using Algolia.Search.Clients;

public static class QuerySuggestions
{
  public static async Task Run(Settings settings)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting QuerySuggestions API playground");
    Console.WriteLine("------------------------------------");
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig(settings.AppId, settings.AdminApiKey, "us"));
  }
}
