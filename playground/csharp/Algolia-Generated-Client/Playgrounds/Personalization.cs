using Algolia.Search.Clients;

public static class Personalization
{
  public static async Task Run(Settings settings)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Personalization API playground");
    Console.WriteLine("------------------------------------");
    var client = new PersonalizationClient(new PersonalizationConfig(settings.AppId, settings.AdminApiKey, "us"));
  }
}
