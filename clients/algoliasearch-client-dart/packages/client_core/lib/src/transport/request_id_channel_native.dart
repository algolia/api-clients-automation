/// Whether the platform mints the Request-ID as the `x-algolia-request-id`
/// query parameter instead of the `Request-ID` header. Native platforms use
/// the header, like every non-browser Algolia client.
const bool platformRequestIdAsQueryParameter = false;
