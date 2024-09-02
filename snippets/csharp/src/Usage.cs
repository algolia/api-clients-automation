// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// >IMPORT
using Algolia.Search.Clients;
using Algolia.Search.Http;
// IMPORT<
using Algolia.Search.Models.Usage;
using Action = Algolia.Search.Models.Ingestion.Action;

public class SnippetUsageClient
{
  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForUsageClientCustomDelete()
  {
    // >SEPARATOR customDelete default
    // Initialize the client
    var client = new UsageClient(new UsageConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomDeleteAsync("test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForUsageClientCustomGet()
  {
    // >SEPARATOR customGet default
    // Initialize the client
    var client = new UsageClient(new UsageConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomGetAsync("test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForUsageClientCustomPost()
  {
    // >SEPARATOR customPost default
    // Initialize the client
    var client = new UsageClient(new UsageConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPostAsync("test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForUsageClientCustomPut()
  {
    // >SEPARATOR customPut default
    // Initialize the client
    var client = new UsageClient(new UsageConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPutAsync("test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetIndexUsage method.
  ///
  /// getIndexUsage with minimal parameters
  /// </summary>
  public async Task SnippetForUsageClientGetIndexUsage()
  {
    // >SEPARATOR getIndexUsage default
    // Initialize the client
    var client = new UsageClient(new UsageConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetIndexUsageAsync(
      Enum.Parse<Statistic>("QueriesOperations"),
      "<YOUR_INDEX_NAME>",
      "2024-04-03T12:46:43Z",
      "2024-04-05T12:46:43Z"
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetUsage method.
  ///
  /// getUsage with minimal parameters
  /// </summary>
  public async Task SnippetForUsageClientGetUsage()
  {
    // >SEPARATOR getUsage default
    // Initialize the client
    var client = new UsageClient(new UsageConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetUsageAsync(
      Enum.Parse<Statistic>("QueriesOperations"),
      "2024-04-03T12:46:43Z",
      "2024-04-05T12:46:43Z"
    );
    // SEPARATOR<
  }
}
