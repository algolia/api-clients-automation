# How to add support of a new language

> We use [openapi-generator](https://openapi-generator.tech/) to generate API clients.

> See [README](../README.md) for the repository commands

## Find a template to start with

> Provided templates should be a good starting point to generate a client but make sure to implement the [Algolia requirements](#algolia-requirements) to make it work properly.

You can pick a default template on the [openapi-generator's "generators" page](https://openapi-generator.tech/docs/generators)

> [Install openapi-generator](https://openapi-generator.tech/docs/installation/)

### Extract the template locally

```bash
openapi-generator author template -g <YOUR_TEMPLATE_NAME> -o templates/<YOUR_API_CLIENT_NAME>
```

Example for the JavaScript client with the `typescript-node` template:

```bash
openapi-generator author template -g typescript-node -o templates/javascript/
```

## Update the generator config

Add each client in the file [`openapitools.json`](../openapitools.json), following the others client structure.

> See [How to add a new client](./addNewClient.md) for informations regarding this file

### Algolia requirements

API clients require custom Algolia logic in order to work with our engine.

### Strip code

The generator includes a lot of useless features that we don't use:

- Multiple authentication methods: We only use `appId`/`apiKey` authentication methods in headers.
- Built-in transporters: The engine requires a [retry strategy](#retry-strategy) and a lot of other features, you need to implement it.
- File support, payload format etc.: We only need to support JSON to communicate with the engine.

**DX is key, make sure to provide a linter and formatting tools, with consistent method usage based on the language.**

### Init method

By default, OpenAPI will put the `AppId` and `ApiKey` in every method parameters, but our clients to be initialized with those values and put them in the header of every requests, with the right hosts.

The constructor of the client can be edited (from the `.mustache` files) to accept and store those values.

- [First implementation on the JavaScript client](https://github.com/algolia/api-clients-automation/pull/7)
- [Current implementation on the JavaScript client](https://github.com/algolia/api-clients-automation/blob/main/clients/algoliasearch-client-javascript/packages/client-search/src/searchApi.ts#L110-L125)

### Retry strategy

The retry strategy cannot be generated and needs to be implemented outside of the generated client folder. You can achieve this by creating a `utils` (or any naming that you find relevant) folder and add your transporter and retry strategy logic to it.

- [First implementation on the JavaScript client](https://github.com/algolia/api-clients-automation/pull/9)
- [Current implementation on the PHP client](https://github.com/algolia/api-clients-automation/tree/main/clients/algoliasearch-client-php/lib/RetryStrategy)

### Different client hosts

Some Algolia clients (search and recommend) targets the default appId host (`${appId}-dsn.algolia.net`, `${appId}.algolia.net`, etc.), while clients like `personalization` have their own regional `host` (`eu` | `us` | `de`).

We guess those hosts methods and variables by reading the `servers` in your spec file and create variables for you to use in your templates, [read more here](./addNewClient.md).

### Requesters

> TODO: informations

### Logger

> TODO: informations

### **DX**

We require our API clients to have an up-to-date usage with their ecosystem, make sure to provide correct tooling to lint and format your generate code.
