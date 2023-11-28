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
 * @param indexName Index targeted by the query.
 * @param userToken User identifier.
 * @param queryId Unique query identifier.
 */
@Serializable

data class LogQuery (

    /* Index targeted by the query. */
    @SerialName(value = "index_name") val indexName: String? = null,

    /* User identifier. */
    @SerialName(value = "user_token") val userToken: String? = null,

    /* Unique query identifier. */
    @SerialName(value = "query_id") val queryId: String? = null

)

