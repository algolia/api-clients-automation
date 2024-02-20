using System.Globalization;
using Algolia.Search.Clients;
using Algolia.Search.Models.Abtesting;
using Algolia.Utils;
using Microsoft.Extensions.Logging;

namespace Algolia.Playgrounds;

public class ABTestingPlayground : IPlayground
{
  const string DefaultIndex = "test-csharp-new-client";
  private readonly AbtestingClient _client;
  private readonly Configuration _configuration;

  public ABTestingPlayground(Configuration configuration)
  {
    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());
    var config = new AbtestingConfig(configuration.AppId, configuration.AdminApiKey);
    _client = new AbtestingClient(config, loggerFactory);
    _configuration = configuration;
  }

  public async Task Run()
  {
    PlaygroundHelper.Hello("Starting ABTesting API playground");

    try
    {
      var newABTest = await _client.AddABTestsAsync(new AddABTestsRequest("A simple A/B Test",
        [
          new AddABTestsVariant(new AbTestsVariant("test-index", 50)),
          new AddABTestsVariant(new AbTestsVariant("test-index2", 50))
        ],
        DateTime.UtcNow.AddDays(1d).ToString("o", CultureInfo.InvariantCulture)));

      Console.WriteLine(newABTest.AbTestID);
    }
    catch (Exception e)
    {
      Console.WriteLine(e);
    }
  }
}
