import 'package:algoliasearch/algoliasearch.dart';

/// Function [runTest] tests API client functionality with provided parameters.
///
/// Takes [builder] to construct a client, [call] to test the client
/// and [intercept] to check the HTTP requests.
Future<void> runTest<T extends ApiClient>({
  required T Function(RequestInterceptor) builder,
  required Future Function(T) call,
  required Function(HttpRequest) intercept,
}) async {
  final interceptor = RequestInterceptor(onRequest: intercept);
  final client = builder(interceptor);
  try {
    await call(client);
  } on InterceptionException catch (_) {
    // Ignore InterceptionException
  } on AlgoliaException catch (_) {
    // Ignore AlgoliaException
  }
}

/// [RequestInterceptor] implements [Requester].
///
/// Uses provided function to intercept HTTP requests.
class RequestInterceptor extends Requester {
  String apiKey = "fake";
  Duration connectTimeout = Duration(seconds: 30);

  Function(HttpRequest) onRequest = (_) {};

  RequestInterceptor({Function(HttpRequest)? onRequest}) {
    this.onRequest = onRequest ?? (_) {};
  }

  void setOnRequest(Function(HttpRequest) onRequest) {
    this.onRequest = onRequest;
  }

  @override
  Future<HttpResponse> perform(HttpRequest request) {
    onRequest(request);
    return Future.error(InterceptionException());
  }

  @override
  void setClientApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  @override
  void setConnectTimeout(Duration connectTimeout) {
    this.connectTimeout = connectTimeout;
  }
}

/// [InterceptionException] implements [Exception].
///
/// Used to indicate interception errors in request handling.
class InterceptionException implements Exception {}

/// [SkipException] implements [Exception].
///
/// Used to indicate to skip the ongoing test.
class SkipException implements Exception {}
