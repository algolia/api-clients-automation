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
    const $client = createClient();

    const result = (await $client.customPost({
      path: '/test',
    })) as unknown as EchoResponse;

    expect(decodeURIComponent(result.algoliaAgent)).toMatch(
      /^Algolia for JavaScript \(\d+\.\d+\.\d+(-?.*)?\)(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*(; Insights (\(\d+\.\d+\.\d+(-?.*)?\)))(; [a-zA-Z. ]+ (\(\d+((\.\d+)?\.\d+)?(-?.*)?\))?)*$/
    );
  });

  test('calls api with default read timeouts', async () => {
    const $client = createClient();

    const result = (await $client.customGet({
      path: '/test',
    })) as unknown as EchoResponse;

    expect(result).toEqual(
      expect.objectContaining({ connectTimeout: 2000, responseTimeout: 5000 })
    );
  });

  test('calls api with default write timeouts', async () => {
    const $client = createClient();

    const result = (await $client.customPost({
      path: '/test',
    })) as unknown as EchoResponse;

    expect(result).toEqual(
      expect.objectContaining({ connectTimeout: 2000, responseTimeout: 30000 })
    );
  });
});

describe('parameters', () => {
  test('fallbacks to the alias when region is not given', async () => {
    const $client = insightsClient('my-app-id', 'my-api-key', '', {
      requester: echoRequester(),
    });

    const result = (await $client.pushEvents({
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
  });

  test('uses the correct region', async () => {
    const $client = insightsClient('my-app-id', 'my-api-key', 'us', {
      requester: echoRequester(),
    });

    const result = (await $client.customDelete({
      path: '/test',
    })) as unknown as EchoResponse;

    expect(result.host).toEqual('insights.us.algolia.io');
  });

  test('throws when incorrect region is given', async () => {
    try {
      const $client = insightsClient(
        'my-app-id',
        'my-api-key',
        'not_a_region',
        { requester: echoRequester() }
      );
      throw new Error('test is expected to throw error');
    } catch (e) {
      expect((e as Error).message).toMatch(
        '`region` must be one of the following: de, us'
      );
    }
  });
});
