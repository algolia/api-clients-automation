import 'package:algolia_client_search/algolia_client_search.dart';

void main() async {
  // Set transformationOptions with your transformation region to use the `WithTransformation` helper methods.
  // Replace 'us' with 'eu' if your Algolia application uses the Europe analytics region.
  final client = SearchClient(
    appId: 'ALGOLIA_APPLICATION_ID',
    apiKey: 'ALGOLIA_API_KEY',
    transformationOptions: TransformationOptions(region: 'us'),
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
