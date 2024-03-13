/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*

/**
 * Search mode the index will use to query for results.  This setting only applies to indices, for which Algolia enabled NeuralSearch for you.
 */
@Serializable
public enum class Mode(public val value: kotlin.String) {

  @SerialName(value = "neuralSearch")
  NeuralSearch("neuralSearch"),

  @SerialName(value = "keywordSearch")
  KeywordSearch("keywordSearch");

  override fun toString(): kotlin.String = value
}
