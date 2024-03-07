/* eslint no-console: ["error", { allow: ["log"] }] */

import { recommendClient } from '@algolia/recommend';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // >SEPARATOR customDelete
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteRecommendRule method.
//
// deleteRecommendRule0
export async function snippetFordeleteRecommendRule(): Promise<void> {
  // >SEPARATOR deleteRecommendRule
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.deleteRecommendRule({
    indexName: 'indexName',
    model: 'related-products',
    objectID: 'objectID',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getRecommendRule method.
//
// getRecommendRule0
export async function snippetForgetRecommendRule(): Promise<void> {
  // >SEPARATOR getRecommendRule
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getRecommendRule({
    indexName: 'indexName',
    model: 'related-products',
    objectID: 'objectID',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getRecommendStatus method.
//
// getRecommendStatus0
export async function snippetForgetRecommendStatus(): Promise<void> {
  // >SEPARATOR getRecommendStatus
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getRecommendStatus({
    indexName: 'indexName',
    model: 'related-products',
    taskID: 12345,
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getRecommendations method.
//
// get recommendations for recommend model with minimal parameters
export async function snippetForgetRecommendations(): Promise<void> {
  // >SEPARATOR getRecommendations
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getRecommendations({
    requests: [
      {
        indexName: 'indexName',
        objectID: 'objectID',
        model: 'related-products',
        threshold: 42,
      },
    ],
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchRecommendRules method.
//
// searchRecommendRules0
export async function snippetForsearchRecommendRules(): Promise<void> {
  // >SEPARATOR searchRecommendRules
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.searchRecommendRules({
    indexName: 'indexName',
    model: 'related-products',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}
