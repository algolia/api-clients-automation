/** Composition API Composition API.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.composition

/** RedirectRuleIndexMetadata
  *
  * @param source
  *   Source index for the redirect rule.
  * @param dest
  *   Destination index for the redirect rule.
  * @param reason
  *   Reason for the redirect rule.
  * @param succeed
  *   Redirect rule status.
  */
case class RedirectRuleIndexMetadata(
    source: String,
    dest: String,
    reason: String,
    succeed: Boolean,
    data: RedirectRuleIndexData
)
