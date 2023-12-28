import 'package:algolia_client_insights/algolia_client_insights.dart';
import 'package:algolia_test/algolia_test.dart';
import 'package:test/test.dart';
import 'package:test_api/hooks.dart';

void main() {
  test('calls api with correct user agent', () {
    final client = InsightsClient(
      appId: 'appId',
      apiKey: 'apiKey',
      region: 'us',
    );
    runTest(
      builder: (requester) => InsightsClient(
        appId: client.appId,
        apiKey: client.apiKey,
        region: client.region,
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test",
      ),
      intercept: (request) {
        TestHandle.current.markSkipped('User agent added using an interceptor');
      },
    );
  });
  test('calls api with default read timeouts', () {
    final client = InsightsClient(
      appId: 'appId',
      apiKey: 'apiKey',
      region: 'us',
    );
    runTest(
      builder: (requester) => InsightsClient(
        appId: client.appId,
        apiKey: client.apiKey,
        region: client.region,
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customGet(
        path: "/test",
      ),
      intercept: (request) {
        expect(5000, request.timeout.inMilliseconds);
      },
    );
  });
  test('calls api with default write timeouts', () {
    final client = InsightsClient(
      appId: 'appId',
      apiKey: 'apiKey',
      region: 'us',
    );
    runTest(
      builder: (requester) => InsightsClient(
        appId: client.appId,
        apiKey: client.apiKey,
        region: client.region,
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customPost(
        path: "/test",
      ),
      intercept: (request) {
        expect(30000, request.timeout.inMilliseconds);
      },
    );
  });

  test('fallbacks to the alias when region is not given', () {
    final client = InsightsClient(
      appId: "my-app-id",
      apiKey: "my-api-key",
    );
    runTest(
      builder: (requester) => InsightsClient(
        appId: client.appId,
        apiKey: client.apiKey,
        region: client.region,
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.pushEvents(
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
      ),
      intercept: (request) {
        expect(request.host.url, 'insights.algolia.io');
      },
    );
  });
  test('uses the correct region', () {
    final client = InsightsClient(
      appId: "my-app-id",
      apiKey: "my-api-key",
      region: 'us',
    );
    runTest(
      builder: (requester) => InsightsClient(
        appId: client.appId,
        apiKey: client.apiKey,
        region: client.region,
        options: ClientOptions(requester: requester),
      ),
      call: (client) => client.customDelete(
        path: "/test",
      ),
      intercept: (request) {
        expect(request.host.url, 'insights.us.algolia.io');
      },
    );
  });
  test('throws when incorrect region is given', () {
    expectError(
      '`region` must be one of the following: de, us',
      () {
        final client = InsightsClient(
          appId: "my-app-id",
          apiKey: "my-api-key",
          region: 'not_a_region',
        );
      },
    );
  });
}
