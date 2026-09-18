@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.NumericFilters

/** AND-context builder for numeric leaves and [FilterGroup.Or.Numeric] groups. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class NumericFilterDsl
internal constructor(private val nodes: FilterAccumulator<FilterGroup>) :
  NumericLeaves by NumericLeafMixin({ nodes.add(it) }) {

  public constructor() : this(FilterAccumulator())

  /** Adds a [FilterGroup.Or.Numeric] of the numeric leaves in [block]. */
  public fun or(block: NumericOrDsl.() -> Unit) {
    nodes.add(FilterGroup.Or.Numeric(NumericOrDsl().apply(block).snapshot()))
  }

  /** Adds a typed [FilterGroup.Not] of the children in [block]. */
  public fun not(block: NumericFilterDsl.() -> Unit) {
    nodes.add(negate(NumericFilterDsl().apply(block).nodes.snapshot()))
  }

  internal fun root(): FilterGroup = nodes.root()
}

/**
 * OR-context builder for [NumericAtom] children. Exposes only numeric leaves and [not]. An empty
 * [not] block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class NumericOrDsl internal constructor(private val nodes: FilterAccumulator<NumericAtom>) :
  NumericLeaves by NumericLeafMixin(nodes::add) {

  public constructor() : this(FilterAccumulator())

  /**
   * Negates every numeric atom collected in [block] and appends each as its own [NumericAtom].
   *
   * An empty [block] appends nothing.
   */
  public fun not(block: NumericOrDsl.() -> Unit) {
    for (atom in NumericOrDsl().apply(block).snapshot()) {
      nodes.add(negateNumericAtom(atom))
    }
  }

  internal fun snapshot(): List<NumericAtom> = nodes.snapshot()
}

/** Constructs [NumericFilters] from a numeric-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun numericFilters(block: NumericFilterDsl.() -> Unit): NumericFilters? =
  FilterLegacyConverter.numeric(NumericFilterDsl().apply(block).root())
