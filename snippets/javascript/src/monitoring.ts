/* eslint no-console: ["error", { allow: ["log"] }] */

import { monitoringClient } from '@algolia/monitoring';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

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
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // Use typed response
  console.log(response);
}

// Snippet for the getClusterIncidents method.
//
// getClusterIncidents
export async function snippetForgetClusterIncidents(): Promise<void> {
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getClusterIncidents({ clusters: 'c1-de' });

  // Use typed response
  console.log(response);
}

// Snippet for the getClusterStatus method.
//
// getClusterStatus
export async function snippetForgetClusterStatus(): Promise<void> {
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getClusterStatus({ clusters: 'c1-de' });

  // Use typed response
  console.log(response);
}

// Snippet for the getIncidents method.
//
// getIncidents
export async function snippetForgetIncidents(): Promise<void> {
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getIncidents();

  // Use typed response
  console.log(response);
}

// Snippet for the getIndexingTime method.
//
// getIndexingTime
export async function snippetForgetIndexingTime(): Promise<void> {
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getIndexingTime({ clusters: 'c1-de' });

  // Use typed response
  console.log(response);
}

// Snippet for the getInventory method.
//
// getInventory
export async function snippetForgetInventory(): Promise<void> {
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getInventory();

  // Use typed response
  console.log(response);
}

// Snippet for the getLatency method.
//
// getLatency
export async function snippetForgetLatency(): Promise<void> {
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getLatency({ clusters: 'c1-de' });

  // Use typed response
  console.log(response);
}

// Snippet for the getMetrics method.
//
// getMetrics
export async function snippetForgetMetrics(): Promise<void> {
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getMetrics({
    metric: 'avg_build_time',
    period: 'minute',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getReachability method.
//
// getReachability
export async function snippetForgetReachability(): Promise<void> {
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getReachability({ clusters: 'c1-de' });

  // Use typed response
  console.log(response);
}

// Snippet for the getStatus method.
//
// getStatus
export async function snippetForgetStatus(): Promise<void> {
  // Initialize the client
  const client = monitoringClient('YOUR_APP_ID', 'YOUR_API_KEY');

  // Call the API
  const response = await client.getStatus();

  // Use typed response
  console.log(response);
}
