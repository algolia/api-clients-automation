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

import com.algolia.client.model.search.MatchLevel

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * Show highlighted section and words matched on a query.
 *
 * @param `value` Markup text with `facetQuery` matches highlighted.
 * @param matchLevel 
 * @param matchedWords List of words from the query that matched the object.
 * @param fullyHighlighted Whether the entire attribute value is highlighted.
 */
@Serializable

data class HighlightResultOption (

    /* Markup text with `facetQuery` matches highlighted. */
    @SerialName(value = "value") @Required val `value`: String,

    @SerialName(value = "matchLevel") @Required val matchLevel: MatchLevel,

    /* List of words from the query that matched the object. */
    @SerialName(value = "matchedWords") @Required val matchedWords: kotlin.collections.List<String>,

    /* Whether the entire attribute value is highlighted. */
    @SerialName(value = "fullyHighlighted") val fullyHighlighted: Boolean? = null

)

