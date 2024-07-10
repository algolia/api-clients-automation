import 'dart:io' show HttpClient;

import 'package:algolia_chopper_requester/algolia_chopper_requester.dart';
import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:http/http.dart' as http show Client;
import 'package:http/io_client.dart' show IOClient;

void main() async {
  const String appId = 'latency';
  const String apiKey = '6be0576ff61c053d5f9a3225e2a90f76';

  // Create a custom http [Client] with a connection timeout of 30 seconds
  final http.Client client = IOClient(
    HttpClient()..connectionTimeout = const Duration(seconds: 30),
  );

  // Creating an instance of the RetryStrategy with necessary parameters.
  // This will retry the failed requests with a backoff strategy.
  final RetryStrategy requester = RetryStrategy.create(
    segment: AgentSegment(value: 'CustomClient'),
    appId: appId,
    apiKey: apiKey,
    defaultHosts: () => [
      Host(url: 'latency-dsn.algolia.net'),
      Host(url: 'latency-1.algolianet.com'),
    ],
    options: ClientOptions(
      requester: ChopperRequester(
        appId: appId,
        apiKey: apiKey,
        // Optionally, pass a custom http [Client] to the ChopperRequester.
        // NOTE: The [Client] must be manually disposed of after use.
        client: client,
      ),
    ),
  );

  // Executing a GET request on the '/1/indexes/instant_search' endpoint.
  final Map<String, dynamic> response = await requester.execute(
    request: ApiRequest(
      method: RequestMethod.get,
      path: '/1/indexes/instant_search',
      queryParams: {'query': 'a', 'hitsPerPage': '5'},
    ),
  );

  // Printing json response.
  print(response);

  // Dispose of the requester to clean up its resources.
  requester.dispose();

  // Disposing a custom [Client] has to be done manually.
  client.close();
}
