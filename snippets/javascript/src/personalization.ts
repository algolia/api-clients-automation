/* eslint no-console: ["error", { allow: ["log"] }] */

import { personalizationClient } from '@algolia/client-personalization';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // >SEPARATOR customDelete
  // Initialize the client
  const client = personalizationClient(
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
  const client = personalizationClient(
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
  const client = personalizationClient(
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
  const client = personalizationClient(
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

// Snippet for the deleteUserProfile method.
//
// delete deleteUserProfile
export async function snippetFordeleteUserProfile(): Promise<void> {
  // >SEPARATOR deleteUserProfile
  // Initialize the client
  const client = personalizationClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteUserProfile({ userToken: 'UserToken' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getPersonalizationStrategy method.
//
// get getPersonalizationStrategy
export async function snippetForgetPersonalizationStrategy(): Promise<void> {
  // >SEPARATOR getPersonalizationStrategy
  // Initialize the client
  const client = personalizationClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getPersonalizationStrategy();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getUserTokenProfile method.
//
// get getUserTokenProfile
export async function snippetForgetUserTokenProfile(): Promise<void> {
  // >SEPARATOR getUserTokenProfile
  // Initialize the client
  const client = personalizationClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getUserTokenProfile({ userToken: 'UserToken' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the setPersonalizationStrategy method.
//
// set setPersonalizationStrategy
export async function snippetForsetPersonalizationStrategy(): Promise<void> {
  // >SEPARATOR setPersonalizationStrategy
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}
