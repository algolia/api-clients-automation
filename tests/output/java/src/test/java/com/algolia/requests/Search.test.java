package com.algolia.methods.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.cdimascio.dotenv.Dotenv;
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchClientRequestsTests {

  private SearchClient client;
  private SearchClient clientE2E;
  private EchoInterceptor echo;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
    this.echo = new EchoInterceptor();
    var options = ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(echo)).build();
    this.client = new SearchClient("appId", "apiKey", options);

    if ("true".equals(System.getenv("CI"))) {
      this.clientE2E = new SearchClient(System.getenv("ALGOLIA_APPLICATION_ID"), System.getenv("ALGOLIA_ADMIN_KEY"));
    } else {
      var dotenv = Dotenv.configure().directory("../../").load();
      this.clientE2E = new SearchClient(dotenv.get("ALGOLIA_APPLICATION_ID"), dotenv.get("ALGOLIA_ADMIN_KEY"));
    }
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("addApiKey0")
  void addApiKeyTest0() {
    assertDoesNotThrow(() -> {
      client.addApiKey(
        new ApiKey()
          .setAcl(List.of(Acl.fromValue("search"), Acl.fromValue("addObject")))
          .setDescription("my new api key")
          .setValidity(300)
          .setMaxQueriesPerIPPerHour(100)
          .setMaxHitsPerQuery(20)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"acl\":[\"search\",\"addObject\"],\"description\":\"my new api" +
        " key\",\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("addOrUpdateObject0")
  void addOrUpdateObjectTest0() {
    assertDoesNotThrow(() -> {
      client.addOrUpdateObject("indexName", "uniqueID", Map.of("key", "value"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/uniqueID", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"key\":\"value\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("appendSource0")
  void appendSourceTest0() {
    assertDoesNotThrow(() -> {
      client.appendSource(new Source().setSource("theSource").setDescription("theDescription"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/security/sources/append", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"source\":\"theSource\",\"description\":\"theDescription\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("assignUserId0")
  void assignUserIdTest0() {
    assertDoesNotThrow(() -> {
      client.assignUserId("userID", new AssignUserIdParams().setCluster("theCluster"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"cluster\":\"theCluster\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-algolia-user-id\":\"userID\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, String> actualHeaders = req.headers;

      for (Map.Entry<String, String> p : expectedHeaders.entrySet()) {
        assertEquals(p.getValue(), actualHeaders.get(p.getKey()));
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse headers json");
    }
  }

  @Test
  @DisplayName("allows batch method with `addObject` action")
  void batchTest0() {
    assertDoesNotThrow(() -> {
      client.batch(
        "theIndexName",
        new BatchWriteParams()
          .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("addObject")).setBody(Map.of("key", "value"))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"value\"}}]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("allows batch method with `clear` action")
  void batchTest1() {
    assertDoesNotThrow(() -> {
      client.batch(
        "theIndexName",
        new BatchWriteParams().setRequests(List.of(new BatchRequest().setAction(Action.fromValue("clear")).setBody(Map.of("key", "value"))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"requests\":[{\"action\":\"clear\",\"body\":{\"key\":\"value\"}}]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("allows batch method with `delete` action")
  void batchTest2() {
    assertDoesNotThrow(() -> {
      client.batch(
        "theIndexName",
        new BatchWriteParams()
          .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("delete")).setBody(Map.of("key", "value"))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"requests\":[{\"action\":\"delete\",\"body\":{\"key\":\"value\"}}]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("allows batch method with `deleteObject` action")
  void batchTest3() {
    assertDoesNotThrow(() -> {
      client.batch(
        "theIndexName",
        new BatchWriteParams()
          .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("deleteObject")).setBody(Map.of("key", "value"))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"deleteObject\",\"body\":{\"key\":\"value\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("allows batch method with `partialUpdateObject` action")
  void batchTest4() {
    assertDoesNotThrow(() -> {
      client.batch(
        "theIndexName",
        new BatchWriteParams()
          .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("partialUpdateObject")).setBody(Map.of("key", "value"))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"partialUpdateObject\",\"body\":{\"key\":\"value\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("allows batch method with `partialUpdateObjectNoCreate` action")
  void batchTest5() {
    assertDoesNotThrow(() -> {
      client.batch(
        "theIndexName",
        new BatchWriteParams()
          .setRequests(
            List.of(new BatchRequest().setAction(Action.fromValue("partialUpdateObjectNoCreate")).setBody(Map.of("key", "value")))
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"partialUpdateObjectNoCreate\",\"body\":{\"key\":\"value\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("allows batch method with `updateObject` action")
  void batchTest6() {
    assertDoesNotThrow(() -> {
      client.batch(
        "theIndexName",
        new BatchWriteParams()
          .setRequests(List.of(new BatchRequest().setAction(Action.fromValue("updateObject")).setBody(Map.of("key", "value"))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"updateObject\",\"body\":{\"key\":\"value\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("batchAssignUserIds0")
  void batchAssignUserIdsTest0() {
    assertDoesNotThrow(() -> {
      client.batchAssignUserIds("userID", new BatchAssignUserIdsParams().setCluster("theCluster").setUsers(List.of("user1", "user2")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"cluster\":\"theCluster\",\"users\":[\"user1\",\"user2\"]}", req.body, JSONCompareMode.STRICT)
    );

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-algolia-user-id\":\"userID\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, String> actualHeaders = req.headers;

      for (Map.Entry<String, String> p : expectedHeaders.entrySet()) {
        assertEquals(p.getValue(), actualHeaders.get(p.getKey()));
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse headers json");
    }
  }

  @Test
  @DisplayName("get batchDictionaryEntries results with minimal parameters")
  void batchDictionaryEntriesTest0() {
    assertDoesNotThrow(() -> {
      client.batchDictionaryEntries(
        DictionaryType.fromValue("compounds"),
        new BatchDictionaryEntriesParams()
          .setRequests(
            List.of(
              new BatchDictionaryEntriesRequest()
                .setAction(DictionaryAction.fromValue("addEntry"))
                .setBody(new DictionaryEntry().setObjectID("1").setLanguage("en")),
              new BatchDictionaryEntriesRequest()
                .setAction(DictionaryAction.fromValue("deleteEntry"))
                .setBody(new DictionaryEntry().setObjectID("2").setLanguage("fr"))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/compounds/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get batchDictionaryEntries results with all parameters")
  void batchDictionaryEntriesTest1() {
    assertDoesNotThrow(() -> {
      client.batchDictionaryEntries(
        DictionaryType.fromValue("compounds"),
        new BatchDictionaryEntriesParams()
          .setClearExistingDictionaryEntries(false)
          .setRequests(
            List.of(
              new BatchDictionaryEntriesRequest()
                .setAction(DictionaryAction.fromValue("addEntry"))
                .setBody(
                  new DictionaryEntry()
                    .setObjectID("1")
                    .setLanguage("en")
                    .setWord("fancy")
                    .setWords(List.of("believe", "algolia"))
                    .setDecomposition(List.of("trust", "algolia"))
                    .setState(DictionaryEntryState.fromValue("enabled"))
                ),
              new BatchDictionaryEntriesRequest()
                .setAction(DictionaryAction.fromValue("deleteEntry"))
                .setBody(
                  new DictionaryEntry()
                    .setObjectID("2")
                    .setLanguage("fr")
                    .setWord("humility")
                    .setWords(List.of("candor", "algolia"))
                    .setDecomposition(List.of("grit", "algolia"))
                    .setState(DictionaryEntryState.fromValue("enabled"))
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/compounds/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"clearExistingDictionaryEntries\":false,\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"word\":\"fancy\",\"words\":[\"believe\",\"algolia\"],\"decomposition\":[\"trust\",\"algolia\"],\"state\":\"enabled\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\",\"word\":\"humility\",\"words\":[\"candor\",\"algolia\"],\"decomposition\":[\"grit\",\"algolia\"],\"state\":\"enabled\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get batchDictionaryEntries results additional properties")
  void batchDictionaryEntriesTest2() {
    assertDoesNotThrow(() -> {
      client.batchDictionaryEntries(
        DictionaryType.fromValue("compounds"),
        new BatchDictionaryEntriesParams()
          .setRequests(
            List.of(
              new BatchDictionaryEntriesRequest()
                .setAction(DictionaryAction.fromValue("addEntry"))
                .setBody(new DictionaryEntry().setObjectID("1").setLanguage("en").setAdditionalProperty("additional", "try me"))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/compounds/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"additional\":\"try" + " me\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("browse with minimal parameters")
  void browseTest0() {
    assertDoesNotThrow(() -> {
      client.browse("cts_e2e_browse", Object.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_browse/browse", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));

    var res = clientE2E.browse("cts_e2e_browse", Object.class);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"page\":0,\"nbHits\":33191,\"nbPages\":34,\"hitsPerPage\":1000,\"query\":\"\",\"params\":\"\"}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("browse with search parameters")
  void browseTest1() {
    assertDoesNotThrow(() -> {
      client.browse(
        "indexName",
        new BrowseParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of("tags:algolia")))),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/browse", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"myQuery\",\"facetFilters\":[\"tags:algolia\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("browse allow a cursor in parameters")
  void browseTest2() {
    assertDoesNotThrow(() -> {
      client.browse("indexName", new BrowseParamsObject().setCursor("test"), Object.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/browse", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"cursor\":\"test\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("clearObjects0")
  void clearObjectsTest0() {
    assertDoesNotThrow(() -> {
      client.clearObjects("theIndexName");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/clear", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("clearRules0")
  void clearRulesTest0() {
    assertDoesNotThrow(() -> {
      client.clearRules("indexName");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/clear", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("clearSynonyms0")
  void clearSynonymsTest0() {
    assertDoesNotThrow(() -> {
      client.clearSynonyms("indexName");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/synonyms/clear", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("allow del method for a custom path with minimal parameters")
  void customDeleteTest0() {
    assertDoesNotThrow(() -> {
      client.customDelete("/test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow del method for a custom path with all parameters")
  void customDeleteTest1() {
    assertDoesNotThrow(() -> {
      client.customDelete("/test/all", Map.of("query", "parameters"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/all", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("allow get method for a custom path with minimal parameters")
  void customGetTest0() {
    assertDoesNotThrow(() -> {
      client.customGet("/test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow get method for a custom path with all parameters")
  void customGetTest1() {
    assertDoesNotThrow(() -> {
      client.customGet("/test/all", Map.of("query", "parameters"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/all", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("allow post method for a custom path with minimal parameters")
  void customPostTest0() {
    assertDoesNotThrow(() -> {
      client.customPost("/test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow post method for a custom path with all parameters")
  void customPostTest1() {
    assertDoesNotThrow(() -> {
      client.customPost("/test/all", Map.of("query", "parameters"), Map.of("body", "parameters"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/all", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"body\":\"parameters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions can override default query parameters")
  void customPostTest2() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("query", "myQueryParameter")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"myQueryParameter\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions merges query parameters with default ones")
  void customPostTest3() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("query2", "myQueryParameter")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"query2\":\"myQueryParameter\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions can override default headers")
  void customPostTest4() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraHeader("x-algolia-api-key", "myApiKey")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-algolia-api-key\":\"myApiKey\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, String> actualHeaders = req.headers;

      for (Map.Entry<String, String> p : expectedHeaders.entrySet()) {
        assertEquals(p.getValue(), actualHeaders.get(p.getKey()));
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse headers json");
    }
  }

  @Test
  @DisplayName("requestOptions merges headers with default ones")
  void customPostTest5() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraHeader("x-algolia-api-key", "myApiKey")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-algolia-api-key\":\"myApiKey\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, String> actualHeaders = req.headers;

      for (Map.Entry<String, String> p : expectedHeaders.entrySet()) {
        assertEquals(p.getValue(), actualHeaders.get(p.getKey()));
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse headers json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts booleans")
  void customPostTest6() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("isItWorking", true)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"isItWorking\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts integers")
  void customPostTest7() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("myParam", 2)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"2\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts list of string")
  void customPostTest8() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("myParam", List.of("c", "d"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"c,d\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts list of booleans")
  void customPostTest9() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("myParam", List.of(true, true, false))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"true,true,false\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("requestOptions queryParameters accepts list of integers")
  void customPostTest10() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "/test/requestOptions",
        Map.of("query", "parameters"),
        Map.of("facet", "filters"),
        new RequestOptions().addExtraQueryParameters("myParam", List.of(1, 2))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"1,2\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("allow put method for a custom path with minimal parameters")
  void customPutTest0() {
    assertDoesNotThrow(() -> {
      client.customPut("/test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/minimal", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow put method for a custom path with all parameters")
  void customPutTest1() {
    assertDoesNotThrow(() -> {
      client.customPut("/test/all", Map.of("query", "parameters"), Map.of("body", "parameters"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/test/all", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"body\":\"parameters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue("{\"query\":\"parameters\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("deleteApiKey0")
  void deleteApiKeyTest0() {
    assertDoesNotThrow(() -> {
      client.deleteApiKey("myTestApiKey");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys/myTestApiKey", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteBy0")
  void deleteByTest0() {
    assertDoesNotThrow(() -> {
      client.deleteBy("theIndexName", new DeleteByParams().setFilters("brand:brandName"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/deleteByQuery", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"filters\":\"brand:brandName\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("deleteIndex0")
  void deleteIndexTest0() {
    assertDoesNotThrow(() -> {
      client.deleteIndex("theIndexName");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteObject0")
  void deleteObjectTest0() {
    assertDoesNotThrow(() -> {
      client.deleteObject("theIndexName", "uniqueID");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/uniqueID", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("delete rule simple case")
  void deleteRuleTest0() {
    assertDoesNotThrow(() -> {
      client.deleteRule("indexName", "id1");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/id1", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("delete rule with simple characters to encode in objectID")
  void deleteRuleTest1() {
    assertDoesNotThrow(() -> {
      client.deleteRule("indexName", "test/with/slash");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/test%2Fwith%2Fslash", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteSource0")
  void deleteSourceTest0() {
    assertDoesNotThrow(() -> {
      client.deleteSource("theSource");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/security/sources/theSource", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteSynonym0")
  void deleteSynonymTest0() {
    assertDoesNotThrow(() -> {
      client.deleteSynonym("indexName", "id1");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/synonyms/id1", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getApiKey0")
  void getApiKeyTest0() {
    assertDoesNotThrow(() -> {
      client.getApiKey("myTestApiKey");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys/myTestApiKey", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("get getDictionaryLanguages")
  void getDictionaryLanguagesTest0() {
    assertDoesNotThrow(() -> {
      client.getDictionaryLanguages();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/*/languages", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("get getDictionarySettings results")
  void getDictionarySettingsTest0() {
    assertDoesNotThrow(() -> {
      client.getDictionarySettings();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/*/settings", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getLogs with minimal parameters")
  void getLogsTest0() {
    assertDoesNotThrow(() -> {
      client.getLogs();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/logs", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getLogs with parameters")
  void getLogsTest1() {
    assertDoesNotThrow(() -> {
      client.getLogs(5, 10, "theIndexName", LogType.fromValue("all"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/logs", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"offset\":\"5\",\"length\":\"10\",\"indexName\":\"theIndexName\",\"type\":\"all\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("getObject0")
  void getObjectTest0() {
    assertDoesNotThrow(() -> {
      client.getObject("theIndexName", "uniqueID", List.of("attr1", "attr2"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/uniqueID", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"attributesToRetrieve\":\"attr1,attr2\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("getObjects0")
  void getObjectsTest0() {
    assertDoesNotThrow(() -> {
      client.getObjects(
        new GetObjectsParams()
          .setRequests(
            List.of(
              new GetObjectsRequest()
                .setAttributesToRetrieve(List.of("attr1", "attr2"))
                .setObjectID("uniqueID")
                .setIndexName("theIndexName")
            )
          ),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/objects", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"attributesToRetrieve\":[\"attr1\",\"attr2\"],\"objectID\":\"uniqueID\",\"indexName\":\"theIndexName\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("getRule0")
  void getRuleTest0() {
    assertDoesNotThrow(() -> {
      client.getRule("indexName", "id1");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/id1", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getSettings0")
  void getSettingsTest0() {
    assertDoesNotThrow(() -> {
      client.getSettings("cts_e2e_settings");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_settings/settings", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    var res = clientE2E.getSettings("cts_e2e_settings");
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"minWordSizefor1Typo\":4,\"minWordSizefor2Typos\":8,\"hitsPerPage\":20,\"maxValuesPerFacet\":100,\"paginationLimitedTo\":10,\"exactOnSingleWordQuery\":\"attribute\",\"ranking\":[\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\",\"custom\"],\"separatorsToIndex\":\"\",\"removeWordsIfNoResults\":\"none\",\"queryType\":\"prefixLast\",\"highlightPreTag\":\"<em>\",\"highlightPostTag\":\"</em>\",\"alternativesAsExact\":[\"ignorePlurals\",\"singleWordSynonym\"]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("getSources0")
  void getSourcesTest0() {
    assertDoesNotThrow(() -> {
      client.getSources();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/security/sources", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getSynonym0")
  void getSynonymTest0() {
    assertDoesNotThrow(() -> {
      client.getSynonym("indexName", "id1");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/synonyms/id1", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getTask0")
  void getTaskTest0() {
    assertDoesNotThrow(() -> {
      client.getTask("theIndexName", 123L);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/task/123", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getTopUserIds0")
  void getTopUserIdsTest0() {
    assertDoesNotThrow(() -> {
      client.getTopUserIds();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping/top", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getUserId0")
  void getUserIdTest0() {
    assertDoesNotThrow(() -> {
      client.getUserId("uniqueID");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping/uniqueID", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("hasPendingMappings with minimal parameters")
  void hasPendingMappingsTest0() {
    assertDoesNotThrow(() -> {
      client.hasPendingMappings();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping/pending", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("hasPendingMappings with parameters")
  void hasPendingMappingsTest1() {
    assertDoesNotThrow(() -> {
      client.hasPendingMappings(true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping/pending", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"getClusters\":\"true\"}", new TypeReference<HashMap<String, String>>() {});
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("listApiKeys0")
  void listApiKeysTest0() {
    assertDoesNotThrow(() -> {
      client.listApiKeys();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listClusters0")
  void listClustersTest0() {
    assertDoesNotThrow(() -> {
      client.listClusters();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listIndices with minimal parameters")
  void listIndicesTest0() {
    assertDoesNotThrow(() -> {
      client.listIndices();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listIndices with parameters")
  void listIndicesTest1() {
    assertDoesNotThrow(() -> {
      client.listIndices(8, 3);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"page\":\"8\",\"hitsPerPage\":\"3\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("listUserIds with minimal parameters")
  void listUserIdsTest0() {
    assertDoesNotThrow(() -> {
      client.listUserIds();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listUserIds with parameters")
  void listUserIdsTest1() {
    assertDoesNotThrow(() -> {
      client.listUserIds(8, 100);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"page\":\"8\",\"hitsPerPage\":\"100\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("multipleBatch0")
  void multipleBatchTest0() {
    assertDoesNotThrow(() -> {
      client.multipleBatch(
        new BatchParams()
          .setRequests(
            List.of(
              new MultipleBatchRequest()
                .setAction(Action.fromValue("addObject"))
                .setBody(Map.of("key", "value"))
                .setIndexName("theIndexName")
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"value\"},\"indexName\":\"theIndexName\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("operationIndex0")
  void operationIndexTest0() {
    assertDoesNotThrow(() -> {
      client.operationIndex(
        "theIndexName",
        new OperationIndexParams()
          .setOperation(OperationType.fromValue("copy"))
          .setDestination("dest")
          .setScope(List.of(ScopeType.fromValue("rules"), ScopeType.fromValue("settings")))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/operation", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"operation\":\"copy\",\"destination\":\"dest\",\"scope\":[\"rules\",\"settings\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("partialUpdateObject0")
  void partialUpdateObjectTest0() {
    assertDoesNotThrow(() -> {
      client.partialUpdateObject(
        "theIndexName",
        "uniqueID",
        Map.of(
          "id1",
          AttributeToUpdate.of("test"),
          "id2",
          new BuiltInOperation().setOperation(BuiltInOperationType.fromValue("AddUnique")).setValue("test2")
        ),
        true
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/uniqueID/partial", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"id1\":\"test\",\"id2\":{\"_operation\":\"AddUnique\",\"value\":\"test2\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"createIfNotExists\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("removeUserId0")
  void removeUserIdTest0() {
    assertDoesNotThrow(() -> {
      client.removeUserId("uniqueID");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping/uniqueID", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("replaceSources0")
  void replaceSourcesTest0() {
    assertDoesNotThrow(() -> {
      client.replaceSources(List.of(new Source().setSource("theSource").setDescription("theDescription")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/security/sources", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("[{\"source\":\"theSource\",\"description\":\"theDescription\"}]", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("restoreApiKey0")
  void restoreApiKeyTest0() {
    assertDoesNotThrow(() -> {
      client.restoreApiKey("myApiKey");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys/myApiKey/restore", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("saveObject0")
  void saveObjectTest0() {
    assertDoesNotThrow(() -> {
      client.saveObject("theIndexName", Map.of("objectID", "id", "test", "val"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"objectID\":\"id\",\"test\":\"val\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("saveRule with minimal parameters")
  void saveRuleTest0() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "id1",
        new Rule()
          .setObjectID("id1")
          .setConditions(List.of(new Condition().setPattern("apple").setAnchoring(Anchoring.fromValue("contains"))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/id1", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("saveRule with all parameters")
  void saveRuleTest1() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "id1",
        new Rule()
          .setObjectID("id1")
          .setConditions(
            List.of(
              new Condition().setPattern("apple").setAnchoring(Anchoring.fromValue("contains")).setAlternatives(false).setContext("search")
            )
          )
          .setConsequence(
            new Consequence()
              .setParams(
                new ConsequenceParams()
                  .setFilters("brand:apple")
                  .setQuery(
                    new ConsequenceQueryObject()
                      .setRemove(List.of("algolia"))
                      .setEdits(
                        List.of(
                          new Edit().setType(EditType.fromValue("remove")).setDelete("abc").setInsert("cde"),
                          new Edit().setType(EditType.fromValue("replace")).setDelete("abc").setInsert("cde")
                        )
                      )
                  )
              )
              .setHide(List.of(new ConsequenceHide().setObjectID("321")))
              .setFilterPromotes(false)
              .setUserData(Map.of("algolia", "aloglia"))
              .setPromote(
                List.of(
                  new PromoteObjectID().setObjectID("abc").setPosition(3),
                  new PromoteObjectIDs().setObjectIDs(List.of("abc", "def")).setPosition(1)
                )
              )
          )
          .setDescription("test")
          .setEnabled(true)
          .setValidity(List.of(new TimeRange().setFrom(1656670273).setUntil(1656670277))),
        true
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/id1", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\",\"alternatives\":false,\"context\":\"search\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\",\"query\":{\"remove\":[\"algolia\"],\"edits\":[{\"type\":\"remove\",\"delete\":\"abc\",\"insert\":\"cde\"},{\"type\":\"replace\",\"delete\":\"abc\",\"insert\":\"cde\"}]}},\"hide\":[{\"objectID\":\"321\"}],\"filterPromotes\":false,\"userData\":{\"algolia\":\"aloglia\"},\"promote\":[{\"objectID\":\"abc\",\"position\":3},{\"objectIDs\":[\"abc\",\"def\"],\"position\":1}]},\"description\":\"test\",\"enabled\":true,\"validity\":[{\"from\":1656670273,\"until\":1656670277}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("saveRules with minimal parameters")
  void saveRulesTest0() {
    assertDoesNotThrow(() -> {
      client.saveRules(
        "indexName",
        List.of(
          new Rule()
            .setObjectID("a-rule-id")
            .setConditions(List.of(new Condition().setPattern("smartphone").setAnchoring(Anchoring.fromValue("contains")))),
          new Rule()
            .setObjectID("a-second-rule-id")
            .setConditions(List.of(new Condition().setPattern("apple").setAnchoring(Anchoring.fromValue("contains"))))
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "[{\"objectID\":\"a-rule-id\",\"conditions\":[{\"pattern\":\"smartphone\",\"anchoring\":\"contains\"}]},{\"objectID\":\"a-second-rule-id\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}]}]",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("saveRules with all parameters")
  void saveRulesTest1() {
    assertDoesNotThrow(() -> {
      client.saveRules(
        "indexName",
        List.of(
          new Rule()
            .setObjectID("id1")
            .setConditions(
              List.of(
                new Condition()
                  .setPattern("apple")
                  .setAnchoring(Anchoring.fromValue("contains"))
                  .setAlternatives(false)
                  .setContext("search")
              )
            )
            .setConsequence(
              new Consequence()
                .setParams(
                  new ConsequenceParams()
                    .setFilters("brand:apple")
                    .setQuery(
                      new ConsequenceQueryObject()
                        .setRemove(List.of("algolia"))
                        .setEdits(
                          List.of(
                            new Edit().setType(EditType.fromValue("remove")).setDelete("abc").setInsert("cde"),
                            new Edit().setType(EditType.fromValue("replace")).setDelete("abc").setInsert("cde")
                          )
                        )
                    )
                )
                .setHide(List.of(new ConsequenceHide().setObjectID("321")))
                .setFilterPromotes(false)
                .setUserData(Map.of("algolia", "aloglia"))
                .setPromote(
                  List.of(
                    new PromoteObjectID().setObjectID("abc").setPosition(3),
                    new PromoteObjectIDs().setObjectIDs(List.of("abc", "def")).setPosition(1)
                  )
                )
            )
            .setDescription("test")
            .setEnabled(true)
            .setValidity(List.of(new TimeRange().setFrom(1656670273).setUntil(1656670277)))
        ),
        true,
        true
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "[{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\",\"alternatives\":false,\"context\":\"search\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\",\"query\":{\"remove\":[\"algolia\"],\"edits\":[{\"type\":\"remove\",\"delete\":\"abc\",\"insert\":\"cde\"},{\"type\":\"replace\",\"delete\":\"abc\",\"insert\":\"cde\"}]}},\"hide\":[{\"objectID\":\"321\"}],\"filterPromotes\":false,\"userData\":{\"algolia\":\"aloglia\"},\"promote\":[{\"objectID\":\"abc\",\"position\":3},{\"objectIDs\":[\"abc\",\"def\"],\"position\":1}]},\"description\":\"test\",\"enabled\":true,\"validity\":[{\"from\":1656670273,\"until\":1656670277}]}]",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\",\"clearExistingRules\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("saveSynonym0")
  void saveSynonymTest0() {
    assertDoesNotThrow(() -> {
      client.saveSynonym(
        "indexName",
        "id1",
        new SynonymHit().setObjectID("id1").setType(SynonymType.fromValue("synonym")).setSynonyms(List.of("car", "vehicule", "auto")),
        true
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/synonyms/id1", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("saveSynonyms0")
  void saveSynonymsTest0() {
    assertDoesNotThrow(() -> {
      client.saveSynonyms(
        "indexName",
        List.of(
          new SynonymHit().setObjectID("id1").setType(SynonymType.fromValue("synonym")).setSynonyms(List.of("car", "vehicule", "auto")),
          new SynonymHit()
            .setObjectID("id2")
            .setType(SynonymType.fromValue("onewaysynonym"))
            .setInput("iphone")
            .setSynonyms(List.of("ephone", "aphone", "yphone"))
        ),
        true,
        false
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/synonyms/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "[{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]},{\"objectID\":\"id2\",\"type\":\"onewaysynonym\",\"input\":\"iphone\",\"synonyms\":[\"ephone\",\"aphone\",\"yphone\"]}]",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\",\"replaceExistingSynonyms\":\"false\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("search for a single hits request with minimal parameters")
  void searchTest0() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams().setRequests(List.of(new SearchForHits().setIndexName("cts_e2e_search_empty_index"))),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"requests\":[{\"indexName\":\"cts_e2e_search_empty_index\"}]}", req.body, JSONCompareMode.STRICT)
    );

    var res = clientE2E.search(
      new SearchMethodParams().setRequests(List.of(new SearchForHits().setIndexName("cts_e2e_search_empty_index"))),
      Object.class
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"results\":[{\"hits\":[],\"page\":0,\"nbHits\":0,\"nbPages\":0,\"hitsPerPage\":20,\"exhaustiveNbHits\":true,\"exhaustiveTypo\":true,\"exhaustive\":{\"nbHits\":true,\"typo\":true},\"query\":\"\",\"params\":\"\",\"index\":\"cts_e2e_search_empty_index\",\"renderingContent\":{}}]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("search for a single facet request with minimal parameters")
  void searchTest1() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            List.of(
              new SearchForFacets().setIndexName("cts_e2e_search_facet").setType(SearchTypeFacet.fromValue("facet")).setFacet("editor")
            )
          )
          .setStrategy(SearchStrategy.fromValue("stopIfEnoughMatches")),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"cts_e2e_search_facet\",\"type\":\"facet\",\"facet\":\"editor\"}],\"strategy\":\"stopIfEnoughMatches\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    var res = clientE2E.search(
      new SearchMethodParams()
        .setRequests(
          List.of(new SearchForFacets().setIndexName("cts_e2e_search_facet").setType(SearchTypeFacet.fromValue("facet")).setFacet("editor"))
        )
        .setStrategy(SearchStrategy.fromValue("stopIfEnoughMatches")),
      Object.class
    );
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"results\":[{\"exhaustiveFacetsCount\":true,\"facetHits\":[{\"count\":1,\"highlighted\":\"goland\",\"value\":\"goland\"},{\"count\":1,\"highlighted\":\"neovim\",\"value\":\"neovim\"},{\"count\":1,\"highlighted\":\"vscode\",\"value\":\"vscode\"}]}]}",
        json.writeValueAsString(res),
        JSONCompareMode.LENIENT
      )
    );
  }

  @Test
  @DisplayName("search for a single hits request with all parameters")
  void searchTest2() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            List.of(
              new SearchForHits()
                .setIndexName("theIndexName")
                .setQuery("myQuery")
                .setHitsPerPage(50)
                .setType(SearchTypeDefault.fromValue("default"))
            )
          ),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"theIndexName\",\"query\":\"myQuery\",\"hitsPerPage\":50,\"type\":\"default\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search for a single facet request with all parameters")
  void searchTest3() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            List.of(
              new SearchForFacets()
                .setIndexName("theIndexName")
                .setType(SearchTypeFacet.fromValue("facet"))
                .setFacet("theFacet")
                .setFacetQuery("theFacetQuery")
                .setQuery("theQuery")
                .setMaxFacetHits(50)
            )
          )
          .setStrategy(SearchStrategy.fromValue("stopIfEnoughMatches")),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"theIndexName\",\"type\":\"facet\",\"facet\":\"theFacet\",\"facetQuery\":\"theFacetQuery\",\"query\":\"theQuery\",\"maxFacetHits\":50}],\"strategy\":\"stopIfEnoughMatches\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search for multiple mixed requests in multiple indices with minimal parameters")
  void searchTest4() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            List.of(
              new SearchForHits().setIndexName("theIndexName"),
              new SearchForFacets().setIndexName("theIndexName2").setType(SearchTypeFacet.fromValue("facet")).setFacet("theFacet"),
              new SearchForHits().setIndexName("theIndexName").setType(SearchTypeDefault.fromValue("default"))
            )
          )
          .setStrategy(SearchStrategy.fromValue("stopIfEnoughMatches")),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"theIndexName\"},{\"indexName\":\"theIndexName2\",\"type\":\"facet\",\"facet\":\"theFacet\"},{\"indexName\":\"theIndexName\",\"type\":\"default\"}],\"strategy\":\"stopIfEnoughMatches\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search for multiple mixed requests in multiple indices with all parameters")
  void searchTest5() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            List.of(
              new SearchForFacets()
                .setIndexName("theIndexName")
                .setType(SearchTypeFacet.fromValue("facet"))
                .setFacet("theFacet")
                .setFacetQuery("theFacetQuery")
                .setQuery("theQuery")
                .setMaxFacetHits(50),
              new SearchForHits()
                .setIndexName("theIndexName")
                .setQuery("myQuery")
                .setHitsPerPage(50)
                .setType(SearchTypeDefault.fromValue("default"))
            )
          )
          .setStrategy(SearchStrategy.fromValue("stopIfEnoughMatches")),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"theIndexName\",\"type\":\"facet\",\"facet\":\"theFacet\",\"facetQuery\":\"theFacetQuery\",\"query\":\"theQuery\",\"maxFacetHits\":50},{\"indexName\":\"theIndexName\",\"query\":\"myQuery\",\"hitsPerPage\":50,\"type\":\"default\"}],\"strategy\":\"stopIfEnoughMatches\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search filters accept all of the possible shapes")
  void searchTest6() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            List.of(
              new SearchForHits()
                .setIndexName("theIndexName")
                .setFacetFilters(FacetFilters.of("mySearch:filters"))
                .setReRankingApplyFilter(ReRankingApplyFilter.of("mySearch:filters"))
                .setTagFilters(TagFilters.of("mySearch:filters"))
                .setNumericFilters(NumericFilters.of("mySearch:filters"))
                .setOptionalFilters(OptionalFilters.of("mySearch:filters")),
              new SearchForHits()
                .setIndexName("theIndexName")
                .setFacetFilters(
                  FacetFilters.of(List.of(MixedSearchFilters.of("mySearch:filters"), MixedSearchFilters.of(List.of("mySearch:filters"))))
                )
                .setReRankingApplyFilter(
                  ReRankingApplyFilter.of(
                    List.of(MixedSearchFilters.of("mySearch:filters"), MixedSearchFilters.of(List.of("mySearch:filters")))
                  )
                )
                .setTagFilters(
                  TagFilters.of(List.of(MixedSearchFilters.of("mySearch:filters"), MixedSearchFilters.of(List.of("mySearch:filters"))))
                )
                .setNumericFilters(
                  NumericFilters.of(List.of(MixedSearchFilters.of("mySearch:filters"), MixedSearchFilters.of(List.of("mySearch:filters"))))
                )
                .setOptionalFilters(
                  OptionalFilters.of(List.of(MixedSearchFilters.of("mySearch:filters"), MixedSearchFilters.of(List.of("mySearch:filters"))))
                )
            )
          ),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"theIndexName\",\"facetFilters\":\"mySearch:filters\",\"reRankingApplyFilter\":\"mySearch:filters\",\"tagFilters\":\"mySearch:filters\",\"numericFilters\":\"mySearch:filters\",\"optionalFilters\":\"mySearch:filters\"},{\"indexName\":\"theIndexName\",\"facetFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"reRankingApplyFilter\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"tagFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"numericFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"optionalFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]]}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search with all search parameters")
  void searchTest7() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            List.of(
              new SearchForHits()
                .setAdvancedSyntax(true)
                .setAdvancedSyntaxFeatures(List.of(AdvancedSyntaxFeatures.fromValue("exactPhrase")))
                .setAllowTyposOnNumericTokens(true)
                .setAlternativesAsExact(List.of(AlternativesAsExact.fromValue("multiWordsSynonym")))
                .setAnalytics(true)
                .setAnalyticsTags(List.of(""))
                .setAroundLatLng("")
                .setAroundLatLngViaIP(true)
                .setAroundPrecision(AroundPrecision.of(0))
                .setAroundRadius(AroundRadiusAll.fromValue("all"))
                .setAttributeCriteriaComputedByMinProximity(true)
                .setAttributesForFaceting(List.of(""))
                .setAttributesToHighlight(List.of(""))
                .setAttributesToRetrieve(List.of(""))
                .setAttributesToSnippet(List.of(""))
                .setClickAnalytics(true)
                .setCustomRanking(List.of(""))
                .setDecompoundQuery(true)
                .setDisableExactOnAttributes(List.of(""))
                .setDisableTypoToleranceOnAttributes(List.of(""))
                .setDistinct(Distinct.of(0))
                .setEnableABTest(true)
                .setEnablePersonalization(true)
                .setEnableReRanking(true)
                .setEnableRules(true)
                .setExactOnSingleWordQuery(ExactOnSingleWordQuery.fromValue("attribute"))
                .setExplain(List.of("foo", "bar"))
                .setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of(""))))
                .setFacetingAfterDistinct(true)
                .setFacets(List.of(""))
                .setFilters("")
                .setGetRankingInfo(true)
                .setHighlightPostTag("")
                .setHighlightPreTag("")
                .setHitsPerPage(1)
                .setIgnorePlurals(IgnorePlurals.of(false))
                .setIndexName("theIndexName")
                .setInsideBoundingBox(List.of(List.of(47.3165, 4.9665, 47.3424, 5.0201), List.of(40.9234, 2.1185, 38.643, 1.9916)))
                .setInsidePolygon(
                  List.of(List.of(47.3165, 4.9665, 47.3424, 5.0201, 47.32, 4.9), List.of(40.9234, 2.1185, 38.643, 1.9916, 39.2587, 2.0104))
                )
                .setKeepDiacriticsOnCharacters("")
                .setLength(1)
                .setMaxValuesPerFacet(0)
                .setMinProximity(1)
                .setMinWordSizefor1Typo(0)
                .setMinWordSizefor2Typos(0)
                .setMinimumAroundRadius(1)
                .setNaturalLanguages(List.of(""))
                .setNumericFilters(NumericFilters.of(List.of(MixedSearchFilters.of(""))))
                .setOffset(0)
                .setOptionalFilters(OptionalFilters.of(List.of(MixedSearchFilters.of(""))))
                .setOptionalWords(List.of(""))
                .setPage(0)
                .setPercentileComputation(true)
                .setPersonalizationImpact(0)
                .setQuery("")
                .setQueryLanguages(List.of(""))
                .setQueryType(QueryType.fromValue("prefixAll"))
                .setRanking(List.of(""))
                .setReRankingApplyFilter(ReRankingApplyFilter.of(List.of(MixedSearchFilters.of(""))))
                .setRelevancyStrictness(0)
                .setRemoveStopWords(RemoveStopWords.of(true))
                .setRemoveWordsIfNoResults(RemoveWordsIfNoResults.fromValue("allOptional"))
                .setRenderingContent(
                  new RenderingContent()
                    .setFacetOrdering(
                      new FacetOrdering()
                        .setFacets(new Facets().setOrder(List.of("a", "b")))
                        .setValues(Map.of("a", new Value().setOrder(List.of("b")).setSortRemainingBy(SortRemainingBy.fromValue("count"))))
                    )
                )
                .setReplaceSynonymsInHighlight(true)
                .setResponseFields(List.of(""))
                .setRestrictHighlightAndSnippetArrays(true)
                .setRestrictSearchableAttributes(List.of(""))
                .setRuleContexts(List.of(""))
                .setSimilarQuery("")
                .setSnippetEllipsisText("")
                .setSortFacetValuesBy("")
                .setSumOrFiltersScores(true)
                .setSynonyms(true)
                .setTagFilters(TagFilters.of(List.of(MixedSearchFilters.of(""))))
                .setType(SearchTypeDefault.fromValue("default"))
                .setTypoTolerance(TypoToleranceEnum.fromValue("min"))
                .setUserToken("")
            )
          ),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"exactPhrase\"],\"allowTyposOnNumericTokens\":true,\"alternativesAsExact\":[\"multiWordsSynonym\"],\"analytics\":true,\"analyticsTags\":[\"\"],\"aroundLatLng\":\"\",\"aroundLatLngViaIP\":true,\"aroundPrecision\":0,\"aroundRadius\":\"all\",\"attributeCriteriaComputedByMinProximity\":true,\"attributesForFaceting\":[\"\"],\"attributesToHighlight\":[\"\"],\"attributesToRetrieve\":[\"\"],\"attributesToSnippet\":[\"\"],\"clickAnalytics\":true,\"customRanking\":[\"\"],\"decompoundQuery\":true,\"disableExactOnAttributes\":[\"\"],\"disableTypoToleranceOnAttributes\":[\"\"],\"distinct\":0,\"enableABTest\":true,\"enablePersonalization\":true,\"enableReRanking\":true,\"enableRules\":true,\"exactOnSingleWordQuery\":\"attribute\",\"explain\":[\"foo\",\"bar\"],\"facetFilters\":[\"\"],\"facetingAfterDistinct\":true,\"facets\":[\"\"],\"filters\":\"\",\"getRankingInfo\":true,\"highlightPostTag\":\"\",\"highlightPreTag\":\"\",\"hitsPerPage\":1,\"ignorePlurals\":false,\"indexName\":\"theIndexName\",\"insideBoundingBox\":[[47.3165,4.9665,47.3424,5.0201],[40.9234,2.1185,38.643,1.9916]],\"insidePolygon\":[[47.3165,4.9665,47.3424,5.0201,47.32,4.9],[40.9234,2.1185,38.643,1.9916,39.2587,2.0104]],\"keepDiacriticsOnCharacters\":\"\",\"length\":1,\"maxValuesPerFacet\":0,\"minProximity\":1,\"minWordSizefor1Typo\":0,\"minWordSizefor2Typos\":0,\"minimumAroundRadius\":1,\"naturalLanguages\":[\"\"],\"numericFilters\":[\"\"],\"offset\":0,\"optionalFilters\":[\"\"],\"optionalWords\":[\"\"],\"page\":0,\"percentileComputation\":true,\"personalizationImpact\":0,\"query\":\"\",\"queryLanguages\":[\"\"],\"queryType\":\"prefixAll\",\"ranking\":[\"\"],\"reRankingApplyFilter\":[\"\"],\"relevancyStrictness\":0,\"removeStopWords\":true,\"removeWordsIfNoResults\":\"allOptional\",\"renderingContent\":{\"facetOrdering\":{\"facets\":{\"order\":[\"a\",\"b\"]},\"values\":{\"a\":{\"order\":[\"b\"],\"sortRemainingBy\":\"count\"}}}},\"replaceSynonymsInHighlight\":true,\"responseFields\":[\"\"],\"restrictHighlightAndSnippetArrays\":true,\"restrictSearchableAttributes\":[\"\"],\"ruleContexts\":[\"\"],\"similarQuery\":\"\",\"snippetEllipsisText\":\"\",\"sortFacetValuesBy\":\"\",\"sumOrFiltersScores\":true,\"synonyms\":true,\"tagFilters\":[\"\"],\"type\":\"default\",\"typoTolerance\":\"min\",\"userToken\":\"\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get searchDictionaryEntries results with minimal parameters")
  void searchDictionaryEntriesTest0() {
    assertDoesNotThrow(() -> {
      client.searchDictionaryEntries(DictionaryType.fromValue("compounds"), new SearchDictionaryEntriesParams().setQuery("foo"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/compounds/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"foo\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("get searchDictionaryEntries results with all parameters")
  void searchDictionaryEntriesTest1() {
    assertDoesNotThrow(() -> {
      client.searchDictionaryEntries(
        DictionaryType.fromValue("compounds"),
        new SearchDictionaryEntriesParams().setQuery("foo").setPage(4).setHitsPerPage(2).setLanguage("fr")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/compounds/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"foo\",\"page\":4,\"hitsPerPage\":2,\"language\":\"fr\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("get searchForFacetValues results with minimal parameters")
  void searchForFacetValuesTest0() {
    assertDoesNotThrow(() -> {
      client.searchForFacetValues("indexName", "facetName");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/facets/facetName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("get searchForFacetValues results with all parameters")
  void searchForFacetValuesTest1() {
    assertDoesNotThrow(() -> {
      client.searchForFacetValues(
        "indexName",
        "facetName",
        new SearchForFacetValuesRequest().setParams("query=foo&facetFilters=['bar']").setFacetQuery("foo").setMaxFacetHits(42)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/facets/facetName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"params\":\"query=foo&facetFilters=['bar']\",\"facetQuery\":\"foo\",\"maxFacetHits\":42}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchRules0")
  void searchRulesTest0() {
    assertDoesNotThrow(() -> {
      client.searchRules("indexName", new SearchRulesParams().setQuery("something"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"something\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("search with minimal parameters")
  void searchSingleIndexTest0() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", Object.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("search with special characters in indexName")
  void searchSingleIndexTest1() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("cts_e2e_space in index", Object.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_space%20in%20index/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));

    var res = clientE2E.searchSingleIndex("cts_e2e_space in index", Object.class);
  }

  @Test
  @DisplayName("search with searchParams")
  void searchSingleIndexTest2() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of("tags:algolia")))),
        Object.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"myQuery\",\"facetFilters\":[\"tags:algolia\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("searchSynonyms with minimal parameters")
  void searchSynonymsTest0() {
    assertDoesNotThrow(() -> {
      client.searchSynonyms("indexName");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/synonyms/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("searchSynonyms with all parameters")
  void searchSynonymsTest1() {
    assertDoesNotThrow(() -> {
      client.searchSynonyms(
        "indexName",
        new SearchSynonymsParams().setQuery("myQuery").setType(SynonymType.fromValue("altcorrection1")).setPage(10).setHitsPerPage(10)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/synonyms/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"myQuery\",\"type\":\"altcorrection1\",\"page\":10,\"hitsPerPage\":10}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchUserIds0")
  void searchUserIdsTest0() {
    assertDoesNotThrow(() -> {
      client.searchUserIds(new SearchUserIdsParams().setQuery("test").setClusterName("theClusterName").setPage(5).setHitsPerPage(10));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"test\",\"clusterName\":\"theClusterName\",\"page\":5,\"hitsPerPage\":10}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get setDictionarySettings results with minimal parameters")
  void setDictionarySettingsTest0() {
    assertDoesNotThrow(() -> {
      client.setDictionarySettings(
        new DictionarySettingsParams()
          .setDisableStandardEntries(new StandardEntries().setPlurals(Map.of("fr", false, "en", false, "ru", true)))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/*/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get setDictionarySettings results with all parameters")
  void setDictionarySettingsTest1() {
    assertDoesNotThrow(() -> {
      client.setDictionarySettings(
        new DictionarySettingsParams()
          .setDisableStandardEntries(
            new StandardEntries()
              .setPlurals(Map.of("fr", false, "en", false, "ru", true))
              .setStopwords(Map.of("fr", false))
              .setCompounds(Map.of("ru", true))
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/*/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true},\"stopwords\":{\"fr\":false},\"compounds\":{\"ru\":true}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("setSettings with minimal parameters")
  void setSettingsTest0() {
    assertDoesNotThrow(() -> {
      client.setSettings("cts_e2e_settings", new IndexSettings().setPaginationLimitedTo(10), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_settings/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"paginationLimitedTo\":10}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }

    var res = clientE2E.setSettings("cts_e2e_settings", new IndexSettings().setPaginationLimitedTo(10), true);
  }

  @Test
  @DisplayName("setSettings allow boolean `typoTolerance`")
  void setSettingsTest1() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setTypoTolerance(TypoTolerance.of(true)), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"typoTolerance\":true}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("setSettings allow enum `typoTolerance`")
  void setSettingsTest2() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setTypoTolerance(TypoToleranceEnum.fromValue("min")), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"typoTolerance\":\"min\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("setSettings allow boolean `ignorePlurals`")
  void setSettingsTest3() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setIgnorePlurals(IgnorePlurals.of(true)), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"ignorePlurals\":true}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("setSettings allow list of string `ignorePlurals`")
  void setSettingsTest4() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setIgnorePlurals(IgnorePlurals.of(List.of("algolia"))), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"ignorePlurals\":[\"algolia\"]}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("setSettings allow boolean `removeStopWords`")
  void setSettingsTest5() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setRemoveStopWords(RemoveStopWords.of(true)), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"removeStopWords\":true}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("setSettings allow list of string `removeStopWords`")
  void setSettingsTest6() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setRemoveStopWords(RemoveStopWords.of(List.of("algolia"))), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"removeStopWords\":[\"algolia\"]}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("setSettings allow boolean `distinct`")
  void setSettingsTest7() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setDistinct(Distinct.of(true)), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"distinct\":true}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("setSettings allow integers for `distinct`")
  void setSettingsTest8() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setDistinct(Distinct.of(1)), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"distinct\":1}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"true\"}",
        new TypeReference<HashMap<String, String>>() {}
      );
      Map<String, Object> actualQuery = req.queryParameters;

      assertEquals(expectedQuery.size(), actualQuery.size());
      for (Map.Entry<String, Object> p : actualQuery.entrySet()) {
        assertEquals(expectedQuery.get(p.getKey()), p.getValue());
      }
    } catch (JsonProcessingException e) {
      fail("failed to parse queryParameters json");
    }
  }

  @Test
  @DisplayName("setSettings allow all `indexSettings`")
  void setSettingsTest9() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings()
          .setAdvancedSyntax(true)
          .setAdvancedSyntaxFeatures(List.of(AdvancedSyntaxFeatures.fromValue("exactPhrase")))
          .setAllowCompressionOfIntegerArray(true)
          .setAllowTyposOnNumericTokens(true)
          .setAlternativesAsExact(List.of(AlternativesAsExact.fromValue("singleWordSynonym")))
          .setAttributeCriteriaComputedByMinProximity(true)
          .setAttributeForDistinct("test")
          .setAttributesForFaceting(List.of("algolia"))
          .setAttributesToHighlight(List.of("algolia"))
          .setAttributesToRetrieve(List.of("algolia"))
          .setAttributesToSnippet(List.of("algolia"))
          .setAttributesToTransliterate(List.of("algolia"))
          .setCamelCaseAttributes(List.of("algolia"))
          .setCustomNormalization(Map.of("algolia", Map.of("aloglia", "aglolia")))
          .setCustomRanking(List.of("algolia"))
          .setDecompoundQuery(false)
          .setDecompoundedAttributes(Map.of("algolia", "aloglia"))
          .setDisableExactOnAttributes(List.of("algolia"))
          .setDisablePrefixOnAttributes(List.of("algolia"))
          .setDisableTypoToleranceOnAttributes(List.of("algolia"))
          .setDisableTypoToleranceOnWords(List.of("algolia"))
          .setDistinct(Distinct.of(3))
          .setEnablePersonalization(true)
          .setEnableReRanking(false)
          .setEnableRules(true)
          .setExactOnSingleWordQuery(ExactOnSingleWordQuery.fromValue("attribute"))
          .setHighlightPreTag("<span>")
          .setHighlightPostTag("</span>")
          .setHitsPerPage(10)
          .setIgnorePlurals(IgnorePlurals.of(false))
          .setIndexLanguages(List.of("algolia"))
          .setKeepDiacriticsOnCharacters("abc")
          .setMaxFacetHits(20)
          .setMaxValuesPerFacet(30)
          .setMinProximity(6)
          .setMinWordSizefor1Typo(5)
          .setMinWordSizefor2Typos(11)
          .setMode(Mode.fromValue("neuralSearch"))
          .setNumericAttributesForFiltering(List.of("algolia"))
          .setOptionalWords(List.of("myspace"))
          .setPaginationLimitedTo(0)
          .setQueryLanguages(List.of("algolia"))
          .setQueryType(QueryType.fromValue("prefixLast"))
          .setRanking(List.of("geo"))
          .setReRankingApplyFilter(ReRankingApplyFilter.of("mySearch:filters"))
          .setRelevancyStrictness(10)
          .setRemoveStopWords(RemoveStopWords.of(false))
          .setRemoveWordsIfNoResults(RemoveWordsIfNoResults.fromValue("lastWords"))
          .setRenderingContent(
            new RenderingContent()
              .setFacetOrdering(
                new FacetOrdering()
                  .setFacets(new Facets().setOrder(List.of("a", "b")))
                  .setValues(Map.of("a", new Value().setOrder(List.of("b")).setSortRemainingBy(SortRemainingBy.fromValue("count"))))
              )
          )
          .setReplaceSynonymsInHighlight(true)
          .setReplicas(List.of(""))
          .setResponseFields(List.of("algolia"))
          .setRestrictHighlightAndSnippetArrays(true)
          .setSearchableAttributes(List.of("foo"))
          .setSemanticSearch(new SemanticSearch().setEventSources(List.of("foo")))
          .setSeparatorsToIndex("bar")
          .setSnippetEllipsisText("---")
          .setSortFacetValuesBy("date")
          .setTypoTolerance(TypoTolerance.of(false))
          .setUnretrievableAttributes(List.of("foo"))
          .setUserData(Map.of("user", "data"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"exactPhrase\"],\"allowCompressionOfIntegerArray\":true,\"allowTyposOnNumericTokens\":true,\"alternativesAsExact\":[\"singleWordSynonym\"],\"attributeCriteriaComputedByMinProximity\":true,\"attributeForDistinct\":\"test\",\"attributesForFaceting\":[\"algolia\"],\"attributesToHighlight\":[\"algolia\"],\"attributesToRetrieve\":[\"algolia\"],\"attributesToSnippet\":[\"algolia\"],\"attributesToTransliterate\":[\"algolia\"],\"camelCaseAttributes\":[\"algolia\"],\"customNormalization\":{\"algolia\":{\"aloglia\":\"aglolia\"}},\"customRanking\":[\"algolia\"],\"decompoundQuery\":false,\"decompoundedAttributes\":{\"algolia\":\"aloglia\"},\"disableExactOnAttributes\":[\"algolia\"],\"disablePrefixOnAttributes\":[\"algolia\"],\"disableTypoToleranceOnAttributes\":[\"algolia\"],\"disableTypoToleranceOnWords\":[\"algolia\"],\"distinct\":3,\"enablePersonalization\":true,\"enableReRanking\":false,\"enableRules\":true,\"exactOnSingleWordQuery\":\"attribute\",\"highlightPreTag\":\"<span>\",\"highlightPostTag\":\"</span>\",\"hitsPerPage\":10,\"ignorePlurals\":false,\"indexLanguages\":[\"algolia\"],\"keepDiacriticsOnCharacters\":\"abc\",\"maxFacetHits\":20,\"maxValuesPerFacet\":30,\"minProximity\":6,\"minWordSizefor1Typo\":5,\"minWordSizefor2Typos\":11,\"mode\":\"neuralSearch\",\"numericAttributesForFiltering\":[\"algolia\"],\"optionalWords\":[\"myspace\"],\"paginationLimitedTo\":0,\"queryLanguages\":[\"algolia\"],\"queryType\":\"prefixLast\",\"ranking\":[\"geo\"],\"reRankingApplyFilter\":\"mySearch:filters\",\"relevancyStrictness\":10,\"removeStopWords\":false,\"removeWordsIfNoResults\":\"lastWords\",\"renderingContent\":{\"facetOrdering\":{\"facets\":{\"order\":[\"a\",\"b\"]},\"values\":{\"a\":{\"order\":[\"b\"],\"sortRemainingBy\":\"count\"}}}},\"replaceSynonymsInHighlight\":true,\"replicas\":[\"\"],\"responseFields\":[\"algolia\"],\"restrictHighlightAndSnippetArrays\":true,\"searchableAttributes\":[\"foo\"],\"semanticSearch\":{\"eventSources\":[\"foo\"]},\"separatorsToIndex\":\"bar\",\"snippetEllipsisText\":\"---\",\"sortFacetValuesBy\":\"date\",\"typoTolerance\":false,\"unretrievableAttributes\":[\"foo\"],\"userData\":{\"user\":\"data\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("updateApiKey0")
  void updateApiKeyTest0() {
    assertDoesNotThrow(() -> {
      client.updateApiKey(
        "myApiKey",
        new ApiKey()
          .setAcl(List.of(Acl.fromValue("search"), Acl.fromValue("addObject")))
          .setValidity(300)
          .setMaxQueriesPerIPPerHour(100)
          .setMaxHitsPerQuery(20)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys/myApiKey", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"acl\":[\"search\",\"addObject\"],\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }
}
