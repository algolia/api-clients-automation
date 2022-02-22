# How to add a new client

Adding a client requires a few manual steps in order to setup the tooling, generation scripts and properly generate the code. We recommend getting inspirations from existing clients such as `javascript-recommend`.

> See [README](../README.md) to `setup the repository tooling` and `setup dev environment`.

## Configuring the environment

After setting up the dev environment from [README](../README.md), you need to update the configuration files to properly generate clients that are maintainable.

### Generation config

[openapitools.json](../openapitools.json) hosts the configuration of all of the generated clients with their available languages.

#### `generators`

Generators are referenced by key with the following pattern `<languageName>-<clientName>`.

> TODO: Automate this step.

You can copy an existing object of a client and replace the `<clientName>` value with the one you'd like to generate.

| Option             |  Type   |  Language  |             Example             | Definition                                                                                                                                      |
| ------------------ | :-----: | :--------: | :-----------------------------: | :---------------------------------------------------------------------------------------------------------------------------------------------- |
| output             | string  |   Common   | `path/to/client/client-sources` | The output path of the client.                                                                                                                  |
| glob               | string  |   Common   |   `path/to/spec/sources.yml`    | The path of the bundled spec file.                                                                                                              |
| gitRepoId          | string  |   Common   |  `algoliasearch-client-java-2`  | The name of the repository under the Algolia org.                                                                                               |
| apiName            | string  | JavaScript |            `search`             | The lowercase name of the exported API.                                                                                                         |
| capitalizedApiName | string  | JavaScript |            `Search`             | The capitalized name of the exported API.                                                                                                       |
| packageVersion     | string  | JavaScript |             `1.2.3`             | The version you'd like to publish the first iteration of the generated client. It will be automatically incremented.                            |
| packageName        | string  |   common   |         `AlgoliaSearch`         | Name of the API package, used in [CTS](./CTS.md).                                                                                               |
| hasRegionalHost    | boolean |   common   |             `false`             | Automatically guessed from `servers` in spec. `undefined` implies that hosts used will required the `appId`, regional hosts are used otherwise. |
| isDeHost           | boolean |   common   |             `false`             | Automatically guessed from `servers` in spec. `undefined` implies that `eu` is the regional host, `de` otherwise.                               |
| host               | string  |   common   |            `crawler`            | Automatically guessed from `servers` in spec.                                                                                                   |
| topLevelDomain     | string  |   common   |              `io`               | Automatically guessed from `servers` in spec.                                                                                                   |

### GitHub actions

The built clients are cached with the [Cache GitHub Action](../.github/actions/cache/action.yml) to avoid useless CI tasks.

> TODO: Automate this step

You can copy [an existing client caching step](../.github/actions/cache/action.yml) or edit the following example:

```yaml
- name: Restore built <LANGUAGE> <CLIENT_NAME> client
  if: ${{ inputs.job == 'cts' }}
  uses: actions/cache@v2
  with:
    path: /home/runner/work/api-clients-automation/api-clients-automation/clients/<LANGUAGE_FOLDER>/<CLIENT_NAME>/<CLIENT_BUILD_PATH>
    key: ${{ runner.os }}-${{ env.CACHE_VERSION }}-<LANGUAGE>-<CLIENT_NAME>-${{ hashFiles('clients/<LANGUAGE_FOLDER>/<CLIENT_NAME>/**') }}-${{ hashFiles('specs/bundled/<CLIENT_SPEC>.yml') }}
```

## Writing specs

We recommend to have a look at [existing spec files](../specs/). The `bundled` folder is automatically generated, manual changes shouldn't be done in these files.

### [common spec folder](../specs/common/)

Properties that are common to Algolia or used in multiple clients.

### [clientName spec folder](../specs/search)

#### [spec file](../specs/search/spec.yml)

We recommend to copy an of existing [spec file](../specs/search/spec.yml) and edit the `paths` and `servers

This file is the entry point of the spec, it contains `servers` and `paths` of the API spec.

#### [spec common folder](../specs/search/common)

Properties that are common to the client.

#### [paths folder](../specs/search/paths)

Path definition of the paths defined in the [spec file](../specs/search/spec.yml)
