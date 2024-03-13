/** Ingestion API API powering the Data Ingestion connectors of Algolia.
  *
  * The version of the OpenAPI document: 1.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.ingestion

import org.json4s._

sealed trait ActionType

/** The action to perform on the Algolia index.
  */
object ActionType {
  case object Replace extends ActionType {
    override def toString = "replace"
  }
  case object Save extends ActionType {
    override def toString = "save"
  }
  case object Partial extends ActionType {
    override def toString = "partial"
  }
  case object Append extends ActionType {
    override def toString = "append"
  }
  val values: Seq[ActionType] = Seq(Replace, Save, Partial, Append)

  def withName(name: String): ActionType = ActionType.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown ActionType value: $name"))
}

class ActionTypeSerializer
    extends CustomSerializer[ActionType](_ =>
      (
        {
          case JString(value) => ActionType.withName(value)
          case JNull          => null
        },
        { case value: ActionType =>
          JString(value.toString)
        }
      )
    )
