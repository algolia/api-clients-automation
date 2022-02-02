// @ts-nocheck
import { SourcesApi, EchoRequester } from '@algolia/client-sources';

const appId = 'test-app-id';
const apiKey = 'test-api-key';

function createClient(): SourcesApi {
  return new SourcesApi(appId, apiKey, 'us', {
    requester: new EchoRequester(),
  });
}

describe('api', () => {
  test('calls api with correct user agent', async () => {
    const $client = createClient();

    let actual;

    actual = $client.postIngestUrl({ type: 'csv', input: { url: '...' } });

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

    actual = $client.postIngestUrl({ type: 'csv', input: { url: '...' } });

    if (actual instanceof Promise) {
      actual = await actual;
    }

    expect(actual).toEqual(
      expect.objectContaining({ connectTimeout: 2, responseTimeout: 30 })
    );
  });
});
