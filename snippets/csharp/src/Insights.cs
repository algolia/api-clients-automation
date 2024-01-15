using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Insights;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetInsightsClient
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
    var client = new InsightsClient(new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new InsightsClient(new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new InsightsClient(new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new InsightsClient(new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPutAsync(path0);
  }

  /// <summary>
  /// Snippet for the deleteUserToken method.
  ///
  /// deleteUserToken0
  /// </summary>
  public async Task SnippetForDeleteUserToken0()
  {
    // Initialize the client
    var client = new InsightsClient(new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string userToken0 = "test-user-1";


    var response = await _client.DeleteUserTokenAsync(userToken0);
  }

  /// <summary>
  /// Snippet for the pushEvents method.
  ///
  /// pushEvents0
  /// </summary>
  public async Task SnippetForPushEvents0()
  {
    // Initialize the client
    var client = new InsightsClient(new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var insightsEvents0 = new InsightsEvents();
    {
      var events1 = new List<EventsItems>();
      var events_02 = new ClickedObjectIDsAfterSearch();
      {
        var eventType3 = (ClickEvent)Enum.Parse(typeof(ClickEvent), "Click");
        events_02.EventType = eventType3; const string eventName3 = "Product Clicked";
        events_02.EventName = eventName3; const string index3 = "products";
        events_02.Index = index3; const string userToken3 = "user-123456";
        events_02.UserToken = userToken3; const string authenticatedUserToken3 = "user-123456";
        events_02.AuthenticatedUserToken = authenticatedUserToken3; const long timestamp3 = 1641290601962L;
        events_02.Timestamp = timestamp3; var objectIDs3 = new List<string>();
        const string objectIDs_04 = "9780545139700";
        objectIDs3.Add(objectIDs_04); const string objectIDs_14 = "9780439784542";
        objectIDs3.Add(objectIDs_14);
        events_02.ObjectIDs = objectIDs3; const string queryID3 = "43b15df305339e827f0ac0bdc5ebcaa7";
        events_02.QueryID = queryID3; var positions3 = new List<int>();
        const int positions_04 = 7;
        positions3.Add(positions_04); const int positions_14 = 6;
        positions3.Add(positions_14);
        events_02.Positions = positions3;
      }
      events1.Add(new EventsItems(events_02));
      insightsEvents0.Events = events1;
    }


    var response = await _client.PushEventsAsync(insightsEvents0);
  }

}
