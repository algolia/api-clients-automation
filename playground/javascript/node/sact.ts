import { ApiError } from '@algolia/client-common';
import { sactClient } from '@algolia/sact';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || '**** SEARCH_KEY *****';

// Init client with appId, apiKey and the region of the application
const client = sactClient(appId, apiKey, 'us');

async function testSact() {
  try {
    const res = await client.listSuggestions({ targetAppId: appId });

    console.log(`[OK]`, res);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace, e);
    }

    console.log('[ERROR]', e);
  }
}

testSact();
