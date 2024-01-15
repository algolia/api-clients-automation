/* eslint no-console: ["error", { allow: ["log"] }] */

import { abtestingClient } from '@algolia/client-abtesting';

// Snippet for the addABTests method.
//
// addABTests with minimal parameters
export async function snippetForaddABTests(): Promise<void> {
  const client = abtestingClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.addABTests({
    endAt: '2022-12-31T00:00:00.000Z',
    name: 'myABTest',
    variants: [
      { index: 'AB_TEST_1', trafficPercentage: 30 },
      { index: 'AB_TEST_2', trafficPercentage: 50 },
    ],
  });

  // use typed response
  console.log(response);
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  const client = abtestingClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.customDelete({ path: '/test/minimal' });

  // use typed response
  console.log(response);
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
export async function snippetForcustomGet(): Promise<void> {
  const client = abtestingClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.customGet({ path: '/test/minimal' });

  // use typed response
  console.log(response);
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
export async function snippetForcustomPost(): Promise<void> {
  const client = abtestingClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.customPost({ path: '/test/minimal' });

  // use typed response
  console.log(response);
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
export async function snippetForcustomPut(): Promise<void> {
  const client = abtestingClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.customPut({ path: '/test/minimal' });

  // use typed response
  console.log(response);
}

// Snippet for the deleteABTest method.
//
// deleteABTest
export async function snippetFordeleteABTest(): Promise<void> {
  const client = abtestingClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.deleteABTest({ id: 42 });

  // use typed response
  console.log(response);
}

// Snippet for the getABTest method.
//
// getABTest
export async function snippetForgetABTest(): Promise<void> {
  const client = abtestingClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getABTest({ id: 42 });

  // use typed response
  console.log(response);
}

// Snippet for the listABTests method.
//
// listABTests with minimal parameters
export async function snippetForlistABTests(): Promise<void> {
  const client = abtestingClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.listABTests();

  // use typed response
  console.log(response);
}

// Snippet for the stopABTest method.
//
// stopABTest
export async function snippetForstopABTest(): Promise<void> {
  const client = abtestingClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.stopABTest({ id: 42 });

  // use typed response
  console.log(response);
}
