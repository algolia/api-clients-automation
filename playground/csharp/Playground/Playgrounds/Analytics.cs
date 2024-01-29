using Algolia.Search.Clients;

namespace Algolia.Playgrounds;

public static class Analytics
{
  public static async Task Run(Configuration configuration)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Analytics API playground");
    Console.WriteLine("------------------------------------");
    var client = new AnalyticsClient(new AnalyticsConfig(configuration.AppId, configuration.AdminApiKey));

    var shortDateString = DateTime.UtcNow.AddDays(-1).ToString("YYYY-MM-DD");
    Console.WriteLine(shortDateString);
    var getSearchesCountResponse = await client.GetSearchesCountAsync("test-index", shortDateString);
    Console.WriteLine(getSearchesCountResponse.Count);
  }
}
