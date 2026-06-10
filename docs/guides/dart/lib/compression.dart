import 'package:algolia_client_search/algolia_client_search.dart';

void compression() async {
  // Initialize the client with gzip compression enabled
  // Compression reduces the size of request bodies sent to Algolia
  final client = SearchClient(
    appId: 'ALGOLIA_APPLICATION_ID',
    apiKey: 'ALGOLIA_API_KEY',
    options: ClientOptions(compression: 'gzip'),
  );

  try {
    // Search with compressed request body
    final result = await client.searchSingleIndex(
      indexName: "<YOUR_INDEX_NAME>",
      searchParams: SearchParamsObject(
        query: "comedy",
      ),
    );
    print(result);
  } catch (e) {
    print("Error: ${e.toString()}");
  }
}
