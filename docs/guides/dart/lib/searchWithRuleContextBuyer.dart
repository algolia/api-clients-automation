import 'package:algolia_client_search/algolia_client_search.dart';

String getBuyerAccountId() {
  return ""; // Implement your logic here
}

void searchWithRuleContextBuyer() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  // get the buyer account information
  final buyer = getBuyerAccountId();
  final searchParams =
      SearchParamsObject(query: "<YOUR_SEARCH_QUERY>", ruleContexts: [buyer]);

  await client.searchSingleIndex(
    indexName: "<YOUR_INDEX_NAME>",
    searchParams: searchParams,
  );
}
