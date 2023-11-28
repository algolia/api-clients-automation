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

import com.algolia.client.model.search.ConsequenceQueryObject
import com.algolia.client.model.search.Edit

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * When providing a string, it replaces the entire query string. When providing an object, it describes incremental edits to be made to the query string (but you can't do both).
 *
 * @param remove Words to remove.
 * @param edits Edits to apply.
 */
@Serializable

data class ConsequenceQuery (

    /* Words to remove. */
    @SerialName(value = "remove") val remove: kotlin.collections.List<String>? = null,

    /* Edits to apply. */
    @SerialName(value = "edits") val edits: kotlin.collections.List<Edit>? = null

)

