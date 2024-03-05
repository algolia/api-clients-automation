using Algolia.Search.Clients;
using Algolia.Search.Exceptions;
using Algolia.Search.Models.Common;
using Algolia.Search.Models.Search;
using Algolia.Search.Utils;
using Algolia.Utils;
using Microsoft.Extensions.Logging;
using Action = Algolia.Search.Models.Search.Action;

namespace Algolia.Playgrounds;

public class SearchPlayground : IPlayground
{
  const string DefaultIndex = "test-csharp-new-client";
  private readonly SearchClient _client;
  private readonly Configuration _configuration;

  public SearchPlayground(Configuration configuration)
  {
    var searchConfig = new SearchConfig(configuration.AppId, configuration.AdminApiKey);
    var loggerFactory = LoggerFactory.Create(i => i.AddFilter("Algolia", LogLevel.Information)
      .AddConsole());

    _client = new SearchClient(searchConfig, loggerFactory);
    _configuration = configuration;
  }

  public async Task Run()
  {
    PlaygroundHelper.Hello("Starting Search API playground");
    try
    {
      await Search();
      await Index();
      await ApiKey();
      await Synonym();
      await Rule();
    }
    catch (Exception e)
    {
      Console.WriteLine(e);
    }
  }

  private async Task Search()
  {
    // Save a single object
    Console.WriteLine("--- Save a single object `SaveObjectAsync` ---");
    var saved = await _client.SaveObjectAsync(DefaultIndex,
      new { ObjectID = "test2", value = "test", otherValue = "otherValue" });

    await PlaygroundHelper.Start($"Saving record ObjectID=`{saved.ObjectID}` - Async TaskID: `{saved.TaskID}`",
      () => _client.WaitForTaskAsync(DefaultIndex, saved.TaskID), $"Record ObjectID=`{saved.ObjectID}` saved !");

    // Save multiple objects
    Console.WriteLine("--- Save a multiple objects `BatchAsync` ---");
    var requests = new List<BatchRequest>
    {
      new(Action.AddObject, new { ObjectID = "test3", value = "batch1", otherValue = "otherValue1" }),
      new(Action.AddObject, new { ObjectID = "test4", value = "batch2", otherValue = "otherValue2" }),
      new(Action.AddObject, new { ObjectID = "test5", value = "batch3", otherValue = "otherValue3" }),
    };
    var batch = await _client.BatchAsync(DefaultIndex, new BatchWriteParams(requests));

    await PlaygroundHelper.Start(
      $"Saving new records - Async TaskID: `{batch.TaskID}`",
      () => _client.WaitForTaskAsync(DefaultIndex, batch.TaskID), "Records saved !");

    // Browse all objects
    Console.WriteLine("--- Browse all objects, one page `BrowseAsync` ---");
    var r = await _client.BrowseAsync<TestObject>(DefaultIndex,
      new BrowseParams(new BrowseParamsObject { HitsPerPage = 100 }));
    r.Hits.ForEach(h =>
      Console.WriteLine($"  - Record ObjectID: {h.ObjectID}, {h.Value} {h.OtherValue} {h.AdditionalProperties.Count}"));

    // Browse Helper, to fetch all pages
    Console.WriteLine("--- Browse all objects, all pages `BrowseObjectsAsync` ---");
    var results = await _client.BrowseObjectsAsync<TestObject>(DefaultIndex, new BrowseParamsObject
    {
      HitsPerPage = 1
    });

    results.ToList().ForEach(h => Console.WriteLine($"  - Record ObjectID: {h.ObjectID}"));

    // Get Objects
    Console.WriteLine("--- Get Objects, with specific attributes `GetObjectsAsync` ---");
    var getObjRequests = new List<GetObjectsRequest>
    {
      new("test2", DefaultIndex)
      {
        AttributesToRetrieve = ["otherValue"]
      },
      new("test3", DefaultIndex)
      {
        AttributesToRetrieve = ["otherValue"]
      },
    };

    var getObjResults = await _client.GetObjectsAsync<TestObject>(new GetObjectsParams(getObjRequests));
    getObjResults.Results.ForEach(t =>
      Console.WriteLine($"  - Record ObjectID: {t.ObjectID} - Property `otherValue`: {t.OtherValue}"));

    // Search single index
    Console.WriteLine("--- Search single index `SearchSingleIndexAsync` ---");
    var t = await _client.SearchSingleIndexAsync<TestObject>(DefaultIndex);
    t.Hits.ForEach(h => Console.WriteLine($"  - Record ObjectID: {h.ObjectID}"));

    Console.WriteLine("--- Search multiple indices `SearchAsync` ---");
    var searchQueries = new List<SearchQuery>
    {
      new(new SearchForHits(DefaultIndex)),
      new(new SearchForHits(DefaultIndex)),
      new(new SearchForFacets("otherValue", DefaultIndex, SearchTypeFacet.Facet)),
    };
    var search = await _client.SearchAsync<TestObject>(new SearchMethodParams(searchQueries));
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

    Console.WriteLine("--- Error Handling ---");
    try
    {
      await _client.SaveRulesAsync(DefaultIndex,
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

    Console.WriteLine("--- Replace all objects `` ---");
    var replaceAllResponse = await _client.ReplaceAllObjectsAsync(DefaultIndex,
      new List<TestObject> { new TestObject { Value = "hello2", OtherValue = "world" } });
    Console.WriteLine($"Replace all objects - Async TaskID: `{string.Join(",", replaceAllResponse)}`");

    Console.WriteLine("Search API playground has ended");
  }

  private async Task Index()
  {
    // Set settings on index
    Console.WriteLine("--- Set setting on index `SetSettingsAsync` ---");
    var updatedAtResponse = await _client.SetSettingsAsync(DefaultIndex, new IndexSettings()
    {
      AttributesForFaceting = ["searchable(value)", "searchable(otherValue)"],
      SearchableAttributes = ["value", "otherValue"]
    });

    await PlaygroundHelper.Start(
      $"Saving new settings on index `{DefaultIndex}` - Async TaskID: `{updatedAtResponse.TaskID}`",
      () => _client.WaitForTaskAsync(DefaultIndex, updatedAtResponse.TaskID), "New settings applied !");
  }

  private async Task ApiKey()
  {
    // API Key
    Console.WriteLine("--- Add new api key `AddApiKeyAsync` ---");
    var addApiKeyResponse = await _client.AddApiKeyAsync(new ApiKey()
    {
      Acl = [Acl.Browse, Acl.Search],
      Description = "A test key",
      Indexes = [DefaultIndex]
    });
    var createdApiKey = await PlaygroundHelper.Start($"Saving new API Key", async () =>
      await _client.WaitForApiKeyAsync(ApiKeyOperation.Add, addApiKeyResponse.Key), "New key has been created !");

    Console.WriteLine("--- Update api key `UpdateApiKeyAsync` ---");
    var modifiedApiKey = createdApiKey.ToApiKey();
    modifiedApiKey.Description = "Updated description";

    var updateApiKey = await _client.UpdateApiKeyAsync(addApiKeyResponse.Key, modifiedApiKey);
    await PlaygroundHelper.Start("Updating API Key`", async () =>
      await _client.WaitForApiKeyAsync(ApiKeyOperation.Update, updateApiKey.Key, modifiedApiKey), "Key updated !");

    Console.WriteLine("--- Delete api key `UpdateApiKeyAsync` ---");
    await _client.DeleteApiKeyAsync(addApiKeyResponse.Key);
    await PlaygroundHelper.Start("Deleting API Key", async () =>
      await _client.WaitForApiKeyAsync(ApiKeyOperation.Delete, updateApiKey.Key), "Key deleted !");

    Console.WriteLine("--- Generate Secured API Keys `GenerateSecuredApiKeys` ---");
    var generateSecuredApiKeys = _client.GenerateSecuredApiKey(_configuration.SearchApiKey,
      new SecuredApiKeyRestrictions
      {
        RestrictIndices = [DefaultIndex],
      });

    Console.WriteLine("Calling SearchSingleIndexAsync with generated secured API keys");

    var searchClient = new SearchClient(_configuration.AppId, generateSecuredApiKeys);
    await searchClient.SearchSingleIndexAsync<object>(DefaultIndex);

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
  }

  private async Task Synonym()
  {
    // Add Synonyms
    Console.WriteLine("--- Add Synonyms `SaveSynonymsAsync` ---");
    var synonymsResponse = await _client.SaveSynonymsAsync(DefaultIndex,
    [
      new SynonymHit
      {
        Type = SynonymType.Onewaysynonym,
        ObjectID = "tshirt",
        Synonyms = ["tshirt", "shirt", "slipover"],
        Input = "tshirt"
      },
      new SynonymHit
      {
        Type = SynonymType.Onewaysynonym,
        ObjectID = "trousers",
        Synonyms = ["trousers", "jeans", "pantaloons"],
        Input = "trousers"
      },
      new SynonymHit
      {
        Type = SynonymType.Onewaysynonym,
        ObjectID = "shoes",
        Synonyms = ["shoes", "boots", "sandals"],
        Input = "shoes"
      }
    ]).ConfigureAwait(false);

    await PlaygroundHelper.Start($"Creating new Synonyms - Async TaskID: `{synonymsResponse.TaskID}`", async () =>
      await _client.WaitForTaskAsync(DefaultIndex, synonymsResponse.TaskID), "New Synonyms has been created !");

    // Search Synonyms
    Console.WriteLine("--- Search Synonyms `SearchSynonymsAsync` ---");
    var searchSynonymsAsync = await _client
      .SearchSynonymsAsync(DefaultIndex,
        new SearchSynonymsParams { Query = "", Type = SynonymType.Onewaysynonym, HitsPerPage = 1 })
      .ConfigureAwait(false);

    searchSynonymsAsync.Hits.ForEach(s => Console.WriteLine("Found :" + string.Join(',', s.Synonyms)));

    // Browse Synonyms
    Console.WriteLine("--- Browse Synonyms `BrowseSynonymsAsync` ---");
    var configuredTaskAwaitable = await _client
      .BrowseSynonymsAsync("test-csharp-new-client",
        new SearchSynonymsParams { Query = "", Type = SynonymType.Onewaysynonym })
      .ConfigureAwait(false);
    configuredTaskAwaitable.ToList().ForEach(s => Console.WriteLine("Found :" + string.Join(',', s.Synonyms)));
  }

  private async Task Rule()
  {
    Console.WriteLine("--- Create new Rule `SaveRulesAsync` ---");
    var saveRulesAsync = await _client.SaveRulesAsync(DefaultIndex,
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
      async () => await _client.WaitForTaskAsync(DefaultIndex, saveRulesAsync.TaskID), "New Rule has been created !");
  }
}

public interface IPlayground
{
  Task Run();
}
