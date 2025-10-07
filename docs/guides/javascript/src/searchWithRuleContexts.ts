import { algoliasearch } from 'algoliasearch';

import type { SearchParams } from 'algoliasearch';

const getPlatformTag = () => {
  return ''; // Implement your logic here
};

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

const platformTag = getPlatformTag();
const searchParams: SearchParams = {
  query: '<YOUR_SEARCH_QUERY>',
  ruleContexts: [platformTag],
};

await client.searchSingleIndex({ indexName: 'indexName', searchParams: searchParams });
