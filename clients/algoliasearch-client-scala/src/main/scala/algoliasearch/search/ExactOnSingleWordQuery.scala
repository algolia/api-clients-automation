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

import org.json4s._

sealed trait ExactOnSingleWordQuery

/** Determines how the [Exact ranking
  * criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes)
  * is computed when the search query has only one word. <dl> <dt><code>attribute</code></dt> <dd> The Exact ranking
  * criterion is 1 if the query word and attribute value are the same. For example, a search for \"road\" will match the
  * value \"road\", but not \"road trip\". </dd> <dt><code>none</code></dt> <dd> The Exact ranking criterion is ignored
  * on single-word searches. </dd> <dt><code>word</code></dt> <dd> The Exact ranking criterion is 1 if the query word is
  * found in the attribute value. The query word must have at least 3 characters and must not be a stop word. </dd>
  * </dl> If `exactOnSingleWordQuery` is `word`, only exact matches will be highlighted, partial and prefix matches
  * won't.
  */
object ExactOnSingleWordQuery {
  case object Attribute extends ExactOnSingleWordQuery {
    override def toString = "attribute"
  }
  case object None extends ExactOnSingleWordQuery {
    override def toString = "none"
  }
  case object Word extends ExactOnSingleWordQuery {
    override def toString = "word"
  }
  val values: Seq[ExactOnSingleWordQuery] = Seq(Attribute, None, Word)

  def withName(name: String): ExactOnSingleWordQuery = ExactOnSingleWordQuery.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown ExactOnSingleWordQuery value: $name"))
}

class ExactOnSingleWordQuerySerializer
    extends CustomSerializer[ExactOnSingleWordQuery](_ =>
      (
        {
          case JString(value) => ExactOnSingleWordQuery.withName(value)
          case JNull          => null
        },
        { case value: ExactOnSingleWordQuery =>
          JString(value.toString)
        }
      )
    )
