/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Set of rules for a task.
 *
 * @param criticalThreshold The number of critical failures in a row before blocking the task and sending a notification.
 */
@Serializable
public data class Policies(

  /** The number of critical failures in a row before blocking the task and sending a notification. */
  @SerialName(value = "criticalThreshold") val criticalThreshold: Int? = null,
)
