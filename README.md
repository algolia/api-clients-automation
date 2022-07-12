<div align="center">

# API Clients Automation

The Algolia API clients are generated from [OpenAPI specs](https://swagger.io/specification/), leveraging the open-source [openapi-generator](https://openapi-generator.tech/) tool.

[![Netlify Status](https://api.netlify.com/api/v1/badges/09af048d-a19a-44db-9312-84172b73599e/deploy-status?branch=main)](https://app.netlify.com/sites/api-clients-automation/deploys) [![License](https://img.shields.io/badge/license-MIT-green.svg?style=flat-square)](./LICENSE)

<p align="center">
  <strong>
  <a href="https://api-clients-automation.netlify.app/">API clients automation documentation</a> •
  <a href="https://www.algolia.com/doc/">Algolia documentation</a>
  </strong>
</p>

</div>

**Migration note from current API clients**

> In July 2022, we released an alpha version generated API clients for the JavaScript, Java and PHP languages. If you are using the latest stable of those clients and looking to upgrade, read the [migration guide](https://api-clients-automation.netlify.app/docs/clients/migration-guides/). You can still browse the documentation of the stable clients on [the Algolia documentation](https://www.algolia.com/doc/).

## 💡 Getting Started with the clients

You can read `getting started` guides and how to use the API clients on [our documentation](https://api-clients-automation.netlify.app/docs/clients/installation).

## ✨ Contributing

> Looking to add a new client, or fix a bug? Make sure to take a look at [our contribution guides](https://api-clients-automation.netlify.app/docs/contributing/introduction).

### Setup repository tooling

```bash
nvm use && yarn
```

### Setup dev environment

> **Make sure to have Docker installed so you don't have to install the tooling for every API clients.**

```bash
yarn docker:setup
```

[Read more on our documentation](https://api-clients-automation.netlify.app/docs/contributing/setup-repository)

### CLI

You can make changes locally and run commands through the docker container.

[Specs CLI commands](https://api-clients-automation.netlify.app/docs/contributing/CLI/specs-commands) • [Clients CLI commands](https://api-clients-automation.netlify.app/docs/contributing/CLI/clients-commands) • [CTS CLI commands](https://api-clients-automation.netlify.app/docs/contributing/CLI/cts-commands)

#### Build and validate specs

```bash
yarn docker build specs <client | all>
```

[Read more on our documentation](https://api-clients-automation.netlify.app/docs/contributing/add-new-api-client)

#### Generate clients based on the [`specs`](./specs/)

```bash
yarn docker generate <language | all> <client | all>
```

[Read more on our documentation](https://api-clients-automation.netlify.app/docs/contributing/add-new-language)

### Tests

You can test our generated clients by running:

- The [`playground`](./playground) ([Playground](https://api-clients-automation.netlify.app/docs/contributing/testing/playground.md))
- The [`Common Test Suite`](./tests/) ([Common Test Suite](https://api-clients-automation.netlify.app/docs/contributing/testing/common-test-suite.md)).

For full documentation, visit the **[online documentation](https://api-clients-automation.netlify.app/docs/contributing/introduction)**.

## ❓ Troubleshooting

Encountering an issue with the API clients? Before reaching out to support, we recommend heading to our [FAQ](https://www.algolia.com/doc/api-client/troubleshooting/faq/javascript/) where you will find answers for the most common issues and gotchas with the client.

You can also [open an issue on GitHub](https://github.com/algolia/api-clients-automation/issues/new/choose).

## 📄 License

Algolia API clients automation is an open-sourced software licensed under the [MIT license](LICENSE.md).
