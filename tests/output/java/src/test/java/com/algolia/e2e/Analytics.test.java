package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.algolia.api.AnalyticsClient;
import com.algolia.config.*;
import com.algolia.model.analytics.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AnalyticsClientRequestsTestsE2E {

  private AnalyticsClient client;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    if ("true".equals(System.getenv("CI"))) {
      this.client = new AnalyticsClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"), "us");
    } else {
      var dotenv = Dotenv.configure().directory("../../").load();
      this.client = new AnalyticsClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"), "us");
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("e2e with complex query params")
  void getTopSearchesTest2() {
    var res = client.getTopSearches("cts_e2e_space in index");
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"searches\":[{\"search\":\"\",\"nbHits\":0}]}", json.writeValueAsString(res), JSONCompareMode.LENIENT)
    );
  }
}
