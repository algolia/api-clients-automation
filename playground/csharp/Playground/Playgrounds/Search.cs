using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Search;
using Algolia.Search.Utils;
using Algolia.Utils;
using Microsoft.Extensions.Logging;
using Action = Algolia.Search.Models.Search.Action;

namespace Algolia.Playgrounds;

public static class SearchPlayground
{
  public static async Task Run(Configuration configuration)
  {
    const string defaultIndex = "test-csharp-new-client";

    Console.WriteLine("------------------------------------");
    Console.WriteLine("Starting Search API playground");
    Console.WriteLine("------------------------------------");

    var searchConfig = new SearchConfig(configuration.AppId, configuration.AdminApiKey)
    {
      Compression = CompressionType.None
    };

    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());

    var client = new SearchClient(searchConfig, loggerFactory);

    var metisClient = new SearchClient(new SearchConfig(configuration.MetisAppId, configuration.MetisApiKey)
    {
      Compression = CompressionType.None
    });

    // Save a single object
    Console.WriteLine("--- Save a single object `SaveObjectAsync` ---");
    var saved = await client.SaveObjectAsync(defaultIndex,
      new { ObjectID = "test2", value = "test", otherValue = "otherValue" });

    await PlaygroundHelper.Start($"Saving record ObjectID=`{saved.ObjectID}` - Async TaskID: `{saved.TaskID}`",
      () => client.WaitForTaskAsync(defaultIndex, saved.TaskID), $"Record ObjectID=`{saved.ObjectID}` saved !");

    // Set settings on index
    Console.WriteLine("--- Set setting on index `SetSettingsAsync` ---");
    var updatedAtResponse = await client.SetSettingsAsync(defaultIndex, new IndexSettings()
    {
      AttributesForFaceting = ["searchable(value)", "searchable(otherValue)"],
      SearchableAttributes = ["value", "otherValue"]
    });

    await PlaygroundHelper.Start(
      $"Saving new settings on index `{defaultIndex}` - Async TaskID: `{updatedAtResponse.TaskID}`",
      () => client.WaitForTaskAsync(defaultIndex, updatedAtResponse.TaskID), "New settings applied !");

    // Save multiple objects
    Console.WriteLine("--- Save a multiple objects `BatchAsync` ---");
    var requests = new List<BatchRequest>
    {
      new(Action.AddObject, new { ObjectID = "test3", value = "batch1", otherValue = "otherValue1" }),
      new(Action.AddObject, new { ObjectID = "test4", value = "batch2", otherValue = "otherValue2" }),
      new(Action.AddObject, new { ObjectID = "test5", value = "batch3", otherValue = "otherValue3" }),
    };
    var batch = await client.BatchAsync(defaultIndex, new BatchWriteParams(requests));

    await PlaygroundHelper.Start(
      $"Saving new records - Async TaskID: `{batch.TaskID}`",
      () => client.WaitForTaskAsync(defaultIndex, batch.TaskID), "Records saved !");

    // Browse all objects
    Console.WriteLine("--- Browse all objects, one page `BrowseAsync` ---");
    var r = await client.BrowseAsync<TestObject>(defaultIndex,
      new BrowseParams(new BrowseParamsObject { HitsPerPage = 100 }));
    r.Hits.ForEach(h =>
      Console.WriteLine($"  - Record ObjectID: {h.ObjectID}, {h.Value} {h.OtherValue} {h.AdditionalProperties.Count}"));


    // Browse Helper, to fetch all pages
    Console.WriteLine("--- Browse all objects, all pages `BrowseObjectsAsync` ---");
    var results = await client.BrowseObjectsAsync<TestObject>(defaultIndex, new BrowseParamsObject
    {
      HitsPerPage = 1
    });

    results.ToList().ForEach(h => Console.WriteLine($"  - Record ObjectID: {h.ObjectID}"));

    // Get Objects
    Console.WriteLine("--- Get Objects, with specific attributes `GetObjectsAsync` ---");
    var getObjRequests = new List<GetObjectsRequest>
    {
      new("test2", defaultIndex)
      {
        AttributesToRetrieve = ["otherValue"]
      },
      new("test3", defaultIndex)
      {
        AttributesToRetrieve = ["otherValue"]
      },
    };

    var getObjResults = await client.GetObjectsAsync<TestObject>(new GetObjectsParams(getObjRequests));
    getObjResults.Results.ForEach(t =>
      Console.WriteLine($"  - Record ObjectID: {t.ObjectID} - Property `otherValue`: {t.OtherValue}"));

    // Search single index
    Console.WriteLine("--- Search single index `SearchSingleIndexAsync` ---");
    var t = await client.SearchSingleIndexAsync<TestObject>(defaultIndex);
    t.Hits.ForEach(h => Console.WriteLine($"  - Record ObjectID: {h.ObjectID}"));

    Console.WriteLine("--- Search multiple indices `SearchAsync` ---");
    var searchQueries = new List<SearchQuery>
    {
      new(new SearchForHits(defaultIndex)),
      new(new SearchForHits(defaultIndex)),
      new(new SearchForFacets("otherValue", defaultIndex, SearchTypeFacet.Facet)),
    };
    var search = await client.SearchAsync<TestObject>(new SearchMethodParams(searchQueries));
    search.Results.ForEach(result =>
    {
      if (result.IsSearchResponse())
      {
        Console.WriteLine(
          $"Record with Hits: ObjectID = {result.AsSearchResponse().Hits.First().ObjectID}, {result.AsSearchResponse().Hits.First().AdditionalProperties.Count}");
      }
      else if (result.IsSearchForFacetValuesResponse())
      {
        Console.WriteLine("Record with Facet. Facet value = " +
                          result.AsSearchForFacetValuesResponse().FacetHits.First().Value);
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
      Console.WriteLine(
        $" - Additional property found {tMetisAdditionalProperty.Key} : {tMetisAdditionalProperty.Value}");
    }

    // API Key
    Console.WriteLine("--- Add new api key `AddApiKeyAsync` ---");
    var addApiKeyResponse = await client.AddApiKeyAsync(new ApiKey()
    {
      Acl = [Acl.Browse, Acl.Search], Description = "A test key",
      Indexes = [defaultIndex]
    });
    var createdApiKey = await PlaygroundHelper.Start($"Saving new API Key", async () =>
      await client.WaitForApiKeyAsync(ApiKeyOperation.Add, addApiKeyResponse.Key), "New key has been created !");

    Console.WriteLine("--- Update api key `UpdateApiKeyAsync` ---");
    var modifiedApiKey = createdApiKey.ToApiKey();
    modifiedApiKey.Description = "Updated description";

    var updateApiKey = await client.UpdateApiKeyAsync(addApiKeyResponse.Key, modifiedApiKey);
    await PlaygroundHelper.Start("Updating API Key`", async () =>
      await client.WaitForApiKeyAsync(ApiKeyOperation.Update, updateApiKey.Key, modifiedApiKey), "Key updated !");

    Console.WriteLine("--- Delete api key `UpdateApiKeyAsync` ---");
    await client.DeleteApiKeyAsync(addApiKeyResponse.Key);
    await PlaygroundHelper.Start("Deleting API Key", async () =>
      await client.WaitForApiKeyAsync(ApiKeyOperation.Delete, updateApiKey.Key), "Key deleted !");

    // Add Synonyms
    Console.WriteLine("--- Add Synonyms `SaveSynonymsAsync` ---");
    var synonymsResponse = await client.SaveSynonymsAsync(defaultIndex,
    [
      new SynonymHit
      {
        Type = SynonymType.Onewaysynonym, ObjectID = "tshirt",
        Synonyms = ["tshirt", "shirt", "slipover"],
        Input = "tshirt"
      },
      new SynonymHit
      {
        Type = SynonymType.Onewaysynonym, ObjectID = "trousers",
        Synonyms = ["trousers", "jeans", "pantaloons"],
        Input = "trousers"
      },
      new SynonymHit
      {
        Type = SynonymType.Onewaysynonym, ObjectID = "shoes",
        Synonyms = ["shoes", "boots", "sandals"],
        Input = "shoes"
      }
    ]).ConfigureAwait(false);

    await PlaygroundHelper.Start($"Creating new Synonyms - Async TaskID: `{synonymsResponse.TaskID}`", async () =>
      await client.WaitForTaskAsync(defaultIndex, synonymsResponse.TaskID), "New Synonyms has been created !");

    // Search Synonyms
    Console.WriteLine("--- Search Synonyms `SearchSynonymsAsync` ---");
    var searchSynonymsAsync = await client
      .SearchSynonymsAsync(defaultIndex,
        new SearchSynonymsParams { Query = "", Type = SynonymType.Onewaysynonym, HitsPerPage = 1 })
      .ConfigureAwait(false);

    searchSynonymsAsync.Hits.ForEach(s => Console.WriteLine("Found :" + string.Join(',', s.Synonyms)));

    // Browse Synonyms
    Console.WriteLine("--- Browse Synonyms `BrowseSynonymsAsync` ---");
    var configuredTaskAwaitable = await client
      .BrowseSynonymsAsync("test-csharp-new-client",
        new SearchSynonymsParams { Query = "", Type = SynonymType.Onewaysynonym })
      .ConfigureAwait(false);
    configuredTaskAwaitable.ToList().ForEach(s => Console.WriteLine("Found :" + string.Join(',', s.Synonyms)));

    // Add Rule
    Console.WriteLine("--- Create new Rule `SaveRulesAsync` ---");
    var saveRulesAsync = await client.SaveRulesAsync(defaultIndex,
    [
      new Rule
      {
        ObjectID = "TestRule1",
        Description = "Test",
        Consequence = new Consequence { Promote = [new Promote(new PromoteObjectID("test3", 1))] },
        Conditions = [new Condition { Anchoring = Anchoring.Contains, Context = "shoes", Pattern = "test" }]
      },
      new Rule
      {
        ObjectID = "TestRule2",
        Description = "Test",
        Consequence = new Consequence { Promote = [new Promote(new PromoteObjectID("test4", 1))] },
        Conditions = [new Condition { Anchoring = Anchoring.Contains, Context = "shoes", Pattern = "test" }]
      },
      new Rule
      {
        ObjectID = "TestRule3",
        Description = "Test",
        Consequence = new Consequence { Promote = [new Promote(new PromoteObjectID("test5", 1))] },
        Conditions = [new Condition { Anchoring = Anchoring.Contains, Context = "shoes", Pattern = "test" }]
      }
    ]).ConfigureAwait(false);

    await PlaygroundHelper.Start($"Saving new Rule - Async TaskID: `{saveRulesAsync.TaskID}`",
      async () => await client.WaitForTaskAsync(defaultIndex, saveRulesAsync.TaskID), "New Rule has been created !");

    Console.WriteLine("--- Error Handling ---");
    try
    {
      await client.SaveRulesAsync(defaultIndex,
      [
        new Rule
        {
          ObjectID = "TestRule1",
          Description = "Test",
          Consequence = new Consequence { Promote = [new Promote(new PromoteObjectID("test3", 1))] },
          Conditions = [new Condition { Anchoring = Anchoring.Contains, Context = "shoes" }]
        }
      ]).ConfigureAwait(false);
    }
    catch (AlgoliaApiException e)
    {
      Console.WriteLine($"Message: {e.Message} - Status {e.HttpErrorCode}");
    }

    Console.WriteLine("--- Generate Secured API Keys `GenerateSecuredApiKeys` ---");
    var generateSecuredApiKeys = client.GenerateSecuredApiKeys(configuration.SearchApiKey,
      new SecuredApiKeyRestriction
      {
        RestrictIndices = [defaultIndex],
      });

    Console.WriteLine("Calling SearchSingleIndexAsync with generated secured API keys");

    var searchClient = new SearchClient(configuration.AppId, generateSecuredApiKeys);
    await searchClient.SearchSingleIndexAsync<object>(defaultIndex);

    Console.WriteLine("Success, this index is authorized");

    Console.WriteLine("Calling SearchSingleIndexAsync with not authorized index");

    try
    {
      await searchClient.SearchSingleIndexAsync<object>("not_authorized_index");
    }
    catch (AlgoliaApiException e)
    {
      Console.WriteLine($"Error received (It's expected !) - {e.HttpErrorCode} {e.Message}");
    }

    Console.WriteLine("--- Replace all objects `` ---");
    var replaceAllResponse = await client.ReplaceAllObjectsAsync(defaultIndex,
      new List<TestObject>() { new TestObject() { Value = "hello2", OtherValue = "world" } });
    Console.WriteLine($"Replace all objects - Async TaskID: `{string.Join(",", replaceAllResponse)}`");

    Console.WriteLine("Search API playground has ended");
  }
}
