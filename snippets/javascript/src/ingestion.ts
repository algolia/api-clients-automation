/* eslint no-console: ["error", { allow: ["log"] }] */

import { ingestionClient } from '@algolia/ingestion';

// Snippet for the createAuthentication method.
//
// createAuthenticationOAuth
export async function snippetForcreateAuthentication(): Promise<void> {
  // >SEPARATOR createAuthentication
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the createDestination method.
//
// createDestination
export async function snippetForcreateDestination(): Promise<void> {
  // >SEPARATOR createDestination
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the createSource method.
//
// createSource
export async function snippetForcreateSource(): Promise<void> {
  // >SEPARATOR createSource
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the createTask method.
//
// createTaskOnDemand
export async function snippetForcreateTask(): Promise<void> {
  // >SEPARATOR createTask
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // >SEPARATOR customDelete
  // Initialize the client
  const client = ingestionClient(
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
  const client = ingestionClient(
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
  const client = ingestionClient(
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
  const client = ingestionClient(
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

// Snippet for the deleteAuthentication method.
//
// deleteAuthentication
export async function snippetFordeleteAuthentication(): Promise<void> {
  // >SEPARATOR deleteAuthentication
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteDestination method.
//
// deleteDestination
export async function snippetFordeleteDestination(): Promise<void> {
  // >SEPARATOR deleteDestination
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteSource method.
//
// deleteSource
export async function snippetFordeleteSource(): Promise<void> {
  // >SEPARATOR deleteSource
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteTask method.
//
// deleteTask
export async function snippetFordeleteTask(): Promise<void> {
  // >SEPARATOR deleteTask
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the disableTask method.
//
// disableTask
export async function snippetFordisableTask(): Promise<void> {
  // >SEPARATOR disableTask
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the enableTask method.
//
// enable task e2e
export async function snippetForenableTask(): Promise<void> {
  // >SEPARATOR enableTask
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getAuthentication method.
//
// getAuthentication
export async function snippetForgetAuthentication(): Promise<void> {
  // >SEPARATOR getAuthentication
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getAuthentications method.
//
// getAuthentications
export async function snippetForgetAuthentications(): Promise<void> {
  // >SEPARATOR getAuthentications
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getAuthentications();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getDestination method.
//
// getDestination
export async function snippetForgetDestination(): Promise<void> {
  // >SEPARATOR getDestination
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getDestinations method.
//
// getDestinations
export async function snippetForgetDestinations(): Promise<void> {
  // >SEPARATOR getDestinations
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getDestinations();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getDockerSourceStreams method.
//
// getDockerSourceStreams
export async function snippetForgetDockerSourceStreams(): Promise<void> {
  // >SEPARATOR getDockerSourceStreams
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getEvent method.
//
// getEvent
export async function snippetForgetEvent(): Promise<void> {
  // >SEPARATOR getEvent
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getEvents method.
//
// getEvents
export async function snippetForgetEvents(): Promise<void> {
  // >SEPARATOR getEvents
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getRun method.
//
// getRun
export async function snippetForgetRun(): Promise<void> {
  // >SEPARATOR getRun
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getRuns method.
//
// getRuns
export async function snippetForgetRuns(): Promise<void> {
  // >SEPARATOR getRuns
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getRuns();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getSource method.
//
// getSource
export async function snippetForgetSource(): Promise<void> {
  // >SEPARATOR getSource
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getSources method.
//
// getSources
export async function snippetForgetSources(): Promise<void> {
  // >SEPARATOR getSources
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getSources();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTask method.
//
// getTask
export async function snippetForgetTask(): Promise<void> {
  // >SEPARATOR getTask
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTasks method.
//
// getTasks
export async function snippetForgetTasks(): Promise<void> {
  // >SEPARATOR getTasks
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTasks();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the runTask method.
//
// runTask
export async function snippetForrunTask(): Promise<void> {
  // >SEPARATOR runTask
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchAuthentications method.
//
// searchAuthentications
export async function snippetForsearchAuthentications(): Promise<void> {
  // >SEPARATOR searchAuthentications
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchDestinations method.
//
// searchDestinations
export async function snippetForsearchDestinations(): Promise<void> {
  // >SEPARATOR searchDestinations
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchSources method.
//
// searchSources
export async function snippetForsearchSources(): Promise<void> {
  // >SEPARATOR searchSources
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the searchTasks method.
//
// searchTasks
export async function snippetForsearchTasks(): Promise<void> {
  // >SEPARATOR searchTasks
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the triggerDockerSourceDiscover method.
//
// triggerDockerSourceDiscover
export async function snippetFortriggerDockerSourceDiscover(): Promise<void> {
  // >SEPARATOR triggerDockerSourceDiscover
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the updateAuthentication method.
//
// updateAuthentication
export async function snippetForupdateAuthentication(): Promise<void> {
  // >SEPARATOR updateAuthentication
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the updateDestination method.
//
// updateDestination
export async function snippetForupdateDestination(): Promise<void> {
  // >SEPARATOR updateDestination
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the updateSource method.
//
// updateSource
export async function snippetForupdateSource(): Promise<void> {
  // >SEPARATOR updateSource
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the updateTask method.
//
// updateTask
export async function snippetForupdateTask(): Promise<void> {
  // >SEPARATOR updateTask
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}
