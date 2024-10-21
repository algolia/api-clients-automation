package com.algolia.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.AnalyticsClient;
import com.algolia.config.*;
import com.algolia.model.analytics.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AnalyticsClientClientTests {

  private EchoInterceptor echo = new EchoInterceptor();
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .serializationInclusion(JsonInclude.Include.NON_NULL)
      .build();
  }

  AnalyticsClient createClient() {
    return new AnalyticsClient("appId", "apiKey", "us", withEchoRequester());
  }

  private ClientOptions withEchoRequester() {
    return ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(echo)).build();
  }

  private ClientOptions withCustomHosts(List<Host> hosts, boolean gzipEncoding) {
    return ClientOptions.builder().setHosts(hosts).setCompressionType(gzipEncoding ? CompressionType.GZIP : CompressionType.NONE).build();
  }

  @Test
  @DisplayName("calls api with correct user agent")
  void commonApiTest0() {
    AnalyticsClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    {
      String regexp =
        "^Algolia for Java \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+" +
        " (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Analytics" +
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
    AnalyticsClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    {
      String regexp = "^Algolia for Java \\(4.5.2\\).*";
      assertTrue(
        result.headers.get("user-agent").matches(regexp),
        "Expected " + result.headers.get("user-agent") + " to match the following regex: " + regexp
      );
    }
  }

  @Test
  @DisplayName("calls api with default read timeouts")
  void commonApiTest2() {
    AnalyticsClient client = createClient();

    client.customGet("1/test");
    EchoResponse result = echo.getLastResponse();
    assertEquals(2000, result.connectTimeout);
    assertEquals(5000, result.responseTimeout);
  }

  @Test
  @DisplayName("calls api with default write timeouts")
  void commonApiTest3() {
    AnalyticsClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    assertEquals(2000, result.connectTimeout);
    assertEquals(30000, result.responseTimeout);
  }

  @Test
  @DisplayName("fallbacks to the alias when region is not given")
  void parametersTest0() {
    AnalyticsClient client = new AnalyticsClient("my-app-id", "my-api-key", withEchoRequester());
    client.getAverageClickPosition("my-index");
    EchoResponse result = echo.getLastResponse();
    assertEquals("analytics.algolia.com", result.host);
  }

  @Test
  @DisplayName("uses the correct region")
  void parametersTest1() {
    AnalyticsClient client = new AnalyticsClient("my-app-id", "my-api-key", "de", withEchoRequester());
    client.customPost("test");
    EchoResponse result = echo.getLastResponse();
    assertEquals("analytics.de.algolia.com", result.host);
  }

  @Test
  @DisplayName("throws when incorrect region is given")
  void parametersTest2() {
    {
      Exception exception = assertThrows(Exception.class, () -> {
        AnalyticsClient client = new AnalyticsClient("my-app-id", "my-api-key", "not_a_region", withEchoRequester());
      });
      assertEquals("`region` must be one of the following: de, us", exception.getMessage());
    }
  }

  @Test
  @DisplayName("getAverageClickPosition throws without index")
  void parametersTest3() {
    AnalyticsClient client = createClient();

    {
      Exception exception = assertThrows(Exception.class, () -> {
        client.getClickPositions(null);
        EchoResponse result = echo.getLastResponse();
      });
      assertEquals("Parameter `index` is required when calling `getClickPositions`.", exception.getMessage());
    }
  }

  @Test
  @DisplayName("switch API key")
  void setClientApiKeyTest0() {
    AnalyticsClient client = new AnalyticsClient(
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
