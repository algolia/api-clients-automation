/** Composition API (beta) The Algolia Composition API lets you run composed search requests on your Compositions. The
  * Composition API is in Beta. ## Client libraries Use Algolia's API clients and libraries to reliably integrate
  * Algolia's APIs with your apps. See: [Algolia's
  * ecosystem](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) ## Base URLs
  * The base URLs for requests to the Composition API are: - `https://{APPLICATION_ID}.algolia.net` -
  * `https://{APPLICATION_ID}-dsn.algolia.net`. If your subscription includes a [Distributed Search
  * Network](https://dashboard.algolia.com/infra), this ensures that requests are sent to servers closest to users. Both
  * URLs provide high availability by distributing requests with load balancing. **All requests must use HTTPS.** ##
  * Retry strategy To guarantee high availability, implement a retry strategy for all API requests using the URLs of
  * your servers as fallbacks: - `https://{APPLICATION_ID}-1.algolianet.com` -
  * `https://{APPLICATION_ID}-2.algolianet.com` - `https://{APPLICATION_ID}-3.algolianet.com` These URLs use a different
  * DNS provider than the primary URLs. You should randomize this list to ensure an even load across the three servers.
  * All Algolia API clients implement this retry strategy. ## Authentication To authenticate your API requests, add
  * these headers: - `x-algolia-application-id`. Your Algolia application ID. - `x-algolia-api-key`. An API key with the
  * necessary permissions to make the request. The required access control list (ACL) to make a request is listed in
  * each endpoint's reference. You can find your application ID and API key in the [Algolia
  * dashboard](https://dashboard.algolia.com/account). ## Request format Depending on the endpoint, request bodies are
  * either JSON objects or arrays of JSON objects, ## Parameters Parameters are passed as query parameters for GET and
  * DELETE requests, and in the request body for POST and PUT requests. Query parameters must be
  * [URL-encoded](https://developer.mozilla.org/en-US/docs/Glossary/Percent-encoding). Non-ASCII characters must be
  * UTF-8 encoded. Plus characters (`+`) are interpreted as spaces. Arrays as query parameters must be one of: - A
  * comma-separated string: `attributesToRetrieve=title,description` - A URL-encoded JSON array:
  * `attributesToRetrieve=%5B%22title%22,%22description%22%D` ## Response status and errors The Composition API returns
  * JSON responses. Since JSON doesn't guarantee any specific ordering, don't rely on the order of attributes in the API
  * response. Successful responses return a `2xx` status. Client errors return a `4xx` status. Server errors are
  * indicated by a `5xx` status. Error responses have a `message` property with more information. ## Version The current
  * version of the Composition API is version 1, as indicated by the `/1/` in each endpoint's URL.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.composition

import org.json4s.MonadicJValue.jvalueToMonadic
import org.json4s.{Extraction, Formats, JField, JObject, JValue, Serializer, TypeInfo}

/** BaseSearchResponse
  *
  * @param abTestID
  *   A/B test ID. This is only included in the response for indices that are part of an A/B test.
  * @param abTestVariantID
  *   Variant ID. This is only included in the response for indices that are part of an A/B test.
  * @param aroundLatLng
  *   Computed geographical location.
  * @param automaticRadius
  *   Distance from a central coordinate provided by `aroundLatLng`.
  * @param appliedRules
  *   Rules applied to the query.
  * @param exhaustiveFacetsCount
  *   See the `facetsCount` field of the `exhaustive` object in the response.
  * @param exhaustiveNbHits
  *   See the `nbHits` field of the `exhaustive` object in the response.
  * @param exhaustiveTypo
  *   See the `typo` field of the `exhaustive` object in the response.
  * @param facets
  *   Facet counts.
  * @param facetsStats
  *   Statistics for numerical facets.
  * @param index
  *   Index name used for the query.
  * @param indexUsed
  *   Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query.
  * @param message
  *   Warnings about the query.
  * @param nbSortedHits
  *   Number of hits selected and sorted by the relevant sort algorithm.
  * @param parsedQuery
  *   Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean)
  *   query string that will be searched.
  * @param processingTimeMS
  *   Time the server took to process the request, in milliseconds.
  * @param processingTimingsMS
  *   Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate
  *   performance issues.
  * @param queryAfterRemoval
  *   Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.
  * @param serverTimeMS
  *   Time the server took to process the request, in milliseconds.
  * @param serverUsed
  *   Host name of the server that processed the request.
  * @param userData
  *   An object with custom data. You can store up to 32kB as custom data.
  * @param queryID
  *   Unique identifier for the query. This is used for [click
  *   analytics](https://www.algolia.com/doc/guides/analytics/click-analytics/).
  * @param automaticInsights
  *   Whether automatic events collection is enabled for the application.
  */
case class BaseSearchResponse(
    abTestID: Option[Int] = scala.None,
    abTestVariantID: Option[Int] = scala.None,
    aroundLatLng: Option[String] = scala.None,
    automaticRadius: Option[String] = scala.None,
    exhaustive: Option[Exhaustive] = scala.None,
    appliedRules: Option[Seq[Any]] = scala.None,
    exhaustiveFacetsCount: Option[Boolean] = scala.None,
    exhaustiveNbHits: Option[Boolean] = scala.None,
    exhaustiveTypo: Option[Boolean] = scala.None,
    facets: Option[Map[String, Map[String, Int]]] = scala.None,
    facetsStats: Option[Map[String, FacetStats]] = scala.None,
    index: Option[String] = scala.None,
    indexUsed: Option[String] = scala.None,
    message: Option[String] = scala.None,
    nbSortedHits: Option[Int] = scala.None,
    parsedQuery: Option[String] = scala.None,
    processingTimeMS: Int,
    processingTimingsMS: Option[Any] = scala.None,
    queryAfterRemoval: Option[String] = scala.None,
    redirect: Option[Redirect] = scala.None,
    renderingContent: Option[RenderingContent] = scala.None,
    serverTimeMS: Option[Int] = scala.None,
    serverUsed: Option[String] = scala.None,
    userData: Option[Any] = scala.None,
    queryID: Option[String] = scala.None,
    automaticInsights: Option[Boolean] = scala.None,
    additionalProperties: Option[List[JField]] = None
)

class BaseSearchResponseSerializer extends Serializer[BaseSearchResponse] {

  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), BaseSearchResponse] = {
    case (TypeInfo(clazz, _), json) if clazz == classOf[BaseSearchResponse] =>
      json match {
        case jobject: JObject =>
          val formats = format - this
          val mf = manifest[BaseSearchResponse]
          val obj = Extraction.extract[BaseSearchResponse](jobject)(formats, mf)

          val fields = Set(
            "abTestID",
            "abTestVariantID",
            "aroundLatLng",
            "automaticRadius",
            "exhaustive",
            "appliedRules",
            "exhaustiveFacetsCount",
            "exhaustiveNbHits",
            "exhaustiveTypo",
            "facets",
            "facetsStats",
            "index",
            "indexUsed",
            "message",
            "nbSortedHits",
            "parsedQuery",
            "processingTimeMS",
            "processingTimingsMS",
            "queryAfterRemoval",
            "redirect",
            "renderingContent",
            "serverTimeMS",
            "serverUsed",
            "userData",
            "queryID",
            "automaticInsights"
          )
          val additionalProperties = jobject removeField {
            case (name, _) if fields.contains(name) => true
            case _                                  => false
          }
          additionalProperties.values match {
            case JObject(fieldsList) => obj copy (additionalProperties = Some(fieldsList))
            case _                   => obj
          }
        case _ => throw new IllegalArgumentException(s"Can't deserialize $json as BaseSearchResponse")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: BaseSearchResponse =>
    val formats = format - this // remove current serializer from formats to avoid stackoverflow
    value.additionalProperties match {
      case Some(fields) => Extraction.decompose(value.copy(additionalProperties = None))(formats) merge JObject(fields)
      case None         => Extraction.decompose(value)(formats)
    }
  }
}
