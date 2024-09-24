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
 * EventsItems
 *
 * Implementations:
 * - [AddedToCartObjectIDs]
 * - [AddedToCartObjectIDsAfterSearch]
 * - [ClickedFilters]
 * - [ClickedObjectIDs]
 * - [ClickedObjectIDsAfterSearch]
 * - [ConvertedFilters]
 * - [ConvertedObjectIDs]
 * - [ConvertedObjectIDsAfterSearch]
 * - [PurchasedObjectIDs]
 * - [PurchasedObjectIDsAfterSearch]
 * - [ViewedFilters]
 * - [ViewedObjectIDs]
 */
@Serializable(EventsItemsSerializer::class)
public sealed interface EventsItems {
  @Serializable
  @JvmInline
  public value class AddedToCartObjectIDsAfterSearchValue(public val value: AddedToCartObjectIDsAfterSearch) : EventsItems

  @Serializable
  @JvmInline
  public value class PurchasedObjectIDsAfterSearchValue(public val value: PurchasedObjectIDsAfterSearch) : EventsItems

  @Serializable
  @JvmInline
  public value class ClickedObjectIDsAfterSearchValue(public val value: ClickedObjectIDsAfterSearch) : EventsItems

  @Serializable
  @JvmInline
  public value class PurchasedObjectIDsValue(public val value: PurchasedObjectIDs) : EventsItems

  @Serializable
  @JvmInline
  public value class AddedToCartObjectIDsValue(public val value: AddedToCartObjectIDs) : EventsItems

  @Serializable
  @JvmInline
  public value class ConvertedObjectIDsAfterSearchValue(public val value: ConvertedObjectIDsAfterSearch) : EventsItems

  @Serializable
  @JvmInline
  public value class ClickedObjectIDsValue(public val value: ClickedObjectIDs) : EventsItems

  @Serializable
  @JvmInline
  public value class ConvertedObjectIDsValue(public val value: ConvertedObjectIDs) : EventsItems

  @Serializable
  @JvmInline
  public value class ClickedFiltersValue(public val value: ClickedFilters) : EventsItems

  @Serializable
  @JvmInline
  public value class ConvertedFiltersValue(public val value: ConvertedFilters) : EventsItems

  @Serializable
  @JvmInline
  public value class ViewedObjectIDsValue(public val value: ViewedObjectIDs) : EventsItems

  @Serializable
  @JvmInline
  public value class ViewedFiltersValue(public val value: ViewedFilters) : EventsItems

  public companion object {

    public fun of(value: AddedToCartObjectIDsAfterSearch): EventsItems {
      return AddedToCartObjectIDsAfterSearchValue(value)
    }
    public fun of(value: PurchasedObjectIDsAfterSearch): EventsItems {
      return PurchasedObjectIDsAfterSearchValue(value)
    }
    public fun of(value: ClickedObjectIDsAfterSearch): EventsItems {
      return ClickedObjectIDsAfterSearchValue(value)
    }
    public fun of(value: PurchasedObjectIDs): EventsItems {
      return PurchasedObjectIDsValue(value)
    }
    public fun of(value: AddedToCartObjectIDs): EventsItems {
      return AddedToCartObjectIDsValue(value)
    }
    public fun of(value: ConvertedObjectIDsAfterSearch): EventsItems {
      return ConvertedObjectIDsAfterSearchValue(value)
    }
    public fun of(value: ClickedObjectIDs): EventsItems {
      return ClickedObjectIDsValue(value)
    }
    public fun of(value: ConvertedObjectIDs): EventsItems {
      return ConvertedObjectIDsValue(value)
    }
    public fun of(value: ClickedFilters): EventsItems {
      return ClickedFiltersValue(value)
    }
    public fun of(value: ConvertedFilters): EventsItems {
      return ConvertedFiltersValue(value)
    }
    public fun of(value: ViewedObjectIDs): EventsItems {
      return ViewedObjectIDsValue(value)
    }
    public fun of(value: ViewedFilters): EventsItems {
      return ViewedFiltersValue(value)
    }
  }
}

internal class EventsItemsSerializer : JsonContentPolymorphicSerializer<EventsItems>(EventsItems::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<EventsItems> {
    return when {
      element is JsonObject && element.containsKey("eventType") && element.containsKey("eventSubtype") && element.containsKey("queryID") && element.containsKey("objectIDs") -> AddedToCartObjectIDsAfterSearch.serializer()
      element is JsonObject && element.containsKey("eventType") && element.containsKey("eventSubtype") && element.containsKey("objectIDs") && element.containsKey("objectData") -> PurchasedObjectIDsAfterSearch.serializer()
      element is JsonObject && element.containsKey("positions") && element.containsKey("queryID") && element.containsKey("eventType") -> ClickedObjectIDsAfterSearch.serializer()
      element is JsonObject && element.containsKey("eventType") && element.containsKey("eventSubtype") && element.containsKey("objectIDs") -> PurchasedObjectIDs.serializer()
      element is JsonObject && element.containsKey("eventType") && element.containsKey("eventSubtype") && element.containsKey("objectIDs") -> AddedToCartObjectIDs.serializer()
      element is JsonObject && element.containsKey("queryID") && element.containsKey("eventType") -> ConvertedObjectIDsAfterSearch.serializer()
      element is JsonObject && element.containsKey("eventType") && element.containsKey("objectIDs") -> ClickedObjectIDs.serializer()
      element is JsonObject && element.containsKey("eventType") && element.containsKey("objectIDs") -> ConvertedObjectIDs.serializer()
      element is JsonObject && element.containsKey("eventType") && element.containsKey("filters") -> ClickedFilters.serializer()
      element is JsonObject && element.containsKey("eventType") && element.containsKey("filters") -> ConvertedFilters.serializer()
      element is JsonObject && element.containsKey("eventType") && element.containsKey("objectIDs") -> ViewedObjectIDs.serializer()
      element is JsonObject && element.containsKey("eventType") && element.containsKey("filters") -> ViewedFilters.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
