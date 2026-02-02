import 'dart:async';

import 'package:algolia_client_core/src/algolia_exception.dart';
import 'package:algolia_client_core/src/config/agent_segment.dart';
import 'package:algolia_client_core/src/transport/algolia_agent.dart';
import 'package:algolia_client_core/src/transport/dio/agent_interceptor.dart';
import 'package:algolia_client_core/src/transport/dio/auth_interceptor.dart';
import 'package:algolia_client_core/src/transport/dio/platform/platform.dart';
import 'package:algolia_client_core/src/transport/requester.dart';
import 'package:algolia_client_core/src/version.dart';
import 'package:dio/dio.dart';

/// A [Requester] implementation using the Dio library.
///
/// This class sends HTTP requests using the Dio library and handles
/// response conversion and error handling.
class DioRequester implements Requester {
  /// The underlying Dio client.
  final AuthInterceptor _authInterceptor;
  late final Dio _client;

  /// Constructs a [DioRequester] with the given [appId], [apiKey], and [options].
  DioRequester({
    required String appId,
    required String apiKey,
    Map<String, dynamic>? headers,
    Duration? connectTimeout,
    Iterable<AgentSegment>? clientSegments,
    Function(Object?)? logger,
    Iterable<Interceptor>? interceptors,
    HttpClientAdapter? httpClientAdapter,
  }) : _authInterceptor = AuthInterceptor(
          appId: appId,
          apiKey: apiKey,
        ) {
    _client = Dio(
      BaseOptions(
        headers: headers,
        connectTimeout: connectTimeout,
      ),
    )..interceptors.addAll([
        _authInterceptor,
        AgentInterceptor(
          agent: AlgoliaAgent(packageVersion)
            ..addAll(clientSegments ?? const [])
            ..addAll(Platform.agentSegments()),
        ),
        if (logger != null)
          LogInterceptor(
            requestBody: true,
            responseBody: true,
            logPrint: logger,
          ),
        if (interceptors != null) ...interceptors,
      ]);
    if (httpClientAdapter != null) {
      _client.httpClientAdapter = httpClientAdapter;
    }
  }

  @override
  Future<HttpResponse> perform(HttpRequest request) async {
    try {
      return await execute(request);
    } on DioException catch (e) {
      switch (e.type) {
        case DioExceptionType.connectionTimeout:
        case DioExceptionType.sendTimeout:
        case DioExceptionType.receiveTimeout:
          throw AlgoliaTimeoutException(e);
        case DioExceptionType.badResponse:
          throw AlgoliaApiException(
            e.response?.statusCode ?? 0,
            e.error ?? e.response,
          );
        case DioExceptionType.badCertificate:
        case DioExceptionType.cancel:
        case DioExceptionType.connectionError:
        case DioExceptionType.unknown:
          throw AlgoliaIOException(e);
      }
    }
  }

  /// Executes the [request] and returns the response as an [HttpResponse].
  Future<HttpResponse> execute(HttpRequest request) async {
    final previousConnectTimeout = _client.options.connectTimeout;
    _client.options.connectTimeout = request.connectTimeout;

    try {
      final response = await _client.requestUri<Map<String, dynamic>>(
        requestUri(request),
        data: request.body,
        options: Options(
          method: request.method,
          headers: request.headers,
          contentType: request.body != null ? Headers.jsonContentType : null,
          sendTimeout: request.timeout,
          receiveTimeout: request.timeout,
        ),
      );
      return HttpResponse(response.statusCode, response.data);
    } finally {
      _client.options.connectTimeout = previousConnectTimeout;
    }
  }

  /// Constructs the request URI from the [request] details.
  Uri requestUri(HttpRequest request) {
    Uri uri = Uri(
      scheme: request.host.scheme,
      host: request.host.url,
      port: request.host.port,
      path: request.path,
    );
    if (request.queryParameters.isNotEmpty) {
      return Uri.dataFromString(
          "${uri.toString()}?${request.queryParameters.entries.map((e) => "${e.key}=${e.value}").join("&")}");
    }

    return uri;
  }

  @override
  void close() => _client.close();

  @override
  void setClientApiKey(String apiKey) {
    _authInterceptor.apiKey = apiKey;
  }

  @override
  Duration? get connectTimeout => _client.options.connectTimeout;

  @override
  void setConnectTimeout(Duration connectTimeout) {
    _client.options.connectTimeout = connectTimeout;
  }
}
