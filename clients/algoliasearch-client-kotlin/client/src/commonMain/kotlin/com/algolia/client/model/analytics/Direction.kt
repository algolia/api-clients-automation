/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.analytics

import kotlinx.serialization.*

@Serializable
public enum class Direction(public val value: kotlin.String) {

  @SerialName(value = "asc")
  Asc("asc"),

  @SerialName(value = "desc")
  Desc("desc");

  override fun toString(): kotlin.String = value
}
