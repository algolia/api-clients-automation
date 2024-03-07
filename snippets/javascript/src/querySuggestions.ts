/* eslint no-console: ["error", { allow: ["log"] }] */

import { querySuggestionsClient } from '@algolia/client-query-suggestions';

// Snippet for the createConfig method.
//
// createConfig0
export async function snippetForcreateConfig(): Promise<void> {
  // >SEPARATOR createConfig
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
  const client = querySuggestionsClient(
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
  const client = querySuggestionsClient(
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
  const client = querySuggestionsClient(
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
  const client = querySuggestionsClient(
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

// Snippet for the deleteConfig method.
//
// deleteConfig0
export async function snippetFordeleteConfig(): Promise<void> {
  // >SEPARATOR deleteConfig
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.deleteConfig({ indexName: 'theIndexName' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getAllConfigs method.
//
// getAllConfigs0
export async function snippetForgetAllConfigs(): Promise<void> {
  // >SEPARATOR getAllConfigs
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getAllConfigs();

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getConfig method.
//
// Retrieve QS config e2e
export async function snippetForgetConfig(): Promise<void> {
  // >SEPARATOR getConfig
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getConfigStatus method.
//
// getConfigStatus0
export async function snippetForgetConfigStatus(): Promise<void> {
  // >SEPARATOR getConfigStatus
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getConfigStatus({ indexName: 'theIndexName' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getLogFile method.
//
// getLogFile0
export async function snippetForgetLogFile(): Promise<void> {
  // >SEPARATOR getLogFile
  // Initialize the client
  const client = querySuggestionsClient(
    'YOUR_APP_ID',
    'YOUR_API_KEY',
    'YOUR_APP_ID_REGION'
  );

  // Call the API
  const response = await client.getLogFile({ indexName: 'theIndexName' });

  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the updateConfig method.
//
// updateConfig0
export async function snippetForupdateConfig(): Promise<void> {
  // >SEPARATOR updateConfig
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

  // use typed response
  console.log(response);
  // SEPARATOR<
}
