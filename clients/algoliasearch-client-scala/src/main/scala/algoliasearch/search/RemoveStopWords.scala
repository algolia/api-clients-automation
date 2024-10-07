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

import algoliasearch.search.SupportedLanguage._

import org.json4s._

/** Removes stop words from the search query. Stop words are common words like articles, conjunctions, prepositions, or
  * pronouns that have little or no meaning on their own. In English, \"the\", \"a\", or \"and\" are stop words. You
  * should only use this feature for the languages used in your index.
  */
sealed trait RemoveStopWords

object RemoveStopWords {

  case class SeqOfSupportedLanguage(value: Seq[SupportedLanguage]) extends RemoveStopWords
  case class BooleanValue(value: Boolean) extends RemoveStopWords

  def apply(value: Seq[SupportedLanguage]): RemoveStopWords = {
    RemoveStopWords.SeqOfSupportedLanguage(value)
  }
  def apply(value: Boolean): RemoveStopWords = {
    RemoveStopWords.BooleanValue(value)
  }

}

object RemoveStopWordsSerializer extends Serializer[RemoveStopWords] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), RemoveStopWords] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[RemoveStopWords] =>
      json match {
        case JArray(value) if value.forall(_.isInstanceOf[JArray]) =>
          RemoveStopWords.SeqOfSupportedLanguage(value.map(_.extract))
        case JBool(value) => RemoveStopWords.BooleanValue(value)
        case _            => throw new MappingException("Can't convert " + json + " to RemoveStopWords")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: RemoveStopWords =>
    value match {
      case RemoveStopWords.SeqOfSupportedLanguage(value) => JArray(value.map(Extraction.decompose).toList)
      case RemoveStopWords.BooleanValue(value)           => JBool(value)
    }
  }
}
