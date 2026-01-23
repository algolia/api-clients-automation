package com.algolia.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.IngestionClient;
import com.algolia.config.*;
import com.algolia.model.ingestion.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.time.Duration;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IngestionClientClientTests {

  private EchoInterceptor echo = new EchoInterceptor();
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .serializationInclusion(JsonInclude.Include.NON_NULL)
      .build();
  }

  IngestionClient createClient() {
    return new IngestionClient("appId", "apiKey", "us", withEchoRequester());
  }

  private ClientOptions withEchoRequester() {
    return ClientOptions.builder()
      .setRequesterConfig(requester -> requester.addInterceptor(echo))
      .build();
  }

  private ClientOptions withCustomHosts(List<Host> hosts, boolean gzipEncoding) {
    return ClientOptions.builder().setHosts(hosts).setCompressionType(gzipEncoding ? CompressionType.GZIP : CompressionType.NONE).build();
  }

  @Test
  @DisplayName("can handle HTML error")
  void apiTest0() {
    IngestionClient client = new IngestionClient(
      "test-app-id",
      "test-api-key",
      "us",
      withCustomHosts(
        Arrays.asList(
          new Host(
            "true".equals(System.getenv("CI")) ? "localhost" : "host.docker.internal",
            EnumSet.of(CallType.READ, CallType.WRITE),
            "http",
            6676
          )
        ),
        false
      )
    );

    {
      Exception exception = assertThrows(Exception.class, () -> {
        Object res = client.customGet("1/html-error");
      });
      assertEquals("Status Code: 429 - Too Many Requests", exception.getMessage());
    }
  }

  @Test
  @DisplayName("calls api with default read timeouts")
  void apiTest1() {
    IngestionClient client = createClient();

    client.customGet("1/test");
    EchoResponse result = echo.getLastResponse();
    assertEquals(25000, result.connectTimeout);
    assertEquals(25000, result.responseTimeout);
  }

  @Test
  @DisplayName("calls api with default write timeouts")
  void apiTest2() {
    IngestionClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    assertEquals(25000, result.connectTimeout);
    assertEquals(25000, result.responseTimeout);
  }

  @Test
  @DisplayName("can leave call opened for a long time")
  void apiTest3() {
    IngestionClient client = new IngestionClient(
      "test-app-id",
      "test-api-key",
      "us",
      withCustomHosts(
        Arrays.asList(
          new Host(
            "true".equals(System.getenv("CI")) ? "localhost" : "host.docker.internal",
            EnumSet.of(CallType.READ, CallType.WRITE),
            "http",
            6676
          )
        ),
        false
      )
    );

    Object res = client.customGet("1/long-wait");

    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"message\":\"OK\"}", json.writeValueAsString(res), JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("endpoint level timeout")
  void apiTest4() {
    IngestionClient client = createClient();

    client.validateSourceBeforeUpdate("6c02aeb1-775e-418e-870b-1faccd4b2c0f", new SourceUpdate().setName("newName"));
    EchoResponse result = echo.getLastResponse();
    assertEquals(180000, result.connectTimeout);
    assertEquals(180000, result.responseTimeout);
  }

  @Test
  @DisplayName("can override endpoint level timeout")
  void apiTest5() {
    IngestionClient client = createClient();

    client.validateSourceBeforeUpdate(
      "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
      new SourceUpdate().setName("newName"),
      new RequestOptions().setWriteTimeout(Duration.ofMillis(3456L))
    );
    EchoResponse result = echo.getLastResponse();
    assertEquals(180000, result.connectTimeout);
    assertEquals(3456, result.responseTimeout);
  }

  @Test
  @DisplayName("calls api with correct user agent")
  void commonApiTest0() {
    IngestionClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    {
      String regexp =
        "^Algolia for Java \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+" +
        " (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Ingestion" +
        " (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+" +
        " (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$";
      assertTrue(
        result.headers.get("user-agent").matches(regexp),
        "Expected " + result.headers.get("user-agent") + " to match the following regex: " + regexp
      );
    }
  }

  @Test
  @DisplayName("the user agent contains the latest version")
  void commonApiTest1() {
    IngestionClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    {
      String regexp = "^Algolia for Java \\(4.34.4\\).*";
      assertTrue(
        result.headers.get("user-agent").matches(regexp),
        "Expected " + result.headers.get("user-agent") + " to match the following regex: " + regexp
      );
    }
  }

  @Test
  @DisplayName("uses the correct region")
  void parametersTest0() {
    IngestionClient client = new IngestionClient("my-app-id", "my-api-key", "us", withEchoRequester());

    client.getSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    EchoResponse result = echo.getLastResponse();
    assertEquals("data.us.algolia.com", result.host);
  }

  @Test
  @DisplayName("throws when incorrect region is given")
  void parametersTest1() {
    {
      Exception exception = assertThrows(Exception.class, () -> {
        IngestionClient client = new IngestionClient("my-app-id", "my-api-key", "not_a_region", withEchoRequester());
      });
      assertEquals("`region` is required and must be one of the following: eu, us", exception.getMessage());
    }
  }

  @Test
  @DisplayName("switch API key")
  void setClientApiKeyTest0() {
    IngestionClient client = new IngestionClient(
      "test-app-id",
      "test-api-key",
      "us",
      withCustomHosts(
        Arrays.asList(
          new Host(
            "true".equals(System.getenv("CI")) ? "localhost" : "host.docker.internal",
            EnumSet.of(CallType.READ, CallType.WRITE),
            "http",
            6683
          )
        ),
        false
      )
    );

    assertDoesNotThrow(() -> {
      Object res = client.customGet("check-api-key/1");

      assertDoesNotThrow(() ->
        JSONAssert.assertEquals("{\"headerAPIKeyValue\":\"test-api-key\"}", json.writeValueAsString(res), JSONCompareMode.STRICT)
      );
    });
    assertDoesNotThrow(() -> {
      client.setClientApiKey("updated-api-key");
    });
    assertDoesNotThrow(() -> {
      Object res = client.customGet("check-api-key/2");

      assertDoesNotThrow(() ->
        JSONAssert.assertEquals("{\"headerAPIKeyValue\":\"updated-api-key\"}", json.writeValueAsString(res), JSONCompareMode.STRICT)
      );
    });
  }
}
