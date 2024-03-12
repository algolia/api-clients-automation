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

sealed trait TaskStatus

/** Task status, `published` if the task is completed, `notPublished` otherwise.
  */
object TaskStatus {
  case object Published extends TaskStatus {
    override def toString = "published"
  }
  case object NotPublished extends TaskStatus {
    override def toString = "notPublished"
  }
  val values: Seq[TaskStatus] = Seq(Published, NotPublished)

  def withName(name: String): TaskStatus = TaskStatus.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown TaskStatus value: $name"))
}

class TaskStatusSerializer
    extends CustomSerializer[TaskStatus](_ =>
      (
        {
          case JString(value) => TaskStatus.withName(value)
          case JNull          => null
        },
        { case value: TaskStatus =>
          JString(value.toString)
        }
      )
    )
