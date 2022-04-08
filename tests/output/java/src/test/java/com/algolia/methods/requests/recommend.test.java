package com.algolia.methods.requests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.algolia.model.recommend.*;
import com.algolia.utils.echo.*;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RecommendApiTests {

  private RecommendApi client;

  @BeforeAll
  void init() {
    client = new RecommendApi("appId", "apiKey", new EchoRequester());
  }

  @Test
  @DisplayName(
    "get recommendations for recommend model with minimal parameters"
  )
  void getRecommendationsTest0() {
    GetRecommendationsParams getRecommendationsParams0 = new GetRecommendationsParams();
    {
      List requests1 = new ArrayList();
      {
        RecommendationRequest requests_02 = new RecommendationRequest();
        {
          String indexName3 = "indexName";

          requests_02.setIndexName(indexName3);
          String objectID3 = "objectID";

          requests_02.setObjectID(objectID3);

          RecommendationModels model3 = RecommendationModels.fromValue(
            "related-products"
          );

          requests_02.setModel(model3);

          int threshold3 = 42;

          requests_02.setThreshold(threshold3);
        }
        requests1.add(requests_02);
      }

      getRecommendationsParams0.setRequests(requests1);
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getRecommendations(getRecommendationsParams0);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/*/recommendations");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get recommendations for recommend model with all parameters")
  void getRecommendationsTest1() {
    GetRecommendationsParams getRecommendationsParams0 = new GetRecommendationsParams();
    {
      List requests1 = new ArrayList();
      {
        RecommendationRequest requests_02 = new RecommendationRequest();
        {
          String indexName3 = "indexName";

          requests_02.setIndexName(indexName3);
          String objectID3 = "objectID";

          requests_02.setObjectID(objectID3);

          RecommendationModels model3 = RecommendationModels.fromValue(
            "related-products"
          );

          requests_02.setModel(model3);

          int threshold3 = 42;

          requests_02.setThreshold(threshold3);

          int maxRecommendations3 = 10;

          requests_02.setMaxRecommendations(maxRecommendations3);

          SearchParamsObject queryParameters3 = new SearchParamsObject();
          {
            String query4 = "myQuery";

            queryParameters3.setQuery(query4);

            List facetFilters4 = new ArrayList();
            {
              String facetFilters_05 = "query";

              facetFilters4.add(facetFilters_05);
            }

            queryParameters3.setFacetFilters(facetFilters4);
          }
          requests_02.setQueryParameters(queryParameters3);

          SearchParamsObject fallbackParameters3 = new SearchParamsObject();
          {
            String query4 = "myQuery";

            fallbackParameters3.setQuery(query4);

            List facetFilters4 = new ArrayList();
            {
              String facetFilters_05 = "fallback";

              facetFilters4.add(facetFilters_05);
            }

            fallbackParameters3.setFacetFilters(facetFilters4);
          }
          requests_02.setFallbackParameters(fallbackParameters3);
        }
        requests1.add(requests_02);
      }

      getRecommendationsParams0.setRequests(requests1);
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getRecommendations(getRecommendationsParams0);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/*/recommendations");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName\",\"objectID\":\"objectID\",\"model\":\"related-products\",\"threshold\":42,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get recommendations for trending model with minimal parameters")
  void getRecommendationsTest2() {
    GetRecommendationsParams getRecommendationsParams0 = new GetRecommendationsParams();
    {
      List requests1 = new ArrayList();
      {
        TrendingRequest requests_02 = new TrendingRequest();
        {
          String indexName3 = "indexName";

          requests_02.setIndexName(indexName3);

          TrendingModels model3 = TrendingModels.fromValue("trending-items");

          requests_02.setModel(model3);

          int threshold3 = 42;

          requests_02.setThreshold(threshold3);
        }
        requests1.add(requests_02);
      }

      getRecommendationsParams0.setRequests(requests1);
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getRecommendations(getRecommendationsParams0);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/*/recommendations");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get recommendations for trending model with all parameters")
  void getRecommendationsTest3() {
    GetRecommendationsParams getRecommendationsParams0 = new GetRecommendationsParams();
    {
      List requests1 = new ArrayList();
      {
        TrendingRequest requests_02 = new TrendingRequest();
        {
          String indexName3 = "indexName";

          requests_02.setIndexName(indexName3);

          TrendingModels model3 = TrendingModels.fromValue("trending-items");

          requests_02.setModel(model3);

          int threshold3 = 42;

          requests_02.setThreshold(threshold3);

          int maxRecommendations3 = 10;

          requests_02.setMaxRecommendations(maxRecommendations3);
          String facetName3 = "myFacetName";

          requests_02.setFacetName(facetName3);
          String facetValue3 = "myFacetValue";

          requests_02.setFacetValue(facetValue3);

          SearchParamsObject queryParameters3 = new SearchParamsObject();
          {
            String query4 = "myQuery";

            queryParameters3.setQuery(query4);

            List facetFilters4 = new ArrayList();
            {
              String facetFilters_05 = "query";

              facetFilters4.add(facetFilters_05);
            }

            queryParameters3.setFacetFilters(facetFilters4);
          }
          requests_02.setQueryParameters(queryParameters3);

          SearchParamsObject fallbackParameters3 = new SearchParamsObject();
          {
            String query4 = "myQuery";

            fallbackParameters3.setQuery(query4);

            List facetFilters4 = new ArrayList();
            {
              String facetFilters_05 = "fallback";

              facetFilters4.add(facetFilters_05);
            }

            fallbackParameters3.setFacetFilters(facetFilters4);
          }
          requests_02.setFallbackParameters(fallbackParameters3);
        }
        requests1.add(requests_02);
      }

      getRecommendationsParams0.setRequests(requests1);
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getRecommendations(getRecommendationsParams0);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/*/recommendations");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName\",\"model\":\"trending-items\",\"threshold\":42,\"maxRecommendations\":10,\"facetName\":\"myFacetName\",\"facetValue\":\"myFacetValue\",\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback\"]}}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get multiple recommendations with minimal parameters")
  void getRecommendationsTest4() {
    GetRecommendationsParams getRecommendationsParams0 = new GetRecommendationsParams();
    {
      List requests1 = new ArrayList();
      {
        RecommendationRequest requests_02 = new RecommendationRequest();
        {
          String indexName3 = "indexName1";

          requests_02.setIndexName(indexName3);
          String objectID3 = "objectID1";

          requests_02.setObjectID(objectID3);

          RecommendationModels model3 = RecommendationModels.fromValue(
            "related-products"
          );

          requests_02.setModel(model3);

          int threshold3 = 21;

          requests_02.setThreshold(threshold3);
        }
        requests1.add(requests_02);

        RecommendationRequest requests_12 = new RecommendationRequest();
        {
          String indexName3 = "indexName2";

          requests_12.setIndexName(indexName3);
          String objectID3 = "objectID2";

          requests_12.setObjectID(objectID3);

          RecommendationModels model3 = RecommendationModels.fromValue(
            "related-products"
          );

          requests_12.setModel(model3);

          int threshold3 = 21;

          requests_12.setThreshold(threshold3);
        }
        requests1.add(requests_12);
      }

      getRecommendationsParams0.setRequests(requests1);
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getRecommendations(getRecommendationsParams0);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/*/recommendations");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get multiple recommendations with all parameters")
  void getRecommendationsTest5() {
    GetRecommendationsParams getRecommendationsParams0 = new GetRecommendationsParams();
    {
      List requests1 = new ArrayList();
      {
        RecommendationRequest requests_02 = new RecommendationRequest();
        {
          String indexName3 = "indexName1";

          requests_02.setIndexName(indexName3);
          String objectID3 = "objectID1";

          requests_02.setObjectID(objectID3);

          RecommendationModels model3 = RecommendationModels.fromValue(
            "related-products"
          );

          requests_02.setModel(model3);

          int threshold3 = 21;

          requests_02.setThreshold(threshold3);

          int maxRecommendations3 = 10;

          requests_02.setMaxRecommendations(maxRecommendations3);

          SearchParamsObject queryParameters3 = new SearchParamsObject();
          {
            String query4 = "myQuery";

            queryParameters3.setQuery(query4);

            List facetFilters4 = new ArrayList();
            {
              String facetFilters_05 = "query1";

              facetFilters4.add(facetFilters_05);
            }

            queryParameters3.setFacetFilters(facetFilters4);
          }
          requests_02.setQueryParameters(queryParameters3);

          SearchParamsObject fallbackParameters3 = new SearchParamsObject();
          {
            String query4 = "myQuery";

            fallbackParameters3.setQuery(query4);

            List facetFilters4 = new ArrayList();
            {
              String facetFilters_05 = "fallback1";

              facetFilters4.add(facetFilters_05);
            }

            fallbackParameters3.setFacetFilters(facetFilters4);
          }
          requests_02.setFallbackParameters(fallbackParameters3);
        }
        requests1.add(requests_02);

        RecommendationRequest requests_12 = new RecommendationRequest();
        {
          String indexName3 = "indexName2";

          requests_12.setIndexName(indexName3);
          String objectID3 = "objectID2";

          requests_12.setObjectID(objectID3);

          RecommendationModels model3 = RecommendationModels.fromValue(
            "related-products"
          );

          requests_12.setModel(model3);

          int threshold3 = 21;

          requests_12.setThreshold(threshold3);

          int maxRecommendations3 = 10;

          requests_12.setMaxRecommendations(maxRecommendations3);

          SearchParamsObject queryParameters3 = new SearchParamsObject();
          {
            String query4 = "myQuery";

            queryParameters3.setQuery(query4);

            List facetFilters4 = new ArrayList();
            {
              String facetFilters_05 = "query2";

              facetFilters4.add(facetFilters_05);
            }

            queryParameters3.setFacetFilters(facetFilters4);
          }
          requests_12.setQueryParameters(queryParameters3);

          SearchParamsObject fallbackParameters3 = new SearchParamsObject();
          {
            String query4 = "myQuery";

            fallbackParameters3.setQuery(query4);

            List facetFilters4 = new ArrayList();
            {
              String facetFilters_05 = "fallback2";

              facetFilters4.add(facetFilters_05);
            }

            fallbackParameters3.setFacetFilters(facetFilters4);
          }
          requests_12.setFallbackParameters(fallbackParameters3);
        }
        requests1.add(requests_12);
      }

      getRecommendationsParams0.setRequests(requests1);
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getRecommendations(getRecommendationsParams0);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/*/recommendations");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"related-products\",\"threshold\":21,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query1\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback1\"]}},{\"indexName\":\"indexName2\",\"objectID\":\"objectID2\",\"model\":\"related-products\",\"threshold\":21,\"maxRecommendations\":10,\"queryParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"query2\"]},\"fallbackParameters\":{\"query\":\"myQuery\",\"facetFilters\":[\"fallback2\"]}}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }

  @Test
  @DisplayName("get frequently bought together recommendations")
  void getRecommendationsTest6() {
    GetRecommendationsParams getRecommendationsParams0 = new GetRecommendationsParams();
    {
      List requests1 = new ArrayList();
      {
        RecommendationRequest requests_02 = new RecommendationRequest();
        {
          String indexName3 = "indexName1";

          requests_02.setIndexName(indexName3);
          String objectID3 = "objectID1";

          requests_02.setObjectID(objectID3);

          RecommendationModels model3 = RecommendationModels.fromValue(
            "bought-together"
          );

          requests_02.setModel(model3);

          int threshold3 = 42;

          requests_02.setThreshold(threshold3);
        }
        requests1.add(requests_02);
      }

      getRecommendationsParams0.setRequests(requests1);
    }

    EchoResponseInterface req = (EchoResponseInterface) assertDoesNotThrow(() -> {
        return client.getRecommendations(getRecommendationsParams0);
      }
    );

    assertEquals(req.getPath(), "/1/indexes/*/recommendations");
    assertEquals(req.getMethod(), "POST");

    assertDoesNotThrow(() -> {
      JSONAssert.assertEquals(
        "{\"requests\":[{\"indexName\":\"indexName1\",\"objectID\":\"objectID1\",\"model\":\"bought-together\",\"threshold\":42}]}",
        req.getBody(),
        JSONCompareMode.STRICT_ORDER
      );
    });
  }
}
