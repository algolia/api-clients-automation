import 'package:algolia_client_core/src/config/client_options.dart';

/// An abstract class representing an API client with specific properties and options.
abstract interface class ApiClient {
  /// A set of custom client options to configure the behavior of the API client.
  ClientOptions get options;

  /// Allow switching the API key used to authenticate requests.
  void setClientApiKey({required String apiKey});

  /// Dispose of underlying resources.
  void dispose();
}
