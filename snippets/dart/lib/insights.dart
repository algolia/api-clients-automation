import 'package:algolia_client_insights/algolia_client_insights.dart';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
void snippetForcustomDelete() async {
  // >SEPARATOR customDelete
  // Initialize the client
  final client = InsightsClient(
      appId: 'YOUR_APP_ID',
      apiKey: 'YOUR_API_KEY',
      region: 'YOUR_APP_ID_REGION');

  // Call the API
  final response = await client.customDelete(
    path: "/test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
void snippetForcustomGet() async {
  // >SEPARATOR customGet
  // Initialize the client
  final client = InsightsClient(
      appId: 'YOUR_APP_ID',
      apiKey: 'YOUR_API_KEY',
      region: 'YOUR_APP_ID_REGION');

  // Call the API
  final response = await client.customGet(
    path: "/test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
void snippetForcustomPost() async {
  // >SEPARATOR customPost
  // Initialize the client
  final client = InsightsClient(
      appId: 'YOUR_APP_ID',
      apiKey: 'YOUR_API_KEY',
      region: 'YOUR_APP_ID_REGION');

  // Call the API
  final response = await client.customPost(
    path: "/test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
void snippetForcustomPut() async {
  // >SEPARATOR customPut
  // Initialize the client
  final client = InsightsClient(
      appId: 'YOUR_APP_ID',
      apiKey: 'YOUR_API_KEY',
      region: 'YOUR_APP_ID_REGION');

  // Call the API
  final response = await client.customPut(
    path: "/test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the deleteUserToken method.
//
// deleteUserToken0
void snippetFordeleteUserToken() async {
  // >SEPARATOR deleteUserToken
  // Initialize the client
  final client = InsightsClient(
      appId: 'YOUR_APP_ID',
      apiKey: 'YOUR_API_KEY',
      region: 'YOUR_APP_ID_REGION');

  // Call the API
  final response = await client.deleteUserToken(
    userToken: "test-user-1",
  );
  // SEPARATOR<
}

// Snippet for the pushEvents method.
//
// pushEvents0
void snippetForpushEvents() async {
  // >SEPARATOR pushEvents
  // Initialize the client
  final client = InsightsClient(
      appId: 'YOUR_APP_ID',
      apiKey: 'YOUR_API_KEY',
      region: 'YOUR_APP_ID_REGION');

  // Call the API
  final response = await client.pushEvents(
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
  // SEPARATOR<
}
