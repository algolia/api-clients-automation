/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*

/**
 * Whether the whole query string matches or only a part.
 */
@Serializable
public enum class MatchLevel(public val value: kotlin.String) {

  @SerialName(value = "none")
  None("none"),

  @SerialName(value = "partial")
  Partial("partial"),

  @SerialName(value = "full")
  Full("full");

  override fun toString(): kotlin.String = value
}
