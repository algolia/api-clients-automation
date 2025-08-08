import { ApiError } from '@algolia/client-common';
import { collectionsClient } from '@algolia/collections';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_ADMIN_KEY || '**** ADMIN_KEY *****';
const indexName = process.env.SEARCH_INDEX || '**** INDEX_NAME *****';

// Init client with appId and apiKey
const client = collectionsClient(appId, apiKey);

async function testCollections() {
  try {
    // list collections
    console.log(await client.listCollections({ indexName }));
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace, e);
    }

    console.log('[ERROR]', e);
  }
}

testCollections();
