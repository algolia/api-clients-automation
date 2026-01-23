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

Check `config/generation.config.mjs` for glob patterns:

- Patterns **without** `!` prefix → **generated** (DO NOT EDIT - will be overwritten)
- Patterns **with** `!` prefix → **hand-written** (safe to edit)

Example from the config:

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
- Run: `yarn cli cts run {lang}`

## ANTI-PATTERNS

- **NEVER** manually edit generated directories
- **NEVER** commit without regenerating after spec changes
- **DO NOT** add language-specific API logic - use templates
- **DO NOT** bypass transport layer for HTTP calls

## COMMANDS

```bash
# Generate
yarn cli generate javascript         # All JS clients
yarn cli generate python search      # Python search only

# Build
yarn cli build clients javascript    # Build JS clients
yarn cli build playground go search  # Build Go playground

# Test
yarn cli cts run javascript          # Run JS CTS tests
yarn cli playground python search    # Interactive playground

# Format
yarn cli format javascript clients/algoliasearch-client-javascript
```
