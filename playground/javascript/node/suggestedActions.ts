import { ApiError } from '@algolia/client-common';
import { suggestedActionsClient } from '@algolia/suggested-actions';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || '**** SEARCH_KEY *****';

// Init client with appId, apiKey and the region of the application
const client = suggestedActionsClient(appId, apiKey, 'us');

async function testSuggestedActions() {
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

testSuggestedActions();
