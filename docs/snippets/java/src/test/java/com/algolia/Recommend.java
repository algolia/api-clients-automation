package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.RecommendClient;
import com.algolia.config.*;
// IMPORT<
import com.algolia.model.recommend.*;
import java.util.*;

class SnippetRecommendClient {

  // Snippet for the batchRecommendRules method.
  //
  // batch recommend rules
  void snippetForBatchRecommendRules() throws Exception {
    // >SEPARATOR batchRecommendRules default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    RecommendUpdatedAtResponse response = client.batchRecommendRules("<YOUR_INDEX_NAME>", RecommendModels.RELATED_PRODUCTS);
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customDelete("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with all parameters
  void snippetForCustomDelete1() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customDelete(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customGet("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with all parameters
  void snippetForCustomGet1() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters with space");
        }
      }
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // requestOptions should be escaped too
  void snippetForCustomGet2() throws Exception {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customGet(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with all parameters
  void snippetForCustomPost1() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default query parameters
  void snippetForCustomPost2() throws Exception {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges query parameters with default ones
  void snippetForCustomPost3() throws Exception {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default headers
  void snippetForCustomPost4() throws Exception {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges headers with default ones
  void snippetForCustomPost5() throws Exception {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts booleans
  void snippetForCustomPost6() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts integers
  void snippetForCustomPost7() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of string
  void snippetForCustomPost8() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of booleans
  void snippetForCustomPost9() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of integers
  void snippetForCustomPost10() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPost(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPut("test/minimal");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with all parameters
  void snippetForCustomPut1() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    Object response = client.customPut(
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the deleteRecommendRule method.
  //
  // deleteRecommendRule
  void snippetForDeleteRecommendRule() throws Exception {
    // >SEPARATOR deleteRecommendRule default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    DeletedAtResponse response = client.deleteRecommendRule("<YOUR_INDEX_NAME>", RecommendModels.RELATED_PRODUCTS, "objectID");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRecommendRule method.
  //
  // getRecommendRule
  void snippetForGetRecommendRule() throws Exception {
    // >SEPARATOR getRecommendRule default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    RecommendRule response = client.getRecommendRule("<YOUR_INDEX_NAME>", RecommendModels.RELATED_PRODUCTS, "objectID");
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRecommendStatus method.
  //
  // getRecommendStatus
  void snippetForGetRecommendStatus() throws Exception {
    // >SEPARATOR getRecommendStatus default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    GetRecommendTaskResponse response = client.getRecommendStatus("<YOUR_INDEX_NAME>", RecommendModels.RELATED_PRODUCTS, 12345L);
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRecommendations method.
  //
  // get recommendations for recommend model with minimal parameters
  void snippetForGetRecommendations() throws Exception {
    // >SEPARATOR getRecommendations get recommendations for recommend model with minimal parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    GetRecommendationsResponse response = client.getRecommendations(
      new GetRecommendationsParams().setRequests(
        Arrays.asList(
          new RelatedQuery()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setObjectID("objectID")
            .setModel(RelatedModel.RELATED_PRODUCTS)
            .setThreshold(42.1)
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRecommendations method.
  //
  // get recommendations with e2e to check oneOf model
  void snippetForGetRecommendations1() throws Exception {
    // >SEPARATOR getRecommendations get recommendations with e2e to check oneOf model
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    GetRecommendationsResponse response = client.getRecommendations(
      new GetRecommendationsParams().setRequests(
        Arrays.asList(
          new RelatedQuery()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setObjectID("Æon Flux")
            .setModel(RelatedModel.RELATED_PRODUCTS)
            .setThreshold(20.0)
            .setMaxRecommendations(2)
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRecommendations method.
  //
  // get recommendations for recommend model with all parameters
  void snippetForGetRecommendations2() throws Exception {
    // >SEPARATOR getRecommendations get recommendations for recommend model with all parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    GetRecommendationsResponse response = client.getRecommendations(
      new GetRecommendationsParams().setRequests(
        Arrays.asList(
          new RelatedQuery()
            .setIndexName("<YOUR_INDEX_NAME>")
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRecommendations method.
  //
  // get recommendations for trending model with minimal parameters
  void snippetForGetRecommendations3() throws Exception {
    // >SEPARATOR getRecommendations get recommendations for trending model with minimal parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    GetRecommendationsResponse response = client.getRecommendations(
      new GetRecommendationsParams().setRequests(
        Arrays.asList(
          new TrendingItemsQuery()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setModel(TrendingItemsModel.TRENDING_ITEMS)
            .setThreshold(42.1)
            .setFacetName("facet")
            .setFacetValue("value")
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRecommendations method.
  //
  // get recommendations for trending model with all parameters
  void snippetForGetRecommendations4() throws Exception {
    // >SEPARATOR getRecommendations get recommendations for trending model with all parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    GetRecommendationsResponse response = client.getRecommendations(
      new GetRecommendationsParams().setRequests(
        Arrays.asList(
          new TrendingItemsQuery()
            .setIndexName("<YOUR_INDEX_NAME>")
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRecommendations method.
  //
  // get multiple recommendations with minimal parameters
  void snippetForGetRecommendations5() throws Exception {
    // >SEPARATOR getRecommendations get multiple recommendations with minimal parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    GetRecommendationsResponse response = client.getRecommendations(
      new GetRecommendationsParams().setRequests(
        Arrays.asList(
          new RelatedQuery()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setObjectID("objectID1")
            .setModel(RelatedModel.RELATED_PRODUCTS)
            .setThreshold(21.7),
          new RelatedQuery()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setObjectID("objectID2")
            .setModel(RelatedModel.RELATED_PRODUCTS)
            .setThreshold(21.7)
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRecommendations method.
  //
  // get multiple recommendations with all parameters
  void snippetForGetRecommendations6() throws Exception {
    // >SEPARATOR getRecommendations get multiple recommendations with all parameters
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    GetRecommendationsResponse response = client.getRecommendations(
      new GetRecommendationsParams().setRequests(
        Arrays.asList(
          new RelatedQuery()
            .setIndexName("<YOUR_INDEX_NAME>")
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
            .setIndexName("<YOUR_INDEX_NAME>")
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
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the getRecommendations method.
  //
  // get frequently bought together recommendations
  void snippetForGetRecommendations7() throws Exception {
    // >SEPARATOR getRecommendations get frequently bought together recommendations
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    GetRecommendationsResponse response = client.getRecommendations(
      new GetRecommendationsParams().setRequests(
        Arrays.asList(
          new BoughtTogetherQuery()
            .setIndexName("<YOUR_INDEX_NAME>")
            .setObjectID("objectID1")
            .setModel(FbtModel.BOUGHT_TOGETHER)
            .setThreshold(42.7)
        )
      )
    );
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the searchRecommendRules method.
  //
  // searchRecommendRules
  void snippetForSearchRecommendRules() throws Exception {
    // >SEPARATOR searchRecommendRules default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    SearchRecommendRulesResponse response = client.searchRecommendRules("<YOUR_INDEX_NAME>", RecommendModels.RELATED_PRODUCTS);
    // >LOG
    // print the response
    System.out.println(response);
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() throws Exception {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }
}
