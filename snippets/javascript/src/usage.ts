// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint no-console: ["error", { allow: ["log"] }] */

import { usageClient } from '@algolia/client-usage';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // >SEPARATOR customDelete
  // Initialize the client
  const client = usageClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customDelete({ path: 'test/minimal' });

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
  const client = usageClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customGet({ path: 'test/minimal' });

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
  const client = usageClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customPost({ path: 'test/minimal' });

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
  const client = usageClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customPut({ path: 'test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getIndexUsage method.
//
// getIndexUsage with minimal parameters
export async function snippetForgetIndexUsage(): Promise<void> {
  // >SEPARATOR getIndexUsage
  // Initialize the client
  const client = usageClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getIndexUsage({
    statistic: 'queries_operations',
    indexName: 'myIndexName',
    startDate: '2024-04-03T12:46:43Z',
    endDate: '2024-04-05T12:46:43Z',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getUsage method.
//
// getUsage with minimal parameters
export async function snippetForgetUsage(): Promise<void> {
  // >SEPARATOR getUsage
  // Initialize the client
  const client = usageClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getUsage({
    statistic: 'queries_operations',
    startDate: '2024-04-03T12:46:43Z',
    endDate: '2024-04-05T12:46:43Z',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}
