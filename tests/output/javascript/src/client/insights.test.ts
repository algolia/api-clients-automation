/* eslint-disable @typescript-eslint/explicit-function-return-type */
/* eslint-disable prefer-const */
// @ts-nocheck Failing tests will have type errors, but we cannot suppress them even with @ts-expect-error because it doesn't work for a block of lines.
import { insightsClient } from '@experimental-api-clients-automation/client-insights';
import { echoRequester } from '@experimental-api-clients-automation/requester-node-http';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient() {
  return insightsClient(appId, apiKey, 'us', { requester: echoRequester() });
}

describe('api', () => {
  test('calls api with correct user agent', async () => {
    let $client;
    $client = createClient();

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
    let $client;
    $client = createClient();

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

describe('parameters', () => {
  test('fallbacks to the alias when region is not given', async () => {
    let $client;

    let actual;

    await expect(
      new Promise((resolve, reject) => {
        $client = insightsClient('my-app-id', 'my-api-key', '', {
          requester: echoRequester(),
        });

        actual = $client;

        if (actual instanceof Promise) {
          actual.then(resolve).catch(reject);
        } else {
          resolve();
        }
      })
    ).resolves.not.toThrow();

    actual = $client.pushEvents({ events: [] });

    if (actual instanceof Promise) {
      actual = await actual;
    }

    expect(actual).toEqual(
      expect.objectContaining({ host: 'insights.algolia.io' })
    );
  });
});
