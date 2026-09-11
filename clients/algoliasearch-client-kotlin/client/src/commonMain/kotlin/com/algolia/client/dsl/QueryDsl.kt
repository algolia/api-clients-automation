@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

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
