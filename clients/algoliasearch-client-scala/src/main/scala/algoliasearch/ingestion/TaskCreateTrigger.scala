/** Ingestion API API powering the Data Ingestion connectors of Algolia.
  *
  * The version of the OpenAPI document: 1.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.ingestion

import algoliasearch.ingestion.StreamingTriggerType._

import org.json4s._

/** TaskCreateTrigger
  */
sealed trait TaskCreateTrigger

trait TaskCreateTriggerTrait extends TaskCreateTrigger

object TaskCreateTrigger {}

object TaskCreateTriggerSerializer extends Serializer[TaskCreateTrigger] {
  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), TaskCreateTrigger] = {

    case (TypeInfo(clazz, _), json) if clazz == classOf[TaskCreateTrigger] =>
      json match {
        case value: JObject => Extraction.extract[OnDemandTriggerInput](value)
        case value: JObject => Extraction.extract[ScheduleTriggerInput](value)
        case value: JObject => Extraction.extract[SubscriptionTrigger](value)
        case value: JObject => Extraction.extract[StreamingTrigger](value)
        case _              => throw new MappingException("Can't convert " + json + " to TaskCreateTrigger")
      }
  }

  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = { case value: TaskCreateTrigger =>
    value match {
      case value: OnDemandTriggerInput => Extraction.decompose(value)(format - this)
      case value: ScheduleTriggerInput => Extraction.decompose(value)(format - this)
      case value: SubscriptionTrigger  => Extraction.decompose(value)(format - this)
      case value: StreamingTrigger     => Extraction.decompose(value)(format - this)
    }
  }
}
