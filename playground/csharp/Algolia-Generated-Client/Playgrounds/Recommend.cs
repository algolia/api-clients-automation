using Algolia.Search.Clients;

public static class Recommend
{
  public static async Task Run(Settings settings)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Recommend API playground");
    Console.WriteLine("------------------------------------");
    var client = new RecommendClient(new RecommendConfig(settings.AppId, settings.AdminApiKey));
  }
}
