/** Composition API Composition API.
  *
  * The version of the OpenAPI document: 1.0.0
  *
  * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
  * https://openapi-generator.tech Do not edit the class manually.
  */
package algoliasearch.composition

/** SearchForFacetValuesResults
  *
  * @param facetHits
  *   Matching facet values.
  * @param exhaustiveFacetsCount
  *   Whether the facet count is exhaustive (true) or approximate (false). For more information, see [Why are my facet
  *   and hit counts not
  *   accurate](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-).
  * @param processingTimeMS
  *   Time the server took to process the request, in milliseconds.
  */
case class SearchForFacetValuesResults(
    indexName: String,
    facetHits: Seq[FacetHits],
    exhaustiveFacetsCount: Boolean,
    processingTimeMS: Option[Int] = scala.None
)
