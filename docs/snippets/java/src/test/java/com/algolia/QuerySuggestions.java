package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.QuerySuggestionsClient;
import com.algolia.model.querysuggestions.*;
// IMPORT<
import java.util.*;

class SnippetQuerySuggestionsClient {

  // Snippet for the createConfig method.
  //
  // createConfig
  void snippetForCreateConfig() throws Exception {
    // >SEPARATOR createConfig default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.createConfig(
      new ConfigurationWithIndex()
        .setIndexName("<YOUR_INDEX_NAME>")
        .setSourceIndices(
          Arrays.asList(
            new SourceIndex()
              .setIndexName("<YOUR_INDEX_NAME>")
              .setFacets(Arrays.asList(new Facet().setAttribute("test")))
              .setGenerate(Arrays.asList(Arrays.asList("facetA", "facetB"), Arrays.asList("facetC")))
          )
        )
        .setLanguages(Languages.of(Arrays.asList("french")))
        .setExclude(Arrays.asList("test"))
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with minimal parameters
  void snippetForCustomDelete() throws Exception {
    // >SEPARATOR customDelete default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

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
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the deleteConfig method.
  //
  // deleteConfig
  void snippetForDeleteConfig() throws Exception {
    // >SEPARATOR deleteConfig default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.deleteConfig("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getAllConfigs method.
  //
  // getAllConfigs
  void snippetForGetAllConfigs() throws Exception {
    // >SEPARATOR getAllConfigs default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getAllConfigs();
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getConfig method.
  //
  // Retrieve QS config e2e
  void snippetForGetConfig() throws Exception {
    // >SEPARATOR getConfig default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getConfig("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getConfigStatus method.
  //
  // getConfigStatus
  void snippetForGetConfigStatus() throws Exception {
    // >SEPARATOR getConfigStatus default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getConfigStatus("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the getLogFile method.
  //
  // getLogFile
  void snippetForGetLogFile() throws Exception {
    // >SEPARATOR getLogFile default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.getLogFile("<YOUR_INDEX_NAME>");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the setClientApiKey method.
  //
  // switch API key
  void snippetForSetClientApiKey() throws Exception {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.setClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the updateConfig method.
  //
  // updateConfig
  void snippetForUpdateConfig() throws Exception {
    // >SEPARATOR updateConfig default
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.updateConfig(
      "<YOUR_INDEX_NAME>",
      new Configuration()
        .setSourceIndices(
          Arrays.asList(
            new SourceIndex()
              .setIndexName("<YOUR_INDEX_NAME>")
              .setFacets(Arrays.asList(new Facet().setAttribute("test")))
              .setGenerate(Arrays.asList(Arrays.asList("facetA", "facetB"), Arrays.asList("facetC")))
          )
        )
        .setLanguages(Languages.of(Arrays.asList("french")))
        .setExclude(Arrays.asList("test"))
    );
    // >LOG
    // SEPARATOR<
  }
}
