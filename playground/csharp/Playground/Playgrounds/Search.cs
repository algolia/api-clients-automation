using System.Diagnostics;
using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Models;
using Algolia.Search.Models.Search;
using Algolia.Search.Utils;
using Algolia.Utils;
using Action = Algolia.Search.Models.Search.Action;

public static class SearchPlayground
{
  public static async Task Run(Configuration configuration)
  {
    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Search API playground");
    Console.WriteLine("------------------------------------");

    var client = new SearchClient(new SearchConfig(configuration.AppId, configuration.AdminApiKey)
    {
      Compression = CompressionType.NONE
    });

    var metisClient = new SearchClient(new SearchConfig(configuration.MetisAppId, configuration.MetisApiKey)
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
    var requests = new List<BatchRequest>
    {
      new(Action.AddObject, new { ObjectID = "test3", value = "batch1", otherValue = "otherValue1" }),
      new(Action.AddObject, new { ObjectID = "test4", value = "batch2", otherValue = "otherValue2" }),
      new(Action.AddObject, new { ObjectID = "test5", value = "batch3", otherValue = "otherValue3" }),
    };
    var batch = await client.BatchAsync("test-csharp-new-client", new BatchWriteParams(requests));
    batch.ObjectIDs.ForEach(Console.WriteLine);

    // Browse all objects
    Console.WriteLine("--- Browse all objects, one page `BrowseAsync` ---");
    var r = await client.BrowseAsync<TestObject>("test-csharp-new-client",
      new BrowseParams(new BrowseParamsObject { HitsPerPage = 100 }));
    r.Hits.ForEach(h => Console.WriteLine(h.ObjectID));

    // Browse Helper, to fetch all pages
    Console.WriteLine("--- Browse all objects, all pages `BrowseObjectsAsync` ---");
    var results = await client.BrowseObjectsAsync<TestObject>("test-csharp-new-client", new BrowseParamsObject
    {
      HitsPerPage = 1
    });

    results.ToList().ForEach(h => Console.WriteLine(h.ObjectID));

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

    // Add Synomyms
    Console.WriteLine("--- Add Synonyms `SaveSynonymsAsync` ---");
    var synonymsResponse = await client.SaveSynonymsAsync("test-csharp-new-client",
      new List<SynonymHit>
      {
        new()
        {
          Type = SynonymType.Onewaysynonym, ObjectID = "tshirt",
          Synonyms = new List<string> { "tshirt", "shirt", "slipover" }, Input = "tshirt"
        },
        new()
        {
          Type = SynonymType.Onewaysynonym, ObjectID = "trousers",
          Synonyms = new List<string> { "trousers", "jeans", "pantaloons" }, Input = "trousers"
        },
        new()
        {
          Type = SynonymType.Onewaysynonym, ObjectID = "shoes",
          Synonyms = new List<string> { "shoes", "boots", "sandals" }, Input = "shoes"
        },
      }).ConfigureAwait(false);

    var stopwatch = new Stopwatch();
    stopwatch.Start();
    var waitResult = await client.WaitForTaskAsync("test-csharp-new-client", synonymsResponse.TaskID)
      .ConfigureAwait(false);
    stopwatch.Stop();
    Console.WriteLine($"Task is now {waitResult.Status}");
    Console.WriteLine($"Task took {stopwatch.ElapsedMilliseconds}ms");

    // // Search Synomyms
    // Console.WriteLine("--- Search Synonyms `SearchSynonymsAsync` ---");
    // var searchSynonymsAsync = await client.SearchSynonymsAsync("test-csharp-new-client", SynonymType.Onewaysynonym, 0,
    //   1, new SearchSynonymsParams() { Query = "" }).ConfigureAwait(false);
    // Console.WriteLine(searchSynonymsAsync.Hits.Count);

    // MAX TIMEOUT ??

    // Browse Synonyms
    // var configuredTaskAwaitable = await client
    //   .BrowseSynonymsAsync("test-csharp-new-client", SynonymType.Onewaysynonym, new SearchSynonymsParams { Query = "" })
    //   .ConfigureAwait(false);
    // configuredTaskAwaitable.ToList().ForEach(s => Console.WriteLine("Found :" + string.Join(',', s.Synonyms)));

    // Add Rule
    Console.WriteLine("--- Create new Rule `SaveRulesAsync` ---");
    var saveRulesAsync = await client.SaveRulesAsync("test-csharp-new-client",
      new List<Rule>
      {
        new()
        {
          ObjectID = "TestRule1", Description = "Test",
          Consequence =
            new Consequence { Promote = new List<Promote> { new(new PromoteObjectID("test3", 1)) } },
          Conditions = new List<Condition>
            { new() { Anchoring = Anchoring.Contains, Context = "shoes", Pattern = "test" } }
        },
        new()
        {
          ObjectID = "TestRule2", Description = "Test",
          Consequence =
            new Consequence { Promote = new List<Promote> { new(new PromoteObjectID("test4", 1)) } },
          Conditions = new List<Condition>
            { new() { Anchoring = Anchoring.Contains, Context = "shoes", Pattern = "test" } }
        },
        new()
        {
          ObjectID = "TestRule3", Description = "Test",
          Consequence =
            new Consequence { Promote = new List<Promote> { new(new PromoteObjectID("test5", 1)) } },
          Conditions = new List<Condition>
            { new() { Anchoring = Anchoring.Contains, Context = "shoes", Pattern = "test" } }
        }
      }).ConfigureAwait(false);

    await TaskHelper.Start(async () => await client.WaitForTaskAsync("test-csharp-new-client", saveRulesAsync.TaskID));

    Console.WriteLine("--- Error Handling ---");
    try
    {
      await client.SaveRulesAsync("test-csharp-new-client",
        new List<Rule>
        {
          new()
          {
            ObjectID = "TestRule1", Description = "Test",
            Consequence =
              new Consequence { Promote = new List<Promote> { new(new PromoteObjectID("test3", 1)) } },
            Conditions = new List<Condition>
              // Error, no Context set
              { new() { Anchoring = Anchoring.Contains, Context = "shoes"  } }
          }
        }).ConfigureAwait(false);
    } catch (AlgoliaApiException e)
    {
      Console.WriteLine($"Message: {e.Message} - Status {e.HttpErrorCode}");
    }
  }
}
