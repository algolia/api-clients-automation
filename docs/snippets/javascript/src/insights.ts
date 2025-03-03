// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

// >IMPORT
import { algoliasearch } from 'algoliasearch';
// IMPORT<

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForCustomDelete(): Promise<void> {
  // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customDelete({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with all parameters
export async function snippetForCustomDelete1(): Promise<void> {
  // >SEPARATOR customDelete allow del method for a custom path with all parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customDelete({ path: 'test/all', parameters: { query: 'parameters' } });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
export async function snippetForCustomGet(): Promise<void> {
  // >SEPARATOR customGet allow get method for a custom path with minimal parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customGet({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with all parameters
export async function snippetForCustomGet1(): Promise<void> {
  // >SEPARATOR customGet allow get method for a custom path with all parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customGet({ path: 'test/all', parameters: { query: 'parameters with space' } });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// requestOptions should be escaped too
export async function snippetForCustomGet2(): Promise<void> {
  // >SEPARATOR customGet requestOptions should be escaped too
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customGet(
    { path: 'test/all', parameters: { query: 'to be overriden' } },
    {
      queryParameters: { query: 'parameters with space', 'and an array': ['array', 'with spaces'] },
      headers: { 'x-header-1': 'spaces are left alone' },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
export async function snippetForCustomPost(): Promise<void> {
  // >SEPARATOR customPost allow post method for a custom path with minimal parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with all parameters
export async function snippetForCustomPost1(): Promise<void> {
  // >SEPARATOR customPost allow post method for a custom path with all parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost({
    path: 'test/all',
    parameters: { query: 'parameters' },
    body: { body: 'parameters' },
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions can override default query parameters
export async function snippetForCustomPost2(): Promise<void> {
  // >SEPARATOR customPost requestOptions can override default query parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { query: 'myQueryParameter' },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions merges query parameters with default ones
export async function snippetForCustomPost3(): Promise<void> {
  // >SEPARATOR customPost requestOptions merges query parameters with default ones
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { query2: 'myQueryParameter' },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions can override default headers
export async function snippetForCustomPost4(): Promise<void> {
  // >SEPARATOR customPost requestOptions can override default headers
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      headers: { 'x-algolia-api-key': 'ALGOLIA_API_KEY' },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions merges headers with default ones
export async function snippetForCustomPost5(): Promise<void> {
  // >SEPARATOR customPost requestOptions merges headers with default ones
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      headers: { 'x-algolia-api-key': 'ALGOLIA_API_KEY' },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions queryParameters accepts booleans
export async function snippetForCustomPost6(): Promise<void> {
  // >SEPARATOR customPost requestOptions queryParameters accepts booleans
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { isItWorking: true },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions queryParameters accepts integers
export async function snippetForCustomPost7(): Promise<void> {
  // >SEPARATOR customPost requestOptions queryParameters accepts integers
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { myParam: 2 },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions queryParameters accepts list of string
export async function snippetForCustomPost8(): Promise<void> {
  // >SEPARATOR customPost requestOptions queryParameters accepts list of string
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { myParam: ['b and c', 'd'] },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions queryParameters accepts list of booleans
export async function snippetForCustomPost9(): Promise<void> {
  // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { myParam: [true, true, false] },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions queryParameters accepts list of integers
export async function snippetForCustomPost10(): Promise<void> {
  // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { myParam: [1, 2] },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
export async function snippetForCustomPut(): Promise<void> {
  // >SEPARATOR customPut allow put method for a custom path with minimal parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPut({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with all parameters
export async function snippetForCustomPut1(): Promise<void> {
  // >SEPARATOR customPut allow put method for a custom path with all parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.customPut({
    path: 'test/all',
    parameters: { query: 'parameters' },
    body: { body: 'parameters' },
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteUserToken method.
//
// deleteUserToken
export async function snippetForDeleteUserToken(): Promise<void> {
  // >SEPARATOR deleteUserToken default
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  await client.deleteUserToken({ userToken: 'test-user-1' });

  // >LOG
  // SEPARATOR<
}

// Snippet for the pushEvents method.
//
// pushEvents
export async function snippetForPushEvents(): Promise<void> {
  // >SEPARATOR pushEvents pushEvents
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.pushEvents({
    events: [
      {
        eventType: 'click',
        eventName: 'Product Clicked',
        index: 'products',
        userToken: 'user-123456',
        authenticatedUserToken: 'user-123456',
        timestamp: 1641290601962,
        objectIDs: ['9780545139700', '9780439784542'],
        queryID: '43b15df305339e827f0ac0bdc5ebcaa7',
        positions: [7, 6],
      },
    ],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the pushEvents method.
//
// Many events type
export async function snippetForPushEvents1(): Promise<void> {
  // >SEPARATOR pushEvents Many events type
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.pushEvents({
    events: [
      {
        eventType: 'conversion',
        eventName: 'Product Purchased',
        index: 'products',
        userToken: 'user-123456',
        authenticatedUserToken: 'user-123456',
        timestamp: 1740787200000,
        objectIDs: ['9780545139700', '9780439784542'],
        queryID: '43b15df305339e827f0ac0bdc5ebcaa7',
      },
      {
        eventType: 'view',
        eventName: 'Product Detail Page Viewed',
        index: 'products',
        userToken: 'user-123456',
        authenticatedUserToken: 'user-123456',
        timestamp: 1740787200000,
        objectIDs: ['9780545139700', '9780439784542'],
      },
    ],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the pushEvents method.
//
// ConvertedObjectIDsAfterSearch
export async function snippetForPushEvents2(): Promise<void> {
  // >SEPARATOR pushEvents ConvertedObjectIDsAfterSearch
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.pushEvents({
    events: [
      {
        eventType: 'conversion',
        eventName: 'Product Purchased',
        index: 'products',
        userToken: 'user-123456',
        authenticatedUserToken: 'user-123456',
        timestamp: 1641290601962,
        objectIDs: ['9780545139700', '9780439784542'],
        queryID: '43b15df305339e827f0ac0bdc5ebcaa7',
      },
    ],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the pushEvents method.
//
// ViewedObjectIDs
export async function snippetForPushEvents3(): Promise<void> {
  // >SEPARATOR pushEvents ViewedObjectIDs
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.pushEvents({
    events: [
      {
        eventType: 'view',
        eventName: 'Product Detail Page Viewed',
        index: 'products',
        userToken: 'user-123456',
        authenticatedUserToken: 'user-123456',
        timestamp: 1641290601962,
        objectIDs: ['9780545139700', '9780439784542'],
      },
    ],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the pushEvents method.
//
// AddedToCartObjectIDs
export async function snippetForPushEvents4(): Promise<void> {
  // >SEPARATOR pushEvents AddedToCartObjectIDs
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  const response = await client.pushEvents({
    events: [
      {
        eventType: 'conversion',
        eventSubtype: 'addToCart',
        eventName: 'Product Added To Cart',
        index: 'products',
        queryID: '43b15df305339e827f0ac0bdc5ebcaa7',
        userToken: 'user-123456',
        authenticatedUserToken: 'user-123456',
        timestamp: 1641290601962,
        objectIDs: ['9780545139700', '9780439784542'],
        objectData: [
          { price: 19.99, quantity: 10, discount: 2.5 },
          { price: '8$', quantity: 7, discount: '30%' },
        ],
        currency: 'USD',
      },
    ],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the setClientApiKey method.
//
// switch API key
export function snippetForSetClientApiKey(): void {
  // >SEPARATOR setClientApiKey default
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initInsights({ region: 'us' });

  // Call the API
  client.setClientApiKey({ apiKey: 'updated-api-key' });

  // >LOG
  // SEPARATOR<
}
