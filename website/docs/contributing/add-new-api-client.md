---
title: Add a new API client
---

:::info

Make sure to first [setup the repository tooling](/docs/contributing/setup-repository) to ease your journey!

:::

Adding a new API client requires some manual steps in order to have a properly working client:

1. [Writing specs](#1-writing-specs)
2. [Configuring the generator](#2-configuring-the-generator)
3. [Generate the client](#3-generate-the-client)
4. [Adding tests](#4-adding-tests-with-the-common-test-suite)
5. [Helpers](#5-helpers)

## 1. Writing specs

> All of our specs follows the [OpenAPI specification](https://spec.openapis.org/oas/v3.1.0).

Take a look to how we write specs by checking the [existing ones](https://github.com/algolia/api-clients-automation/blob/main/specs/).

> **The `bundled` folder is automatically generated, manual changes shouldn't be done in these files.**

### Guidelines

- **Endpoints**: Each file in [the `paths` folder](https://github.com/algolia/api-clients-automation/tree/main/specs/search/paths) should contain `operationId`s for a single endpoint, multiple methods are allowed.
- **File name**:
  - When the `path` file only contain one method (e.g. `GET`), we name the file after the `operationId`
  - When multiple methods are present (e.g. `PUT` and `DELETE`), we pick a more generic name that is related to the endpoint itself.
- **Description/Summary**: `operationId`s must have both description and summary.
- **Complex objects**: Complex objects (nested arrays, nested objects, `oneOf`, `allOf`, etc.) must be referenced (`$ref`) in the `operationId` file and not inlined. This is required to provide a accurate naming and improve readability.

### `common` spec folder

[The `common` folder](https://github.com/algolia/api-clients-automation/blob/main/specs/common/) contains properties that are common to many Algolia APIs.

### `specs/<apiName>` folder

> Example with the [search client spec](https://github.com/algolia/api-clients-automation/blob/main/specs/search/)

#### **`specs/<apiName>/spec.yml` file**

The `spec.yml` file is the entry point of the client spec, it contains the `servers`, `paths` and other specific information to contact the API. We recommend to copy an existing [`spec.yml` file](https://github.com/algolia/api-clients-automation/blob/main/specs/search/spec.yml) to get started.

#### **`specs/<apiName>/common` folder**

Same as [the global `common` folder](#common-spec-folder) but only related to the current API.

#### **`specs/<apiName>/paths` folder**

Path definition of the paths defined in the [spec file](#specsapinamespecyml-file). See [guidelines](#guidelines).

### Troubleshooting

#### **Force the name of a `requestBody`**

> [Detailed issue](https://github.com/algolia/api-clients-automation/issues/891)

In some cases, you can encounter wrongly named `requestBody` from the specs, which could be due to:

- The type is too complex/too broad to be generated. (e.g. [An object with `additionalProperties`](https://github.com/algolia/api-clients-automation/tree/main/specs/search/paths/objects/partialUpdate.yml#L24-L33))
- The type is an alias of its model (e.g. [A list of `model`](https://github.com/algolia/api-clients-automation/tree/main/specs/search/paths/rules/saveRules.yml#L12-L20))

The [`x-codegen-request-body-name`](https://openapi-generator.tech/docs/swagger-codegen-migration/#body-parameter-name) property can be added at the root of the spec, to force the name of the generated `requestBody` property.

You can find an example of this implementation [on this PR](https://github.com/algolia/api-clients-automation/pull/896).

#### **Send additional options to the template**

You might want to send additional information to the generators. To do so, you can add parameters starting with an `x-` at the root level of your spec, which will be available in the `mustache` template under the `vendorExtensions` object.

[Example in the `search.yml` spec](https://github.com/algolia/api-clients-automation/blob/main/specs/search/paths/search/search.yml#L5-L7) and how it is used [in a mustache file](https://github.com/algolia/api-clients-automation/blob/bf4271246f9282d3c11dd46918e74cb86d9c96dc/templates/java/libraries/okhttp-gson/api.mustache#L196).

## 2. Configuring the generator

> Most of the configuration is "guessed" by the api-clients-automation CLI (`scripts/`).

### Configs

#### [`config/clients.config.json`](https://github.com/algolia/api-clients-automation/blob/main/config/clients.config.json)

Contains information common to every `clients` generated for a language, fields below are required:

| Option               | Description                                                                                                          |
|----------------------|----------------------------------------------------------------------------------------------------------------------|
| `folder`             | The path to the parent folder of every clients for this language.                                                    |
| `gitRepoId`          | The name of the repository of this API client.                                                                       |
| `packageVersion`     | The version you'd like to publish the first iteration of the generated client. It will be automatically incremented. |
| `modelFolder`        | The path to the `model` folder that will host the generated code.                                                    |
| `apiFolder`          | The path to the `api` folder that will host the generated code.                                                      |
| `tests.extension`    | The extension of a test file, e.g. `.test.java` or `_test.py`                                                        |
| `tests.outputFolder` | The path to the folder that holds the test for this language, e.g. `tests/`                                          |


## 3. Generate the client

You can find all the commands in the [CLI > clients commands page](/docs/contributing/CLI/clients-commands) and [CLI > specs commands page](/docs/contributing/CLI/specs-commands).

## 4. Adding tests with the Common Test Suite

Clients needs to be tested, you can read more in the [Common Test Suite](/docs/contributing/testing/common-test-suite) guide.

## 5. Helpers

We provide manually written helpers that wrap generated API clients methods in order to ease the user's journey.

| Helper name              | Description                                                                                                                                                                               | Wrapped API call            | Stop condition                                          | Example                                                                                                                                                           |
|--------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------|---------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `waitForTask`            | Given a `taskID`, calls the `getTask` method until the status gets `published`                                                                                                            | `getTask()`                 | `response.status == "published"`                        | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts#L232) |
| `waitForApiKey`          | Given a `Key`, calls the `getApiKey` method until the stop condition for the given `operation` is validated                                                                               | `getApiKey()`               | Diff between the given `Key` and the `response` payload | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts#L269) |
| `browseObjects<T>`       | Given an `indexName` and the same parameters as the `browse` method, aggregates all the `objects` returned by the API calls in a single `browse` response object                          | `browse()`                  | `response.cursor == null`                               | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts#L342) |
| `browseRules`            | Given an `indexName` and the same parameters as the `searchRules` method, aggregates all the `rules` returned by the API calls in a single `searchRules` response object                  | `searchRules()`             | `response.nbHits < params.hitsPerPage`                  | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts#L379) |
| `browseSynonyms`         | Given an `indexName` and the same parameters as the `searchSynonyms` method, aggregates all the `synonyms` returned by the API calls in a single `searchSynonyms` response object         | `searchSynonyms()`          | `response.nbHits < params.hitsPerPage`                  | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts#L422) |
| `searchForHits<T>`       | Given the same parameters as the `search` method, returns the API response with the certainty that it will only contain `hits` by casting it to a generic `SearchResponse<T>` object      | `search()`                  | `none`                                                  | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts#L462) |
| `searchForFacets`        | Given the same parameters as the `search` method, returns the API response with the certainty that it will only contain `facets` by casting it to a `SearchForFacetValuesResponse` object | `search()`                  | `none`                                                  | [JavaScript](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchClient.ts#L479) |
| `replaceAllObjects`      | Given an `indexName` and an array of `objects`, replace all objects in this index using a temporary one                                                                                   | `operationIndex(), batch()` | `none`                                                  | [PHP](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-php/lib/Api/SearchClient.php#L2813)                                |
| `generateSecuredApiKey`  | Given a `indexName` and an array of `restrictions`, generates a secured API Key using the SHA-256 algorithm                                                                               | `none`                      | `none`                                                  | [PHP](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-php/lib/Api/SearchClient.php#L2869)                                |
