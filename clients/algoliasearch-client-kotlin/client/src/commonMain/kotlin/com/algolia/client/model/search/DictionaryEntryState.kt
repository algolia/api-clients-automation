/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*

/**
 * The state of the dictionary entry.
 */
@Serializable
public enum class DictionaryEntryState(public val value: kotlin.String) {

  @SerialName(value = "enabled")
  Enabled("enabled"),

  @SerialName(value = "disabled")
  Disabled("disabled");

  override fun toString(): kotlin.String = value
}
