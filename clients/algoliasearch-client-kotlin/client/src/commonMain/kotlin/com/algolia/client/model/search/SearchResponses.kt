/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SearchResponses
 *
 * @param results
 */
@Serializable
public data class SearchResponses(

  @SerialName(value = "results") val results: List<SearchResult>,
)
