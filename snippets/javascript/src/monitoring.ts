/* eslint no-console: ["error", { allow: ["log"] }] */

import { monitoringClient } from '@algolia/monitoring';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // >SEPARATOR customDelete
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getClusterIncidents method.
//
// getClusterIncidents
export async function snippetForgetClusterIncidents(): Promise<void> {
  // >SEPARATOR getClusterIncidents
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getClusterIncidents({ clusters: 'c1-de' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getClusterStatus method.
//
// getClusterStatus
export async function snippetForgetClusterStatus(): Promise<void> {
  // >SEPARATOR getClusterStatus
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getClusterStatus({ clusters: 'c1-de' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getIncidents method.
//
// getIncidents
export async function snippetForgetIncidents(): Promise<void> {
  // >SEPARATOR getIncidents
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getIncidents();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getIndexingTime method.
//
// getIndexingTime
export async function snippetForgetIndexingTime(): Promise<void> {
  // >SEPARATOR getIndexingTime
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getIndexingTime({ clusters: 'c1-de' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getInventory method.
//
// getInventory
export async function snippetForgetInventory(): Promise<void> {
  // >SEPARATOR getInventory
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getInventory();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getLatency method.
//
// getLatency
export async function snippetForgetLatency(): Promise<void> {
  // >SEPARATOR getLatency
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getLatency({ clusters: 'c1-de' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getMetrics method.
//
// getMetrics
export async function snippetForgetMetrics(): Promise<void> {
  // >SEPARATOR getMetrics
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getMetrics({
    metric: 'avg_build_time',
    period: 'minute',
  });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getReachability method.
//
// getReachability
export async function snippetForgetReachability(): Promise<void> {
  // >SEPARATOR getReachability
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getReachability({ clusters: 'c1-de' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getStatus method.
//
// getStatus
export async function snippetForgetStatus(): Promise<void> {
  // >SEPARATOR getStatus
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getStatus();

  // use typed response
  console.log(response);
  // SEPARATOR<
}
