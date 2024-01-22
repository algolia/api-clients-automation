using Algolia.Search.Clients;
using Algolia.Search.Models.Ingestion;

public static class Ingestion
{
  public static async Task Run(Settings settings)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Ingestion API playground");
    Console.WriteLine("------------------------------------");
    var client = new IngestionClient(new IngestionConfig(settings.AppId, settings.AdminApiKey, "us"));

    // Get existing JSON source
    Console.WriteLine("--- Get existing JSON source `GetSourcesAsync` ---");
    var jsonSources = await client.GetSourcesAsync(type:new List<SourceType> { SourceType.Json }).ConfigureAwait(false);
    Console.WriteLine(jsonSources.Sources.Count == 0 ? "There is no JSON Source !" : $"There is {jsonSources.Sources.Count} JSON source(s)");

    // Deleting existing JSON source
    Console.WriteLine("--- Deleting existing JSON source `DeleteSourceAsync` ---");
    foreach (var source in jsonSources.Sources)
    {
      Console.WriteLine($"Deleting source {source.SourceID}");
      var response = await client.DeleteSourceAsync(source.SourceID).ConfigureAwait(false);
      Console.WriteLine(response.DeletedAt);
    }

    // Create a new JSON source
    Console.WriteLine("--- Create a new source `CreateSourceAsync` ---");
    var saved = await client.CreateSourceAsync(new SourceCreate
    {
      Name = "test-csharp-new-client",
      Type = SourceType.Json,
      Input = new SourceInput(new SourceJSON("https://test.com/test.json"))
    }).ConfigureAwait(false);

    Console.WriteLine(saved.SourceID);
  }
}
