/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.usage

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*
import kotlin.jvm.JvmInline

/**
 * StatisticValue
 *
 * Implementations:
 * - [Int] - *[StatisticValue.of]*
 * - [Map<kotlin.String, Int>] - *[StatisticValue.of]*
 */
@Serializable(StatisticValueSerializer::class)
public sealed interface StatisticValue {
  @Serializable
  @JvmInline
  public value class IntValue(public val value: Int) : StatisticValue

  @Serializable
  @JvmInline
  public value class MapOfkotlinStringIntValue(public val value: Map<kotlin.String, Int>) : StatisticValue

  public companion object {

    public fun of(value: Int): StatisticValue {
      return IntValue(value)
    }
    public fun of(value: Map<kotlin.String, Int>): StatisticValue {
      return MapOfkotlinStringIntValue(value)
    }
  }
}

internal class StatisticValueSerializer : JsonContentPolymorphicSerializer<StatisticValue>(StatisticValue::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<StatisticValue> {
    return when {
      element.isInt -> StatisticValue.IntValue.serializer()
      element is JsonObject -> StatisticValue.MapOfkotlinStringIntValue.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
