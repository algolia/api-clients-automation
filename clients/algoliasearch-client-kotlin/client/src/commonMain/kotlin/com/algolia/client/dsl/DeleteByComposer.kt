@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.DSLFilters
import com.algolia.client.model.search.DeleteByParams

/**
 * Collects delete-by filter fragments from several modules and builds one [DeleteByParams].
 *
 * Delete-by twin of [QueryComposer]: filters only, since [DeleteByParams] has no list fields.
 *
 * [add] and [override] only store their blocks; nothing runs until [build]. Each [build] runs every
 * stored [add] block, then writes `filters` once: all `filters { }` fragments run inside one
 * [DSLFilters] (so they are AND-ed). Then every [override] block runs on the same
 * [DeleteByBuilder], in call order: last write wins, so an override that sets `filters` replaces
 * the accumulated value. Geo fields (`aroundLatLng`, `aroundRadius`, `insideBoundingBox`,
 * `insidePolygon`) have no additive form; set them in [override]. Empty fragments leave the field
 * omitted.
 *
 * Every [build] re-evaluates every stored block, so values captured by reference (a `var`, a
 * mutable list) are read at build time and side effects in a block repeat on each build. [build]
 * can be called repeatedly. Not thread-safe.
 *
 * ```
 * val composer = DeleteByComposer()
 * composer.add { filters { facet("locale", "en-US") } }
 * composer.add { filters { facet("entityId", "x", isNegated = true) } }
 * composer.override { aroundLatLng = "40.71,-74.01" }
 * val params = composer.build() // filters = "locale:en-US AND NOT entityId:x"
 * ```
 */
@DSLParameters
@AlgoliaExperimentalDsl
public class DeleteByComposer public constructor() {
  private val additions: MutableList<DeleteByAdditions.() -> Unit> = mutableListOf()
  private val overrides: MutableList<DeleteByBuilder.() -> Unit> = mutableListOf()

  /**
   * Stores [block]. It runs on every [build], before the overrides; captured values are read then.
   */
  public fun add(block: DeleteByAdditions.() -> Unit) {
    additions += block
  }

  /** Stores [block]. It runs on every [build], after the additive fields. Last write wins. */
  public fun override(block: DeleteByBuilder.() -> Unit) {
    overrides += block
  }

  /**
   * Builds a [DeleteByParams] from fresh state: runs every stored [add] block, writes each filter
   * field once, then runs every stored [override] block in call order.
   */
  public fun build(): DeleteByParams {
    val collected = DeleteByAdditions()
    for (block in additions) collected.block()
    val builder = DeleteByBuilder()
    collected.applyTo(builder)
    for (block in overrides) builder.block()
    return builder.build()
  }
}

/**
 * Additive receiver of [DeleteByComposer.add], created fresh on every [DeleteByComposer.build].
 * Each method records its block for that field; the blocks for a field run together, in call order,
 * inside one receiver when the field is written.
 */
@DSLParameters
@AlgoliaExperimentalDsl
public class DeleteByAdditions internal constructor() {
  private val filterBlocks: Blocks<DSLFilters> = Blocks()

  /** Records a `filters` fragment. All fragments run inside one [DSLFilters] at build time. */
  public fun filters(block: DSLFilters.() -> Unit) {
    filterBlocks.add(block)
  }

  /**
   * Writes each field with at least one recorded block once, through the generated
   * [DeleteByBuilder] member helper, so the helper's rules (empty → `null`) apply unchanged. The
   * [Blocks] are bound to locals first: the `@DSLParameters` marker hides this receiver inside the
   * nested filter blocks.
   */
  internal fun applyTo(builder: DeleteByBuilder) {
    val filters = filterBlocks
    if (!filters.isEmpty()) builder.filters { filters.replay(this) }
  }
}

/**
 * Composes a [DeleteByParams] in one expression: `DeleteByComposer().apply(block).build()`.
 *
 * ```
 * val params =
 *   composeDeleteBy {
 *     add { filters { facet("locale", "en-US") } }
 *     override { aroundLatLng = "40.71,-74.01" }
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public fun composeDeleteBy(block: DeleteByComposer.() -> Unit): DeleteByParams {
  return DeleteByComposer().apply(block).build()
}
