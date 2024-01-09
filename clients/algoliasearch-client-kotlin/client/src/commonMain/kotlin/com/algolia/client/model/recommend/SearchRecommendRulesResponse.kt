/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SearchRecommendRulesResponse
 *
 * @param hits Fetched rules.
 * @param nbHits Number of hits the search query matched.
 * @param page Page to retrieve (the first page is `0`, not `1`).
 * @param nbPages Number of pages of results for the current query.
 */
@Serializable
public data class SearchRecommendRulesResponse(

  /** Fetched rules. */
  @SerialName(value = "hits") val hits: List<RuleResponse>,

  /** Number of hits the search query matched. */
  @SerialName(value = "nbHits") val nbHits: Int,

  /** Page to retrieve (the first page is `0`, not `1`). */
  @SerialName(value = "page") val page: Int,

  /** Number of pages of results for the current query. */
  @SerialName(value = "nbPages") val nbPages: Int,
)
