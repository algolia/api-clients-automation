import { ApiError } from '@algolia/client-common';
import type { SearchQuery } from '@algolia/client-search';
import { apiClientVersion, searchClient } from '@algolia/client-search';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_ADMIN_KEY || '**** SEARCH_API_KEY *****';

const searchIndex = process.env.SEARCH_INDEX || 'test_index';
const searchQuery = process.env.SEARCH_QUERY || 'test_query';

// Init client with appId and apiKey
const client = searchClient(appId, apiKey);

client.addAlgoliaAgent('Node playground', '0.0.1');

const requests: SearchQuery[] = [{ indexName: searchIndex, query: searchQuery }];
console.log('version', apiClientVersion, 'requests', requests);

interface Animal {
  name: string;
  age: number;
  objectID: string;
}

async function testSearch() {
  try {
    const req = await client.setSettings({
      indexName: 'theIndexName',
      indexSettings: { distinct: true },
    });

    console.log(`[OK]`, req);

    const a: Animal = {
      name: 'Dog',
      age: 5,
      objectID: 'dog-123',
    };

    const ssss = await client.saveObject({
      indexName: 'theIndexName',
      body: a,
    });
  } catch (e: any) {
    // Instance of
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace);
    }

    // Other way
    if (e.name === 'RetryError') {
      return console.log(`[${e.name}] ${e.message}`, e.stackTrace);
    }

    console.log('[ERROR]', e);
  }
}

testSearch();
