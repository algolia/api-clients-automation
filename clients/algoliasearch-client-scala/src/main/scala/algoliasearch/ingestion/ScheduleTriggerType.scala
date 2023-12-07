/** Ingestion API API powering the Data Ingestion connectors of Algolia.
  *
  * The version of the OpenAPI document: 1.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.ingestion

import org.json4s._

sealed trait ScheduleTriggerType

/** A task which is triggered by a schedule (cron expression).
  */
object ScheduleTriggerType {
  case object Schedule extends ScheduleTriggerType {
    override def toString = "schedule"
  }
  val values: Seq[ScheduleTriggerType] = Seq(Schedule)

  def withName(name: String): ScheduleTriggerType = ScheduleTriggerType.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown ScheduleTriggerType value: $name"))
}

class ScheduleTriggerTypeSerializer
    extends CustomSerializer[ScheduleTriggerType](_ =>
      (
        {
          case JString(value) => ScheduleTriggerType.withName(value)
          case JNull          => null
        },
        { case value: ScheduleTriggerType =>
          JString(value.toString)
        }
      )
    )
