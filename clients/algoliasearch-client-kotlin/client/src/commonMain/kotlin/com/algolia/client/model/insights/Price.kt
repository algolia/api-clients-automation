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
 * Total price of a product, including any discounts, in units of `currency`.
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

    public fun of(value: Double): Price = DoubleValue(value)

    public fun of(value: String): Price = StringValue(value)
  }
}

internal class PriceSerializer : JsonContentPolymorphicSerializer<Price>(Price::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Price> = when {
    element.isDouble -> Price.DoubleValue.serializer()
    element.isString -> Price.StringValue.serializer()
    else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
  }
}
