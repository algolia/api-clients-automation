/* eslint no-console: ["error", { allow: ["log"] }] */

import { personalizationClient } from '@algolia/client-personalization';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // Initialize the client
  const client = personalizationClient(
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
  const client = personalizationClient(
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
  const client = personalizationClient(
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
  const client = personalizationClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // Use typed response
  console.log(response);
}

// Snippet for the deleteUserProfile method.
//
// delete deleteUserProfile
export async function snippetFordeleteUserProfile(): Promise<void> {
  // Initialize the client
  const client = personalizationClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteUserProfile({ userToken: 'UserToken' });

  // Use typed response
  console.log(response);
}

// Snippet for the getPersonalizationStrategy method.
//
// get getPersonalizationStrategy
export async function snippetForgetPersonalizationStrategy(): Promise<void> {
  // Initialize the client
  const client = personalizationClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getPersonalizationStrategy();

  // Use typed response
  console.log(response);
}

// Snippet for the getUserTokenProfile method.
//
// get getUserTokenProfile
export async function snippetForgetUserTokenProfile(): Promise<void> {
  // Initialize the client
  const client = personalizationClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getUserTokenProfile({ userToken: 'UserToken' });

  // Use typed response
  console.log(response);
}

// Snippet for the setPersonalizationStrategy method.
//
// set setPersonalizationStrategy
export async function snippetForsetPersonalizationStrategy(): Promise<void> {
  // Initialize the client
  const client = personalizationClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.setPersonalizationStrategy({
    eventScoring: [{ score: 42, eventName: 'Algolia', eventType: 'Event' }],
    facetScoring: [{ score: 42, facetName: 'Event' }],
    personalizationImpact: 42,
  });

  // Use typed response
  console.log(response);
}
