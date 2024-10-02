import { searchClient, apiClientVersion } from '@algolia/client-search';
import { SearchQuery } from '@algolia/client-search/model';
import { ApiError } from '@algolia/client-common';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_ADMIN_KEY || '**** SEARCH_API_KEY *****';

const searchIndex = process.env.SEARCH_INDEX || 'test_index';
const searchQuery = process.env.SEARCH_QUERY || 'test_query';

// Init client with appId and apiKey
const client = searchClient(appId, apiKey);

client.addAlgoliaAgent('Node playground', '0.0.1');

const requests: SearchQuery[] = [
  { indexName: searchIndex, query: searchQuery },
];
console.log('version', apiClientVersion, 'requests', requests);

async function testSearch() {
  try {
    const res = await client.browseRules({ indexName: "cts_e2e_search_facet", aggregator: (resp: any) => {console.log(resp)} });

    console.log(`[OK]`, res);
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
