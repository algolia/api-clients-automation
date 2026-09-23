@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * Converts a typed [FilterGroup] tree to an Algolia `filters` SQL string.
 *
 * Leaf syntax matches version 2 `FilterConverter.SQL` (`attribute:value`, `_tags:value`, `attribute
 * op number`, `attribute:lower TO upper`, `attribute:value<score=N>`, `NOT <leaf>`). The tree first
 * goes through [conjunctiveRows], the same normal form [FilterLegacyConverter] uses, so both
 * encoders produce the same AND/OR shape and leaf polarity on every tree (leaf text differs: a
 * negated [Filter.Range] stays `NOT attr:lo TO hi` here, while the legacy encoder expands it to
 * `attr < lo` / `attr > hi`):
 * - `NOT` only precedes a leaf: `NOT (a OR b)` is `NOT a AND NOT b`, `NOT (a AND b)` is `(NOT a OR
 *   NOT b)`. Algolia does not support negating a group.
 * - Nested [FilterGroup.And]s are flattened and the top-level `AND` is never parenthesised. Algolia
 *   does not support `(A AND (B OR C))`.
 * - An `OR` of two or more filters is parenthesised: `(a OR b)`.
 * - Empty groups contribute nothing; a tree with no filter encodes as `null`.
 *
 * Throws [IllegalArgumentException] when the tree needs an `OR` of `AND`s, or an `OR` that mixes
 * facet, tag, and numeric filters. Algolia supports neither.
 *
 * Attributes and values are quoted when they contain spaces, quotes, or the keywords `AND`, `OR`,
 * or `NOT`.
 *
 * [Documentation](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/combining-boolean-operators/)
 */
internal object FilterSqlConverter {

  /** Returns the SQL `filters` string for [root], or `null` when [root] holds no filter. */
  operator fun invoke(root: FilterGroup): String? {
    val rows = conjunctiveRows(root)
    if (rows.isEmpty()) return null
    return rows.joinToString(separator = " AND ") { emitRow(it) }
  }

  private fun emitRow(row: List<Literal>): String {
    if (row.size == 1) return emitLiteral(row.single())
    val family = familyOf(row.first().filter)
    require(row.all { familyOf(it.filter) == family }) {
      "An OR group cannot mix facet, tag, and numeric filters: $row"
    }
    return row.joinToString(separator = " OR ", prefix = "(", postfix = ")") { emitLiteral(it) }
  }

  private fun emitLiteral(literal: Literal): String {
    val text =
      when (val filter = literal.filter) {
        is Filter.Facet -> emitFacet(filter)
        is Filter.Tag -> emitTag(filter)
        is Filter.Comparison -> emitComparison(filter)
        is Filter.Range -> emitRange(filter)
      }
    return if (literal.negated) "NOT $text" else text
  }

  private fun emitFacet(filter: Filter.Facet): String {
    val attribute = FilterQuote.quote(filter.attribute)
    val value = FilterQuote.quote(filter.value)
    val score = filter.score?.let { "<score=$it>" }.orEmpty()
    return "$attribute:$value$score"
  }

  private fun emitTag(filter: Filter.Tag): String = "_tags:${FilterQuote.quote(filter.value)}"

  private fun emitComparison(filter: Filter.Comparison): String =
    "${FilterQuote.quote(filter.attribute)} ${filter.operator.raw} ${filter.value}"

  private fun emitRange(filter: Filter.Range): String =
    "${FilterQuote.quote(filter.attribute)}:${filter.lowerBound} TO ${filter.upperBound}"
}
