package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.RecommendClient;
import com.algolia.model.recommend.*;
// IMPORT<
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
    client.batchRecommendRules("<YOUR_INDEX_NAME>", RecommendModels.RELATED_PRODUCTS);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() throws Exception {
    // >SEPARATOR customDelete default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customDelete("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() throws Exception {
    // >SEPARATOR customGet default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customGet("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() throws Exception {
    // >SEPARATOR customPost default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPost("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() throws Exception {
    // >SEPARATOR customPut default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
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
    client.deleteRecommendRule("<YOUR_INDEX_NAME>", RecommendModels.RELATED_PRODUCTS, "objectID");
    // >LOG
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
    client.getRecommendRule("<YOUR_INDEX_NAME>", RecommendModels.RELATED_PRODUCTS, "objectID");
    // >LOG
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
    client.getRecommendStatus("<YOUR_INDEX_NAME>", RecommendModels.RELATED_PRODUCTS, 12345L);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getRecommendations method.
  //
  // get recommendations for recommend model with minimal parameters
  void snippetForGetRecommendations() throws Exception {
    // >SEPARATOR getRecommendations default
    // Initialize the client
    RecommendClient client = new RecommendClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.getRecommendations(
      new GetRecommendationsParams()
        .setRequests(
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
    client.searchRecommendRules("<YOUR_INDEX_NAME>", RecommendModels.RELATED_PRODUCTS);
    // >LOG
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
