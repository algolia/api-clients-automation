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
    // >SEPARATOR customDelete
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
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
  public async Task SnippetForAnalyticsClientCustomGet()
  {
    // >SEPARATOR customGet
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPost()
  {
    // >SEPARATOR customPost
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
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
  public async Task SnippetForAnalyticsClientCustomPut()
  {
    // >SEPARATOR customPut
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetAverageClickPosition method.
  ///
  /// get getAverageClickPosition with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetAverageClickPosition()
  {
    // >SEPARATOR getAverageClickPosition
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetAverageClickPositionAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetClickPositions method.
  ///
  /// get getClickPositions with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetClickPositions()
  {
    // >SEPARATOR getClickPositions
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetClickPositionsAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetClickThroughRate method.
  ///
  /// get getClickThroughRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetClickThroughRate()
  {
    // >SEPARATOR getClickThroughRate
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetClickThroughRateAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetConversationRate method.
  ///
  /// get getConversationRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetConversationRate()
  {
    // >SEPARATOR getConversationRate
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetConversationRateAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetNoClickRate method.
  ///
  /// get getNoClickRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetNoClickRate()
  {
    // >SEPARATOR getNoClickRate
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetNoClickRateAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetNoResultsRate method.
  ///
  /// get getNoResultsRate with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetNoResultsRate()
  {
    // >SEPARATOR getNoResultsRate
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetNoResultsRateAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSearchesCount method.
  ///
  /// get getSearchesCount with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesCount()
  {
    // >SEPARATOR getSearchesCount
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSearchesCountAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSearchesNoClicks method.
  ///
  /// get getSearchesNoClicks with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesNoClicks()
  {
    // >SEPARATOR getSearchesNoClicks
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSearchesNoClicksAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSearchesNoResults method.
  ///
  /// get getSearchesNoResults with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetSearchesNoResults()
  {
    // >SEPARATOR getSearchesNoResults
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetSearchesNoResultsAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetStatus method.
  ///
  /// get getStatus with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetStatus()
  {
    // >SEPARATOR getStatus
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetStatusAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopCountries method.
  ///
  /// get getTopCountries with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopCountries()
  {
    // >SEPARATOR getTopCountries
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopCountriesAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFilterAttributes method.
  ///
  /// get getTopFilterAttributes with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFilterAttributes()
  {
    // >SEPARATOR getTopFilterAttributes
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopFilterAttributesAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFilterForAttribute method.
  ///
  /// get getTopFilterForAttribute with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFilterForAttribute()
  {
    // >SEPARATOR getTopFilterForAttribute
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopFilterForAttributeAsync("myAttribute", "index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopFiltersNoResults method.
  ///
  /// get getTopFiltersNoResults with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopFiltersNoResults()
  {
    // >SEPARATOR getTopFiltersNoResults
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopFiltersNoResultsAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopHits method.
  ///
  /// get getTopHits with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopHits()
  {
    // >SEPARATOR getTopHits
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopHitsAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopSearches method.
  ///
  /// get getTopSearches with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetTopSearches()
  {
    // >SEPARATOR getTopSearches
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetTopSearchesAsync("index");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetUsersCount method.
  ///
  /// get getUsersCount with minimal parameters
  /// </summary>
  public async Task SnippetForAnalyticsClientGetUsersCount()
  {
    // >SEPARATOR getUsersCount
    // Initialize the client
    var client = new AnalyticsClient(
      new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetUsersCountAsync("index");
    // SEPARATOR<
  }
}
