---
title: Writing and editing specs
---

# Writing and editing specs

Algolia's API specs follow the [OpenAPI specification, version 3.0](https://spec.openapis.org/oas/v3.0.2), with the exception of nullable properties.

## API reference style guide

- Clarity, completeness, conciseness.

### Summaries

Start with an imperative verb that describes what the endpoint does.

Use these verbs consistently:

| Use      | To describe                                                                    | Don't use             | Example                  |
| -------- | ------------------------------------------------------------------------------ | --------------------- | ------------------------ |
| Browse   | The [Browse for records](/specs/search#tag/Search/operation/browse) operation. | List                  | Browse for records       |
| List     | Operations that return many or all instances of an object.                     | Browse, retrieve many | List indices             |
| Retrieve | Operations that return one instance of an object.                              | Get                   | Retrieve index settings  |
| Update   | Operations that update parts of an object without completely replacing it.     |                       | Add or replace a record  |
| Replace  | Operations that replace entire objects.                                        | Update                | Add or update attributes |

### Descriptions

#### Descriptions for endpoints

Start with a verb in third person and describe what the endpoint does.
Often, this repeats what is written in the `summary` field,
but you can provide an extended description.
