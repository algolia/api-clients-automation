@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.DSLFilters
import com.algolia.client.dsl.generated.DSLDeleteByParamsAdditions
import com.algolia.client.model.search.DeleteByParams

/**
 * Collects delete-by filter fragments from several modules and builds one [DeleteByParams].
 *
 * Delete-by twin of [DSLQueryComposer]: filters only, since [DeleteByParams] has no list fields.
 *
 * [add] and [override] only store their blocks; nothing runs until [build]. Each [build] runs every
 * stored [add] block, runs [base] on a fresh [DSLDeleteBy], then writes `filters` once: all
 * `filters { }` fragments run inside one [DSLFilters] after the base rows (so they are AND-ed with
 * the base). Then every [override] block runs on the same [DSLDeleteBy], in call order: last write
 * wins, so an override that sets `filters` replaces the merged value. Geo fields (`aroundLatLng`,
 * `aroundRadius`, `insideBoundingBox`, `insidePolygon`) have no additive form; set them in [base]
 * or [override].
 *
 * Put the starting filters in [base], not in an [override]: an override replaces the fragments. A
 * base that assigns `filters` directly cannot be merged with fragments, so [build] throws
 * [IllegalStateException]; set it with `filters { }` in the base instead.
 *
 * [build] throws [IllegalArgumentException] when a `filters { }` fragment, or a group block inside
 * one, adds no filter: dropping it would widen the delete. It also throws when the result has no
 * filter and no geo condition, which the engine rejects. Skip the delete when there is nothing to
 * match.
 *
 * Every [build] re-evaluates every stored block, so values captured by reference (a `var`, a
 * mutable list) are read at build time and side effects in a block repeat on each build. [build]
 * can be called repeatedly. Not thread-safe.
 *
 * ```
 * val composer = DSLDeleteByComposer()
 * composer.add { filters { facet("locale", "en-US") } }
 * composer.add { filters { facet("entityId", "x", isNegated = true) } }
 * composer.override { aroundLatLng = "40.71,-74.01" }
 * val params = composer.build() // filters = "locale:en-US AND NOT entityId:x"
 * ```
 */
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLDeleteByComposer public constructor(base: DSLDeleteBy.() -> Unit = {}) {
  private val core =
    ComposerCore(
      ::DSLDeleteByParamsAdditions,
      { DSLDeleteBy() },
      base,
      merge = true,
      DSLDeleteByParamsAdditions::applyTo,
    )

  /**
   * Stores [block]. It runs on every [build], before the overrides; captured values are read then.
   */
  public fun add(block: DSLDeleteByAdditions.() -> Unit): Unit = core.add(block)

  /** Stores [block]. It runs on every [build], after the additive fields. Last write wins. */
  public fun override(block: DSLDeleteBy.() -> Unit): Unit = core.override(block)

  /**
   * Builds a [DeleteByParams] from fresh state: runs every stored [add] block and [base], merges
   * each filter field once, then runs every stored [override] block in call order. Throws
   * [IllegalArgumentException] when the result has no filter and no geo condition.
   */
  public fun build(): DeleteByParams = core.build().build().requireDeleteCondition()
}

/**
 * Returns this when it sets a filter or a geo condition. The engine rejects a delete-by without one
 * (`{}`, a blank `filters`) with HTTP 400, so this fails before the request instead. An assigned
 * `facetFilters`, `numericFilters`, or `tagFilters` counts as set even when empty; the engine
 * rejects the empty ones itself.
 */
internal fun DeleteByParams.requireDeleteCondition(): DeleteByParams {
  val hasCondition =
    !filters.isNullOrBlank() ||
      facetFilters != null ||
      numericFilters != null ||
      tagFilters != null ||
      !aroundLatLng.isNullOrBlank() ||
      aroundRadius != null ||
      insideBoundingBox != null ||
      insidePolygon != null
  require(hasCondition) {
    "deleteBy: no filter and no geo condition; the engine rejects an empty delete-by. " +
      "Skip the delete when there is nothing to match."
  }
  return this
}

/**
 * Composes a [DeleteByParams] in one expression: `DSLDeleteByComposer(base).apply(block).build()`.
 *
 * ```
 * val params =
 *   composeDeleteBy(base = { aroundLatLng = "40.71,-74.01" }) {
 *     add { filters { facet("locale", "en-US") } }
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public fun composeDeleteBy(
  base: DSLDeleteBy.() -> Unit = {},
  block: DSLDeleteByComposer.() -> Unit,
): DeleteByParams {
  return DSLDeleteByComposer(base).apply(block).build()
}
