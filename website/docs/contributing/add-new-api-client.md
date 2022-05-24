---
title: Add a new API client
---

# Add a new API client

Adding an API client requires manual steps in order to setup the tooling, generation scripts and properly generate the code. We recommend getting inspirations from existing clients such as `javascript-recommend`.

:::info

Make sure to first [setup the repository tooling](/docs/contributing/setup-repository) to ease your journey!

:::

## 1. Writing specs

We recommend to have a look at [existing spec files](https://github.com/algolia/api-clients-automation/blob/main/specs/). The `bundled` folder is automatically generated, manual changes shouldn't be done in these files.

### `common` spec folder

[This folder](https://github.com/algolia/api-clients-automation/blob/main/specs/common/) hosts properties that are common to Algolia or used in multiple clients.

### `<clientName>` spec folder

> Example with the [search client spec](https://github.com/algolia/api-clients-automation/blob/main/specs/search/)

#### `spec.yml` file

This file is the entry point of the client spec, it contains `servers`, `paths` and other specific information of the API. We recommend to copy an existing [`spec.yml` file](https://github.com/algolia/api-clients-automation/blob/main/specs/search/spec.yml) to get started.

#### `<clientName>`/common folder

Properties that are common to the client, for properties common to all clients, check the [common folder](#common-spec-folder).

#### `<clientName>`/paths folder

Path definition of the paths defined in the [spec file](#specyml-file).

### Send extra options to the template

You might want to send extra information to the generators that have no link with your REST API. To do so, you can add parameters starting matching `x-my-parameter-name` that will be available in the template under `vendorExtensions`.

[Example in the `search.yml` spec](https://github.com/algolia/api-clients-automation/blob/main/specs/search/paths/search/search.yml#L5) and how it is used [in a mustache file](https://github.com/algolia/api-clients-automation/blob/bf4271246f9282d3c11dd46918e74cb86d9c96dc/templates/java/libraries/okhttp-gson/api.mustache#L196).

#### Guidelines

- **Endpoints**: Each file in the `paths` folder should contain `operationId`s for a single endpoint, but multiple methods are allowed.
- **Name**: If the path file only contain one method, we name the file same as the `operationId`, but we try to make it less specific if there is multiple methods.
- **Description/Summary**: `operationId`s must have both description and summary.
- **Complex objects**: Complex objects (nested arrays, nested objects, , `oneOf`, `allOf`, etc.) must be referenced (`$ref`) in the `operationId` file and not inlined. This is required to provide a accurate naming and improve readability.

## 2. Configuring the environment

> The generator follows its own configuration file named `config/openapitools.json`

### Generation config

[`config/openapitools.json`](https://github.com/algolia/api-clients-automation/blob/main/config/openapitools.json) and [`config/clients.config.json`](https://github.com/algolia/api-clients-automation/blob/main/config/clients.config.json) hosts the configuration of all of the generated clients with their available languages and extra information.

#### `generators`

Generators are referenced by key with the following pattern `<languageName>-<clientName>`. You can copy an existing object of a client and replace the `<clientName>` value with the one you'd like to generate.

Below are the options you need to **make sure to define for your client**, other options are automatically added by our generator.

| Option              |         File          |  Type  |        Language         |                       Example                        | Definition                                                                                                           |
| ------------------- | :-------------------: | :----: | :---------------------: | :--------------------------------------------------: | :------------------------------------------------------------------------------------------------------------------- |
| output              |  `openapitools.json`  | string |           All           |           `path/to/client/client-sources`            | The output path of the client.                                                                                       |
| packageName         |  `openapitools.json`  | string |           All           |                   `AlgoliaSearch`                    | Name of the API package, used in [CTS](/docs/contributing/testing/common-test-suite).                                |
| packageVersion      |  `openapitools.json`  | string |       JavaScript        |                       `1.2.3`                        | The version you'd like to publish the first iteration of the generated client. It will be automatically incremented. |
| utilsPackageVersion | `clients.config.json` | string |       JavaScript        |                       `1.2.3`                        | The version of the utils package. Every utils package should have synchronized version.                              |
| packageVersion      | `clients.config.json` | string | All (except JavaScript) |                       `1.2.3`                        | The version you'd like to publish the first iteration of the generated client. It will be automatically incremented. |
| gitRepoId           | `clients.config.json` | string |           All           |          `algoliasearch-client-javascript`           | The name of the repository.                                                                                          |
| folder              | `clients.config.json` | string |           All           |        `clients/algoliasearch-client-java-2`         | The path to the folder that will host the generated code.                                                            |
| modelFolder         | `clients.config.json` | string |           All           | `algoliasearch-core/src/main/java/com/algolia/model` | The path to the `model` folder that will host the generated code.                                                    |
| apiFolder           | `clients.config.json` | string |           All           |  `algoliasearch-core/src/main/java/com/algolia/api`  | The path to the `api` folder that will host the generated code.                                                      |
| customGenerator     | `clients.config.json` | string |           All           |                    `algolia-php`                     | The name of the generator used to generate code.                                                                     |

### GitHub actions

If you have successfully configured the configuration files above, you shouldn't have to change anything in the GitHub actions to make the CI work.

## 3. Generate new client

You can find all the commands in the [CLI > clients commands page](/docs/contributing/CLI/clients-commands) and [CLI > specs commands page](/docs/contributing/CLI/specs-commands).

## 4. Implementing the Common Test Suite

Clients needs to be tested, you can read more in the [Common Test Suite](/docs/contributing/testing/common-test-suite) guide.
