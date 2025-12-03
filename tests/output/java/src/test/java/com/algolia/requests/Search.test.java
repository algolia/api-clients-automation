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
    ClientOptions options = ClientOptions.builder()
      .setRequesterConfig(requester -> requester.addInterceptor(echo))
      .build();
    this.client = new SearchClient("appId", "apiKey", options);
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("minimal")
  void addApiKeyTest() {
    assertDoesNotThrow(() -> {
      client.addApiKey(new ApiKey().setAcl(Arrays.asList(Acl.SEARCH, Acl.ADD_OBJECT)).setDescription("my new api key"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/keys", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"acl\":[\"search\",\"addObject\"],\"description\":\"my new api key\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("all")
  void addApiKeyTest1() {
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
  @DisplayName("simple")
  void assignUserIdTest() {
    assertDoesNotThrow(() -> {
      client.assignUserId("user42", new AssignUserIdParams().setCluster("d4242-eu"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/clusters/mapping", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"cluster\":\"d4242-eu\"}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-algolia-user-id\":\"user42\"}",
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
        new BatchWriteParams().setRequests(
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
        new BatchWriteParams().setRequests(
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
        new BatchWriteParams().setRequests(
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
        new BatchWriteParams().setRequests(
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
        new BatchWriteParams().setRequests(
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
        new BatchWriteParams().setRequests(
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
        new BatchWriteParams().setRequests(
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
        new BatchDictionaryEntriesParams().setRequests(
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
  @DisplayName("browse with query string")
  void browseTest3() {
    assertDoesNotThrow(() -> {
      client.browse("indexName", new SearchParamsString().setParams("foo=bar&cursor=test"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/browse", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"params\":\"foo=bar&cursor=test\"}", req.body, JSONCompareMode.STRICT));
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
            put("query", "to be overridden");
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
  @DisplayName("by ID")
  void getObjectsTest() {
    assertDoesNotThrow(() -> {
      client.getObjects(
        new GetObjectsParams().setRequests(Arrays.asList(new GetObjectsRequest().setObjectID("uniqueID").setIndexName("theIndexName"))),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/objects", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"objectID\":\"uniqueID\",\"indexName\":\"theIndexName\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("multiple IDs")
  void getObjectsTest1() {
    assertDoesNotThrow(() -> {
      client.getObjects(
        new GetObjectsParams().setRequests(
          Arrays.asList(
            new GetObjectsRequest().setObjectID("uniqueID1").setIndexName("theIndexName1"),
            new GetObjectsRequest().setObjectID("uniqueID2").setIndexName("theIndexName2")
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
        "{\"requests\":[{\"objectID\":\"uniqueID1\",\"indexName\":\"theIndexName1\"},{\"objectID\":\"uniqueID2\",\"indexName\":\"theIndexName2\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("with attributesToRetrieve")
  void getObjectsTest2() {
    assertDoesNotThrow(() -> {
      client.getObjects(
        new GetObjectsParams().setRequests(
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
      client.getSettings("cts_e2e_settings", 2);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_settings/settings", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);

    try {
      Map<String, String> expectedQuery = json.readValue("{\"getVersion\":\"2\"}", new TypeReference<HashMap<String, String>>() {});
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
        new BatchParams().setRequests(
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
  @DisplayName("with visible_by filter")
  void partialUpdateObjectTest5() {
    assertDoesNotThrow(() -> {
      client.partialUpdateObject(
        "theIndexName",
        "uniqueID",
        new HashMap() {
          {
            put("visible_by", Arrays.asList("Angela", "group/Finance", "group/Shareholders"));
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/uniqueID/partial", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"visible_by\":[\"Angela\",\"group/Finance\",\"group/Shareholders\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("add men pant")
  void partialUpdateObjectTest6() {
    assertDoesNotThrow(() -> {
      client.partialUpdateObject(
        "theIndexName",
        "productId",
        new HashMap() {
          {
            put(
              "categoryPageId",
              new HashMap() {
                {
                  put("_operation", "Add");
                  put("value", "men-clothing-pants");
                }
              }
            );
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/productId/partial", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"categoryPageId\":{\"_operation\":\"Add\",\"value\":\"men-clothing-pants\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("remove men pant")
  void partialUpdateObjectTest7() {
    assertDoesNotThrow(() -> {
      client.partialUpdateObject(
        "theIndexName",
        "productId",
        new HashMap() {
          {
            put(
              "categoryPageId",
              new HashMap() {
                {
                  put("_operation", "Remove");
                  put("value", "men-clothing-pants");
                }
              }
            );
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/productId/partial", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"categoryPageId\":{\"_operation\":\"Remove\",\"value\":\"men-clothing-pants\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
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
            put("name", "Black T-shirt");
            put("color", "#000000||black");
            put("availableIn", "https://source.unsplash.com/100x100/?paris||Paris");
            put("objectID", "myID");
          }
        }
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"name\":\"Black" +
          " T-shirt\",\"color\":\"#000000||black\",\"availableIn\":\"https://source.unsplash.com/100x100/?paris||Paris\",\"objectID\":\"myID\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("saveRule with minimal parameters")
  void saveRuleTest() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "id1",
        new Rule()
          .setObjectID("id1")
          .setConditions(Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(new Consequence().setParams(new ConsequenceParams().setFilters("brand:xiaomi")))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/id1", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:xiaomi\"}}}",
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
  @DisplayName("b2b catalog")
  void saveRuleTest2() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "article-rule",
        new Rule()
          .setObjectID("article-rule")
          .setConditions(Arrays.asList(new Condition().setPattern("article").setAnchoring(Anchoring.STARTS_WITH)))
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams()
                .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("article"))))
                .setRestrictSearchableAttributes(Arrays.asList("title", "book_id"))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/article-rule", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"article-rule\",\"conditions\":[{\"pattern\":\"article\",\"anchoring\":\"startsWith\"}],\"consequence\":{\"params\":{\"query\":{\"edits\":[{\"type\":\"remove\",\"delete\":\"article\"}]},\"restrictSearchableAttributes\":[\"title\",\"book_id\"]}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("merchandising and promoting")
  void saveRuleTest3() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "director-rule",
        new Rule()
          .setObjectID("director-rule")
          .setConditions(Arrays.asList(new Condition().setPattern("{facet:director} director").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams()
                .setRestrictSearchableAttributes(Arrays.asList("title", "book_id"))
                .setAutomaticFacetFilters(
                  AutomaticFacetFilters.ofListOfAutomaticFacetFilter(Arrays.asList(new AutomaticFacetFilter().setFacet("director")))
                )
                .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("director"))))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/director-rule", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"director-rule\",\"conditions\":[{\"pattern\":\"{facet:director}" +
          " director\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"restrictSearchableAttributes\":[\"title\",\"book_id\"],\"automaticFacetFilters\":[{\"facet\":\"director\"}],\"query\":{\"edits\":[{\"type\":\"remove\",\"delete\":\"director\"}]}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("harry potter")
  void saveRuleTest4() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "harry-potter-rule",
        new Rule()
          .setObjectID("harry-potter-rule")
          .setConditions(Arrays.asList(new Condition().setPattern("harry potter").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(
            new Consequence().setUserData(
              new HashMap() {
                {
                  put("promo_content", "20% OFF on all Harry Potter books!");
                }
              }
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/harry-potter-rule", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"harry-potter-rule\",\"conditions\":[{\"pattern\":\"harry" +
          " potter\",\"anchoring\":\"contains\"}],\"consequence\":{\"userData\":{\"promo_content\":\"20%" +
          " OFF on all Harry Potter books!\"}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("merchandising empty query")
  void saveRuleTest5() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "clearance-category-filter",
        new Rule()
          .setObjectID("clearance-category-filter")
          .setConditions(Arrays.asList(new Condition().setPattern("").setAnchoring(Anchoring.IS).setContext("landing")))
          .setConsequence(new Consequence().setParams(new ConsequenceParams().setOptionalFilters(OptionalFilters.of("clearance:true"))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/clearance-category-filter", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"clearance-category-filter\",\"conditions\":[{\"pattern\":\"\",\"anchoring\":\"is\",\"context\":\"landing\"}],\"consequence\":{\"params\":{\"optionalFilters\":\"clearance:true\"}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("redirect")
  void saveRuleTest6() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "redirect-help-rule",
        new Rule()
          .setObjectID("redirect-help-rule")
          .setConditions(Arrays.asList(new Condition().setPattern("help").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(
            new Consequence().setUserData(
              new HashMap() {
                {
                  put("redirect", "https://www.algolia.com/support");
                }
              }
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/redirect-help-rule", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"redirect-help-rule\",\"conditions\":[{\"pattern\":\"help\",\"anchoring\":\"contains\"}],\"consequence\":{\"userData\":{\"redirect\":\"https://www.algolia.com/support\"}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("promote some results over others")
  void saveRuleTest7() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "tomato-fruit",
        new Rule()
          .setObjectID("tomato-fruit")
          .setConditions(Arrays.asList(new Condition().setPattern("tomato").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(new Consequence().setParams(new ConsequenceParams().setOptionalFilters(OptionalFilters.of("food_group:fruit"))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/tomato-fruit", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"tomato-fruit\",\"conditions\":[{\"pattern\":\"tomato\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"optionalFilters\":\"food_group:fruit\"}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("promote several hits")
  void saveRuleTest8() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "Promote-Apple-Newest",
        new Rule()
          .setObjectID("Promote-Apple-Newest")
          .setConditions(Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.IS)))
          .setConsequence(
            new Consequence().setPromote(
              Arrays.asList(new PromoteObjectIDs().setObjectIDs(Arrays.asList("iPhone-12345", "watch-123")).setPosition(0))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/Promote-Apple-Newest", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"Promote-Apple-Newest\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"is\"}],\"consequence\":{\"promote\":[{\"objectIDs\":[\"iPhone-12345\",\"watch-123\"],\"position\":0}]}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("promote newest release")
  void saveRuleTest9() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "Promote-iPhone-X",
        new Rule()
          .setObjectID("Promote-iPhone-X")
          .setConditions(Arrays.asList(new Condition().setPattern("iPhone").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(new Consequence().setPromote(Arrays.asList(new PromoteObjectID().setObjectID("iPhone-12345").setPosition(0))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/Promote-iPhone-X", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"Promote-iPhone-X\",\"conditions\":[{\"pattern\":\"iPhone\",\"anchoring\":\"contains\"}],\"consequence\":{\"promote\":[{\"objectID\":\"iPhone-12345\",\"position\":0}]}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("promote single item")
  void saveRuleTest10() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "promote-harry-potter-box-set",
        new Rule()
          .setObjectID("promote-harry-potter-box-set")
          .setConditions(Arrays.asList(new Condition().setPattern("Harry Potter").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(new Consequence().setPromote(Arrays.asList(new PromoteObjectID().setObjectID("HP-12345").setPosition(0))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/promote-harry-potter-box-set", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"promote-harry-potter-box-set\",\"conditions\":[{\"pattern\":\"Harry" +
          " Potter\",\"anchoring\":\"contains\"}],\"consequence\":{\"promote\":[{\"objectID\":\"HP-12345\",\"position\":0}]}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("limit search results")
  void saveRuleTest11() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "article-rule",
        new Rule()
          .setObjectID("article-rule")
          .setConditions(Arrays.asList(new Condition().setPattern("article").setAnchoring(Anchoring.STARTS_WITH)))
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams()
                .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("article"))))
                .setRestrictSearchableAttributes(Arrays.asList("title", "book_id"))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/article-rule", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"article-rule\",\"conditions\":[{\"pattern\":\"article\",\"anchoring\":\"startsWith\"}],\"consequence\":{\"params\":{\"query\":{\"edits\":[{\"type\":\"remove\",\"delete\":\"article\"}]},\"restrictSearchableAttributes\":[\"title\",\"book_id\"]}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("query match")
  void saveRuleTest12() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "tagged-brand-rule",
        new Rule()
          .setConditions(
            Arrays.asList(new Condition().setPattern("brand: {facet:brand}").setAnchoring(Anchoring.CONTAINS).setAlternatives(false))
          )
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams()
                .setAutomaticFacetFilters(
                  AutomaticFacetFilters.ofListOfAutomaticFacetFilter(Arrays.asList(new AutomaticFacetFilter().setFacet("brand")))
                )
                .setQuery(new ConsequenceQueryObject().setRemove(Arrays.asList("brand:", "{facet:brand}")))
            )
          )
          .setDescription("filter on brand: {brand}")
          .setObjectID("tagged-brand-rule")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/tagged-brand-rule", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"conditions\":[{\"pattern\":\"brand:" +
          " {facet:brand}\",\"anchoring\":\"contains\",\"alternatives\":false}],\"consequence\":{\"params\":{\"automaticFacetFilters\":[{\"facet\":\"brand\"}],\"query\":{\"remove\":[\"brand:\",\"{facet:brand}\"]}}},\"description\":\"filter" +
          " on brand: {brand}\",\"objectID\":\"tagged-brand-rule\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("dynamic filtering")
  void saveRuleTest13() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "color-facets",
        new Rule()
          .setObjectID("color-facets")
          .setConditions(Arrays.asList(new Condition().setPattern("{facet:color}")))
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams().setAutomaticFacetFilters(
                AutomaticFacetFilters.ofListOfAutomaticFacetFilter(Arrays.asList(new AutomaticFacetFilter().setFacet("color")))
              )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/color-facets", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"color-facets\",\"conditions\":[{\"pattern\":\"{facet:color}\"}],\"consequence\":{\"params\":{\"automaticFacetFilters\":[{\"facet\":\"color\"}]}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("hide hits")
  void saveRuleTest14() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "hide-12345",
        new Rule()
          .setObjectID("hide-12345")
          .setConditions(Arrays.asList(new Condition().setPattern("cheap").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(new Consequence().setHide(Arrays.asList(new ConsequenceHide().setObjectID("to-hide-12345"))))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/hide-12345", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"hide-12345\",\"conditions\":[{\"pattern\":\"cheap\",\"anchoring\":\"contains\"}],\"consequence\":{\"hide\":[{\"objectID\":\"to-hide-12345\"}]}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("one rule per facet")
  void saveRuleTest15() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "red-color",
        new Rule()
          .setObjectID("red-color")
          .setConditions(Arrays.asList(new Condition().setPattern("red").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams().setQuery(new ConsequenceQueryObject().setRemove(Arrays.asList("red"))).setFilters("color:red")
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/red-color", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"red-color\",\"conditions\":[{\"pattern\":\"red\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"query\":{\"remove\":[\"red\"]},\"filters\":\"color:red\"}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("numerical filters")
  void saveRuleTest16() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "cheap",
        new Rule()
          .setObjectID("cheap")
          .setConditions(Arrays.asList(new Condition().setPattern("cheap").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams().setQuery(new ConsequenceQueryObject().setRemove(Arrays.asList("cheap"))).setFilters("price < 10")
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/cheap", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"cheap\",\"conditions\":[{\"pattern\":\"cheap\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"query\":{\"remove\":[\"cheap\"]},\"filters\":\"price" +
          " < 10\"}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("negative filters")
  void saveRuleTest17() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "gluten-free-rule",
        new Rule()
          .setObjectID("gluten-free-rule")
          .setConditions(Arrays.asList(new Condition().setPattern("gluten-free").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams()
                .setFilters("NOT allergens:gluten")
                .setQuery(
                  new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("gluten-free")))
                )
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/gluten-free-rule", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"gluten-free-rule\",\"conditions\":[{\"pattern\":\"gluten-free\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"NOT" +
          " allergens:gluten\",\"query\":{\"edits\":[{\"type\":\"remove\",\"delete\":\"gluten-free\"}]}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("positive filters")
  void saveRuleTest18() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "diet-rule",
        new Rule()
          .setObjectID("diet-rule")
          .setConditions(Arrays.asList(new Condition().setPattern("diet").setAnchoring(Anchoring.CONTAINS)))
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams()
                .setFilters("'low-carb' OR 'low-fat'")
                .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("diet"))))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/diet-rule", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"diet-rule\",\"conditions\":[{\"pattern\":\"diet\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"'low-carb'" +
          " OR 'low-fat'\",\"query\":{\"edits\":[{\"type\":\"remove\",\"delete\":\"diet\"}]}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("conditionless")
  void saveRuleTest19() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "diet-rule",
        new Rule()
          .setObjectID("diet-rule")
          .setConsequence(
            new Consequence().setParams(
              new ConsequenceParams()
                .setFilters("'low-carb' OR 'low-fat'")
                .setQuery(new ConsequenceQueryObject().setEdits(Arrays.asList(new Edit().setType(EditType.REMOVE).setDelete("diet"))))
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/diet-rule", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"diet-rule\",\"consequence\":{\"params\":{\"filters\":\"'low-carb'" +
          " OR 'low-fat'\",\"query\":{\"edits\":[{\"type\":\"remove\",\"delete\":\"diet\"}]}}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("contextual")
  void saveRuleTest20() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "a-rule-id",
        new Rule()
          .setObjectID("a-rule-id")
          .setConditions(Arrays.asList(new Condition().setContext("mobile")))
          .setConsequence(new Consequence().setParams(new ConsequenceParams().setFilters("release_date >= 1577836800")))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/a-rule-id", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"a-rule-id\",\"conditions\":[{\"context\":\"mobile\"}],\"consequence\":{\"params\":{\"filters\":\"release_date" +
          " >= 1577836800\"}}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("saveRule always active rule")
  void saveRuleTest21() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "a-rule-id",
        new Rule()
          .setObjectID("a-rule-id")
          .setConsequence(new Consequence().setParams(new ConsequenceParams().setAroundRadius(AroundRadius.of(1000))))
          .setValidity(Arrays.asList(new TimeRange().setFrom(1577836800L).setUntil(1577836800L)))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/a-rule-id", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"a-rule-id\",\"consequence\":{\"params\":{\"aroundRadius\":1000}},\"validity\":[{\"from\":1577836800,\"until\":1577836800}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("one sided validity")
  void saveRuleTest22() {
    assertDoesNotThrow(() -> {
      client.saveRule(
        "indexName",
        "a-rule-id",
        new Rule()
          .setObjectID("a-rule-id")
          .setConsequence(new Consequence().setParams(new ConsequenceParams().setAroundRadius(AroundRadius.of(1000))))
          .setValidity(Arrays.asList(new TimeRange().setFrom(1577836800L)))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/rules/a-rule-id", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"objectID\":\"a-rule-id\",\"consequence\":{\"params\":{\"aroundRadius\":1000}},\"validity\":[{\"from\":1577836800}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
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
            .setConditions(Arrays.asList(new Condition().setPattern("smartphone").setAnchoring(Anchoring.CONTAINS)))
            .setConsequence(new Consequence().setParams(new ConsequenceParams().setFilters("brand:apple"))),
          new Rule()
            .setObjectID("a-second-rule-id")
            .setConditions(Arrays.asList(new Condition().setPattern("apple").setAnchoring(Anchoring.CONTAINS)))
            .setConsequence(new Consequence().setParams(new ConsequenceParams().setFilters("brand:samsung")))
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
        "[{\"objectID\":\"a-rule-id\",\"conditions\":[{\"pattern\":\"smartphone\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\"}}},{\"objectID\":\"a-second-rule-id\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:samsung\"}}}]",
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
  @DisplayName("dynamic filtering")
  void saveRulesTest2() {
    assertDoesNotThrow(() -> {
      client.saveRules(
        "<YOUR_INDEX_NAME>",
        Arrays.asList(
          new Rule()
            .setObjectID("toaster")
            .setConditions(Arrays.asList(new Condition().setPattern("toaster").setAnchoring(Anchoring.CONTAINS)))
            .setConsequence(
              new Consequence().setParams(
                new ConsequenceParams()
                  .setQuery(new ConsequenceQueryObject().setRemove(Arrays.asList("toaster")))
                  .setFilters("product_type:toaster")
              )
            ),
          new Rule()
            .setObjectID("cheap")
            .setConditions(Arrays.asList(new Condition().setPattern("cheap").setAnchoring(Anchoring.CONTAINS)))
            .setConsequence(
              new Consequence().setParams(
                new ConsequenceParams().setQuery(new ConsequenceQueryObject().setRemove(Arrays.asList("cheap"))).setFilters("price < 15")
              )
            )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/rules/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "[{\"objectID\":\"toaster\",\"conditions\":[{\"pattern\":\"toaster\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"query\":{\"remove\":[\"toaster\"]},\"filters\":\"product_type:toaster\"}}},{\"objectID\":\"cheap\",\"conditions\":[{\"pattern\":\"cheap\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"query\":{\"remove\":[\"cheap\"]},\"filters\":\"price" +
          " < 15\"}}}]",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("enhance search results")
  void saveRulesTest3() {
    assertDoesNotThrow(() -> {
      client.saveRules(
        "<YOUR_INDEX_NAME>",
        Arrays.asList(
          new Rule()
            .setObjectID("country")
            .setConditions(Arrays.asList(new Condition().setPattern("{facet:country}").setAnchoring(Anchoring.CONTAINS)))
            .setConsequence(new Consequence().setParams(new ConsequenceParams().setAroundLatLngViaIP(false))),
          new Rule()
            .setObjectID("city")
            .setConditions(Arrays.asList(new Condition().setPattern("{facet:city}").setAnchoring(Anchoring.CONTAINS)))
            .setConsequence(new Consequence().setParams(new ConsequenceParams().setAroundLatLngViaIP(false)))
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/rules/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "[{\"objectID\":\"country\",\"conditions\":[{\"pattern\":\"{facet:country}\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"aroundLatLngViaIP\":false}}},{\"objectID\":\"city\",\"conditions\":[{\"pattern\":\"{facet:city}\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"aroundLatLngViaIP\":false}}}]",
        req.body,
        JSONCompareMode.STRICT
      )
    );
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
        new SearchMethodParams().setRequests(
          Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setHitsPerPage(50))
        ),
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
        new SearchMethodParams().setRequests(
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
        new SearchMethodParams().setRequests(
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
        new SearchMethodParams().setRequests(
          Arrays.asList(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setFilters("NOT actor:Nicolas Cage"))
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
        new SearchMethodParams().setRequests(
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
        new SearchMethodParams().setRequests(
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
        new SearchMethodParams().setRequests(
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
        new SearchMethodParams().setRequests(
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
        new SearchMethodParams().setRequests(
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
        new SearchMethodParams().setRequests(
          Arrays.asList(
            new SearchForHits().setIndexName("cts_e2e_search_facet").setFilters("editor:'visual studio' OR editor:neovim"),
            new SearchForHits()
              .setIndexName("cts_e2e_search_facet")
              .setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("editor:'visual studio'"), FacetFilters.of("editor:neovim")))),
            new SearchForHits()
              .setIndexName("cts_e2e_search_facet")
              .setFacetFilters(
                FacetFilters.of(
                  Arrays.asList(FacetFilters.of("editor:'visual studio'"), FacetFilters.of(Arrays.asList(FacetFilters.of("editor:neovim"))))
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
        new SearchMethodParams().setRequests(
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
                new RenderingContent().setFacetOrdering(
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
        "{\"requests\":[{\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"exactPhrase\"],\"allowTyposOnNumericTokens\":true,\"alternativesAsExact\":[\"multiWordsSynonym\"],\"analytics\":true,\"analyticsTags\":[\"\"],\"aroundLatLng\":\"\",\"aroundLatLngViaIP\":true,\"aroundPrecision\":0,\"aroundRadius\":\"all\",\"attributeCriteriaComputedByMinProximity\":true,\"attributesToHighlight\":[\"\"],\"attributesToRetrieve\":[\"\"],\"attributesToSnippet\":[\"\"],\"clickAnalytics\":true,\"decompoundQuery\":true,\"disableExactOnAttributes\":[\"\"],\"disableTypoToleranceOnAttributes\":[\"\"],\"distinct\":0,\"enableABTest\":true,\"enablePersonalization\":true,\"enableReRanking\":true,\"enableRules\":true,\"exactOnSingleWordQuery\":\"attribute\",\"facetFilters\":[\"\"],\"facetingAfterDistinct\":true,\"facets\":[\"\"],\"filters\":\"\",\"getRankingInfo\":true,\"highlightPostTag\":\"\",\"highlightPreTag\":\"\",\"hitsPerPage\":1,\"ignorePlurals\":false,\"indexName\":\"theIndexName\",\"insideBoundingBox\":[[47.3165,4.9665,47.3424,5.0201],[40.9234,2.1185,38.643,1.9916]],\"insidePolygon\":[[47.3165,4.9665,47.3424,5.0201,47.32,4.9],[40.9234,2.1185,38.643,1.9916,39.2587,2.0104]],\"length\":1,\"maxValuesPerFacet\":0,\"minProximity\":1,\"minWordSizefor1Typo\":0,\"minWordSizefor2Typos\":0,\"minimumAroundRadius\":1,\"naturalLanguages\":[\"fr\"],\"numericFilters\":[\"\"],\"offset\":0,\"optionalFilters\":[\"\"],\"optionalWords\":[\"\"],\"page\":0,\"percentileComputation\":true,\"personalizationImpact\":0,\"query\":\"\",\"queryLanguages\":[\"fr\"],\"queryType\":\"prefixAll\",\"ranking\":[\"\"],\"reRankingApplyFilter\":[\"\"],\"relevancyStrictness\":0,\"removeStopWords\":true,\"removeWordsIfNoResults\":\"allOptional\",\"renderingContent\":{\"facetOrdering\":{\"facets\":{\"order\":[\"a\",\"b\"]},\"values\":{\"a\":{\"order\":[\"b\"],\"sortRemainingBy\":\"count\"}}}},\"replaceSynonymsInHighlight\":true,\"responseFields\":[\"\"],\"restrictHighlightAndSnippetArrays\":true,\"restrictSearchableAttributes\":[\"\"],\"ruleContexts\":[\"\"],\"similarQuery\":\"\",\"snippetEllipsisText\":\"\",\"sortFacetValuesBy\":\"\",\"sumOrFiltersScores\":true,\"synonyms\":true,\"tagFilters\":[\"\"],\"type\":\"default\",\"typoTolerance\":\"min\",\"userToken\":\"\"}]}",
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
  @DisplayName("facetName and facetQuery")
  void searchForFacetValuesTest2() {
    assertDoesNotThrow(() -> {
      client.searchForFacetValues("indexName", "author", new SearchForFacetValuesRequest().setFacetQuery("stephen"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/facets/author/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facetQuery\":\"stephen\"}", req.body, JSONCompareMode.STRICT));
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
  @DisplayName("query")
  void searchSingleIndexTest4() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("phone"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"phone\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("filters")
  void searchSingleIndexTest5() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setFilters("country:US AND price.gross < 2.0"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"filters\":\"country:US AND price.gross < 2.0\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("filters for stores")
  void searchSingleIndexTest6() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("ben").setFilters("categories:politics AND store:Gibert Joseph Saint-Michel"),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"ben\",\"filters\":\"categories:politics AND store:Gibert Joseph" + " Saint-Michel\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("filters boolean")
  void searchSingleIndexTest7() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setFilters("is_available:true"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"filters\":\"is_available:true\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("distinct")
  void searchSingleIndexTest8() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setDistinct(Distinct.of(true)), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"distinct\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("filtersNumeric")
  void searchSingleIndexTest9() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setFilters("price < 10"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"filters\":\"price < 10\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("filtersTimestamp")
  void searchSingleIndexTest10() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setFilters("NOT date_timestamp:1514764800 TO 1546300799"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"filters\":\"NOT date_timestamp:1514764800 TO 1546300799\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("filtersSumOrFiltersScoresFalse")
  void searchSingleIndexTest11() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setFilters("(company:Google<score=3> OR company:Amazon<score=2> OR" + " company:Facebook<score=1>)")
          .setSumOrFiltersScores(false),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"filters\":\"(company:Google<score=3> OR company:Amazon<score=2> OR" +
          " company:Facebook<score=1>)\",\"sumOrFiltersScores\":false}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("filtersSumOrFiltersScoresTrue")
  void searchSingleIndexTest12() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setFilters("(company:Google<score=3> OR company:Amazon<score=2> OR" + " company:Facebook<score=1>)")
          .setSumOrFiltersScores(true),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"filters\":\"(company:Google<score=3> OR company:Amazon<score=2> OR" +
          " company:Facebook<score=1>)\",\"sumOrFiltersScores\":true}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("filtersStephenKing")
  void searchSingleIndexTest13() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setFilters("author:\"Stephen King\""), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"filters\":\"author:\\\"Stephen King\\\"\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("filtersNotTags")
  void searchSingleIndexTest14() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("harry").setFilters("_tags:non-fiction"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"harry\",\"filters\":\"_tags:non-fiction\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("facetFiltersList")
  void searchSingleIndexTest15() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setFacetFilters(
          FacetFilters.of(
            Arrays.asList(
              FacetFilters.of("publisher:Penguin"),
              FacetFilters.of(Arrays.asList(FacetFilters.of("author:Stephen King"), FacetFilters.of("genre:Horror")))
            )
          )
        ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"facetFilters\":[\"publisher:Penguin\",[\"author:Stephen" + " King\",\"genre:Horror\"]]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("facetFiltersBook")
  void searchSingleIndexTest16() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("category:Book")))),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"facetFilters\":[\"category:Book\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("facetFiltersAND")
  void searchSingleIndexTest17() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("category:Book"), FacetFilters.of("author:John Doe")))),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"facetFilters\":[\"category:Book\",\"author:John Doe\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("facetFiltersOR")
  void searchSingleIndexTest18() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setFacetFilters(
            FacetFilters.of(
              Arrays.asList(FacetFilters.of(Arrays.asList(FacetFilters.of("category:Book"), FacetFilters.of("author:John Doe"))))
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"facetFilters\":[[\"category:Book\",\"author:John Doe\"]]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("facetFiltersCombined")
  void searchSingleIndexTest19() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setFacetFilters(
            FacetFilters.of(
              Arrays.asList(
                FacetFilters.of("author:John Doe"),
                FacetFilters.of(Arrays.asList(FacetFilters.of("category:Book"), FacetFilters.of("category:Movie")))
              )
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"facetFilters\":[\"author:John" + " Doe\",[\"category:Book\",\"category:Movie\"]]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("facetFiltersNeg")
  void searchSingleIndexTest20() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setFacetFilters(FacetFilters.of("category:-Ebook")), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facetFilters\":\"category:-Ebook\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("filtersAndFacetFilters")
  void searchSingleIndexTest21() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setFilters("(author:\"Stephen King\" OR genre:\"Horror\")")
          .setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("publisher:Penguin")))),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"filters\":\"(author:\\\"Stephen King\\\" OR" + " genre:\\\"Horror\\\")\",\"facetFilters\":[\"publisher:Penguin\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("facet author genre")
  void searchSingleIndexTest22() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setFacets(Arrays.asList("author", "genre")), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facets\":[\"author\",\"genre\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("facet wildcard")
  void searchSingleIndexTest23() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setFacets(Arrays.asList("*")), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"facets\":[\"*\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("maxValuesPerFacet")
  void searchSingleIndexTest24() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setMaxValuesPerFacet(1000), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"maxValuesPerFacet\":1000}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("aroundLatLng")
  void searchSingleIndexTest25() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setAroundLatLng("40.71, -74.01"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"aroundLatLng\":\"40.71, -74.01\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("aroundLatLngViaIP")
  void searchSingleIndexTest26() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setAroundLatLngViaIP(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"aroundLatLngViaIP\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("aroundRadius")
  void searchSingleIndexTest27() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setAroundLatLng("40.71, -74.01").setAroundRadius(AroundRadius.of(1000000)),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"aroundLatLng\":\"40.71, -74.01\",\"aroundRadius\":1000000}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("insideBoundingBox")
  void searchSingleIndexTest28() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setInsideBoundingBox(
          InsideBoundingBox.of(Arrays.asList(Arrays.asList(49.067996905313834, 65.73828125, 25.905859247243498, 128.8046875)))
        ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"insideBoundingBox\":[[49.067996905313834,65.73828125,25.905859247243498,128.8046875]]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("insidePolygon")
  void searchSingleIndexTest29() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setInsidePolygon(
          Arrays.asList(
            Arrays.asList(
              42.01,
              -124.31,
              48.835509470063045,
              -124.40453125000005,
              45.01082951668149,
              -65.95726562500005,
              31.247243545293433,
              -81.06578125000004,
              25.924152577235226,
              -97.68234374999997,
              32.300311895879545,
              -117.54828125
            )
          )
        ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"insidePolygon\":[[42.01,-124.31,48.835509470063045,-124.40453125000005,45.01082951668149,-65.95726562500005,31.247243545293433,-81.06578125000004,25.924152577235226,-97.68234374999997,32.300311895879545,-117.54828125]]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("optionalFilters")
  void searchSingleIndexTest30() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setOptionalFilters(OptionalFilters.of(Arrays.asList(OptionalFilters.of("can_deliver_quickly:true")))),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"optionalFilters\":[\"can_deliver_quickly:true\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("optionalFiltersMany")
  void searchSingleIndexTest31() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setOptionalFilters(
          OptionalFilters.of(
            Arrays.asList(
              OptionalFilters.of("brand:Apple<score=3>"),
              OptionalFilters.of("brand:Samsung<score=2>"),
              OptionalFilters.of("brand:-Huawei")
            )
          )
        ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"optionalFilters\":[\"brand:Apple<score=3>\",\"brand:Samsung<score=2>\",\"brand:-Huawei\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("optionalFiltersSimple")
  void searchSingleIndexTest32() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setOptionalFilters(
          OptionalFilters.of(Arrays.asList(OptionalFilters.of("brand:Apple<score=2>"), OptionalFilters.of("type:tablet")))
        ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"optionalFilters\":[\"brand:Apple<score=2>\",\"type:tablet\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("restrictSearchableAttributes")
  void searchSingleIndexTest33() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setRestrictSearchableAttributes(Arrays.asList("title_fr")), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"restrictSearchableAttributes\":[\"title_fr\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("getRankingInfo")
  void searchSingleIndexTest34() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setGetRankingInfo(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"getRankingInfo\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("clickAnalytics")
  void searchSingleIndexTest35() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setClickAnalytics(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"clickAnalytics\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("clickAnalyticsUserToken")
  void searchSingleIndexTest36() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setClickAnalytics(true).setUserToken("user-1"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"clickAnalytics\":true,\"userToken\":\"user-1\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("enablePersonalization")
  void searchSingleIndexTest37() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setEnablePersonalization(true).setUserToken("user-1"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"enablePersonalization\":true,\"userToken\":\"user-1\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("userToken")
  void searchSingleIndexTest38() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setUserToken("user-1"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"userToken\":\"user-1\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("userToken1234")
  void searchSingleIndexTest39() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setUserToken("user-1234"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"userToken\":\"user-1234\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("analyticsTag")
  void searchSingleIndexTest40() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setAnalyticsTags(Arrays.asList("YOUR_ANALYTICS_TAG")), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"analyticsTags\":[\"YOUR_ANALYTICS_TAG\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("facetFiltersUsers")
  void searchSingleIndexTest41() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setFacetFilters(
          FacetFilters.of(Arrays.asList(FacetFilters.of("user:user42"), FacetFilters.of("user:public")))
        ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"facetFilters\":[\"user:user42\",\"user:public\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("buildTheQuery")
  void searchSingleIndexTest42() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setFilters("categoryPageId: Men's Clothing")
          .setHitsPerPage(50)
          .setAnalyticsTags(Arrays.asList("mens-clothing")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"filters\":\"categoryPageId: Men's" + " Clothing\",\"hitsPerPage\":50,\"analyticsTags\":[\"mens-clothing\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("attributesToHighlightOverride")
  void searchSingleIndexTest43() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setAttributesToHighlight(Arrays.asList("title", "content")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"attributesToHighlight\":[\"title\",\"content\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("disableTypoToleranceOnAttributes")
  void searchSingleIndexTest44() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setDisableTypoToleranceOnAttributes(Arrays.asList("serial_number")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"disableTypoToleranceOnAttributes\":[\"serial_number\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search query")
  void searchSingleIndexTest45() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("shirt"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"shirt\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("search_everything")
  void searchSingleIndexTest46() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery(""), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("api_filtering_range_example")
  void searchSingleIndexTest47() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("books").setFilters("price:10 TO 20"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"books\",\"filters\":\"price:10 TO 20\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("similarQuery")
  void searchSingleIndexTest48() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("")
          .setSimilarQuery("Comedy Drama Crime McDormand Macy Buscemi Stormare Presnell Coen")
          .setFilters("year:1991 TO 2001"),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"\",\"similarQuery\":\"Comedy Drama Crime McDormand Macy Buscemi" +
          " Stormare Presnell Coen\",\"filters\":\"year:1991 TO 2001\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("override_retrievable_attributes")
  void searchSingleIndexTest49() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setAttributesToRetrieve(Arrays.asList("title", "content")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"attributesToRetrieve\":[\"title\",\"content\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("restrict_searchable_attributes")
  void searchSingleIndexTest50() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setRestrictSearchableAttributes(Arrays.asList("title", "author")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"restrictSearchableAttributes\":[\"title\",\"author\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("override_default_relevancy")
  void searchSingleIndexTest51() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setRelevancyStrictness(70), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"relevancyStrictness\":70}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("apply_filters")
  void searchSingleIndexTest52() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setFilters("(category:Book OR category:Ebook) AND _tags:published"),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"filters\":\"(category:Book OR category:Ebook) AND" + " _tags:published\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("apply_all_filters")
  void searchSingleIndexTest53() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setFilters(
            "available = 1 AND (category:Book OR NOT category:Ebook) AND _tags:published" +
              " AND publication_date:1441745506 TO 1441755506 AND inStock > 0 AND" +
              " author:\"John Doe\""
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"filters\":\"available = 1 AND (category:Book OR NOT" +
          " category:Ebook) AND _tags:published AND publication_date:1441745506 TO" +
          " 1441755506 AND inStock > 0 AND author:\\\"John Doe\\\"\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("escape_spaces")
  void searchSingleIndexTest54() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setFilters("category:\"Books and Comics\""),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"filters\":\"category:\\\"Books and Comics\\\"\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("escape_keywords")
  void searchSingleIndexTest55() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setFilters("keyword:\"OR\""), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"filters\":\"keyword:\\\"OR\\\"\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("escape_single_quotes")
  void searchSingleIndexTest56() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setFilters("content:\"It's a wonderful day\""),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"filters\":\"content:\\\"It's a wonderful day\\\"\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("escape_double_quotes")
  void searchSingleIndexTest57() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setFilters("content:\"She said \"Hello World\""),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"filters\":\"content:\\\"She said \\\"Hello World\\\"\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("apply_optional_filters")
  void searchSingleIndexTest58() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setOptionalFilters(
            OptionalFilters.of(Arrays.asList(OptionalFilters.of("category:Book"), OptionalFilters.of("author:John Doe")))
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"optionalFilters\":[\"category:Book\",\"author:John Doe\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("apply_negative_filters")
  void searchSingleIndexTest59() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setOptionalFilters(
            OptionalFilters.of(Arrays.asList(OptionalFilters.of("category:Book"), OptionalFilters.of("author:-John Doe")))
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"optionalFilters\":[\"category:Book\",\"author:-John" + " Doe\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("apply_negative_filters_restaurants")
  void searchSingleIndexTest60() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setOptionalFilters(OptionalFilters.of(Arrays.asList(OptionalFilters.of("restaurant:-Bert's Inn")))),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"optionalFilters\":[\"restaurant:-Bert's Inn\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("apply_numeric_filters")
  void searchSingleIndexTest61() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setNumericFilters(
            NumericFilters.of(
              Arrays.asList(
                NumericFilters.of("price < 1000"),
                NumericFilters.of(Arrays.asList(NumericFilters.of("inStock = 1"), NumericFilters.of("deliveryDate < 1441755506")))
              )
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"numericFilters\":[\"price < 1000\",[\"inStock =" + " 1\",\"deliveryDate < 1441755506\"]]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("apply_tag_filters")
  void searchSingleIndexTest62() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setTagFilters(
            TagFilters.of(
              Arrays.asList(TagFilters.of("SciFi"), TagFilters.of(Arrays.asList(TagFilters.of("Book"), TagFilters.of("Movie"))))
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"tagFilters\":[\"SciFi\",[\"Book\",\"Movie\"]]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_sum_or_filters_scores")
  void searchSingleIndexTest63() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setSumOrFiltersScores(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"sumOrFiltersScores\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("facets_all")
  void searchSingleIndexTest64() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setFacets(Arrays.asList("*")), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"facets\":[\"*\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("retrieve_only_some_facets")
  void searchSingleIndexTest65() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setFacets(Arrays.asList("category", "author")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"facets\":[\"category\",\"author\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("override_default_max_values_per_facet")
  void searchSingleIndexTest66() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setMaxValuesPerFacet(20), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"maxValuesPerFacet\":20}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("enable_faceting_after_distinct")
  void searchSingleIndexTest67() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setFacetingAfterDistinct(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"facetingAfterDistinct\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("sort_facet_values_alphabetically")
  void searchSingleIndexTest68() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setSortFacetValuesBy("count"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"sortFacetValuesBy\":\"count\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("override_attributes_to_snippet")
  void searchSingleIndexTest69() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setAttributesToSnippet(Arrays.asList("title", "content:80")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"attributesToSnippet\":[\"title\",\"content:80\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("override_default_highlight_pre_tag")
  void searchSingleIndexTest70() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setHighlightPreTag("<strong>"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"highlightPreTag\":\"<strong>\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("override_default_highlight_post_tag")
  void searchSingleIndexTest71() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setHighlightPostTag("</strong>"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"highlightPostTag\":\"</strong>\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("override_default_snippet_ellipsis_text")
  void searchSingleIndexTest72() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setSnippetEllipsisText(""), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"snippetEllipsisText\":\"\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("enable_restrict_highlight_and_snippet_arrays")
  void searchSingleIndexTest73() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setRestrictHighlightAndSnippetArrays(false),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"restrictHighlightAndSnippetArrays\":false}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("access_page")
  void searchSingleIndexTest74() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setPage(0), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"page\":0}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("override_default_hits_per_page")
  void searchSingleIndexTest75() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setHitsPerPage(10), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"hitsPerPage\":10}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("get_nth_hit")
  void searchSingleIndexTest76() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setOffset(4), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"offset\":4}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("get_n_results")
  void searchSingleIndexTest77() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setLength(4), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"length\":4}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("override_default_min_word_size_for_one_typo")
  void searchSingleIndexTest78() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setMinWordSizefor1Typo(2), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"minWordSizefor1Typo\":2}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("override_default_min_word_size_for_two_typos")
  void searchSingleIndexTest79() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setMinWordSizefor2Typos(2), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"minWordSizefor2Typos\":2}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("override_default_typo_tolerance_mode")
  void searchSingleIndexTest80() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setTypoTolerance(TypoTolerance.of(false)),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"typoTolerance\":false}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("disable_typos_on_numeric_tokens_at_search_time")
  void searchSingleIndexTest81() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setAllowTyposOnNumericTokens(false), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"allowTyposOnNumericTokens\":false}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("search_around_a_position")
  void searchSingleIndexTest82() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setAroundLatLng("40.71, -74.01"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"aroundLatLng\":\"40.71, -74.01\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("search_around_server_ip")
  void searchSingleIndexTest83() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setAroundLatLngViaIP(true),
        Hit.class,
        new RequestOptions().addExtraHeader(
          "x-forwarded-for",
          "94.228.178.246 // should be replaced with the actual IP you would like to" + " search around"
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"aroundLatLngViaIP\":true}", req.body, JSONCompareMode.STRICT));

    try {
      Map<String, String> expectedHeaders = json.readValue(
        "{\"x-forwarded-for\":\"94.228.178.246 // should be replaced with the actual IP you" + " would like to search around\"}",
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
  @DisplayName("set_around_radius")
  void searchSingleIndexTest84() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setAroundRadius(AroundRadius.of(1000)), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"aroundRadius\":1000}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("disable_automatic_radius")
  void searchSingleIndexTest85() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setAroundRadius(AroundRadiusAll.ALL), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"aroundRadius\":\"all\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_geo_search_precision")
  void searchSingleIndexTest86() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setAroundPrecision(AroundPrecision.of(100)),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"aroundPrecision\":100}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_geo_search_precision_non_linear")
  void searchSingleIndexTest87() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setAroundPrecision(
            AroundPrecision.of(Arrays.asList(new Range().setFrom(0).setValue(25), new Range().setFrom(2000).setValue(1000)))
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"aroundPrecision\":[{\"from\":0,\"value\":25},{\"from\":2000,\"value\":1000}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("set_minimum_geo_search_radius")
  void searchSingleIndexTest88() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setMinimumAroundRadius(1000), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"minimumAroundRadius\":1000}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("search_inside_rectangular_area")
  void searchSingleIndexTest89() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setInsideBoundingBox(
            InsideBoundingBox.of(Arrays.asList(Arrays.asList(46.650828100116044, 7.123046875, 45.17210966999772, 1.009765625)))
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"insideBoundingBox\":[[46.650828100116044,7.123046875,45.17210966999772,1.009765625]]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search_inside_multiple_rectangular_areas")
  void searchSingleIndexTest90() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setInsideBoundingBox(
            InsideBoundingBox.of(
              Arrays.asList(
                Arrays.asList(46.650828100116044, 7.123046875, 45.17210966999772, 1.009765625),
                Arrays.asList(49.62625916704081, 4.6181640625, 47.715070300900194, 0.482421875)
              )
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"insideBoundingBox\":[[46.650828100116044,7.123046875,45.17210966999772,1.009765625],[49.62625916704081,4.6181640625,47.715070300900194,0.482421875]]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search_inside_polygon_area")
  void searchSingleIndexTest91() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setInsidePolygon(
            Arrays.asList(Arrays.asList(46.650828100116044, 7.123046875, 45.17210966999772, 1.009765625, 49.62625916704081, 4.6181640625))
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"insidePolygon\":[[46.650828100116044,7.123046875,45.17210966999772,1.009765625,49.62625916704081,4.6181640625]]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("search_inside_multiple_polygon_areas")
  void searchSingleIndexTest92() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setInsidePolygon(
            Arrays.asList(
              Arrays.asList(46.650828100116044, 7.123046875, 45.17210966999772, 1.009765625, 49.62625916704081, 4.6181640625),
              Arrays.asList(
                49.62625916704081,
                4.6181640625,
                47.715070300900194,
                0.482421875,
                45.17210966999772,
                1.009765625,
                50.62626704081,
                4.6181640625
              )
            )
          ),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"insidePolygon\":[[46.650828100116044,7.123046875,45.17210966999772,1.009765625,49.62625916704081,4.6181640625],[49.62625916704081,4.6181640625,47.715070300900194,0.482421875,45.17210966999772,1.009765625,50.62626704081,4.6181640625]]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("set_querylanguages_override")
  void searchSingleIndexTest93() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setIgnorePlurals(IgnorePlurals.of(Arrays.asList(SupportedLanguage.CA, SupportedLanguage.ES))),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"ignorePlurals\":[\"ca\",\"es\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_querylanguages_with_japanese_query")
  void searchSingleIndexTest94() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setQueryLanguages(Arrays.asList(SupportedLanguage.JA, SupportedLanguage.EN)),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"queryLanguages\":[\"ja\",\"en\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_natural_languages")
  void searchSingleIndexTest95() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("").setNaturalLanguages(Arrays.asList(SupportedLanguage.FR)),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"\",\"naturalLanguages\":[\"fr\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("override_natural_languages_with_query")
  void searchSingleIndexTest96() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("")
          .setNaturalLanguages(Arrays.asList(SupportedLanguage.FR))
          .setRemoveWordsIfNoResults(RemoveWordsIfNoResults.FIRST_WORDS),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"\",\"naturalLanguages\":[\"fr\"],\"removeWordsIfNoResults\":\"firstWords\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("enable_decompound_query_search_time")
  void searchSingleIndexTest97() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setDecompoundQuery(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"decompoundQuery\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("enable_rules_search_time")
  void searchSingleIndexTest98() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setEnableRules(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"enableRules\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_rule_contexts")
  void searchSingleIndexTest99() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setRuleContexts(Arrays.asList("front_end", "website2")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"ruleContexts\":[\"front_end\",\"website2\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("enable_personalization")
  void searchSingleIndexTest100() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setEnablePersonalization(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"enablePersonalization\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("enable_personalization_with_user_token")
  void searchSingleIndexTest101() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setEnablePersonalization(true).setUserToken("123456"),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"enablePersonalization\":true,\"userToken\":\"123456\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("personalization_impact")
  void searchSingleIndexTest102() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setPersonalizationImpact(20), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"personalizationImpact\":20}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_user_token")
  void searchSingleIndexTest103() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setUserToken("123456"), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"userToken\":\"123456\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_user_token_with_personalization")
  void searchSingleIndexTest104() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setEnablePersonalization(true).setUserToken("123456"),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"enablePersonalization\":true,\"userToken\":\"123456\"}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("override_default_query_type")
  void searchSingleIndexTest105() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setQueryType(QueryType.PREFIX_ALL), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"queryType\":\"prefixAll\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("override_default_remove_words_if_no_results")
  void searchSingleIndexTest106() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setRemoveWordsIfNoResults(RemoveWordsIfNoResults.LAST_WORDS),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"removeWordsIfNoResults\":\"lastWords\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("enable_advanced_syntax_search_time")
  void searchSingleIndexTest107() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setAdvancedSyntax(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"advancedSyntax\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("overide_default_optional_words")
  void searchSingleIndexTest108() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setOptionalWords(OptionalWords.of(Arrays.asList("toyota", "2020 2021"))),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"optionalWords\":[\"toyota\",\"2020 2021\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("disabling_exact_for_some_attributes_search_time")
  void searchSingleIndexTest109() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setDisableExactOnAttributes(Arrays.asList("description")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"disableExactOnAttributes\":[\"description\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("override_default_exact_single_word_query")
  void searchSingleIndexTest110() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setExactOnSingleWordQuery(ExactOnSingleWordQuery.NONE),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"exactOnSingleWordQuery\":\"none\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("override_default_aternative_as_exact")
  void searchSingleIndexTest111() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setAlternativesAsExact(Arrays.asList(AlternativesAsExact.MULTI_WORDS_SYNONYM)),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"alternativesAsExact\":[\"multiWordsSynonym\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("enable_advanced_syntax_exact_phrase")
  void searchSingleIndexTest112() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setAdvancedSyntax(true)
          .setAdvancedSyntaxFeatures(Arrays.asList(AdvancedSyntaxFeatures.EXACT_PHRASE)),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"exactPhrase\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("enable_advanced_syntax_exclude_words")
  void searchSingleIndexTest113() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject()
          .setQuery("query")
          .setAdvancedSyntax(true)
          .setAdvancedSyntaxFeatures(Arrays.asList(AdvancedSyntaxFeatures.EXCLUDE_WORDS)),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"query\":\"query\",\"advancedSyntax\":true,\"advancedSyntaxFeatures\":[\"excludeWords\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("override_distinct")
  void searchSingleIndexTest114() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setDistinct(Distinct.of(0)), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"distinct\":0}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("get_ranking_info")
  void searchSingleIndexTest115() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setGetRankingInfo(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"getRankingInfo\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("disable_click_analytics")
  void searchSingleIndexTest116() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setClickAnalytics(false), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"clickAnalytics\":false}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("enable_click_analytics")
  void searchSingleIndexTest117() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setClickAnalytics(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"clickAnalytics\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("disable_analytics")
  void searchSingleIndexTest118() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setAnalytics(false), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"analytics\":false}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("add_analytics_tags")
  void searchSingleIndexTest119() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setAnalyticsTags(Arrays.asList("front_end", "website2")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"analyticsTags\":[\"front_end\",\"website2\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("disable_synonyms")
  void searchSingleIndexTest120() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setSynonyms(false), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"synonyms\":false}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("override_replace_synonyms_in_highlights")
  void searchSingleIndexTest121() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setReplaceSynonymsInHighlight(true), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"replaceSynonymsInHighlight\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("override_min_proximity")
  void searchSingleIndexTest122() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setMinProximity(2), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"minProximity\":2}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("override_default_field")
  void searchSingleIndexTest123() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query").setResponseFields(Arrays.asList("hits", "facets")),
        Hit.class
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"responseFields\":[\"hits\",\"facets\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("override_percentile_computation")
  void searchSingleIndexTest124() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setPercentileComputation(false), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"query\":\"query\",\"percentileComputation\":false}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_ab_test")
  void searchSingleIndexTest125() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setEnableABTest(false), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"enableABTest\":false}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_enable_re_ranking")
  void searchSingleIndexTest126() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex("indexName", new SearchParamsObject().setQuery("query").setEnableReRanking(false), Hit.class);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\",\"enableReRanking\":false}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("with algolia user id")
  void searchSingleIndexTest127() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "indexName",
        new SearchParamsObject().setQuery("query"),
        Hit.class,
        new RequestOptions().addExtraHeader("X-Algolia-User-ID", "user1234")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"query\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("mcm with algolia user id")
  void searchSingleIndexTest128() {
    assertDoesNotThrow(() -> {
      client.searchSingleIndex(
        "playlists",
        new SearchParamsObject().setQuery("peace"),
        Hit.class,
        new RequestOptions().addExtraHeader("X-Algolia-User-ID", "user42")
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/playlists/query", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"query\":\"peace\"}", req.body, JSONCompareMode.STRICT));
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
        new DictionarySettingsParams().setDisableStandardEntries(
          new StandardEntries().setPlurals(
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
        new DictionarySettingsParams().setDisableStandardEntries(
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
  @DisplayName("minimal parameters")
  void setSettingsTest() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "cts_e2e_settings",
        new IndexSettings().setPaginationLimitedTo(10).setTypoTolerance(TypoToleranceEnum.FALSE),
        true
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/cts_e2e_settings/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"paginationLimitedTo\":10,\"typoTolerance\":\"false\"}", req.body, JSONCompareMode.STRICT)
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
  @DisplayName("boolean typoTolerance")
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
  @DisplayName("enum typoTolerance")
  void setSettingsTest2() {
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
  @DisplayName("ignorePlurals")
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
  @DisplayName("list of string ignorePlurals")
  void setSettingsTest4() {
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
  @DisplayName("removeStopWords boolean")
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
  @DisplayName("removeStopWords list of string")
  void setSettingsTest6() {
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
  @DisplayName("boolean distinct")
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
  @DisplayName("integer distinct")
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
  @DisplayName("distinct company")
  void setSettingsTest9() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributeForDistinct("company").setDistinct(Distinct.of(true)));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributeForDistinct\":\"company\",\"distinct\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("distinct design")
  void setSettingsTest10() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributeForDistinct("design").setDistinct(Distinct.of(true)));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributeForDistinct\":\"design\",\"distinct\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("distinct true")
  void setSettingsTest11() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setDistinct(Distinct.of(true)));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"distinct\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("distinct section")
  void setSettingsTest12() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributeForDistinct("section").setDistinct(Distinct.of(true)));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributeForDistinct\":\"section\",\"distinct\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("attributesForFaceting allergens")
  void setSettingsTest13() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("allergens")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributesForFaceting\":[\"allergens\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("attributesForFaceting availableIn")
  void setSettingsTest14() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("color", "availableIn")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesForFaceting\":[\"color\",\"availableIn\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("api_attributes_for_faceting")
  void setSettingsTest15() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("genre", "author")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesForFaceting\":[\"genre\",\"author\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("api_attributes_for_faceting_searchable")
  void setSettingsTest16() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("genre", "searchable(author)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesForFaceting\":[\"genre\",\"searchable(author)\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("api_attributes_for_filter_only")
  void setSettingsTest17() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("filterOnly(genre)", "author")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesForFaceting\":[\"filterOnly(genre)\",\"author\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("attributesForFaceting categoryPageId")
  void setSettingsTest18() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("searchable(categoryPageId)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesForFaceting\":[\"searchable(categoryPageId)\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("unretrievableAttributes")
  void setSettingsTest19() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setUnretrievableAttributes(Arrays.asList("visible_by")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"unretrievableAttributes\":[\"visible_by\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("attributesForFaceting user restricted data")
  void setSettingsTest20() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("filterOnly(visible_by)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesForFaceting\":[\"filterOnly(visible_by)\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("attributesForFaceting optional filters")
  void setSettingsTest21() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "<YOUR_INDEX_NAME>",
        new IndexSettings().setAttributesForFaceting(Arrays.asList("can_deliver_quickly", "restaurant"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesForFaceting\":[\"can_deliver_quickly\",\"restaurant\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("attributesForFaceting redirect index")
  void setSettingsTest22() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("query_terms")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributesForFaceting\":[\"query_terms\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("attributesForFaceting multiple consequences")
  void setSettingsTest23() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("director")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributesForFaceting\":[\"director\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("attributesForFaceting in-depth optional filters")
  void setSettingsTest24() {
    assertDoesNotThrow(() -> {
      client.setSettings("<YOUR_INDEX_NAME>", new IndexSettings().setAttributesForFaceting(Arrays.asList("filterOnly(brand)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/%3CYOUR_INDEX_NAME%3E/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesForFaceting\":[\"filterOnly(brand)\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("mode neuralSearch")
  void setSettingsTest25() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMode(Mode.NEURAL_SEARCH));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"mode\":\"neuralSearch\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("mode keywordSearch")
  void setSettingsTest26() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMode(Mode.KEYWORD_SEARCH));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"mode\":\"keywordSearch\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("searchableAttributes same priority")
  void setSettingsTest27() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setSearchableAttributes(Arrays.asList("title,comments", "ingredients")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"searchableAttributes\":[\"title,comments\",\"ingredients\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("searchableAttributes higher priority")
  void setSettingsTest28() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setSearchableAttributes(Arrays.asList("title", "ingredients")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"searchableAttributes\":[\"title\",\"ingredients\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("customRanking retweets")
  void setSettingsTest29() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setCustomRanking(Arrays.asList("desc(retweets)", "desc(likes)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"customRanking\":[\"desc(retweets)\",\"desc(likes)\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("customRanking boosted")
  void setSettingsTest30() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setCustomRanking(Arrays.asList("desc(boosted)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"customRanking\":[\"desc(boosted)\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("customRanking pageviews")
  void setSettingsTest31() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setCustomRanking(Arrays.asList("desc(pageviews)", "desc(comments)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"customRanking\":[\"desc(pageviews)\",\"desc(comments)\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("customRanking applying search parameters for a specific query")
  void setSettingsTest32() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings()
          .setCustomRanking(Arrays.asList("desc(nb_airline_liaisons)"))
          .setAttributesForFaceting(Arrays.asList("city, country"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"customRanking\":[\"desc(nb_airline_liaisons)\"],\"attributesForFaceting\":[\"city," + " country\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("customRanking rounded pageviews")
  void setSettingsTest33() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setCustomRanking(Arrays.asList("desc(rounded_pageviews)", "desc(comments)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"customRanking\":[\"desc(rounded_pageviews)\",\"desc(comments)\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("customRanking price")
  void setSettingsTest34() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setCustomRanking(Arrays.asList("desc(price)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"customRanking\":[\"desc(price)\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("ranking exhaustive (price)")
  void setSettingsTest35() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setRanking(
          Arrays.asList("desc(price)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom")
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"ranking\":[\"desc(price)\",\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\",\"custom\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("ranking exhaustive (is_popular)")
  void setSettingsTest36() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setRanking(
          Arrays.asList("desc(is_popular)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom")
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"ranking\":[\"desc(is_popular)\",\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\",\"custom\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("ranking standard replica")
  void setSettingsTest37() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setRanking(Arrays.asList("desc(post_date_timestamp)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"ranking\":[\"desc(post_date_timestamp)\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("ranking virtual replica")
  void setSettingsTest38() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setCustomRanking(Arrays.asList("desc(post_date_timestamp)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"customRanking\":[\"desc(post_date_timestamp)\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("customRanking and ranking sort alphabetically")
  void setSettingsTest39() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings()
          .setCustomRanking(Arrays.asList("asc(textual_attribute)"))
          .setRanking(Arrays.asList("custom", "typo", "geo", "words", "filters", "proximity", "attribute", "exact"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"customRanking\":[\"asc(textual_attribute)\"],\"ranking\":[\"custom\",\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("relevancyStrictness")
  void setSettingsTest40() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setCustomRanking(Arrays.asList("asc(textual_attribute)")).setRelevancyStrictness(0)
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"customRanking\":[\"asc(textual_attribute)\"],\"relevancyStrictness\":0}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("create replica index")
  void setSettingsTest41() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setReplicas(Arrays.asList("products_price_desc")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"replicas\":[\"products_price_desc\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("create replica index articles")
  void setSettingsTest42() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setReplicas(Arrays.asList("articles_date_desc")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"replicas\":[\"articles_date_desc\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("create virtual replica index")
  void setSettingsTest43() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setReplicas(Arrays.asList("virtual(products_price_desc)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"replicas\":[\"virtual(products_price_desc)\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("unlink replica index")
  void setSettingsTest44() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setReplicas(Arrays.asList("")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"replicas\":[\"\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("forwardToReplicas")
  void setSettingsTest45() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setSearchableAttributes(Arrays.asList("name", "description")), true);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"searchableAttributes\":[\"name\",\"description\"]}", req.body, JSONCompareMode.STRICT)
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
  @DisplayName("maxValuesPerFacet")
  void setSettingsTest46() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMaxValuesPerFacet(1000));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"maxValuesPerFacet\":1000}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("maxFacetHits")
  void setSettingsTest47() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMaxFacetHits(100));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"maxFacetHits\":100}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("attributesForFaceting complex")
  void setSettingsTest48() {
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
  @DisplayName("ranking closest dates")
  void setSettingsTest49() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setRanking(
          Arrays.asList("asc(date_timestamp)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom")
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"ranking\":[\"asc(date_timestamp)\",\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\",\"custom\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchableAttributes item variation")
  void setSettingsTest50() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setSearchableAttributes(Arrays.asList("design", "type", "color")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"searchableAttributes\":[\"design\",\"type\",\"color\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("searchableAttributes around location")
  void setSettingsTest51() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings()
          .setSearchableAttributes(Arrays.asList("name", "country", "city", "iata_code"))
          .setCustomRanking(Arrays.asList("desc(links_count)"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"searchableAttributes\":[\"name\",\"country\",\"city\",\"iata_code\"],\"customRanking\":[\"desc(links_count)\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("attributesToHighlight")
  void setSettingsTest52() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributesToHighlight(Arrays.asList("author", "title", "content")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesToHighlight\":[\"author\",\"title\",\"content\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("attributesToHighlightStar")
  void setSettingsTest53() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributesToHighlight(Arrays.asList("*")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributesToHighlight\":[\"*\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("everything")
  void setSettingsTest54() {
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
            new RenderingContent().setFacetOrdering(
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
  @DisplayName("searchableAttributesWithCustomRankingsAndAttributesForFaceting")
  void setSettingsTest55() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings()
          .setSearchableAttributes(Arrays.asList("brand", "name", "categories", "unordered(description)"))
          .setCustomRanking(Arrays.asList("desc(popularity)"))
          .setAttributesForFaceting(Arrays.asList("searchable(brand)", "type", "categories", "price"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"searchableAttributes\":[\"brand\",\"name\",\"categories\",\"unordered(description)\"],\"customRanking\":[\"desc(popularity)\"],\"attributesForFaceting\":[\"searchable(brand)\",\"type\",\"categories\",\"price\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchableAttributesOrdering")
  void setSettingsTest56() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setSearchableAttributes(Arrays.asList("unordered(title)", "cast")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"searchableAttributes\":[\"unordered(title)\",\"cast\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("searchableAttributesProductReferenceSuffixes")
  void setSettingsTest57() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setSearchableAttributes(Arrays.asList("name", "product_reference", "product_reference_suffixes"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"searchableAttributes\":[\"name\",\"product_reference\",\"product_reference_suffixes\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("queryLanguageAndIgnorePlurals")
  void setSettingsTest58() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setQueryLanguages(Arrays.asList(SupportedLanguage.EN)).setIgnorePlurals(IgnorePlurals.of(true))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"queryLanguages\":[\"en\"],\"ignorePlurals\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("searchableAttributesInMovies")
  void setSettingsTest59() {
    assertDoesNotThrow(() -> {
      client.setSettings("movies", new IndexSettings().setSearchableAttributes(Arrays.asList("title_eng", "title_fr", "title_es")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/movies/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"searchableAttributes\":[\"title_eng\",\"title_fr\",\"title_es\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("disablePrefixOnAttributes")
  void setSettingsTest60() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setDisablePrefixOnAttributes(Arrays.asList("serial_number")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"disablePrefixOnAttributes\":[\"serial_number\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("disableTypoToleranceOnAttributes")
  void setSettingsTest61() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setDisableTypoToleranceOnAttributes(Arrays.asList("serial_number")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"disableTypoToleranceOnAttributes\":[\"serial_number\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("searchableAttributesSimpleExample")
  void setSettingsTest62() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setSearchableAttributes(Arrays.asList("serial_number")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"searchableAttributes\":[\"serial_number\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("searchableAttributesSimpleExampleAlt")
  void setSettingsTest63() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setSearchableAttributes(Arrays.asList("serial_number", "serial_number_suffixes"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"searchableAttributes\":[\"serial_number\",\"serial_number_suffixes\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_searchable_attributes")
  void setSettingsTest64() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setSearchableAttributes(
          Arrays.asList("title,alternative_title", "author", "unordered(text)", "emails.personal")
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"searchableAttributes\":[\"title,alternative_title\",\"author\",\"unordered(text)\",\"emails.personal\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("set_attributes_for_faceting")
  void setSettingsTest65() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setAttributesForFaceting(
          Arrays.asList(
            "author",
            "filterOnly(isbn)",
            "searchable(edition)",
            "afterDistinct(category)",
            "afterDistinct(searchable(publisher))"
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"attributesForFaceting\":[\"author\",\"filterOnly(isbn)\",\"searchable(edition)\",\"afterDistinct(category)\",\"afterDistinct(searchable(publisher))\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("unretrievable_attributes")
  void setSettingsTest66() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setUnretrievableAttributes(Arrays.asList("total_number_of_sales")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"unretrievableAttributes\":[\"total_number_of_sales\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_retrievable_attributes")
  void setSettingsTest67() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributesToRetrieve(Arrays.asList("author", "title", "content")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesToRetrieve\":[\"author\",\"title\",\"content\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_all_attributes_as_retrievable")
  void setSettingsTest68() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributesToRetrieve(Arrays.asList("*")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributesToRetrieve\":[\"*\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("specify_attributes_not_to_retrieve")
  void setSettingsTest69() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributesToRetrieve(Arrays.asList("*", "-SKU", "-internal_desc")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesToRetrieve\":[\"*\",\"-SKU\",\"-internal_desc\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("neural_search")
  void setSettingsTest70() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMode(Mode.NEURAL_SEARCH));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"mode\":\"neuralSearch\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("keyword_search")
  void setSettingsTest71() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMode(Mode.KEYWORD_SEARCH));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"mode\":\"keywordSearch\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_ranking")
  void setSettingsTest72() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setRanking(Arrays.asList("typo", "geo", "words", "filters", "attribute", "proximity", "exact", "custom"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"ranking\":[\"typo\",\"geo\",\"words\",\"filters\",\"attribute\",\"proximity\",\"exact\",\"custom\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("set_ranking_by_attribute_asc")
  void setSettingsTest73() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setRanking(
          Arrays.asList("asc(price)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom")
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"ranking\":[\"asc(price)\",\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\",\"custom\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("set_ranking_by_attribute_desc")
  void setSettingsTest74() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setRanking(
          Arrays.asList("desc(price)", "typo", "geo", "words", "filters", "proximity", "attribute", "exact", "custom")
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"ranking\":[\"desc(price)\",\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\",\"custom\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("set_custom_ranking")
  void setSettingsTest75() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setCustomRanking(Arrays.asList("desc(popularity)", "asc(price)")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"customRanking\":[\"desc(popularity)\",\"asc(price)\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_default_relevancy")
  void setSettingsTest76() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setRelevancyStrictness(90));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"relevancyStrictness\":90}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_replicas")
  void setSettingsTest77() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setReplicas(Arrays.asList("name_of_replica_index1", "name_of_replica_index2"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"replicas\":[\"name_of_replica_index1\",\"name_of_replica_index2\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_default_max_values_per_facet")
  void setSettingsTest78() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMaxValuesPerFacet(100));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"maxValuesPerFacet\":100}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_sort_facet_values_by")
  void setSettingsTest79() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setSortFacetValuesBy("alpha"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"sortFacetValuesBy\":\"alpha\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_attributes_to_snippet")
  void setSettingsTest80() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributesToSnippet(Arrays.asList("content:80", "description")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributesToSnippet\":[\"content:80\",\"description\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_all_attributes_to_snippet")
  void setSettingsTest81() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributesToSnippet(Arrays.asList("*:80")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributesToSnippet\":[\"*:80\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_highlight_pre_tag")
  void setSettingsTest82() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setHighlightPreTag("<em>"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"highlightPreTag\":\"<em>\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_highlight_post_tag")
  void setSettingsTest83() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setHighlightPostTag("</em>"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"highlightPostTag\":\"</em>\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_snippet_ellipsis_text")
  void setSettingsTest84() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setSnippetEllipsisText("…"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"snippetEllipsisText\":\"…\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("enable_restrict_highlight_and_snippet_arrays_by_default")
  void setSettingsTest85() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setRestrictHighlightAndSnippetArrays(true));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"restrictHighlightAndSnippetArrays\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_hits_per_page")
  void setSettingsTest86() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setHitsPerPage(20));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"hitsPerPage\":20}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_pagination_limit")
  void setSettingsTest87() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setPaginationLimitedTo(1000));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"paginationLimitedTo\":1000}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_min_word_size_for_one_typo")
  void setSettingsTest88() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMinWordSizefor1Typo(4));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"minWordSizefor1Typo\":4}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_min_word_size_for_two_typos")
  void setSettingsTest89() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMinWordSizefor2Typos(4));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"minWordSizefor2Typos\":4}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_typo_tolerance_mode")
  void setSettingsTest90() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setTypoTolerance(TypoTolerance.of(true)));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"typoTolerance\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("disable_typos_on_numeric_tokens_by_default")
  void setSettingsTest91() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAllowTyposOnNumericTokens(false));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"allowTyposOnNumericTokens\":false}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("disable_typo_tolerance_for_words")
  void setSettingsTest92() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setDisableTypoToleranceOnWords(Arrays.asList("wheel", "1X2BCD")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"disableTypoToleranceOnWords\":[\"wheel\",\"1X2BCD\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_separators_to_index")
  void setSettingsTest93() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setSeparatorsToIndex("+#"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"separatorsToIndex\":\"+#\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_querylanguage_ignoreplurals")
  void setSettingsTest94() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setQueryLanguages(Arrays.asList(SupportedLanguage.ES)).setIgnorePlurals(IgnorePlurals.of(true))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"queryLanguages\":[\"es\"],\"ignorePlurals\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_attributes_to_transliterate")
  void setSettingsTest95() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings()
          .setIndexLanguages(Arrays.asList(SupportedLanguage.JA))
          .setAttributesToTransliterate(Arrays.asList("name", "description"))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"indexLanguages\":[\"ja\"],\"attributesToTransliterate\":[\"name\",\"description\"]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("set_querylanguage_removestopwords")
  void setSettingsTest96() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setQueryLanguages(Arrays.asList(SupportedLanguage.ES)).setRemoveStopWords(RemoveStopWords.of(true))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"queryLanguages\":[\"es\"],\"removeStopWords\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_camel_case_attributes")
  void setSettingsTest97() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setCamelCaseAttributes(Arrays.asList("description")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"camelCaseAttributes\":[\"description\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_decompounded_attributes")
  void setSettingsTest98() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setDecompoundedAttributes(
          new HashMap() {
            {
              put("de", Arrays.asList("name"));
            }
          }
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"decompoundedAttributes\":{\"de\":[\"name\"]}}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_decompounded_multiple_attributes")
  void setSettingsTest99() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setDecompoundedAttributes(
          new HashMap() {
            {
              put("de", Arrays.asList("name_de", "description_de"));
              put("fi", Arrays.asList("name_fi", "description_fi"));
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
        "{\"decompoundedAttributes\":{\"de\":[\"name_de\",\"description_de\"],\"fi\":[\"name_fi\",\"description_fi\"]}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("set_keep_diacritics_on_characters")
  void setSettingsTest100() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setKeepDiacriticsOnCharacters("øé"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"keepDiacriticsOnCharacters\":\"øé\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_custom_normalization")
  void setSettingsTest101() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setCustomNormalization(
          new HashMap() {
            {
              put(
                "default",
                new HashMap() {
                  {
                    put("ä", "ae");
                  }
                }
              );
            }
          }
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"customNormalization\":{\"default\":{\"ä\":\"ae\"}}}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_querylanguage_both")
  void setSettingsTest102() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings()
          .setQueryLanguages(Arrays.asList(SupportedLanguage.ES))
          .setRemoveStopWords(RemoveStopWords.of(true))
          .setIgnorePlurals(IgnorePlurals.of(true))
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"queryLanguages\":[\"es\"],\"removeStopWords\":true,\"ignorePlurals\":true}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("set_indexlanguages")
  void setSettingsTest103() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setIndexLanguages(Arrays.asList(SupportedLanguage.JA)));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"indexLanguages\":[\"ja\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("enable_decompound_query_by_default")
  void setSettingsTest104() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setDecompoundQuery(true));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"decompoundQuery\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("enable_rules_syntax_by_default")
  void setSettingsTest105() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setEnableRules(true));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"enableRules\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("enable_personalization_settings")
  void setSettingsTest106() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setEnablePersonalization(true));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"enablePersonalization\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_query_type")
  void setSettingsTest107() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setQueryType(QueryType.PREFIX_LAST));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"queryType\":\"prefixLast\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_remove_words_if_no_result")
  void setSettingsTest108() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setRemoveWordsIfNoResults(RemoveWordsIfNoResults.NONE));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"removeWordsIfNoResults\":\"none\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("enable_advanced_syntax_by_default")
  void setSettingsTest109() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAdvancedSyntax(true));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"advancedSyntax\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_optional_words")
  void setSettingsTest110() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setOptionalWords(OptionalWords.of(Arrays.asList("blue", "iphone case"))));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"optionalWords\":[\"blue\",\"iphone case\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("disabling_prefix_search_for_some_attributes_by_default")
  void setSettingsTest111() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setDisablePrefixOnAttributes(Arrays.asList("sku")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"disablePrefixOnAttributes\":[\"sku\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("disabling_exact_for_some_attributes_by_default")
  void setSettingsTest112() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setDisableExactOnAttributes(Arrays.asList("description")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"disableExactOnAttributes\":[\"description\"]}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_exact_single_word_query")
  void setSettingsTest113() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setExactOnSingleWordQuery(ExactOnSingleWordQuery.ATTRIBUTE));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"exactOnSingleWordQuery\":\"attribute\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_aternative_as_exact")
  void setSettingsTest114() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setAlternativesAsExact(
          Arrays.asList(AlternativesAsExact.IGNORE_PLURALS, AlternativesAsExact.SINGLE_WORD_SYNONYM)
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"alternativesAsExact\":[\"ignorePlurals\",\"singleWordSynonym\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_numeric_attributes_for_filtering")
  void setSettingsTest115() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setNumericAttributesForFiltering(Arrays.asList("quantity", "popularity")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"numericAttributesForFiltering\":[\"quantity\",\"popularity\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("enable_compression_of_integer_array")
  void setSettingsTest116() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAllowCompressionOfIntegerArray(true));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"allowCompressionOfIntegerArray\":true}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_attributes_for_distinct")
  void setSettingsTest117() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributeForDistinct("url"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"attributeForDistinct\":\"url\"}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_distinct")
  void setSettingsTest118() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setDistinct(Distinct.of(1)).setAttributeForDistinct("url"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"distinct\":1,\"attributeForDistinct\":\"url\"}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_replace_synonyms_in_highlights")
  void setSettingsTest119() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setReplaceSynonymsInHighlight(false));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"replaceSynonymsInHighlight\":false}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_min_proximity")
  void setSettingsTest120() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMinProximity(1));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"minProximity\":1}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_default_field")
  void setSettingsTest121() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setResponseFields(Arrays.asList("hits", "hitsPerPage", "nbPages", "page")));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"responseFields\":[\"hits\",\"hitsPerPage\",\"nbPages\",\"page\"]}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_max_facet_hits")
  void setSettingsTest122() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setMaxFacetHits(10));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{\"maxFacetHits\":10}", req.body, JSONCompareMode.STRICT));
  }

  @Test
  @DisplayName("set_attribute_criteria_computed_by_min_proximity")
  void setSettingsTest123() {
    assertDoesNotThrow(() -> {
      client.setSettings("theIndexName", new IndexSettings().setAttributeCriteriaComputedByMinProximity(true));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals("{\"attributeCriteriaComputedByMinProximity\":true}", req.body, JSONCompareMode.STRICT)
    );
  }

  @Test
  @DisplayName("set_user_data")
  void setSettingsTest124() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setUserData(
          new HashMap() {
            {
              put("extraData", "This is the custom data that you want to store in your index");
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
        "{\"userData\":{\"extraData\":\"This is the custom data that you want to store in" + " your index\"}}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("set_rendering_content")
  void setSettingsTest125() {
    assertDoesNotThrow(() -> {
      client.setSettings(
        "theIndexName",
        new IndexSettings().setRenderingContent(
          new RenderingContent().setFacetOrdering(
            new FacetOrdering()
              .setFacets(new Facets().setOrder(Arrays.asList("size", "brand")))
              .setValues(
                new HashMap() {
                  {
                    put(
                      "brand",
                      new Value().setOrder(Arrays.asList("uniqlo")).setHide(Arrays.asList("muji")).setSortRemainingBy(SortRemainingBy.COUNT)
                    );
                    put("size", new Value().setOrder(Arrays.asList("S", "M", "L")).setSortRemainingBy(SortRemainingBy.HIDDEN));
                  }
                }
              )
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/theIndexName/settings", req.path);
    assertEquals("PUT", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"renderingContent\":{\"facetOrdering\":{\"facets\":{\"order\":[\"size\",\"brand\"]},\"values\":{\"brand\":{\"order\":[\"uniqlo\"],\"hide\":[\"muji\"],\"sortRemainingBy\":\"count\"},\"size\":{\"order\":[\"S\",\"M\",\"L\"],\"sortRemainingBy\":\"hidden\"}}}}}",
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
