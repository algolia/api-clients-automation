import { describe, expect, test } from 'vitest';
import { createMemoryCache, createNullCache } from '../cache';
import { createNullLogger } from '../logger';
import { createTransporter } from '../transporter';
import type { AlgoliaAgent, EndRequest, Requester, TransporterOptions, TransporterWithHttpInfo } from '../types';

const SECRET = 'SECRET';
const APP_ID = 'APPID';

describe('transporter body auth', () => {
  const algoliaAgent: AlgoliaAgent = {
    value: 'test',
    add: () => algoliaAgent,
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

  test('POST object body merges the credential into JSON and keeps a simple CORS request', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);

    await transporter.request({
      method: 'POST',
      path: '/search',
      queryParameters: {},
      headers: {},
      data: { query: 'foo', hitsPerPage: 1 },
    });

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual({
      query: 'foo',
      hitsPerPage: 1,
      apiKey: SECRET,
    });
    expect(queryParams(requests[0]).get('x-algolia-application-id')).toBe(APP_ID);
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBeNull();
    expect(requests[0].headers['content-type']).toBe('text/plain');
    assertNoAuthHeaders(requests[0].headers);
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
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBe(SECRET);
    expect(queryParams(requests[0]).get('x-algolia-application-id')).toBe(APP_ID);
    assertNoAuthHeaders(requests[0].headers);
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
      expect(queryParams(endRequest).get('x-algolia-api-key')).toBe(SECRET);
      expect(queryParams(endRequest).get('x-algolia-application-id')).toBe(APP_ID);
      assertNoAuthHeaders(endRequest.headers);
    }
  });

  test('array body is serialized untouched and the key falls back to the query', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);
    const payload = [{ objectID: '1' }, { objectID: '2' }];

    await transporter.request({
      method: 'POST',
      path: '/1/indexes/foo/batch',
      queryParameters: {},
      headers: {},
      data: payload,
    });

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual(payload);
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBe(SECRET);
    expect(queryParams(requests[0]).get('x-algolia-application-id')).toBe(APP_ID);
    assertNoAuthHeaders(requests[0].headers);
  });

  test('payload that already owns apiKey as a string is left untouched and the key falls back to the query', async () => {
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
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBe(SECRET);
    assertNoAuthHeaders(requests[0].headers);
  });

  test('payload that already owns apiKey as an object is left untouched and the key falls back to the query', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);
    const payload = { apiKey: { name: 'nested' } };

    await transporter.request({
      method: 'POST',
      path: '/1/providers',
      queryParameters: {},
      headers: {},
      data: payload,
    });

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual(payload);
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBe(SECRET);
    assertNoAuthHeaders(requests[0].headers);
  });

  test('requestOptions.data.apiKey cannot overwrite the transporter credential', async () => {
    const { requester, requests } = createEchoRequester();
    const transporter = createTestTransporter(requester);

    await transporter.request(
      {
        method: 'POST',
        path: '/search',
        queryParameters: {},
        headers: {},
        data: { query: 'foo' },
      },
      { data: { apiKey: 'ATTACKER' } },
    );

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual({
      query: 'foo',
      apiKey: SECRET,
    });
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBeNull();
    assertNoAuthHeaders(requests[0].headers);
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
    const cacheableRequest = {
      method: 'POST' as const,
      path: '/search',
      queryParameters: {},
      headers: {},
      data: { query: 'foo' },
      cacheable: true,
    };

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

  test('requestStream applies the same POST object-body auth path', async () => {
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

    await transporter
      .requestStream({
        method: 'POST',
        path: '/search',
        queryParameters: {},
        headers: {},
        data: { query: 'foo', hitsPerPage: 1 },
      })
      .next();

    expect(requests).toHaveLength(1);
    expect(JSON.parse(requests[0].data as string)).toEqual({
      query: 'foo',
      hitsPerPage: 1,
      apiKey: SECRET,
    });
    expect(queryParams(requests[0]).get('x-algolia-application-id')).toBe(APP_ID);
    expect(queryParams(requests[0]).get('x-algolia-api-key')).toBeNull();
    expect(requests[0].headers['content-type']).toBe('text/plain');
    assertNoAuthHeaders(requests[0].headers);
  });
});
