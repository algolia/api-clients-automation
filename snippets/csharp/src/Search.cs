using Algolia.Search.Http;
using Algolia.Search.Clients;
using Algolia.Search.Models.Search;
using Action = Algolia.Search.Models.Search.Action;

public class SnippetSearchClient
{
  [Fact]
  public void Dispose()
  {

  }

  /// <summary>
  /// Snippet for the addApiKey method.
  ///
  /// addApiKey0
  /// </summary>
  public async Task SnippetForAddApiKey0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var apiKey0 = new ApiKey();
    {
      var acl1 = new List<Acl>();
      var acl_02 = (Acl)Enum.Parse(typeof(Acl), "Search");
      acl1.Add(acl_02); var acl_12 = (Acl)Enum.Parse(typeof(Acl), "AddObject");
      acl1.Add(acl_12);
      apiKey0.Acl = acl1; const string description1 = "my new api key";
      apiKey0.Description = description1; const int validity1 = 300;
      apiKey0.Validity = validity1; const int maxQueriesPerIPPerHour1 = 100;
      apiKey0.MaxQueriesPerIPPerHour = maxQueriesPerIPPerHour1; const int maxHitsPerQuery1 = 20;
      apiKey0.MaxHitsPerQuery = maxHitsPerQuery1;
    }


    var response = await _client.AddApiKeyAsync(apiKey0);
  }

  /// <summary>
  /// Snippet for the addOrUpdateObject method.
  ///
  /// addOrUpdateObject0
  /// </summary>
  public async Task SnippetForAddOrUpdateObject0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    const string objectID0 = "uniqueID";
    var body0 = new Dictionary<string, string>();
    {
      const string key1 = "value";
      body0.Add("key", key1);
    }


    var response = await _client.AddOrUpdateObjectAsync(indexName0, objectID0, body0);
  }

  /// <summary>
  /// Snippet for the appendSource method.
  ///
  /// appendSource0
  /// </summary>
  public async Task SnippetForAppendSource0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var source0 = new Source();
    {
      const string source1 = "theSource";
      source0.VarSource = source1; const string description1 = "theDescription";
      source0.Description = description1;
    }


    var response = await _client.AppendSourceAsync(source0);
  }

  /// <summary>
  /// Snippet for the assignUserId method.
  ///
  /// assignUserId0
  /// </summary>
  public async Task SnippetForAssignUserId0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string xAlgoliaUserID0 = "userID";
    var assignUserIdParams0 = new AssignUserIdParams();
    {
      const string cluster1 = "theCluster";
      assignUserIdParams0.Cluster = cluster1;
    }


    var response = await _client.AssignUserIdAsync(xAlgoliaUserID0, assignUserIdParams0);
  }

  /// <summary>
  /// Snippet for the batch method.
  ///
  /// allows batch method with `addObject` action
  /// </summary>
  public async Task SnippetForBatch0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "theIndexName";
    var batchWriteParams0 = new BatchWriteParams();
    {
      var requests1 = new List<BatchRequest>();
      var requests_02 = new BatchRequest();
      {
        var action3 = (Action)Enum.Parse(typeof(Action), "AddObject");
        requests_02.Action = action3; var body3 = new Dictionary<string, string>();
        {
          const string key4 = "value";
          body3.Add("key", key4);
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02);
      batchWriteParams0.Requests = requests1;
    }


    var response = await _client.BatchAsync(indexName0, batchWriteParams0);
  }

  /// <summary>
  /// Snippet for the batchAssignUserIds method.
  ///
  /// batchAssignUserIds0
  /// </summary>
  public async Task SnippetForBatchAssignUserIds0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string xAlgoliaUserID0 = "userID";
    var batchAssignUserIdsParams0 = new BatchAssignUserIdsParams();
    {
      const string cluster1 = "theCluster";
      batchAssignUserIdsParams0.Cluster = cluster1; var users1 = new List<string>();
      const string users_02 = "user1";
      users1.Add(users_02); const string users_12 = "user2";
      users1.Add(users_12);
      batchAssignUserIdsParams0.Users = users1;
    }


    var response = await _client.BatchAssignUserIdsAsync(xAlgoliaUserID0, batchAssignUserIdsParams0);
  }

  /// <summary>
  /// Snippet for the batchDictionaryEntries method.
  ///
  /// get batchDictionaryEntries results with minimal parameters
  /// </summary>
  public async Task SnippetForBatchDictionaryEntries0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var dictionaryName0 = (DictionaryType)Enum.Parse(typeof(DictionaryType), "Compounds");
    var batchDictionaryEntriesParams0 = new BatchDictionaryEntriesParams();
    {
      var requests1 = new List<BatchDictionaryEntriesRequest>();
      var requests_02 = new BatchDictionaryEntriesRequest();
      {
        var action3 = (DictionaryAction)Enum.Parse(typeof(DictionaryAction), "AddEntry");
        requests_02.Action = action3; var body3 = new DictionaryEntry();
        {
          const string objectID4 = "1";
          body3.ObjectID = objectID4; const string language4 = "en";
          body3.Language = language4;
        }
        requests_02.Body = body3;
      }
      requests1.Add(requests_02); var requests_12 = new BatchDictionaryEntriesRequest();
      {
        var action3 = (DictionaryAction)Enum.Parse(typeof(DictionaryAction), "DeleteEntry");
        requests_12.Action = action3; var body3 = new DictionaryEntry();
        {
          const string objectID4 = "2";
          body3.ObjectID = objectID4; const string language4 = "fr";
          body3.Language = language4;
        }
        requests_12.Body = body3;
      }
      requests1.Add(requests_12);
      batchDictionaryEntriesParams0.Requests = requests1;
    }


    var response = await _client.BatchDictionaryEntriesAsync(dictionaryName0, batchDictionaryEntriesParams0);
  }

  /// <summary>
  /// Snippet for the browse method.
  ///
  /// browse with minimal parameters
  /// </summary>
  public async Task SnippetForBrowse0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "cts_e2e_browse";


    var response = await _client.BrowseAsync<Object>(indexName0);
  }

  /// <summary>
  /// Snippet for the clearAllSynonyms method.
  ///
  /// clearAllSynonyms0
  /// </summary>
  public async Task SnippetForClearAllSynonyms0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";


    var response = await _client.ClearAllSynonymsAsync(indexName0);
  }

  /// <summary>
  /// Snippet for the clearObjects method.
  ///
  /// clearObjects0
  /// </summary>
  public async Task SnippetForClearObjects0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "theIndexName";


    var response = await _client.ClearObjectsAsync(indexName0);
  }

  /// <summary>
  /// Snippet for the clearRules method.
  ///
  /// clearRules0
  /// </summary>
  public async Task SnippetForClearRules0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";


    var response = await _client.ClearRulesAsync(indexName0);
  }

  /// <summary>
  /// Snippet for the customDelete method.
  ///
  /// allow del method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomDelete0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomDeleteAsync(path0);
  }

  /// <summary>
  /// Snippet for the customGet method.
  ///
  /// allow get method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomGet0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomGetAsync(path0);
  }

  /// <summary>
  /// Snippet for the customPost method.
  ///
  /// allow post method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPost0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPostAsync(path0);
  }

  /// <summary>
  /// Snippet for the customPut method.
  ///
  /// allow put method for a custom path with minimal parameters
  /// </summary>
  public async Task SnippetForCustomPut0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string path0 = "/test/minimal";


    var response = await _client.CustomPutAsync(path0);
  }

  /// <summary>
  /// Snippet for the deleteApiKey method.
  ///
  /// deleteApiKey0
  /// </summary>
  public async Task SnippetForDeleteApiKey0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string key0 = "myTestApiKey";


    var response = await _client.DeleteApiKeyAsync(key0);
  }

  /// <summary>
  /// Snippet for the deleteBy method.
  ///
  /// deleteBy0
  /// </summary>
  public async Task SnippetForDeleteBy0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "theIndexName";
    var deleteByParams0 = new DeleteByParams();
    {
      const string filters1 = "brand:brandName";
      deleteByParams0.Filters = filters1;
    }


    var response = await _client.DeleteByAsync(indexName0, deleteByParams0);
  }

  /// <summary>
  /// Snippet for the deleteIndex method.
  ///
  /// deleteIndex0
  /// </summary>
  public async Task SnippetForDeleteIndex0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "theIndexName";


    var response = await _client.DeleteIndexAsync(indexName0);
  }

  /// <summary>
  /// Snippet for the deleteObject method.
  ///
  /// deleteObject0
  /// </summary>
  public async Task SnippetForDeleteObject0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "theIndexName";
    const string objectID0 = "uniqueID";


    var response = await _client.DeleteObjectAsync(indexName0, objectID0);
  }

  /// <summary>
  /// Snippet for the deleteRule method.
  ///
  /// delete rule simple case
  /// </summary>
  public async Task SnippetForDeleteRule0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    const string objectID0 = "id1";


    var response = await _client.DeleteRuleAsync(indexName0, objectID0);
  }

  /// <summary>
  /// Snippet for the deleteSource method.
  ///
  /// deleteSource0
  /// </summary>
  public async Task SnippetForDeleteSource0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string source0 = "theSource";


    var response = await _client.DeleteSourceAsync(source0);
  }

  /// <summary>
  /// Snippet for the deleteSynonym method.
  ///
  /// deleteSynonym0
  /// </summary>
  public async Task SnippetForDeleteSynonym0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    const string objectID0 = "id1";


    var response = await _client.DeleteSynonymAsync(indexName0, objectID0);
  }

  /// <summary>
  /// Snippet for the getApiKey method.
  ///
  /// getApiKey0
  /// </summary>
  public async Task SnippetForGetApiKey0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string key0 = "myTestApiKey";


    var response = await _client.GetApiKeyAsync(key0);
  }

  /// <summary>
  /// Snippet for the getDictionaryLanguages method.
  ///
  /// get getDictionaryLanguages
  /// </summary>
  public async Task SnippetForGetDictionaryLanguages0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.GetDictionaryLanguagesAsync();
  }

  /// <summary>
  /// Snippet for the getDictionarySettings method.
  ///
  /// get getDictionarySettings results
  /// </summary>
  public async Task SnippetForGetDictionarySettings0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.GetDictionarySettingsAsync();
  }

  /// <summary>
  /// Snippet for the getLogs method.
  ///
  /// getLogs with minimal parameters
  /// </summary>
  public async Task SnippetForGetLogs0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.GetLogsAsync();
  }

  /// <summary>
  /// Snippet for the getObject method.
  ///
  /// getObject0
  /// </summary>
  public async Task SnippetForGetObject0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "theIndexName";
    const string objectID0 = "uniqueID";
    var attributesToRetrieve0 = new List<string>();
    const string attributesToRetrieve_01 = "attr1";
    attributesToRetrieve0.Add(attributesToRetrieve_01); const string attributesToRetrieve_11 = "attr2";
    attributesToRetrieve0.Add(attributesToRetrieve_11);


    var response = await _client.GetObjectAsync(indexName0, objectID0, attributesToRetrieve0);
  }

  /// <summary>
  /// Snippet for the getObjects method.
  ///
  /// getObjects0
  /// </summary>
  public async Task SnippetForGetObjects0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var getObjectsParams0 = new GetObjectsParams();
    {
      var requests1 = new List<GetObjectsRequest>();
      var requests_02 = new GetObjectsRequest();
      {
        var attributesToRetrieve3 = new List<string>();
        const string attributesToRetrieve_04 = "attr1";
        attributesToRetrieve3.Add(attributesToRetrieve_04); const string attributesToRetrieve_14 = "attr2";
        attributesToRetrieve3.Add(attributesToRetrieve_14);
        requests_02.AttributesToRetrieve = attributesToRetrieve3; const string objectID3 = "uniqueID";
        requests_02.ObjectID = objectID3; const string indexName3 = "theIndexName";
        requests_02.IndexName = indexName3;
      }
      requests1.Add(requests_02);
      getObjectsParams0.Requests = requests1;
    }


    var response = await _client.GetObjectsAsync<Object>(getObjectsParams0);
  }

  /// <summary>
  /// Snippet for the getRule method.
  ///
  /// getRule0
  /// </summary>
  public async Task SnippetForGetRule0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    const string objectID0 = "id1";


    var response = await _client.GetRuleAsync(indexName0, objectID0);
  }

  /// <summary>
  /// Snippet for the getSettings method.
  ///
  /// getSettings0
  /// </summary>
  public async Task SnippetForGetSettings0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "cts_e2e_settings";


    var response = await _client.GetSettingsAsync(indexName0);
  }

  /// <summary>
  /// Snippet for the getSources method.
  ///
  /// getSources0
  /// </summary>
  public async Task SnippetForGetSources0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.GetSourcesAsync();
  }

  /// <summary>
  /// Snippet for the getSynonym method.
  ///
  /// getSynonym0
  /// </summary>
  public async Task SnippetForGetSynonym0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    const string objectID0 = "id1";


    var response = await _client.GetSynonymAsync(indexName0, objectID0);
  }

  /// <summary>
  /// Snippet for the getTask method.
  ///
  /// getTask0
  /// </summary>
  public async Task SnippetForGetTask0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "theIndexName";
    const long taskID0 = 123L;


    var response = await _client.GetTaskAsync(indexName0, taskID0);
  }

  /// <summary>
  /// Snippet for the getTopUserIds method.
  ///
  /// getTopUserIds0
  /// </summary>
  public async Task SnippetForGetTopUserIds0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.GetTopUserIdsAsync();
  }

  /// <summary>
  /// Snippet for the getUserId method.
  ///
  /// getUserId0
  /// </summary>
  public async Task SnippetForGetUserId0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string userID0 = "uniqueID";


    var response = await _client.GetUserIdAsync(userID0);
  }

  /// <summary>
  /// Snippet for the hasPendingMappings method.
  ///
  /// hasPendingMappings with minimal parameters
  /// </summary>
  public async Task SnippetForHasPendingMappings0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.HasPendingMappingsAsync();
  }

  /// <summary>
  /// Snippet for the listApiKeys method.
  ///
  /// listApiKeys0
  /// </summary>
  public async Task SnippetForListApiKeys0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.ListApiKeysAsync();
  }

  /// <summary>
  /// Snippet for the listClusters method.
  ///
  /// listClusters0
  /// </summary>
  public async Task SnippetForListClusters0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.ListClustersAsync();
  }

  /// <summary>
  /// Snippet for the listIndices method.
  ///
  /// listIndices with minimal parameters
  /// </summary>
  public async Task SnippetForListIndices0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.ListIndicesAsync();
  }

  /// <summary>
  /// Snippet for the listUserIds method.
  ///
  /// listUserIds with minimal parameters
  /// </summary>
  public async Task SnippetForListUserIds0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API


    var response = await _client.ListUserIdsAsync();
  }

  /// <summary>
  /// Snippet for the multipleBatch method.
  ///
  /// multipleBatch0
  /// </summary>
  public async Task SnippetForMultipleBatch0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var batchParams0 = new BatchParams();
    {
      var requests1 = new List<MultipleBatchRequest>();
      var requests_02 = new MultipleBatchRequest();
      {
        var action3 = (Action)Enum.Parse(typeof(Action), "AddObject");
        requests_02.Action = action3; var body3 = new Dictionary<string, string>();
        {
          const string key4 = "value";
          body3.Add("key", key4);
        }
        requests_02.Body = body3; const string indexName3 = "theIndexName";
        requests_02.IndexName = indexName3;
      }
      requests1.Add(requests_02);
      batchParams0.Requests = requests1;
    }


    var response = await _client.MultipleBatchAsync(batchParams0);
  }

  /// <summary>
  /// Snippet for the operationIndex method.
  ///
  /// operationIndex0
  /// </summary>
  public async Task SnippetForOperationIndex0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "theIndexName";
    var operationIndexParams0 = new OperationIndexParams();
    {
      var operation1 = (OperationType)Enum.Parse(typeof(OperationType), "Copy");
      operationIndexParams0.Operation = operation1; const string destination1 = "dest";
      operationIndexParams0.Destination = destination1; var scope1 = new List<ScopeType>();
      var scope_02 = (ScopeType)Enum.Parse(typeof(ScopeType), "Rules");
      scope1.Add(scope_02); var scope_12 = (ScopeType)Enum.Parse(typeof(ScopeType), "Settings");
      scope1.Add(scope_12);
      operationIndexParams0.Scope = scope1;
    }


    var response = await _client.OperationIndexAsync(indexName0, operationIndexParams0);
  }

  /// <summary>
  /// Snippet for the partialUpdateObject method.
  ///
  /// partialUpdateObject0
  /// </summary>
  public async Task SnippetForPartialUpdateObject0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "theIndexName";
    const string objectID0 = "uniqueID";
    var attributesToUpdate0 = new Dictionary<string, AttributeToUpdate>();
    {
      const string id11 = "test";
      attributesToUpdate0.Add("id1", new AttributeToUpdate(id11)); var id21 = new BuiltInOperation();
      {
        var _operation2 = (BuiltInOperationType)Enum.Parse(typeof(BuiltInOperationType), "AddUnique");
        id21.Operation = _operation2; const string value2 = "test2";
        id21.Value = value2;
      }
      attributesToUpdate0.Add("id2", new AttributeToUpdate(id21));
    }
    const bool createIfNotExists0 = true;


    var response = await _client.PartialUpdateObjectAsync(indexName0, objectID0, attributesToUpdate0, createIfNotExists0);
  }

  /// <summary>
  /// Snippet for the removeUserId method.
  ///
  /// removeUserId0
  /// </summary>
  public async Task SnippetForRemoveUserId0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string userID0 = "uniqueID";


    var response = await _client.RemoveUserIdAsync(userID0);
  }

  /// <summary>
  /// Snippet for the replaceSources method.
  ///
  /// replaceSources0
  /// </summary>
  public async Task SnippetForReplaceSources0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var source0 = new List<Source>();
    var source_01 = new Source();
    {
      const string source2 = "theSource";
      source_01.VarSource = source2; const string description2 = "theDescription";
      source_01.Description = description2;
    }
    source0.Add(source_01);


    var response = await _client.ReplaceSourcesAsync(source0);
  }

  /// <summary>
  /// Snippet for the restoreApiKey method.
  ///
  /// restoreApiKey0
  /// </summary>
  public async Task SnippetForRestoreApiKey0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string key0 = "myApiKey";


    var response = await _client.RestoreApiKeyAsync(key0);
  }

  /// <summary>
  /// Snippet for the saveObject method.
  ///
  /// saveObject0
  /// </summary>
  public async Task SnippetForSaveObject0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "theIndexName";
    var body0 = new Dictionary<string, string>();
    {
      const string objectID1 = "id";
      body0.Add("objectID", objectID1); const string test1 = "val";
      body0.Add("test", test1);
    }


    var response = await _client.SaveObjectAsync(indexName0, body0);
  }

  /// <summary>
  /// Snippet for the saveRule method.
  ///
  /// saveRule with minimal parameters
  /// </summary>
  public async Task SnippetForSaveRule0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    const string objectID0 = "id1";
    var rule0 = new Rule();
    {
      const string objectID1 = "id1";
      rule0.ObjectID = objectID1; var conditions1 = new List<Condition>();
      var conditions_02 = new Condition();
      {
        const string pattern3 = "apple";
        conditions_02.Pattern = pattern3; var anchoring3 = (Anchoring)Enum.Parse(typeof(Anchoring), "Contains");
        conditions_02.Anchoring = anchoring3;
      }
      conditions1.Add(conditions_02);
      rule0.Conditions = conditions1;
    }


    var response = await _client.SaveRuleAsync(indexName0, objectID0, rule0);
  }

  /// <summary>
  /// Snippet for the saveRules method.
  ///
  /// saveRules with minimal parameters
  /// </summary>
  public async Task SnippetForSaveRules0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    var rules0 = new List<Rule>();
    var rules_01 = new Rule();
    {
      const string objectID2 = "a-rule-id";
      rules_01.ObjectID = objectID2; var conditions2 = new List<Condition>();
      var conditions_03 = new Condition();
      {
        const string pattern4 = "smartphone";
        conditions_03.Pattern = pattern4; var anchoring4 = (Anchoring)Enum.Parse(typeof(Anchoring), "Contains");
        conditions_03.Anchoring = anchoring4;
      }
      conditions2.Add(conditions_03);
      rules_01.Conditions = conditions2;
    }
    rules0.Add(rules_01); var rules_11 = new Rule();
    {
      const string objectID2 = "a-second-rule-id";
      rules_11.ObjectID = objectID2; var conditions2 = new List<Condition>();
      var conditions_03 = new Condition();
      {
        const string pattern4 = "apple";
        conditions_03.Pattern = pattern4; var anchoring4 = (Anchoring)Enum.Parse(typeof(Anchoring), "Contains");
        conditions_03.Anchoring = anchoring4;
      }
      conditions2.Add(conditions_03);
      rules_11.Conditions = conditions2;
    }
    rules0.Add(rules_11);


    var response = await _client.SaveRulesAsync(indexName0, rules0);
  }

  /// <summary>
  /// Snippet for the saveSynonym method.
  ///
  /// saveSynonym0
  /// </summary>
  public async Task SnippetForSaveSynonym0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    const string objectID0 = "id1";
    var synonymHit0 = new SynonymHit();
    {
      const string objectID1 = "id1";
      synonymHit0.ObjectID = objectID1; var type1 = (SynonymType)Enum.Parse(typeof(SynonymType), "Synonym");
      synonymHit0.Type = type1; var synonyms1 = new List<string>();
      const string synonyms_02 = "car";
      synonyms1.Add(synonyms_02); const string synonyms_12 = "vehicule";
      synonyms1.Add(synonyms_12); const string synonyms_22 = "auto";
      synonyms1.Add(synonyms_22);
      synonymHit0.Synonyms = synonyms1;
    }
    const bool forwardToReplicas0 = true;


    var response = await _client.SaveSynonymAsync(indexName0, objectID0, synonymHit0, forwardToReplicas0);
  }

  /// <summary>
  /// Snippet for the saveSynonyms method.
  ///
  /// saveSynonyms0
  /// </summary>
  public async Task SnippetForSaveSynonyms0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    var synonymHit0 = new List<SynonymHit>();
    var synonymHit_01 = new SynonymHit();
    {
      const string objectID2 = "id1";
      synonymHit_01.ObjectID = objectID2; var type2 = (SynonymType)Enum.Parse(typeof(SynonymType), "Synonym");
      synonymHit_01.Type = type2; var synonyms2 = new List<string>();
      const string synonyms_03 = "car";
      synonyms2.Add(synonyms_03); const string synonyms_13 = "vehicule";
      synonyms2.Add(synonyms_13); const string synonyms_23 = "auto";
      synonyms2.Add(synonyms_23);
      synonymHit_01.Synonyms = synonyms2;
    }
    synonymHit0.Add(synonymHit_01); var synonymHit_11 = new SynonymHit();
    {
      const string objectID2 = "id2";
      synonymHit_11.ObjectID = objectID2; var type2 = (SynonymType)Enum.Parse(typeof(SynonymType), "Onewaysynonym");
      synonymHit_11.Type = type2; const string input2 = "iphone";
      synonymHit_11.Input = input2; var synonyms2 = new List<string>();
      const string synonyms_03 = "ephone";
      synonyms2.Add(synonyms_03); const string synonyms_13 = "aphone";
      synonyms2.Add(synonyms_13); const string synonyms_23 = "yphone";
      synonyms2.Add(synonyms_23);
      synonymHit_11.Synonyms = synonyms2;
    }
    synonymHit0.Add(synonymHit_11);
    const bool forwardToReplicas0 = true;
    const bool replaceExistingSynonyms0 = false;


    var response = await _client.SaveSynonymsAsync(indexName0, synonymHit0, forwardToReplicas0, replaceExistingSynonyms0);
  }

  /// <summary>
  /// Snippet for the search method.
  ///
  /// search for a single hits request with minimal parameters
  /// </summary>
  public async Task SnippetForSearch0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var searchMethodParams0 = new SearchMethodParams();
    {
      var requests1 = new List<SearchQuery>();
      var requests_02 = new SearchForHits();
      {
        const string indexName3 = "cts_e2e_search_empty_index";
        requests_02.IndexName = indexName3;
      }
      requests1.Add(new SearchQuery(requests_02));
      searchMethodParams0.Requests = requests1;
    }


    var response = await _client.SearchAsync<Object>(searchMethodParams0);
  }

  /// <summary>
  /// Snippet for the searchDictionaryEntries method.
  ///
  /// get searchDictionaryEntries results with minimal parameters
  /// </summary>
  public async Task SnippetForSearchDictionaryEntries0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var dictionaryName0 = (DictionaryType)Enum.Parse(typeof(DictionaryType), "Compounds");
    var searchDictionaryEntriesParams0 = new SearchDictionaryEntriesParams();
    {
      const string query1 = "foo";
      searchDictionaryEntriesParams0.Query = query1;
    }


    var response = await _client.SearchDictionaryEntriesAsync(dictionaryName0, searchDictionaryEntriesParams0);
  }

  /// <summary>
  /// Snippet for the searchForFacetValues method.
  ///
  /// get searchForFacetValues results with minimal parameters
  /// </summary>
  public async Task SnippetForSearchForFacetValues0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    const string facetName0 = "facetName";


    var response = await _client.SearchForFacetValuesAsync(indexName0, facetName0);
  }

  /// <summary>
  /// Snippet for the searchRules method.
  ///
  /// searchRules0
  /// </summary>
  public async Task SnippetForSearchRules0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";
    var searchRulesParams0 = new SearchRulesParams();
    {
      const string query1 = "something";
      searchRulesParams0.Query = query1;
    }


    var response = await _client.SearchRulesAsync(indexName0, searchRulesParams0);
  }

  /// <summary>
  /// Snippet for the searchSingleIndex method.
  ///
  /// search with minimal parameters
  /// </summary>
  public async Task SnippetForSearchSingleIndex0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";


    var response = await _client.SearchSingleIndexAsync<Object>(indexName0);
  }

  /// <summary>
  /// Snippet for the searchSynonyms method.
  ///
  /// searchSynonyms with minimal parameters
  /// </summary>
  public async Task SnippetForSearchSynonyms0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "indexName";


    var response = await _client.SearchSynonymsAsync(indexName0);
  }

  /// <summary>
  /// Snippet for the searchUserIds method.
  ///
  /// searchUserIds0
  /// </summary>
  public async Task SnippetForSearchUserIds0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var searchUserIdsParams0 = new SearchUserIdsParams();
    {
      const string query1 = "test";
      searchUserIdsParams0.Query = query1; const string clusterName1 = "theClusterName";
      searchUserIdsParams0.ClusterName = clusterName1; const int page1 = 5;
      searchUserIdsParams0.Page = page1; const int hitsPerPage1 = 10;
      searchUserIdsParams0.HitsPerPage = hitsPerPage1;
    }


    var response = await _client.SearchUserIdsAsync(searchUserIdsParams0);
  }

  /// <summary>
  /// Snippet for the setDictionarySettings method.
  ///
  /// get setDictionarySettings results with minimal parameters
  /// </summary>
  public async Task SnippetForSetDictionarySettings0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    var dictionarySettingsParams0 = new DictionarySettingsParams();
    {
      var disableStandardEntries1 = new StandardEntries();
      {
        var plurals2 = new Dictionary<string, Boolean>();
        {
          const bool fr3 = false;
          plurals2.Add("fr", fr3); const bool en3 = false;
          plurals2.Add("en", en3); const bool ru3 = true;
          plurals2.Add("ru", ru3);
        }
        disableStandardEntries1.Plurals = plurals2;
      }
      dictionarySettingsParams0.DisableStandardEntries = disableStandardEntries1;
    }


    var response = await _client.SetDictionarySettingsAsync(dictionarySettingsParams0);
  }

  /// <summary>
  /// Snippet for the setSettings method.
  ///
  /// setSettings with minimal parameters
  /// </summary>
  public async Task SnippetForSetSettings0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string indexName0 = "cts_e2e_settings";
    var indexSettings0 = new IndexSettings();
    {
      const int paginationLimitedTo1 = 10;
      indexSettings0.PaginationLimitedTo = paginationLimitedTo1;
    }
    const bool forwardToReplicas0 = true;


    var response = await _client.SetSettingsAsync(indexName0, indexSettings0, forwardToReplicas0);
  }

  /// <summary>
  /// Snippet for the updateApiKey method.
  ///
  /// updateApiKey0
  /// </summary>
  public async Task SnippetForUpdateApiKey0()
  {
    // Initialize the client
    var client = new SearchClient(new SearchConfig("YOUR_APP_ID", "YOUR_API_KEY"));

    // Call the API
    const string key0 = "myApiKey";
    var apiKey0 = new ApiKey();
    {
      var acl1 = new List<Acl>();
      var acl_02 = (Acl)Enum.Parse(typeof(Acl), "Search");
      acl1.Add(acl_02); var acl_12 = (Acl)Enum.Parse(typeof(Acl), "AddObject");
      acl1.Add(acl_12);
      apiKey0.Acl = acl1; const int validity1 = 300;
      apiKey0.Validity = validity1; const int maxQueriesPerIPPerHour1 = 100;
      apiKey0.MaxQueriesPerIPPerHour = maxQueriesPerIPPerHour1; const int maxHitsPerQuery1 = 20;
      apiKey0.MaxHitsPerQuery = maxHitsPerQuery1;
    }


    var response = await _client.UpdateApiKeyAsync(key0, apiKey0);
  }

}
