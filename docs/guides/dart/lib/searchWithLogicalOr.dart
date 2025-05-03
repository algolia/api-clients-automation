import 'package:algolia_client_search/algolia_client_search.dart';

void searchWithLogicalOr() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');
  final query = "the query";
  final optionalWords = ["the", "query"];
  final searchParams = SearchParamsObject(
    query: query,
    optionalWords: optionalWords,
  );
  await client.searchSingleIndex(
    indexName: "<YOUR_INDEX_NAME>",
    searchParams: searchParams,
  );
}
