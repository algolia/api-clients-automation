using Algolia.Playgrounds;
using Algolia.Utils;

var arguments = Environment.GetCommandLineArgs();
var client = (arguments.Length > 1 ? arguments[1] : null) ?? "all";

Console.WriteLine("------------------------------------");
Console.WriteLine("Welcome to the Algolia C# playground");
Console.WriteLine(client == "all"
  ? "Running playground for all Algolia Clients"
  : "Running playground for Algolia client: " + client);
Console.WriteLine("------------------------------------");

var config = Config.Load();

await StartPlayground(client, config);

async Task StartPlayground(string s, Configuration configuration)
{
  switch (s)
  {
    case "abtesting":
      var abTesting = new ABTestingPlayground(configuration);
      await abTesting.Run();
      break;
    case "analytics":
      var analytics = new AnalyticsPlayground(configuration);
      await analytics.Run();
      break;
    case "insights":
      var insights = new InsightsPlayground(configuration);
      await insights.Run();
      break;
    case "monitoring":
      var monitoring = new MonitoringPlayground(configuration);
      await monitoring.Run();
      break;
    case "personalization":
      var personalization = new PersonalizationPlayground(configuration);
      await personalization.Run();
      break;
    case "query-suggestions":
      var querySuggestions = new QuerySuggestionsPlayground(configuration);
      await querySuggestions.Run();
      break;
    case "recommend":
      var recommend = new RecommendPlayground(configuration);
      await recommend.Run();
      break;
    case "search":
      var searchPlayground = new SearchPlayground(configuration);
      await searchPlayground.Run();
      break;
    case "ingestion":
      var ingestion = new IngestionPlayground(configuration);
      await ingestion.Run();
      break;
    case "all":
      await StartPlayground("abtesting", configuration);
      await StartPlayground("analytics", configuration);
      await StartPlayground("insights", configuration);
      await StartPlayground("monitoring", configuration);
      await StartPlayground("personalization", configuration);
      await StartPlayground("query-suggestions", configuration);
      await StartPlayground("recommend", configuration);
      await StartPlayground("search", configuration);
      await StartPlayground("ingestion", configuration);
      break;
  }
}
