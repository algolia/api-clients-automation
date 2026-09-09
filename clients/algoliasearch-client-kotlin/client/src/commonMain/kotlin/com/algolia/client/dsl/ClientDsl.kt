@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.api.SearchClient
import com.algolia.client.dsl.deleteBy as buildDeleteBy
import com.algolia.client.dsl.generated.DeleteByParamsBuilder
import com.algolia.client.dsl.generated.IndexSettingsBuilder
import com.algolia.client.dsl.generated.SearchParamsObjectBuilder
import com.algolia.client.model.search.SearchParams
import com.algolia.client.model.search.SearchResponse
import com.algolia.client.model.search.UpdatedAtResponse
import com.algolia.client.transport.RequestOptions

/**
 * Searches a single index with a [query] DSL block.
 *
 * [SearchParamsObject] is not a [SearchParams]. This wraps [query] with [SearchParams.of].
 *
 * Do not use [SearchClient.search] for this: that method is multi-query.
 *
 * ```
 * val response =
 *   client.searchSingleIndex("idx") {
 *     query = "shoes"
 *     filters { facet("brand", "Apple") }
 *   }
 * ```
 */
@AlgoliaExperimentalDsl
public suspend fun SearchClient.searchSingleIndex(
  indexName: String,
  requestOptions: RequestOptions? = null,
  block: SearchParamsObjectBuilder.() -> Unit,
): SearchResponse =
  searchSingleIndex(
    indexName = indexName,
    searchParams = SearchParams.of(query(block = block)),
    requestOptions = requestOptions,
  )

/**
 * Updates index settings with a [settings] DSL block.
 *
 * ```
 * client.setSettings("idx") {
 *   searchableAttributes { ordered("name") }
 * }
 * ```
 */
@AlgoliaExperimentalDsl
public suspend fun SearchClient.setSettings(
  indexName: String,
  forwardToReplicas: Boolean? = null,
  requestOptions: RequestOptions? = null,
  block: IndexSettingsBuilder.() -> Unit,
): UpdatedAtResponse =
  setSettings(
    indexName = indexName,
    indexSettings = settings(block),
    forwardToReplicas = forwardToReplicas,
    requestOptions = requestOptions,
  )

/**
 * Deletes records that match a [deleteBy] DSL block.
 *
 * ```
 * client.deleteBy("idx") { filters { facet("brand", "Apple") } }
 * ```
 */
@AlgoliaExperimentalDsl
public suspend fun SearchClient.deleteBy(
  indexName: String,
  requestOptions: RequestOptions? = null,
  block: DeleteByParamsBuilder.() -> Unit,
): UpdatedAtResponse =
  deleteBy(
    indexName = indexName,
    deleteByParams = buildDeleteBy(block),
    requestOptions = requestOptions,
  )
