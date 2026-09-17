# WebMCP search and filter tools (JS browser client)

- **Ticket:** none
- **Kind:** feature
- **Languages:** javascript (browser builds of `algoliasearch`, `algoliasearch/lite`, `client-search`)
- **Status:** planning
- **Research:** `.agents/research/webmcp-js-browser-client.md`

## Goal

Let a browser page opt in, from `algoliasearch()` / `liteClient()` init, to register WebMCP tools (`algolia_search`, `algolia_filter`, optional `algolia_facets`) on `document.modelContext`. Default is off. Missing WebMCP is a silent no-op. Tools call existing search methods with a narrow schema, capped/truncated output, and an index allow-list. No other languages, no write tools, no InstantSearch UI sync.

## BREAKING:

None. Additive optional `webmcp` init key. Must be stripped before options are spread into the transporter so unknown-option spreading cannot leak it.

## Directives

- Source of truth is hand-written `packages/client-common` plus browser Mustache templates. Do not edit generated `packages/*/src` or `packages/*/builds` except by regenerating.
- Browser builds only. Node / worker / fetch stay unaware.
- Opt-in, default off. `webmcp: true` enables `search` + `filter`.
- Feature-detect `document.modelContext?.registerTool`. Never throw from init when the API is missing.
- Narrow tool schemas, not full `SearchParamsObject`. Validate index allow-list and required filter args in code.
- Annotate tools `readOnlyHint: true`, `untrustedContentHint: true`, `consequentialHint: false`.
- Truncate execute output (~1.5K chars). Strip `_highlightResult` / `_snippetResult` / `_rankingInfo`.
- Tag tool queries with `analyticsTags: ['webmcp']` (merge with caller tags).
- No MCP-B / polyfill dependency. Local types for `ModelContext`.
- JS Vitest only; do not add CTS JSON.

## Assumptions

- (assume) Init-only enable/disable; no `client.enableWebMCP()` in v1.
- (assume) Stateless tools (each call carries query/filters). No last-query session state.
- (assume) InstantSearch UI coupling is a follow-up in that repo; optional `onExecute` callback is deferred unless needed for tests.
- (assume) Lite + full search browser clients; not other API clients.
- (defer) Forwarding `execute` abort `signal` into XHR (`requester-browser-xhr` has no AbortSignal today).

## Tasks

### T1 — WebMCP types and registrar in client-common
- **files:** `clients/algoliasearch-client-javascript/packages/client-common/src/types/webmcp.ts`, `clients/algoliasearch-client-javascript/packages/client-common/src/webmcp/registerAlgoliaWebMCPTools.ts`, `clients/algoliasearch-client-javascript/packages/client-common/src/webmcp/summarizeSearchResult.ts`, `clients/algoliasearch-client-javascript/packages/client-common/src/types/createClient.ts`, `clients/algoliasearch-client-javascript/packages/client-common/src/types/index.ts`, `clients/algoliasearch-client-javascript/packages/client-common/src/index.ts`
- **depends:** none
- **verify:** `cd clients/algoliasearch-client-javascript && yarn exec tsc --noEmit -p packages/client-common` (or the package’s existing typecheck script if present)
- **status:** pending
- **notes:** Export `WebMCPOptions` and add `webmcp?: boolean | WebMCPOptions` on `ClientOptions`. `registerAlgoliaWebMCPTools(client, options)` uses a shared `AbortController`, registers enabled tools, returns `{ abort: () => void }`. Guard `typeof document === 'undefined'`. Client duck-type: `{ searchSingleIndex?: Function, search?: Function }`.

### T2 — Unit tests for registrar and summarizer
- **files:** `clients/algoliasearch-client-javascript/packages/client-common/src/__tests__/webmcp/registerAlgoliaWebMCPTools.test.ts`, `clients/algoliasearch-client-javascript/packages/client-common/src/__tests__/webmcp/summarizeSearchResult.test.ts`
- **depends:** T1
- **verify:** `cd clients/algoliasearch-client-javascript && yarn vitest run packages/client-common/src/__tests__/webmcp`
- **status:** pending
- **notes:** Mock `document.modelContext`. Cover default-off, missing API, tool subset, index allow-list errors, truncation, highlight stripping, `webmcp: true` registers search+filter only.

### T3 — Hook browser factories (template)
- **files:** `templates/javascript/clients/client/builds/browser.mustache`, `templates/javascript/clients/client/builds/definition.mustache` (only if needed for imports/types)
- **depends:** T1
- **verify:** `yarn cli generate javascript search && yarn cli generate javascript algoliasearch`
- **status:** pending
- **notes:** Import registrar from `@algolia/client-common`. Destructure `webmcp` next to `compression`. After `create*Client`, if `isSearchClient` or lite, call registrar. Other API clients: still strip `webmcp` so it cannot hit the transporter, but do not register tools. Keep node/fetch/worker templates unchanged.

### T4 — algoliasearch composite browser init
- **files:** `templates/javascript/clients/algoliasearch/builds/definition.mustache`
- **depends:** T3
- **verify:** `yarn cli generate javascript algoliasearch`
- **status:** pending
- **notes:** `algoliasearch()` already forwards `options` into `searchClient()`. If T3 registers from `searchClient` browser factory, this task is a type/doc pass only (`ClientOptions` already carries `webmcp`). Confirm lite browser build is covered by T3’s lite `browser.mustache`. Do not double-register if both wrappers would call the helper.

### T5 — Browser client tests
- **files:** `clients/algoliasearch-client-javascript/packages/algoliasearch/__tests__/algoliasearch.browser.test.ts` (and lite equivalent if one exists; otherwise add a lite browser test next to lite builds)
- **depends:** T3, T4
- **verify:** `cd clients/algoliasearch-client-javascript && yarn vitest run packages/algoliasearch/__tests__/algoliasearch.browser.test.ts`
- **status:** pending
- **notes:** After generate, assert `algoliasearch(appId, apiKey, { webmcp: true })` with a mocked `document.modelContext` registers tools, and default init does not.

### T6 — Format
- **files:** files from T1–T5
- **depends:** T5
- **verify:** `yarn cli format javascript clients/algoliasearch-client-javascript`
- **status:** pending
- **notes:** Required before commit of implementation.

## Ledger

- 2026-09-17: plan written; implementation not started (research-and-plan request)
