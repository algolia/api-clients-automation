package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.algolia.api.AbtestingV3Client;
import com.algolia.config.*;
import com.algolia.model.abtestingv3.*;
import com.algolia.utils.TestHelpers;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AbtestingV3ClientRequestsTestsE2E {

  private AbtestingV3Client client;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    if ("true".equals(System.getenv("CI"))) {
      this.client = new AbtestingV3Client(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"), "us");
    } else {
      Dotenv dotenv = Dotenv.configure().directory("../../").load();
      this.client = new AbtestingV3Client(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"), "us");
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("listABTests with parameters")
  void listABTestsTest1() {
    ListABTestsResponse res = client.listABTests(
      0,
      21,
      "cts_e2e ab",
      "t",
      Direction.ASC,
      Arrays.asList(AnalysisMethod.FREQUENTIST, AnalysisMethod.BAYESIAN)
    );
    assertDoesNotThrow(() ->
      TestHelpers.lenientJsonAssert(
        "{\"abtests\":[{\"abTestID\":85635,\"createdAt\":\"2024-05-13T10:12:27.739233Z\",\"endAt\":\"2124-05-13T00:00:00Z\",\"name\":\"cts_e2e_abtest\",\"hypothesis\":\"\",\"status\":\"active\",\"variants\":[{\"description\":\"this" +
          " abtest is used for api client automation tests and will expire in" +
          " 2124\",\"index\":\"cts_e2e_search_facet\",\"trafficPercentage\":25},{\"description\":\"\",\"index\":\"cts_e2e" +
          " abtest\",\"trafficPercentage\":75}]}],\"count\":1,\"total\":1}",
        json.writeValueAsString(res)
      )
    );
  }
}
