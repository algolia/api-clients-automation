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

import com.algolia.client.model.search.DictionaryAction
import com.algolia.client.model.search.DictionaryEntry

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param action 
 * @param body 
 */
@Serializable

data class BatchDictionaryEntriesRequest (

    @SerialName(value = "action") @Required val action: DictionaryAction,

    @SerialName(value = "body") @Required val body: DictionaryEntry

)

