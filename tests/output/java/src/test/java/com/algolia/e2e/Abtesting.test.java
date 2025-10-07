package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.algolia.api.AbtestingClient;
import com.algolia.config.*;
import com.algolia.model.abtesting.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AbtestingClientRequestsTestsE2E {

  private AbtestingClient client;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    if ("true".equals(System.getenv("CI"))) {
      this.client = new AbtestingClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"), "us");
    } else {
      Dotenv dotenv = Dotenv.configure().directory("../../").load();
      this.client = new AbtestingClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"), "us");
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("listABTests with parameters")
  void listABTestsTest1() {
    ListABTestsResponse res = client.listABTests(0, 21, "cts_e2e ab", "t");
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"abtests\":[{\"abTestID\":85635,\"createdAt\":\"2024-05-13T10:12:27.739233Z\",\"endAt\":\"2124-05-13T00:00:00Z\",\"name\":\"cts_e2e_abtest\",\"status\":\"active\",\"variants\":[{\"addToCartCount\":0,\"clickCount\":0,\"conversionCount\":0,\"description\":\"this" +
          " abtest is used for api client automation tests and will expire in" +
          " 2124\",\"index\":\"cts_e2e_search_facet\",\"purchaseCount\":0,\"trafficPercentage\":25},{\"addToCartCount\":0,\"clickCount\":0,\"conversionCount\":0,\"description\":\"\",\"index\":\"cts_e2e" +
          " abtest\",\"purchaseCount\":0,\"trafficPercentage\":75}]}],\"count\":1,\"total\":1}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }
}
