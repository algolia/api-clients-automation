/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SearchSynonymsParams
 *
 * @param query Search query.
 * @param type
 * @param page Page of search results to retrieve.
 * @param hitsPerPage Number of hits per page.
 */
@Serializable
public data class SearchSynonymsParams(

  /** Search query. */
  @SerialName(value = "query") val query: String? = null,

  @SerialName(value = "type") val type: SynonymType? = null,

  /** Page of search results to retrieve. */
  @SerialName(value = "page") val page: Int? = null,

  /** Number of hits per page. */
  @SerialName(value = "hitsPerPage") val hitsPerPage: Int? = null,
)
