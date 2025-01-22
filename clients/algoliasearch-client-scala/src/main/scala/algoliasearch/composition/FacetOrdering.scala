/** Composition API Composition API.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.composition

/** Order of facet names and facet values in your UI.
  *
  * @param values
  *   Order of facet values. One object for each facet.
  */
case class FacetOrdering(
    facets: Option[Facets] = scala.None,
    values: Option[Map[String, Value]] = scala.None
)
