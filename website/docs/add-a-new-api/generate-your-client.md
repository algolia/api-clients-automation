---
title: Generate your client
---

:::info

Make sure to first read the [setup the repository tooling section](/docs/setup-repository) first.

This section is only about **adding to the existing API clients**, to support a new programming language, see [Support a new language](/docs/add-a-new-language).

:::

## Configuration file

> Most of the configuration is determined by the api-clients-automation CLI (`scripts/`).

The file [`config/clients.config.json`](https://github.com/algolia/api-clients-automation/blob/main/config/clients.config.json) contains information that's common to all clients generated for each language, you can [find its JSON schema here](https://github.com/algolia/api-clients-automation/blob/main/config/clients.schema.json).

## CLI Commands

Use the CLI to generate your client:

- [Commands for working with clients](/docs/CLI/generate-commands)

## Generate a pre-release client

:::info

Only the JavaScript client releases standalone packages along with the main `algoliasearch` package, so it's the only possible "generated" solution for pre-releases (alpha or beta).

:::

1. [Update the configuration file](https://github.com/algolia/api-clients-automation/blob/main/config/clients.config.json#L131)

The `clients` field define which specification to generate and their output location. In order to create a pre-release for your API, it needs to be standalone only (non bundled with `algoliasearch`).

```json
{
  "name": "awesomeapi", // this must match the name of the specification
  "output": "clients/algoliasearch-client-javascript/packages/awesomeapi", // make sure to keep everything in `clients/algoliasearch-client-javascript/packages/`
  "isStandaloneClient": true // this tells the generator not to put it in the `algoliasearch` bundle
},
```

2. Generate your client

With just the above changes, you can now run `yarn cli generate -h` which should output a complete list of the available APIs for Javascript, `awesomeapi` should be in it.

Running `yarn cli generate javascript awesomeapi` will generate the client and format it, and `yarn cli build clients javascript awesomeapi` will bundle it.

3. Test the client

At least one test per operation is required, you can read more about it in the [Common Test Suite section](/docs/testing/common-test-suite.md).

4. Release

We take care of it, open your pull request :)
