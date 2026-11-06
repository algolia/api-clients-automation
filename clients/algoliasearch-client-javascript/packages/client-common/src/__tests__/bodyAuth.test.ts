import { describe, expect, test } from 'vitest';
import { createMemoryCache, createNullCache } from '../cache';
import { createNullLogger } from '../logger';
import { createTransporter } from '../transporter';
import type {
  AlgoliaAgent,
  EndRequest,
  Request,
  Requester,
  TransporterOptions,
  TransporterWithHttpInfo,
} from '../types';

const SECRET = 'SECRET';
const APP_ID = 'APPID';

describe('transporter body auth', () => {
  const algoliaAgent: AlgoliaAgent = {
    value: 'test',
    add: () => algoliaAgent,
  };

  const searchRequest: Request = {
    method: 'POST',
    path: '/1/indexes/*/queries',
    queryParameters: {},
    headers: {},
    data: { requests: [{ indexName: 'foo', query: 'bar' }] },
    useReadTransporter: true,
    acceptsApiKeyInBody: true,
  };

  function createTestTransporter(
    requester: Requester,
    options: Partial<TransporterOptions> = {},
  ): TransporterWithHttpInfo {
    return createTransporter({
      hosts: [{ url: 'localhost', accept: 'readWrite', protocol: 'https' }],
      hostsCache: createNullCache(),
      baseHeaders: { 'content-type': 'text/plain' },
      baseQueryParameters: { 'x-algolia-application-id': APP_ID },
      baseBodyParameters: { apiKey: SECRET },
      algoliaAgent,
      logger: createNullLogger(),
      timeouts: {
        connect: 1000,
        read: 2000,
        write: 3000,
      },
      requester,
      requestsCache: createMemoryCache({ serializable: false }),
      responsesCache: createMemoryCache(),
      ...options,
    });
  }

  function createEchoRequester(): { requester: Requester; requests: EndRequest[] } {
    const requests: EndRequest[] = [];

    return {
      requests,
      requester: {
        send: async (endRequest) => {
          requests.push(endRequest);
          return { status: 200, content: '{}', isTimedOut: false };
        },
      },
    };
  }

  function queryParams(endRequest: EndRequest): URLSearchParams {
    return new URL(endRequest.url).searchParams;
  }

  function assertNoAuthHeaders(headers: EndRequest['headers']): void {
    expect(headers['x-algolia-api-key']).toBeUndefined();
    expect(headers['x-algolia-application-id']).toBeUndefined();
  }

  function assertKeyInQuery(endRequest: EndRequest): void {
    expect(queryParams(endRequest).get('x-algolia-api-key')).toBe(SECRET);
    expect(queryParams(endRequest).get('x-algolia-application-id')).toBe(APP_ID);
    assertNoAuthHeaders(endRequest.headers);
  }

  test('read POST merges the credential into the JSON body and keeps a simple CORS request', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);

    await transporter.request(searchRequest);

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual({
      requests: [{ indexName: 'foo', query: 'bar' }],
      apiKey: SECRET,
    });
    expect(queryParams(requests[0]).get('x-algolia-application-id')).toBe(APP_ID);
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBeNull();
    expect(requests[0].headers['content-type']).toBe('text/plain');
    assertNoAuthHeaders(requests[0].headers);
  });

  test('write POST leaves the user payload untouched and puts the key in the query', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);
    const attributesToUpdate = { title: 'foo' };

    await transporter.request({
      method: 'POST',
      path: '/1/indexes/foo/bar/partial',
      queryParameters: {},
      headers: {},
      data: attributesToUpdate,
    });

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual(attributesToUpdate);
    assertKeyInQuery(requests[0]);
  });

  test('write POST that owns an apiKey field keeps it and puts the credential in the query', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);
    const payload = { provider: 'openai', apiKey: 'third-party-key' };

    await transporter.request({
      method: 'POST',
      path: '/1/providers',
      queryParameters: {},
      headers: {},
      data: payload,
    });

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual(payload);
    assertKeyInQuery(requests[0]);
  });

  test('GET puts the key in the query and sends no body', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);

    await transporter.request({
      method: 'GET',
      path: '/1/indexes/foo',
      queryParameters: {},
      headers: {},
    });

    expect(requests).toHaveLength(1);
    expect(requests[0].data).toBeUndefined();
    assertKeyInQuery(requests[0]);
  });

  test('empty-body DELETE and PUT put the key in the query and leave the body absent', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);

    for (const method of ['DELETE', 'PUT'] as const) {
      await transporter.request({
        method,
        path: '/1/indexes/foo',
        queryParameters: {},
        headers: {},
      });
    }

    expect(requests).toHaveLength(2);
    for (const endRequest of requests) {
      expect(endRequest.data).toBeUndefined();
      assertKeyInQuery(endRequest);
    }
  });

  test('array body is serialized untouched and the key falls back to the query', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);
    const payload = [{ objectID: '1' }, { objectID: '2' }];

    await transporter.request({ ...searchRequest, data: payload });

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual(payload);
    assertKeyInQuery(requests[0]);
  });

  test('requestOptions.data.apiKey overrides the body credential, like request headers in WithinHeaders', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);

    await transporter.request(searchRequest, { data: { apiKey: 'PER_REQUEST' } });

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual({
      requests: [{ indexName: 'foo', query: 'bar' }],
      apiKey: 'PER_REQUEST',
    });
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBeNull();
  });

  test('read POST that does not accept a body key (e.g. getObjects) puts the key in the query', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);
    const payload = { requests: [{ indexName: 'foo', objectID: 'bar' }] };

    await transporter.request({
      method: 'POST',
      path: '/1/indexes/*/objects',
      queryParameters: {},
      headers: {},
      data: payload,
      useReadTransporter: true,
    });

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual(payload);
    assertKeyInQuery(requests[0]);
  });

  test('requestOptions.queryParameters overrides the query fallback credential', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);

    await transporter.request(
      { method: 'GET', path: '/1/indexes/foo', queryParameters: {}, headers: {} },
      { queryParameters: { 'x-algolia-api-key': 'PER_REQUEST' } },
    );

    expect(requests).toHaveLength(1);
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBe('PER_REQUEST');
  });

  test('rotating baseBodyParameters.apiKey applies to the next request', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);

    transporter.baseBodyParameters.apiKey = 'ROTATED';
    await transporter.request(searchRequest);
    await transporter.request({ method: 'GET', path: '/1/indexes/foo', queryParameters: {}, headers: {} });

    expect(JSON.parse(requests[0].data as string).apiKey).toBe('ROTATED');
    expect(queryParams(requests[1]).get('x-algolia-api-key')).toBe('ROTATED');
  });

  test('a body that carries the credential is never gzipped, so stack traces can mask it', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester, {
      compression: 'gzip',
      compress: async (data) => new TextEncoder().encode(data),
    });
    const longQuery = 'a'.repeat(2000);

    await transporter.request({ ...searchRequest, data: { query: longQuery } });
    await transporter.request({
      method: 'POST',
      path: '/1/indexes/foo/batch',
      queryParameters: {},
      headers: {},
      data: { requests: [{ action: 'addObject', body: { title: longQuery } }] },
    });

    expect(requests).toHaveLength(2);
    expect(JSON.parse(requests[0].data as string)).toEqual({ query: longQuery, apiKey: SECRET });
    expect(requests[0].headers['content-encoding']).toBeUndefined();
    expect(requests[1].data).toBeInstanceOf(Uint8Array);
    expect(requests[1].headers['content-encoding']).toBe('gzip');
    assertKeyInQuery(requests[1]);
  });

  test('cacheable requests that differ only by the body secret miss the cache', async () => {
    let requestCount = 0;
    const requester: Requester = {
      send: async () => {
        requestCount++;
        return { status: 200, content: '{}', isTimedOut: false };
      },
    };
    const requestsCache = createMemoryCache({ serializable: false });
    const responsesCache = createMemoryCache();
    const cacheableRequest = { ...searchRequest, cacheable: true };

    const first = createTestTransporter(requester, {
      requestsCache,
      responsesCache,
      baseBodyParameters: { apiKey: SECRET },
    });
    const second = createTestTransporter(requester, {
      requestsCache,
      responsesCache,
      baseBodyParameters: { apiKey: 'OTHER' },
    });

    await first.request(cacheableRequest);
    await second.request(cacheableRequest);

    expect(requestCount).toBe(2);
  });

  test('requestStream applies the same read-request body auth', async () => {
    const requests: EndRequest[] = [];
    const requester: Requester = {
      send: async () => ({ status: 200, content: '{}', isTimedOut: false }),
      sendStream: async (endRequest) => {
        requests.push(endRequest);
        return new ReadableStream<Uint8Array>({
          start(controller) {
            controller.close();
          },
        });
      },
    };
    const transporter = createTestTransporter(requester);

    await transporter.requestStream(searchRequest).next();
    await transporter
      .requestStream({ method: 'POST', path: '/1/completions', queryParameters: {}, headers: {}, data: { q: 'x' } })
      .next();

    expect(requests).toHaveLength(2);
    expect(JSON.parse(requests[0].data as string)).toEqual({
      requests: [{ indexName: 'foo', query: 'bar' }],
      apiKey: SECRET,
    });
    expect(queryParams(requests[0]).get('x-algolia-application-id')).toBe(APP_ID);
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBeNull();
    assertNoAuthHeaders(requests[0].headers);
    expect(JSON.parse(requests[1].data as string)).toEqual({ q: 'x' });
    assertKeyInQuery(requests[1]);
  });
});
