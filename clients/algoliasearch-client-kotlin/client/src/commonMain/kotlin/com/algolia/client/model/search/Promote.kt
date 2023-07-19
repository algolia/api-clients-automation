/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*

/**
 * Promote
 */
@Serializable(PromoteSerializer::class)
public sealed interface Promote {

  public companion object {

    /**
     * Record to promote.
     *
     * @param objectID Unique identifier of the record to promote.
     * @param position The position to promote the records to. If you pass objectIDs, the records are placed at this position as a group. For example, if you pronmote four objectIDs to position 0, the records take the first four positions.
     */
    public fun PromoteObjectID(
      objectID: String,
      position: Int,
    ): PromoteObjectID = com.algolia.client.model.search.PromoteObjectID(
      objectID = objectID,
      position = position,
    )

    /**
     * Records to promote.
     *
     * @param objectIDs Unique identifiers of the records to promote.
     * @param position The position to promote the records to. If you pass objectIDs, the records are placed at this position as a group. For example, if you pronmote four objectIDs to position 0, the records take the first four positions.
     */
    public fun PromoteObjectIDs(
      objectIDs: List<String>,
      position: Int,
    ): PromoteObjectIDs = com.algolia.client.model.search.PromoteObjectIDs(
      objectIDs = objectIDs,
      position = position,
    )
  }
}

internal class PromoteSerializer : KSerializer<Promote> {

  override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Promote")

  override fun serialize(encoder: Encoder, value: Promote) {
    when (value) {
      is PromoteObjectID -> PromoteObjectID.serializer().serialize(encoder, value)
      is PromoteObjectIDs -> PromoteObjectIDs.serializer().serialize(encoder, value)
    }
  }

  override fun deserialize(decoder: Decoder): Promote {
    val codec = decoder.asJsonDecoder()
    val tree = codec.decodeJsonElement()

    // deserialize PromoteObjectID
    if (tree is JsonObject) {
      try {
        return codec.json.decodeFromJsonElement<PromoteObjectID>(tree)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize PromoteObjectID (error: ${e.message})")
      }
    }

    // deserialize PromoteObjectIDs
    if (tree is JsonObject) {
      try {
        return codec.json.decodeFromJsonElement<PromoteObjectIDs>(tree)
      } catch (e: Exception) {
        // deserialization failed, continue
        println("Failed to deserialize PromoteObjectIDs (error: ${e.message})")
      }
    }

    throw AlgoliaClientException("Failed to deserialize json element: $tree")
  }
}
