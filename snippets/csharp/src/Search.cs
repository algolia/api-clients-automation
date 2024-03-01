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
  public async Task SnippetForSearchClientAddApiKey()
  {
    // >SEPARATOR addApiKey
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the AddOrUpdateObject method.
  ///
  /// addOrUpdateObject0
  /// </summary>
  public async Task SnippetForSearchClientAddOrUpdateObject()
  {
    // >SEPARATOR addOrUpdateObject
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.AddOrUpdateObjectAsync(
      "indexName",
      "uniqueID",
      new Dictionary<string, string> { { "key", "value" } }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the AppendSource method.
  ///
  /// appendSource0
  /// </summary>
  public async Task SnippetForSearchClientAppendSource()
  {
    // >SEPARATOR appendSource
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.AppendSourceAsync(
      new Source { VarSource = "theSource", Description = "theDescription", }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the AssignUserId method.
  ///
  /// assignUserId0
  /// </summary>
  public async Task SnippetForSearchClientAssignUserId()
  {
    // >SEPARATOR assignUserId
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.AssignUserIdAsync(
      "userID",
      new AssignUserIdParams { Cluster = "theCluster", }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the Batch method.
  ///
  /// allows batch method with `addObject` action
  /// </summary>
  public async Task SnippetForSearchClientBatch()
  {
    // >SEPARATOR batch
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the BatchAssignUserIds method.
  ///
  /// batchAssignUserIds0
  /// </summary>
  public async Task SnippetForSearchClientBatchAssignUserIds()
  {
    // >SEPARATOR batchAssignUserIds
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the BatchDictionaryEntries method.
  ///
  /// get batchDictionaryEntries results with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientBatchDictionaryEntries()
  {
    // >SEPARATOR batchDictionaryEntries
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the Browse method.
  ///
  /// browse with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientBrowse()
  {
    // >SEPARATOR browse
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.BrowseAsync<Object>("cts_e2e_browse");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ClearObjects method.
  ///
  /// clearObjects0
  /// </summary>
  public async Task SnippetForSearchClientClearObjects()
  {
    // >SEPARATOR clearObjects
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ClearObjectsAsync("theIndexName");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ClearRules method.
  ///
  /// clearRules0
  /// </summary>
  public async Task SnippetForSearchClientClearRules()
  {
    // >SEPARATOR clearRules
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ClearRulesAsync("indexName");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ClearSynonyms method.
  ///
  /// clearSynonyms0
  /// </summary>
  public async Task SnippetForSearchClientClearSynonyms()
  {
    // >SEPARATOR clearSynonyms
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ClearSynonymsAsync("indexName");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientCustomDelete()
  {
    // >SEPARATOR customDelete
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomDeleteAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientCustomGet()
  {
    // >SEPARATOR customGet
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomGetAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientCustomPost()
  {
    // >SEPARATOR customPost
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPostAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the CustomPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientCustomPut()
  {
    // >SEPARATOR customPut
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.CustomPutAsync("/test/minimal");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteApiKey method.
  ///
  /// deleteApiKey0
  /// </summary>
  public async Task SnippetForSearchClientDeleteApiKey()
  {
    // >SEPARATOR deleteApiKey
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteApiKeyAsync("myTestApiKey");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteBy method.
  ///
  /// deleteBy0
  /// </summary>
  public async Task SnippetForSearchClientDeleteBy()
  {
    // >SEPARATOR deleteBy
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteByAsync(
      "theIndexName",
      new DeleteByParams { Filters = "brand:brandName", }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteIndex method.
  ///
  /// deleteIndex0
  /// </summary>
  public async Task SnippetForSearchClientDeleteIndex()
  {
    // >SEPARATOR deleteIndex
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteIndexAsync("theIndexName");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteObject method.
  ///
  /// deleteObject0
  /// </summary>
  public async Task SnippetForSearchClientDeleteObject()
  {
    // >SEPARATOR deleteObject
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteObjectAsync("theIndexName", "uniqueID");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteRule method.
  ///
  /// delete rule simple case
  /// </summary>
  public async Task SnippetForSearchClientDeleteRule()
  {
    // >SEPARATOR deleteRule
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteRuleAsync("indexName", "id1");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteSource method.
  ///
  /// deleteSource0
  /// </summary>
  public async Task SnippetForSearchClientDeleteSource()
  {
    // >SEPARATOR deleteSource
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteSourceAsync("theSource");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the DeleteSynonym method.
  ///
  /// deleteSynonym0
  /// </summary>
  public async Task SnippetForSearchClientDeleteSynonym()
  {
    // >SEPARATOR deleteSynonym
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.DeleteSynonymAsync("indexName", "id1");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetApiKey method.
  ///
  /// getApiKey0
  /// </summary>
  public async Task SnippetForSearchClientGetApiKey()
  {
    // >SEPARATOR getApiKey
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetApiKeyAsync("myTestApiKey");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetDictionaryLanguages method.
  ///
  /// get getDictionaryLanguages
  /// </summary>
  public async Task SnippetForSearchClientGetDictionaryLanguages()
  {
    // >SEPARATOR getDictionaryLanguages
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetDictionaryLanguagesAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetDictionarySettings method.
  ///
  /// get getDictionarySettings results
  /// </summary>
  public async Task SnippetForSearchClientGetDictionarySettings()
  {
    // >SEPARATOR getDictionarySettings
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetDictionarySettingsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetLogs method.
  ///
  /// getLogs with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientGetLogs()
  {
    // >SEPARATOR getLogs
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetLogsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetObject method.
  ///
  /// getObject0
  /// </summary>
  public async Task SnippetForSearchClientGetObject()
  {
    // >SEPARATOR getObject
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetObjectAsync(
      "theIndexName",
      "uniqueID",
      new List<string> { "attr1", "attr2" }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetObjects method.
  ///
  /// getObjects0
  /// </summary>
  public async Task SnippetForSearchClientGetObjects()
  {
    // >SEPARATOR getObjects
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetRule method.
  ///
  /// getRule0
  /// </summary>
  public async Task SnippetForSearchClientGetRule()
  {
    // >SEPARATOR getRule
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetRuleAsync("indexName", "id1");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSettings method.
  ///
  /// getSettings0
  /// </summary>
  public async Task SnippetForSearchClientGetSettings()
  {
    // >SEPARATOR getSettings
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetSettingsAsync("cts_e2e_settings");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSources method.
  ///
  /// getSources0
  /// </summary>
  public async Task SnippetForSearchClientGetSources()
  {
    // >SEPARATOR getSources
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetSourcesAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetSynonym method.
  ///
  /// getSynonym0
  /// </summary>
  public async Task SnippetForSearchClientGetSynonym()
  {
    // >SEPARATOR getSynonym
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetSynonymAsync("indexName", "id1");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTask method.
  ///
  /// getTask0
  /// </summary>
  public async Task SnippetForSearchClientGetTask()
  {
    // >SEPARATOR getTask
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetTaskAsync("theIndexName", 123L);
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetTopUserIds method.
  ///
  /// getTopUserIds0
  /// </summary>
  public async Task SnippetForSearchClientGetTopUserIds()
  {
    // >SEPARATOR getTopUserIds
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetTopUserIdsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the GetUserId method.
  ///
  /// getUserId0
  /// </summary>
  public async Task SnippetForSearchClientGetUserId()
  {
    // >SEPARATOR getUserId
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.GetUserIdAsync("uniqueID");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the HasPendingMappings method.
  ///
  /// hasPendingMappings with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientHasPendingMappings()
  {
    // >SEPARATOR hasPendingMappings
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.HasPendingMappingsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListApiKeys method.
  ///
  /// listApiKeys0
  /// </summary>
  public async Task SnippetForSearchClientListApiKeys()
  {
    // >SEPARATOR listApiKeys
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ListApiKeysAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListClusters method.
  ///
  /// listClusters0
  /// </summary>
  public async Task SnippetForSearchClientListClusters()
  {
    // >SEPARATOR listClusters
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ListClustersAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListIndices method.
  ///
  /// listIndices with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientListIndices()
  {
    // >SEPARATOR listIndices
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ListIndicesAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ListUserIds method.
  ///
  /// listUserIds with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientListUserIds()
  {
    // >SEPARATOR listUserIds
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ListUserIdsAsync();
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the MultipleBatch method.
  ///
  /// multipleBatch0
  /// </summary>
  public async Task SnippetForSearchClientMultipleBatch()
  {
    // >SEPARATOR multipleBatch
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the OperationIndex method.
  ///
  /// operationIndex0
  /// </summary>
  public async Task SnippetForSearchClientOperationIndex()
  {
    // >SEPARATOR operationIndex
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the PartialUpdateObject method.
  ///
  /// partialUpdateObject0
  /// </summary>
  public async Task SnippetForSearchClientPartialUpdateObject()
  {
    // >SEPARATOR partialUpdateObject
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the RemoveUserId method.
  ///
  /// removeUserId0
  /// </summary>
  public async Task SnippetForSearchClientRemoveUserId()
  {
    // >SEPARATOR removeUserId
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.RemoveUserIdAsync("uniqueID");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the ReplaceSources method.
  ///
  /// replaceSources0
  /// </summary>
  public async Task SnippetForSearchClientReplaceSources()
  {
    // >SEPARATOR replaceSources
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.ReplaceSourcesAsync(
      new List<Source>
      {
        new Source { VarSource = "theSource", Description = "theDescription", }
      }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the RestoreApiKey method.
  ///
  /// restoreApiKey0
  /// </summary>
  public async Task SnippetForSearchClientRestoreApiKey()
  {
    // >SEPARATOR restoreApiKey
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.RestoreApiKeyAsync("myApiKey");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SaveObject method.
  ///
  /// saveObject0
  /// </summary>
  public async Task SnippetForSearchClientSaveObject()
  {
    // >SEPARATOR saveObject
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SaveObjectAsync(
      "theIndexName",
      new Dictionary<string, string> { { "objectID", "id" }, { "test", "val" } }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SaveRule method.
  ///
  /// saveRule with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientSaveRule()
  {
    // >SEPARATOR saveRule
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SaveRules method.
  ///
  /// saveRules with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientSaveRules()
  {
    // >SEPARATOR saveRules
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SaveSynonym method.
  ///
  /// saveSynonym0
  /// </summary>
  public async Task SnippetForSearchClientSaveSynonym()
  {
    // >SEPARATOR saveSynonym
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SaveSynonyms method.
  ///
  /// saveSynonyms0
  /// </summary>
  public async Task SnippetForSearchClientSaveSynonyms()
  {
    // >SEPARATOR saveSynonyms
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the Search method.
  ///
  /// search for a single hits request with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientSearch()
  {
    // >SEPARATOR search
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchDictionaryEntries method.
  ///
  /// get searchDictionaryEntries results with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientSearchDictionaryEntries()
  {
    // >SEPARATOR searchDictionaryEntries
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchDictionaryEntriesAsync(
      Enum.Parse<DictionaryType>("Compounds"),
      new SearchDictionaryEntriesParams { Query = "foo", }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchForFacetValues method.
  ///
  /// get searchForFacetValues results with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientSearchForFacetValues()
  {
    // >SEPARATOR searchForFacetValues
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchForFacetValuesAsync("indexName", "facetName");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchRules method.
  ///
  /// searchRules0
  /// </summary>
  public async Task SnippetForSearchClientSearchRules()
  {
    // >SEPARATOR searchRules
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchRulesAsync(
      "indexName",
      new SearchRulesParams { Query = "something", }
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchSingleIndex method.
  ///
  /// search with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientSearchSingleIndex()
  {
    // >SEPARATOR searchSingleIndex
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchSingleIndexAsync<Object>("indexName");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchSynonyms method.
  ///
  /// searchSynonyms with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientSearchSynonyms()
  {
    // >SEPARATOR searchSynonyms
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SearchSynonymsAsync("indexName");
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SearchUserIds method.
  ///
  /// searchUserIds0
  /// </summary>
  public async Task SnippetForSearchClientSearchUserIds()
  {
    // >SEPARATOR searchUserIds
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SetDictionarySettings method.
  ///
  /// get setDictionarySettings results with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientSetDictionarySettings()
  {
    // >SEPARATOR setDictionarySettings
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
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the SetSettings method.
  ///
  /// setSettings with minimal parameters
  /// </summary>
  public async Task SnippetForSearchClientSetSettings()
  {
    // >SEPARATOR setSettings
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var response = await client.SetSettingsAsync(
      "cts_e2e_settings",
      new IndexSettings { PaginationLimitedTo = 10, },
      true
    );
    // SEPARATOR<
  }

  /// <summary>
  /// Snippet for the UpdateApiKey method.
  ///
  /// updateApiKey0
  /// </summary>
  public async Task SnippetForSearchClientUpdateApiKey()
  {
    // >SEPARATOR updateApiKey
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
    // SEPARATOR<
  }
}
