@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.dsl.filter.filters as buildFilters
import com.algolia.client.dsl.generated.SearchParamsObjectBuilder
import com.algolia.client.model.search.SearchParamsObject

/**
 * Constructs a [SearchParamsObject] from the generated [SearchParamsObjectBuilder].
 *
 * Last write wins: a later assignment to the same builder property replaces an earlier one. If
 * [query] is non-null, it is written first. The [block] may overwrite it. A later `filters { }` or
 * `filters = "..."` assignment replaces an earlier `filters` value. The same rule applies to
 * `facetFilters`, `optionalFilters`, `numericFilters`, and `tagFilters`. The DSL does not merge
 * filter parameters.
 *
 * ```
 * val params =
 *   query {
 *     query = "x"
 *     filters { facet("brand", "Apple") }
 *   }
 * ```
 *
 * Or pass the query string as the first argument:
 * ```
 * val params = query("x") { filters { facet("brand", "Apple") } }
 * ```
 */
@AlgoliaExperimentalDsl
public fun query(
  query: String? = null,
  block: SearchParamsObjectBuilder.() -> Unit,
): SearchParamsObject =
  SearchParamsObjectBuilder()
    .apply {
      if (query != null) {
        this.query = query
      }
      block()
    }
    .build()

/**
 * Sets [SearchParamsObjectBuilder.filters] from a typed filter block as a SQL string.
 *
 * Last write wins: this replaces any earlier `filters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun SearchParamsObjectBuilder.filters(block: FilterDsl.() -> Unit) {
  filters = buildFilters(block).asSql()
}

/**
 * Sets [SearchParamsObjectBuilder.facetFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `facetFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun SearchParamsObjectBuilder.facetFilters(block: FilterDsl.() -> Unit) {
  facetFilters = buildFilters(block).asFacetFilters()
}

/**
 * Sets [SearchParamsObjectBuilder.optionalFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `optionalFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun SearchParamsObjectBuilder.optionalFilters(block: FilterDsl.() -> Unit) {
  optionalFilters = buildFilters(block).asOptionalFilters()
}

/**
 * Sets [SearchParamsObjectBuilder.numericFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `numericFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun SearchParamsObjectBuilder.numericFilters(block: FilterDsl.() -> Unit) {
  numericFilters = buildFilters(block).asNumericFilters()
}

/**
 * Sets [SearchParamsObjectBuilder.tagFilters] from a typed filter block as a legacy wrapper.
 *
 * Last write wins: this replaces any earlier `tagFilters` value in the same builder.
 */
@AlgoliaExperimentalDsl
public fun SearchParamsObjectBuilder.tagFilters(block: FilterDsl.() -> Unit) {
  tagFilters = buildFilters(block).asTagFilters()
}
