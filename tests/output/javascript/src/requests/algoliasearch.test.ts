// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
import { describe, expect, test } from 'vitest';

import type { EchoResponse } from '@algolia/requester-testing';
import { nodeEchoRequester } from '@algolia/requester-testing';
import { liteClient } from 'algoliasearch/lite';

const appId = process.env.ALGOLIA_APPLICATION_ID || 'test_app_id';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'test_api_key';

// this makes sure the types are correctly exported
const client = liteClient(appId, apiKey, { requester: nodeEchoRequester() });

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

describe('search', () => {
  test('withHitsPerPage', async () => {
    const req = (await client.search({
      requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', hitsPerPage: 50 }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', hitsPerPage: 50 }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('filterOnly', async () => {
    const req = (await client.search({
      requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', filters: 'actor:Scarlett Johansson' }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', filters: 'actor:Scarlett Johansson' }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('filterOr', async () => {
    const req = (await client.search({
      requests: [
        {
          indexName: '<YOUR_INDEX_NAME>',
          query: '<YOUR_QUERY>',
          filters: 'actor:Tom Cruise OR actor:Scarlett Johansson',
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          indexName: '<YOUR_INDEX_NAME>',
          query: '<YOUR_QUERY>',
          filters: 'actor:Tom Cruise OR actor:Scarlett Johansson',
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('filterNot', async () => {
    const req = (await client.search({
      requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', filters: 'NOT actor:Nicolas Cage' }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', filters: 'NOT actor:Nicolas Cage' }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search for a single hits request with minimal parameters', async () => {
    const req = (await client.search({
      requests: [{ indexName: 'cts_e2e_search_empty_index' }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ requests: [{ indexName: 'cts_e2e_search_empty_index' }] });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search with highlight and snippet results', async () => {
    const req = (await client.search({
      requests: [
        {
          indexName: 'cts_e2e_highlight_snippet_results',
          query: 'vim',
          attributesToSnippet: ['*:20'],
          attributesToHighlight: ['*'],
          attributesToRetrieve: ['*'],
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        {
          indexName: 'cts_e2e_highlight_snippet_results',
          query: 'vim',
          attributesToSnippet: ['*:20'],
          attributesToHighlight: ['*'],
          attributesToRetrieve: ['*'],
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('retrieveFacets', async () => {
    const req = (await client.search({
      requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', facets: ['author', 'genre'] }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', facets: ['author', 'genre'] }],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('retrieveFacetsWildcard', async () => {
    const req = (await client.search({
      requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', facets: ['*'] }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', facets: ['*'] }] });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search for a single facet request with minimal parameters', async () => {
    const req = (await client.search({
      requests: [{ indexName: 'cts_e2e_search_facet', type: 'facet', facet: 'editor' }],
      strategy: 'stopIfEnoughMatches',
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: 'cts_e2e_search_facet', type: 'facet', facet: 'editor' }],
      strategy: 'stopIfEnoughMatches',
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search for a single hits request with all parameters', async () => {
    const req = (await client.search({
      requests: [{ indexName: 'theIndexName', query: 'myQuery', hitsPerPage: 50, type: 'default' }],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: 'theIndexName', query: 'myQuery', hitsPerPage: 50, type: 'default' }],
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
        { indexName: 'theIndexName', query: 'myQuery', hitsPerPage: 50, type: 'default' },
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
        { indexName: 'theIndexName', query: 'myQuery', hitsPerPage: 50, type: 'default' },
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
          facetFilters: ['mySearch:filters', ['mySearch:filters', ['mySearch:filters']]],
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
          facetFilters: ['mySearch:filters', ['mySearch:filters', ['mySearch:filters']]],
          reRankingApplyFilter: ['mySearch:filters', ['mySearch:filters']],
          tagFilters: ['mySearch:filters', ['mySearch:filters']],
          numericFilters: ['mySearch:filters', ['mySearch:filters']],
          optionalFilters: ['mySearch:filters', ['mySearch:filters']],
        },
      ],
    });
    expect(req.searchParams).toStrictEqual(undefined);
  });

  test('search filters end to end', async () => {
    const req = (await client.search({
      requests: [
        { indexName: 'cts_e2e_search_facet', filters: "editor:'visual studio' OR editor:neovim" },
        { indexName: 'cts_e2e_search_facet', facetFilters: ["editor:'visual studio'", 'editor:neovim'] },
        { indexName: 'cts_e2e_search_facet', facetFilters: ["editor:'visual studio'", ['editor:neovim']] },
        {
          indexName: 'cts_e2e_search_facet',
          facetFilters: ["editor:'visual studio'", ['editor:neovim', ['editor:goland']]],
        },
      ],
    })) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [
        { indexName: 'cts_e2e_search_facet', filters: "editor:'visual studio' OR editor:neovim" },
        { indexName: 'cts_e2e_search_facet', facetFilters: ["editor:'visual studio'", 'editor:neovim'] },
        { indexName: 'cts_e2e_search_facet', facetFilters: ["editor:'visual studio'", ['editor:neovim']] },
        {
          indexName: 'cts_e2e_search_facet',
          facetFilters: ["editor:'visual studio'", ['editor:neovim', ['editor:goland']]],
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
          attributesToHighlight: [''],
          attributesToRetrieve: [''],
          attributesToSnippet: [''],
          clickAnalytics: true,
          decompoundQuery: true,
          disableExactOnAttributes: [''],
          disableTypoToleranceOnAttributes: [''],
          distinct: 0,
          enableABTest: true,
          enablePersonalization: true,
          enableReRanking: true,
          enableRules: true,
          exactOnSingleWordQuery: 'attribute',
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
          length: 1,
          maxValuesPerFacet: 0,
          minProximity: 1,
          minWordSizefor1Typo: 0,
          minWordSizefor2Typos: 0,
          minimumAroundRadius: 1,
          naturalLanguages: ['fr'],
          numericFilters: [''],
          offset: 0,
          optionalFilters: [''],
          optionalWords: [''],
          page: 0,
          percentileComputation: true,
          personalizationImpact: 0,
          query: '',
          queryLanguages: ['fr'],
          queryType: 'prefixAll',
          ranking: [''],
          reRankingApplyFilter: [''],
          relevancyStrictness: 0,
          removeStopWords: true,
          removeWordsIfNoResults: 'allOptional',
          renderingContent: {
            facetOrdering: { facets: { order: ['a', 'b'] }, values: { a: { order: ['b'], sortRemainingBy: 'count' } } },
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
          attributesToHighlight: [''],
          attributesToRetrieve: [''],
          attributesToSnippet: [''],
          clickAnalytics: true,
          decompoundQuery: true,
          disableExactOnAttributes: [''],
          disableTypoToleranceOnAttributes: [''],
          distinct: 0,
          enableABTest: true,
          enablePersonalization: true,
          enableReRanking: true,
          enableRules: true,
          exactOnSingleWordQuery: 'attribute',
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
          length: 1,
          maxValuesPerFacet: 0,
          minProximity: 1,
          minWordSizefor1Typo: 0,
          minWordSizefor2Typos: 0,
          minimumAroundRadius: 1,
          naturalLanguages: ['fr'],
          numericFilters: [''],
          offset: 0,
          optionalFilters: [''],
          optionalWords: [''],
          page: 0,
          percentileComputation: true,
          personalizationImpact: 0,
          query: '',
          queryLanguages: ['fr'],
          queryType: 'prefixAll',
          ranking: [''],
          reRankingApplyFilter: [''],
          relevancyStrictness: 0,
          removeStopWords: true,
          removeWordsIfNoResults: 'allOptional',
          renderingContent: {
            facetOrdering: { facets: { order: ['a', 'b'] }, values: { a: { order: ['b'], sortRemainingBy: 'count' } } },
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
