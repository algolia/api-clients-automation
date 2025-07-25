import { analyticsClient } from '@algolia/client-analytics';
import { ApiError } from '@algolia/client-common';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_ANALYTICS_KEY || '**** ANALYTICS_API_KEY *****';

const analyticsIndex = process.env.ANALYTICS_INDEX || 'test_index';

// Init client with appId and apiKey
const client = analyticsClient(appId, apiKey, 'de');

async function testAnalytics() {
  try {
    const res = await client.getTopFilterForAttribute(
      {
        attribute: 'myAttribute1,myAttribute2',
        index: analyticsIndex,
      },
      { timeouts: { read: 20000, write: 30000 } },
    );

    console.log(`[OK]`, res);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace, e);
    }

    console.log('[ERROR]', e);
  }
}

testAnalytics();
