/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.analytics

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * GetConversionRateResponse
 *
 * @param rate Conversion rate: calculated as the number of tracked searches with at least one conversion event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.
 * @param trackedSearchCount Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true.
 * @param conversionCount Number of conversions from this search.
 * @param dates Daily conversion rates.
 */
@Serializable
public data class GetConversionRateResponse(

  /** Conversion rate: calculated as the number of tracked searches with at least one conversion event divided by the number of tracked searches. If null, Algolia didn't receive any search requests with `clickAnalytics` set to true.  */
  @SerialName(value = "rate") val rate: Double,

  /** Number of tracked searches. Tracked searches are search requests where the `clickAnalytics` parameter is true. */
  @SerialName(value = "trackedSearchCount") val trackedSearchCount: Int,

  /** Number of conversions from this search. */
  @SerialName(value = "conversionCount") val conversionCount: Int,

  /** Daily conversion rates. */
  @SerialName(value = "dates") val dates: List<DailyConversionRates>,
)
