// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algoliasearch/src/deserialize.dart';
import 'package:algoliasearch/src/version.dart';

import 'package:algoliasearch/src/model/get_recommendations_params.dart';
import 'package:algoliasearch/src/model/get_recommendations_response.dart';
import 'package:algoliasearch/src/model/search_method_params.dart';
import 'package:algoliasearch/src/model/search_responses.dart';

final class SearchClient implements ApiClient {
  @override
  final ClientOptions options;

  final RetryStrategy _retryStrategy;

  SearchClient({
    required String appId,
    required String apiKey,
    this.options = const ClientOptions(),
  }) : _retryStrategy = RetryStrategy.create(
          segment:
              AgentSegment(value: "Algoliasearch", version: packageVersion),
          appId: appId,
          apiKey: apiKey,
          options: options,
          defaultHosts: () =>
              [
                Host(url: '$appId-dsn.algolia.net', callType: CallType.read),
                Host(url: '$appId.algolia.net', callType: CallType.write),
              ] +
              ([
                Host(url: '$appId-1.algolianet.com'),
                Host(url: '$appId-2.algolianet.com'),
                Host(url: '$appId-3.algolianet.com'),
              ]..shuffle()),
        ) {
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

  /// Retrieves recommendations from selected AI models.
  ///
  /// Required API Key ACLs:
  ///   - search
  ///
  /// Parameters:
  /// * [getRecommendationsParams]
  /// * [requestOptions] additional request configuration.
  Future<GetRecommendationsResponse> getRecommendations({
    required GetRecommendationsParams getRecommendationsParams,
    RequestOptions? requestOptions,
  }) async {
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1/indexes/*/recommendations',
      isRead: true,
      body: getRecommendationsParams.toJson(),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<GetRecommendationsResponse, GetRecommendationsResponse>(
      response,
      'GetRecommendationsResponse',
      growable: true,
    );
  }

  /// Sends multiple search requests to one or more indices.  This can be useful in these cases:  - Different indices for different purposes, such as, one index for products, another one for marketing content. - Multiple searches to the same index—for example, with different filters.
  ///
  /// Required API Key ACLs:
  ///   - search
  ///
  /// Parameters:
  /// * [searchMethodParams] Muli-search request body. Results are returned in the same order as the requests.
  /// * [requestOptions] additional request configuration.
  Future<SearchResponses> search({
    required SearchMethodParams searchMethodParams,
    RequestOptions? requestOptions,
  }) async {
    final request = ApiRequest(
      method: RequestMethod.post,
      path: r'/1/indexes/*/queries',
      isRead: true,
      body: searchMethodParams.toJson(),
    );
    final response = await _retryStrategy.execute(
      request: request,
      options: requestOptions,
    );
    return deserialize<SearchResponses, SearchResponses>(
      response,
      'SearchResponses',
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

  @override
  void dispose() => _retryStrategy.dispose();
}
