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

/** SearchResponse
  *
  * @param abTestID
  *   A/B test ID. This is only included in the response for indices that are part of an A/B test.
  * @param abTestVariantID
  *   Variant ID. This is only included in the response for indices that are part of an A/B test.
  * @param aroundLatLng
  *   Computed geographical location.
  * @param automaticRadius
  *   Automatically-computed radius.
  * @param exhaustiveFacetsCount
  *   See the `facetsCount` field of the `exhaustive` object in the response.
  * @param exhaustiveNbHits
  *   See the `nbHits` field of the `exhaustive` object in the response.
  * @param exhaustiveTypo
  *   See the `typo` field of the `exhaustive` object in the response.
  * @param facets
  *   Mapping of each facet name to the corresponding facet counts.
  * @param facetsStats
  *   Statistics for numerical facets.
  * @param hitsPerPage
  *   Number of hits per page.
  * @param index
  *   Index name used for the query.
  * @param indexUsed
  *   Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query.
  * @param message
  *   Warnings about the query.
  * @param nbHits
  *   Number of hits the search query matched.
  * @param nbPages
  *   Number of pages of results for the current query.
  * @param nbSortedHits
  *   Number of hits selected and sorted by the relevant sort algorithm.
  * @param page
  *   Page to retrieve (the first page is `0`, not `1`).
  * @param parsedQuery
  *   Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean)
  *   query string that will be searched.
  * @param processingTimeMS
  *   Time the server took to process the request, in milliseconds.
  * @param processingTimingsMS
  *   Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate
  *   performance issues.
  * @param queryAfterRemoval
  *   Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.
  * @param serverTimeMS
  *   Time the server took to process the request, in milliseconds.
  * @param serverUsed
  *   Host name of the server that processed the request.
  * @param userData
  *   Lets you store custom data in your indices.
  * @param queryID
  *   Unique identifier for the query. This is used for [click
  *   analytics](https://www.algolia.com/doc/guides/analytics/click-analytics/).
  * @param query
  *   Text to search for in an index.
  * @param params
  *   URL-encoded string of all search parameters.
  */
case class SearchResponse(
    abTestID: Option[Int] = scala.None,
    abTestVariantID: Option[Int] = scala.None,
    aroundLatLng: Option[String] = scala.None,
    automaticRadius: Option[String] = scala.None,
    exhaustive: Option[Exhaustive] = scala.None,
    exhaustiveFacetsCount: Option[Boolean] = scala.None,
    exhaustiveNbHits: Option[Boolean] = scala.None,
    exhaustiveTypo: Option[Boolean] = scala.None,
    facets: Option[Map[String, Map[String, Int]]] = scala.None,
    facetsStats: Option[Map[String, FacetsStats]] = scala.None,
    hitsPerPage: Int,
    index: Option[String] = scala.None,
    indexUsed: Option[String] = scala.None,
    message: Option[String] = scala.None,
    nbHits: Int,
    nbPages: Int,
    nbSortedHits: Option[Int] = scala.None,
    page: Int,
    parsedQuery: Option[String] = scala.None,
    processingTimeMS: Int,
    processingTimingsMS: Option[Any] = scala.None,
    queryAfterRemoval: Option[String] = scala.None,
    redirect: Option[Redirect] = scala.None,
    renderingContent: Option[RenderingContent] = scala.None,
    serverTimeMS: Option[Int] = scala.None,
    serverUsed: Option[String] = scala.None,
    userData: Option[Any] = scala.None,
    queryID: Option[String] = scala.None,
    hits: Seq[Hit],
    query: String,
    params: String
) extends SearchResultTrait
