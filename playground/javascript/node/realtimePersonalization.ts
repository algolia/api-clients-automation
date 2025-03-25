import { ApiError } from '@algolia/client-common';
import { realtimePersonalizationClient } from '@algolia/client-realtime-personalization';

const appId = process.env.METIS_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.METIS_API_KEY || '**** ADMIN_KEY *****';

// Init client with appId and apiKey
const client = realtimePersonalizationClient(appId, apiKey, 'us');

async function testRealtimePersonalization() {
  try {
    console.log(appId, apiKey);

    const resp = await client.getUser({userToken: "foo"});

    console.log(resp);

  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace, e);
    }

    console.log('[ERROR]', e);
  }
}

testRealtimePersonalization();
