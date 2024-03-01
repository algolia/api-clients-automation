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
    // >SEPARATOR customDelete
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
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
  public async Task SnippetForPersonalizationClientCustomGet()
  {
    // >SEPARATOR customGet
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
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
  public async Task SnippetForPersonalizationClientCustomPost()
  {
    // >SEPARATOR customPost
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
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
  public async Task SnippetForPersonalizationClientCustomPut()
  {
    // >SEPARATOR customPut
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteUserProfile method.
  ///
  /// delete deleteUserProfile
  /// </summary>
  public async Task SnippetForPersonalizationClientDeleteUserProfile()
  {
    // >SEPARATOR deleteUserProfile
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteUserProfileAsync("UserToken");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetPersonalizationStrategy method.
  ///
  /// get getPersonalizationStrategy
  /// </summary>
  public async Task SnippetForPersonalizationClientGetPersonalizationStrategy()
  {
    // >SEPARATOR getPersonalizationStrategy
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetPersonalizationStrategyAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetUserTokenProfile method.
  ///
  /// get getUserTokenProfile
  /// </summary>
  public async Task SnippetForPersonalizationClientGetUserTokenProfile()
  {
    // >SEPARATOR getUserTokenProfile
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetUserTokenProfileAsync("UserToken");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SetPersonalizationStrategy method.
  ///
  /// set setPersonalizationStrategy
  /// </summary>
  public async Task SnippetForPersonalizationClientSetPersonalizationStrategy()
  {
    // >SEPARATOR setPersonalizationStrategy
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
    // SEPARATOR<
  }
}
