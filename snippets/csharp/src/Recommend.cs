using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Recommend;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetRecommendClient
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
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

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
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

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
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

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
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPutAsync(path0);
  }

  /// <summary>
  /// Snippet for the deleteRecommendRule method.
  ///
  /// deleteRecommendRule0
  /// </summary>
  public async Task SnippetForDeleteRecommendRule0()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    var model0 = (RecommendModels)Enum.Parse(typeof(RecommendModels), "RelatedProducts");
    const string objectID0 = "objectID";


    var response = await _client.DeleteRecommendRuleAsync(indexName0, model0, objectID0);
  }

  /// <summary>
  /// Snippet for the getRecommendRule method.
  ///
  /// getRecommendRule0
  /// </summary>
  public async Task SnippetForGetRecommendRule0()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    var model0 = (RecommendModels)Enum.Parse(typeof(RecommendModels), "RelatedProducts");
    const string objectID0 = "objectID";


    var response = await _client.GetRecommendRuleAsync(indexName0, model0, objectID0);
  }

  /// <summary>
  /// Snippet for the getRecommendStatus method.
  ///
  /// getRecommendStatus0
  /// </summary>
  public async Task SnippetForGetRecommendStatus0()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    var model0 = (RecommendModels)Enum.Parse(typeof(RecommendModels), "RelatedProducts");
    const long taskID0 = 12345L;


    var response = await _client.GetRecommendStatusAsync(indexName0, model0, taskID0);
  }

  /// <summary>
  /// Snippet for the getRecommendations method.
  ///
  /// get recommendations for recommend model with minimal parameters
  /// </summary>
  public async Task SnippetForGetRecommendations0()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var getRecommendationsParams0 = new GetRecommendationsParams();
    {
      var requests1 = new List<RecommendationsRequest>();
      var requests_02 = new RecommendationsQuery();
      {
        const string indexName3 = "indexName";
        requests_02.IndexName = indexName3; const string objectID3 = "objectID";
        requests_02.ObjectID = objectID3; var model3 = (RecommendationModels)Enum.Parse(typeof(RecommendationModels), "RelatedProducts");
        requests_02.Model = model3; const int threshold3 = 42;
        requests_02.Threshold = threshold3;
      }
      requests1.Add(new RecommendationsRequest(requests_02));
      getRecommendationsParams0.Requests = requests1;
    }


    var response = await _client.GetRecommendationsAsync(getRecommendationsParams0);
  }

  /// <summary>
  /// Snippet for the searchRecommendRules method.
  ///
  /// searchRecommendRules0
  /// </summary>
  public async Task SnippetForSearchRecommendRules0()
  {
    // Initialize the client
    var client = new RecommendClient(new RecommendConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    var model0 = (RecommendModels)Enum.Parse(typeof(RecommendModels), "RelatedProducts");


    var response = await _client.SearchRecommendRulesAsync(indexName0, model0);
  }

}
