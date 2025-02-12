import type { OptionalWords, SearchParamsObject } from 'algoliasearch';
import { algoliasearch } from 'algoliasearch';

try {
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');
  const query = 'the query';
  const optionalWords: OptionalWords = ['the', 'query'];
  const searchParams: SearchParamsObject = {
    query,
    optionalWords,
  };
  await client.searchSingleIndex({ indexName: 'indexName', searchParams: searchParams });
} catch (e: any) {
  console.error(e.message);
}
