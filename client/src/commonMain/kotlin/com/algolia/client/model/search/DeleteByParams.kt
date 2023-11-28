/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.algolia.client.model.search

import com.algolia.client.model.search.AroundRadius
import com.algolia.client.model.search.FacetFilters
import com.algolia.client.model.search.NumericFilters
import com.algolia.client.model.search.TagFilters

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param facetFilters 
 * @param filters [Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters. 
 * @param numericFilters 
 * @param tagFilters 
 * @param aroundLatLng Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area.
 * @param aroundRadius 
 * @param insideBoundingBox Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).
 * @param insidePolygon Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).
 */
@Serializable

data class DeleteByParams (

    @SerialName(value = "facetFilters") val facetFilters: FacetFilters? = null,

    /* [Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters.  */
    @SerialName(value = "filters") val filters: String? = "",

    @SerialName(value = "numericFilters") val numericFilters: NumericFilters? = null,

    @SerialName(value = "tagFilters") val tagFilters: TagFilters? = null,

    /* Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area. */
    @SerialName(value = "aroundLatLng") val aroundLatLng: String? = "",

    @SerialName(value = "aroundRadius") val aroundRadius: AroundRadius? = null,

    /* Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates). */
    @SerialName(value = "insideBoundingBox") val insideBoundingBox: kotlin.collections.List<List<Double>>? = null,

    /* Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates). */
    @SerialName(value = "insidePolygon") val insidePolygon: kotlin.collections.List<List<Double>>? = null

)

