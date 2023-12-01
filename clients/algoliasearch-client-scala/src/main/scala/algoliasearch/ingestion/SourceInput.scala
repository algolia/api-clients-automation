/** Ingestion API API powering the Data Ingestion connectors of Algolia.
  *
  * The version of the OpenAPI document: 1.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.ingestion

import algoliasearch.ingestion.BigQueryDataType._
import algoliasearch.ingestion.DockerImageType._
import algoliasearch.ingestion.DockerRegistry._
import algoliasearch.ingestion.MappingTypeCSV._
import algoliasearch.ingestion.MethodType._

import org.json4s._

/** SourceInput
  */
sealed trait SourceInput

trait SourceInputTrait extends SourceInput

object SourceInput {}

object SourceInputSerializer extends Serializer[SourceInput] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), SourceInput] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[SourceInput] =>
      json match {
        case value: JObject => Extraction.extract[SourceCommercetools](value)
        case value: JObject => Extraction.extract[SourceBigCommerce](value)
        case value: JObject => Extraction.extract[SourceJSON](value)
        case value: JObject => Extraction.extract[SourceCSV](value)
        case value: JObject => Extraction.extract[SourceBigQuery](value)
        case value: JObject => Extraction.extract[SourceDocker](value)
        case _              => throw new MappingException("Can't convert " + json + " to SourceInput")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value =>
    Extraction.decompose(value)(format - this)
  }
}

object SourceInputEnums {}
