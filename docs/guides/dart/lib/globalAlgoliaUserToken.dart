import 'package:algolia_client_search/algolia_client_search.dart';

void globalAlgoliaUserToken() async {
  final client = SearchClient(
      appId: 'ALGOLIA_APPLICATION_ID',
      apiKey: 'ALGOLIA_API_KEY',
      options: ClientOptions(
        headers: {
          'X-Algolia-UserToken': 'test-user-123',
        },
      ));
  print(client.options.headers);
}
