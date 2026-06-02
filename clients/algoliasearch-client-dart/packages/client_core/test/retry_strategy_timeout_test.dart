import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:test/test.dart';

/// Mirrors the CTS echo requester: it carries its own non-null connect timeout
/// (like the generated `RequestInterceptor`) and captures the outgoing
/// [HttpRequest] before short-circuiting the call.
class _CaptureRequester extends Requester {
  HttpRequest? captured;

  @override
  Duration connectTimeout = const Duration(seconds: 30);

  @override
  Future<HttpResponse> perform(HttpRequest request) {
    captured = request;
    return Future.error(_StopException());
  }

  @override
  void setClientApiKey(String apiKey) {}

  @override
  void setConnectTimeout(Duration connectTimeout) {
    this.connectTimeout = connectTimeout;
  }
}

class _StopException implements Exception {}

void main() {
  Iterable<Host> defaultHosts() => [const Host(url: 'localhost')];

  // The ingestion spec sets every server timeout to 25s; the generated client
  // forwards those as the per-client defaults below.
  const ingestionDefault = Duration(milliseconds: 25000);

  RetryStrategy build(ClientOptions options) => RetryStrategy.create(
        segment: AgentSegment(value: 'Test', version: '0.0.0'),
        appId: 'appId',
        apiKey: 'apiKey',
        defaultHosts: defaultHosts,
        options: options,
        defaultConnectTimeout: ingestionDefault,
        defaultReadTimeout: ingestionDefault,
        defaultWriteTimeout: ingestionDefault,
      );

  group('RetryStrategy per-client default timeouts', () {
    test('applies per-client defaults when ClientOptions leaves timeouts unset',
        () {
      final strategy = build(const ClientOptions());
      expect(strategy.readTimeout, ingestionDefault);
      expect(strategy.writeTimeout, ingestionDefault);
    });

    test(
        'keeps per-client defaults when other options are set (e.g. requester)',
        () async {
      final requester = _CaptureRequester();
      final strategy = build(ClientOptions(requester: requester));

      expect(strategy.readTimeout, ingestionDefault);
      expect(strategy.writeTimeout, ingestionDefault);
      // The resolved connect timeout is pushed onto the provided requester.
      expect(requester.connectTimeout, ingestionDefault);

      // A read call should go out with the per-client read + connect timeouts —
      // this is what the "calls api with default read timeouts" CTS test asserts.
      await strategy
          .execute(
            request:
                const ApiRequest(method: RequestMethod.get, path: '1/test'),
          )
          .catchError((_) => <String, dynamic>{});

      expect(requester.captured, isNotNull);
      expect(requester.captured!.timeout, ingestionDefault);
      expect(requester.captured!.connectTimeout, ingestionDefault);
    });

    test('explicit caller timeouts win over per-client defaults', () {
      final strategy =
          build(const ClientOptions(readTimeout: Duration(seconds: 3)));
      expect(strategy.readTimeout, const Duration(seconds: 3));
      // Untouched fields still fall back to the per-client default.
      expect(strategy.writeTimeout, ingestionDefault);
    });
  });
}
