---
title: Clients commands
---

# Clients commands

## Usage

> `language` and `client` defaults to `all`

```bash
yarn docker generate <language | all> <client | all>
```

### Available options

| Option      | Command           | Description                                                   |
| ----------- | :---------------- | :------------------------------------------------------------ |
| verbose     | -v, --verbose     | Make the process verbose, display logs from third party tools |
| interactive | -i, --interactive | Open prompt to query parameters                               |

## Generate

### Generate all supported languages for all clients

```bash
yarn docker generate
```

### Generate specific language for specific client

```bash
yarn docker generate java sources
```

## Build

### Build all supported languages for all clients

```bash
yarn docker build clients
```

### Build specific language for specific client

```bash
yarn docker build clients javascript recommend
```
