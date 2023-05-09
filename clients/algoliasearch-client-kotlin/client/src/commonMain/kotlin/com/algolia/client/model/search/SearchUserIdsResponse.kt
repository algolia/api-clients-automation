/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * userIDs data.
 *
 * @param hits List of user object matching the query.
 * @param nbHits Number of hits that the search query matched.
 * @param page Specify the page to retrieve.
 * @param hitsPerPage Maximum number of hits in a page. Minimum is 1, maximum is 1000.
 * @param updatedAt Date of last update (ISO-8601 format).
 */
@Serializable
public data class SearchUserIdsResponse(

  /** List of user object matching the query. */
  @SerialName(value = "hits") val hits: List<UserHit>,

  /** Number of hits that the search query matched. */
  @SerialName(value = "nbHits") val nbHits: Int,

  /** Specify the page to retrieve. */
  @SerialName(value = "page") val page: Int,

  /** Maximum number of hits in a page. Minimum is 1, maximum is 1000. */
  @SerialName(value = "hitsPerPage") val hitsPerPage: Int,

  /** Date of last update (ISO-8601 format). */
  @SerialName(value = "updatedAt") val updatedAt: String,
)
