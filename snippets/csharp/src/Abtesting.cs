using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Abtesting;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetAbtestingClient
{
  [Fact]
  public void Dispose()
  {

  }

  /// <summary>
  /// Snippet for the addABTests method.
  ///
  /// addABTests with minimal parameters
  /// </summary>
  public async Task SnippetForAddABTests0()
  {
    // Initialize the client
    var client = new AbtestingClient(new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    var addABTestsRequest0 = new AddABTestsRequest();
    {
      const string endAt1 = "2022-12-31T00:00:00.000Z";
      addABTestsRequest0.EndAt = endAt1; const string name1 = "myABTest";
      addABTestsRequest0.Name = name1; var variants1 = new List<AddABTestsVariant>();
      var variants_02 = new AbTestsVariant();
      {
        const string index3 = "AB_TEST_1";
        variants_02.Index = index3; const int trafficPercentage3 = 30;
        variants_02.TrafficPercentage = trafficPercentage3;
      }
      variants1.Add(new AddABTestsVariant(variants_02)); var variants_12 = new AbTestsVariant();
      {
        const string index3 = "AB_TEST_2";
        variants_12.Index = index3; const int trafficPercentage3 = 50;
        variants_12.TrafficPercentage = trafficPercentage3;
      }
      variants1.Add(new AddABTestsVariant(variants_12));
      addABTestsRequest0.Variants = variants1;
    }


    var response = await _client.AddABTestsAsync(addABTestsRequest0);
  }

  /// <summary>
  /// Snippet for the customDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomDelete0()
  {
    // Initialize the client
    var client = new AbtestingClient(new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new AbtestingClient(new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new AbtestingClient(new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

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
    var client = new AbtestingClient(new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPutAsync(path0);
  }

  /// <summary>
  /// Snippet for the deleteABTest method.
  ///
  /// deleteABTest
  /// </summary>
  public async Task SnippetForDeleteABTest0()
  {
    // Initialize the client
    var client = new AbtestingClient(new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const int id0 = 42;


    var response = await _client.DeleteABTestAsync(id0);
  }

  /// <summary>
  /// Snippet for the getABTest method.
  ///
  /// getABTest
  /// </summary>
  public async Task SnippetForGetABTest0()
  {
    // Initialize the client
    var client = new AbtestingClient(new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const int id0 = 42;


    var response = await _client.GetABTestAsync(id0);
  }

  /// <summary>
  /// Snippet for the listABTests method.
  ///
  /// listABTests with minimal parameters
  /// </summary>
  public async Task SnippetForListABTests0()
  {
    // Initialize the client
    var client = new AbtestingClient(new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API


    var response = await _client.ListABTestsAsync();
  }

  /// <summary>
  /// Snippet for the stopABTest method.
  ///
  /// stopABTest
  /// </summary>
  public async Task SnippetForStopABTest0()
  {
    // Initialize the client
    var client = new AbtestingClient(new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION"));

    // Call the API
    const int id0 = 42;


    var response = await _client.StopABTestAsync(id0);
  }

}
