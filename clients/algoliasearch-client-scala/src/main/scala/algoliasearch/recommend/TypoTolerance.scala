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

import algoliasearch.recommend.TypoToleranceEnum._

import org.json4s._

/** Controls whether [typo
  * tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) is enabled
  * and how it is applied.
  */
sealed trait TypoTolerance

trait TypoToleranceTrait extends TypoTolerance

object TypoTolerance {

  case class BooleanValue(value: Boolean) extends TypoTolerance

  def apply(value: Boolean): TypoTolerance = {
    TypoTolerance.BooleanValue(value)
  }
}

object TypoToleranceSerializer extends Serializer[TypoTolerance] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), TypoTolerance] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[TypoTolerance] =>
      json match {
        case JBool(value)   => TypoTolerance.BooleanValue(value)
        case value: JString => Extraction.extract[TypoToleranceEnum](value)
        case _              => throw new MappingException("Can't convert " + json + " to TypoTolerance")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value =>
    Extraction.decompose(value)(format - this)
  }
}
