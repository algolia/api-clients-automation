/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SearchRulesResponse
 *
 * @param hits Rules that matched the search criteria.
 * @param nbHits Number of rules that matched the search criteria.
 * @param page Current page.
 * @param nbPages Number of pages.
 */
@Serializable
public data class SearchRulesResponse(

  /** Rules that matched the search criteria. */
  @SerialName(value = "hits") val hits: List<Rule>,

  /** Number of rules that matched the search criteria. */
  @SerialName(value = "nbHits") val nbHits: Int,

  /** Current page. */
  @SerialName(value = "page") val page: Int,

  /** Number of pages. */
  @SerialName(value = "nbPages") val nbPages: Int,
)
