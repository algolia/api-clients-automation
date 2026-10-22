import { describe, expect, test } from 'vitest';

import type { EchoResponse } from '@algolia/requester-testing';
import { nodeEchoRequester } from '@algolia/requester-testing';
import { algoliasearch } from 'algoliasearch';

const appId = 'foo';
const apiKey = 'bar';

function createBodyClient() {
  return algoliasearch(appId, apiKey, { requester: nodeEchoRequester(), authMode: 'WithinBody' });
}

function headersWithoutRequestId(headers: EchoResponse['headers']): Record<string, string> {
  const { 'request-id': _requestId, ...rest } = headers;

  return rest;
}

function assertSimpleRequest(req: EchoResponse): void {
  expect(headersWithoutRequestId(req.headers)).toEqual({
    accept: 'application/json',
    'content-type': 'text/plain',
  });
  expect(req.headers).not.toHaveProperty('x-algolia-api-key');
  expect(req.headers).not.toHaveProperty('x-algolia-application-id');
}

describe('WithinBody', () => {
  test('search merges apiKey into the multi-query POST body', async () => {
    const client = createBodyClient();
    const req = (await client.search({
      requests: [{ indexName: 'idx', query: 'foo' }],
    })) as unknown as EchoResponse;

    expect(req.method).toEqual('POST');
    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.data).toEqual({
      requests: [{ indexName: 'idx', query: 'foo' }],
      apiKey,
    });
    expect(req.searchParams).toEqual({
      'x-algolia-application-id': appId,
    });
    assertSimpleRequest(req);
  });

  test('searchSingleIndex merges apiKey into the single-index POST body', async () => {
    const client = createBodyClient();
    const req = (await client.searchSingleIndex({
      indexName: 'idx',
      searchParams: { query: 'foo' },
    })) as unknown as EchoResponse;

    expect(req.method).toEqual('POST');
    expect(req.path).toEqual('/1/indexes/idx/query');
    expect(req.data).toEqual({
      query: 'foo',
      apiKey,
    });
    expect(req.searchParams).toEqual({
      'x-algolia-application-id': appId,
    });
    assertSimpleRequest(req);
  });

  test('browse and searchForFacetValues merge apiKey into the POST body', async () => {
    const client = createBodyClient();
    const requests = [
      (await client.browse({ indexName: 'idx', browseParams: { hitsPerPage: 1 } })) as unknown as EchoResponse,
      (await client.searchForFacetValues({
        indexName: 'idx',
        facetName: 'genre',
        searchForFacetValuesRequest: { facetQuery: 'a' },
      })) as unknown as EchoResponse,
    ];

    for (const req of requests) {
      expect(req.data).toMatchObject({ apiKey });
      expect(req.searchParams).toEqual({
        'x-algolia-application-id': appId,
      });
      assertSimpleRequest(req);
    }
  });

  test('read requests the engine rejects a body apiKey for fall back to the query parameter', async () => {
    const client = createBodyClient();
    const requests = [
      (await client.getObjects({ requests: [{ indexName: 'idx', objectID: 'id' }] })) as unknown as EchoResponse,
      (await client.searchRules({ indexName: 'idx', searchRulesParams: { query: '' } })) as unknown as EchoResponse,
      (await client.searchSynonyms({
        indexName: 'idx',
        searchSynonymsParams: { query: '' },
      })) as unknown as EchoResponse,
    ];

    for (const req of requests) {
      expect(req.method).toEqual('POST');
      expect(req.data).not.toHaveProperty('apiKey');
      expect(req.searchParams).toMatchObject({
        'x-algolia-api-key': apiKey,
        'x-algolia-application-id': appId,
      });
      assertSimpleRequest(req);
    }
  });

  test('GET falls back to the api key query parameter', async () => {
    const client = createBodyClient();
    const req = (await client.getSettings({ indexName: 'idx' })) as unknown as EchoResponse;

    expect(req.method).toEqual('GET');
    expect(req.data).toBeUndefined();
    expect(req.searchParams).toMatchObject({
      'x-algolia-api-key': apiKey,
      'x-algolia-application-id': appId,
    });
    assertSimpleRequest(req);
  });

  test('object-body partialUpdateObject leaves the record untouched and falls back to the query', async () => {
    const client = createBodyClient();
    const req = (await client.partialUpdateObject({
      indexName: 'idx',
      objectID: 'id',
      attributesToUpdate: { title: 'foo' },
    })) as unknown as EchoResponse;

    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ title: 'foo' });
    expect(req.searchParams).toMatchObject({
      'x-algolia-api-key': apiKey,
      'x-algolia-application-id': appId,
    });
    assertSimpleRequest(req);
  });

  test('array-body saveRules leaves the payload untouched and falls back to the query', async () => {
    const client = createBodyClient();
    const rules = [
      {
        objectID: 'a-rule-id',
        conditions: [{ pattern: 'smartphone', anchoring: 'contains' as const }],
        consequence: { params: { filters: 'brand:apple' } },
      },
    ];
    const req = (await client.saveRules({
      indexName: 'idx',
      rules,
    })) as unknown as EchoResponse;

    expect(req.method).toEqual('POST');
    expect(req.data).toEqual(rules);
    expect(req.searchParams).toMatchObject({
      'x-algolia-api-key': apiKey,
      'x-algolia-application-id': appId,
    });
    assertSimpleRequest(req);
  });

  test('setClientApiKey rotates the body credential on the next search', async () => {
    const client = createBodyClient();

    client.setClientApiKey({ apiKey: 'rotated' });

    const req = (await client.search({
      requests: [{ indexName: 'idx', query: 'foo' }],
    })) as unknown as EchoResponse;

    expect(req.data).toEqual({
      requests: [{ indexName: 'idx', query: 'foo' }],
      apiKey: 'rotated',
    });
    expect(req.searchParams).toEqual({
      'x-algolia-application-id': appId,
    });
  });
});
