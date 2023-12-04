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


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param lat Latitude of the matched location.
 * @param lng Longitude of the matched location.
 * @param distance Distance between the matched location and the search location (in meters).
 */
@Serializable

data class MatchedGeoLocation (

    /* Latitude of the matched location. */
    @SerialName(value = "lat") val lat: Double? = null,

    /* Longitude of the matched location. */
    @SerialName(value = "lng") val lng: Double? = null,

    /* Distance between the matched location and the search location (in meters). */
    @SerialName(value = "distance") val distance: Int? = null

)

