<!-- centered logo -->
<p align="center">
  <a href="https://www.algolia.com">
    <img alt="Algolia for Dart" src="https://raw.githubusercontent.com/algolia/algoliasearch-client-common/master/banners/dart.png" >
  </a>
</p>

<!-- centered badges -->
<p align="center">
  <a href="https://pub.dartlang.org/packages/algolia_chopper_client"><img src="https://img.shields.io/pub/v/algolia_chopper_client.svg" alt="Latest version"></a>
  <a href="https://pub.dev/packages/algolia_chopper_client/publisher"><img src="https://img.shields.io/pub/publisher/algolia_chopper_client.svg" alt="Publisher"></a>
</p>

<h3 align="center">
  <strong>Algolia API Chopper Requester</strong>
</h3>

<p align="center">
  Use the Chopper Requester to send requests to the Algolia API with the Algolia Search Client for Dart. This package provides a custom Requester for the Algolia Search Client, allowing users to send requests to the Algolia API using the Chopper HTTP client.
</p>

## 💡 Installation

Add Chopper Requester as a dependency in your project directly from pub.dev:

#### For Dart projects:

```shell
dart pub add algolia_chopper_requester
```

#### For Flutter projects:

```shell
flutter pub add algolia_chopper_requester
```

### Basic Usage

```dart
final String appId = 'latency';
final String apiKey = '6be0576ff61c053d5f9a3225e2a90f76';

final SearchClient _client = SearchClient(
  appId: appId,
  apiKey: apiKey,
  options: ClientOptions(
    requester: ChopperRequester(
      appId: appId,
      apiKey: apiKey,
    )
  ),
);

Future<SearchResponse> search(String query) => _client.searchIndex(
      request: SearchForHits(
        indexName: 'flutter',
        query: query,
        hitsPerPage: 5,
      ),
    );
```

You can configure the `ChopperRequester` with the following parameters:

### Configuration

```dart
final requester = ChopperRequester({
  /// Your Algolia Application ID
  required String appId,
  /// Your Algolia Search-Only API Key
  required String apiKey,
  /// Additional headers to send with the request
  Map<String, dynamic>? headers,
  /// The segments to include in the `User-Agent` header
  Iterable<AgentSegment>? clientSegments,
  /// The logger to use for debugging
  Logger? logger,
  /// The Chopper Interceptors to use for modifying the request
  Iterable<Interceptor>? interceptors,
  /// The HTTP client to use for sending requests
  Client? client,
  /// A custom JSON converter to use for serializing and deserializing JSON
  JsonConverter? converter,
});
```

### Advanced Usage

To set the connect timeout one has to do that directly on the `Client`, i.e.

```dart
final requester = ChopperRequester(
  appId: appId,
  apiKey: apiKey,
  client: http.IOClient(
    HttpClient()..connectionTimeout = const Duration(seconds: 60),
  ),
);
```

#### Custom Interceptors

For interceptors please see the [Chopper documentation](https://hadrien-lejard.gitbook.io/chopper/interceptors).

#### Custom Clients

Via the `client` option users can use platform specific HTTP clients such:
- [cronet_http](https://pub.dev/packages/cronet_http) on Android
  ```dart
  final requester = ChopperRequester(
    appId: appId,
    apiKey: apiKey,
    client: CronetClient.fromCronetEngine(
      CronetEngine.build(
        cacheMode: CacheMode.memory,
        cacheMaxSize: 50 * 1024 * 1024,
      ),
      closeEngine: true,
    ),
  );
  ```
- [cupertino_http](https://pub.dev/packages/cupertino_http) on iOS/macOS
  ```dart
  final requester = ChopperRequester(
    appId: appId,
    apiKey: apiKey,
    client: CupertinoClient.fromSessionConfiguration(
      (URLSessionConfiguration.defaultSessionConfiguration()
          ..timeoutIntervalForRequest = const Duration(seconds: 30)),
    ),
  );
  ```
  
#### Parsing JSON in the background using Isolates

Parsing JSON in the background is a good idea if you don't want to block the main thread.
Please see the [Chopper documentation](https://hadrien-lejard.gitbook.io/chopper/faq#decoding-json-using-isolates) on Decoding JSON using Isolate worker pools.

## License

Chopper Requester for Algolia Search Client is an open-sourced software licensed under the [MIT license](LICENSE).
