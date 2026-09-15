@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * Converts a typed [FilterGroup] tree to an Algolia `filters` SQL string.
 *
 * Matches version 2 `FilterGroupsConverter.SQL` leaf syntax (`attribute:value`, `_tags:value`,
 * `attribute op number`, `attribute:lower TO upper`, `attribute:value<score=N>`) and group joining
 * (`AND` / `OR` / `NOT`). Empty [FilterGroup.And] and [FilterGroup.Or] groups become `null` so
 * `SearchParamsObject.filters` can stay omitted.
 *
 * [FilterGroup.Or] carries its family in the type. This converter performs no family check.
 *
 * Attributes and values are quoted when they contain spaces, quotes, or the keywords `AND`, `OR`,
 * or `NOT`.
 *
 * [Documentation](https://www.algolia.com/doc/api-reference/api-parameters/filters/)
 */
@AlgoliaExperimentalDsl
public object FilterSqlConverter {

  /**
   * Returns the SQL `filters` string for [root], or `null` when [root] is an empty
   * [FilterGroup.And] or [FilterGroup.Or] (including an `And` / `Or` whose children are all empty).
   */
  public operator fun invoke(root: FilterGroup): String? = emit(root)

  private fun emit(node: FilterGroup): String? {
    return when (node) {
      is Filter.Facet -> emitFacet(node)
      is Filter.Tag -> emitTag(node)
      is Filter.Comparison -> emitComparison(node)
      is Filter.Range -> emitRange(node)
      is FilterGroup.And -> emitAnd(node)
      is FilterGroup.Or -> emitOr(node)
      is FilterGroup.Not -> emitNot(node)
    }
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

  private fun emitAnd(group: FilterGroup.And): String? {
    val parts = group.children.mapNotNull(::emit)
    if (parts.isEmpty()) return null
    return parts.joinToString(separator = " AND ", prefix = "(", postfix = ")")
  }

  private fun emitOr(group: FilterGroup.Or): String? {
    if (group.children.isEmpty()) return null
    val parts = group.children.map(::requireEmit)
    return parts.joinToString(separator = " OR ", prefix = "(", postfix = ")")
  }

  private fun emitNot(group: FilterGroup.Not): String {
    val child = group.child
    val inner = requireEmit(child)
    return when (child) {
      is FilterGroup.And,
      is FilterGroup.Or -> "NOT $inner"
      is FilterGroup.Not -> "NOT ($inner)"
      else -> "NOT $inner"
    }
  }

  private fun requireEmit(node: FilterGroup): String =
    emit(node)
      ?: throw IllegalArgumentException("FilterGroup.Not cannot wrap an empty And or Or group.")
}
