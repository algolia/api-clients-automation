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
   * Negates the children in [block].
   *
   * One child gets unary `!`: a leaf toggles its [Filter.negated] flag (`not { facet("a", "b") }`
   * builds the same tree as `!Filter.Facet("a", "b")`), a nested `not { }` is unwrapped so `not {
   * not { … } }` is the positive node, and an `and { }`, `orFacet { }`, `orTag { }`, or `orNumeric
   * { }` group is wrapped in [FilterGroup.Not]. Several children are wrapped as [FilterGroup.Not]
   * of an [FilterGroup.And]. An empty block adds nothing. Both encoders emit a toggled leaf and a
   * [FilterGroup.Not] over that leaf identically.
   */
  public fun not(block: FilterDsl.() -> Unit) {
    negate(FilterDsl().apply(block).nodes.snapshot())?.let(nodes::add)
  }

  internal fun root(): FilterGroup = nodes.root()
}

/** Constructs a SQL `filters` string from the DSL block, or `null` when the block is empty. */
@AlgoliaExperimentalDsl
public fun filters(block: FilterDsl.() -> Unit): String? =
  FilterSqlConverter(FilterDsl().apply(block).root())
