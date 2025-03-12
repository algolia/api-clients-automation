/** Search API The Algolia Search API lets you search, configure, and manage your indices and records. ## Client
  * libraries Use Algolia's API clients and libraries to reliably integrate Algolia's APIs with your apps. The official
  * API clients are covered by Algolia's [Service Level Agreement](https://www.algolia.com/policies/sla/). See:
  * [Algolia's ecosystem](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) ##
  * Base URLs The base URLs for requests to the Search API are: - `https://{APPLICATION_ID}.algolia.net` -
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
  * `attributesToRetrieve=%5B%22title%22,%22description%22%D` ## Response status and errors The Search API returns JSON
  * responses. Since JSON doesn't guarantee any specific ordering, don't rely on the order of attributes in the API
  * response. Successful responses return a `2xx` status. Client errors return a `4xx` status. Server errors are
  * indicated by a `5xx` status. Error responses have a `message` property with more information. ## Version The current
  * version of the Search API is version 1, as indicated by the `/1/` in each endpoint's URL.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.search

import org.json4s._

/** LogQuery
  *
  * @param indexName
  *   Index targeted by the query.
  * @param userToken
  *   A user identifier.
  * @param queryId
  *   Unique query identifier.
  */
case class LogQuery(
    indexName /* index_name */: Option[String] = scala.None,
    userToken /* user_token */: Option[String] = scala.None,
    queryId /* query_id */: Option[String] = scala.None
)

class LogQuerySerializer extends Serializer[LogQuery] {

  private val renamedFields = Map[String, String](
    "index_name" -> "indexName",
    "user_token" -> "userToken",
    "query_id" -> "queryId"
  )
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), LogQuery] = {
    case (TypeInfo(clazz, _), json) if clazz == classOf[LogQuery] =>
      json match {
        case jobject: JObject =>
          // Rename fields from JSON to Scala
          val renamedObject = JObject(
            jobject.obj.map { field =>
              renamedFields.get(field._1).map(JField(_, field._2)).getOrElse(field)
            }
          )
          val formats = format - this
          val mf = manifest[LogQuery]
          Extraction.extract[LogQuery](renamedObject)(formats, mf)

        case _ => throw new IllegalArgumentException(s"Can't deserialize $json as LogQuery")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: LogQuery =>
    val formats = format - this // remove current serializer from formats to avoid stackoverflow
    val baseObj = Extraction.decompose(value)(formats)
    baseObj transformField {
      case JField(name, value) if renamedFields.exists(_._2 == name) => (renamedFields.find(_._2 == name).get._1, value)
    }
  }
}
