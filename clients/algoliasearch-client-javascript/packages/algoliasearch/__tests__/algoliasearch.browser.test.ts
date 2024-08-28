import type { EchoResponse } from '@algolia/client-common';
import {
  DEFAULT_CONNECT_TIMEOUT_BROWSER,
  DEFAULT_READ_TIMEOUT_BROWSER,
  DEFAULT_WRITE_TIMEOUT_BROWSER,
} from '@algolia/client-common';
import { echoRequester } from '@algolia/requester-browser-xhr';

import { algoliasearch, apiClientVersion } from '../builds/browser';
import { liteClient } from '../lite/builds/browser';

const client = algoliasearch('APP_ID', 'API_KEY', {
  requester: echoRequester(),
});

describe('api', () => {
  it('exposes the `appId` currently in use at the root of the API', () => {
    expect(client.appId).toEqual('APP_ID');
  });

  it('provides a `clearCache` method', () => {
    expect(client.clearCache).not.toBeUndefined();
  });

  it('sets the user agent', async () => {
    const req = (await client.customPost({
      path: '/test',
    })) as unknown as EchoResponse;

    expect(req.algoliaAgent).toMatchInlineSnapshot(
      `"Algolia%20for%20JavaScript%20(${apiClientVersion})%3B%20Search%20(${apiClientVersion})%3B%20Browser"`,
    );
  });

  it('throws with undefined API key', () => {
    expect(() => algoliasearch('APP_ID', '')).toThrow('`apiKey` is missing');
  });

  it('throws with undefined app ID', () => {
    expect(() => algoliasearch('', 'API_KEY')).toThrow('`appId` is missing');
  });

  it('provides the search client at the root of the API', () => {
    expect(client.search).not.toBeUndefined();
  });

  describe('_ua', () => {
    it('provides a backward compatible `_ua` variable at the root of the client', () => {
      expect(client._ua).toEqual(
        expect.stringContaining(`Algolia for JavaScript (${apiClientVersion}); Search (${apiClientVersion});`),
      );
    });

    it('keeps `_ua` updated with the transporter algolia agent', () => {
      expect(client._ua).toEqual(expect.stringMatching(/.*; Browser$/g));

      client.addAlgoliaAgent('Jest', '0.0.1');

      expect(client._ua).toEqual(expect.stringMatching(/.*; Jest \(0\.0\.1\)$/g));
    });
  });

  it('exposes the search client transporter for the algoliasearch client', () => {
    expect(client.transporter).not.toBeUndefined();
    expect(client.transporter).toEqual({
      algoliaAgent: {
        add: expect.any(Function),
        value: expect.stringContaining(`Algolia for JavaScript (${apiClientVersion}); Search (${apiClientVersion});`),
      },
      baseHeaders: {
        'content-type': 'text/plain',
      },
      baseQueryParameters: {
        'x-algolia-api-key': 'API_KEY',
        'x-algolia-application-id': 'APP_ID',
      },
      hosts: expect.arrayContaining([
        {
          accept: 'read',
          protocol: 'https',
          url: 'APP_ID-dsn.algolia.net',
        },
        {
          accept: 'write',
          protocol: 'https',
          url: 'APP_ID.algolia.net',
        },
        {
          accept: 'readWrite',
          protocol: 'https',
          url: 'APP_ID-3.algolianet.com',
        },
        {
          accept: 'readWrite',
          protocol: 'https',
          url: 'APP_ID-1.algolianet.com',
        },
        {
          accept: 'readWrite',
          protocol: 'https',
          url: 'APP_ID-2.algolianet.com',
        },
      ]),
      hostsCache: {
        clear: expect.any(Function),
        delete: expect.any(Function),
        get: expect.any(Function),
        set: expect.any(Function),
      },
      request: expect.any(Function),
      requester: {
        send: expect.any(Function),
      },
      requestsCache: {
        clear: expect.any(Function),
        delete: expect.any(Function),
        get: expect.any(Function),
        set: expect.any(Function),
      },
      responsesCache: {
        clear: expect.any(Function),
        delete: expect.any(Function),
        get: expect.any(Function),
        set: expect.any(Function),
      },
      timeouts: {
        connect: DEFAULT_CONNECT_TIMEOUT_BROWSER,
        read: DEFAULT_READ_TIMEOUT_BROWSER,
        write: DEFAULT_WRITE_TIMEOUT_BROWSER,
      },
    });
  });

  describe('init clients', () => {
    it('provides an init method for the analytics client', () => {
      expect(client.initAnalytics).not.toBeUndefined();
    });

    it('provides an init method for the abtesting client', () => {
      expect(client.initAbtesting).not.toBeUndefined();
    });

    it('provides an init method for the personalization client', () => {
      expect(client.initPersonalization).not.toBeUndefined();
    });

    it('default `init` clients to the root `algoliasearch` credentials', async () => {
      const abtestingClient = client.initAbtesting({options:{requester:echoRequester()}});
      const analyticsClient = client.initAnalytics({options:{requester:echoRequester()}});
      const personalizationClient = client.initPersonalization({region:'eu',options:{requester:echoRequester()}});

      const res1 = (await abtestingClient.customGet({
        path: 'abtestingClient',
      })) as unknown as EchoResponse;
      const res2 = (await analyticsClient.customGet({
        path: 'analyticsClient',
      })) as unknown as EchoResponse;
      const res3 = (await personalizationClient.customGet({
        path: 'personalizationClient',
      })) as unknown as EchoResponse;

      expect(res1.searchParams).toEqual(
        expect.objectContaining({
          'x-algolia-application-id': 'APP_ID',
          'x-algolia-api-key': 'API_KEY',
        }),
      );
      expect(res2.searchParams).toEqual(
        expect.objectContaining({
          'x-algolia-application-id': 'APP_ID',
          'x-algolia-api-key': 'API_KEY',
        }),
      );
      expect(res3.searchParams).toEqual(
        expect.objectContaining({
          'x-algolia-application-id': 'APP_ID',
          'x-algolia-api-key': 'API_KEY',
        }),
      );
    });

    it('`init` clients accept different credentials', async () => {
      const abtestingClient = client.initAbtesting({
        appId: 'appId1',
        apiKey: 'apiKey1',
        options:{requester: echoRequester()}
      });
      const analyticsClient = client.initAnalytics({
        appId: 'appId2',
        apiKey: 'apiKey2',
        options:{requester: echoRequester()}
      });
      const personalizationClient = client.initPersonalization({
        appId: 'appId3',
        apiKey: 'apiKey3',
        region: 'eu',
        options:{requester: echoRequester()}
      });

      const res1 = (await abtestingClient.customGet({
        path: 'abtestingClient',
      })) as unknown as EchoResponse;
      const res2 = (await analyticsClient.customGet({
        path: 'analyticsClient',
      })) as unknown as EchoResponse;
      const res3 = (await personalizationClient.customGet({
        path: 'personalizationClient',
      })) as unknown as EchoResponse;

      expect(res1.searchParams).toEqual(
        expect.objectContaining({
          'x-algolia-application-id': 'appId1',
          'x-algolia-api-key': 'apiKey1',
        }),
      );
      expect(res2.searchParams).toEqual(
        expect.objectContaining({
          'x-algolia-application-id': 'appId2',
          'x-algolia-api-key': 'apiKey2',
        }),
      );
      expect(res3.searchParams).toEqual(
        expect.objectContaining({
          'x-algolia-application-id': 'appId3',
          'x-algolia-api-key': 'apiKey3',
        }),
      );
    });
  });
});

describe('bundle', () => {
  it('expose both a full bundled package and a lite one', () => {
    expect(liteClient).not.toBeUndefined();
    expect(algoliasearch).not.toBeUndefined();
  });
});

/**
 * We only test the legacy signature, as `algoliasearch` inherits methods from the `client-search`.
 * The new signatures are already tested in the CTS.
 */
describe('search with legacy signature', () => {
  it('allows searching for query', async () => {
    const req = (await client.search([
      {
        indexName: 'theIndexName',
      },
    ])) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({ requests: [{ indexName: 'theIndexName' }] });
    expect(req.searchParams).toStrictEqual({
      'x-algolia-api-key': 'API_KEY',
      'x-algolia-application-id': 'APP_ID',
    });
  });

  it('allows searching for facet', async () => {
    const req = (await client.search([
      {
        indexName: 'theIndexName',
        type: 'facet',
        facet: 'theFacet',
      },
    ])) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: 'theIndexName', type: 'facet', facet: 'theFacet' }],
    });
    expect(req.searchParams).toStrictEqual({
      'x-algolia-api-key': 'API_KEY',
      'x-algolia-application-id': 'APP_ID',
    });
  });

  it('accepts a `params` parameter for `searchParams`', async () => {
    const req = (await client.search([
      {
        indexName: 'theIndexName',
        params: {
          hitsPerPage: 42,
        },
      },
    ])) as unknown as EchoResponse;

    expect(req.path).toEqual('/1/indexes/*/queries');
    expect(req.method).toEqual('POST');
    expect(req.data).toEqual({
      requests: [{ indexName: 'theIndexName', hitsPerPage: 42 }],
    });
    expect(req.searchParams).toStrictEqual({
      'x-algolia-api-key': 'API_KEY',
      'x-algolia-application-id': 'APP_ID',
    });
  });
});

describe('init', () => {
  test('sets authMode', async () => {
    const qpClient = algoliasearch('foo', 'bar', {
      authMode: 'WithinQueryParameters',
      requester: echoRequester(),
    });
    const headerClient = algoliasearch('foo', 'bar', {
      authMode: 'WithinHeaders',
      requester: echoRequester(),
    });

    const qpResult = (await qpClient.customGet({
      path: '1/foo',
    })) as unknown as EchoResponse;
    expect(qpResult.searchParams).toEqual({
      'x-algolia-api-key': 'bar',
      'x-algolia-application-id': 'foo',
    });

    const headerResult = (await headerClient.customGet({
      path: '1/bar',
    })) as unknown as EchoResponse;
    expect(headerResult.headers).toEqual({
      accept: 'application/json',
      'content-type': 'text/plain',
      'x-algolia-api-key': 'bar',
      'x-algolia-application-id': 'foo',
    });
  });

  test('defaults to qp', async () => {
    const res = (await client.customGet({
      path: '1/foo',
    })) as unknown as EchoResponse;
    expect(res.searchParams).toEqual({
      'x-algolia-api-key': 'API_KEY',
      'x-algolia-application-id': 'APP_ID',
    });
  });
});
