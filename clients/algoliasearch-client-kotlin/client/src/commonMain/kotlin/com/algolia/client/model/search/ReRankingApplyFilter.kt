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
 * Restrict [Dynamic Re-ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/) to records that match these filters.
 *
 * Implementations:
 * - [List<MixedSearchFilters>] - *[ReRankingApplyFilter.of]*
 * - [String] - *[ReRankingApplyFilter.of]*
 */
@Serializable(ReRankingApplyFilterSerializer::class)
public sealed interface ReRankingApplyFilter {
  @Serializable
  @JvmInline
  public value class ListOfMixedSearchFiltersValue(public val value: List<MixedSearchFilters>) : ReRankingApplyFilter

  @Serializable
  @JvmInline
  public value class StringValue(public val value: String) : ReRankingApplyFilter

  public companion object {

    public fun of(value: List<MixedSearchFilters>): ReRankingApplyFilter {
      return ListOfMixedSearchFiltersValue(value)
    }
    public fun of(value: String): ReRankingApplyFilter {
      return StringValue(value)
    }
  }
}

internal class ReRankingApplyFilterSerializer : JsonContentPolymorphicSerializer<ReRankingApplyFilter>(ReRankingApplyFilter::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<ReRankingApplyFilter> {
    return when {
      element.isJsonArrayOfObjects -> ReRankingApplyFilter.ListOfMixedSearchFiltersValue.serializer()
      element.isString -> ReRankingApplyFilter.StringValue.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
