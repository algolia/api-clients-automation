using System.Globalization;
using Algolia.Search.Clients;
using Algolia.Search.Models.Abtesting;
using Algolia.Utils;
using Microsoft.Extensions.Logging;

namespace Algolia.Playgrounds;

public class QuerySuggestionsPlayground : IPlayground
{
  private readonly QuerySuggestionsClient _client;
  private readonly Configuration _configuration;

  public QuerySuggestionsPlayground(Configuration configuration)
  {
    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());
    var config = new QuerySuggestionsConfig(configuration.AppId, configuration.AdminApiKey, "us");
    _client = new QuerySuggestionsClient(config, loggerFactory);
    _configuration = configuration;
  }

  public async Task Run()
  {
    PlaygroundHelper.Hello("Starting QuerySuggestions API playground");

    try
    {
    }
    catch (Exception)
    {
      // ignored
    }
  }
}
