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
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForRecommendClientCustomGet()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForRecommendClientCustomPost()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForRecommendClientCustomPut()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the DeleteRecommendRule method.
  ///
  /// deleteRecommendRule0
  /// </summary>
  public async Task SnippetForRecommendClientDeleteRecommendRule()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteRecommendRuleAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts"),
      "objectID"
    );
  }

  /// <summary>
  /// Snippet for the GetRecommendRule method.
  ///
  /// getRecommendRule0
  /// </summary>
  public async Task SnippetForRecommendClientGetRecommendRule()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetRecommendRuleAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts"),
      "objectID"
    );
  }

  /// <summary>
  /// Snippet for the GetRecommendStatus method.
  ///
  /// getRecommendStatus0
  /// </summary>
  public async Task SnippetForRecommendClientGetRecommendStatus()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetRecommendStatusAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts"),
      12345L
    );
  }

  /// <summary>
  /// Snippet for the GetRecommendations method.
  ///
  /// get recommendations for recommend model with minimal parameters
  /// </summary>
  public async Task SnippetForRecommendClientGetRecommendations()
  {
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
  }

  /// <summary>
  /// Snippet for the SearchRecommendRules method.
  ///
  /// searchRecommendRules0
  /// </summary>
  public async Task SnippetForRecommendClientSearchRecommendRules()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchRecommendRulesAsync(
      "indexName",
      Enum.Parse<RecommendModels>("RelatedProducts")
    );
  }
}
