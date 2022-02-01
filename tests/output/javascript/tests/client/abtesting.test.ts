// @ts-nocheck
import { AbtestingApi, EchoRequester } from '@algolia/client-abtesting';

const appId = process.env.ALGOLIA_APPLICATION_ID || 'Algolia-API-Key';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'Algolia-Application-Id';

function createClient(): AbtestingApi {
  return new AbtestingApi(appId, apiKey, 'us', {
    requester: new EchoRequester(),
  });
}

describe('basic', () => {
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
