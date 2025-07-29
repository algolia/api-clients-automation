import 'package:algolia_client_abtesting_v3/algolia_client_abtesting_v3.dart';

void main() async {
  // Creating an instance of the Abtesting V3 client with the provided App ID and API key.
  final abtesting = AbtestingV3Client(
    appId: 'latency',
    apiKey: '6be0576ff61c053d5f9a3225e2a90f76',
    region: 'us',
  );

  await abtesting.getABTest(
    id: 123,
  );

  // Close the client and dispose of all underlying resources.
  abtesting.dispose();
}
