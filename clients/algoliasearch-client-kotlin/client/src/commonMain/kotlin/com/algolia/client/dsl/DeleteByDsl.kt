@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.dsl.filter.FilterDsl
import com.algolia.client.dsl.filter.filters as buildFilters
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

/**
 * Sets [DeleteByParamsBuilder.filters] from the typed filter DSL.
 *
 * Emits the SQL `filters` string. Last write wins if this property was already set in the same
 * block.
 */
@AlgoliaExperimentalDsl
public fun DeleteByParamsBuilder.filters(block: FilterDsl.() -> Unit) {
  filters = buildFilters(block).asSql()
}

/**
 * Sets [DeleteByParamsBuilder.facetFilters] from the typed filter DSL.
 *
 * Emits the legacy facet-filters wrapper. Last write wins if this property was already set in the
 * same block.
 */
@AlgoliaExperimentalDsl
public fun DeleteByParamsBuilder.facetFilters(block: FilterDsl.() -> Unit) {
  facetFilters = buildFilters(block).asFacetFilters()
}

/**
 * Sets [DeleteByParamsBuilder.numericFilters] from the typed filter DSL.
 *
 * Emits the legacy numeric-filters wrapper. Last write wins if this property was already set in the
 * same block.
 */
@AlgoliaExperimentalDsl
public fun DeleteByParamsBuilder.numericFilters(block: FilterDsl.() -> Unit) {
  numericFilters = buildFilters(block).asNumericFilters()
}

/**
 * Sets [DeleteByParamsBuilder.tagFilters] from the typed filter DSL.
 *
 * Emits the legacy tag-filters wrapper. Last write wins if this property was already set in the
 * same block.
 */
@AlgoliaExperimentalDsl
public fun DeleteByParamsBuilder.tagFilters(block: FilterDsl.() -> Unit) {
  tagFilters = buildFilters(block).asTagFilters()
}
