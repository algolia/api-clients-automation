/** Recommend API The Recommend API lets you retrieve recommendations from one of Algolia's AI recommendation models
  * that you previously trained on your data. ## Client libraries Use Algolia's API clients and libraries to reliably
  * integrate Algolia's APIs with your apps. The official API clients are covered by Algolia's [Service Level
  * Agreement](https://www.algolia.com/policies/sla/). See: [Algolia's
  * ecosystem](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) ## Base URLs
  * The base URLs for requests to the Recommend API are: - `https://{APPLICATION_ID}.algolia.net` -
  * `https://{APPLICATION_ID}-dsn.algolia.net`. If your subscription includes a [Distributed Search
  * Network](https://dashboard.algolia.com/infra), this ensures that requests are sent to servers closest to users. Both
  * URLs provide high availability by distributing requests with load balancing. **All requests must use HTTPS.** ##
  * Retry strategy To guarantee a high availability, implement a retry strategy for all API requests using the URLs of
  * your servers as fallbacks: - `https://{APPLICATION_ID}-1.algolianet.com` -
  * `https://{APPLICATION_ID}-2.algolianet.com` - `https://{APPLICATION_ID}-3.algolianet.com` These URLs use a different
  * DNS provider than the primary URLs. You should randomize this list to ensure an even load across the three servers.
  * All Algolia API clients implement this retry strategy. ## Authentication To authenticate your API requests, add
  * these headers: - `x-algolia-application-id`. Your Algolia application ID. - `x-algolia-api-key`. An API key with the
  * necessary permissions to make the request. The required access control list (ACL) to make a request is listed in
  * each endpoint's reference. You can find your application ID and API key in the [Algolia
  * dashboard](https://dashboard.algolia.com/account). ## Request format Request bodies must be JSON objects. ##
  * Response status and errors The Recommend API returns JSON responses. Since JSON doesn't guarantee any specific
  * ordering, don't rely on the order of attributes in the API response. Successful responses return a `2xx` status.
  * Client errors return a `4xx` status. Server errors are indicated by a `5xx` status. Error responses have a `message`
  * property with more information. ## Version The current version of the Recommend API is version 1, as indicated by
  * the `/1/` in each endpoint's URL.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.recommend

/** Object with detailed information about the record's ranking.
  *
  * @param filters
  *   Whether a filter matched the query.
  * @param firstMatchedWord
  *   Position of the first matched word in the best matching attribute of the record.
  * @param geoDistance
  *   Distance between the geo location in the search query and the best matching geo location in the record, divided by
  *   the geo precision (in meters).
  * @param geoPrecision
  *   Precision used when computing the geo distance, in meters.
  * @param nbExactWords
  *   Number of exactly matched words.
  * @param nbTypos
  *   Number of typos encountered when matching the record.
  * @param promoted
  *   Whether the record was promoted by a rule.
  * @param proximityDistance
  *   Number of words between multiple matches in the query plus 1. For single word queries, `proximityDistance` is 0.
  * @param userScore
  *   Overall ranking of the record, expressed as a single integer. This attribute is internal.
  * @param words
  *   Number of matched words.
  * @param promotedByReRanking
  *   Whether the record is re-ranked.
  */
case class RankingInfo(
    filters: Option[Int] = scala.None,
    firstMatchedWord: Int,
    geoDistance: Int,
    geoPrecision: Option[Int] = scala.None,
    matchedGeoLocation: Option[MatchedGeoLocation] = scala.None,
    personalization: Option[Personalization] = scala.None,
    nbExactWords: Int,
    nbTypos: Int,
    promoted: Option[Boolean] = scala.None,
    proximityDistance: Option[Int] = scala.None,
    userScore: Int,
    words: Option[Int] = scala.None,
    promotedByReRanking: Option[Boolean] = scala.None
)
