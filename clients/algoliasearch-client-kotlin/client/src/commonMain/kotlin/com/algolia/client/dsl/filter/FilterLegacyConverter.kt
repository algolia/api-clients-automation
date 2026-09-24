@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.OptionalFilters

/**
 * Converts a typed [FilterGroup] tree of [Filter.Facet] leaves to the legacy `List<List<String>>`
 * form of `optionalFilters`, then wraps it with the generated oneOf factory [OptionalFilters.of].
 * It never builds raw JSON.
 *
 * ## Nested lists
 *
 * The outer list is `AND`. Each inner list is an `OR` group. A single leaf in an [FilterGroup.And]
 * becomes its own one-element inner list:
 * - [FilterGroup.And] of leaves `A`, `B` → `[["A"], ["B"]]` → `A AND B`
 * - [FilterGroup.Or] of leaves `A`, `B` → `[["A", "B"]]` → `A OR B`
 * - [FilterGroup.And] of `Or(A, B)` and leaf `C` → `[["A", "B"], ["C"]]` → `(A OR B) AND C`
 *
 * [FacetFilterDsl] makes a non-facet leaf unrepresentable. A hand-built tree that still contains
 * one throws [IllegalArgumentException]. The encoder does not drop other families.
 *
 * ## Empty groups
 *
 * An empty [FilterGroup.And] or [FilterGroup.Or] contributes no row, with or without an enclosing
 * [FilterGroup.Not]. A tree with no rows encodes as `null`, matching [FilterSqlConverter].
 *
 * ## Reject cases ([IllegalArgumentException])
 *
 * - **Non-facet leaf:** a [Filter.Tag] or [Filter.Numeric] leaf.
 * - **OR of ANDs:** see [conjunctiveRows].
 *
 * ## Encoding
 *
 * Every leaf is unquoted `attribute:value`. The only escape is a leading `-` in a positive value
 * (`attr:\-v`). Negation is a `-` right after the colon: `attr:-v`, or `attr:--v` when the value
 * itself starts with `-`. A non-null [Filter.Facet.score] is appended as `<score=N>`.
 *
 * Quoted forms are never emitted because the engine does not parse quotes in `optionalFilters`: a
 * quoted entry is ignored, `"attr":-"v"` matches every record, and `\"` inside quotes never
 * matches. Version 2 `FilterConverter.Legacy` with `escape = true` emitted those quoted forms; this
 * encoder does not follow it.
 *
 * Attribute names containing `:` are not supported (the engine's split is unverified).
 *
 * See https://www.algolia.com/doc/api-reference/api-parameters/optionalFilters/.
 *
 * ## Shared shape with [FilterSqlConverter]
 *
 * Both encoders share [conjunctiveRows], so they produce the same AND/OR shape and leaf polarity on
 * every tree. Leaf text differs: [FilterSqlConverter] quotes with [FilterQuote] and writes negation
 * as a `NOT` prefix; this encoder never quotes and writes negation as `-` after the colon.
 */
internal object FilterLegacyConverter {

  /**
   * Legacy [OptionalFilters] for the [Filter.Facet] leaves in [root].
   *
   * Throws [IllegalArgumentException] for a non-facet leaf or a De Morgan OR-of-ANDs that the
   * nested-list format cannot encode. Returns `null` when no leaf remains.
   */
  fun optional(root: FilterGroup): OptionalFilters? =
    wrapLegacy(toLegacyRows(root, FilterFamily.Facet), OptionalFilters::of, OptionalFilters::of)
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
    is Filter.Tag,
    is Filter.Numeric -> error("optionalFilters holds facet leaves only: $filter")
  }
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
