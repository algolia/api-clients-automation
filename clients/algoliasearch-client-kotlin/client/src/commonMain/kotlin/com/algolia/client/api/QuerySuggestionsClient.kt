/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.api

import com.algolia.client.configuration.*
import com.algolia.client.exception.*
import com.algolia.client.extensions.internal.*
import com.algolia.client.model.querysuggestions.*
import com.algolia.client.transport.*
import com.algolia.client.transport.internal.*
import kotlinx.serialization.json.*

public class QuerySuggestionsClient(
  override val appId: String,
  override val apiKey: String,
  public val region: String,
  override val options: ClientOptions = ClientOptions(),
) : ApiClient {

  init {
    require(appId.isNotBlank()) { "`appId` is missing." }
    require(apiKey.isNotBlank()) { "`apiKey` is missing." }
  }

  override val requester: Requester = requesterOf(clientName = "QuerySuggestions", appId = appId, apiKey = apiKey, options = options) {
    val allowedRegions = listOf("eu", "us")
    require(region in allowedRegions) { "`region` is required and must be one of the following: ${allowedRegions.joinToString()}" }
    val url = "query-suggestions.$region.algolia.com"
    listOf(Host(url))
  }

  /**
   * Create a configuration.
   * Create a configuration of a Query Suggestions index. There's a limit of 100 configurations per application.
   * @param querySuggestionsIndexWithIndexParam
   * @param requestOptions additional request configuration.
   */
  public suspend fun createConfig(querySuggestionsIndexWithIndexParam: QuerySuggestionsIndexWithIndexParam, requestOptions: RequestOptions? = null): SuccessResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("1", "configs"),
      body = querySuggestionsIndexWithIndexParam,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Send requests to the Algolia REST API.
   * This method allow you to send requests to the Algolia REST API.
   * @param path The path of the API endpoint to target, anything after the /1 needs to be specified.
   * @param parameters Query parameters to be applied to the current query.
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
   * Delete a configuration.
   * Delete a configuration of a Query Suggestion's index. By deleting a configuration, you stop all updates to the underlying query suggestion index. Note that when doing this, the underlying index does not change - existing suggestions remain untouched.
   * @param indexName The index in which to perform the request.
   * @param requestOptions additional request configuration.
   */
  public suspend fun deleteConfig(indexName: String, requestOptions: RequestOptions? = null): SuccessResponse {
    require(indexName.isNotBlank()) { "Parameter `indexName` is required when calling `deleteConfig`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.DELETE,
      path = listOf("1", "configs", "$indexName"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Send requests to the Algolia REST API.
   * This method allow you to send requests to the Algolia REST API.
   * @param path The path of the API endpoint to target, anything after the /1 needs to be specified.
   * @param parameters Query parameters to be applied to the current query.
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
   * List configurations.
   * Get all the configurations of Query Suggestions. For each index, you get a block of JSON with a list of its configuration settings.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getAllConfigs(requestOptions: RequestOptions? = null): List<QuerySuggestionsIndex> {
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("1", "configs"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get a single configuration.
   * Get the configuration of a single Query Suggestions index.
   * @param indexName The index in which to perform the request.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getConfig(indexName: String, requestOptions: RequestOptions? = null): QuerySuggestionsIndex {
    require(indexName.isNotBlank()) { "Parameter `indexName` is required when calling `getConfig`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("1", "configs", "$indexName"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get configuration status.
   * Get the status of a Query Suggestion's index. The status includes whether the Query Suggestions index is currently in the process of being built, and the last build time.
   * @param indexName The index in which to perform the request.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getConfigStatus(indexName: String, requestOptions: RequestOptions? = null): Status {
    require(indexName.isNotBlank()) { "Parameter `indexName` is required when calling `getConfigStatus`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("1", "configs", "$indexName", "status"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get a log file.
   * Get the log file of the last build of a single Query Suggestion index.
   * @param indexName The index in which to perform the request.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getLogFile(indexName: String, requestOptions: RequestOptions? = null): List<LogFile> {
    require(indexName.isNotBlank()) { "Parameter `indexName` is required when calling `getLogFile`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("1", "logs", "$indexName"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Send requests to the Algolia REST API.
   * This method allow you to send requests to the Algolia REST API.
   * @param path The path of the API endpoint to target, anything after the /1 needs to be specified.
   * @param parameters Query parameters to be applied to the current query.
   * @param body The parameters to send with the custom request.
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
   * @param path The path of the API endpoint to target, anything after the /1 needs to be specified.
   * @param parameters Query parameters to be applied to the current query.
   * @param body The parameters to send with the custom request.
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

  /**
   * Update a configuration.
   * Update the configuration of a Query Suggestions index.
   * @param indexName The index in which to perform the request.
   * @param querySuggestionsIndexParam
   * @param requestOptions additional request configuration.
   */
  public suspend fun updateConfig(indexName: String, querySuggestionsIndexParam: QuerySuggestionsIndexParam, requestOptions: RequestOptions? = null): SuccessResponse {
    require(indexName.isNotBlank()) { "Parameter `indexName` is required when calling `updateConfig`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.PUT,
      path = listOf("1", "configs", "$indexName"),
      body = querySuggestionsIndexParam,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }
}
