@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * Builds a typed [FilterGroup] tree with a Kotlin DSL.
 *
 * Top-level children are combined with [FilterGroup.And]. Use [orFacet], [orTag], or [orNumeric]
 * for a homogeneous OR. A mixed-family OR does not compile.
 *
 * ```
 * val sql =
 *   filters {
 *     and {
 *       facet("color", "red")
 *       facet("category", "shirt")
 *     }
 *     orNumeric {
 *       range("price", 0 until 10)
 *       comparison("price", NumericOperator.Equals, 15)
 *     }
 *   }
 * ```
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class FilterDsl internal constructor(private val nodes: FilterAccumulator<FilterGroup>) :
  FacetLeaves by FacetLeafMixin({ nodes.add(it) }),
  TagLeaves by TagLeafMixin({ nodes.add(it) }),
  NumericLeaves by NumericLeafMixin({ nodes.add(it) }) {

  public constructor() : this(FilterAccumulator())

  /** Adds an [FilterGroup.And] of the children in [block]. */
  public fun and(block: FilterDsl.() -> Unit) {
    nodes.add(FilterGroup.And(FilterDsl().apply(block).nodes.snapshot()))
  }

  /** Adds a [FilterGroup.Or.Facet] of the facet leaves in [block]. */
  public fun orFacet(block: FacetOrDsl.() -> Unit) {
    nodes.add(FilterGroup.Or.Facet(FacetOrDsl().apply(block).snapshot()))
  }

  /** Adds a [FilterGroup.Or.Tag] of the tag leaves in [block]. */
  public fun orTag(block: TagOrDsl.() -> Unit) {
    nodes.add(FilterGroup.Or.Tag(TagOrDsl().apply(block).snapshot()))
  }

  /** Adds a [FilterGroup.Or.Numeric] of the numeric leaves in [block]. */
  public fun orNumeric(block: NumericOrDsl.() -> Unit) {
    nodes.add(FilterGroup.Or.Numeric(NumericOrDsl().apply(block).snapshot()))
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
  public fun not(block: FilterDsl.() -> Unit) {
    nodes.add(negate(FilterDsl().apply(block).nodes.snapshot()))
  }

  internal fun root(): FilterGroup = nodes.root()
}

/** Constructs a SQL `filters` string from the DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun filters(block: FilterDsl.() -> Unit): String? =
  FilterSqlConverter(FilterDsl().apply(block).root())
