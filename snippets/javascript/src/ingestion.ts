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
    input: { indexName: 'full_name______' },
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
// task without cron
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
    action: 'replace',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the createTaskV1 method.
//
// createTaskOnDemand
export async function snippetForCreateTaskV1(): Promise<void> {
  // >SEPARATOR createTaskV1 default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.createTaskV1({
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

// Snippet for the deleteTaskV1 method.
//
// deleteTaskV1
export async function snippetForDeleteTaskV1(): Promise<void> {
  // >SEPARATOR deleteTaskV1 default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteTaskV1({
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

// Snippet for the disableTaskV1 method.
//
// disableTaskV1
export async function snippetForDisableTaskV1(): Promise<void> {
  // >SEPARATOR disableTaskV1 default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.disableTaskV1({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the enableTask method.
//
// enableTask
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

// Snippet for the enableTaskV1 method.
//
// enableTaskV1
export async function snippetForEnableTaskV1(): Promise<void> {
  // >SEPARATOR enableTaskV1 default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.enableTaskV1({
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

// Snippet for the getTaskV1 method.
//
// getTaskV1
export async function snippetForGetTaskV1(): Promise<void> {
  // >SEPARATOR getTaskV1 default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getTaskV1({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

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

// Snippet for the listAuthentications method.
//
// getAuthentications
export async function snippetForListAuthentications(): Promise<void> {
  // >SEPARATOR listAuthentications default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.listAuthentications();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listDestinations method.
//
// getDestinations
export async function snippetForListDestinations(): Promise<void> {
  // >SEPARATOR listDestinations default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.listDestinations();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listEvents method.
//
// getEvents
export async function snippetForListEvents(): Promise<void> {
  // >SEPARATOR listEvents default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.listEvents({
    runID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listRuns method.
//
// listRuns
export async function snippetForListRuns(): Promise<void> {
  // >SEPARATOR listRuns default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.listRuns();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listSources method.
//
// listSources
export async function snippetForListSources(): Promise<void> {
  // >SEPARATOR listSources default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.listSources();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listTasks method.
//
// listTasks
export async function snippetForListTasks(): Promise<void> {
  // >SEPARATOR listTasks default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.listTasks();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listTasksV1 method.
//
// listTasksV1
export async function snippetForListTasksV1(): Promise<void> {
  // >SEPARATOR listTasksV1 default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.listTasksV1();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listTransformationModels method.
//
// listTransformationModels
export async function snippetForListTransformationModels(): Promise<void> {
  // >SEPARATOR listTransformationModels default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.listTransformationModels();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the listTransformations method.
//
// listTransformations
export async function snippetForListTransformations(): Promise<void> {
  // >SEPARATOR listTransformations default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.listTransformations();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the pushTask method.
//
// pushTask
export async function snippetForPushTask(): Promise<void> {
  // >SEPARATOR pushTask default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.pushTask({
    taskID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    batchWriteParams: {
      requests: [
        { action: 'addObject', body: { key: 'bar', foo: '1' } },
        { action: 'addObject', body: { key: 'baz', foo: '2' } },
      ],
    },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the runSource method.
//
// runSource
export async function snippetForRunSource(): Promise<void> {
  // >SEPARATOR runSource default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.runSource({
    sourceID: '6c02aeb1-775e-418e-870b-1faccd4b2c0f',
    runSourcePayload: {
      indexToInclude: ['products_us', 'products eu'],
      entityIDs: ['1234', '5678'],
      entityType: 'product',
    },
  });

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

// Snippet for the runTaskV1 method.
//
// runTaskV1
export async function snippetForRunTaskV1(): Promise<void> {
  // >SEPARATOR runTaskV1 default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.runTaskV1({
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

// Snippet for the searchTasksV1 method.
//
// searchTasksV1
export async function snippetForSearchTasksV1(): Promise<void> {
  // >SEPARATOR searchTasksV1 default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.searchTasksV1({
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
    transformationIDs: [
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
    taskUpdate: { enabled: false, cron: '* * * * *' },
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the updateTaskV1 method.
//
// updateTaskV1
export async function snippetForUpdateTaskV1(): Promise<void> {
  // >SEPARATOR updateTaskV1 default
  // Initialize the client
  const client = ingestionClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.updateTaskV1({
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
