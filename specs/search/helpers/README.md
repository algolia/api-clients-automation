## Helpers

This folders contains all the helpers added to the `search` API, they have 2 purposes:
- for the client codegen, the operations are removed and only the models are kept to be used in the manual implementation of the helper.
- for the CTS to generate tests for the helpers.

For consistency and to satisfy redocly linter, and openapi format, each helper must wrapped in:

```yaml
method:
  get:
    x-helper: true
```

in order to garanty that the scripts will parse the helpers correctly.

By default, all helpers are assumed to be asynchronous methods (for example `async` in JavaScript), if a helper is synchronous, you can add:

```yaml
x-asynchronous-helper: false
```
