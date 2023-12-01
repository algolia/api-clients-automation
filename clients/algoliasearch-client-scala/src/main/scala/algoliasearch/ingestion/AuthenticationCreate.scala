/** Ingestion API API powering the Data Ingestion connectors of Algolia.
  *
  * The version of the OpenAPI document: 1.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.ingestion

import algoliasearch.ingestion.AuthenticationType._
import algoliasearch.ingestion.Platform._

/** The payload when creating an authentication.
  *
  * @param name
  *   An human readable name describing the object.
  */
case class AuthenticationCreate(
    `type`: AuthenticationType,
    name: String,
    platform: Option[Platform] = scala.None,
    input: AuthInput
)

object AuthenticationCreateEnums {}
