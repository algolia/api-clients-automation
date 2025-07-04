/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.api

import com.algolia.client.configuration.*
import com.algolia.client.exception.*
import com.algolia.client.extensions.internal.*
import com.algolia.client.model.abtesting.*
import com.algolia.client.transport.*
import com.algolia.client.transport.internal.*
import kotlinx.serialization.json.*
import kotlin.time.Duration.Companion.milliseconds

public class AbtestingClient(
  override val appId: String,
  override var apiKey: String,
  public val region: String? = null,
  override val options: ClientOptions = ClientOptions(),
) : ApiClient {

  init {
    require(appId.isNotBlank()) { "`appId` is missing." }
    require(apiKey.isNotBlank()) { "`apiKey` is missing." }
  }

  override val requester: Requester = requesterOf(clientName = "Abtesting", appId = appId, apiKey = apiKey, connectTimeout = 2000.milliseconds, readTimeout = 5000.milliseconds, writeTimeout = 30000.milliseconds, options = options) {
    val allowedRegions = listOf("de", "us")
    require(region == null || region in allowedRegions) { "`region` must be one of the following: ${allowedRegions.joinToString()}" }
    val url = if (region == null) "analytics.algolia.com" else "analytics.$region.algolia.com"
    listOf(Host(url))
  }

  /**
   * Creates a new A/B test.
   *
   * Required API Key ACLs:
   *   - editSettings
   * @param addABTestsRequest
   * @param requestOptions additional request configuration.
   */
  public suspend fun addABTests(addABTestsRequest: AddABTestsRequest, requestOptions: RequestOptions? = null): ABTestResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("2", "abtests"),
      body = addABTestsRequest,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   * @param path Path of the endpoint, for example `1/newFeature`.
   * @param parameters Query parameters to apply to the current query.
   * @param requestOptions additional request configuration.
   */
  public suspend fun customDelete(path: String, parameters: Map<kotlin.String, Any>? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `customDelete`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.DELETE,
      path = "/{path}".replace("{path}", path),
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
   * This method lets you send requests to the Algolia REST API.
   * @param path Path of the endpoint, for example `1/newFeature`.
   * @param parameters Query parameters to apply to the current query.
   * @param requestOptions additional request configuration.
   */
  public suspend fun customGet(path: String, parameters: Map<kotlin.String, Any>? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `customGet`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = "/{path}".replace("{path}", path),
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
   * This method lets you send requests to the Algolia REST API.
   * @param path Path of the endpoint, for example `1/newFeature`.
   * @param parameters Query parameters to apply to the current query.
   * @param body Parameters to send with the custom request.
   * @param requestOptions additional request configuration.
   */
  public suspend fun customPost(path: String, parameters: Map<kotlin.String, Any>? = null, body: JsonObject? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `customPost`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = "/{path}".replace("{path}", path),
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
   * This method lets you send requests to the Algolia REST API.
   * @param path Path of the endpoint, for example `1/newFeature`.
   * @param parameters Query parameters to apply to the current query.
   * @param body Parameters to send with the custom request.
   * @param requestOptions additional request configuration.
   */
  public suspend fun customPut(path: String, parameters: Map<kotlin.String, Any>? = null, body: JsonObject? = null, requestOptions: RequestOptions? = null): JsonObject {
    require(path.isNotBlank()) { "Parameter `path` is required when calling `customPut`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.PUT,
      path = "/{path}".replace("{path}", path),
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
   * Deletes an A/B test by its ID.
   *
   * Required API Key ACLs:
   *   - editSettings
   * @param id Unique A/B test identifier.
   * @param requestOptions additional request configuration.
   */
  public suspend fun deleteABTest(id: Int, requestOptions: RequestOptions? = null): ABTestResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.DELETE,
      path = listOf("2", "abtests", "$id"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Given the traffic percentage and the expected effect size, this endpoint estimates the sample size and duration of an A/B test based on historical traffic.
   *
   * Required API Key ACLs:
   *   - analytics
   * @param estimateABTestRequest
   * @param requestOptions additional request configuration.
   */
  public suspend fun estimateABTest(estimateABTestRequest: EstimateABTestRequest, requestOptions: RequestOptions? = null): EstimateABTestResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("2", "abtests", "estimate"),
      body = estimateABTestRequest,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Retrieves the details for an A/B test by its ID.
   *
   * Required API Key ACLs:
   *   - analytics
   * @param id Unique A/B test identifier.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getABTest(id: Int, requestOptions: RequestOptions? = null): ABTest {
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "abtests", "$id"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Lists all A/B tests you configured for this application.
   *
   * Required API Key ACLs:
   *   - analytics
   * @param offset Position of the first item to return. (default to 0)
   * @param limit Number of items to return. (default to 10)
   * @param indexPrefix Index name prefix. Only A/B tests for indices starting with this string are included in the response.
   * @param indexSuffix Index name suffix. Only A/B tests for indices ending with this string are included in the response.
   * @param requestOptions additional request configuration.
   */
  public suspend fun listABTests(offset: Int? = null, limit: Int? = null, indexPrefix: String? = null, indexSuffix: String? = null, requestOptions: RequestOptions? = null): ListABTestsResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("2", "abtests"),
      query = buildMap {
        offset?.let { put("offset", it) }
        limit?.let { put("limit", it) }
        indexPrefix?.let { put("indexPrefix", it) }
        indexSuffix?.let { put("indexSuffix", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Schedule an A/B test to be started at a later time.
   *
   * Required API Key ACLs:
   *   - editSettings
   * @param scheduleABTestsRequest
   * @param requestOptions additional request configuration.
   */
  public suspend fun scheduleABTest(scheduleABTestsRequest: ScheduleABTestsRequest, requestOptions: RequestOptions? = null): ScheduleABTestResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("2", "abtests", "schedule"),
      body = scheduleABTestsRequest,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Stops an A/B test by its ID.  You can't restart stopped A/B tests.
   *
   * Required API Key ACLs:
   *   - editSettings
   * @param id Unique A/B test identifier.
   * @param requestOptions additional request configuration.
   */
  public suspend fun stopABTest(id: Int, requestOptions: RequestOptions? = null): ABTestResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("2", "abtests", "$id", "stop"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }
}
