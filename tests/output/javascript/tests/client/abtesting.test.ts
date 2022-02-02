// @ts-nocheck
import { AbtestingApi, EchoRequester } from '@algolia/client-abtesting';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient(): AbtestingApi {
  return new AbtestingApi(appId, apiKey, 'us', {
    requester: new EchoRequester(),
  });
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
      expect.objectContaining({ connectTimeout: 2, responseTimeout: 30 })
    );
  });
});

describe('parameters', () => {
  test('throws when region is not given', async () => {
    let actual;
    await expect(
      new Promise((resolve, reject) => {
        const $client = new AbtestingApi('my-app-id', 'my-api-key', '', {
          requester: new EchoRequester(),
        });
        actual = $client;

        if (actual instanceof Promise) {
          actual.then(resolve).catch(reject);
        } else {
          resolve();
        }
      })
    ).rejects.toThrow('`region` is missing.');
  });

  test('does not throw when region is given', async () => {
    let actual;

    await expect(
      new Promise((resolve, reject) => {
        const $client = new AbtestingApi('my-app-id', 'my-api-key', 'us', {
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
