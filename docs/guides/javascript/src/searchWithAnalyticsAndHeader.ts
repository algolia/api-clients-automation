import { algoliasearch } from 'algoliasearch';

import type { SearchParamsObject } from 'algoliasearch';

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

/*
'94.228.178.246' should be replaced with your user's IP address.
Depending on your stack there are multiple ways to get this information.
*/
const ip = '94.228.178.246';
const query = 'query';

const searchParams: SearchParamsObject = {
  query,
  analytics: true,
};

await client.searchSingleIndex(
  { indexName: 'indexName', searchParams: searchParams },
  {
    headers: { 'X-Forwarded-For': ip },
  },
);
