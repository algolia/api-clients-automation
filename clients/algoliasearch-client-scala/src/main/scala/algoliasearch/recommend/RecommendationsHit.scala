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

/** RecommendationsHit
  */
sealed trait RecommendationsHit

trait RecommendationsHitTrait extends RecommendationsHit

object RecommendationsHit {

  case class RecommendHitValue(value: RecommendHit) extends RecommendationsHit

  def apply(value: RecommendHit): RecommendationsHit = {
    RecommendationsHit.RecommendHitValue(value)
  }
}

object RecommendationsHitSerializer extends Serializer[RecommendationsHit] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), RecommendationsHit] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[RecommendationsHit] =>
      json match {
        case value: JObject => Extraction.extract[TrendingFacetHit](value)
        case _              => throw new MappingException("Can't convert " + json + " to RecommendationsHit")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: RecommendationsHit =>
    value match {
      case value: TrendingFacetHit => Extraction.decompose(value)(format - this)
    }
  }
}
