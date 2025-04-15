import 'package:algolia_client_search/algolia_client_search.dart';

final class Image {
  final String imageUrl;
  final String objectID;
  List<Map<String, dynamic>> objects;

  Image(String imageUrl, String objectID, List<Map<String, dynamic>> objects)
      : imageUrl = imageUrl,
        objectID = objectID,
        objects = objects;
}

Future<Map<String, dynamic>> getImageLabels(
    String imageURL, String objectID, double scoreLimit) async {
  // Implement your image classification logic here
  return {};
}

void saveImageClassifications() async {
  // API key ACL should include editSettings / addObject
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  final List<Map<String, dynamic>> records = [];

  BrowseResponse? browseResponse;
  do {
    final browseParams =
        BrowseParamsObject(hitsPerPage: 1000, cursor: browseResponse?.cursor);
    browseResponse = await client.browse(
        indexName: "<YOUR_INDEX_NAME>", browseParams: browseParams);
    for (final hit in browseResponse.hits) {
      final props = hit.toJson();
      final imageWithLabels =
          await getImageLabels(props["imageUrl"], hit.objectID, 0.5);
      records.add(imageWithLabels);
    }
  } while (browseResponse.cursor != null);

  final batchParams = BatchWriteParams(
      requests: records
          .map((record) => BatchRequest(
                action: Action.partialUpdateObject,
                body: record,
              ))
          .toList());

  // Update records with image classifications
  await client.batch(
    indexName: "<YOUR_INDEX_NAME>",
    batchWriteParams: batchParams,
  );
}
