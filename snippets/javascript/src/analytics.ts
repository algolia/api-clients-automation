/* eslint no-console: ["error", { allow: ["log"] }] */

import { analyticsClient } from '@algolia/client-analytics';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
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
  const client = analyticsClient(
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
  const client = analyticsClient(
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
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // Use typed response
  console.log(response);
}

// Snippet for the getAverageClickPosition method.
//
// get getAverageClickPosition with minimal parameters
export async function snippetForgetAverageClickPosition(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getAverageClickPosition({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getClickPositions method.
//
// get getClickPositions with minimal parameters
export async function snippetForgetClickPositions(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getClickPositions({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getClickThroughRate method.
//
// get getClickThroughRate with minimal parameters
export async function snippetForgetClickThroughRate(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getClickThroughRate({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getConversationRate method.
//
// get getConversationRate with minimal parameters
export async function snippetForgetConversationRate(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getConversationRate({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getNoClickRate method.
//
// get getNoClickRate with minimal parameters
export async function snippetForgetNoClickRate(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getNoClickRate({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getNoResultsRate method.
//
// get getNoResultsRate with minimal parameters
export async function snippetForgetNoResultsRate(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getNoResultsRate({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getSearchesCount method.
//
// get getSearchesCount with minimal parameters
export async function snippetForgetSearchesCount(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getSearchesCount({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getSearchesNoClicks method.
//
// get getSearchesNoClicks with minimal parameters
export async function snippetForgetSearchesNoClicks(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getSearchesNoClicks({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getSearchesNoResults method.
//
// get getSearchesNoResults with minimal parameters
export async function snippetForgetSearchesNoResults(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getSearchesNoResults({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getStatus method.
//
// get getStatus with minimal parameters
export async function snippetForgetStatus(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getStatus({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getTopCountries method.
//
// get getTopCountries with minimal parameters
export async function snippetForgetTopCountries(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopCountries({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getTopFilterAttributes method.
//
// get getTopFilterAttributes with minimal parameters
export async function snippetForgetTopFilterAttributes(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopFilterAttributes({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getTopFilterForAttribute method.
//
// get getTopFilterForAttribute with minimal parameters
export async function snippetForgetTopFilterForAttribute(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopFilterForAttribute({
    attribute: 'myAttribute',
    index: 'index',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getTopFiltersNoResults method.
//
// get getTopFiltersNoResults with minimal parameters
export async function snippetForgetTopFiltersNoResults(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopFiltersNoResults({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getTopHits method.
//
// get getTopHits with minimal parameters
export async function snippetForgetTopHits(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopHits({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getTopSearches method.
//
// get getTopSearches with minimal parameters
export async function snippetForgetTopSearches(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopSearches({ index: 'index' });

  // Use typed response
  console.log(response);
}

// Snippet for the getUsersCount method.
//
// get getUsersCount with minimal parameters
export async function snippetForgetUsersCount(): Promise<void> {
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getUsersCount({ index: 'index' });

  // Use typed response
  console.log(response);
}
