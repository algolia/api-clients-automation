using Algolia.Search.Clients;

public static class Personalization
{
  public static async Task Run(Configuration configuration)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Personalization API playground");
    Console.WriteLine("------------------------------------");
    var client = new PersonalizationClient(new PersonalizationConfig(configuration.AppId, configuration.AdminApiKey, "us"));
  }
}
