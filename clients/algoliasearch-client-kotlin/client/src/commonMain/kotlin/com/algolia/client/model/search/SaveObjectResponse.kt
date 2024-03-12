/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SaveObjectResponse
 *
 * @param createdAt Timestamp when the record was added, in ISO 8601 format.
 * @param taskID Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`.
 * @param objectID Unique record identifier.
 */
@Serializable
public data class SaveObjectResponse(

  /** Timestamp when the record was added, in ISO 8601 format. */
  @SerialName(value = "createdAt") val createdAt: String,

  /** Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`.  */
  @SerialName(value = "taskID") val taskID: Long,

  /** Unique record identifier. */
  @SerialName(value = "objectID") val objectID: String? = null,
)
