// See https://aka.ms/new-console-template for more information

using Algolia.Search.Search.Api;

Console.WriteLine("Hello, World!");

var searchClient = new SearchClient("NIOXZRNMTV", "XXX");


var saved = await searchClient.SaveObjectAsync("test-csharp-new-client",new { ObjectID = "test", value = "test" });

Console.WriteLine(saved);
