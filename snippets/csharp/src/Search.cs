using Algolia.Search.Clients;
using Algolia.Search.Http;
using Algolia.Search.Models.Search;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetSearchClient
{
  /// <summary>
  /// Snippet for the AddApiKey method.
  ///
  /// addApiKey0
  /// </summary>
  public async Task SnippetForAddApiKey0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.AddApiKeyAsync(
      new ApiKey
      {
        Acl = new List<Acl> { Enum.Parse<Acl>("Search"), Enum.Parse<Acl>("AddObject") },
        Description = "my new api key",
        Validity = 300,
        MaxQueriesPerIPPerHour = 100,
        MaxHitsPerQuery = 20,
      }
    );
  }

  /// <summary>
  /// Snippet for the AddOrUpdateObject method.
  ///
  /// addOrUpdateObject0
  /// </summary>
  public async Task SnippetForAddOrUpdateObject0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.AddOrUpdateObjectAsync(
      "indexName",
      "uniqueID",
      new Dictionary<string, string> { { "key", "value" } }
    );
  }

  /// <summary>
  /// Snippet for the AppendSource method.
  ///
  /// appendSource0
  /// </summary>
  public async Task SnippetForAppendSource0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.AppendSourceAsync(
      new Source { VarSource = "theSource", Description = "theDescription", }
    );
  }

  /// <summary>
  /// Snippet for the AssignUserId method.
  ///
  /// assignUserId0
  /// </summary>
  public async Task SnippetForAssignUserId0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.AssignUserIdAsync(
      "userID",
      new AssignUserIdParams { Cluster = "theCluster", }
    );
  }

  /// <summary>
  /// Snippet for the Batch method.
  ///
  /// allows batch method with `addObject` action
  /// </summary>
  public async Task SnippetForBatch0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.BatchAsync(
      "theIndexName",
      new BatchWriteParams
      {
        Requests = new List<BatchRequest>
        {
          new BatchRequest
          {
            Action = Enum.Parse<Action>("AddObject"),
            Body = new Dictionary<string, string> { { "key", "value" } },
          }
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the BatchAssignUserIds method.
  ///
  /// batchAssignUserIds0
  /// </summary>
  public async Task SnippetForBatchAssignUserIds0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.BatchAssignUserIdsAsync(
      "userID",
      new BatchAssignUserIdsParams
      {
        Cluster = "theCluster",
        Users = new List<string> { "user1", "user2" },
      }
    );
  }

  /// <summary>
  /// Snippet for the BatchDictionaryEntries method.
  ///
  /// get batchDictionaryEntries results with minimal parameters
  /// </summary>
  public async Task SnippetForBatchDictionaryEntries0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.BatchDictionaryEntriesAsync(
      Enum.Parse<DictionaryType>("Compounds"),
      new BatchDictionaryEntriesParams
      {
        Requests = new List<BatchDictionaryEntriesRequest>
        {
          new BatchDictionaryEntriesRequest
          {
            Action = Enum.Parse<DictionaryAction>("AddEntry"),
            Body = new DictionaryEntry { ObjectID = "1", Language = "en", },
          },
          new BatchDictionaryEntriesRequest
          {
            Action = Enum.Parse<DictionaryAction>("DeleteEntry"),
            Body = new DictionaryEntry { ObjectID = "2", Language = "fr", },
          }
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the Browse method.
  ///
  /// browse with minimal parameters
  /// </summary>
  public async Task SnippetForBrowse0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.BrowseAsync<Object>("cts_e2e_browse");
  }

  /// <summary>
  /// Snippet for the ClearObjects method.
  ///
  /// clearObjects0
  /// </summary>
  public async Task SnippetForClearObjects0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ClearObjectsAsync("theIndexName");
  }

  /// <summary>
  /// Snippet for the ClearRules method.
  ///
  /// clearRules0
  /// </summary>
  public async Task SnippetForClearRules0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ClearRulesAsync("indexName");
  }

  /// <summary>
  /// Snippet for the ClearSynonyms method.
  ///
  /// clearSynonyms0
  /// </summary>
  public async Task SnippetForClearSynonyms0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ClearSynonymsAsync("indexName");
  }

  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomDelete0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomGet0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPost0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPut0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
  }

  /// <summary>
  /// Snippet for the DeleteApiKey method.
  ///
  /// deleteApiKey0
  /// </summary>
  public async Task SnippetForDeleteApiKey0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteApiKeyAsync("myTestApiKey");
  }

  /// <summary>
  /// Snippet for the DeleteBy method.
  ///
  /// deleteBy0
  /// </summary>
  public async Task SnippetForDeleteBy0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteByAsync(
      "theIndexName",
      new DeleteByParams { Filters = "brand:brandName", }
    );
  }

  /// <summary>
  /// Snippet for the DeleteIndex method.
  ///
  /// deleteIndex0
  /// </summary>
  public async Task SnippetForDeleteIndex0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteIndexAsync("theIndexName");
  }

  /// <summary>
  /// Snippet for the DeleteObject method.
  ///
  /// deleteObject0
  /// </summary>
  public async Task SnippetForDeleteObject0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteObjectAsync("theIndexName", "uniqueID");
  }

  /// <summary>
  /// Snippet for the DeleteRule method.
  ///
  /// delete rule simple case
  /// </summary>
  public async Task SnippetForDeleteRule0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteRuleAsync("indexName", "id1");
  }

  /// <summary>
  /// Snippet for the DeleteSource method.
  ///
  /// deleteSource0
  /// </summary>
  public async Task SnippetForDeleteSource0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteSourceAsync("theSource");
  }

  /// <summary>
  /// Snippet for the DeleteSynonym method.
  ///
  /// deleteSynonym0
  /// </summary>
  public async Task SnippetForDeleteSynonym0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteSynonymAsync("indexName", "id1");
  }

  /// <summary>
  /// Snippet for the GetApiKey method.
  ///
  /// getApiKey0
  /// </summary>
  public async Task SnippetForGetApiKey0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetApiKeyAsync("myTestApiKey");
  }

  /// <summary>
  /// Snippet for the GetDictionaryLanguages method.
  ///
  /// get getDictionaryLanguages
  /// </summary>
  public async Task SnippetForGetDictionaryLanguages0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetDictionaryLanguagesAsync();
  }

  /// <summary>
  /// Snippet for the GetDictionarySettings method.
  ///
  /// get getDictionarySettings results
  /// </summary>
  public async Task SnippetForGetDictionarySettings0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetDictionarySettingsAsync();
  }

  /// <summary>
  /// Snippet for the GetLogs method.
  ///
  /// getLogs with minimal parameters
  /// </summary>
  public async Task SnippetForGetLogs0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetLogsAsync();
  }

  /// <summary>
  /// Snippet for the GetObject method.
  ///
  /// getObject0
  /// </summary>
  public async Task SnippetForGetObject0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetObjectAsync(
      "theIndexName",
      "uniqueID",
      new List<string> { "attr1", "attr2" }
    );
  }

  /// <summary>
  /// Snippet for the GetObjects method.
  ///
  /// getObjects0
  /// </summary>
  public async Task SnippetForGetObjects0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetObjectsAsync<Object>(
      new GetObjectsParams
      {
        Requests = new List<GetObjectsRequest>
        {
          new GetObjectsRequest
          {
            AttributesToRetrieve = new List<string> { "attr1", "attr2" },
            ObjectID = "uniqueID",
            IndexName = "theIndexName",
          }
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the GetRule method.
  ///
  /// getRule0
  /// </summary>
  public async Task SnippetForGetRule0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetRuleAsync("indexName", "id1");
  }

  /// <summary>
  /// Snippet for the GetSettings method.
  ///
  /// getSettings0
  /// </summary>
  public async Task SnippetForGetSettings0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetSettingsAsync("cts_e2e_settings");
  }

  /// <summary>
  /// Snippet for the GetSources method.
  ///
  /// getSources0
  /// </summary>
  public async Task SnippetForGetSources0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetSourcesAsync();
  }

  /// <summary>
  /// Snippet for the GetSynonym method.
  ///
  /// getSynonym0
  /// </summary>
  public async Task SnippetForGetSynonym0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetSynonymAsync("indexName", "id1");
  }

  /// <summary>
  /// Snippet for the GetTask method.
  ///
  /// getTask0
  /// </summary>
  public async Task SnippetForGetTask0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetTaskAsync("theIndexName", 123L);
  }

  /// <summary>
  /// Snippet for the GetTopUserIds method.
  ///
  /// getTopUserIds0
  /// </summary>
  public async Task SnippetForGetTopUserIds0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetTopUserIdsAsync();
  }

  /// <summary>
  /// Snippet for the GetUserId method.
  ///
  /// getUserId0
  /// </summary>
  public async Task SnippetForGetUserId0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetUserIdAsync("uniqueID");
  }

  /// <summary>
  /// Snippet for the HasPendingMappings method.
  ///
  /// hasPendingMappings with minimal parameters
  /// </summary>
  public async Task SnippetForHasPendingMappings0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.HasPendingMappingsAsync();
  }

  /// <summary>
  /// Snippet for the ListApiKeys method.
  ///
  /// listApiKeys0
  /// </summary>
  public async Task SnippetForListApiKeys0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ListApiKeysAsync();
  }

  /// <summary>
  /// Snippet for the ListClusters method.
  ///
  /// listClusters0
  /// </summary>
  public async Task SnippetForListClusters0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ListClustersAsync();
  }

  /// <summary>
  /// Snippet for the ListIndices method.
  ///
  /// listIndices with minimal parameters
  /// </summary>
  public async Task SnippetForListIndices0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ListIndicesAsync();
  }

  /// <summary>
  /// Snippet for the ListUserIds method.
  ///
  /// listUserIds with minimal parameters
  /// </summary>
  public async Task SnippetForListUserIds0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ListUserIdsAsync();
  }

  /// <summary>
  /// Snippet for the MultipleBatch method.
  ///
  /// multipleBatch0
  /// </summary>
  public async Task SnippetForMultipleBatch0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.MultipleBatchAsync(
      new BatchParams
      {
        Requests = new List<MultipleBatchRequest>
        {
          new MultipleBatchRequest
          {
            Action = Enum.Parse<Action>("AddObject"),
            Body = new Dictionary<string, string> { { "key", "value" } },
            IndexName = "theIndexName",
          }
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the OperationIndex method.
  ///
  /// operationIndex0
  /// </summary>
  public async Task SnippetForOperationIndex0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.OperationIndexAsync(
      "theIndexName",
      new OperationIndexParams
      {
        Operation = Enum.Parse<OperationType>("Copy"),
        Destination = "dest",
        Scope = new List<ScopeType>
        {
          Enum.Parse<ScopeType>("Rules"),
          Enum.Parse<ScopeType>("Settings")
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the PartialUpdateObject method.
  ///
  /// partialUpdateObject0
  /// </summary>
  public async Task SnippetForPartialUpdateObject0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.PartialUpdateObjectAsync(
      "theIndexName",
      "uniqueID",
      new Dictionary<string, AttributeToUpdate>
      {
        { "id1", new AttributeToUpdate("test") },
        {
          "id2",
          new AttributeToUpdate(
            new BuiltInOperation
            {
              Operation = Enum.Parse<BuiltInOperationType>("AddUnique"),
              Value = "test2",
            }
          )
        }
      },
      true
    );
  }

  /// <summary>
  /// Snippet for the RemoveUserId method.
  ///
  /// removeUserId0
  /// </summary>
  public async Task SnippetForRemoveUserId0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.RemoveUserIdAsync("uniqueID");
  }

  /// <summary>
  /// Snippet for the ReplaceSources method.
  ///
  /// replaceSources0
  /// </summary>
  public async Task SnippetForReplaceSources0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ReplaceSourcesAsync(
      new List<Source>
      {
        new Source { VarSource = "theSource", Description = "theDescription", }
      }
    );
  }

  /// <summary>
  /// Snippet for the RestoreApiKey method.
  ///
  /// restoreApiKey0
  /// </summary>
  public async Task SnippetForRestoreApiKey0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.RestoreApiKeyAsync("myApiKey");
  }

  /// <summary>
  /// Snippet for the SaveObject method.
  ///
  /// saveObject0
  /// </summary>
  public async Task SnippetForSaveObject0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SaveObjectAsync(
      "theIndexName",
      new Dictionary<string, string> { { "objectID", "id" }, { "test", "val" } }
    );
  }

  /// <summary>
  /// Snippet for the SaveRule method.
  ///
  /// saveRule with minimal parameters
  /// </summary>
  public async Task SnippetForSaveRule0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SaveRuleAsync(
      "indexName",
      "id1",
      new Rule
      {
        ObjectID = "id1",
        Conditions = new List<Condition>
        {
          new Condition { Pattern = "apple", Anchoring = Enum.Parse<Anchoring>("Contains"), }
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the SaveRules method.
  ///
  /// saveRules with minimal parameters
  /// </summary>
  public async Task SnippetForSaveRules0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SaveRulesAsync(
      "indexName",
      new List<Rule>
      {
        new Rule
        {
          ObjectID = "a-rule-id",
          Conditions = new List<Condition>
          {
            new Condition { Pattern = "smartphone", Anchoring = Enum.Parse<Anchoring>("Contains"), }
          },
        },
        new Rule
        {
          ObjectID = "a-second-rule-id",
          Conditions = new List<Condition>
          {
            new Condition { Pattern = "apple", Anchoring = Enum.Parse<Anchoring>("Contains"), }
          },
        }
      }
    );
  }

  /// <summary>
  /// Snippet for the SaveSynonym method.
  ///
  /// saveSynonym0
  /// </summary>
  public async Task SnippetForSaveSynonym0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SaveSynonymAsync(
      "indexName",
      "id1",
      new SynonymHit
      {
        ObjectID = "id1",
        Type = Enum.Parse<SynonymType>("Synonym"),
        Synonyms = new List<string> { "car", "vehicule", "auto" },
      },
      true
    );
  }

  /// <summary>
  /// Snippet for the SaveSynonyms method.
  ///
  /// saveSynonyms0
  /// </summary>
  public async Task SnippetForSaveSynonyms0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SaveSynonymsAsync(
      "indexName",
      new List<SynonymHit>
      {
        new SynonymHit
        {
          ObjectID = "id1",
          Type = Enum.Parse<SynonymType>("Synonym"),
          Synonyms = new List<string> { "car", "vehicule", "auto" },
        },
        new SynonymHit
        {
          ObjectID = "id2",
          Type = Enum.Parse<SynonymType>("Onewaysynonym"),
          Input = "iphone",
          Synonyms = new List<string> { "ephone", "aphone", "yphone" },
        }
      },
      true,
      false
    );
  }

  /// <summary>
  /// Snippet for the Search method.
  ///
  /// search for a single hits request with minimal parameters
  /// </summary>
  public async Task SnippetForSearch0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchAsync<Object>(
      new SearchMethodParams
      {
        Requests = new List<SearchQuery>
        {
          new SearchQuery(new SearchForHits { IndexName = "cts_e2e_search_empty_index", })
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the SearchDictionaryEntries method.
  ///
  /// get searchDictionaryEntries results with minimal parameters
  /// </summary>
  public async Task SnippetForSearchDictionaryEntries0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchDictionaryEntriesAsync(
      Enum.Parse<DictionaryType>("Compounds"),
      new SearchDictionaryEntriesParams { Query = "foo", }
    );
  }

  /// <summary>
  /// Snippet for the SearchForFacetValues method.
  ///
  /// get searchForFacetValues results with minimal parameters
  /// </summary>
  public async Task SnippetForSearchForFacetValues0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchForFacetValuesAsync("indexName", "facetName");
  }

  /// <summary>
  /// Snippet for the SearchRules method.
  ///
  /// searchRules0
  /// </summary>
  public async Task SnippetForSearchRules0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchRulesAsync(
      "indexName",
      new SearchRulesParams { Query = "something", }
    );
  }

  /// <summary>
  /// Snippet for the SearchSingleIndex method.
  ///
  /// search with minimal parameters
  /// </summary>
  public async Task SnippetForSearchSingleIndex0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchSingleIndexAsync<Object>("indexName");
  }

  /// <summary>
  /// Snippet for the SearchSynonyms method.
  ///
  /// searchSynonyms with minimal parameters
  /// </summary>
  public async Task SnippetForSearchSynonyms0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchSynonymsAsync("indexName");
  }

  /// <summary>
  /// Snippet for the SearchUserIds method.
  ///
  /// searchUserIds0
  /// </summary>
  public async Task SnippetForSearchUserIds0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchUserIdsAsync(
      new SearchUserIdsParams
      {
        Query = "test",
        ClusterName = "theClusterName",
        Page = 5,
        HitsPerPage = 10,
      }
    );
  }

  /// <summary>
  /// Snippet for the SetDictionarySettings method.
  ///
  /// get setDictionarySettings results with minimal parameters
  /// </summary>
  public async Task SnippetForSetDictionarySettings0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SetDictionarySettingsAsync(
      new DictionarySettingsParams
      {
        DisableStandardEntries = new StandardEntries
        {
          Plurals = new Dictionary<string, Boolean>
          {
            { "fr", false },
            { "en", false },
            { "ru", true }
          },
        },
      }
    );
  }

  /// <summary>
  /// Snippet for the SetSettings method.
  ///
  /// setSettings with minimal parameters
  /// </summary>
  public async Task SnippetForSetSettings0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SetSettingsAsync(
      "cts_e2e_settings",
      new IndexSettings { PaginationLimitedTo = 10, },
      true
    );
  }

  /// <summary>
  /// Snippet for the UpdateApiKey method.
  ///
  /// updateApiKey0
  /// </summary>
  public async Task SnippetForUpdateApiKey0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.UpdateApiKeyAsync(
      "myApiKey",
      new ApiKey
      {
        Acl = new List<Acl> { Enum.Parse<Acl>("Search"), Enum.Parse<Acl>("AddObject") },
        Validity = 300,
        MaxQueriesPerIPPerHour = 100,
        MaxHitsPerQuery = 20,
      }
    );
  }
}
