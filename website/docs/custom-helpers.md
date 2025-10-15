---
title: Custom helpers
---

The API clients provide many hand-written helpers for tasks that would otherwise require custom code or global knowledge of how the Algolia API works.

| Helper name             | Description                                                                                                                                                                                                          | Wrapped API call            | Stop condition                                          | Example                                                                                                                                                      |
| ----------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------- | ------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `customPut`             | Makes a fully customizable PUT API call to the current API.                                                                                                                                                          | none                        | none                                                    | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `customGet`             | Makes a fully customizable GET API call to the current API.                                                                                                                                                          | none                        | none                                                    | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `customPost`            | Makes a fully customizable POST API call to the current API.                                                                                                                                                         | none                        | none                                                    | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `customDelete`          | Makes a fully customizable DELETE API call to the current API.                                                                                                                                                       | none                        | none                                                    | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `waitForTask`           | Given a `taskID`, calls the `getTask` method until the status gets `published`                                                                                                                                       | `getTask()`                 | `response.status == "published"`                        | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `waitForAppTask`        | Given a `taskID`, calls the `getAppTask` method until the status gets `published`                                                                                                                                    | `getAppTask()`              | `response.status == "published"`                        | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `waitForApiKey`         | Given a `Key`, calls the `getApiKey` method until the stop condition for the given `operation` is validated                                                                                                          | `getApiKey()`               | Diff between the given `Key` and the `response` payload | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `browseObjects<T>`      | Given an `indexName` and the same parameters as the `browse` method, aggregates all the `objects` returned by the API calls in a single `browse` response object                                                     | `browse()`                  | `response.cursor == null`                               | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `browseRules`           | Given an `indexName` and the same parameters as the `searchRules` method, aggregates all the `rules` returned by the API calls in a single `searchRules` response object                                             | `searchRules()`             | `response.nbHits < params.hitsPerPage`                  | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `browseSynonyms`        | Given an `indexName` and the same parameters as the `searchSynonyms` method, aggregates all the `synonyms` returned by the API calls in a single `searchSynonyms` response object                                    | `searchSynonyms()`          | `response.nbHits < params.hitsPerPage`                  | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `searchForHits<T>`      | Given the same parameters as the `search` method, returns the API response with the certainty that it will only contain `hits` by casting it to a generic `SearchResponse<T>` object                                 | `search()`                  | `none`                                                  | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `searchForFacets`       | Given the same parameters as the `search` method, returns the API response with the certainty that it will only contain `facets` by casting it to a `SearchForFacetValuesResponse` object                            | `search()`                  | `none`                                                  | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts) |
| `replaceAllObjects`     | Given an `indexName` and an array of `objects`, replace all objects in this index using a temporary one                                                                                                              | `operationIndex(), batch()` | `none`                                                  | [PHP](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-php/lib/Api/SearchClient.php)                                 |
| `generateSecuredApiKey` | Given an `indexName` and an array of `restrictions`, generates a secured API Key using the SHA-256 algorithm                                                                                                         | `none`                      | `none`                                                  | [PHP](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-php/lib/Api/SearchClient.php)                                 |
| `chunkedBatch`          | Creates chunks of `objects` in order to make them fit in multiple `batch` requests                                                                                                                                   | `batch()`                   | `none`                                                  | [PHP](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-php/lib/Api/SearchClient.php)                                 |
| `saveObjects`           | Saves the given array of objects in the given index. The `chunkedBatch` helper is used under the hood, which creates a `batch` requests with at most 1000 objects in it.                                             | `batch()`                   | `none`                                                  | [Go](https://github.com/algolia/api-clients-automation/blob/main/templates/go/search_helpers.mustache)                                                       |
| `deleteObjects`         | Deletes every records for the given objectIDs. The `chunkedBatch` helper is used under the hood, which creates a `batch` requests with at most 1000 objectIDs in it.                                                 | `batch()`                   | `none`                                                  | [Go](https://github.com/algolia/api-clients-automation/blob/main/templates/go/search_helpers.mustache)                                                       |
| `partialUpdateObjects`  | Replaces object content of all the given objects according to their respective `objectID` field. The `chunkedBatch` helper is used under the hood, which creates a `batch` requests with at most 1000 objects in it. | `batch()`                   | `none`                                                  | [Go](https://github.com/algolia/api-clients-automation/blob/main/templates/go/search_helpers.mustache)                                                       |

## Complex usage descrpition

:::info

This section explains the decision over the implementation of complicated helper, self-explanatory ones might not be listed.

:::

### `replaceAllObjects`

:::caution

Always wait on the tmp index, because:

- it's the only index that we know for sure will exist (since we create it).
- it is Metis compliant, no need for custom implementation.

:::

#### 1. copy index

The first step is to make a copy of the index settings, rules and synonyms.

We **don't wait** for this first operation, as we:

- don't know if the source index exists, and therefore can't call `waitTask` on it.
- won't have a tmp index to `waitTask` on, if the `copy` can't succeed.

#### 2. chunk batch

Call the chunk batch for the given `objects`, call `waitTask` for the batching operation, which would create the `tmp` index in case `copy` did not succeded.

#### 3. copy index again

Now that we are certain the tmp index exist:

1. `waitTask` on the tmp index, with the `taskID` returned from the first copy index invocation.
2. call `copy` again, if the first call succeeded, it will be a noop, otherwise, the tmp index will be rebuilt.
3. `waitTask` on the tmp index

#### 4. move tmp index

Move the tmp index to the source index, call `waitTask` on the tmp index.
