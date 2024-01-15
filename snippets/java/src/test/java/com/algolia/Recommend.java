package com.algolia.methods.snippets;

import com.algolia.api.RecommendClient;
import com.algolia.model.recommend.*;

class SnippetRecommendClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.customPut("/test/minimal");
  }

  // Snippet for the deleteRecommendRule method.
  //
  // deleteRecommendRule0
  void snippetForDeleteRecommendRule() {
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.deleteRecommendRule("indexName", RecommendModels.fromValue("related-products"), "objectID");
  }

  // Snippet for the getRecommendRule method.
  //
  // getRecommendRule0
  void snippetForGetRecommendRule() {
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getRecommendRule("indexName", RecommendModels.fromValue("related-products"), "objectID");
  }

  // Snippet for the getRecommendStatus method.
  //
  // getRecommendStatus0
  void snippetForGetRecommendStatus() {
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.getRecommendStatus("indexName", RecommendModels.fromValue("related-products"), 12345L);
  }

  // Snippet for the getRecommendations method.
  //
  // get recommendations for recommend model with minimal parameters
  void snippetForGetRecommendations() {
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
  }

  // Snippet for the searchRecommendRules method.
  //
  // searchRecommendRules0
  void snippetForSearchRecommendRules() {
    // Initialize the client
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    // Call the API
    client.searchRecommendRules("indexName", RecommendModels.fromValue("related-products"));
  }
}
