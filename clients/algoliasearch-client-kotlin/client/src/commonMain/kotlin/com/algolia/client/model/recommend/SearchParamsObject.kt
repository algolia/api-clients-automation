/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT. */
package com.algolia.client.model.recommend

import kotlinx.serialization.*
import kotlinx.serialization.json.*

/**
 * SearchParamsObject
 *
 * @param query The text to search in the index.
 * @param similarQuery Overrides the query parameter and performs a more generic search that can be used to find \"similar\" results.
 * @param filters Filter the query with numeric, facet and/or tag filters.
 * @param facetFilters
 * @param optionalFilters
 * @param numericFilters
 * @param tagFilters
 * @param sumOrFiltersScores Determines how to calculate the total score for filtering.
 * @param facets Retrieve facets and their facet values.
 * @param maxValuesPerFacet Maximum number of facet values to return for each facet during a regular search.
 * @param facetingAfterDistinct Force faceting to be applied after de-duplication (via the Distinct setting).
 * @param sortFacetValuesBy Controls how facet values are fetched.
 * @param page Specify the page to retrieve.
 * @param offset Specify the offset of the first hit to return.
 * @param length Set the number of hits to retrieve (used only with offset).
 * @param aroundLatLng Search for entries around a central geolocation, enabling a geo search within a circular area.
 * @param aroundLatLngViaIP Search for entries around a given location automatically computed from the requester's IP address.
 * @param aroundRadius
 * @param aroundPrecision Precision of geo search (in meters), to add grouping by geo location to the ranking formula.
 * @param minimumAroundRadius Minimum radius (in meters) used for a geo search when aroundRadius is not set.
 * @param insideBoundingBox Search inside a rectangular area (in geo coordinates).
 * @param insidePolygon Search inside a polygon (in geo coordinates).
 * @param naturalLanguages This parameter changes the default values of certain parameters and settings that work best for a natural language query, such as ignorePlurals, removeStopWords, removeWordsIfNoResults, analyticsTags and ruleContexts. These parameters and settings work well together when the query is formatted in natural language instead of keywords, for example when your user performs a voice search.
 * @param ruleContexts Enables contextual rules.
 * @param personalizationImpact Define the impact of the Personalization feature.
 * @param userToken Associates a certain user token with the current search.
 * @param getRankingInfo Retrieve detailed ranking information.
 * @param clickAnalytics Enable the Click Analytics feature.
 * @param analytics Whether the current query will be taken into account in the Analytics.
 * @param analyticsTags List of tags to apply to the query for analytics purposes.
 * @param percentileComputation Whether to include or exclude a query from the processing-time percentile computation.
 * @param enableABTest Whether this search should participate in running AB tests.
 * @param enableReRanking Whether this search should use AI Re-Ranking.
 * @param reRankingApplyFilter
 * @param attributesForFaceting The complete list of attributes that will be used for faceting.
 * @param attributesToRetrieve This parameter controls which attributes to retrieve and which not to retrieve.
 * @param restrictSearchableAttributes Restricts a given query to look in only a subset of your searchable attributes.
 * @param ranking Controls how Algolia should sort your results.
 * @param customRanking Specifies the custom ranking criterion.
 * @param relevancyStrictness Controls the relevancy threshold below which less relevant results aren't included in the results.
 * @param attributesToHighlight List of attributes to highlight.
 * @param attributesToSnippet List of attributes to snippet, with an optional maximum number of words to snippet.
 * @param highlightPreTag The HTML string to insert before the highlighted parts in all highlight and snippet results.
 * @param highlightPostTag The HTML string to insert after the highlighted parts in all highlight and snippet results.
 * @param snippetEllipsisText String used as an ellipsis indicator when a snippet is truncated.
 * @param restrictHighlightAndSnippetArrays Restrict highlighting and snippeting to items that matched the query.
 * @param hitsPerPage Set the number of hits per page.
 * @param minWordSizefor1Typo Minimum number of characters a word in the query string must contain to accept matches with 1 typo.
 * @param minWordSizefor2Typos Minimum number of characters a word in the query string must contain to accept matches with 2 typos.
 * @param typoTolerance
 * @param allowTyposOnNumericTokens Whether to allow typos on numbers (\"numeric tokens\") in the query string.
 * @param disableTypoToleranceOnAttributes List of attributes on which you want to disable typo tolerance.
 * @param ignorePlurals
 * @param removeStopWords
 * @param keepDiacriticsOnCharacters List of characters that the engine shouldn't automatically normalize.
 * @param queryLanguages Sets the languages to be used by language-specific settings and functionalities such as ignorePlurals, removeStopWords, and CJK word-detection.
 * @param decompoundQuery Splits compound words into their composing atoms in the query.
 * @param enableRules Whether Rules should be globally enabled.
 * @param enablePersonalization Enable the Personalization feature.
 * @param queryType
 * @param removeWordsIfNoResults
 * @param mode
 * @param semanticSearch
 * @param advancedSyntax Enables the advanced query syntax.
 * @param optionalWords A list of words that should be considered as optional when found in the query.
 * @param disableExactOnAttributes List of attributes on which you want to disable the exact ranking criterion.
 * @param exactOnSingleWordQuery
 * @param alternativesAsExact List of alternatives that should be considered an exact match by the exact ranking criterion.
 * @param advancedSyntaxFeatures Allows you to specify which advanced syntax features are active when ‘advancedSyntax' is enabled.
 * @param explain Enriches the API’s response with meta-information as to how the query was processed.
 * @param distinct
 * @param attributeForDistinct Name of the de-duplication attribute to be used with the distinct feature.
 * @param synonyms Whether to take into account an index's synonyms for a particular search.
 * @param replaceSynonymsInHighlight Whether to highlight and snippet the original word that matches the synonym or the synonym itself.
 * @param minProximity Precision of the proximity ranking criterion.
 * @param responseFields Choose which fields to return in the API response. This parameters applies to search and browse queries.
 * @param maxFacetHits Maximum number of facet hits to return during a search for facet values. For performance reasons, the maximum allowed number of returned values is 100.
 * @param attributeCriteriaComputedByMinProximity When attribute is ranked above proximity in your ranking formula, proximity is used to select which searchable attribute is matched in the attribute ranking stage.
 * @param renderingContent
 */
@Serializable
public data class SearchParamsObject(

  /** The text to search in the index. */
  @SerialName(value = "query") val query: String? = null,

  /** Overrides the query parameter and performs a more generic search that can be used to find \"similar\" results. */
  @SerialName(value = "similarQuery") val similarQuery: String? = null,

  /** Filter the query with numeric, facet and/or tag filters. */
  @SerialName(value = "filters") val filters: String? = null,

  @SerialName(value = "facetFilters") val facetFilters: FacetFilters? = null,

  @SerialName(value = "optionalFilters") val optionalFilters: OptionalFilters? = null,

  @SerialName(value = "numericFilters") val numericFilters: NumericFilters? = null,

  @SerialName(value = "tagFilters") val tagFilters: TagFilters? = null,

  /** Determines how to calculate the total score for filtering. */
  @SerialName(value = "sumOrFiltersScores") val sumOrFiltersScores: Boolean? = null,

  /** Retrieve facets and their facet values. */
  @SerialName(value = "facets") val facets: List<String>? = null,

  /** Maximum number of facet values to return for each facet during a regular search. */
  @SerialName(value = "maxValuesPerFacet") val maxValuesPerFacet: Int? = null,

  /** Force faceting to be applied after de-duplication (via the Distinct setting). */
  @SerialName(value = "facetingAfterDistinct") val facetingAfterDistinct: Boolean? = null,

  /** Controls how facet values are fetched. */
  @SerialName(value = "sortFacetValuesBy") val sortFacetValuesBy: String? = null,

  /** Specify the page to retrieve. */
  @SerialName(value = "page") val page: Int? = null,

  /** Specify the offset of the first hit to return. */
  @SerialName(value = "offset") val offset: Int? = null,

  /** Set the number of hits to retrieve (used only with offset). */
  @SerialName(value = "length") val length: Int? = null,

  /** Search for entries around a central geolocation, enabling a geo search within a circular area. */
  @SerialName(value = "aroundLatLng") val aroundLatLng: String? = null,

  /** Search for entries around a given location automatically computed from the requester's IP address. */
  @SerialName(value = "aroundLatLngViaIP") val aroundLatLngViaIP: Boolean? = null,

  @SerialName(value = "aroundRadius") val aroundRadius: AroundRadius? = null,

  /** Precision of geo search (in meters), to add grouping by geo location to the ranking formula. */
  @SerialName(value = "aroundPrecision") val aroundPrecision: Int? = null,

  /** Minimum radius (in meters) used for a geo search when aroundRadius is not set. */
  @SerialName(value = "minimumAroundRadius") val minimumAroundRadius: Int? = null,

  /** Search inside a rectangular area (in geo coordinates). */
  @SerialName(value = "insideBoundingBox") val insideBoundingBox: List<Double>? = null,

  /** Search inside a polygon (in geo coordinates). */
  @SerialName(value = "insidePolygon") val insidePolygon: List<Double>? = null,

  /** This parameter changes the default values of certain parameters and settings that work best for a natural language query, such as ignorePlurals, removeStopWords, removeWordsIfNoResults, analyticsTags and ruleContexts. These parameters and settings work well together when the query is formatted in natural language instead of keywords, for example when your user performs a voice search. */
  @SerialName(value = "naturalLanguages") val naturalLanguages: List<String>? = null,

  /** Enables contextual rules. */
  @SerialName(value = "ruleContexts") val ruleContexts: List<String>? = null,

  /** Define the impact of the Personalization feature. */
  @SerialName(value = "personalizationImpact") val personalizationImpact: Int? = null,

  /** Associates a certain user token with the current search. */
  @SerialName(value = "userToken") val userToken: String? = null,

  /** Retrieve detailed ranking information. */
  @SerialName(value = "getRankingInfo") val getRankingInfo: Boolean? = null,

  /** Enable the Click Analytics feature. */
  @SerialName(value = "clickAnalytics") val clickAnalytics: Boolean? = null,

  /** Whether the current query will be taken into account in the Analytics. */
  @SerialName(value = "analytics") val analytics: Boolean? = null,

  /** List of tags to apply to the query for analytics purposes. */
  @SerialName(value = "analyticsTags") val analyticsTags: List<String>? = null,

  /** Whether to include or exclude a query from the processing-time percentile computation. */
  @SerialName(value = "percentileComputation") val percentileComputation: Boolean? = null,

  /** Whether this search should participate in running AB tests. */
  @SerialName(value = "enableABTest") val enableABTest: Boolean? = null,

  /** Whether this search should use AI Re-Ranking. */
  @SerialName(value = "enableReRanking") val enableReRanking: Boolean? = null,

  @SerialName(value = "reRankingApplyFilter") val reRankingApplyFilter: ReRankingApplyFilter? = null,

  /** The complete list of attributes that will be used for faceting. */
  @SerialName(value = "attributesForFaceting") val attributesForFaceting: List<String>? = null,

  /** This parameter controls which attributes to retrieve and which not to retrieve. */
  @SerialName(value = "attributesToRetrieve") val attributesToRetrieve: List<String>? = null,

  /** Restricts a given query to look in only a subset of your searchable attributes. */
  @SerialName(value = "restrictSearchableAttributes") val restrictSearchableAttributes: List<String>? = null,

  /** Controls how Algolia should sort your results. */
  @SerialName(value = "ranking") val ranking: List<String>? = null,

  /** Specifies the custom ranking criterion. */
  @SerialName(value = "customRanking") val customRanking: List<String>? = null,

  /** Controls the relevancy threshold below which less relevant results aren't included in the results. */
  @SerialName(value = "relevancyStrictness") val relevancyStrictness: Int? = null,

  /** List of attributes to highlight. */
  @SerialName(value = "attributesToHighlight") val attributesToHighlight: List<String>? = null,

  /** List of attributes to snippet, with an optional maximum number of words to snippet. */
  @SerialName(value = "attributesToSnippet") val attributesToSnippet: List<String>? = null,

  /** The HTML string to insert before the highlighted parts in all highlight and snippet results. */
  @SerialName(value = "highlightPreTag") val highlightPreTag: String? = null,

  /** The HTML string to insert after the highlighted parts in all highlight and snippet results. */
  @SerialName(value = "highlightPostTag") val highlightPostTag: String? = null,

  /** String used as an ellipsis indicator when a snippet is truncated. */
  @SerialName(value = "snippetEllipsisText") val snippetEllipsisText: String? = null,

  /** Restrict highlighting and snippeting to items that matched the query. */
  @SerialName(value = "restrictHighlightAndSnippetArrays") val restrictHighlightAndSnippetArrays: Boolean? = null,

  /** Set the number of hits per page. */
  @SerialName(value = "hitsPerPage") val hitsPerPage: Int? = null,

  /** Minimum number of characters a word in the query string must contain to accept matches with 1 typo. */
  @SerialName(value = "minWordSizefor1Typo") val minWordSizefor1Typo: Int? = null,

  /** Minimum number of characters a word in the query string must contain to accept matches with 2 typos. */
  @SerialName(value = "minWordSizefor2Typos") val minWordSizefor2Typos: Int? = null,

  @SerialName(value = "typoTolerance") val typoTolerance: TypoTolerance? = null,

  /** Whether to allow typos on numbers (\"numeric tokens\") in the query string. */
  @SerialName(value = "allowTyposOnNumericTokens") val allowTyposOnNumericTokens: Boolean? = null,

  /** List of attributes on which you want to disable typo tolerance. */
  @SerialName(value = "disableTypoToleranceOnAttributes") val disableTypoToleranceOnAttributes: List<String>? = null,

  @SerialName(value = "ignorePlurals") val ignorePlurals: IgnorePlurals? = null,

  @SerialName(value = "removeStopWords") val removeStopWords: RemoveStopWords? = null,

  /** List of characters that the engine shouldn't automatically normalize. */
  @SerialName(value = "keepDiacriticsOnCharacters") val keepDiacriticsOnCharacters: String? = null,

  /** Sets the languages to be used by language-specific settings and functionalities such as ignorePlurals, removeStopWords, and CJK word-detection. */
  @SerialName(value = "queryLanguages") val queryLanguages: List<String>? = null,

  /** Splits compound words into their composing atoms in the query. */
  @SerialName(value = "decompoundQuery") val decompoundQuery: Boolean? = null,

  /** Whether Rules should be globally enabled. */
  @SerialName(value = "enableRules") val enableRules: Boolean? = null,

  /** Enable the Personalization feature. */
  @SerialName(value = "enablePersonalization") val enablePersonalization: Boolean? = null,

  @SerialName(value = "queryType") val queryType: QueryType? = null,

  @SerialName(value = "removeWordsIfNoResults") val removeWordsIfNoResults: RemoveWordsIfNoResults? = null,

  @SerialName(value = "mode") val mode: Mode? = null,

  @SerialName(value = "semanticSearch") val semanticSearch: IndexSettingsAsSearchParamsSemanticSearch? = null,

  /** Enables the advanced query syntax. */
  @SerialName(value = "advancedSyntax") val advancedSyntax: Boolean? = null,

  /** A list of words that should be considered as optional when found in the query. */
  @SerialName(value = "optionalWords") val optionalWords: List<String>? = null,

  /** List of attributes on which you want to disable the exact ranking criterion. */
  @SerialName(value = "disableExactOnAttributes") val disableExactOnAttributes: List<String>? = null,

  @SerialName(value = "exactOnSingleWordQuery") val exactOnSingleWordQuery: ExactOnSingleWordQuery? = null,

  /** List of alternatives that should be considered an exact match by the exact ranking criterion. */
  @SerialName(value = "alternativesAsExact") val alternativesAsExact: List<AlternativesAsExact>? = null,

  /** Allows you to specify which advanced syntax features are active when ‘advancedSyntax' is enabled. */
  @SerialName(value = "advancedSyntaxFeatures") val advancedSyntaxFeatures: List<AdvancedSyntaxFeatures>? = null,

  /** Enriches the API’s response with meta-information as to how the query was processed. */
  @SerialName(value = "explain") val explain: List<String>? = null,

  @SerialName(value = "distinct") val distinct: Distinct? = null,

  /** Name of the de-duplication attribute to be used with the distinct feature. */
  @SerialName(value = "attributeForDistinct") val attributeForDistinct: String? = null,

  /** Whether to take into account an index's synonyms for a particular search. */
  @SerialName(value = "synonyms") val synonyms: Boolean? = null,

  /** Whether to highlight and snippet the original word that matches the synonym or the synonym itself. */
  @SerialName(value = "replaceSynonymsInHighlight") val replaceSynonymsInHighlight: Boolean? = null,

  /** Precision of the proximity ranking criterion. */
  @SerialName(value = "minProximity") val minProximity: Int? = null,

  /** Choose which fields to return in the API response. This parameters applies to search and browse queries. */
  @SerialName(value = "responseFields") val responseFields: List<String>? = null,

  /** Maximum number of facet hits to return during a search for facet values. For performance reasons, the maximum allowed number of returned values is 100. */
  @SerialName(value = "maxFacetHits") val maxFacetHits: Int? = null,

  /** When attribute is ranked above proximity in your ranking formula, proximity is used to select which searchable attribute is matched in the attribute ranking stage. */
  @SerialName(value = "attributeCriteriaComputedByMinProximity") val attributeCriteriaComputedByMinProximity: Boolean? = null,

  @SerialName(value = "renderingContent") val renderingContent: RenderingContent? = null,
)
