import { algoliasearch } from 'algoliasearch';

import type { SearchParams } from 'algoliasearch';

const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

// Implement your logic here
const getUserToken = () => {
  return '';
};

// Set the searchParams and get the current user token
const searchParams: SearchParams = {
  query: 'User search query',
  enableABTest: true,
};
const userToken = getUserToken();

// Is the user token anonymous?
if (userToken === null || userToken === undefined || userToken === 'YOUR_ANONYMOUS_USER_TOKEN') {
  // Disable A/B testing for this request
  searchParams.enableABTest = false;
} else {
  // Set the user token to the current user token
  searchParams.userToken = userToken;
}

try {
  // Perform the searchSingleIndex
  const result = await client.searchSingleIndex({ indexName: 'indexName', searchParams: searchParams });
  // SearchSingleIndex results
  console.log(result);
} catch (err) {
  // SearchSingleIndex errors
  console.error(err);
}
