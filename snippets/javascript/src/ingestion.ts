// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
/* eslint no-console: ["error", { allow: ["log"] }] */

// >IMPORT
import { ingestionClient } from '@algolia/ingestion';
// IMPORT<

// Snippet for the createAuthentication method.
//
// createAuthenticationOAuth
export async function snippetForCreateAuthentication(): Promise<void> {
  // >SEPARATOR createAuthentication default
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
export async function snippetForCreateDestination(): Promise<void> {
  // >SEPARATOR createDestination default
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
export async function snippetForCreateSource(): Promise<void> {
  // >SEPARATOR createSource default
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
export async function snippetForCreateTask(): Promise<void> {
  // >SEPARATOR createTask default
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

// Snippet for the createTransformation method.
//
// createTransformation
export async function snippetForCreateTransformation(): Promise<void> {
  // >SEPARATOR createTransformation default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.createTransformation({
    code: 'foo',
    name: 'bar',
    description: 'baz',
  });

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
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customDelete({ path: 'test/minimal' });

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
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customGet({ path: 'test/minimal' });

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
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customPost({ path: 'test/minimal' });

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
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customPut({ path: 'test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteAuthentication method.
//
// deleteAuthentication
export async function snippetForDeleteAuthentication(): Promise<void> {
  // >SEPARATOR deleteAuthentication default
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
export async function snippetForDeleteDestination(): Promise<void> {
  // >SEPARATOR deleteDestination default
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
export async function snippetForDeleteSource(): Promise<void> {
  // >SEPARATOR deleteSource default
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
export async function snippetForDeleteTask(): Promise<void> {
  // >SEPARATOR deleteTask default
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

// Snippet for the deleteTransformation method.
//
// deleteTransformation
export async function snippetForDeleteTransformation(): Promise<void> {
  // >SEPARATOR deleteTransformation default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteTransformation({
    transformationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the disableTask method.
//
// disableTask
export async function snippetForDisableTask(): Promise<void> {
  // >SEPARATOR disableTask default
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
export async function snippetForEnableTask(): Promise<void> {
  // >SEPARATOR enableTask default
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
export async function snippetForGetAuthentication(): Promise<void> {
  // >SEPARATOR getAuthentication default
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
export async function snippetForGetAuthentications(): Promise<void> {
  // >SEPARATOR getAuthentications default
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
export async function snippetForGetDestination(): Promise<void> {
  // >SEPARATOR getDestination default
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
export async function snippetForGetDestinations(): Promise<void> {
  // >SEPARATOR getDestinations default
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

// Snippet for the getEvent method.
//
// getEvent
export async function snippetForGetEvent(): Promise<void> {
  // >SEPARATOR getEvent default
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
export async function snippetForGetEvents(): Promise<void> {
  // >SEPARATOR getEvents default
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
export async function snippetForGetRun(): Promise<void> {
  // >SEPARATOR getRun default
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
export async function snippetForGetRuns(): Promise<void> {
  // >SEPARATOR getRuns default
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
export async function snippetForGetSource(): Promise<void> {
  // >SEPARATOR getSource default
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
export async function snippetForGetSources(): Promise<void> {
  // >SEPARATOR getSources default
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
export async function snippetForGetTask(): Promise<void> {
  // >SEPARATOR getTask default
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
export async function snippetForGetTasks(): Promise<void> {
  // >SEPARATOR getTasks default
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

// Snippet for the getTransformation method.
//
// getTransformation
export async function snippetForGetTransformation(): Promise<void> {
  // >SEPARATOR getTransformation default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTransformation({
    transformationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getTransformations method.
//
// getTransformations
export async function snippetForGetTransformations(): Promise<void> {
  // >SEPARATOR getTransformations default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTransformations();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the runTask method.
//
// runTask
export async function snippetForRunTask(): Promise<void> {
  // >SEPARATOR runTask default
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
export async function snippetForSearchAuthentications(): Promise<void> {
  // >SEPARATOR searchAuthentications default
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
export async function snippetForSearchDestinations(): Promise<void> {
  // >SEPARATOR searchDestinations default
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
export async function snippetForSearchSources(): Promise<void> {
  // >SEPARATOR searchSources default
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
export async function snippetForSearchTasks(): Promise<void> {
  // >SEPARATOR searchTasks default
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

// Snippet for the searchTransformations method.
//
// searchTransformations
export async function snippetForSearchTransformations(): Promise<void> {
  // >SEPARATOR searchTransformations default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.searchTransformations({
    transformationsIDs: [
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
export async function snippetForTriggerDockerSourceDiscover(): Promise<void> {
  // >SEPARATOR triggerDockerSourceDiscover default
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

// Snippet for the tryTransformations method.
//
// tryTransformations
export async function snippetForTryTransformations(): Promise<void> {
  // >SEPARATOR tryTransformations default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.tryTransformations({
    code: 'foo',
    sampleRecord: { bar: 'baz' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the updateAuthentication method.
//
// updateAuthentication
export async function snippetForUpdateAuthentication(): Promise<void> {
  // >SEPARATOR updateAuthentication default
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
export async function snippetForUpdateDestination(): Promise<void> {
  // >SEPARATOR updateDestination default
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
export async function snippetForUpdateSource(): Promise<void> {
  // >SEPARATOR updateSource default
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
export async function snippetForUpdateTask(): Promise<void> {
  // >SEPARATOR updateTask default
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

// Snippet for the updateTransformation method.
//
// updateTransformation
export async function snippetForUpdateTransformation(): Promise<void> {
  // >SEPARATOR updateTransformation default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.updateTransformation({
    transformationID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    transformationCreate: { code: 'foo', name: 'bar', description: 'baz' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the validateSource method.
//
// validateSource
export async function snippetForValidateSource(): Promise<void> {
  // >SEPARATOR validateSource default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.validateSource({
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

// Snippet for the validateSourceBeforeUpdate method.
//
// validateSourceBeforeUpdate
export async function snippetForValidateSourceBeforeUpdate(): Promise<void> {
  // >SEPARATOR validateSourceBeforeUpdate default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.validateSourceBeforeUpdate({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    sourceUpdate: { name: 'newName' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}
