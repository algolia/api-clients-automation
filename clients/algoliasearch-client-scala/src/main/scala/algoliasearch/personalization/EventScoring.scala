/** Personalization API API powering the Personalization feature of Algolia.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.personalization

/** EventScoring
  *
  * @param score
  *   The score for the event.
  * @param eventName
  *   The name of the event.
  * @param eventType
  *   The type of the event.
  */
case class EventScoring(
    score: Int,
    eventName: String,
    eventType: String
)
