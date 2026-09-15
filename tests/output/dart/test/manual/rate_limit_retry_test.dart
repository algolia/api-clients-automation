import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_client_core/src/transport/rate_limit.dart';
import 'package:test/test.dart';

const ok = HttpResponse(200, {'message': 'ok'});
const serverError = AlgoliaApiException(500, {'message': 'server error'});
const rateLimitedBody = {'message': 'Too many requests'};

AlgoliaApiException rateLimited({
  Map<String, String>? headers,
  String? correlationId,
}) =>
    AlgoliaApiException(
      429,
      rateLimitedBody,
      correlationId: correlationId,
      headers: headers,
    );

/// Answers each request from a per-host script and records every call. A
/// scripted [AlgoliaException] is thrown, an [HttpResponse] is returned as is
/// (a requester may report errors either way); the last outcome repeats.
final class ScriptedRequester implements Requester {
  final Map<String, List<Object>> scripts;
  final List<String> calls = [];

  ScriptedRequester(this.scripts);

  @override
  Future<HttpResponse> perform(HttpRequest request) async {
    final hostUrl = request.host.url;
    calls.add(hostUrl);
    final script = scripts[hostUrl]!;
    final outcome = script.length > 1 ? script.removeAt(0) : script.first;
    if (outcome is AlgoliaException) throw outcome;
    return outcome as HttpResponse;
  }

  @override
  Duration? connectTimeout;

  @override
  void setConnectTimeout(Duration connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  @override
  void setClientApiKey(String apiKey) {}

  @override
  void close() {}
}

RetryStrategy strategy(
  ScriptedRequester requester,
  List<Duration> waits, {
  List<String> hosts = const ['a'],
  int? maxRateLimitRetries,
}) =>
    RetryStrategy(
      requester: requester,
      readTimeout: const Duration(seconds: 5),
      writeTimeout: const Duration(seconds: 30),
      hosts: hosts.map((url) => Host(url: url)),
      maxRateLimitRetries: maxRateLimitRetries,
      sleep: (duration) async {
        waits.add(duration);
      },
    );

const getRequest = ApiRequest(method: RequestMethod.get, path: '/1/test');

final isRateLimitedException = isA<AlgoliaApiException>()
    .having((e) => e.statusCode, 'statusCode', 429)
    .having((e) => e.error, 'error', rateLimitedBody);

void main() {
  group('parseRetryAfter', () {
    const oneSecond = Duration(seconds: 1);
    const ceiling = Duration(seconds: maxRateLimitWaitSeconds);

    test('honours a positive whole number of seconds', () {
      expect(parseRetryAfter({'retry-after': '2'}), const Duration(seconds: 2));
      expect(
          parseRetryAfter({'retry-after': ' 3 '}), const Duration(seconds: 3));
      expect(
          parseRetryAfter({'retry-after': '007'}), const Duration(seconds: 7));
    });

    test('matches the header name case-insensitively', () {
      expect(parseRetryAfter({'Retry-After': '4'}), const Duration(seconds: 4));
      expect(parseRetryAfter({'RETRY-AFTER': '5'}), const Duration(seconds: 5));
    });

    test('falls back to one second when the header is missing or unusable', () {
      expect(parseRetryAfter(null), oneSecond);
      expect(parseRetryAfter({}), oneSecond);
      expect(parseRetryAfter({'x-other': '2'}), oneSecond);
      expect(parseRetryAfter({'retry-after': ''}), oneSecond);
      expect(parseRetryAfter({'retry-after': '0'}), oneSecond);
      expect(parseRetryAfter({'retry-after': '-5'}), oneSecond);
      expect(parseRetryAfter({'retry-after': 'abc'}), oneSecond);
      expect(parseRetryAfter({'retry-after': '1.5'}), oneSecond);
      expect(
        parseRetryAfter({'retry-after': 'Wed, 21 Oct 2015 07:28:00 GMT'}),
        oneSecond,
      );
    });

    test('accepts ASCII digits only', () {
      // Arabic-Indic three.
      expect(parseRetryAfter({'retry-after': '٣'}), oneSecond);
    });

    test('waits the Duration ceiling for values it cannot hold', () {
      expect(ceiling.isNegative, isFalse);
      expect(parseRetryAfter({'retry-after': '9223372036854'}), ceiling);
      expect(parseRetryAfter({'retry-after': '9223372036855'}), ceiling);
      expect(
        parseRetryAfter({'retry-after': '99999999999999999999'}),
        ceiling,
      );
    });
  });

  group('resolveMaxRateLimitRetries', () {
    test('null means the default, negative means zero', () {
      expect(resolveMaxRateLimitRetries(null), defaultMaxRateLimitRetries);
      expect(resolveMaxRateLimitRetries(null), 3);
      expect(resolveMaxRateLimitRetries(0), 0);
      expect(resolveMaxRateLimitRetries(-1), 0);
      expect(resolveMaxRateLimitRetries(5), 5);
    });
  });

  group('RetryStrategy', () {
    test('retries a 429 on the same host after Retry-After', () async {
      final waits = <Duration>[];
      final requester = ScriptedRequester({
        'a': [
          rateLimited(headers: {'retry-after': '2'}),
          ok
        ],
      });
      final retryStrategy = strategy(requester, waits);

      final response = await retryStrategy.execute(request: getRequest);

      expect(response, {'message': 'ok'});
      expect(requester.calls, ['a', 'a']);
      expect(waits, [const Duration(seconds: 2)]);
      final host = retryStrategy.hosts.single;
      expect(host.isUp, isTrue);
      expect(host.retryCount, 0);
    });

    test('waits one second when Retry-After is missing', () async {
      final waits = <Duration>[];
      final requester = ScriptedRequester({
        'a': [rateLimited(), ok],
      });

      await strategy(requester, waits).execute(request: getRequest);

      expect(requester.calls, ['a', 'a']);
      expect(waits, [const Duration(seconds: 1)]);
    });

    test('also retries when the requester returns the 429 as a response',
        () async {
      final waits = <Duration>[];
      final requester = ScriptedRequester({
        'a': [
          const HttpResponse(429, rateLimitedBody,
              headers: {'Retry-After': '1'}),
          ok,
        ],
      });

      await strategy(requester, waits).execute(request: getRequest);

      expect(requester.calls, ['a', 'a']);
      expect(waits, [const Duration(seconds: 1)]);
    });

    test('fails on the first 429 when maxRateLimitRetries is 0', () async {
      final waits = <Duration>[];
      final requester = ScriptedRequester({
        'a': [
          rateLimited(headers: {'retry-after': '2'})
        ],
      });
      final retryStrategy = strategy(requester, waits, maxRateLimitRetries: 0);

      await expectLater(
        retryStrategy.execute(request: getRequest),
        throwsA(isRateLimitedException),
      );
      expect(requester.calls, ['a']);
      expect(waits, isEmpty);
    });

    test('treats a negative maxRateLimitRetries like 0', () async {
      final waits = <Duration>[];
      final requester = ScriptedRequester({
        'a': [rateLimited()],
      });
      final retryStrategy = strategy(requester, waits, maxRateLimitRetries: -1);

      await expectLater(
        retryStrategy.execute(request: getRequest),
        throwsA(isRateLimitedException),
      );
      expect(requester.calls, ['a']);
      expect(waits, isEmpty);
    });

    test('surfaces the 429 once the default budget is used up', () async {
      final waits = <Duration>[];
      final requester = ScriptedRequester({
        'a': [
          rateLimited(headers: {'retry-after': '2'})
        ],
      });
      final retryStrategy = strategy(requester, waits);

      await expectLater(
        retryStrategy.execute(request: getRequest),
        throwsA(isRateLimitedException),
      );
      expect(requester.calls, ['a', 'a', 'a', 'a']);
      expect(waits, List.filled(3, const Duration(seconds: 2)));
      expect(retryStrategy.hosts.single.isUp, isTrue);
    });

    test('restores the connect timeout before waiting on a 429', () async {
      final requester = ScriptedRequester({
        'a': [
          rateLimited(headers: {'retry-after': '2'}),
          ok
        ],
      });
      requester.setConnectTimeout(const Duration(seconds: 2));
      final seenWhileWaiting = <Duration?>[];
      final retryStrategy = RetryStrategy(
        requester: requester,
        readTimeout: const Duration(seconds: 5),
        writeTimeout: const Duration(seconds: 30),
        hosts: [Host(url: 'a')],
        sleep: (_) async {
          seenWhileWaiting.add(requester.connectTimeout);
        },
      );

      await retryStrategy.execute(
        request: getRequest,
        options: const RequestOptions(connectTimeout: Duration(seconds: 9)),
      );

      // The per-call override must not leak to concurrent requests for the
      // length of the wait, so it is restored before sleep runs.
      expect(seenWhileWaiting, [const Duration(seconds: 2)]);
      expect(requester.connectTimeout, const Duration(seconds: 2));
    });

    test('still fails over to the next host on a 5xx', () async {
      final waits = <Duration>[];
      final requester = ScriptedRequester({
        'a': [serverError],
        'b': [ok],
      });
      final retryStrategy = strategy(requester, waits, hosts: ['a', 'b']);

      await retryStrategy.execute(request: getRequest);

      expect(requester.calls, ['a', 'b']);
      expect(waits, isEmpty);
      expect(retryStrategy.hosts.first.isUp, isFalse);
      expect(retryStrategy.hosts.last.isUp, isTrue);
    });

    test('shares the budget across hosts', () async {
      final waits = <Duration>[];
      final requester = ScriptedRequester({
        'a': [rateLimited(), serverError],
        'b': [rateLimited()],
      });
      final retryStrategy = strategy(requester, waits, hosts: ['a', 'b']);

      await expectLater(
        retryStrategy.execute(request: getRequest),
        throwsA(isRateLimitedException),
      );
      expect(requester.calls, ['a', 'a', 'b', 'b', 'b']);
      expect(waits, hasLength(3));
    });

    test('keeps the waited-out 429 visible when every host fails', () async {
      final waits = <Duration>[];
      final requester = ScriptedRequester({
        'a': [rateLimited(correlationId: 'corr-429'), serverError],
        'b': [serverError],
      });
      final retryStrategy = strategy(requester, waits, hosts: ['a', 'b']);

      await expectLater(
        retryStrategy.execute(request: getRequest),
        throwsA(
          isA<UnreachableHostsException>().having(
            (e) => e.errors,
            'errors',
            [
              isRateLimitedException.having(
                  (e) => e.correlationId, 'correlationId', 'corr-429'),
              serverError,
              serverError,
            ],
          ),
        ),
      );
      expect(waits, [const Duration(seconds: 1)]);
    });

    test('create resolves maxRateLimitRetries from ClientOptions', () {
      final requester = ScriptedRequester({});
      RetryStrategy create(int? maxRateLimitRetries) => RetryStrategy.create(
            segment: AgentSegment(value: 'Test', version: '0.0.0'),
            appId: 'appId',
            apiKey: 'apiKey',
            defaultHosts: () => [Host(url: 'a')],
            options: ClientOptions(
              requester: requester,
              maxRateLimitRetries: maxRateLimitRetries,
            ),
          );

      expect(create(null).maxRateLimitRetries, 3);
      expect(create(0).maxRateLimitRetries, 0);
      expect(create(-2).maxRateLimitRetries, 0);
      expect(create(7).maxRateLimitRetries, 7);
    });
  });

  group('ClientOptions', () {
    test('includes maxRateLimitRetries in equality, hashCode and toString', () {
      const zero = ClientOptions(maxRateLimitRetries: 0);
      const alsoZero = ClientOptions(maxRateLimitRetries: 0);
      const unset = ClientOptions();

      expect(zero, alsoZero);
      expect(zero.hashCode, alsoZero.hashCode);
      expect(zero, isNot(unset));
      expect(zero.toString(), contains('maxRateLimitRetries: 0'));
      expect(unset.toString(), contains('maxRateLimitRetries: null'));
    });
  });
}
