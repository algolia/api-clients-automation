import { algoliasearch } from 'algoliasearch';

import type { SearchParams } from 'algoliasearch';

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

const d = new Date();
const searchParams: SearchParams = {
  query: '<YOUR_SEARCH_QUERY>',
  filters: `date_timestamp > ${Math.floor(d.setDate(d.getDate() - 365) / 1000)}`,
};

await client.searchSingleIndex({ indexName: 'indexName', searchParams: searchParams });
