/** Search API Use the Search REST API to manage your data (indices and records), implement search, and improve
  * relevance (with Rules, synonyms, and language dictionaries). Although Algolia provides a REST API, you should use
  * the official open source API [clients, libraries, and
  * tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no
  * [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.search

import org.json4s._

sealed trait AroundRadiusAll extends AroundRadiusTrait

/** AroundRadiusAll enumeration
  */
object AroundRadiusAll {
  case object All extends AroundRadiusAll {
    override def toString = "all"
  }
  val values: Seq[AroundRadiusAll] = Seq(All)

  def withName(name: String): AroundRadiusAll = AroundRadiusAll.values
    .find(_.toString == name)
    .getOrElse(throw new MappingException(s"Unknown AroundRadiusAll value: $name"))
}

class AroundRadiusAllSerializer
    extends CustomSerializer[AroundRadiusAll](_ =>
      (
        {
          case JString(value) => AroundRadiusAll.withName(value)
          case JNull          => null
        },
        { case value: AroundRadiusAll =>
          JString(value.toString)
        }
      )
    )
