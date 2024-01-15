/* eslint no-console: ["error", { allow: ["log"] }] */

import { recommendClient } from '@algolia/recommend';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // Use typed response
  console.log(response);
}

// Snippet for the deleteRecommendRule method.
//
// deleteRecommendRule0
export async function snippetFordeleteRecommendRule(): Promise<void> {
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.deleteRecommendRule({
    indexName: 'indexName',
    model: 'related-products',
    objectID: 'objectID',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getRecommendRule method.
//
// getRecommendRule0
export async function snippetForgetRecommendRule(): Promise<void> {
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getRecommendRule({
    indexName: 'indexName',
    model: 'related-products',
    objectID: 'objectID',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getRecommendStatus method.
//
// getRecommendStatus0
export async function snippetForgetRecommendStatus(): Promise<void> {
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getRecommendStatus({
    indexName: 'indexName',
    model: 'related-products',
    taskID: 12345,
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getRecommendations method.
//
// get recommendations for recommend model with minimal parameters
export async function snippetForgetRecommendations(): Promise<void> {
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

  // Use typed response
  console.log(response);
}

// Snippet for the searchRecommendRules method.
//
// searchRecommendRules0
export async function snippetForsearchRecommendRules(): Promise<void> {
  // Initialize the client
  const client = recommendClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.searchRecommendRules({
    indexName: 'indexName',
    model: 'related-products',
  });

  // Use typed response
  console.log(response);
}
