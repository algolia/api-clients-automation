// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// >IMPORT
using Algolia.Search.Clients;
using Algolia.Search.Http;
// IMPORT<
using Algolia.Search.Models.Personalization;
using Action = Algolia.Search.Models.Ingestion.Action;

public class SnippetPersonalizationClient
{
  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForPersonalizationClientCustomDelete()
  {
    // >SEPARATOR customDelete default
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomDeleteAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForPersonalizationClientCustomGet()
  {
    // >SEPARATOR customGet default
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomGetAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForPersonalizationClientCustomPost()
  {
    // >SEPARATOR customPost default
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPostAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForPersonalizationClientCustomPut()
  {
    // >SEPARATOR customPut default
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteUserProfile method.
  ///
  /// delete deleteUserProfile
  /// </summary>
  public async Task SnippetForPersonalizationClientDeleteUserProfile()
  {
    // >SEPARATOR deleteUserProfile default
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteUserProfileAsync("UserToken");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetPersonalizationStrategy method.
  ///
  /// get getPersonalizationStrategy
  /// </summary>
  public async Task SnippetForPersonalizationClientGetPersonalizationStrategy()
  {
    // >SEPARATOR getPersonalizationStrategy default
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetPersonalizationStrategyAsync();
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetUserTokenProfile method.
  ///
  /// get getUserTokenProfile
  /// </summary>
  public async Task SnippetForPersonalizationClientGetUserTokenProfile()
  {
    // >SEPARATOR getUserTokenProfile default
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetUserTokenProfileAsync("UserToken");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SetClientApiKey method.
  ///
  /// switch API key
  /// </summary>
  public async Task SnippetForPersonalizationClientSetClientApiKey()
  {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    var client = new PersonalizationClient(
      new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    client.SetClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SetPersonalizationStrategy method.
  ///
  /// set setPersonalizationStrategy
  /// </summary>
  public async Task SnippetForPersonalizationClientSetPersonalizationStrategy()
  {
    // >SEPARATOR setPersonalizationStrategy default
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
            EventType = Enum.Parse<EventType>("Click"),
          }
        },
        FacetScoring = new List<FacetScoring>
        {
          new FacetScoring { Score = 42, FacetName = "Event", }
        },
        PersonalizationImpact = 42,
      }
    );
    // >LOG
    // SEPARATOR<
  }
}
