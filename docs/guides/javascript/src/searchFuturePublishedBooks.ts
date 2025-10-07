import { algoliasearch } from 'algoliasearch';

import type { SearchParams } from 'algoliasearch';

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

const dateTimestamp = Date.now();
const searchParams: SearchParams = {
  query: '<YOUR_SEARCH_QUERY>',
  filters: `date_timestamp > ${dateTimestamp}`,
};

await client.searchSingleIndex({ indexName: 'indexName', searchParams: searchParams });
