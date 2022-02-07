/* eslint-disable @typescript-eslint/explicit-function-return-type */
// @ts-nocheck Failing tests will have type errors, but we cannot suppress them even with @ts-expect-error because it doesn't work for a block of lines.
import { EchoRequester } from '@algolia/client-common';
import { insightsApi } from '@algolia/client-insights';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient() {
  return insightsApi(appId, apiKey, 'us', { requester: new EchoRequester() });
}

describe('api', () => {
  test('calls api with correct user agent', async () => {
    const $client = createClient();

    let actual;

    actual = $client.pushEvents({ events: [] });

    if (actual instanceof Promise) {
      actual = await actual;
    }

    expect(actual.userAgent).toMatch(
      /Algolia%20for%20(.+)%20\(\d+\.\d+\.\d+\)/
    );
  });

  test('calls api with correct timeouts', async () => {
    const $client = createClient();

    let actual;

    actual = $client.pushEvents({ events: [] });

    if (actual instanceof Promise) {
      actual = await actual;
    }

    expect(actual).toEqual(
      expect.objectContaining({ connectTimeout: 1, responseTimeout: 30 })
    );
  });
});
