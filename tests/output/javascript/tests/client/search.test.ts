/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable require-await */
/* eslint-disable @typescript-eslint/explicit-function-return-type */
import { SearchApi, EchoRequester } from '@algolia/client-search';

const appId = process.env.ALGOLIA_APPLICATION_ID || 'Algolia-API-Key';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'Algolia-Application-Id';

function createClient() {
  return new SearchApi(appId, apiKey, 'us', { requester: new EchoRequester() });
}

async function createIndex() {}

describe('basic', () => {
  test('client throws with invalid parameters', async () => {
    let actual;
    expect(async () => {
      const $client = new SearchApi(
        '',
        'blah',

        {
          requester: new EchoRequester(),
        }
      );
      actual = $client;
    }).toThrowError('appId is missing!');
  });

  test('sets user agent', async () => {
    const $client = createClient();

    let actual;

    actual = await $client.setUserAgent('hello');

    actual = await $client.getUserAgent();
  });
});
