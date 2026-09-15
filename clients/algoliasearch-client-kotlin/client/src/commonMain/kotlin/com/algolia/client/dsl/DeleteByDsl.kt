@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.generated.DeleteByParamsBuilder
import com.algolia.client.model.search.DeleteByParams

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
