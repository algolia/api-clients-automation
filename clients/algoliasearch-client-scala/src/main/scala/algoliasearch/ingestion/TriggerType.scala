/** Ingestion API API powering the Data Ingestion connectors of Algolia.
  *
  * The version of the OpenAPI document: 1.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.ingestion

import org.json4s._

sealed trait TriggerType

/** The type of the task reflect how it can be used: - onDemand: a task that runs manually - schedule: a task that runs
  * regularly, following a given cron expression - subscription: a task that runs after a subscription event is received
  * from an integration (e.g. Webhook). - streaming: a task that runs continuously.
  */
object TriggerType {
  case object OnDemand extends TriggerType {
    override def toString = "onDemand"
  }
  case object Schedule extends TriggerType {
    override def toString = "schedule"
  }
  case object Subscription extends TriggerType {
    override def toString = "subscription"
  }
  case object Streaming extends TriggerType {
    override def toString = "streaming"
  }
  val values: Seq[TriggerType] = Seq(OnDemand, Schedule, Subscription, Streaming)

  def withName(name: String): TriggerType = TriggerType.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown TriggerType value: $name"))
}

class TriggerTypeSerializer
    extends CustomSerializer[TriggerType](_ =>
      (
        {
          case JString(value) => TriggerType.withName(value)
          case JNull          => null
        },
        { case value: TriggerType =>
          JString(value.toString)
        }
      )
    )
