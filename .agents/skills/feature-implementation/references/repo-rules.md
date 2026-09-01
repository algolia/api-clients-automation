# Repo rules for implementers

Consult `AGENTS.md`, `specs/AGENTS.md`, `templates/AGENTS.md`, and `config/generation.config.mjs` rather than restating them. This page is the gotchas that those files do not make obvious in one place.

## Source of truth

Hand-written (safe to edit): paths in `config/generation.config.mjs` that **start with `!`**. Everything else under generated client folders is generated and will be overwritten.

Typical edit sites:

| Change | Edit here | Then verify with |
| --- | --- | --- |
| Endpoint, schema, ACL, docs text | `specs/<api>/paths/` or `specs/<api>/common/` | `yarn cli build specs` (never edit `specs/bundled/`) |
| Generated method/model shape | `templates/<lang>/` and/or `generators/src/main/java/com/algolia/codegen/` | `yarn cli generate <lang>` |
| Helper / transport / retry behavior | hand-written client files (negated globs) | language tests + CTS |
| Cross-language behavior | `tests/CTS/requests/` or `tests/CTS/client/` | `yarn cli cts generate [lang]` then `yarn cli cts run [lang]` |

CTS JSON must run unattended in CI: no live keys, no manual setup, no non-deterministic values.

## Parity

When kind is `parity` or the ticket names one language as the reference:

1. Read the reference implementation (and the spec) before writing the port.
2. Match method names, options, defaults, and error-detection behavior unless the target language's type system or idioms forbid it.
3. Prefer one CTS case that all languages run over N language-specific tests.
4. After the port, search the other language client folders for the same feature and confirm there is no leftover gap.

Languages: JavaScript, Python, Java, Go, Ruby, PHP, Kotlin, Scala, Swift, Dart, C#.

## Format, commit, PR title

- Format before commit: `yarn cli format {language} {folder}`.
- Commits: `type(scope): description` — see `CONTRIBUTING.md`.
- PR title must match `.github/workflows/pr-title.yml`. Allowed scopes include `clients`, `generators`, `csharp`, `dart`, `go`, `java`, `javascript`, `kotlin`, `php`, `python`, `ruby`, `scala`, `swift`, `cts`, `specs`, `scripts`, `ci`, `templates`, `deps`.
- Spec documentation follows `website/docs/add-a-new-api/api-documentation-guidelines.md`.
