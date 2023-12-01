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
 * Treats singular, plurals, and other forms of declensions as matching terms. `ignorePlurals` is used in conjunction with the `queryLanguages` setting. _list_: language ISO codes for which ignoring plurals should be enabled. This list will override any values that you may have set in `queryLanguages`. _true_: enables the ignore plurals feature, where singulars and plurals are considered equivalent (\"foot\" = \"feet\"). The languages supported here are either [every language](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/) (this is the default) or those set by `queryLanguages`. _false_: turns off the ignore plurals feature, so that singulars and plurals aren't considered to be the same (\"foot\" will not find \"feet\").
 *
 * Implementations:
 * - [Boolean] - *[IgnorePlurals.of]*
 * - [List<String>] - *[IgnorePlurals.of]*
 */
@Serializable(IgnorePluralsSerializer::class)
public sealed interface IgnorePlurals {
  @Serializable
  @JvmInline
  public value class ListOfStringValue(public val value: List<String>) : IgnorePlurals

  @Serializable
  @JvmInline
  public value class BooleanValue(public val value: Boolean) : IgnorePlurals

  public companion object {

    public fun of(value: List<String>): IgnorePlurals {
      return ListOfStringValue(value)
    }
    public fun of(value: Boolean): IgnorePlurals {
      return BooleanValue(value)
    }
  }
}

internal class IgnorePluralsSerializer : JsonContentPolymorphicSerializer<IgnorePlurals>(IgnorePlurals::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<IgnorePlurals> {
    return when {
      element.isJsonArrayOfPrimitives -> IgnorePlurals.ListOfStringValue.serializer()
      element.isBoolean -> IgnorePlurals.BooleanValue.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
