using Algolia.Search.Client;
using Algolia.Search.Search.Api;
using Algolia.Search.Search.Client;
using Algolia.Search.Search.Models;
using Microsoft.Extensions.Configuration;
using Action = Algolia.Search.Search.Models.Action;

Console.WriteLine("Welcome to the Algolia C# playground");

var config = new ConfigurationBuilder().AddJsonFile("appsettings.json", optional: true).Build();

var algoliaSetting = config.GetSection("Algolia").Get<PlaygroundSetting>();
if (algoliaSetting == null)
{
  throw new Exception("Please check your appsettings.json file");
}

var searchClient = new SearchClient(new SearchConfig(algoliaSetting.AppId, algoliaSetting.ApiKey)
{
  Compression = CompressionType.NONE
});

// Save
Console.WriteLine("--- Save a single object `SaveObjectAsync` ---");
var saved = await searchClient.SaveObjectAsync("test-csharp-new-client",
  new { ObjectID = "test2", value = "test", otherValue = "otherValue" });
Console.WriteLine(saved.ObjectID);

Console.WriteLine("--- Set setting on index `SetSettingsAsync` ---");
var updatedAtResponse = await searchClient.SetSettingsAsync("test-csharp-new-client", new IndexSettings()
{
  AttributesForFaceting = new List<string> { "searchable(value)", "searchable(otherValue)" },
  SearchableAttributes = new List<string> { "value", "otherValue" }
});
Console.WriteLine(updatedAtResponse.TaskID);


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

// Browse
Console.WriteLine("--- Browse all objects `BrowseAsync` ---");
var r = await searchClient.BrowseAsync<TestObject>("test-csharp-new-client");
r.Hits.ForEach(h => Console.WriteLine(h.ObjectID));

// Get Objects
Console.WriteLine("--- Get Objects `GetObjectsAsync` ---");
var getObjRequests = new List<GetObjectsRequest>
{
  new("test2", "test-csharp-new-client")
  {
    AttributesToRetrieve = new List<string> { "otherValue" }
  },
  new("test3", "test-csharp-new-client")
  {
    AttributesToRetrieve = new List<string> { "otherValue" }
  },
};

var getObjResults = await searchClient.GetObjectsAsync<TestObject>(new GetObjectsParams(getObjRequests));
getObjResults.Results.ForEach(testObject => Console.WriteLine(testObject.otherValue));

// Search single
Console.WriteLine("--- Search single index `SearchSingleIndexAsync` ---");
var t = await searchClient.SearchSingleIndexAsync<TestObject>("test-csharp-new-client");
t.Hits.ForEach(h => Console.WriteLine(h.ObjectID));

// Search
Console.WriteLine("--- Search multiple indices `SearchAsync` ---");
var searchQueries = new List<SearchQuery>
{
  new(new SearchForHits("test-csharp-new-client")),
  new(new SearchForHits("test-csharp-new-client")),
  new(new SearchForFacets("otherValue", "test-csharp-new-client", SearchTypeFacet.Facet)),
};
var search = await searchClient.SearchAsync<TestObject>(new SearchMethodParams(searchQueries));
search.Results.ForEach(result =>
{
  if (result.IsSearchResponse())
  {
    Console.WriteLine("Hits: " + result.AsSearchResponse().Hits.First().ObjectID);
  }
  else if (result.IsSearchForFacetValuesResponse())
  {
    Console.WriteLine("Facet: " + result.AsSearchForFacetValuesResponse().FacetHits.First().Value);
  }
  else
  {
    Console.WriteLine("Nothing");
  }
});
