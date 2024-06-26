/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SearchForHitsOptions
 *
 * @param indexName Index name (case-sensitive).
 * @param type
 */
@Serializable
public data class SearchForHitsOptions(

  /** Index name (case-sensitive). */
  @SerialName(value = "indexName") val indexName: String,

  @SerialName(value = "type") val type: SearchTypeDefault? = null,
)
