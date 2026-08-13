package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.algolia.api.CompositionClient;
import com.algolia.config.*;
import com.algolia.model.composition.*;
import com.algolia.utils.TestHelpers;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompositionClientRequestsTestsE2E {

  private CompositionClient client;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    if ("true".equals(System.getenv("CI"))) {
      this.client = new CompositionClient(System.getenv("METIS_APPLICATION_ID"), System.getenv("METIS_API_KEY"));
    } else {
      Dotenv dotenv = Dotenv.configure().directory("../../").load();
      this.client = new CompositionClient(dotenv.get("METIS_APPLICATION_ID"), dotenv.get("METIS_API_KEY"));
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("the Correlation-ID ends with the sent Request-ID")
  void getCompositionTest1() {
    Composition res = client.getComposition("id1", new RequestOptions().addExtraHeader("request-id", "CtsE2eEcho4"));
    assertDoesNotThrow(() -> TestHelpers.lenientJsonAssert("{\"objectID\":\"id1\"}", json.writeValueAsString(res)));
    okhttp3.Response httpResp = client.customGetWithHTTPInfo(
      "/1/compositions/id1".substring(1),
      new RequestOptions().addExtraHeader("request-id", "CtsE2eEcho4")
    );

    assertNotNull(httpResp.header("Correlation-ID"));
    assertTrue(httpResp.header("Correlation-ID").endsWith("CtsE2eEcho4"));
  }

  @Test
  @DisplayName("the Correlation-ID ends with the Request-ID sent as a query parameter")
  void getCompositionTest2() {
    Composition res = client.getComposition("id1", new RequestOptions().addExtraQueryParameters("x-algolia-request-id", "CtsE2eEchoQ"));
    assertDoesNotThrow(() -> TestHelpers.lenientJsonAssert("{\"objectID\":\"id1\"}", json.writeValueAsString(res)));
    okhttp3.Response httpResp = client.customGetWithHTTPInfo(
      "/1/compositions/id1".substring(1),
      new RequestOptions().addExtraQueryParameters("x-algolia-request-id", "CtsE2eEchoQ")
    );

    assertNotNull(httpResp.header("Correlation-ID"));
    assertTrue(httpResp.header("Correlation-ID").endsWith("CtsE2eEchoQ"));
  }

  @Test
  @DisplayName("listCompositions")
  void listCompositionsTest1() {
    ListCompositionsResponse res = client.listCompositions();
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"items\":[{\"objectID\":\"id1\",\"name\":\"my first" +
          " composition\",\"description\":\"the first ever composition from the" +
          " client\",\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"cts_e2e_small\"}}}}}}],\"nbPages\":1}",
        json.writeValueAsString(res)
      )
    );
  }
}
