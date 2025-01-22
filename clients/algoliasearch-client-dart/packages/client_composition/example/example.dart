import 'package:algolia_client_composition/algolia_client_composition.dart';

void main() async {
  // Creating an instance of the Composition client with the provided App ID and API key.
  final composition = CompositionClient(
    appId: 'latency',
    apiKey: '6be0576ff61c053d5f9a3225e2a90f76',
  );

  await composition.search(
    compositionID: "foo",
    requestBody: RequestBody(
      params: Params(
        query: "batman",
      ),
    ),
  );

  // Close the client and dispose of all underlying resources.
  composition.dispose();
}
