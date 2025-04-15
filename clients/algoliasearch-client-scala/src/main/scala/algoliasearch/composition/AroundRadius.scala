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

import algoliasearch.composition.AroundRadiusAll._

import org.json4s._

/** Maximum radius for a search around a central location. This parameter works in combination with the `aroundLatLng`
  * and `aroundLatLngViaIP` parameters. By default, the search radius is determined automatically from the density of
  * hits around the central location. The search radius is small if there are many hits close to the central
  * coordinates.
  */
sealed trait AroundRadius

trait AroundRadiusTrait extends AroundRadius

object AroundRadius {

  case class IntValue(value: Int) extends AroundRadius

  def apply(value: Int): AroundRadius = {
    AroundRadius.IntValue(value)
  }

}

object AroundRadiusSerializer extends Serializer[AroundRadius] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), AroundRadius] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[AroundRadius] =>
      json match {
        case JInt(value)    => AroundRadius.IntValue(value.toInt)
        case value: JString => Extraction.extract[AroundRadiusAll](value)
        case _              => throw new MappingException("Can't convert " + json + " to AroundRadius")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: AroundRadius =>
    value match {
      case AroundRadius.IntValue(value) => JInt(value)
      case value: AroundRadiusAll       => JString(value.toString)
    }
  }
}
