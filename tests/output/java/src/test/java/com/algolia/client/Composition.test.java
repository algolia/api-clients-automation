package com.algolia.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.CompositionClient;
import com.algolia.config.*;
import com.algolia.model.composition.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompositionClientClientTests {

  private EchoInterceptor echo = new EchoInterceptor();
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      .serializationInclusion(JsonInclude.Include.NON_NULL)
      .build();
  }

  CompositionClient createClient() {
    return new CompositionClient("appId", "apiKey", withEchoRequester());
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
  @DisplayName("calls api with correct read host")
  void apiTest0() {
    CompositionClient client = new CompositionClient("test-app-id", "test-api-key", withEchoRequester());

    client.search("test-composition-id", new RequestBody(), Hit.class);

    EchoResponse result = echo.getLastResponse();
    assertEquals("test-app-id-dsn.algolia.net", result.host);
  }

  @Test
  @DisplayName("calls api with correct write host")
  void apiTest1() {
    CompositionClient client = new CompositionClient("test-app-id", "test-api-key", withEchoRequester());

    client.search("test-composition-id", new RequestBody(), Hit.class);

    EchoResponse result = echo.getLastResponse();
    assertEquals("test-app-id-dsn.algolia.net", result.host);
  }
}
