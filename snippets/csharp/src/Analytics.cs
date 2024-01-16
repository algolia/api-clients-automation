using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Analytics;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetAnalyticsClient
{
  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientCustomDelete()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientCustomGet()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientCustomPost()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientCustomPut()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the GetAverageClickPosition method.
  ///
  /// get getAverageClickPosition with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetAverageClickPosition()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetAverageClickPositionAsync("index");
  }

  /// <summary>
  /// Snippet for the GetClickPositions method.
  ///
  /// get getClickPositions with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetClickPositions()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetClickPositionsAsync("index");
  }

  /// <summary>
  /// Snippet for the GetClickThroughRate method.
  ///
  /// get getClickThroughRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetClickThroughRate()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetClickThroughRateAsync("index");
  }

  /// <summary>
  /// Snippet for the GetConversationRate method.
  ///
  /// get getConversationRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetConversationRate()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetConversationRateAsync("index");
  }

  /// <summary>
  /// Snippet for the GetNoClickRate method.
  ///
  /// get getNoClickRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetNoClickRate()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetNoClickRateAsync("index");
  }

  /// <summary>
  /// Snippet for the GetNoResultsRate method.
  ///
  /// get getNoResultsRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetNoResultsRate()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetNoResultsRateAsync("index");
  }

  /// <summary>
  /// Snippet for the GetSearchesCount method.
  ///
  /// get getSearchesCount with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesCount()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSearchesCountAsync("index");
  }

  /// <summary>
  /// Snippet for the GetSearchesNoClicks method.
  ///
  /// get getSearchesNoClicks with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesNoClicks()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSearchesNoClicksAsync("index");
  }

  /// <summary>
  /// Snippet for the GetSearchesNoResults method.
  ///
  /// get getSearchesNoResults with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesNoResults()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSearchesNoResultsAsync("index");
  }

  /// <summary>
  /// Snippet for the GetStatus method.
  ///
  /// get getStatus with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetStatus()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetStatusAsync("index");
  }

  /// <summary>
  /// Snippet for the GetTopCountries method.
  ///
  /// get getTopCountries with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopCountries()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopCountriesAsync("index");
  }

  /// <summary>
  /// Snippet for the GetTopFilterAttributes method.
  ///
  /// get getTopFilterAttributes with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFilterAttributes()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopFilterAttributesAsync("index");
  }

  /// <summary>
  /// Snippet for the GetTopFilterForAttribute method.
  ///
  /// get getTopFilterForAttribute with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFilterForAttribute()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopFilterForAttributeAsync("myAttribute", "index");
  }

  /// <summary>
  /// Snippet for the GetTopFiltersNoResults method.
  ///
  /// get getTopFiltersNoResults with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFiltersNoResults()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopFiltersNoResultsAsync("index");
  }

  /// <summary>
  /// Snippet for the GetTopHits method.
  ///
  /// get getTopHits with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopHits()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopHitsAsync("index");
  }

  /// <summary>
  /// Snippet for the GetTopSearches method.
  ///
  /// get getTopSearches with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopSearches()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopSearchesAsync("index");
  }

  /// <summary>
  /// Snippet for the GetUsersCount method.
  ///
  /// get getUsersCount with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetUsersCount()
  {
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetUsersCountAsync("index");
  }
}
