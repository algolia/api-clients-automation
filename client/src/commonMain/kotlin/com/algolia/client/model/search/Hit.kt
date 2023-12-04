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

import com.algolia.client.model.search.AbstractMap
import com.algolia.client.model.search.Any
import com.algolia.client.model.search.HighlightResult
import com.algolia.client.model.search.RankingInfo
import com.algolia.client.model.search.SnippetResult

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * A single hit.
 *
 * @param objectID Unique object identifier.
 * @param highlightResult Show highlighted section and words matched on a query.
 * @param snippetResult Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty.
 * @param rankingInfo 
 * @param distinctSeqID 
 */
@Serializable

data class Hit (

    /* Unique object identifier. */
    @SerialName(value = "objectID") @Required val objectID: String,

    /* Show highlighted section and words matched on a query. */
    @SerialName(value = "_highlightResult") val highlightResult: Map<kotlin.String, HighlightResult>? = null,

    /* Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty. */
    @SerialName(value = "_snippetResult") val snippetResult: Map<kotlin.String, SnippetResult>? = null,

    @SerialName(value = "_rankingInfo") val rankingInfo: RankingInfo? = null,

    @SerialName(value = "_distinctSeqID") val distinctSeqID: Int? = null

) : AbstractMap<String, Any>()

