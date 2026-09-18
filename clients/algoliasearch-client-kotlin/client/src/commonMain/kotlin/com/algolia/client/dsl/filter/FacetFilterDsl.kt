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

  /** Adds a typed [FilterGroup.Not] of the children in [block]. */
  public fun not(block: FacetFilterDsl.() -> Unit) {
    nodes.add(negate(FacetFilterDsl().apply(block).nodes.snapshot()))
  }

  internal fun root(): FilterGroup = nodes.root()
}

/**
 * OR-context builder for [FacetAtom] children. Exposes only facet leaves and [not]. An empty [not]
 * block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FacetOrDsl internal constructor(private val nodes: FilterAccumulator<FacetAtom>) :
  FacetLeaves by FacetLeafMixin(nodes::add) {

  public constructor() : this(FilterAccumulator())

  /**
   * Negates every facet atom collected in [block] and appends each as its own [FacetAtom].
   *
   * `not { facet(a); facet(b) }` yields two negated atoms. An empty [block] appends nothing.
   */
  public fun not(block: FacetOrDsl.() -> Unit) {
    for (atom in FacetOrDsl().apply(block).snapshot()) {
      nodes.add(negateFacetAtom(atom))
    }
  }

  internal fun snapshot(): List<FacetAtom> = nodes.snapshot()
}

/** Constructs [FacetFilters] from a facet-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun facetFilters(block: FacetFilterDsl.() -> Unit): FacetFilters? =
  FilterLegacyConverter.facet(FacetFilterDsl().apply(block).root())

/** Constructs [OptionalFilters] from a facet-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun optionalFilters(block: FacetFilterDsl.() -> Unit): OptionalFilters? =
  FilterLegacyConverter.optional(FacetFilterDsl().apply(block).root())
