import recommendClient from '@algolia/recommend';
import { ApiError } from '@algolia/client-common';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || '**** SEARCH_API_KEY *****';

const searchIndex = process.env.SEARCH_INDEX || 'test_index';
const searchQuery = process.env.SEARCH_QUERY || 'test_query';

console.log("######################")
console.log({ recommendClient })

// Init client with appId and apiKey
const client = recommendClient(appId, apiKey);

async function testGetRecommendations() {
  try {
    const res = await client.getRecommendations({
      requests: [
        {
          indexName: searchIndex,
          model: 'bought-together',
          objectID: searchQuery,
          threshold: 0,
        },
      ],
    });

    console.log('[OK] GetRecommendations', res);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace);
    }

    console.log('[ERROR] GetRecommendations', e);
  }
}



async function testRecommend() {
  await testGetRecommendations();
}

testRecommend();
