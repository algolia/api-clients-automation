using System.Globalization;
using Algolia.Search.Clients;
using Algolia.Utils;
using Microsoft.Extensions.Logging;

namespace Algolia.Playgrounds;

public class MonitoringPlayground : IPlayground
{
  private readonly MonitoringClient _client;
  private readonly Configuration _configuration;

  public MonitoringPlayground(Configuration configuration)
  {
    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());
    var config = new MonitoringConfig(configuration.AppId, configuration.AdminApiKey);
    _client = new MonitoringClient(config, loggerFactory);
    _configuration = configuration;
  }

  public async Task Run()
  {
    PlaygroundHelper.Hello("Starting Monitoring API playground");

    try
    {
      Console.WriteLine("--- Get clusters status `GetStatusAsync` ---");
      var response = await _client.GetStatusAsync();
      Console.WriteLine(string.Join(',', response.Status.Select((x, y) => $"Host: {x.Key} is {(x.Value)}")));

      Console.WriteLine("--- Get incidents list `GetIncidentsAsync` ---");
      var incidentsResponse = await _client.GetIncidentsAsync();

      foreach (var incident in incidentsResponse.Incidents)
      {
        Console.WriteLine(
          $"{incident.Key}: {Environment.NewLine}- {string.Join($"{Environment.NewLine} -", incident.Value.Select(inner => $" {DateTimeOffset.FromUnixTimeMilliseconds(inner.T.Value).ToString(CultureInfo.InvariantCulture)} - {inner.V.Title}"))} {Environment.NewLine}");
      }
    }
    catch (Exception e)
    {
      Console.WriteLine(e);
    }
  }
}
