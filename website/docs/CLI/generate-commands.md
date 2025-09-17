---
title: Generate commands
---

# Generate commands

:::info

You can use `yarn cli` as a drop in replacement for `apic`.

:::

The Generate commands are used to [`generate`](#generate) API clients.

## Usage

> `language` and `client` defaults to `all`

> The `client` parameter is variadic, you can pass multiple `client` name

```bash
apic generate <language | all> <client... | all>
```

### Available options

| Option   | Command        | Description                                                                       |
|----------|:---------------|:----------------------------------------------------------------------------------|
| verbose  | -v, --verbose  | Make the process verbose, display logs from third party tools                     |
| debugger | -d, --debugger | runs the generator in debug mode, it will wait for a Java debugger to be attached |

## Generate

### Generate all clients for all supported languages

```bash
apic generate
```

### Generate specific client for specific language

```bash
apic generate java search
```

### Generate many client for specific language

```bash
apic generate php insights recommend search
```

## Build

### Build all clients for all supported languages

```bash
apic build clients
```

### Build specific client for specific language

```bash
apic build clients javascript recommend
```

### Build many client for specific language

```bash
apic build clients php insights recommend search
```
