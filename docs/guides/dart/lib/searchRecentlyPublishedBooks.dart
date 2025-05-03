import 'package:algolia_client_search/algolia_client_search.dart';

void searchRecentlyPublishedBooks() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  final dateTimestamp =
      DateTime.now().subtract(Duration(days: 365)).millisecondsSinceEpoch;
  final searchParams = SearchParamsObject(
      query: "<YOUR_SEARCH_QUERY>", filters: "date_timestamp > $dateTimestamp");

  await client.searchSingleIndex(
    indexName: "<YOUR_INDEX_NAME>",
    searchParams: searchParams,
  );
}
