import { algoliasearch } from 'algoliasearch';

import type { SearchParams } from 'algoliasearch';

const getAppIDFor = (_: string) => {
  return ''; // Implement your own logic here
};
const getIndexingApiKeyFor = (_: string) => {
  return ''; // Implement your own logic here
};

// Fetch from your own data storage and with your own code
// the associated application ID and API key for this user
const appID = getAppIDFor('user42');
const apiKey = getIndexingApiKeyFor('user42');

const client = algoliasearch(appID, apiKey);
const searchParams: SearchParams = {
  query: '<YOUR_SEARCH_QUERY>',
  facetFilters: ['user:user42', 'user:public'],
};

await client.searchSingleIndex({ indexName: 'indexName', searchParams: searchParams });
