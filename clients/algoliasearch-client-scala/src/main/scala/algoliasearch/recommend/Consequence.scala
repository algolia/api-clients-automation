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

/** [Consequences](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#consequences) of a rule.
  *
  * @param promote
  *   Records to promote.
  * @param filterPromotes
  *   Only use in combination with the `promote` consequence. When `true`, promoted results will be restricted to match
  *   the filters of the current search. When `false`, the promoted results will show up regardless of the filters.
  * @param hide
  *   Records to hide. By default, you can hide up to 50 records per rule.
  * @param userData
  *   Custom JSON object that will be appended to the userData array in the response. This object isn't interpreted by
  *   the API. It's limited to 1kB of minified JSON.
  */
case class Consequence(
    params: Option[ConsequenceParams] = scala.None,
    promote: Option[Seq[Promote]] = scala.None,
    filterPromotes: Option[Boolean] = scala.None,
    hide: Option[Seq[ConsequenceHide]] = scala.None,
    userData: Option[Any] = scala.None
)
