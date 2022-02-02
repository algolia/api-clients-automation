// @ts-nocheck
import { AnalyticsApi, EchoRequester } from '@algolia/client-analytics';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient(): AnalyticsApi {
  return new AnalyticsApi(appId, apiKey, 'us', {
    requester: new EchoRequester(),
  });
}

describe('api', () => {
  test('calls api with correct user agent', async () => {
    const $client = createClient();

    let actual;

    actual = $client.getAverageClickPosition({ index: 'my-index' });

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

    actual = $client.getAverageClickPosition({ index: 'my-index' });

    if (actual instanceof Promise) {
      actual = await actual;
    }

    expect(actual).toEqual(
      expect.objectContaining({ connectTimeout: 2, responseTimeout: 5 })
    );
  });
});

describe('parameters', () => {
  test('does not throw when region is not given', async () => {
    let actual;

    await expect(
      new Promise((resolve, reject) => {
        const $client = new AnalyticsApi('my-app-id', 'my-api-key', '', {
          requester: new EchoRequester(),
        });
        actual = $client;

        if (actual instanceof Promise) {
          actual.then(resolve).catch(reject);
        } else {
          resolve();
        }
      })
    ).resolves.not.toThrow();
  });

  test('getAverageClickPosition throws without index', async () => {
    const $client = createClient();

    let actual;
    await expect(
      new Promise((resolve, reject) => {
        actual = $client.getClickPositions({});
        if (actual instanceof Promise) {
          actual.then(resolve).catch(reject);
        } else {
          resolve();
        }
      })
    ).rejects.toThrow(
      'Parameter `index` is required when calling `getClickPositions`.'
    );
  });
});
