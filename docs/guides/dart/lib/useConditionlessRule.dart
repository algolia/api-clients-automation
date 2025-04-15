import 'package:algolia_client_search/algolia_client_search.dart';

void useConditionlessRule() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  final objectID = "a-rule-id";

  final rule = Rule(
      objectID: objectID,
      consequence: Consequence(
          // Set relevant consequence
          ),
      // Set validity (optional)
      validity: [TimeRange(from: 1688774400, until: 1738972800)]);

  await client.saveRule(
    indexName: "<YOUR_INDEX_NAME>",
    objectID: objectID,
    rule: rule,
  );
}
