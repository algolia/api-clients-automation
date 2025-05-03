import { algoliasearch } from 'algoliasearch';

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// 1. Change the sort dynamically based on the UI events
const sortByPrice = false;

// 2. Get the index name based on sortByPrice
const indexName = sortByPrice ? 'products_price_desc' : 'products';

// 3. Search on dynamic index name (primary or replica)
await client.searchSingleIndex({ indexName: indexName, searchParams: { query: 'query' } });
