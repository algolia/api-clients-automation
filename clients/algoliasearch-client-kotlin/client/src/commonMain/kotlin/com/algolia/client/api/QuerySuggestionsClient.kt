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
   * Create a new Query Suggestions configuration.  You can have up to 100 configurations per Algolia application.
   *
   * Required API Key ACLs:
   *   - editSettings
   * @param querySuggestionsConfigurationWithIndex
   * @param requestOptions additional request configuration.
   */
  public suspend fun createConfig(querySuggestionsConfigurationWithIndex: QuerySuggestionsConfigurationWithIndex, requestOptions: RequestOptions? = null): BaseResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("1", "configs"),
      body = querySuggestionsConfigurationWithIndex,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * This method allow you to send requests to the Algolia REST API.
   * @param path Path of the endpoint, anything after \"/1\" must be specified.
   * @param parameters Query parameters to apply to the current query.
   * @param requestOptions additional request configuration.
   */
  public suspend fun customDelete(path: String, parameters: Map<kotlin.String, Any>? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `customDelete`." }
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
   * This method allow you to send requests to the Algolia REST API.
   * @param path Path of the endpoint, anything after \"/1\" must be specified.
   * @param parameters Query parameters to apply to the current query.
   * @param requestOptions additional request configuration.
   */
  public suspend fun customGet(path: String, parameters: Map<kotlin.String, Any>? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `customGet`." }
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
   * This method allow you to send requests to the Algolia REST API.
   * @param path Path of the endpoint, anything after \"/1\" must be specified.
   * @param parameters Query parameters to apply to the current query.
   * @param body Parameters to send with the custom request.
   * @param requestOptions additional request configuration.
   */
  public suspend fun customPost(path: String, parameters: Map<kotlin.String, Any>? = null, body: JsonObject? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `customPost`." }
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
   * This method allow you to send requests to the Algolia REST API.
   * @param path Path of the endpoint, anything after \"/1\" must be specified.
   * @param parameters Query parameters to apply to the current query.
   * @param body Parameters to send with the custom request.
   * @param requestOptions additional request configuration.
   */
  public suspend fun customPut(path: String, parameters: Map<kotlin.String, Any>? = null, body: JsonObject? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `customPut`." }
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
   * Delete a Query Suggestions configuration.  Deleting only removes the configuration and stops updates to the Query Suggestions index. The Query Suggestions index itself is not deleted.
   *
   * Required API Key ACLs:
   *   - editSettings
   * @param indexName Query Suggestions index name.
   * @param requestOptions additional request configuration.
   */
  public suspend fun deleteConfig(indexName: String, requestOptions: RequestOptions? = null): BaseResponse {
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
   * List all Query Suggestions configurations of your Algolia application.
   *
   * Required API Key ACLs:
   *   - settings
   * @param requestOptions additional request configuration.
   */
  public suspend fun getAllConfigs(requestOptions: RequestOptions? = null): List<QuerySuggestionsConfigurationResponse> {
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
   * Get a single Query Suggestions configuration.
   *
   * Required API Key ACLs:
   *   - settings
   * @param indexName Query Suggestions index name.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getConfig(indexName: String, requestOptions: RequestOptions? = null): QuerySuggestionsConfigurationResponse {
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
   * Report the status of a Query Suggestions index.
   *
   * Required API Key ACLs:
   *   - settings
   * @param indexName Query Suggestions index name.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getConfigStatus(indexName: String, requestOptions: RequestOptions? = null): GetConfigStatus200Response {
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
   * Get the logs for a single Query Suggestions index.
   *
   * Required API Key ACLs:
   *   - settings
   * @param indexName Query Suggestions index name.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getLogFile(indexName: String, requestOptions: RequestOptions? = null): GetLogFile200Response {
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
   * Update a QuerySuggestions configuration.
   *
   * Required API Key ACLs:
   *   - editSettings
   * @param indexName Query Suggestions index name.
   * @param querySuggestionsConfiguration
   * @param requestOptions additional request configuration.
   */
  public suspend fun updateConfig(indexName: String, querySuggestionsConfiguration: QuerySuggestionsConfiguration, requestOptions: RequestOptions? = null): BaseResponse {
    require(indexName.isNotBlank()) { "Parameter `indexName` is required when calling `updateConfig`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.PUT,
      path = listOf("1", "configs", "$indexName"),
      body = querySuggestionsConfiguration,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }
}
