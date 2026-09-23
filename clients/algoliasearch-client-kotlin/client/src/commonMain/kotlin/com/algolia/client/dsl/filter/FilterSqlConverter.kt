@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl

/**
 * Converts a typed [FilterGroup] tree to an Algolia `filters` SQL string.
 *
 * Matches version 2 `FilterGroupsConverter.SQL` leaf syntax (`attribute:value`, `_tags:value`,
 * `attribute op number`, `attribute:lower TO upper`, `attribute:value<score=N>`) and group joining
 * (`AND` / `OR` / `NOT`). Empty [FilterGroup.And] and [FilterGroup.Or] groups become `null` so
 * `SearchParamsObject.filters` can stay omitted. A [FilterGroup.Not] over an empty group is `null`
 * as well. This converter never throws.
 *
 * [FilterGroup.Or] carries its family in the type. This converter performs no family check.
 *
 * A leaf with [Filter.negated] emits `NOT <leaf>`. A [FilterGroup.Not] over an [FilterGroup.And] or
 * [FilterGroup.Or] emits `NOT (<group>)`. A [FilterGroup.Not] over a leaf or over another
 * [FilterGroup.Not] folds into parity (`parity xor leaf.negated`), so `NOT NOT` is never emitted
 * and the result always agrees with [FilterLegacyConverter].
 *
 * Attributes and values are quoted when they contain spaces, quotes, or the keywords `AND`, `OR`,
 * or `NOT`.
 *
 * [Documentation](https://www.algolia.com/doc/api-reference/api-parameters/filters/)
 */
internal object FilterSqlConverter {

  /**
   * Returns the SQL `filters` string for [root], or `null` when [root] is an empty
   * [FilterGroup.And] or [FilterGroup.Or] (including an `And` / `Or` whose children are all empty,
   * or a [FilterGroup.Not] over such a group).
   */
  operator fun invoke(root: FilterGroup): String? = emit(root, negated = false)

  private fun emit(node: FilterGroup, negated: Boolean): String? =
    when (node) {
      is Filter -> emitLeaf(node, negated xor node.negated)
      is FilterGroup.Not -> emit(node.child, !negated)
      is FilterGroup.And -> emitAnd(node).negateGroup(negated)
      is FilterGroup.Or -> emitOr(node).negateGroup(negated)
    }

  private fun emitLeaf(filter: Filter, negated: Boolean): String {
    val text =
      when (filter) {
        is Filter.Facet -> emitFacet(filter)
        is Filter.Tag -> emitTag(filter)
        is Filter.Comparison -> emitComparison(filter)
        is Filter.Range -> emitRange(filter)
      }
    return if (negated) "NOT $text" else text
  }

  /**
   * Prefixes `NOT ` when [negated]. `null` (an empty group) stays `null`, so `Not(And())` and
   * `Not(Or.Facet())` encode as nothing, exactly like the empty group they wrap.
   */
  private fun String?.negateGroup(negated: Boolean): String? =
    if (negated && this != null) "NOT $this" else this

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
    val parts = group.children.mapNotNull { emit(it, negated = false) }
    if (parts.isEmpty()) return null
    return parts.joinToString(separator = " AND ", prefix = "(", postfix = ")")
  }

  private fun emitOr(group: FilterGroup.Or): String? {
    if (group.children.isEmpty()) return null
    val parts = group.children.map { emitLeaf(it, it.negated) }
    return parts.joinToString(separator = " OR ", prefix = "(", postfix = ")")
  }
}
