import 'dart:convert';
import 'dart:io';

import 'package:algolia_client_search/algolia_client_search.dart';

void saveObjectsChunks() async {
  final path = '/tmp/records.json';
  final json = File(path).readAsStringSync();
  List<Map<String, dynamic>> records;
  try {
    records = List<Map<String, dynamic>>.from(jsonDecode(json));
  } catch (e) {
    throw Exception('Failed to read file at $path: $e');
  }

  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  final chunkSize = 10000;

  for (var i = 0; i < records.length; i += chunkSize) {
    final chunk = records.sublist(
        i, (i + chunkSize > records.length) ? records.length : i + chunkSize);
    final batchParams = BatchWriteParams(
        requests: chunk
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
