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
 * @param taskID Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the `task` operation and this `taskID`. 
 * @param updatedAt Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
 * @param id Unique identifier of a synonym object.
 */
@Serializable

data class SaveSynonymResponse (

    /* Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the `task` operation and this `taskID`.  */
    @SerialName(value = "taskID") @Required val taskID: Long,

    /* Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. */
    @SerialName(value = "updatedAt") @Required val updatedAt: String,

    /* Unique identifier of a synonym object. */
    @SerialName(value = "id") @Required val id: String

)

