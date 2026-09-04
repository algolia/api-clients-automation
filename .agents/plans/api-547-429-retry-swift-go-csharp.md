# 429 Retry-After: Swift, Go, C#

- **Ticket:** API-547
- **Kind:** parity
- **Languages:** swift, go, csharp
- **Status:** done
- **Reference:** https://github.com/algolia/api-clients-automation/pull/6965 (API-545 JavaScript)

## Goal

Port same-host HTTP 429 wait/retry from the JavaScript transporter into Swift, Go, and C#. Honor `Retry-After` as a positive whole number of seconds (otherwise wait 1s, no client max wait); keep the host up; cap waits with `maxRateLimitRetries` (default 3, `0` fails on the first 429). Opt these languages into the shared CTS mock on ports 6697/6698. 5xx / timeout / network host-failover stays unchanged.

## BREAKING:

Behavioral, not API-shape. Callers who currently get an immediate 429 now wait up to three times (1s each by default, or the full `Retry-After`) before the same error surfaces. `maxRateLimitRetries: 0` restores fail-on-first-429. No public method/parameter removals.

## Directives

- Change hand-written transport only (`generation.config.mjs` negated paths). Do not edit generated API clients except Swift configs produced from `templates/swift/client_configuration.mustache`.
- Intercept 429 **before** host-failover `Decide` / `notify` / `isRetryable`.
- Parse `Retry-After` case-insensitively; only `^\d+$` with value > 0 counts.
- Expose the option with local naming: Go `MaxRateLimitRetries *int` (nil = 3, so `0` can mean fail-fast), C# `MaxRateLimitRetries` default 3, Swift `maxRateLimitRetries` default 3.
- Opt into existing CTS via `onlyLanguages`; do not duplicate CTS JSON.
- Move Swift/Go/C# onto the `maxRateLimitRetries: 0` HTML-error clone so that test stays one request.
- Stream 429 retry only where a stream API already exists (Go `RequestStream`). Swift and C# have no equivalent.
- Docs-new customize samples and live e2e: deferred (no staging rate limit; samples live in another repo). Same as API-545.

## Ambiguity

- (assume) Language samples in docs-new are out of this repo — PR body usage snippets only.
- (assume) Go zero-value `int` cannot mean both “unset → 3” and “fail-fast → 0”; use `*int` like `RequestIDEnabled *bool`.
- (defer) Live e2e against a real/staging rate limit.

## Tasks

### T1 — Go transporter
- **files:** `clients/algoliasearch-client-go/algolia/transport/configuration.go`, `clients/algoliasearch-client-go/algolia/transport/transport.go`, `clients/algoliasearch-client-go/algolia/transport/rate_limit.go`, `clients/algoliasearch-client-go/algolia/transport/rate_limit_test.go`, `templates/go/tests/client/createClient.mustache`, `tests/output/go/tests/manual/rate_limit_retry_test.go`
- **depends:** none
- **verify:** `gofmt -w` + `go test ./algolia/transport/` in the Go client, plus the manual test package
- **status:** done
- **notes:** `gofmt` + `go test ./algolia/transport/` pass. Request and RequestStream wait on the same host; per-attempt timeout is cancelled before sleep.

### T2 — Swift transporter
- **files:** `clients/algoliasearch-client-swift/Sources/Core/Networking/Transporter.swift`, `clients/algoliasearch-client-swift/Sources/Core/Networking/BaseConfiguration.swift`, `clients/algoliasearch-client-swift/Sources/Core/Networking/HTTP/HTTPError.swift`, `clients/algoliasearch-client-swift/Sources/Core/Networking/RateLimitRetry.swift`, `templates/swift/client_configuration.mustache`, `templates/swift/tests/client/createClient.mustache`, `clients/algoliasearch-client-swift/Sources/Search/Extra/TransformationOptions.swift`, `clients/algoliasearch-client-swift/Sources/Search/Extra/SearchClientTransformationExtension.swift`, `tests/output/swift/Tests/manual/RateLimitRetryTests.swift`
- **depends:** none
- **verify:** `yarn cli generate swift` (or local openapi-generator) then `yarn cli cts generate swift`
- **status:** done
- **notes:** No Swift toolchain in this environment. Configs were patched to match `client_configuration.mustache`. Manual tests live in `tests/output/swift/Tests/manual/RateLimitRetryTests.swift`.

### T3 — C# transporter
- **files:** `clients/algoliasearch-client-csharp/algoliasearch/Clients/AlgoliaConfig.cs`, `clients/algoliasearch-client-csharp/algoliasearch/Transport/HttpTransport.cs`, `clients/algoliasearch-client-csharp/algoliasearch/Transport/RetryAfter.cs`, `templates/csharp/tests/client/createClient.mustache`, `tests/output/csharp/src/RateLimitRetryTests.cs`, `config/generation.config.mjs`
- **depends:** none
- **verify:** compile + `RateLimitRetryTests`
- **status:** done
- **notes:** `dotnet test --filter FullyQualifiedName~RateLimitRetryTests` pass (21 tests including CTS). Inner same-host loop intercepts 429 before `Decide`.

### T4 — Shared CTS opt-in
- **files:** `tests/CTS/client/search/api.json`, `tests/CTS/client/ingestion/api.json`, `scripts/cts/runCts.ts`, `scripts/cts/testServer/rateLimit.ts`, `website/docs/add-a-new-language.md`
- **depends:** T1, T2, T3
- **verify:** `CI=1 yarn cli cts generate go csharp swift` then client CTS against the rate-limit mock
- **status:** done
- **notes:** Go CTS against localhost:6697/6698 and HTML 6676: TestSearchapi13–16 and TestIngestionapi0 pass with expected waits (2s / 1s / 3s / 0s). C# CTS included in the 21 passing tests. Swift CTS generated into client tests; runtime deferred (no toolchain). Docs-new samples and live e2e remain deferred.

## Ledger

- 2026-09-04: plan written
- 2026-09-04: T1 Go transporter done
- 2026-09-04: T2 Swift transporter done (compile deferred)
- 2026-09-04: T3 C# transporter done
- 2026-09-04: T4 CTS opt-in done; draft PR next
