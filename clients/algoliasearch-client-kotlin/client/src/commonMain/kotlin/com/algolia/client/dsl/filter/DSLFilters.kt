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
 * In delete-by filters, a group block that adds no filter throws [IllegalArgumentException] instead
 * of adding nothing: dropping it would widen the delete.
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
public class DSLFilters
private constructor(private val rows: MutableList<List<Filter>>, private val strict: Boolean) :
  DSLFacet by FacetLeafMixin({ rows.add(listOf(it)) }),
  DSLTag by TagLeafMixin({ rows.add(listOf(it)) }),
  DSLNumeric by NumericLeafMixin({ rows.add(listOf(it)) }) {

  /** [strict]: an empty group block throws instead of adding nothing (delete-by filters). */
  internal constructor(strict: Boolean = false) : this(mutableListOf(), strict)

  /** ANDs the filters in [block] into this block. An empty block adds nothing. */
  public fun and(block: DSLFilters.() -> Unit) {
    val added = DSLFilters(strict).apply(block).rows
    require(!strict || added.isNotEmpty()) { widensDelete("and { }") }
    rows.addAll(added)
  }

  /** Adds `(a OR b …)` of the facet leaves in [block]. An empty block adds nothing. */
  public fun orFacet(block: DSLGroupFacet.() -> Unit) {
    addGroup("orFacet { }", DSLGroupFacet().apply(block).leaves())
  }

  /** Adds `(a OR b …)` of the tag leaves in [block]. An empty block adds nothing. */
  public fun orTag(block: DSLGroupTag.() -> Unit) {
    addGroup("orTag { }", DSLGroupTag().apply(block).leaves())
  }

  /** Adds `(a OR b …)` of the numeric leaves in [block]. An empty block adds nothing. */
  public fun orNumeric(block: DSLGroupNumeric.() -> Unit) {
    addGroup("orNumeric { }", DSLGroupNumeric().apply(block).leaves())
  }

  private fun addGroup(construct: String, leaves: List<Filter>) {
    require(!strict || leaves.isNotEmpty()) { widensDelete(construct) }
    if (leaves.isNotEmpty()) rows.add(leaves)
  }

  internal fun addRows(seed: List<List<Filter>>) {
    rows.addAll(seed)
  }

  internal fun rowCount(): Int = rows.size

  internal fun rows(): List<List<Filter>> = rows.toList()
}

internal fun widensDelete(construct: String): String =
  "deleteBy filters: $construct added no filter; dropping it would widen the delete. " +
    "Skip the delete when there is nothing to match."

/**
 * Constructs a SQL `filters` string from the DSL block, or `null` when the block is empty.
 *
 * `NOT` only precedes a single filter (`isNegated`), nested `and { }` blocks are flattened, the
 * top-level `AND` is never parenthesised, and each `OR` holds one filter family by construction.
 */
@AlgoliaExperimentalDsl
public fun filters(block: DSLFilters.() -> Unit): String? = writeFilters(block).value

internal fun writeFilters(block: DSLFilters.() -> Unit): FilterWrite<String, Filter> {
  val rows = DSLFilters().apply(block).rows()
  return FilterWrite(FiltersEncoder(rows), rows)
}

/**
 * [writeFilters] for delete-by: throws [IllegalArgumentException] when the block, or any group
 * block in it, adds no filter, since dropping it would widen the delete.
 */
internal fun writeDeleteByFilters(block: DSLFilters.() -> Unit): FilterWrite<String, Filter> {
  val rows = DSLFilters(strict = true).apply(block).rows()
  require(rows.isNotEmpty()) { widensDelete("filters { }") }
  return FilterWrite(FiltersEncoder(rows), rows)
}
