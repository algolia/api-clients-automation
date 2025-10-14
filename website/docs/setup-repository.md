---
title: Setup repository
---

# Setup repository

:::info

Make sure to have:

- [Docker installed so you don't have to install the tooling for every API clients](https://docs.docker.com/desktop/mac/install/)
- [jq because it's nice](https://jqlang.github.io/jq/download/)

:::

## Install the dependencies

```bash
nvm use && yarn
```

## Mounting the docker images

We use multiple docker images to simplify the build. There is [one base image](https://github.com/algolia/api-clients-automation/blob/main/scripts/docker/Dockerfile.base) that contains everything except [swift](https://github.com/algolia/api-clients-automation/blob/main/scripts/docker/Dockerfile.swift) and [ruby](https://github.com/algolia/api-clients-automation/blob/main/scripts/docker/Dockerfile.ruby), they have their own Dockerfile

```bash
yarn docker:setup
```

## Tooling

:::info

This step is optional, using `yarn cli ...` should work perfectly as well.

:::

Install the CLI tool by following the instructions at the top of [scripts/install.sh](https://github.com/algolia/api-clients-automation/blob/main/scripts/install.sh) to acces `apic` from your terminal, with bash autocompletion.
You can run `apic help` to check if it's working properly.

#### Clean

> Stops all containers and clean the images

```bash
docker compose down --rmi all
```

## Contribute

Once you've successfully built and mounted the Docker image, you can now play with the repository! Read our guides on:

- [How to add a new API to an existing client](/docs/add-a-new-api/write-a-specification)
- [Add a new language](/docs/add-a-new-language)
- [Use CLI specs commands](/docs/CLI/build-commands)
- [Use CLI clients commands](/docs/CLI/generate-commands)
- [Use CLI release commands](/docs/CLI/release-commands)
- [Use CLI Common Test Suite commands](/docs/CLI/build-commands)

## Troubleshooting

:::caution

You should run the commands via the [Docker container](#mounting-the-docker-images) to avoid issues.

:::

> `Error: The operation couldn't be completed. Unable to locate a Java Runtime.`

Java is not located in your PATH, either source the right `.bash_profile`, `.zshrc`, etc. file or do the following command in this repository:

```bash
echo 'export PATH="/usr/local/opt/openjdk/bin:$PATH"' > .bash_profile && source .bash_profile
```

### Running renovate locally

Running renovate on github can be tidious because it only works on the branch `main`, but you can run it locally with the CLI:

```sh
npm install -g renovate

GITHUB_COM_TOKEN="<github token>" LOG_LEVEL=debug renovate --dry-run --platform local
```
