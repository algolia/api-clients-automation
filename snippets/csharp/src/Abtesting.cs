// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// >IMPORT
using Algolia.Search.Clients;
using Algolia.Search.Models.Abtesting;
// IMPORT<
using Action = Algolia.Search.Models.Ingestion.Action;

public class SnippetAbtestingClient
{
  /// <summary>
  /// Snippet for the AddABTests method.
  ///
  /// addABTests with minimal parameters
  /// </summary>
  public async Task SnippetForAbtestingClientAddABTests()
  {
    // >SEPARATOR addABTests default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.AddABTestsAsync(
      new AddABTestsRequest
      {
        EndAt = "2022-12-31T00:00:00.000Z",
        Name = "myABTest",
        Variants = new List<AddABTestsVariant>
        {
          new AddABTestsVariant(new AbTestsVariant { Index = "AB_TEST_1", TrafficPercentage = 30 }),
          new AddABTestsVariant(new AbTestsVariant { Index = "AB_TEST_2", TrafficPercentage = 50 }),
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForAbtestingClientCustomDelete()
  {
    // >SEPARATOR customDelete default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAbtestingClientCustomGet()
  {
    // >SEPARATOR customGet default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAbtestingClientCustomPost()
  {
    // >SEPARATOR customPost default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
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
  public async Task SnippetForAbtestingClientCustomPut()
  {
    // >SEPARATOR customPut default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.CustomPutAsync("test/minimal");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteABTest method.
  ///
  /// deleteABTest
  /// </summary>
  public async Task SnippetForAbtestingClientDeleteABTest()
  {
    // >SEPARATOR deleteABTest default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.DeleteABTestAsync(42);
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetABTest method.
  ///
  /// getABTest
  /// </summary>
  public async Task SnippetForAbtestingClientGetABTest()
  {
    // >SEPARATOR getABTest default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.GetABTestAsync(42);
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListABTests method.
  ///
  /// listABTests with minimal parameters
  /// </summary>
  public async Task SnippetForAbtestingClientListABTests()
  {
    // >SEPARATOR listABTests default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ListABTestsAsync();
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ScheduleABTest method.
  ///
  /// scheduleABTest with minimal parameters
  /// </summary>
  public async Task SnippetForAbtestingClientScheduleABTest()
  {
    // >SEPARATOR scheduleABTest default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.ScheduleABTestAsync(
      new ScheduleABTestsRequest
      {
        EndAt = "2022-12-31T00:00:00.000Z",
        ScheduledAt = "2022-11-31T00:00:00.000Z",
        Name = "myABTest",
        Variants = new List<AddABTestsVariant>
        {
          new AddABTestsVariant(new AbTestsVariant { Index = "AB_TEST_1", TrafficPercentage = 30 }),
          new AddABTestsVariant(new AbTestsVariant { Index = "AB_TEST_2", TrafficPercentage = 50 }),
        },
      }
    );
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SetClientApiKey method.
  ///
  /// switch API key
  /// </summary>
  public async Task SnippetForAbtestingClientSetClientApiKey()
  {
    // >SEPARATOR setClientApiKey default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    client.SetClientApiKey("updated-api-key");
    // >LOG
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the StopABTest method.
  ///
  /// stopABTest
  /// </summary>
  public async Task SnippetForAbtestingClientStopABTest()
  {
    // >SEPARATOR stopABTest default
    // Initialize the client
    var client = new AbtestingClient(
      new AbtestingConfig("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")
    );

    // Call the API
    var response = await client.StopABTestAsync(42);
    // >LOG
    // SEPARATOR<
  }
}
