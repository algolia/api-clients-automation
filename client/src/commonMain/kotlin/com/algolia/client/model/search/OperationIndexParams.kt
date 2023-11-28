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

import com.algolia.client.model.search.OperationType
import com.algolia.client.model.search.ScopeType

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param operation 
 * @param destination Algolia index name.
 * @param scope **This only applies to the _copy_ operation.**  If you omit `scope`, the copy command copies all records, settings, synonyms, and rules.  If you specify `scope`, only the specified scopes are copied.
 */
@Serializable

data class OperationIndexParams (

    @SerialName(value = "operation") @Required val operation: OperationType,

    /* Algolia index name. */
    @SerialName(value = "destination") @Required val destination: String,

    /* **This only applies to the _copy_ operation.**  If you omit `scope`, the copy command copies all records, settings, synonyms, and rules.  If you specify `scope`, only the specified scopes are copied. */
    @SerialName(value = "scope") val scope: kotlin.collections.List<ScopeType>? = null

)

