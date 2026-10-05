# CLIENTS KNOWLEDGE BASE

## OVERVIEW

Generated API clients for 11 languages. Most code is auto-generated - only edit hand-written directories.

**Each client has its own AGENTS.md** with language-specific conventions, patterns, and gotchas. See the per-language file for detailed guidance.

## STRUCTURE

```
clients/
├── algoliasearch-client-javascript/   # TypeScript/JavaScript (monorepo) → See AGENTS.md
├── algoliasearch-client-python/       # Python (Poetry) → See AGENTS.md
├── algoliasearch-client-java/         # Java (Gradle) → See AGENTS.md
├── algoliasearch-client-go/           # Go (modules) → See AGENTS.md
├── algoliasearch-client-ruby/         # Ruby (Bundler) → See AGENTS.md
├── algoliasearch-client-php/          # PHP (Composer) → See AGENTS.md
├── algoliasearch-client-kotlin/       # Kotlin (Gradle, multiplatform) → See AGENTS.md
├── algoliasearch-client-scala/        # Scala (SBT) → See AGENTS.md
├── algoliasearch-client-swift/        # Swift (SPM) → See AGENTS.md
├── algoliasearch-client-dart/         # Dart (Pub/Melos) → See AGENTS.md
└── algoliasearch-client-csharp/       # C# (.NET) → See AGENTS.md
```

## GENERATED VS HAND-WRITTEN

**Before editing any file in `clients/`, verify it's not auto-generated.**

Rules: see [Generated vs Hand-Written](../AGENTS.md#generated-vs-hand-written) in the root `AGENTS.md`. Example from `config/generation.config.mjs`:

```javascript
'clients/algoliasearch-client-go/algolia/**',     // Generated
'!clients/algoliasearch-client-go/algolia/transport/**',  // Hand-written (safe)
```

When in doubt, check the config file before making changes.

## WHERE TO LOOK

| Task                    | Location                                              | Notes               |
| ----------------------- | ----------------------------------------------------- | ------------------- |
| Fix transport/HTTP bug  | Check `config/generation.config.mjs` for `!` patterns | Hand-written code   |
| Fix model serialization | `templates/{lang}/model.mustache`                     | Regenerate after    |
| Add API method          | `specs/{api}/paths/` then regenerate                  | Via code generation |
| Add client helper       | `templates/{lang}/*.mustache`                         | Regenerate after    |

## CONVENTIONS

### Package Versions

Defined in `config/clients.config.json`. Updated during release.

### Client APIs (All Languages)

Each client has consistent API structure:

- Constructor with `appId`, `apiKey`, optional config
- Method per API operation (named from `operationId`)
- Async variants where applicable
- Request options parameter for overrides

### Testing

- CTS (Common Test Suite) in `tests/output/{lang}/`
- E2E tests require credentials in `.env`
- Commands: see [COMMANDS](../AGENTS.md#commands) in the root `AGENTS.md`

## ANTI-PATTERNS

- **NEVER** commit without regenerating after spec changes
- **DO NOT** add language-specific API logic - use templates
- **DO NOT** bypass transport layer for HTTP calls

## COMMANDS

Generate, test, playground and format commands: see [COMMANDS](../AGENTS.md#commands) in the root `AGENTS.md`. Client-specific:

```bash
yarn cli build clients javascript    # Build JS clients
yarn cli build playground go search  # Build Go playground
yarn cli format javascript clients/algoliasearch-client-javascript
```
