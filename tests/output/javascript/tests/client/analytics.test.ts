/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable require-await */
/* eslint-disable @typescript-eslint/explicit-function-return-type */
import { AnalyticsApi, EchoRequester } from '@algolia/client-analytics';

const appId = process.env.ALGOLIA_APPLICATION_ID || 'Algolia-API-Key';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'Algolia-Application-Id';

function createClient() {
  return new AnalyticsApi(appId, apiKey, 'us', {
    requester: new EchoRequester(),
  });
}

async function createIndex() {}

describe('basic', () => {
  test('does not throw when region is not given', async () => {
    let actual;

    expect(async () => {
      const $client = new AnalyticsApi(
        'my-app-id',
        'my-api-key',

        {
          requester: new EchoRequester(),
        }
      );
      actual = $client;
    }).not.toThrowError();
  });

  test('getAverageClickPosition throws without index', async () => {
    const $client = createClient();

    let actual;
    expect(async () => {
      actual = await $client.getClickPositions({});
    }).toThrowError(
      'Required parameter index was null or undefined when calling getAverageClickPosition.'
    );
  });
});
