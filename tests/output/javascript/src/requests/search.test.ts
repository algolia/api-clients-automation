import type { EchoResponse, RequestOptions } from '@algolia/client-common';
import { searchClient } from '@algolia/client-search';
import { echoRequester } from '@algolia/requester-node-http';
import * as dotenv from 'dotenv';

import { union } from '../helpers';

dotenv.config({ path: '../../.env' });

const appId = process.env.ALGOLIA_APPLICATION_ID || 'test_app_id';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'test_api_key';

const client = searchClient(appId, apiKey, { requester: echoRequester() });

if (!process.env.ALGOLIA_APPLICATION_ID) {
  throw new Error(
    'please provide an `ALGOLIA_APPLICATION_ID` env var for e2e tests'
  );
}

if (!process.env.ALGOLIA_ADMIN_KEY) {
  throw new Error(
    'please provide an `ALGOLIA_ADMIN_KEY` env var for e2e tests'
  );
}

const e2eClient = searchClient(
  process.env.ALGOLIA_APPLICATION_ID,
  process.env.ALGOLIA_ADMIN_KEY
);

describe('addApiKey', () => {
  test('addApiKey0', async () => {
    const req = (await client.addApiKey({
      acl: ['search', 'addObject'],
      description: 'my new api key',
      validity: 300,
      maxQueriesPerIPPerHour: 100,
      maxHitsPerQuery: 20,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/keys');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      acl: ['search', 'addObject'],
      description: 'my new api key',
      validity: 300,
      maxQueriesPerIPPerHour: 100,
      maxHitsPerQuery: 20,
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('addOrUpdateObject', () => {
  test('addOrUpdateObject0', async () => {
    const req = (await client.addOrUpdateObject({
      indexName: 'indexName',
      objectID: 'uniqueID',
      body: { key: 'value' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/uniqueID');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ key: 'value' });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('appendSource', () => {
  test('appendSource0', async () => {
    const req = (await client.appendSource({
      source: 'theSource',
      description: 'theDescription',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/security/sources/append');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      source: 'theSource',
      description: 'theDescription',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('assignUserId', () => {
  test('assignUserId0', async () => {
    const req = (await client.assignUserId({
      xAlgoliaUserID: 'userID',
      assignUserIdParams: { cluster: 'theCluster' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ cluster: 'theCluster' });
    expect(req.searchParams).toStrictEqual(undefined);
    expect(req.headers).toEqual(
      expect.objectContaining({ 'x-algolia-user-id': 'userID' })
    );
  });

  test('it should not encode the userID', async () => {
    const req = (await client.assignUserId({
      xAlgoliaUserID: 'user id with spaces',
      assignUserIdParams: { cluster: 'cluster with spaces' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ cluster: 'cluster with spaces' });
    expect(req.searchParams).toStrictEqual(undefined);
    expect(req.headers).toEqual(
      expect.objectContaining({ 'x-algolia-user-id': 'user id with spaces' })
    );
  });
});

describe('batch', () => {
  test('allows batch method with `addObject` action', async () => {
    const req = (await client.batch({
      indexName: 'theIndexName',
      batchWriteParams: {
        requests: [{ action: 'addObject', body: { key: 'value' } }],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ action: 'addObject', body: { key: 'value' } }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allows batch method with `clear` action', async () => {
    const req = (await client.batch({
      indexName: 'theIndexName',
      batchWriteParams: {
        requests: [{ action: 'clear', body: { key: 'value' } }],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ action: 'clear', body: { key: 'value' } }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allows batch method with `delete` action', async () => {
    const req = (await client.batch({
      indexName: 'theIndexName',
      batchWriteParams: {
        requests: [{ action: 'delete', body: { key: 'value' } }],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ action: 'delete', body: { key: 'value' } }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allows batch method with `deleteObject` action', async () => {
    const req = (await client.batch({
      indexName: 'theIndexName',
      batchWriteParams: {
        requests: [{ action: 'deleteObject', body: { key: 'value' } }],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ action: 'deleteObject', body: { key: 'value' } }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allows batch method with `partialUpdateObject` action', async () => {
    const req = (await client.batch({
      indexName: 'theIndexName',
      batchWriteParams: {
        requests: [{ action: 'partialUpdateObject', body: { key: 'value' } }],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ action: 'partialUpdateObject', body: { key: 'value' } }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allows batch method with `partialUpdateObjectNoCreate` action', async () => {
    const req = (await client.batch({
      indexName: 'theIndexName',
      batchWriteParams: {
        requests: [
          { action: 'partialUpdateObjectNoCreate', body: { key: 'value' } },
        ],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        { action: 'partialUpdateObjectNoCreate', body: { key: 'value' } },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allows batch method with `updateObject` action', async () => {
    const req = (await client.batch({
      indexName: 'theIndexName',
      batchWriteParams: {
        requests: [{ action: 'updateObject', body: { key: 'value' } }],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ action: 'updateObject', body: { key: 'value' } }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('batchAssignUserIds', () => {
  test('batchAssignUserIds0', async () => {
    const req = (await client.batchAssignUserIds({
      xAlgoliaUserID: 'userID',
      batchAssignUserIdsParams: {
        cluster: 'theCluster',
        users: ['user1', 'user2'],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      cluster: 'theCluster',
      users: ['user1', 'user2'],
    });
    expect(req.searchParams).toStrictEqual(undefined);
    expect(req.headers).toEqual(
      expect.objectContaining({ 'x-algolia-user-id': 'userID' })
    );
  });
});

describe('batchDictionaryEntries', () => {
  test('get batchDictionaryEntries results with minimal parameters', async () => {
    const req = (await client.batchDictionaryEntries({
      dictionaryName: 'compounds',
      batchDictionaryEntriesParams: {
        requests: [
          { action: 'addEntry', body: { objectID: '1', language: 'en' } },
          { action: 'deleteEntry', body: { objectID: '2', language: 'fr' } },
        ],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/dictionaries/compounds/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        { action: 'addEntry', body: { objectID: '1', language: 'en' } },
        { action: 'deleteEntry', body: { objectID: '2', language: 'fr' } },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get batchDictionaryEntries results with all parameters', async () => {
    const req = (await client.batchDictionaryEntries({
      dictionaryName: 'compounds',
      batchDictionaryEntriesParams: {
        clearExistingDictionaryEntries: false,
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
          {
            action: 'deleteEntry',
            body: {
              objectID: '2',
              language: 'fr',
              word: 'humility',
              words: ['candor', 'algolia'],
              decomposition: ['grit', 'algolia'],
              state: 'enabled',
            },
          },
        ],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/dictionaries/compounds/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      clearExistingDictionaryEntries: false,
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
        {
          action: 'deleteEntry',
          body: {
            objectID: '2',
            language: 'fr',
            word: 'humility',
            words: ['candor', 'algolia'],
            decomposition: ['grit', 'algolia'],
            state: 'enabled',
          },
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get batchDictionaryEntries results additional properties', async () => {
    const req = (await client.batchDictionaryEntries({
      dictionaryName: 'compounds',
      batchDictionaryEntriesParams: {
        requests: [
          {
            action: 'addEntry',
            body: { objectID: '1', language: 'en', additional: 'try me' },
          },
        ],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/dictionaries/compounds/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          action: 'addEntry',
          body: { objectID: '1', language: 'en', additional: 'try me' },
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('browse', () => {
  test('browse with minimal parameters', async () => {
    const req = (await client.browse({
      indexName: 'cts_e2e_browse',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/cts_e2e_browse/browse');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);

    const resp = await e2eClient.browse({ indexName: 'cts_e2e_browse' });

    const expectedBody = {
      page: 0,
      nbHits: 33191,
      nbPages: 34,
      hitsPerPage: 1000,
      query: '',
      params: '',
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });

  test('browse with search parameters', async () => {
    const req = (await client.browse({
      indexName: 'indexName',
      browseParams: { query: 'myQuery', facetFilters: ['tags:algolia'] },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/browse');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      query: 'myQuery',
      facetFilters: ['tags:algolia'],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('browse allow a cursor in parameters', async () => {
    const req = (await client.browse({
      indexName: 'indexName',
      browseParams: { cursor: 'test' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/browse');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ cursor: 'test' });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('clearObjects', () => {
  test('clearObjects0', async () => {
    const req = (await client.clearObjects({
      indexName: 'theIndexName',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/clear');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('clearRules', () => {
  test('clearRules0', async () => {
    const req = (await client.clearRules({
      indexName: 'indexName',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/rules/clear');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('clearSynonyms', () => {
  test('clearSynonyms0', async () => {
    const req = (await client.clearSynonyms({
      indexName: 'indexName',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/synonyms/clear');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('customDelete', () => {
  test('allow del method for a custom path with minimal parameters', async () => {
    const req = (await client.customDelete({
      path: '/test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/minimal');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow del method for a custom path with all parameters', async () => {
    const req = (await client.customDelete({
      path: '/test/all',
      parameters: { query: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/all');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });
});

describe('customGet', () => {
  test('allow get method for a custom path with minimal parameters', async () => {
    const req = (await client.customGet({
      path: '/test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/minimal');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow get method for a custom path with all parameters', async () => {
    const req = (await client.customGet({
      path: '/test/all',
      parameters: { query: 'parameters with space' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/all');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      query: 'parameters%20with%20space',
    });
  });

  test('requestOptions should be escaped too', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: {
        query: 'parameters with space',
        'and an array': ['array', 'with spaces'],
      },
      headers: { 'x-header-1': 'spaces are left alone' },
    };

    const req = (await client.customGet(
      { path: '/test/all', parameters: { query: 'to be overriden' } },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/all');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      query: 'parameters%20with%20space',
      'and%20an%20array': 'array%2Cwith%20spaces',
    });
    expect(req.headers).toEqual(
      expect.objectContaining({ 'x-header-1': 'spaces are left alone' })
    );
  });
});

describe('customPost', () => {
  test('allow post method for a custom path with minimal parameters', async () => {
    const req = (await client.customPost({
      path: '/test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/minimal');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow post method for a custom path with all parameters', async () => {
    const req = (await client.customPost({
      path: '/test/all',
      parameters: { query: 'parameters' },
      body: { body: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/all');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ body: 'parameters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });

  test('requestOptions can override default query parameters', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { query: 'myQueryParameter' },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'myQueryParameter' });
  });

  test('requestOptions merges query parameters with default ones', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { query2: 'myQueryParameter' },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      query2: 'myQueryParameter',
    });
  });

  test('requestOptions can override default headers', async () => {
    const requestOptions: RequestOptions = {
      headers: { 'x-algolia-api-key': 'myApiKey' },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
    expect(req.headers).toEqual(
      expect.objectContaining({ 'x-algolia-api-key': 'myApiKey' })
    );
  });

  test('requestOptions merges headers with default ones', async () => {
    const requestOptions: RequestOptions = {
      headers: { 'x-algolia-api-key': 'myApiKey' },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
    expect(req.headers).toEqual(
      expect.objectContaining({ 'x-algolia-api-key': 'myApiKey' })
    );
  });

  test('requestOptions queryParameters accepts booleans', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { isItWorking: true },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      isItWorking: 'true',
    });
  });

  test('requestOptions queryParameters accepts integers', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { myParam: 2 },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      myParam: '2',
    });
  });

  test('requestOptions queryParameters accepts list of string', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { myParam: ['b and c', 'd'] },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      myParam: 'b%20and%20c%2Cd',
    });
  });

  test('requestOptions queryParameters accepts list of booleans', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { myParam: [true, true, false] },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      myParam: 'true%2Ctrue%2Cfalse',
    });
  });

  test('requestOptions queryParameters accepts list of integers', async () => {
    const requestOptions: RequestOptions = {
      queryParameters: { myParam: [1, 2] },
    };

    const req = (await client.customPost(
      {
        path: '/test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({
      query: 'parameters',
      myParam: '1%2C2',
    });
  });
});

describe('customPut', () => {
  test('allow put method for a custom path with minimal parameters', async () => {
    const req = (await client.customPut({
      path: '/test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/minimal');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow put method for a custom path with all parameters', async () => {
    const req = (await client.customPut({
      path: '/test/all',
      parameters: { query: 'parameters' },
      body: { body: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/test/all');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ body: 'parameters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });
});

describe('deleteApiKey', () => {
  test('deleteApiKey0', async () => {
    const req = (await client.deleteApiKey({
      key: 'myTestApiKey',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/keys/myTestApiKey');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('deleteBy', () => {
  test('deleteBy0', async () => {
    const req = (await client.deleteBy({
      indexName: 'theIndexName',
      deleteByParams: { filters: 'brand:brandName' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/deleteByQuery');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ filters: 'brand:brandName' });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('deleteIndex', () => {
  test('deleteIndex0', async () => {
    const req = (await client.deleteIndex({
      indexName: 'theIndexName',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('deleteObject', () => {
  test('deleteObject0', async () => {
    const req = (await client.deleteObject({
      indexName: 'theIndexName',
      objectID: 'uniqueID',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/uniqueID');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('deleteRule', () => {
  test('delete rule simple case', async () => {
    const req = (await client.deleteRule({
      indexName: 'indexName',
      objectID: 'id1',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/rules/id1');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('delete rule with simple characters to encode in objectID', async () => {
    const req = (await client.deleteRule({
      indexName: 'indexName',
      objectID: 'test/with/slash',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/rules/test%2Fwith%2Fslash');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('deleteSource', () => {
  test('deleteSource0', async () => {
    const req = (await client.deleteSource({
      source: 'theSource',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/security/sources/theSource');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('deleteSynonym', () => {
  test('deleteSynonym0', async () => {
    const req = (await client.deleteSynonym({
      indexName: 'indexName',
      objectID: 'id1',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/synonyms/id1');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getApiKey', () => {
  test('getApiKey0', async () => {
    const req = (await client.getApiKey({
      key: 'myTestApiKey',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/keys/myTestApiKey');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getDictionaryLanguages', () => {
  test('get getDictionaryLanguages', async () => {
    const req =
      (await client.getDictionaryLanguages()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/dictionaries/*/languages');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getDictionarySettings', () => {
  test('get getDictionarySettings results', async () => {
    const req =
      (await client.getDictionarySettings()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/dictionaries/*/settings');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getLogs', () => {
  test('getLogs with minimal parameters', async () => {
    const req = (await client.getLogs()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/logs');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('getLogs with parameters', async () => {
    const req = (await client.getLogs({
      offset: 5,
      length: 10,
      indexName: 'theIndexName',
      type: 'all',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/logs');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      offset: '5',
      length: '10',
      indexName: 'theIndexName',
      type: 'all',
    });
  });
});

describe('getObject', () => {
  test('getObject0', async () => {
    const req = (await client.getObject({
      indexName: 'theIndexName',
      objectID: 'uniqueID',
      attributesToRetrieve: ['attr1', 'attr2'],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/uniqueID');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      attributesToRetrieve: 'attr1%2Cattr2',
    });
  });
});

describe('getObjects', () => {
  test('getObjects0', async () => {
    const req = (await client.getObjects({
      requests: [
        {
          attributesToRetrieve: ['attr1', 'attr2'],
          objectID: 'uniqueID',
          indexName: 'theIndexName',
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/objects');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          attributesToRetrieve: ['attr1', 'attr2'],
          objectID: 'uniqueID',
          indexName: 'theIndexName',
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getRule', () => {
  test('getRule0', async () => {
    const req = (await client.getRule({
      indexName: 'indexName',
      objectID: 'id1',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/rules/id1');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getSettings', () => {
  test('getSettings0', async () => {
    const req = (await client.getSettings({
      indexName: 'cts_e2e_settings',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/cts_e2e_settings/settings');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);

    const resp = await e2eClient.getSettings({ indexName: 'cts_e2e_settings' });

    const expectedBody = {
      minWordSizefor1Typo: 4,
      minWordSizefor2Typos: 8,
      hitsPerPage: 100,
      maxValuesPerFacet: 100,
      paginationLimitedTo: 10,
      exactOnSingleWordQuery: 'attribute',
      ranking: [
        'typo',
        'geo',
        'words',
        'filters',
        'proximity',
        'attribute',
        'exact',
        'custom',
      ],
      separatorsToIndex: '',
      removeWordsIfNoResults: 'none',
      queryType: 'prefixLast',
      highlightPreTag: '<em>',
      highlightPostTag: '</em>',
      alternativesAsExact: ['ignorePlurals', 'singleWordSynonym'],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('getSources', () => {
  test('getSources0', async () => {
    const req = (await client.getSources()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/security/sources');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getSynonym', () => {
  test('getSynonym0', async () => {
    const req = (await client.getSynonym({
      indexName: 'indexName',
      objectID: 'id1',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/synonyms/id1');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getTask', () => {
  test('getTask0', async () => {
    const req = (await client.getTask({
      indexName: 'theIndexName',
      taskID: 123,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/task/123');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getTopUserIds', () => {
  test('getTopUserIds0', async () => {
    const req = (await client.getTopUserIds()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping/top');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getUserId', () => {
  test('getUserId0', async () => {
    const req = (await client.getUserId({
      userID: 'uniqueID',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping/uniqueID');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('hasPendingMappings', () => {
  test('hasPendingMappings with minimal parameters', async () => {
    const req = (await client.hasPendingMappings()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping/pending');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('hasPendingMappings with parameters', async () => {
    const req = (await client.hasPendingMappings({
      getClusters: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping/pending');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ getClusters: 'true' });
  });
});

describe('listApiKeys', () => {
  test('listApiKeys0', async () => {
    const req = (await client.listApiKeys()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/keys');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('listClusters', () => {
  test('listClusters0', async () => {
    const req = (await client.listClusters()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('listIndices', () => {
  test('listIndices with minimal parameters', async () => {
    const req = (await client.listIndices()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('listIndices with parameters', async () => {
    const req = (await client.listIndices({
      page: 8,
      hitsPerPage: 3,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ page: '8', hitsPerPage: '3' });
  });
});

describe('listUserIds', () => {
  test('listUserIds with minimal parameters', async () => {
    const req = (await client.listUserIds()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('listUserIds with parameters', async () => {
    const req = (await client.listUserIds({
      page: 8,
      hitsPerPage: 100,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ page: '8', hitsPerPage: '100' });
  });
});

describe('multipleBatch', () => {
  test('multipleBatch0', async () => {
    const req = (await client.multipleBatch({
      requests: [
        {
          action: 'addObject',
          body: { key: 'value' },
          indexName: 'theIndexName',
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          action: 'addObject',
          body: { key: 'value' },
          indexName: 'theIndexName',
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('operationIndex', () => {
  test('operationIndex0', async () => {
    const req = (await client.operationIndex({
      indexName: 'theIndexName',
      operationIndexParams: {
        operation: 'copy',
        destination: 'dest',
        scope: ['rules', 'settings'],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/operation');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      operation: 'copy',
      destination: 'dest',
      scope: ['rules', 'settings'],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('partialUpdateObject', () => {
  test('partialUpdateObject0', async () => {
    const req = (await client.partialUpdateObject({
      indexName: 'theIndexName',
      objectID: 'uniqueID',
      attributesToUpdate: {
        id1: 'test',
        id2: { _operation: 'AddUnique', value: 'test2' },
      },
      createIfNotExists: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/uniqueID/partial');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      id1: 'test',
      id2: { _operation: 'AddUnique', value: 'test2' },
    });
    expect(req.searchParams).toStrictEqual({ createIfNotExists: 'true' });
  });
});

describe('removeUserId', () => {
  test('removeUserId0', async () => {
    const req = (await client.removeUserId({
      userID: 'uniqueID',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping/uniqueID');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('replaceSources', () => {
  test('replaceSources0', async () => {
    const req = (await client.replaceSources({
      source: [{ source: 'theSource', description: 'theDescription' }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/security/sources');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual([
      { source: 'theSource', description: 'theDescription' },
    ]);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('restoreApiKey', () => {
  test('restoreApiKey0', async () => {
    const req = (await client.restoreApiKey({
      key: 'myApiKey',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/keys/myApiKey/restore');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('saveObject', () => {
  test('saveObject0', async () => {
    const req = (await client.saveObject({
      indexName: 'theIndexName',
      body: { objectID: 'id', test: 'val' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ objectID: 'id', test: 'val' });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('saveRule', () => {
  test('saveRule with minimal parameters', async () => {
    const req = (await client.saveRule({
      indexName: 'indexName',
      objectID: 'id1',
      rule: {
        objectID: 'id1',
        conditions: [{ pattern: 'apple', anchoring: 'contains' }],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/rules/id1');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({
      objectID: 'id1',
      conditions: [{ pattern: 'apple', anchoring: 'contains' }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('saveRule with all parameters', async () => {
    const req = (await client.saveRule({
      indexName: 'indexName',
      objectID: 'id1',
      rule: {
        objectID: 'id1',
        conditions: [
          {
            pattern: 'apple',
            anchoring: 'contains',
            alternatives: false,
            context: 'search',
          },
        ],
        consequence: {
          params: {
            filters: 'brand:apple',
            query: {
              remove: ['algolia'],
              edits: [
                { type: 'remove', delete: 'abc', insert: 'cde' },
                { type: 'replace', delete: 'abc', insert: 'cde' },
              ],
            },
          },
          hide: [{ objectID: '321' }],
          filterPromotes: false,
          userData: { algolia: 'aloglia' },
          promote: [
            { objectID: 'abc', position: 3 },
            { objectIDs: ['abc', 'def'], position: 1 },
          ],
        },
        description: 'test',
        enabled: true,
        validity: [{ from: 1656670273, until: 1656670277 }],
      },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/rules/id1');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({
      objectID: 'id1',
      conditions: [
        {
          pattern: 'apple',
          anchoring: 'contains',
          alternatives: false,
          context: 'search',
        },
      ],
      consequence: {
        params: {
          filters: 'brand:apple',
          query: {
            remove: ['algolia'],
            edits: [
              { type: 'remove', delete: 'abc', insert: 'cde' },
              { type: 'replace', delete: 'abc', insert: 'cde' },
            ],
          },
        },
        hide: [{ objectID: '321' }],
        filterPromotes: false,
        userData: { algolia: 'aloglia' },
        promote: [
          { objectID: 'abc', position: 3 },
          { objectIDs: ['abc', 'def'], position: 1 },
        ],
      },
      description: 'test',
      enabled: true,
      validity: [{ from: 1656670273, until: 1656670277 }],
    });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });
  });
});

describe('saveRules', () => {
  test('saveRules with minimal parameters', async () => {
    const req = (await client.saveRules({
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
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/rules/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual([
      {
        objectID: 'a-rule-id',
        conditions: [{ pattern: 'smartphone', anchoring: 'contains' }],
      },
      {
        objectID: 'a-second-rule-id',
        conditions: [{ pattern: 'apple', anchoring: 'contains' }],
      },
    ]);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('saveRules with all parameters', async () => {
    const req = (await client.saveRules({
      indexName: 'indexName',
      rules: [
        {
          objectID: 'id1',
          conditions: [
            {
              pattern: 'apple',
              anchoring: 'contains',
              alternatives: false,
              context: 'search',
            },
          ],
          consequence: {
            params: {
              filters: 'brand:apple',
              query: {
                remove: ['algolia'],
                edits: [
                  { type: 'remove', delete: 'abc', insert: 'cde' },
                  { type: 'replace', delete: 'abc', insert: 'cde' },
                ],
              },
            },
            hide: [{ objectID: '321' }],
            filterPromotes: false,
            userData: { algolia: 'aloglia' },
            promote: [
              { objectID: 'abc', position: 3 },
              { objectIDs: ['abc', 'def'], position: 1 },
            ],
          },
          description: 'test',
          enabled: true,
          validity: [{ from: 1656670273, until: 1656670277 }],
        },
      ],
      forwardToReplicas: true,
      clearExistingRules: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/rules/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual([
      {
        objectID: 'id1',
        conditions: [
          {
            pattern: 'apple',
            anchoring: 'contains',
            alternatives: false,
            context: 'search',
          },
        ],
        consequence: {
          params: {
            filters: 'brand:apple',
            query: {
              remove: ['algolia'],
              edits: [
                { type: 'remove', delete: 'abc', insert: 'cde' },
                { type: 'replace', delete: 'abc', insert: 'cde' },
              ],
            },
          },
          hide: [{ objectID: '321' }],
          filterPromotes: false,
          userData: { algolia: 'aloglia' },
          promote: [
            { objectID: 'abc', position: 3 },
            { objectIDs: ['abc', 'def'], position: 1 },
          ],
        },
        description: 'test',
        enabled: true,
        validity: [{ from: 1656670273, until: 1656670277 }],
      },
    ]);
    expect(req.searchParams).toStrictEqual({
      forwardToReplicas: 'true',
      clearExistingRules: 'true',
    });
  });
});

describe('saveSynonym', () => {
  test('saveSynonym0', async () => {
    const req = (await client.saveSynonym({
      indexName: 'indexName',
      objectID: 'id1',
      synonymHit: {
        objectID: 'id1',
        type: 'synonym',
        synonyms: ['car', 'vehicule', 'auto'],
      },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/synonyms/id1');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({
      objectID: 'id1',
      type: 'synonym',
      synonyms: ['car', 'vehicule', 'auto'],
    });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });
  });
});

describe('saveSynonyms', () => {
  test('saveSynonyms0', async () => {
    const req = (await client.saveSynonyms({
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
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/synonyms/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual([
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
    ]);
    expect(req.searchParams).toStrictEqual({
      forwardToReplicas: 'true',
      replaceExistingSynonyms: 'false',
    });
  });
});

describe('search', () => {
  test('search for a single hits request with minimal parameters', async () => {
    const req = (await client.search({
      requests: [{ indexName: 'cts_e2e_search_empty_index' }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: 'cts_e2e_search_empty_index' }],
    });
    expect(req.searchParams).toStrictEqual(undefined);

    const resp = await e2eClient.search({
      requests: [{ indexName: 'cts_e2e_search_empty_index' }],
    });

    const expectedBody = {
      results: [
        {
          hits: [],
          page: 0,
          nbHits: 0,
          nbPages: 0,
          hitsPerPage: 20,
          exhaustiveNbHits: true,
          exhaustiveTypo: true,
          exhaustive: { nbHits: true, typo: true },
          query: '',
          params: '',
          index: 'cts_e2e_search_empty_index',
          renderingContent: {},
        },
      ],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });

  test('search for a single facet request with minimal parameters', async () => {
    const req = (await client.search({
      requests: [
        { indexName: 'cts_e2e_search_facet', type: 'facet', facet: 'editor' },
      ],
      strategy: 'stopIfEnoughMatches',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        { indexName: 'cts_e2e_search_facet', type: 'facet', facet: 'editor' },
      ],
      strategy: 'stopIfEnoughMatches',
    });
    expect(req.searchParams).toStrictEqual(undefined);

    const resp = await e2eClient.search({
      requests: [
        { indexName: 'cts_e2e_search_facet', type: 'facet', facet: 'editor' },
      ],
      strategy: 'stopIfEnoughMatches',
    });

    const expectedBody = {
      results: [
        {
          exhaustiveFacetsCount: true,
          facetHits: [
            { count: 1, highlighted: 'goland', value: 'goland' },
            { count: 1, highlighted: 'neovim', value: 'neovim' },
            { count: 1, highlighted: 'vscode', value: 'vscode' },
          ],
        },
      ],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });

  test('search for a single hits request with all parameters', async () => {
    const req = (await client.search({
      requests: [
        {
          indexName: 'theIndexName',
          query: 'myQuery',
          hitsPerPage: 50,
          type: 'default',
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          indexName: 'theIndexName',
          query: 'myQuery',
          hitsPerPage: 50,
          type: 'default',
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search for a single facet request with all parameters', async () => {
    const req = (await client.search({
      requests: [
        {
          indexName: 'theIndexName',
          type: 'facet',
          facet: 'theFacet',
          facetQuery: 'theFacetQuery',
          query: 'theQuery',
          maxFacetHits: 50,
        },
      ],
      strategy: 'stopIfEnoughMatches',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          indexName: 'theIndexName',
          type: 'facet',
          facet: 'theFacet',
          facetQuery: 'theFacetQuery',
          query: 'theQuery',
          maxFacetHits: 50,
        },
      ],
      strategy: 'stopIfEnoughMatches',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search for multiple mixed requests in multiple indices with minimal parameters', async () => {
    const req = (await client.search({
      requests: [
        { indexName: 'theIndexName' },
        { indexName: 'theIndexName2', type: 'facet', facet: 'theFacet' },
        { indexName: 'theIndexName', type: 'default' },
      ],
      strategy: 'stopIfEnoughMatches',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        { indexName: 'theIndexName' },
        { indexName: 'theIndexName2', type: 'facet', facet: 'theFacet' },
        { indexName: 'theIndexName', type: 'default' },
      ],
      strategy: 'stopIfEnoughMatches',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search for multiple mixed requests in multiple indices with all parameters', async () => {
    const req = (await client.search({
      requests: [
        {
          indexName: 'theIndexName',
          type: 'facet',
          facet: 'theFacet',
          facetQuery: 'theFacetQuery',
          query: 'theQuery',
          maxFacetHits: 50,
        },
        {
          indexName: 'theIndexName',
          query: 'myQuery',
          hitsPerPage: 50,
          type: 'default',
        },
      ],
      strategy: 'stopIfEnoughMatches',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          indexName: 'theIndexName',
          type: 'facet',
          facet: 'theFacet',
          facetQuery: 'theFacetQuery',
          query: 'theQuery',
          maxFacetHits: 50,
        },
        {
          indexName: 'theIndexName',
          query: 'myQuery',
          hitsPerPage: 50,
          type: 'default',
        },
      ],
      strategy: 'stopIfEnoughMatches',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search filters accept all of the possible shapes', async () => {
    const req = (await client.search({
      requests: [
        {
          indexName: 'theIndexName',
          facetFilters: 'mySearch:filters',
          reRankingApplyFilter: 'mySearch:filters',
          tagFilters: 'mySearch:filters',
          numericFilters: 'mySearch:filters',
          optionalFilters: 'mySearch:filters',
        },
        {
          indexName: 'theIndexName',
          facetFilters: ['mySearch:filters', ['mySearch:filters']],
          reRankingApplyFilter: ['mySearch:filters', ['mySearch:filters']],
          tagFilters: ['mySearch:filters', ['mySearch:filters']],
          numericFilters: ['mySearch:filters', ['mySearch:filters']],
          optionalFilters: ['mySearch:filters', ['mySearch:filters']],
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          indexName: 'theIndexName',
          facetFilters: 'mySearch:filters',
          reRankingApplyFilter: 'mySearch:filters',
          tagFilters: 'mySearch:filters',
          numericFilters: 'mySearch:filters',
          optionalFilters: 'mySearch:filters',
        },
        {
          indexName: 'theIndexName',
          facetFilters: ['mySearch:filters', ['mySearch:filters']],
          reRankingApplyFilter: ['mySearch:filters', ['mySearch:filters']],
          tagFilters: ['mySearch:filters', ['mySearch:filters']],
          numericFilters: ['mySearch:filters', ['mySearch:filters']],
          optionalFilters: ['mySearch:filters', ['mySearch:filters']],
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search with all search parameters', async () => {
    const req = (await client.search({
      requests: [
        {
          advancedSyntax: true,
          advancedSyntaxFeatures: ['exactPhrase'],
          allowTyposOnNumericTokens: true,
          alternativesAsExact: ['multiWordsSynonym'],
          analytics: true,
          analyticsTags: [''],
          aroundLatLng: '',
          aroundLatLngViaIP: true,
          aroundPrecision: 0,
          aroundRadius: 'all',
          attributeCriteriaComputedByMinProximity: true,
          attributesForFaceting: [''],
          attributesToHighlight: [''],
          attributesToRetrieve: [''],
          attributesToSnippet: [''],
          clickAnalytics: true,
          customRanking: [''],
          decompoundQuery: true,
          disableExactOnAttributes: [''],
          disableTypoToleranceOnAttributes: [''],
          distinct: 0,
          enableABTest: true,
          enablePersonalization: true,
          enableReRanking: true,
          enableRules: true,
          exactOnSingleWordQuery: 'attribute',
          explain: ['foo', 'bar'],
          facetFilters: [''],
          facetingAfterDistinct: true,
          facets: [''],
          filters: '',
          getRankingInfo: true,
          highlightPostTag: '',
          highlightPreTag: '',
          hitsPerPage: 1,
          ignorePlurals: false,
          indexName: 'theIndexName',
          insideBoundingBox: [
            [47.3165, 4.9665, 47.3424, 5.0201],
            [40.9234, 2.1185, 38.643, 1.9916],
          ],
          insidePolygon: [
            [47.3165, 4.9665, 47.3424, 5.0201, 47.32, 4.9],
            [40.9234, 2.1185, 38.643, 1.9916, 39.2587, 2.0104],
          ],
          keepDiacriticsOnCharacters: '',
          length: 1,
          maxValuesPerFacet: 0,
          minProximity: 1,
          minWordSizefor1Typo: 0,
          minWordSizefor2Typos: 0,
          minimumAroundRadius: 1,
          naturalLanguages: [''],
          numericFilters: [''],
          offset: 0,
          optionalFilters: [''],
          optionalWords: [''],
          page: 0,
          percentileComputation: true,
          personalizationImpact: 0,
          query: '',
          queryLanguages: [''],
          queryType: 'prefixAll',
          ranking: [''],
          reRankingApplyFilter: [''],
          relevancyStrictness: 0,
          removeStopWords: true,
          removeWordsIfNoResults: 'allOptional',
          renderingContent: {
            facetOrdering: {
              facets: { order: ['a', 'b'] },
              values: { a: { order: ['b'], sortRemainingBy: 'count' } },
            },
          },
          replaceSynonymsInHighlight: true,
          responseFields: [''],
          restrictHighlightAndSnippetArrays: true,
          restrictSearchableAttributes: [''],
          ruleContexts: [''],
          similarQuery: '',
          snippetEllipsisText: '',
          sortFacetValuesBy: '',
          sumOrFiltersScores: true,
          synonyms: true,
          tagFilters: [''],
          type: 'default',
          typoTolerance: 'min',
          userToken: '',
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          advancedSyntax: true,
          advancedSyntaxFeatures: ['exactPhrase'],
          allowTyposOnNumericTokens: true,
          alternativesAsExact: ['multiWordsSynonym'],
          analytics: true,
          analyticsTags: [''],
          aroundLatLng: '',
          aroundLatLngViaIP: true,
          aroundPrecision: 0,
          aroundRadius: 'all',
          attributeCriteriaComputedByMinProximity: true,
          attributesForFaceting: [''],
          attributesToHighlight: [''],
          attributesToRetrieve: [''],
          attributesToSnippet: [''],
          clickAnalytics: true,
          customRanking: [''],
          decompoundQuery: true,
          disableExactOnAttributes: [''],
          disableTypoToleranceOnAttributes: [''],
          distinct: 0,
          enableABTest: true,
          enablePersonalization: true,
          enableReRanking: true,
          enableRules: true,
          exactOnSingleWordQuery: 'attribute',
          explain: ['foo', 'bar'],
          facetFilters: [''],
          facetingAfterDistinct: true,
          facets: [''],
          filters: '',
          getRankingInfo: true,
          highlightPostTag: '',
          highlightPreTag: '',
          hitsPerPage: 1,
          ignorePlurals: false,
          indexName: 'theIndexName',
          insideBoundingBox: [
            [47.3165, 4.9665, 47.3424, 5.0201],
            [40.9234, 2.1185, 38.643, 1.9916],
          ],
          insidePolygon: [
            [47.3165, 4.9665, 47.3424, 5.0201, 47.32, 4.9],
            [40.9234, 2.1185, 38.643, 1.9916, 39.2587, 2.0104],
          ],
          keepDiacriticsOnCharacters: '',
          length: 1,
          maxValuesPerFacet: 0,
          minProximity: 1,
          minWordSizefor1Typo: 0,
          minWordSizefor2Typos: 0,
          minimumAroundRadius: 1,
          naturalLanguages: [''],
          numericFilters: [''],
          offset: 0,
          optionalFilters: [''],
          optionalWords: [''],
          page: 0,
          percentileComputation: true,
          personalizationImpact: 0,
          query: '',
          queryLanguages: [''],
          queryType: 'prefixAll',
          ranking: [''],
          reRankingApplyFilter: [''],
          relevancyStrictness: 0,
          removeStopWords: true,
          removeWordsIfNoResults: 'allOptional',
          renderingContent: {
            facetOrdering: {
              facets: { order: ['a', 'b'] },
              values: { a: { order: ['b'], sortRemainingBy: 'count' } },
            },
          },
          replaceSynonymsInHighlight: true,
          responseFields: [''],
          restrictHighlightAndSnippetArrays: true,
          restrictSearchableAttributes: [''],
          ruleContexts: [''],
          similarQuery: '',
          snippetEllipsisText: '',
          sortFacetValuesBy: '',
          sumOrFiltersScores: true,
          synonyms: true,
          tagFilters: [''],
          type: 'default',
          typoTolerance: 'min',
          userToken: '',
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchDictionaryEntries', () => {
  test('get searchDictionaryEntries results with minimal parameters', async () => {
    const req = (await client.searchDictionaryEntries({
      dictionaryName: 'compounds',
      searchDictionaryEntriesParams: { query: 'foo' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/dictionaries/compounds/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ query: 'foo' });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get searchDictionaryEntries results with all parameters', async () => {
    const req = (await client.searchDictionaryEntries({
      dictionaryName: 'compounds',
      searchDictionaryEntriesParams: {
        query: 'foo',
        page: 4,
        hitsPerPage: 2,
        language: 'fr',
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/dictionaries/compounds/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      query: 'foo',
      page: 4,
      hitsPerPage: 2,
      language: 'fr',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchForFacetValues', () => {
  test('get searchForFacetValues results with minimal parameters', async () => {
    const req = (await client.searchForFacetValues({
      indexName: 'indexName',
      facetName: 'facetName',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/facets/facetName/query');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get searchForFacetValues results with all parameters', async () => {
    const req = (await client.searchForFacetValues({
      indexName: 'indexName',
      facetName: 'facetName',
      searchForFacetValuesRequest: {
        params: "query=foo&facetFilters=['bar']",
        facetQuery: 'foo',
        maxFacetHits: 42,
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/facets/facetName/query');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      params: "query=foo&facetFilters=['bar']",
      facetQuery: 'foo',
      maxFacetHits: 42,
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchRules', () => {
  test('searchRules0', async () => {
    const req = (await client.searchRules({
      indexName: 'indexName',
      searchRulesParams: { query: 'something' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/rules/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ query: 'something' });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchSingleIndex', () => {
  test('search with minimal parameters', async () => {
    const req = (await client.searchSingleIndex({
      indexName: 'indexName',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/query');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search with special characters in indexName', async () => {
    const req = (await client.searchSingleIndex({
      indexName: 'cts_e2e_space in index',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/cts_e2e_space%20in%20index/query');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);

    await e2eClient.searchSingleIndex({ indexName: 'cts_e2e_space in index' });
  });

  test('search with searchParams', async () => {
    const req = (await client.searchSingleIndex({
      indexName: 'indexName',
      searchParams: { query: 'myQuery', facetFilters: ['tags:algolia'] },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/query');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      query: 'myQuery',
      facetFilters: ['tags:algolia'],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('single search retrieve snippets', async () => {
    const req = (await client.searchSingleIndex({
      indexName: 'cts_e2e_browse',
      searchParams: {
        query: 'batman mask of the phantasm',
        attributesToRetrieve: ['*'],
        attributesToSnippet: ['*:20'],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/cts_e2e_browse/query');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      query: 'batman mask of the phantasm',
      attributesToRetrieve: ['*'],
      attributesToSnippet: ['*:20'],
    });
    expect(req.searchParams).toStrictEqual(undefined);

    const resp = await e2eClient.searchSingleIndex({
      indexName: 'cts_e2e_browse',
      searchParams: {
        query: 'batman mask of the phantasm',
        attributesToRetrieve: ['*'],
        attributesToSnippet: ['*:20'],
      },
    });

    const expectedBody = {
      nbHits: 1,
      hits: [
        {
          _snippetResult: {
            genres: [
              { value: 'Animated', matchLevel: 'none' },
              { value: 'Superhero', matchLevel: 'none' },
              { value: 'Romance', matchLevel: 'none' },
            ],
            year: { value: '1993', matchLevel: 'none' },
          },
          _highlightResult: {
            genres: [
              { value: 'Animated', matchLevel: 'none', matchedWords: [] },
              { value: 'Superhero', matchLevel: 'none', matchedWords: [] },
              { value: 'Romance', matchLevel: 'none', matchedWords: [] },
            ],
            year: { value: '1993', matchLevel: 'none', matchedWords: [] },
          },
        },
      ],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('searchSynonyms', () => {
  test('searchSynonyms with minimal parameters', async () => {
    const req = (await client.searchSynonyms({
      indexName: 'indexName',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/synonyms/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('searchSynonyms with all parameters', async () => {
    const req = (await client.searchSynonyms({
      indexName: 'indexName',
      searchSynonymsParams: {
        query: 'myQuery',
        type: 'altcorrection1',
        page: 10,
        hitsPerPage: 10,
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/synonyms/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      query: 'myQuery',
      type: 'altcorrection1',
      page: 10,
      hitsPerPage: 10,
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchUserIds', () => {
  test('searchUserIds0', async () => {
    const req = (await client.searchUserIds({
      query: 'test',
      clusterName: 'theClusterName',
      page: 5,
      hitsPerPage: 10,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/clusters/mapping/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      query: 'test',
      clusterName: 'theClusterName',
      page: 5,
      hitsPerPage: 10,
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('setDictionarySettings', () => {
  test('get setDictionarySettings results with minimal parameters', async () => {
    const req = (await client.setDictionarySettings({
      disableStandardEntries: { plurals: { fr: false, en: false, ru: true } },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/dictionaries/*/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({
      disableStandardEntries: { plurals: { fr: false, en: false, ru: true } },
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get setDictionarySettings results with all parameters', async () => {
    const req = (await client.setDictionarySettings({
      disableStandardEntries: {
        plurals: { fr: false, en: false, ru: true },
        stopwords: { fr: false },
        compounds: { ru: true },
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/dictionaries/*/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({
      disableStandardEntries: {
        plurals: { fr: false, en: false, ru: true },
        stopwords: { fr: false },
        compounds: { ru: true },
      },
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('setSettings', () => {
  test('setSettings with minimal parameters', async () => {
    const req = (await client.setSettings({
      indexName: 'cts_e2e_settings',
      indexSettings: { paginationLimitedTo: 10 },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/cts_e2e_settings/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ paginationLimitedTo: 10 });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });

    await e2eClient.setSettings({
      indexName: 'cts_e2e_settings',
      indexSettings: { paginationLimitedTo: 10 },
      forwardToReplicas: true,
    });
  });

  test('setSettings allow boolean `typoTolerance`', async () => {
    const req = (await client.setSettings({
      indexName: 'theIndexName',
      indexSettings: { typoTolerance: true },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ typoTolerance: true });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });
  });

  test('setSettings allow enum `typoTolerance`', async () => {
    const req = (await client.setSettings({
      indexName: 'theIndexName',
      indexSettings: { typoTolerance: 'min' },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ typoTolerance: 'min' });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });
  });

  test('setSettings allow boolean `ignorePlurals`', async () => {
    const req = (await client.setSettings({
      indexName: 'theIndexName',
      indexSettings: { ignorePlurals: true },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ ignorePlurals: true });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });
  });

  test('setSettings allow list of string `ignorePlurals`', async () => {
    const req = (await client.setSettings({
      indexName: 'theIndexName',
      indexSettings: { ignorePlurals: ['algolia'] },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ ignorePlurals: ['algolia'] });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });
  });

  test('setSettings allow boolean `removeStopWords`', async () => {
    const req = (await client.setSettings({
      indexName: 'theIndexName',
      indexSettings: { removeStopWords: true },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ removeStopWords: true });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });
  });

  test('setSettings allow list of string `removeStopWords`', async () => {
    const req = (await client.setSettings({
      indexName: 'theIndexName',
      indexSettings: { removeStopWords: ['algolia'] },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ removeStopWords: ['algolia'] });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });
  });

  test('setSettings allow boolean `distinct`', async () => {
    const req = (await client.setSettings({
      indexName: 'theIndexName',
      indexSettings: { distinct: true },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ distinct: true });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });
  });

  test('setSettings allow integers for `distinct`', async () => {
    const req = (await client.setSettings({
      indexName: 'theIndexName',
      indexSettings: { distinct: 1 },
      forwardToReplicas: true,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ distinct: 1 });
    expect(req.searchParams).toStrictEqual({ forwardToReplicas: 'true' });
  });

  test('setSettings allow all `indexSettings`', async () => {
    const req = (await client.setSettings({
      indexName: 'theIndexName',
      indexSettings: {
        advancedSyntax: true,
        advancedSyntaxFeatures: ['exactPhrase'],
        allowCompressionOfIntegerArray: true,
        allowTyposOnNumericTokens: true,
        alternativesAsExact: ['singleWordSynonym'],
        attributeCriteriaComputedByMinProximity: true,
        attributeForDistinct: 'test',
        attributesForFaceting: ['algolia'],
        attributesToHighlight: ['algolia'],
        attributesToRetrieve: ['algolia'],
        attributesToSnippet: ['algolia'],
        attributesToTransliterate: ['algolia'],
        camelCaseAttributes: ['algolia'],
        customNormalization: { algolia: { aloglia: 'aglolia' } },
        customRanking: ['algolia'],
        decompoundQuery: false,
        decompoundedAttributes: { algolia: 'aloglia' },
        disableExactOnAttributes: ['algolia'],
        disablePrefixOnAttributes: ['algolia'],
        disableTypoToleranceOnAttributes: ['algolia'],
        disableTypoToleranceOnWords: ['algolia'],
        distinct: 3,
        enablePersonalization: true,
        enableReRanking: false,
        enableRules: true,
        exactOnSingleWordQuery: 'attribute',
        highlightPreTag: '<span>',
        highlightPostTag: '</span>',
        hitsPerPage: 10,
        ignorePlurals: false,
        indexLanguages: ['algolia'],
        keepDiacriticsOnCharacters: 'abc',
        maxFacetHits: 20,
        maxValuesPerFacet: 30,
        minProximity: 6,
        minWordSizefor1Typo: 5,
        minWordSizefor2Typos: 11,
        mode: 'neuralSearch',
        numericAttributesForFiltering: ['algolia'],
        optionalWords: ['myspace'],
        paginationLimitedTo: 0,
        queryLanguages: ['algolia'],
        queryType: 'prefixLast',
        ranking: ['geo'],
        reRankingApplyFilter: 'mySearch:filters',
        relevancyStrictness: 10,
        removeStopWords: false,
        removeWordsIfNoResults: 'lastWords',
        renderingContent: {
          facetOrdering: {
            facets: { order: ['a', 'b'] },
            values: { a: { order: ['b'], sortRemainingBy: 'count' } },
          },
        },
        replaceSynonymsInHighlight: true,
        replicas: [''],
        responseFields: ['algolia'],
        restrictHighlightAndSnippetArrays: true,
        searchableAttributes: ['foo'],
        semanticSearch: { eventSources: ['foo'] },
        separatorsToIndex: 'bar',
        snippetEllipsisText: '---',
        sortFacetValuesBy: 'date',
        typoTolerance: false,
        unretrievableAttributes: ['foo'],
        userData: { user: 'data' },
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/theIndexName/settings');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({
      advancedSyntax: true,
      advancedSyntaxFeatures: ['exactPhrase'],
      allowCompressionOfIntegerArray: true,
      allowTyposOnNumericTokens: true,
      alternativesAsExact: ['singleWordSynonym'],
      attributeCriteriaComputedByMinProximity: true,
      attributeForDistinct: 'test',
      attributesForFaceting: ['algolia'],
      attributesToHighlight: ['algolia'],
      attributesToRetrieve: ['algolia'],
      attributesToSnippet: ['algolia'],
      attributesToTransliterate: ['algolia'],
      camelCaseAttributes: ['algolia'],
      customNormalization: { algolia: { aloglia: 'aglolia' } },
      customRanking: ['algolia'],
      decompoundQuery: false,
      decompoundedAttributes: { algolia: 'aloglia' },
      disableExactOnAttributes: ['algolia'],
      disablePrefixOnAttributes: ['algolia'],
      disableTypoToleranceOnAttributes: ['algolia'],
      disableTypoToleranceOnWords: ['algolia'],
      distinct: 3,
      enablePersonalization: true,
      enableReRanking: false,
      enableRules: true,
      exactOnSingleWordQuery: 'attribute',
      highlightPreTag: '<span>',
      highlightPostTag: '</span>',
      hitsPerPage: 10,
      ignorePlurals: false,
      indexLanguages: ['algolia'],
      keepDiacriticsOnCharacters: 'abc',
      maxFacetHits: 20,
      maxValuesPerFacet: 30,
      minProximity: 6,
      minWordSizefor1Typo: 5,
      minWordSizefor2Typos: 11,
      mode: 'neuralSearch',
      numericAttributesForFiltering: ['algolia'],
      optionalWords: ['myspace'],
      paginationLimitedTo: 0,
      queryLanguages: ['algolia'],
      queryType: 'prefixLast',
      ranking: ['geo'],
      reRankingApplyFilter: 'mySearch:filters',
      relevancyStrictness: 10,
      removeStopWords: false,
      removeWordsIfNoResults: 'lastWords',
      renderingContent: {
        facetOrdering: {
          facets: { order: ['a', 'b'] },
          values: { a: { order: ['b'], sortRemainingBy: 'count' } },
        },
      },
      replaceSynonymsInHighlight: true,
      replicas: [''],
      responseFields: ['algolia'],
      restrictHighlightAndSnippetArrays: true,
      searchableAttributes: ['foo'],
      semanticSearch: { eventSources: ['foo'] },
      separatorsToIndex: 'bar',
      snippetEllipsisText: '---',
      sortFacetValuesBy: 'date',
      typoTolerance: false,
      unretrievableAttributes: ['foo'],
      userData: { user: 'data' },
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('updateApiKey', () => {
  test('updateApiKey0', async () => {
    const req = (await client.updateApiKey({
      key: 'myApiKey',
      apiKey: {
        acl: ['search', 'addObject'],
        validity: 300,
        maxQueriesPerIPPerHour: 100,
        maxHitsPerQuery: 20,
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/keys/myApiKey');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({
      acl: ['search', 'addObject'],
      validity: 300,
      maxQueriesPerIPPerHour: 100,
      maxHitsPerQuery: 20,
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('generateSecuredApiKey', () => {
  test('generates a key without restrictions', () => {
    const resp = client.generateSecuredApiKey({ parentApiKey: 'foo' });
    expect(resp).toEqual(
      'NjgzNzE2ZDlkN2Y4MmVlZDE3NGM2Y2FlYmUwODZlZTkzMzc2Yzc5ZDdjNjFkZDY3MGVhMDBmN2Y4ZDZlYjBhOA=='
    );
  });

  test('generates a key with restrictions', () => {
    const resp = client.generateSecuredApiKey({
      parentApiKey: 'foo',
      restrictions: {
        validUntil: 100,
        restrictIndices: ['bar'],
        restrictSources: '192,168.1.0/24',
        userToken: 'foobarbaz',
        searchParams: {
          query: 'foo',
        },
      },
    });
    expect(resp).toEqual(
      'M2RlY2Y5ZjgzMDU1ZDRiYjkyOTdjYjYxYWNjNWNhNTQ5ZGI5Mjc3ZmVjNmNmNjM2ZjAwMTA4OGRjNDI5YjFhOXZhbGlkVW50aWw9MTAwJnJlc3RyaWN0SW5kaWNlcz0lNUIlMjJiYXIlMjIlNUQmcmVzdHJpY3RTb3VyY2VzPTE5MiUyQzE2OC4xLjAlMkYyNCZ1c2VyVG9rZW49Zm9vYmFyYmF6JnNlYXJjaFBhcmFtcz0lN0IlMjJxdWVyeSUyMiUzQSUyMmZvbyUyMiU3RA=='
    );
  });
});

describe('getSecuredApiKeyRemainingValidity', () => {
  test('is able to check the remaining validity of a key', () => {
    const resp = client.generateSecuredApiKey({
      parentApiKey: 'foo',
      restrictions: { validUntil: 42 },
    });
    expect(resp).toEqual(
      'NDI5ZjRkMTRiNTBlZmExZWIyN2I3NzczOGUwMzE0NjYwMDU1M2M3NjYyY2IxODZhMDAxMWEwOWJmZjE5MzY0NnZhbGlkVW50aWw9NDI='
    );

    const validity = client.getSecuredApiKeyRemainingValidity({
      securedApiKey: resp,
    });
    expect(validity).toEqual(42 - Math.round(new Date().getTime() / 1000));
  });

  test('throws when the validity field is not found', () => {
    try {
      client.getSecuredApiKeyRemainingValidity({ securedApiKey: 'foo' });
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch(
        'validUntil not found in given secured api key.'
      );
    }
  });
});

describe('replaceAllObjects', () => {
  beforeEach(() => {
    client.batch = jest.fn(() =>
      Promise.resolve({ taskID: 42, objectIDs: ['foo', 'bar'] })
    );
    client.operationIndex = jest.fn(() =>
      Promise.resolve({ taskID: 21, updatedAt: 'foobar' })
    );
    client.waitForTask = jest.fn(() =>
      Promise.resolve({ status: 'published' })
    );
  });

  afterEach(() => {
    jest.resetAllMocks();
    jest.restoreAllMocks();
  });

  test('executes with minimal parameters', async () => {
    const resp = await client.replaceAllObjects({
      indexName: 'foo',
      objects: [{ name: 'John Doe' }],
    });

    expect(client.batch).toHaveBeenCalledTimes(1);
    expect(client.operationIndex).toHaveBeenCalledTimes(2);
    expect(resp).toEqual({
      copyOperationResponse: { taskID: 21, updatedAt: 'foobar' },
      batchResponses: [
        {
          objectIDs: ['foo', 'bar'],
          taskID: 42,
        },
      ],
      moveOperationResponse: { taskID: 21, updatedAt: 'foobar' },
    });
  });

  test('does many calls when len(objects) > batchSize', async () => {
    const objects: Array<Record<string, any>> = [];
    for (let i = 0; i < 33; i++) {
      objects.push({ name: `John Doe${i}` });
    }

    const resp = await client.replaceAllObjects({
      indexName: 'foo',
      objects,
      batchSize: 10,
    });

    expect(client.batch).toHaveBeenCalledTimes(4);
    expect(client.operationIndex).toHaveBeenCalledTimes(2);
    expect(resp).toEqual({
      copyOperationResponse: { taskID: 21, updatedAt: 'foobar' },
      batchResponses: [
        {
          objectIDs: ['foo', 'bar'],
          taskID: 42,
        },
        {
          objectIDs: ['foo', 'bar'],
          taskID: 42,
        },
        {
          objectIDs: ['foo', 'bar'],
          taskID: 42,
        },
        {
          objectIDs: ['foo', 'bar'],
          taskID: 42,
        },
      ],
      moveOperationResponse: { taskID: 21, updatedAt: 'foobar' },
    });
  });

  test('batchSize is 1000 by default', async () => {
    const objects: Array<Record<string, any>> = [];
    for (let i = 0; i < 1001; i++) {
      objects.push({ name: `John Doe${i}` });
    }

    const resp = await client.replaceAllObjects({ indexName: 'foo', objects });

    expect(client.batch).toHaveBeenCalledTimes(2);
    expect(client.operationIndex).toHaveBeenCalledTimes(2);
    expect(resp).toEqual({
      copyOperationResponse: { taskID: 21, updatedAt: 'foobar' },
      batchResponses: [
        {
          objectIDs: ['foo', 'bar'],
          taskID: 42,
        },
        {
          objectIDs: ['foo', 'bar'],
          taskID: 42,
        },
      ],
      moveOperationResponse: { taskID: 21, updatedAt: 'foobar' },
    });
  });
});
