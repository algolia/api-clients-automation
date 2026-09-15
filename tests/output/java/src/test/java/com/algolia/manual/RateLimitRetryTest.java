package com.algolia.manual;

import static org.junit.jupiter.api.Assertions.*;

import com.algolia.api.IngestionClient;
import com.algolia.api.SearchClient;
import com.algolia.config.CallType;
import com.algolia.config.ClientOptions;
import com.algolia.config.Host;
import com.algolia.config.TransformationOptions;
import com.algolia.exceptions.AlgoliaApiException;
import com.algolia.exceptions.AlgoliaRetryException;
import com.algolia.internal.interceptors.RetryStrategy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pins the HTTP 429 wait-and-retry round: how `Retry-After` is parsed, how the
 * `maxRateLimitRetries` budget is spent and shared across hosts, that a rate-limited host is
 * retried in place rather than failed over or marked down, and that a waited-out 429 stays visible
 * in the retry error. The interceptor answers every attempt itself, so no real HTTP is performed.
 */
class RateLimitRetryTest {

  private static final String FIRST_HOST = "host-one.test";
  private static final String SECOND_HOST = "host-two.test";
  private static final String JSON_BODY = "{\"message\":\"Too many requests\"}";
  private static final String HTML_BODY = "<html><body>429 Too Many Requests</body></html>";

  @Test
  @DisplayName("Retry-After is honored only as a positive whole number of seconds")
  void parsesRetryAfter() throws Exception {
    assertEquals(2_000L, rateLimitWaitMillis("2"));
    assertEquals(5_000L, rateLimitWaitMillis(" 5 "));
    assertEquals(86_400_000L, rateLimitWaitMillis("86400"));
    assertEquals((Long.MAX_VALUE / 1000) * 1000, rateLimitWaitMillis(String.valueOf(Long.MAX_VALUE / 1000)));

    assertEquals(1_000L, rateLimitWaitMillis(null));
    assertEquals(1_000L, rateLimitWaitMillis(""));
    assertEquals(1_000L, rateLimitWaitMillis(" "));
    assertEquals(1_000L, rateLimitWaitMillis("0"));
    assertEquals(1_000L, rateLimitWaitMillis("-5"));
    assertEquals(1_000L, rateLimitWaitMillis("1.5"));
    assertEquals(1_000L, rateLimitWaitMillis("120abc"));
    assertEquals(1_000L, rateLimitWaitMillis("Wed, 21 Oct 2015 07:28:00 GMT"));

    assertEquals(Long.MAX_VALUE, rateLimitWaitMillis(String.valueOf(Long.MAX_VALUE / 1000 + 1)));
    assertEquals(Long.MAX_VALUE, rateLimitWaitMillis(String.valueOf(Long.MAX_VALUE)));
    assertEquals(Long.MAX_VALUE, rateLimitWaitMillis("99999999999999999999"));
  }

  @Test
  @DisplayName("waits Retry-After then retries the same host without marking it down")
  void waitsThenRetriesTheSameHost() throws Exception {
    FakeServer server = new FakeServer(rateLimited("2"), ok());

    try (SearchClient client = searchClient(server, ClientOptions.builder())) {
      long start = System.nanoTime();
      client.customGet("1/test");
      long elapsedMillis = (System.nanoTime() - start) / 1_000_000;

      assertTrue(elapsedMillis >= 1_950, "expected to wait Retry-After (2s), waited " + elapsedMillis + "ms");
      assertEquals(Arrays.asList(FIRST_HOST, FIRST_HOST), server.hosts);

      client.customGet("1/test");
      assertEquals(Arrays.asList(FIRST_HOST, FIRST_HOST, FIRST_HOST), server.hosts);
    }
  }

  @Test
  @DisplayName("waits 1s when Retry-After is missing")
  void waitsOneSecondWithoutRetryAfter() throws Exception {
    FakeServer server = new FakeServer(rateLimited(null), ok());

    try (SearchClient client = searchClient(server, ClientOptions.builder())) {
      long start = System.nanoTime();
      client.customGet("1/test");
      long elapsedMillis = (System.nanoTime() - start) / 1_000_000;

      assertTrue(elapsedMillis >= 950, "expected to wait 1s, waited " + elapsedMillis + "ms");
      assertEquals(Arrays.asList(FIRST_HOST, FIRST_HOST), server.hosts);
    }
  }

  @Test
  @DisplayName("surfaces the 429 once maxRateLimitRetries is used up, without failing over")
  void surfacesThe429OnceRetriesAreUsedUp() throws Exception {
    FakeServer server = new FakeServer(rateLimited("1"));

    try (SearchClient client = searchClient(server, ClientOptions.builder())) {
      AlgoliaApiException exception = assertThrows(AlgoliaApiException.class, () -> client.customGet("1/test"));

      assertEquals(429, exception.getStatusCode());
      assertEquals("Status Code: 429 - {\"message\":\"Too many requests\"}", exception.getMessage());
      assertEquals(Arrays.asList(FIRST_HOST, FIRST_HOST, FIRST_HOST, FIRST_HOST), server.hosts);
    }
  }

  @Test
  @DisplayName("the maxRateLimitRetries budget is shared across hosts")
  void sharesTheBudgetAcrossHosts() throws Exception {
    FakeServer server = new FakeServer(rateLimited("1"), serverError(), rateLimited("1"), rateLimited("1"), rateLimited("1"), ok());

    try (SearchClient client = searchClient(server, ClientOptions.builder())) {
      AlgoliaApiException exception = assertThrows(AlgoliaApiException.class, () -> client.customGet("1/test"));

      assertEquals(429, exception.getStatusCode());
      assertEquals(Arrays.asList(FIRST_HOST, FIRST_HOST, SECOND_HOST, SECOND_HOST, SECOND_HOST), server.hosts);
    }
  }

  @Test
  @DisplayName("a waited-out 429 stays visible when every host then fails")
  void keepsTheWaitedOut429WhenEveryHostFails() throws Exception {
    FakeServer server = new FakeServer(rateLimited("1", "RateLimitCid"), serverError());

    try (SearchClient client = searchClient(server, ClientOptions.builder())) {
      AlgoliaRetryException exception = assertThrows(AlgoliaRetryException.class, () -> client.customGet("1/test"));

      assertEquals(Arrays.asList(FIRST_HOST, FIRST_HOST, SECOND_HOST), server.hosts);
      assertEquals("RateLimitCid", exception.getCorrelationId());
      AlgoliaApiException rateLimited = (AlgoliaApiException) exception.getErrors().get(0);
      assertEquals(429, rateLimited.getStatusCode());
      assertEquals("RateLimitCid", rateLimited.getCorrelationId());
    }
  }

  @Test
  @DisplayName("an HTML 429 still surfaces once maxRateLimitRetries is used up")
  void surfacesAnHtml429OnceRetriesAreUsedUp() throws Exception {
    FakeServer server = new FakeServer(rateLimitedHtml());

    try (SearchClient client = searchClient(server, ClientOptions.builder().setMaxRateLimitRetries(1))) {
      AlgoliaApiException exception = assertThrows(AlgoliaApiException.class, () -> client.customGet("1/test"));

      assertEquals(429, exception.getStatusCode());
      assertEquals("Status Code: 429 - Too Many Requests", exception.getMessage());
      assertEquals(Arrays.asList(FIRST_HOST, FIRST_HOST), server.hosts);
    }
  }

  @Test
  @DisplayName("fails on the first 429 without waiting when maxRateLimitRetries is 0")
  void failsOnTheFirst429WhenRetriesAreDisabled() throws Exception {
    FakeServer server = new FakeServer(rateLimited("30"));

    try (SearchClient client = searchClient(server, ClientOptions.builder().setMaxRateLimitRetries(0))) {
      long start = System.nanoTime();
      AlgoliaApiException exception = assertThrows(AlgoliaApiException.class, () -> client.customGet("1/test"));
      long elapsedMillis = (System.nanoTime() - start) / 1_000_000;

      assertEquals(429, exception.getStatusCode());
      assertTrue(elapsedMillis < 1_000, "expected no wait, waited " + elapsedMillis + "ms");
      assertEquals(Arrays.asList(FIRST_HOST), server.hosts);
    }
  }

  @Test
  @DisplayName("maxRateLimitRetries defaults to 3")
  void defaultsToThreeRetries() {
    assertEquals(3, new ClientOptions().getMaxRateLimitRetries());
    assertEquals(3, ClientOptions.builder().build().getMaxRateLimitRetries());
    assertEquals(0, ClientOptions.builder().setMaxRateLimitRetries(0).build().getMaxRateLimitRetries());
  }

  @Test
  @DisplayName("TransformationOptions forward maxRateLimitRetries to the ingestion transporter")
  void forwardsMaxRateLimitRetriesToTheIngestionTransporter() throws Exception {
    try (SearchClient client = SearchClient.withTransformation("app-id", "api-key", new TransformationOptions("us"))) {
      assertEquals(3, ingestionTransporter(client).clientOptions.getMaxRateLimitRetries());
    }

    ClientOptions ingestionOptions = ClientOptions.builder().setMaxRateLimitRetries(0).build();
    TransformationOptions transformationOptions = new TransformationOptions("us", ingestionOptions);
    try (SearchClient client = SearchClient.withTransformation("app-id", "api-key", transformationOptions)) {
      assertEquals(0, ingestionTransporter(client).clientOptions.getMaxRateLimitRetries());
    }
  }

  private static long rateLimitWaitMillis(String retryAfter) throws Exception {
    Method method = RetryStrategy.class.getDeclaredMethod("rateLimitWaitMillis", String.class);
    method.setAccessible(true);
    return (long) method.invoke(null, retryAfter);
  }

  private static SearchClient searchClient(FakeServer server, ClientOptions.Builder options) {
    List<Host> hosts = Arrays.asList(
      new Host(FIRST_HOST, EnumSet.of(CallType.READ, CallType.WRITE)),
      new Host(SECOND_HOST, EnumSet.of(CallType.READ, CallType.WRITE))
    );
    return new SearchClient(
      "app-id",
      "api-key",
      options
        .setHosts(hosts)
        .setRequesterConfig(requester -> requester.addInterceptor(server))
        .build()
    );
  }

  private static IngestionClient ingestionTransporter(SearchClient client) throws Exception {
    Field field = SearchClient.class.getDeclaredField("ingestionTransporter");
    field.setAccessible(true);
    return (IngestionClient) field.get(client);
  }

  private static Reply rateLimited(String retryAfter) {
    return rateLimited(retryAfter, null);
  }

  private static Reply rateLimited(String retryAfter, String correlationId) {
    return new Reply(429, "Too Many Requests", "application/json", JSON_BODY, retryAfter, correlationId);
  }

  private static Reply rateLimitedHtml() {
    return new Reply(429, "Too Many Requests", "text/html", HTML_BODY, null, null);
  }

  private static Reply serverError() {
    return new Reply(500, "Server Error", "application/json", "{\"message\":\"server error\"}", null, null);
  }

  private static Reply ok() {
    return new Reply(200, "OK", "application/json", "{\"message\":\"ok rate limit retry\"}", null, null);
  }

  private static final class Reply {

    final int code;
    final String message;
    final String contentType;
    final String body;
    final String retryAfter;
    final String correlationId;

    Reply(int code, String message, String contentType, String body, String retryAfter, String correlationId) {
      this.code = code;
      this.message = message;
      this.contentType = contentType;
      this.body = body;
      this.retryAfter = retryAfter;
      this.correlationId = correlationId;
    }
  }

  /** Answers each attempt from the scripted replies, repeating the last one, and records the host it was sent to. */
  private static final class FakeServer implements Interceptor {

    final List<String> hosts = new ArrayList<>();
    private final List<Reply> replies;

    FakeServer(Reply... replies) {
      this.replies = Arrays.asList(replies);
    }

    @Override
    public Response intercept(Chain chain) {
      Request request = chain.request();
      hosts.add(request.url().host());
      Reply reply = replies.get(Math.min(hosts.size(), replies.size()) - 1);
      Response.Builder response = new Response.Builder()
        .request(request)
        .protocol(Protocol.HTTP_2)
        .code(reply.code)
        .message(reply.message)
        .header("Content-Type", reply.contentType)
        .body(ResponseBody.create(reply.body, MediaType.parse(reply.contentType)));
      if (reply.retryAfter != null) {
        response.header("Retry-After", reply.retryAfter);
      }
      if (reply.correlationId != null) {
        response.header("Correlation-ID", reply.correlationId);
      }
      return response.build();
    }
  }
}
