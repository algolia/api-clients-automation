/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.api

import com.algolia.client.configuration.*
import com.algolia.client.exception.*
import com.algolia.client.extensions.internal.*
import com.algolia.client.model.analytics.*
import com.algolia.client.transport.*
import com.algolia.client.transport.internal.*
import kotlinx.serialization.json.*

public class AnalyticsClient(
  override val appId: String,
  override val apiKey: String,
  public val region: String? = null,
  override val options: ClientOptions = ClientOptions(),
) : ApiClient {

  init {
    require(appId.isNotBlank()) { "`appId` is missing." }
    require(apiKey.isNotBlank()) { "`apiKey` is missing." }
  }

  override val requester: Requester = requesterOf(clientName = "Analytics", appId = appId, apiKey = apiKey, options = options) {
    val allowedRegions = listOf("de", "us")
    require(region == null || region in allowedRegions) { "`region` must be one of the following: ${allowedRegions.joinToString()}" }
    val url = if (region == null) "analytics.algolia.com" else "analytics.$region.algolia.com"
    listOf(Host(url))
  }

  /**
   * Send requests to the Algolia REST API.
   * This method allow you to send requests to the Algolia REST API.
   * @param path Path of the endpoint, anything after \"/1\" must be specified.
   * @param parameters Query parameters to apply to the current query.
   * @param requestOptions additional request configuration.
   */
  public suspend fun del(path: String, parameters: Map<kotlin.String, Any>? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `del`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.DELETE,
      path = "/1{path}".replace("{path}", path),
      query = buildMap {
        parameters?.let { putAll(it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Send requests to the Algolia REST API.
   * This method allow you to send requests to the Algolia REST API.
   * @param path Path of the endpoint, anything after \"/1\" must be specified.
   * @param parameters Query parameters to apply to the current query.
   * @param requestOptions additional request configuration.
   */
  public suspend fun get(path: String, parameters: Map<kotlin.String, Any>? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `get`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = "/1{path}".replace("{path}", path),
      query = buildMap {
        parameters?.let { putAll(it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get average click position.
   * Return the average click position for the complete time range and for individual days. > **Note**: If all `positions` have a `clickCount` of `0` or `null`, it means Algolia didn't receive any click events for tracked searches. A _tracked_ search is a search request where the `clickAnalytics` parameter is `true`.
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getAverageClickPosition(index: String, startDate: String? = null, endDate: String? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetAverageClickPositionResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getAverageClickPosition`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "clicks", "averageClickPosition"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get click positions.
   * Show the number of clicks events and their associated position in the search results.  > **Note**: If all `positions` have a `clickCount` of `0` or `null`, it means Algolia didn't receive any click events for tracked searches. A _tracked_ search is a search request where the `clickAnalytics` parameter is `true`.
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getClickPositions(index: String, startDate: String? = null, endDate: String? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetClickPositionsResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getClickPositions`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "clicks", "positions"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get click-through rate (CTR).
   * Returns a [click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getClickThroughRate(index: String, startDate: String? = null, endDate: String? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetClickThroughRateResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getClickThroughRate`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "clicks", "clickThroughRate"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get conversion rate (CR).
   * Return a [conversion rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate).
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getConversationRate(index: String, startDate: String? = null, endDate: String? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetConversationRateResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getConversationRate`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "conversions", "conversionRate"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get no click rate.
   * Returns the rate at which searches don't lead to any clicks. The endpoint returns a value for the complete given time range, as well as a value per day. It also returns the count of searches and searches without clicks.
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getNoClickRate(index: String, startDate: String? = null, endDate: String? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetNoClickRateResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getNoClickRate`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "searches", "noClickRate"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get no results rate.
   * Returns the rate at which searches didn't return any results.
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getNoResultsRate(index: String, startDate: String? = null, endDate: String? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetNoResultsRateResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getNoResultsRate`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "searches", "noResultRate"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get number of searches.
   * Returns the number of searches within a time range.
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getSearchesCount(index: String, startDate: String? = null, endDate: String? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetSearchesCountResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getSearchesCount`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "searches", "count"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get top searches with no clicks.
   * Return the most popular of the last 1,000 searches that didn't lead to any clicks.
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param limit Number of records to return (page size). (default to 10)
   * @param offset Position of the starting record. Used for paging. 0 is the first record. (default to 0)
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getSearchesNoClicks(index: String, startDate: String? = null, endDate: String? = null, limit: Int? = null, offset: Int? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetSearchesNoClicksResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getSearchesNoClicks`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "searches", "noClicks"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        limit?.let { put("limit", it) }
        offset?.let { put("offset", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get top searches with no results.
   * Returns the most popular of the latest 1,000 searches that didn't return any results.
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param limit Number of records to return (page size). (default to 10)
   * @param offset Position of the starting record. Used for paging. 0 is the first record. (default to 0)
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getSearchesNoResults(index: String, startDate: String? = null, endDate: String? = null, limit: Int? = null, offset: Int? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetSearchesNoResultsResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getSearchesNoResults`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "searches", "noResults"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        limit?.let { put("limit", it) }
        offset?.let { put("offset", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get Analytics API status.
   * Return the latest update time of the Analytics API for an index. If the index has been recently created or no search has been performed yet, `updatedAt` will be `null`. > **Note**: The Analytics API is updated every 5&nbsp;minutes.
   * @param index Index name to target.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getStatus(index: String, requestOptions: RequestOptions? = null): GetStatusResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getStatus`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "status"),
      query = buildMap {
        put("index", index)
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get top countries.
   * Returns top countries. Limited to the 1,000 most frequent ones.
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param limit Number of records to return (page size). (default to 10)
   * @param offset Position of the starting record. Used for paging. 0 is the first record. (default to 0)
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getTopCountries(index: String, startDate: String? = null, endDate: String? = null, limit: Int? = null, offset: Int? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetTopCountriesResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getTopCountries`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "countries"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        limit?.let { put("limit", it) }
        offset?.let { put("offset", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get top filterable attributes.
   * Return the most popular [filterable attributes](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) in the 1,000 most recently used filters.
   * @param index Index name to target.
   * @param search User query.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param limit Number of records to return (page size). (default to 10)
   * @param offset Position of the starting record. Used for paging. 0 is the first record. (default to 0)
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getTopFilterAttributes(index: String, search: String? = null, startDate: String? = null, endDate: String? = null, limit: Int? = null, offset: Int? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetTopFilterAttributesResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getTopFilterAttributes`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "filters"),
      query = buildMap {
        put("index", index)
        search?.let { put("search", it) }
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        limit?.let { put("limit", it) }
        offset?.let { put("offset", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get top filter values for an attribute.
   * Returns the most popular filter values for an attribute in the 1,000 most recently used filters.
   * @param attribute Attribute name.
   * @param index Index name to target.
   * @param search User query.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param limit Number of records to return (page size). (default to 10)
   * @param offset Position of the starting record. Used for paging. 0 is the first record. (default to 0)
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getTopFilterForAttribute(attribute: String, index: String, search: String? = null, startDate: String? = null, endDate: String? = null, limit: Int? = null, offset: Int? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetTopFilterForAttributeResponse {
    require(attribute.isNotBlank()) { "Parameter `attribute` is required when calling `getTopFilterForAttribute`." }
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getTopFilterForAttribute`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "filters", "$attribute"),
      query = buildMap {
        put("index", index)
        search?.let { put("search", it) }
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        limit?.let { put("limit", it) }
        offset?.let { put("offset", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get top filters for a no result search.
   * Returns top filters for filter-enabled searches that don't return results. Limited to the 1,000 most recently used filters.
   * @param index Index name to target.
   * @param search User query.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param limit Number of records to return (page size). (default to 10)
   * @param offset Position of the starting record. Used for paging. 0 is the first record. (default to 0)
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getTopFiltersNoResults(index: String, search: String? = null, startDate: String? = null, endDate: String? = null, limit: Int? = null, offset: Int? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetTopFiltersNoResultsResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getTopFiltersNoResults`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "filters", "noResults"),
      query = buildMap {
        put("index", index)
        search?.let { put("search", it) }
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        limit?.let { put("limit", it) }
        offset?.let { put("offset", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get top hits.
   * Return the most popular clicked results in the last 1,000 searches.
   * @param index Index name to target.
   * @param search User query.
   * @param clickAnalytics Whether to include [click and conversion](https://www.algolia.com/doc/guides/sending-events/getting-started/) rates for a search. (default to false)
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param limit Number of records to return (page size). (default to 10)
   * @param offset Position of the starting record. Used for paging. 0 is the first record. (default to 0)
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getTopHits(index: String, search: String? = null, clickAnalytics: Boolean? = null, startDate: String? = null, endDate: String? = null, limit: Int? = null, offset: Int? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetTopHitsResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getTopHits`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "hits"),
      query = buildMap {
        put("index", index)
        search?.let { put("search", it) }
        clickAnalytics?.let { put("clickAnalytics", it) }
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        limit?.let { put("limit", it) }
        offset?.let { put("offset", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get top searches.
   * Returns the most popular of the latest 1,000 searches. For each search, also returns the number of hits.
   * @param index Index name to target.
   * @param clickAnalytics Whether to include [click and conversion](https://www.algolia.com/doc/guides/sending-events/getting-started/) rates for a search. (default to false)
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param orderBy Reorder the results. (default to searchCount)
   * @param direction Sorting direction of the results: ascending or descending.  (default to asc)
   * @param limit Number of records to return (page size). (default to 10)
   * @param offset Position of the starting record. Used for paging. 0 is the first record. (default to 0)
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getTopSearches(index: String, clickAnalytics: Boolean? = null, startDate: String? = null, endDate: String? = null, orderBy: OrderBy? = null, direction: Direction? = null, limit: Int? = null, offset: Int? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetTopSearchesResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getTopSearches`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "searches"),
      query = buildMap {
        put("index", index)
        clickAnalytics?.let { put("clickAnalytics", it) }
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        orderBy?.let { put("orderBy", it) }
        direction?.let { put("direction", it) }
        limit?.let { put("limit", it) }
        offset?.let { put("offset", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get user count.
   * Return the count of unique users.
   * @param index Index name to target.
   * @param startDate Start date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param endDate End date (a string in the format `YYYY-MM-DD`) of the period to analyze.
   * @param tags Filter analytics on the [`analyticsTags`](https://www.algolia.com/doc/api-reference/api-parameters/analyticsTags/) set at search time. Multiple tags can be combined with the operators OR and AND. If a tag contains characters like spaces or parentheses, it must be URL-encoded.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getUsersCount(index: String, startDate: String? = null, endDate: String? = null, tags: String? = null, requestOptions: RequestOptions? = null): GetUsersCountResponse {
    require(index.isNotBlank()) { "Parameter `index` is required when calling `getUsersCount`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "users", "count"),
      query = buildMap {
        put("index", index)
        startDate?.let { put("startDate", it) }
        endDate?.let { put("endDate", it) }
        tags?.let { put("tags", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Send requests to the Algolia REST API.
   * This method allow you to send requests to the Algolia REST API.
   * @param path Path of the endpoint, anything after \"/1\" must be specified.
   * @param parameters Query parameters to apply to the current query.
   * @param body Parameters to send with the custom request.
   * @param requestOptions additional request configuration.
   */
  public suspend fun post(path: String, parameters: Map<kotlin.String, Any>? = null, body: JsonObject? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `post`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = "/1{path}".replace("{path}", path),
      query = buildMap {
        parameters?.let { putAll(it) }
      },
      body = body,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Send requests to the Algolia REST API.
   * This method allow you to send requests to the Algolia REST API.
   * @param path Path of the endpoint, anything after \"/1\" must be specified.
   * @param parameters Query parameters to apply to the current query.
   * @param body Parameters to send with the custom request.
   * @param requestOptions additional request configuration.
   */
  public suspend fun put(path: String, parameters: Map<kotlin.String, Any>? = null, body: JsonObject? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `put`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.PUT,
      path = "/1{path}".replace("{path}", path),
      query = buildMap {
        parameters?.let { putAll(it) }
      },
      body = body,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }
}
