import 'package:algolia_client_search/algolia_client_search.dart';

void main() async {
  // Override the Ingestion API defaults. Any option you don't set keeps its default.
  // Replace 'us' with 'eu' if your Algolia application uses the Europe analytics region.
  final client = SearchClient(
    appId: 'ALGOLIA_APPLICATION_ID',
    apiKey: 'ALGOLIA_API_KEY',
    transformationOptions: TransformationOptions(
      region: 'us',
      ingestionClientOptions: ClientOptions(
        connectTimeout: Duration(seconds: 5),
        readTimeout: Duration(seconds: 30),
      ),
    ),
  );

  try {
    // Save records, transforming them through the Push connector
    await client.saveObjectsWithTransformation(
      indexName: "<YOUR_INDEX_NAME>",
      objects: [
        {
          'objectID': "1",
          'name': "Adam",
        },
        {
          'objectID': "2",
          'name': "Benoit",
        },
      ],
      waitForTasks: true,
    );
    print('Done!');
  } catch (e) {
    print('Error: ${e.toString()}');
  }
}
