using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Personalization;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetPersonalizationClient
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
    var client = new PersonalizationClient(new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new PersonalizationClient(new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new PersonalizationClient(new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new PersonalizationClient(new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPutAsync(path0);
  }

  /// <summary>
  /// Snippet for the deleteUserProfile method.
  ///
  /// delete deleteUserProfile
  /// </summary>
  public async Task SnippetForDeleteUserProfile0()
  {
    // Initialize the client
    var client = new PersonalizationClient(new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string userToken0 = "UserToken";


    var response = await _client.DeleteUserProfileAsync(userToken0);
  }

  /// <summary>
  /// Snippet for the getPersonalizationStrategy method.
  ///
  /// get getPersonalizationStrategy
  /// </summary>
  public async Task SnippetForGetPersonalizationStrategy0()
  {
    // Initialize the client
    var client = new PersonalizationClient(new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API


    var response = await _client.GetPersonalizationStrategyAsync();
  }

  /// <summary>
  /// Snippet for the getUserTokenProfile method.
  ///
  /// get getUserTokenProfile
  /// </summary>
  public async Task SnippetForGetUserTokenProfile0()
  {
    // Initialize the client
    var client = new PersonalizationClient(new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string userToken0 = "UserToken";


    var response = await _client.GetUserTokenProfileAsync(userToken0);
  }

  /// <summary>
  /// Snippet for the setPersonalizationStrategy method.
  ///
  /// set setPersonalizationStrategy
  /// </summary>
  public async Task SnippetForSetPersonalizationStrategy0()
  {
    // Initialize the client
    var client = new PersonalizationClient(new PersonalizationConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var personalizationStrategyParams0 = new PersonalizationStrategyParams();
    {
      var eventScoring1 = new List<EventScoring>();
      var eventScoring_02 = new EventScoring();
      {
        const int score3 = 42;
        eventScoring_02.Score = score3; const string eventName3 = "Algolia";
        eventScoring_02.EventName = eventName3; const string eventType3 = "Event";
        eventScoring_02.EventType = eventType3;
      }
      eventScoring1.Add(eventScoring_02);
      personalizationStrategyParams0.EventScoring = eventScoring1; var facetScoring1 = new List<FacetScoring>();
      var facetScoring_02 = new FacetScoring();
      {
        const int score3 = 42;
        facetScoring_02.Score = score3; const string facetName3 = "Event";
        facetScoring_02.FacetName = facetName3;
      }
      facetScoring1.Add(facetScoring_02);
      personalizationStrategyParams0.FacetScoring = facetScoring1; const int personalizationImpact1 = 42;
      personalizationStrategyParams0.PersonalizationImpact = personalizationImpact1;
    }


    var response = await _client.SetPersonalizationStrategyAsync(personalizationStrategyParams0);
  }

}
