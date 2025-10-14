package com.algolia.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import com.algolia.EchoInterceptor;
import com.algolia.EchoResponse;
import com.algolia.api.RecommendClient;
import com.algolia.config.*;
import com.algolia.model.recommend.*;
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
class RecommendClientRequestsTests {

  private RecommendClient client;
  private EchoInterceptor echo;
  private ObjectMapper json;

  @BeforeAll
  void init() {
    this.json = JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();
    this.echo = new EchoInterceptor();
    ClientOptions options = ClientOptions.builder()
      .setRequesterConfig(requester -> requester.addInterceptor(echo))
      .build();
    this.client = new RecommendClient("appId", "apiKey", options);
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
  }

  @Test
  @DisplayName("batch recommend rules")
  void batchRecommendRulesTest() {
    assertDoesNotThrow(() -> {
      client.batchRecommendRules("indexName", RecommendModels.RELATED_PRODUCTS);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/related-products/recommend/rules/batch", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
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
  @DisplayName("deleteRecommendRule")
  void deleteRecommendRuleTest() {
    assertDoesNotThrow(() -> {
      client.deleteRecommendRule("indexName", RecommendModels.RELATED_PRODUCTS, "objectID");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/related-products/recommend/rules/objectID", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getRecommendRule")
  void getRecommendRuleTest() {
    assertDoesNotThrow(() -> {
      client.getRecommendRule("indexName", RecommendModels.RELATED_PRODUCTS, "objectID");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/related-products/recommend/rules/objectID", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getRecommendStatus")
  void getRecommendStatusTest() {
    assertDoesNotThrow(() -> {
      client.getRecommendStatus("indexName", RecommendModels.RELATED_PRODUCTS, 12345L);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/related-products/task/12345", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("get recommendations for recommend model with minimal parameters")
  void getRecommendationsTest() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams().setRequests(
          Arrays.asList(
            new RelatedQuery().setIndexName("indexName").setObjectID("objectID").setModel(RelatedModel.RELATED_PRODUCTS).setThreshold(42.1)
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42.1}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get recommendations with e2e to check oneOf model")
  void getRecommendationsTest1() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
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
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"cts_e2e_browse\",\"objectID\":\"Æon" +
          " Flux\",\"model\":\"related-products\",\"threshold\":20.0,\"maxRecommendations\":2}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get recommendations for recommend model with all parameters")
  void getRecommendationsTest2() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams().setRequests(
          Arrays.asList(
            new RelatedQuery()
              .setIndexName("indexName")
              .setObjectID("objectID")
              .setModel(RelatedModel.RELATED_PRODUCTS)
              .setThreshold(42.1)
              .setMaxRecommendations(10)
              .setQueryParameters(
                new RecommendSearchParams().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("query"))))
              )
              .setFallbackParameters(
                new FallbackParams().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("fallback"))))
              )
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42.1,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get recommendations for trending model with minimal parameters")
  void getRecommendationsTest3() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams().setRequests(
          Arrays.asList(
            new TrendingItemsQuery()
              .setIndexName("indexName")
              .setModel(TrendingItemsModel.TRENDING_ITEMS)
              .setThreshold(42.1)
              .setFacetName("facet")
              .setFacetValue("value")
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42.1,\"facetName\":\"facet\",\"facetValue\":\"value\"}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get recommendations for trending model with all parameters")
  void getRecommendationsTest4() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams().setRequests(
          Arrays.asList(
            new TrendingItemsQuery()
              .setIndexName("indexName")
              .setModel(TrendingItemsModel.TRENDING_ITEMS)
              .setThreshold(42.1)
              .setMaxRecommendations(10)
              .setFacetName("myFacetName")
              .setFacetValue("myFacetValue")
              .setQueryParameters(
                new RecommendSearchParams().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("query"))))
              )
              .setFallbackParameters(
                new FallbackParams().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("fallback"))))
              )
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42.1,\"maxRecommendations\":10,\"facetName\":\"myFacetName\",\"facetValue\":\"myFacetValue\",\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get multiple recommendations with minimal parameters")
  void getRecommendationsTest5() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams().setRequests(
          Arrays.asList(
            new RelatedQuery()
              .setIndexName("indexName1")
              .setObjectID("objectID1")
              .setModel(RelatedModel.RELATED_PRODUCTS)
              .setThreshold(21.7),
            new RelatedQuery()
              .setIndexName("indexName2")
              .setObjectID("objectID2")
              .setModel(RelatedModel.RELATED_PRODUCTS)
              .setThreshold(21.7)
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21.7},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21.7}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get multiple recommendations with all parameters")
  void getRecommendationsTest6() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams().setRequests(
          Arrays.asList(
            new RelatedQuery()
              .setIndexName("indexName1")
              .setObjectID("objectID1")
              .setModel(RelatedModel.RELATED_PRODUCTS)
              .setThreshold(21.7)
              .setMaxRecommendations(10)
              .setQueryParameters(
                new RecommendSearchParams().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("query1"))))
              )
              .setFallbackParameters(
                new FallbackParams().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("fallback1"))))
              ),
            new RelatedQuery()
              .setIndexName("indexName2")
              .setObjectID("objectID2")
              .setModel(RelatedModel.RELATED_PRODUCTS)
              .setThreshold(21.7)
              .setMaxRecommendations(10)
              .setQueryParameters(
                new RecommendSearchParams().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("query2"))))
              )
              .setFallbackParameters(
                new FallbackParams().setQuery("myQuery").setFacetFilters(FacetFilters.of(Arrays.asList(FacetFilters.of("fallback2"))))
              )
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21.7,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query1\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback1\"]}},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21.7,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query2\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback2\"]}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get frequently bought together recommendations")
  void getRecommendationsTest7() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams().setRequests(
          Arrays.asList(
            new BoughtTogetherQuery()
              .setIndexName("indexName1")
              .setObjectID("objectID1")
              .setModel(FbtModel.BOUGHT_TOGETHER)
              .setThreshold(42.7)
          )
        )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"bought-together\",\"threshold\":42.7}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchRecommendRules")
  void searchRecommendRulesTest() {
    assertDoesNotThrow(() -> {
      client.searchRecommendRules("indexName", RecommendModels.RELATED_PRODUCTS);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/related-products/recommend/rules/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }
}
