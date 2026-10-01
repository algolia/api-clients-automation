# PROJECT KNOWLEDGE BASE

**Generated:** 2026-01-14
**Commit:** 609737c378
**Branch:** main

## OVERVIEW

Multi-language API client generator for Algolia. Generates 11 language clients (JavaScript, Python, Java, Go, Ruby, PHP, Kotlin, Scala, Swift, Dart, C#) from OpenAPI specs using custom OpenAPI Generator extensions.

## STRUCTURE

```
api-clients-automation/
├── clients/           # Generated API clients (11 languages) - DO NOT EDIT directly
├── generators/        # Custom Java OpenAPI generators (Gradle)
├── templates/         # Mustache templates per language
├── specs/             # OpenAPI YAML specifications
│   ├── bundled/       # Pre-built specs for generation
│   └── {api}/         # Modular specs (search, ingestion, insights...)
├── scripts/           # TypeScript CLI and build orchestration
│   ├── cli/           # Commander.js CLI entry point
│   ├── cts/           # Common Test Suite generation
│   ├── release/       # Release automation
│   └── ci/            # GitHub Actions helpers
├── config/            # Generation config, version files
├── tests/             # CTS test definitions and output
├── docs/              # Snippets, guides per language
├── website/           # Docusaurus documentation site
├── eslint/            # Custom ESLint plugin for spec validation
└── playground/        # Language-specific test environments
```

## WHERE TO LOOK

| Task                            | Location                                           | Notes                   |
| ------------------------------- | -------------------------------------------------- | ----------------------- |
| Add/modify API endpoint         | `specs/{api}/paths/`                               | Then regenerate clients |
| Change generated code structure | `templates/{language}/`                            | Mustache templates      |
| Custom generation logic         | `generators/src/main/java/com/algolia/codegen/`    | Java generators         |
| CLI commands                    | `scripts/cli/index.ts`                             | Commander.js            |
| Build/test a client             | `scripts/buildLanguages.ts`                        | Via `yarn cli build`    |
| Add new language                | `config/clients.config.json` + `templates/{lang}/` | See docs                |
| CI/CD workflows                 | `.github/workflows/check.yml`                      | Main pipeline           |
| Release process                 | `scripts/release/`                                 | `yarn cli release`      |

## CODE MAP

### Entry Points

- `yarn cli` → `scripts/cli/index.ts` (main CLI)
- `yarn cli generate [lang] [clients]` → Code generation
- `yarn cli build clients|specs|snippets` → Build artifacts
- `yarn cli cts generate|run` → Common Test Suite

### Key Files

| File                           | Purpose                                      |
| ------------------------------ | -------------------------------------------- |
| `config/clients.config.json`   | All language/client definitions              |
| `config/generation.config.mjs` | Which files are generated vs hand-written    |
| `openapitools.json`            | OpenAPI Generator config (auto-generated)    |
| `scripts/common.ts`            | Shared utilities (run, toAbsolutePath, etc.) |
| `scripts/buildLanguages.ts`    | Language build orchestration                 |

## CONVENTIONS

### Commit Messages

```
type(scope): description
```

Types: `fix`, `feat`, `refactor`, `docs`, `chore`
Scopes: `specs`, `javascript`, `python`, language names, or `deps`

### Generated vs Hand-Written

- Check `config/generation.config.mjs` for exact patterns
- **Hand-written** (safe to edit): all files mentioned in `config/generation.config.mjs` that START with `!`
- **Generated** (DO NOT EDIT): all files mentioned in `config/generation.config.mjs` that DON'T START with `!`, or all non-mentioned files in generated client folders

Be careful to check for glob patterns!

### Implementation Notes (non-trivial branches)

When working on a non-trivial task (multi-file, multi-language, or anything with a plan), maintain an `implementation-notes.md` at the repo root (gitignored, local-only):

- **On start**: record the task, the plan, and any blindspot findings or open questions.
- **During work**: every time you deviate from the plan, log one entry: what changed, why it was forced (constraint discovered, wrong assumption, etc.).
- **On completion**: the notes are input for the `audit` skill (which checks deviations were deliberate) and for handoffs to other agents.

Keep entries short — one or two lines each. The value is the deviation log, not prose.

### Code Generation Flow

1. Edit OpenAPI spec in `specs/{api}/`
2. Run `yarn cli build specs` to bundle
3. Run `yarn cli generate {language}` to regenerate
4. Hand-written code in folders and files mentioned in `config/generation.config.mjs` is preserved

## ANTI-PATTERNS (THIS PROJECT)

- **NEVER** edit files in file not explicitly marked as hand-written in `config/generation.config.mjs` because they will be overwritten at generation time
- **NEVER** use `as any` or `@ts-ignore` in scripts/
- **NEVER** commit without running `yarn cli format {language} {folder}`
- **NEVER** manually edit `openapitools.json` - it's auto-generated
- **NEVER** bypass pre-commit hooks as they ensure consistency, formatting, code quality
- **DO NOT** add language-specific logic to `scripts/` - use templates instead

## UNIQUE STYLES

### Multi-Build System

- **Node.js/TypeScript**: Scripts, CLI, website, ESLint plugin (`yarn`)
- **Java/Gradle**: Custom OpenAPI generators (`./gradlew build` in `generators/`)
- **Docker**: Language-specific builds via `yarn docker:setup`

### Language Version Files

All in `config/`: `.java-version`, `.python-version`, `.ruby-version`, `.go-version`, `.swift-version`, `.php-version`, `.dart-version`, `.csharp-version`

### Protected Files Pattern

Files in `.openapi-generator-ignore` and negated patterns in `generation.config.mjs` are hand-written and NOT overwritten during generation.

## COMMANDS

```bash
# Setup
nvm use && yarn                    # Install dependencies
yarn docker:setup                  # Setup Docker environment

# Generation
yarn cli generate javascript       # Generate all JS clients
yarn cli generate python search    # Generate Python search client
yarn cli build specs               # Bundle OpenAPI specs
yarn cli build specs --docs        # Build specs with doc snippets

# Testing
yarn cli cts generate [lang]       # Generate CTS tests
yarn cli cts run [lang]            # Run CTS tests
yarn cli playground {lang} {client} # Run interactive playground

# Formatting
yarn cli format {language} {folder}

# Release
yarn cli release                   # Create release PR
yarn cli release --dry-run         # Test release without pushing
```

## NOTES

### API Documentation Guidelines

When writing or editing API specs, follow `website/docs/add-a-new-api/api-documentation-guidelines.md`.

### Never Remove Spec Fields

Removing a field from a published spec is a breaking change (breaks the user/API contract), even if the API ignores it — mark it `x-deprecated: true` (or explain in `description`) instead; genuine breaking changes must be called out as `BREAKING CHANGE` entries in the affected client changelogs.

### Backfilling a Missed GitHub Release

`scripts/ci/codegen/createGitHubReleases.ts` only runs when HEAD's commit message starts with `chore: release` (the CI gate), so it silently skips on a `main` that has moved past the release commit. To backfill a missed release, run it from a temporary git worktree checked out at the release commit (with `GITHUB_TOKEN` and `RUNNER_TEMP` set).

### Docker Required

Most language builds require Docker. Run `yarn docker:setup` first. Images: `apic_base` (most languages), `apic_ruby`, `apic_swift`.

### CI Matrix

CI runs parallel builds per language. Dynamic matrix generated from git diff - only changed clients rebuild. See `.github/workflows/check.yml`.
