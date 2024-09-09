/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.analytics

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * GetRevenue
 *
 * @param currencies Revenue associated with this search, broken-down by currencies.
 * @param dates Daily revenue.
 */
@Serializable
public data class GetRevenue(

  /** Revenue associated with this search, broken-down by currencies. */
  @SerialName(value = "currencies") val currencies: Map<kotlin.String, CurrencyCode>,

  /** Daily revenue. */
  @SerialName(value = "dates") val dates: List<DailyRevenue>,
)
