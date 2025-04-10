import 'dart:convert';
import 'dart:io';

import 'package:algolia_client_search/algolia_client_search.dart';

void saveObjectsModified() async {
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  final path = '/tmp/records.json';
  final json = File(path).readAsStringSync();
  List<Map<String, dynamic>> products;
  try {
    products = List<Map<String, dynamic>>.from(jsonDecode(json));
  } catch (e) {
    throw Exception('Failed to read file at $path: $e');
  }

  final records = products.map((product) {
    final reference = product['product_reference'].toString();
    final suffixes = [
      for (int i = 1; i <= reference.length; i++)
        reference.substring(i - 1, reference.length)
    ];
    final updatedProduct = {
      ...product,
      'product_reference_suffixes': suffixes,
    };
    return updatedProduct;
  }).toList();

  final batchParams = BatchWriteParams(
      requests: records
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
