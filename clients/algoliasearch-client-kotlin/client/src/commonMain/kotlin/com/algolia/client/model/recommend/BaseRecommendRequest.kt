/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * BaseRecommendRequest
 *
 * @param indexName The Algolia index name.
 * @param threshold The threshold to use when filtering recommendations by their score.
 * @param maxRecommendations The max number of recommendations to retrieve. If it's set to 0, all the recommendations of the objectID may be returned.
 * @param queryParameters
 * @param fallbackParameters
 */
@Serializable
public data class BaseRecommendRequest(

  /** The Algolia index name. */
  @SerialName(value = "indexName") val indexName: String,

  /** The threshold to use when filtering recommendations by their score. */
  @SerialName(value = "threshold") val threshold: Int,

  /** The max number of recommendations to retrieve. If it's set to 0, all the recommendations of the objectID may be returned. */
  @SerialName(value = "maxRecommendations") val maxRecommendations: Int? = null,

  @SerialName(value = "queryParameters") val queryParameters: SearchParamsObject? = null,

  @SerialName(value = "fallbackParameters") val fallbackParameters: SearchParamsObject? = null,
)
