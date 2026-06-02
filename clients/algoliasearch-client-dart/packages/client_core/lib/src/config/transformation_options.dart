import 'package:algolia_client_core/src/config/client_options.dart';

/// Options for the ingestion transporter used by `*WithTransformation` helpers.
final class TransformationOptions {
  /// The Algolia region for the Ingestion API (e.g. `'us'` or `'eu'`). Required.
  final String region;

  /// Optional overrides for the ingestion transporter's [ClientOptions].
  /// Only the fields you set here replace the Ingestion API defaults (25 s timeouts);
  /// unset fields keep those defaults.
  final ClientOptions? ingestionClientOptions;

  /// Constructs a [TransformationOptions] instance.
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

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is TransformationOptions &&
          runtimeType == other.runtimeType &&
          region == other.region &&
          ingestionClientOptions == other.ingestionClientOptions;

  @override
  int get hashCode => region.hashCode ^ ingestionClientOptions.hashCode;

  @override
  String toString() {
    return 'TransformationOptions{region: $region, ingestionClientOptions: $ingestionClientOptions}';
  }
}
