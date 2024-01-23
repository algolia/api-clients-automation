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
    await ABTesting.Run(config);
    break;
  case "analytics":
    await Analytics.Run(config);
    break;
  case "insights":
    await Insights.Run(config);
    break;
  case "monitoring":
    await Monitoring.Run(config);
    break;
  case "personalization":
    await Personalization.Run(config);
    break;
  case "query-suggestions":
    await QuerySuggestions.Run(config);
    break;
  case "recommend":
    await Recommend.Run(config);
    break;
  case "search":
    await SearchPlayground.Run(config);
    break;
  case "ingestion":
    await Ingestion.Run(config);
    break;
  case "all":
    await ABTesting.Run(config);
    await Analytics.Run(config);
    await Insights.Run(config);
    await Monitoring.Run(config);
    await Personalization.Run(config);
    await QuerySuggestions.Run(config);
    await Recommend.Run(config);
    await SearchPlayground.Run(config);
    await Ingestion.Run(config);
    break;
}
