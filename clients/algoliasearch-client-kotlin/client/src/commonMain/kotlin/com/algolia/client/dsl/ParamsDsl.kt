@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.generated.BrowseParamsObjectBuilder
import com.algolia.client.dsl.generated.DeleteByParamsBuilder
import com.algolia.client.dsl.generated.SearchParamsObjectBuilder
import com.algolia.client.model.search.BrowseParamsObject
import com.algolia.client.model.search.DeleteByParams
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
 * Constructs a [BrowseParamsObject] from the generated [BrowseParamsObjectBuilder].
 *
 * Last write wins: a later assignment to the same builder property replaces an earlier one. A later
 * `filters { }` or `filters = "..."` assignment replaces an earlier `filters` value. The same rule
 * applies to `facetFilters`, `optionalFilters`, `numericFilters`, and `tagFilters`. The DSL does
 * not merge filter parameters.
 *
 * Pass the result to the generated [com.algolia.client.api.SearchClient.browse] method or to
 * [com.algolia.client.extensions.browseObjects]:
 * ```
 * client.browse("idx", browse { query = "shoes"; filters { facet("brand", "Apple") } })
 * ```
 */
@AlgoliaExperimentalDsl
public fun browse(block: BrowseParamsObjectBuilder.() -> Unit): BrowseParamsObject =
  BrowseParamsObjectBuilder().apply(block).build()

/**
 * Constructs a [DeleteByParams] value from the generated [DeleteByParamsBuilder].
 *
 * Last write wins: a later assignment to the same builder property replaces an earlier one,
 * including values set by [filters], [facetFilters], [numericFilters], and [tagFilters].
 * [DeleteByParams] has no `optionalFilters` field.
 *
 * Geo fields (`aroundLatLng`, `aroundRadius`, `insideBoundingBox`, `insidePolygon`) are set as
 * builder properties.
 *
 * ```
 * val params =
 *   deleteBy {
 *     aroundLatLng = "40.71,-74.01"
 *     filters { facet("brand", "Apple") }
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public fun deleteBy(block: DeleteByParamsBuilder.() -> Unit): DeleteByParams =
  DeleteByParamsBuilder().apply(block).build()
