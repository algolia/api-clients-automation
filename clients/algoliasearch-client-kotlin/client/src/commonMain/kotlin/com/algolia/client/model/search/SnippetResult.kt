/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*
import kotlin.jvm.JvmInline

/**
 * SnippetResult
 *
 * Implementations:
 * - [List<SnippetResultOption>] - *[SnippetResult.of]*
 * - [Map<kotlin.String, SnippetResult>] - *[SnippetResult.of]*
 * - [Map<kotlin.String, SnippetResultOption>] - *[SnippetResult.of]*
 * - [SnippetResultOption]
 */
@Serializable(SnippetResultSerializer::class)
public sealed interface SnippetResult {
  @Serializable
  @JvmInline
  public value class MapOfkotlinStringSnippetResultValue(public val value: Map<kotlin.String, SnippetResult>) : SnippetResult

  @Serializable
  @JvmInline
  public value class MapOfkotlinStringSnippetResultOptionValue(public val value: Map<kotlin.String, SnippetResultOption>) : SnippetResult

  @Serializable
  @JvmInline
  public value class ListOfSnippetResultOptionValue(public val value: List<SnippetResultOption>) : SnippetResult

  public companion object {

    public fun ofMapOfkotlinStringSnippetResult(value: Map<kotlin.String, SnippetResult>): SnippetResult {
      return MapOfkotlinStringSnippetResultValue(value)
    }
    public fun ofMapOfkotlinStringSnippetResultOption(value: Map<kotlin.String, SnippetResultOption>): SnippetResult {
      return MapOfkotlinStringSnippetResultOptionValue(value)
    }
    public fun of(value: List<SnippetResultOption>): SnippetResult {
      return ListOfSnippetResultOptionValue(value)
    }
  }
}

internal class SnippetResultSerializer : JsonContentPolymorphicSerializer<SnippetResult>(SnippetResult::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<SnippetResult> {
    return when {
      element is JsonObject -> SnippetResult.MapOfkotlinStringSnippetResultValue.serializer()
      element is JsonObject -> SnippetResultOption.serializer()
      element is JsonObject -> SnippetResult.MapOfkotlinStringSnippetResultOptionValue.serializer()
      element.isJsonArrayOfObjects -> SnippetResult.ListOfSnippetResultOptionValue.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
