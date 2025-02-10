import 'package:algolia_client_search/algolia_client_search.dart';

void savePopularRecords() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  final List<Map<String, dynamic>> records = [];

  BrowseResponse? browseResponse;
  do {
    final browseParams =
        BrowseParamsObject(hitsPerPage: 1000, cursor: browseResponse?.cursor);
    browseResponse =
        await client.browse(indexName: "indexName", browseParams: browseParams);
    for (final hit in browseResponse.hits) {
      final isPopular = hit['nbFollowers'] > 1000;
      final updatedProduct = {
        ...hit,
        'isPopular': isPopular,
      };
      records.add(updatedProduct);
    }
  } while (browseResponse.cursor != null);

  final batchParams = BatchWriteParams(
      requests: records
          .map((record) => BatchRequest(
                action: Action.addObject,
                body: record,
              ))
          .toList());
  await client.batch(
    indexName: "<YOUR_INDEX_NAME>",
    batchWriteParams: batchParams,
  );
}
