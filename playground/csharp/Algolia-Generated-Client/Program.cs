// See https://aka.ms/new-console-template for more information

using Algolia.Search.Search.Api;
using Algolia.Search.Search.Client;

Console.WriteLine("Algolia Search Client Playground for C#");


var configuration = new Configuration();
configuration.AddApiKey("apiKey", "6af80f5e321fb3de2a848ff74ba81546");
configuration.AddApiKey("appId", "NIOXZRNMTV");


var searchClient = new SearchClient(configuration);

var resp = await searchClient.AddOrUpdateObjectAsync("playground-csharp", "myobjectid", new { name = "John Doe" });
