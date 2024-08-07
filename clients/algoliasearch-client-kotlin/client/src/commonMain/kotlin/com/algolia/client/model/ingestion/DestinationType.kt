/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*

/**
 * Destination type.  - `search`.   Data is stored in an Algolia index.  - `insights`.   Data is recorded as user events in the Insights API.
 */
@Serializable
public enum class DestinationType(public val value: kotlin.String) {

  @SerialName(value = "search")
  Search("search"),

  @SerialName(value = "insights")
  Insights("insights");

  override fun toString(): kotlin.String = value
}
