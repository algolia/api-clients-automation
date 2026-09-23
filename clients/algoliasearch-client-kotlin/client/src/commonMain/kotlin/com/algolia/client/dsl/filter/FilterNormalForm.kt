@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl

/** A leaf with its effective polarity once every [FilterGroup.Not] is pushed down to it. */
internal data class Literal(val filter: Filter, val negated: Boolean)

internal enum class FilterFamily {
  Facet,
  Numeric,
  Tag,
}

internal fun familyOf(filter: Filter): FilterFamily =
  when (filter) {
    is Filter.Facet -> FilterFamily.Facet
    is Filter.Tag -> FilterFamily.Tag
    is Filter.Comparison,
    is Filter.Range -> FilterFamily.Numeric
  }

/**
 * Conjunctive normal form of [root]: the outer list is `AND`, each inner list is an `OR` of
 * literals. `NOT` is pushed down to the leaves with De Morgan, nested `AND`s are flattened, and
 * empty groups contribute no row. No row is empty.
 *
 * Throws [IllegalArgumentException] when a negated [FilterGroup.And] expands to an `OR` of `AND`s
 * (for example `NOT ((a OR b) AND c)`), which neither `filters` nor the nested-list parameters can
 * express.
 */
internal fun conjunctiveRows(root: FilterGroup): List<List<Literal>> = rows(root, negated = false)

private fun rows(node: FilterGroup, negated: Boolean): List<List<Literal>> =
  when (node) {
    is Filter -> listOf(listOf(Literal(node, negated xor node.negated)))
    is FilterGroup.Not -> rows(node.child, !negated)
    is FilterGroup.And ->
      if (negated) negatedAndRows(node.children)
      else node.children.flatMap { rows(it, negated = false) }
    is FilterGroup.Or ->
      when {
        node.children.isEmpty() -> emptyList()
        negated -> node.children.map { listOf(Literal(it, !it.negated)) }
        else -> listOf(node.children.map { Literal(it, it.negated) })
      }
  }

/**
 * De Morgan for a negated [FilterGroup.And]: `NOT (a AND b)` is the single row `NOT a OR NOT b`.
 * Children with no row are dropped first. One remaining child keeps all its negated rows. With two
 * or more, each must collapse to exactly one row.
 */
private fun negatedAndRows(children: List<FilterGroup>): List<List<Literal>> {
  val expanded = children.map { rows(it, negated = true) }.filter { it.isNotEmpty() }
  if (expanded.size <= 1) return expanded.singleOrNull().orEmpty()
  require(expanded.all { it.size == 1 }) {
    "NOT of an AND that holds a conjunction expands to an OR of ANDs, which Algolia filters " +
      "cannot express."
  }
  return listOf(expanded.flatMap { it.single() })
}
