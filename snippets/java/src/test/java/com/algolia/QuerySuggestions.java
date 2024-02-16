package com.algolia.methods.snippets;

import com.algolia.api.QuerySuggestionsClient;
import com.algolia.model.querysuggestions.*;

class SnippetQuerySuggestionsClient {

  // Snippet for the createConfig method.
  //
  // createConfig0
  void snippetForCreateConfig() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createConfig(
      new QuerySuggestionsConfigurationWithIndex()
        .setIndexName("theIndexName")
        .setSourceIndices(
          List.of(
            new SourceIndex()
              .setIndexName("testIndex")
              .setFacets(List.of(new Facet().setAttribute("test")))
              .setGenerate(List.of(List.of("facetA", "facetB"), List.of("facetC")))
          )
        )
        .setLanguages(Languages.of(List.of("french")))
        .setExclude(List.of("test"))
    );
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("/test/minimal");
  }

  // Snippet for the deleteConfig method.
  //
  // deleteConfig0
  void snippetForDeleteConfig() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteConfig("theIndexName");
  }

  // Snippet for the getAllConfigs method.
  //
  // getAllConfigs0
  void snippetForGetAllConfigs() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getAllConfigs();
  }

  // Snippet for the getConfig method.
  //
  // Retrieve QS config e2e
  void snippetForGetConfig() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getConfig("cts_e2e_browse_query_suggestions");
  }

  // Snippet for the getConfigStatus method.
  //
  // getConfigStatus0
  void snippetForGetConfigStatus() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getConfigStatus("theIndexName");
  }

  // Snippet for the getLogFile method.
  //
  // getLogFile0
  void snippetForGetLogFile() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getLogFile("theIndexName");
  }

  // Snippet for the updateConfig method.
  //
  // updateConfig0
  void snippetForUpdateConfig() {
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateConfig(
      "theIndexName",
      new QuerySuggestionsConfiguration()
        .setSourceIndices(
          List.of(
            new SourceIndex()
              .setIndexName("testIndex")
              .setFacets(List.of(new Facet().setAttribute("test")))
              .setGenerate(List.of(List.of("facetA", "facetB"), List.of("facetC")))
          )
        )
        .setLanguages(Languages.of(List.of("french")))
        .setExclude(List.of("test"))
    );
  }
}
