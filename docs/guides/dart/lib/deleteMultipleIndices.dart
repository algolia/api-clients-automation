import 'package:algolia_client_search/algolia_client_search.dart';

void deleteMultipleIndices() async {
  // You need an API key with `deleteIndex`
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  // List all indices
  final indices = await client.listIndices();

  // Primary indices don't have a `primary` key
  final primaryIndices =
      indices.items.where((element) => element.primary == null).toList();
  final replicaIndices =
      indices.items.where((element) => element.primary != null).toList();

  // Delete primary indices first
  if (primaryIndices.isNotEmpty) {
    final List<MultipleBatchRequest> requests = primaryIndices
        .map((element) => MultipleBatchRequest(
            action: Action.delete, indexName: element.name))
        .toList();
    await client.multipleBatch(
      batchParams: BatchParams(
        requests: requests,
      ),
    );
    print("Deleted primary indices.");
  }

  // Now, delete replica indices
  if (replicaIndices.isNotEmpty) {
    final List<MultipleBatchRequest> requests = replicaIndices
        .map((element) => MultipleBatchRequest(
            action: Action.delete, indexName: element.name))
        .toList();
    await client.multipleBatch(
      batchParams: BatchParams(
        requests: requests,
      ),
    );
    print("Deleted replica indices.");
  }
}
