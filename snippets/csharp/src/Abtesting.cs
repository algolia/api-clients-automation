using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Abtesting;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetAbtestingClient
{
  /// <summary>
  /// Snippet for the AddABTests method.
  ///
  /// addABTests with minimal parameters
  /// </summary>
  public async Task SnippetForAbtestingClientAddABTests()
  {
    // >SEPARATOR addABTests
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.AddABTestsAsync(
      new AddABTestsRequest
      {
        EndAt = "2022-12-31T00:00:00.000Z",
        Name = "myABTest",
        Variants = new List<AddABTestsVariant>
        {
          new AddABTestsVariant(
            new AbTestsVariant { Index = "AB_TEST_1", TrafficPercentage = 30, }
          ),
          new AddABTestsVariant(new AbTestsVariant { Index = "AB_TEST_2", TrafficPercentage = 50, })
        },
      }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForAbtestingClientCustomDelete()
  {
    // >SEPARATOR customDelete
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
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
  public async Task SnippetForAbtestingClientCustomGet()
  {
    // >SEPARATOR customGet
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
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
  public async Task SnippetForAbtestingClientCustomPost()
  {
    // >SEPARATOR customPost
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
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
  public async Task SnippetForAbtestingClientCustomPut()
  {
    // >SEPARATOR customPut
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteABTest method.
  ///
  /// deleteABTest
  /// </summary>
  public async Task SnippetForAbtestingClientDeleteABTest()
  {
    // >SEPARATOR deleteABTest
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.DeleteABTestAsync(42);
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetABTest method.
  ///
  /// getABTest
  /// </summary>
  public async Task SnippetForAbtestingClientGetABTest()
  {
    // >SEPARATOR getABTest
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.GetABTestAsync(42);
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListABTests method.
  ///
  /// listABTests with minimal parameters
  /// </summary>
  public async Task SnippetForAbtestingClientListABTests()
  {
    // >SEPARATOR listABTests
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.ListABTestsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the StopABTest method.
  ///
  /// stopABTest
  /// </summary>
  public async Task SnippetForAbtestingClientStopABTest()
  {
    // >SEPARATOR stopABTest
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("YOUR_APP_ID", "YOUR_API_KEY", "YOUR_APP_ID_REGION")
    );

    // Call the API
    var response = await client.StopABTestAsync(42);
    // SEPARATOR<
  }
}
