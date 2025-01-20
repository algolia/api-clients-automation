import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:algolia_client_search/algolia_client_search.dart';

void main() async {
  // initiate client
  final client =
      SearchClient(appId: 'ALGOLIA_APPLICATION_ID', apiKey: 'ALGOLIA_API_KEY');

  // read json file from url
  final datasetRequest = await http.get(
      Uri.parse('https://dashboard.algolia.com/api/1/sample_datasets?type=movie'));

  if (datasetRequest.statusCode == 200) {
    final moviesData = jsonDecode(datasetRequest.body);

    final batchRequests = <BatchRequest>[];

    for (final movie in moviesData) {
      batchRequests.add(
        BatchRequest(action: Action.fromJson('addObject'), body: movie),
      );
    }

    try {
      // push data to algolia
      await client.batch(
        indexName: 'movies_index',
        batchWriteParams: BatchWriteParams(requests: batchRequests),
      );
      print("Successfully indexed records!");
    } catch (e) {
      print("Error: ${e.toString()}");
    }
  } else {
    throw Exception('Failed to load data');
  }
}
