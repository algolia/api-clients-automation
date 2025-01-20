/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.analytics

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * TopHit
 *
 * @param hit Object ID of a record returned as a search result.
 * @param count Number of occurrences.
 */
@Serializable
public data class TopHit(

  /** Object ID of a record returned as a search result. */
  @SerialName(value = "hit") val hit: String,

  /** Number of occurrences. */
  @SerialName(value = "count") val count: Int,
)
