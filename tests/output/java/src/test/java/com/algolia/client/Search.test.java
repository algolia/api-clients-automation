package com.algolia.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
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
class SearchClientClientTests {

  private EchoInterceptor echo = new EchoInterceptor();
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
  }

  SearchClient createClient() {
    return new SearchClient("appId", "apiKey", withEchoRequester());
  }

  private ClientOptions withEchoRequester() {
    return ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(echo)).build();
  }

  private ClientOptions withCustomHosts(List<Host> hosts, boolean gzipEncoding) {
    return ClientOptions.builder().setHosts(hosts).setCompressionType(gzipEncoding ? CompressionType.GZIP : CompressionType.NONE).build();
  }

  @Test
  @DisplayName("calls api with correct read host")
  void apiTest0() {
    SearchClient client = new SearchClient("test-app-id", "test-api-key", withEchoRequester());
    client.customGet("/test");
    EchoResponse result = echo.getLastResponse();

    assertEquals("test-app-id-dsn.algolia.net", result.host);
  }

  @Test
  @DisplayName("calls api with correct write host")
  void apiTest1() {
    SearchClient client = new SearchClient("test-app-id", "test-api-key", withEchoRequester());
    client.customPost("/test");
    EchoResponse result = echo.getLastResponse();

    assertEquals("test-app-id.algolia.net", result.host);
  }

  @Test
  @DisplayName("tests the retry strategy")
  void apiTest2() {
    SearchClient client = new SearchClient(
      "test-app-id",
      "test-api-key",
      withCustomHosts(
        Arrays.asList(
          new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6677),
          new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6678)
        ),
        false
      )
    );
    var res = client.customGet("/test/retry");

    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"message\":\"ok test server response\"}", json.writeValueAsString(res), JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("test the compression strategy")
  void apiTest3() {
    SearchClient client = new SearchClient(
      "test-app-id",
      "test-api-key",
      withCustomHosts(Arrays.asList(new Host("localhost", EnumSet.of(CallType.READ, CallType.WRITE), "http", 6678)), true)
    );
    var res = client.customPost("/test/gzip", Map.of(), Map.of("message", "this is a compressed body"));

    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"message\":\"ok compression test server response\",\"body\":{\"message\":\"this" + " is a compressed body\"}}",
        json.writeValueAsString(res),
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("calls api with correct user agent")
  void commonApiTest0() {
    SearchClient client = createClient();

    client.customPost("/test");
    EchoResponse result = echo.getLastResponse();
    {
      String regexp =
        "^Algolia for Java \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+" +
        " (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; Search" +
        " (\\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)))(; [a-zA-Z. ]+" +
        " (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*$";
      assertTrue(
        result.headers.get("user-agent").matches(regexp),
        "Expected " + result.headers.get("user-agent") + " to match the following regex: " + regexp
      );
    }
  }

  @Test
  @DisplayName("calls api with default read timeouts")
  void commonApiTest1() {
    SearchClient client = createClient();

    client.customGet("/test");
    EchoResponse result = echo.getLastResponse();

    assertEquals(2000, result.connectTimeout);
    assertEquals(5000, result.responseTimeout);
  }

  @Test
  @DisplayName("calls api with default write timeouts")
  void commonApiTest2() {
    SearchClient client = createClient();

    client.customPost("/test");
    EchoResponse result = echo.getLastResponse();

    assertEquals(2000, result.connectTimeout);
    assertEquals(30000, result.responseTimeout);
  }

  @Test
  @DisplayName("client throws with invalid parameters")
  void parametersTest0() {
    {
      Exception exception = assertThrows(
        Exception.class,
        () -> {
          SearchClient client = new SearchClient("", "", withEchoRequester());
        }
      );
      assertEquals("`appId` is missing.", exception.getMessage());
    }
    {
      Exception exception = assertThrows(
        Exception.class,
        () -> {
          SearchClient client = new SearchClient("", "my-api-key", withEchoRequester());
        }
      );
      assertEquals("`appId` is missing.", exception.getMessage());
    }
    {
      Exception exception = assertThrows(
        Exception.class,
        () -> {
          SearchClient client = new SearchClient("my-app-id", "", withEchoRequester());
        }
      );
      assertEquals("`apiKey` is missing.", exception.getMessage());
    }
  }

  @Test
  @DisplayName("`addApiKey` throws with invalid parameters")
  void parametersTest1() {
    SearchClient client = createClient();

    {
      Exception exception = assertThrows(
        Exception.class,
        () -> {
          client.addApiKey(null);
          EchoResponse result = echo.getLastResponse();
        }
      );
      assertEquals("Parameter `apiKey` is required when calling `addApiKey`.", exception.getMessage());
    }
  }

  @Test
  @DisplayName("`addOrUpdateObject` throws with invalid parameters")
  void parametersTest2() {
    SearchClient client = createClient();

    {
      Exception exception = assertThrows(
        Exception.class,
        () -> {
          client.addOrUpdateObject(null, "my-object-id", Map.of());
          EchoResponse result = echo.getLastResponse();
        }
      );
      assertEquals("Parameter `indexName` is required when calling `addOrUpdateObject`.", exception.getMessage());
    }
    {
      Exception exception = assertThrows(
        Exception.class,
        () -> {
          client.addOrUpdateObject("my-index-name", null, Map.of());
          EchoResponse result = echo.getLastResponse();
        }
      );
      assertEquals("Parameter `objectID` is required when calling `addOrUpdateObject`.", exception.getMessage());
    }
    {
      Exception exception = assertThrows(
        Exception.class,
        () -> {
          client.addOrUpdateObject("my-index-name", "my-object-id", null);
          EchoResponse result = echo.getLastResponse();
        }
      );
      assertEquals("Parameter `body` is required when calling `addOrUpdateObject`.", exception.getMessage());
    }
  }
}
