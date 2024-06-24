---
title: Common Test Suite
---

# Common Test Suite

The CTS gather multiple types of tests that make sure our API clients generate the correct requests and throws the correct error, it does not aim at testing the engine.
It is automatically generated for all languages from JSON files and ensure properties are valid by checking specs.

:::info

While some clients can run tests from source, languages like Java or JavaScript and other requires clients to be built, see [CLI > clients commands page](/docs/contributing/CLI/clients-commands)

:::

## How to add test

There are differents type of tests in the CTS:

### Requests tests

There are two types of `requests` tests:
- Unit tests with interceptors (named `EchoRequesters`/`EchoTransporters` in this codebase)
- ^ and an e2e step that asserts the response of the API

#### Input test file

The test generation script requires a JSON file name from the `operationId` (e.g. `search.json`), located in the `tests/CTS/requests/<apiname>/` folder (e.g. `tests/CTS/requests/search/`).

The list of `queryParameters` must match exactly the actual value, the CTS has to check the number of query parameters and the value of each.
**It's important to ensure the number of parameters because the API clients must not set default values, they should be handled by the engine.**

> See the [browse test file for the search client](https://github.com/algolia/api-clients-automation/blob/main/tests/CTS/requests/search/browse.json)

```json
[
  {
    "testName": "The name of the test (e.g. 'searches to testIndex with query parameters')",
    // The parameters of you'd like to pass to the method
    "parameters": {
      "indexName": "testIndex",
      "searchParams": {
        "offset": 42,
        "limit": 21,
        "query": "the string to search"
      },
      "facets": ["*"]
    },
    // Additional options sent with your method
    "requestOptions": {
      // Merged with transporter query parameters
      "queryParameters": {
        "anOtherParam": true
      },
      // Merged with transporter headers
      "headers": {
        "x-header": "test"
      }
    },
    // The payload of the request
    "request": {
      "path": "/1/indexes/testIndex/query",
      "method": "POST",
      "body": { "query": "the string to search" },
      "queryParameters": {
        "otherParam": "22",
        "anOtherParam": "true"
      },
      "headers": {
        "x-header": "test"
      }
    },
    // The expected response - useful for e2e assertions
    "response": {
      "statusCode": 200,
      // This doesn't need to be the full response since we support partial assertions
      "body": {
        "results": [
          {
            "hits": [],
            "page": 0,
            "nbHits": 0,
            "nbPages": 0,
            "hitsPerPage": 20,
            "exhaustiveNbHits": true,
            "exhaustiveTypo": true,
            "exhaustive": {
              "nbHits": true,
              "typo": true
            },
            "query": "",
            "params": "",
            "index": "cts_e2e_search_empty_index",
            "renderingContent": {}
          }
        ]
      }
    }
  }
]
```

#### e2e

Only cases that contains a `response` field in [their definition](#input-test-file) will really execute the query in order to assert the API response. We only partially assert `response` since some fields might vary, (see [PR for motivations](https://github.com/algolia/api-clients-automation/pull/2441)).

In order to support the partial assertion, your client must provide an helper named `union` to do so, you can take a look at existing implementations:
- [python](https://github.com/algolia/api-clients-automation/blob/main/tests/output/python/tests/helpers.py)
- [javascript](https://github.com/algolia/api-clients-automation/blob/main/tests/output/javascript/src/helpers.ts)
- [ruby](https://github.com/algolia/api-clients-automation/blob/main/tests/output/ruby/src/helpers.rb)

### Clients tests

The clients tests are located in the folder `tests/CTS/client/<apiName>`, they aim at testing the constructors and common error thrown by an API, and can be use to build more complex multi-step tests.

> TODO

## How to add a new language

### Requests tests

Create a template in `templates/<languageName>/tests/requests.mustache` that parses an array of tests into the test framework of choice.

> See [implementation of the JavaScript tests](https://github.com/algolia/api-clients-automation/blob/main/templates/javascript/tests/requests/requests.mustache)

When writing your template, here is a list of variables accessible from `mustache`:

```json
{
  "client": "the name of the API Client object to instanciate and import",
  "clientPrefix": "the name of the client without Client at the end",
  "hasRegionalHost": "true if the hosts accepts region",
  "defaultRegion": "the region to provide by default to the constructor",
  "hasE2E": "true if the test suite has e2e tests to be asserted",
  "blocks": [
    {
      // The list of test to implement
      "operationID": "the name of the endpoint and the cts file to test",
      "tests": [
        {
          "method": "the method to call on the API Client",
          "testName": "the descriptive name test (default to `method`)",
          "testIndex": "the index of the test to avoid duplicate function name",
          "hasParameters": "true if the method has parameters, useful for `GET` requests",
          "assertNullBody": "true if the method does not have a body, useful to assert if `GET` and `DELETE` requests are correctly parsed",
          "parameters": {
            // Object of all parameters with their name, to be used for languages that require the parameter name
            "parameterName": "value"
            // ...
          },
          "parametersWithDataType": [
            {
              "key": "key",
              "value": "value",
              // booleans indicating the data type
              "isArray": false,
              "isObject": true,
              "isFreeFormObject": false,
              "isString": false,
              "isInteger": false,
              "isLong": false,
              "isDouble": false,
              "isEnum": false,
              "isBoolean": false,
              "objectName": "SearchParams",
              // oneOfModel empty if there is no oneOf
              "oneOfModel": {
                // the compound type
                "parentClassName": "SearchParams",
                "type": "SearchParamsObject",
                "x-one-of-explicit-name": "true if the name needs to be explicit (types are compatible)"
              },
              // properties used to have unique name and link to parent
              "parent": "theParentObject",
              // whether there is a parent to the current object or not.
              "isRoot": false,
              "suffix": 7,
              "parentSuffix": 6,
              "useAnonymousKey": "true if we are in an array at the first level",
              // boolean indicating if it is the last parameter
              "-last": false
            }
          ],
          "parametersWithDataTypeMap": {
            "parameterName": {
              // Same as the parametersWithDataType, where the "key" is really a key
            }
          },
          // boolean indicating if the method has requestOptions, useful to shape your template only if provided
          "hasRequestOptions": true,
          "requestOptions": {
            "queryParameters": {
              // the raw JSON object
              "parameters": {},
              // list of parameters with enhance types
              "parametersWithDataType": [],
              // map of enhance parameters
              "parametersWithDataTypeMap": {}
            },
            "headers": {
              // the raw JSON object
              "parameters": {},
              // list of parameters with enhance types
              "parametersWithDataType": [],
              // map of enhance parameters
              "parametersWithDataTypeMap": {}
            }
          },
          "request": {
            "path": "the expected path of the request",
            "method": "the expected method: GET, POST, PUT, DELETE or PATCH",
            "body": {
              // The expected body of the request
            },
            "queryParameters": {
              // key: string map
              "parameterName": "stringify version of the value"
            },
            "headers": {
              // key: string map
              "headerName": "stringify version of the value"
            }
          },
          "response": {
            "statusCode": 200, // any status code expected by the request sent
            "body": {} // the raw JSON object returned by the API
          }
        }
      ]
    }
  ]
}
```

As well as lambdas to transform strings:

- `escapeQuotes` - Escapes double quotes characters, replaces `"` with `\"`.
- `escapeSlash` - Escapes backward slash characters, replaces `\` with `\\`.
- `lowercase` - Converts all of the characters in this fragment to lower case using the rules of the ROOT locale.
- `uppercase` - Converts all of the characters in this fragment to upper case using the rules of the ROOT locale.
- `titlecase` - Converts text in a fragment to title case. For example once upon a time to Once Upon A Time.
- `camelcase` - Converts text in a fragment to camelCase. For example Input-text to inputText.
- `indented` - Prepends 4 spaces indention from second line of a fragment on. First line will be indented by Mustache.
- `indented_8` - Prepends 8 spaces indention from second line of a fragment on. First line will be indented by Mustache.
- `indented_12` - Prepends 12 spaces indention from second line of a fragment on. First line will be indented by Mustache.
- `indented_16` - Prepends 16 spaces indention from second line of a fragment on. First line will be indented by Mustache.

If specific values are needed for a specific languages, or custom generated files, they can be added using a custom CTS manager:

- [javascript](https://github.com/algolia/api-clients-automation/blob/main/generators/src/main/java/com/algolia/codegen/cts/manager/JavaScriptCTSManager.java)
  - `utilsPackageVersion`: the utils version to import
  - `import`: the name of the package or library to import
- [java](https://github.com/algolia/api-clients-automation/blob/main/generators/src/main/java/com/algolia/codegen/cts/manager/JavaCTSManager.java)
  - `packageVersion`: the version of the Java client
  - `import`: the name of the client package to import from

### Clients tests

> TODO

## Add common tests to every clients

You might want to test how every clients behaves, without having to duplicate the same tests. We provide 4 methods on every clients, common to all languages.

You can find [the common folder](https://github.com/algolia/api-clients-automation/tree/main/tests/CTS/requests/common) in the CTS too. [Adding a test](#how-to-add-test) in this folder will generate tests for all the clients.

## Get the list of remaining CTS to implement

To get the list of `operationId` not yet in the CTS but in the spec, run this command:

```bash
rm -rf ./specs/bundled
comm -3 <(grep -r operationId ./specs | awk -F: '{gsub(/ /,""); print $NF}' | sort) <(find ./tests/CTS/clients -type f -name '*.json' | awk -F/ '{gsub(/.json/,"");print $NF}' | sort)
```
