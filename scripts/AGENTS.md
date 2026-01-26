# SCRIPTS KNOWLEDGE BASE

## OVERVIEW

TypeScript CLI and build orchestration for API client generation. Entry point: `yarn cli` (Commander.js).

## STRUCTURE

```
scripts/
├── cli/               # CLI entry point and utilities
│   ├── index.ts       # Main commands (generate, build, cts, release, etc.)
│   └── utils.ts       # Argument parsing, language/client selection
├── cts/               # Common Test Suite
│   ├── generate.ts    # CTS test generation
│   ├── runCts.ts      # Test execution
│   └── testServer/    # Mock test server
├── release/           # Release automation
│   └── createReleasePR.ts
├── ci/                # CI/CD helpers
│   ├── codegen/       # Code generation for CI (push, spread, wait)
│   ├── githubActions/ # Matrix generation, run variables
│   └── actions/       # Custom GitHub Actions
├── specs/             # Spec building (Redocly bundling)
├── pre-gen/           # Pre-generation tasks
└── docs/              # Documentation generation
```

## WHERE TO LOOK

| Task                 | File                         | Notes                                       |
| -------------------- | ---------------------------- | ------------------------------------------- |
| Add CLI command      | `cli/index.ts`               | Use Commander.js pattern                    |
| Language build logic | `buildLanguages.ts`          | Handles client/playground/snippets/guides   |
| Run shell commands   | `common.ts` → `run()`        | Supports Docker execution                   |
| Get language paths   | `config.ts`                  | `getLanguageFolder()`, `getTestExtension()` |
| Format code          | `formatter.ts`               | Language-specific formatters                |
| Generate CTS tests   | `cts/generate.ts`            | Uses custom CTS generator                   |
| Release workflow     | `release/createReleasePR.ts` | Version bumps, changelogs                   |

## CONVENTIONS

### Adding CLI Commands

```typescript
program
  .command('mycommand')
  .description('What it does')
  .addArgument(args.language) // Optional language arg
  .addArgument(args.clients) // Optional clients arg
  .addOption(flags.verbose)
  .action(async (langArg, clientArg, { verbose }) => {
    const { language, client } = transformSelection({ langArg, clientArg });
    // Implementation
  });
```

### Running Commands

```typescript
import { run } from '../common.ts';

// Simple command
await run('npm install');

// With Docker (uses language's Docker image)
await run('bundle install', { language: 'ruby' });

// With working directory
await run('go build', {
  language: 'go',
  cwd: 'clients/algoliasearch-client-go',
});
```

### Language Configuration

All language metadata from `config/clients.config.json`. Access via:

```typescript
import {
  getLanguageFolder,
  getTestExtension,
  getDockerImage,
} from '../config.ts';
```

## ANTI-PATTERNS

- **NEVER** hardcode language paths - use `getLanguageFolder(language)`
- **NEVER** skip Docker for language builds - breaks CI consistency
- **NEVER** add language-specific logic here - put in templates instead
- **DO NOT** import from `clients/` - scripts are language-agnostic

## KEY EXPORTS (common.ts)

| Export                 | Purpose                              |
| ---------------------- | ------------------------------------ |
| `run(cmd, opts)`       | Execute shell command (Docker-aware) |
| `toAbsolutePath(path)` | Resolve relative to repo root        |
| `LANGUAGES`            | Array of all supported languages     |
| `CLIENTS`              | Array of all client names            |
| `CI`                   | Boolean: running in CI environment   |
| `setVerbose(bool)`     | Enable verbose logging               |
