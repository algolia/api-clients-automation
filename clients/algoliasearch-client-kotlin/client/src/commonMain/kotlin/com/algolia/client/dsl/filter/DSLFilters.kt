@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.dsl.DSLParameters

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
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLFilters internal constructor(private val nodes: FilterAccumulator<FilterGroup>) :
  DSLFacet by FacetLeafMixin({ nodes.add(it) }),
  DSLTag by TagLeafMixin({ nodes.add(it) }),
  DSLNumeric by NumericLeafMixin({ nodes.add(it) }) {

  public constructor() : this(FilterAccumulator())

  /** Adds an [FilterGroup.And] of the children in [block]. An empty block adds nothing. */
  public fun and(block: DSLFilters.() -> Unit) {
    val children = DSLFilters().apply(block).nodes.snapshot()
    if (children.isNotEmpty()) nodes.add(FilterGroup.And(children))
  }

  /** Adds a [FilterGroup.Or.Facet] of the facet leaves in [block]. An empty block adds nothing. */
  public fun orFacet(block: DSLGroupFacet.() -> Unit) {
    val leaves = DSLGroupFacet().apply(block).snapshot()
    if (leaves.isNotEmpty()) nodes.add(FilterGroup.Or.Facet(leaves))
  }

  /** Adds a [FilterGroup.Or.Tag] of the tag leaves in [block]. An empty block adds nothing. */
  public fun orTag(block: DSLGroupTag.() -> Unit) {
    val leaves = DSLGroupTag().apply(block).snapshot()
    if (leaves.isNotEmpty()) nodes.add(FilterGroup.Or.Tag(leaves))
  }

  /**
   * Adds a [FilterGroup.Or.Numeric] of the numeric leaves in [block]. An empty block adds nothing.
   */
  public fun orNumeric(block: DSLGroupNumeric.() -> Unit) {
    val leaves = DSLGroupNumeric().apply(block).snapshot()
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
public fun filters(block: DSLFilters.() -> Unit): String? =
  FilterSqlConverter(DSLFilters().apply(block).root())

/** OR-context builder for [Filter.Numeric] children. Exposes only numeric leaves. */
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLGroupNumeric
internal constructor(private val leaves: FilterAccumulator<Filter.Numeric>) :
  DSLNumeric by NumericLeafMixin(leaves::add) {

  public constructor() : this(FilterAccumulator())

  internal fun snapshot(): List<Filter.Numeric> = leaves.snapshot()
}

/** OR-context builder for [Filter.Tag] children. Exposes only tag leaves. */
@DSLParameters
@AlgoliaExperimentalDsl
public class DSLGroupTag internal constructor(private val leaves: FilterAccumulator<Filter.Tag>) :
  DSLTag by TagLeafMixin(leaves::add) {

  public constructor() : this(FilterAccumulator())

  internal fun snapshot(): List<Filter.Tag> = leaves.snapshot()
}
