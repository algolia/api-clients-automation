---
title: Build commands
---

# Build commands

:::info

You can use `yarn cli` as a drop in replacement for `apic`.

:::

The Build commands are used to [`build`](#build) API specs, clients, playground, snippets and guides.

## Usage for specs

> `client` defaults to `all`

> The `client` parameter is variadic, you can pass multiple `client` name

```bash
apic build specs <client... | all>
```

### Available options

| Option     | Command          | Description                                                     |
| ---------- | :--------------- | :-------------------------------------------------------------- |
| verbose    | -v, --verbose    | Make the process verbose, display logs from third party tools   |
| skip cache | -s, --skip-cache | Skip cache checking to force building specs                     |
| docs       | -d, --docs       | Builds the specs for the Algolia doc, which embeds the snippets |

## Build specs

### Build all specs

```bash
apic build specs
```

### Build specific spec

```bash
apic build specs recommend
```

### Build many spec

```bash
apic build specs recommend search ingestion
```

## Lint

### Fix specs

> Automatically done when building specs

```bash
yarn specs:fix
```

### Check specs

If you just want to check the format (not override the files)

```bash
yarn specs:lint search
```

## Usage for clients, playground, snippets and guides

> `language` and `client` defaults to `all`

> The `client` parameter is variadic, you can pass multiple `client` name

> scope is one of: `clients` | `playground` | `snippets` | `guides`

```bash
apic build <scope> <language | all> <client... | all>
```

### Available options

| Option  | Command       | Description                                                   |
| ------- | :------------ | :------------------------------------------------------------ |
| verbose | -v, --verbose | Make the process verbose, display logs from third party tools |

## Build

### Build all clients for all supported languages

```bash
apic build clients
```

### Build playground for specific language

```bash
apic build playground javascript recommend
```

### Build many snippets for specific language

```bash
apic build snippets java insights recommend search
```
