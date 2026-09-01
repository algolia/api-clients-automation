# 429 Retry-After: CTS foundation + JavaScript

- **Ticket:** [API-545](https://algolia.atlassian.net/browse/API-545)
- **Kind:** feature
- **Languages:** javascript
- **Status:** done

## Goal

When Search (and any JS client on `client-common`) receives HTTP 429, wait on the **same host** and retry: honor `Retry-After` as a positive whole number of seconds, otherwise wait 1s; `maxRateLimitRetries` defaults to 3 (`0` fails on the first 429); do not mark the host down or fail over; keep today’s 5xx/timeout/network retries. Prove it with a shared CTS mock and JS-only client cases (other languages skip until sibling tickets). Ship a JSDoc note on the option. Live e2e and docs-new customize copy wait until a staging rate limit / docs-new edit exists.

## BREAKING:

None (API surface). Behavioral: 429 no longer fails on the first response by default — it waits and retries up to three times. Fail-fast is `maxRateLimitRetries: 0`.

## Directives

- Put logic in hand-written JS transporter (`client-common`), not generated clients.
- Intercept 429 **before** the 4xx-is-not-retryable path.
- Strict `Retry-After` parse: positive integer string only; HTTP-date / `0` / missing / garbage → 1000ms.
- CTS tests `skipLanguages` every language except `javascript`.
- HTML 429 ingestion test: JS must pass `maxRateLimitRetries: 0` so it stays a parse test, not a 3s wait.
- SSE `requestStream` has no retry loop today — leave it.
- Non-blocking wait (`setTimeout` / Promise).

## Tasks

### T1 — JS transporter 429 wait/retry

- **files:** `clients/algoliasearch-client-javascript/packages/client-common/src/types/transporter.ts`, `clients/algoliasearch-client-javascript/packages/client-common/src/transporter/responses.ts`, `clients/algoliasearch-client-javascript/packages/client-common/src/transporter/createTransporter.ts`, `clients/algoliasearch-client-javascript/packages/client-common/src/__tests__/transporter/rateLimit.test.ts`
- **depends:** none
- **verify:** `yarn test` in `clients/algoliasearch-client-javascript/packages/client-common`
- **status:** done
- **notes:** `yarn test` in client-common: 20 files, 146 tests passed (fake timers; `rateLimit.test.ts` added to node project in `vitest.config.ts`). 429 is handled before `isRetryable`; wait via `setTimeout`; same host is re-queued. Exhausted-retry assertion attaches `.rejects` before advancing timers to avoid unhandled rejection.

### T2 — CTS mock server

- **files:** `scripts/cts/testServer/rateLimit.ts`, `scripts/cts/testServer/index.ts`, `scripts/cts/runCts.ts`
- **depends:** none
- **verify:** `npx tsc --noEmit -p scripts` if available, else `yarn cli cts run javascript` after T4
- **status:** done
- **notes:** ports 6697 (429 then success / exhausted / missing header / zero-retries) and 6698 (never-called). End-of-run assertion only when javascript ran.

### T3 — CTS plumbing for `maxRateLimitRetries`

- **files:** `generators/src/main/java/com/algolia/codegen/cts/tests/TestsClient.java`, `templates/javascript/tests/client/createClient.mustache`
- **depends:** none
- **verify:** `yarn cli cts generate javascript` succeeds after T4
- **status:** done
- **notes:** `CI=1 yarn cli cts generate javascript` succeeded (host Gradle, no Docker).

### T4 — Shared CTS cases

- **files:** `tests/CTS/client/search/api.json`, `tests/CTS/client/ingestion/api.json`
- **depends:** T2, T3
- **verify:** `yarn cli cts generate javascript`
- **status:** done
- **notes:** four JS-only search cases (Retry-After, missing header, exhausted, `maxRateLimitRetries: 0`) plus JS HTML-error variant with `maxRateLimitRetries: 0`. Other languages skip until sibling tickets.

### T5 — Generate and run JS CTS

- **files:** generated `tests/output/javascript/**` (side-effect)
- **depends:** T1, T4
- **verify:** `CI=1 yarn cli cts generate javascript && CI=1 yarn cli cts run javascript --no-e2e`
- **status:** done
- **notes:** `CI=1 yarn cli cts run javascript --no-e2e`: 27 files, 1123 tests passed. Isolated 429 cases: Retry-After 1020ms, missing header 1004ms, exhausted 3010ms, fail-fast 2ms, HTML with retries disabled 17ms. e2e skipped (needs live keys).

### T6 — JSDoc + website retry note

- **files:** `clients/algoliasearch-client-javascript/packages/client-common/src/types/transporter.ts`, `website/docs/add-a-new-language.md`
- **depends:** T1
- **verify:** `yarn cli format javascript clients/algoliasearch-client-javascript/packages/client-common`
- **status:** done
- **notes:** docs-new customize page deferred (not this repo). Live e2e deferred (no staging rate limit). SSE `requestStream` has no retry loop — left unchanged.

## Ledger

- 2026-09-01: plan written
- 2026-09-01: T1–T4 and T6 implemented; client-common unit tests passed; CTS generate succeeded; CTS run still pending (needs built JS packages)
- 2026-09-01: T5 done. `CI=1 yarn cli cts run javascript --no-e2e` passed (1123 tests). Draft PR blocked by GitHub SAML SSO on ManagePullRequest.
- 2026-09-01: included `rateLimit.test.ts` in client-common vitest node project; exhausted-retry test no longer leaks an unhandled ApiError
