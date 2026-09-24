@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.api.SearchClient
import com.algolia.client.dsl.deleteBy as buildDeleteBy
import com.algolia.client.model.search.SearchParams
import com.algolia.client.model.search.SearchResponse
import com.algolia.client.model.search.UpdatedAtResponse
import com.algolia.client.transport.RequestOptions

/**
 * Searches a single index with a [query] DSL block.
 *
 * Wraps [query] with [SearchParams.of] for symmetry with the generated method. [SearchParamsObject]
 * is a [SearchParams].
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
  block: QueryBuilder.() -> Unit,
): SearchResponse =
  searchSingleIndex(
    indexName = indexName,
    searchParams = SearchParams.of(query(block = block)),
    requestOptions = requestOptions,
  )

/**
 * Searches [indexName] with the parameters [composer] builds; `build()` runs on each call, so a
 * fragment added between two calls is sent by the second.
 */
@AlgoliaExperimentalDsl
public suspend fun SearchClient.searchSingleIndex(
  indexName: String,
  composer: QueryComposer,
  requestOptions: RequestOptions? = null,
): SearchResponse = searchSingleIndex(indexName, SearchParams.of(composer.build()), requestOptions)

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
  block: SettingsBuilder.() -> Unit,
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
  block: DeleteByBuilder.() -> Unit,
): UpdatedAtResponse =
  deleteBy(
    indexName = indexName,
    deleteByParams = buildDeleteBy(block),
    requestOptions = requestOptions,
  )

/**
 * Deletes from [indexName] the records matching the parameters [composer] builds; `build()` runs on
 * each call, so a fragment added between two calls is applied by the second.
 */
@AlgoliaExperimentalDsl
public suspend fun SearchClient.deleteBy(
  indexName: String,
  composer: DeleteByComposer,
  requestOptions: RequestOptions? = null,
): UpdatedAtResponse = deleteBy(indexName, composer.build(), requestOptions)
