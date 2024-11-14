import { ApiError } from '@algolia/client-common';
import { compositionClient } from '@algolia/client-composition';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_ADMIN_KEY || '**** ADMIN_KEY *****';

// Init client with appId and apiKey
const client = compositionClient(appId, apiKey);

async function testComposition() {
  try {
    const res = await client.listCompositions();

    console.log(`[OK]`, res);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace, e);
    }

    console.log('[ERROR]', e);
  }
}

testComposition();
