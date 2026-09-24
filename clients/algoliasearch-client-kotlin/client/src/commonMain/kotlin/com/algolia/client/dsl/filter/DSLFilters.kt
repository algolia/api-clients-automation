@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.dsl.DSLParameters

/**
 * Collects `filters` rows with a Kotlin DSL: the outer list is `AND`, each inner row is `OR`.
 *
 * Top-level filters are `AND`ed in call order. Use [orFacet], [orTag], or [orNumeric] for a
 * homogeneous OR. A mixed-family OR does not compile. The example encodes as `color:red AND
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
public class DSLFilters private constructor(private val rows: MutableList<List<Filter>>) :
  DSLFacet by FacetLeafMixin({ rows.add(listOf(it)) }),
  DSLTag by TagLeafMixin({ rows.add(listOf(it)) }),
  DSLNumeric by NumericLeafMixin({ rows.add(listOf(it)) }) {

  internal constructor() : this(mutableListOf())

  /** ANDs the filters in [block] into this block. An empty block adds nothing. */
  public fun and(block: DSLFilters.() -> Unit) {
    rows.addAll(DSLFilters().apply(block).rows)
  }

  /** Adds `(a OR b …)` of the facet leaves in [block]. An empty block adds nothing. */
  public fun orFacet(block: DSLGroupFacet.() -> Unit) {
    DSLGroupFacet().apply(block).leaves().takeIf { it.isNotEmpty() }?.let { rows.add(it) }
  }

  /** Adds `(a OR b …)` of the tag leaves in [block]. An empty block adds nothing. */
  public fun orTag(block: DSLGroupTag.() -> Unit) {
    DSLGroupTag().apply(block).leaves().takeIf { it.isNotEmpty() }?.let { rows.add(it) }
  }

  /** Adds `(a OR b …)` of the numeric leaves in [block]. An empty block adds nothing. */
  public fun orNumeric(block: DSLGroupNumeric.() -> Unit) {
    DSLGroupNumeric().apply(block).leaves().takeIf { it.isNotEmpty() }?.let { rows.add(it) }
  }

  internal fun rows(): List<List<Filter>> = rows.toList()
}

/**
 * Constructs a SQL `filters` string from the DSL block, or `null` when the block is empty.
 *
 * `NOT` only precedes a single filter (`isNegated`), nested `and { }` blocks are flattened, the
 * top-level `AND` is never parenthesised, and each `OR` holds one filter family by construction.
 */
@AlgoliaExperimentalDsl
public fun filters(block: DSLFilters.() -> Unit): String? =
  FiltersEncoder(DSLFilters().apply(block).rows())
