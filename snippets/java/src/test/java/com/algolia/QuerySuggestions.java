package com.algolia.methods.snippets;

import com.algolia.api.QuerySuggestionsClient;
import com.algolia.model.querysuggestions.*;

class SnippetQuerySuggestionsClient {

  // Snippet for the createConfig method.
  //
  // createConfig0
  void SnippetForCreateConfig() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
  void SnippetForCustomDelete() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customDelete("/test/minimal");
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void SnippetForCustomGet() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customGet("/test/minimal");
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void SnippetForCustomPost() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customPost("/test/minimal");
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void SnippetForCustomPut() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.customPut("/test/minimal");
  }

  // Snippet for the deleteConfig method.
  //
  // deleteConfig0
  void SnippetForDeleteConfig() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.deleteConfig("theIndexName");
  }

  // Snippet for the getAllConfigs method.
  //
  // getAllConfigs0
  void SnippetForGetAllConfigs() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getAllConfigs();
  }

  // Snippet for the getConfig method.
  //
  // getConfig0
  void SnippetForGetConfig() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getConfig("theIndexName");
  }

  // Snippet for the getConfigStatus method.
  //
  // getConfigStatus0
  void SnippetForGetConfigStatus() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getConfigStatus("theIndexName");
  }

  // Snippet for the getLogFile method.
  //
  // getLogFile0
  void SnippetForGetLogFile() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    client.getLogFile("theIndexName");
  }

  // Snippet for the updateConfig method.
  //
  // updateConfig0
  void SnippetForUpdateConfig() {
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

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
