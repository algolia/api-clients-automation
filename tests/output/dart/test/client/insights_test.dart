import 'package:algolia_client_insights/algolia_client_insights.dart';
import 'package:algolia_test/algolia_test.dart';
import 'package:test/test.dart';
import 'package:test_api/hooks.dart';

void main() {
  test('calls api with correct user agent', () async {
    final requester = RequestInterceptor();
    final client = InsightsClient(
      appId: 'appId',
      apiKey: 'apiKey',
      region: 'us',
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
    final client = InsightsClient(
      appId: 'appId',
      apiKey: 'apiKey',
      region: 'us',
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
    final client = InsightsClient(
      appId: 'appId',
      apiKey: 'apiKey',
      region: 'us',
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

  test('fallbacks to the alias when region is not given', () async {
    final requester = RequestInterceptor();
    final client = InsightsClient(
        appId: "my-app-id",
        apiKey: "my-api-key",
        options: ClientOptions(requester: requester));
    requester.setOnRequest((request) {
      expect(request.host.url, 'insights.algolia.io');
    });
    try {
      final res = await client.pushEvents(
        insightsEvents: InsightsEvents(
          events: [
            ClickedObjectIDsAfterSearch(
              eventType: ClickEvent.fromJson("click"),
              eventName: "Product Clicked",
              index: "products",
              userToken: "user-123456",
              authenticatedUserToken: "user-123456",
              timestamp: 1641290601962,
              objectIDs: [
                "9780545139700",
                "9780439784542",
              ],
              queryID: "43b15df305339e827f0ac0bdc5ebcaa7",
              positions: [
                7,
                6,
              ],
            ),
          ],
        ),
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('uses the correct region', () async {
    final requester = RequestInterceptor();
    final client = InsightsClient(
        appId: "my-app-id",
        apiKey: "my-api-key",
        region: 'us',
        options: ClientOptions(requester: requester));
    requester.setOnRequest((request) {
      expect(request.host.url, 'insights.us.algolia.io');
    });
    try {
      final res = await client.customDelete(
        path: "test",
      );
    } on InterceptionException catch (_) {
      // Ignore InterceptionException
    }
  });

  test('throws when incorrect region is given', () async {
    final requester = RequestInterceptor();
    expectError(
      '`region` must be one of the following: de, us',
      () async {
        final client = InsightsClient(
            appId: "my-app-id",
            apiKey: "my-api-key",
            region: 'not_a_region',
            options: ClientOptions(requester: requester));
      },
    );
  });
}
