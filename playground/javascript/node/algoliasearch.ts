import { ApiError } from '@algolia/client-common';
import { algoliasearch } from 'algoliasearch';
import { liteClient } from 'algoliasearch/lite';

import type { SearchResponses } from 'algoliasearch';

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || '**** SEARCH_API_KEY *****';
const adminApiKey = process.env.ALGOLIA_ADMIN_KEY || '**** ADMIN_API_KEY *****';

const searchIndex = process.env.SEARCH_INDEX || 'test_index';
const searchQuery = process.env.SEARCH_QUERY || 'test_query';
const analyticsIndex = process.env.ANALYTICS_INDEX || 'test_index';

async function testAlgoliasearch() {
  // Init client with appId and apiKey
  const client = algoliasearch(appId, apiKey);
  const clientLite = liteClient(appId, apiKey);
  
  client.addAlgoliaAgent('algoliasearch node playground', '0.0.1');

  try {
    const res: SearchResponses = await client.search({
      requests: [
        {
          indexName: searchIndex,
          query: searchQuery,
          hitsPerPage: 50,
        },
      ],
    });

    client.generateSecuredApiKey({
      parentApiKey: 'foo',
      restrictions: {
        validUntil: 200,
      },
    });

    const resLite: SearchResponses = await clientLite.search({
      requests: [
        {
          indexName: searchIndex,
          query: searchQuery,
          hitsPerPage: 50,
        },
      ],
    });

    console.log(`[OK search]`, res);
    console.log(`[OK search LITE]`, resLite);

    const resWithLegacySignature: SearchResponses = await client.search([
      {
        indexName: searchIndex,
        params: {
          query: searchQuery,
          hitsPerPage: 50,
        },
      },
    ]);

    const resWithLegacySignatureLite: SearchResponses = await clientLite.search([
      {
        indexName: searchIndex,
        params: {
          query: searchQuery,
          hitsPerPage: 50,
        },
      },
    ]);

    console.log(`[OK legacy search]`, resWithLegacySignature);
    console.log(`[OK legacy search LITE ]`, resWithLegacySignatureLite);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace);
    }

    console.log('[ERROR search]', e);
  }

  try {
    const analyticsClient = client.initAnalytics({ region: 'de' });

    const res = await analyticsClient.getTopFilterForAttribute({
      attribute: 'myAttribute1,myAttribute2',
      index: analyticsIndex,
    });

    console.log(`[OK analytics]`, res);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace);
    }

    console.log('[ERROR analytics]', e);
  }

  try {
    const abtestingClient = client.initAbtesting({ region: 'us' });

    const res = await abtestingClient.getABTest({
      id: 42,
    });

    console.log(`[OK abtesting]`, res);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace);
    }

    console.log('[ERROR abtesting]', e);
  }

  try {
    const personalizationClient = client.initPersonalization({
      region: 'eu',
    });

    const res = await personalizationClient.getUserTokenProfile({
      userToken: 'wouhou',
    });

    console.log(`[OK personalization]`, res);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace);
    }

    console.log('[ERROR personalization]', e);
  }
}

async function testAlgoliasearchBridgeIngestion() {
  // Init client with appId and apiKey
  const client = algoliasearch(appId, adminApiKey, { transformation: { region: 'eu'}});

  await client.saveObjectsWithTransformation({indexName: "foo", objects: [{objectID: "foo", data: {baz: "baz", win: 42}}], waitForTasks: true })

  await client.partialUpdateObjectsWithTransformation({indexName: "foo", objects: [{objectID: "foo", data: {baz: "baz", win: 42}}], waitForTasks: true, createIfNotExists: false })
}

// testAlgoliasearch();
testAlgoliasearchBridgeIngestion()
