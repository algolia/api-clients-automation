// @ts-nocheck
import { RecommendApi, EchoRequester } from '@algolia/recommend';

const appId = process.env.ALGOLIA_APPLICATION_ID || 'Algolia-API-Key';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'Algolia-Application-Id';

function createClient(): RecommendApi {
  return new RecommendApi(appId, apiKey, { requester: new EchoRequester() });
}

describe('api', () => {
  test('calls api with correct user agent', async () => {
    const $client = createClient();

    let actual;

    actual = $client.getRecommendations({ requests: [] });

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

    actual = $client.getRecommendations({ requests: [] });

    if (actual instanceof Promise) {
      actual = await actual;
    }

    expect(actual).toEqual(
      expect.objectContaining({ connectTimeout: 2, responseTimeout: 30 })
    );
  });
});
