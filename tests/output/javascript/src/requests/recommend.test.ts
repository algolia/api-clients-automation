// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import { describe, expect, test } from 'vitest';

import type { ClientOptions } from '@algolia/client-common';
import type { EchoResponse } from '@algolia/requester-testing';
import { nodeEchoRequester } from '@algolia/requester-testing';
import { algoliasearch } from 'algoliasearch';

const appId = process.env.ALGOLIA_APPLICATION_ID || 'test_app_id';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'test_api_key';

const clientOptions: ClientOptions = { requester: nodeEchoRequester() }; // this makes sure the types are correctly exported
const client = algoliasearch(appId, apiKey).initRecommend({ options: clientOptions });

describe('batchRecommendRules', () => {
  test('batch recommend rules', async () => {
    const req = (await client.batchRecommendRules({
      indexName: 'indexName',
      model: 'related-products',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/related-products/recommend/rules/batch');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

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

describe('deleteRecommendRule', () => {
  test('deleteRecommendRule', async () => {
    const req = (await client.deleteRecommendRule({
      indexName: 'indexName',
      model: 'related-products',
      objectID: 'objectID',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/related-products/recommend/rules/objectID');
    expect(req.method).toEqual('DELETE');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getRecommendRule', () => {
  test('getRecommendRule', async () => {
    const req = (await client.getRecommendRule({
      indexName: 'indexName',
      model: 'related-products',
      objectID: 'objectID',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/related-products/recommend/rules/objectID');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getRecommendStatus', () => {
  test('getRecommendStatus', async () => {
    const req = (await client.getRecommendStatus({
      indexName: 'indexName',
      model: 'related-products',
      taskID: 12345,
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/related-products/task/12345');
    expect(req.method).toEqual('GET');
    expect(req.data).toEqual(undefined);
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('getRecommendations', () => {
  test('get recommendations for recommend model with minimal parameters', async () => {
    const req = (await client.getRecommendations({
      requests: [{ indexName: 'indexName', objectID: 'objectID', model: 'related-products', threshold: 42.1 }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/recommendations');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: 'indexName', objectID: 'objectID', model: 'related-products', threshold: 42.1 }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get recommendations with e2e to check oneOf model', async () => {
    const req = (await client.getRecommendations({
      requests: [
        {
          indexName: 'cts_e2e_browse',
          objectID: 'Æon Flux',
          model: 'related-products',
          threshold: 20.0,
          maxRecommendations: 2,
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/recommendations');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          indexName: 'cts_e2e_browse',
          objectID: 'Æon Flux',
          model: 'related-products',
          threshold: 20.0,
          maxRecommendations: 2,
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get recommendations for recommend model with all parameters', async () => {
    const req = (await client.getRecommendations({
      requests: [
        {
          indexName: 'indexName',
          objectID: 'objectID',
          model: 'related-products',
          threshold: 42.1,
          maxRecommendations: 10,
          queryParameters: { query: 'myQuery', facetFilters: ['query'] },
          fallbackParameters: { query: 'myQuery', facetFilters: ['fallback'] },
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/recommendations');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          indexName: 'indexName',
          objectID: 'objectID',
          model: 'related-products',
          threshold: 42.1,
          maxRecommendations: 10,
          queryParameters: { query: 'myQuery', facetFilters: ['query'] },
          fallbackParameters: { query: 'myQuery', facetFilters: ['fallback'] },
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get recommendations for trending model with minimal parameters', async () => {
    const req = (await client.getRecommendations({
      requests: [
        { indexName: 'indexName', model: 'trending-items', threshold: 42.1, facetName: 'facet', facetValue: 'value' },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/recommendations');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        { indexName: 'indexName', model: 'trending-items', threshold: 42.1, facetName: 'facet', facetValue: 'value' },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get recommendations for trending model with all parameters', async () => {
    const req = (await client.getRecommendations({
      requests: [
        {
          indexName: 'indexName',
          model: 'trending-items',
          threshold: 42.1,
          maxRecommendations: 10,
          facetName: 'myFacetName',
          facetValue: 'myFacetValue',
          queryParameters: { query: 'myQuery', facetFilters: ['query'] },
          fallbackParameters: { query: 'myQuery', facetFilters: ['fallback'] },
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/recommendations');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          indexName: 'indexName',
          model: 'trending-items',
          threshold: 42.1,
          maxRecommendations: 10,
          facetName: 'myFacetName',
          facetValue: 'myFacetValue',
          queryParameters: { query: 'myQuery', facetFilters: ['query'] },
          fallbackParameters: { query: 'myQuery', facetFilters: ['fallback'] },
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get multiple recommendations with minimal parameters', async () => {
    const req = (await client.getRecommendations({
      requests: [
        { indexName: 'indexName1', objectID: 'objectID1', model: 'related-products', threshold: 21.7 },
        { indexName: 'indexName2', objectID: 'objectID2', model: 'related-products', threshold: 21.7 },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/recommendations');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        { indexName: 'indexName1', objectID: 'objectID1', model: 'related-products', threshold: 21.7 },
        { indexName: 'indexName2', objectID: 'objectID2', model: 'related-products', threshold: 21.7 },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get multiple recommendations with all parameters', async () => {
    const req = (await client.getRecommendations({
      requests: [
        {
          indexName: 'indexName1',
          objectID: 'objectID1',
          model: 'related-products',
          threshold: 21.7,
          maxRecommendations: 10,
          queryParameters: { query: 'myQuery', facetFilters: ['query1'] },
          fallbackParameters: { query: 'myQuery', facetFilters: ['fallback1'] },
        },
        {
          indexName: 'indexName2',
          objectID: 'objectID2',
          model: 'related-products',
          threshold: 21.7,
          maxRecommendations: 10,
          queryParameters: { query: 'myQuery', facetFilters: ['query2'] },
          fallbackParameters: { query: 'myQuery', facetFilters: ['fallback2'] },
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/recommendations');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          indexName: 'indexName1',
          objectID: 'objectID1',
          model: 'related-products',
          threshold: 21.7,
          maxRecommendations: 10,
          queryParameters: { query: 'myQuery', facetFilters: ['query1'] },
          fallbackParameters: { query: 'myQuery', facetFilters: ['fallback1'] },
        },
        {
          indexName: 'indexName2',
          objectID: 'objectID2',
          model: 'related-products',
          threshold: 21.7,
          maxRecommendations: 10,
          queryParameters: { query: 'myQuery', facetFilters: ['query2'] },
          fallbackParameters: { query: 'myQuery', facetFilters: ['fallback2'] },
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('get frequently bought together recommendations', async () => {
    const req = (await client.getRecommendations({
      requests: [{ indexName: 'indexName1', objectID: 'objectID1', model: 'bought-together', threshold: 42.7 }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/recommendations');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: 'indexName1', objectID: 'objectID1', model: 'bought-together', threshold: 42.7 }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });
});

describe('searchRecommendRules', () => {
  test('searchRecommendRules', async () => {
    const req = (await client.searchRecommendRules({
      indexName: 'indexName',
      model: 'related-products',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/indexName/related-products/recommend/rules/search');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({});
    expect(req.searchParams).toStrictEqual(undefined);
  });
});
