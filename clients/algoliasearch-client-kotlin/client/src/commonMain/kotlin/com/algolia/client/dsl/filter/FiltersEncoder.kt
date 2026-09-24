@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * Encodes filter rows (outer list `AND`, inner list `OR`) to an Algolia `filters` SQL string.
 *
 * Leaf syntax matches version 2 `FilterConverter.SQL` (`attribute:value`, `_tags:value`, `attribute
 * op number`, `attribute:lower TO upper`, `attribute:value<score=N>`, `NOT <leaf>`). Rows are the
 * same shape [OptionalFiltersEncoder] takes, so both encoders produce the same AND/OR structure and
 * leaf polarity (leaf text differs: this encoder quotes and writes `NOT <leaf>`, while the
 * optionalFilters encoder never quotes and writes `-` after the colon):
 * - `NOT` only precedes a single leaf whose [Filter.negated] is `true`. Groups are never negated:
 *   the engine rejects `NOT (…)`.
 * - The `AND` is flat and never parenthesised: the engine only allows `(X OR Y) AND Z` and rejects
 *   nested groups.
 * - A row of two or more filters is parenthesised: `(a OR b)`. Each row holds one filter family by
 *   construction: the engine rejects mixed families in one `OR`.
 * - No rows encode as `null`.
 *
 * Attributes and values are quoted when they contain spaces, quotes, or the keywords `AND`, `OR`,
 * or `NOT`.
 *
 * [Documentation](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/combining-boolean-operators/)
 */
internal object FiltersEncoder {

  /** Returns the SQL `filters` string for [rows], or `null` when there is no row. */
  operator fun invoke(rows: List<List<Filter>>): String? =
    if (rows.isEmpty()) null else rows.joinToString(" AND ") { emitRow(it) }

  private fun emitRow(row: List<Filter>): String {
    if (row.size == 1) return emitLeaf(row.single())
    return row.joinToString(separator = " OR ", prefix = "(", postfix = ")") { emitLeaf(it) }
  }

  private fun emitLeaf(filter: Filter): String {
    val text =
      when (filter) {
        is Filter.Facet -> emitFacet(filter)
        is Filter.Tag -> emitTag(filter)
        is Filter.Comparison -> emitComparison(filter)
        is Filter.Range -> emitRange(filter)
      }
    return if (filter.negated) "NOT $text" else text
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
