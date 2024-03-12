/** Search API The Algolia Search API lets you search, configure, and mange your indices and records. # Client libraries
  * Use Algolia's API clients and libraries to reliably integrate Algolia's APIs with your apps. The official API
  * clients are covered by Algolia's [Service Level Agreement](https://www.algolia.com/policies/sla/). See: [Algolia's
  * ecosystem](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) # Base URLs The
  * base URLs for making requests to the Search API are: - `https://{APPLICATION_ID}.algolia.net` -
  * `https://{APPLICATION_ID}-dsn.algolia.net`. If your subscription includes a [Distributed Search
  * Network](https://dashboard.algolia.com/infra), this ensures that requests are sent to servers closest to users. Both
  * URLs provide high availability by distributing requests with load balancing. **All requests must use HTTPS.** #
  * Retry strategy To guarantee a high availability, implement a retry strategy for all API requests using the URLs of
  * your servers as fallbacks: - `https://{APPLICATION_ID}-1.algolianet.com` -
  * `https://{APPLICATION_ID}-2.algolianet.com` - `https://{APPLICATION_ID}-3.algolianet.com` These URLs use a different
  * DNS provider than the primary URLs. You should randomize this list to ensure an even load across the three servers.
  * All Algolia API clients implement this retry strategy. # Authentication To authenticate your API requests, add these
  * headers: <dl> <dt><code>x-algolia-application-id</code></dt> <dd>Your Algolia application ID.</dd>
  * <dt><code>x-algolia-api-key</code></dt> <dd> An API key with the necessary permissions to make the request. The
  * required access control list (ACL) to make a request is listed in each endpoint's reference. </dd> </dl> You can
  * find your application ID and API key in the [Algolia dashboard](https://dashboard.algolia.com/account). # Request
  * format Depending on the endpoint, request bodies are either JSON objects or arrays of JSON objects, # Parameters
  * Parameters are passed as query parameters for GET and DELETE requests, and in the request body for POST and PUT
  * requests. Query parameters must be
  * [URL-encoded](https://developer.mozilla.org/en-US/docs/Glossary/Percent-encoding). Non-ASCII characters must be
  * UTF-8 encoded. Plus characters (`+`) are interpreted as spaces. Arrays as query parameters must be one of: - A
  * comma-separated string: `attributesToRetrieve=title,description` - A URL-encoded JSON array:
  * `attributesToRetrieve=%5B%22title%22,%22description%22%D` # Response status and errors The Search API returns JSON
  * responses. Since JSON doesn't guarantee any specific ordering, don't rely on the order of attributes in the API
  * response. Successful responses return a `2xx` status. Client errors return a `4xx` status. Server errors are
  * indicated by a `5xx` status. Error responses have a `message` property with more information. # Version The current
  * version of the Search API is version 1, as indicated by the `/1/` in each endpoint's URL.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.search

import org.json4s.MonadicJValue.jvalueToMonadic
import org.json4s.{Extraction, Formats, JField, JObject, JValue, Serializer, TypeInfo}

/** Search result. A hit is a record from your index, augmented with special attributes for highlighting, snippeting,
  * and ranking.
  *
  * @param objectID
  *   Unique record identifier.
  * @param highlightResult
  *   Surround words that match the query with HTML tags for highlighting.
  * @param snippetResult
  *   Snippets that show the context around a matching search query.
  */
case class Hit(
    objectID: String,
    highlightResult: Option[Map[String, HighlightResult]] = scala.None,
    snippetResult: Option[Map[String, SnippetResult]] = scala.None,
    rankingInfo: Option[RankingInfo] = scala.None,
    distinctSeqID: Option[Int] = scala.None,
    additionalProperties: Option[List[JField]] = None
)

class HitSerializer extends Serializer[Hit] {

  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), Hit] = {
    case (TypeInfo(clazz, _), json) if clazz == classOf[Hit] =>
      json match {
        case jobject: JObject =>
          val formats = format - this
          val mf = manifest[Hit]
          val obj = Extraction.extract[Hit](jobject)(formats, mf)

          val fields = Set("objectID", "highlightResult", "snippetResult", "rankingInfo", "distinctSeqID")
          val additionalProperties = jobject removeField {
            case (name, _) if fields.contains(name) => true
            case _                                  => false
          }
          additionalProperties.values match {
            case JObject(fieldsList) => obj copy (additionalProperties = Some(fieldsList))
            case _                   => obj
          }
        case _ => throw new IllegalArgumentException(s"Can't deserialize $json as Hit")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: Hit =>
    val formats = format - this // remove current serializer from formats to avoid stackoverflow
    value.additionalProperties match {
      case Some(fields) => Extraction.decompose(value.copy(additionalProperties = None))(formats) merge JObject(fields)
      case None         => Extraction.decompose(value)(formats)
    }
  }
}
