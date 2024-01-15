package com.algolia.methods.snippets;

import com.algolia.api.RecommendClient;
import com.algolia.model.recommend.*;

class SnippetRecommendClient {

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void SnippetForCustomDelete() {
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void SnippetForCustomGet() {
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void SnippetForCustomPost() {
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void SnippetForCustomPut() {
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.customPut("/test/minimal");
  }

  // Snippet for the deleteRecommendRule method.
  //
  // deleteRecommendRule0
  void SnippetForDeleteRecommendRule() {
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.deleteRecommendRule("indexName", RecommendModels.fromValue("related-products"), "objectID");
  }

  // Snippet for the getRecommendRule method.
  //
  // getRecommendRule0
  void SnippetForGetRecommendRule() {
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getRecommendRule("indexName", RecommendModels.fromValue("related-products"), "objectID");
  }

  // Snippet for the getRecommendStatus method.
  //
  // getRecommendStatus0
  void SnippetForGetRecommendStatus() {
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.getRecommendStatus("indexName", RecommendModels.fromValue("related-products"), 12345L);
  }

  // Snippet for the getRecommendations method.
  //
  // get recommendations for recommend model with minimal parameters
  void SnippetForGetRecommendations() {
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

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
  void SnippetForSearchRecommendRules() {
    RecommendClient client = new RecommendClient("YOUR_APP_ID", "YOUR_API_KEY");

    client.searchRecommendRules("indexName", RecommendModels.fromValue("related-products"));
  }
}
