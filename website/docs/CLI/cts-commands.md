---
title: Common Test Suite commands
---

# Common Test Suite commands

:::info

Common Test Suite requires all clients to be built.

You can use `yarn cli` as a drop in replacement for `apic`.

:::

The Common Test Suite commands are used to [`generate`](#generate) and [`run`](#run) tests.

## Usage

> `language` and `client` defaults to `all`

> The `client` parameter is variadic, you can pass multiple `client` name

```bash
apic cts generate <language | all> <client... | all>
```

### Available options

| Option   | Command        | Description                                                                       |
|----------|:---------------|:----------------------------------------------------------------------------------|
| verbose  | -v, --verbose  | Make the process verbose, display logs from third party tools                     |
| debugger | -d, --debugger | runs the generator in debug mode, it will wait for a Java debugger to be attached |

## Generate

### Generate CTS for all clients for all supported languages

```bash
apic cts generate
```

### Generate CTS for specific client for specific language

```bash
apic cts generate java search
```

### Generate CTS for many client for specific language

```bash
apic cts generate php insights recommend search
```

### Attach a debugger to the generator

Using VS code extension [Debugger For Java](https://code.visualstudio.com/docs/java/java-debugging), you can attach breakpoint to the generator.
Example config for VS Code in `.vscode/launch.json`:

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "APIC Generator",
      "request": "attach",
      "hostName": "localhost",
      "port": "5009"
    }
  ]
}
```

```bash
apic cts generate java search -d
```

Then you can connect you favorite Java debugger, either IntelliJ, VS Code, or jdb.

## Run

### Run CTS for all supported languages

```bash
apic cts run
```

### Run CTS for a specific languages

```bash
apic cts run javascript
```
