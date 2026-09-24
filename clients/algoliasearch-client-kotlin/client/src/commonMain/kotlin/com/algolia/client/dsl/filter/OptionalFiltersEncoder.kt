@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.filter

import com.algolia.client.dsl.AlgoliaExperimentalDsl
import com.algolia.client.model.search.OptionalFilters

/**
 * Encodes facet rows (outer list `AND`, inner list `OR`) to nested [OptionalFilters] through the
 * generated oneOf factory [OptionalFilters.of]; no rows encode as `null`.
 *
 * Every leaf is unquoted `attr:value`. The only escape is a leading `-` in a positive value
 * (`attr:\-v`). Negation is a `-` right after the colon: `attr:-v`, or `attr:--v` when the value
 * itself starts with `-`. A non-null [Filter.Facet.score] is appended as `<score=N>`.
 *
 * Quotes are never emitted: the engine does not parse them in `optionalFilters` (a quoted entry is
 * ignored, `"attr":-"v"` matches every record, `\"` inside quotes never matches). Version 2
 * `FilterConverter.Legacy` with `escape = true` emitted those forms; this encoder does not.
 * Attribute names containing `:` are not supported (the engine's split is unverified).
 *
 * See https://www.algolia.com/doc/api-reference/api-parameters/optionalFilters/.
 */
internal object OptionalFiltersEncoder {
  operator fun invoke(rows: List<List<Filter.Facet>>): OptionalFilters? =
    if (rows.isEmpty()) null
    else
      OptionalFilters.of(
        rows.map { row -> OptionalFilters.of(row.map { OptionalFilters.of(encode(it)) }) }
      )

  private fun encode(facet: Filter.Facet): String {
    val value =
      when {
        facet.negated -> "-${facet.value}"
        facet.value.startsWith('-') -> "\\${facet.value}"
        else -> facet.value
      }
    return "${facet.attribute}:$value${facet.score?.let { "<score=$it>" }.orEmpty()}"
  }
}
