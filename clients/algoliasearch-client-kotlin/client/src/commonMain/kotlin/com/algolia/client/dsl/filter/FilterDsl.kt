@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaDsl
import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * Builds a typed [FilterGroup] tree with a Kotlin DSL.
 *
 * Top-level children are combined with [FilterGroup.And]. Use [orFacet], [orTag], or [orNumeric]
 * for a homogeneous OR. A mixed-family OR does not compile. The example encodes as `color:red AND
 * category:shirt AND (price:0 TO 9 OR price = 15)`.
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

  /** Adds an [FilterGroup.And] of the children in [block]. An empty block adds nothing. */
  public fun and(block: FilterDsl.() -> Unit) {
    val children = FilterDsl().apply(block).nodes.snapshot()
    if (children.isNotEmpty()) nodes.add(FilterGroup.And(children))
  }

  /** Adds a [FilterGroup.Or.Facet] of the facet leaves in [block]. An empty block adds nothing. */
  public fun orFacet(block: FacetOrDsl.() -> Unit) {
    val leaves = FacetOrDsl().apply(block).snapshot()
    if (leaves.isNotEmpty()) nodes.add(FilterGroup.Or.Facet(leaves))
  }

  /** Adds a [FilterGroup.Or.Tag] of the tag leaves in [block]. An empty block adds nothing. */
  public fun orTag(block: TagOrDsl.() -> Unit) {
    val leaves = TagOrDsl().apply(block).snapshot()
    if (leaves.isNotEmpty()) nodes.add(FilterGroup.Or.Tag(leaves))
  }

  /**
   * Adds a [FilterGroup.Or.Numeric] of the numeric leaves in [block]. An empty block adds nothing.
   */
  public fun orNumeric(block: NumericOrDsl.() -> Unit) {
    val leaves = NumericOrDsl().apply(block).snapshot()
    if (leaves.isNotEmpty()) nodes.add(FilterGroup.Or.Numeric(leaves))
  }

  internal fun root(): FilterGroup = nodes.root()
}

/**
 * Constructs a SQL `filters` string from the DSL block, or `null` when the block is empty.
 *
 * `NOT` only precedes a single filter (`isNegated`), nested `and { }` blocks are flattened, the
 * top-level `AND` is never parenthesised, and each `OR` holds one filter family by construction.
 */
@AlgoliaExperimentalDsl
public fun filters(block: FilterDsl.() -> Unit): String? =
  FilterSqlConverter(FilterDsl().apply(block).root())

/** OR-context builder for [Filter.Numeric] children. Exposes only numeric leaves. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class NumericOrDsl
internal constructor(private val leaves: FilterAccumulator<Filter.Numeric>) :
  NumericLeaves by NumericLeafMixin(leaves::add) {

  public constructor() : this(FilterAccumulator())

  internal fun snapshot(): List<Filter.Numeric> = leaves.snapshot()
}

/** OR-context builder for [Filter.Tag] children. Exposes only tag leaves. */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class TagOrDsl internal constructor(private val leaves: FilterAccumulator<Filter.Tag>) :
  TagLeaves by TagLeafMixin(leaves::add) {

  public constructor() : this(FilterAccumulator())

  internal fun snapshot(): List<Filter.Tag> = leaves.snapshot()
}
