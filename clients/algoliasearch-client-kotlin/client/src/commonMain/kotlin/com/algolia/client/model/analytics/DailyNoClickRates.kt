/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.analytics

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * DailyNoClickRates
 *
 * @param rate No click rate: calculated as the number of tracked searches without clicks divided by the number of tracked searches.
 * @param count Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
 * @param noClickCount Number of times this search was returned as a result without any click.
 * @param date Date in the format YYYY-MM-DD.
 */
@Serializable
public data class DailyNoClickRates(

  /** No click rate: calculated as the number of tracked searches without clicks divided by the number of tracked searches.  */
  @SerialName(value = "rate") val rate: Double,

  /** Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true. */
  @SerialName(value = "count") val count: Int,

  /** Number of times this search was returned as a result without any click. */
  @SerialName(value = "noClickCount") val noClickCount: Int,

  /** Date in the format YYYY-MM-DD. */
  @SerialName(value = "date") val date: String,
)
