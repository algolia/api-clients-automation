using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Recommend;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetRecommendClient
{
  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForRecommendClientCustomDelete()
  {
    // >SEPARATOR customDelete
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForRecommendClientCustomGet()
  {
    // >SEPARATOR customGet
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForRecommendClientCustomPost()
  {
    // >SEPARATOR customPost
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForRecommendClientCustomPut()
  {
    // >SEPARATOR customPut
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteRecommendRule method.
  ///
  /// deleteRecommendRule0
  /// </summary>
  public async Task SnippetForRecommendClientDeleteRecommendRule()
  {
    // >SEPARATOR deleteRecommendRule
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteRecommendRuleAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts"),
      "objectID"
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetRecommendRule method.
  ///
  /// getRecommendRule0
  /// </summary>
  public async Task SnippetForRecommendClientGetRecommendRule()
  {
    // >SEPARATOR getRecommendRule
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetRecommendRuleAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts"),
      "objectID"
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetRecommendStatus method.
  ///
  /// getRecommendStatus0
  /// </summary>
  public async Task SnippetForRecommendClientGetRecommendStatus()
  {
    // >SEPARATOR getRecommendStatus
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetRecommendStatusAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts"),
      12345L
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetRecommendations method.
  ///
  /// get recommendations for recommend model with minimal parameters
  /// </summary>
  public async Task SnippetForRecommendClientGetRecommendations()
  {
    // >SEPARATOR getRecommendations
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetRecommendationsAsync(
      new GetRecommendationsParams
      {
        Requests = new List<RecommendationsRequest>
        {
          new RecommendationsRequest(
            new RecommendationsQuery
            {
              IndexName = "indexName",
              ObjectID = "objectID",
              Model = Enum.Parse<RecommendationModels>("RelatedProducts"),
              Threshold = 42,
            }
          )
        },
      }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchRecommendRules method.
  ///
  /// searchRecommendRules0
  /// </summary>
  public async Task SnippetForRecommendClientSearchRecommendRules()
  {
    // >SEPARATOR searchRecommendRules
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchRecommendRulesAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts")
    );
    // SEPARATOR<
  }
}
