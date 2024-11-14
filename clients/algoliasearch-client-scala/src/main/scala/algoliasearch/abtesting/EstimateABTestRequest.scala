/** A/B Testing API The Algolia A/B Testing API lets you manage your Algolia A/B tests to optimize your search
  * experience. ## Base URLs The base URLs for requests to the A/B testing API are: - `https://analytics.us.algolia.com`
  * \- `https://analytics.de.algolia.com` - `https://analytics.algolia.com` (routes requests to the closest of the above
  * servers, based on your geographical location) Use the URL that matches your [analytics
  * region](https://dashboard.algolia.com/account/infrastructure/analytics). **All requests must use HTTPS.** ##
  * Availability and authentication Access to the A/B testing API is available as part of the [Premium or Elevate
  * plans](https://www.algolia.com/pricing). To authenticate your API requests, add these headers: -
  * `x-algolia-application-id`. Your Algolia application ID. - `x-algolia-api-key`. An API key with the necessary
  * permissions to make the request. The required access control list (ACL) to make a request is listed in each
  * endpoint's reference. You can find your application ID and API key in the [Algolia
  * dashboard](https://dashboard.algolia.com/account). ## Rate limits You can make up to **100 requests per minute per
  * app** to the A/B testing API. The response includes headers with information about the limits. ## Parameters Query
  * parameters must be [URL-encoded](https://developer.mozilla.org/en-US/docs/Glossary/Percent-encoding). Non-ASCII
  * characters must be UTF-8 encoded. Plus characters (`+`) are interpreted as spaces. ## Response status and errors The
  * A/B testing API returns JSON responses. Since JSON doesn't guarantee any specific ordering, don't rely on the order
  * of attributes in the API response. Successful responses return a `2xx` status. Client errors return a `4xx` status.
  * Server errors are indicated by a `5xx` status. Error responses have a `message` property with more information. ##
  * Version The current version of the A/B Testing API is version 2, as indicated by the `/2/` in each endpoint's URL.
  *
  * The version of the OpenAPI document: 2.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.abtesting

/** EstimateABTestRequest
  *
  * @param variants
  *   A/B test variants.
  */
case class EstimateABTestRequest(
    configuration: EstimateConfiguration,
    variants: Seq[AddABTestsVariant]
)
