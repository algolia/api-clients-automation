/* eslint no-console: ["error", { allow: ["log"] }] */

import { ingestionClient } from '@algolia/ingestion';

// Snippet for the createAuthentication method.
//
// createAuthenticationOAuth
export async function snippetForcreateAuthentication(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.createAuthentication({
    type: 'oauth',
    name: 'authName',
    input: {
      url: 'http://test.oauth',
      client_id: 'myID',
      client_secret: 'mySecret',
    },
  });

  // Use typed response
  console.log(response);
}

// Snippet for the createDestination method.
//
// createDestination
export async function snippetForcreateDestination(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.createDestination({
    type: 'search',
    name: 'destinationName',
    input: { indexPrefix: 'prefix_' },
    authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the createSource method.
//
// createSource
export async function snippetForcreateSource(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.createSource({
    type: 'commercetools',
    name: 'sourceName',
    input: {
      storeKeys: ['myStore'],
      locales: ['de'],
      url: 'http://commercetools.com',
      projectKey: 'keyID',
    },
    authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the createTask method.
//
// createTaskOnDemand
export async function snippetForcreateTask(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.createTask({
    sourceID: 'search',
    destinationID: 'destinationName',
    trigger: { type: 'onDemand' },
    action: 'replace',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
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
  const client = ingestionClient(
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
  const client = ingestionClient(
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
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // Use typed response
  console.log(response);
}

// Snippet for the deleteAuthentication method.
//
// deleteAuthentication
export async function snippetFordeleteAuthentication(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteAuthentication({
    authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the deleteDestination method.
//
// deleteDestination
export async function snippetFordeleteDestination(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteDestination({
    destinationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the deleteSource method.
//
// deleteSource
export async function snippetFordeleteSource(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteSource({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the deleteTask method.
//
// deleteTask
export async function snippetFordeleteTask(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the disableTask method.
//
// disableTask
export async function snippetFordisableTask(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.disableTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the enableTask method.
//
// enable task e2e
export async function snippetForenableTask(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.enableTask({
    taskID: '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getAuthentication method.
//
// getAuthentication
export async function snippetForgetAuthentication(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getAuthentication({
    authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getAuthentications method.
//
// getAuthentications
export async function snippetForgetAuthentications(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getAuthentications();

  // Use typed response
  console.log(response);
}

// Snippet for the getDestination method.
//
// getDestination
export async function snippetForgetDestination(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getDestination({
    destinationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getDestinations method.
//
// getDestinations
export async function snippetForgetDestinations(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getDestinations();

  // Use typed response
  console.log(response);
}

// Snippet for the getDockerSourceStreams method.
//
// getDockerSourceStreams
export async function snippetForgetDockerSourceStreams(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getDockerSourceStreams({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getEvent method.
//
// getEvent
export async function snippetForgetEvent(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getEvent({
    runID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    eventID: '6c02aeb1-775e-418e-870b-1faccd4b2c0c',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getEvents method.
//
// getEvents
export async function snippetForgetEvents(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getEvents({
    runID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getRun method.
//
// getRun
export async function snippetForgetRun(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getRun({
    runID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getRuns method.
//
// getRuns
export async function snippetForgetRuns(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getRuns();

  // Use typed response
  console.log(response);
}

// Snippet for the getSource method.
//
// getSource
export async function snippetForgetSource(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getSource({
    sourceID: '75eeb306-51d3-4e5e-a279-3c92bd8893ac',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getSources method.
//
// getSources
export async function snippetForgetSources(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getSources();

  // Use typed response
  console.log(response);
}

// Snippet for the getTask method.
//
// getTask
export async function snippetForgetTask(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getTasks method.
//
// getTasks
export async function snippetForgetTasks(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTasks();

  // Use typed response
  console.log(response);
}

// Snippet for the runTask method.
//
// runTask
export async function snippetForrunTask(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.runTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the searchAuthentications method.
//
// searchAuthentications
export async function snippetForsearchAuthentications(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.searchAuthentications({
    authenticationIDs: [
      '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
    ],
  });

  // Use typed response
  console.log(response);
}

// Snippet for the searchDestinations method.
//
// searchDestinations
export async function snippetForsearchDestinations(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.searchDestinations({
    destinationIDs: [
      '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
    ],
  });

  // Use typed response
  console.log(response);
}

// Snippet for the searchSources method.
//
// searchSources
export async function snippetForsearchSources(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.searchSources({
    sourceIDs: [
      '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
    ],
  });

  // Use typed response
  console.log(response);
}

// Snippet for the searchTasks method.
//
// searchTasks
export async function snippetForsearchTasks(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.searchTasks({
    taskIDs: [
      '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
      '76ab4c2a-ce17-496f-b7a6-506dc59ee498',
    ],
  });

  // Use typed response
  console.log(response);
}

// Snippet for the triggerDockerSourceDiscover method.
//
// triggerDockerSourceDiscover
export async function snippetFortriggerDockerSourceDiscover(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.triggerDockerSourceDiscover({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the updateAuthentication method.
//
// updateAuthentication
export async function snippetForupdateAuthentication(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.updateAuthentication({
    authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    authenticationUpdate: { name: 'newName' },
  });

  // Use typed response
  console.log(response);
}

// Snippet for the updateDestination method.
//
// updateDestination
export async function snippetForupdateDestination(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.updateDestination({
    destinationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    destinationUpdate: { name: 'newName' },
  });

  // Use typed response
  console.log(response);
}

// Snippet for the updateSource method.
//
// updateSource
export async function snippetForupdateSource(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.updateSource({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    sourceUpdate: { name: 'newName' },
  });

  // Use typed response
  console.log(response);
}

// Snippet for the updateTask method.
//
// updateTask
export async function snippetForupdateTask(): Promise<void> {
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.updateTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    taskUpdate: { enabled: false },
  });

  // Use typed response
  console.log(response);
}
