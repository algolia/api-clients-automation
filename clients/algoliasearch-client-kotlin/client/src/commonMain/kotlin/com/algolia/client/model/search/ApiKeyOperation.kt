/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*

@Serializable
public enum class ApiKeyOperation(public val value: kotlin.String) {

  @SerialName(value = "add")
  Add("add"),

  @SerialName(value = "delete")
  Delete("delete"),

  @SerialName(value = "update")
  Update("update");

  override fun toString(): kotlin.String = value
}
