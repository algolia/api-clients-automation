---
title: Add new API clients
---

:::info

First, [setup the repository tooling](./setup-repository.md) so that you can lint, test, and preview documentation on your computer.

:::

To add a new API client in a supported programming language, you need to run these steps:

1. [Write specs](#1-write-specs)
2. [Configure the generator](#2-configure-the-generator)
3. [Generate the client](#3-generate-the-client)
4. [Add tests](#4-add-tests-with-the-common-test-suite)
5. [Helpers](#5-helpers)

For more information about adding support for a new programming language, see [Support a new language](./add-new-language.md).

## 1. Write specs

Algolia's API specs follow the [OpenAPI specification, version 3.1](https://spec.openapis.org/oas/v3.1.0).

To add a new spec, it's best to start from an [existing one](https://github.com/algolia/api-clients-automation/blob/main/specs/).

> Don't edit files in the `specs/bundled/` directory.
> These files are auto-generated and your changes will be overwritten.

### How to organize the specs

Each API spec follows a consistent structure.

#### `specs/common/`

The [`common`](https://github.com/algolia/api-clients-automation/blob/main/specs/common/) directory contains schemas and parameters that are common to many Algolia APIs.

#### `specs/<apiName>/`

Each API is in its own directory.

For an example, see the [Search API](https://github.com/algolia/api-clients-automation/blob/main/specs/search/) directory.

#### `specs/<apiName>/spec.yml`

The `spec.yml` file contains the general description of the API,
including the `servers` and `paths` properties.

To get started, copy an existing file, for example, from the [Search API](https://github.com/algolia/api-clients-automation/blob/main/specs/search/spec.yml).

For information about documenting the API, see [API descriptions](./docs.md#api-descriptions).

#### `specs/<apiName>/common/`

This directory contains schemas and parameters that are common to endpoints of the current API.
For schemas that are shared between multiple APIs, see the global [`specs/common`](#specscommon) directory.

#### `specs/<apiName>/paths/`

This directory contains the descriptions of the **endpoints** of the API.
The paths themselves are defined in the [`spec.yml`](#specsapinamespecyml) file.

### Guidelines for operations

Operations are endpoints combined with an HTTP method (`GET`, `POST`, etc.).
Each operation must have a unique `operationID` property.
Operations for the same endpoint may share the same file, for example, the `GET` and `DELETE` request for the same endpoint.

Every operation must have a `summary` and `description` property.
For information about documenting operations, see [Operation summaries](./docs.md#operation-summaries) and [Operation descriptions](./docs.md#operation-descriptions).

#### Filenames

Follow these conventions:

- If the file only contains one operation, use `<operationId>.yml` as filename.
- If the file contains multiple operations, use a more generic name, for example [`rule.yml`](https://github.com/algolia/api-clients-automation/blob/main/specs/search/paths/rules/rule.yml) for the `GET`, `PUT`, and `DELETE` request for a rule.

#### Access control lists (ACL)

Each operation should include an `x-acl` property
to document the ACL required to make the request.

The `x-acl` property is an array of strings.
For operations that require the admin API key, use `admin`.

#### Complex objects

The following objects must not be inlined, but referenced with `$ref`:

- Nested arrays
- Nested objects
- `oneOf`
- `allOf`
- `enum`

This is required for accurate naming of the generated code objects.
It also improves the readability of the specs.

### Guidelines for properties and parameters

- Create separate objects and reference them for [complex objects](#complex-objects).
- The `format` parameter for strings isn't supported.
- For **nullable properties**, use the following syntax:

  ```yaml
  nullableProp:
    default: null
    oneOf:
      - type: string
        description: Some value
      - type: 'null'
        description: The single quotes are required.
  ```

For information about documenting properties and parameters, see [Properties and parameters](/docs/docs#properties-and-parameter-descriptions).

### Troubleshooting

#### Explicit names for request bodies

> [Detailed issue](https://github.com/algolia/api-clients-automation/issues/891)

In some cases, the generated name for the `requestBody` property might be wrong.
This can happen in these cases:

- The type is too complex or too broad to be correctly generated,
  for example, [an object with `additionalProperties`](https://github.com/algolia/api-clients-automation/tree/main/specs/search/paths/objects/partialUpdate.yml#L24-L33).

- The type is an alias of its model,
  for example, [a list of `model`](https://github.com/algolia/api-clients-automation/tree/main/specs/search/paths/rules/saveRules.yml#L12-L20).

To provide a name for the request body, add the [`x-codegen-request-body-name`](https://openapi-generator.tech/docs/swagger-codegen-migration/#body-parameter-name) property to the root of the operation's spec file.

For an example, see [pull request #896](https://github.com/algolia/api-clients-automation/pull/896).

#### Send additional options to the templates

To send additional information to the generators,
you can add properties starting with `x-` to the root level of your spec.
These are available in the templates as part of the `vendorExtensions` object.

For an example, see [`search.yml`](https://github.com/algolia/api-clients-automation/blob/main/specs/search/paths/search/search.yml#L5-L7)

## 2. Configure the generator

> Most of the configuration is "guessed" by the api-clients-automation CLI (`scripts/`).

### Configuration file

The file [`config/clients.config.json`](https://github.com/algolia/api-clients-automation/blob/main/config/clients.config.json) contains information that's common to all clients generated for each language.

The following fields are required:

| Option               | Description                                                                                       |
| -------------------- | ------------------------------------------------------------------------------------------------- |
| `folder`             | Path to the parent folder of every client for this language.                                      |
| `gitRepoId`          | Name of the repository for this API client.                                                       |
| `packageVersion`     | Initial version number to publish for the generated client. It will be automatically incremented. |
| `modelFolder`        | Path to the `model` folder that will host the generated code.                                     |
| `apiFolder`          | Path to the `api` folder that will host the generated code.                                       |
| `tests.extension`    | Test file extension, such as `.test.java` or `_test.py`                                           |
| `tests.outputFolder` | Path to the folder that holds the tests for this language, such as `tests/`                       |

## 3. Generate the client

Use the CLI to generate the clients:

- [Commands for working with specs](./CLI/specs-commands.md)
- [Commands for working with clients](./CLI/clients-commands.md)

## 4. Add tests with the Common Test Suite

You must add tests for your clients.
For more information, see [Common Test Suite](./testing/common-test-suite.md).

## 5. Helpers

The API clients have hand-written helpers for tasks that would otherwise require custom code.

| Helper name             | Description                                                                                                                                                                                                          | Wrapped API call            | Stop condition                                          | Example                                                                                                                                                      |
| ----------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------- | ------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
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

### `replaceAllObjects`

:::info

This section explains the decision over the implementation of the helper, as it's quite tricky the get the order right

:::

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
