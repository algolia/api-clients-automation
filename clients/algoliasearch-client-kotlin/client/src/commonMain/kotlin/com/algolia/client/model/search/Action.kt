/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*

/**
 * Type of indexing operation.
 */
@Serializable
public enum class Action(public val value: kotlin.String) {

  @SerialName(value = "addObject")
  AddObject("addObject"),

  @SerialName(value = "updateObject")
  UpdateObject("updateObject"),

  @SerialName(value = "partialUpdateObject")
  PartialUpdateObject("partialUpdateObject"),

  @SerialName(value = "partialUpdateObjectNoCreate")
  PartialUpdateObjectNoCreate("partialUpdateObjectNoCreate"),

  @SerialName(value = "deleteObject")
  DeleteObject("deleteObject"),

  @SerialName(value = "delete")
  Delete("delete"),

  @SerialName(value = "clear")
  Clear("clear");

  override fun toString(): kotlin.String = value
}
