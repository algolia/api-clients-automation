package com.algolia.manual;

import static org.junit.jupiter.api.Assertions.*;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.SearchClient;
import com.algolia.config.ClientOptions;
import com.algolia.config.RequestOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Regression test for the `HeaderInterceptor` fix shipped with API-517: `ClientOptions` default
 * headers used to be applied only when the request already carried the header (overwriting it) and
 * were never added otherwise. Default headers must be sent when the request doesn't set them, lose
 * to per-request headers, and never shadow the client credentials.
 */
class DefaultHeadersTest {

  private static ClientOptions.Builder optionsWith(EchoInterceptor echo) {
    return ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(echo));
  }

  @Test
  @DisplayName("default headers are sent, and a default Request-ID suppresses minting")
  void defaultHeadersAreSent() throws Exception {
    EchoInterceptor echo = new EchoInterceptor();
    ClientOptions options = optionsWith(echo)
      .addDefaultHeader("x-custom-header", "CustomValue")
      .addDefaultHeader("request-id", "DefaultHeaderId")
      .build();

    try (SearchClient client = new SearchClient("app-id", "api-key", options)) {
      client.customGet("1/test");

      EchoResponse request = echo.getLastResponse();
      assertEquals("CustomValue", request.headers.get("x-custom-header"), "default headers must be sent when the request doesn't set them");
      assertEquals(
        "DefaultHeaderId",
        request.headers.get("request-id"),
        "a default-header Request-ID must be honored instead of minting one"
      );
    }
  }

  @Test
  @DisplayName("a per-request header wins over the same default header")
  void perRequestHeaderWinsOverDefault() throws Exception {
    EchoInterceptor echo = new EchoInterceptor();
    ClientOptions options = optionsWith(echo).addDefaultHeader("request-id", "DefaultHeaderId").build();

    try (SearchClient client = new SearchClient("app-id", "api-key", options)) {
      client.customGet("1/test", new RequestOptions().addExtraHeader("request-id", "PerRequestId"));

      assertEquals("PerRequestId", echo.getLastResponse().headers.get("request-id"), "a per-request header must win over the default");
    }
  }

  @Test
  @DisplayName("default headers never shadow the client credentials")
  void clientCredentialsWinOverDefaultHeaders() throws Exception {
    EchoInterceptor echo = new EchoInterceptor();
    ClientOptions options = optionsWith(echo).addDefaultHeader("x-algolia-api-key", "default-header-key").build();

    try (SearchClient client = new SearchClient("app-id", "api-key", options)) {
      client.customGet("1/test");
      assertEquals(
        "api-key",
        echo.getLastResponse().headers.get("x-algolia-api-key"),
        "the client credentials must win over a default header"
      );

      client.setClientApiKey("rotated-key");
      client.customGet("1/test");
      assertEquals(
        "rotated-key",
        echo.getLastResponse().headers.get("x-algolia-api-key"),
        "setClientApiKey must keep working when a default api key header is set"
      );
    }
  }
}
