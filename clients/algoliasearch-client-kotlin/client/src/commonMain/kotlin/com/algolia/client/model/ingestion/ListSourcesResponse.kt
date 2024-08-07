/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.ingestion

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * ListSourcesResponse
 *
 * @param sources
 * @param pagination
 */
@Serializable
public data class ListSourcesResponse(

  @SerialName(value = "sources") val sources: List<Source>,

  @SerialName(value = "pagination") val pagination: Pagination,
)
