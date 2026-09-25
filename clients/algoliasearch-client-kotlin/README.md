<p align="center">
  <a href="https://www.algolia.com">
    <img alt="Algolia for Kotlin" src="https://raw.githubusercontent.com/algolia/algoliasearch-client-common/master/banners/kotlin.png" >
  </a>

<h4 align="center">The perfect starting point to integrate <a href="https://algolia.com" target="_blank">Algolia</a> within your Kotlin project</h4>

  <p align="center">
    <a href="https://search.maven.org/search?q=a:algoliasearch-client-kotlin"><img src="https://img.shields.io/maven-central/v/com.algolia/algoliasearch-client-kotlin?label=Download" alt="Latest version"></img></a>
    <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="Licence"></img></a>
  </p>
</p>

<p align="center">
  <a href="https://www.algolia.com/doc/libraries/sdk/install#kotlin" target="_blank">Documentation</a>  •
  <a href="https://discourse.algolia.com" target="_blank">Community Forum</a>  •
  <a href="http://stackoverflow.com/questions/tagged/algolia" target="_blank">Stack Overflow</a>  •
  <a href="https://github.com/algolia/algoliasearch-client-kotlin/issues" target="_blank">Report a bug</a>  •
  <a href="https://alg.li/support" target="_blank">Support</a>
</p>

## ✨ Features

- The Kotlin client is compatible with Kotlin `1.6` and higher.
- It is compatible with Kotlin project on the JVM, such as backend and Android applications.
- It relies on the open source Kotlin libraries for seamless integration into Kotlin projects:
    - [Kotlin multiplatform](https://kotlinlang.org/docs/reference/multiplatform.html).
    - [Kotlinx serialization](https://github.com/Kotlin/kotlinx.serialization) for json parsing.
    - [Kotlinx coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous operations.
    - [Ktor](https://github.com/ktorio/ktor) HTTP client.
- The Kotlin client integrates the actual Algolia documentation in each source file: Request parameters, response fields, methods and concepts; all are documented and link to the corresponding url of the Algolia doc website.
- The client is thread-safe. You can use `SearchClient`, `AnalyticsClient`, and `InsightsClient` in a multithreaded environment.

## 💡 Getting Started

Install the Kotlin client by adding the following dependency to your `gradle.build` file:

  ```gradle
  repositories {
     mavenCentral()
  }
  
  dependencies {
     implementation "com.algolia:algoliasearch-client-kotlin:$version"
  }
  ```
Also, choose and add to your dependencies one of [Ktor http client engines](https://ktor.io/docs/http-client-engines.html).
Alternatively, you can use [algoliasearch-client-kotlin-bom](/client-bom).  

For full documentation, visit the **[Algolia Kotlin API Client](https://www.algolia.com/doc/libraries/sdk/install#kotlin)**.

## Optional Kotlin DSL

The client includes an optional Kotlin DSL for search parameters and index settings. The DSL is optional, experimental on the first 3.x minor (`@OptIn(AlgoliaExperimentalDsl::class)`), and is not source compatible with version 2. Data-class constructors stay supported.

```kotlin
import com.algolia.client.dsl.*

@OptIn(AlgoliaExperimentalDsl::class)
val params = query {
  query = "shoes"
  filters { facet("brand", "Apple") }          // SQL string
  optionalFilters { or { facet("color", "red"); facet("color", "blue") } }
}
```

`filters { }` sets the SQL `filters` string and `optionalFilters { }` the `optionalFilters` field. For `facetFilters`, `numericFilters`, and `tagFilters`, use `filters { }` (Algolia recommends `filters`) or assign the generated field. An empty block omits the field.

Negate a single leaf with `isNegated` (pass it by name: the third positional argument of `facet` is `score`). `and { }` works in every filter block. OR groups are `orFacet { }`, `orTag { }`, `orNumeric { }` in `filters { }`, and `or { }` in `optionalFilters { }` (facets only) — the version 2 names:

```kotlin
@OptIn(AlgoliaExperimentalDsl::class)
val params = query {
  filters {
    orFacet { facet("entityId", "a"); facet("entityId", "b") }
    facet("batchId", "b-1", isNegated = true)
  }
  optionalFilters {
    and { facet("genre", "comedy", score = 500); facet("provider", "NBC", score = 500) }
    or { facet("isFeatured", true, score = 0); facet("isNew", true) }
  }
}
```

In `deleteBy { }` (and `DSLDeleteByComposer`), an empty `filters { }`, an empty `and { }`, `orFacet { }`, `orTag { }`, or `orNumeric { }`, or an empty composer `filters` fragment throws `IllegalArgumentException` before any request is sent: on search dropping it only broadens the results, on a delete it would delete more records than intended. A delete-by with no filter and no geo condition (`aroundLatLng`, `aroundRadius`, `insideBoundingBox`, `insidePolygon`) throws too, since the engine rejects it. Skip the delete when there is nothing to match.

The `filters` string only uses shapes Algolia supports: `NOT` only precedes a single filter (`isNegated`), nested `and { }` blocks are flattened, the top-level `AND` has no parentheses, and each `OR` holds one filter family by construction. Attributes and values are written bare only when they are made of ASCII letters, digits, `_`, `.`, and `-` and hold no `AND`, `OR`, `NOT`, or `TO` word; anything else is quoted, with `\` and `"` escaped (`category:"Books (Kids)"`, `path:"C:\\dir\\"`), because the engine rejects `(`, `)`, `:`, `<`, `>`, `=`, and `!` outside quotes. `optionalFilters` entries are written unquoted, exactly as the engine matches them: `category:Book`, negated `category:-Book`, a value starting with `-` as `category:\-Movie` (negated: `category:--Movie`), and values with spaces, colons, or quotes as-is (`provider:NBC: Universal "East"`). Scores are emitted whenever set, including `score = 0`; the engine takes the maximum inside an `OR` group and sums across `AND`ed filters.

Store reusable fragments with the stable receiver names `DSLQuery`, `DSLBrowse`, `DSLDeleteBy`, `DSLSettings`, `DSLQueryAdditions`, and `DSLDeleteByAdditions`, and the filter receivers `DSLFilters` and `DSLFacetFilters`. The stable receiver names are Kotlin typealiases of the generated `DSL<Model>` classes (`DSLSearchParamsObject`, `DSLBrowseParamsObject`, `DSLDeleteByParams`, `DSLIndexSettings`) and of the generated composer receivers (`DSLSearchParamsObjectAdditions`, `DSLDeleteByParamsAdditions`); Java code and JVM signatures show the generated classes:

```kotlin
@OptIn(AlgoliaExperimentalDsl::class)
val locale: DSLFilters.() -> Unit = { orFacet { facet("locale", "en-US") } }

@OptIn(AlgoliaExperimentalDsl::class)
val base: DSLQuery.() -> Unit = { hitsPerPage = 20; filters(locale) }
```

```kotlin
import com.algolia.client.dsl.*

@OptIn(AlgoliaExperimentalDsl::class)
val indexSettings = settings {
  searchableAttributes {
    ordered("name")
    unordered("description")
  }
}
```

Use the generated `browse` method with the value builder:

```kotlin
@OptIn(AlgoliaExperimentalDsl::class)
client.browse("idx", browse { query = "shoes"; filters { facet("brand", "Apple") } })
```

A `rule` requires `consequence`. `promote { }` and `hide { }` replace the list on a second call:

```kotlin
@OptIn(AlgoliaExperimentalDsl::class)
val promo = rule("promo") {
  consequence {
    promote { objectID("object-1", position = 0) }
    hide { +"object-9" }
  }
}
```

List parameters on `query { }`, `browse { }`, and rule `params { }` take `+` blocks. A block replaces the list; an empty block sends `[]`, as in version 2 and the `settings { }` list helpers. Leave the field unset to omit it.

```kotlin
@OptIn(AlgoliaExperimentalDsl::class)
val params = query {
  restrictSearchableAttributes { +"title"; +"alternateTitles" }
  queryLanguages { +SupportedLanguage.En }
  responseFields { +"hits"; +"processingTimingsMS"; +"renderingContent" }
}
```

### Composing queries

`DSLQueryComposer` assembles one `SearchParamsObject` from fragments contributed by several modules. `base` is the starting query, `add { }` contributes to a field, and `override { }` sets a field outright:

```kotlin
@OptIn(AlgoliaExperimentalDsl::class)
val composer = DSLQueryComposer(base = { hitsPerPage = 20 })   // was: QueryWrapper(query)
composer.add { filters { orFacet { facet("locale", primary); secondary?.let { facet("locale", it) } } } }
composer.override { queryLanguages { +SupportedLanguage.En } }
composer.add { optionalFilters { or { facet("isFeatured", true, score = 500) } } }
composer.override { sumOrFiltersScores = true }
val extra: DSLQueryAdditions.() -> Unit = { ruleContexts { +"desktop" } }   // stored fragment
composer.add(extra)
client.searchSingleIndex(indexName, composer.build())         // every lambda above runs here
```

`composer.build()` runs every stored block and returns the `SearchParamsObject`; send it with `client.searchSingleIndex(indexName, composer.build())`. A `DSLDeleteByComposer`'s `build()` goes to `client.deleteBy(indexName, …)` the same way.

`add { }` and `override { }` only store their blocks; nothing runs until `build()`. `build()` runs every stored `add` block on a fresh `DSLQueryAdditions`, runs `base` on a fresh `DSLQuery`, then merges each field once: all fragments for a field run inside one receiver after what `base` set, so `filters` fragments are `AND`ed with the base filters into one group and `ruleContexts` fragments append to the base list. A `base` that assigns `filters` or `optionalFilters` directly (`filters = "a OR b"`) cannot be merged with fragments for that field: `build()` throws `IllegalStateException`, so set it with `filters { }` in `base`. It then runs every `override` block on the resulting `DSLQuery`, in call order, so the last write wins over anything set additively (including `filters = null`). Because every block re-runs on each `build()`, captured values (a `var locale`, a mutable list) are read at build time, side effects repeat per build, and an `add` or `override` made after a `build()` affects the next one. A list field whose fragments add nothing is sent as `[]`; empty `filters { }` or `optionalFilters { }` fragments leave the field as `base` set it, or omitted. `build()` can throw whatever a stored block throws. A composer is not thread-safe. `DSLDeleteByComposer` does the same for `deleteBy`, with the `filters` field only.

To start from a `SearchParamsObject` you already have, pass it as `from`: `DSLQueryComposer(from = existing)`. Each `build()` copies its values into a fresh builder (the object is never modified), replaces every field that has `add { }` fragments with those fragments, and runs the overrides last; fields without fragments keep the object's value. This is what a version 2 `QueryWrapper(query).build()` did, without mutating `query`.

Compared with a hand-rolled `QueryWrapper` that stored `DSLFilters.() -> Unit`, `DSLFacetFilters.() -> Unit`, and `DSLStrings.() -> Unit` lambdas: fragments are per-field inside one `add { }` (no separate lambda types to declare), and the starting query goes in `base`, not in `override { }`: overrides run after the additive fields and replace them.

### Migrating from version 2

Map version 2 types to version 3 types:

| Version 2 | Version 3 |
| --- | --- |
| `Query(...)`, `query { }` | `query { }` → `SearchParamsObject`; receiver `DSLQuery` |
| `index.search(query)` | `client.searchSingleIndex(indexName) { }` |
| `index.browse(query)` | `client.browse(indexName, browse { })` |
| `DeleteByQuery().apply { filters { } }` + `index.deleteObjectsBy(q)` | `client.deleteBy(indexName) { filters { } }` |
| `Settings` | `settings { }` → `IndexSettings`; receiver `DSLSettings` |
| `Attribute("x")` | `"x"` |
| `DSLFilters`, `DSLFacetFilters` (facet / optional filters) | same names (`com.algolia.client.dsl.filter`) |
| `DSLGroupFacet`, `DSLGroupNumeric`, `DSLGroupTag` | same names |
| `DSLFacet`, `DSLNumeric`, `DSLTag` | same names |
| `facetFilters { }`, `numericFilters { }`, `tagFilters { }` | `filters { }` |
| `DSLAttributes`, `DSLStrings`, `DSLLanguage` | same names; typealiases of `DSLValues<String>` / `DSLValues<SupportedLanguage>` |
| `DSLSearchableAttributes`, `DSLAttributesForFaceting`, `DSLCustomRanking`, `DSLRanking`, `@DSLParameters` | same names |
| `DSLConditions`, `DSLPromotions`, `DSLObjectIDs` | same names; members differ from version 2 (`condition { }`, `objectID(id, position)`/`objectIDs(ids, position)`, `+"objectID"`) |
| `facet(attr, value, score, isNegated)` | same, `attr` is `String` |
| `not { }`, unary `!` | `isNegated = true` on each leaf |
| `Distinct(1)` | `Distinct.of(1)` |
| `Language.English` | `SupportedLanguage.En` |
| `TypoTolerance.Min`, `TypoTolerance.True` | `TypoTolerance.of(TypoToleranceEnum.Min)`, `TypoTolerance.of(true)` |
| `IgnorePlurals.True`, `IgnorePlurals.QueryLanguages(...)` | `IgnorePlurals.of(true)`, `IgnorePlurals.of(listOf(SupportedLanguage.En))` |
| `RemoveStopWords.True` | `RemoveStopWords.of(true)` |
| `UserToken("u")` | `"u"` |
| `ResponseFields.Hits`, `ResponseFields.Other("x")` | `+"hits"`, `+"x"` |
| v2 legacy strings `"attr":"v"`, `"attr":-"v"` | `attr:v`, `attr:-v` — the engine ignores v2's quoted form in `optionalFilters` |
| custom query wrapper | `DSLQueryComposer` / `DSLDeleteByComposer` |
| `QueryWrapper(query)` (mutated `query` on build) | `DSLQueryComposer(from = query)` (copies `query`) |
| `and { a; b }` sent as `(a AND b)`, every group parenthesised, duplicate groups dropped | `and { }` flattened into the top-level `AND`; groups keep call order and duplicates |
| `filters` values always quoted, `\` not escaped | quoted only when needed, `\` and `"` escaped |
| empty filter group dropped, also in `deleteBy` | dropped on search; throws in `deleteBy` |
| `initIndex` | removed; pass the index name to each client method |

`SearchClient.search` is multi-query. Use `searchSingleIndex` for a single index.

```kotlin
import com.algolia.client.dsl.*

@OptIn(AlgoliaExperimentalDsl::class)
val response = client.searchSingleIndex("products") {
  query = "shoes"
  filters { facet("brand", "Apple") }
}
```

See the [Kotlin upgrade guide](https://www.algolia.com/doc/libraries/sdk/upgrade/kotlin).

## ❓ Troubleshooting

Encountering an issue? Before reaching out to support, we recommend heading to our [FAQ](https://support.algolia.com/hc/sections/15061037630609-API-Client-FAQs) where you will find answers for the most common issues and gotchas with the client.

## Use the Dockerfile

If you want to contribute to this project without installing all its dependencies, you can use our Docker image. Please check our [dedicated guide](DOCKER_README.md) to learn more.

## 📄 License

The Algolia Kotlin API Client is an open-sourced software licensed under the [MIT license](LICENSE).
