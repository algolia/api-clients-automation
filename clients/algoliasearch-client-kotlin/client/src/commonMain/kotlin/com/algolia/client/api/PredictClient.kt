/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.api

import com.algolia.client.configuration.*
import com.algolia.client.exception.*
import com.algolia.client.extensions.internal.*
import com.algolia.client.model.predict.*
import com.algolia.client.transport.*
import com.algolia.client.transport.internal.*
import kotlinx.serialization.json.*

public class PredictClient(
  override val appId: String,
  override val apiKey: String,
  public val region: String,
  override val options: ClientOptions = ClientOptions(),
) : ApiClient {

  init {
    require(appId.isNotBlank()) { "`appId` is missing." }
    require(apiKey.isNotBlank()) { "`apiKey` is missing." }
  }

  override val requester: Requester = requesterOf(clientName = "Predict", appId = appId, apiKey = apiKey, options = options) {
    val allowedRegions = listOf("eu", "us")
    require(region in allowedRegions) { "`region` is required and must be one of the following: ${allowedRegions.joinToString()}" }
    val url = "predict.$region.algolia.com"
    listOf(Host(url))
  }

  /**
   * Activate a model instance.
   * Activate an existing model template. This action triggers the training and inference pipelines for the selected model.  The model is added with `modelStatus=pending`. If a model with the exact same source & index already exists, the API endpoint returns an error.
   * @param activateModelParams
   * @param requestOptions additional request configuration.
   */
  public suspend fun activateModelInstance(activateModelParams: ActivateModelParams, requestOptions: RequestOptions? = null): ActivateModelInstanceResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("1", "predict", "models"),
      body = activateModelParams,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Create a segment.
   * Create a new segment. All segments added by this endpoint will have a computed type. The endpoint receives a filters parameter, with a syntax similar to filters for Rules.
   * @param createSegmentParams
   * @param requestOptions additional request configuration.
   */
  public suspend fun createSegment(createSegmentParams: CreateSegmentParams, requestOptions: RequestOptions? = null): CreateSegmentResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("1", "segments"),
      body = createSegmentParams,
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
   * Delete a model instance.
   * Delete the model’s configuration, pipelines and generated predictions.
   * @param modelID The ID of the model to retrieve.
   * @param requestOptions additional request configuration.
   */
  public suspend fun deleteModelInstance(modelID: String, requestOptions: RequestOptions? = null): DeleteModelInstanceResponse {
    require(modelID.isNotBlank()) { "Parameter `modelID` is required when calling `deleteModelInstance`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.DELETE,
      path = listOf("1", "predict", "models", "$modelID"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Delete a segment's configuration.
   * Delete the segment’s configuration. User intents (predictions) from the segment are not deleted. All segment types (computed or custom) can be deleted.  When the query is successful, the HTTP response is 200 OK and returns the date until which you can safely consider the data as being deleted.
   * @param segmentID The ID of the Segment to fetch.
   * @param requestOptions additional request configuration.
   */
  public suspend fun deleteSegment(segmentID: String, requestOptions: RequestOptions? = null): DeleteSegmentResponse {
    require(segmentID.isNotBlank()) { "Parameter `segmentID` is required when calling `deleteSegment`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.DELETE,
      path = listOf("1", "segments", "$segmentID"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Delete user profile.
   * Delete all data and predictions associated with an authenticated user (userID) or an anonymous user (cookieID, sessionID).
   * @param userID User ID for authenticated users or cookie ID for non-authenticated repeated users (visitors).
   * @param requestOptions additional request configuration.
   */
  public suspend fun deleteUserProfile(userID: String, requestOptions: RequestOptions? = null): DeleteUserProfileResponse {
    require(userID.isNotBlank()) { "Parameter `userID` is required when calling `deleteUserProfile`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.DELETE,
      path = listOf("1", "users", "$userID"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get all segments.
   * Get the list of segments with their configuration.
   * @param type The type of segments to fetch.
   * @param requestOptions additional request configuration.
   */
  public suspend fun fetchAllSegments(type: SegmentType? = null, requestOptions: RequestOptions? = null): List<Segment> {
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("1", "segments"),
      query = buildMap {
        type?.let { put("type", it) }
      },
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get all user profiles.
   * Get all users with predictions in the provided application.
   * @param fetchAllUserProfilesParams
   * @param requestOptions additional request configuration.
   */
  public suspend fun fetchAllUserProfiles(fetchAllUserProfilesParams: FetchAllUserProfilesParams, requestOptions: RequestOptions? = null): FetchAllUserProfilesResponse {
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("1", "users"),
      body = fetchAllUserProfilesParams,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get the segment configuration.
   * Get the segment configuration.
   * @param segmentID The ID of the Segment to fetch.
   * @param requestOptions additional request configuration.
   */
  public suspend fun fetchSegment(segmentID: String, requestOptions: RequestOptions? = null): Segment {
    require(segmentID.isNotBlank()) { "Parameter `segmentID` is required when calling `fetchSegment`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("1", "segments", "$segmentID"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get user profile.
   * Get predictions, properties (raw, computed or custom) and segments (computed or custom) for a user profile.
   * @param userID User ID for authenticated users or cookie ID for non-authenticated repeated users (visitors).
   * @param params
   * @param requestOptions additional request configuration.
   */
  public suspend fun fetchUserProfile(userID: String, params: Params, requestOptions: RequestOptions? = null): UserProfile {
    require(userID.isNotBlank()) { "Parameter `userID` is required when calling `fetchUserProfile`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("1", "users", "$userID", "fetch"),
      body = params,
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
   * Get a list of available model types.
   * Get a list of all available model types. Each model type can be activated more than once, by selecting a different data source.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getAvailableModelTypes(requestOptions: RequestOptions? = null): List<GetAvailableModelTypesResponseInner> {
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("1", "predict", "modeltypes"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get a model’s instance configuration.
   * Get the configuration for a model that was activated.
   * @param modelID The ID of the model to retrieve.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getModelInstanceConfig(modelID: String, requestOptions: RequestOptions? = null): ModelInstance {
    require(modelID.isNotBlank()) { "Parameter `modelID` is required when calling `getModelInstanceConfig`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("1", "predict", "models", "$modelID"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get model instances.
   * Get a list of all model instances.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getModelInstances(requestOptions: RequestOptions? = null): List<ModelInstance> {
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("1", "predict", "models"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get a model’s instance metrics.
   * Get the model instance’ training metrics.
   * @param modelID The ID of the model to retrieve.
   * @param requestOptions additional request configuration.
   */
  public suspend fun getModelMetrics(modelID: String, requestOptions: RequestOptions? = null): GetModelMetricsResponse {
    require(modelID.isNotBlank()) { "Parameter `modelID` is required when calling `getModelMetrics`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.GET,
      path = listOf("1", "predict", "models", "$modelID", "metrics"),
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Get segment users.
   * Get the profiles of users that belong to a segment.
   * @param segmentID The ID of the Segment to fetch.
   * @param fetchAllUserProfilesParams
   * @param requestOptions additional request configuration.
   */
  public suspend fun getSegmentUsers(segmentID: String, fetchAllUserProfilesParams: FetchAllUserProfilesParams, requestOptions: RequestOptions? = null): GetSegmentUsersResponse {
    require(segmentID.isNotBlank()) { "Parameter `segmentID` is required when calling `getSegmentUsers`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("1", "segments", "$segmentID", "users"),
      body = fetchAllUserProfilesParams,
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

  /**
   * Update a model instance.
   * Update a model’s configuration.
   * @param modelID The ID of the model to retrieve.
   * @param updateModelParams
   * @param requestOptions additional request configuration.
   */
  public suspend fun updateModelInstance(modelID: String, updateModelParams: UpdateModelParams, requestOptions: RequestOptions? = null): UpdateModelInstanceResponse {
    require(modelID.isNotBlank()) { "Parameter `modelID` is required when calling `updateModelInstance`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("1", "predict", "models", "$modelID"),
      body = updateModelParams,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }

  /**
   * Update segment.
   * Update a segment’s configuration.
   * @param segmentID The ID of the Segment to fetch.
   * @param updateSegmentParams
   * @param requestOptions additional request configuration.
   */
  public suspend fun updateSegment(segmentID: String, updateSegmentParams: UpdateSegmentParams, requestOptions: RequestOptions? = null): UpdateSegmentResponse {
    require(segmentID.isNotBlank()) { "Parameter `segmentID` is required when calling `updateSegment`." }
    val requestConfig = RequestConfig(
      method = RequestMethod.POST,
      path = listOf("1", "segments", "$segmentID"),
      body = updateSegmentParams,
    )
    return requester.execute(
      requestConfig = requestConfig,
      requestOptions = requestOptions,
    )
  }
}
