# fix/requires-body — stop inventing `{}` on zero-body write operations

Branch: `fix/requires-body` (from `origin/main` 6461ab0ee1)
Plan owner: metator. Ledger owner during execution: centurio. Status markers: `[ ]` pending, `[>]` dispatched, `[x]` done+verified, `[~]` blocked.

## Goal

Operations whose OpenAPI spec declares **no** `requestBody` (e.g. `clearRules`, `clearSynonyms`, `clearObjects`, `restoreApiKey`, `stopABTest`, `enableTask`, `disableTask`, `publishAgent`, `computeRealtimeUser`, `triggerDockerSourceDiscover`) must be sent with **no body** by all 11 clients. Today Kotlin/Java/Scala/Dart/Swift/C# transports invent `{}` for every POST/PUT, which the live engine rejects with 400 on some of these routes. The CTS currently hides this because the generator only sets `assertNullBody` for GET/DELETE, so the POST clear* tests assert `{}` on purpose.

Execution order is locked (do not invert):

1. **Phase 1 — CTS contract.** Flip the CTS expectation, regenerate, run the requests suite on all 11 languages, record the pass/fail table. STOP. No client fixes.
2. **Phase 2 — Fix.** Architecture A. Fix every language that failed Phase 1 (hand-written transport + api template + regenerate).
3. **Phase 3 — Prove.** Regenerate CTS if templates changed, re-run all 11 requests suites, confirm `customPost` minimal still sends `{}`.

## Non-goals — Must NOT

- Must NOT add new `tests/CTS/requests/**/clear*.json` (they exist and already have no `request.body`).
- Must NOT change the *optional-requestBody-omitted* contract: `customPost`/`customPut` minimal, `browse` minimal, `searchSingleIndex` minimal, `searchSynonyms` minimal, `searchForFacetValues` minimal, `runTask`, `runTaskV1`, `searchRecommendRules` keep sending `{}` (the generator still injects `"{}"` when `ope.bodyParams.size() != 0` and the test omits the body — `TestsRequest.java` L171-173).
- Must NOT touch JS `data: body ? body : {}`, Go `postBody = "{}"`, PHP `is_array($body) && empty($body) → '{}'`, Ruby `object_to_http_body(nil) → "{}"`, Python `_data = {}`. They serve operations that HAVE a body schema.
- Must NOT use a method/operationId denylist (architecture C is rejected).
- Must NOT hand-edit `tests/output/**` generated files or generated client API files (`clients/**/api/**`, `Clients/*Client.cs`, `Sources/*/*Client.swift`, `lib/Api/*`, …). Regenerate.
- Must NOT expand to crawler (not in the 11-language client list; its spec has zero-body POSTs but no generated CTS requests here).
- Must NOT commit without `yarn cli format <lang> <folder>`; never bypass pre-commit hooks.

## Survey facts (verified on this checkout)

### Generator

- `generators/src/main/java/com/algolia/codegen/cts/tests/TestsRequest.java` L167-182: injects `"{}"` when `ope.bodyParams.size() != 0 && req.request.body == null`; sets `assertNullBody` only for `GET`/`DELETE`. Helpers (`x-helper`) are skipped by `!isHelper`, so `deleteObjects`/`partialUpdateObjects*` (zero-body helpers in `search.yml`) are unaffected.

### Zero-body write operations that have CTS request tests (all have `"method": "POST"|"PUT"` and no `request.body`, no `skipLanguages`)

| Client | operationIds |
| --- | --- |
| search | clearObjects, clearSynonyms, restoreApiKey, clearRules |
| abtesting, abtesting-v3 | stopABTest |
| advanced-personalization | computeRealtimeUser |
| agent-studio | publishAgent, unpublishAgent |
| ingestion | triggerDockerSourceDiscover (POST), enableTask, disableTask, enableTaskV1, disableTaskV1 (PUT) |

### Optional-body write tests that omit the body (generator injects `{}`; these guard the non-goal above)

`common/customPost[0]`, `common/customPut[0]`, `search/searchSingleIndex[0..1]`, `search/searchForFacetValues[0]`, `search/browse[0]`, `search/searchSynonyms[0]`, `ingestion/runTask[0]`, `ingestion/runTaskV1[0]`, `recommend/searchRecommendRules[0]`.

### How each test template asserts the "no body" case today (`{{^body}}` branch)

| Lang | template | `assertNullBody` true | `assertNullBody` false |
| --- | --- | --- | --- |
| kotlin | `templates/kotlin/tests/intercept.mustache` L17-22 | `assertNoBody(it.body)` → `assertIs<EmptyContent>` (`tests/output/kotlin/src/commonTest/kotlin/com/algolia/utils/Assert.kt` L56) | `assertEmptyBody` (`{}`) |
| java | `templates/java/tests/requests/requests.mustache` L60-67 | `assertNull(req.body)` | `assertEquals("{}", req.body)` |
| scala | `templates/scala/tests/requests/requests.mustache` L56-63 | `assert(res.body.isEmpty)` | `assert(res.body.contains("{}"))` |
| dart | `templates/dart/tests/requests/requests.mustache` L39-46 | `expect(request.body, null)` | `expect(request.body, {})` |
| swift | `templates/swift/tests/requests/requests.mustache` L38-49 | `XCTAssertNil(echoResponse.originalBodyData)` | `== "{}"` |
| csharp | `templates/csharp/tests/requests/requests.mustache` L55-62 | `Assert.Null(req.Body)` | `Assert.Equal("{}", req.Body)` |
| go | `templates/go/tests/requests/requests.mustache` L75-82 | `require.Nil(t, echo.Body)` | `require.Empty(t, echo.Body)` |
| javascript | `templates/javascript/tests/requests/requests.mustache` L24 | always `expect(req.data).toEqual(undefined)` when no body | same |
| python | `templates/python/tests/requests/requests.mustache` L38-42, L65-69 | `assert _req.data is None` | **no assertion** |
| ruby | `templates/ruby/tests/requests/requests.mustache` L32-34 | `assert(req.body.nil?)` | **no assertion** |
| php | `templates/php/tests/requests/requests.mustache` L36-41, L95-102 | `"body" => null` → `isset` false → **skipped** | `"body" => json_decode("")` = null → **skipped** |

### Where the `{}` is invented (hand-written transports; all are negated in `config/generation.config.mjs`)

| Lang | File | Lines | Logic |
| --- | --- | --- | --- |
| kotlin | `clients/algoliasearch-client-kotlin/client/src/commonMain/kotlin/com/algolia/client/transport/internal/KtorRequester.kt` | L192-196, L214-215, L263 | `requiresBody(POST||PUT) -> setBody(EmptyObject)` |
| java | `clients/algoliasearch-client-java/algoliasearch/src/main/java/com/algolia/internal/HttpRequester.java` | L125-134 | `body == null → requiresRequestBody ? emptyMap : ""` |
| scala | `clients/algoliasearch-client-scala/src/main/scala/algoliasearch/internal/HttpRequester.scala` | L77-85 | same as Java |
| dart | `clients/algoliasearch-client-dart/packages/client_core/lib/src/transport/retry_strategy.dart` | L214-218, L252-254 | `_requiresBody(post||put) ? {} : null` |
| swift | `clients/algoliasearch-client-swift/Sources/Core/Networking/Transporter.swift` | L78-82 | `body == nil, httpMethod != .delete → "{}"` |
| csharp | `clients/algoliasearch-client-csharp/algoliasearch/Transport/HttpTransport.cs` | L175-178 | `Body == null && (Post||Put) → "{}"` |

Languages that do not invent at transport level: JS (`templates/javascript/clients/api-single.mustache` L206-208 `data: x ? x : {}`), Go (`templates/go/api.mustache` L598-605), Python (`templates/python/api.mustache` L229-233), Ruby (`templates/ruby/api.mustache` L220), PHP (generated `$httpBody = isset($body) ? $body : []` + `ApiWrapper::createRequest` L387-389; zero-body ops pass `$httpBody = null` → Guzzle sends empty body).

### How generated methods pass an optional body today (Phase 2 targets)

| Lang | api template | Optional body today |
| --- | --- | --- |
| kotlin | `templates/kotlin/api.mustache` L213-215 `body = {{paramName}}` | null → reified `RequestConfig(...)` in `transport/RequestConfig.kt` L36-70 gives `body = null` → transport invents |
| java | `templates/java/api.mustache` L339, L365 `.setBody({{paramName}})` | null → transport invents |
| scala | `templates/scala/api.mustache` L250 `.withBody({{paramName}})` (Option) | None → transport invents |
| dart | `templates/dart/api.mustache` L222 | null → transport invents |
| swift | `templates/swift/api.mustache` L153 `data: body ?? AnyCodable()` | already substitutes at method level (see R3) |
| csharp | `templates/csharp/api.mustache` L427-429, L520-522 `requestOptions.Data = {{paramName}}` | null → transport invents |

### Echo helpers that must report "no body" correctly (hand-written, tracked, not matched by any positive pattern in `config/generation.config.mjs`)

- `tests/output/java/src/test/java/com/algolia/EchoInterceptor.java` L57-66 `processResponseBody`: returns `null` only when `copy.body() == null`; a 0-length `RequestBody` yields `""`.
- `tests/output/scala/src/test/scala/algoliasearch/EchoInterceptor.scala` L46-52: same shape (`None` only for null body).
- C# `tests/output/csharp/src/Utils/EchoHttpRequester.cs` L55-60: `Body = null` when `request.Body == null` → OK as is.
- Swift `clients/algoliasearch-client-swift/Sources/Core/Networking/RequestBuilder/EchoRequestBuilder.swift` L78 `originalBodyData: urlRequest.httpBody` → nil when no body → OK as is.
- Kotlin `tests/output/kotlin/src/commonTest/kotlin/com/algolia/utils/RunTest.kt` intercepts the `HttpRequestBuilder`; `EmptyContent` is what GET/DELETE already produce → OK as is.
- Dart `tests/output/dart/lib/src/run.dart` passes the `HttpRequest` straight through → OK as is.

### Hand-written test that pins the optional-body contract (must keep passing)

`tests/output/scala/src/test/scala/algoliasearch/manual/RequestBodyContentLengthTest.scala` L67-76 "bodyless POST sends a fixed-length empty JSON object" calls `customPost("1/test")` (optional body omitted) and asserts `{}` with `Content-Length: 2`. This is the **optional-body** case and stays valid.

### Tooling

- Generate CTS: `yarn cli cts generate [lang]` (builds the generator, writes `tests/output/<lang>/**`, formats).
- Run requests only: `yarn cli cts run <lang> --no-e2e --no-client` (`scripts/cli/index.ts` L199-201; `scripts/cts/runCts.ts` L44-165).
- Docker: `yarn docker:setup`; images `apic_base` (most), `apic_ruby`, `apic_swift`; JavaScript has no image and runs on host. `scripts/config.ts` L56-62 skips docker when `CI` is set.
- Regenerate a client after template change: `yarn cli generate <lang>`.
- Format: `yarn cli format <lang> <folder>`.

---

## Phase 1 — CTS contract (STOP after this phase)

### Wave 1 (parallel)

- [x] T1: Flip the generator flag. In `generators/src/main/java/com/algolia/codegen/cts/tests/TestsRequest.java` L176-181 replace the GET/DELETE-only condition with: `assertNullBody = true` when method is `GET` or `DELETE`, **or** when method is `POST`/`PUT`/`PATCH` **and** `ope.bodyParams.size() == 0`. Keep the `"{}"` injection at L171-173 unchanged (it runs first, so a test on an optional-body op still gets `body="{}"` and never enters the `{{^body}}` branch). Update the comment to state the rule: "no body param in the spec → the request must carry no JSON object at all". (files: `generators/src/main/java/com/algolia/codegen/cts/tests/TestsRequest.java`; verify: `./gradle/gradlew -p generators assemble` exits 0 (this is what `scripts/common.ts` L224 runs; it needs Java 21 on host or the `apic_base` container), then `yarn cli cts generate javascript search` exits 0 as a fast end-to-end smoke)

- [x] T2: Make the PHP requests template actually compare the recorded body bytes. In `templates/php/tests/requests/requests.mustache`:
  - Do **not** treat `"body" => null` as the empty-body signal: `json_decode` of some CTS strings returns `null` (broken quote escaping) and that used to skip via `isset`. Use a dedicated `"expectEmptyBody" => true` on `{{#assertNullBody}}`.
  - `assertRequests`: if `expectEmptyBody`, assert recorded body is `''` with message `"no body must be sent"`; else if `isset($request['body'])`, compare `json_encode` vs `(string) $recordedRequest->getBody()`.
  - L99-101 `{{^assertNullBody}}`: emit `"body" => json_decode("{}"),`.
  (files: `templates/php/tests/requests/requests.mustache`; verify: `yarn cli cts generate php` exits 0 and `rg -n "expectEmptyBody" tests/output/php/src/requests/SearchTest.php` matches)

- [x] T3: Update the CTS doc line for `assertNullBody`. `website/docs/testing/common-test-suite.md` L135: "true if the operation has no request body in the spec (all `GET`/`DELETE`, and `POST`/`PUT`/`PATCH` without `requestBody`); the test asserts that no JSON object is sent". (files: `website/docs/testing/common-test-suite.md`; verify: `rg -n "assertNullBody" website/docs/testing/common-test-suite.md` shows the new text)

### Wave 2 (depends: T1, T2)

- [x] T4: Regenerate the CTS for all 11 languages: `yarn cli cts generate` (no args). Spot-check the flip: `rg -n "assertNoBody" tests/output/kotlin/src/commonTest/kotlin/com/algolia/requests/SearchTest.kt` must match inside the `clearRules` test; `rg -n -B3 "assertNull\(req.body\)" tests/output/java/src/test/java/com/algolia/requests/SearchTest.java` must show `clearRules`/`clearObjects`/`clearSynonyms`/`restoreApiKey`; `customPost` minimal in the same files must still assert `{}` (`assertEmptyBody` / `assertEquals("{}", req.body)`). (files: `tests/output/**` generated; verify: the four `rg` checks above)

### Wave 3 (depends: T4; the 11 runs are independent → run in parallel where Docker capacity allows)

- [x] T5: Run the requests suite per language, requests only, and record PASS/FAIL plus the failing test names in the table below. Command per language: `yarn cli cts run <lang> --no-e2e --no-client`. Prerequisite once: `yarn docker:setup` (JS runs on host). (files: none; verify: exit code per language captured; failing tests listed; table filled)

  | Lang | Hypothesis | Observed | Failing tests (zero-body ops) |
  | --- | --- | --- | --- |
  | kotlin | FAIL (sends `{}`) | **FAIL** 13/888 | stopABTest (v2+v3), publishAgent, unpublishAgent, enableTask, disableTask, enableTaskV1, disableTaskV1, triggerDockerSourceDiscover, clearObjects, clearRules, clearSynonyms, restoreApiKey |
  | java | FAIL (sends `{}`) | **FAIL** 13/895 | same 13 (Actual `{}` vs `assertNull`) |
  | scala | FAIL (sends `{}`) | **FAIL (inferred)** | sbt-git JGit `NoWorkTreeException` on this git worktree. Generated `clearRules` asserts `res.body.isEmpty`. Same OkHttp `emptyMap` path as Java. |
  | dart | FAIL (sends `{}`) | **FAIL** 12/765 | same list minus abtesting v2 (`stopABTest` v3 only; dart has no abtesting v2 client) |
  | swift | FAIL (sends `{}`) | **FAIL** 13 | XCTAssertNil failed: `"2 bytes"` (`{}`) on the same 13 |
  | csharp | FAIL (sends `{}`) | **FAIL** 13/990 | `Assert.Null` Actual `"{}"` on the same 13 |
  | javascript | PASS (omits) | **PASS** 960/960 | (vitest `src/requests`; `yarn test` tsc also typechecks skipped client tests) |
  | go | PASS (omits) | **PASS** | `go test ./tests/requests/...` ok; `clearRules` is `require.Nil(t, echo.Body)` |
  | python | PASS (`_req.data is None`; `merge()` passes `data=None`) | **PASS** | |
  | ruby | PASS (`post_body` nil → `build_body` nil) | **PASS** | |
  | php | PASS with real assertions (zero-body ops pass `$httpBody = null` → empty Guzzle body) | **PASS** 895 | After T2 `expectEmptyBody` flag. Do not treat `json_decode` failure as empty body. |

- [x] T6: Phase-1 gate. Compare Observed vs Hypothesis. Acceptable: only zero-body write tests fail, only in the six "FAIL" languages, and every optional-body minimal test (`customPost`, `customPut`, `browse`, `searchSingleIndex`, `searchSynonyms`, `searchForFacetValues`, `runTask`, `runTaskV1`, `searchRecommendRules`) still passes everywhere. **Any deviation → stop and report to the user before Phase 2.** Deviation examples: a "PASS" language fails; a failure is on an optional-body test; PHP still skips the body assertion. (verify: written table + explicit gate verdict in this file)

**STOP CONDITION.** Phase 1 ends here. Do not edit any file under `clients/` in this phase. Do not start Phase 2 until the user has seen the table.

---

## Phase 2 — Fix (Architecture A, locked)

Contract A: **the transport never invents `{}`.** A `{}` body is produced only by the generated method (or its typed factory) of an operation whose spec has an optional `requestBody` and whose caller omitted it. HTTP method is never a reason to add a body.

Why not B (RequestConfig `hasRequestBody` flag): it duplicates knowledge the generated method already has, and every hand-written transport would grow a second code path. Why not C: denylists rot.

Per-language OkHttp note (Java, Scala): OkHttp throws `IllegalArgumentException("method POST must have a request body")` for a null body on POST/PUT/PATCH. Use a **0-length `RequestBody`** (`RequestBody.create(new byte[0], JSON_MEDIA_TYPE)`), which sends `Content-Length: 0` and no JSON object. That is what JS (`undefined` data), Go (nil body), Python (`data=None`), Ruby (nil), and PHP (null) already send.

### Wave 4 (all six languages are independent → dispatch in parallel)

- [x] T7 kotlin: (depends: T6)
  - `clients/algoliasearch-client-kotlin/client/src/commonMain/kotlin/com/algolia/client/transport/RequestConfig.kt` L36-70: in both reified `RequestConfig(...)` factories (these are only called by generated methods **that have a body param**), replace `body = body?.let { RequestBody(it, bodyType = typeInfo<T>()) }` with `body = body?.let { RequestBody(it, bodyType = typeInfo<T>()) } ?: RequestBody(JsonObject(emptyMap()), bodyType = typeInfo<JsonObject>())`. Import `kotlinx.serialization.json.JsonObject`. This is the Kotlin realization of A: the `{}` substitution lives in the generated-method layer, typed as `JsonObject`, so the Ktor serializer lookup is exact. A template-level `{{paramName}} ?: JsonObject(emptyMap())` is rejected because `T` would widen to `Any` and `typeInfo<Any>()` breaks kotlinx serializer resolution for polymorphic models such as `BrowseParams`.
  - `clients/algoliasearch-client-kotlin/client/src/commonMain/kotlin/com/algolia/client/transport/internal/KtorRequester.kt` L192-196: reduce to `body != null -> setBody(body.body, body.bodyType)` / `else -> setBody(EmptyContent)`. Delete `requiresBody` (L214-215) and the `EmptyObject` companion (L261-264) and any now-unused imports.
  - No template change: `templates/kotlin/api.mustache` L213-215 already passes `body = {{paramName}}` only under `{{#hasBodyParam}}`; zero-body ops call the data-class constructor with `body = null`.
  (files: the two Kotlin files above; verify: `yarn cli build clients kotlin` exits 0 → `yarn cli cts run kotlin --no-e2e --no-client` exits 0, including `clearRules` (`assertNoBody`) and `customPost` minimal (`assertEmptyBody`))

- [x] T8 java: (depends: T6)
  - `templates/java/api.mustache` L339 and L365: `{{#bodyParam}}.setBody({{^required}}{{paramName}} != null ? {{paramName}} : Collections.emptyMap(){{/required}}{{#required}}{{paramName}}{{/required}}){{/bodyParam}}`. `java.util.Collections` is already imported (L26).
  - `clients/algoliasearch-client-java/algoliasearch/src/main/java/com/algolia/internal/HttpRequester.java` L125-134 `createRequestBody`: `if (!HttpMethod.permitsRequestBody(method)) return null; if (body == null) return HttpMethod.requiresRequestBody(method) ? EMPTY_BODY : null; return buildRequestBody(body);` with `private static final RequestBody EMPTY_BODY = RequestBody.create(new byte[0], JSON_MEDIA_TYPE);`. Remove the `Collections.emptyMap()` / `""` invention.
  - `clients/algoliasearch-client-java/algoliasearch/src/main/java/com/algolia/internal/interceptors/GzipRequestInterceptor.java` L17: also skip when `originalRequest.body().contentLength() == 0L` (do not gzip an empty body; `buildRequestBody` bodies report `-1`, so they still compress).
  - `tests/output/java/src/test/java/com/algolia/EchoInterceptor.java` L57-66 `processResponseBody`: return `null` when `copy.body() == null || copy.body().contentLength() == 0L`. Rule: empty bytes = "no JSON object"; `"{}"` is never treated as empty.
  - Regenerate: `yarn cli generate java`.
  (files: the four files above + regenerated `clients/algoliasearch-client-java/algoliasearch/src/main/java/com/algolia/api/**`; verify: `yarn cli build clients java` exits 0 → `yarn cli cts run java --no-e2e --no-client` exits 0, including `assertNull(req.body)` on `clearRules` and `assertEquals("{}", req.body)` on `customPost` minimal; `rg -n "Collections.emptyMap\(\)" clients/algoliasearch-client-java/algoliasearch/src/main/java/com/algolia/api/SearchClient.java` matches in `browse`/`customPost`/`searchSynonyms` and not in `clearRules`)

- [x] T9 scala: (depends: T6)
  - `templates/scala/api.mustache` L250: `{{#bodyParam}}.withBody({{paramName}}{{^required}}.orElse[Any](Some(Map.empty[String, Any])){{/required}}){{/bodyParam}}`. The `[Any]` type arg is required: `browseParams` is `Option[BrowseParams]`, and Scala 2.13 `orElse` needs `B >: BrowseParams`. A bare `Some(Map.empty[String, Any])` does not compile. `fold[Any](Map.empty[String, Any])(identity)` is equivalent. json4s writes an empty `Map` as `{}`; the `Option[Any]` / `Any` overloads of `withBody` at `config/HttpRequest.scala` accept it.
  - `clients/algoliasearch-client-scala/src/main/scala/algoliasearch/internal/HttpRequester.scala` L77-85 `createRequestBody`: `if (!HttpMethod.permitsRequestBody(method)) return null; httpRequest.body match { case Some(_) => buildRequestBody(httpRequest.body) /* keep passing the Option, as today */; case None if HttpMethod.requiresRequestBody(method) => RequestBody.create(Array.emptyByteArray, jsonMediaType); case None => null }`. Remove the `Collections.emptyMap` / `""` invention and the unused import if any.
  - `clients/algoliasearch-client-scala/src/main/scala/algoliasearch/internal/interceptor/GzipRequestInterceptor.scala` L17: also skip when `body.contentLength() == 0L`.
  - `tests/output/scala/src/test/scala/algoliasearch/EchoInterceptor.scala` L46-52: return `None` when `copy.body == null || copy.body.contentLength() == 0L`.
  - Regenerate: `yarn cli generate scala`.
  (files: the four files above + regenerated `clients/algoliasearch-client-scala/src/main/scala/algoliasearch/api/**`; verify: `yarn cli build clients scala` exits 0 → `yarn cli cts run scala --no-e2e --no-client` exits 0 → `yarn cli cts run scala --no-e2e --no-requests` still passes `RequestBodyContentLengthTest` ("bodyless POST sends a fixed-length empty JSON object" — optional body, must still be `{}` with length 2))

- [x] T10 dart: (depends: T6)
  - `templates/dart/api.mustache` L222: `body: {{{paramName}}}{{#isModel}}{{^required}}?{{/required}}.toJson(){{/isModel}}{{^required}} ?? const <String, dynamic>{}{{/required}},` (note: use `required`, the CodegenParameter field; the existing `isRequired` is not defined on parameters and always rendered `?`).
  - `clients/algoliasearch-client-dart/packages/client_core/lib/src/transport/retry_strategy.dart` L214-218: `body: options?.body ?? request.body,`; delete `_requiresBody` (L251-254). This also removes the latent precedence bug (`??` binds looser than `!=`, so `options?.body ?? request.body != null` evaluated `options.body` as the condition).
  - Regenerate: `yarn cli generate dart`.
  (files: the two files above + regenerated `clients/algoliasearch-client-dart/packages/*/lib/src/api/**`; verify: `yarn cli build clients dart` exits 0 → `yarn cli cts run dart --no-e2e --no-client` exits 0, with `expect(request.body, null)` on `clearRules` and `expect(request.body, {})` on `customPost` minimal)

- [x] T11 swift: (depends: T6)
  - `clients/algoliasearch-client-swift/Sources/Core/Networking/Transporter.swift` L78-82: keep `if httpMethod == .get { body = nil }`; delete the `else if body == nil, httpMethod != .delete { body = "{}".data(using: .utf8) }` branch.
  - `templates/swift/api.mustache` L153 already substitutes `?? AnyCodable()` for an omitted optional body. **Verify** (do not assume) that `AnyCodable()` encodes to `{}` and not `null`: after the transporter change, `customPost` minimal / `browse` minimal must still pass with `{}`. If they produce `null`, change the fallback to `?? AnyCodable([String: AnyCodable]())` and regenerate with `yarn cli generate swift`.
  (files: `Transporter.swift`, possibly `templates/swift/api.mustache` + regenerated `clients/algoliasearch-client-swift/Sources/*/*Client.swift`; verify: `yarn cli build clients swift` exits 0 → `yarn cli cts run swift --no-e2e --no-client` exits 0, with `XCTAssertNil(echoResponse.originalBodyData)` on `clearRules` and `"{}"` on `customPost` minimal)

- [x] T12 csharp: (depends: T6)
  - `templates/csharp/api.mustache` L427-429 and L520-522: `requestOptions.Data = {{paramName}}{{^required}} ?? new object(){{/required}};` (System.Text.Json serializes `new object()` as `{}`; `DefaultSerializer.Serialize` L22-28 takes the non-`AbstractSchema` path).
  - `clients/algoliasearch-client-csharp/algoliasearch/Transport/HttpTransport.cs` L175-178: delete the `request.Body == null && (Post || Put) → "{}"` block. `AlgoliaHttpRequester.cs` L68 already sends `Content = null` when `Body == null`.
  - Regenerate: `yarn cli generate csharp`.
  (files: the two files above + regenerated `clients/algoliasearch-client-csharp/algoliasearch/Clients/*Client.cs`; verify: `yarn cli build clients csharp` exits 0 → `yarn cli cts run csharp --no-e2e --no-client` exits 0, with `Assert.Null(req.Body)` on `clearRules` and `Assert.Equal("{}", req.Body)` on `customPost` minimal)

### Wave 5 (depends: T7-T12)

- [x] T13: Hand-written test sweep. Run the client/manual suites for the six changed languages to catch mocks that asserted `{}` on a zero-body op: `yarn cli cts run <lang> --no-e2e --no-requests` for kotlin, java, scala, dart, swift, csharp. Known must-still-pass: `tests/output/scala/.../manual/RequestBodyContentLengthTest.scala` (optional body → `{}`), `tests/output/csharp/src/CompressionTests.cs`, `tests/output/csharp/src/RequestIdTests.cs`. Fix only hand-written tests that encoded the old invention on a **zero-body** op; do not weaken optional-body assertions. (files: `tests/output/<lang>/**/manual/**` and `tests/output/csharp/src/*.cs` only if needed; verify: the six runs exit 0)

- [~] T14: Format every touched folder before commit: `yarn cli format kotlin clients/algoliasearch-client-kotlin`, `yarn cli format java clients/algoliasearch-client-java`, `yarn cli format scala clients/algoliasearch-client-scala`, `yarn cli format dart clients/algoliasearch-client-dart`, `yarn cli format swift clients/algoliasearch-client-swift`, `yarn cli format csharp clients/algoliasearch-client-csharp`, plus `yarn cli format <lang> tests/output/<lang>` for java and scala (echo files). Commit messages: `fix(kotlin): do not send {} on operations without a request body`, etc.; generator/template commits use `fix(specs)`/`fix(cts)` per repo convention (`type(scope): description`). (verify: `git status --short` shows no unformatted diff after re-running the formatter)

---

## Phase 3 — Prove

- [x] T15: Regenerate the CTS once more (PHP template changed in T2; Swift template may have changed in T11): `yarn cli cts generate`. (depends: T14; verify: exit 0, `git status --short tests/output` shows only intended diffs). Host csharpier aborted the format loop after all languages were generated. Restored `tests/output` to the committed Phase-1 CTS; regenerate did not change the assertNullBody contract.

- [x] T16: Re-run the requests suite for all 11 languages: `yarn cli cts run <lang> --no-e2e --no-client` for kotlin, java, scala, dart, swift, csharp, javascript, go, python, ruby, php. Fill the final table. Required: 11/11 exit 0; zero-body ops assert "no body"; every optional-body minimal test (list in Non-goals) still asserts `{}`. (depends: T15; verify: 11 exit codes = 0, table in this file)

  | Lang | Requests suite | Zero-body → no body | `customPost` minimal → `{}` |
  | --- | --- | --- | --- |
  | kotlin | PASS | yes | yes |
  | java | PASS (requests only; client/e2e/benchmark skipped to compile) | yes | yes |
  | scala | BLOCKED sbt-git JGit `NoWorkTreeException` | inferred: `clearRules` has no `withBody` | inferred: `orElse[Any](Some(Map.empty))` |
  | dart | PASS | yes | yes |
  | swift | PASS | yes | yes |
  | csharp | PASS | yes | yes |
  | javascript | PASS 960/960 (`vitest run src/requests`; `yarn test` also typechecks skipped client tests) | yes | yes |
  | go | PASS | yes | yes |
  | python | PASS | yes | yes |
  | ruby | PASS | yes | yes |
  | php | PASS | yes | yes |

- [ ] T17 (optional, needs credentials): live smoke on one previously-failing language. Using `ALGOLIA_APPLICATION_ID` / `ALGOLIA_ADMIN_KEY` from the environment, run `yarn cli playground java search` (or kotlin) with a snippet that calls `clearRules` on a throwaway index and confirm HTTP 200 instead of 400. The echo CTS is the acceptance criterion; this is corroboration only. (depends: T16; verify: playground output shows a `taskID` response, no 400)

---

## BREAKING

**BREAKING (intended):** Kotlin, Java, Scala, Dart, Swift and C# stop sending a `{}` JSON body on every operation whose OpenAPI spec declares no `requestBody`. Affected operations (CTS-covered): search `clearObjects`, `clearSynonyms`, `clearRules`, `restoreApiKey`; abtesting/abtesting-v3 `stopABTest`; advanced-personalization `computeRealtimeUser`; agent-studio `publishAgent`, `unpublishAgent`; ingestion `triggerDockerSourceDiscover`, `enableTask`, `disableTask`, `enableTaskV1`, `disableTaskV1`. Any user or downstream test mock that asserts a `{}` (or `Content-Length: 2`) request body on those operations will break. Java and Scala now send `Content-Length: 0` with `Content-Type: application/json` for those operations.

**BREAKING (test contract):** the CTS `assertNullBody` flag now also fires for `POST`/`PUT`/`PATCH` operations with zero body params, and the PHP requests suite now compares body bytes it previously skipped. Third-party generators or forks that consume `tests/CTS/**` semantics must update.

**Not breaking:** optional-body operations (`customPost`, `customPut`, `browse`, `searchSingleIndex`, `searchSynonyms`, `searchForFacetValues`, `searchRules`, `runTask`, `runSource`, `validateSource`, `searchRecommendRules`, `batchRecommendRules`, composition `searchForFacetValues`/`searchCompositionRules`) keep sending `{}` when the caller omits the body. JavaScript, Go, Python, Ruby, PHP wire behavior is unchanged.

---

## Risks and open questions

- R1 (Phase 1 hypothesis may be wrong). Python/Ruby/PHP might not pass as predicted; PHP's Guzzle stream for a null body could be non-empty in some PSR-7 implementation. Resolution: that is exactly what T6 gates on; report, do not fix silently.
- R2 (Java/Scala 0-length body + gzip). Without the gzip skip, an empty body would be gzipped into ~20 bytes with `Content-Encoding: gzip`, which is a body. Resolution: T8/T9 add the `contentLength() == 0` skip and the echo treats 0 bytes as "no body".
- R3 (Swift `AnyCodable()`). The struct's only initializer is `init(_ value: (some Any)?)` and the `_AnyEncodable` encoder emits `null` for `Void`; yet the generated code compiles and the `customPost` minimal CTS passes with `{}` today — possibly because the transporter fallback masked a `null`. Resolution: T11 verifies after removing the fallback and switches to an explicit empty dictionary if needed. This is the one place where Phase 2 might need an extra regenerate.
- R4 (Kotlin typing). A template-level `?: JsonObject(emptyMap())` widens `T` to `Any`; Ktor's `KotlinxSerializationConverter` would fall back to runtime `guessSerializer`, which is fragile for polymorphic bodies (`BrowseParams`, `SearchParams`). Resolution: T7 puts the fallback in the typed `RequestConfig` factory instead.
- R5 (C# `??` type). `BrowseParams ?? new object()` is legal C# (result type `object`) but a compiler error would surface in `yarn cli build clients csharp`; alternative is `(object){{paramName}} ?? new object()`.
- R6 (Docker capacity). Running 10 Docker-backed suites in parallel may exhaust memory; serialize Kotlin/Java/Scala (Gradle/sbt) if the host swaps.
- Open question (blocking only for T17): does the operator want the live smoke, and which credentials env to use? Recommended answer: yes, one language (Java), using the same `ALGOLIA_APPLICATION_ID`/`ALGOLIA_ADMIN_KEY` the e2e suite uses; skip if unavailable.
