using Algolia.Search.Clients;
using Algolia.Search.Models.Insights;
using Algolia.Utils;
using Microsoft.Extensions.Logging;

namespace Algolia.Playgrounds;

public class InsightsPlayground : IPlayground
{
  private readonly InsightsClient _client;
  private readonly Configuration _configuration;

  public InsightsPlayground(Configuration configuration)
  {
    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());
    var config = new InsightsConfig(configuration.AppId, configuration.AdminApiKey);
    _client = new InsightsClient(config, loggerFactory);
    _configuration = configuration;
  }

  public async Task Run()
  {
    PlaygroundHelper.Hello("Starting Insights API playground");

    try
    {
      Console.WriteLine("--- Push new events `PushEventsAsync` ---");
      var response = await _client.PushEventsAsync(new InsightsEvents([
        new EventsItems(new ConvertedObjectIDs("Buy event", ConversionEvent.Conversion, "test",
          ["iphone_7", "iphone_8"], "me"))
      ])).ConfigureAwait(false);

      Console.WriteLine(response);
    }
    catch (Exception e)
    {
      Console.WriteLine(e);
    }
  }
}
