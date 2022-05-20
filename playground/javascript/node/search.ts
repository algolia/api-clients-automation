import { searchClient } from '@experimental-api-clients-automation/client-search';
import { ApiError } from '@experimental-api-clients-automation/client-common';
import dotenv from 'dotenv';
import { echoRequester } from '@experimental-api-clients-automation/requester-node-http';

dotenv.config({ path: '../../.env' });

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || '**** SEARCH_API_KEY *****';

const searchIndex = process.env.SEARCH_INDEX || 'test_index';
const searchQuery = process.env.SEARCH_QUERY || 'test_query';

// Init client with appId and apiKey
const client = searchClient(appId, apiKey);

client.addAlgoliaAgent('Node playground', '0.0.1');

async function testSearch() {
  try {
    const res = await client.search({
      requests: [
        {
          indexName: searchIndex,
          query: searchQuery,
        },
      ],
    });

    console.log(`[OK]`, res);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace);
    }

    console.log('[ERROR]', e);
  }
}

testSearch();
