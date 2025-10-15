<div align="center">

# API Clients Automation

The Algolia API clients are generated from [OpenAPI specs](https://swagger.io/specification/), leveraging the open-source [openapi-generator](https://openapi-generator.tech/) tool.

[![License](https://img.shields.io/badge/license-MIT-green.svg?style=flat-square)](./LICENSE.md)

<p align="center">
  <strong>
  <a href="https://api-clients-automation.netlify.app/">API clients automation documentation</a> •
  <a href="https://www.algolia.com/doc/">Algolia documentation</a>
  </strong>
</p>

</div>

**Migration note from current API clients**

> In July 2022, we released an alpha version generated API clients for the JavaScript, Java and PHP languages. If you are using the latest stable of those clients and looking to upgrade, read the [migration guide](https://www.algolia.com/doc/libraries/sdk/upgrade). You can still browse the documentation of the stable clients on [the Algolia documentation](https://www.algolia.com/doc/).

## 💡 Getting Started with the clients

You can read `getting started` guides and how to use the API clients on [our documentation](https://www.algolia.com/doc/libraries/sdk/install).

## ✨ Contributing

> Looking to add a new client, or fix a bug? Make sure to take a look at [our contribution guides](https://api-clients-automation.netlify.app/docs/introduction).

### Setup repository tooling

```bash
nvm use && yarn
```

### Setup dev environment

> **Make sure to have Docker installed so you don't have to install the tooling for every API clients.**

```bash
yarn docker:setup
```

[Read more on our documentation](https://api-clients-automation.netlify.app/docs/setup-repository)

### CLI

The CLI allows you to make changes locally and run commands through the docker container.

- [Generate CLI commands](https://api-clients-automation.netlify.app/docs/CLI/generate-commands)
- [Build CLI commands](https://api-clients-automation.netlify.app/docs/CLI/build-commands)
- [CTS CLI commands](https://api-clients-automation.netlify.app/docs/CLI/cts-commands)
- [Release CLI commands](https://api-clients-automation.netlify.app/docs/CLI/release-commands)

### Guides and requirements

Read the guides and requirements to:

- [Add a new client](https://api-clients-automation.netlify.app/docs/add-a-new-api/write-a-specification)
- [Add a new language](https://api-clients-automation.netlify.app/docs/add-a-new-language)

### Tests

Test the generated clients by running:

- The [`playground`](./playground) (see [documentation](https://api-clients-automation.netlify.app/docs/testing/playground))
- The [`Common Test Suite`](./tests/) (see [documentation](https://api-clients-automation.netlify.app/docs/testing/common-test-suite)).

For full documentation, visit the **[online documentation](https://api-clients-automation.netlify.app/docs/introduction)**.

## ❓ Troubleshooting

Encountering an issue with the API clients? Before reaching out to support, we recommend heading to our [FAQ](https://support.algolia.com/hc/sections/15061037630609-API-Client-FAQs) where you will find answers to the most common issues and gotchas with the client.

You can also [open an issue on GitHub](https://github.com/algolia/api-clients-automation/issues/new/choose).

## 📄 License

Algolia API clients automation is an open-sourced software licensed under the [MIT license](LICENSE.md).
