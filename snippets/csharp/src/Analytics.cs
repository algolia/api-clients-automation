using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Analytics;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetAnalyticsClient
{
  [Fact]
  public void Dispose()
  {

  }

  /// <summary>
  /// Snippet for the customDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomDelete0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPutAsync(path0);
  }

  /// <summary>
  /// Snippet for the getAverageClickPosition method.
  ///
  /// get getAverageClickPosition with minimal parameters
  /// </summary>
  public async Task SnippetForGetAverageClickPosition0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetAverageClickPositionAsync(index0);
  }

  /// <summary>
  /// Snippet for the getClickPositions method.
  ///
  /// get getClickPositions with minimal parameters
  /// </summary>
  public async Task SnippetForGetClickPositions0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetClickPositionsAsync(index0);
  }

  /// <summary>
  /// Snippet for the getClickThroughRate method.
  ///
  /// get getClickThroughRate with minimal parameters
  /// </summary>
  public async Task SnippetForGetClickThroughRate0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetClickThroughRateAsync(index0);
  }

  /// <summary>
  /// Snippet for the getConversationRate method.
  ///
  /// get getConversationRate with minimal parameters
  /// </summary>
  public async Task SnippetForGetConversationRate0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetConversationRateAsync(index0);
  }

  /// <summary>
  /// Snippet for the getNoClickRate method.
  ///
  /// get getNoClickRate with minimal parameters
  /// </summary>
  public async Task SnippetForGetNoClickRate0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetNoClickRateAsync(index0);
  }

  /// <summary>
  /// Snippet for the getNoResultsRate method.
  ///
  /// get getNoResultsRate with minimal parameters
  /// </summary>
  public async Task SnippetForGetNoResultsRate0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetNoResultsRateAsync(index0);
  }

  /// <summary>
  /// Snippet for the getSearchesCount method.
  ///
  /// get getSearchesCount with minimal parameters
  /// </summary>
  public async Task SnippetForGetSearchesCount0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetSearchesCountAsync(index0);
  }

  /// <summary>
  /// Snippet for the getSearchesNoClicks method.
  ///
  /// get getSearchesNoClicks with minimal parameters
  /// </summary>
  public async Task SnippetForGetSearchesNoClicks0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetSearchesNoClicksAsync(index0);
  }

  /// <summary>
  /// Snippet for the getSearchesNoResults method.
  ///
  /// get getSearchesNoResults with minimal parameters
  /// </summary>
  public async Task SnippetForGetSearchesNoResults0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetSearchesNoResultsAsync(index0);
  }

  /// <summary>
  /// Snippet for the getStatus method.
  ///
  /// get getStatus with minimal parameters
  /// </summary>
  public async Task SnippetForGetStatus0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetStatusAsync(index0);
  }

  /// <summary>
  /// Snippet for the getTopCountries method.
  ///
  /// get getTopCountries with minimal parameters
  /// </summary>
  public async Task SnippetForGetTopCountries0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetTopCountriesAsync(index0);
  }

  /// <summary>
  /// Snippet for the getTopFilterAttributes method.
  ///
  /// get getTopFilterAttributes with minimal parameters
  /// </summary>
  public async Task SnippetForGetTopFilterAttributes0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetTopFilterAttributesAsync(index0);
  }

  /// <summary>
  /// Snippet for the getTopFilterForAttribute method.
  ///
  /// get getTopFilterForAttribute with minimal parameters
  /// </summary>
  public async Task SnippetForGetTopFilterForAttribute0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string attribute0 = "myAttribute";
    const string index0 = "index";


    var response = await _client.GetTopFilterForAttributeAsync(attribute0, index0);
  }

  /// <summary>
  /// Snippet for the getTopFiltersNoResults method.
  ///
  /// get getTopFiltersNoResults with minimal parameters
  /// </summary>
  public async Task SnippetForGetTopFiltersNoResults0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetTopFiltersNoResultsAsync(index0);
  }

  /// <summary>
  /// Snippet for the getTopHits method.
  ///
  /// get getTopHits with minimal parameters
  /// </summary>
  public async Task SnippetForGetTopHits0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetTopHitsAsync(index0);
  }

  /// <summary>
  /// Snippet for the getTopSearches method.
  ///
  /// get getTopSearches with minimal parameters
  /// </summary>
  public async Task SnippetForGetTopSearches0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetTopSearchesAsync(index0);
  }

  /// <summary>
  /// Snippet for the getUsersCount method.
  ///
  /// get getUsersCount with minimal parameters
  /// </summary>
  public async Task SnippetForGetUsersCount0()
  {
    // Initialize the client
    var client = new AnalyticsClient(new AnalyticsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string index0 = "index";


    var response = await _client.GetUsersCountAsync(index0);
  }

}
