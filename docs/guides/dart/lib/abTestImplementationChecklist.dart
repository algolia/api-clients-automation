import 'package:algolia_client_search/algolia_client_search.dart';

String getUserToken() {
  // Implement your logic here
  return "";
}

void abTestImplementationChecklist() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  // Set the query and get the current user token
  final query = "User search query";
  final userToken = getUserToken();

  // Set the searchParams
  final SearchParamsObject searchParams;

  // Is the user token anonymous?
  if (userToken.isEmpty || userToken == "YOUR_ANONYMOUS_USER_TOKEN") {
    // Disable A/B testing for this request
    searchParams = SearchParamsObject(
      query: query,
      enableABTest: false,
    );
  } else {
    // Set the user token to the current user token
    searchParams = SearchParamsObject(
      query: query,
      userToken: userToken,
    );
  }

  try {
    // Perform the searchSingleIndex
    final result = await client.searchSingleIndex(
      indexName: "<YOUR_INDEX_NAME>",
      searchParams: searchParams,
    );
    // SearchSingleIndex results
    print(result);
  } catch (err) {
    // SearchSingleIndex errors
    print(err);
  }
}
