using Microsoft.Extensions.Configuration;

// get arguments from dotnet run
var arguments = Environment.GetCommandLineArgs();
var client = (arguments.Length > 1 ? arguments[1] : null) ?? "all";

Console.WriteLine("------------------------------------");
Console.WriteLine("Welcome to the Algolia C# playground");
Console.WriteLine(client == "all"
  ? "Running playground for all Algolia Clients"
  : "Running playground for Algolia client: " + client);
Console.WriteLine("------------------------------------");

// Get Algolia settings from appsettings.json (AppId, ApiKey)
var config = new ConfigurationBuilder().AddJsonFile("appsettings.json", optional: true).Build();

var algoliaSetting = config.GetSection("Algolia").Get<Settings>();
if (algoliaSetting == null)
{
  throw new Exception(
    "Please check your appsettings.json file (A appsettings.example.json is available to help you bootstrap your appsettings.json)");
}

switch (client)
{
  case "abtesting":
    await ABTesting.Run(algoliaSetting);
    break;
  case "analytics":
    await Analytics.Run(algoliaSetting);
    break;
  case "insights":
    await Insights.Run(algoliaSetting);
    break;
  case "monitoring":
    await Monitoring.Run(algoliaSetting);
    break;
  case "personalization":
    await Personalization.Run(algoliaSetting);
    break;
  case "query-suggestions":
    await QuerySuggestions.Run(algoliaSetting);
    break;
  case "recommend":
    await Recommend.Run(algoliaSetting);
    break;
  case "search":
    await SearchPlayground.Run(algoliaSetting);
    break;
  case "ingestion":
    await Ingestion.Run(algoliaSetting);
    break;
  case "all":
    await ABTesting.Run(algoliaSetting);
    await Analytics.Run(algoliaSetting);
    await Insights.Run(algoliaSetting);
    await Monitoring.Run(algoliaSetting);
    await Personalization.Run(algoliaSetting);
    await QuerySuggestions.Run(algoliaSetting);
    await Recommend.Run(algoliaSetting);
    await SearchPlayground.Run(algoliaSetting);
    await Ingestion.Run(algoliaSetting);
    break;
}
