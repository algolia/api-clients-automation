// See https://aka.ms/new-console-template for more information

using Algolia.Search.Clients;

Console.WriteLine("Hello, World!");

var searchClient = new SearchClient("myApp", "myKey");

var index = searchClient.InitIndex("test");

var ruleAsync = await index.GetRuleAsync("");

ruleAsync.Consequence.Params.AutomaticFacetFilters.First().Facet = "test";
