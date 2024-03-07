import 'package:algolia_client_recommend/algolia_client_recommend.dart';

// Snippet for the customDelete method.
//
// allow del method for a custom path with minimal parameters
void snippetForcustomDelete() async {
  // >SEPARATOR customDelete
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

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
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

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
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

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
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customPut(
    path: "/test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the deleteRecommendRule method.
//
// deleteRecommendRule0
void snippetFordeleteRecommendRule() async {
  // >SEPARATOR deleteRecommendRule
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.deleteRecommendRule(
    indexName: "indexName",
    model: RecommendModels.fromJson("related-products"),
    objectID: "objectID",
  );
  // SEPARATOR<
}

// Snippet for the getRecommendRule method.
//
// getRecommendRule0
void snippetForgetRecommendRule() async {
  // >SEPARATOR getRecommendRule
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getRecommendRule(
    indexName: "indexName",
    model: RecommendModels.fromJson("related-products"),
    objectID: "objectID",
  );
  // SEPARATOR<
}

// Snippet for the getRecommendStatus method.
//
// getRecommendStatus0
void snippetForgetRecommendStatus() async {
  // >SEPARATOR getRecommendStatus
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.getRecommendStatus(
    indexName: "indexName",
    model: RecommendModels.fromJson("related-products"),
    taskID: 12345,
  );
  // SEPARATOR<
}

// Snippet for the getRecommendations method.
//
// get recommendations for recommend model with minimal parameters
void snippetForgetRecommendations() async {
  // >SEPARATOR getRecommendations
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
  // SEPARATOR<
}

// Snippet for the searchRecommendRules method.
//
// searchRecommendRules0
void snippetForsearchRecommendRules() async {
  // >SEPARATOR searchRecommendRules
  // Initialize the client
  final client = RecommendClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.searchRecommendRules(
    indexName: "indexName",
    model: RecommendModels.fromJson("related-products"),
  );
  // SEPARATOR<
}
