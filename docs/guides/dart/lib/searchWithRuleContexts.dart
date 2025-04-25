import 'package:algolia_client_search/algolia_client_search.dart';

String getPlatformTag() {
  return ""; // Implement your logic here
}

void searchWithRuleContexts() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  final platformTag = getPlatformTag();
  final searchParams = SearchParamsObject(
      query: "<YOUR_SEARCH_QUERY>", ruleContexts: [platformTag]);

  await client.searchSingleIndex(
    indexName: "<YOUR_INDEX_NAME>",
    searchParams: searchParams,
  );
}
