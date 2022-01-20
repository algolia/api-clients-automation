import { SourcesApi, ApiError } from '@algolia/client-sources';
import dotenv from 'dotenv';

dotenv.config({ path: '../.env' });

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_ADMIN_KEY || '**** ALGOLIA_ADMIN_KEY *****';

// Init client with appId and apiKey
const client = new SourcesApi(appId, apiKey);

async function testSource() {
  try {
    const res = await client.search({
      indexName: searchIndex,
      searchParams: { query: searchQuery },
    });

    console.log(`[OK]`, res);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace);
    }

    console.log('[ERROR]', e);
  }
}

testSource();
