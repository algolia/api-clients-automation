package com.algolia.manual;

import static org.junit.jupiter.api.Assertions.*;

import com.algolia.api.SearchClient;
import com.algolia.config.ClientOptions;
import com.algolia.exceptions.AlgoliaRetryException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pins {@link AlgoliaRetryException#getCorrelationId()}: once every host is exhausted, it returns
 * the `Correlation-ID` of the last attempt whose response carried one, and null when none did. The
 * interceptor answers every attempt with a retryable 500, so no real HTTP is performed.
 */
class RetryCorrelationIdTest {

  private static Interceptor failingWith(AtomicInteger attempts, boolean withCorrelationId) {
    return chain -> {
      int attempt = attempts.incrementAndGet();
      Response.Builder response = new Response.Builder()
        .request(chain.request())
        .protocol(Protocol.HTTP_2)
        .code(500)
        .message("Server Error")
        .body(ResponseBody.create("{\"message\":\"retry test\"}", MediaType.parse("application/json")));
      if (withCorrelationId) {
        response.header("Correlation-ID", "RetryCid" + attempt);
      }
      return response.build();
    };
  }

  @Test
  @DisplayName("getCorrelationId returns the last attempt's Correlation-ID after retry exhaustion")
  void returnsTheLastAttemptsCorrelationId() throws Exception {
    AtomicInteger attempts = new AtomicInteger();
    ClientOptions options = ClientOptions.builder()
      .setRequesterConfig(requester -> requester.addInterceptor(failingWith(attempts, true)))
      .build();

    try (SearchClient client = new SearchClient("app-id", "api-key", options)) {
      AlgoliaRetryException exception = assertThrows(AlgoliaRetryException.class, () -> client.customGet("1/test"));

      assertTrue(attempts.get() > 1, "the retry strategy must have tried more than one host");
      assertEquals(
        "RetryCid" + attempts.get(),
        exception.getCorrelationId(),
        "getCorrelationId must return the last attempt's Correlation-ID"
      );
    }
  }

  @Test
  @DisplayName("getCorrelationId returns null when no response carried a Correlation-ID")
  void returnsNullWithoutCorrelationIds() throws Exception {
    AtomicInteger attempts = new AtomicInteger();
    ClientOptions options = ClientOptions.builder()
      .setRequesterConfig(requester -> requester.addInterceptor(failingWith(attempts, false)))
      .build();

    try (SearchClient client = new SearchClient("app-id", "api-key", options)) {
      AlgoliaRetryException exception = assertThrows(AlgoliaRetryException.class, () -> client.customGet("1/test"));

      assertTrue(attempts.get() > 1, "the retry strategy must have tried more than one host");
      assertNull(exception.getCorrelationId(), "getCorrelationId must return null when no response carried one");
    }
  }
}
