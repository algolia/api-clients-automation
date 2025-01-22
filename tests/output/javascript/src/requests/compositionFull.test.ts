// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import { describe, expect, test } from 'vitest';

import { compositionClient } from '@algolia/client-composition';
import type { EchoResponse } from '@algolia/requester-testing';
import { nodeEchoRequester } from '@algolia/requester-testing';

const appId = process.env.ALGOLIA_APPLICATION_ID || 'test_app_id';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'test_api_key';

// this makes sure the types are correctly exported
const client = compositionClient(appId, apiKey, { requester: nodeEchoRequester() });

describe('customDelete', () => {
  test('allow del method for a custom path with minimal parameters', async () => {
    const req = (await client.customDelete({ path: 'test/minimal' })) as unknown as EchoResponse;

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
    const req = (await client.customGet({ path: 'test/minimal' })) as unknown as EchoResponse;

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
    expect(req.searchParams).toStrictEqual({ query: 'parameters%20with%20space' });
  });

  test('requestOptions should be escaped too', async () => {
    const req = (await client.customGet(
      { path: 'test/all', parameters: { query: 'to be overriden' } },
      {
        queryParameters: { query: 'parameters with space', 'and an array': ['array', 'with spaces'] },
        headers: { 'x-header-1': 'spaces are left alone' },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/all');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual({
      query: 'parameters%20with%20space',
      'and%20an%20array': 'array%2Cwith%20spaces',
    });
    expect(req.headers).toEqual(expect.objectContaining({ 'x-header-1': 'spaces are left alone' }));
  });
});

describe('customPost', () => {
  test('allow post method for a custom path with minimal parameters', async () => {
    const req = (await client.customPost({ path: 'test/minimal' })) as unknown as EchoResponse;

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
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { query: 'myQueryParameter' },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'myQueryParameter' });
  });

  test('requestOptions merges query parameters with default ones', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { query2: 'myQueryParameter' },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', query2: 'myQueryParameter' });
  });

  test('requestOptions can override default headers', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        headers: { 'x-algolia-api-key': 'ALGOLIA_API_KEY' },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
    expect(req.headers).toEqual(expect.objectContaining({ 'x-algolia-api-key': 'ALGOLIA_API_KEY' }));
  });

  test('requestOptions merges headers with default ones', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        headers: { 'x-algolia-api-key': 'ALGOLIA_API_KEY' },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters' });
    expect(req.headers).toEqual(expect.objectContaining({ 'x-algolia-api-key': 'ALGOLIA_API_KEY' }));
  });

  test('requestOptions queryParameters accepts booleans', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { isItWorking: true },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', isItWorking: 'true' });
  });

  test('requestOptions queryParameters accepts integers', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { myParam: 2 },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', myParam: '2' });
  });

  test('requestOptions queryParameters accepts list of string', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { myParam: ['b and c', 'd'] },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', myParam: 'b%20and%20c%2Cd' });
  });

  test('requestOptions queryParameters accepts list of booleans', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { myParam: [true, true, false] },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', myParam: 'true%2Ctrue%2Cfalse' });
  });

  test('requestOptions queryParameters accepts list of integers', async () => {
    const req = (await client.customPost(
      { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
      {
        queryParameters: { myParam: [1, 2] },
      },
    )) as unknown as EchoResponse;

    expect(req.path).toEqual('/test/requestOptions');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ facet: 'filters' });
    expect(req.searchParams).toStrictEqual({ query: 'parameters', myParam: '1%2C2' });
  });
});

describe('customPut', () => {
  test('allow put method for a custom path with minimal parameters', async () => {
    const req = (await client.customPut({ path: 'test/minimal' })) as unknown as EchoResponse;

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

describe('getComposition', () => {
  test('getComposition', async () => {
    const req = (await client.getComposition({ compositionID: 'foo' })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/compositions/foo');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getRule', () => {
  test('getRule', async () => {
    const req = (await client.getRule({ compositionID: 'foo', objectID: '123' })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/compositions/foo/rules/123');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getTask', () => {
  test('getTask', async () => {
    const req = (await client.getTask({ compositionID: 'foo', taskID: 42 })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/compositions/foo/task/42');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('listCompositions', () => {
  test('listCompositions', async () => {
    const req = (await client.listCompositions()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/compositions');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('listCompositions', async () => {
    const req = (await client.listCompositions()) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/compositions');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('multipleBatch', () => {
  test('multipleBatch', async () => {
    const req = (await client.multipleBatch({
      requests: [
        {
          action: 'upsert',
          body: {
            objectID: 'foo',
            name: 'my first composition',
            behavior: { injection: { main: { source: { search: { index: 'bar' } } }, injectedItems: [] } },
          },
        },
        { action: 'delete', body: { objectID: 'baz' } },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/compositions/*/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          action: 'upsert',
          body: {
            behavior: { injection: { injectedItems: [], main: { source: { search: { index: 'bar' } } } } },
            name: 'my first composition',
            objectID: 'foo',
          },
        },
        { action: 'delete', body: { objectID: 'baz' } },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('saveRules', () => {
  test('saveRules', async () => {
    const req = (await client.saveRules({
      compositionID: 'foo',
      rules: {
        requests: [
          {
            action: 'upsert',
            body: {
              objectID: '123',
              conditions: [{ pattern: 'a' }],
              consequence: {
                behavior: { injection: { main: { source: { search: { index: '<YOUR_INDEX_NAME>' } } } } },
              },
            },
          },
        ],
      },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/compositions/foo/rules/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          action: 'upsert',
          body: {
            objectID: '123',
            conditions: [{ pattern: 'a' }],
            consequence: { behavior: { injection: { main: { source: { search: { index: '<YOUR_INDEX_NAME>' } } } } } },
          },
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('search', () => {
  test('search', async () => {
    const req = (await client.search({
      compositionID: 'foo',
      requestBody: { params: { query: 'batman' } },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/compositions/foo/run');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ params: { query: 'batman' } });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchCompositionRules', () => {
  test('searchCompositionRules', async () => {
    const req = (await client.searchCompositionRules({
      compositionID: 'foo',
      searchCompositionRulesParams: { query: 'batman' },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/compositions/foo/rules/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ query: 'batman' });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchForFacetValues', () => {
  test('searchForFacetValues', async () => {
    const req = (await client.searchForFacetValues({
      compositionID: 'foo',
      facetName: 'brand',
      searchForFacetValuesRequest: { params: { maxFacetHits: 10 } },
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/compositions/foo/facets/brand/query');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ params: { maxFacetHits: 10 } });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});
