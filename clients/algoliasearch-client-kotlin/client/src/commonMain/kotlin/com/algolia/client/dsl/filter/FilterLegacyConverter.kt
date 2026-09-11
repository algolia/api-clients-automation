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
 * [FilterGroup.Or] has no compile-time leaf kind. Children are classified at runtime.
 *
 * ## Family partition
 *
 * Each entry point keeps only its family and ignores other leaves (including under
 * [FilterGroup.And] and [FilterGroup.Not]):
 * - [facet] / [optional]: [Filter.Facet] only
 * - [numeric]: [Filter.Comparison] and [Filter.Range] only
 * - [tag]: [Filter.Tag] only
 *
 * An empty result after that partition is `null`.
 *
 * ## Reject cases ([IllegalArgumentException])
 *
 * - **Mixed-family [FilterGroup.Or]:** the `Or` subtree contains more than one of Facet, Numeric,
 *   Tag. The converter does not drop the foreign side or emit invalid JSON.
 * - **[FilterGroup.And] nested in [FilterGroup.Or]:** a child of `Or` encodes as more than one
 *   `AND` row (OR-of-ANDs). `List<List<String>>` cannot represent that. A single-child `And` is
 *   flattened to that child.
 * - **De Morgan OR-of-ANDs:** [FilterGroup.Not] of an [FilterGroup.And] whose negated children
 *   include a conjunction (for example `Not(And(Or(A, B), C))`).
 *
 * Version 2 used typed `Or.Facet` / `Or.Numeric` / `Or.Tag`. This converter enforces the same
 * homogeneity at runtime.
 */
@AlgoliaExperimentalDsl
public object FilterLegacyConverter {

  /**
   * Legacy [FacetFilters] for [Filter.Facet] leaves in [root].
   *
   * Ignores [Filter.Tag], [Filter.Comparison], and [Filter.Range]. Throws
   * [IllegalArgumentException] for a mixed-family [FilterGroup.Or] or an `And` nested in `Or` that
   * the nested-list format cannot encode. Returns `null` when no Facet leaf remains.
   */
  @AlgoliaExperimentalDsl
  public fun facet(root: FilterGroup): FacetFilters? =
    wrapLegacy(toLegacyRows(root, FilterFamily.Facet), FacetFilters::of, FacetFilters::of)

  /**
   * Legacy [OptionalFilters] for [Filter.Facet] leaves in [root].
   *
   * Same family rule and reject cases as [facet]. Returns `null` when no Facet leaf remains.
   */
  @AlgoliaExperimentalDsl
  public fun optional(root: FilterGroup): OptionalFilters? =
    wrapLegacy(toLegacyRows(root, FilterFamily.Facet), OptionalFilters::of, OptionalFilters::of)

  /**
   * Legacy [NumericFilters] for [Filter.Comparison] and [Filter.Range] leaves in [root].
   *
   * Ignores [Filter.Facet] and [Filter.Tag]. Throws [IllegalArgumentException] for a mixed-family
   * [FilterGroup.Or] or an `And` nested in `Or` that the nested-list format cannot encode. Returns
   * `null` when no numeric leaf remains.
   */
  @AlgoliaExperimentalDsl
  public fun numeric(root: FilterGroup): NumericFilters? =
    wrapLegacy(toLegacyRows(root, FilterFamily.Numeric), NumericFilters::of, NumericFilters::of)

  /**
   * Legacy [TagFilters] for [Filter.Tag] leaves in [root].
   *
   * Ignores [Filter.Facet], [Filter.Comparison], and [Filter.Range]. Throws
   * [IllegalArgumentException] for a mixed-family [FilterGroup.Or] or an `And` nested in `Or` that
   * the nested-list format cannot encode. Returns `null` when no Tag leaf remains.
   */
  @AlgoliaExperimentalDsl
  public fun tag(root: FilterGroup): TagFilters? =
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
      if (familyOf(group) != family) {
        emptyList()
      } else {
        listOf(encodeLeaf(group, negated))
      }
    }
    is FilterGroup.Not -> toRows(group.child, family, !negated)
    is FilterGroup.And -> convertAnd(group.children, family, negated)
    is FilterGroup.Or -> convertOr(group.children, family, negated)
  }
}

private fun convertAnd(
  children: List<FilterGroup>,
  family: FilterFamily,
  negated: Boolean,
): List<List<String>> {
  val relevant = children.filter { family in leafFamilies(it) }
  if (relevant.isEmpty()) return emptyList()
  if (negated) {
    return if (relevant.size == 1) {
      toRows(relevant.single(), family, negated = true)
    } else {
      convertOr(relevant.map { FilterGroup.Not(it) }, family, negated = false)
    }
  }
  return relevant.flatMap { toRows(it, family, negated = false) }.filter { it.isNotEmpty() }
}

private fun convertOr(
  children: List<FilterGroup>,
  family: FilterFamily,
  negated: Boolean,
): List<List<String>> {
  val families = children.fold(emptySet<FilterFamily>()) { acc, child -> acc + leafFamilies(child) }
  require(families.size <= 1) {
    "Or mixes filter families $families. List<List<String>> cannot encode a mixed-family Or."
  }
  if (family !in families) return emptyList()
  if (negated) {
    return children.flatMap { toRows(it, family, negated = true) }.filter { it.isNotEmpty() }
  }
  val literals = mutableListOf<String>()
  for (child in children) {
    val rows = toRows(child, family, negated = false).filter { it.isNotEmpty() }
    when (rows.size) {
      0 -> Unit
      1 -> literals += rows.single()
      else ->
        throw IllegalArgumentException(
          "Or contains an And that List<List<String>> cannot encode. " +
            "A nested And inside Or would require OR-of-ANDs."
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

private fun leafFamilies(group: FilterGroup): Set<FilterFamily> =
  when (group) {
    is Filter -> setOf(familyOf(group))
    is FilterGroup.And ->
      group.children.fold(emptySet()) { acc, child -> acc + leafFamilies(child) }
    is FilterGroup.Or -> group.children.fold(emptySet()) { acc, child -> acc + leafFamilies(child) }
    is FilterGroup.Not -> leafFamilies(group.child)
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
      val raw = filter.value.escape()
      listOf(if (negated) "-$raw" else raw)
    }
    is Filter.Comparison -> {
      val operator = if (negated) filter.operator.negated() else filter.operator
      listOf("${filter.attribute.escape()} ${operator.raw} ${filter.value}")
    }
    is Filter.Range -> {
      val attribute = filter.attribute.escape()
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
