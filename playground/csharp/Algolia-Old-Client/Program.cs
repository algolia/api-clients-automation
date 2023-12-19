// See https://aka.ms/new-console-template for more information

using Algolia.Search.Clients;

Console.WriteLine("Hello, World!");

var searchClient = new SearchClient("NIOXZRNMTV", "XXX");

var index = searchClient.InitIndex("test-csharp-legacy-client");

var saved = await index.SaveObjectAsync(new { ObjectID = "test", value = "test" });

Console.WriteLine(saved);
