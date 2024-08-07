/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.analytics

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * TopHitsResponse
 *
 * @param hits Most frequent search results.
 */
@Serializable
public data class TopHitsResponse(

  /** Most frequent search results. */
  @SerialName(value = "hits") val hits: List<TopHit>,
) : GetTopHitsResponse
