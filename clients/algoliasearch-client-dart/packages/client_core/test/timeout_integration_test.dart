import 'dart:io';

import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_client_core/src/transport/dio/dio_requester.dart';
import 'package:test/test.dart';

/// Test server address
String get testServer {
  final isDocker = File('/.dockerenv').existsSync();
  return isDocker ? 'host.docker.internal' : 'localhost';
}

/// Creates a RetryStrategy with a single custom host
RetryStrategy createRetryStrategyWithHost(String hostUrl,
    {String scheme = 'https', int? port}) {
  final host = Host(url: hostUrl, scheme: scheme, port: port);
  return RetryStrategy(
    requester: DioRequester(appId: 'test-app', apiKey: 'test-key'),
    readTimeout: Duration(seconds: 5),
    writeTimeout: Duration(seconds: 30),
    hosts: [host],
  );
}

/// Creates a RetryStrategy pointing to the test server
RetryStrategy createServerRetryStrategy() {
  return createRetryStrategyWithHost(testServer, scheme: 'http', port: 6676);
}

void main() {
  group('Timeout Integration Tests', () {
    test('retry count increases timeout: 2s -> 4s -> 6s', () async {
      final retryStrategy = createRetryStrategyWithHost('10.255.255.1');

      final times = <double>[];

      for (var i = 0; i < 3; i++) {
        final start = DateTime.now();
        try {
          await retryStrategy.execute(
            request: ApiRequest(
              method: RequestMethod.get,
              path: '/test',
              isRead: true,
            ),
          );
        } catch (e) {
          final elapsed =
              DateTime.now().difference(start).inMilliseconds / 1000.0;
          times.add(elapsed);
        }
      }

      retryStrategy.dispose();

      expect(times.length, equals(3), reason: 'Should have 3 timeout measurements');
      expect(times[0], greaterThan(1.5),
          reason: 'Request 1 should be >= 1.5s, got ${times[0].toStringAsFixed(2)}s');
      expect(times[0], lessThan(2.5),
          reason: 'Request 1 should be < 2.5s, got ${times[0].toStringAsFixed(2)}s');

      expect(times[1], greaterThan(3.5),
          reason: 'Request 2 should be >= 3.5s, got ${times[1].toStringAsFixed(2)}s');
      expect(times[1], lessThan(4.5),
          reason: 'Request 2 should be < 4.5s, got ${times[1].toStringAsFixed(2)}s');

      expect(times[2], greaterThan(5.5),
          reason: 'Request 3 should be >= 5.5s, got ${times[2].toStringAsFixed(2)}s');
      expect(times[2], lessThan(7.0),
          reason: 'Request 3 should be < 7.0s, got ${times[2].toStringAsFixed(2)}s');
    });

    test('retry count resets to 0 after successful request', () async {
      // Start with bad host to increment retry count
      final retryStrategy = createRetryStrategyWithHost('10.255.255.1');

      // Fail twice to increment retry_count to 2
      for (var i = 0; i < 2; i++) {
        try {
          await retryStrategy.execute(
            request: ApiRequest(
              method: RequestMethod.get,
              path: '/test',
              isRead: true,
            ),
          );
        } catch (e) {
        }
      }

      final badHost = retryStrategy.hosts.first;
      final retryCountBeforeSuccess = badHost.retryCount;
      expect(retryCountBeforeSuccess, equals(2),
          reason: 'Bad host should have retry_count = 2 after two timeouts');

      // Switch to good host and make successful request
      final goodRetryStrategy = createServerRetryStrategy();

      // Manually set retry count on good host to match bad host (simulates same host)
      final goodHost = goodRetryStrategy.hosts.first;
      goodHost.retryCount = badHost.retryCount;

      final response = await goodRetryStrategy.execute(
        request: ApiRequest(
          method: RequestMethod.get,
          path: '/1/test/instant',
          isRead: true,
        ),
      );

      expect(response, isNotNull, reason: 'Should get successful response');
      expect(goodHost.retryCount, equals(0),
          reason: 'retry_count should reset to 0 after success, got ${goodHost.retryCount}');

      final resetRetryStrategy = createRetryStrategyWithHost('10.255.255.1');

      // The new strategy should start with retry_count = 0
      final start = DateTime.now();
      try {
        await resetRetryStrategy.execute(
          request: ApiRequest(
            method: RequestMethod.get,
            path: '/test',
            isRead: true,
          ),
        );
        fail('Request should have timed out');
      } catch (e) {
        final elapsed = DateTime.now().difference(start).inMilliseconds / 1000.0;
        expect(elapsed, greaterThan(1.5),
            reason: 'After reset should be >= 1.5s, got ${elapsed.toStringAsFixed(2)}s');
        expect(elapsed, lessThan(2.5),
            reason: 'After reset should be < 2.5s, got ${elapsed.toStringAsFixed(2)}s');
      }

      retryStrategy.dispose();
      goodRetryStrategy.dispose();
      resetRetryStrategy.dispose();
    });

    test('multiple hosts have independent retry counts', () async {
      // Create strategy with two bad hosts
      final host1 = Host(url: '10.255.255.1', scheme: 'https');
      final host2 = Host(url: '10.255.255.2', scheme: 'https');

      final retryStrategy = RetryStrategy(
        requester: DioRequester(appId: 'test-app', apiKey: 'test-key'),
        readTimeout: Duration(seconds: 5),
        writeTimeout: Duration(seconds: 30),
        hosts: [host1, host2],
      );

      // First request hits host1, times out at ~2s, host1.retry_count = 1
      final start1 = DateTime.now();
      try {
        await retryStrategy.execute(
          request: ApiRequest(
            method: RequestMethod.get,
            path: '/test',
            isRead: true,
          ),
        );
      } catch (e) {
      }
      final elapsed1 = DateTime.now().difference(start1).inMilliseconds / 1000.0;

      final retryableHost1 = retryStrategy.hosts.elementAt(0);
      final retryableHost2 = retryStrategy.hosts.elementAt(1);

      expect(retryableHost1.retryCount, equals(1),
          reason: 'Host1 should have retry_count = 1');
      expect(retryableHost2.retryCount, equals(1),
          reason: 'Host2 should have retry_count = 1 (also tried and timed out)');

      // Both hosts should timeout at ~2s on their first attempt
      expect(elapsed1, greaterThan(1.5),
          reason: 'First attempt should timeout at ~2s per host');
      expect(elapsed1, lessThan(5.0),
          reason: 'Should timeout before reaching 5s');

      // Second request should try host1 again (now with retry_count = 1)
      // Expected timeout at ~4s for host1, then ~4s for host2
      final start2 = DateTime.now();
      try {
        await retryStrategy.execute(
          request: ApiRequest(
            method: RequestMethod.get,
            path: '/test',
            isRead: true,
          ),
        );
      } catch (e) {
      }
      final elapsed2 = DateTime.now().difference(start2).inMilliseconds / 1000.0;

      expect(retryableHost1.retryCount, equals(2),
          reason: 'Host1 should have retry_count = 2');
      expect(retryableHost2.retryCount, equals(2),
          reason: 'Host2 should have retry_count = 2');

      // Total timeout should be ~4s + ~4s = ~8s
      expect(elapsed2, greaterThan(7.0),
          reason: 'Second request should take ~8s total, got ${elapsed2.toStringAsFixed(2)}s');
      expect(elapsed2, lessThan(10.0),
          reason: 'Second request should be < 10s, got ${elapsed2.toStringAsFixed(2)}s');

      retryStrategy.dispose();
    });

    test('mixed hosts: only bad host gets increased timeout', () async {
      final badHost = Host(url: '10.255.255.1', scheme: 'https');
      final goodHost = Host(url: testServer, scheme: 'http', port: 6676);

      final retryStrategy = RetryStrategy(
        requester: DioRequester(appId: 'test-app', apiKey: 'test-key'),
        readTimeout: Duration(seconds: 5),
        writeTimeout: Duration(seconds: 30),
        hosts: [badHost, goodHost],
      );

      // First request: bad host times out at ~2s, then good host succeeds
      final start1 = DateTime.now();
      final response = await retryStrategy.execute(
        request: ApiRequest(
          method: RequestMethod.get,
          path: '/1/test/instant',
          isRead: true,
        ),
      );
      final elapsed1 = DateTime.now().difference(start1).inMilliseconds / 1000.0;

      expect(response, isNotNull, reason: 'Should succeed on good host');

      // Total time should be ~2s (bad host timeout) + instant (good host)
      expect(elapsed1, greaterThan(1.5),
          reason: 'Should take at least 2s for bad host timeout');
      expect(elapsed1, lessThan(3.0),
          reason: 'Should complete within 3s');

      final retryableHost1 = retryStrategy.hosts.elementAt(0);
      final retryableHost2 = retryStrategy.hosts.elementAt(1);

      expect(retryableHost1.retryCount, equals(1),
          reason: 'Bad host should have retry_count = 1');
      expect(retryableHost2.retryCount, equals(0),
          reason: 'Good host should have retry_count = 0 (reset after success)');

      // Second request: bad host now times out at ~4s, then good host succeeds
      final start2 = DateTime.now();
      await retryStrategy.execute(
        request: ApiRequest(
          method: RequestMethod.get,
          path: '/1/test/instant',
          isRead: true,
        ),
      );
      final elapsed2 = DateTime.now().difference(start2).inMilliseconds / 1000.0;

      // Total time should be ~4s (bad host timeout with retry_count=1) + instant
      expect(elapsed2, greaterThan(3.5),
          reason: 'Should take at least 4s for bad host timeout, got ${elapsed2.toStringAsFixed(2)}s');
      expect(elapsed2, lessThan(5.0),
          reason: 'Should complete within 5s, got ${elapsed2.toStringAsFixed(2)}s');

      expect(retryableHost1.retryCount, equals(2),
          reason: 'Bad host should have retry_count = 2');
      expect(retryableHost2.retryCount, equals(0),
          reason: 'Good host should still have retry_count = 0');

      retryStrategy.dispose();
    });
  });
}
