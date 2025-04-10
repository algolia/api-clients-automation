import 'package:algolia_client_search/algolia_client_search.dart';

final playlists = []; // Your records

String getAppIDFor(String _) {
  return ""; // Implement your own logic here
}

String getIndexingApiKeyFor(String _) {
  return ""; // Implement your own logic here
}

void setSettingsThenSaveObjects() async {
  for (final playlist in playlists) {
    // Fetch from your own data storage and with your own code
    // the associated application ID and API key for this user
    final appId = getAppIDFor(playlist["user"]);
    final apiKey = getIndexingApiKeyFor(playlist["user"]);

    final client = SearchClient(appId: appId, apiKey: apiKey);
    final settings = IndexSettings(
      attributesForFaceting: ['filterOnly(userID)'],
    );

    await client.setSettings(
      indexName: "<YOUR_INDEX_NAME>",
      indexSettings: settings,
    );

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
  }
}
