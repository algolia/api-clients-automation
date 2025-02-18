import 'package:algolia_client_search/algolia_client_search.dart';

List<Map<String, String>> getAllAppIDConfigurations() {
  return [/* A list of your MCM AppID/ApiKey pairs */];
}

List<Map> playlists = [/* Your records */];

void saveObjectsMCM() async {
  final configurations = getAllAppIDConfigurations();

  for (var configuration in configurations) {
    final appId = configuration['appID'] ?? "";
    final apiKey = configuration['apiKey'] ?? "";
    final client = SearchClient(appId: appId, apiKey: apiKey);

    try {
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
      );
    } catch (e) {
      throw Exception('Error for appID $appId: $e');
    }
  }
}
