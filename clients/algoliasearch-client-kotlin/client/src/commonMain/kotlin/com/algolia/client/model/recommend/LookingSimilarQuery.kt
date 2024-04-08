/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * LookingSimilarQuery
 *
 * @param indexName Index name.
 * @param threshold Minimum score a recommendation must have to be included in the response.
 * @param model
 * @param objectID Unique record identifier.
 * @param maxRecommendations Maximum number of recommendations to retrieve. By default, all recommendations are returned and no fallback request is made. Depending on the available recommendations and the other request parameters, the actual number of recommendations may be lower than this value.
 * @param queryParameters
 * @param fallbackParameters
 */
@Serializable
public data class LookingSimilarQuery(

  /** Index name. */
  @SerialName(value = "indexName") val indexName: String,

  /** Minimum score a recommendation must have to be included in the response. */
  @SerialName(value = "threshold") val threshold: Double,

  @SerialName(value = "model") val model: LookingSimilarModel,

  /** Unique record identifier. */
  @SerialName(value = "objectID") val objectID: String,

  /** Maximum number of recommendations to retrieve. By default, all recommendations are returned and no fallback request is made. Depending on the available recommendations and the other request parameters, the actual number of recommendations may be lower than this value.  */
  @SerialName(value = "maxRecommendations") val maxRecommendations: Int? = null,

  @SerialName(value = "queryParameters") val queryParameters: SearchParams? = null,

  @SerialName(value = "fallbackParameters") val fallbackParameters: FallbackParams? = null,
) : RecommendationsRequest
