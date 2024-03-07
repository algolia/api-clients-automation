using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.QuerySuggestions;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetQuerySuggestionsClient
{
  /// <summary>
  /// Snippet for the CreateConfig method.
  ///
  /// createConfig0
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientCreateConfig()
  {
    // >SEPARATOR createConfig
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CreateConfigAsync(
      new QuerySuggestionsConfigurationWithIndex
      {
        IndexName = "theIndexName",
        SourceIndices = new List<SourceIndex>
        {
          new SourceIndex
          {
            IndexName = "testIndex",
            Facets = new List<Facet> { new Facet { Attribute = "test", } },
            Generate = new List<List<string>>
            {
              new List<string> { "facetA", "facetB" },
              new List<string> { "facetC" }
            },
          }
        },
        Languages = new Languages(new List<string> { "french" }),
        Exclude = new List<string> { "test" },
      }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientCustomDelete()
  {
    // >SEPARATOR customDelete
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientCustomGet()
  {
    // >SEPARATOR customGet
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientCustomPost()
  {
    // >SEPARATOR customPost
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientCustomPut()
  {
    // >SEPARATOR customPut
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteConfig method.
  ///
  /// deleteConfig0
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientDeleteConfig()
  {
    // >SEPARATOR deleteConfig
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteConfigAsync("theIndexName");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetAllConfigs method.
  ///
  /// getAllConfigs0
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientGetAllConfigs()
  {
    // >SEPARATOR getAllConfigs
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetAllConfigsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetConfig method.
  ///
  /// Retrieve QS config e2e
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientGetConfig()
  {
    // >SEPARATOR getConfig
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetConfigAsync("cts_e2e_browse_query_suggestions");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetConfigStatus method.
  ///
  /// getConfigStatus0
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientGetConfigStatus()
  {
    // >SEPARATOR getConfigStatus
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetConfigStatusAsync("theIndexName");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetLogFile method.
  ///
  /// getLogFile0
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientGetLogFile()
  {
    // >SEPARATOR getLogFile
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetLogFileAsync("theIndexName");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateConfig method.
  ///
  /// updateConfig0
  /// </summary>
  public async Task SnippetForQuerySuggestionsClientUpdateConfig()
  {
    // >SEPARATOR updateConfig
    // Initialize the client
    var client = new QuerySuggestionsClient(
      new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.UpdateConfigAsync(
      "theIndexName",
      new QuerySuggestionsConfiguration
      {
        SourceIndices = new List<SourceIndex>
        {
          new SourceIndex
          {
            IndexName = "testIndex",
            Facets = new List<Facet> { new Facet { Attribute = "test", } },
            Generate = new List<List<string>>
            {
              new List<string> { "facetA", "facetB" },
              new List<string> { "facetC" }
            },
          }
        },
        Languages = new Languages(new List<string> { "french" }),
        Exclude = new List<string> { "test" },
      }
    );
    // SEPARATOR<
  }
}
