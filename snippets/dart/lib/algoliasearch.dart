import 'package:algoliasearch/algoliasearch_lite.dart';

// Snippet for the customPost method.
//
// allow post method for a custom path with minimal parameters
void snippetForcustomPost() async {
  // >SEPARATOR customPost
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.customPost(
    path: "/test/minimal",
  );
  // SEPARATOR<
}

// Snippet for the search method.
//
// search for a single hits request with minimal parameters
void snippetForsearch() async {
  // >SEPARATOR search
  // Initialize the client
  final client = SearchClient(appId: 'YOUR_APP_ID', apiKey: 'YOUR_API_KEY');

  // Call the API
  final response = await client.search(
    searchMethodParams: SearchMethodParams(
      requests: [
        SearchForHits(
          indexName: "cts_e2e_search_empty_index",
        ),
      ],
    ),
  );
  // SEPARATOR<
}
