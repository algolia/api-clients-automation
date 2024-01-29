using Algolia.Search.Clients;
using Algolia.Search.Models.Insights;

namespace Algolia.Playgrounds;

public static class Insights
{
  public static async Task Run(Configuration configuration)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Insights API playground");
    Console.WriteLine("------------------------------------");
    var client = new InsightsClient(new InsightsConfig(configuration.AppId, configuration.AdminApiKey));

    Console.WriteLine("--- Push new events `PushEventsAsync` ---");
    var response = await client.PushEventsAsync(new InsightsEvents(new List<EventsItems>()
    {
      new(new ConvertedObjectIDs("Buy event", ConversionEvent.Conversion, "test",
        new List<string> { "iphone_7", "iphone_8" }, "me"))
    })).ConfigureAwait(false);

    Console.WriteLine(response);
  }


}
