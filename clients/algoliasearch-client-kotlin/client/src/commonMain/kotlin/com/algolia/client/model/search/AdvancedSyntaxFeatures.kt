/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*

@Serializable
public enum class AdvancedSyntaxFeatures(public val value: kotlin.String) {

  @SerialName(value = "exactPhrase")
  ExactPhrase("exactPhrase"),

  @SerialName(value = "excludeWords")
  ExcludeWords("excludeWords");

  override fun toString(): kotlin.String = value
}
