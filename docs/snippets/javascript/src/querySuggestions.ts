// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

// >IMPORT
import { algoliasearch } from 'algoliasearch';
// IMPORT<

// Snippet for the createConfig method.
//
// createConfig
export async function snippetForCreateConfig(): Promise<void> {
  // >SEPARATOR createConfig default
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.createConfig({
    indexName: 'theIndexName',
    sourceIndices: [
      { indexName: 'testIndex', facets: [{ attribute: 'test' }], generate: [['facetA', 'facetB'], ['facetC']] },
    ],
    languages: ['french'],
    exclude: ['test'],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
export async function snippetForCustomDelete(): Promise<void> {
  // >SEPARATOR customDelete allow del method for a custom path with minimal parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customDelete({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customDelete method.
//
// allow del method for a custom path with all parameters
export async function snippetForCustomDelete1(): Promise<void> {
  // >SEPARATOR customDelete allow del method for a custom path with all parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customDelete({ path: 'test/all', parameters: { query: 'parameters' } });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
export async function snippetForCustomGet(): Promise<void> {
  // >SEPARATOR customGet allow get method for a custom path with minimal parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customGet({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with all parameters
export async function snippetForCustomGet1(): Promise<void> {
  // >SEPARATOR customGet allow get method for a custom path with all parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customGet({ path: 'test/all', parameters: { query: 'parameters with space' } });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// requestOptions should be escaped too
export async function snippetForCustomGet2(): Promise<void> {
  // >SEPARATOR customGet requestOptions should be escaped too
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customGet(
    { path: 'test/all', parameters: { query: 'to be overriden' } },
    {
      queryParameters: { query: 'parameters with space', 'and an array': ['array', 'with spaces'] },
      headers: { 'x-header-1': 'spaces are left alone' },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
export async function snippetForCustomPost(): Promise<void> {
  // >SEPARATOR customPost allow post method for a custom path with minimal parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with all parameters
export async function snippetForCustomPost1(): Promise<void> {
  // >SEPARATOR customPost allow post method for a custom path with all parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost({
    path: 'test/all',
    parameters: { query: 'parameters' },
    body: { body: 'parameters' },
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions can override default query parameters
export async function snippetForCustomPost2(): Promise<void> {
  // >SEPARATOR customPost requestOptions can override default query parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { query: 'myQueryParameter' },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions merges query parameters with default ones
export async function snippetForCustomPost3(): Promise<void> {
  // >SEPARATOR customPost requestOptions merges query parameters with default ones
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { query2: 'myQueryParameter' },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions can override default headers
export async function snippetForCustomPost4(): Promise<void> {
  // >SEPARATOR customPost requestOptions can override default headers
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      headers: { 'x-algolia-api-key': 'ALGOLIA_API_KEY' },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions merges headers with default ones
export async function snippetForCustomPost5(): Promise<void> {
  // >SEPARATOR customPost requestOptions merges headers with default ones
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      headers: { 'x-algolia-api-key': 'ALGOLIA_API_KEY' },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions queryParameters accepts booleans
export async function snippetForCustomPost6(): Promise<void> {
  // >SEPARATOR customPost requestOptions queryParameters accepts booleans
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { isItWorking: true },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions queryParameters accepts integers
export async function snippetForCustomPost7(): Promise<void> {
  // >SEPARATOR customPost requestOptions queryParameters accepts integers
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { myParam: 2 },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions queryParameters accepts list of string
export async function snippetForCustomPost8(): Promise<void> {
  // >SEPARATOR customPost requestOptions queryParameters accepts list of string
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { myParam: ['b and c', 'd'] },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions queryParameters accepts list of booleans
export async function snippetForCustomPost9(): Promise<void> {
  // >SEPARATOR customPost requestOptions queryParameters accepts list of booleans
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { myParam: [true, true, false] },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// requestOptions queryParameters accepts list of integers
export async function snippetForCustomPost10(): Promise<void> {
  // >SEPARATOR customPost requestOptions queryParameters accepts list of integers
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPost(
    { path: 'test/requestOptions', parameters: { query: 'parameters' }, body: { facet: 'filters' } },
    {
      queryParameters: { myParam: [1, 2] },
    },
  );

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
export async function snippetForCustomPut(): Promise<void> {
  // >SEPARATOR customPut allow put method for a custom path with minimal parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPut({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with all parameters
export async function snippetForCustomPut1(): Promise<void> {
  // >SEPARATOR customPut allow put method for a custom path with all parameters
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.customPut({
    path: 'test/all',
    parameters: { query: 'parameters' },
    body: { body: 'parameters' },
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the deleteConfig method.
//
// deleteConfig
export async function snippetForDeleteConfig(): Promise<void> {
  // >SEPARATOR deleteConfig default
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.deleteConfig({ indexName: 'theIndexName' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getAllConfigs method.
//
// getAllConfigs
export async function snippetForGetAllConfigs(): Promise<void> {
  // >SEPARATOR getAllConfigs default
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.getAllConfigs();

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getConfig method.
//
// Retrieve QS config e2e
export async function snippetForGetConfig(): Promise<void> {
  // >SEPARATOR getConfig default
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.getConfig({ indexName: 'cts_e2e_browse_query_suggestions' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getConfigStatus method.
//
// getConfigStatus
export async function snippetForGetConfigStatus(): Promise<void> {
  // >SEPARATOR getConfigStatus default
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.getConfigStatus({ indexName: 'theIndexName' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getLogFile method.
//
// getLogFile
export async function snippetForGetLogFile(): Promise<void> {
  // >SEPARATOR getLogFile default
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.getLogFile({ indexName: 'theIndexName' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the setClientApiKey method.
//
// switch API key
export function snippetForSetClientApiKey(): void {
  // >SEPARATOR setClientApiKey default
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  client.setClientApiKey({ apiKey: 'updated-api-key' });

  // >LOG
  // SEPARATOR<
}

// Snippet for the updateConfig method.
//
// updateConfig
export async function snippetForUpdateConfig(): Promise<void> {
  // >SEPARATOR updateConfig default
  // Initialize the client
  // Replace 'us' with your Algolia Application Region
  const client = algoliasearch('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY').initQuerySuggestions({ region: 'us' });

  // Call the API
  const response = await client.updateConfig({
    indexName: 'theIndexName',
    configuration: {
      sourceIndices: [
        { indexName: 'testIndex', facets: [{ attribute: 'test' }], generate: [['facetA', 'facetB'], ['facetC']] },
      ],
      languages: ['french'],
      exclude: ['test'],
    },
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}
