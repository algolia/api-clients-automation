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

import org.json4s._

/** MixedSearchFilters
  */
sealed trait MixedSearchFilters

object MixedSearchFilters {

  case class SeqOfString(value: Seq[String]) extends MixedSearchFilters
  case class StringValue(value: String) extends MixedSearchFilters

  def apply(value: Seq[String]): MixedSearchFilters = {
    MixedSearchFilters.SeqOfString(value)
  }
  def apply(value: String): MixedSearchFilters = {
    MixedSearchFilters.StringValue(value)
  }
}

object MixedSearchFiltersSerializer extends Serializer[MixedSearchFilters] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), MixedSearchFilters] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[MixedSearchFilters] =>
      json match {
        case JArray(value) if value.forall(_.isInstanceOf[JArray]) =>
          MixedSearchFilters.SeqOfString(value.map(_.extract))
        case JString(value) => MixedSearchFilters.StringValue(value)
        case _              => throw new MappingException("Can't convert " + json + " to MixedSearchFilters")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: MixedSearchFilters =>
    value match {
      case MixedSearchFilters.SeqOfString(value) => JArray(value.map(Extraction.decompose).toList)
      case MixedSearchFilters.StringValue(value) => JString(value)
    }
  }
}
