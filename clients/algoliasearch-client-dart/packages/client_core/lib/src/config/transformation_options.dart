import 'package:algolia_client_core/src/config/client_options.dart';

final class TransformationOptions {
  final String region;
  final ClientOptions? ingestionClientOptions;

  TransformationOptions({
    required this.region,
    this.ingestionClientOptions,
  }) {
    if (region.isEmpty) {
      throw ArgumentError(
        'region is required in transformationOptions.'
        ' See https://www.algolia.com/doc/libraries/sdk/methods/ingestion',
      );
    }
  }
}
