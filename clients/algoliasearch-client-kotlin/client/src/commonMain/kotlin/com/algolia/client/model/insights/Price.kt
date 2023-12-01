/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.insights

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*
import kotlin.jvm.JvmInline

/**
 * The price of the item. This should be the final price, inclusive of any discounts in effect.
 *
 * Implementations:
 * - [Double] - *[Price.of]*
 * - [String] - *[Price.of]*
 */
@Serializable(PriceSerializer::class)
public sealed interface Price {
  @Serializable
  @JvmInline
  public value class DoubleValue(public val value: Double) : Price

  @Serializable
  @JvmInline
  public value class StringValue(public val value: String) : Price

  public companion object {

    public fun of(value: Double): Price {
      return DoubleValue(value)
    }
    public fun of(value: String): Price {
      return StringValue(value)
    }
  }
}

internal class PriceSerializer : JsonContentPolymorphicSerializer<Price>(Price::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Price> {
    return when {
      element.isDouble -> Price.DoubleValue.serializer()
      element.isString -> Price.StringValue.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
