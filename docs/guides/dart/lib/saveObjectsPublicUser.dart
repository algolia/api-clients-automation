import 'package:algolia_client_search/algolia_client_search.dart';

final playlists = [/* Your records */];

void saveObjectsPublicUser() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  final batchParams = BatchWriteParams(
      requests: playlists
          .map((record) => BatchRequest(
                action: Action.addObject,
                body: record,
              ))
          .toList());
  await client.batch(
      indexName: "<YOUR_INDEX_NAME>",
      batchWriteParams: batchParams,
      requestOptions: RequestOptions(
        headers: {
          'X-Algolia-User-ID': "*",
        },
      ));
}
