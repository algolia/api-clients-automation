// @ts-nocheck
import { InsightsApi, EchoRequester } from '@algolia/client-insights';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient(): InsightsApi {
  return new InsightsApi(appId, apiKey, { requester: new EchoRequester() });
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
      expect.objectContaining({ connectTimeout: 2, responseTimeout: 30 })
    );
  });
});
