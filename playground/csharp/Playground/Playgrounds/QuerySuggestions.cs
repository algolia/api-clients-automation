using Algolia.Search.Clients;

public static class QuerySuggestions
{
  public static async Task Run(Configuration configuration)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting QuerySuggestions API playground");
    Console.WriteLine("------------------------------------");
    var client = new QuerySuggestionsClient(new QuerySuggestionsConfig(configuration.AppId, configuration.AdminApiKey, "us"));
  }
}
