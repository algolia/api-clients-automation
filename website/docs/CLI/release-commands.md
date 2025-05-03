---
title: Release commands
---

# Release commands

:::info

You can use `yarn cli` as a drop in replacement for `apic`.

:::

The Release commands are used to release every, or a subset of API clients.

## Usage

> The `language` parameter is variadic, you can pass multiple `language`, it defaults to every available languages.

```bash
apic release <language... | all>
```

### Available options

| Option          | Command                  | Description                                                                                      |
| --------------- | :----------------------- | :----------------------------------------------------------------------------------------------- |
| verbose         | -v, --verbose            | Make the process verbose, display logs from third party tools                                    |
| dry run         | -d, --dry-run            | Locally generate a new release but do not push to GitHub                                         |
| version history | --vh, --versions-history | Generates versions-history policy for SLA                                                        |
| releaseType     | --rt, --release-type     | Forces the release script to create a release for the given client list of the given releaseType |

## Release

### Release all supported languages

```bash
apic release
```

### Release a specific language

```bash
apic release javascript
```

### Release many specific language

```bash
apic release javascript php dart
```
