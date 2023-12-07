/** Ingestion API API powering the Data Ingestion connectors of Algolia.
  *
  * The version of the OpenAPI document: 1.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.ingestion

import algoliasearch.ingestion.BigQueryDataType._
import algoliasearch.ingestion.DockerRegistry._
import algoliasearch.ingestion.MappingTypeCSV._
import algoliasearch.ingestion.MethodType._

import org.json4s._

/** SourceUpdateInput
  */
sealed trait SourceUpdateInput

trait SourceUpdateInputTrait extends SourceUpdateInput

object SourceUpdateInput {}

object SourceUpdateInputSerializer extends Serializer[SourceUpdateInput] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), SourceUpdateInput] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[SourceUpdateInput] =>
      json match {
        case value: JObject => Extraction.extract[SourceUpdateCommercetools](value)
        case value: JObject => Extraction.extract[SourceJSON](value)
        case value: JObject => Extraction.extract[SourceCSV](value)
        case value: JObject => Extraction.extract[SourceBigQuery](value)
        case value: JObject => Extraction.extract[SourceUpdateDocker](value)
        case _              => throw new MappingException("Can't convert " + json + " to SourceUpdateInput")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: SourceUpdateInput =>
    value match {
      case value: SourceUpdateCommercetools => Extraction.decompose(value)(format - this)
      case value: SourceJSON                => Extraction.decompose(value)(format - this)
      case value: SourceCSV                 => Extraction.decompose(value)(format - this)
      case value: SourceBigQuery            => Extraction.decompose(value)(format - this)
      case value: SourceUpdateDocker        => Extraction.decompose(value)(format - this)
    }
  }
}
