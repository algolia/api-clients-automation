/**
 * Optional, additive Kotlin DSL for the Algolia client.
 *
 * This package is experimental on the first 3.x minor. It is not source compatible with version 2.
 * Data-class constructors stay the default.
 */
package com.algolia.client.dsl

/**
 * Marks types that belong to the Algolia Kotlin DSL.
 *
 * Nested DSL receivers cannot access outer receivers that share this marker.
 */
@DslMarker public annotation class AlgoliaDsl

/**
 * Marks the Algolia Kotlin DSL as experimental.
 *
 * The DSL is optional and additive. It is not source compatible with version 2. The first 3.x minor
 * may change the shape.
 */
@RequiresOptIn(
  level = RequiresOptIn.Level.ERROR,
  message =
    "This DSL is experimental, optional, additive, and not v2 source compatible. The first 3.x minor may change its shape.",
)
@Retention(AnnotationRetention.BINARY)
@Target(
  AnnotationTarget.CLASS,
  AnnotationTarget.FUNCTION,
  AnnotationTarget.PROPERTY,
  AnnotationTarget.CONSTRUCTOR,
  AnnotationTarget.TYPEALIAS,
)
public annotation class AlgoliaExperimentalDsl
