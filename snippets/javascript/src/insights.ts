/* eslint no-console: ["error", { allow: ["log"] }] */

import { insightsClient } from '@algolia/client-insights';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customDelete({ path: '/test/minimal' });

  // Use typed response
  console.log(response);
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
export async function snippetForcustomGet(): Promise<void> {
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customGet({ path: '/test/minimal' });

  // Use typed response
  console.log(response);
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
export async function snippetForcustomPost(): Promise<void> {
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customPost({ path: '/test/minimal' });

  // Use typed response
  console.log(response);
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
export async function snippetForcustomPut(): Promise<void> {
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // Use typed response
  console.log(response);
}

// Snippet for the deleteUserToken method.
//
// deleteUserToken0
export async function snippetFordeleteUserToken(): Promise<void> {
  // Initialize the client
  const client = insightsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteUserToken({ userToken: 'test-user-1' });

  // Use typed response
  console.log(response);
}

// Snippet for the pushEvents method.
//
// pushEvents0
export async function snippetForpushEvents(): Promise<void> {
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

  // Use typed response
  console.log(response);
}
