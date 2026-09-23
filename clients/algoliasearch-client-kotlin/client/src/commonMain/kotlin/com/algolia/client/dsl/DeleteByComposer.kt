@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FacetFilterDsl
import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.dsl.filter.NumericFilterDsl
import com.algolia.client.dsl.filter.TagFilterDsl
import com.algolia.client.model.search.DeleteByParams

/**
 * Collects delete-by filter fragments from several modules and builds one [DeleteByParams].
 *
 * Delete-by twin of [QueryComposer]: filters only, since [DeleteByParams] has no list fields.
 *
 * [add] and [override] only store their blocks; nothing runs until [build]. Each [build] runs every
 * stored [add] block, then writes each filter field once: all `filters { }` fragments run inside
 * one [FilterDsl] (so they are AND-ed), all `facetFilters { }` fragments inside one
 * [FacetFilterDsl], and so on. Then every [override] block runs on the same [DeleteByBuilder], in
 * call order: last write wins, so an override that sets `filters` replaces the accumulated value.
 * Geo fields (`aroundLatLng`, `aroundRadius`, `insideBoundingBox`, `insidePolygon`) have no
 * additive form; set them in [override]. Empty fragments leave the field omitted.
 *
 * Every [build] re-evaluates every stored block, so values captured by reference (a `var`, a
 * mutable list) are read at build time and side effects in a block repeat on each build. [build]
 * can be called repeatedly and may throw [IllegalArgumentException] for a filter tree Algolia
 * cannot express (see [DeleteByBuilder.filters]). Not thread-safe.
 *
 * ```
 * val composer = DeleteByComposer()
 * composer.add { filters { facet("locale", "en-US") } }
 * composer.add { filters { facet("entityId", "x", isNegated = true) } }
 * composer.override { aroundLatLng = "40.71,-74.01" }
 * val params = composer.build() // filters = "locale:en-US AND NOT entityId:x"
 * ```
 */
@AlgoliaDsl
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
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class DeleteByAdditions internal constructor() {
  private val filterBlocks: Blocks<FilterDsl> = Blocks()
  private val facetFilterBlocks: Blocks<FacetFilterDsl> = Blocks()
  private val numericFilterBlocks: Blocks<NumericFilterDsl> = Blocks()
  private val tagFilterBlocks: Blocks<TagFilterDsl> = Blocks()

  /** Records a `filters` fragment. All fragments run inside one [FilterDsl] at build time. */
  public fun filters(block: FilterDsl.() -> Unit) {
    filterBlocks.add(block)
  }

  /**
   * Records a `facetFilters` fragment. All fragments run inside one [FacetFilterDsl] at build time.
   */
  public fun facetFilters(block: FacetFilterDsl.() -> Unit) {
    facetFilterBlocks.add(block)
  }

  /**
   * Records a `numericFilters` fragment. All fragments run inside one [NumericFilterDsl] at build
   * time.
   */
  public fun numericFilters(block: NumericFilterDsl.() -> Unit) {
    numericFilterBlocks.add(block)
  }

  /** Records a `tagFilters` fragment. All fragments run inside one [TagFilterDsl] at build time. */
  public fun tagFilters(block: TagFilterDsl.() -> Unit) {
    tagFilterBlocks.add(block)
  }

  /**
   * Writes each field with at least one recorded block once, through the generated
   * [DeleteByBuilder] member helper, so the helper's rules (empty → `null`, filter-tree rejects)
   * apply unchanged. The [Blocks] are bound to locals first: the `@AlgoliaDsl` marker hides this
   * receiver inside the nested filter blocks.
   */
  internal fun applyTo(builder: DeleteByBuilder) {
    val filters = filterBlocks
    if (!filters.isEmpty()) builder.filters { filters.replay(this) }
    val facetFilters = facetFilterBlocks
    if (!facetFilters.isEmpty()) builder.facetFilters { facetFilters.replay(this) }
    val numericFilters = numericFilterBlocks
    if (!numericFilters.isEmpty()) builder.numericFilters { numericFilters.replay(this) }
    val tagFilters = tagFilterBlocks
    if (!tagFilters.isEmpty()) builder.tagFilters { tagFilters.replay(this) }
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
