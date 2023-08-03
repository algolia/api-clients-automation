/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * BaseSearchResponse
 *
 * @param exhaustiveNbHits Indicates whether the number of hits `nbHits` is exhaustive (exact) or approximate.
 * @param hitsPerPage Number of hits per page.
 * @param nbHits Number of hits the search query matched.
 * @param nbPages Number of pages of results for the current query.
 * @param page Page to retrieve (the first page is `0`, not `1`).
 * @param processingTimeMS Time the server took to process the request, in milliseconds.
 * @param abTestID A/B test ID. This is only included in the response for indices that are part of an A/B test.
 * @param abTestVariantID Variant ID. This is only included in the response for indices that are part of an A/B test.
 * @param aroundLatLng Computed geographical location.
 * @param automaticRadius Automatically-computed radius.
 * @param exhaustiveFacetsCount Indicates whether the facet count is exhaustive (exact) or approximate.
 * @param exhaustiveTypo Indicates whether the search for typos was exhaustive (exact) or approximate.
 * @param facets Mapping of each facet name to the corresponding facet counts.
 * @param facetsStats Statistics for numerical facets.
 * @param index Index name used for the query.
 * @param indexUsed Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query.
 * @param message Warnings about the query.
 * @param nbSortedHits Number of hits selected and sorted by the relevant sort algorithm.
 * @param redirect
 * @param parsedQuery Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched.
 * @param queryAfterRemoval Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.
 * @param serverUsed Host name of the server that processed the request.
 * @param userData Lets you store custom data in your indices.
 * @param renderingContent
 */
@Serializable
public data class BaseSearchResponse(

  /** Indicates whether the number of hits `nbHits` is exhaustive (exact) or approximate. */
  @SerialName(value = "exhaustiveNbHits") val exhaustiveNbHits: Boolean,

  /** Number of hits per page. */
  @SerialName(value = "hitsPerPage") val hitsPerPage: Int,

  /** Number of hits the search query matched. */
  @SerialName(value = "nbHits") val nbHits: Int,

  /** Number of pages of results for the current query. */
  @SerialName(value = "nbPages") val nbPages: Int,

  /** Page to retrieve (the first page is `0`, not `1`). */
  @SerialName(value = "page") val page: Int,

  /** Time the server took to process the request, in milliseconds. */
  @SerialName(value = "processingTimeMS") val processingTimeMS: Int,

  /** A/B test ID. This is only included in the response for indices that are part of an A/B test. */
  @SerialName(value = "abTestID") val abTestID: Int? = null,

  /** Variant ID. This is only included in the response for indices that are part of an A/B test. */
  @SerialName(value = "abTestVariantID") val abTestVariantID: Int? = null,

  /** Computed geographical location. */
  @SerialName(value = "aroundLatLng") val aroundLatLng: String? = null,

  /** Automatically-computed radius. */
  @SerialName(value = "automaticRadius") val automaticRadius: String? = null,

  /** Indicates whether the facet count is exhaustive (exact) or approximate. */
  @SerialName(value = "exhaustiveFacetsCount") val exhaustiveFacetsCount: Boolean? = null,

  /** Indicates whether the search for typos was exhaustive (exact) or approximate. */
  @SerialName(value = "exhaustiveTypo") val exhaustiveTypo: Boolean? = null,

  /** Mapping of each facet name to the corresponding facet counts. */
  @SerialName(value = "facets") val facets: Map<kotlin.String, Map<kotlin.String, Int>>? = null,

  /** Statistics for numerical facets. */
  @SerialName(value = "facets_stats") val facetsStats: Map<kotlin.String, FacetsStats>? = null,

  /** Index name used for the query. */
  @SerialName(value = "index") val index: String? = null,

  /** Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query. */
  @SerialName(value = "indexUsed") val indexUsed: String? = null,

  /** Warnings about the query. */
  @SerialName(value = "message") val message: String? = null,

  /** Number of hits selected and sorted by the relevant sort algorithm. */
  @SerialName(value = "nbSortedHits") val nbSortedHits: Int? = null,

  @SerialName(value = "redirect") val redirect: BaseSearchResponseRedirect? = null,

  /** Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched. */
  @SerialName(value = "parsedQuery") val parsedQuery: String? = null,

  /** Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set. */
  @SerialName(value = "queryAfterRemoval") val queryAfterRemoval: String? = null,

  /** Host name of the server that processed the request. */
  @SerialName(value = "serverUsed") val serverUsed: String? = null,

  /** Lets you store custom data in your indices. */
  @SerialName(value = "userData") val userData: JsonObject? = null,

  @SerialName(value = "renderingContent") val renderingContent: RenderingContent? = null,
)
