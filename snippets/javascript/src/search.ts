/* eslint no-console: ["error", { allow: ["log"] }] */

import { searchClient } from '@algolia/client-search';

// Snippet for the addApiKey method.
//
// addApiKey0
export async function snippetForaddApiKey(): Promise<void> {
  // >SEPARATOR addApiKey
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
// addOrUpdateObject0
export async function snippetForaddOrUpdateObject(): Promise<void> {
  // >SEPARATOR addOrUpdateObject
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
// appendSource0
export async function snippetForappendSource(): Promise<void> {
  // >SEPARATOR appendSource
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
// assignUserId0
export async function snippetForassignUserId(): Promise<void> {
  // >SEPARATOR assignUserId
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
// allows batch method with `addObject` action
export async function snippetForbatch(): Promise<void> {
  // >SEPARATOR batch
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batch({
    indexName: 'theIndexName',
    batchWriteParams: {
      requests: [{ action: 'addObject', body: { key: 'value' } }],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the batchAssignUserIds method.
//
// batchAssignUserIds0
export async function snippetForbatchAssignUserIds(): Promise<void> {
  // >SEPARATOR batchAssignUserIds
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
// get batchDictionaryEntries results with minimal parameters
export async function snippetForbatchDictionaryEntries(): Promise<void> {
  // >SEPARATOR batchDictionaryEntries
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.batchDictionaryEntries({
    dictionaryName: 'compounds',
    batchDictionaryEntriesParams: {
      requests: [
        { action: 'addEntry', body: { objectID: '1', language: 'en' } },
        { action: 'deleteEntry', body: { objectID: '2', language: 'fr' } },
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
export async function snippetForbrowse(): Promise<void> {
  // >SEPARATOR browse
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
// clearObjects0
export async function snippetForclearObjects(): Promise<void> {
  // >SEPARATOR clearObjects
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
// clearRules0
export async function snippetForclearRules(): Promise<void> {
  // >SEPARATOR clearRules
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
// clearSynonyms0
export async function snippetForclearSynonyms(): Promise<void> {
  // >SEPARATOR clearSynonyms
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
export async function snippetForcustomDelete(): Promise<void> {
  // >SEPARATOR customDelete
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customDelete({ path: '/test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
export async function snippetForcustomGet(): Promise<void> {
  // >SEPARATOR customGet
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customGet({ path: '/test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
export async function snippetForcustomPost(): Promise<void> {
  // >SEPARATOR customPost
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customPost({ path: '/test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
export async function snippetForcustomPut(): Promise<void> {
  // >SEPARATOR customPut
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteApiKey method.
//
// deleteApiKey0
export async function snippetFordeleteApiKey(): Promise<void> {
  // >SEPARATOR deleteApiKey
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
// deleteBy0
export async function snippetFordeleteBy(): Promise<void> {
  // >SEPARATOR deleteBy
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
// deleteIndex0
export async function snippetFordeleteIndex(): Promise<void> {
  // >SEPARATOR deleteIndex
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
// deleteObject0
export async function snippetFordeleteObject(): Promise<void> {
  // >SEPARATOR deleteObject
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.deleteObject({
    indexName: 'theIndexName',
    objectID: 'uniqueID',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteRule method.
//
// delete rule simple case
export async function snippetFordeleteRule(): Promise<void> {
  // >SEPARATOR deleteRule
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
// deleteSource0
export async function snippetFordeleteSource(): Promise<void> {
  // >SEPARATOR deleteSource
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
// deleteSynonym0
export async function snippetFordeleteSynonym(): Promise<void> {
  // >SEPARATOR deleteSynonym
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
// getApiKey0
export async function snippetForgetApiKey(): Promise<void> {
  // >SEPARATOR getApiKey
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getApiKey({ key: 'myTestApiKey' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getDictionaryLanguages method.
//
// get getDictionaryLanguages
export async function snippetForgetDictionaryLanguages(): Promise<void> {
  // >SEPARATOR getDictionaryLanguages
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
export async function snippetForgetDictionarySettings(): Promise<void> {
  // >SEPARATOR getDictionarySettings
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
export async function snippetForgetLogs(): Promise<void> {
  // >SEPARATOR getLogs
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
// getObject0
export async function snippetForgetObject(): Promise<void> {
  // >SEPARATOR getObject
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
// getObjects0
export async function snippetForgetObjects(): Promise<void> {
  // >SEPARATOR getObjects
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
// getRule0
export async function snippetForgetRule(): Promise<void> {
  // >SEPARATOR getRule
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
// getSettings0
export async function snippetForgetSettings(): Promise<void> {
  // >SEPARATOR getSettings
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
// getSources0
export async function snippetForgetSources(): Promise<void> {
  // >SEPARATOR getSources
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
// getSynonym0
export async function snippetForgetSynonym(): Promise<void> {
  // >SEPARATOR getSynonym
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
// getTask0
export async function snippetForgetTask(): Promise<void> {
  // >SEPARATOR getTask
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
// getTopUserIds0
export async function snippetForgetTopUserIds(): Promise<void> {
  // >SEPARATOR getTopUserIds
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
// getUserId0
export async function snippetForgetUserId(): Promise<void> {
  // >SEPARATOR getUserId
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
export async function snippetForhasPendingMappings(): Promise<void> {
  // >SEPARATOR hasPendingMappings
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
// listApiKeys0
export async function snippetForlistApiKeys(): Promise<void> {
  // >SEPARATOR listApiKeys
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
// listClusters0
export async function snippetForlistClusters(): Promise<void> {
  // >SEPARATOR listClusters
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
export async function snippetForlistIndices(): Promise<void> {
  // >SEPARATOR listIndices
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
export async function snippetForlistUserIds(): Promise<void> {
  // >SEPARATOR listUserIds
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
// multipleBatch0
export async function snippetFormultipleBatch(): Promise<void> {
  // >SEPARATOR multipleBatch
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
// operationIndex0
export async function snippetForoperationIndex(): Promise<void> {
  // >SEPARATOR operationIndex
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.operationIndex({
    indexName: 'theIndexName',
    operationIndexParams: {
      operation: 'copy',
      destination: 'dest',
      scope: ['rules', 'settings'],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the partialUpdateObject method.
//
// partialUpdateObject0
export async function snippetForpartialUpdateObject(): Promise<void> {
  // >SEPARATOR partialUpdateObject
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
// removeUserId0
export async function snippetForremoveUserId(): Promise<void> {
  // >SEPARATOR removeUserId
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
// replaceSources0
export async function snippetForreplaceSources(): Promise<void> {
  // >SEPARATOR replaceSources
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
// restoreApiKey0
export async function snippetForrestoreApiKey(): Promise<void> {
  // >SEPARATOR restoreApiKey
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
// saveObject0
export async function snippetForsaveObject(): Promise<void> {
  // >SEPARATOR saveObject
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.saveObject({
    indexName: 'theIndexName',
    body: { objectID: 'id', test: 'val' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the saveRule method.
//
// saveRule with minimal parameters
export async function snippetForsaveRule(): Promise<void> {
  // >SEPARATOR saveRule
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
export async function snippetForsaveRules(): Promise<void> {
  // >SEPARATOR saveRules
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.saveRules({
    indexName: 'indexName',
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
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the saveSynonym method.
//
// saveSynonym0
export async function snippetForsaveSynonym(): Promise<void> {
  // >SEPARATOR saveSynonym
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
// saveSynonyms0
export async function snippetForsaveSynonyms(): Promise<void> {
  // >SEPARATOR saveSynonyms
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.saveSynonyms({
    indexName: 'indexName',
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
    replaceExistingSynonyms: false,
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// search for a single hits request with minimal parameters
export async function snippetForsearch(): Promise<void> {
  // >SEPARATOR search
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [{ indexName: 'cts_e2e_search_empty_index' }],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchDictionaryEntries method.
//
// get searchDictionaryEntries results with minimal parameters
export async function snippetForsearchDictionaryEntries(): Promise<void> {
  // >SEPARATOR searchDictionaryEntries
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.searchDictionaryEntries({
    dictionaryName: 'compounds',
    searchDictionaryEntriesParams: { query: 'foo' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchForFacetValues method.
//
// get searchForFacetValues results with minimal parameters
export async function snippetForsearchForFacetValues(): Promise<void> {
  // >SEPARATOR searchForFacetValues
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
// searchRules0
export async function snippetForsearchRules(): Promise<void> {
  // >SEPARATOR searchRules
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
export async function snippetForsearchSingleIndex(): Promise<void> {
  // >SEPARATOR searchSingleIndex
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
export async function snippetForsearchSynonyms(): Promise<void> {
  // >SEPARATOR searchSynonyms
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
// searchUserIds0
export async function snippetForsearchUserIds(): Promise<void> {
  // >SEPARATOR searchUserIds
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
export async function snippetForsetDictionarySettings(): Promise<void> {
  // >SEPARATOR setDictionarySettings
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
// setSettings with minimal parameters
export async function snippetForsetSettings(): Promise<void> {
  // >SEPARATOR setSettings
  // Initialize the client
  const client = searchClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.setSettings({
    indexName: 'cts_e2e_settings',
    indexSettings: { paginationLimitedTo: 10 },
    forwardToReplicas: true,
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the updateApiKey method.
//
// updateApiKey0
export async function snippetForupdateApiKey(): Promise<void> {
  // >SEPARATOR updateApiKey
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
