using Algolia.Search.Clients;
using Algolia.Utils;
using Microsoft.Extensions.Logging;

namespace Algolia.Playgrounds;

public class AgentStudioPlayground : IPlayground
{
  private readonly AgentStudioClient _client;

  public AgentStudioPlayground(Configuration configuration)
  {
    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());
    var config = new AgentStudioConfig(configuration.AppId, configuration.AdminApiKey, "us");
    _client = new AgentStudioClient(config, loggerFactory);
  }

  public async Task Run()
  {
    PlaygroundHelper.Hello("Starting Agent Studio API playground");
    try
    {
      var response = await _client.ListAgentsAsync().ConfigureAwait(false);
      Console.WriteLine("List of agents:");
      foreach (var agent in response.Data)
      {
        Console.WriteLine($"- {agent.Name} (ID: {agent.Id})");
      }
    }
    catch (Exception e)
    {
      Console.WriteLine($"Error: {e.Message}");
    }
  }
}
