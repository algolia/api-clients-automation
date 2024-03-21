import 'package:algolia_client_recommend/algolia_client_recommend.dart';
import 'package:algolia_test/algolia_test.dart';
import 'package:test/test.dart';
import 'package:test_api/hooks.dart';

void main() {
  test('calls api with correct read host', () async {
    final requester = RequestInterceptor();
    final client = RecommendClient(
        appId: "test-app-id",
        apiKey: "test-api-key",
        options: ClientOptions(requester: requester));
    requester.setOnRequest((request) {
      expect(request.host.url, 'test-app-id-dsn.algolia.net');
    });
    try {
      final res = await client.customGet(
        path: "test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('calls api with correct write host', () async {
    final requester = RequestInterceptor();
    final client = RecommendClient(
        appId: "test-app-id",
        apiKey: "test-api-key",
        options: ClientOptions(requester: requester));
    requester.setOnRequest((request) {
      expect(request.host.url, 'test-app-id.algolia.net');
    });
    try {
      final res = await client.customPost(
        path: "test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('calls api with correct user agent', () async {
    final requester = RequestInterceptor();
    final client = RecommendClient(
      appId: 'appId',
      apiKey: 'apiKey',
      options: ClientOptions(requester: requester),
    );
    requester.setOnRequest((request) {
      TestHandle.current.markSkipped('User agent added using an interceptor');
    });
    try {
      final res = await client.customPost(
        path: "1/test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('calls api with default read timeouts', () async {
    final requester = RequestInterceptor();
    final client = RecommendClient(
      appId: 'appId',
      apiKey: 'apiKey',
      options: ClientOptions(requester: requester),
    );
    requester.setOnRequest((request) {
      expect(5000, request.timeout.inMilliseconds);
    });
    try {
      final res = await client.customGet(
        path: "1/test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('calls api with default write timeouts', () async {
    final requester = RequestInterceptor();
    final client = RecommendClient(
      appId: 'appId',
      apiKey: 'apiKey',
      options: ClientOptions(requester: requester),
    );
    requester.setOnRequest((request) {
      expect(30000, request.timeout.inMilliseconds);
    });
    try {
      final res = await client.customPost(
        path: "1/test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });
}
