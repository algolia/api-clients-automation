import 'package:algolia_client_search/algolia_client_search.dart';
import 'package:test/test.dart';

final requestIdFormat = RegExp(r'^[0-9A-Za-z]{11}$');

/// Records the Request-ID header of every request it serves, optionally
/// failing with retryable errors before succeeding.
final class RecordingRequester implements Requester {
  final List<String?> requestIds = [];
  int failuresBeforeSuccess;
  Map<String, dynamic> Function(HttpRequest request) bodyFor;

  RecordingRequester({
    this.failuresBeforeSuccess = 0,
    Map<String, dynamic> Function(HttpRequest request)? bodyFor,
  }) : bodyFor = bodyFor ?? ((_) => const {});

  @override
  Future<HttpResponse> perform(HttpRequest request) async {
    String? requestId;
    request.headers?.forEach((key, value) {
      if (key.toLowerCase() == 'request-id') {
        requestId = value?.toString();
      }
    });
    requestIds.add(requestId);

    if (failuresBeforeSuccess > 0) {
      failuresBeforeSuccess--;
      throw AlgoliaIOException(Exception('network down'));
    }

    return HttpResponse(200, bodyFor(request));
  }

  @override
  Duration? get connectTimeout => null;

  @override
  void setConnectTimeout(Duration connectTimeout) {}

  @override
  void setClientApiKey(String apiKey) {}

  @override
  void close() {}
}

RetryStrategy strategy(
  RecordingRequester requester, {
  bool requestIdSupport = true,
  bool hasDefaultRequestId = false,
  int hostCount = 1,
}) =>
    RetryStrategy(
      requester: requester,
      readTimeout: const Duration(seconds: 5),
      writeTimeout: const Duration(seconds: 30),
      hosts: List.generate(hostCount, (_) => Host(url: 'localhost')),
      requestIdSupport: requestIdSupport,
      hasDefaultRequestId: hasDefaultRequestId,
    );

const getRequest = ApiRequest(method: RequestMethod.get, path: '/1/test');

void main() {
  test('generate format and uniqueness', () {
    final ids = List.generate(100, (_) => generateRequestId());

    for (final id in ids) {
      expect(id, matches(requestIdFormat));
    }
    expect(ids.toSet().length, greaterThan(90),
        reason: 'IDs are expected to be essentially unique');
  });

  test('hasRequestIdHeader is case-insensitive', () {
    expect(hasRequestIdHeader(null), isFalse);
    expect(hasRequestIdHeader({'x-forwarded-for': '1'}), isFalse);
    expect(hasRequestIdHeader({'request-id': 'a'}), isTrue);
    expect(hasRequestIdHeader({'ReQuEsT-iD': 'a'}), isTrue);
    expect(hasRequestIdHeader({'REQUEST-ID': 'a'}), isTrue);
  });

  test('mints a fresh Request-ID per execution', () async {
    final requester = RecordingRequester();
    final retryStrategy = strategy(requester);

    await retryStrategy.execute(request: getRequest);
    await retryStrategy.execute(request: getRequest);

    expect(requester.requestIds, hasLength(2));
    expect(requester.requestIds[0], matches(requestIdFormat));
    expect(requester.requestIds[1], matches(requestIdFormat));
    expect(requester.requestIds[0], isNot(requester.requestIds[1]));
  });

  test('reuses the Request-ID across retries', () async {
    final requester = RecordingRequester(failuresBeforeSuccess: 2);
    final retryStrategy = strategy(requester, hostCount: 3);

    await retryStrategy.execute(request: getRequest);

    expect(requester.requestIds, hasLength(3));
    expect(requester.requestIds[0], matches(requestIdFormat));
    expect(requester.requestIds.toSet(), hasLength(1));
  });

  test('a caller-supplied Request-ID wins over minting', () async {
    final requester = RecordingRequester();
    final retryStrategy = strategy(requester);

    await retryStrategy.execute(
      request: getRequest,
      options: const RequestOptions(headers: {'ReQuEsT-iD': 'CallerOwnedId'}),
    );

    expect(requester.requestIds, ['CallerOwnedId']);
  });

  test(
      'a caller-supplied x-algolia-request-id query parameter suppresses minting',
      () async {
    final requester = RecordingRequester();
    final retryStrategy = strategy(requester);

    await retryStrategy.execute(
      request: getRequest,
      options: const RequestOptions(
          urlParameters: {'X-Algolia-Request-Id': 'QueryOwned'}),
    );

    expect(requester.requestIds, [null]);
  });

  test('an operation-supplied Request-ID wins over minting', () async {
    final requester = RecordingRequester();
    final retryStrategy = strategy(requester);

    await retryStrategy.execute(
      request: const ApiRequest(
        method: RequestMethod.get,
        path: '/1/test',
        headers: {'REQUEST-ID': 'OperationOwned'},
      ),
    );

    expect(requester.requestIds, ['OperationOwned']);
  });

  test('a default-headers Request-ID suppresses minting', () async {
    final requester = RecordingRequester();
    final retryStrategy = strategy(requester, hasDefaultRequestId: true);

    await retryStrategy.execute(request: getRequest);

    expect(requester.requestIds, [null]);
  });

  test('disabled clients never mint', () async {
    final requester = RecordingRequester();
    final retryStrategy = strategy(requester, requestIdSupport: false);

    await retryStrategy.execute(request: getRequest);

    expect(requester.requestIds, [null]);
  });

  test('requestIdEnabled: false disables minting on a supporting client',
      () async {
    final requester = RecordingRequester();
    final client = SearchClient(
      appId: 'test-app-id',
      apiKey: 'test-api-key',
      options: ClientOptions(
        requester: requester,
        hosts: [Host(url: 'localhost')],
        requestIdEnabled: false,
      ),
    );

    await client.customGet(path: '1/test');

    expect(requester.requestIds, [null]);
  });

  test('requestIdEnabled: false disables helper minting too', () async {
    final requester = RecordingRequester(
        bodyFor: (_) => {'status': 'published', 'updatedAt': ''});
    final client = SearchClient(
      appId: 'test-app-id',
      apiKey: 'test-api-key',
      options: ClientOptions(
        requester: requester,
        hosts: [Host(url: 'localhost')],
        requestIdEnabled: false,
      ),
    );

    await client.waitTask(indexName: 'indexName', taskID: 42);

    expect(requester.requestIds, [null]);
  });

  test('waitTask polls share one Request-ID per invocation', () async {
    var polls = 0;
    final requester = RecordingRequester(bodyFor: (_) {
      polls++;
      return {
        'status': polls < 2 ? 'notPublished' : 'published',
        'updatedAt': ''
      };
    });
    final client = SearchClient(
      appId: 'test-app-id',
      apiKey: 'test-api-key',
      options:
          ClientOptions(requester: requester, hosts: [Host(url: 'localhost')]),
    );

    await client.waitTask(indexName: 'indexName', taskID: 42);

    expect(requester.requestIds, hasLength(2));
    expect(requester.requestIds[0], matches(requestIdFormat));
    expect(requester.requestIds.toSet(), hasLength(1));

    // A second helper invocation mints a fresh ID.
    polls = 1;
    await client.waitTask(indexName: 'indexName', taskID: 42);

    expect(requester.requestIds, hasLength(3));
    expect(requester.requestIds[2], isNot(requester.requestIds[0]));
  });

  test(
      'waitTask mints one shared ID when default headers carry an ID '
      'a custom requester never sends', () async {
    final requester = RecordingRequester(
        bodyFor: (_) => {'status': 'published', 'updatedAt': ''});
    final client = SearchClient(
      appId: 'test-app-id',
      apiKey: 'test-api-key',
      options: ClientOptions(
        requester: requester,
        hosts: [Host(url: 'localhost')],
        headers: {'Request-ID': 'NeverReachesTheWire'},
      ),
    );

    await client.waitTask(indexName: 'indexName', taskID: 42);

    expect(requester.requestIds, hasLength(1));
    expect(requester.requestIds[0], matches(requestIdFormat));
  });

  test('waitTask keeps a caller-supplied Request-ID', () async {
    final requester = RecordingRequester(
        bodyFor: (_) => {'status': 'published', 'updatedAt': ''});
    final client = SearchClient(
      appId: 'test-app-id',
      apiKey: 'test-api-key',
      options:
          ClientOptions(requester: requester, hosts: [Host(url: 'localhost')]),
    );

    await client.waitTask(
      indexName: 'indexName',
      taskID: 42,
      requestOptions:
          const RequestOptions(headers: {'Request-ID': 'HelperCaller'}),
    );

    expect(requester.requestIds, ['HelperCaller']);
  });

  test('AlgoliaApiException surfaces the Correlation-ID', () {
    const withId =
        AlgoliaApiException(400, 'boom', correlationId: 'CorrTest123');
    expect(withId.correlationId, 'CorrTest123');
    expect(withId.toString(), endsWith('(Correlation-ID: CorrTest123)'));

    const withoutId = AlgoliaApiException(400, 'boom');
    expect(withoutId.correlationId, isNull);
    expect(withoutId.toString(),
        'AlgoliaApiException{statusCode: 400, error: boom}');
  });

  test('HttpResponse carries optional headers without changing equality', () {
    const bare = HttpResponse(200, {});
    const withHeaders = HttpResponse(200, {}, headers: {'correlation-id': 'x'});

    expect(bare.headers, isNull);
    expect(withHeaders.headers, {'correlation-id': 'x'});
    expect(bare == withHeaders, isTrue);
  });
}
