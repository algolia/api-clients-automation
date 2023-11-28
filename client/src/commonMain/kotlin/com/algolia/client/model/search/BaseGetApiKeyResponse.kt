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
 * @param createdAt Timestamp of creation in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time).
 * @param `value` API key.
 */
@Serializable

data class BaseGetApiKeyResponse (

    /* Timestamp of creation in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). */
    @SerialName(value = "createdAt") @Required val createdAt: Long,

    /* API key. */
    @SerialName(value = "value") val `value`: String? = null

)

