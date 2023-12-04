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
 * @param objectIDs Unique object (record) identifiers.
 */
@Serializable

data class BatchResponse (

    /* Unique identifier of a task. A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the `task` operation and this `taskID`.  */
    @SerialName(value = "taskID") @Required val taskID: Long,

    /* Unique object (record) identifiers. */
    @SerialName(value = "objectIDs") @Required val objectIDs: kotlin.collections.List<String>

)

