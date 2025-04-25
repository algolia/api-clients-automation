import 'package:algolia_client_search/algolia_client_search.dart';

String getGoogleAnalyticsUserIdFromBrowserCookie(String cookieName) {
  // This function is a placeholder for a real implementation
  return "";
}

void searchWithGAToken() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  final userToken = getGoogleAnalyticsUserIdFromBrowserCookie("_ga");
  var searchParams =
      SearchParamsObject(query: "<YOUR_SEARCH_QUERY>", userToken: userToken);

  await client.searchSingleIndex(
    indexName: "<YOUR_INDEX_NAME>",
    searchParams: searchParams,
  );

  String? loggedInUser;
  searchParams = SearchParamsObject(
      query: "<YOUR_SEARCH_QUERY>", userToken: loggedInUser ?? userToken);

  await client.searchSingleIndex(
    indexName: "<YOUR_INDEX_NAME>",
    searchParams: searchParams,
  );
}
