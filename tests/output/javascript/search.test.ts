// @ts-nocheck
import { SearchApi, EchoRequester } from '@algolia/client-search';

describe('Common Test Suite', () => {
  const client = new SearchApi(
    process.env.ALGOLIA_APPLICATION_ID,
    process.env.ALGOLIA_SEARCH_KEY,
    { requester: new EchoRequester() }
  );

  test('get getDictionarySettings results', async () => {
    const req = await client.getDictionarySettings();
    expect(req).toMatchObject({
      path: '/1/dictionaries/*/settings',
      method: 'GET',
    });
  });

  test('searchSynonyms', async () => {
    const req = await client.searchSynonyms({
      indexName: 'indexName',
      query: 'queryString',
      type: 'onewaysynonym',
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/synonyms/search',
      method: 'POST',
    });
  });

  test('saveSynonyms', async () => {
    const req = await client.saveSynonyms({
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
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/synonyms/batch',
      method: 'POST',
      data: [
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
    });
  });

  test('deleteRule', async () => {
    const req = await client.deleteRule({
      indexName: 'indexName',
      objectID: 'id1',
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/rules/id1',
      method: 'DELETE',
    });
  });

  test('get searchForFacetValues results with minimal parameters', async () => {
    const req = await client.searchForFacetValues({
      indexName: 'indexName',
      facetName: 'facetName',
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/facets/facetName/query',
      method: 'POST',
    });
  });

  test('get searchForFacetValues results with all parameters', async () => {
    const req = await client.searchForFacetValues({
      indexName: 'indexName',
      facetName: 'facetName',
      searchForFacetValuesRequest: {
        params: "query=foo&facetFilters=['bar']",
        facetQuery: 'foo',
        maxFacetHits: 42,
      },
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/facets/facetName/query',
      method: 'POST',
      data: {
        params: "query=foo&facetFilters=['bar']",
        facetQuery: 'foo',
        maxFacetHits: 42,
      },
    });
  });

  test('getSynonym', async () => {
    const req = await client.getSynonym({
      indexName: 'indexName',
      objectID: 'id1',
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/synonyms/id1',
      method: 'GET',
    });
  });

  test('search', async () => {
    const req = await client.search({
      indexName: 'indexName',
      searchParams: { $objectName: 'Query', query: 'queryString' },
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/query',
      method: 'POST',
      data: { query: 'queryString' },
    });
  });

  test('get setDictionarySettings results with minimal parameters', async () => {
    const req = await client.setDictionarySettings({
      dictionarySettingsRequest: {
        disableStandardEntries: { plurals: { fr: false, en: false, ru: true } },
      },
    });
    expect(req).toMatchObject({
      path: '/1/dictionaries/*/settings',
      method: 'PUT',
      data: {
        disableStandardEntries: { plurals: { fr: false, en: false, ru: true } },
      },
    });
  });

  test('get setDictionarySettings results with all parameters', async () => {
    const req = await client.setDictionarySettings({
      dictionarySettingsRequest: {
        disableStandardEntries: {
          plurals: { fr: false, en: false, ru: true },
          stopwords: { fr: false },
          compounds: { ru: true },
        },
      },
    });
    expect(req).toMatchObject({
      path: '/1/dictionaries/*/settings',
      method: 'PUT',
      data: {
        disableStandardEntries: {
          plurals: { fr: false, en: false, ru: true },
          stopwords: { fr: false },
          compounds: { ru: true },
        },
      },
    });
  });

  test('getRule', async () => {
    const req = await client.getRule({
      indexName: 'indexName',
      objectID: 'id1',
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/rules/id1',
      method: 'GET',
    });
  });

  test('get searchDictionaryEntries results with minimal parameters', async () => {
    const req = await client.searchDictionaryEntries({
      dictionaryName: 'dictionaryName',
      searchDictionaryEntries: { query: 'foo' },
    });
    expect(req).toMatchObject({
      path: '/1/dictionaries/dictionaryName/search',
      method: 'POST',
      data: { query: 'foo' },
    });
  });

  test('get searchDictionaryEntries results with all parameters', async () => {
    const req = await client.searchDictionaryEntries({
      dictionaryName: 'dictionaryName',
      searchDictionaryEntries: {
        query: 'foo',
        page: 4,
        hitsPerPage: 2,
        language: 'fr',
      },
    });
    expect(req).toMatchObject({
      path: '/1/dictionaries/dictionaryName/search',
      method: 'POST',
      data: { query: 'foo', page: 4, hitsPerPage: 2, language: 'fr' },
    });
  });

  test('batchRules', async () => {
    const req = await client.batchRules({
      indexName: 'indexName',
      rule: [
        {
          objectID: 'a-rule-id',
          conditions: [{ pattern: 'smartphone', anchoring: 'contains' }],
          consequence: { params: { filters: 'category:smartphone' } },
        },
        {
          objectID: 'a-second-rule-id',
          conditions: [{ pattern: 'apple', anchoring: 'contains' }],
          consequence: { params: { filters: 'brand:apple' } },
        },
      ],
      forwardToReplicas: true,
      clearExistingRules: true,
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/rules/batch',
      method: 'POST',
      data: [
        {
          objectID: 'a-rule-id',
          conditions: [{ pattern: 'smartphone', anchoring: 'contains' }],
          consequence: { params: { filters: 'category:smartphone' } },
        },
        {
          objectID: 'a-second-rule-id',
          conditions: [{ pattern: 'apple', anchoring: 'contains' }],
          consequence: { params: { filters: 'brand:apple' } },
        },
      ],
    });
  });

  test('updateApiKey', async () => {
    const req = await client.updateApiKey({
      key: 'myApiKey',
      apiKey: {
        acl: ['search', 'addObject'],
        validity: 300,
        maxQueriesPerIPPerHour: 100,
        maxHitsPerQuery: 20,
      },
    });
    expect(req).toMatchObject({
      path: '/1/keys/myApiKey',
      method: 'PUT',
      data: {
        acl: ['search', 'addObject'],
        validity: 300,
        maxQueriesPerIPPerHour: 100,
        maxHitsPerQuery: 20,
      },
    });
  });

  test('get getDictionaryLanguages', async () => {
    const req = await client.getDictionaryLanguages();
    expect(req).toMatchObject({
      path: '/1/dictionaries/*/languages',
      method: 'GET',
    });
  });

  test('deleteApiKey', async () => {
    const req = await client.deleteApiKey({ key: 'myTestApiKey' });
    expect(req).toMatchObject({
      path: '/1/keys/myTestApiKey',
      method: 'DELETE',
    });
  });

  test('searchRules', async () => {
    const req = await client.searchRules({
      indexName: 'indexName',
      searchRulesParams: { query: 'something' },
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/rules/search',
      method: 'POST',
      data: { query: 'something' },
    });
  });

  test('clearAllSynonyms', async () => {
    const req = await client.clearAllSynonyms({ indexName: 'indexName' });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/synonyms/clear',
      method: 'POST',
    });
  });

  test('saveRule', async () => {
    const req = await client.saveRule({
      indexName: 'indexName',
      objectID: 'id1',
      rule: {
        objectID: 'id1',
        conditions: [{ pattern: 'apple', anchoring: 'contains' }],
        consequence: { params: { filters: 'brand:apple' } },
      },
      forwardToReplicas: true,
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/rules/id1',
      method: 'PUT',
      data: {
        objectID: 'id1',
        conditions: [{ pattern: 'apple', anchoring: 'contains' }],
        consequence: { params: { filters: 'brand:apple' } },
      },
    });
  });

  test('addApiKey', async () => {
    const req = await client.addApiKey({
      apiKey: {
        acl: ['search', 'addObject'],
        description: 'my new api key',
        validity: 300,
        maxQueriesPerIPPerHour: 100,
        maxHitsPerQuery: 20,
      },
    });
    expect(req).toMatchObject({
      path: '/1/keys',
      method: 'POST',
      data: {
        acl: ['search', 'addObject'],
        description: 'my new api key',
        validity: 300,
        maxQueriesPerIPPerHour: 100,
        maxHitsPerQuery: 20,
      },
    });
  });

  test('restoreApiKey', async () => {
    const req = await client.restoreApiKey({ key: 'myApiKey' });
    expect(req).toMatchObject({
      path: '/1/keys/myApiKey/restore',
      method: 'POST',
    });
  });

  test('getApiKey', async () => {
    const req = await client.getApiKey({ key: 'myTestApiKey' });
    expect(req).toMatchObject({
      path: '/1/keys/myTestApiKey',
      method: 'GET',
    });
  });

  test('get browse results with minimal parameters', async () => {
    const req = await client.browse({ indexName: 'indexName' });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/browse',
      method: 'POST',
    });
  });

  test('get browse results with all parameters', async () => {
    const req = await client.browse({
      indexName: 'indexName',
      browseRequest: {
        params: "query=foo&facetFilters=['bar']",
        cursor: 'cts',
      },
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/browse',
      method: 'POST',
      data: { params: "query=foo&facetFilters=['bar']", cursor: 'cts' },
    });
  });

  test('deleteSynonym', async () => {
    const req = await client.deleteSynonym({
      indexName: 'indexName',
      objectID: 'id1',
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/synonyms/id1',
      method: 'DELETE',
    });
  });

  test('clearRules', async () => {
    const req = await client.clearRules({ indexName: 'indexName' });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/rules/clear',
      method: 'POST',
    });
  });

  test('get batchDictionaryEntries results with minimal parameters', async () => {
    const req = await client.batchDictionaryEntries({
      dictionaryName: 'dictionaryName',
      batchDictionaryEntries: {
        requests: [
          { action: 'addEntry', body: { objectID: '1', language: 'en' } },
          { action: 'deleteEntry', body: { objectID: '2', language: 'fr' } },
        ],
      },
    });
    expect(req).toMatchObject({
      path: '/1/dictionaries/dictionaryName/batch',
      method: 'POST',
      data: {
        requests: [
          { action: 'addEntry', body: { objectID: '1', language: 'en' } },
          { action: 'deleteEntry', body: { objectID: '2', language: 'fr' } },
        ],
      },
    });
  });

  test('get batchDictionaryEntries results with all parameters', async () => {
    const req = await client.batchDictionaryEntries({
      dictionaryName: 'dictionaryName',
      batchDictionaryEntries: {
        clearExistingDictionaryEntries: false,
        requests: [
          {
            action: 'addEntry',
            body: {
              objectID: '1',
              language: 'en',
              word: 'yo',
              words: ['yo', 'algolia'],
              decomposition: ['yo', 'algolia'],
              state: 'enabled',
            },
          },
          {
            action: 'deleteEntry',
            body: {
              objectID: '2',
              language: 'fr',
              word: 'salut',
              words: ['salut', 'algolia'],
              decomposition: ['salut', 'algolia'],
              state: 'enabled',
            },
          },
        ],
      },
    });
    expect(req).toMatchObject({
      path: '/1/dictionaries/dictionaryName/batch',
      method: 'POST',
      data: {
        clearExistingDictionaryEntries: false,
        requests: [
          {
            action: 'addEntry',
            body: {
              objectID: '1',
              language: 'en',
              word: 'yo',
              words: ['yo', 'algolia'],
              decomposition: ['yo', 'algolia'],
              state: 'enabled',
            },
          },
          {
            action: 'deleteEntry',
            body: {
              objectID: '2',
              language: 'fr',
              word: 'salut',
              words: ['salut', 'algolia'],
              decomposition: ['salut', 'algolia'],
              state: 'enabled',
            },
          },
        ],
      },
    });
  });

  test('listApiKeys', async () => {
    const req = await client.listApiKeys();
    expect(req).toMatchObject({
      path: '/1/keys',
      method: 'GET',
    });
  });

  test('saveSynonym', async () => {
    const req = await client.saveSynonym({
      indexName: 'indexName',
      objectID: 'id1',
      synonymHit: {
        objectID: 'id1',
        type: 'synonym',
        synonyms: ['car', 'vehicule', 'auto'],
      },
      forwardToReplicas: true,
    });
    expect(req).toMatchObject({
      path: '/1/indexes/indexName/synonyms/id1',
      method: 'PUT',
      data: {
        objectID: 'id1',
        type: 'synonym',
        synonyms: ['car', 'vehicule', 'auto'],
      },
    });
  });
});
