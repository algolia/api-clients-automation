package com.algolia.methods.snippets;

import com.algolia.api.RecommendClient;
import com.algolia.model.recommend.*;

class SnippetRecommendClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customDelete("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customGet("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPost("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPut("/test/minimal");
    // SEPARATOR<
  }

  // Snippet for the deleteRecommendRule method.
  //
  // deleteRecommendRule0
  void snippetForDeleteRecommendRule() {
    // >SEPARATOR deleteRecommendRule
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteRecommendRule("indexName", RecommendModels.fromValue("related-products"), "objectID");
    // SEPARATOR<
  }

  // Snippet for the getRecommendRule method.
  //
  // getRecommendRule0
  void snippetForGetRecommendRule() {
    // >SEPARATOR getRecommendRule
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getRecommendRule("indexName", RecommendModels.fromValue("related-products"), "objectID");
    // SEPARATOR<
  }

  // Snippet for the getRecommendStatus method.
  //
  // getRecommendStatus0
  void snippetForGetRecommendStatus() {
    // >SEPARATOR getRecommendStatus
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getRecommendStatus("indexName", RecommendModels.fromValue("related-products"), 12345L);
    // SEPARATOR<
  }

  // Snippet for the getRecommendations method.
  //
  // get recommendations for recommend model with minimal parameters
  void snippetForGetRecommendations() {
    // >SEPARATOR getRecommendations
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
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
    // SEPARATOR<
  }

  // Snippet for the searchRecommendRules method.
  //
  // searchRecommendRules0
  void snippetForSearchRecommendRules() {
    // >SEPARATOR searchRecommendRules
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchRecommendRules("indexName", RecommendModels.fromValue("related-products"));
    // SEPARATOR<
  }
}
