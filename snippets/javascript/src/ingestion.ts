/* eslint no-console: ["error", { allow: ["log"] }] */

import { ingestionClient } from '@algolia/ingestion';

// Snippet for the createAuthentication method.
//
// createAuthenticationOAuth
export async function snippetForcreateAuthentication(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

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
}

// Snippet for the createDestination method.
//
// createDestination
export async function snippetForcreateDestination(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.createDestination({
    type: 'search',
    name: 'destinationName',
    input: { indexPrefix: 'prefix_' },
    authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the createSource method.
//
// createSource
export async function snippetForcreateSource(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

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
}

// Snippet for the createTask method.
//
// createTaskOnDemand
export async function snippetForcreateTask(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.createTask({
    sourceID: 'search',
    destinationID: 'destinationName',
    trigger: { type: 'onDemand' },
    action: 'replace',
  });

  // use typed response
  console.log(response);
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.customDelete({ path: '/test/minimal' });

  // use typed response
  console.log(response);
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
export async function snippetForcustomGet(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.customGet({ path: '/test/minimal' });

  // use typed response
  console.log(response);
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
export async function snippetForcustomPost(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.customPost({ path: '/test/minimal' });

  // use typed response
  console.log(response);
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
export async function snippetForcustomPut(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.customPut({ path: '/test/minimal' });

  // use typed response
  console.log(response);
}

// Snippet for the deleteAuthentication method.
//
// deleteAuthentication
export async function snippetFordeleteAuthentication(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.deleteAuthentication({
    authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the deleteDestination method.
//
// deleteDestination
export async function snippetFordeleteDestination(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.deleteDestination({
    destinationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the deleteSource method.
//
// deleteSource
export async function snippetFordeleteSource(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.deleteSource({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the deleteTask method.
//
// deleteTask
export async function snippetFordeleteTask(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.deleteTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the disableTask method.
//
// disableTask
export async function snippetFordisableTask(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.disableTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the enableTask method.
//
// enableTask
export async function snippetForenableTask(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.enableTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the getAuthentication method.
//
// getAuthentication
export async function snippetForgetAuthentication(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getAuthentication({
    authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the getAuthentications method.
//
// getAuthentications
export async function snippetForgetAuthentications(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getAuthentications();

  // use typed response
  console.log(response);
}

// Snippet for the getDestination method.
//
// getDestination
export async function snippetForgetDestination(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getDestination({
    destinationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the getDestinations method.
//
// getDestinations
export async function snippetForgetDestinations(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getDestinations();

  // use typed response
  console.log(response);
}

// Snippet for the getDockerSourceStreams method.
//
// getDockerSourceStreams
export async function snippetForgetDockerSourceStreams(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getDockerSourceStreams({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the getEvent method.
//
// getEvent
export async function snippetForgetEvent(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getEvent({
    runID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    eventID: '6c02aeb1-775e-418e-870b-1faccd4b2c0c',
  });

  // use typed response
  console.log(response);
}

// Snippet for the getEvents method.
//
// getEvents
export async function snippetForgetEvents(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getEvents({
    runID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the getRun method.
//
// getRun
export async function snippetForgetRun(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getRun({
    runID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the getRuns method.
//
// getRuns
export async function snippetForgetRuns(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getRuns();

  // use typed response
  console.log(response);
}

// Snippet for the getSource method.
//
// getSource
export async function snippetForgetSource(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getSource({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the getSources method.
//
// getSources
export async function snippetForgetSources(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getSources();

  // use typed response
  console.log(response);
}

// Snippet for the getTask method.
//
// getTask
export async function snippetForgetTask(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the getTasks method.
//
// getTasks
export async function snippetForgetTasks(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.getTasks();

  // use typed response
  console.log(response);
}

// Snippet for the runTask method.
//
// runTask
export async function snippetForrunTask(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.runTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the searchAuthentications method.
//
// searchAuthentications
export async function snippetForsearchAuthentications(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.searchAuthentications({
    authenticationIDs: [
      '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
    ],
  });

  // use typed response
  console.log(response);
}

// Snippet for the searchDestinations method.
//
// searchDestinations
export async function snippetForsearchDestinations(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.searchDestinations({
    destinationIDs: [
      '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
    ],
  });

  // use typed response
  console.log(response);
}

// Snippet for the searchSources method.
//
// searchSources
export async function snippetForsearchSources(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.searchSources({
    sourceIDs: [
      '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
    ],
  });

  // use typed response
  console.log(response);
}

// Snippet for the searchTasks method.
//
// searchTasks
export async function snippetForsearchTasks(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.searchTasks({
    taskIDs: [
      '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
      '947ac9c4-7e58-4c87-b1e7-14a68e99699a',
    ],
  });

  // use typed response
  console.log(response);
}

// Snippet for the triggerDockerSourceDiscover method.
//
// triggerDockerSourceDiscover
export async function snippetFortriggerDockerSourceDiscover(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.triggerDockerSourceDiscover({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
}

// Snippet for the updateAuthentication method.
//
// updateAuthentication
export async function snippetForupdateAuthentication(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.updateAuthentication({
    authenticationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    authenticationUpdate: { name: 'newName' },
  });

  // use typed response
  console.log(response);
}

// Snippet for the updateDestination method.
//
// updateDestination
export async function snippetForupdateDestination(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.updateDestination({
    destinationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    destinationUpdate: { name: 'newName' },
  });

  // use typed response
  console.log(response);
}

// Snippet for the updateSource method.
//
// updateSource
export async function snippetForupdateSource(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.updateSource({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    sourceUpdate: { name: 'newName' },
  });

  // use typed response
  console.log(response);
}

// Snippet for the updateTask method.
//
// updateTask
export async function snippetForupdateTask(): Promise<void> {
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  const response = await client.updateTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    taskUpdate: { enabled: false },
  });

  // use typed response
  console.log(response);
}
