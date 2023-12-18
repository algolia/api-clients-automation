// See https://aka.ms/new-console-template for more information

using Algolia.Search.Search.Api;
using Algolia.Search.Search.Models;
using Action = Algolia.Search.Search.Models.Action;

Console.WriteLine("Hello, World!");

var searchClient = new SearchClient("NIOXZRNMTV", "XXX");

// Save
Console.WriteLine("--- Save a single object `SaveObjectAsync` ---");
var saved = await searchClient.SaveObjectAsync("test-csharp-new-client",
  new { ObjectID = "test2", value = "test", otherValue = "otherValue" });
Console.WriteLine(saved.ObjectID);

// Batch
Console.WriteLine("--- Save a multiple objects `BatchAsync` ---");
var requests = new List<BatchRequest>()
{
  new(Action.AddObject, new { ObjectID = "test3", value = "batch1", otherValue = "otherValue1" }),
  new(Action.AddObject, new { ObjectID = "test4", value = "batch2", otherValue = "otherValue2" }),
  new(Action.AddObject, new { ObjectID = "test5", value = "batch3", otherValue = "otherValue3" }),
};
var batch = await searchClient.BatchAsync("test-csharp-new-client", new BatchWriteParams(requests));
batch.ObjectIDs.ForEach(Console.WriteLine);

// // Browse
// Console.WriteLine("--- Browse all objects `BrowseAsync` ---");
// var r = await searchClient.BrowseAsync<TestObject>("test-csharp-new-client");
// r.Hits.ForEach(h => Console.WriteLine(h.ObjectID));
//
// // Get Objects
// Console.WriteLine("--- Get Objects `GetObjectsAsync` ---");
// var getObjRequests = new List<GetObjectsRequest>
// {
//   new("test2", "test-csharp-new-client")
//   {
//     AttributesToRetrieve = new List<string> { "otherValue" }
//   },
//   new("test3", "test-csharp-new-client")
//   {
//     AttributesToRetrieve = new List<string> { "otherValue" }
//   },
// };
//
// var getObjResults = await searchClient.GetObjectsAsync<TestObject>(new GetObjectsParams(getObjRequests));
// getObjResults.Results.ForEach(testObject => Console.WriteLine(testObject.otherValue));
//
// // Search single
// Console.WriteLine("--- Search single index `SearchSingleIndexAsync` ---");
// var t = await searchClient.SearchSingleIndexAsync<TestObject>("test-csharp-new-client");
// t.Hits.ForEach(h => Console.WriteLine(h.ObjectID));

// Search
Console.WriteLine("--- Search multiple indices `SearchAsync` ---");
var searchQueries = new List<SearchQuery>()
{
  new SearchQuery(new SearchForHits("test-csharp-new-client")),
  new SearchQuery(new SearchForHits("test-csharp-new-client")),
};
var search = await searchClient.SearchAsync(new SearchMethodParams(searchQueries));
var getterSearchResponse = search.Results.First().GetterSearchResponse<TestObject>();
Console.WriteLine(getterSearchResponse.Hits.First().ObjectID);
