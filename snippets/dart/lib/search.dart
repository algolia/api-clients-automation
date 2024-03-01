import 'package:algolia_client_search/algolia_client_search.dart';

// Snippet for the addApiKey method.
//
// addApiKey0
void snippetForaddApiKey() async {
  // >SEPARATOR addApiKey
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.addApiKey(
    apiKey: ApiKey(
      acl: [
        Acl.fromJson("search"),
        Acl.fromJson("addObject"),
      ],
      description: "my new api key",
      validity: 300,
      maxQueriesPerIPPerHour: 100,
      maxHitsPerQuery: 20,
    ),
  );
  // SEPARATOR<
}

// Snippet for the addOrUpdateObject method.
//
// addOrUpdateObject0
void snippetForaddOrUpdateObject() async {
  // >SEPARATOR addOrUpdateObject
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.addOrUpdateObject(
    indexName: "indexName",
    objectID: "uniqueID",
    body: {
      'key': "value",
    },
  );
  // SEPARATOR<
}

// Snippet for the appendSource method.
//
// appendSource0
void snippetForappendSource() async {
  // >SEPARATOR appendSource
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.appendSource(
    source: Source(
      source: "theSource",
      description: "theDescription",
    ),
  );
  // SEPARATOR<
}

// Snippet for the assignUserId method.
//
// assignUserId0
void snippetForassignUserId() async {
  // >SEPARATOR assignUserId
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.assignUserId(
    xAlgoliaUserID: "userID",
    assignUserIdParams: AssignUserIdParams(
      cluster: "theCluster",
    ),
  );
  // SEPARATOR<
}

// Snippet for the batch method.
//
// allows batch method with `addObject` action
void snippetForbatch() async {
  // >SEPARATOR batch
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batch(
    indexName: "theIndexName",
    batchWriteParams: BatchWriteParams(
      requests: [
        BatchRequest(
          action: Action.fromJson("addObject"),
          body: {
            'key': "value",
          },
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the batchAssignUserIds method.
//
// batchAssignUserIds0
void snippetForbatchAssignUserIds() async {
  // >SEPARATOR batchAssignUserIds
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batchAssignUserIds(
    xAlgoliaUserID: "userID",
    batchAssignUserIdsParams: BatchAssignUserIdsParams(
      cluster: "theCluster",
      users: [
        "user1",
        "user2",
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the batchDictionaryEntries method.
//
// get batchDictionaryEntries results with minimal parameters
void snippetForbatchDictionaryEntries() async {
  // >SEPARATOR batchDictionaryEntries
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batchDictionaryEntries(
    dictionaryName: DictionaryType.fromJson("compounds"),
    batchDictionaryEntriesParams: BatchDictionaryEntriesParams(
      requests: [
        BatchDictionaryEntriesRequest(
          action: DictionaryAction.fromJson("addEntry"),
          body: DictionaryEntry(
            objectID: "1",
            language: "en",
          ),
        ),
        BatchDictionaryEntriesRequest(
          action: DictionaryAction.fromJson("deleteEntry"),
          body: DictionaryEntry(
            objectID: "2",
            language: "fr",
          ),
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the browse method.
//
// browse with minimal parameters
void snippetForbrowse() async {
  // >SEPARATOR browse
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.browse(
    indexName: "cts_e2e_browse",
  );
  // SEPARATOR<
}

// Snippet for the clearObjects method.
//
// clearObjects0
void snippetForclearObjects() async {
  // >SEPARATOR clearObjects
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.clearObjects(
    indexName: "theIndexName",
  );
  // SEPARATOR<
}

// Snippet for the clearRules method.
//
// clearRules0
void snippetForclearRules() async {
  // >SEPARATOR clearRules
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.clearRules(
    indexName: "indexName",
  );
  // SEPARATOR<
}

// Snippet for the clearSynonyms method.
//
// clearSynonyms0
void snippetForclearSynonyms() async {
  // >SEPARATOR clearSynonyms
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.clearSynonyms(
    indexName: "indexName",
  );
  // SEPARATOR<
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
void snippetForcustomDelete() async {
  // >SEPARATOR customDelete
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customDelete(
    path: "/test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
void snippetForcustomGet() async {
  // >SEPARATOR customGet
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customGet(
    path: "/test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
void snippetForcustomPost() async {
  // >SEPARATOR customPost
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customPost(
    path: "/test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
void snippetForcustomPut() async {
  // >SEPARATOR customPut
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customPut(
    path: "/test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the deleteApiKey method.
//
// deleteApiKey0
void snippetFordeleteApiKey() async {
  // >SEPARATOR deleteApiKey
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteApiKey(
    key: "myTestApiKey",
  );
  // SEPARATOR<
}

// Snippet for the deleteBy method.
//
// deleteBy0
void snippetFordeleteBy() async {
  // >SEPARATOR deleteBy
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteBy(
    indexName: "theIndexName",
    deleteByParams: DeleteByParams(
      filters: "brand:brandName",
    ),
  );
  // SEPARATOR<
}

// Snippet for the deleteIndex method.
//
// deleteIndex0
void snippetFordeleteIndex() async {
  // >SEPARATOR deleteIndex
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteIndex(
    indexName: "theIndexName",
  );
  // SEPARATOR<
}

// Snippet for the deleteObject method.
//
// deleteObject0
void snippetFordeleteObject() async {
  // >SEPARATOR deleteObject
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteObject(
    indexName: "theIndexName",
    objectID: "uniqueID",
  );
  // SEPARATOR<
}

// Snippet for the deleteRule method.
//
// delete rule simple case
void snippetFordeleteRule() async {
  // >SEPARATOR deleteRule
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteRule(
    indexName: "indexName",
    objectID: "id1",
  );
  // SEPARATOR<
}

// Snippet for the deleteSource method.
//
// deleteSource0
void snippetFordeleteSource() async {
  // >SEPARATOR deleteSource
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteSource(
    source: "theSource",
  );
  // SEPARATOR<
}

// Snippet for the deleteSynonym method.
//
// deleteSynonym0
void snippetFordeleteSynonym() async {
  // >SEPARATOR deleteSynonym
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteSynonym(
    indexName: "indexName",
    objectID: "id1",
  );
  // SEPARATOR<
}

// Snippet for the getApiKey method.
//
// getApiKey0
void snippetForgetApiKey() async {
  // >SEPARATOR getApiKey
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getApiKey(
    key: "myTestApiKey",
  );
  // SEPARATOR<
}

// Snippet for the getDictionaryLanguages method.
//
// get getDictionaryLanguages
void snippetForgetDictionaryLanguages() async {
  // >SEPARATOR getDictionaryLanguages
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getDictionaryLanguages();
  // SEPARATOR<
}

// Snippet for the getDictionarySettings method.
//
// get getDictionarySettings results
void snippetForgetDictionarySettings() async {
  // >SEPARATOR getDictionarySettings
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getDictionarySettings();
  // SEPARATOR<
}

// Snippet for the getLogs method.
//
// getLogs with minimal parameters
void snippetForgetLogs() async {
  // >SEPARATOR getLogs
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getLogs();
  // SEPARATOR<
}

// Snippet for the getObject method.
//
// getObject0
void snippetForgetObject() async {
  // >SEPARATOR getObject
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getObject(
    indexName: "theIndexName",
    objectID: "uniqueID",
    attributesToRetrieve: [
      "attr1",
      "attr2",
    ],
  );
  // SEPARATOR<
}

// Snippet for the getObjects method.
//
// getObjects0
void snippetForgetObjects() async {
  // >SEPARATOR getObjects
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getObjects(
    getObjectsParams: GetObjectsParams(
      requests: [
        GetObjectsRequest(
          attributesToRetrieve: [
            "attr1",
            "attr2",
          ],
          objectID: "uniqueID",
          indexName: "theIndexName",
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the getRule method.
//
// getRule0
void snippetForgetRule() async {
  // >SEPARATOR getRule
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getRule(
    indexName: "indexName",
    objectID: "id1",
  );
  // SEPARATOR<
}

// Snippet for the getSettings method.
//
// getSettings0
void snippetForgetSettings() async {
  // >SEPARATOR getSettings
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getSettings(
    indexName: "cts_e2e_settings",
  );
  // SEPARATOR<
}

// Snippet for the getSources method.
//
// getSources0
void snippetForgetSources() async {
  // >SEPARATOR getSources
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getSources();
  // SEPARATOR<
}

// Snippet for the getSynonym method.
//
// getSynonym0
void snippetForgetSynonym() async {
  // >SEPARATOR getSynonym
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getSynonym(
    indexName: "indexName",
    objectID: "id1",
  );
  // SEPARATOR<
}

// Snippet for the getTask method.
//
// getTask0
void snippetForgetTask() async {
  // >SEPARATOR getTask
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getTask(
    indexName: "theIndexName",
    taskID: 123,
  );
  // SEPARATOR<
}

// Snippet for the getTopUserIds method.
//
// getTopUserIds0
void snippetForgetTopUserIds() async {
  // >SEPARATOR getTopUserIds
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getTopUserIds();
  // SEPARATOR<
}

// Snippet for the getUserId method.
//
// getUserId0
void snippetForgetUserId() async {
  // >SEPARATOR getUserId
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getUserId(
    userID: "uniqueID",
  );
  // SEPARATOR<
}

// Snippet for the hasPendingMappings method.
//
// hasPendingMappings with minimal parameters
void snippetForhasPendingMappings() async {
  // >SEPARATOR hasPendingMappings
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.hasPendingMappings();
  // SEPARATOR<
}

// Snippet for the listApiKeys method.
//
// listApiKeys0
void snippetForlistApiKeys() async {
  // >SEPARATOR listApiKeys
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.listApiKeys();
  // SEPARATOR<
}

// Snippet for the listClusters method.
//
// listClusters0
void snippetForlistClusters() async {
  // >SEPARATOR listClusters
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.listClusters();
  // SEPARATOR<
}

// Snippet for the listIndices method.
//
// listIndices with minimal parameters
void snippetForlistIndices() async {
  // >SEPARATOR listIndices
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.listIndices();
  // SEPARATOR<
}

// Snippet for the listUserIds method.
//
// listUserIds with minimal parameters
void snippetForlistUserIds() async {
  // >SEPARATOR listUserIds
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.listUserIds();
  // SEPARATOR<
}

// Snippet for the multipleBatch method.
//
// multipleBatch0
void snippetFormultipleBatch() async {
  // >SEPARATOR multipleBatch
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.multipleBatch(
    batchParams: BatchParams(
      requests: [
        MultipleBatchRequest(
          action: Action.fromJson("addObject"),
          body: {
            'key': "value",
          },
          indexName: "theIndexName",
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the operationIndex method.
//
// operationIndex0
void snippetForoperationIndex() async {
  // >SEPARATOR operationIndex
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.operationIndex(
    indexName: "theIndexName",
    operationIndexParams: OperationIndexParams(
      operation: OperationType.fromJson("copy"),
      destination: "dest",
      scope: [
        ScopeType.fromJson("rules"),
        ScopeType.fromJson("settings"),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the partialUpdateObject method.
//
// partialUpdateObject0
void snippetForpartialUpdateObject() async {
  // >SEPARATOR partialUpdateObject
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.partialUpdateObject(
    indexName: "theIndexName",
    objectID: "uniqueID",
    attributesToUpdate: {
      'id1': "test",
      'id2': BuiltInOperation(
        operation: BuiltInOperationType.fromJson("AddUnique"),
        value: "test2",
      ),
    },
    createIfNotExists: true,
  );
  // SEPARATOR<
}

// Snippet for the removeUserId method.
//
// removeUserId0
void snippetForremoveUserId() async {
  // >SEPARATOR removeUserId
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.removeUserId(
    userID: "uniqueID",
  );
  // SEPARATOR<
}

// Snippet for the replaceSources method.
//
// replaceSources0
void snippetForreplaceSources() async {
  // >SEPARATOR replaceSources
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.replaceSources(
    source: [
      Source(
        source: "theSource",
        description: "theDescription",
      ),
    ],
  );
  // SEPARATOR<
}

// Snippet for the restoreApiKey method.
//
// restoreApiKey0
void snippetForrestoreApiKey() async {
  // >SEPARATOR restoreApiKey
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.restoreApiKey(
    key: "myApiKey",
  );
  // SEPARATOR<
}

// Snippet for the saveObject method.
//
// saveObject0
void snippetForsaveObject() async {
  // >SEPARATOR saveObject
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.saveObject(
    indexName: "theIndexName",
    body: {
      'objectID': "id",
      'test': "val",
    },
  );
  // SEPARATOR<
}

// Snippet for the saveRule method.
//
// saveRule with minimal parameters
void snippetForsaveRule() async {
  // >SEPARATOR saveRule
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.saveRule(
    indexName: "indexName",
    objectID: "id1",
    rule: Rule(
      objectID: "id1",
      conditions: [
        Condition(
          pattern: "apple",
          anchoring: Anchoring.fromJson("contains"),
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the saveRules method.
//
// saveRules with minimal parameters
void snippetForsaveRules() async {
  // >SEPARATOR saveRules
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.saveRules(
    indexName: "indexName",
    rules: [
      Rule(
        objectID: "a-rule-id",
        conditions: [
          Condition(
            pattern: "smartphone",
            anchoring: Anchoring.fromJson("contains"),
          ),
        ],
      ),
      Rule(
        objectID: "a-second-rule-id",
        conditions: [
          Condition(
            pattern: "apple",
            anchoring: Anchoring.fromJson("contains"),
          ),
        ],
      ),
    ],
  );
  // SEPARATOR<
}

// Snippet for the saveSynonym method.
//
// saveSynonym0
void snippetForsaveSynonym() async {
  // >SEPARATOR saveSynonym
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.saveSynonym(
    indexName: "indexName",
    objectID: "id1",
    synonymHit: SynonymHit(
      objectID: "id1",
      type: SynonymType.fromJson("synonym"),
      synonyms: [
        "car",
        "vehicule",
        "auto",
      ],
    ),
    forwardToReplicas: true,
  );
  // SEPARATOR<
}

// Snippet for the saveSynonyms method.
//
// saveSynonyms0
void snippetForsaveSynonyms() async {
  // >SEPARATOR saveSynonyms
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.saveSynonyms(
    indexName: "indexName",
    synonymHit: [
      SynonymHit(
        objectID: "id1",
        type: SynonymType.fromJson("synonym"),
        synonyms: [
          "car",
          "vehicule",
          "auto",
        ],
      ),
      SynonymHit(
        objectID: "id2",
        type: SynonymType.fromJson("onewaysynonym"),
        input: "iphone",
        synonyms: [
          "ephone",
          "aphone",
          "yphone",
        ],
      ),
    ],
    forwardToReplicas: true,
    replaceExistingSynonyms: false,
  );
  // SEPARATOR<
}

// Snippet for the search method.
//
// search for a single hits request with minimal parameters
void snippetForsearch() async {
  // >SEPARATOR search
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.search(
    searchMethodParams: SearchMethodParams(
      requests: [
        SearchForHits(
          indexName: "cts_e2e_search_empty_index",
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the searchDictionaryEntries method.
//
// get searchDictionaryEntries results with minimal parameters
void snippetForsearchDictionaryEntries() async {
  // >SEPARATOR searchDictionaryEntries
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchDictionaryEntries(
    dictionaryName: DictionaryType.fromJson("compounds"),
    searchDictionaryEntriesParams: SearchDictionaryEntriesParams(
      query: "foo",
    ),
  );
  // SEPARATOR<
}

// Snippet for the searchForFacetValues method.
//
// get searchForFacetValues results with minimal parameters
void snippetForsearchForFacetValues() async {
  // >SEPARATOR searchForFacetValues
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchForFacetValues(
    indexName: "indexName",
    facetName: "facetName",
  );
  // SEPARATOR<
}

// Snippet for the searchRules method.
//
// searchRules0
void snippetForsearchRules() async {
  // >SEPARATOR searchRules
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchRules(
    indexName: "indexName",
    searchRulesParams: SearchRulesParams(
      query: "something",
    ),
  );
  // SEPARATOR<
}

// Snippet for the searchSingleIndex method.
//
// search with minimal parameters
void snippetForsearchSingleIndex() async {
  // >SEPARATOR searchSingleIndex
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchSingleIndex(
    indexName: "indexName",
  );
  // SEPARATOR<
}

// Snippet for the searchSynonyms method.
//
// searchSynonyms with minimal parameters
void snippetForsearchSynonyms() async {
  // >SEPARATOR searchSynonyms
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchSynonyms(
    indexName: "indexName",
  );
  // SEPARATOR<
}

// Snippet for the searchUserIds method.
//
// searchUserIds0
void snippetForsearchUserIds() async {
  // >SEPARATOR searchUserIds
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchUserIds(
    searchUserIdsParams: SearchUserIdsParams(
      query: "test",
      clusterName: "theClusterName",
      page: 5,
      hitsPerPage: 10,
    ),
  );
  // SEPARATOR<
}

// Snippet for the setDictionarySettings method.
//
// get setDictionarySettings results with minimal parameters
void snippetForsetDictionarySettings() async {
  // >SEPARATOR setDictionarySettings
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.setDictionarySettings(
    dictionarySettingsParams: DictionarySettingsParams(
      disableStandardEntries: StandardEntries(
        plurals: {
          'fr': false,
          'en': false,
          'ru': true,
        },
      ),
    ),
  );
  // SEPARATOR<
}

// Snippet for the setSettings method.
//
// setSettings with minimal parameters
void snippetForsetSettings() async {
  // >SEPARATOR setSettings
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.setSettings(
    indexName: "cts_e2e_settings",
    indexSettings: IndexSettings(
      paginationLimitedTo: 10,
    ),
    forwardToReplicas: true,
  );
  // SEPARATOR<
}

// Snippet for the updateApiKey method.
//
// updateApiKey0
void snippetForupdateApiKey() async {
  // >SEPARATOR updateApiKey
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.updateApiKey(
    key: "myApiKey",
    apiKey: ApiKey(
      acl: [
        Acl.fromJson("search"),
        Acl.fromJson("addObject"),
      ],
      validity: 300,
      maxQueriesPerIPPerHour: 100,
      maxHitsPerQuery: 20,
    ),
  );
  // SEPARATOR<
}
