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
 * [FilterGroup.Or] has no compile-time leaf kind. This converter classifies children at runtime:
 * - An `Or` may contain only leaves of one family: all [Filter.Facet], all [Filter.Tag], or all
 *   numeric ([Filter.Comparison] / [Filter.Range]). [FilterGroup.Not] around a leaf stays in that
 *   leaf's family.
 * - Mixed-type `Or` throws [IllegalArgumentException].
 * - `Or` of nested [FilterGroup.And] or [FilterGroup.Or] throws [IllegalArgumentException]. The
 *   Algolia `filters` grammar does not allow OR of conjunctions or nested disjunctions.
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
    val attribute = quote(filter.attribute)
    val value = quote(filter.value)
    val score = filter.score?.let { "<score=$it>" }.orEmpty()
    return "$attribute:$value$score"
  }

  private fun emitTag(filter: Filter.Tag): String = "_tags:${quote(filter.value)}"

  private fun emitComparison(filter: Filter.Comparison): String =
    "${quote(filter.attribute)} ${filter.operator.raw} ${filter.value}"

  private fun emitRange(filter: Filter.Range): String =
    "${quote(filter.attribute)}:${filter.lowerBound} TO ${filter.upperBound}"

  private fun emitAnd(group: FilterGroup.And): String? {
    val parts = group.children.mapNotNull(::emit)
    if (parts.isEmpty()) return null
    return parts.joinToString(separator = " AND ", prefix = "(", postfix = ")")
  }

  private fun emitOr(group: FilterGroup.Or): String? {
    if (group.children.isEmpty()) return null
    validateOr(group)
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
      ?: throw IllegalArgumentException(
        "FilterGroup.Not and FilterGroup.Or cannot wrap an empty And or Or group."
      )

  private fun validateOr(group: FilterGroup.Or) {
    val families = group.children.map(::orFamily)
    val unique = families.distinct()
    if (unique.size > 1) {
      throw IllegalArgumentException(
        "Or may contain only leaves of one family: all Facet, all Tag, or all " +
          "Comparison/Range (numeric). This Or mixes ${unique.joinToString(" and ")}."
      )
    }
  }

  /**
   * Classifies an `Or` child. [FilterGroup.Not] unwraps to the inner leaf family. Nested `And` /
   * `Or` cannot be encoded in Algolia `filters` SQL.
   */
  private fun orFamily(node: FilterGroup): OrFamily {
    return when (node) {
      is Filter.Facet -> OrFamily.Facet
      is Filter.Tag -> OrFamily.Tag
      is Filter.Comparison,
      is Filter.Range -> OrFamily.Numeric
      is FilterGroup.Not -> orFamily(node.child)
      is FilterGroup.And ->
        throw IllegalArgumentException(
          "Or cannot contain nested And groups. The Algolia filters grammar does not allow OR of conjunctions."
        )
      is FilterGroup.Or ->
        throw IllegalArgumentException(
          "Or cannot contain nested Or groups. The Algolia filters grammar does not allow nested disjunctions."
        )
    }
  }

  private fun quote(raw: String): String {
    if (!needsQuotes(raw)) return raw
    return "\"${raw.replace("\"", "\\\"")}\""
  }

  private fun needsQuotes(raw: String): Boolean {
    if (raw.isEmpty()) return true
    if (raw.any { it == ' ' || it == '"' || it == '\'' }) return true
    return KEYWORD.containsMatchIn(raw)
  }

  private enum class OrFamily {
    Facet,
    Tag,
    Numeric,
  }

  private val KEYWORD: Regex = Regex("(?i)\\b(?:AND|OR|NOT)\\b")
}
