/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SearchMethodParams
 *
 * @param requests
 * @param strategy
 */
@Serializable
public data class SearchMethodParams(

  @SerialName(value = "requests") val requests: List<SearchQuery>,

  @SerialName(value = "strategy") val strategy: SearchStrategy? = null,
)
