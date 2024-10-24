/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.search

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SearchDictionaryEntriesResponse
 *
 * @param hits Dictionary entries matching the search criteria.
 * @param page Requested page of the API response.  Algolia uses `page` and `hitsPerPage` to control how search results are displayed ([paginated](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/)).  - `hitsPerPage`: sets the number of search results (_hits_) displayed per page. - `page`: specifies the page number of the search results you want to retrieve. Page numbering starts at 0, so the first page is `page=0`, the second is `page=1`, and so on.  For example, to display 10 results per page starting from the third page, set `hitsPerPage` to 10 and `page` to 2.
 * @param nbHits Number of results (hits).
 * @param nbPages Number of pages of results.
 */
@Serializable
public data class SearchDictionaryEntriesResponse(

  /** Dictionary entries matching the search criteria. */
  @SerialName(value = "hits") val hits: List<DictionaryEntry>,

  /** Requested page of the API response.  Algolia uses `page` and `hitsPerPage` to control how search results are displayed ([paginated](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/)).  - `hitsPerPage`: sets the number of search results (_hits_) displayed per page. - `page`: specifies the page number of the search results you want to retrieve. Page numbering starts at 0, so the first page is `page=0`, the second is `page=1`, and so on.  For example, to display 10 results per page starting from the third page, set `hitsPerPage` to 10 and `page` to 2.  */
  @SerialName(value = "page") val page: Int,

  /** Number of results (hits). */
  @SerialName(value = "nbHits") val nbHits: Int,

  /** Number of pages of results. */
  @SerialName(value = "nbPages") val nbPages: Int,
)
