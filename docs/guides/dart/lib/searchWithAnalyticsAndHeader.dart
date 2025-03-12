import 'package:algolia_client_search/algolia_client_search.dart';

void searchWithAnalyticsAndHeader() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  /*
  '94.228.178.246' should be replaced with your user's IP address.
  Depending on your stack there are multiple ways to get this information.
  */
  final ip = "94.228.178.246";
  final query = "query";

  final searchParams = SearchParamsObject(query: query, analytics: true);

  await client.searchSingleIndex(
      indexName: "<YOUR_INDEX_NAME>",
      searchParams: searchParams,
      requestOptions: RequestOptions(
        headers: {
          'X-Forwarded-For': ip,
        },
      ));
}
