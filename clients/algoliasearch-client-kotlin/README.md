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
  facetFilters { or { facet("color", "red"); facet("color", "blue") } }
}
```

`filters { }` sets the SQL `filters` string. `facetFilters { }`, `optionalFilters { }`, `numericFilters { }`, and `tagFilters { }` set the matching typed field. An empty block omits the field.

Negate a single leaf with `isNegated` (pass it by name: the third positional argument of `facet` is `score`), or a group with `not { }`. `and { }` and `or { }` work in every filter block, including `optionalFilters`:

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

The `filters` string only uses shapes Algolia supports: `NOT` applies to single filters (`not { orFacet { a; b } }` encodes as `NOT a AND NOT b`, `not { a; b }` as `(NOT a OR NOT b)`), nested `and { }` blocks are flattened, and the top-level `AND` has no parentheses. A `not { }` that would need an `OR` of `AND`s, or an `OR` across facet, tag, and numeric filters, throws `IllegalArgumentException`. `facetFilters`, `optionalFilters`, and `tagFilters` entries are written unquoted, exactly as the engine matches them: `category:Book`, negated `category:-Book`, a value starting with `-` as `category:\-Movie` (negated: `category:--Movie`), and values with spaces, colons, or quotes as-is (`provider:NBC: Universal "East"`). Scores are emitted whenever set, including `score = 0`; the engine takes the maximum inside an `OR` group and sums across `AND`ed filters.

Store reusable fragments with the stable receiver names `QueryBuilder`, `BrowseBuilder`, `DeleteByBuilder`, and `SettingsBuilder`, and the filter receivers `FilterDsl`, `FacetFilterDsl`, `NumericFilterDsl`, and `TagFilterDsl`. The four builder names are Kotlin typealiases; Java code and JVM signatures still show the generated `*Builder` classes:

```kotlin
@OptIn(AlgoliaExperimentalDsl::class)
val locale: FilterDsl.() -> Unit = { orFacet { facet("locale", "en-US") } }

@OptIn(AlgoliaExperimentalDsl::class)
val base: QueryBuilder.() -> Unit = { hitsPerPage = 20; filters(locale) }
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

List parameters on `query { }`, `browse { }`, and rule `params { }` take `+` blocks. A block replaces the list; an empty block omits the field. This differs from the `settings { }` list helpers, where an empty block sends an empty list. To send `[]` from a query, assign it: `attributesToRetrieve = emptyList()`.

```kotlin
@OptIn(AlgoliaExperimentalDsl::class)
val params = query {
  restrictSearchableAttributes { +"title"; +"alternateTitles" }
  queryLanguages { +SupportedLanguage.En }
  responseFields { +ResponseField.Hits; +ResponseField.ProcessingTimingsMS; +ResponseField.Other("renderingContent") }
}
```

### Migrating from version 2

Map version 2 types to version 3 types:

- `Query` → `SearchParamsObject` via `query { }`
- `Settings` → `IndexSettings` via `settings { }`
- `Attribute` → `String`
- `initIndex` is gone. Pass the index name to the client method.
- `index.search { }` → `client.searchSingleIndex(indexName) { }`
- `index.browse(query)` → `client.browse(indexName, browse { })`

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
