---
title: Write an OpenAPI specification
---

:::info

Algolia's API specs follow the [OpenAPI specification, version 3.1](https://spec.openapis.org/oas/v3.1.0).

Starting from an existing specification **really eases the contribution process and is recommended** (e.g. [search](https://github.com/algolia/api-clients-automation/blob/main/specs/search/))

**Do not edit the files in [`specs/bundled`](https://github.com/algolia/api-clients-automation/blob/main/specs/bundled)** they are the generated from the manually written specifications, and only used to generate API clients.

:::

:::caution

A specification is used to generate the API client, its tests and code snippets, but is most importantly served by [the Algolia public documentation](https://www.algolia.com/doc/api-reference/rest-api/), please read our [API Documentation guidelines](./api-documentation-guidelines.md) to properly document your specification.

:::

# Structure your specification

Each API specification follows a consistent structure.

## `specs/common/`

This [common directory](https://github.com/algolia/api-clients-automation/blob/main/specs/common/) contains schemas and parameters that are common to multiple Algolia APIs, for example: search parameters or indexName definitions.

## `specs/<apiName>/`

Each API must be contained in its own directory, for example: [the Search API](https://github.com/algolia/api-clients-automation/blob/main/specs/search/).

### `specs/<apiName>/spec.yml`

This file is the main entrypoint of your specification and should describe your API, including the `servers`, `securitySchemes` and `paths` properties.

### `specs/<apiName>/common/`

This directory contains schemas and parameters that are common to **your API**.
For schemas that are shared between multiple APIs please use the global [`specs/common`](#specscommon) directory.

### `specs/<apiName>/paths/`

This directory contains the descriptions of the **endpoints** of your API.
The paths themselves are defined in the [`spec.yml`](#specsapinamespecyml) file.

#### `specs/<apiName>/paths/<operation>.yml`

Operations are endpoints combined with an HTTP method (`GET`, `POST`, etc.).
Each operation must have a unique `operationID` property.
Operations for the same endpoint may share the same file, for example, the `GET` and `DELETE` request for the same endpoint.

##### Filenames

Follow these conventions:

- If the file only contains one operation, use `<operationId>.yml` as filename.
- If the file contains multiple operations, use a more generic name, for example [`rule.yml`](https://github.com/algolia/api-clients-automation/blob/main/specs/search/paths/rules/rule.yml) for the `GET`, `PUT`, and `DELETE` request for a rule.

##### Summaries and descriptions

Every operation must have a `summary` and `description` property (they will be used in the generated API clients, and the Algolia documentation).
For information about documenting operations, see [Operation summaries](/docs/add-a-new-api/api-documentation-guidelines#operation-summaries) and [Operation descriptions](./api-documentation-guidelines.md#operation-descriptions).

##### Access Control Lists (ACL)

Each operation should include an `x-acl` property
to document the ACL required to make the request.

The `x-acl` property is an array of strings, the allowed values are: `search`, `browse`, `addObject`, `deleteObject`, `listIndexes`, `deleteIndex`, `settings`, `editSettings`, `analytics`, `recommendation`, `usage`, `logs`, `setUnretrievableAttributes`, `admin`.
For operations that require the admin API key, use `admin`

##### Complex objects

The following objects must not be inlined, but referenced with `$ref`:

- Nested arrays
- Nested objects
- `oneOf`
- `allOf`
- `enum`

This is required for accurate naming of the generated code objects.
It also improves the readability of the specs.

##### Properties and parameters

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

For information about documenting properties and parameters, see [Properties and parameters](/docs/add-a-new-api/api-documentation-guidelines#properties-and-parameter-descriptions).

## CLI Commands

Use the CLI to generate build your specs:

- [Commands for working with specs](/docs/CLI/build-commands)

## Troubleshooting

### Explicit names for request bodies

> [Detailed issue](https://github.com/algolia/api-clients-automation/issues/891)

In some cases, the generated name for the `requestBody` property might be wrong.
This can happen in these cases:

- The type is too complex or too broad to be correctly generated,
  for example, [an object with `additionalProperties`](https://github.com/algolia/api-clients-automation/tree/main/specs/search/paths/objects/partialUpdate.yml#L24-L33).

- The type is an alias of its model,
  for example, [a list of `model`](https://github.com/algolia/api-clients-automation/tree/main/specs/search/paths/rules/saveRules.yml#L12-L20).

To provide a name for the request body, add the [`x-codegen-request-body-name`](https://openapi-generator.tech/docs/swagger-codegen-migration/#body-parameter-name) property to the root of the operation's spec file.

For an example, see [pull request #896](https://github.com/algolia/api-clients-automation/pull/896).

### Send additional options to the templates

To send additional information to the generators,
you can add properties starting with `x-` to the root level of your spec.
These are available in the templates as part of the `vendorExtensions` object.

For an example, see [`search.yml`](https://github.com/algolia/api-clients-automation/blob/main/specs/search/paths/search/search.yml#L5-L7)
