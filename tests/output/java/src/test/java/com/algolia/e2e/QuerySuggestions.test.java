package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.algolia.api.QuerySuggestionsClient;
import com.algolia.config.*;
import com.algolia.model.querysuggestions.*;
import com.algolia.utils.TestHelpers;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuerySuggestionsClientRequestsTestsE2E {

  private QuerySuggestionsClient client;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    if ("true".equals(System.getenv("CI"))) {
      this.client = new QuerySuggestionsClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"), "us");
    } else {
      Dotenv dotenv = Dotenv.configure().directory("../../").load();
      this.client = new QuerySuggestionsClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"), "us");
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("Retrieve QS config e2e")
  void getConfigTest() {
    ConfigurationResponse res = client.getConfig("cts_e2e_browse_query_suggestions");
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"appID\":\"T8JK9S7I7X\",\"allowSpecialCharacters\":true,\"enablePersonalization\":false,\"exclude\":[\"^cocaines$\"],\"indexName\":\"cts_e2e_browse_query_suggestions\",\"languages\":[],\"sourceIndices\":[{\"facets\":[{\"amount\":1,\"attribute\":\"title\"}],\"generate\":[[\"year\"]],\"indexName\":\"cts_e2e_browse\",\"minHits\":5,\"minLetters\":4,\"replicas\":false}]}",
        json.writeValueAsString(res)
      )
    );
  }
}
