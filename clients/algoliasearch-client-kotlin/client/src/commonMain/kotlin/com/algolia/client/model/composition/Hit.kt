/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.composition

import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*

/**
 * Search result.  A hit is a record from your index, augmented with special attributes for highlighting, snippeting, and ranking.
 *
 * @param objectID Unique record identifier.
 * @param highlightResult Surround words that match the query with HTML tags for highlighting.
 * @param snippetResult Snippets that show the context around a matching search query.
 * @param rankingInfo
 * @param distinctSeqID
 */
@Serializable(HitSerializer::class)
public data class Hit(

  /** Unique record identifier. */
  val objectID: String,

  /** Surround words that match the query with HTML tags for highlighting. */
  val highlightResult: Map<kotlin.String, HighlightResult>? = null,

  /** Snippets that show the context around a matching search query. */
  val snippetResult: Map<kotlin.String, SnippetResult>? = null,

  val rankingInfo: HitRankingInfo? = null,

  val distinctSeqID: Int? = null,

  val additionalProperties: Map<String, JsonElement>? = null,
)

internal object HitSerializer : KSerializer<Hit> {

  override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Hit") {
    element<String>("objectID")
    element<Map<kotlin.String, HighlightResult>>("_highlightResult", isOptional = true)
    element<Map<kotlin.String, SnippetResult>>("_snippetResult", isOptional = true)
    element<HitRankingInfo>("_rankingInfo", isOptional = true)
    element<Int>("_distinctSeqID", isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Hit {
    val input = decoder.asJsonDecoder()
    val tree = input.decodeJsonObject()
    return Hit(
      objectID = tree.getValue("objectID").let { input.json.decodeFromJsonElement(it) },
      highlightResult = tree["_highlightResult"]?.let { input.json.decodeFromJsonElement(it) },
      snippetResult = tree["_snippetResult"]?.let { input.json.decodeFromJsonElement(it) },
      rankingInfo = tree["_rankingInfo"]?.let { input.json.decodeFromJsonElement(it) },
      distinctSeqID = tree["_distinctSeqID"]?.let { input.json.decodeFromJsonElement(it) },
      additionalProperties = tree.filterKeys { it !in descriptor.elementNames },
    )
  }

  override fun serialize(encoder: Encoder, value: Hit) {
    val output = encoder.asJsonEncoder()
    val json = buildJsonObject {
      put("objectID", output.json.encodeToJsonElement(value.objectID))
      value.highlightResult?.let { put("_highlightResult", output.json.encodeToJsonElement(it)) }
      value.snippetResult?.let { put("_snippetResult", output.json.encodeToJsonElement(it)) }
      value.rankingInfo?.let { put("_rankingInfo", output.json.encodeToJsonElement(it)) }
      value.distinctSeqID?.let { put("_distinctSeqID", output.json.encodeToJsonElement(it)) }
      value.additionalProperties?.onEach { (key, element) -> put(key, element) }
    }
    (encoder as JsonEncoder).encodeJsonElement(json)
  }
}
