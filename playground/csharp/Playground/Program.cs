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

switch (client)
{
  case "abtesting":
    var abTesting = new ABTestingPlayground(config);
    await abTesting.Run();
    break;
  case "analytics":
    var analytics = new AnalyticsPlayground(config);
    await analytics.Run();
    break;
  case "insights":
    var insights = new InsightsPlayground(config);
    await insights.Run();
    break;
  case "monitoring":
    var monitoring = new MonitoringPlayground(config);
    await monitoring.Run();
    break;
  case "personalization":
    var personalization = new PersonalizationPlayground(config);
    await personalization.Run();
    break;
  case "query-suggestions":
    var querySuggestions = new QuerySuggestionsPlayground(config);
    await querySuggestions.Run();
    break;
  case "recommend":
    var recommend = new RecommendPlayground(config);
    await recommend.Run();
    break;
  case "search":
    var searchPlayground = new SearchPlayground(config);
    await searchPlayground.Run();
    break;
  case "ingestion":
    var ingestion = new IngestionPlayground(config);
    await ingestion.Run();
    break;
  case "all":
    var abTestingAll = new ABTestingPlayground(config);
    await abTestingAll.Run();

    var analyticsAll = new AnalyticsPlayground(config);
    await analyticsAll.Run();

    var insightsAll = new InsightsPlayground(config);
    await insightsAll.Run();

    var monitoringAll = new MonitoringPlayground(config);
    await monitoringAll.Run();
 
    var personalizationAll = new PersonalizationPlayground(config);
    await personalizationAll.Run();

    var querySuggestionsAll = new QuerySuggestionsPlayground(config);
    await querySuggestionsAll.Run();
  
    var recommendAll = new RecommendPlayground(config);
    await recommendAll.Run();

    var searchPlaygroundAll = new SearchPlayground(config);
    await searchPlaygroundAll.Run();
 
    var ingestionAll = new IngestionPlayground(config);
    await ingestionAll.Run();
    break;
}
