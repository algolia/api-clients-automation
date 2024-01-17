using Microsoft.Extensions.Configuration;

Console.WriteLine("------------------------------------");
Console.WriteLine("Welcome to the Algolia C# playground");
Console.WriteLine("------------------------------------");

// Get Algolia settings from appsettings.json (AppId, ApiKey)
var config = new ConfigurationBuilder().AddJsonFile("appsettings.json", optional: true).Build();

var algoliaSetting = config.GetSection("Algolia").Get<Settings>();
if (algoliaSetting == null)
{
  throw new Exception("Please check your appsettings.json file");
}

// Start Search Playground
await SearchPlayground.Run(algoliaSetting);

// Start Ingestion Playground
await Ingestion.Run(algoliaSetting);

// Start Recommend Playground
await Recommend.Run(algoliaSetting);

// Start ABTesting Playground
 await ABTesting.Run(algoliaSetting);

// Start Analytics Playground
await Analytics.Run(algoliaSetting);

// Start Insights Playground
await Insights.Run(algoliaSetting);

// Start Monitoring Playground
await Monitoring.Run(algoliaSetting);

// Start QuerySuggestions Playground
await QuerySuggestions.Run(algoliaSetting);

// Start Personalization Playground
await Personalization.Run(algoliaSetting);
