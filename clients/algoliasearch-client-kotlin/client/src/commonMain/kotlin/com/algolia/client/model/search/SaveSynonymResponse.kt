/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SaveSynonymResponse
 *
 * @param taskID Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`.
 * @param updatedAt Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format.
 * @param id Unique identifier of a synonym object.
 */
@Serializable
public data class SaveSynonymResponse(

  /** Unique identifier of a task.  A successful API response means that a task was added to a queue. It might not run immediately. You can check the task's progress with the [`task` operation](#tag/Indices/operation/getTask) and this `taskID`.  */
  @SerialName(value = "taskID") val taskID: Long,

  /** Timestamp of the last update in [ISO 8601](https://wikipedia.org/wiki/ISO_8601) format. */
  @SerialName(value = "updatedAt") val updatedAt: String,

  /** Unique identifier of a synonym object. */
  @SerialName(value = "id") val id: String,
)
