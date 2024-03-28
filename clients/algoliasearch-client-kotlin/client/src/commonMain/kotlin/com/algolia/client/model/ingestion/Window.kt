/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Time window by which to filter the observability data.
 *
 * @param startDate Date in RFC3339 format representing the oldest data in the time window.
 * @param endDate Date in RFC3339 format representing the newest data in the time window.
 */
@Serializable
public data class Window(

  /** Date in RFC3339 format representing the oldest data in the time window. */
  @SerialName(value = "startDate") val startDate: String,

  /** Date in RFC3339 format representing the newest data in the time window. */
  @SerialName(value = "endDate") val endDate: String,
)
