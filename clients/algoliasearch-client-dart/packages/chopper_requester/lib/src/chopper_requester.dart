import 'dart:async' show TimeoutException;

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:chopper/chopper.dart';
import 'package:algolia_chopper_requester/src/agent_interceptor.dart';
import 'package:algolia_chopper_requester/src/auth_interceptor.dart';
import 'package:algolia_chopper_requester/src/platform/platform.dart';
import 'package:algolia_chopper_requester/src/version.dart';
import 'package:http/http.dart' as http;
import 'package:logging/logging.dart' show Logger;

/// A [Requester] implementation using the Chopper library.
///
/// This class sends HTTP requests using the Chopper library and handles
/// response conversion and error handling.
class ChopperRequester implements Requester {
  /// The underlying Chopper client.
  final ChopperClient _client;

  /// Constructs a [ChopperClient] with the given [appId] and [apiKey].
  ChopperRequester({
    required String appId,
    required String apiKey,
    Map<String, dynamic>? headers,
    Iterable<AgentSegment>? clientSegments,
    Logger? logger,
    Iterable<Interceptor>? interceptors,
    http.Client? client,
  }) : _client = ChopperClient(
          client: client,
          converter: JsonConverter(),
          interceptors: [
            AuthInterceptor(
              appId: appId,
              apiKey: apiKey,
            ),
            AgentInterceptor(
              agent: AlgoliaAgent(packageVersion)
                ..addAll([
                  ...?clientSegments,
                  ...Platform.agentSegments(),
                ]),
            ),
            if (logger != null)
              HttpLoggingInterceptor(
                level: Level.body,
                onlyErrors: false,
                logger: logger,
              ),
            ...?interceptors,
          ],
        );

  @override
  Future<HttpResponse> perform(HttpRequest request) async {
    try {
      final Response<Map<String, dynamic>> response = await execute(request);

      if (response.isSuccessful) {
        return HttpResponse(
          response.statusCode,
          response.body,
        );
      } else {
        throw AlgoliaApiException(
          response.statusCode,
          response.error ?? response.body,
        );
      }
    } on TimeoutException catch (e) {
      throw AlgoliaTimeoutException(e);
    } on http.ClientException catch (e) {
      throw AlgoliaIOException(e);
    }
  }

  /// Executes the [request] and returns the response as an [HttpResponse].
  Future<Response<Map<String, dynamic>>> execute(HttpRequest request) async {
    final Request chopperRequest = Request(
      request.method,
      Uri(
        scheme: request.host.scheme,
        host: request.host.url,
        port: request.host.port,
        path: request.path,
      ),
      _client.baseUrl,
      body: request.body,
      parameters: request.queryParameters,
      headers: {
        for (final MapEntry<String, dynamic> entry
            in request.headers?.entries ?? const {})
          entry.key: entry.value.toString(),
        if (request.body != null) 'content-type': 'application/json',
      },
    );

    return switch (options.timeout) {
      null => await _client
          .send<Map<String, dynamic>, Map<String, dynamic>>(chopperRequest),
      _ => await _client
          .send<Map<String, dynamic>, Map<String, dynamic>>(chopperRequest)
          .timeout(options.timeout!),
    };
  }

  @override
  void close() => _client.dispose();
}
