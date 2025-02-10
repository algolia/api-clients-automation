import type { SearchParams } from 'algoliasearch';
import { algoliasearch } from 'algoliasearch';

const getGoogleAnalyticsUserIdFromBrowserCookie = (_: string) => {
  return ''; // Implement your logic here
};

try {
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  const userToken = getGoogleAnalyticsUserIdFromBrowserCookie('_ga');
  let searchParams: SearchParams = {
    query: '<YOUR_SEARCH_QUERY>',
    userToken,
  };

  await client.searchSingleIndex({ indexName: 'indexName', searchParams: searchParams });

  const loggedInUser: string | undefined = undefined;
  searchParams.userToken = loggedInUser ?? userToken;

  await client.searchSingleIndex({ indexName: 'indexName', searchParams: searchParams });
} catch (e) {
  console.error(e);
}
