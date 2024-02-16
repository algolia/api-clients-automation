import 'package:algolia_client_search/algolia_client_search.dart';
import 'package:algolia_test/algolia_test.dart';
import 'package:test/test.dart';
import 'package:test_api/hooks.dart';

void main() {
  test('calls api with correct read host', () async {
    final requester = RequestInterceptor();
    final client = SearchClient(
        appId: "test-app-id",
        apiKey: "test-api-key",
        options: ClientOptions(requester: requester));
    requester.setOnRequest((request) {
      expect(request.host.url, 'test-app-id-dsn.algolia.net');
    });
    try {
      final res = await client.customGet(
        path: "/test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('calls api with correct write host', () async {
    final requester = RequestInterceptor();
    final client = SearchClient(
        appId: "test-app-id",
        apiKey: "test-api-key",
        options: ClientOptions(requester: requester));
    requester.setOnRequest((request) {
      expect(request.host.url, 'test-app-id.algolia.net');
    });
    try {
      final res = await client.customPost(
        path: "/test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('tests the retry strategy', () async {
    final requester = RequestInterceptor();
    final client = SearchClient(
        appId: "test-app-id",
        apiKey: "test-api-key",
        options: ClientOptions(hosts: [
          Host.create(url: 'localhost:6677', scheme: 'http'),
          Host.create(url: 'localhost:6678', scheme: 'http'),
        ]));
    requester.setOnRequest((request) {});
    try {
      final res = await client.customGet(
        path: "/test",
      );
      expectBody(res, """{"message":"ok test server response"}""");
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('calls api with correct user agent', () async {
    final requester = RequestInterceptor();
    final client = SearchClient(
      appId: 'appId',
      apiKey: 'apiKey',
      options: ClientOptions(requester: requester),
    );
    requester.setOnRequest((request) {
      TestHandle.current.markSkipped('User agent added using an interceptor');
    });
    try {
      final res = await client.customPost(
        path: "/test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('calls api with default read timeouts', () async {
    final requester = RequestInterceptor();
    final client = SearchClient(
      appId: 'appId',
      apiKey: 'apiKey',
      options: ClientOptions(requester: requester),
    );
    requester.setOnRequest((request) {
      expect(5000, request.timeout.inMilliseconds);
    });
    try {
      final res = await client.customGet(
        path: "/test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('calls api with default write timeouts', () async {
    final requester = RequestInterceptor();
    final client = SearchClient(
      appId: 'appId',
      apiKey: 'apiKey',
      options: ClientOptions(requester: requester),
    );
    requester.setOnRequest((request) {
      expect(30000, request.timeout.inMilliseconds);
    });
    try {
      final res = await client.customPost(
        path: "/test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('client throws with invalid parameters', () async {
    final requester = RequestInterceptor();
    expectError(
      '`appId` is missing.',
      () async {
        final client = SearchClient(
            appId: "",
            apiKey: "",
            options: ClientOptions(requester: requester));
      },
    );
    expectError(
      '`appId` is missing.',
      () async {
        final client = SearchClient(
            appId: "",
            apiKey: "my-api-key",
            options: ClientOptions(requester: requester));
      },
    );
    expectError(
      '`apiKey` is missing.',
      () async {
        final client = SearchClient(
            appId: "my-app-id",
            apiKey: "",
            options: ClientOptions(requester: requester));
      },
    );
  });

  test('`addApiKey` throws with invalid parameters', () async {
    final requester = RequestInterceptor();
    final client = SearchClient(
      appId: 'appId',
      apiKey: 'apiKey',
      options: ClientOptions(requester: requester),
    );
    expectError(
      'Parameter `apiKey` is required when calling `addApiKey`.',
      () async {
        try {
          final res = await client.addApiKey(
            apiKey: empty(),
          );
        } on InterceptionException catch (_) {
          // Ignore InterceptionException
        }
      },
    );
  });

  test('`addOrUpdateObject` throws with invalid parameters', () async {
    final requester = RequestInterceptor();
    final client = SearchClient(
      appId: 'appId',
      apiKey: 'apiKey',
      options: ClientOptions(requester: requester),
    );
    expectError(
      'Parameter `indexName` is required when calling `addOrUpdateObject`.',
      () async {
        try {
          final res = await client.addOrUpdateObject(
            indexName: empty(),
            objectID: "my-object-id",
            body: {},
          );
        } on InterceptionException catch (_) {
          // Ignore InterceptionException
        }
      },
    );
    expectError(
      'Parameter `objectID` is required when calling `addOrUpdateObject`.',
      () async {
        try {
          final res = await client.addOrUpdateObject(
            indexName: "my-index-name",
            objectID: empty(),
            body: {},
          );
        } on InterceptionException catch (_) {
          // Ignore InterceptionException
        }
      },
    );
    expectError(
      'Parameter `body` is required when calling `addOrUpdateObject`.',
      () async {
        try {
          final res = await client.addOrUpdateObject(
            indexName: "my-index-name",
            objectID: "my-object-id",
            body: empty(),
          );
        } on InterceptionException catch (_) {
          // Ignore InterceptionException
        }
      },
    );
  });
}
