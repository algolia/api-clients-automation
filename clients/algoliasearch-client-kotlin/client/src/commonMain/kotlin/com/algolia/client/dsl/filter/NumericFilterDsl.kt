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

  /**
   * Adds a [FilterGroup.Not] of the children in [block]. One child is wrapped as-is (a leaf under
   * `not { }` stays a leaf inside a [FilterGroup.Not]; its [Filter.negated] flag is not toggled).
   * Several children are wrapped as [FilterGroup.Not] of an [FilterGroup.And]. When the only child
   * is itself a [FilterGroup.Not], it is unwrapped, so `not { not { … } }` is the positive group.
   * An empty block adds a [FilterGroup.Not] of an empty [FilterGroup.And]: [filters] throws, the
   * legacy builders encode nothing.
   */
  public fun not(block: NumericFilterDsl.() -> Unit) {
    nodes.add(negate(NumericFilterDsl().apply(block).nodes.snapshot()))
  }

  internal fun root(): FilterGroup = nodes.root()
}

/**
 * OR-context builder for [Filter.Numeric] children. Exposes only numeric leaves and [not]. An empty
 * [not] block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class NumericOrDsl
internal constructor(private val nodes: FilterAccumulator<Filter.Numeric>) :
  NumericLeaves by NumericLeafMixin(nodes::add) {

  public constructor() : this(FilterAccumulator())

  /**
   * Toggles [Filter.negated] on every numeric leaf collected in [block] and appends each one.
   *
   * `not { range(a); comparison(b) }` yields two negated leaves (`NOT a OR NOT b` inside the OR);
   * `not { not { range(a) } }` yields the positive leaf. An empty [block] appends nothing.
   */
  public fun not(block: NumericOrDsl.() -> Unit) {
    for (leaf in NumericOrDsl().apply(block).snapshot()) nodes.add(!leaf)
  }

  internal fun snapshot(): List<Filter.Numeric> = nodes.snapshot()
}

/** Constructs [NumericFilters] from a numeric-only DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun numericFilters(block: NumericFilterDsl.() -> Unit): NumericFilters? =
  FilterLegacyConverter.numeric(NumericFilterDsl().apply(block).root())
