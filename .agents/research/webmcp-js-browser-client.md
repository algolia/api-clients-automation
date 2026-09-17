# WebMCP for the JavaScript browser client

**Date:** 2026-09-17
**Status:** research for planning (no implementation in this change)
**Scope:** `algoliasearch` / `liteClient` browser builds only

## What WebMCP is

WebMCP is a proposed browser API that lets a **page** register JavaScript functions as tools for in-browser agents (Gemini in Chrome, inspector extensions, later other browser agents). It is MCP-inspired, not an MCP server and not a replacement for Algolia’s backend MCP / Agent Studio. [[spec]](https://webmachinelearning.github.io/webmcp) [[chrome]](https://developer.chrome.com/docs/ai/webmcp) [[mcp-vs-webmcp]](https://developer.chrome.com/blog/webmcp-mcp-usage)

| | MCP (Agent Studio, Productivity MCP) | WebMCP |
| --- | --- | --- |
| Where it runs | Server / daemon, any client | Current browser tab |
| Lifecycle | Persistent | Ephemeral, document-scoped |
| Consumer today | Desktop/cloud agents | Chrome origin trial; Gemini in Chrome |
| Right layer | Admin / app-level tools | Site search the user already has open |

Chrome’s own framing: WebMCP is for **structured in-page actions** (`checkout`, `filter_results`) so agents stop scraping the DOM. [[chrome]](https://developer.chrome.com/docs/ai/webmcp)

## Current API (Chrome 149–156 origin trial)

Surface: `document.modelContext` (not `navigator.modelContext`, removed in Chromium 150). [[chrome-imperative]](https://developer.chrome.com/docs/ai/webmcp/imperative-api) [[chromium]](https://github.com/chromium/chromium/commit/4a9fee9eafcabd675c7245cc1b0acc1ca5f17d99)

```js
const modelContext = document.modelContext;
if (!modelContext?.registerTool) return;

const controller = new AbortController();
await modelContext.registerTool(
  {
    name: 'algolia_search',
    description: 'Search the product catalog.',
    inputSchema: { type: 'object', properties: { query: { type: 'string' } }, required: ['query'] },
    annotations: { readOnlyHint: true, untrustedContentHint: true, consequentialHint: false },
    execute: async ({ query }, { signal }) => {
      const res = await client.searchSingleIndex({ indexName: 'products', searchParams: { query } });
      return summarize(res);
    },
  },
  { signal: controller.signal },
);
// later: controller.abort() unregisters
```

Facts that constrain our design:

- **Opt-in at the browser**, gated by origin isolation + `tools` Permissions Policy (`self` by default). HTTPS only. [[chrome]](https://developer.chrome.com/docs/ai/webmcp)
- **No `unregisterTool()`**. Unregister by aborting the registration `AbortSignal`. [[chrome-imperative]](https://developer.chrome.com/docs/ai/webmcp/imperative-api)
- **`execute` second argument is `{ signal }`** for in-flight cancel. Forward it if we can; the XHR requester today does not take `AbortSignal` (`packages/requester-browser-xhr`).
- Tool **names**: 1–128 chars, ASCII alnum / `_` / `-` / `.`. Duplicate names reject. [[spec]](https://webmachinelearning.github.io/webmcp)
- Chrome output budget guidance: **~1.5K characters per tool result**, 500 per description, 150 per param description, 30 per name. [[secure-tools]](https://developer.chrome.com/docs/ai/webmcp/secure-tools)
- Native Chrome dictionary has **`inputSchema` only**. `outputSchema` exists in MCP-B (`@mcp-b/webmcp-types`), not in the W3C/Chrome tool dictionary. Do not depend on MCP-B or a polyfill for v1.
- Origin trial: Chrome **149–156**, intended ship **157**. Local flag: `chrome://flags/#enable-webmcp-testing`. [[chromestatus]](https://chromestatus.com/feature/5117755740913664)
- Feature-detect always. Missing API must be a silent no-op so Node, Firefox, Safari, and old Chrome keep working.

Declarative HTML annotations exist; they are the wrong fit for an API client. Use the **imperative** API.

## What already exists at Algolia

No Jira, Confluence, or repo code for WebMCP. Internal discussion is in Slack:

- **#ai-at-algolia** (2026-02-09): Raed flagged Chrome’s early preview. [[thread]](https://algolia-grid.enterprise.slack.com/archives/C08Q9K5NC74/p1770645524787639)
- **#proj-mcp** (2026-02-17): Benjamin: a site could expose search as an agent tool wrapping the public Algolia API. Emir: yes, but raw API access without a **middleware / allow-list** is the risk; WebMCP is an **explicit declaration** that the capability is for agents, not inferred from network traffic. Longer-term he wanted a **controlled, agent-aware interface**, not “replay whatever InstantSearch sends”. [[thread]](https://algolia-grid.enterprise.slack.com/archives/C08HT6VT1V2/p1771355724122739)
- **#help-website** (2026-03-06): Oscar’s `llms.txt` already documents algolia.com’s public search endpoint (query + `filters` + `facetFilters`) as the way LLMs should search site content. That is the same job, without a browser standard. [[thread]](https://algolia-grid.enterprise.slack.com/archives/C37JL45MY/p1772809621138479)

Agent Studio already has a **server-side** Algolia search tool (`AlgoliaSearchToolConfig` with per-index descriptions and `searchParameters`). WebMCP is the **in-tab** counterpart: same product idea, different runtime.

## Where it belongs in this repo

The JavaScript client is generated except for negated paths in `config/generation.config.mjs`. Safe places:

| Layer | Path | Role |
| --- | --- | --- |
| Types + registrar | `packages/client-common/**` (hand-written) | `WebMCPOptions`, `registerAlgoliaWebMCPTools()`, summarizer |
| Browser factory | `templates/javascript/clients/client/builds/browser.mustache` | Strip `webmcp` from transporter options, call registrar after `create*Client` |
| Composite client | `templates/javascript/clients/algoliasearch/builds/definition.mustache` | Same option on `algoliasearch()`, browser-only call |
| Tests | `packages/client-common/src/__tests__/` and `packages/algoliasearch/__tests__/` | Mock `document.modelContext` |

Do **not** put this in Node / worker / fetch builds. Do **not** enable it on ingestion, analytics, or other API clients. **Do** include the **lite** browser build: InstantSearch and most public sites use it.

`ClientOptions` is shared across environments. Follow the `compression` pattern: accept `webmcp` on the public init type, **destructure it out** before spreading into `createLiteClient` / `createSearchClient`.

```ts
const { compression: _compression, webmcp, ...browserOptions } = options || {};
const client = createLiteClient({ ...browserOptions, /* ... */ });
if (webmcp) {
  registerAlgoliaWebMCPTools(client, normalizeWebMCPOptions(webmcp));
}
return client;
```

## Recommended public API

Default **off**. Enabling is an explicit “this page offers search to agents” contract (Emir’s point).

```ts
import { algoliasearch } from 'algoliasearch';
// or: import { liteClient } from 'algoliasearch/lite';

const client = algoliasearch('APP_ID', 'SEARCH_ONLY_KEY', {
  webmcp: true,
  // or:
  webmcp: {
    indexName: 'products',
    allowedIndexNames: ['products', 'products_query_suggestions'],
    tools: { search: true, filter: true, facets: false },
    hitsPerPage: 5,
    attributesToRetrieve: ['objectID', 'name', 'url', 'brand', 'price'],
  },
});
```

### Options

```ts
type WebMCPToolName = 'search' | 'filter' | 'facets';

type WebMCPOptions = {
  /** Default true when the object form is passed. */
  enabled?: boolean;
  /** Default `{ search: true, filter: true, facets: false }`. */
  tools?: Partial<Record<WebMCPToolName, boolean>>;
  /** Default index. If omitted, tools require `indexName` on every call. */
  indexName?: string;
  /** If set, tool calls may only target these indices (default: `[indexName]` when that is set). */
  allowedIndexNames?: string[];
  /** Hard cap, default 5. Chrome’s ~1.5K output budget cannot fit a full SearchResponse. */
  hitsPerPage?: number;
  attributesToRetrieve?: string[];
  /** Extra analytics tags merged into every tool-initiated query. Default `['webmcp']`. */
  analyticsTags?: string[];
};

type ClientOptions = /* existing */ & {
  webmcp?: boolean | WebMCPOptions;
};
```

`webmcp: false` and omitting the key are equivalent. `webmcp: true` equals `{ enabled: true }` with default tools.

No `client.enableWebMCP()` in v1. Init-only matches the request and avoids a second public surface. Unregister happens automatically on document unload (spec cleanup). If we later need SPA teardown, add `client.disableWebMCP()` that aborts the shared `AbortController`.

## Tool strategy (non-overlapping)

Chrome: one job per tool, no overlap, short descriptions. [[best-practices]](https://developer.chrome.com/docs/ai/webmcp/best-practices)

Do **not** dump `SearchParamsObject` into the schema. That is the “raw API replay” Emir warned about. Expose a **narrow agent contract**.

### 1. `algolia_search`

Search an index. Filters are optional so a first query does not require a second tool.

```json
{
  "type": "object",
  "properties": {
    "query": { "type": "string", "description": "User search text. Empty string lists popular or filtered records." },
    "indexName": { "type": "string", "description": "Index to search. Omit when the client was created with a default index." },
    "filters": { "type": "string", "description": "Algolia filter expression, e.g. brand:Nike AND price < 100." },
    "page": { "type": "integer", "minimum": 0, "description": "0-based results page." }
  },
  "required": ["query"]
}
```

`execute` → `searchSingleIndex` (full client) or `searchForHits` / `search` (lite).

Annotations: `readOnlyHint: true`, `untrustedContentHint: true`, `consequentialHint: false`.

### 2. `algolia_filter`

Refine a catalog by filters. Required `filters` **or** `facetFilters`. Optional `query` (default `''`) so “show red shoes under $80” does not need a prior search.

```json
{
  "type": "object",
  "properties": {
    "query": { "type": "string", "description": "Optional text query to keep while applying filters." },
    "indexName": { "type": "string" },
    "filters": { "type": "string", "description": "Algolia filter expression combining facets, numeric, and tags." },
    "facetFilters": {
      "type": "array",
      "items": { "type": "string" },
      "description": "Facet constraints as 'attribute:value'. AND between items. For OR, pass a nested list in a later version."
    },
    "page": { "type": "integer", "minimum": 0 }
  }
}
```

Validate in code: reject if both `filters` and `facetFilters` are missing. Schema stays loose; errors tell the model how to retry. [[best-practices]](https://developer.chrome.com/docs/ai/webmcp/best-practices)

This is the Chrome `filter_results` idea, namespaced to Algolia.

### 3. `algolia_facets` (off by default)

`searchForFacetValues` / a `type: facet` request. Agents need this to know **which** filter values exist. Off by default to keep the tool list small; enable with `tools: { facets: true }`.

```json
{
  "type": "object",
  "properties": {
    "facetName": { "type": "string", "description": "Facet attribute, e.g. brand." },
    "facetQuery": { "type": "string", "description": "Optional prefix to narrow facet values." },
    "query": { "type": "string", "description": "Current search query so facet counts stay contextual." },
    "filters": { "type": "string" },
    "indexName": { "type": "string" }
  },
  "required": ["facetName"]
}
```

Do not add write tools, `customPost`, recommend, or insights in v1.

## Output shape

Chrome’s 1.5K guidance plus prompt-injection risk from index content:

1. Pick `attributesToRetrieve` (init option, or a tiny default: `objectID` plus common fields if the caller did not set it — better to **require** `attributesToRetrieve` when `webmcp` is enabled, or default to `['objectID']` and let the app opt into more).
2. Drop `_highlightResult`, `_snippetResult`, `_rankingInfo`, `renderingContent`, `extensions`.
3. Cap `hitsPerPage` (default 5, max 20 even if the agent asks higher).
4. Return a compact object, then `JSON.stringify`. If still over ~1500 chars, drop hits from the end and add `"truncated": true`.
5. Include `nbHits`, `page`, `nbPages`, `query`, `index` so the agent can paginate without guessing.

```ts
{
  index: 'products',
  query: 'red shoes',
  nbHits: 128,
  page: 0,
  nbPages: 26,
  hits: [{ objectID: '1', name: 'Trail Runner', brand: 'Nike', price: 90 }],
}
```

Errors: return a short string (`Index "foo" is not allowed. Use one of: products.`) rather than throwing, so the agent can self-correct.

## UI coupling (out of scope, called out)

These tools call the **API**. They do **not** move InstantSearch widgets. Chrome wants tools to update visible UI so the user trusts the agent. [[chrome]](https://developer.chrome.com/docs/ai/webmcp) [[best-practices]](https://developer.chrome.com/docs/ai/webmcp/best-practices)

That follow-up belongs in InstantSearch (helper / widgets register tools that call `helper.setQuery` / `toggleFacetRefinement`). The API client is still the right v1: InstantSearch already depends on lite, and sites without InstantSearch (custom UI, headless) get tools for free.

v1 is useful for:

- Agents answering “search this catalog” while the user is on the site
- algolia.com-style content search (Oscar’s llms.txt, but as a first-class tool)
- A foundation InstantSearch can wrap later (`webmcp: { onSearch(params) { helper.setState(...) } }` hook if we want a callback)

Optional v1.1: `webmcp.onExecute?: (tool, args, result) => void` so InstantSearch can sync UI without forking the registrar.

## Security

Follow Chrome tool security. [[secure-tools]](https://developer.chrome.com/docs/ai/webmcp/secure-tools)

- Search-only API keys only (already the browser norm). Never register tools that write.
- `allowedIndexNames` so an agent cannot probe other indices in the same app.
- Do not set `exposedTo` in v1 (same-origin only).
- `untrustedContentHint: true` because hits are index/UGC data (indirect prompt injection).
- `analyticsTags: ['webmcp']` and `{ segment: 'WebMCP' }` on `algoliaAgents` when a tool runs, so customers can see agent traffic.
- Feature-detect; never throw from init if `document.modelContext` is missing.
- Do not log API keys or raw hits in `logger`.
- Cross-origin iframes: parent must `allow="tools"`. We do not paper over that.

## Testing

CTS JSON is language-agnostic and the wrong place. Use Vitest with a fake `document.modelContext`:

- `webmcp` omitted / `false` → `registerTool` never called
- `webmcp: true` without the API → no throw
- `webmcp: true` with mock → registers `algolia_search` + `algolia_filter` only
- `tools: { search: true, filter: false, facets: true }` → exact set
- `allowedIndexNames` rejects other indices
- execute truncates payload and strips `_highlightResult`
- aborting the registration signal is how tests simulate disable

Manual: Chrome 149+ with `chrome://flags/#enable-webmcp-testing` and the [Model Context Tool Inspector](https://developer.chrome.com/docs/ai/webmcp) extension against the JS playground.

## Non-goals

- Polyfill / MCP-B runtime
- Node, worker, fetch, React Native
- Parity in other language clients (no `document.modelContext`)
- Declarative HTML tools
- Origin-trial token distribution (site owners register their origin)
- InstantSearch widget sync (follow-up repo)
- Exposing the full Search API as tools

## Sources

- [WebMCP spec (W3C WebML CG, 2026-09-02)](https://webmachinelearning.github.io/webmcp)
- [WebMCP API proposal](https://webmachinelearning.github.io/webmcp/docs/proposal.html)
- [Chrome WebMCP](https://developer.chrome.com/docs/ai/webmcp)
- [Imperative API](https://developer.chrome.com/docs/ai/webmcp/imperative-api)
- [Best practices](https://developer.chrome.com/docs/ai/webmcp/best-practices)
- [Tool security](https://developer.chrome.com/docs/ai/webmcp/secure-tools)
- [When to use WebMCP vs MCP](https://developer.chrome.com/blog/webmcp-mcp-usage)
- [Chrome Status 5117755740913664](https://chromestatus.com/feature/5117755740913664)
- Slack #proj-mcp 2026-02-17, #ai-at-algolia 2026-02-09, #help-website 2026-03-06
