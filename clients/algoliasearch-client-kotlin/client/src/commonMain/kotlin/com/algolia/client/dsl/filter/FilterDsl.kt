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

  /**
   * Negates the children in [block]. One child gets unary `!` ([FilterGroup.not]); several become
   * [FilterGroup.Not] of an [FilterGroup.And]; an empty block adds nothing.
   */
  public fun not(block: FilterDsl.() -> Unit) {
    negate(FilterDsl().apply(block).nodes.snapshot())?.let(nodes::add)
  }

  internal fun root(): FilterGroup = nodes.root()
}

/**
 * Constructs a SQL `filters` string from the DSL block, or `null` when the block is empty.
 *
 * Negation is pushed down to the leaves (`not { orFacet { a; b } }` → `NOT a AND NOT b`, `not { a;
 * b }` → `(NOT a OR NOT b)`), nested `and { }` blocks are flattened, and the top-level `AND` is
 * never parenthesised. Throws [IllegalArgumentException] when a `not { }` over several children
 * would need an `OR` of `AND`s (for example `not { orFacet { a; b }; c }`) or an `OR` across facet,
 * tag, and numeric filters (for example `not { facet(…); tag(…) }`); Algolia `filters` cannot
 * express either.
 */
@AlgoliaExperimentalDsl
public fun filters(block: FilterDsl.() -> Unit): String? =
  FilterSqlConverter(FilterDsl().apply(block).root())

/**
 * OR-context builder for [Filter.Numeric] children. Exposes only numeric leaves and [not]. An empty
 * [not] block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class NumericOrDsl internal constructor(private val core: FamilyOrBuilder<Filter.Numeric>) :
  NumericLeaves by NumericLeafMixin(core::add) {

  public constructor() : this(FamilyOrBuilder<Filter.Numeric> { !it })

  /**
   * Appends each numeric leaf in [block] with [Filter.negated] toggled: `not { a; b }` contributes
   * `NOT a OR NOT b`. An empty block appends nothing.
   */
  public fun not(block: NumericOrDsl.() -> Unit) {
    core.not(NumericOrDsl().apply(block).snapshot())
  }

  internal fun snapshot(): List<Filter.Numeric> = core.snapshot()
}

/**
 * OR-context builder for [Filter.Tag] children. Exposes only tag leaves and [not]. An empty [not]
 * block appends nothing.
 */
@AlgoliaDsl
@AlgoliaExperimentalDsl
public class TagOrDsl internal constructor(private val core: FamilyOrBuilder<Filter.Tag>) :
  TagLeaves by TagLeafMixin(core::add) {

  public constructor() : this(FamilyOrBuilder<Filter.Tag> { !it })

  /**
   * Appends each tag leaf in [block] with [Filter.negated] toggled: `not { a; b }` contributes `NOT
   * a OR NOT b`. An empty block appends nothing.
   */
  public fun not(block: TagOrDsl.() -> Unit) {
    core.not(TagOrDsl().apply(block).snapshot())
  }

  internal fun snapshot(): List<Filter.Tag> = core.snapshot()
}
