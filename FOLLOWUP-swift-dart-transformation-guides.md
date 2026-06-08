# Merge sequencing: Swift & Dart transformationOptions guides

This changeset documents the `transformationOptions` pattern for **all 11 languages**
(docs ticket "Update transformation documentation with generated snippets", API-369..379).

The Swift and Dart guide templates are included:

- `templates/swift/guides/search/setUpTransformationOptions.mustache`
- `templates/swift/guides/search/setUpTransformationOptionsWithOverrides.mustache`
- `templates/dart/guides/search/setUpTransformationOptions.mustache`
- `templates/dart/guides/search/setUpTransformationOptionsWithOverrides.mustache`

They are verified against the implementation branches `origin/feat/swift-transformation-options`
and `origin/feat/dart-transformation-options`.

## ⚠️ Merge ordering (required)

The Swift and Dart `transformationOptions` implementations are NOT yet on `main`
(they live in the two branches above — the ticket's "Blocked by API-369..379" dependency).

Until those implementation PRs merge:
- The Swift/Dart clients on `main` don't expose `TransformationOptions`.
- `saveObjectsWithTransformation` is not in their `x-available-languages` on `main`.

So **this PR must merge after** `feat/swift-transformation-options` and
`feat/dart-transformation-options` land. Merging it to `main` before then will fail
guide generation/build for Swift and Dart in CI.

Recommended: rebase/merge this docs PR once both implementation PRs are in, or fold the
four Swift/Dart template files into those implementation PRs so each ships with the API
it documents. The other 9 languages and all prose are unaffected and can merge any time.

## Notes on the ticket's per-language examples (real API differs)

- **Dart**: `transformationOptions` is a `SearchClient(...)` constructor parameter, not a field of `ClientOptions`. The ticket's `options: ClientOptions(transformationOptions: ...)` is inaccurate.
- **Swift**: region is an enum case (`.us`), passed to `SearchClientConfiguration(transformationOptions:)`; the client is built with `SearchClient(configuration:)`.
- **C#**: the real API is `SearchClient.WithTransformation(...)`, not `new SearchConfig(...) { TransformationOptions = ... }`.
- Swift and Dart have no deprecated old API to migrate from (transformationOptions is their first/only transformation config).
