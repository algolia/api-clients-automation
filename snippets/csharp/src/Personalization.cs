using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Personalization;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetPersonalizationClient
{
  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForPersonalizationClientCustomDelete()
  {
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForPersonalizationClientCustomGet()
  {
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForPersonalizationClientCustomPost()
  {
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForPersonalizationClientCustomPut()
  {
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the DeleteUserProfile method.
  ///
  /// delete deleteUserProfile
  /// </summary>
  public async Task SnippetForPersonalizationClientDeleteUserProfile()
  {
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteUserProfileAsync("UserToken");
  }

  /// <summary>
  /// Snippet for the GetPersonalizationStrategy method.
  ///
  /// get getPersonalizationStrategy
  /// </summary>
  public async Task SnippetForPersonalizationClientGetPersonalizationStrategy()
  {
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetPersonalizationStrategyAsync();
  }

  /// <summary>
  /// Snippet for the GetUserTokenProfile method.
  ///
  /// get getUserTokenProfile
  /// </summary>
  public async Task SnippetForPersonalizationClientGetUserTokenProfile()
  {
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetUserTokenProfileAsync("UserToken");
  }

  /// <summary>
  /// Snippet for the SetPersonalizationStrategy method.
  ///
  /// set setPersonalizationStrategy
  /// </summary>
  public async Task SnippetForPersonalizationClientSetPersonalizationStrategy()
  {
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.SetPersonalizationStrategyAsync(
      new PersonalizationStrategyParams
      {
        EventScoring = new List<EventScoring>
        {
          new EventScoring
          {
            Score = 42,
            EventName = "Algolia",
            EventType = "Event",
          }
        },
        FacetScoring = new List<FacetScoring>
        {
          new FacetScoring { Score = 42, FacetName = "Event", }
        },
        PersonalizationImpact = 42,
      }
    );
  }
}
