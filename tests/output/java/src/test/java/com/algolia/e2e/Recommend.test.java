package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.algolia.api.RecommendClient;
import com.algolia.config.*;
import com.algolia.model.recommend.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RecommendClientRequestsTestsE2E {

  private RecommendClient client;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    if ("true".equals(System.getenv("CI"))) {
      this.client = new RecommendClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"));
    } else {
      Dotenv dotenv = Dotenv.configure().directory("../../").load();
      this.client = new RecommendClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"));
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("get recommendations with e2e to check oneOf model")
  void getRecommendationsTest1() {
    GetRecommendationsResponse res = client.getRecommendations(
      new GetRecommendationsParams().setRequests(
        Arrays.asList(
          new RelatedQuery()
            .setIndexName("cts_e2e_browse")
            .setObjectID("Æon Flux")
            .setModel(RelatedModel.RELATED_PRODUCTS)
            .setThreshold(20.0)
            .setMaxRecommendations(2)
        )
      )
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"results\":[{\"exhaustive\":{\"nbHits\":true,\"typo\":true},\"exhaustiveNbHits\":true,\"exhaustiveTypo\":true,\"index\":\"cts_e2e_browse\",\"page\":0,\"nbHits\":2,\"nbPages\":1,\"hitsPerPage\":2,\"hits\":[{\"objectID\":\"The" +
          " Transformers: The" +
          " Movie\",\"_highlightResult\":{\"genres\":[{\"matchLevel\":\"none\",\"matchedWords\":[],\"value\":\"Animated\"},{\"matchLevel\":\"none\",\"matchedWords\":[],\"value\":\"Action\"},{\"matchLevel\":\"none\",\"matchedWords\":[],\"value\":\"Science" +
          " Fiction\"}],\"href\":{\"matchLevel\":\"none\",\"matchedWords\":[],\"value\":\"The_Transformers:_The_Movie\"}},\"_score\":100.0,\"cast\":[\"Judd" +
          " Nelson\",\"Leonard Nimoy\",\"Robert Stack\",\"Orson Welles\",\"Michael" +
          " Bell\",\"Eric Idle\",\"Chris Latta\",\"Peter Cullen\",\"Frank" +
          " Welker\",\"Neil Ross\",\"Paul Eiding\"],\"extract\":\"The Transformers: The" +
          " Movie is a 1986 animated science fiction action film based on the" +
          " Transformers television series. It was released in North America on August" +
          " 8, 1986, and in the United Kingdom on December 12, 1986. It was co-produced" +
          " and directed by Nelson Shin, who also produced the television series. The" +
          " screenplay was written by Ron Friedman, who created Bionic Six a year" +
          " later.\",\"title\":\"The Transformers: The" +
          " Movie\",\"year\":1986},{\"objectID\":\"Treasure" +
          " Planet\",\"_score\":90.56,\"title\":\"Treasure Planet\",\"year\":2002}]}]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }
}
