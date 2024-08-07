/** Algolia Monitoring API The Monitoring API lets you check the status of your Algolia infrastructure. ## Base URLs The
  * base URL for requests to the Monitoring API is: - `https://status.algolia.com` **All requests must use HTTPS.** ##
  * Availability and authentication Access to the [Infrastructure](#tag/infrastructure) endpoints is available as part
  * of the [Premium or Elevate plans](https://www.algolia.com/pricing). To authenticate requests to the Infrastructure
  * endpoints, add these headers: - `x-algolia-application-id`. Your Algolia application ID. - `x-algolia-api-key`. Your
  * Monitoring API key. You can find your application ID and API key in the [Algolia
  * dashboard](https://dashboard.algolia.com/account). Other endpoints don't require authentication. ## Response status
  * and errors The Monitoring API returns JSON responses. Since JSON doesn't guarantee any specific ordering, don't rely
  * on the order of attributes in the API response. Successful responses return a `2xx` status. Client errors return a
  * `4xx` status. Server errors are indicated by a `5xx` status. Error responses have a `message` property with more
  * information. ## Version The current version of the Monitoring API is version 1, as indicated by the `/1/` in each
  * endpoint's URL.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.monitoring

import org.json4s._

sealed trait Period

/** Period enumeration
  */
object Period {
  case object Minute extends Period {
    override def toString = "minute"
  }
  case object Hour extends Period {
    override def toString = "hour"
  }
  case object Day extends Period {
    override def toString = "day"
  }
  case object Week extends Period {
    override def toString = "week"
  }
  case object Month extends Period {
    override def toString = "month"
  }
  val values: Seq[Period] = Seq(Minute, Hour, Day, Week, Month)

  def withName(name: String): Period = Period.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown Period value: $name"))
}

class PeriodSerializer
    extends CustomSerializer[Period](_ =>
      (
        {
          case JString(value) => Period.withName(value)
          case JNull          => null
        },
        { case value: Period =>
          JString(value.toString)
        }
      )
    )
