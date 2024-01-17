using System.Globalization;
using Algolia.Search.Clients;
using Algolia.Search.Models.Abtesting;

public static class ABTesting
{
  public static async Task Run(Settings settings)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting ABTesting API playground");
    Console.WriteLine("------------------------------------");
    var client = new AbtestingClient(new AbtestingConfig(settings.AppId, settings.AdminApiKey));

    var newABTest = await client.AddABTestsAsync(new AddABTestsRequest("A simple A/B Test",
      new List<AddABTestsVariant> { new(new AbTestsVariant("test-index", 50)),  new(new AbTestsVariant("test-index2", 50)) },
      DateTime.UtcNow.AddDays(1d).ToString("o", CultureInfo.InvariantCulture)));

    Console.WriteLine(newABTest.AbTestID);
  }
}
