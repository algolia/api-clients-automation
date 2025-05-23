import 'package:algolia_client_search/algolia_client_search.dart';

final List<String> labels = []; // A list of labels

List<String> reduceLabelsToFilters(List<String> labels) {
  return []; // Implement your logic here
}

void searchWithOptionalFilters() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  final optionalFilters = reduceLabelsToFilters(labels);
  final searchParams = SearchParamsObject(
      query: "<YOUR_SEARCH_QUERY>", optionalFilters: optionalFilters);

  await client.searchSingleIndex(
    indexName: "<YOUR_INDEX_NAME>",
    searchParams: searchParams,
  );
}
