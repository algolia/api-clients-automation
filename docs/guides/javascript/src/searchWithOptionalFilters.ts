import { algoliasearch } from 'algoliasearch';

import type { OptionalFilters, SearchParams } from 'algoliasearch';

const labels: string[] = []; // A list of labels

const reduceLabelsToFilters = (_labels: string[]): OptionalFilters => {
  return []; // Implement your logic here
};

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

const optionalFilters = reduceLabelsToFilters(labels);
const searchParams: SearchParams = {
  query: '<YOUR_SEARCH_QUERY>',
  optionalFilters: optionalFilters,
};

await client.searchSingleIndex({ indexName: 'indexName', searchParams: searchParams });
