@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.OptionalFilters

/** AND-context builder for [Filter.Facet] leaves and [FilterGroup.Or.Facet] groups. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FacetFilterDsl internal constructor(private val core: FamilyAndBuilder<Filter.Facet>) :
  FacetLeaves by FacetLeafMixin(core::add) {

  public constructor() : this(FamilyAndBuilder<Filter.Facet> { FilterGroup.Or.Facet(it) })

  /**
   * Adds an [FilterGroup.And] of the children in [block]. An empty block adds nothing. The encoders
   * flatten it into the enclosing `AND`, so `optionalFilters { and { a; b }; or { c; d } }` encodes
   * as `[[a], [b], [c, d]]`.
   */
  public fun and(block: FacetFilterDsl.() -> Unit) {
    core.and(FacetFilterDsl().apply(block).core.snapshot())
  }

  /** Adds a [FilterGroup.Or.Facet] of the facet leaves in [block]. An empty block adds nothing. */
  public fun or(block: FacetOrDsl.() -> Unit) {
    core.or(FacetOrDsl().apply(block).snapshot())
  }

  internal fun root(): FilterGroup = core.root()
}

/** OR-context builder for [Filter.Facet] children. Exposes only facet leaves. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FacetOrDsl internal constructor(private val leaves: FilterAccumulator<Filter.Facet>) :
  FacetLeaves by FacetLeafMixin(leaves::add) {

  public constructor() : this(FilterAccumulator())

  internal fun snapshot(): List<Filter.Facet> = leaves.snapshot()
}

/** Constructs [OptionalFilters] from a facet-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun optionalFilters(block: FacetFilterDsl.() -> Unit): OptionalFilters? =
  FilterLegacyConverter.optional(FacetFilterDsl().apply(block).root())
