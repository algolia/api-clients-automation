import 'package:algolia_client_search/algolia_client_search.dart';

// Snippet for the addApiKey method.
//
// addApiKey0
void snippetForaddApiKey() async {
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
}

// Snippet for the addOrUpdateObject method.
//
// addOrUpdateObject0
void snippetForaddOrUpdateObject() async {
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
}

// Snippet for the appendSource method.
//
// appendSource0
void snippetForappendSource() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.appendSource(
    source: Source(
      source: "theSource",
      description: "theDescription",
    ),
  );
}

// Snippet for the assignUserId method.
//
// assignUserId0
void snippetForassignUserId() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.assignUserId(
    xAlgoliaUserID: "userID",
    assignUserIdParams: AssignUserIdParams(
      cluster: "theCluster",
    ),
  );
}

// Snippet for the batch method.
//
// allows batch method with `addObject` action
void snippetForbatch() async {
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
}

// Snippet for the batchAssignUserIds method.
//
// batchAssignUserIds0
void snippetForbatchAssignUserIds() async {
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
}

// Snippet for the batchDictionaryEntries method.
//
// get batchDictionaryEntries results with minimal parameters
void snippetForbatchDictionaryEntries() async {
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
}

// Snippet for the browse method.
//
// browse with minimal parameters
void snippetForbrowse() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.browse(
    indexName: "cts_e2e_browse",
  );
}

// Snippet for the clearObjects method.
//
// clearObjects0
void snippetForclearObjects() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.clearObjects(
    indexName: "theIndexName",
  );
}

// Snippet for the clearRules method.
//
// clearRules0
void snippetForclearRules() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.clearRules(
    indexName: "indexName",
  );
}

// Snippet for the clearSynonyms method.
//
// clearSynonyms0
void snippetForclearSynonyms() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.clearSynonyms(
    indexName: "indexName",
  );
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
void snippetForcustomDelete() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customDelete(
    path: "/test/minimal",
  );
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
void snippetForcustomGet() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customGet(
    path: "/test/minimal",
  );
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
void snippetForcustomPost() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customPost(
    path: "/test/minimal",
  );
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
void snippetForcustomPut() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customPut(
    path: "/test/minimal",
  );
}

// Snippet for the deleteApiKey method.
//
// deleteApiKey0
void snippetFordeleteApiKey() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteApiKey(
    key: "myTestApiKey",
  );
}

// Snippet for the deleteBy method.
//
// deleteBy0
void snippetFordeleteBy() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteBy(
    indexName: "theIndexName",
    deleteByParams: DeleteByParams(
      filters: "brand:brandName",
    ),
  );
}

// Snippet for the deleteIndex method.
//
// deleteIndex0
void snippetFordeleteIndex() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteIndex(
    indexName: "theIndexName",
  );
}

// Snippet for the deleteObject method.
//
// deleteObject0
void snippetFordeleteObject() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteObject(
    indexName: "theIndexName",
    objectID: "uniqueID",
  );
}

// Snippet for the deleteRule method.
//
// delete rule simple case
void snippetFordeleteRule() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteRule(
    indexName: "indexName",
    objectID: "id1",
  );
}

// Snippet for the deleteSource method.
//
// deleteSource0
void snippetFordeleteSource() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteSource(
    source: "theSource",
  );
}

// Snippet for the deleteSynonym method.
//
// deleteSynonym0
void snippetFordeleteSynonym() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteSynonym(
    indexName: "indexName",
    objectID: "id1",
  );
}

// Snippet for the getApiKey method.
//
// getApiKey0
void snippetForgetApiKey() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getApiKey(
    key: "myTestApiKey",
  );
}

// Snippet for the getDictionaryLanguages method.
//
// get getDictionaryLanguages
void snippetForgetDictionaryLanguages() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getDictionaryLanguages();
}

// Snippet for the getDictionarySettings method.
//
// get getDictionarySettings results
void snippetForgetDictionarySettings() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getDictionarySettings();
}

// Snippet for the getLogs method.
//
// getLogs with minimal parameters
void snippetForgetLogs() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getLogs();
}

// Snippet for the getObject method.
//
// getObject0
void snippetForgetObject() async {
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
}

// Snippet for the getObjects method.
//
// getObjects0
void snippetForgetObjects() async {
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
}

// Snippet for the getRule method.
//
// getRule0
void snippetForgetRule() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getRule(
    indexName: "indexName",
    objectID: "id1",
  );
}

// Snippet for the getSettings method.
//
// getSettings0
void snippetForgetSettings() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getSettings(
    indexName: "cts_e2e_settings",
  );
}

// Snippet for the getSources method.
//
// getSources0
void snippetForgetSources() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getSources();
}

// Snippet for the getSynonym method.
//
// getSynonym0
void snippetForgetSynonym() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getSynonym(
    indexName: "indexName",
    objectID: "id1",
  );
}

// Snippet for the getTask method.
//
// getTask0
void snippetForgetTask() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getTask(
    indexName: "theIndexName",
    taskID: 123,
  );
}

// Snippet for the getTopUserIds method.
//
// getTopUserIds0
void snippetForgetTopUserIds() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getTopUserIds();
}

// Snippet for the getUserId method.
//
// getUserId0
void snippetForgetUserId() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getUserId(
    userID: "uniqueID",
  );
}

// Snippet for the hasPendingMappings method.
//
// hasPendingMappings with minimal parameters
void snippetForhasPendingMappings() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.hasPendingMappings();
}

// Snippet for the listApiKeys method.
//
// listApiKeys0
void snippetForlistApiKeys() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.listApiKeys();
}

// Snippet for the listClusters method.
//
// listClusters0
void snippetForlistClusters() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.listClusters();
}

// Snippet for the listIndices method.
//
// listIndices with minimal parameters
void snippetForlistIndices() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.listIndices();
}

// Snippet for the listUserIds method.
//
// listUserIds with minimal parameters
void snippetForlistUserIds() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.listUserIds();
}

// Snippet for the multipleBatch method.
//
// multipleBatch0
void snippetFormultipleBatch() async {
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
}

// Snippet for the operationIndex method.
//
// operationIndex0
void snippetForoperationIndex() async {
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
}

// Snippet for the partialUpdateObject method.
//
// partialUpdateObject0
void snippetForpartialUpdateObject() async {
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
}

// Snippet for the removeUserId method.
//
// removeUserId0
void snippetForremoveUserId() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.removeUserId(
    userID: "uniqueID",
  );
}

// Snippet for the replaceSources method.
//
// replaceSources0
void snippetForreplaceSources() async {
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
}

// Snippet for the restoreApiKey method.
//
// restoreApiKey0
void snippetForrestoreApiKey() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.restoreApiKey(
    key: "myApiKey",
  );
}

// Snippet for the saveObject method.
//
// saveObject0
void snippetForsaveObject() async {
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
}

// Snippet for the saveRule method.
//
// saveRule with minimal parameters
void snippetForsaveRule() async {
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
}

// Snippet for the saveRules method.
//
// saveRules with minimal parameters
void snippetForsaveRules() async {
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
}

// Snippet for the saveSynonym method.
//
// saveSynonym0
void snippetForsaveSynonym() async {
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
}

// Snippet for the saveSynonyms method.
//
// saveSynonyms0
void snippetForsaveSynonyms() async {
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
}

// Snippet for the search method.
//
// search for a single hits request with minimal parameters
void snippetForsearch() async {
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
}

// Snippet for the searchDictionaryEntries method.
//
// get searchDictionaryEntries results with minimal parameters
void snippetForsearchDictionaryEntries() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchDictionaryEntries(
    dictionaryName: DictionaryType.fromJson("compounds"),
    searchDictionaryEntriesParams: SearchDictionaryEntriesParams(
      query: "foo",
    ),
  );
}

// Snippet for the searchForFacetValues method.
//
// get searchForFacetValues results with minimal parameters
void snippetForsearchForFacetValues() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchForFacetValues(
    indexName: "indexName",
    facetName: "facetName",
  );
}

// Snippet for the searchRules method.
//
// searchRules0
void snippetForsearchRules() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchRules(
    indexName: "indexName",
    searchRulesParams: SearchRulesParams(
      query: "something",
    ),
  );
}

// Snippet for the searchSingleIndex method.
//
// search with minimal parameters
void snippetForsearchSingleIndex() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchSingleIndex(
    indexName: "indexName",
  );
}

// Snippet for the searchSynonyms method.
//
// searchSynonyms with minimal parameters
void snippetForsearchSynonyms() async {
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchSynonyms(
    indexName: "indexName",
  );
}

// Snippet for the searchUserIds method.
//
// searchUserIds0
void snippetForsearchUserIds() async {
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
}

// Snippet for the setDictionarySettings method.
//
// get setDictionarySettings results with minimal parameters
void snippetForsetDictionarySettings() async {
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
}

// Snippet for the setSettings method.
//
// setSettings with minimal parameters
void snippetForsetSettings() async {
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
}

// Snippet for the updateApiKey method.
//
// updateApiKey0
void snippetForupdateApiKey() async {
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
}
