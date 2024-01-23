package com.algolia.methods.requests;

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
    var options = ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(echo)).build();
    this.client = new RecommendClient("appId", "apiKey", options);
  }

  @AfterAll
  void tearUp() throws Exception {
    client.close();
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
  @DisplayName("deleteRecommendRule0")
  void deleteRecommendRuleTest0() {
    assertDoesNotThrow(() -> {
      client.deleteRecommendRule("indexName", RecommendModels.fromValue("related-products"), "objectID");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/related-products/recommend/rules/objectID", req.path);
    assertEquals("DELETE", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getRecommendRule0")
  void getRecommendRuleTest0() {
    assertDoesNotThrow(() -> {
      client.getRecommendRule("indexName", RecommendModels.fromValue("related-products"), "objectID");
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/related-products/recommend/rules/objectID", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("getRecommendStatus0")
  void getRecommendStatusTest0() {
    assertDoesNotThrow(() -> {
      client.getRecommendStatus("indexName", RecommendModels.fromValue("related-products"), 12345L);
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/related-products/task/12345", req.path);
    assertEquals("GET", req.method);
    assertNull(req.body);
  }

  @Test
  @DisplayName("get recommendations for recommend model with minimal parameters")
  void getRecommendationsTest0() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams()
          .setRequests(
            List.of(
              new RecommendationsQuery()
                .setIndexName("indexName")
                .setObjectID("objectID")
                .setModel(RecommendationModels.fromValue("related-products"))
                .setThreshold(42)
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get recommendations for recommend model with all parameters")
  void getRecommendationsTest1() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams()
          .setRequests(
            List.of(
              new RecommendationsQuery()
                .setIndexName("indexName")
                .setObjectID("objectID")
                .setModel(RecommendationModels.fromValue("related-products"))
                .setThreshold(42)
                .setMaxRecommendations(10)
                .setQueryParameters(
                  new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of("query"))))
                )
                .setFallbackParameters(
                  new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of("fallback"))))
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
        "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get recommendations for trending model with minimal parameters")
  void getRecommendationsTest2() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams()
          .setRequests(
            List.of(
              new TrendingItemsQuery().setIndexName("indexName").setModel(TrendingItemsModel.fromValue("trending-items")).setThreshold(42)
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get recommendations for trending model with all parameters")
  void getRecommendationsTest3() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams()
          .setRequests(
            List.of(
              new TrendingItemsQuery()
                .setIndexName("indexName")
                .setModel(TrendingItemsModel.fromValue("trending-items"))
                .setThreshold(42)
                .setMaxRecommendations(10)
                .setFacetName("myFacetName")
                .setFacetValue("myFacetValue")
                .setQueryParameters(
                  new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of("query"))))
                )
                .setFallbackParameters(
                  new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of("fallback"))))
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
        "{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42,\"maxRecommendations\":10,\"facetName\":\"myFacetName\",\"facetValue\":\"myFacetValue\",\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get multiple recommendations with minimal parameters")
  void getRecommendationsTest4() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams()
          .setRequests(
            List.of(
              new RecommendationsQuery()
                .setIndexName("indexName1")
                .setObjectID("objectID1")
                .setModel(RecommendationModels.fromValue("related-products"))
                .setThreshold(21),
              new RecommendationsQuery()
                .setIndexName("indexName2")
                .setObjectID("objectID2")
                .setModel(RecommendationModels.fromValue("related-products"))
                .setThreshold(21)
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get multiple recommendations with all parameters")
  void getRecommendationsTest5() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams()
          .setRequests(
            List.of(
              new RecommendationsQuery()
                .setIndexName("indexName1")
                .setObjectID("objectID1")
                .setModel(RecommendationModels.fromValue("related-products"))
                .setThreshold(21)
                .setMaxRecommendations(10)
                .setQueryParameters(
                  new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of("query1"))))
                )
                .setFallbackParameters(
                  new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of("fallback1"))))
                ),
              new RecommendationsQuery()
                .setIndexName("indexName2")
                .setObjectID("objectID2")
                .setModel(RecommendationModels.fromValue("related-products"))
                .setThreshold(21)
                .setMaxRecommendations(10)
                .setQueryParameters(
                  new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of("query2"))))
                )
                .setFallbackParameters(
                  new SearchParamsObject().setQuery("myQuery").setFacetFilters(FacetFilters.of(List.of(MixedSearchFilters.of("fallback2"))))
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
        "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query1\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback1\"]}},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query2\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback2\"]}}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("get frequently bought together recommendations")
  void getRecommendationsTest6() {
    assertDoesNotThrow(() -> {
      client.getRecommendations(
        new GetRecommendationsParams()
          .setRequests(
            List.of(
              new RecommendationsQuery()
                .setIndexName("indexName1")
                .setObjectID("objectID1")
                .setModel(RecommendationModels.fromValue("bought-together"))
                .setThreshold(42)
            )
          )
      );
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/*/recommendations", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() ->
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"bought-together\",\"threshold\":42}]}",
        req.body,
        JSONCompareMode.STRICT
      )
    );
  }

  @Test
  @DisplayName("searchRecommendRules0")
  void searchRecommendRulesTest0() {
    assertDoesNotThrow(() -> {
      client.searchRecommendRules("indexName", RecommendModels.fromValue("related-products"));
    });
    EchoResponse req = echo.getLastResponse();
    assertEquals("/1/indexes/indexName/related-products/recommend/rules/search", req.path);
    assertEquals("POST", req.method);
    assertDoesNotThrow(() -> JSONAssert.assertEquals("{}", req.body, JSONCompareMode.STRICT));
  }
}
