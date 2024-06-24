---
title: Release process
---

# Release process

## Usage

### 1. Setup your `GITHUB_TOKEN`

You need a `GITHUB_TOKEN` in your [`.env`](https://github.com/algolia/api-clients-automation/blob/main/.env.example) file at the root of the repository. You can generate one from the [personal access token page](https://github.com/settings/tokens/new) with `Repo (Full control of private repositories)` scope.

```
GITHUB_TOKEN=<YOUR-PERSONAL-ACCESS-TOKEN>
```

Once setup, you can run:

:::info
See [Use CLI release commands](/docs/contributing/CLI/release-commands) for the detailed release commands
:::

```bash
apic release
```

It will create [a release PR](https://github.com/algolia/api-clients-automation/pull/545).

### 2. Review the release PR.

You need to review the release PR, in two parts:

1.  version changes
2.  CHANGELOGs

You need approval from a member of the [`@algolia/api-clients-automation`](https://github.com/orgs/algolia/teams/api-clients-automation) team to release clients.

### 3. The release process.

After a full CI run, a release commit will be sent to every repository and spread changes to their `next` branch.

Each language repository should have their own release process, and should run only when the latest commit starts with `chore: release`. By doing so, we have a way to just update the repository, for example READMEs, without having to release.

## SLA graph

In order to generate the SLA graphs ([available here](/docs/clients/service-level-agreement)), we leverage the open-source Node.js tools:
- [JSON input format file](https://github.com/nodejs/Release/blob/main/schedule.json)
- [script](https://github.com/nodejs/lts-schedule)

The source of truth data lives in [the release config file](https://github.com/algolia/api-clients-automation/blob/main/config/release.config.json), under the `lts` field.

### Patch `lts` package

The [`lts`](https://github.com/nodejs/lts-schedule) package has been patched (with `yarn patch lts`, see diff in `.yarn/patches`), if you edit the patch, make sure to run `yarn patch-commit -s /path/to/your/patch/folder` in order to update the lock.

### Generate

```bash
apic release -gg
```
