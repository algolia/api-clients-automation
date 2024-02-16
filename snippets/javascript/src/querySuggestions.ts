/* eslint no-console: ["error", { allow: ["log"] }] */

import { querySuggestionsClient } from '@algolia/client-query-suggestions';

// Snippet for the createConfig method.
//
// createConfig0
export async function snippetForcreateConfig(): Promise<void> {
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.createConfig({
    indexName: 'theIndexName',
    sourceIndices: [
      {
        indexName: 'testIndex',
        facets: [{ attribute: 'test' }],
        generate: [['facetA', 'facetB'], ['facetC']],
      },
    ],
    languages: ['french'],
    exclude: ['test'],
  });

  // Use typed response
  console.log(response);
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForcustomDelete(): Promise<void> {
  // Initialize the client
  const client = querySuggestionsClient(
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
  const client = querySuggestionsClient(
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
  const client = querySuggestionsClient(
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
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.customPut({ path: '/test/minimal' });

  // Use typed response
  console.log(response);
}

// Snippet for the deleteConfig method.
//
// deleteConfig0
export async function snippetFordeleteConfig(): Promise<void> {
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteConfig({ indexName: 'theIndexName' });

  // Use typed response
  console.log(response);
}

// Snippet for the getAllConfigs method.
//
// getAllConfigs0
export async function snippetForgetAllConfigs(): Promise<void> {
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getAllConfigs();

  // Use typed response
  console.log(response);
}

// Snippet for the getConfig method.
//
// Retrieve QS config e2e
export async function snippetForgetConfig(): Promise<void> {
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getConfig({
    indexName: 'cts_e2e_browse_query_suggestions',
  });

  // Use typed response
  console.log(response);
}

// Snippet for the getConfigStatus method.
//
// getConfigStatus0
export async function snippetForgetConfigStatus(): Promise<void> {
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getConfigStatus({ indexName: 'theIndexName' });

  // Use typed response
  console.log(response);
}

// Snippet for the getLogFile method.
//
// getLogFile0
export async function snippetForgetLogFile(): Promise<void> {
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getLogFile({ indexName: 'theIndexName' });

  // Use typed response
  console.log(response);
}

// Snippet for the updateConfig method.
//
// updateConfig0
export async function snippetForupdateConfig(): Promise<void> {
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.updateConfig({
    indexName: 'theIndexName',
    querySuggestionsConfiguration: {
      sourceIndices: [
        {
          indexName: 'testIndex',
          facets: [{ attribute: 'test' }],
          generate: [['facetA', 'facetB'], ['facetC']],
        },
      ],
      languages: ['french'],
      exclude: ['test'],
    },
  });

  // Use typed response
  console.log(response);
}
