@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.FacetFilters
import com.algolia.client.model.search.OptionalFilters

/** AND-context builder for [Filter.Facet] leaves and [FilterGroup.Or.Facet] groups. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FacetFilterDsl
internal constructor(private val nodes: FilterAccumulator<FilterGroup>) :
  FacetLeaves by FacetLeafMixin({ nodes.add(it) }) {

  public constructor() : this(FilterAccumulator())

  /** Adds a [FilterGroup.Or.Facet] of the facet leaves in [block]. */
  public fun or(block: FacetOrDsl.() -> Unit) {
    nodes.add(FilterGroup.Or.Facet(FacetOrDsl().apply(block).snapshot()))
  }

  /**
   * Adds a [FilterGroup.Not] of the children in [block].
   *
   * One child is wrapped as-is (a leaf under `not { }` stays a leaf inside a [FilterGroup.Not]; its
   * [Filter.negated] flag is not toggled). Several children are wrapped as [FilterGroup.Not] of an
   * [FilterGroup.And]. When the only child is itself a [FilterGroup.Not], it is unwrapped, so `not
   * { not { … } }` is the positive group. An empty block adds a [FilterGroup.Not] of an empty
   * [FilterGroup.And]: [filters] throws, the legacy builders encode nothing.
   */
  public fun not(block: FacetFilterDsl.() -> Unit) {
    nodes.add(negate(FacetFilterDsl().apply(block).nodes.snapshot()))
  }

  internal fun root(): FilterGroup = nodes.root()
}

/**
 * OR-context builder for [Filter.Facet] children. Exposes only facet leaves and [not]. An empty
 * [not] block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FacetOrDsl internal constructor(private val nodes: FilterAccumulator<Filter.Facet>) :
  FacetLeaves by FacetLeafMixin(nodes::add) {

  public constructor() : this(FilterAccumulator())

  /**
   * Toggles [Filter.negated] on every facet leaf collected in [block] and appends each one.
   *
   * `not { facet(a); facet(b) }` yields two negated leaves (`NOT a OR NOT b` inside the OR); `not {
   * not { facet(a) } }` yields the positive leaf. An empty [block] appends nothing.
   */
  public fun not(block: FacetOrDsl.() -> Unit) {
    for (leaf in FacetOrDsl().apply(block).snapshot()) nodes.add(!leaf)
  }

  internal fun snapshot(): List<Filter.Facet> = nodes.snapshot()
}

/** Constructs [FacetFilters] from a facet-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun facetFilters(block: FacetFilterDsl.() -> Unit): FacetFilters? =
  FilterLegacyConverter.facet(FacetFilterDsl().apply(block).root())

/** Constructs [OptionalFilters] from a facet-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun optionalFilters(block: FacetFilterDsl.() -> Unit): OptionalFilters? =
  FilterLegacyConverter.optional(FacetFilterDsl().apply(block).root())
