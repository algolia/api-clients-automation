// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

// >IMPORT
import { recommendClient } from '@algolia/recommend';
// IMPORT<

// Snippet for the batchRecommendRules method.
//
// batch recommend rules
export async function snippetForBatchRecommendRules(): Promise<void> {
  // >SEPARATOR batchRecommendRules default
  // Initialize the client
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.batchRecommendRules({ indexName: 'indexName', model: 'related-products' });

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
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

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
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

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
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

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
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.customPut({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteRecommendRule method.
//
// deleteRecommendRule
export async function snippetForDeleteRecommendRule(): Promise<void> {
  // >SEPARATOR deleteRecommendRule default
  // Initialize the client
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.deleteRecommendRule({
    indexName: 'indexName',
    model: 'related-products',
    objectID: 'objectID',
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getRecommendRule method.
//
// getRecommendRule
export async function snippetForGetRecommendRule(): Promise<void> {
  // >SEPARATOR getRecommendRule default
  // Initialize the client
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.getRecommendRule({
    indexName: 'indexName',
    model: 'related-products',
    objectID: 'objectID',
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getRecommendStatus method.
//
// getRecommendStatus
export async function snippetForGetRecommendStatus(): Promise<void> {
  // >SEPARATOR getRecommendStatus default
  // Initialize the client
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.getRecommendStatus({
    indexName: 'indexName',
    model: 'related-products',
    taskID: 12345,
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getRecommendations method.
//
// get recommendations for recommend model with minimal parameters
export async function snippetForGetRecommendations(): Promise<void> {
  // >SEPARATOR getRecommendations default
  // Initialize the client
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.getRecommendations({
    requests: [{ indexName: 'indexName', objectID: 'objectID', model: 'related-products', threshold: 42.1 }],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchRecommendRules method.
//
// searchRecommendRules
export async function snippetForSearchRecommendRules(): Promise<void> {
  // >SEPARATOR searchRecommendRules default
  // Initialize the client
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.searchRecommendRules({ indexName: 'indexName', model: 'related-products' });

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
  //
  const client = recommendClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  client.setClientApiKey({ apiKey: 'updated-api-key' });

  // >LOG
  // SEPARATOR<
}
