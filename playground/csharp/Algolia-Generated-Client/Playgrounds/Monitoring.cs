using System.Globalization;
using Algolia.Search.Clients;

public static class Monitoring
{
  public static async Task Run(Settings settings)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Monitoring API playground");
    Console.WriteLine("------------------------------------");
    var client = new MonitoringClient(new MonitoringConfig(settings.AppId, settings.MonitoringApiKey));

    Console.WriteLine("--- Get clusters status `GetStatusAsync` ---");
    var response = await client.GetStatusAsync();
    Console.WriteLine(string.Join(',', response.Status.Select((x, y) => $"Host: {x.Key} is {(x.Value)}")));

    Console.WriteLine("--- Get incidents list `GetIncidentsAsync` ---");
    var incidentsResponse = await client.GetIncidentsAsync();
    
    foreach (var incident in incidentsResponse.Incidents)
    {
      Console.WriteLine(
        $"{incident.Key}: {Environment.NewLine}- {string.Join($"{Environment.NewLine} -", incident.Value.Select(inner =>  $" { DateTimeOffset.FromUnixTimeMilliseconds(inner.T).ToString(CultureInfo.InvariantCulture)} - {inner.V.Title}"))} {Environment.NewLine}");
    }
  }
}
