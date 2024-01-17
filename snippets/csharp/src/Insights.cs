using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Insights;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetInsightsClient
{
  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomDelete()
  {
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomGet()
  {
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomPost()
  {
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForInsightsClientCustomPut()
  {
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the DeleteUserToken method.
  ///
  /// deleteUserToken0
  /// </summary>
  public async Task SnippetForInsightsClientDeleteUserToken()
  {
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteUserTokenAsync("test-user-1");
  }

  /// <summary>
  /// Snippet for the PushEvents method.
  ///
  /// pushEvents0
  /// </summary>
  public async Task SnippetForInsightsClientPushEvents()
  {
    // Initialize the client
    var client = new InsightsClient(
      new InsightsConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.PushEventsAsync(
      new InsightsEvents
      {
        Events = new List<EventsItems>
        {
          new EventsItems(
            new ClickedObjectIDsAfterSearch
            {
              EventType = Enum.Parse<ClickEvent>("Click"),
              EventName = "Product Clicked",
              Index = "products",
              UserToken = "user-123456",
              AuthenticatedUserToken = "user-123456",
              Timestamp = 1641290601962L,
              ObjectIDs = new List<string> { "9780545139700", "9780439784542" },
              QueryID = "43b15df305339e827f0ac0bdc5ebcaa7",
              Positions = new List<int> { 7, 6 },
            }
          )
        },
      }
    );
  }
}
