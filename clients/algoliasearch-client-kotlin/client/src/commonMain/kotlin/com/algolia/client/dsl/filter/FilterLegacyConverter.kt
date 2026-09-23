@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.FacetFilters
import com.algolia.client.model.search.NumericFilters
import com.algolia.client.model.search.OptionalFilters
import com.algolia.client.model.search.TagFilters

/**
 * Converts a typed [FilterGroup] tree to the legacy `List<List<String>>` form, then wraps it with
 * the generated oneOf factories ([FacetFilters.of], [OptionalFilters.of], [NumericFilters.of],
 * [TagFilters.of]). It never builds raw JSON.
 *
 * ## Nested lists
 *
 * The outer list is `AND`. Each inner list is an `OR` group. A single leaf in an [FilterGroup.And]
 * becomes its own one-element inner list:
 * - [FilterGroup.And] of leaves `A`, `B` → `[["A"], ["B"]]` → `A AND B`
 * - [FilterGroup.Or] of leaves `A`, `B` → `[["A", "B"]]` → `A OR B`
 * - [FilterGroup.And] of `Or(A, B)` and leaf `C` → `[["A", "B"], ["C"]]` → `(A OR B) AND C`
 *
 * [FilterGroup.Or] carries its family in the type.
 *
 * Family receivers make a wrong-family leaf unrepresentable. A hand-built tree that still contains
 * one throws [IllegalArgumentException]. The encoder does not drop other families.
 *
 * ## Empty groups
 *
 * An empty [FilterGroup.And] or [FilterGroup.Or] contributes no row, with or without an enclosing
 * [FilterGroup.Not]. A tree with no rows encodes as `null`, matching [FilterSqlConverter].
 *
 * ## Reject cases ([IllegalArgumentException])
 *
 * - **Wrong family:** a leaf that does not match the encoder family.
 * - **OR of ANDs:** see [conjunctiveRows].
 *
 * ## Encoding
 *
 * Facet (and optional) leaves are `attribute:value` with no quoting and no escaping except a
 * leading `-` in the value (`attr:\-v`). Negation is a `-` right after the colon (`attr:-v`, or
 * `attr:--v` when the value itself starts with `-`). Tags are `v`, `\-v`, `-v`, `--v`. Numeric
 * leaves quote the attribute with the same rule as [FilterSqlConverter].
 *
 * Version 2 `FilterConverter.Legacy` with `escape = true` quoted attribute and value. That form is
 * broken on the engine: a quoted `optionalFilters` entry is ignored, `"a":-"v"` matches every
 * record, and `\"` inside quotes never matches. This encoder does not follow it.
 *
 * Attribute names containing `:` are not supported (the engine's split is unverified).
 *
 * See https://www.algolia.com/doc/api-reference/api-parameters/facetFilters/.
 *
 * ## Shared shape with [FilterSqlConverter]
 *
 * Both encoders share [conjunctiveRows], so they produce the same AND/OR shape and leaf polarity on
 * every tree. Leaf text differs: a negated [Filter.Range] is two comparisons here and `NOT attr:lo
 * TO hi` in [FilterSqlConverter]; a negated [Filter.Comparison] flips its operator here and is `NOT
 * attr op n` there.
 *
 * ## Range negation
 *
 * A negated [Filter.Range] encodes as two comparisons: `attr < lo` and `attr > hi`.
 */
internal object FilterLegacyConverter {

  /**
   * Legacy [FacetFilters] for [Filter.Facet] leaves in [root].
   *
   * Throws [IllegalArgumentException] for a wrong-family leaf or a De Morgan OR-of-ANDs that the
   * nested-list format cannot encode. Returns `null` when no Facet leaf remains.
   */
  fun facet(root: FilterGroup): FacetFilters? =
    wrapLegacy(toLegacyRows(root, FilterFamily.Facet), FacetFilters::of, FacetFilters::of)

  /**
   * Legacy [OptionalFilters] for [Filter.Facet] leaves in [root].
   *
   * Same family rule and reject cases as [facet]. Returns `null` when no Facet leaf remains.
   */
  fun optional(root: FilterGroup): OptionalFilters? =
    wrapLegacy(toLegacyRows(root, FilterFamily.Facet), OptionalFilters::of, OptionalFilters::of)

  /**
   * Legacy [NumericFilters] for [Filter.Comparison] and [Filter.Range] leaves in [root].
   *
   * Throws [IllegalArgumentException] for a wrong-family leaf or a De Morgan OR-of-ANDs that the
   * nested-list format cannot encode. Returns `null` when no numeric leaf remains.
   */
  fun numeric(root: FilterGroup): NumericFilters? =
    wrapLegacy(toLegacyRows(root, FilterFamily.Numeric), NumericFilters::of, NumericFilters::of)

  /**
   * Legacy [TagFilters] for [Filter.Tag] leaves in [root].
   *
   * Throws [IllegalArgumentException] for a wrong-family leaf or a De Morgan OR-of-ANDs that the
   * nested-list format cannot encode. Returns `null` when no Tag leaf remains.
   */
  fun tag(root: FilterGroup): TagFilters? =
    wrapLegacy(toLegacyRows(root, FilterFamily.Tag), TagFilters::of, TagFilters::of)
}

private fun toLegacyRows(root: FilterGroup, family: FilterFamily): List<List<String>> =
  conjunctiveRows(root).map { row ->
    row.flatMap { literal ->
      requireFamily(literal.filter, family)
      encodeLeaf(literal.filter, literal.negated)
    }
  }

private fun requireFamily(filter: Filter, family: FilterFamily) {
  require(familyOf(filter) == family) {
    "${family.name} filters cannot encode ${filter::class.simpleName} leaf $filter"
  }
}

private fun encodeLeaf(filter: Filter, negated: Boolean): List<String> {
  return when (filter) {
    is Filter.Facet -> {
      val score = filter.score?.let { "<score=$it>" }.orEmpty()
      listOf("${filter.attribute}:${legacyValue(filter.value, negated)}$score")
    }
    is Filter.Tag -> listOf(legacyValue(filter.value, negated))
    is Filter.Comparison -> {
      val operator = if (negated) filter.operator.negated() else filter.operator
      listOf("${FilterQuote.quote(filter.attribute)} ${operator.raw} ${filter.value}")
    }
    is Filter.Range -> {
      val attribute = FilterQuote.quote(filter.attribute)
      if (negated) {
        listOf("$attribute < ${filter.lowerBound}", "$attribute > ${filter.upperBound}")
      } else {
        listOf("$attribute:${filter.lowerBound} TO ${filter.upperBound}")
      }
    }
  }
}

private fun NumericOperator.negated(): NumericOperator =
  when (this) {
    NumericOperator.Less -> NumericOperator.GreaterOrEquals
    NumericOperator.LessOrEquals -> NumericOperator.Greater
    NumericOperator.Equals -> NumericOperator.NotEquals
    NumericOperator.NotEquals -> NumericOperator.Equals
    NumericOperator.Greater -> NumericOperator.LessOrEquals
    NumericOperator.GreaterOrEquals -> NumericOperator.Less
  }

/**
 * Legacy value token, never quoted: `v`, `\-v` (a positive value that starts with `-`), `-v`
 * (negated), `--v` (negated value that starts with `-`). The engine reads a single leading `-` as
 * negation and treats quotes as literal or disables the filter, so quoting is never used.
 */
private fun legacyValue(value: String, negated: Boolean): String =
  when {
    negated -> "-$value"
    value.startsWith('-') -> "\\$value"
    else -> value
  }

/**
 * Wraps legacy rows with a generated oneOf factory pair. [ofString] builds a leaf, [ofList] builds
 * an inner `OR` row and the outer `AND` list. Rows that hold no literal are dropped; an empty
 * result is `null`.
 */
private fun <T> wrapLegacy(
  rows: List<List<String>>,
  ofString: (String) -> T,
  ofList: (List<T>) -> T,
): T? {
  val compact = rows.filter { it.isNotEmpty() }
  if (compact.isEmpty()) return null
  return ofList(compact.map { row -> ofList(row.map(ofString)) })
}
