// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_client_insights/src/deserialize.dart';
import 'package:algolia_client_insights/src/version.dart';

import 'package:algolia_client_insights/src/model/events_response.dart';
import 'package:algolia_client_insights/src/model/insights_events.dart';

final class InsightsClient implements ApiClient {
  @override
  final ClientOptions options;

  final String? region;

  final RetryStrategy _retryStrategy;

  InsightsClient({
    required String appId,
    required String apiKey,
    this.options = const ClientOptions(),
    this.region,
  }) : _retryStrategy = RetryStrategy.create(
            segment: AgentSegment(value: "Insights", version: packageVersion),
            appId: appId,
            apiKey: apiKey,
            options: options,
            defaultHosts: () {
              final allowedRegions = ['de', 'us'];
              assert(
                region == null || allowedRegions.contains(region),
                '`region` must be one of the following: ${allowedRegions.join(', ')}',
              );
              final url = region == null
                  ? 'insights.algolia.io'
                  : 'insights.{region}.algolia.io'
                      .replaceAll('{region}', region);
              return [Host(url: url)];
            }) {
    assert(appId.isNotEmpty, '`appId` is missing.');
    assert(apiKey.isNotEmpty, '`apiKey` is missing.');
  }

  /// Allows to switch the API key used to authenticate requests.
  @override
  void setClientApiKey({required String apiKey}) {
    _retryStrategy.requester.setClientApiKey(apiKey);
  }

  /// This method lets you send requests to the Algolia REST API.
  ///
  /// Parameters:
  /// * [path] Path of the endpoint, anything after \"/1\" must be specified.
  /// * [parameters] Query parameters to apply to the current query.
  /// * [requestOptions] additional request configuration.
  Future<Object> customDelete({
    required String path,
    Map<String, Object>? parameters,
    RequestOptions? requestOptions,
  }) async {
    assert(
      path.isNotEmpty,
      'Parameter `path` is required when calling `customDelete`.',
    );
    final request = ApiRequest(
      method: RequestMethod.delete,
      path: r'/{path}'.replaceAll('{' r'path' '}', path),
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

  /// This method lets you send requests to the Algolia REST API.
  ///
  /// Parameters:
  /// * [path] Path of the endpoint, anything after \"/1\" must be specified.
  /// * [parameters] Query parameters to apply to the current query.
  /// * [requestOptions] additional request configuration.
  Future<Object> customGet({
    required String path,
    Map<String, Object>? parameters,
    RequestOptions? requestOptions,
  }) async {
    assert(
      path.isNotEmpty,
      'Parameter `path` is required when calling `customGet`.',
    );
    final request = ApiRequest(
      method: RequestMethod.get,
      path: r'/{path}'.replaceAll('{' r'path' '}', path),
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

  /// This method lets you send requests to the Algolia REST API.
  ///
  /// Parameters:
  /// * [path] Path of the endpoint, anything after \"/1\" must be specified.
  /// * [parameters] Query parameters to apply to the current query.
  /// * [body] Parameters to send with the custom request.
  /// * [requestOptions] additional request configuration.
  Future<Object> customPost({
    required String path,
    Map<String, Object>? parameters,
    Object? body,
    RequestOptions? requestOptions,
  }) async {
    assert(
      path.isNotEmpty,
      'Parameter `path` is required when calling `customPost`.',
    );
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/{path}'.replaceAll('{' r'path' '}', path),
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

  /// This method lets you send requests to the Algolia REST API.
  ///
  /// Parameters:
  /// * [path] Path of the endpoint, anything after \"/1\" must be specified.
  /// * [parameters] Query parameters to apply to the current query.
  /// * [body] Parameters to send with the custom request.
  /// * [requestOptions] additional request configuration.
  Future<Object> customPut({
    required String path,
    Map<String, Object>? parameters,
    Object? body,
    RequestOptions? requestOptions,
  }) async {
    assert(
      path.isNotEmpty,
      'Parameter `path` is required when calling `customPut`.',
    );
    final request = ApiRequest(
      method: RequestMethod.put,
      path: r'/{path}'.replaceAll('{' r'path' '}', path),
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

  /// Deletes all events related to the specified user token from events metrics and analytics. The deletion is asynchronous, and processed within 48 hours. To delete a personalization user profile, see `Delete a user profile` in the Personalization API.
  ///
  /// Parameters:
  /// * [userToken] User token for which to delete all associated events.
  /// * [requestOptions] additional request configuration.
  Future<void> deleteUserToken({
    required String userToken,
    RequestOptions? requestOptions,
  }) async {
    assert(
      userToken.isNotEmpty,
      'Parameter `userToken` is required when calling `deleteUserToken`.',
    );
    final request = ApiRequest(
      method: RequestMethod.delete,
      path: r'/1/usertokens/{userToken}'.replaceAll(
          '{' r'userToken' '}', Uri.encodeComponent(userToken.toString())),
    );
    await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
  }

  /// Sends a list of events to the Insights API.  You can include up to 1,000 events in a single request, but the request body must be smaller than 2&nbsp;MB.
  ///
  /// Parameters:
  /// * [insightsEvents]
  /// * [requestOptions] additional request configuration.
  Future<EventsResponse> pushEvents({
    required InsightsEvents insightsEvents,
    RequestOptions? requestOptions,
  }) async {
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1/events',
      body: insightsEvents.toJson(),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<EventsResponse, EventsResponse>(
      response,
      'EventsResponse',
      growable: true,
    );
  }

  @Deprecated('This operation has been deprecated, use `customPost` instead')
  Future<Object> post({
    required String path,
    Map<String, Object>? parameters,
    Object? body,
    RequestOptions? requestOptions,
  }) async {
    return customPost(
        path: path, parameters: parameters, requestOptions: requestOptions);
  }

  @Deprecated('This operation has been deprecated, use `customPut` instead')
  Future<Object> put({
    required String path,
    Map<String, Object>? parameters,
    Object? body,
    RequestOptions? requestOptions,
  }) async {
    return customPut(
        path: path, parameters: parameters, requestOptions: requestOptions);
  }

  @Deprecated('This operation has been deprecated, use `customGet` instead')
  Future<Object> get({
    required String path,
    Map<String, Object>? parameters,
    Object? body,
    RequestOptions? requestOptions,
  }) async {
    return customGet(
        path: path, parameters: parameters, requestOptions: requestOptions);
  }

  @Deprecated('This operation has been deprecated, use `customDelete` instead')
  Future<Object> del({
    required String path,
    Map<String, Object>? parameters,
    Object? body,
    RequestOptions? requestOptions,
  }) async {
    return customDelete(
        path: path, parameters: parameters, requestOptions: requestOptions);
  }

  @override
  void dispose() => _retryStrategy.dispose();
}
