using Algolia.Search.Clients;
using Algolia.Search.Models;
using Algolia.Search.Models.Search;
using Action = Algolia.Search.Models.Search.Action;

public static class SearchPlayground
{
  public static async Task Run(Settings settings)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Search API playground");
    Console.WriteLine("------------------------------------");

    var client = new SearchClient(new SearchConfig(settings.AppId, settings.AdminApiKey)
    {
      Compression = CompressionType.NONE
    });

    var metisClient = new SearchClient(new SearchConfig(settings.MetisAppId, settings.MetisApiKey)
    {
      Compression = CompressionType.NONE
    });

    // Save a single object
    Console.WriteLine("--- Save a single object `SaveObjectAsync` ---");
    var saved = await client.SaveObjectAsync("test-csharp-new-client",
      new { ObjectID = "test2", value = "test", otherValue = "otherValue" });
    Console.WriteLine(saved.ObjectID);

    // Set settings on index
    Console.WriteLine("--- Set setting on index `SetSettingsAsync` ---");
    var updatedAtResponse = await client.SetSettingsAsync("test-csharp-new-client", new IndexSettings()
    {
      AttributesForFaceting = new List<string> { "searchable(value)", "searchable(otherValue)" },
      SearchableAttributes = new List<string> { "value", "otherValue" }
    });
    Console.WriteLine(updatedAtResponse.TaskID);

    // Save multiple objects
    Console.WriteLine("--- Save a multiple objects `BatchAsync` ---");
    var requests = new List<BatchRequest>()
    {
      new(Action.AddObject, new { ObjectID = "test3", value = "batch1", otherValue = "otherValue1" }),
      new(Action.AddObject, new { ObjectID = "test4", value = "batch2", otherValue = "otherValue2" }),
      new(Action.AddObject, new { ObjectID = "test5", value = "batch3", otherValue = "otherValue3" }),
    };
    var batch = await client.BatchAsync("test-csharp-new-client", new BatchWriteParams(requests));
    batch.ObjectIDs.ForEach(Console.WriteLine);

    // Browse all objects
    Console.WriteLine("--- Browse all objects `BrowseAsync` ---");
    var r = await client.BrowseAsync<TestObject>("test-csharp-new-client");
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

    var getObjResults = await client.GetObjectsAsync<TestObject>(new GetObjectsParams(getObjRequests));
    getObjResults.Results.ForEach(testObject => Console.WriteLine(testObject.otherValue));

    // Search single index
    Console.WriteLine("--- Search single index `SearchSingleIndexAsync` ---");
    var t = await client.SearchSingleIndexAsync<TestObject>("test-csharp-new-client");
    t.Hits.ForEach(h => Console.WriteLine(h.ObjectID));

    // Search
    Console.WriteLine("--- Search multiple indices `SearchAsync` ---");
    var searchQueries = new List<SearchQuery>
    {
      new(new SearchForHits("test-csharp-new-client")),
      new(new SearchForHits("test-csharp-new-client")),
      new(new SearchForFacets("otherValue", "test-csharp-new-client", SearchTypeFacet.Facet)),
    };
    var search = await client.SearchAsync<TestObject>(new SearchMethodParams(searchQueries));
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

    // Search with Metis Additional properties
    Console.WriteLine("--- Search single index `SearchSingleIndexAsync`, with additional properties ---");
    var tMetis = await metisClient.SearchSingleIndexAsync<object>("008_jobs_v2_nosplit__contents__default");
    foreach (var tMetisAdditionalProperty in tMetis.AdditionalProperties)
    {
      Console.WriteLine(tMetisAdditionalProperty.Key + " : " + tMetisAdditionalProperty.Value);
    }
  }
}
