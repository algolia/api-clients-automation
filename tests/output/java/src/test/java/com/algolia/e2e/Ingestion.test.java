package com.algolia.e2e;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.algolia.api.IngestionClient;
import com.algolia.config.*;
import com.algolia.model.ingestion.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IngestionClientRequestsTestsE2E {

  private IngestionClient client;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    if ("true".equals(System.getenv("CI"))) {
      this.client = new IngestionClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"), "us");
    } else {
      Dotenv dotenv = Dotenv.configure().directory("../../").load();
      this.client = new IngestionClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"), "us");
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("enableTask")
  void enableTaskTest() {
    TaskUpdateResponse res = client.enableTask("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"taskID\":\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\"}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("enableTaskV1")
  void enableTaskV1Test() {
    TaskUpdateResponse res = client.enableTaskV1("76ab4c2a-ce17-496f-b7a6-506dc59ee498");
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"taskID\":\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\"}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("getSource")
  void getSourceTest() {
    Source res = client.getSource("75eeb306-51d3-4e5e-a279-3c92bd8893ac");
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"sourceID\":\"75eeb306-51d3-4e5e-a279-3c92bd8893ac\",\"name\":\"cts_e2e_browse\",\"type\":\"json\",\"input\":{\"url\":\"https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json\"}}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("getAuthentications with query params")
  void listAuthenticationsTest1() {
    ListAuthenticationsResponse res = client.listAuthentications(
      2,
      1,
      Arrays.asList(AuthenticationType.BASIC, AuthenticationType.ALGOLIA),
      Arrays.asList(PlatformNone.NONE),
      AuthenticationSortKeys.CREATED_AT,
      OrderKeys.ASC
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"pagination\":{\"page\":1,\"itemsPerPage\":2},\"authentications\":[{\"authenticationID\":\"474f050f-a771-464c-a016-323538029f5f\",\"type\":\"algolia\",\"name\":\"algolia-auth-1677060483885\",\"input\":{},\"createdAt\":\"2023-02-22T10:08:04Z\",\"updatedAt\":\"2023-10-25T08:41:56Z\"},{}]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("searchTasks")
  void searchTasksTest() {
    List res = client.searchTasks(
      new TaskSearch().setTaskIDs(
        Arrays.asList(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "[{\"taskID\":\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\",\"sourceID\":\"75eeb306-51d3-4e5e-a279-3c92bd8893ac\",\"destinationID\":\"506d79fa-e29d-4bcf-907c-6b6a41172153\",\"enabled\":true,\"failureThreshold\":0,\"action\":\"replace\",\"createdAt\":\"2024-01-08T16:47:41Z\"}]",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("searchTasksV1")
  void searchTasksV1Test() {
    List res = client.searchTasksV1(
      new TaskSearch().setTaskIDs(
        Arrays.asList(
          "6c02aeb1-775e-418e-870b-1faccd4b2c0f",
          "947ac9c4-7e58-4c87-b1e7-14a68e99699a",
          "76ab4c2a-ce17-496f-b7a6-506dc59ee498"
        )
      )
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "[{\"taskID\":\"76ab4c2a-ce17-496f-b7a6-506dc59ee498\",\"sourceID\":\"75eeb306-51d3-4e5e-a279-3c92bd8893ac\",\"destinationID\":\"506d79fa-e29d-4bcf-907c-6b6a41172153\",\"trigger\":{\"type\":\"onDemand\"},\"enabled\":true,\"failureThreshold\":0,\"action\":\"replace\",\"createdAt\":\"2024-01-08T16:47:41Z\"}]",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }
}
