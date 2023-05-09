/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.analytics

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * ClickThroughRateEvent
 *
 * @param rate The click-through rate.
 * @param clickCount The number of click event.
 * @param trackedSearchCount The number of tracked search click.
 * @param date Date of the event.
 */
@Serializable
public data class ClickThroughRateEvent(

  /** The click-through rate. */
  @SerialName(value = "rate") val rate: Double,

  /** The number of click event. */
  @SerialName(value = "clickCount") val clickCount: Int,

  /** The number of tracked search click. */
  @SerialName(value = "trackedSearchCount") val trackedSearchCount: Int,

  /** Date of the event. */
  @SerialName(value = "date") val date: String,
)
