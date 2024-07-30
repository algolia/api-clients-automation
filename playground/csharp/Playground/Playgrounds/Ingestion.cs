using Algolia.Search.Clients;
using Algolia.Search.Models.Ingestion;
using Algolia.Search.Models.Monitoring;
using Algolia.Utils;
using Microsoft.Extensions.Logging;

namespace Algolia.Playgrounds;

public class IngestionPlayground : IPlayground
{
  private readonly IngestionClient _client;
  private readonly Configuration _configuration;

  public IngestionPlayground(Configuration configuration)
  {
    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());
    var config = new IngestionConfig(configuration.AppId, configuration.AdminApiKey, "us");
    _client = new IngestionClient(config, loggerFactory);
    _configuration = configuration;
  }

  public async Task Run()
  {
    PlaygroundHelper.Hello("Starting Ingestion API playground");
    try
    {
      // Get existing JSON source
      Console.WriteLine("--- Get existing JSON source `GetSourcesAsync` ---");
      var jsonSources = await _client.ListSourcesAsync(type: [SourceType.Json]).ConfigureAwait(false);
      Console.WriteLine(jsonSources.Sources.Count == 0
        ? "There is no JSON Source !"
        : $"There is {jsonSources.Sources.Count} JSON source(s)");

      // Deleting existing JSON source
      Console.WriteLine("--- Deleting existing JSON source `DeleteSourceAsync` ---");
      foreach (var source in jsonSources.Sources)
      {
        Console.WriteLine($"Deleting source {source.SourceID}");
        var response = await _client.DeleteSourceAsync(source.SourceID).ConfigureAwait(false);
        Console.WriteLine(response.DeletedAt);
      }

      // Create a new JSON source
      Console.WriteLine("--- Create a new source `CreateSourceAsync` ---");
      var saved = await _client.CreateSourceAsync(new SourceCreate
      {
        Name = "test-csharp-new-client",
        Type = SourceType.Json,
        Input = new SourceInput(new SourceJSON("https://test.com/test.json"))
      }).ConfigureAwait(false);

      Console.WriteLine(saved.SourceID);
    }
    catch (Exception)
    {
      // ignored
    }
  }
}
