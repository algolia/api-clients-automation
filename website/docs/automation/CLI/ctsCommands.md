---
title: Common Test Suite commands
---

# Common Test Suite commands

:::info

Common Test Suite requires all clients to be built.

:::

## Usage

> `language` and `client` defaults to `all`

```bash
yarn docker cts generate <language | all> <client | all>
```

### Available options

| Option      | Command           | Description                                                   |
| ----------- | :---------------- | :------------------------------------------------------------ |
| verbose     | -v, --verbose     | Make the process verbose, display logs from third party tools |
| interactive | -i, --interactive | Open prompt to query parameters                               |

## Generate

### Generate CTS for all supported languages for all clients

```bash
yarn docker cts generate
```

### Generate CTS for specific language for specific client

```bash
yarn docker cts generate java sources
```

## Run

### Run CTS for all supported languages

```bash
yarn docker cts run
```

### Build specific language

```bash
yarn docker build clients javascript
```
