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
 * Precision of a geographical search (in meters), to [group results that are more or less the same distance from a central point](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/in-depth/geo-ranking-precision/).
 *
 * Implementations:
 * - [Int] - *[AroundPrecision.of]*
 * - [List<AroundPrecisionFromValueInner>] - *[AroundPrecision.of]*
 */
@Serializable(AroundPrecisionSerializer::class)
public sealed interface AroundPrecision {
  @Serializable
  @JvmInline
  public value class IntValue(public val value: Int) : AroundPrecision

  @Serializable
  @JvmInline
  public value class ListOfAroundPrecisionFromValueInnerValue(public val value: List<AroundPrecisionFromValueInner>) : AroundPrecision

  public companion object {

    public fun of(value: Int): AroundPrecision {
      return IntValue(value)
    }
    public fun of(value: List<AroundPrecisionFromValueInner>): AroundPrecision {
      return ListOfAroundPrecisionFromValueInnerValue(value)
    }
  }
}

internal class AroundPrecisionSerializer : JsonContentPolymorphicSerializer<AroundPrecision>(AroundPrecision::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<AroundPrecision> {
    return when {
      element.isInt -> AroundPrecision.IntValue.serializer()
      element.isJsonArrayOfObjects -> AroundPrecision.ListOfAroundPrecisionFromValueInnerValue.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
