using Algolia.Search.Clients;
using Algolia.Search.Models.Insights;

public static class Insights
{
  public static async Task Run(Settings settings)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Insights API playground");
    Console.WriteLine("------------------------------------");
    var client = new InsightsClient(new InsightsConfig(settings.AppId, settings.AdminApiKey));

    Console.WriteLine("--- Push new events `PushEventsAsync` ---");
    var response = await client.PushEventsAsync(new InsightsEvents(new List<EventsItems>()
    {
      new(new ConvertedObjectIDs("Buy event", ConversionEvent.Conversion, "test",
        new List<string> { "iphone_7", "iphone_8" }, "me"))
    })).ConfigureAwait(false);

    Console.WriteLine(response);
  }


}
