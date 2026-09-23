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
 * - **De Morgan OR-of-ANDs:** [FilterGroup.Not] of an [FilterGroup.And] whose negated children
 *   include a conjunction (for example `Not(And(Or.Facet(A, B), C))`).
 *
 * ## Quoting
 *
 * Facet (and optional) leaves always quote attribute and value. That matches version 2
 * `FilterConverter.Legacy` with `escape = true`.
 *
 * Numeric attributes and tag values use the same T5 rule as [FilterSqlConverter]: quote only when
 * the token is empty or contains a space, a quote, or `AND` / `OR` / `NOT`.
 *
 * ## Leaf negation
 *
 * A leaf encodes with `parity xor Filter.negated`, where parity is the number of enclosing
 * [FilterGroup.Not] nodes mod 2. `Not(Not(A))` is `A`; `Not(!A)` is `A`; `!!A` is `A`. This is the
 * same rule as [FilterSqlConverter], so both encoders agree on every tree.
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

private enum class FilterFamily {
  Facet,
  Numeric,
  Tag,
}

private fun toLegacyRows(root: FilterGroup, family: FilterFamily): List<List<String>> =
  toRows(root, family, negated = false)

private fun toRows(
  group: FilterGroup,
  family: FilterFamily,
  negated: Boolean,
): List<List<String>> {
  return when (group) {
    is Filter -> {
      requireFamily(group, family)
      listOf(encodeLeaf(group, negated xor group.negated))
    }
    is FilterGroup.Not -> toRows(group.child, family, !negated)
    is FilterGroup.And -> convertAnd(group.children, family, negated)
    is FilterGroup.Or -> orRows(group.children, family, negated)
  }
}

private fun convertAnd(
  children: List<FilterGroup>,
  family: FilterFamily,
  negated: Boolean,
): List<List<String>> {
  if (!negated) {
    return children.flatMap { toRows(it, family, negated = false) }.filter { it.isNotEmpty() }
  }
  return when (children.size) {
    0 -> emptyList()
    1 -> toRows(children.single(), family, negated = true)
    else -> negatedAndRow(children, family)
  }
}

/**
 * OR of leaves. Positive: one row holding every leaf literal (a negated [Filter.Range] contributes
 * its two comparisons to that same row). Negated: De Morgan turns `NOT (a OR b)` into `NOT a AND
 * NOT b`, one row per leaf. Empty: no rows. A leaf always encodes as exactly one row, so this never
 * rejects.
 */
private fun orRows(
  children: List<Filter>,
  family: FilterFamily,
  negated: Boolean,
): List<List<String>> {
  if (children.isEmpty()) return emptyList()
  if (negated) return children.flatMap { toRows(it, family, negated = true) }
  return listOf(children.flatMap { toRows(it, family, negated = false).single() })
}

/**
 * De Morgan for a negated [FilterGroup.And] of two or more children: `NOT (a AND b)` is the single
 * OR row `NOT a OR NOT b`, so each child must collapse to one row. A child that needs several rows
 * — a negated [FilterGroup.Or] with two or more leaves, or a positive conjunction under a double
 * [FilterGroup.Not] — is an OR of ANDs, which `List<List<String>>` cannot encode: that is the
 * [IllegalArgumentException] reject case. A child with no row (an empty group) is skipped.
 */
private fun negatedAndRow(children: List<FilterGroup>, family: FilterFamily): List<List<String>> {
  val literals = mutableListOf<String>()
  for (child in children) {
    val rows = toRows(child, family, negated = true).filter { it.isNotEmpty() }
    when (rows.size) {
      0 -> Unit
      1 -> literals += rows.single()
      else ->
        throw IllegalArgumentException(
          "Not of an And that holds a disjunction cannot encode as List<List<String>>."
        )
    }
  }
  return if (literals.isEmpty()) emptyList() else listOf(literals)
}

private fun familyOf(filter: Filter): FilterFamily =
  when (filter) {
    is Filter.Facet -> FilterFamily.Facet
    is Filter.Tag -> FilterFamily.Tag
    is Filter.Comparison,
    is Filter.Range -> FilterFamily.Numeric
  }

private fun requireFamily(filter: Filter, family: FilterFamily) {
  require(familyOf(filter) == family) {
    "${family.name} filters cannot encode ${filter::class.simpleName} leaf $filter"
  }
}

private fun encodeLeaf(filter: Filter, negated: Boolean): List<String> {
  return when (filter) {
    is Filter.Facet -> {
      val attribute = filter.attribute.escape()
      val value = buildString {
        if (negated) append('-')
        append(filter.value.escape())
      }
      val score = filter.score?.let { "<score=$it>" }.orEmpty()
      listOf("$attribute:$value$score")
    }
    is Filter.Tag -> {
      val raw = FilterQuote.quote(filter.value)
      listOf(if (negated) "-$raw" else raw)
    }
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

private fun String.escapeQuotation(): String = replace("\"", "\\\"")

private fun String.escape(): String = "\"${escapeQuotation()}\""

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
