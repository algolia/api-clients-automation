/* eslint no-console: ["error", { allow: ["log"] }] */

import { insightsClient } from '@algolia/client-insights';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // >SEPARATOR customDelete
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customDelete({ path: '/test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
export async function snippetForcustomGet(): Promise<void> {
  // >SEPARATOR customGet
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customGet({ path: '/test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
export async function snippetForcustomPost(): Promise<void> {
  // >SEPARATOR customPost
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customPost({ path: '/test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
export async function snippetForcustomPut(): Promise<void> {
  // >SEPARATOR customPut
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteUserToken method.
//
// deleteUserToken0
export async function snippetFordeleteUserToken(): Promise<void> {
  // >SEPARATOR deleteUserToken
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteUserToken({ userToken: 'test-user-1' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the pushEvents method.
//
// pushEvents0
export async function snippetForpushEvents(): Promise<void> {
  // >SEPARATOR pushEvents
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

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

  // use typed response
  console.log(response);
  // SEPARATOR<
}
