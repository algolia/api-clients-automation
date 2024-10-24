import 'package:algolia_client_recommend/algolia_client_recommend.dart';
import 'package:dotenv/dotenv.dart';

void main() async {
  final dotenv = DotEnv()..load(['../.env']);

  // Creating an instance of the recommend client with the provided App ID and API key.
  final client = RecommendClient(
    appId: dotenv['ALGOLIA_APPLICATION_ID']!,
    apiKey: dotenv['ALGOLIA_SEARCH_KEY']!,
  );

  // Creating recommendation requests for different products.
  var requests = [
    RelatedProducts(
      model: RelatedModel.relatedProducts,
      objectID: '6445156',
      fallbackParameters: FallbackParams(
        query: 'iphone',
      ),
    ),
    RelatedProducts(
      model: RelatedModel.relatedProducts,
      objectID: '6443034',
    )
  ];

  // Fetching recommendations from Algolia using the above requests.
  final response = await client.getRecommendations(
    getRecommendationsParams: GetRecommendationsParams(requests: requests),
  );

  // Printing the recommendations.
  printRecommendations(response);

  // Close the client and dispose of all underlying resources.
  client.dispose();
}

/// Prints the search hits.
void printRecommendations(GetRecommendationsResponse response) {
  final results = response.results;

  // Loop over each result and map over the search hits,
  // converting each hit to a product.
  for (final result in results) {
    final hits = result.hits.map((e) => product(e));
    for (final (name, brand) in hits) {
      print("* $name ($brand)");
    }
  }
}

/// Converts a JSON object into a product tuple of (name, brand).
/// A data class with json deserialization can also be used.
(String, String) product(Map<String, dynamic> json) =>
    (json['name'] as String, json['brand'] as String);
