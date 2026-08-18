import 'package:algolia_client_core/algolia_client_core.dart';
import 'package:algolia_client_search/src/api/search_client.dart';

/// Shared by the wait* and transformation helper extensions; not exported.
extension SharedRequestIdOptions on SearchClient {
  /// Request options carrying the Request-ID shared by one helper invocation;
  /// untouched when minting is disabled or the caller supplied an ID, which
  /// also makes nested helpers reuse their caller's ID.
  RequestOptions? withSharedRequestId(RequestOptions? requestOptions) {
    // requestIdEnabled suffices: these extensions exist solely on
    // SearchClient, whose generated requestIdSupport flag is always true.
    // The default-headers check is gated on the default requester, the only
    // one that receives ClientOptions.headers.
    if (options.requestIdEnabled == false ||
        hasRequestIdHeader(requestOptions?.headers) ||
        hasRequestIdQueryParameter(requestOptions?.urlParameters) ||
        (options.requester == null && hasRequestIdHeader(options.headers))) {
      return requestOptions;
    }

    return mintedRequestIdOptions() + requestOptions;
  }
}

/// Shared by the transformation helper's rescue path; not exported.
extension CleanupRequestOptions on RequestOptions {
  /// A copy for rescue cleanups: headers and query parameters survive, the
  /// caller's timeouts and body do not. Keep in sync with [RequestOptions].
  RequestOptions withoutTimeoutsAndBody() =>
      RequestOptions(headers: headers, urlParameters: urlParameters);
}
