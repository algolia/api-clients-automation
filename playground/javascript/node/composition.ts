import { ApiError } from '@algolia/client-common';
import { compositionClient } from '@algolia/client-composition';

const appId = process.env.METIS_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.METIS_API_KEY || '**** ADMIN_KEY *****';

// Init client with appId and apiKey
const client = compositionClient(appId, apiKey);

async function testComposition() {
  try {
    // create a new composition
    /*
    const res = await client.multipleBatch({
      requests: [
        {
          action: 'upsert',
          body: {
            objectID: 'id1',
            description: 'the first ever composition from the client',
            behavior: {
              injection: {
                main: {
                  source: {
                    search: {
                      index: 'cts_e2e_small',
                    },
                  },
                },
              },
            },
          },
        },
      ],
    });
    console.log(`[OK]`, res);
    */

    const compos = await client.listCompositions();

    console.log(`[OK]`, compos);
  } catch (e) {
    if (e instanceof ApiError) {
      return console.log(`[${e.status}] ${e.message}`, e.stackTrace, e);
    }

    console.log('[ERROR]', e);
  }
}

testComposition();
