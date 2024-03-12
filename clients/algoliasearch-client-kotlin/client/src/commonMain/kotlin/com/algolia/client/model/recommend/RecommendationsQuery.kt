/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * RecommendationsQuery
 *
 * @param indexName Index name.
 * @param model
 * @param objectID Unique record identifier.
 * @param threshold Recommendations with a confidence score lower than `threshold` won't appear in results. > **Note**: Each recommendation has a confidence score of 0 to 100. The closer the score is to 100, the more relevant the recommendations are.
 * @param maxRecommendations Maximum number of recommendations to retrieve. If 0, all recommendations will be returned.
 * @param queryParameters
 * @param fallbackParameters
 */
@Serializable
public data class RecommendationsQuery(

  /** Index name. */
  @SerialName(value = "indexName") val indexName: String,

  @SerialName(value = "model") val model: RecommendationModels,

  /** Unique record identifier. */
  @SerialName(value = "objectID") val objectID: String,

  /** Recommendations with a confidence score lower than `threshold` won't appear in results. > **Note**: Each recommendation has a confidence score of 0 to 100. The closer the score is to 100, the more relevant the recommendations are.  */
  @SerialName(value = "threshold") val threshold: Int? = null,

  /** Maximum number of recommendations to retrieve. If 0, all recommendations will be returned. */
  @SerialName(value = "maxRecommendations") val maxRecommendations: Int? = null,

  @SerialName(value = "queryParameters") val queryParameters: SearchParamsObject? = null,

  @SerialName(value = "fallbackParameters") val fallbackParameters: SearchParamsObject? = null,
) : RecommendationsRequest
