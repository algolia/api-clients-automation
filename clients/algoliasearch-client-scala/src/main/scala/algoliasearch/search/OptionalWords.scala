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

/** Words that should be considered optional when found in the query. By default, records must match all words in the
  * search query to be included in the search results. Adding optional words can help to increase the number of search
  * results by running an additional search query that doesn't include the optional words. For example, if the search
  * query is \"action video\" and \"video\" is an optional word, the search engine runs two queries. One for \"action
  * video\" and one for \"action\". Records that match all words are ranked higher. For a search query with 4 or more
  * words **and** all its words are optional, the number of matched words required for a record to be included in the
  * search results increases for every 1,000 records: - If `optionalWords` has less than 10 words, the required number
  * of matched words increases by 1: results 1 to 1,000 require 1 matched word, results 1,001 to 2000 need 2 matched
  * words. - If `optionalWords` has 10 or more words, the number of required matched words increases by the number of
  * optional words divided by 5 (rounded down). For example, with 18 optional words: results 1 to 1,000 require 1
  * matched word, results 1,001 to 2000 need 4 matched words. For more information, see [Optional
  * words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words).
  */
sealed trait OptionalWords

object OptionalWords {

  case class StringValue(value: String) extends OptionalWords

  case class SeqOfString(value: Seq[String]) extends OptionalWords

  def apply(value: String): OptionalWords = {
    OptionalWords.StringValue(value)
  }

  def apply(value: Seq[String]): OptionalWords = {
    OptionalWords.SeqOfString(value)
  }

}

object OptionalWordsSerializer extends Serializer[OptionalWords] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), OptionalWords] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[OptionalWords] =>
      json match {
        case JString(value) => OptionalWords.StringValue(value)
        case value: JArray  => OptionalWords.apply(Extraction.extract[Seq[String]](value))
        case _              => throw new MappingException("Can't convert " + json + " to OptionalWords")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: OptionalWords =>
    value match {
      case OptionalWords.StringValue(value) => JString(value)
      case OptionalWords.SeqOfString(value) => JArray(value.map(Extraction.decompose).toList)
    }
  }
}
