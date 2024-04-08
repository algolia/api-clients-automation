/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*

/**
 * RecommendationsRequest
 *
 * Implementations:
 * - [BoughtTogetherQuery]
 * - [LookingSimilarQuery]
 * - [RecommendedForYouQuery]
 * - [RelatedQuery]
 * - [TrendingFacetsQuery]
 * - [TrendingItemsQuery]
 */
@Serializable(RecommendationsRequestSerializer::class)
public sealed interface RecommendationsRequest {

  public companion object {
  }
}

internal class RecommendationsRequestSerializer : JsonContentPolymorphicSerializer<RecommendationsRequest>(RecommendationsRequest::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<RecommendationsRequest> {
    return when {
      element is JsonObject -> BoughtTogetherQuery.serializer()
      element is JsonObject -> RelatedQuery.serializer()
      element is JsonObject -> TrendingItemsQuery.serializer()
      element is JsonObject -> TrendingFacetsQuery.serializer()
      element is JsonObject -> LookingSimilarQuery.serializer()
      element is JsonObject -> RecommendedForYouQuery.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
