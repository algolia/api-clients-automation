/** Ingestion API The Ingestion API lets you connect third-party services and platforms with Algolia and schedule tasks
  * to ingest your data. The Ingestion API powers the no-code [data
  * connectors](https://dashboard.algolia.com/connectors). ## Base URLs The base URLs for requests to the Ingestion API
  * are: - `https://data.us.algolia.com` - `https://data.eu.algolia.com` Use the URL that matches your [analytics
  * region](https://dashboard.algolia.com/account/infrastructure/analytics). **All requests must use HTTPS.** ##
  * Authentication To authenticate your API requests, add these headers: - `x-algolia-application-id`. Your Algolia
  * application ID. - `x-algolia-api-key`. An API key with the necessary permissions to make the request. The required
  * access control list (ACL) to make a request is listed in each endpoint's reference. You can find your application ID
  * and API key in the [Algolia dashboard](https://dashboard.algolia.com/account). ## Request format Request bodies must
  * be JSON objects. ## Response status and errors Response bodies are JSON objects. Successful responses return a `2xx`
  * status. Client errors return a `4xx` status. Server errors are indicated by a `5xx` status. Error responses have a
  * `message` property with more information. ## Version The current version of the Ingestion API is version 1, as
  * indicated by the `/1/` in each endpoint's URL.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.ingestion

import org.json4s._

sealed trait TriggerType

/** Task trigger, describing when a task should run. - `onDemand`. Manually trigger the task with the `/run` endpoint. -
  * `schedule`. Regularly trigger the task on a `cron` schedule. - `subscription`. Trigger the task after an event is
  * received, such as, a webhook. - `streaming`. Run the task continuously.
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
