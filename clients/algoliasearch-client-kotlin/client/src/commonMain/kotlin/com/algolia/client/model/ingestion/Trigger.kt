/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import com.algolia.client.exception.AlgoliaClientException
import com.algolia.client.extensions.internal.*
import kotlinx.serialization.*
import kotlinx.serialization.builtins.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.json.*

/**
 * Trigger
 *
 * Implementations:
 * - [OnDemandTrigger]
 * - [ScheduleTrigger]
 * - [SubscriptionTrigger]
 */
@Serializable(TriggerSerializer::class)
public sealed interface Trigger {

  public companion object {
  }
}

internal class TriggerSerializer : JsonContentPolymorphicSerializer<Trigger>(Trigger::class) {
  override fun selectDeserializer(element: JsonElement): DeserializationStrategy<Trigger> {
    return when {
      element is JsonObject -> OnDemandTrigger.serializer()
      element is JsonObject -> ScheduleTrigger.serializer()
      element is JsonObject -> SubscriptionTrigger.serializer()
      else -> throw AlgoliaClientException("Failed to deserialize json element: $element")
    }
  }
}
