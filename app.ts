import { searchClient, HttpError } from 'algoliasearch-client-javascript';
import dotenv from 'dotenv';

dotenv.config();

const appId = process.env.ALGOLIA_APPLICATION_ID || '**** APP_ID *****';
const apiKey = process.env.ALGOLIA_SEARCH_KEY || '**** SEARCH_API_KEY *****';

// Init client with appId and apiKey
const client = new searchClient(appId, apiKey);

async function testMultiQueries() {
  try {
    const { response, body } = await client.multipleQueries({
      requests: [
        {
          indexName: 'docsearch',
          query: 'crawler',
        },
      ],
    });

    console.log(`[${response.statusCode} - ${response.statusMessage}]`, body.results);
  } catch (e) {
    if (e instanceof HttpError) {
      console.log(`[${e.statusCode} - ${e.response.statusMessage}]`, e.response);
    }
  }
}

async function testSearch() {
  try {
    const { response, body } = await client.search('docsearch', {
      query: 'crawler',
    });

    console.log(`[${response.statusCode} - ${response.statusMessage}]`, body);
  } catch (e) {
    if (e instanceof HttpError) {
      console.log(`[${e.statusCode} - ${e.response.statusMessage}]`, e.response);
    }
  }
}

// testMultiQueries();
testSearch();
