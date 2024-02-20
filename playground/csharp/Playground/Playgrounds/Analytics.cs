using Algolia.Search.Clients;
using Algolia.Utils;
using Microsoft.Extensions.Logging;

namespace Algolia.Playgrounds;

public class AnalyticsPlayground : IPlayground
{
  private readonly AnalyticsClient _client;
  private readonly Configuration _configuration;

  public AnalyticsPlayground(Configuration configuration)
  {
    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());
    var config = new AnalyticsConfig(configuration.AppId, configuration.AdminApiKey);
    _client = new AnalyticsClient(config, loggerFactory);
    _configuration = configuration;
  }

  public async Task Run()
  {
    PlaygroundHelper.Hello("Starting Analytics API playground");
    try
    {
      var shortDateString = DateTime.UtcNow.AddDays(-1).ToString("YYYY-MM-DD");
      Console.WriteLine(shortDateString);
      var getSearchesCountResponse = await _client.GetSearchesCountAsync("test-index", shortDateString);
      Console.WriteLine(getSearchesCountResponse.Count);
    }
    catch (Exception)
    {
      // ignored
    }
  }
}
