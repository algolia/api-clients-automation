/** Recommend API The Recommend API lets you generate recommendations with several AI models. > **Note**: You should use
  * Algolia's [libraries and
  * tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) to interact with
  * the Recommend API. Using the HTTP endpoints directly is not covered by the
  * [SLA](https://www.algolia.com/policies/sla/).
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.recommend

import org.json4s._

/** Enables [deduplication or grouping of results (Algolia's _distinct_
  * feature](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/#introducing-algolias-distinct-feature)).
  */
sealed trait Distinct

object Distinct {

  case class BooleanValue(value: Boolean) extends Distinct
  case class IntValue(value: Int) extends Distinct

  def apply(value: Boolean): Distinct = {
    Distinct.BooleanValue(value)
  }
  def apply(value: Int): Distinct = {
    Distinct.IntValue(value)
  }
}

object DistinctSerializer extends Serializer[Distinct] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), Distinct] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[Distinct] =>
      json match {
        case JBool(value) => Distinct.BooleanValue(value)
        case JInt(value)  => Distinct.IntValue(value.toInt)
        case _            => throw new MappingException("Can't convert " + json + " to Distinct")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value =>
    Extraction.decompose(value)(format - this)
  }
}
