import { SearchApi } from '@algolia/client-search';

const appId = process.env.ALGOLIA_APPLICATION_ID || 'test_app_id';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || 'test_api_key';

function createClient() {
  return new SearchApi(appId, apiKey);
}

async function createIndex() {
  // TODO
}

describe('basic', () => {
  test('client throws with invalid parameters', async () => {
    let result;
    expect(() => {
      const $client = new SearchApi('', 'blah');
      result = $client;
    }).toThrowError('appId is missing!');
  });

  test('client has instance variables for appId and apiKey', async () => {
    let result;

    const $client = new SearchApi('my-app-id', 'my-api-key');
    result = $client;

    result = $client.appId;

    result = $client.apiKey;
  });

  test('sets user agent', async () => {
    const $client = createClient();

    let result;

    result = await $client.setUserAgent('hello');

    result = await $client.getUserAgent();
  });

  test('save objects and perform a basic search', async () => {
    const $client = createClient();
    const $index = await createIndex();

    let result;

    result = await $index.saveObjects(
      [
        {
          objectID: 'julien-lemoine',
          company: 'Algolia',
          name: 'Julien Lemoine',
        },
        {
          objectID: 'nicolas-dessaigne',
          company: 'Algolia',
          name: 'Nicolas Dessaigne',
        },
        { company: 'Amazon', name: 'Jeff Bezos' },
        { company: 'Apple', name: 'Steve Jobs' },
        { company: 'Apple', name: 'Steve Wozniak' },
        { company: 'Arista Networks', name: 'Jayshree Ullal' },
        { company: 'Google', name: 'Larry Page' },
        { company: 'Google', name: 'Rob Pike' },
        { company: 'Google', name: 'Serguey Brin' },
        { company: 'Microsoft', name: 'Bill Gates' },
        { company: 'SpaceX', name: 'Elon Musk' },
        { company: 'Tesla', name: 'Elon Musk' },
        { company: 'Yahoo', name: 'Marissa Mayer' },
      ],
      { autoGenerateObjectIDIfNotExist: true }
    );

    result = await $index.setSettings({
      attributesForFaceting: ['searchable(company)'],
    });

    result = await $index.search('algolia');

    result = await $index.search('elon', {
      facets: ['*'],
      facetFilters: [['company:tesla', 'company:spacex']],
    });

    expect(result).toHaveLength(2);
  });
});
