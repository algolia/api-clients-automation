/** Insights API The Insights API lets you collect events related to your search and discovery experience. Events
  * represent user interactions with your app or website. They unlock powerful features, such as recommendations,
  * personalization, smarter search results, and analytics that help you optimize your user experience. ## Client
  * libraries Use Algolia's API clients, libraries, and integrations to collect events from your UI and send them to the
  * Insights API. See: [Algolia's
  * ecosystem](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/). ## Base URLs
  * The base URLs for making requests to the Insights API are: - `https://insights.us.algolia.io` -
  * `https://insights.de.algolia.io` - `https//insights.algolia.io` (routes requests to the closest of the above
  * servers, based on your geographical location) **All requests must use HTTPS.** ## Authentication To authenticate
  * your API requests, add these headers: - `x-algolia-application-id`. Your Algolia application ID. -
  * `x-algolia-api-key`. An API key with the necessary permissions to make the request. The required access control list
  * (ACL) to make a request is listed in each endpoint's reference. You can find your application ID and API key in the
  * [Algolia dashboard](https://dashboard.algolia.com/account). ## Request format Request bodies must be JSON objects.
  * ## Response status and errors Response bodies are JSON objects. Deleting a user token returns an empty response body
  * with rate-limiting information as headers. Successful responses return a `2xx` status. Client errors return a `4xx`
  * status. Server errors are indicated by a `5xx` status. Error responses have a `message` property with more
  * information. The Insights API doesn't validate if the event parameters such as `indexName`, `objectIDs`, or
  * `userToken`, correspond to anything in the Search API. It just checks if they're formatted correctly. Check the
  * [Events](https://dashboard.algolia.com/events/health) health section, whether your events can be used for Algolia
  * features such as Analytics, or Dynamic Re-Ranking. ## Version The current version of the Insights API is version 1,
  * as indicated by the `/1/` in each endpoint's URL.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.insights

import algoliasearch.insights.AddToCartEvent._
import algoliasearch.insights.ViewEvent._

import org.json4s._

/** EventsItems
  */
sealed trait EventsItems

trait EventsItemsTrait extends EventsItems

object EventsItems {}

object EventsItemsSerializer extends Serializer[EventsItems] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), EventsItems] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[EventsItems] =>
      json match {
        case value: JObject
            if value.obj.exists(_._1 == "eventType") && value.obj.exists(_._1 == "eventSubtype") && value.obj.exists(
              _._1 == "queryID"
            ) && value.obj.exists(_._1 == "objectIDs") =>
          Extraction.extract[AddedToCartObjectIDsAfterSearch](value)
        case value: JObject
            if value.obj.exists(_._1 == "eventType") && value.obj.exists(_._1 == "eventSubtype") && value.obj.exists(
              _._1 == "objectIDs"
            ) && value.obj.exists(_._1 == "objectData") =>
          Extraction.extract[PurchasedObjectIDsAfterSearch](value)
        case value: JObject
            if value.obj.exists(_._1 == "positions") && value.obj
              .exists(_._1 == "queryID") && value.obj.exists(_._1 == "eventType") =>
          Extraction.extract[ClickedObjectIDsAfterSearch](value)
        case value: JObject
            if value.obj.exists(_._1 == "eventType") && value.obj
              .exists(_._1 == "eventSubtype") && value.obj.exists(_._1 == "objectIDs") =>
          Extraction.extract[PurchasedObjectIDs](value)
        case value: JObject
            if value.obj.exists(_._1 == "eventType") && value.obj
              .exists(_._1 == "eventSubtype") && value.obj.exists(_._1 == "objectIDs") =>
          Extraction.extract[AddedToCartObjectIDs](value)
        case value: JObject if value.obj.exists(_._1 == "queryID") && value.obj.exists(_._1 == "eventType") =>
          Extraction.extract[ConvertedObjectIDsAfterSearch](value)
        case value: JObject if value.obj.exists(_._1 == "eventType") && value.obj.exists(_._1 == "objectIDs") =>
          Extraction.extract[ClickedObjectIDs](value)
        case value: JObject if value.obj.exists(_._1 == "eventType") && value.obj.exists(_._1 == "objectIDs") =>
          Extraction.extract[ConvertedObjectIDs](value)
        case value: JObject if value.obj.exists(_._1 == "eventType") && value.obj.exists(_._1 == "filters") =>
          Extraction.extract[ClickedFilters](value)
        case value: JObject if value.obj.exists(_._1 == "eventType") && value.obj.exists(_._1 == "filters") =>
          Extraction.extract[ConvertedFilters](value)
        case value: JObject if value.obj.exists(_._1 == "eventType") && value.obj.exists(_._1 == "objectIDs") =>
          Extraction.extract[ViewedObjectIDs](value)
        case value: JObject if value.obj.exists(_._1 == "eventType") && value.obj.exists(_._1 == "filters") =>
          Extraction.extract[ViewedFilters](value)
        case _ => throw new MappingException("Can't convert " + json + " to EventsItems")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: EventsItems =>
    value match {
      case value: AddedToCartObjectIDsAfterSearch => Extraction.decompose(value)(format - this)
      case value: PurchasedObjectIDsAfterSearch   => Extraction.decompose(value)(format - this)
      case value: ClickedObjectIDsAfterSearch     => Extraction.decompose(value)(format - this)
      case value: PurchasedObjectIDs              => Extraction.decompose(value)(format - this)
      case value: AddedToCartObjectIDs            => Extraction.decompose(value)(format - this)
      case value: ConvertedObjectIDsAfterSearch   => Extraction.decompose(value)(format - this)
      case value: ClickedObjectIDs                => Extraction.decompose(value)(format - this)
      case value: ConvertedObjectIDs              => Extraction.decompose(value)(format - this)
      case value: ClickedFilters                  => Extraction.decompose(value)(format - this)
      case value: ConvertedFilters                => Extraction.decompose(value)(format - this)
      case value: ViewedObjectIDs                 => Extraction.decompose(value)(format - this)
      case value: ViewedFilters                   => Extraction.decompose(value)(format - this)
    }
  }
}
