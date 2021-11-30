# Common Test Suite

The CTS aims at ensuring minimal working operation for the API clients, by comparing the request formed by sample parameters.
It it automaticaly generated for all langages, from a json entry point.

## How to run it

```bash
yarn cts:generate all
yarn cts:test
```

If you only want to generate the tests for a set of langages, you can run:
```bash
yarn cts:generate javascript ruby
```

## How to add test

The common format for a test is a json object in the file named: `<client>/<operationId>`, that follows this schema:
```json
[
    {
        "name": "test name",
        "method": "the method to call (ex: search)",
        "parameters": [
            "indexName",
            {
                "query": "the string to search"
            }
        ],
        "request": {
            "path": "/1/indexes/indexName/query",
            "method": "POST",
            "data": { "query": "the string to search" }
        }
    }
]
```

And that's it ! If the name of the file matches a real `operationId` in the spec, then a test will be generated.

## How to add a new langage

- Create a template in `test/CTS/templates/<your langage>.mustache` that parse a array of test into your test framework of choice
- Add the langage in the array `langages` in `tests/generateCTS.ts`.

