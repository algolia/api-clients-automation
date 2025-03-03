// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint-disable eslint/no-unused-vars */
import { describe, expect, test } from 'vitest';

import type { EchoResponse } from '@algolia/requester-testing';
import { nodeEchoRequester } from '@algolia/requester-testing';
import { algoliasearch } from 'algoliasearch';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient() {
  return algoliasearch(appId, apiKey).initMonitoring({ options: { requester: nodeEchoRequester() } });
}

describe('commonApi', () => {
  test('calls api with correct user agent', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(
      /^Algolia for JavaScript \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Monitoring (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/,
    );
  }, 15000);

  test('the user agent contains the latest version', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(/^Algolia for JavaScript \(1.20.4\).*/);
  }, 15000);
});

describe('parameters', () => {
  test('use the correct host', async () => {
    const client = algoliasearch('my-app-id', 'my-api-key').initMonitoring({
      options: {
        requester: nodeEchoRequester(),
      },
    });
    const result = (await client.customDelete({ path: 'test' })) as unknown as EchoResponse;

    expect(result.host).toEqual('status.algolia.com');
  }, 15000);
});

describe('setClientApiKey', () => {
  test('switch API key', async () => {
    const client = algoliasearch('test-app-id', 'test-api-key').initMonitoring({
      options: {
        hosts: [
          {
            url: 'localhost',
            port: 6683,
            accept: 'readWrite',
            protocol: 'http',
          },
        ],
      },
    });
    {
      const result = await client.customGet({ path: 'check-api-key/1' });

      expect(result).toEqual({ headerAPIKeyValue: 'test-api-key' });
    }
    {
      client.setClientApiKey({ apiKey: 'updated-api-key' });
    }
    {
      const result = await client.customGet({ path: 'check-api-key/2' });

      expect(result).toEqual({ headerAPIKeyValue: 'updated-api-key' });
    }
  }, 15000);
});

describe('init', () => {
  test('sets authMode', async () => {
    const qpClient = algoliasearch('foo', 'bar').initMonitoring({
      options: { requester: nodeEchoRequester(), authMode: 'WithinQueryParameters' },
    });
    const headerClient = algoliasearch('foo', 'bar').initMonitoring({
      options: { requester: nodeEchoRequester(), authMode: 'WithinHeaders' },
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
});
