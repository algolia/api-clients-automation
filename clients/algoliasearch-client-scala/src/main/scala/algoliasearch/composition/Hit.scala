/** Composition API The Algolia Composition API lets you run composed search requests on your Compositions. ## Client
  * libraries Use Algolia's API clients and libraries to reliably integrate Algolia's APIs with your apps. See:
  * [Algolia's ecosystem](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) ##
  * Base URLs The base URLs for requests to the Composition API are: - `https://{APPLICATION_ID}.algolia.net` -
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

import org.json4s._

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
    highlightResult /* _highlightResult */: Option[Map[String, HighlightResult]] = scala.None,
    snippetResult /* _snippetResult */: Option[Map[String, SnippetResult]] = scala.None,
    rankingInfo /* _rankingInfo */: Option[HitRankingInfo] = scala.None,
    distinctSeqID /* _distinctSeqID */: Option[Int] = scala.None,
    additionalProperties: Option[List[JField]] = None
)

class HitSerializer extends Serializer[Hit] {

  private val renamedFields = Map[String, String](
    "_highlightResult" -> "highlightResult",
    "_snippetResult" -> "snippetResult",
    "_rankingInfo" -> "rankingInfo",
    "_distinctSeqID" -> "distinctSeqID"
  )
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), Hit] = {
    case (TypeInfo(clazz, _), json) if clazz == classOf[Hit] =>
      json match {
        case jobject: JObject =>
          // Rename fields from JSON to Scala
          val renamedObject = JObject(
            jobject.obj.map { field =>
              renamedFields.get(field._1).map(JField(_, field._2)).getOrElse(field)
            }
          )
          val formats = format - this
          val mf = manifest[Hit]
          val obj = Extraction.extract[Hit](renamedObject)(formats, mf)

          val fields = Set("objectID", "_highlightResult", "_snippetResult", "_rankingInfo", "_distinctSeqID")
          val additionalProperties = jobject removeField {
            case (name, _) if fields.contains(name) => true
            case _                                  => false
          }
          additionalProperties match {
            case JObject(fieldsList) => obj copy (additionalProperties = Some(fieldsList))
            case _                   => obj
          }
        case _ => throw new IllegalArgumentException(s"Can't deserialize $json as Hit")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: Hit =>
    val formats = format - this // remove current serializer from formats to avoid stackoverflow
    val baseObj = Extraction.decompose(value.copy(additionalProperties = None))(formats)
    val renamedObj = baseObj transformField {
      case JField(name, value) if renamedFields.exists(_._2 == name) => (renamedFields.find(_._2 == name).get._1, value)
    }
    value.additionalProperties match {
      case Some(fields) => renamedObj merge JObject(fields)
      case None         => renamedObj
    }
  }
}
