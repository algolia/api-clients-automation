import { algoliasearch } from 'algoliasearch';

import type { SearchParams } from 'algoliasearch';

const getBuyerAccountId = () => {
  return ''; // Implement your logic here
};

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// get the buyer account information
const buyer = getBuyerAccountId();
const searchParams: SearchParams = {
  query: '<YOUR_SEARCH_QUERY>',
  ruleContexts: [buyer],
};

await client.searchSingleIndex({ indexName: 'indexName', searchParams: searchParams });
