@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.generated.BrowseParamsObjectBuilder
import com.algolia.client.dsl.generated.DeleteByParamsBuilder
import com.algolia.client.dsl.generated.IndexSettingsBuilder
import com.algolia.client.dsl.generated.SearchParamsObjectBuilder

// The four aliases below are source-level only: bytecode, Java callers, reflection, and stack
// traces still see the generated `*Builder` class names.

/**
 * Receiver of [query] and [com.algolia.client.dsl.searchSingleIndex]. Use this name, not the
 * generated one, in stored fragments such as `val extra: QueryBuilder.() -> Unit`. This is a Kotlin
 * source alias; Java and JVM signatures still use [SearchParamsObjectBuilder].
 */
@AlgoliaExperimentalDsl
public typealias QueryBuilder = SearchParamsObjectBuilder

/** Receiver of [browse]. Kotlin source alias of [BrowseParamsObjectBuilder]. */
@AlgoliaExperimentalDsl
public typealias BrowseBuilder = BrowseParamsObjectBuilder

/**
 * Receiver of [deleteBy] and [com.algolia.client.dsl.deleteBy] on the search client. Kotlin source
 * alias of [DeleteByParamsBuilder].
 */
@AlgoliaExperimentalDsl
public typealias DeleteByBuilder = DeleteByParamsBuilder

/**
 * Receiver of [settings] and [com.algolia.client.dsl.setSettings]. Kotlin source alias of
 * [IndexSettingsBuilder].
 */
@AlgoliaExperimentalDsl
public typealias SettingsBuilder = IndexSettingsBuilder
