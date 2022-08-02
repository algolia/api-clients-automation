import {
  BrowseResponse,
  Rule,
  searchClient,
  SearchRulesResponse,
  SearchSynonymsResponse,
} from '@algolia/client-search';
import { ApiError, createIterablePromise } from '@algolia/client-common';
import dotenv from 'dotenv';

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
    const records: Record<string, any> = [];

    await client.browseObjects({
      indexName: 'gatsbyjs',

      aggregator: (response) => records.push(...response.hits),
    });

    console.log(records, records.length);
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
