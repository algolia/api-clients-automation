/// Whether the platform mints the Request-ID as the `x-algolia-request-id`
/// query parameter instead of the header. Browsers must: the header is not
/// covered by the API's CORS allow-list. Also the fallback for unknown
/// platforms (wasm web included), where only the query parameter is safe.
const bool platformRequestIdAsQueryParameter = true;
