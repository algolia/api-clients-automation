/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.composition

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * Params
 *
 * @param query Search query.
 * @param filters Filter expression to only include items that match the filter criteria in the response.  You can use these filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.   **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at least one element of the array.  For more information, see [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
 * @param page Page of search results to retrieve.
 * @param getRankingInfo Whether the search response should include detailed ranking information.
 * @param relevancyStrictness
 * @param facetFilters
 * @param optionalFilters
 * @param numericFilters
 * @param hitsPerPage Number of hits per page.
 * @param aroundLatLng Coordinates for the center of a circle, expressed as a comma-separated string of latitude and longitude.  Only records included within a circle around this central location are included in the results. The radius of the circle is determined by the `aroundRadius` and `minimumAroundRadius` settings. This parameter is ignored if you also specify `insidePolygon` or `insideBoundingBox`.
 * @param aroundLatLngViaIP Whether to obtain the coordinates from the request's IP address.
 * @param aroundRadius
 * @param aroundPrecision
 * @param minimumAroundRadius Minimum radius (in meters) for a search around a location when `aroundRadius` isn't set.
 * @param insideBoundingBox
 * @param insidePolygon Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas). This parameter is ignored if you also specify `insideBoundingBox`.
 * @param queryLanguages Languages for language-specific query processing steps such as plurals, stop-word removal, and word-detection dictionaries.  This setting sets a default list of languages used by the `removeStopWords` and `ignorePlurals` settings. This setting also sets a dictionary for word detection in the logogram-based [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) languages. To support this, you must place the CJK language **first**.  **You should always specify a query language.** If you don't specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
 * @param naturalLanguages ISO language codes that adjust settings that are useful for processing natural language queries (as opposed to keyword searches):  - Sets `removeStopWords` and `ignorePlurals` to the list of provided languages. - Sets `removeWordsIfNoResults` to `allOptional`. - Adds a `natural_language` attribute to `ruleContexts` and `analyticsTags`.
 * @param enableRules Whether to enable rules.
 * @param ruleContexts Assigns a rule context to the search query.  [Rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) are strings that you can use to trigger matching rules.
 * @param userToken Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
 * @param clickAnalytics Whether to include a `queryID` attribute in the response.  The query ID is a unique identifier for a search query and is required for tracking [click and conversion events](https://www.algolia.com/guides/sending-events/getting-started/).
 * @param analytics Whether this search will be included in Analytics.
 * @param analyticsTags Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
 * @param enableABTest Whether to enable A/B testing for this search.
 * @param enableReRanking Whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).  This setting only has an effect if you activated Dynamic Re-Ranking for this index in the Algolia dashboard.
 */
@Serializable
public data class Params(

  /** Search query. */
  @SerialName(value = "query") val query: String? = null,

  /** Filter expression to only include items that match the filter criteria in the response.  You can use these filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.   **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of filters.   **Not supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions (`AND`) with `OR`.   **Not supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at least one element of the array.  For more information, see [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).  */
  @SerialName(value = "filters") val filters: String? = null,

  /** Page of search results to retrieve. */
  @SerialName(value = "page") val page: Int? = null,

  /** Whether the search response should include detailed ranking information. */
  @SerialName(value = "getRankingInfo") val getRankingInfo: Boolean? = null,

  @SerialName(value = "relevancyStrictness") val relevancyStrictness: Int? = null,

  @SerialName(value = "facetFilters") val facetFilters: FacetFilters? = null,

  @SerialName(value = "optionalFilters") val optionalFilters: OptionalFilters? = null,

  @SerialName(value = "numericFilters") val numericFilters: NumericFilters? = null,

  /** Number of hits per page. */
  @SerialName(value = "hitsPerPage") val hitsPerPage: Int? = null,

  /** Coordinates for the center of a circle, expressed as a comma-separated string of latitude and longitude.  Only records included within a circle around this central location are included in the results. The radius of the circle is determined by the `aroundRadius` and `minimumAroundRadius` settings. This parameter is ignored if you also specify `insidePolygon` or `insideBoundingBox`.  */
  @SerialName(value = "aroundLatLng") val aroundLatLng: String? = null,

  /** Whether to obtain the coordinates from the request's IP address. */
  @SerialName(value = "aroundLatLngViaIP") val aroundLatLngViaIP: Boolean? = null,

  @SerialName(value = "aroundRadius") val aroundRadius: AroundRadius? = null,

  @SerialName(value = "aroundPrecision") val aroundPrecision: AroundPrecision? = null,

  /** Minimum radius (in meters) for a search around a location when `aroundRadius` isn't set. */
  @SerialName(value = "minimumAroundRadius") val minimumAroundRadius: Int? = null,

  @SerialName(value = "insideBoundingBox") val insideBoundingBox: InsideBoundingBox? = null,

  /** Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas). This parameter is ignored if you also specify `insideBoundingBox`.  */
  @SerialName(value = "insidePolygon") val insidePolygon: List<List<Double>>? = null,

  /** Languages for language-specific query processing steps such as plurals, stop-word removal, and word-detection dictionaries.  This setting sets a default list of languages used by the `removeStopWords` and `ignorePlurals` settings. This setting also sets a dictionary for word detection in the logogram-based [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) languages. To support this, you must place the CJK language **first**.  **You should always specify a query language.** If you don't specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).  */
  @SerialName(value = "queryLanguages") val queryLanguages: List<SupportedLanguage>? = null,

  /** ISO language codes that adjust settings that are useful for processing natural language queries (as opposed to keyword searches):  - Sets `removeStopWords` and `ignorePlurals` to the list of provided languages. - Sets `removeWordsIfNoResults` to `allOptional`. - Adds a `natural_language` attribute to `ruleContexts` and `analyticsTags`.  */
  @SerialName(value = "naturalLanguages") val naturalLanguages: List<SupportedLanguage>? = null,

  /** Whether to enable rules. */
  @SerialName(value = "enableRules") val enableRules: Boolean? = null,

  /** Assigns a rule context to the search query.  [Rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) are strings that you can use to trigger matching rules.  */
  @SerialName(value = "ruleContexts") val ruleContexts: List<String>? = null,

  /** Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).  */
  @SerialName(value = "userToken") val userToken: String? = null,

  /** Whether to include a `queryID` attribute in the response.  The query ID is a unique identifier for a search query and is required for tracking [click and conversion events](https://www.algolia.com/guides/sending-events/getting-started/).  */
  @SerialName(value = "clickAnalytics") val clickAnalytics: Boolean? = null,

  /** Whether this search will be included in Analytics. */
  @SerialName(value = "analytics") val analytics: Boolean? = null,

  /** Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/). */
  @SerialName(value = "analyticsTags") val analyticsTags: List<String>? = null,

  /** Whether to enable A/B testing for this search. */
  @SerialName(value = "enableABTest") val enableABTest: Boolean? = null,

  /** Whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).  This setting only has an effect if you activated Dynamic Re-Ranking for this index in the Algolia dashboard.  */
  @SerialName(value = "enableReRanking") val enableReRanking: Boolean? = null,
)
