import { ApiError, createIterablePromise } from '@algolia/client-common';
import { ingestionClient } from '@algolia/ingestion';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_ADMIN_KEY || '**** ADMIN_KEY *****';

// Init client with appId and apiKey
const client = ingestionClient(appId, apiKey, 'us', {
  authMode: 'WithinHeaders',
  hosts: [{ url: 'staging-data.us.algolia.com', accept: 'readWrite', protocol: 'https' }],
});

async function testIngestion() {
  try {
    const res = await client.listAuthentications();

    console.log(`[OK]`, res);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace, e);
    }

    console.log('[ERROR]', e);
  }
}

testIngestion();
