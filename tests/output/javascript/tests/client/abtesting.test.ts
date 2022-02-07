/* eslint-disable @typescript-eslint/explicit-function-return-type */
// @ts-nocheck Failing tests will have type errors, but we cannot suppress them even with @ts-expect-error because it doesn't work for a block of lines.
import { abtestingApi } from '@algolia/client-abtesting';
import { EchoRequester } from '@algolia/client-common';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient() {
  return abtestingApi(appId, apiKey, 'us', { requester: new EchoRequester() });
}

describe('api', () => {
  test('calls api with correct user agent', async () => {
    const $client = createClient();

    let actual;

    actual = $client.addABTests({
      name: 'test',
      variant: [{ index: 'my-test-index', trafficPercentage: 90 }],
      endAt: '2022-02-01T13:37:01Z',
    });

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

    actual = $client.addABTests({
      name: 'test',
      variant: [{ index: 'my-test-index', trafficPercentage: 90 }],
      endAt: '2022-02-01T13:37:01Z',
    });

    if (actual instanceof Promise) {
      actual = await actual;
    }

    expect(actual).toEqual(
      expect.objectContaining({ connectTimeout: 1, responseTimeout: 30 })
    );
  });
});

describe('parameters', () => {
  test('does not throw when region is not given', async () => {
    let actual;

    await expect(
      new Promise((resolve, reject) => {
        const $client = abtestingApi('my-app-id', 'my-api-key', '', {
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

  test('does not throw when region is given', async () => {
    let actual;

    await expect(
      new Promise((resolve, reject) => {
        const $client = abtestingApi('my-app-id', 'my-api-key', 'us', {
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
});
