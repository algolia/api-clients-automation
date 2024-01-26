using Algolia.Search.Clients;

namespace Algolia.Playgrounds;

public static class Recommend
{
  public static async Task Run(Configuration configuration)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Recommend API playground");
    Console.WriteLine("------------------------------------");
    var client = new RecommendClient(new RecommendConfig(configuration.AppId, configuration.AdminApiKey));
  }
}
