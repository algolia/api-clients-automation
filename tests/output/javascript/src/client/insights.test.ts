// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint-disable @typescript-eslint/no-unused-vars, require-await */
// @ts-nocheck Failing tests will have type errors, but we cannot suppress them even with @ts-expect-error because it doesn't work for a block of lines.
import type { InsightsClient } from '@algolia/client-insights';
import { insightsClient } from '@algolia/client-insights';
import { echoRequester } from '@algolia/requester-node-http';
import type { EchoResponse } from '@algolia/requester-node-http';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient(): InsightsClient {
  return insightsClient(appId, apiKey, 'us', { requester: echoRequester() });
}

describe('commonApi', () => {
  test('calls api with correct user agent', async () => {
    const client = createClient();

    const result = (await client.customPost({ path: '1/test' })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(
      /^Algolia for JavaScript \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Insights (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/,
    );
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

describe('parameters', () => {
  test('fallbacks to the alias when region is not given', async () => {
    const client = insightsClient('my-app-id', 'my-api-key', '', { requester: echoRequester() });

    const result = (await client.pushEvents({
      events: [
        {
          eventType: 'click',
          eventName: 'Product Clicked',
          index: 'products',
          userToken: 'user-123456',
          authenticatedUserToken: 'user-123456',
          timestamp: 1641290601962,
          objectIDs: ['9780545139700', '9780439784542'],
          queryID: '43b15df305339e827f0ac0bdc5ebcaa7',
          positions: [7, 6],
        },
      ],
    })) as unknown as EchoResponse;

    expect(result.host).toEqual('insights.algolia.io');
  }, 15000);

  test('uses the correct region', async () => {
    const client = insightsClient('my-app-id', 'my-api-key', 'us', { requester: echoRequester() });

    const result = (await client.customDelete({ path: 'test' })) as unknown as EchoResponse;

    expect(result.host).toEqual('insights.us.algolia.io');
  }, 15000);

  test('throws when incorrect region is given', async () => {
    try {
      const client = insightsClient('my-app-id', 'my-api-key', 'not_a_region', { requester: echoRequester() });
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch('`region` must be one of the following: de, us');
    }
  }, 15000);
});

describe('init', () => {
  test('sets authMode', async () => {
    const qpClient = insightsClient('foo', 'bar', 'us', {
      authMode: 'WithinQueryParameters',
      requester: echoRequester(),
    });
    const headerClient = insightsClient('foo', 'bar', 'us', {
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
});
