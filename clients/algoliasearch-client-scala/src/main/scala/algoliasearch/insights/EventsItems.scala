/** Insights API The Algolia Insights API lets you collect events related to your search and discovery experience.
  * Events represent actions that users take on your app or website. They unlock powerful features, such as
  * recommendations, personalization, smarter search results, and analytics that help you optimize your user experience.
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
            if value.obj.exists(_._1 == "positions") && value.obj
              .exists(_._1 == "queryID") && value.obj.exists(_._1 == "eventType") =>
          Extraction.extract[ClickedObjectIDsAfterSearch](value)
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
        case value: JObject if value.obj.exists(_._1 == "queryID") && value.obj.exists(_._1 == "eventType") =>
          Extraction.extract[ConvertedObjectIDsAfterSearch](value)
        case value: JObject if value.obj.exists(_._1 == "eventType") && value.obj.exists(_._1 == "objectIDs") =>
          Extraction.extract[ClickedObjectIDs](value)
        case value: JObject
            if value.obj.exists(_._1 == "eventType") && value.obj
              .exists(_._1 == "eventSubtype") && value.obj.exists(_._1 == "objectIDs") =>
          Extraction.extract[PurchasedObjectIDs](value)
        case value: JObject
            if value.obj.exists(_._1 == "eventType") && value.obj
              .exists(_._1 == "eventSubtype") && value.obj.exists(_._1 == "objectIDs") =>
          Extraction.extract[AddedToCartObjectIDs](value)
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
      case value: ClickedObjectIDsAfterSearch     => Extraction.decompose(value)(format - this)
      case value: AddedToCartObjectIDsAfterSearch => Extraction.decompose(value)(format - this)
      case value: PurchasedObjectIDsAfterSearch   => Extraction.decompose(value)(format - this)
      case value: ConvertedObjectIDsAfterSearch   => Extraction.decompose(value)(format - this)
      case value: ClickedObjectIDs                => Extraction.decompose(value)(format - this)
      case value: PurchasedObjectIDs              => Extraction.decompose(value)(format - this)
      case value: AddedToCartObjectIDs            => Extraction.decompose(value)(format - this)
      case value: ConvertedObjectIDs              => Extraction.decompose(value)(format - this)
      case value: ClickedFilters                  => Extraction.decompose(value)(format - this)
      case value: ConvertedFilters                => Extraction.decompose(value)(format - this)
      case value: ViewedObjectIDs                 => Extraction.decompose(value)(format - this)
      case value: ViewedFilters                   => Extraction.decompose(value)(format - this)
    }
  }
}
