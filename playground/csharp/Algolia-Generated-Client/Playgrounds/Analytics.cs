using System.Globalization;
using System.Runtime.InteropServices.JavaScript;
using Algolia.Search.Clients;

public static class Analytics
{
  public static async Task Run(Settings settings)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Analytics API playground");
    Console.WriteLine("------------------------------------");
    var client = new AnalyticsClient(new AnalyticsConfig(settings.AppId, settings.AdminApiKey));

    var shortDateString = DateTime.UtcNow.AddDays(-1).ToString("YYYY-MM-DD");
    Console.WriteLine(shortDateString);
    var getSearchesCountResponse = await client.GetSearchesCountAsync("test-index", shortDateString);
    Console.WriteLine(getSearchesCountResponse.Count);
  }
}
