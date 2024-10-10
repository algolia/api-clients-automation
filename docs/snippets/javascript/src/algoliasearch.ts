// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

// >IMPORT
import { liteClient } from 'algoliasearch/lite';
// IMPORT<

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
export async function snippetForCustomPost(): Promise<void> {
  // >SEPARATOR customPost default
  // Initialize the client
  //
  const client = liteClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.customPost({ path: 'test/minimal' });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the getRecommendations method.
//
// get recommendations for recommend model with minimal parameters
export async function snippetForGetRecommendations(): Promise<void> {
  // >SEPARATOR getRecommendations default
  // Initialize the client
  //
  const client = liteClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.getRecommendations({
    requests: [{ indexName: 'indexName', objectID: 'objectID', model: 'related-products', threshold: 42.1 }],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// withHitsPerPage
export async function snippetForSearch(): Promise<void> {
  // >SEPARATOR search withHitsPerPage
  // Initialize the client
  //
  const client = liteClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', hitsPerPage: 50 }],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// filterOnly
export async function snippetForSearch1(): Promise<void> {
  // >SEPARATOR search filterOnly
  // Initialize the client
  //
  const client = liteClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', filters: 'actor:Scarlett Johansson' }],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// filterOr
export async function snippetForSearch2(): Promise<void> {
  // >SEPARATOR search filterOr
  // Initialize the client
  //
  const client = liteClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [
      {
        indexName: '<YOUR_INDEX_NAME>',
        query: '<YOUR_QUERY>',
        filters: 'actor:Tom Cruise OR actor:Scarlett Johansson',
      },
    ],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// filterNot
export async function snippetForSearch3(): Promise<void> {
  // >SEPARATOR search filterNot
  // Initialize the client
  //
  const client = liteClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', filters: 'NOT actor:Nicolas Cage' }],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// retrieveFacets
export async function snippetForSearch4(): Promise<void> {
  // >SEPARATOR search retrieveFacets
  // Initialize the client
  //
  const client = liteClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', facets: ['author', 'genre'] }],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}

// Snippet for the search method.
//
// retrieveFacetsWildcard
export async function snippetForSearch5(): Promise<void> {
  // >SEPARATOR search retrieveFacetsWildcard
  // Initialize the client
  //
  const client = liteClient('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

  // Call the API
  const response = await client.search({
    requests: [{ indexName: '<YOUR_INDEX_NAME>', query: '<YOUR_QUERY>', facets: ['*'] }],
  });

  // >LOG
  // use typed response
  console.log(response);
  // SEPARATOR<
}
