---
title: Clients commands
---

# Clients commands

The Clients commands are used to [`generate`](#generate) and [`build`](#build) API clients.

## Usage

> `language` and `client` defaults to `all`

> The `client` parameter is variadic, you can pass multiple `client` name

```bash
apic generate <language | all> <client... | all>
```

### Available options

| Option  | Command       | Description                                                   |
| ------- | :------------ | :------------------------------------------------------------ |
| verbose | -v, --verbose | Make the process verbose, display logs from third party tools |

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
