package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.QuerySuggestionsClient;
import com.algolia.model.querysuggestions.*;

// IMPORT<

class SnippetQuerySuggestionsClient {

  // Snippet for the createConfig method.
  //
  // createConfig
  void snippetForCreateConfig() {
    // >SEPARATOR createConfig default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.createConfig(
      new ConfigurationWithIndex()
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
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() {
    // >SEPARATOR customDelete default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customDelete("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() {
    // >SEPARATOR customGet default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customGet("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() {
    // >SEPARATOR customPost default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPost("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() {
    // >SEPARATOR customPut default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.customPut("test/minimal");
    // SEPARATOR<
  }

  // Snippet for the deleteConfig method.
  //
  // deleteConfig
  void snippetForDeleteConfig() {
    // >SEPARATOR deleteConfig default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.deleteConfig("theIndexName");
    // SEPARATOR<
  }

  // Snippet for the getAllConfigs method.
  //
  // getAllConfigs
  void snippetForGetAllConfigs() {
    // >SEPARATOR getAllConfigs default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getAllConfigs();
    // SEPARATOR<
  }

  // Snippet for the getConfig method.
  //
  // Retrieve QS config e2e
  void snippetForGetConfig() {
    // >SEPARATOR getConfig default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getConfig("cts_e2e_browse_query_suggestions");
    // SEPARATOR<
  }

  // Snippet for the getConfigStatus method.
  //
  // getConfigStatus
  void snippetForGetConfigStatus() {
    // >SEPARATOR getConfigStatus default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getConfigStatus("theIndexName");
    // SEPARATOR<
  }

  // Snippet for the getLogFile method.
  //
  // getLogFile
  void snippetForGetLogFile() {
    // >SEPARATOR getLogFile default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.getLogFile("theIndexName");
    // SEPARATOR<
  }

  // Snippet for the updateConfig method.
  //
  // updateConfig
  void snippetForUpdateConfig() {
    // >SEPARATOR updateConfig default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION");

    // Call the API
    client.updateConfig(
      "theIndexName",
      new Configuration()
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
    // SEPARATOR<
  }
}
