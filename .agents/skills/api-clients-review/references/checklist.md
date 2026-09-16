# Review checklist

Stay strictly within these six rules during the checklist pass.

## Rule 1 — Test correctness

Tests must actually exercise the behavior they claim to assert. This applies inside the Common Test Suite (CTS) **and** outside it.

CTS-specific (must run deterministically across every supported language with no manual setup). Flag any test added or modified within the CTS that:

- Requires manual setup — running a local server, seeding a database, copying a fixture by hand, or any step a human has to perform before CI can run.
- Depends on a real network call, a live API key, or any external state that isn't part of the CTS harness.
- Hardcodes credentials, environment-specific URLs, machine-local paths, timestamps, or non-deterministic values (`Date.now()`, `Math.random()`, etc.).
- Is intentionally skipped, gated behind a `manual`/`local` flag, or otherwise unable to run unattended in CI.

General test correctness (CTS or not). Flag any test where:

- Pass criteria are asymmetric — the assertion only fires under specific conditions, so the test passes vacuously if those conditions don't hold (e.g., `if (ex is X) { Assert.X(...) }` with no fallback for the no-exception or wrong-exception cases).
- Exceptions are caught and swallowed without re-asserting — the test passes if no exception is thrown OR if the wrong exception is thrown.
- Mocks or fixtures no longer match the code path, so the assertion runs against stale data and would pass even if the production code were broken.

## Rule 2 — No dead or obsolete surface area

Flag any newly added public method, exported function, class, type, or API endpoint that is not invoked by tests, snippets, or other production code in the same PR. New public surface must have a real caller and a non-trivial implementation. Specifically flag:

- Methods whose body is empty, returns a constant placeholder, or throws "not implemented".
- New exports that no other file imports.
- API endpoints that are declared but unrouted, or routed but never called.
- Parameters that are accepted but never read.
- Newly added methods or exports that carry a deprecation annotation — if no pre-existing callers exist in the codebase, there is nothing to migrate; flag as dead surface added to immediately retire.
- Public methods that accept an object or nil at a boundary but would crash with an unguided internal error (NoMethodError, NullPointerException, AttributeError, etc.) on nil rather than raising a clean error at the call site. Use search to check whether nil is guarded before it reaches internal code.
- Public APIs that silently coerce unvalidated input (e.g., unknown hash keys silently dropped, unexpected types silently cast) where a caller mistake would be invisible at the call site.
- Newly added wrapper types (classes/structs named `Options`, `Config`, `Settings`, etc.) that are only ever used as a property of exactly one other type — search to confirm there is only one consumer. If so, flag: the fields should either be flattened into the containing type (preferred when the language has object-initializer or named-argument support) or the wrapper renamed to include the containing type's name in its own name (e.g. `TransformationOptions` not `ClientOptions`), so the scope is unambiguous. A generic name on a single-use wrapper type misleads callers and clashes with similarly named primitives in other languages.

Additionally, flag breaking changes to existing public API:

- **Dart named parameters**: adding a new optional named parameter to an existing method is NOT a breaking change (callers use names, not positions). However, **removing** an existing named parameter IS a breaking change even if it was dead/unused — existing callers who pass it by name will get a compile error. The correct approach is to deprecate it first (`@Deprecated`), not remove it outright. Flag any removal of a named parameter from an existing public method.
- **Parameter ordering**: new parameters must be added after all pre-existing parameters. Inserting a new parameter before an existing one displaces it and is a style violation — flag it. Check the surrounding methods in the same file to learn the project's ordering convention (e.g. in this repo's Dart helpers, `requestOptions` is always last).
- **Type widening to nullable**: changing a public field or property from a non-nullable type to its nullable equivalent (e.g. `Duration` → `Duration?`, `String` → `String?`, `int` → `int?`, `T` → `T?`) is a breaking change in any language with null-safety (Dart, Swift, Kotlin). Existing callers that assign the field to a non-nullable variable, or call methods directly on it without a null check, will get a compile error. Flag any such change and verify it is intentional — if it is, the PR description must explain why and what callers need to update.

Additionally, flag obsolete API still in use:

- Methods marked `[Obsolete]` / `@Deprecated` / `@deprecated` that are still called by code in the same PR — including generated CTS, snippets, and examples. The deprecation isn't complete until callers migrate.
- Public surface removed (or renamed) in this PR but still referenced by code that wasn't updated.
- Deprecated methods whose body was changed from the pre-existing implementation. A deprecation shim must preserve the original behavior exactly — it exists so that existing callers are not silently broken while they migrate. Flag any deprecated wrapper that: (a) changes observable behavior compared to the pre-PR implementation (different defaults, different side effects, forwarded arguments now ignored), or (b) silently drops parameters that had real effects in the old code (e.g., a logger factory that previously controlled logging now being ignored). The `@deprecated` / `[Obsolete]` message may document the difference, but that doesn't make the silent regression acceptable — the old code path should be preserved in the shim body. The one permitted improvement: a dropped parameter may fall back to a reasonable stored default rather than null (e.g. `factory ?? _loggerFactory`) as long as the net behavior for callers who did pass a value is unchanged.

Use search to confirm zero callers (for new-but-unused) or to find the callers (for obsolete-but-called) before flagging.

## Rule 3 — Template output correctness

For any change to a code-generation template (Mustache, Jinja, ERB, etc.), verify that the generated output would still compile. Specifically flag:

- Imports or `require`/`use` statements added to a template that have no corresponding usage of the imported symbol in the same template body — they will produce unused-import compile errors in every generated file.
- Imports or `require`/`use` statements that are not gated by the same conditional block (`{{#isSearchClient}}`, `{% if %}`, etc.) as the only code that uses them — they will produce unused-import errors in generated files where that condition is false.
- Symbol references in a template that were removed or renamed elsewhere in the same PR without updating the template — they will produce undefined-symbol errors in generated output.

Before flagging, search the template body for any usage of the imported symbol to confirm it is genuinely absent.

## Rule 4 — Config mutation correctness

For any code (template or hand-authored) that applies user-supplied overrides to a freshly constructed config or options object, verify that collection properties are merged rather than replaced. Specifically flag:

- Assignments of the form `config.Headers = userHeaders` (or equivalent in any language) where the constructor already populates that collection with required defaults (auth headers, user-agent, etc.) — the assignment silently wipes the defaults, so requests go out missing credentials or required metadata.
- The correct pattern is to iterate over the user-supplied entries and set them individually (`foreach (var kvp in userHeaders) config.Headers[kvp.Key] = kvp.Value`), so pre-initialized keys survive alongside the caller's additions.

Before flagging, check what the constructor puts into the collection (read the base class if needed) to confirm there are pre-initialized entries that would be lost.

## Rule 5 — Documentation quality

Documentation must match the surrounding language's style **and** accurately describe the code it documents. Flag deviations on either axis.

**Consistency** — read neighboring files in the same package/module first to learn the convention, then flag deviations. Do not impose an external standard — match what's already there.

- JavaScript/TypeScript — JSDoc with the tag set used elsewhere in the same module.
- Python — docstrings in the same flavor (Google, NumPy, or reST) as the surrounding module.
- Java/Kotlin — Javadoc/KDoc with the same tag set used by neighboring classes.
- Go — sentence-style comments starting with the identifier name, ending with a period.
- Ruby — YARD or RDoc consistent with the surrounding files.
- C#/Swift/PHP/Dart/Scala — match neighboring files. For C# specifically: every public member documented elsewhere with `<summary>` should have one; methods with `<param>` tags on their neighbors should document each parameter.

**Correctness** — the doc text must agree with the code it describes. Flag:

- Wrong subject — doc refers to "the parent X" when the symbol IS X (copy-paste artifact from another file).
- Stale references — `<see>`, `@see`, `@link` pointing to renamed or removed symbols.
- Parameter docs that don't match the actual parameter list (missing, extra, or wrong-named).
- Return-value docs that don't match the actual return type.

Flag missing docs only on **public** API surface where the surrounding code documents its public surface.

## Rule 6 — Cross-language consistency

When a PR adds or changes a feature in one language, find the same feature in the other languages (Python, Java, JavaScript, Scala, Go, Ruby, PHP, C#, Kotlin, Swift, Dart) and compare. Search for equivalent files or templates. This rule is **the most important one** — a divergence that looks innocuous in isolation can be a silent breaking change or an API that callers from other SDKs won't recognise.

**How to check**: search for the feature name (method, class, config key) in other language client directories and helper templates. Read the corresponding implementation before judging.

Flag any divergence in the following categories:

- **Breaking change** — the new implementation removes, renames, or changes the signature of something that exists in other languages (e.g. a required parameter becomes optional, a method is split, a config key changes name). Even if the change is unintentional, callers porting code from another SDK will be silently surprised.
- **Design choice** — the new implementation makes a structural decision that differs from the established pattern without a language-idiomatic reason. Examples: storing configuration on the config object vs. on the client; using a factory method vs. a constructor; using an optional parameter vs. a named options object. If other languages converged on a design, the new language should match unless the language's idioms actively prevent it.
- **Idiomatic choice** — flag the *opposite* too: when the PR copies a pattern verbatim from another language but the target language has a strongly preferred idiom (e.g., using a class where the language would use a struct, ignoring nil-safety conventions, not using named parameters where the language requires them). The implementation should feel native, not like a translation.
- **Correctness gap** — the new implementation is missing behaviour that all other languages implement (e.g., error handling for an edge case, a retry path, a header that other clients set, a fallback that other SDKs document). Check error messages: if every other language raises with the same string, the new one should too so that callers can detect errors uniformly.
- **Completeness gap** — the new implementation adds only a subset of the methods or configuration options that other languages expose for this feature. Flag any method or option present in two or more other languages that is absent here without an explicit reason.

Do **not** flag differences that are explained by the target language's type system or standard library constraints (e.g., Dart needing `async`/`await` where Java uses sync APIs, Go returning errors by value). Do flag differences that have no language-idiomatic explanation.
