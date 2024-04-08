/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * userIDs data.
 *
 * @param hits User objects that match the query.
 * @param nbHits Number of results (hits).
 * @param page Page of search results to retrieve.
 * @param hitsPerPage Maximum number of hits per page.
 * @param updatedAt Date and time when the object was updated, in RFC 3339 format.
 */
@Serializable
public data class SearchUserIdsResponse(

  /** User objects that match the query. */
  @SerialName(value = "hits") val hits: List<UserHit>,

  /** Number of results (hits). */
  @SerialName(value = "nbHits") val nbHits: Int,

  /** Page of search results to retrieve. */
  @SerialName(value = "page") val page: Int,

  /** Maximum number of hits per page. */
  @SerialName(value = "hitsPerPage") val hitsPerPage: Int,

  /** Date and time when the object was updated, in RFC 3339 format. */
  @SerialName(value = "updatedAt") val updatedAt: String,
)
