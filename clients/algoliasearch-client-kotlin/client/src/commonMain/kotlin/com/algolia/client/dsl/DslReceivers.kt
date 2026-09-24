@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.generated.DSLBrowseParamsObject
import com.algolia.client.dsl.generated.DSLDeleteByParams
import com.algolia.client.dsl.generated.DSLIndexSettings
import com.algolia.client.dsl.generated.DSLSearchParamsObject

// The four aliases below are source-level only: bytecode, Java callers, reflection, and stack
// traces still see the generated `DSL<Model>` class names.

/**
 * Receiver of [query] and [com.algolia.client.dsl.searchSingleIndex]. Use this name, not the
 * generated one, in stored fragments such as `val extra: DSLQuery.() -> Unit`. This is a Kotlin
 * source alias; Java and JVM signatures still use [DSLSearchParamsObject].
 */
@AlgoliaExperimentalDsl
public typealias DSLQuery = DSLSearchParamsObject

/** Receiver of [browse]. Kotlin source alias of [DSLBrowseParamsObject]. */
@AlgoliaExperimentalDsl
public typealias DSLBrowse = DSLBrowseParamsObject

/**
 * Receiver of [deleteBy] and [com.algolia.client.dsl.deleteBy] on the search client. Kotlin source
 * alias of [DSLDeleteByParams].
 */
@AlgoliaExperimentalDsl
public typealias DSLDeleteBy = DSLDeleteByParams

/**
 * Receiver of [settings] and [com.algolia.client.dsl.setSettings]. Kotlin source alias of
 * [DSLIndexSettings].
 */
@AlgoliaExperimentalDsl
public typealias DSLSettings = DSLIndexSettings
