/// Whether the platform mints the Request-ID as the `x-algolia-request-id`
/// query parameter instead of the `Request-ID` header. Browsers must use the
/// query parameter: the header is not covered by the API's CORS
/// `Access-Control-Allow-Headers`, so sending it would fail the preflight and
/// block the request outright. The engine consults the query parameter
/// whenever the header is absent. This mirrors the JS `requestIdChannel` and
/// the [Platform] seam that moves the Algolia agent off the `User-Agent`
/// header on web. This file is also the fallback for unknown platforms
/// (including wasm web builds, where `dart.library.html` is false): the query
/// parameter degrades safely everywhere, the header does not.
const bool platformRequestIdAsQueryParameter = true;
