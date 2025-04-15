import 'package:algolia_client_search/algolia_client_search.dart';

void searchInReplicaIndex() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  // 1. Change the sort dynamically based on the UI events
  final sortByPrice = false;

  // 2. Get the index name based on sortByPrice
  // ignore: dead_code
  final indexName = sortByPrice ? "products_price_desc" : "products";

  // 3. Search on dynamic index name (primary or replica)
  await client.searchSingleIndex(
    indexName: indexName,
    searchParams: SearchParamsObject(
      query: "query",
    ),
  );
}
