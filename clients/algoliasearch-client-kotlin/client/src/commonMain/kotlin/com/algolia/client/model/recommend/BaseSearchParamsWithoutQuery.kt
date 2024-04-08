/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * BaseSearchParamsWithoutQuery
 *
 * @param similarQuery Keywords to be used instead of the search query to conduct a more broader search.  Using the `similarQuery` parameter changes other settings:  - `queryType` is set to `prefixNone`. - `removeStopWords` is set to true. - `words` is set as the first ranking criterion. - All remaining words are treated as `optionalWords`.  Since the `similarQuery` is supposed to do a broad search, they usually return many results. Combine it with `filters` to narrow down the list of results.
 * @param filters Filter expression to only include items that match the filter criteria in the response.  You can use these filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.   **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at least one element of the array.  For more information, see [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
 * @param facetFilters
 * @param optionalFilters
 * @param numericFilters
 * @param tagFilters
 * @param sumOrFiltersScores Whether to sum all filter scores.  If true, all filter scores are summed. Otherwise, the maximum filter score is kept. For more information, see [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores).
 * @param restrictSearchableAttributes Restricts a search to a subset of your searchable attributes.
 * @param facets Facets for which to retrieve facet values that match the search criteria and the number of matching facet values.  To retrieve all facets, use the wildcard character `*`. For more information, see [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts).
 * @param facetingAfterDistinct Whether faceting should be applied after deduplication with `distinct`.  This leads to accurate facet counts when using faceting in combination with `distinct`. It's usually better to use `afterDistinct` modifiers in the `attributesForFaceting` setting, as `facetingAfterDistinct` only computes correct facet counts if all records have the same facet values for the `attributeForDistinct`.
 * @param page Page of search results to retrieve.
 * @param offset Position of the first hit to retrieve.
 * @param length Number of hits to retrieve (used in combination with `offset`).
 * @param aroundLatLng Coordinates for the center of a circle, expressed as a comma-separated string of latitude and longitude.  Only records included within circle around this central location are included in the results. The radius of the circle is determined by the `aroundRadius` and `minimumAroundRadius` settings. This parameter is ignored if you also specify `insidePolygon` or `insideBoundingBox`.
 * @param aroundLatLngViaIP Whether to obtain the coordinates from the request's IP address.
 * @param aroundRadius
 * @param aroundPrecision
 * @param minimumAroundRadius Minimum radius (in meters) for a search around a location when `aroundRadius` isn't set.
 * @param insideBoundingBox Coordinates for a rectangular area in which to search.  Each bounding box is defined by the two opposite points of its diagonal, and expressed as latitude and longitude pair: `[p1 lat, p1 long, p2 lat, p2 long]`. Provide multiple bounding boxes as nested arrays. For more information, see [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
 * @param insidePolygon Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas). This parameter is ignored, if you also specify `insideBoundingBox`.
 * @param naturalLanguages ISO language codes that adjust settings that are useful for processing natural language queries (as opposed to keyword searches):  - Sets `removeStopWords` and `ignorePlurals` to the list of provided languages. - Sets `removeWordsIfNoResults` to `allOptional`. - Adds a `natural_language` attribute to `ruleContexts` and `analyticsTags`.
 * @param ruleContexts Assigns a rule context to the search query.  [Rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) are strings that you can use to trigger matching rules.
 * @param personalizationImpact Impact that Personalization should have on this search.  The higher this value is, the more Personalization determines the ranking compared to other factors. For more information, see [Understanding Personalization impact](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).
 * @param userToken Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
 * @param getRankingInfo Whether the search response should include detailed ranking information.
 * @param synonyms Whether to take into account an index's synonyms for this search.
 * @param clickAnalytics Whether to include a `queryID` attribute in the response.  The query ID is a unique identifier for a search query and is required for tracking [click and conversion events](https://www.algolia.com/guides/sending-events/getting-started/).
 * @param analytics Whether this search will be included in Analytics.
 * @param analyticsTags Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
 * @param percentileComputation Whether to include this search when calculating processing-time percentiles.
 * @param enableABTest Whether to enable A/B testing for this search.
 */
@Serializable
public data class BaseSearchParamsWithoutQuery(

  /** Keywords to be used instead of the search query to conduct a more broader search.  Using the `similarQuery` parameter changes other settings:  - `queryType` is set to `prefixNone`. - `removeStopWords` is set to true. - `words` is set as the first ranking criterion. - All remaining words are treated as `optionalWords`.  Since the `similarQuery` is supposed to do a broad search, they usually return many results. Combine it with `filters` to narrow down the list of results.  */
  @SerialName(value = "similarQuery") val similarQuery: String? = null,

  /** Filter expression to only include items that match the filter criteria in the response.  You can use these filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.   **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at least one element of the array.  For more information, see [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).  */
  @SerialName(value = "filters") val filters: String? = null,

  @SerialName(value = "facetFilters") val facetFilters: FacetFilters? = null,

  @SerialName(value = "optionalFilters") val optionalFilters: OptionalFilters? = null,

  @SerialName(value = "numericFilters") val numericFilters: NumericFilters? = null,

  @SerialName(value = "tagFilters") val tagFilters: TagFilters? = null,

  /** Whether to sum all filter scores.  If true, all filter scores are summed. Otherwise, the maximum filter score is kept. For more information, see [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores).  */
  @SerialName(value = "sumOrFiltersScores") val sumOrFiltersScores: Boolean? = null,

  /** Restricts a search to a subset of your searchable attributes. */
  @SerialName(value = "restrictSearchableAttributes") val restrictSearchableAttributes: List<String>? = null,

  /** Facets for which to retrieve facet values that match the search criteria and the number of matching facet values.  To retrieve all facets, use the wildcard character `*`. For more information, see [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts).  */
  @SerialName(value = "facets") val facets: List<String>? = null,

  /** Whether faceting should be applied after deduplication with `distinct`.  This leads to accurate facet counts when using faceting in combination with `distinct`. It's usually better to use `afterDistinct` modifiers in the `attributesForFaceting` setting, as `facetingAfterDistinct` only computes correct facet counts if all records have the same facet values for the `attributeForDistinct`.  */
  @SerialName(value = "facetingAfterDistinct") val facetingAfterDistinct: Boolean? = null,

  /** Page of search results to retrieve. */
  @SerialName(value = "page") val page: Int? = null,

  /** Position of the first hit to retrieve. */
  @SerialName(value = "offset") val offset: Int? = null,

  /** Number of hits to retrieve (used in combination with `offset`). */
  @SerialName(value = "length") val length: Int? = null,

  /** Coordinates for the center of a circle, expressed as a comma-separated string of latitude and longitude.  Only records included within circle around this central location are included in the results. The radius of the circle is determined by the `aroundRadius` and `minimumAroundRadius` settings. This parameter is ignored if you also specify `insidePolygon` or `insideBoundingBox`.  */
  @SerialName(value = "aroundLatLng") val aroundLatLng: String? = null,

  /** Whether to obtain the coordinates from the request's IP address. */
  @SerialName(value = "aroundLatLngViaIP") val aroundLatLngViaIP: Boolean? = null,

  @SerialName(value = "aroundRadius") val aroundRadius: AroundRadius? = null,

  @SerialName(value = "aroundPrecision") val aroundPrecision: AroundPrecision? = null,

  /** Minimum radius (in meters) for a search around a location when `aroundRadius` isn't set. */
  @SerialName(value = "minimumAroundRadius") val minimumAroundRadius: Int? = null,

  /** Coordinates for a rectangular area in which to search.  Each bounding box is defined by the two opposite points of its diagonal, and expressed as latitude and longitude pair: `[p1 lat, p1 long, p2 lat, p2 long]`. Provide multiple bounding boxes as nested arrays. For more information, see [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).  */
  @SerialName(value = "insideBoundingBox") val insideBoundingBox: List<List<Double>>? = null,

  /** Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas). This parameter is ignored, if you also specify `insideBoundingBox`.  */
  @SerialName(value = "insidePolygon") val insidePolygon: List<List<Double>>? = null,

  /** ISO language codes that adjust settings that are useful for processing natural language queries (as opposed to keyword searches):  - Sets `removeStopWords` and `ignorePlurals` to the list of provided languages. - Sets `removeWordsIfNoResults` to `allOptional`. - Adds a `natural_language` attribute to `ruleContexts` and `analyticsTags`.  */
  @SerialName(value = "naturalLanguages") val naturalLanguages: List<String>? = null,

  /** Assigns a rule context to the search query.  [Rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) are strings that you can use to trigger matching rules.  */
  @SerialName(value = "ruleContexts") val ruleContexts: List<String>? = null,

  /** Impact that Personalization should have on this search.  The higher this value is, the more Personalization determines the ranking compared to other factors. For more information, see [Understanding Personalization impact](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).  */
  @SerialName(value = "personalizationImpact") val personalizationImpact: Int? = null,

  /** Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).  */
  @SerialName(value = "userToken") val userToken: String? = null,

  /** Whether the search response should include detailed ranking information. */
  @SerialName(value = "getRankingInfo") val getRankingInfo: Boolean? = null,

  /** Whether to take into account an index's synonyms for this search. */
  @SerialName(value = "synonyms") val synonyms: Boolean? = null,

  /** Whether to include a `queryID` attribute in the response.  The query ID is a unique identifier for a search query and is required for tracking [click and conversion events](https://www.algolia.com/guides/sending-events/getting-started/).  */
  @SerialName(value = "clickAnalytics") val clickAnalytics: Boolean? = null,

  /** Whether this search will be included in Analytics. */
  @SerialName(value = "analytics") val analytics: Boolean? = null,

  /** Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/). */
  @SerialName(value = "analyticsTags") val analyticsTags: List<String>? = null,

  /** Whether to include this search when calculating processing-time percentiles. */
  @SerialName(value = "percentileComputation") val percentileComputation: Boolean? = null,

  /** Whether to enable A/B testing for this search. */
  @SerialName(value = "enableABTest") val enableABTest: Boolean? = null,
)
