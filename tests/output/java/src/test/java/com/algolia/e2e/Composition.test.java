package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.algolia.api.CompositionClient;
import com.algolia.config.*;
import com.algolia.model.composition.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

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
  @DisplayName("listCompositions")
  void listCompositionsTest1() {
    ListCompositionsResponse res = client.listCompositions();
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"items\":[{\"objectID\":\"id1\",\"name\":\"my first" +
          " composition\",\"description\":\"the first ever composition from the" +
          " client\",\"behavior\":{\"injection\":{\"main\":{\"source\":{\"search\":{\"index\":\"cts_e2e_small\"}}}}}}],\"nbPages\":1}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }
}
