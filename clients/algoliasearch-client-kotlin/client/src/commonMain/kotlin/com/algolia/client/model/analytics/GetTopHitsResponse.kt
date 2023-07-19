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
 * GetTopHitsResponse
 */
@Serializable(GetTopHitsResponseSerializer::class)
public sealed interface GetTopHitsResponse {

  public companion object {

    /**
     * TopHitsResponse
     *
     * @param hits Top hits.
     */
    public fun TopHitsResponse(
      hits: List<TopHit>,
    ): TopHitsResponse = com.algolia.client.model.analytics.TopHitsResponse(
      hits = hits,
    )

    /**
     * TopHitsResponseWithAnalytics
     *
     * @param hits Top hits.
     */
    public fun TopHitsResponseWithAnalytics(
      hits: List<TopHitWithAnalytics>,
    ): TopHitsResponseWithAnalytics = com.algolia.client.model.analytics.TopHitsResponseWithAnalytics(
      hits = hits,
    )
  }
}

internal class GetTopHitsResponseSerializer : KSerializer<GetTopHitsResponse> {

  override val descriptor: SerialDescriptor = buildClassSerialDescriptor("GetTopHitsResponse")

  override fun serialize(encoder: Encoder, value: GetTopHitsResponse) {
    when (value) {
      is TopHitsResponse -> TopHitsResponse.serializer().serialize(encoder, value)
      is TopHitsResponseWithAnalytics -> TopHitsResponseWithAnalytics.serializer().serialize(encoder, value)
    }
  }

  override fun deserialize(decoder: Decoder): GetTopHitsResponse {
    val codec = decoder.asJsonDecoder()
    val tree = codec.decodeJsonElement()

    // deserialize TopHitsResponse
    if (tree is JsonObject) {
      try {
        return codec.json.decodeFromJsonElement<TopHitsResponse>(tree)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize TopHitsResponse (error: ${e.message})")
      }
    }

    // deserialize TopHitsResponseWithAnalytics
    if (tree is JsonObject) {
      try {
        return codec.json.decodeFromJsonElement<TopHitsResponseWithAnalytics>(tree)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize TopHitsResponseWithAnalytics (error: ${e.message})")
      }
    }

    throw AlgoliaClientException("Failed to deserialize json element: $tree")
  }
}
