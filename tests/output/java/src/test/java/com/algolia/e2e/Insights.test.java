package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.algolia.api.InsightsClient;
import com.algolia.config.*;
import com.algolia.model.insights.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InsightsClientRequestsTestsE2E {

  private InsightsClient client;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    if ("true".equals(System.getenv("CI"))) {
      this.client = new InsightsClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"), "us");
    } else {
      Dotenv dotenv = Dotenv.configure().directory("../../").load();
      this.client = new InsightsClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"), "us");
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("Many events type")
  void pushEventsTest1() {
    EventsResponse res = client.pushEvents(
      new InsightsEvents().setEvents(
        Arrays.asList(
          new ConvertedObjectIDsAfterSearch()
            .setEventType(ConversionEvent.CONVERSION)
            .setEventName("Product Purchased")
            .setIndex("products")
            .setUserToken("user-123456")
            .setAuthenticatedUserToken("user-123456")
            .setTimestamp(1769817600000L)
            .setObjectIDs(Arrays.asList("9780545139700", "9780439784542"))
            .setQueryID("43b15df305339e827f0ac0bdc5ebcaa7"),
          new ViewedObjectIDs()
            .setEventType(ViewEvent.VIEW)
            .setEventName("Product Detail Page Viewed")
            .setIndex("products")
            .setUserToken("user-123456")
            .setAuthenticatedUserToken("user-123456")
            .setTimestamp(1769817600000L)
            .setObjectIDs(Arrays.asList("9780545139700", "9780439784542"))
        )
      )
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"message\":\"OK\",\"status\":200}", json.writeValueAsString(res), JSONCompareMode.LENIENT)
    );
  }
}
