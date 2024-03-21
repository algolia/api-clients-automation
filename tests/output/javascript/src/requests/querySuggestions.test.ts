import type { EchoResponse, RequestOptions } from '@algolia/client-common';
import { querySuggestionsClient } from '@algolia/client-query-suggestions';
import { echoRequester } from '@algolia/requester-node-http';
import * as dotenv from 'dotenv';

import { union } from '../helpers';

dotenv.config({ path: '../../.env' });

const appId = process.env.ALGOLIA_APPLICATION_ID || 'test_app_id';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'test_api_key';

const client = querySuggestionsClient(appId, apiKey, 'us', {
  requester: echoRequester(),
});

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

const e2eClient = querySuggestionsClient(
  process.env.ALGOLIA_APPLICATION_ID,
  process.env.ALGOLIA_ADMIN_KEY,
  'us'
);

describe('createConfig', () => {
  test('createConfig0', async () => {
    const req = (await client.createConfig({
      indexName: 'theIndexName',
      sourceIndices: [
        {
          indexName: 'testIndex',
          facets: [{ attribute: 'test' }],
          generate: [['facetA', 'facetB'], ['facetC']],
        },
      ],
      languages: ['french'],
      exclude: ['test'],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/configs');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      indexName: 'theIndexName',
      sourceIndices: [
        {
          indexName: 'testIndex',
          facets: [{ attribute: 'test' }],
          generate: [['facetA', 'facetB'], ['facetC']],
        },
      ],
      languages: ['french'],
      exclude: ['test'],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('customDelete', () => {
  test('allow del method for a custom path with minimal parameters', async () => {
    const req = (await client.customDelete({
      path: 'test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/minimal');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow del method for a custom path with all parameters', async () => {
    const req = (await client.customDelete({
      path: 'test/all',
      parameters: { query: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });
});

describe('customGet', () => {
  test('allow get method for a custom path with minimal parameters', async () => {
    const req = (await client.customGet({
      path: 'test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/minimal');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow get method for a custom path with all parameters', async () => {
    const req = (await client.customGet({
      path: 'test/all',
      parameters: { query: 'parameters with space' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
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
      { path: 'test/all', parameters: { query: 'to be overriden' } },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
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
      path: 'test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/minimal');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow post method for a custom path with all parameters', async () => {
    const req = (await client.customPost({
      path: 'test/all',
      parameters: { query: 'parameters' },
      body: { body: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
        path: 'test/requestOptions',
        parameters: { query: 'parameters' },
        body: { facet: 'filters' },
      },
      requestOptions
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
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
      path: 'test/minimal',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/minimal');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('allow put method for a custom path with all parameters', async () => {
    const req = (await client.customPut({
      path: 'test/all',
      parameters: { query: 'parameters' },
      body: { body: 'parameters' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({ body: 'parameters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
  });
});

describe('deleteConfig', () => {
  test('deleteConfig0', async () => {
    const req = (await client.deleteConfig({
      indexName: 'theIndexName',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/configs/theIndexName');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getAllConfigs', () => {
  test('getAllConfigs0', async () => {
    const req = (await client.getAllConfigs()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/configs');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getConfig', () => {
  test('Retrieve QS config e2e', async () => {
    const req = (await client.getConfig({
      indexName: 'cts_e2e_browse_query_suggestions',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/configs/cts_e2e_browse_query_suggestions');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);

    const resp = await e2eClient.getConfig({
      indexName: 'cts_e2e_browse_query_suggestions',
    });

    const expectedBody = {
      allowSpecialCharacters: true,
      enablePersonalization: false,
      exclude: ['^cocaines$'],
      indexName: 'cts_e2e_browse_query_suggestions',
      languages: [],
      sourceIndices: [
        {
          facets: [{ amount: 1, attribute: 'title' }],
          generate: [['year']],
          indexName: 'cts_e2e_browse',
          minHits: 5,
          minLetters: 4,
          replicas: false,
        },
      ],
    };

    expect(expectedBody).toEqual(union(expectedBody, resp));
  });
});

describe('getConfigStatus', () => {
  test('getConfigStatus0', async () => {
    const req = (await client.getConfigStatus({
      indexName: 'theIndexName',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/configs/theIndexName/status');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getLogFile', () => {
  test('getLogFile0', async () => {
    const req = (await client.getLogFile({
      indexName: 'theIndexName',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/logs/theIndexName');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('updateConfig', () => {
  test('updateConfig0', async () => {
    const req = (await client.updateConfig({
      indexName: 'theIndexName',
      querySuggestionsConfiguration: {
        sourceIndices: [
          {
            indexName: 'testIndex',
            facets: [{ attribute: 'test' }],
            generate: [['facetA', 'facetB'], ['facetC']],
          },
        ],
        languages: ['french'],
        exclude: ['test'],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/configs/theIndexName');
    expect(req.method).toEqual('PUT');
    expect(req.data).toEqual({
      sourceIndices: [
        {
          indexName: 'testIndex',
          facets: [{ attribute: 'test' }],
          generate: [['facetA', 'facetB'], ['facetC']],
        },
      ],
      languages: ['french'],
      exclude: ['test'],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});
