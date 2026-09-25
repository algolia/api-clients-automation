@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.DSLFilters
import com.algolia.client.dsl.filter.widensDelete
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
 * one, adds no filter: dropping it would widen the delete. Skip the delete when there is nothing to
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
      ::DSLDeleteByAdditions,
      { DSLDeleteBy() },
      base,
      merge = true,
      DSLDeleteByAdditions::applyTo,
    )

  /**
   * Stores [block]. It runs on every [build], before the overrides; captured values are read then.
   */
  public fun add(block: DSLDeleteByAdditions.() -> Unit): Unit = core.add(block)

  /** Stores [block]. It runs on every [build], after the additive fields. Last write wins. */
  public fun override(block: DSLDeleteBy.() -> Unit): Unit = core.override(block)

  /**
   * Builds a [DeleteByParams] from fresh state: runs every stored [add] block and [base], merges
   * each filter field once, then runs every stored [override] block in call order.
   */
  public fun build(): DeleteByParams = core.build().build()
}

/**
 * Additive receiver of [DSLDeleteByComposer.add], created fresh on every
 * [DSLDeleteByComposer.build]. Each method records its block for that field; the blocks for a field
 * run together, in call order, inside one receiver when the field is written.
 */
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLDeleteByAdditions internal constructor() {
  // Not `filters`: `filters(it)` in the lambda must resolve to the builder helper, and a
  // property must not appear in its own initializer.
  private val filtersField: Additive<DSLDeleteBy, DSLFilters> =
    filterAdditive("filters", DSLDeleteBy::filtersRows, DSLFilters::addRows) { filters(it) }
  private var filtersFragments = 0

  private val fields: List<Additive<DSLDeleteBy, *>> = listOf(filtersField)

  /**
   * Records a `filters` fragment. All fragments run inside one [DSLFilters] at build time. A
   * fragment that adds no filter makes [DSLDeleteByComposer.build] throw
   * [IllegalArgumentException], even when other fragments add some.
   */
  public fun filters(block: DSLFilters.() -> Unit) {
    val position = ++filtersFragments
    filtersField.add {
      val before = rowCount()
      block()
      require(rowCount() > before) { widensDelete("filters { } fragment $position") }
    }
  }

  /**
   * Writes each field with at least one recorded block once, through the generated [DSLDeleteBy]
   * member helper, so the helper's rules (an empty block throws) apply unchanged.
   */
  internal fun applyTo(builder: DSLDeleteBy, merge: Boolean) {
    for (field in fields) field.applyTo(builder, merge)
  }
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
