// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// >IMPORT
import 'package:algolia_client_search/algolia_client_search.dart';
// IMPORT<

// Snippet for the addApiKey method.
//
// addApiKey
void snippetForaddApiKey() async {
  // >SEPARATOR addApiKey default
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
// addOrUpdateObject
void snippetForaddOrUpdateObject() async {
  // >SEPARATOR addOrUpdateObject default
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
// appendSource
void snippetForappendSource() async {
  // >SEPARATOR appendSource default
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
// assignUserId
void snippetForassignUserId() async {
  // >SEPARATOR assignUserId default
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
// addObject
void snippetForbatch() async {
  // >SEPARATOR batch addObject
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batch(
    indexName: "<YOUR_INDEX_NAME>",
    batchWriteParams: BatchWriteParams(
      requests: [
        BatchRequest(
          action: Action.fromJson("addObject"),
          body: {
            'key': "bar",
            'foo': "1",
          },
        ),
        BatchRequest(
          action: Action.fromJson("addObject"),
          body: {
            'key': "baz",
            'foo': "2",
          },
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the batch method.
//
// clear
void snippetForbatch1() async {
  // >SEPARATOR batch clear
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batch(
    indexName: "<YOUR_INDEX_NAME>",
    batchWriteParams: BatchWriteParams(
      requests: [
        BatchRequest(
          action: Action.fromJson("clear"),
          body: {
            'key': "value",
          },
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the batch method.
//
// delete
void snippetForbatch2() async {
  // >SEPARATOR batch delete
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batch(
    indexName: "<YOUR_INDEX_NAME>",
    batchWriteParams: BatchWriteParams(
      requests: [
        BatchRequest(
          action: Action.fromJson("delete"),
          body: {
            'key': "value",
          },
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the batch method.
//
// deleteObject
void snippetForbatch3() async {
  // >SEPARATOR batch deleteObject
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batch(
    indexName: "<YOUR_INDEX_NAME>",
    batchWriteParams: BatchWriteParams(
      requests: [
        BatchRequest(
          action: Action.fromJson("deleteObject"),
          body: {
            'key': "value",
          },
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the batch method.
//
// partialUpdateObject
void snippetForbatch4() async {
  // >SEPARATOR batch partialUpdateObject
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batch(
    indexName: "<YOUR_INDEX_NAME>",
    batchWriteParams: BatchWriteParams(
      requests: [
        BatchRequest(
          action: Action.fromJson("partialUpdateObject"),
          body: {
            'key': "value",
          },
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the batch method.
//
// partialUpdateObjectNoCreate
void snippetForbatch5() async {
  // >SEPARATOR batch partialUpdateObjectNoCreate
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batch(
    indexName: "<YOUR_INDEX_NAME>",
    batchWriteParams: BatchWriteParams(
      requests: [
        BatchRequest(
          action: Action.fromJson("partialUpdateObjectNoCreate"),
          body: {
            'key': "value",
          },
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the batch method.
//
// updateObject
void snippetForbatch6() async {
  // >SEPARATOR batch updateObject
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batch(
    indexName: "<YOUR_INDEX_NAME>",
    batchWriteParams: BatchWriteParams(
      requests: [
        BatchRequest(
          action: Action.fromJson("updateObject"),
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
// batchAssignUserIds
void snippetForbatchAssignUserIds() async {
  // >SEPARATOR batchAssignUserIds default
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
// replace
void snippetForbatchDictionaryEntries() async {
  // >SEPARATOR batchDictionaryEntries replace
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batchDictionaryEntries(
    dictionaryName: DictionaryType.fromJson("plurals"),
    batchDictionaryEntriesParams: BatchDictionaryEntriesParams(
      clearExistingDictionaryEntries: true,
      requests: [
        BatchDictionaryEntriesRequest(
          action: DictionaryAction.fromJson("addEntry"),
          body: DictionaryEntry(
            objectID: "1",
            language: SupportedLanguage.fromJson("en"),
            word: "fancy",
            words: [
              "believe",
              "algolia",
            ],
            decomposition: [
              "trust",
              "algolia",
            ],
            state: DictionaryEntryState.fromJson("enabled"),
          ),
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the batchDictionaryEntries method.
//
// delete
void snippetForbatchDictionaryEntries1() async {
  // >SEPARATOR batchDictionaryEntries delete
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batchDictionaryEntries(
    dictionaryName: DictionaryType.fromJson("plurals"),
    batchDictionaryEntriesParams: BatchDictionaryEntriesParams(
      clearExistingDictionaryEntries: true,
      requests: [
        BatchDictionaryEntriesRequest(
          action: DictionaryAction.fromJson("deleteEntry"),
          body: DictionaryEntry(
            objectID: "1",
          ),
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the batchDictionaryEntries method.
//
// append
void snippetForbatchDictionaryEntries2() async {
  // >SEPARATOR batchDictionaryEntries append
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.batchDictionaryEntries(
    dictionaryName: DictionaryType.fromJson("stopwords"),
    batchDictionaryEntriesParams: BatchDictionaryEntriesParams(
      requests: [
        BatchDictionaryEntriesRequest(
          action: DictionaryAction.fromJson("addEntry"),
          body: DictionaryEntry(
            objectID: "1",
            language: SupportedLanguage.fromJson("en"),
            additionalProperties: {'additional': 'try me'},
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
  // >SEPARATOR browse default
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
// clearObjects
void snippetForclearObjects() async {
  // >SEPARATOR clearObjects default
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
// clearRules
void snippetForclearRules() async {
  // >SEPARATOR clearRules default
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
// clearSynonyms
void snippetForclearSynonyms() async {
  // >SEPARATOR clearSynonyms default
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
  // >SEPARATOR customDelete default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customDelete(
    path: "test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
void snippetForcustomGet() async {
  // >SEPARATOR customGet default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customGet(
    path: "test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
void snippetForcustomPost() async {
  // >SEPARATOR customPost default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customPost(
    path: "test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
void snippetForcustomPut() async {
  // >SEPARATOR customPut default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customPut(
    path: "test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the deleteApiKey method.
//
// deleteApiKey
void snippetFordeleteApiKey() async {
  // >SEPARATOR deleteApiKey default
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
// deleteBy
void snippetFordeleteBy() async {
  // >SEPARATOR deleteBy default
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
// deleteIndex
void snippetFordeleteIndex() async {
  // >SEPARATOR deleteIndex default
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
// deleteObject
void snippetFordeleteObject() async {
  // >SEPARATOR deleteObject default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteObject(
    indexName: "<YOUR_INDEX_NAME>",
    objectID: "uniqueID",
  );
  // SEPARATOR<
}

// Snippet for the deleteRule method.
//
// delete rule simple case
void snippetFordeleteRule() async {
  // >SEPARATOR deleteRule default
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
// deleteSource
void snippetFordeleteSource() async {
  // >SEPARATOR deleteSource default
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
// deleteSynonym
void snippetFordeleteSynonym() async {
  // >SEPARATOR deleteSynonym default
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
// getApiKey
void snippetForgetApiKey() async {
  // >SEPARATOR getApiKey default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getApiKey(
    key: "myTestApiKey",
  );
  // SEPARATOR<
}

// Snippet for the getAppTask method.
//
// getAppTask
void snippetForgetAppTask() async {
  // >SEPARATOR getAppTask default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getAppTask(
    taskID: 123,
  );
  // SEPARATOR<
}

// Snippet for the getDictionaryLanguages method.
//
// get getDictionaryLanguages
void snippetForgetDictionaryLanguages() async {
  // >SEPARATOR getDictionaryLanguages default
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
  // >SEPARATOR getDictionarySettings default
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
  // >SEPARATOR getLogs default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getLogs();
  // SEPARATOR<
}

// Snippet for the getObject method.
//
// getObject
void snippetForgetObject() async {
  // >SEPARATOR getObject default
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
// getObjects
void snippetForgetObjects() async {
  // >SEPARATOR getObjects default
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
// getRule
void snippetForgetRule() async {
  // >SEPARATOR getRule default
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
// getSettings
void snippetForgetSettings() async {
  // >SEPARATOR getSettings default
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
// getSources
void snippetForgetSources() async {
  // >SEPARATOR getSources default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getSources();
  // SEPARATOR<
}

// Snippet for the getSynonym method.
//
// getSynonym
void snippetForgetSynonym() async {
  // >SEPARATOR getSynonym default
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
// getTask
void snippetForgetTask() async {
  // >SEPARATOR getTask default
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
// getTopUserIds
void snippetForgetTopUserIds() async {
  // >SEPARATOR getTopUserIds default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getTopUserIds();
  // SEPARATOR<
}

// Snippet for the getUserId method.
//
// getUserId
void snippetForgetUserId() async {
  // >SEPARATOR getUserId default
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
  // >SEPARATOR hasPendingMappings default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.hasPendingMappings();
  // SEPARATOR<
}

// Snippet for the listApiKeys method.
//
// listApiKeys
void snippetForlistApiKeys() async {
  // >SEPARATOR listApiKeys default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.listApiKeys();
  // SEPARATOR<
}

// Snippet for the listClusters method.
//
// listClusters
void snippetForlistClusters() async {
  // >SEPARATOR listClusters default
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
  // >SEPARATOR listIndices default
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
  // >SEPARATOR listUserIds default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.listUserIds();
  // SEPARATOR<
}

// Snippet for the multipleBatch method.
//
// multipleBatch
void snippetFormultipleBatch() async {
  // >SEPARATOR multipleBatch default
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
// scopes
void snippetForoperationIndex() async {
  // >SEPARATOR operationIndex scopes
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.operationIndex(
    indexName: "<SOURCE_INDEX_NAME>",
    operationIndexParams: OperationIndexParams(
      operation: OperationType.fromJson("move"),
      destination: "<DESTINATION_INDEX_NAME>",
      scope: [
        ScopeType.fromJson("rules"),
        ScopeType.fromJson("settings"),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the operationIndex method.
//
// copy
void snippetForoperationIndex1() async {
  // >SEPARATOR operationIndex copy
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.operationIndex(
    indexName: "<SOURCE_INDEX_NAME>",
    operationIndexParams: OperationIndexParams(
      operation: OperationType.fromJson("copy"),
      destination: "<DESTINATION_INDEX_NAME>",
    ),
  );
  // SEPARATOR<
}

// Snippet for the operationIndex method.
//
// move
void snippetForoperationIndex2() async {
  // >SEPARATOR operationIndex move
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.operationIndex(
    indexName: "<SOURCE_INDEX_NAME>",
    operationIndexParams: OperationIndexParams(
      operation: OperationType.fromJson("move"),
      destination: "<DESTINATION_INDEX_NAME>",
    ),
  );
  // SEPARATOR<
}

// Snippet for the partialUpdateObject method.
//
// Partial update with string value
void snippetForpartialUpdateObject() async {
  // >SEPARATOR partialUpdateObject default
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
// removeUserId
void snippetForremoveUserId() async {
  // >SEPARATOR removeUserId default
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
// replaceSources
void snippetForreplaceSources() async {
  // >SEPARATOR replaceSources default
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
// restoreApiKey
void snippetForrestoreApiKey() async {
  // >SEPARATOR restoreApiKey default
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
// saveObject
void snippetForsaveObject() async {
  // >SEPARATOR saveObject default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.saveObject(
    indexName: "<YOUR_INDEX_NAME>",
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
  // >SEPARATOR saveRule default
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
  // >SEPARATOR saveRules default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.saveRules(
    indexName: "<YOUR_INDEX_NAME>",
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
    forwardToReplicas: false,
    clearExistingRules: true,
  );
  // SEPARATOR<
}

// Snippet for the saveSynonym method.
//
// saveSynonym
void snippetForsaveSynonym() async {
  // >SEPARATOR saveSynonym default
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
// saveSynonyms
void snippetForsaveSynonyms() async {
  // >SEPARATOR saveSynonyms default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.saveSynonyms(
    indexName: "<YOUR_INDEX_NAME>",
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
    replaceExistingSynonyms: true,
  );
  // SEPARATOR<
}

// Snippet for the search method.
//
// withHitsPerPage
void snippetForsearch() async {
  // >SEPARATOR search withHitsPerPage
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.search(
    searchMethodParams: SearchMethodParams(
      requests: [
        SearchForHits(
          indexName: "<YOUR_INDEX_NAME>",
          query: "<YOUR_QUERY>",
          hitsPerPage: 50,
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the search method.
//
// filterOnly
void snippetForsearch1() async {
  // >SEPARATOR search filterOnly
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.search(
    searchMethodParams: SearchMethodParams(
      requests: [
        SearchForHits(
          indexName: "<YOUR_INDEX_NAME>",
          query: "<YOUR_QUERY>",
          filters: "actor:Scarlett Johansson",
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the search method.
//
// filterOr
void snippetForsearch2() async {
  // >SEPARATOR search filterOr
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.search(
    searchMethodParams: SearchMethodParams(
      requests: [
        SearchForHits(
          indexName: "<YOUR_INDEX_NAME>",
          query: "<YOUR_QUERY>",
          filters: "actor:Tom Cruise OR actor:Scarlett Johansson",
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the search method.
//
// filterNot
void snippetForsearch3() async {
  // >SEPARATOR search filterNot
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.search(
    searchMethodParams: SearchMethodParams(
      requests: [
        SearchForHits(
          indexName: "<YOUR_INDEX_NAME>",
          query: "<YOUR_QUERY>",
          filters: "NOT actor:Nicolas Cage",
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the search method.
//
// retrieveFacets
void snippetForsearch5() async {
  // >SEPARATOR search retrieveFacets
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.search(
    searchMethodParams: SearchMethodParams(
      requests: [
        SearchForHits(
          indexName: "<YOUR_INDEX_NAME>",
          query: "<YOUR_QUERY>",
          facets: [
            "author",
            "genre",
          ],
        ),
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the search method.
//
// retrieveFacetsWildcard
void snippetForsearch6() async {
  // >SEPARATOR search retrieveFacetsWildcard
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.search(
    searchMethodParams: SearchMethodParams(
      requests: [
        SearchForHits(
          indexName: "<YOUR_INDEX_NAME>",
          query: "<YOUR_QUERY>",
          facets: [
            "*",
          ],
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
  // >SEPARATOR searchDictionaryEntries default
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchDictionaryEntries(
    dictionaryName: DictionaryType.fromJson("stopwords"),
    searchDictionaryEntriesParams: SearchDictionaryEntriesParams(
      query: "about",
    ),
  );
  // SEPARATOR<
}

// Snippet for the searchForFacetValues method.
//
// get searchForFacetValues results with minimal parameters
void snippetForsearchForFacetValues() async {
  // >SEPARATOR searchForFacetValues default
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
// searchRules
void snippetForsearchRules() async {
  // >SEPARATOR searchRules default
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
  // >SEPARATOR searchSingleIndex default
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
  // >SEPARATOR searchSynonyms default
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
// searchUserIds
void snippetForsearchUserIds() async {
  // >SEPARATOR searchUserIds default
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
  // >SEPARATOR setDictionarySettings default
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
// setSettingsAttributesForFaceting
void snippetForsetSettings() async {
  // >SEPARATOR setSettings setSettingsAttributesForFaceting
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.setSettings(
    indexName: "<YOUR_INDEX_NAME>",
    indexSettings: IndexSettings(
      attributesForFaceting: [
        "actor",
        "filterOnly(category)",
        "searchable(publisher)",
      ],
    ),
  );
  // SEPARATOR<
}

// Snippet for the updateApiKey method.
//
// updateApiKey
void snippetForupdateApiKey() async {
  // >SEPARATOR updateApiKey default
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
