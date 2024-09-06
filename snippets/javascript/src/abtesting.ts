// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint no-console: ["error", { allow: ["log"] }] */

// >IMPORT
import { abtestingClient } from '@algolia/client-abtesting';
// IMPORT<

// Snippet for the addABTests method.
//
// addABTests with minimal parameters
export async function snippetForAddABTests(): Promise<void> {
  // >SEPARATOR addABTests default
  // Initialize the client
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  const response = await client.addABTests({
    endAt: '2022-12-31T00:00:00.000Z',
    name: 'myABTest',
    variants: [
      { index: 'AB_TEST_1', trafficPercentage: 30 },
      { index: 'AB_TEST_2', trafficPercentage: 50 },
    ],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForCustomDelete(): Promise<void> {
  // >SEPARATOR customDelete default
  // Initialize the client
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  const response = await client.customDelete({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
export async function snippetForCustomGet(): Promise<void> {
  // >SEPARATOR customGet default
  // Initialize the client
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  const response = await client.customGet({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
export async function snippetForCustomPost(): Promise<void> {
  // >SEPARATOR customPost default
  // Initialize the client
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  const response = await client.customPost({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
export async function snippetForCustomPut(): Promise<void> {
  // >SEPARATOR customPut default
  // Initialize the client
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  const response = await client.customPut({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteABTest method.
//
// deleteABTest
export async function snippetForDeleteABTest(): Promise<void> {
  // >SEPARATOR deleteABTest default
  // Initialize the client
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  const response = await client.deleteABTest({ id: 42 });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getABTest method.
//
// getABTest
export async function snippetForGetABTest(): Promise<void> {
  // >SEPARATOR getABTest default
  // Initialize the client
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  const response = await client.getABTest({ id: 42 });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listABTests method.
//
// listABTests with minimal parameters
export async function snippetForListABTests(): Promise<void> {
  // >SEPARATOR listABTests default
  // Initialize the client
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  const response = await client.listABTests();

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the scheduleABTest method.
//
// scheduleABTest with minimal parameters
export async function snippetForScheduleABTest(): Promise<void> {
  // >SEPARATOR scheduleABTest default
  // Initialize the client
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  const response = await client.scheduleABTest({
    endAt: '2022-12-31T00:00:00.000Z',
    scheduledAt: '2022-11-31T00:00:00.000Z',
    name: 'myABTest',
    variants: [
      { index: 'AB_TEST_1', trafficPercentage: 30 },
      { index: 'AB_TEST_2', trafficPercentage: 50 },
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
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  client.setClientApiKey({ apiKey: 'updated-api-key' });

  // >LOG
  // SEPARATOR<
}

// Snippet for the stopABTest method.
//
// stopABTest
export async function snippetForStopABTest(): Promise<void> {
  // >SEPARATOR stopABTest default
  // Initialize the client
  const client = abtestingClient('YOUR_APP_ID', 'YOUR_API_KEY', 'YOUR_APP_ID_REGION');

  // Call the API
  const response = await client.stopABTest({ id: 42 });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}
