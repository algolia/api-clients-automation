/// Whether the platform mints the Request-ID as the `x-algolia-request-id`
/// query parameter instead of the `Request-ID` header. Browsers must use the
/// query parameter: the header is not covered by the API's CORS
/// `Access-Control-Allow-Headers`, so sending it would fail the preflight and
/// block the request outright. The engine consults the query parameter
/// whenever the header is absent. This mirrors the JS `requestIdChannel` and
/// the [Platform] seam that moves the Algolia agent off the `User-Agent`
/// header on web.
const bool platformRequestIdAsQueryParameter = true;
