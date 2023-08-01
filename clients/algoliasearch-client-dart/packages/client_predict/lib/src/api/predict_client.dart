// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_client_predict/src/deserialize.dart';
import 'package:algolia_client_predict/src/version.dart';

import 'package:algolia_client_predict/src/model/activate_model_instance_response.dart';
import 'package:algolia_client_predict/src/model/activate_model_params.dart';
import 'package:algolia_client_predict/src/model/create_segment_params.dart';
import 'package:algolia_client_predict/src/model/create_segment_response.dart';
import 'package:algolia_client_predict/src/model/delete_model_instance_response.dart';
import 'package:algolia_client_predict/src/model/delete_segment_response.dart';
import 'package:algolia_client_predict/src/model/delete_user_profile_response.dart';
import 'package:algolia_client_predict/src/model/fetch_all_user_profiles_response.dart';
import 'package:algolia_client_predict/src/model/get_available_model_types_response_inner.dart';
import 'package:algolia_client_predict/src/model/get_model_metrics_response.dart';
import 'package:algolia_client_predict/src/model/get_segment_users_response.dart';
import 'package:algolia_client_predict/src/model/model_instance.dart';
import 'package:algolia_client_predict/src/model/segment.dart';
import 'package:algolia_client_predict/src/model/segment_type.dart';
import 'package:algolia_client_predict/src/model/update_model_instance_response.dart';
import 'package:algolia_client_predict/src/model/update_model_params.dart';
import 'package:algolia_client_predict/src/model/update_segment_response.dart';
import 'package:algolia_client_predict/src/model/user_profile.dart';

final class PredictClient implements ApiClient {
  @override
  final String apiKey;

  @override
  final String appId;

  @override
  final ClientOptions options;

  final String region;

  final RetryStrategy _retryStrategy;

  PredictClient({
    required this.appId,
    required this.apiKey,
    this.options = const ClientOptions(),
    required this.region,
  }) : _retryStrategy = RetryStrategy.create(
            segment: AgentSegment(value: "Predict", version: packageVersion),
            appId: appId,
            apiKey: apiKey,
            options: options,
            defaultHosts: () {
              final allowedRegions = ['eu', 'us'];
              assert(
                allowedRegions.contains(region),
                '`region` is required and must be one of the following: ${allowedRegions.join(', ')}',
              );
              final url =
                  'predict.{region}.algolia.com'.replaceAll('{region}', region);
              return [Host(url: url)];
            }) {
    assert(appId.isNotEmpty, '`appId` is missing.');
    assert(apiKey.isNotEmpty, '`apiKey` is missing.');
  }

  /// Activate a model instance.
  /// Activate an existing model template. This action triggers the training and inference pipelines for the selected model.  The model is added with `modelStatus=pending`. If a model with the exact same source & index already exists, the API endpoint returns an error.
  ///
  /// Parameters:
  /// * [activateModelParams]
  /// * [requestOptions] additional request configuration.
  Future<ActivateModelInstanceResponse> activateModelInstance({
    required ActivateModelParams activateModelParams,
    RequestOptions? requestOptions,
  }) async {
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1/predict/models',
      body: activateModelParams.toJson(),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<ActivateModelInstanceResponse,
        ActivateModelInstanceResponse>(
      response,
      'ActivateModelInstanceResponse',
      growable: true,
    );
  }

  /// Create a segment.
  /// Create a new segment. All segments added by this endpoint will have a computed type. The endpoint receives a filters parameter, with a syntax similar to filters for Rules.
  ///
  /// Parameters:
  /// * [createSegmentParams]
  /// * [requestOptions] additional request configuration.
  Future<CreateSegmentResponse> createSegment({
    required CreateSegmentParams createSegmentParams,
    RequestOptions? requestOptions,
  }) async {
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1/segments',
      body: createSegmentParams.toJson(),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<CreateSegmentResponse, CreateSegmentResponse>(
      response,
      'CreateSegmentResponse',
      growable: true,
    );
  }

  /// Send requests to the Algolia REST API.
  /// This method allow you to send requests to the Algolia REST API.
  ///
  /// Parameters:
  /// * [path] Path of the endpoint, anything after \"/1\" must be specified.
  /// * [parameters] Query parameters to apply to the current query.
  /// * [requestOptions] additional request configuration.
  Future<Object> del({
    required String path,
    Map<String, Object>? parameters,
    RequestOptions? requestOptions,
  }) async {
    assert(
      path.isNotEmpty,
      'Parameter `path` is required when calling `del`.',
    );
    final request = ApiRequest(
      method: RequestMethod.delete,
      path: r'/1{path}'.replaceAll('{' r'path' '}', path),
      queryParams: {
        ...?parameters,
      },
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<Object, Object>(
      response,
      'Object',
      growable: true,
    );
  }

  /// Delete a model instance.
  /// Delete the model’s configuration, pipelines and generated predictions.
  ///
  /// Parameters:
  /// * [modelID] The ID of the model to retrieve.
  /// * [requestOptions] additional request configuration.
  Future<DeleteModelInstanceResponse> deleteModelInstance({
    required String modelID,
    RequestOptions? requestOptions,
  }) async {
    assert(
      modelID.isNotEmpty,
      'Parameter `modelID` is required when calling `deleteModelInstance`.',
    );
    final request = ApiRequest(
      method: RequestMethod.delete,
      path: r'/1/predict/models/{modelID}'.replaceAll(
          '{' r'modelID' '}', Uri.encodeComponent(modelID.toString())),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<DeleteModelInstanceResponse,
        DeleteModelInstanceResponse>(
      response,
      'DeleteModelInstanceResponse',
      growable: true,
    );
  }

  /// Delete a segment's configuration.
  /// Delete the segment’s configuration. User intents (predictions) from the segment are not deleted. All segment types (computed or custom) can be deleted.  When the query is successful, the HTTP response is 200 OK and returns the date until which you can safely consider the data as being deleted.
  ///
  /// Parameters:
  /// * [segmentID] The ID of the Segment to fetch.
  /// * [requestOptions] additional request configuration.
  Future<DeleteSegmentResponse> deleteSegment({
    required String segmentID,
    RequestOptions? requestOptions,
  }) async {
    assert(
      segmentID.isNotEmpty,
      'Parameter `segmentID` is required when calling `deleteSegment`.',
    );
    final request = ApiRequest(
      method: RequestMethod.delete,
      path: r'/1/segments/{segmentID}'.replaceAll(
          '{' r'segmentID' '}', Uri.encodeComponent(segmentID.toString())),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<DeleteSegmentResponse, DeleteSegmentResponse>(
      response,
      'DeleteSegmentResponse',
      growable: true,
    );
  }

  /// Delete user profile.
  /// Delete all data and predictions associated with an authenticated user (userID) or an anonymous user (cookieID, sessionID).
  ///
  /// Parameters:
  /// * [userID] User ID for authenticated users or cookie ID for non-authenticated repeated users (visitors).
  /// * [requestOptions] additional request configuration.
  Future<DeleteUserProfileResponse> deleteUserProfile({
    required String userID,
    RequestOptions? requestOptions,
  }) async {
    assert(
      userID.isNotEmpty,
      'Parameter `userID` is required when calling `deleteUserProfile`.',
    );
    final request = ApiRequest(
      method: RequestMethod.delete,
      path: r'/1/users/{userID}'.replaceAll(
          '{' r'userID' '}', Uri.encodeComponent(userID.toString())),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<DeleteUserProfileResponse, DeleteUserProfileResponse>(
      response,
      'DeleteUserProfileResponse',
      growable: true,
    );
  }

  /// Get all segments.
  /// Get the list of segments with their configuration.
  ///
  /// Parameters:
  /// * [type] The type of segments to fetch.
  /// * [requestOptions] additional request configuration.
  Future<List<Segment>> fetchAllSegments({
    SegmentType? type,
    RequestOptions? requestOptions,
  }) async {
    final request = ApiRequest(
      method: RequestMethod.get,
      path: r'/1/segments',
      queryParams: {
        if (type != null) 'type': type,
      },
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<List<Segment>, Segment>(
      response,
      'List<Segment>',
      growable: true,
    );
  }

  /// Get all user profiles.
  /// Get all users with predictions in the provided application.
  ///
  /// Parameters:
  /// * [fetchAllUserProfilesParams]  - one of types: [ModelsToRetrieveParam], [LimitParam], [PreviousPageTokenParam], [NextPageTokenParam], [TypesToRetrieveParam],
  /// * [requestOptions] additional request configuration.
  Future<FetchAllUserProfilesResponse> fetchAllUserProfiles({
    required dynamic fetchAllUserProfilesParams,
    RequestOptions? requestOptions,
  }) async {
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1/users',
      body: fetchAllUserProfilesParams?.toJson(),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<FetchAllUserProfilesResponse,
        FetchAllUserProfilesResponse>(
      response,
      'FetchAllUserProfilesResponse',
      growable: true,
    );
  }

  /// Get the segment configuration.
  /// Get the segment configuration.
  ///
  /// Parameters:
  /// * [segmentID] The ID of the Segment to fetch.
  /// * [requestOptions] additional request configuration.
  Future<Segment> fetchSegment({
    required String segmentID,
    RequestOptions? requestOptions,
  }) async {
    assert(
      segmentID.isNotEmpty,
      'Parameter `segmentID` is required when calling `fetchSegment`.',
    );
    final request = ApiRequest(
      method: RequestMethod.get,
      path: r'/1/segments/{segmentID}'.replaceAll(
          '{' r'segmentID' '}', Uri.encodeComponent(segmentID.toString())),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<Segment, Segment>(
      response,
      'Segment',
      growable: true,
    );
  }

  /// Get user profile.
  /// Get predictions, properties (raw, computed or custom) and segments (computed or custom) for a user profile.
  ///
  /// Parameters:
  /// * [userID] User ID for authenticated users or cookie ID for non-authenticated repeated users (visitors).
  /// * [params]  - one of types: [ModelsToRetrieveParam], [AllParams], [TypesToRetrieveParam],
  /// * [requestOptions] additional request configuration.
  Future<UserProfile> fetchUserProfile({
    required String userID,
    required dynamic params,
    RequestOptions? requestOptions,
  }) async {
    assert(
      userID.isNotEmpty,
      'Parameter `userID` is required when calling `fetchUserProfile`.',
    );
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1/users/{userID}/fetch'.replaceAll(
          '{' r'userID' '}', Uri.encodeComponent(userID.toString())),
      body: params?.toJson(),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<UserProfile, UserProfile>(
      response,
      'UserProfile',
      growable: true,
    );
  }

  /// Send requests to the Algolia REST API.
  /// This method allow you to send requests to the Algolia REST API.
  ///
  /// Parameters:
  /// * [path] Path of the endpoint, anything after \"/1\" must be specified.
  /// * [parameters] Query parameters to apply to the current query.
  /// * [requestOptions] additional request configuration.
  Future<Object> get({
    required String path,
    Map<String, Object>? parameters,
    RequestOptions? requestOptions,
  }) async {
    assert(
      path.isNotEmpty,
      'Parameter `path` is required when calling `get`.',
    );
    final request = ApiRequest(
      method: RequestMethod.get,
      path: r'/1{path}'.replaceAll('{' r'path' '}', path),
      queryParams: {
        ...?parameters,
      },
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<Object, Object>(
      response,
      'Object',
      growable: true,
    );
  }

  /// Get a list of available model types.
  /// Get a list of all available model types. Each model type can be activated more than once, by selecting a different data source.
  ///
  /// Parameters:
  /// * [requestOptions] additional request configuration.
  Future<List<GetAvailableModelTypesResponseInner>> getAvailableModelTypes({
    RequestOptions? requestOptions,
  }) async {
    final request = ApiRequest(
      method: RequestMethod.get,
      path: r'/1/predict/modeltypes',
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<List<GetAvailableModelTypesResponseInner>,
        GetAvailableModelTypesResponseInner>(
      response,
      'List<GetAvailableModelTypesResponseInner>',
      growable: true,
    );
  }

  /// Get a model’s instance configuration.
  /// Get the configuration for a model that was activated.
  ///
  /// Parameters:
  /// * [modelID] The ID of the model to retrieve.
  /// * [requestOptions] additional request configuration.
  Future<ModelInstance> getModelInstanceConfig({
    required String modelID,
    RequestOptions? requestOptions,
  }) async {
    assert(
      modelID.isNotEmpty,
      'Parameter `modelID` is required when calling `getModelInstanceConfig`.',
    );
    final request = ApiRequest(
      method: RequestMethod.get,
      path: r'/1/predict/models/{modelID}'.replaceAll(
          '{' r'modelID' '}', Uri.encodeComponent(modelID.toString())),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<ModelInstance, ModelInstance>(
      response,
      'ModelInstance',
      growable: true,
    );
  }

  /// Get model instances.
  /// Get a list of all model instances.
  ///
  /// Parameters:
  /// * [requestOptions] additional request configuration.
  Future<List<ModelInstance>> getModelInstances({
    RequestOptions? requestOptions,
  }) async {
    final request = ApiRequest(
      method: RequestMethod.get,
      path: r'/1/predict/models',
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<List<ModelInstance>, ModelInstance>(
      response,
      'List<ModelInstance>',
      growable: true,
    );
  }

  /// Get a model’s instance metrics.
  /// Get the model instance’ training metrics.
  ///
  /// Parameters:
  /// * [modelID] The ID of the model to retrieve.
  /// * [requestOptions] additional request configuration.
  Future<GetModelMetricsResponse> getModelMetrics({
    required String modelID,
    RequestOptions? requestOptions,
  }) async {
    assert(
      modelID.isNotEmpty,
      'Parameter `modelID` is required when calling `getModelMetrics`.',
    );
    final request = ApiRequest(
      method: RequestMethod.get,
      path: r'/1/predict/models/{modelID}/metrics'.replaceAll(
          '{' r'modelID' '}', Uri.encodeComponent(modelID.toString())),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<GetModelMetricsResponse, GetModelMetricsResponse>(
      response,
      'GetModelMetricsResponse',
      growable: true,
    );
  }

  /// Get segment users.
  /// Get the profiles of users that belong to a segment.
  ///
  /// Parameters:
  /// * [segmentID] The ID of the Segment to fetch.
  /// * [fetchAllUserProfilesParams]  - one of types: [ModelsToRetrieveParam], [LimitParam], [PreviousPageTokenParam], [NextPageTokenParam], [TypesToRetrieveParam],
  /// * [requestOptions] additional request configuration.
  Future<GetSegmentUsersResponse> getSegmentUsers({
    required String segmentID,
    required dynamic fetchAllUserProfilesParams,
    RequestOptions? requestOptions,
  }) async {
    assert(
      segmentID.isNotEmpty,
      'Parameter `segmentID` is required when calling `getSegmentUsers`.',
    );
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1/segments/{segmentID}/users'.replaceAll(
          '{' r'segmentID' '}', Uri.encodeComponent(segmentID.toString())),
      body: fetchAllUserProfilesParams?.toJson(),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<GetSegmentUsersResponse, GetSegmentUsersResponse>(
      response,
      'GetSegmentUsersResponse',
      growable: true,
    );
  }

  /// Send requests to the Algolia REST API.
  /// This method allow you to send requests to the Algolia REST API.
  ///
  /// Parameters:
  /// * [path] Path of the endpoint, anything after \"/1\" must be specified.
  /// * [parameters] Query parameters to apply to the current query.
  /// * [body] Parameters to send with the custom request.
  /// * [requestOptions] additional request configuration.
  Future<Object> post({
    required String path,
    Map<String, Object>? parameters,
    Object? body,
    RequestOptions? requestOptions,
  }) async {
    assert(
      path.isNotEmpty,
      'Parameter `path` is required when calling `post`.',
    );
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1{path}'.replaceAll('{' r'path' '}', path),
      queryParams: {
        ...?parameters,
      },
      body: body,
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<Object, Object>(
      response,
      'Object',
      growable: true,
    );
  }

  /// Send requests to the Algolia REST API.
  /// This method allow you to send requests to the Algolia REST API.
  ///
  /// Parameters:
  /// * [path] Path of the endpoint, anything after \"/1\" must be specified.
  /// * [parameters] Query parameters to apply to the current query.
  /// * [body] Parameters to send with the custom request.
  /// * [requestOptions] additional request configuration.
  Future<Object> put({
    required String path,
    Map<String, Object>? parameters,
    Object? body,
    RequestOptions? requestOptions,
  }) async {
    assert(
      path.isNotEmpty,
      'Parameter `path` is required when calling `put`.',
    );
    final request = ApiRequest(
      method: RequestMethod.put,
      path: r'/1{path}'.replaceAll('{' r'path' '}', path),
      queryParams: {
        ...?parameters,
      },
      body: body,
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<Object, Object>(
      response,
      'Object',
      growable: true,
    );
  }

  /// Update a model instance.
  /// Update a model’s configuration.
  ///
  /// Parameters:
  /// * [modelID] The ID of the model to retrieve.
  /// * [updateModelParams]
  /// * [requestOptions] additional request configuration.
  Future<UpdateModelInstanceResponse> updateModelInstance({
    required String modelID,
    required UpdateModelParams updateModelParams,
    RequestOptions? requestOptions,
  }) async {
    assert(
      modelID.isNotEmpty,
      'Parameter `modelID` is required when calling `updateModelInstance`.',
    );
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1/predict/models/{modelID}'.replaceAll(
          '{' r'modelID' '}', Uri.encodeComponent(modelID.toString())),
      body: updateModelParams.toJson(),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<UpdateModelInstanceResponse,
        UpdateModelInstanceResponse>(
      response,
      'UpdateModelInstanceResponse',
      growable: true,
    );
  }

  /// Update segment.
  /// Update a segment’s configuration.
  ///
  /// Parameters:
  /// * [segmentID] The ID of the Segment to fetch.
  /// * [updateSegmentParams]  - one of types: [SegmentConditionsParam], [SegmentNameParam], [AllUpdateSegmentParams],
  /// * [requestOptions] additional request configuration.
  Future<UpdateSegmentResponse> updateSegment({
    required String segmentID,
    required dynamic updateSegmentParams,
    RequestOptions? requestOptions,
  }) async {
    assert(
      segmentID.isNotEmpty,
      'Parameter `segmentID` is required when calling `updateSegment`.',
    );
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1/segments/{segmentID}'.replaceAll(
          '{' r'segmentID' '}', Uri.encodeComponent(segmentID.toString())),
      body: updateSegmentParams?.toJson(),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<UpdateSegmentResponse, UpdateSegmentResponse>(
      response,
      'UpdateSegmentResponse',
      growable: true,
    );
  }

  @override
  void dispose() => _retryStrategy.dispose();
}
