package com.algolia.client;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.AgentStudioClient;
import com.algolia.config.*;
import com.algolia.model.agentstudio.*;
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
class AgentStudioClientClientTests {

  private EchoInterceptor echo = new EchoInterceptor();
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .serializationInclusion(JsonInclude.Include.NON_NULL)
      .build();
  }

  AgentStudioClient createClient() {
    return new AgentStudioClient("appId", "apiKey", withEchoRequester());
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
  @DisplayName("calls api with default read timeouts")
  void apiTest0() {
    AgentStudioClient client = createClient();

    client.listAgents();
    EchoResponse result = echo.getLastResponse();
    assertEquals(25000, result.connectTimeout);
    assertEquals(25000, result.responseTimeout);
  }

  @Test
  @DisplayName("calls api with default write timeouts")
  void apiTest1() {
    AgentStudioClient client = createClient();

    client.createAgent(new AgentConfigCreate().setName("test-agent").setInstructions("test instructions"));
    EchoResponse result = echo.getLastResponse();
    assertEquals(25000, result.connectTimeout);
    assertEquals(25000, result.responseTimeout);
  }

  @Test
  @DisplayName("calls api with correct user agent")
  void commonApiTest0() {
    AgentStudioClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    {
      String regexp =
        "^Algolia for Java \\(\\d+\\.\\d+\\.\\d+(-?.*)?\\)(; [a-zA-Z. ]+" +
        " (\\(\\d+((\\.\\d+)?\\.\\d+)?(-?.*)?\\))?)*(; AgentStudio" +
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
    AgentStudioClient client = createClient();

    client.customPost("1/test");
    EchoResponse result = echo.getLastResponse();
    {
      String regexp = "^Algolia for Java \\(4.38.1\\).*";
      assertTrue(
        result.headers.get("user-agent").matches(regexp),
        "Expected " + result.headers.get("user-agent") + " to match the following regex: " + regexp
      );
    }
  }

  @Test
  @DisplayName("handles 204 No Content responses correctly")
  void noContentTest0() {
    AgentStudioClient client = new AgentStudioClient(
      "test-app-id",
      "test-api-key",
      withCustomHosts(
        Arrays.asList(
          new Host(
            "true".equals(System.getenv("CI")) ? "localhost" : "host.docker.internal",
            EnumSet.of(CallType.READ, CallType.WRITE),
            "http",
            6692
          )
        ),
        false
      )
    );

    Object res = client.customDelete("1/test/no-content");

    assertEquals(null, res);
  }

  @Test
  @DisplayName("uses the correct host")
  void parametersTest0() {
    AgentStudioClient client = new AgentStudioClient("my-app-id", "my-api-key", withEchoRequester());

    client.customGet("test");
    EchoResponse result = echo.getLastResponse();
    assertEquals("my-app-id-dsn.algolia.net", result.host);
  }

  @Test
  @DisplayName("switch API key")
  void setClientApiKeyTest0() {
    AgentStudioClient client = new AgentStudioClient(
      "test-app-id",
      "test-api-key",
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
