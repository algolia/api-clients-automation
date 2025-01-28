/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.composition

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*
import kotlin.jvm.JvmInline

/**
 * Precision of a coordinate-based search in meters to group results with similar distances.  The Geo ranking criterion considers all matches within the same range of distances to be equal.
 *
 * Implementations:
 * - [Int] - *[AroundPrecision.of]*
 * - [List<Range>] - *[AroundPrecision.of]*
 */
@Serializable(AroundPrecisionSerializer::class)
public sealed interface AroundPrecision {
  @Serializable
  @JvmInline
  public value class IntValue(public val value: Int) : AroundPrecision

  @Serializable
  @JvmInline
  public value class ListOfRangeValue(public val value: List<Range>) : AroundPrecision

  public companion object {

    public fun of(value: Int): AroundPrecision = IntValue(value)

    public fun of(value: List<Range>): AroundPrecision = ListOfRangeValue(value)
  }
}

internal class AroundPrecisionSerializer : JsonContentPolymorphicSerializer<AroundPrecision>(AroundPrecision::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<AroundPrecision> = when {
    element.isInt -> AroundPrecision.IntValue.serializer()
    element is JsonArray -> AroundPrecision.ListOfRangeValue.serializer()
    else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
  }
}
