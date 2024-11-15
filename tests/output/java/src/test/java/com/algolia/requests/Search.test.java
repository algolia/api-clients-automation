package com.algolia.requests;

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
import java.util.*;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchClientRequestsTests {

  private SearchClient client;
  private EchoInterceptor echo;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
    this.echo = new EchoInterceptor();
    ClientOptions options = ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(echo)).build();
    this.client = new SearchClient("appId", "apiKey", options);
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("addApiKey")
  void addApiKeyTest() {
    assertDoesNotThrow(() -> {
      client.addApiKey(
        new ApiKey()
          .setAcl(Arrays.asList(Acl.SEARCH, Acl.ADD_OBJECT))
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
  @DisplayName("addOrUpdateObject")
  void addOrUpdateObjectTest() {
    assertDoesNotThrow(() -> {
      client.addOrUpdateObject(
        "indexName",
        "uniqueID",
        new HashMap() {
          {
            put("key", "value");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/uniqueID", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"key\":\"value\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("appendSource")
  void appendSourceTest() {
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
  @DisplayName("assignUserId")
  void assignUserIdTest() {
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
  @DisplayName("it should not encode the userID")
  void assignUserIdTest1() {
    assertDoesNotThrow(() -> {
      client.assignUserId("user id with spaces", new AssignUserIdParams().setCluster("cluster with spaces"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"cluster\":\"cluster with spaces\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-algolia-user-id\":\"user id with spaces\"}",
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
  @DisplayName("addObject")
  void batchTest() {
    assertDoesNotThrow(() -> {
      client.batch(
        "<YOUR_INDEX_NAME>",
        new BatchWriteParams()
          .setRequests(
            Arrays.asList(
              new BatchRequest()
                .setAction(Action.ADD_OBJECT)
                .setBody(
                  new HashMap() {
                    {
                      put("key", "bar");
                      put("foo", "1");
                    }
                  }
                ),
              new BatchRequest()
                .setAction(Action.ADD_OBJECT)
                .setBody(
                  new HashMap() {
                    {
                      put("key", "baz");
                      put("foo", "2");
                    }
                  }
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"bar\",\"foo\":\"1\"}},{\"action\":\"addObject\",\"body\":{\"key\":\"baz\",\"foo\":\"2\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("clear")
  void batchTest1() {
    assertDoesNotThrow(() -> {
      client.batch(
        "<YOUR_INDEX_NAME>",
        new BatchWriteParams()
          .setRequests(
            Arrays.asList(
              new BatchRequest()
                .setAction(Action.CLEAR)
                .setBody(
                  new HashMap() {
                    {
                      put("key", "value");
                    }
                  }
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"requests\":[{\"action\":\"clear\",\"body\":{\"key\":\"value\"}}]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("delete")
  void batchTest2() {
    assertDoesNotThrow(() -> {
      client.batch(
        "<YOUR_INDEX_NAME>",
        new BatchWriteParams()
          .setRequests(
            Arrays.asList(
              new BatchRequest()
                .setAction(Action.DELETE)
                .setBody(
                  new HashMap() {
                    {
                      put("key", "value");
                    }
                  }
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"requests\":[{\"action\":\"delete\",\"body\":{\"key\":\"value\"}}]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("deleteObject")
  void batchTest3() {
    assertDoesNotThrow(() -> {
      client.batch(
        "<YOUR_INDEX_NAME>",
        new BatchWriteParams()
          .setRequests(
            Arrays.asList(
              new BatchRequest()
                .setAction(Action.DELETE_OBJECT)
                .setBody(
                  new HashMap() {
                    {
                      put("key", "value");
                    }
                  }
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/batch", req.path);
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
  @DisplayName("partialUpdateObject")
  void batchTest4() {
    assertDoesNotThrow(() -> {
      client.batch(
        "<YOUR_INDEX_NAME>",
        new BatchWriteParams()
          .setRequests(
            Arrays.asList(
              new BatchRequest()
                .setAction(Action.PARTIAL_UPDATE_OBJECT)
                .setBody(
                  new HashMap() {
                    {
                      put("key", "value");
                    }
                  }
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/batch", req.path);
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
  @DisplayName("partialUpdateObjectNoCreate")
  void batchTest5() {
    assertDoesNotThrow(() -> {
      client.batch(
        "<YOUR_INDEX_NAME>",
        new BatchWriteParams()
          .setRequests(
            Arrays.asList(
              new BatchRequest()
                .setAction(Action.PARTIAL_UPDATE_OBJECT_NO_CREATE)
                .setBody(
                  new HashMap() {
                    {
                      put("key", "value");
                    }
                  }
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/batch", req.path);
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
  @DisplayName("updateObject")
  void batchTest6() {
    assertDoesNotThrow(() -> {
      client.batch(
        "<YOUR_INDEX_NAME>",
        new BatchWriteParams()
          .setRequests(
            Arrays.asList(
              new BatchRequest()
                .setAction(Action.UPDATE_OBJECT)
                .setBody(
                  new HashMap() {
                    {
                      put("key", "value");
                    }
                  }
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/batch", req.path);
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
  @DisplayName("batchAssignUserIds")
  void batchAssignUserIdsTest() {
    assertDoesNotThrow(() -> {
      client.batchAssignUserIds(
        "userID",
        new BatchAssignUserIdsParams().setCluster("theCluster").setUsers(Arrays.asList("user1", "user2"))
      );
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
  @DisplayName("replace")
  void batchDictionaryEntriesTest() {
    assertDoesNotThrow(() -> {
      client.batchDictionaryEntries(
        DictionaryType.PLURALS,
        new BatchDictionaryEntriesParams()
          .setClearExistingDictionaryEntries(true)
          .setRequests(
            Arrays.asList(
              new BatchDictionaryEntriesRequest()
                .setAction(DictionaryAction.ADD_ENTRY)
                .setBody(
                  new DictionaryEntry()
                    .setObjectID("1")
                    .setLanguage(SupportedLanguage.EN)
                    .setWord("fancy")
                    .setWords(Arrays.asList("believe", "algolia"))
                    .setDecomposition(Arrays.asList("trust", "algolia"))
                    .setState(DictionaryEntryState.ENABLED)
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/plurals/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"clearExistingDictionaryEntries\":true,\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"word\":\"fancy\",\"words\":[\"believe\",\"algolia\"],\"decomposition\":[\"trust\",\"algolia\"],\"state\":\"enabled\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("delete")
  void batchDictionaryEntriesTest1() {
    assertDoesNotThrow(() -> {
      client.batchDictionaryEntries(
        DictionaryType.PLURALS,
        new BatchDictionaryEntriesParams()
          .setClearExistingDictionaryEntries(true)
          .setRequests(
            Arrays.asList(
              new BatchDictionaryEntriesRequest().setAction(DictionaryAction.DELETE_ENTRY).setBody(new DictionaryEntry().setObjectID("1"))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/plurals/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"clearExistingDictionaryEntries\":true,\"requests\":[{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"1\"}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("append")
  void batchDictionaryEntriesTest2() {
    assertDoesNotThrow(() -> {
      client.batchDictionaryEntries(
        DictionaryType.STOPWORDS,
        new BatchDictionaryEntriesParams()
          .setRequests(
            Arrays.asList(
              new BatchDictionaryEntriesRequest()
                .setAction(DictionaryAction.ADD_ENTRY)
                .setBody(
                  new DictionaryEntry().setObjectID("1").setLanguage(SupportedLanguage.EN).setAdditionalProperty("additional", "try me")
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/stopwords/batch", req.path);
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
  void browseTest() {
    assertDoesNotThrow(() -> {
      client.browse("cts_e2e_browse", Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_browse/browse", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("browse with search parameters")
  void browseTest1() {
    assertDoesNotThrow(() -> {
      client.browse(
        "indexName",
        new BrowseParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("tags:algolia")))),
        Hit.class
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
      client.browse("indexName", new BrowseParamsObject().setCursor("test"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/browse", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"cursor\":\"test\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("clearObjects")
  void clearObjectsTest() {
    assertDoesNotThrow(() -> {
      client.clearObjects("theIndexName");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/clear", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("clearRules")
  void clearRulesTest() {
    assertDoesNotThrow(() -> {
      client.clearRules("indexName");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/clear", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("clearSynonyms")
  void clearSynonymsTest() {
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
  void customDeleteTest() {
    assertDoesNotThrow(() -> {
      client.customDelete("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow del method for a custom path with all parameters")
  void customDeleteTest1() {
    assertDoesNotThrow(() -> {
      client.customDelete(
        "test/all",
        new HashMap() {
          {
            put("query", "parameters");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
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
  void customGetTest() {
    assertDoesNotThrow(() -> {
      client.customGet("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("allow get method for a custom path with all parameters")
  void customGetTest1() {
    assertDoesNotThrow(() -> {
      client.customGet(
        "test/all",
        new HashMap() {
          {
            put("query", "parameters with space");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters%20with%20space\"}",
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
  @DisplayName("requestOptions should be escaped too")
  void customGetTest2() {
    assertDoesNotThrow(() -> {
      client.customGet(
        "test/all",
        new HashMap() {
          {
            put("query", "to be overriden");
          }
        },
        new RequestOptions()
          .addExtraQueryParameters("query", "parameters with space")
          .addExtraQueryParameters("and an array", Arrays.asList("array", "with spaces"))
          .addExtraHeader("x-header-1", "spaces are left alone")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters%20with%20space\",\"and%20an%20array\":\"array%2Cwith%20spaces\"}",
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

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-header-1\":\"spaces are left alone\"}",
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
  @DisplayName("allow post method for a custom path with minimal parameters")
  void customPostTest() {
    assertDoesNotThrow(() -> {
      client.customPost("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow post method for a custom path with all parameters")
  void customPostTest1() {
    assertDoesNotThrow(() -> {
      client.customPost(
        "test/all",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("body", "parameters");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
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
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("query", "myQueryParameter")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
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
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("query2", "myQueryParameter")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
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
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
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
        "{\"x-algolia-api-key\":\"ALGOLIA_API_KEY\"}",
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
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraHeader("x-algolia-api-key", "ALGOLIA_API_KEY")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
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
        "{\"x-algolia-api-key\":\"ALGOLIA_API_KEY\"}",
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
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("isItWorking", true)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
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
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("myParam", 2)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
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
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList("b and c", "d"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"b%20and%20c%2Cd\"}",
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
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList(true, true, false))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"true%2Ctrue%2Cfalse\"}",
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
        "test/requestOptions",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("facet", "filters");
          }
        },
        new RequestOptions().addExtraQueryParameters("myParam", Arrays.asList(1, 2))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/requestOptions", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facet\":\"filters\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"query\":\"parameters\",\"myParam\":\"1%2C2\"}",
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
  void customPutTest() {
    assertDoesNotThrow(() -> {
      client.customPut("test/minimal");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/minimal", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("allow put method for a custom path with all parameters")
  void customPutTest1() {
    assertDoesNotThrow(() -> {
      client.customPut(
        "test/all",
        new HashMap() {
          {
            put("query", "parameters");
          }
        },
        new HashMap() {
          {
            put("body", "parameters");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/test/all", req.path);
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
  @DisplayName("deleteApiKey")
  void deleteApiKeyTest() {
    assertDoesNotThrow(() -> {
      client.deleteApiKey("myTestApiKey");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys/myTestApiKey", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteBy")
  void deleteByTest() {
    assertDoesNotThrow(() -> {
      client.deleteBy("theIndexName", new DeleteByParams().setFilters("brand:brandName"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/deleteByQuery", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"filters\":\"brand:brandName\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("deleteIndex")
  void deleteIndexTest() {
    assertDoesNotThrow(() -> {
      client.deleteIndex("theIndexName");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteObject")
  void deleteObjectTest() {
    assertDoesNotThrow(() -> {
      client.deleteObject("<YOUR_INDEX_NAME>", "uniqueID");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/uniqueID", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("delete rule simple case")
  void deleteRuleTest() {
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
  @DisplayName("deleteSource")
  void deleteSourceTest() {
    assertDoesNotThrow(() -> {
      client.deleteSource("theSource");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/security/sources/theSource", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("deleteSynonym")
  void deleteSynonymTest() {
    assertDoesNotThrow(() -> {
      client.deleteSynonym("indexName", "id1");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/synonyms/id1", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getApiKey")
  void getApiKeyTest() {
    assertDoesNotThrow(() -> {
      client.getApiKey("myTestApiKey");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys/myTestApiKey", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getAppTask")
  void getAppTaskTest() {
    assertDoesNotThrow(() -> {
      client.getAppTask(123L);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/task/123", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("get getDictionaryLanguages")
  void getDictionaryLanguagesTest() {
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
  void getDictionarySettingsTest() {
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
  void getLogsTest() {
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
      client.getLogs(5, 10, "theIndexName", LogType.ALL);
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
  @DisplayName("getObject")
  void getObjectTest() {
    assertDoesNotThrow(() -> {
      client.getObject("theIndexName", "uniqueID", Arrays.asList("attr1", "attr2"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/uniqueID", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"attributesToRetrieve\":\"attr1%2Cattr2\"}",
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
  @DisplayName("search with a real object")
  void getObjectTest1() {
    assertDoesNotThrow(() -> {
      client.getObject("cts_e2e_browse", "Batman and Robin");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_browse/Batman%20and%20Robin", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getObjects")
  void getObjectsTest() {
    assertDoesNotThrow(() -> {
      client.getObjects(
        new GetObjectsParams()
          .setRequests(
            Arrays.asList(
              new GetObjectsRequest()
                .setAttributesToRetrieve(Arrays.asList("attr1", "attr2"))
                .setObjectID("uniqueID")
                .setIndexName("theIndexName")
            )
          ),
        Hit.class
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
  @DisplayName("getRule")
  void getRuleTest() {
    assertDoesNotThrow(() -> {
      client.getRule("cts_e2e_browse", "qr-1725004648916");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_browse/rules/qr-1725004648916", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getSettings")
  void getSettingsTest() {
    assertDoesNotThrow(() -> {
      client.getSettings("cts_e2e_settings");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_settings/settings", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getSources")
  void getSourcesTest() {
    assertDoesNotThrow(() -> {
      client.getSources();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/security/sources", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getSynonym")
  void getSynonymTest() {
    assertDoesNotThrow(() -> {
      client.getSynonym("indexName", "id1");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/synonyms/id1", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getTask")
  void getTaskTest() {
    assertDoesNotThrow(() -> {
      client.getTask("theIndexName", 123L);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/task/123", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getTopUserIds")
  void getTopUserIdsTest() {
    assertDoesNotThrow(() -> {
      client.getTopUserIds();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping/top", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getUserId")
  void getUserIdTest() {
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
  void hasPendingMappingsTest() {
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
  @DisplayName("listApiKeys")
  void listApiKeysTest() {
    assertDoesNotThrow(() -> {
      client.listApiKeys();
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("listClusters")
  void listClustersTest() {
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
  void listIndicesTest() {
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
  void listUserIdsTest() {
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
  @DisplayName("multipleBatch")
  void multipleBatchTest() {
    assertDoesNotThrow(() -> {
      client.multipleBatch(
        new BatchParams()
          .setRequests(
            Arrays.asList(
              new MultipleBatchRequest()
                .setAction(Action.ADD_OBJECT)
                .setBody(
                  new HashMap() {
                    {
                      put("key", "value");
                    }
                  }
                )
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
  @DisplayName("scopes")
  void operationIndexTest() {
    assertDoesNotThrow(() -> {
      client.operationIndex(
        "<SOURCE_INDEX_NAME>",
        new OperationIndexParams()
          .setOperation(OperationType.MOVE)
          .setDestination("<DESTINATION_INDEX_NAME>")
          .setScope(Arrays.asList(ScopeType.RULES, ScopeType.SETTINGS))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CSOURCE_INDEX_NAME%3E/operation", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"operation\":\"move\",\"destination\":\"<DESTINATION_INDEX_NAME>\",\"scope\":[\"rules\",\"settings\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("copy")
  void operationIndexTest1() {
    assertDoesNotThrow(() -> {
      client.operationIndex(
        "<SOURCE_INDEX_NAME>",
        new OperationIndexParams().setOperation(OperationType.COPY).setDestination("<DESTINATION_INDEX_NAME>")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CSOURCE_INDEX_NAME%3E/operation", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"operation\":\"copy\",\"destination\":\"<DESTINATION_INDEX_NAME>\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("move")
  void operationIndexTest2() {
    assertDoesNotThrow(() -> {
      client.operationIndex(
        "<SOURCE_INDEX_NAME>",
        new OperationIndexParams().setOperation(OperationType.MOVE).setDestination("<DESTINATION_INDEX_NAME>")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CSOURCE_INDEX_NAME%3E/operation", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"operation\":\"move\",\"destination\":\"<DESTINATION_INDEX_NAME>\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("Partial update with a new value for a string attribute")
  void partialUpdateObjectTest() {
    assertDoesNotThrow(() -> {
      client.partialUpdateObject(
        "theIndexName",
        "uniqueID",
        new HashMap() {
          {
            put("attributeId", "new value");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/uniqueID/partial", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributeId\":\"new value\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("Partial update with a new value for an integer attribute")
  void partialUpdateObjectTest1() {
    assertDoesNotThrow(() -> {
      client.partialUpdateObject(
        "theIndexName",
        "uniqueID",
        new HashMap() {
          {
            put("attributeId", 1);
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/uniqueID/partial", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributeId\":1}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("Partial update with a new value for a boolean attribute")
  void partialUpdateObjectTest2() {
    assertDoesNotThrow(() -> {
      client.partialUpdateObject(
        "theIndexName",
        "uniqueID",
        new HashMap() {
          {
            put("attributeId", true);
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/uniqueID/partial", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributeId\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("Partial update with a new value for an array attribute")
  void partialUpdateObjectTest3() {
    assertDoesNotThrow(() -> {
      client.partialUpdateObject(
        "theIndexName",
        "uniqueID",
        new HashMap() {
          {
            put("attributeId", Arrays.asList("one", "two", "three"));
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/uniqueID/partial", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributeId\":[\"one\",\"two\",\"three\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("Partial update with a new value for an object attribute")
  void partialUpdateObjectTest4() {
    assertDoesNotThrow(() -> {
      client.partialUpdateObject(
        "theIndexName",
        "uniqueID",
        new HashMap() {
          {
            put(
              "attributeId",
              new HashMap() {
                {
                  put("nested", "value");
                }
              }
            );
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/uniqueID/partial", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributeId\":{\"nested\":\"value\"}}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("removeUserId")
  void removeUserIdTest() {
    assertDoesNotThrow(() -> {
      client.removeUserId("uniqueID");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping/uniqueID", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("replaceSources")
  void replaceSourcesTest() {
    assertDoesNotThrow(() -> {
      client.replaceSources(Arrays.asList(new Source().setSource("theSource").setDescription("theDescription")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/security/sources", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("[{\"source\":\"theSource\",\"description\":\"theDescription\"}]", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("restoreApiKey")
  void restoreApiKeyTest() {
    assertDoesNotThrow(() -> {
      client.restoreApiKey("ALGOLIA_API_KEY");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys/ALGOLIA_API_KEY/restore", req.path);
    assertEquals("POST", req.method);
    assertEquals("{}", req.body);
  }

  @Test
  @DisplayName("saveObject")
  void saveObjectTest() {
    assertDoesNotThrow(() -> {
      client.saveObject(
        "<YOUR_INDEX_NAME>",
        new HashMap() {
          {
            put("objectID", "id");
            put("test", "val");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"objectID\":\"id\",\"test\":\"val\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("saveRule with minimal parameters")
  void saveRuleTest() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "id1",
        new Rule().setObjectID("id1").setConditions(Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS)))
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
            Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS).setAlternatives(false).setContext("search"))
          )
          .setConsequence(
            new Consequence()
              .setParams(
                new ConsequenceParams()
                  .setFilters("brand:apple")
                  .setQuery(
                    new ConsequenceQueryObject()
                      .setRemove(Arrays.asList("algolia"))
                      .setEdits(
                        Arrays.asList(
                          new Edit().setType(EditType.REMOVE).setDelete("abc").setInsert("cde"),
                          new Edit().setType(EditType.REPLACE).setDelete("abc").setInsert("cde")
                        )
                      )
                  )
              )
              .setHide(Arrays.asList(new ConsequenceHide().setObjectID("321")))
              .setFilterPromotes(false)
              .setUserData(
                new HashMap() {
                  {
                    put("algolia", "aloglia");
                  }
                }
              )
              .setPromote(
                Arrays.asList(
                  new PromoteObjectID().setObjectID("abc").setPosition(3),
                  new PromoteObjectIDs().setObjectIDs(Arrays.asList("abc", "def")).setPosition(1)
                )
              )
          )
          .setDescription("test")
          .setEnabled(true)
          .setValidity(Arrays.asList(new TimeRange().setFrom(1656670273L).setUntil(1656670277L))),
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
  void saveRulesTest() {
    assertDoesNotThrow(() -> {
      client.saveRules(
        "<YOUR_INDEX_NAME>",
        Arrays.asList(
          new Rule()
            .setObjectID("a-rule-id")
            .setConditions(Arrays.asList(new Condition().setPattern("smartphone").setAnchoring(Anchoring.CONTAINS))),
          new Rule()
            .setObjectID("a-second-rule-id")
            .setConditions(Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS)))
        ),
        false,
        true
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/rules/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "[{\"objectID\":\"a-rule-id\",\"conditions\":[{\"pattern\":\"smartphone\",\"anchoring\":\"contains\"}]},{\"objectID\":\"a-second-rule-id\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}]}]",
        req.body,
        JSONCompareMode.STRICT
      )
    );

    try {
      Map<String, String> expectedQuery = json.readValue(
        "{\"forwardToReplicas\":\"false\",\"clearExistingRules\":\"true\"}",
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
  @DisplayName("saveRules with all parameters")
  void saveRulesTest1() {
    assertDoesNotThrow(() -> {
      client.saveRules(
        "<YOUR_INDEX_NAME>",
        Arrays.asList(
          new Rule()
            .setObjectID("id1")
            .setConditions(
              Arrays.asList(
                new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS).setAlternatives(false).setContext("search")
              )
            )
            .setConsequence(
              new Consequence()
                .setParams(
                  new ConsequenceParams()
                    .setFilters("brand:apple")
                    .setQuery(
                      new ConsequenceQueryObject()
                        .setRemove(Arrays.asList("algolia"))
                        .setEdits(
                          Arrays.asList(
                            new Edit().setType(EditType.REMOVE).setDelete("abc").setInsert("cde"),
                            new Edit().setType(EditType.REPLACE).setDelete("abc").setInsert("cde")
                          )
                        )
                    )
                )
                .setHide(Arrays.asList(new ConsequenceHide().setObjectID("321")))
                .setFilterPromotes(false)
                .setUserData(
                  new HashMap() {
                    {
                      put("algolia", "aloglia");
                    }
                  }
                )
                .setPromote(
                  Arrays.asList(
                    new PromoteObjectID().setObjectID("abc").setPosition(3),
                    new PromoteObjectIDs().setObjectIDs(Arrays.asList("abc", "def")).setPosition(1)
                  )
                )
            )
            .setDescription("test")
            .setEnabled(true)
            .setValidity(Arrays.asList(new TimeRange().setFrom(1656670273L).setUntil(1656670277L)))
        ),
        true,
        true
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/rules/batch", req.path);
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
  @DisplayName("saveSynonym")
  void saveSynonymTest() {
    assertDoesNotThrow(() -> {
      client.saveSynonym(
        "indexName",
        "id1",
        new SynonymHit().setObjectID("id1").setType(SynonymType.SYNONYM).setSynonyms(Arrays.asList("car", "vehicule", "auto")),
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
  @DisplayName("saveSynonyms")
  void saveSynonymsTest() {
    assertDoesNotThrow(() -> {
      client.saveSynonyms(
        "<YOUR_INDEX_NAME>",
        Arrays.asList(
          new SynonymHit().setObjectID("id1").setType(SynonymType.SYNONYM).setSynonyms(Arrays.asList("car", "vehicule", "auto")),
          new SynonymHit()
            .setObjectID("id2")
            .setType(SynonymType.ONEWAYSYNONYM)
            .setInput("iphone")
            .setSynonyms(Arrays.asList("ephone", "aphone", "yphone"))
        ),
        true,
        true
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/synonyms/batch", req.path);
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
        "{\"forwardToReplicas\":\"true\",\"replaceExistingSynonyms\":\"true\"}",
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
  @DisplayName("withHitsPerPage")
  void searchTest() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setHitsPerPage(50))),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"<YOUR_INDEX_NAME>\",\"query\":\"<YOUR_QUERY>\",\"hitsPerPage\":50}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("filterOnly")
  void searchTest1() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFilters("actor:Scarlett Johansson")
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"<YOUR_INDEX_NAME>\",\"query\":\"<YOUR_QUERY>\",\"filters\":\"actor:Scarlett" + " Johansson\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("filterOr")
  void searchTest2() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForHits()
                .setIndexName("<YOUR_INDEX_NAME>")
                .setQuery("<YOUR_QUERY>")
                .setFilters("actor:Tom Cruise OR actor:Scarlett Johansson")
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"<YOUR_INDEX_NAME>\",\"query\":\"<YOUR_QUERY>\",\"filters\":\"actor:Tom" +
        " Cruise OR actor:Scarlett Johansson\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("filterNot")
  void searchTest3() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFilters("NOT actor:Nicolas Cage")
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"<YOUR_INDEX_NAME>\",\"query\":\"<YOUR_QUERY>\",\"filters\":\"NOT" + " actor:Nicolas Cage\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search for a single hits request with minimal parameters")
  void searchTest4() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams().setRequests(Arrays.asList(new SearchForHits().setIndexName("cts_e2e_search_empty_index"))),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"requests\":[{\"indexName\":\"cts_e2e_search_empty_index\"}]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("search with highlight and snippet results")
  void searchTest5() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForHits()
                .setIndexName("cts_e2e_highlight_snippet_results")
                .setQuery("vim")
                .setAttributesToSnippet(Arrays.asList("*:20"))
                .setAttributesToHighlight(Arrays.asList("*"))
                .setAttributesToRetrieve(Arrays.asList("*"))
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"cts_e2e_highlight_snippet_results\",\"query\":\"vim\",\"attributesToSnippet\":[\"*:20\"],\"attributesToHighlight\":[\"*\"],\"attributesToRetrieve\":[\"*\"]}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("retrieveFacets")
  void searchTest6() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFacets(Arrays.asList("author", "genre"))
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"<YOUR_INDEX_NAME>\",\"query\":\"<YOUR_QUERY>\",\"facets\":[\"author\",\"genre\"]}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("retrieveFacetsWildcard")
  void searchTest7() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFacets(Arrays.asList("*")))
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"<YOUR_INDEX_NAME>\",\"query\":\"<YOUR_QUERY>\",\"facets\":[\"*\"]}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search for a single facet request with minimal parameters")
  void searchTest8() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(new SearchForFacets().setIndexName("cts_e2e_search_facet").setType(SearchTypeFacet.FACET).setFacet("editor"))
          )
          .setStrategy(SearchStrategy.STOP_IF_ENOUGH_MATCHES),
        Hit.class
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
  }

  @Test
  @DisplayName("search for a single hits request with all parameters")
  void searchTest9() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForHits().setIndexName("theIndexName").setQuery("myQuery").setHitsPerPage(50).setType(SearchTypeDefault.DEFAULT)
            )
          ),
        Hit.class
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
  void searchTest10() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForFacets()
                .setIndexName("theIndexName")
                .setType(SearchTypeFacet.FACET)
                .setFacet("theFacet")
                .setFacetQuery("theFacetQuery")
                .setQuery("theQuery")
                .setMaxFacetHits(50)
            )
          )
          .setStrategy(SearchStrategy.STOP_IF_ENOUGH_MATCHES),
        Hit.class
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
  void searchTest11() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForHits().setIndexName("theIndexName"),
              new SearchForFacets().setIndexName("theIndexName2").setType(SearchTypeFacet.FACET).setFacet("theFacet"),
              new SearchForHits().setIndexName("theIndexName").setType(SearchTypeDefault.DEFAULT)
            )
          )
          .setStrategy(SearchStrategy.STOP_IF_ENOUGH_MATCHES),
        Hit.class
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
  void searchTest12() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForFacets()
                .setIndexName("theIndexName")
                .setType(SearchTypeFacet.FACET)
                .setFacet("theFacet")
                .setFacetQuery("theFacetQuery")
                .setQuery("theQuery")
                .setMaxFacetHits(50),
              new SearchForHits().setIndexName("theIndexName").setQuery("myQuery").setHitsPerPage(50).setType(SearchTypeDefault.DEFAULT)
            )
          )
          .setStrategy(SearchStrategy.STOP_IF_ENOUGH_MATCHES),
        Hit.class
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
  void searchTest13() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
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
                  FacetFilters.of(
                    Arrays.asList(
                      FacetFilters.of("mySearch:filters"),
                      FacetFilters.of(
                        Arrays.asList(
                          FacetFilters.of("mySearch:filters"),
                          FacetFilters.of(Arrays.asList(FacetFilters.of("mySearch:filters")))
                        )
                      )
                    )
                  )
                )
                .setReRankingApplyFilter(
                  ReRankingApplyFilter.of(
                    Arrays.asList(
                      ReRankingApplyFilter.of("mySearch:filters"),
                      ReRankingApplyFilter.of(Arrays.asList(ReRankingApplyFilter.of("mySearch:filters")))
                    )
                  )
                )
                .setTagFilters(
                  TagFilters.of(
                    Arrays.asList(TagFilters.of("mySearch:filters"), TagFilters.of(Arrays.asList(TagFilters.of("mySearch:filters"))))
                  )
                )
                .setNumericFilters(
                  NumericFilters.of(
                    Arrays.asList(
                      NumericFilters.of("mySearch:filters"),
                      NumericFilters.of(Arrays.asList(NumericFilters.of("mySearch:filters")))
                    )
                  )
                )
                .setOptionalFilters(
                  OptionalFilters.of(
                    Arrays.asList(
                      OptionalFilters.of("mySearch:filters"),
                      OptionalFilters.of(Arrays.asList(OptionalFilters.of("mySearch:filters")))
                    )
                  )
                )
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"theIndexName\",\"facetFilters\":\"mySearch:filters\",\"reRankingApplyFilter\":\"mySearch:filters\",\"tagFilters\":\"mySearch:filters\",\"numericFilters\":\"mySearch:filters\",\"optionalFilters\":\"mySearch:filters\"},{\"indexName\":\"theIndexName\",\"facetFilters\":[\"mySearch:filters\",[\"mySearch:filters\",[\"mySearch:filters\"]]],\"reRankingApplyFilter\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"tagFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"numericFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]],\"optionalFilters\":[\"mySearch:filters\",[\"mySearch:filters\"]]}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search filters end to end")
  void searchTest14() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForHits().setIndexName("cts_e2e_search_facet").setFilters("editor:'visual studio' OR editor:neovim"),
              new SearchForHits()
                .setIndexName("cts_e2e_search_facet")
                .setFacetFilters(
                  FacetFilters.of(Arrays.asList(FacetFilters.of("editor:'visual studio'"), FacetFilters.of("editor:neovim")))
                ),
              new SearchForHits()
                .setIndexName("cts_e2e_search_facet")
                .setFacetFilters(
                  FacetFilters.of(
                    Arrays.asList(
                      FacetFilters.of("editor:'visual studio'"),
                      FacetFilters.of(Arrays.asList(FacetFilters.of("editor:neovim")))
                    )
                  )
                ),
              new SearchForHits()
                .setIndexName("cts_e2e_search_facet")
                .setFacetFilters(
                  FacetFilters.of(
                    Arrays.asList(
                      FacetFilters.of("editor:'visual studio'"),
                      FacetFilters.of(
                        Arrays.asList(FacetFilters.of("editor:neovim"), FacetFilters.of(Arrays.asList(FacetFilters.of("editor:goland"))))
                      )
                    )
                  )
                )
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"cts_e2e_search_facet\",\"filters\":\"editor:'visual" +
        " studio' OR" +
        " editor:neovim\"},{\"indexName\":\"cts_e2e_search_facet\",\"facetFilters\":[\"editor:'visual" +
        " studio'\",\"editor:neovim\"]},{\"indexName\":\"cts_e2e_search_facet\",\"facetFilters\":[\"editor:'visual" +
        " studio'\",[\"editor:neovim\"]]},{\"indexName\":\"cts_e2e_search_facet\",\"facetFilters\":[\"editor:'visual" +
        " studio'\",[\"editor:neovim\",[\"editor:goland\"]]]}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search with all search parameters")
  void searchTest15() {
    assertDoesNotThrow(() -> {
      client.search(
        new SearchMethodParams()
          .setRequests(
            Arrays.asList(
              new SearchForHits()
                .setAdvancedSyntax(true)
                .setAdvancedSyntaxFeatures(Arrays.asList(AdvancedSyntaxFeatures.EXACT_PHRASE))
                .setAllowTyposOnNumericTokens(true)
                .setAlternativesAsExact(Arrays.asList(AlternativesAsExact.MULTI_WORDS_SYNONYM))
                .setAnalytics(true)
                .setAnalyticsTags(Arrays.asList(""))
                .setAroundLatLng("")
                .setAroundLatLngViaIP(true)
                .setAroundPrecision(AroundPrecision.of(0))
                .setAroundRadius(AroundRadiusAll.ALL)
                .setAttributeCriteriaComputedByMinProximity(true)
                .setAttributesToHighlight(Arrays.asList(""))
                .setAttributesToRetrieve(Arrays.asList(""))
                .setAttributesToSnippet(Arrays.asList(""))
                .setClickAnalytics(true)
                .setCustomRanking(Arrays.asList(""))
                .setDecompoundQuery(true)
                .setDisableExactOnAttributes(Arrays.asList(""))
                .setDisableTypoToleranceOnAttributes(Arrays.asList(""))
                .setDistinct(Distinct.of(0))
                .setEnableABTest(true)
                .setEnablePersonalization(true)
                .setEnableReRanking(true)
                .setEnableRules(true)
                .setExactOnSingleWordQuery(ExactOnSingleWordQuery.ATTRIBUTE)
                .setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of(""))))
                .setFacetingAfterDistinct(true)
                .setFacets(Arrays.asList(""))
                .setFilters("")
                .setGetRankingInfo(true)
                .setHighlightPostTag("")
                .setHighlightPreTag("")
                .setHitsPerPage(1)
                .setIgnorePlurals(IgnorePlurals.of(false))
                .setIndexName("theIndexName")
                .setInsideBoundingBox(
                  InsideBoundingBox.of(
                    Arrays.asList(Arrays.asList(47.3165, 4.9665, 47.3424, 5.0201), Arrays.asList(40.9234, 2.1185, 38.643, 1.9916))
                  )
                )
                .setInsidePolygon(
                  Arrays.asList(
                    Arrays.asList(47.3165, 4.9665, 47.3424, 5.0201, 47.32, 4.9),
                    Arrays.asList(40.9234, 2.1185, 38.643, 1.9916, 39.2587, 2.0104)
                  )
                )
                .setKeepDiacriticsOnCharacters("")
                .setLength(1)
                .setMaxValuesPerFacet(0)
                .setMinProximity(1)
                .setMinWordSizefor1Typo(0)
                .setMinWordSizefor2Typos(0)
                .setMinimumAroundRadius(1)
                .setNaturalLanguages(Arrays.asList(SupportedLanguage.FR))
                .setNumericFilters(NumericFilters.of(Arrays.asList(NumericFilters.of(""))))
                .setOffset(0)
                .setOptionalFilters(OptionalFilters.of(Arrays.asList(OptionalFilters.of(""))))
                .setOptionalWords(OptionalWords.of(Arrays.asList("")))
                .setPage(0)
                .setPercentileComputation(true)
                .setPersonalizationImpact(0)
                .setQuery("")
                .setQueryLanguages(Arrays.asList(SupportedLanguage.FR))
                .setQueryType(QueryType.PREFIX_ALL)
                .setRanking(Arrays.asList(""))
                .setReRankingApplyFilter(ReRankingApplyFilter.of(Arrays.asList(ReRankingApplyFilter.of(""))))
                .setRelevancyStrictness(0)
                .setRemoveStopWords(RemoveStopWords.of(true))
                .setRemoveWordsIfNoResults(RemoveWordsIfNoResults.ALL_OPTIONAL)
                .setRenderingContent(
                  new RenderingContent()
                    .setFacetOrdering(
                      new FacetOrdering()
                        .setFacets(new Facets().setOrder(Arrays.asList("a", "b")))
                        .setValues(
                          new HashMap() {
                            {
                              put("a", new Value().setOrder(Arrays.asList("b")).setSortRemainingBy(SortRemainingBy.COUNT));
                            }
                          }
                        )
                    )
                )
                .setReplaceSynonymsInHighlight(true)
                .setResponseFields(Arrays.asList(""))
                .setRestrictHighlightAndSnippetArrays(true)
                .setRestrictSearchableAttributes(Arrays.asList(""))
                .setRuleContexts(Arrays.asList(""))
                .setSimilarQuery("")
                .setSnippetEllipsisText("")
                .setSortFacetValuesBy("")
                .setSumOrFiltersScores(true)
                .setSynonyms(true)
                .setTagFilters(TagFilters.of(Arrays.asList(TagFilters.of(""))))
                .setType(SearchTypeDefault.DEFAULT)
                .setTypoTolerance(TypoToleranceEnum.MIN)
                .setUserToken("")
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/queries", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"exactPhrase\"],\"allowTyposOnNumericTokens\":true,\"alternativesAsExact\":[\"multiWordsSynonym\"],\"analytics\":true,\"analyticsTags\":[\"\"],\"aroundLatLng\":\"\",\"aroundLatLngViaIP\":true,\"aroundPrecision\":0,\"aroundRadius\":\"all\",\"attributeCriteriaComputedByMinProximity\":true,\"attributesToHighlight\":[\"\"],\"attributesToRetrieve\":[\"\"],\"attributesToSnippet\":[\"\"],\"clickAnalytics\":true,\"customRanking\":[\"\"],\"decompoundQuery\":true,\"disableExactOnAttributes\":[\"\"],\"disableTypoToleranceOnAttributes\":[\"\"],\"distinct\":0,\"enableABTest\":true,\"enablePersonalization\":true,\"enableReRanking\":true,\"enableRules\":true,\"exactOnSingleWordQuery\":\"attribute\",\"facetFilters\":[\"\"],\"facetingAfterDistinct\":true,\"facets\":[\"\"],\"filters\":\"\",\"getRankingInfo\":true,\"highlightPostTag\":\"\",\"highlightPreTag\":\"\",\"hitsPerPage\":1,\"ignorePlurals\":false,\"indexName\":\"theIndexName\",\"insideBoundingBox\":[[47.3165,4.9665,47.3424,5.0201],[40.9234,2.1185,38.643,1.9916]],\"insidePolygon\":[[47.3165,4.9665,47.3424,5.0201,47.32,4.9],[40.9234,2.1185,38.643,1.9916,39.2587,2.0104]],\"keepDiacriticsOnCharacters\":\"\",\"length\":1,\"maxValuesPerFacet\":0,\"minProximity\":1,\"minWordSizefor1Typo\":0,\"minWordSizefor2Typos\":0,\"minimumAroundRadius\":1,\"naturalLanguages\":[\"fr\"],\"numericFilters\":[\"\"],\"offset\":0,\"optionalFilters\":[\"\"],\"optionalWords\":[\"\"],\"page\":0,\"percentileComputation\":true,\"personalizationImpact\":0,\"query\":\"\",\"queryLanguages\":[\"fr\"],\"queryType\":\"prefixAll\",\"ranking\":[\"\"],\"reRankingApplyFilter\":[\"\"],\"relevancyStrictness\":0,\"removeStopWords\":true,\"removeWordsIfNoResults\":\"allOptional\",\"renderingContent\":{\"facetOrdering\":{\"facets\":{\"order\":[\"a\",\"b\"]},\"values\":{\"a\":{\"order\":[\"b\"],\"sortRemainingBy\":\"count\"}}}},\"replaceSynonymsInHighlight\":true,\"responseFields\":[\"\"],\"restrictHighlightAndSnippetArrays\":true,\"restrictSearchableAttributes\":[\"\"],\"ruleContexts\":[\"\"],\"similarQuery\":\"\",\"snippetEllipsisText\":\"\",\"sortFacetValuesBy\":\"\",\"sumOrFiltersScores\":true,\"synonyms\":true,\"tagFilters\":[\"\"],\"type\":\"default\",\"typoTolerance\":\"min\",\"userToken\":\"\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get searchDictionaryEntries results with minimal parameters")
  void searchDictionaryEntriesTest() {
    assertDoesNotThrow(() -> {
      client.searchDictionaryEntries(DictionaryType.STOPWORDS, new SearchDictionaryEntriesParams().setQuery("about"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/dictionaries/stopwords/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"about\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("get searchDictionaryEntries results with all parameters")
  void searchDictionaryEntriesTest1() {
    assertDoesNotThrow(() -> {
      client.searchDictionaryEntries(
        DictionaryType.COMPOUNDS,
        new SearchDictionaryEntriesParams().setQuery("foo").setPage(4).setHitsPerPage(2).setLanguage(SupportedLanguage.FR)
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
  void searchForFacetValuesTest() {
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
  @DisplayName("searchRules")
  void searchRulesTest() {
    assertDoesNotThrow(() -> {
      client.searchRules("cts_e2e_browse", new SearchRulesParams().setQuery("zorro"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_browse/rules/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"zorro\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("search with minimal parameters")
  void searchSingleIndexTest() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", Hit.class);
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
      client.searchSingleIndex("cts_e2e_space in index", Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_space%20in%20index/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("search with searchParams")
  void searchSingleIndexTest2() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("tags:algolia")))),
        Hit.class
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
  @DisplayName("single search retrieve snippets")
  void searchSingleIndexTest3() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "cts_e2e_browse",
        new SearchParamsObject()
          .setQuery("batman mask of the phantasm")
          .setAttributesToRetrieve(Arrays.asList("*"))
          .setAttributesToSnippet(Arrays.asList("*:20")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_browse/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"batman mask of the" + " phantasm\",\"attributesToRetrieve\":[\"*\"],\"attributesToSnippet\":[\"*:20\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchSynonyms with minimal parameters")
  void searchSynonymsTest() {
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
        new SearchSynonymsParams().setQuery("myQuery").setType(SynonymType.ALTCORRECTION_1).setPage(10).setHitsPerPage(10)
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
  @DisplayName("searchUserIds")
  void searchUserIdsTest() {
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
  void setDictionarySettingsTest() {
    assertDoesNotThrow(() -> {
      client.setDictionarySettings(
        new DictionarySettingsParams()
          .setDisableStandardEntries(
            new StandardEntries()
              .setPlurals(
                new HashMap() {
                  {
                    put("fr", false);
                    put("en", false);
                    put("ru", true);
                  }
                }
              )
          )
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
              .setPlurals(
                new HashMap() {
                  {
                    put("fr", false);
                    put("en", false);
                    put("ru", true);
                  }
                }
              )
              .setStopwords(
                new HashMap() {
                  {
                    put("fr", false);
                  }
                }
              )
              .setCompounds(
                new HashMap() {
                  {
                    put("ru", true);
                  }
                }
              )
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
  @DisplayName("setSettingsAttributesForFaceting")
  void setSettingsTest() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "<YOUR_INDEX_NAME>",
        new IndexSettings().setAttributesForFaceting(Arrays.asList("actor", "filterOnly(category)", "searchable(publisher)"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"attributesForFaceting\":[\"actor\",\"filterOnly(category)\",\"searchable(publisher)\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("setSettings with minimal parameters")
  void setSettingsTest1() {
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
  }

  @Test
  @DisplayName("setSettings allow boolean `typoTolerance`")
  void setSettingsTest2() {
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
  void setSettingsTest3() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setTypoTolerance(TypoToleranceEnum.MIN), true);
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
  void setSettingsTest4() {
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
  void setSettingsTest5() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setIgnorePlurals(IgnorePlurals.of(Arrays.asList(SupportedLanguage.FR))), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"ignorePlurals\":[\"fr\"]}", req.body, JSONCompareMode.STRICT));

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
  void setSettingsTest6() {
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
  void setSettingsTest7() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setRemoveStopWords(RemoveStopWords.of(Arrays.asList(SupportedLanguage.FR))),
        true
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"removeStopWords\":[\"fr\"]}", req.body, JSONCompareMode.STRICT));

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
  void setSettingsTest8() {
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
  void setSettingsTest9() {
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
  void setSettingsTest10() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings()
          .setAdvancedSyntax(true)
          .setAdvancedSyntaxFeatures(Arrays.asList(AdvancedSyntaxFeatures.EXACT_PHRASE))
          .setAllowCompressionOfIntegerArray(true)
          .setAllowTyposOnNumericTokens(true)
          .setAlternativesAsExact(Arrays.asList(AlternativesAsExact.SINGLE_WORD_SYNONYM))
          .setAttributeCriteriaComputedByMinProximity(true)
          .setAttributeForDistinct("test")
          .setAttributesForFaceting(Arrays.asList("algolia"))
          .setAttributesToHighlight(Arrays.asList("algolia"))
          .setAttributesToRetrieve(Arrays.asList("algolia"))
          .setAttributesToSnippet(Arrays.asList("algolia"))
          .setAttributesToTransliterate(Arrays.asList("algolia"))
          .setCamelCaseAttributes(Arrays.asList("algolia"))
          .setCustomNormalization(
            new HashMap() {
              {
                put(
                  "algolia",
                  new HashMap() {
                    {
                      put("aloglia", "aglolia");
                    }
                  }
                );
              }
            }
          )
          .setCustomRanking(Arrays.asList("algolia"))
          .setDecompoundQuery(false)
          .setDecompoundedAttributes(
            new HashMap() {
              {
                put("algolia", "aloglia");
              }
            }
          )
          .setDisableExactOnAttributes(Arrays.asList("algolia"))
          .setDisablePrefixOnAttributes(Arrays.asList("algolia"))
          .setDisableTypoToleranceOnAttributes(Arrays.asList("algolia"))
          .setDisableTypoToleranceOnWords(Arrays.asList("algolia"))
          .setDistinct(Distinct.of(3))
          .setEnablePersonalization(true)
          .setEnableReRanking(false)
          .setEnableRules(true)
          .setExactOnSingleWordQuery(ExactOnSingleWordQuery.ATTRIBUTE)
          .setHighlightPreTag("<span>")
          .setHighlightPostTag("</span>")
          .setHitsPerPage(10)
          .setIgnorePlurals(IgnorePlurals.of(false))
          .setIndexLanguages(Arrays.asList(SupportedLanguage.FR))
          .setKeepDiacriticsOnCharacters("abc")
          .setMaxFacetHits(20)
          .setMaxValuesPerFacet(30)
          .setMinProximity(6)
          .setMinWordSizefor1Typo(5)
          .setMinWordSizefor2Typos(11)
          .setMode(Mode.NEURAL_SEARCH)
          .setNumericAttributesForFiltering(Arrays.asList("algolia"))
          .setOptionalWords(OptionalWords.of(Arrays.asList("myspace")))
          .setPaginationLimitedTo(0)
          .setQueryLanguages(Arrays.asList(SupportedLanguage.FR))
          .setQueryType(QueryType.PREFIX_LAST)
          .setRanking(Arrays.asList("geo"))
          .setReRankingApplyFilter(ReRankingApplyFilter.of("mySearch:filters"))
          .setRelevancyStrictness(10)
          .setRemoveStopWords(RemoveStopWords.of(false))
          .setRemoveWordsIfNoResults(RemoveWordsIfNoResults.LAST_WORDS)
          .setRenderingContent(
            new RenderingContent()
              .setFacetOrdering(
                new FacetOrdering()
                  .setFacets(new Facets().setOrder(Arrays.asList("a", "b")))
                  .setValues(
                    new HashMap() {
                      {
                        put("a", new Value().setOrder(Arrays.asList("b")).setSortRemainingBy(SortRemainingBy.COUNT));
                      }
                    }
                  )
              )
          )
          .setReplaceSynonymsInHighlight(true)
          .setReplicas(Arrays.asList(""))
          .setResponseFields(Arrays.asList("algolia"))
          .setRestrictHighlightAndSnippetArrays(true)
          .setSearchableAttributes(Arrays.asList("foo"))
          .setSemanticSearch(new SemanticSearch().setEventSources(Arrays.asList("foo")))
          .setSeparatorsToIndex("bar")
          .setSnippetEllipsisText("---")
          .setSortFacetValuesBy("date")
          .setTypoTolerance(TypoTolerance.of(false))
          .setUnretrievableAttributes(Arrays.asList("foo"))
          .setUserData(
            new HashMap() {
              {
                put("user", "data");
              }
            }
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"exactPhrase\"],\"allowCompressionOfIntegerArray\":true,\"allowTyposOnNumericTokens\":true,\"alternativesAsExact\":[\"singleWordSynonym\"],\"attributeCriteriaComputedByMinProximity\":true,\"attributeForDistinct\":\"test\",\"attributesForFaceting\":[\"algolia\"],\"attributesToHighlight\":[\"algolia\"],\"attributesToRetrieve\":[\"algolia\"],\"attributesToSnippet\":[\"algolia\"],\"attributesToTransliterate\":[\"algolia\"],\"camelCaseAttributes\":[\"algolia\"],\"customNormalization\":{\"algolia\":{\"aloglia\":\"aglolia\"}},\"customRanking\":[\"algolia\"],\"decompoundQuery\":false,\"decompoundedAttributes\":{\"algolia\":\"aloglia\"},\"disableExactOnAttributes\":[\"algolia\"],\"disablePrefixOnAttributes\":[\"algolia\"],\"disableTypoToleranceOnAttributes\":[\"algolia\"],\"disableTypoToleranceOnWords\":[\"algolia\"],\"distinct\":3,\"enablePersonalization\":true,\"enableReRanking\":false,\"enableRules\":true,\"exactOnSingleWordQuery\":\"attribute\",\"highlightPreTag\":\"<span>\",\"highlightPostTag\":\"</span>\",\"hitsPerPage\":10,\"ignorePlurals\":false,\"indexLanguages\":[\"fr\"],\"keepDiacriticsOnCharacters\":\"abc\",\"maxFacetHits\":20,\"maxValuesPerFacet\":30,\"minProximity\":6,\"minWordSizefor1Typo\":5,\"minWordSizefor2Typos\":11,\"mode\":\"neuralSearch\",\"numericAttributesForFiltering\":[\"algolia\"],\"optionalWords\":[\"myspace\"],\"paginationLimitedTo\":0,\"queryLanguages\":[\"fr\"],\"queryType\":\"prefixLast\",\"ranking\":[\"geo\"],\"reRankingApplyFilter\":\"mySearch:filters\",\"relevancyStrictness\":10,\"removeStopWords\":false,\"removeWordsIfNoResults\":\"lastWords\",\"renderingContent\":{\"facetOrdering\":{\"facets\":{\"order\":[\"a\",\"b\"]},\"values\":{\"a\":{\"order\":[\"b\"],\"sortRemainingBy\":\"count\"}}}},\"replaceSynonymsInHighlight\":true,\"replicas\":[\"\"],\"responseFields\":[\"algolia\"],\"restrictHighlightAndSnippetArrays\":true,\"searchableAttributes\":[\"foo\"],\"semanticSearch\":{\"eventSources\":[\"foo\"]},\"separatorsToIndex\":\"bar\",\"snippetEllipsisText\":\"---\",\"sortFacetValuesBy\":\"date\",\"typoTolerance\":false,\"unretrievableAttributes\":[\"foo\"],\"userData\":{\"user\":\"data\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("updateApiKey")
  void updateApiKeyTest() {
    assertDoesNotThrow(() -> {
      client.updateApiKey(
        "ALGOLIA_API_KEY",
        new ApiKey()
          .setAcl(Arrays.asList(Acl.SEARCH, Acl.ADD_OBJECT))
          .setValidity(300)
          .setMaxQueriesPerIPPerHour(100)
          .setMaxHitsPerQuery(20)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys/ALGOLIA_API_KEY", req.path);
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
