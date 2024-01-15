using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.QuerySuggestions;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetQuerySuggestionsClient
{
  [Fact]
  public void Dispose()
  {

  }

  /// <summary>
  /// Snippet for the createConfig method.
  ///
  /// createConfig0
  /// </summary>
  public async Task SnippetForCreateConfig0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var querySuggestionsConfigurationWithIndex0 = new QuerySuggestionsConfigurationWithIndex();
    {
      const string indexName1 = "theIndexName";
      querySuggestionsConfigurationWithIndex0.IndexName = indexName1; var sourceIndices1 = new List<SourceIndex>();
      var sourceIndices_02 = new SourceIndex();
      {
        const string indexName3 = "testIndex";
        sourceIndices_02.IndexName = indexName3; var facets3 = new List<Facet>();
        var facets_04 = new Facet();
        {
          const string attribute5 = "test";
          facets_04.Attribute = attribute5;
        }
        facets3.Add(facets_04);
        sourceIndices_02.Facets = facets3; var generate3 = new List<List<string>>();
        var generate_04 = new List<string>();
        const string generate_0_05 = "facetA";
        generate_04.Add(generate_0_05); const string generate_0_15 = "facetB";
        generate_04.Add(generate_0_15);
        generate3.Add(generate_04); var generate_14 = new List<string>();
        const string generate_1_05 = "facetC";
        generate_14.Add(generate_1_05);
        generate3.Add(generate_14);
        sourceIndices_02.Generate = generate3;
      }
      sourceIndices1.Add(sourceIndices_02);
      querySuggestionsConfigurationWithIndex0.SourceIndices = sourceIndices1; var languages1 = new List<string>();
      const string languages_02 = "french";
      languages1.Add(languages_02);
      querySuggestionsConfigurationWithIndex0.Languages = new Languages(languages1); var exclude1 = new List<string>();
      const string exclude_02 = "test";
      exclude1.Add(exclude_02);
      querySuggestionsConfigurationWithIndex0.Exclude = exclude1;
    }


    var response = await _client.CreateConfigAsync(querySuggestionsConfigurationWithIndex0);
  }

  /// <summary>
  /// Snippet for the customDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomDelete0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomDeleteAsync(path0);
  }

  /// <summary>
  /// Snippet for the customGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomGet0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomGetAsync(path0);
  }

  /// <summary>
  /// Snippet for the customPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPost0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPostAsync(path0);
  }

  /// <summary>
  /// Snippet for the customPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPut0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPutAsync(path0);
  }

  /// <summary>
  /// Snippet for the deleteConfig method.
  ///
  /// deleteConfig0
  /// </summary>
  public async Task SnippetForDeleteConfig0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string indexName0 = "theIndexName";


    var response = await _client.DeleteConfigAsync(indexName0);
  }

  /// <summary>
  /// Snippet for the getAllConfigs method.
  ///
  /// getAllConfigs0
  /// </summary>
  public async Task SnippetForGetAllConfigs0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API


    var response = await _client.GetAllConfigsAsync();
  }

  /// <summary>
  /// Snippet for the getConfig method.
  ///
  /// getConfig0
  /// </summary>
  public async Task SnippetForGetConfig0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string indexName0 = "theIndexName";


    var response = await _client.GetConfigAsync(indexName0);
  }

  /// <summary>
  /// Snippet for the getConfigStatus method.
  ///
  /// getConfigStatus0
  /// </summary>
  public async Task SnippetForGetConfigStatus0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string indexName0 = "theIndexName";


    var response = await _client.GetConfigStatusAsync(indexName0);
  }

  /// <summary>
  /// Snippet for the getLogFile method.
  ///
  /// getLogFile0
  /// </summary>
  public async Task SnippetForGetLogFile0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string indexName0 = "theIndexName";


    var response = await _client.GetLogFileAsync(indexName0);
  }

  /// <summary>
  /// Snippet for the updateConfig method.
  ///
  /// updateConfig0
  /// </summary>
  public async Task SnippetForUpdateConfig0()
  {
    // Initialize the client
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string indexName0 = "theIndexName";
    var querySuggestionsConfiguration0 = new QuerySuggestionsConfiguration();
    {
      var sourceIndices1 = new List<SourceIndex>();
      var sourceIndices_02 = new SourceIndex();
      {
        const string indexName3 = "testIndex";
        sourceIndices_02.IndexName = indexName3; var facets3 = new List<Facet>();
        var facets_04 = new Facet();
        {
          const string attribute5 = "test";
          facets_04.Attribute = attribute5;
        }
        facets3.Add(facets_04);
        sourceIndices_02.Facets = facets3; var generate3 = new List<List<string>>();
        var generate_04 = new List<string>();
        const string generate_0_05 = "facetA";
        generate_04.Add(generate_0_05); const string generate_0_15 = "facetB";
        generate_04.Add(generate_0_15);
        generate3.Add(generate_04); var generate_14 = new List<string>();
        const string generate_1_05 = "facetC";
        generate_14.Add(generate_1_05);
        generate3.Add(generate_14);
        sourceIndices_02.Generate = generate3;
      }
      sourceIndices1.Add(sourceIndices_02);
      querySuggestionsConfiguration0.SourceIndices = sourceIndices1; var languages1 = new List<string>();
      const string languages_02 = "french";
      languages1.Add(languages_02);
      querySuggestionsConfiguration0.Languages = new Languages(languages1); var exclude1 = new List<string>();
      const string exclude_02 = "test";
      exclude1.Add(exclude_02);
      querySuggestionsConfiguration0.Exclude = exclude1;
    }


    var response = await _client.UpdateConfigAsync(indexName0, querySuggestionsConfiguration0);
  }

}
