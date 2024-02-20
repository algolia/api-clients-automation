/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*

/**
 * SourceUpdateInput
 *
 * Implementations:
 * - [SourceBigQuery]
 * - [SourceCSV]
 * - [SourceJSON]
 * - [SourceUpdateCommercetools]
 * - [SourceUpdateDocker]
 */
@Serializable(SourceUpdateInputSerializer::class)
public sealed interface SourceUpdateInput {

  public companion object {
  }
}

internal class SourceUpdateInputSerializer : JsonContentPolymorphicSerializer<SourceUpdateInput>(SourceUpdateInput::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<SourceUpdateInput> {
    return when {
      element is JsonObject && element.containsKey("projectID") -> SourceBigQuery.serializer()
      element is JsonObject -> SourceUpdateCommercetools.serializer()
      element is JsonObject -> SourceJSON.serializer()
      element is JsonObject -> SourceCSV.serializer()
      element is JsonObject -> SourceUpdateDocker.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
