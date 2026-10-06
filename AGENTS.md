# PROJECT KNOWLEDGE BASE

## OVERVIEW

Multi-language API client generator for Algolia. Generates 11 language clients (JavaScript, Python, Java, Go, Ruby, PHP, Kotlin, Scala, Swift, Dart, C#) from OpenAPI specs using custom OpenAPI Generator extensions.

## STRUCTURE

- [`clients/`](clients/AGENTS.md) — generated API clients (11 languages); each has its own `AGENTS.md`
- [`generators/`](generators/AGENTS.md) — custom Java OpenAPI generators
- [`templates/`](templates/AGENTS.md) — Mustache templates per language
- [`specs/`](specs/AGENTS.md) — modular OpenAPI specs; `specs/bundled/` is build output
- [`scripts/`](scripts/AGENTS.md) — TypeScript CLI (`yarn cli`) and build/release/CI orchestration
- `config/` — generation config, language version files
- `tests/` — CTS test definitions (`tests/CTS/`) and generated tests (`tests/output/`)
- `docs/` — generated snippets and guides per language
- `website/` — Docusaurus contributor docs (`website/docs/`)
- `eslint/` — custom ESLint plugin for spec validation
- `playground/` — per-language playgrounds

## WHERE TO LOOK

| Task                            | Location                                           | Notes                                                     |
| ------------------------------- | -------------------------------------------------- | --------------------------------------------------------- |
| Add/modify API endpoint         | `specs/{api}/paths/`                               | Then regenerate clients                                   |
| Change generated code structure | `templates/{language}/`                            | Mustache templates                                        |
| Custom generation logic         | `generators/src/main/java/com/algolia/codegen/`    | Java generators                                           |
| CLI commands                    | `scripts/cli/index.ts`                             | Commander.js, entry point of `yarn cli`                   |
| Build/test a client             | `scripts/buildLanguages.ts`                        | Via `yarn cli build`                                      |
| Add new language                | `config/clients.config.json` + `templates/{lang}/` | See docs                                                  |
| CI/CD workflows                 | `.github/workflows/check.yml`                      | Main pipeline                                             |
| Release process                 | `scripts/release/`                                 | `yarn cli release`; see `website/docs/release-process.md` |

### Key Files

| File                           | Purpose                                                              |
| ------------------------------ | -------------------------------------------------------------------- |
| `config/clients.config.json`   | All language/client definitions                                      |
| `config/generation.config.mjs` | Which files are generated vs hand-written                            |
| `openapitools.json`            | OpenAPI Generator config (generated at build; absent on fresh clone) |

## CONVENTIONS

### Commit Messages

`type(scope): description`, same types and scopes as PR titles (see [REVIEW & PR POLICY](#review--pr-policy)).

### Generated vs Hand-Written

- Check `config/generation.config.mjs` for exact patterns
- **Hand-written** (safe to edit): all files mentioned in `config/generation.config.mjs` that START with `!`
- **Generated** (DO NOT EDIT): all files mentioned in `config/generation.config.mjs` that DON'T START with `!`, or all non-mentioned files in generated client folders
- Files listed in `.openapi-generator-ignore` are also hand-written and NOT overwritten during generation

Be careful to check for glob patterns!

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
- **NEVER** make clients set default values for API parameters — defaults are handled by the engine; CTS asserts the exact number of query parameters to enforce this (see `website/docs/testing/common-test-suite.md`)
- **NEVER** run Gradle directly — use `yarn cli ...` (e.g. `generate`, `cts generate`), which builds the custom generators through the scripts and Docker (`yarn docker:setup`)

## UNIQUE STYLES

### Multi-Build System

- **Node.js/TypeScript**: Scripts, CLI, website, ESLint plugin (`yarn`)
- **Java**: Custom OpenAPI generators in `generators/`, rebuilt automatically (cached) by `yarn cli generate` / `yarn cli cts generate`
- **Docker**: Language toolchains run in Docker images (see [Docker Required](#docker-required))

### Language Version Files

In `config/`: `.java-version`, `.python-version`, `.ruby-version`, `.go-version`, `.swift-version`, `.php-version`, `.dart-version`, `.csharp-version`. Node.js: root `.nvmrc` (read by `nvm use`).

## COMMANDS

Every `yarn cli` command is documented in `website/docs/CLI/` (where it is written `apic`).

```bash
# Setup
nvm use && yarn                     # Install dependencies (Node.js version from root .nvmrc)
yarn docker:setup                   # Setup Docker environment

# Generation
yarn cli generate javascript        # Generate all JS clients
yarn cli generate python search     # Generate Python search client
yarn cli build specs                # Bundle OpenAPI specs (more variants in specs/AGENTS.md)

# Testing
yarn cli cts generate [lang] [client...]  # Generate CTS tests from tests/CTS/ (all languages/clients if omitted)
yarn cli cts run [lang] [client...]       # Run the CTS; requires built clients (yarn cli build clients {lang})
yarn scripts:test                         # Type-check and vitest for scripts/
yarn cli playground {lang} {client}       # Run interactive playground

# Formatting
yarn cli format {language} {folder}

# Release (see website/docs/release-process.md)
yarn cli release                    # Create release PR
yarn cli release --dry-run          # Test release without pushing
```

### Which tests for which change

| Change                        | Run                                                                                           |
| ----------------------------- | --------------------------------------------------------------------------------------------- |
| `specs/`                      | `yarn cli generate {lang}`, then `yarn cli cts generate {lang}` and `yarn cli cts run {lang}` |
| `templates/` or `generators/` | Same as specs, for each affected language                                                     |
| `tests/CTS/` test definitions | `yarn cli cts generate {lang}` and `yarn cli cts run {lang}`                                  |
| `scripts/`                    | `yarn scripts:test`                                                                           |

`yarn cli cts run` also accepts `--no-e2e` (skip e2e tests that need internet), `--no-client`, `--no-requests`, `--benchmark`.

## REVIEW & PR POLICY

- **PR title** (enforced by `.github/workflows/pr-title.yml`): `type(scope): description`, or any title starting with `docs`, `chore`, `snippets` or `guides`.
  - Types: `feat`, `fix`, `docs`, `style`, `refactor`, `perf`, `test`, `build`, `ci`, `chore`, `revert`
  - Scopes: `clients`, `generators`, `playground`, `csharp`, `dart`, `go`, `java`, `javascript`, `kotlin`, `php`, `python`, `ruby`, `scala`, `swift`, `cts`, `specs`, `scripts`, `ci`, `templates`, `deps`
- **PR description**: fill `.github/PULL_REQUEST_TEMPLATE.md` — "What and Why" (with the JIRA ticket), "Changes included", "Test".
- **Code owners**: [`CODEOWNERS`](CODEOWNERS) is last-match-wins; `*` → `@algolia/api-clients-automation` comes after the `specs/`/`website/` rules, so only `specs/composition` (`@algolia/composition`) and `tests/CTS/**/composition` (both teams) differ. Releases need approval from `@algolia/api-clients-automation`.
- **Pre-commit hook** (`.husky/pre-commit`): `scripts/husky/pre-commit.mjs` unstages generated files (`config/generation.config.mjs` patterns plus generated `tests/output/` folders) and `yarn.lock` when JavaScript snippets/guides are staged (skipped during a merge or when `CI` is set); then `yarn lint-staged` (`.lintstagedrc.mjs`) formats staged Java generators and scripts and runs `eslint --fix` on staged workflow YAML, JSON and spec YAML. Never bypass it.
- **Review skill**: `.agents/skills/api-clients-review/SKILL.md` — reviews a PR against a six-rule checklist (tests, dead surface, template output, config mutation, docs, cross-language consistency) plus a general pass.
- No branch naming rule.

## GLOSSARY

- **CTS (Common Test Suite)**: tests generated for every language from JSON files in `tests/CTS/` into `tests/output/{lang}/`; they check that clients send the correct requests and throw the correct errors, not the engine.
- **Playground**: per-language project in `playground/{lang}/` to try generated clients by hand (`yarn cli playground {lang} {client}`).
- **Bundled specs**: single-file specs in `specs/bundled/`, produced from `specs/{api}/` by `yarn cli build specs` and used for generation; never edit.
- **Generated vs hand-written**: generated files are overwritten by `yarn cli generate`; hand-written ones are the `!` patterns in `config/generation.config.mjs` (see [CONVENTIONS](#generated-vs-hand-written)).
- **`apic`**: the CLI name used in `website/docs/`; `yarn cli` is a drop-in replacement.

## DOCS INDEX

- [Introduction](website/docs/introduction.md) — start here: map of the contributor docs.
- [Setup repository](website/docs/setup-repository.md) — first-time tooling, Docker images, troubleshooting.
- [Commit and pull request](website/docs/commit-and-pull-request.md) — pre-commit unstaging and PR title rules.
- [Release process](website/docs/release-process.md) — before running or reviewing a release.
- [Add a new language](website/docs/add-a-new-language.md) — requirements for a new language client (transport, retry, user agent).
- [Custom helpers](website/docs/custom-helpers.md) — before adding or changing a hand-written client helper.
- [Generating guides](website/docs/generating-guides.md) — when adding guide templates or push config.
- [Common Test Suite](website/docs/testing/common-test-suite.md) — when adding CTS tests or CTS templates.
- [Playground](website/docs/testing/playground.md) — when running or adding a playground.
- CLI reference: [build](website/docs/CLI/build-commands.md), [generate](website/docs/CLI/generate-commands.md), [cts](website/docs/CLI/cts-commands.md), [release](website/docs/CLI/release-commands.md) — for command options.
- [CI overview](website/docs/CI/overview.md) — when debugging which CI jobs run.
- Add a new API: [write a specification](website/docs/add-a-new-api/write-a-specification.md), [documentation guidelines](website/docs/add-a-new-api/api-documentation-guidelines.md), [generate your client](website/docs/add-a-new-api/generate-your-client.md) — when adding or editing specs.
- [`docs/README.md`](docs/README.md) — what the generated snippets and guides are.
- Area guides: the `AGENTS.md` linked from each [STRUCTURE](#structure) entry; per-language conventions in `clients/algoliasearch-client-{lang}/AGENTS.md`.
- [`CODEOWNERS`](CODEOWNERS), [PR template](.github/PULL_REQUEST_TEMPLATE.md), [check.yml](.github/workflows/check.yml) (main CI), [pr-title.yml](.github/workflows/pr-title.yml) — review and CI rules.
- [CONTRIBUTING.md](CONTRIBUTING.md) — commit conventions and requirements for external contributors.
- Skills: [api-clients-review](.agents/skills/api-clients-review/SKILL.md) (PR review), [renovate](.agents/skills/renovate/SKILL.md) (dependency PRs on `chore/renovateBaseBranch`), [merge-renovate-prs](.agents/skills/merge-renovate-prs/SKILL.md) (retry and merge failed Renovate PRs).

## NOTES

### API Documentation Guidelines

When writing or editing API specs, follow `website/docs/add-a-new-api/api-documentation-guidelines.md`.

### Never Remove Spec Fields

Removing a field from a published spec is a breaking change (breaks the user/API contract), even if the API ignores it — mark it `deprecated: true` (or explain in `description`) instead; genuine breaking changes must be called out as `BREAKING CHANGE` entries in the affected client changelogs.

### Backfilling a Missed GitHub Release

`scripts/ci/codegen/createGitHubReleases.ts` only runs when HEAD's commit message starts with `chore: release` (the CI gate), so it silently skips on a `main` that has moved past the release commit. To backfill a missed release, run it from a temporary git worktree checked out at the release commit (with `GITHUB_TOKEN` and `RUNNER_TEMP` set).

### Failed Release

The `notify failures` step in `.github/workflows/check.yml` posts ":alert: Some clients failed during release" to the internal release-alerts Slack channel, listing the failed languages; for each failed language, check the release CI on the public repo `algolia/algoliasearch-client-{language}` and report findings to the operator. **NEVER** re-release or re-trigger without the operator's explicit approval. Normal flow: `website/docs/release-process.md`.

### Docker Required

Most language builds require Docker. Run `yarn docker:setup` first. Images: `apic_base` (most languages), `apic_ruby`, `apic_swift`.

### CI Matrix

CI only runs the jobs and languages affected by the diff; see [CI overview](website/docs/CI/overview.md) and `.github/workflows/check.yml`.
