using Algolia.Search.Clients;
using Algolia.Utils;
using Microsoft.Extensions.Logging;

namespace Algolia.Playgrounds;

public class RecommendPlayground : IPlayground
{
  private readonly RecommendClient _client;
  private readonly Configuration _configuration;

  public RecommendPlayground(Configuration configuration)
  {
    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());
    var config = new RecommendConfig(configuration.AppId, configuration.AdminApiKey);
    _client = new RecommendClient(config, loggerFactory);
    _configuration = configuration;
  }

  public async Task Run()
  {
    PlaygroundHelper.Hello("Starting Recommend API playground");

    try
    {
    }
    catch (Exception)
    {
      // ignored
    }
  }
}
