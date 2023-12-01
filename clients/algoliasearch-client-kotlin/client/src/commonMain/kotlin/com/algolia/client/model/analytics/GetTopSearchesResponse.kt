/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.analytics

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*

/**
 * GetTopSearchesResponse
 *
 * Implementations:
 * - [TopSearchesResponse]
 * - [TopSearchesResponseWithAnalytics]
 */
@Serializable(GetTopSearchesResponseSerializer::class)
public sealed interface GetTopSearchesResponse {

  public companion object {
  }
}

internal class GetTopSearchesResponseSerializer : JsonContentPolymorphicSerializer<GetTopSearchesResponse>(GetTopSearchesResponse::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<GetTopSearchesResponse> {
    return when {
      element is JsonObject -> TopSearchesResponse.serializer()
      element is JsonObject -> TopSearchesResponseWithAnalytics.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
