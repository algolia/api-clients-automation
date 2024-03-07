/* eslint no-console: ["error", { allow: ["log"] }] */

import { analyticsClient } from '@algolia/client-analytics';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // >SEPARATOR customDelete
  // Initialize the client
  const client = analyticsClient(
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
  const client = analyticsClient(
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
  const client = analyticsClient(
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
  const client = analyticsClient(
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

// Snippet for the getAverageClickPosition method.
//
// get getAverageClickPosition with minimal parameters
export async function snippetForgetAverageClickPosition(): Promise<void> {
  // >SEPARATOR getAverageClickPosition
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getAverageClickPosition({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getClickPositions method.
//
// get getClickPositions with minimal parameters
export async function snippetForgetClickPositions(): Promise<void> {
  // >SEPARATOR getClickPositions
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getClickPositions({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getClickThroughRate method.
//
// get getClickThroughRate with minimal parameters
export async function snippetForgetClickThroughRate(): Promise<void> {
  // >SEPARATOR getClickThroughRate
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getClickThroughRate({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getConversationRate method.
//
// get getConversationRate with minimal parameters
export async function snippetForgetConversationRate(): Promise<void> {
  // >SEPARATOR getConversationRate
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getConversationRate({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getNoClickRate method.
//
// get getNoClickRate with minimal parameters
export async function snippetForgetNoClickRate(): Promise<void> {
  // >SEPARATOR getNoClickRate
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getNoClickRate({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getNoResultsRate method.
//
// get getNoResultsRate with minimal parameters
export async function snippetForgetNoResultsRate(): Promise<void> {
  // >SEPARATOR getNoResultsRate
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getNoResultsRate({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getSearchesCount method.
//
// get getSearchesCount with minimal parameters
export async function snippetForgetSearchesCount(): Promise<void> {
  // >SEPARATOR getSearchesCount
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getSearchesCount({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getSearchesNoClicks method.
//
// get getSearchesNoClicks with minimal parameters
export async function snippetForgetSearchesNoClicks(): Promise<void> {
  // >SEPARATOR getSearchesNoClicks
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getSearchesNoClicks({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getSearchesNoResults method.
//
// get getSearchesNoResults with minimal parameters
export async function snippetForgetSearchesNoResults(): Promise<void> {
  // >SEPARATOR getSearchesNoResults
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getSearchesNoResults({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getStatus method.
//
// get getStatus with minimal parameters
export async function snippetForgetStatus(): Promise<void> {
  // >SEPARATOR getStatus
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getStatus({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTopCountries method.
//
// get getTopCountries with minimal parameters
export async function snippetForgetTopCountries(): Promise<void> {
  // >SEPARATOR getTopCountries
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopCountries({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTopFilterAttributes method.
//
// get getTopFilterAttributes with minimal parameters
export async function snippetForgetTopFilterAttributes(): Promise<void> {
  // >SEPARATOR getTopFilterAttributes
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopFilterAttributes({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTopFilterForAttribute method.
//
// get getTopFilterForAttribute with minimal parameters
export async function snippetForgetTopFilterForAttribute(): Promise<void> {
  // >SEPARATOR getTopFilterForAttribute
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTopFiltersNoResults method.
//
// get getTopFiltersNoResults with minimal parameters
export async function snippetForgetTopFiltersNoResults(): Promise<void> {
  // >SEPARATOR getTopFiltersNoResults
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopFiltersNoResults({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTopHits method.
//
// get getTopHits with minimal parameters
export async function snippetForgetTopHits(): Promise<void> {
  // >SEPARATOR getTopHits
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopHits({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTopSearches method.
//
// get getTopSearches with minimal parameters
export async function snippetForgetTopSearches(): Promise<void> {
  // >SEPARATOR getTopSearches
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTopSearches({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getUsersCount method.
//
// get getUsersCount with minimal parameters
export async function snippetForgetUsersCount(): Promise<void> {
  // >SEPARATOR getUsersCount
  // Initialize the client
  const client = analyticsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getUsersCount({ index: 'index' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}
