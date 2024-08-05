// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint no-console: ["error", { allow: ["log"] }] */

// >IMPORT
import { searchClient } from '@algolia/client-search';
// IMPORT<

// Snippet for the addApiKey method.
//
// addApiKey
export async function snippetForAddApiKey(): Promise<void> {
  // >SEPARATOR addApiKey default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.addApiKey({
    acl: ['search', 'addObject'],
    description: 'my new api key',
    validity: 300,
    maxQueriesPerIPPerHour: 100,
    maxHitsPerQuery: 20,
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the addOrUpdateObject method.
//
// addOrUpdateObject
export async function snippetForAddOrUpdateObject(): Promise<void> {
  // >SEPARATOR addOrUpdateObject default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.addOrUpdateObject({
    indexName: 'indexName',
    objectID: 'uniqueID',
    body: { key: 'value' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the appendSource method.
//
// appendSource
export async function snippetForAppendSource(): Promise<void> {
  // >SEPARATOR appendSource default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.appendSource({
    source: 'theSource',
    description: 'theDescription',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the assignUserId method.
//
// assignUserId
export async function snippetForAssignUserId(): Promise<void> {
  // >SEPARATOR assignUserId default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.assignUserId({
    xAlgoliaUserID: 'userID',
    assignUserIdParams: { cluster: 'theCluster' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batch method.
//
// addObject
export async function snippetForBatch(): Promise<void> {
  // >SEPARATOR batch addObject
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batch({
    indexName: '<YOUR_INDEX_NAME>',
    batchWriteParams: {
      requests: [
        { action: 'addObject', body: { key: 'bar', foo: '1' } },
        { action: 'addObject', body: { key: 'baz', foo: '2' } },
      ],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batch method.
//
// clear
export async function snippetForBatch1(): Promise<void> {
  // >SEPARATOR batch clear
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batch({
    indexName: '<YOUR_INDEX_NAME>',
    batchWriteParams: {
      requests: [{ action: 'clear', body: { key: 'value' } }],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batch method.
//
// delete
export async function snippetForBatch2(): Promise<void> {
  // >SEPARATOR batch delete
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batch({
    indexName: '<YOUR_INDEX_NAME>',
    batchWriteParams: {
      requests: [{ action: 'delete', body: { key: 'value' } }],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batch method.
//
// deleteObject
export async function snippetForBatch3(): Promise<void> {
  // >SEPARATOR batch deleteObject
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batch({
    indexName: '<YOUR_INDEX_NAME>',
    batchWriteParams: {
      requests: [{ action: 'deleteObject', body: { key: 'value' } }],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batch method.
//
// partialUpdateObject
export async function snippetForBatch4(): Promise<void> {
  // >SEPARATOR batch partialUpdateObject
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batch({
    indexName: '<YOUR_INDEX_NAME>',
    batchWriteParams: {
      requests: [{ action: 'partialUpdateObject', body: { key: 'value' } }],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batch method.
//
// partialUpdateObjectNoCreate
export async function snippetForBatch5(): Promise<void> {
  // >SEPARATOR batch partialUpdateObjectNoCreate
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batch({
    indexName: '<YOUR_INDEX_NAME>',
    batchWriteParams: {
      requests: [
        { action: 'partialUpdateObjectNoCreate', body: { key: 'value' } },
      ],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batch method.
//
// updateObject
export async function snippetForBatch6(): Promise<void> {
  // >SEPARATOR batch updateObject
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batch({
    indexName: '<YOUR_INDEX_NAME>',
    batchWriteParams: {
      requests: [{ action: 'updateObject', body: { key: 'value' } }],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batchAssignUserIds method.
//
// batchAssignUserIds
export async function snippetForBatchAssignUserIds(): Promise<void> {
  // >SEPARATOR batchAssignUserIds default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batchAssignUserIds({
    xAlgoliaUserID: 'userID',
    batchAssignUserIdsParams: {
      cluster: 'theCluster',
      users: ['user1', 'user2'],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batchDictionaryEntries method.
//
// replace
export async function snippetForBatchDictionaryEntries(): Promise<void> {
  // >SEPARATOR batchDictionaryEntries replace
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batchDictionaryEntries({
    dictionaryName: 'plurals',
    batchDictionaryEntriesParams: {
      clearExistingDictionaryEntries: true,
      requests: [
        {
          action: 'addEntry',
          body: {
            objectID: '1',
            language: 'en',
            word: 'fancy',
            words: ['believe', 'algolia'],
            decomposition: ['trust', 'algolia'],
            state: 'enabled',
          },
        },
      ],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batchDictionaryEntries method.
//
// delete
export async function snippetForBatchDictionaryEntries1(): Promise<void> {
  // >SEPARATOR batchDictionaryEntries delete
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batchDictionaryEntries({
    dictionaryName: 'plurals',
    batchDictionaryEntriesParams: {
      clearExistingDictionaryEntries: true,
      requests: [{ action: 'deleteEntry', body: { objectID: '1' } }],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batchDictionaryEntries method.
//
// append
export async function snippetForBatchDictionaryEntries2(): Promise<void> {
  // >SEPARATOR batchDictionaryEntries append
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batchDictionaryEntries({
    dictionaryName: 'stopwords',
    batchDictionaryEntriesParams: {
      requests: [
        {
          action: 'addEntry',
          body: { objectID: '1', language: 'en', additional: 'try me' },
        },
      ],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the browse method.
//
// browse with minimal parameters
export async function snippetForBrowse(): Promise<void> {
  // >SEPARATOR browse default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.browse({ indexName: 'cts_e2e_browse' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the clearObjects method.
//
// clearObjects
export async function snippetForClearObjects(): Promise<void> {
  // >SEPARATOR clearObjects default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.clearObjects({ indexName: 'theIndexName' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the clearRules method.
//
// clearRules
export async function snippetForClearRules(): Promise<void> {
  // >SEPARATOR clearRules default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.clearRules({ indexName: 'indexName' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the clearSynonyms method.
//
// clearSynonyms
export async function snippetForClearSynonyms(): Promise<void> {
  // >SEPARATOR clearSynonyms default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.clearSynonyms({ indexName: 'indexName' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForCustomDelete(): Promise<void> {
  // >SEPARATOR customDelete default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customDelete({ path: 'test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
export async function snippetForCustomGet(): Promise<void> {
  // >SEPARATOR customGet default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customGet({ path: 'test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
export async function snippetForCustomPost(): Promise<void> {
  // >SEPARATOR customPost default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customPost({ path: 'test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
export async function snippetForCustomPut(): Promise<void> {
  // >SEPARATOR customPut default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customPut({ path: 'test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteApiKey method.
//
// deleteApiKey
export async function snippetForDeleteApiKey(): Promise<void> {
  // >SEPARATOR deleteApiKey default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.deleteApiKey({ key: 'myTestApiKey' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteBy method.
//
// deleteBy
export async function snippetForDeleteBy(): Promise<void> {
  // >SEPARATOR deleteBy default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.deleteBy({
    indexName: 'theIndexName',
    deleteByParams: { filters: 'brand:brandName' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteIndex method.
//
// deleteIndex
export async function snippetForDeleteIndex(): Promise<void> {
  // >SEPARATOR deleteIndex default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.deleteIndex({ indexName: 'theIndexName' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteObject method.
//
// deleteObject
export async function snippetForDeleteObject(): Promise<void> {
  // >SEPARATOR deleteObject default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.deleteObject({
    indexName: '<YOUR_INDEX_NAME>',
    objectID: 'uniqueID',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteRule method.
//
// delete rule simple case
export async function snippetForDeleteRule(): Promise<void> {
  // >SEPARATOR deleteRule default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.deleteRule({
    indexName: 'indexName',
    objectID: 'id1',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteSource method.
//
// deleteSource
export async function snippetForDeleteSource(): Promise<void> {
  // >SEPARATOR deleteSource default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.deleteSource({ source: 'theSource' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteSynonym method.
//
// deleteSynonym
export async function snippetForDeleteSynonym(): Promise<void> {
  // >SEPARATOR deleteSynonym default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.deleteSynonym({
    indexName: 'indexName',
    objectID: 'id1',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getApiKey method.
//
// getApiKey
export async function snippetForGetApiKey(): Promise<void> {
  // >SEPARATOR getApiKey default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getApiKey({ key: 'myTestApiKey' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getAppTask method.
//
// getAppTask
export async function snippetForGetAppTask(): Promise<void> {
  // >SEPARATOR getAppTask default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getAppTask({ taskID: 123 });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getDictionaryLanguages method.
//
// get getDictionaryLanguages
export async function snippetForGetDictionaryLanguages(): Promise<void> {
  // >SEPARATOR getDictionaryLanguages default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getDictionaryLanguages();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getDictionarySettings method.
//
// get getDictionarySettings results
export async function snippetForGetDictionarySettings(): Promise<void> {
  // >SEPARATOR getDictionarySettings default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getDictionarySettings();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getLogs method.
//
// getLogs with minimal parameters
export async function snippetForGetLogs(): Promise<void> {
  // >SEPARATOR getLogs default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getLogs();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getObject method.
//
// getObject
export async function snippetForGetObject(): Promise<void> {
  // >SEPARATOR getObject default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getObject({
    indexName: 'theIndexName',
    objectID: 'uniqueID',
    attributesToRetrieve: ['attr1', 'attr2'],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getObjects method.
//
// getObjects
export async function snippetForGetObjects(): Promise<void> {
  // >SEPARATOR getObjects default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getObjects({
    requests: [
      {
        attributesToRetrieve: ['attr1', 'attr2'],
        objectID: 'uniqueID',
        indexName: 'theIndexName',
      },
    ],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getRule method.
//
// getRule
export async function snippetForGetRule(): Promise<void> {
  // >SEPARATOR getRule default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getRule({
    indexName: 'indexName',
    objectID: 'id1',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getSettings method.
//
// getSettings
export async function snippetForGetSettings(): Promise<void> {
  // >SEPARATOR getSettings default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getSettings({ indexName: 'cts_e2e_settings' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getSources method.
//
// getSources
export async function snippetForGetSources(): Promise<void> {
  // >SEPARATOR getSources default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getSources();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getSynonym method.
//
// getSynonym
export async function snippetForGetSynonym(): Promise<void> {
  // >SEPARATOR getSynonym default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getSynonym({
    indexName: 'indexName',
    objectID: 'id1',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTask method.
//
// getTask
export async function snippetForGetTask(): Promise<void> {
  // >SEPARATOR getTask default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getTask({
    indexName: 'theIndexName',
    taskID: 123,
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTopUserIds method.
//
// getTopUserIds
export async function snippetForGetTopUserIds(): Promise<void> {
  // >SEPARATOR getTopUserIds default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getTopUserIds();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getUserId method.
//
// getUserId
export async function snippetForGetUserId(): Promise<void> {
  // >SEPARATOR getUserId default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getUserId({ userID: 'uniqueID' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the hasPendingMappings method.
//
// hasPendingMappings with minimal parameters
export async function snippetForHasPendingMappings(): Promise<void> {
  // >SEPARATOR hasPendingMappings default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.hasPendingMappings();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listApiKeys method.
//
// listApiKeys
export async function snippetForListApiKeys(): Promise<void> {
  // >SEPARATOR listApiKeys default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.listApiKeys();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listClusters method.
//
// listClusters
export async function snippetForListClusters(): Promise<void> {
  // >SEPARATOR listClusters default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.listClusters();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listIndices method.
//
// listIndices with minimal parameters
export async function snippetForListIndices(): Promise<void> {
  // >SEPARATOR listIndices default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.listIndices();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listUserIds method.
//
// listUserIds with minimal parameters
export async function snippetForListUserIds(): Promise<void> {
  // >SEPARATOR listUserIds default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.listUserIds();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the multipleBatch method.
//
// multipleBatch
export async function snippetForMultipleBatch(): Promise<void> {
  // >SEPARATOR multipleBatch default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.multipleBatch({
    requests: [
      {
        action: 'addObject',
        body: { key: 'value' },
        indexName: 'theIndexName',
      },
    ],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the operationIndex method.
//
// scopes
export async function snippetForOperationIndex(): Promise<void> {
  // >SEPARATOR operationIndex scopes
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.operationIndex({
    indexName: '<SOURCE_INDEX_NAME>',
    operationIndexParams: {
      operation: 'move',
      destination: '<DESTINATION_INDEX_NAME>',
      scope: ['rules', 'settings'],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the operationIndex method.
//
// copy
export async function snippetForOperationIndex1(): Promise<void> {
  // >SEPARATOR operationIndex copy
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.operationIndex({
    indexName: '<SOURCE_INDEX_NAME>',
    operationIndexParams: {
      operation: 'copy',
      destination: '<DESTINATION_INDEX_NAME>',
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the operationIndex method.
//
// move
export async function snippetForOperationIndex2(): Promise<void> {
  // >SEPARATOR operationIndex move
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.operationIndex({
    indexName: '<SOURCE_INDEX_NAME>',
    operationIndexParams: {
      operation: 'move',
      destination: '<DESTINATION_INDEX_NAME>',
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the partialUpdateObject method.
//
// Partial update with string value
export async function snippetForPartialUpdateObject(): Promise<void> {
  // >SEPARATOR partialUpdateObject default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.partialUpdateObject({
    indexName: 'theIndexName',
    objectID: 'uniqueID',
    attributesToUpdate: {
      id1: 'test',
      id2: { _operation: 'AddUnique', value: 'test2' },
    },
    createIfNotExists: true,
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the removeUserId method.
//
// removeUserId
export async function snippetForRemoveUserId(): Promise<void> {
  // >SEPARATOR removeUserId default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.removeUserId({ userID: 'uniqueID' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the replaceSources method.
//
// replaceSources
export async function snippetForReplaceSources(): Promise<void> {
  // >SEPARATOR replaceSources default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.replaceSources({
    source: [{ source: 'theSource', description: 'theDescription' }],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the restoreApiKey method.
//
// restoreApiKey
export async function snippetForRestoreApiKey(): Promise<void> {
  // >SEPARATOR restoreApiKey default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.restoreApiKey({ key: 'myApiKey' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the saveObject method.
//
// saveObject
export async function snippetForSaveObject(): Promise<void> {
  // >SEPARATOR saveObject default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.saveObject({
    indexName: '<YOUR_INDEX_NAME>',
    body: { objectID: 'id', test: 'val' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the saveRule method.
//
// saveRule with minimal parameters
export async function snippetForSaveRule(): Promise<void> {
  // >SEPARATOR saveRule default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.saveRule({
    indexName: 'indexName',
    objectID: 'id1',
    rule: {
      objectID: 'id1',
      conditions: [{ pattern: 'apple', anchoring: 'contains' }],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the saveRules method.
//
// saveRules with minimal parameters
export async function snippetForSaveRules(): Promise<void> {
  // >SEPARATOR saveRules default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.saveRules({
    indexName: '<YOUR_INDEX_NAME>',
    rules: [
      {
        objectID: 'a-rule-id',
        conditions: [{ pattern: 'smartphone', anchoring: 'contains' }],
      },
      {
        objectID: 'a-second-rule-id',
        conditions: [{ pattern: 'apple', anchoring: 'contains' }],
      },
    ],
    forwardToReplicas: false,
    clearExistingRules: true,
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the saveSynonym method.
//
// saveSynonym
export async function snippetForSaveSynonym(): Promise<void> {
  // >SEPARATOR saveSynonym default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.saveSynonym({
    indexName: 'indexName',
    objectID: 'id1',
    synonymHit: {
      objectID: 'id1',
      type: 'synonym',
      synonyms: ['car', 'vehicule', 'auto'],
    },
    forwardToReplicas: true,
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the saveSynonyms method.
//
// saveSynonyms
export async function snippetForSaveSynonyms(): Promise<void> {
  // >SEPARATOR saveSynonyms default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.saveSynonyms({
    indexName: '<YOUR_INDEX_NAME>',
    synonymHit: [
      {
        objectID: 'id1',
        type: 'synonym',
        synonyms: ['car', 'vehicule', 'auto'],
      },
      {
        objectID: 'id2',
        type: 'onewaysynonym',
        input: 'iphone',
        synonyms: ['ephone', 'aphone', 'yphone'],
      },
    ],
    forwardToReplicas: true,
    replaceExistingSynonyms: true,
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// withHitsPerPage
export async function snippetForSearch(): Promise<void> {
  // >SEPARATOR search withHitsPerPage
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [
      {
        indexName: '<YOUR_INDEX_NAME>',
        query: '<YOUR_QUERY>',
        hitsPerPage: 50,
      },
    ],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// filterOnly
export async function snippetForSearch1(): Promise<void> {
  // >SEPARATOR search filterOnly
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [
      {
        indexName: '<YOUR_INDEX_NAME>',
        query: '<YOUR_QUERY>',
        filters: 'actor:Scarlett Johansson',
      },
    ],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// filterOr
export async function snippetForSearch2(): Promise<void> {
  // >SEPARATOR search filterOr
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [
      {
        indexName: '<YOUR_INDEX_NAME>',
        query: '<YOUR_QUERY>',
        filters: 'actor:Tom Cruise OR actor:Scarlett Johansson',
      },
    ],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// filterNot
export async function snippetForSearch3(): Promise<void> {
  // >SEPARATOR search filterNot
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [
      {
        indexName: '<YOUR_INDEX_NAME>',
        query: '<YOUR_QUERY>',
        filters: 'NOT actor:Nicolas Cage',
      },
    ],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// retrieveFacets
export async function snippetForSearch5(): Promise<void> {
  // >SEPARATOR search retrieveFacets
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [
      {
        indexName: '<YOUR_INDEX_NAME>',
        query: '<YOUR_QUERY>',
        facets: ['author', 'genre'],
      },
    ],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// retrieveFacetsWildcard
export async function snippetForSearch6(): Promise<void> {
  // >SEPARATOR search retrieveFacetsWildcard
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [
      { indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', facets: ['*'] },
    ],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchDictionaryEntries method.
//
// get searchDictionaryEntries results with minimal parameters
export async function snippetForSearchDictionaryEntries(): Promise<void> {
  // >SEPARATOR searchDictionaryEntries default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.searchDictionaryEntries({
    dictionaryName: 'stopwords',
    searchDictionaryEntriesParams: { query: 'about' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchForFacetValues method.
//
// get searchForFacetValues results with minimal parameters
export async function snippetForSearchForFacetValues(): Promise<void> {
  // >SEPARATOR searchForFacetValues default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.searchForFacetValues({
    indexName: 'indexName',
    facetName: 'facetName',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchRules method.
//
// searchRules
export async function snippetForSearchRules(): Promise<void> {
  // >SEPARATOR searchRules default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.searchRules({
    indexName: 'indexName',
    searchRulesParams: { query: 'something' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchSingleIndex method.
//
// search with minimal parameters
export async function snippetForSearchSingleIndex(): Promise<void> {
  // >SEPARATOR searchSingleIndex default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.searchSingleIndex({ indexName: 'indexName' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchSynonyms method.
//
// searchSynonyms with minimal parameters
export async function snippetForSearchSynonyms(): Promise<void> {
  // >SEPARATOR searchSynonyms default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.searchSynonyms({ indexName: 'indexName' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchUserIds method.
//
// searchUserIds
export async function snippetForSearchUserIds(): Promise<void> {
  // >SEPARATOR searchUserIds default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.searchUserIds({
    query: 'test',
    clusterName: 'theClusterName',
    page: 5,
    hitsPerPage: 10,
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the setDictionarySettings method.
//
// get setDictionarySettings results with minimal parameters
export async function snippetForSetDictionarySettings(): Promise<void> {
  // >SEPARATOR setDictionarySettings default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.setDictionarySettings({
    disableStandardEntries: { plurals: { fr: false, en: false, ru: true } },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the setSettings method.
//
// setSettingsAttributesForFaceting
export async function snippetForSetSettings(): Promise<void> {
  // >SEPARATOR setSettings setSettingsAttributesForFaceting
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.setSettings({
    indexName: '<YOUR_INDEX_NAME>',
    indexSettings: {
      attributesForFaceting: [
        'actor',
        'filterOnly(category)',
        'searchable(publisher)',
      ],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the updateApiKey method.
//
// updateApiKey
export async function snippetForUpdateApiKey(): Promise<void> {
  // >SEPARATOR updateApiKey default
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.updateApiKey({
    key: 'myApiKey',
    apiKey: {
      acl: ['search', 'addObject'],
      validity: 300,
      maxQueriesPerIPPerHour: 100,
      maxHitsPerQuery: 20,
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}
