import 'package:algolia_client_recommend/algolia_client_recommend.dart';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
void snippetForcustomDelete() async {
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customDelete(
    path: "/test/minimal",
  );
}

// Snippet for the customGet method.
//
// allow get method for a custom path with minimal parameters
void snippetForcustomGet() async {
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customGet(
    path: "/test/minimal",
  );
}

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
void snippetForcustomPost() async {
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customPost(
    path: "/test/minimal",
  );
}

// Snippet for the customPut method.
//
// allow put method for a custom path with minimal parameters
void snippetForcustomPut() async {
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customPut(
    path: "/test/minimal",
  );
}

// Snippet for the deleteRecommendRule method.
//
// deleteRecommendRule0
void snippetFordeleteRecommendRule() async {
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteRecommendRule(
    indexName: "indexName",
    model: RecommendModels.fromJson("related-products"),
    objectID: "objectID",
  );
}

// Snippet for the getRecommendRule method.
//
// getRecommendRule0
void snippetForgetRecommendRule() async {
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getRecommendRule(
    indexName: "indexName",
    model: RecommendModels.fromJson("related-products"),
    objectID: "objectID",
  );
}

// Snippet for the getRecommendStatus method.
//
// getRecommendStatus0
void snippetForgetRecommendStatus() async {
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getRecommendStatus(
    indexName: "indexName",
    model: RecommendModels.fromJson("related-products"),
    taskID: 12345,
  );
}

// Snippet for the getRecommendations method.
//
// get recommendations for recommend model with minimal parameters
void snippetForgetRecommendations() async {
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getRecommendations(
    getRecommendationsParams: GetRecommendationsParams(
      requests: [
        RecommendationsQuery(
          indexName: "indexName",
          objectID: "objectID",
          model: RecommendationModels.fromJson("related-products"),
          threshold: 42,
        ),
      ],
    ),
  );
}

// Snippet for the searchRecommendRules method.
//
// searchRecommendRules0
void snippetForsearchRecommendRules() async {
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchRecommendRules(
    indexName: "indexName",
    model: RecommendModels.fromJson("related-products"),
  );
}
