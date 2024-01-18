package com.algolia.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.IngestionClient;
import com.algolia.config.*;
import com.algolia.model.ingestion.*;
import java.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IngestionClientClientTests {

  private EchoInterceptor echo = new EchoInterceptor();

  IngestionClient createClient() {
    return new IngestionClient("appId", "apiKey", "us", buildClientOptions());
  }

  private ClientOptions buildClientOptions() {
    return ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(echo)).build();
  }

  @Test
  @DisplayName("calls api with correct user agent")
  void commonApiTest0() {
    IngestionClient client = createClient();

    client.customPost("/test");
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
  @DisplayName("calls api with default read timeouts")
  void commonApiTest1() {
    IngestionClient client = createClient();

    client.customGet("/test");
    EchoResponse result = echo.getLastResponse();

    assertEquals(2000, result.connectTimeout);
    assertEquals(5000, result.responseTimeout);
  }

  @Test
  @DisplayName("calls api with default write timeouts")
  void commonApiTest2() {
    IngestionClient client = createClient();

    client.customPost("/test");
    EchoResponse result = echo.getLastResponse();

    assertEquals(2000, result.connectTimeout);
    assertEquals(30000, result.responseTimeout);
  }

  @Test
  @DisplayName("uses the correct region")
  void parametersTest0() {
    IngestionClient client = new IngestionClient("my-app-id", "my-api-key", "us", buildClientOptions());
    client.getSource("6c02aeb1-775e-418e-870b-1faccd4b2c0f");
    EchoResponse result = echo.getLastResponse();

    assertEquals("data.us.algolia.com", result.host);
  }

  @Test
  @DisplayName("throws when incorrect region is given")
  void parametersTest1() {
    {
      Exception exception = assertThrows(
        Exception.class,
        () -> {
          IngestionClient client = new IngestionClient("my-app-id", "my-api-key", "not_a_region", buildClientOptions());
        }
      );
      assertEquals("`region` is required and must be one of the following: eu, us", exception.getMessage());
    }
  }
}
