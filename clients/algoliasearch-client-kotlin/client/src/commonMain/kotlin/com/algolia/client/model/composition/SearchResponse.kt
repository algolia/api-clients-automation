/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.composition

import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*

/**
 * SearchResponse
 *
 * @param results Search results.
 * @param compositions
 */
@Serializable(SearchResponseSerializer::class)
public data class SearchResponse(

  /** Search results. */
  val results: List<SearchResultsItem>,

  val compositions: CompositionsSearchResponse? = null,

  val additionalProperties: Map<String, JsonElement>? = null,
)

internal object SearchResponseSerializer : KSerializer<SearchResponse> {

  override val descriptor: SerialDescriptor = buildClassSerialDescriptor("SearchResponse") {
    element<List<SearchResultsItem>>("results")
    element<CompositionsSearchResponse>("compositions", isOptional = true)
  }

  override fun deserialize(decoder: Decoder): SearchResponse {
    val input = decoder.asJsonDecoder()
    val tree = input.decodeJsonObject()
    return SearchResponse(
      results = tree.getValue("results").let { input.json.decodeFromJsonElement(it) },
      compositions = tree["compositions"]?.let { input.json.decodeFromJsonElement(it) },
      additionalProperties = tree.filterKeys { it !in descriptor.elementNames },
    )
  }

  override fun serialize(encoder: Encoder, value: SearchResponse) {
    val output = encoder.asJsonEncoder()
    val json = buildJsonObject {
      put("results", output.json.encodeToJsonElement(value.results))
      value.compositions?.let { put("compositions", output.json.encodeToJsonElement(it)) }
      value.additionalProperties?.onEach { (key, element) -> put(key, element) }
    }
    (encoder as JsonEncoder).encodeJsonElement(json)
  }
}
