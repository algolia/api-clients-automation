using Algolia.Search.Clients;
using Algolia.Utils;
using Microsoft.Extensions.Logging;

namespace Algolia.Playgrounds;

public class PersonalizationPlayground : IPlayground
{
  private readonly PersonalizationClient _client;
  private readonly Configuration _configuration;

  public PersonalizationPlayground(Configuration configuration)
  {
    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());
    var config = new PersonalizationConfig(configuration.AppId, configuration.AdminApiKey, "us");
    _client = new PersonalizationClient(config, loggerFactory);
    _configuration = configuration;
  }

  public async Task Run()
  {
    PlaygroundHelper.Hello("Starting Personalization API playground");

    try
    {
    }
    catch (Exception e)
    {
      Console.WriteLine(e);
    }
  }
}
