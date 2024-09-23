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
 * Maximum radius for a search around a central location.  This parameter works in combination with the `aroundLatLng` and `aroundLatLngViaIP` parameters. By default, the search radius is determined automatically from the density of hits around the central location. The search radius is small if there are many hits close to the central coordinates.
 *
 * Implementations:
 * - [AroundRadiusAll]
 * - [Int] - *[AroundRadius.of]*
 */
@Serializable(AroundRadiusSerializer::class)
public sealed interface AroundRadius {
  @Serializable
  @JvmInline
  public value class IntValue(public val value: Int) : AroundRadius

  @Serializable
  @JvmInline
  public value class AroundRadiusAllValue(public val value: AroundRadiusAll) : AroundRadius

  public companion object {

    public fun of(value: Int): AroundRadius {
      return IntValue(value)
    }
    public fun of(value: AroundRadiusAll): AroundRadius {
      return AroundRadiusAllValue(value)
    }
  }
}

internal class AroundRadiusSerializer : JsonContentPolymorphicSerializer<AroundRadius>(AroundRadius::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<AroundRadius> {
    return when {
      element.isInt -> AroundRadius.IntValue.serializer()
      element.isString -> AroundRadiusAll.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
