/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*

@Serializable
public enum class MappingTypeCSV(public val value: kotlin.String) {

  @SerialName(value = "string")
  String("string"),

  @SerialName(value = "integer")
  Integer("integer"),

  @SerialName(value = "float")
  Float("float"),

  @SerialName(value = "boolean")
  Boolean("boolean"),

  @SerialName(value = "json")
  Json("json");

  override fun toString(): kotlin.String = value
}
