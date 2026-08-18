import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_client_search/src/api/search_client.dart';

/// Shared by the wait* and transformation helper extensions; deliberately not
/// exported from the package.
extension SharedRequestIdOptions on SearchClient {
  /// Derives the request options carrying the Request-ID shared by every
  /// search-side request of one helper invocation. Returns the options
  /// untouched when the caller disabled minting through
  /// [ClientOptions.requestIdEnabled], or already supplied an ID through the
  /// options or the client default headers, which also makes nested helpers
  /// reuse the ID minted by their caller.
  RequestOptions? withSharedRequestId(RequestOptions? requestOptions) {
    // The default-headers check is gated on the default requester, like in
    // RetryStrategy.create: a custom requester never receives the client
    // default headers, so an ID there must not suppress minting. An ID in the
    // x-algolia-request-id query parameter suppresses minting too: the server
    // consults it only when the header is absent.
    if (options.requestIdEnabled == false ||
        hasRequestIdHeader(requestOptions?.headers) ||
        hasRequestIdQueryParameter(requestOptions?.urlParameters) ||
        (options.requester == null && hasRequestIdHeader(options.headers))) {
      return requestOptions;
    }

    return mintedRequestIdOptions() + requestOptions;
  }
}
