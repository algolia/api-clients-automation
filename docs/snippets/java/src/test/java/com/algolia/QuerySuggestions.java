package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.QuerySuggestionsClient;
import com.algolia.config.*;
// IMPORT<
import com.algolia.model.querysuggestions.*;
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
    // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customDelete("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customDelete method.
  //
  // allow del method for a custom path with all parameters
  void snippetForCustomDelete1() throws Exception {
    // >SEPARATOR customDelete allow del method for a custom path with all parameters
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customDelete(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with minimal parameters
  void snippetForCustomGet() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with minimal parameters
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customGet("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // allow get method for a custom path with all parameters
  void snippetForCustomGet1() throws Exception {
    // >SEPARATOR customGet allow get method for a custom path with all parameters
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customGet(
      "test/all",
      new HashMap() {
        {
          put("query", "parameters with space");
        }
      }
    );
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customGet method.
  //
  // requestOptions should be escaped too
  void snippetForCustomGet2() throws Exception {
    // >SEPARATOR customGet requestOptions should be escaped too
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customGet(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with minimal parameters
  void snippetForCustomPost() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with minimal parameters
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // allow post method for a custom path with all parameters
  void snippetForCustomPost1() throws Exception {
    // >SEPARATOR customPost allow post method for a custom path with all parameters
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default query parameters
  void snippetForCustomPost2() throws Exception {
    // >SEPARATOR customPost requestOptions can override default query parameters
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges query parameters with default ones
  void snippetForCustomPost3() throws Exception {
    // >SEPARATOR customPost requestOptions merges query parameters with default ones
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions can override default headers
  void snippetForCustomPost4() throws Exception {
    // >SEPARATOR customPost requestOptions can override default headers
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions merges headers with default ones
  void snippetForCustomPost5() throws Exception {
    // >SEPARATOR customPost requestOptions merges headers with default ones
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts booleans
  void snippetForCustomPost6() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts booleans
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts integers
  void snippetForCustomPost7() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts integers
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of string
  void snippetForCustomPost8() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of string
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of booleans
  void snippetForCustomPost9() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPost method.
  //
  // requestOptions queryParameters accepts list of integers
  void snippetForCustomPost10() throws Exception {
    // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPost(
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
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with minimal parameters
  void snippetForCustomPut() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with minimal parameters
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPut("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the customPut method.
  //
  // allow put method for a custom path with all parameters
  void snippetForCustomPut1() throws Exception {
    // >SEPARATOR customPut allow put method for a custom path with all parameters
    // Initialize the client
    QuerySuggestionsClient client = new QuerySuggestionsClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    // Call the API
    client.customPut(
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
