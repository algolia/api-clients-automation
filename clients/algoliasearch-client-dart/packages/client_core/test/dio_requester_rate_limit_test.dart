import 'dart:convert';
import 'dart:typed_data';

// dio has its own RequestOptions; this test only needs the core exception,
// Host and HttpRequest types.
import 'package:algolia_client_core/algolia_client_core.dart'
    hide RequestOptions;
import 'package:algolia_client_core/src/transport/dio/dio_requester.dart';
import 'package:dio/dio.dart';
import 'package:test/test.dart';

/// Answers every request with a 429 carrying Retry-After and Correlation-ID.
final class RateLimitedAdapter implements HttpClientAdapter {
  @override
  Future<ResponseBody> fetch(
    RequestOptions options,
    Stream<Uint8List>? requestStream,
    Future<void>? cancelFuture,
  ) async =>
      ResponseBody.fromString(
        jsonEncode({'message': 'Too many requests'}),
        429,
        headers: {
          Headers.contentTypeHeader: [Headers.jsonContentType],
          'Retry-After': ['2'],
          'Correlation-ID': ['corr-429'],
        },
      );

  @override
  void close({bool force = false}) {}
}

String? headerOf(Map<String, String>? headers, String name) => headers?.entries
    .where((entry) => entry.key.toLowerCase() == name)
    .map((entry) => entry.value)
    .firstOrNull;

void main() {
  test('a dio 429 carries its response headers into AlgoliaApiException',
      () async {
    final requester = DioRequester(
      appId: 'appId',
      apiKey: 'apiKey',
      httpClientAdapter: RateLimitedAdapter(),
    );
    final request = HttpRequest(
      method: 'GET',
      host: Host(url: 'localhost'),
      path: '/1/test',
      timeout: const Duration(seconds: 5),
      connectTimeout: const Duration(seconds: 2),
      queryParameters: const {},
    );

    await expectLater(
      requester.perform(request),
      throwsA(
        isA<AlgoliaApiException>()
            .having((e) => e.statusCode, 'statusCode', 429)
            .having(
                (e) => headerOf(e.headers, 'retry-after'), 'Retry-After', '2')
            .having((e) => e.correlationId, 'correlationId', 'corr-429'),
      ),
    );
    requester.close();
  });
}
