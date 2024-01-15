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

import org.json4s._

/** The absolute value of the discount for this product, in units of `currency`.
  */
sealed trait Discount

object Discount {

  case class DoubleValue(value: Double) extends Discount
  case class StringValue(value: String) extends Discount

  def apply(value: Double): Discount = {
    Discount.DoubleValue(value)
  }
  def apply(value: String): Discount = {
    Discount.StringValue(value)
  }
}

object DiscountSerializer extends Serializer[Discount] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), Discount] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[Discount] =>
      json match {
        case JDouble(value) => Discount.DoubleValue(value.toDouble)
        case JString(value) => Discount.StringValue(value)
        case _              => throw new MappingException("Can't convert " + json + " to Discount")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: Discount =>
    value match {
      case Discount.DoubleValue(value) => JDouble(value)
      case Discount.StringValue(value) => JString(value)
    }
  }
}
