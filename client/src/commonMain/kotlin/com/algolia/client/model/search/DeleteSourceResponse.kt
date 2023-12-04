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
 * @param deletedAt Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
 */
@Serializable

data class DeleteSourceResponse (

    /* Timestamp of deletion in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. */
    @SerialName(value = "deletedAt") @Required val deletedAt: String

)

