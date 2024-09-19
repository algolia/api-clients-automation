// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint-disable no-lone-blocks */
// @ts-nocheck Failing tests will have type errors, but we cannot suppress them even with @ts-expect-error because it doesn't work for a block of lines.

import type { RecommendClient } from '@algolia/recommend';
import { recommendClient } from '@algolia/recommend';
import { nodeEchoRequester } from '@algolia/requester-testing';
import type { EchoResponse } from '@algolia/requester-testing';
import { describe, test, expect } from 'vitest';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient(): RecommendClient {
  return recommendClient(appId, apiKey, { requester: nodeEchoRequester() });
}

describe('api', () => {
  test('calls api with correct read host', async () => {
    const client = recommendClient('test-app-id', 'test-api-key', { requester: nodeEchoRequester() });

    const result = (await client.customGet({ path: 'test' })) as unknown as EchoResponse;

    expect(result.host).toEqual('test-app-id-dsn.algolia.net');
  }, 15000);

  test('calls api with correct write host', async () => {
    const client = recommendClient('test-app-id', 'test-api-key', { requester: nodeEchoRequester() });

    const result = (await client.customPost({ path: 'test' })) as unknown as EchoResponse;

    expect(result.host).toEqual('test-app-id.algolia.net');
  }, 15000);
});

describe('commonApi', () => {
  test('calls api with correct user agent', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(
      /^Algolia for JavaScript \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Recommend (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/,
    );
  }, 15000);

  test('the user agent contains the latest version', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(/^Algolia for JavaScript \(5.5.1\).*/);
  }, 15000);

  test('calls api with default read timeouts', async () => {
    const client = createClient();

    const result = (await client.customGet({ path: '1/test' })) as unknown as EchoResponse;

    expect(result).toEqual(expect.objectContaining({ connectTimeout: 2000, responseTimeout: 5000 }));
  }, 15000);

  test('calls api with default write timeouts', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(result).toEqual(expect.objectContaining({ connectTimeout: 2000, responseTimeout: 30000 }));
  }, 15000);
});

describe('setClientApiKey', () => {
  test('switch API key', async () => {
    const client = recommendClient('test-app-id', 'test-api-key', {
      hosts: [{ url: 'localhost', port: 6683, accept: 'readWrite', protocol: 'http' }],
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
    const qpClient = recommendClient('foo', 'bar', {
      authMode: 'WithinQueryParameters',
      requester: nodeEchoRequester(),
    });
    const headerClient = recommendClient('foo', 'bar', {
      authMode: 'WithinHeaders',
      requester: nodeEchoRequester(),
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
