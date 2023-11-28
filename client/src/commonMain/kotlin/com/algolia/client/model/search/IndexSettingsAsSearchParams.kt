/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.algolia.client.model.search

import com.algolia.client.model.search.AdvancedSyntaxFeatures
import com.algolia.client.model.search.AlternativesAsExact
import com.algolia.client.model.search.Distinct
import com.algolia.client.model.search.ExactOnSingleWordQuery
import com.algolia.client.model.search.IgnorePlurals
import com.algolia.client.model.search.Mode
import com.algolia.client.model.search.QueryType
import com.algolia.client.model.search.ReRankingApplyFilter
import com.algolia.client.model.search.RemoveStopWords
import com.algolia.client.model.search.RemoveWordsIfNoResults
import com.algolia.client.model.search.RenderingContent
import com.algolia.client.model.search.SemanticSearch
import com.algolia.client.model.search.TypoTolerance

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * 
 *
 * @param attributesForFaceting Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/) and the [modifiers](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) that can be applied: `filterOnly`, `searchable`, and `afterDistinct`. 
 * @param attributesToRetrieve Attributes to include in the API response. To reduce the size of your response, you can retrieve only some of the attributes. By default, the response includes all attributes.
 * @param ranking Determines the order in which Algolia [returns your results](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/).
 * @param customRanking Specifies the [Custom ranking criterion](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Use the `asc` and `desc` modifiers to specify the ranking order: ascending or descending. 
 * @param relevancyStrictness Relevancy threshold below which less relevant results aren't included in the results.
 * @param attributesToHighlight Attributes to highlight. Strings that match the search query in the attributes are highlighted by surrounding them with HTML tags (`highlightPreTag` and `highlightPostTag`).
 * @param attributesToSnippet Attributes to _snippet_. 'Snippeting' is shortening the attribute to a certain number of words. If not specified, the attribute is shortened to the 10 words around the matching string but you can specify the number. For example: `body:20`. 
 * @param highlightPreTag HTML string to insert before the highlighted parts in all highlight and snippet results.
 * @param highlightPostTag HTML string to insert after the highlighted parts in all highlight and snippet results.
 * @param snippetEllipsisText String used as an ellipsis indicator when a snippet is truncated.
 * @param restrictHighlightAndSnippetArrays Restrict highlighting and snippeting to items that matched the query.
 * @param hitsPerPage Number of hits per page.
 * @param minWordSizefor1Typo Minimum number of characters a word in the query string must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
 * @param minWordSizefor2Typos Minimum number of characters a word in the query string must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
 * @param typoTolerance 
 * @param allowTyposOnNumericTokens Whether to allow typos on numbers (\"numeric tokens\") in the query string.
 * @param disableTypoToleranceOnAttributes Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).
 * @param ignorePlurals 
 * @param removeStopWords 
 * @param keepDiacriticsOnCharacters Characters that the engine shouldn't automatically [normalize](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
 * @param queryLanguages Sets your user's search language. This adjusts language-specific settings and features such as `ignorePlurals`, `removeStopWords`, and [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) word detection.
 * @param decompoundQuery [Splits compound words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words) into their component word parts in the query. 
 * @param enableRules Incidates whether [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/) are enabled.
 * @param enablePersonalization Incidates whether [Personalization](https://www.algolia.com/doc/guides/personalization/what-is-personalization/) is enabled.
 * @param queryType 
 * @param removeWordsIfNoResults 
 * @param mode 
 * @param semanticSearch 
 * @param advancedSyntax Enables the [advanced query syntax](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#advanced-syntax).
 * @param optionalWords Words which should be considered [optional](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words) when found in a query.
 * @param disableExactOnAttributes Attributes for which you want to [turn off the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).
 * @param exactOnSingleWordQuery 
 * @param alternativesAsExact Alternatives that should be considered an exact match by [the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).
 * @param advancedSyntaxFeatures Allows you to specify which advanced syntax features are active when `advancedSyntax` is enabled.
 * @param distinct 
 * @param replaceSynonymsInHighlight Whether to highlight and snippet the original word that matches the synonym or the synonym itself.
 * @param minProximity Precision of the [proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity).
 * @param responseFields Attributes to include in the API response for search and browse queries.
 * @param maxFacetHits Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
 * @param maxValuesPerFacet Maximum number of facet values to return for each facet.
 * @param sortFacetValuesBy Controls how facet values are fetched.
 * @param attributeCriteriaComputedByMinProximity When the [Attribute criterion is ranked above Proximity](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute-and-proximity-combinations) in your ranking formula, Proximity is used to select which searchable attribute is matched in the Attribute ranking stage.
 * @param renderingContent 
 * @param enableReRanking Indicates whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).
 * @param reRankingApplyFilter 
 */
@Serializable

data class IndexSettingsAsSearchParams (

    /* Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/) and the [modifiers](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) that can be applied: `filterOnly`, `searchable`, and `afterDistinct`.  */
    @SerialName(value = "attributesForFaceting") val attributesForFaceting: kotlin.collections.List<String>? = arrayListOf(),

    /* Attributes to include in the API response. To reduce the size of your response, you can retrieve only some of the attributes. By default, the response includes all attributes. */
    @SerialName(value = "attributesToRetrieve") val attributesToRetrieve: kotlin.collections.List<String>? = arrayListOf("*"),

    /* Determines the order in which Algolia [returns your results](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/). */
    @SerialName(value = "ranking") val ranking: kotlin.collections.List<String>? = arrayListOf("typo","geo","words","filters","proximity","attribute","exact","custom"),

    /* Specifies the [Custom ranking criterion](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Use the `asc` and `desc` modifiers to specify the ranking order: ascending or descending.  */
    @SerialName(value = "customRanking") val customRanking: kotlin.collections.List<String>? = arrayListOf(),

    /* Relevancy threshold below which less relevant results aren't included in the results. */
    @SerialName(value = "relevancyStrictness") val relevancyStrictness: Int? = 100,

    /* Attributes to highlight. Strings that match the search query in the attributes are highlighted by surrounding them with HTML tags (`highlightPreTag` and `highlightPostTag`). */
    @SerialName(value = "attributesToHighlight") val attributesToHighlight: kotlin.collections.List<String>? = null,

    /* Attributes to _snippet_. 'Snippeting' is shortening the attribute to a certain number of words. If not specified, the attribute is shortened to the 10 words around the matching string but you can specify the number. For example: `body:20`.  */
    @SerialName(value = "attributesToSnippet") val attributesToSnippet: kotlin.collections.List<String>? = arrayListOf(),

    /* HTML string to insert before the highlighted parts in all highlight and snippet results. */
    @SerialName(value = "highlightPreTag") val highlightPreTag: String? = "<em>",

    /* HTML string to insert after the highlighted parts in all highlight and snippet results. */
    @SerialName(value = "highlightPostTag") val highlightPostTag: String? = "</em>",

    /* String used as an ellipsis indicator when a snippet is truncated. */
    @SerialName(value = "snippetEllipsisText") val snippetEllipsisText: String? = "…",

    /* Restrict highlighting and snippeting to items that matched the query. */
    @SerialName(value = "restrictHighlightAndSnippetArrays") val restrictHighlightAndSnippetArrays: Boolean? = false,

    /* Number of hits per page. */
    @SerialName(value = "hitsPerPage") val hitsPerPage: Int? = 20,

    /* Minimum number of characters a word in the query string must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos). */
    @SerialName(value = "minWordSizefor1Typo") val minWordSizefor1Typo: Int? = 4,

    /* Minimum number of characters a word in the query string must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos). */
    @SerialName(value = "minWordSizefor2Typos") val minWordSizefor2Typos: Int? = 8,

    @SerialName(value = "typoTolerance") val typoTolerance: TypoTolerance? = null,

    /* Whether to allow typos on numbers (\"numeric tokens\") in the query string. */
    @SerialName(value = "allowTyposOnNumericTokens") val allowTyposOnNumericTokens: Boolean? = true,

    /* Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). */
    @SerialName(value = "disableTypoToleranceOnAttributes") val disableTypoToleranceOnAttributes: kotlin.collections.List<String>? = arrayListOf(),

    @SerialName(value = "ignorePlurals") val ignorePlurals: IgnorePlurals? = null,

    @SerialName(value = "removeStopWords") val removeStopWords: RemoveStopWords? = null,

    /* Characters that the engine shouldn't automatically [normalize](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/). */
    @SerialName(value = "keepDiacriticsOnCharacters") val keepDiacriticsOnCharacters: String? = "",

    /* Sets your user's search language. This adjusts language-specific settings and features such as `ignorePlurals`, `removeStopWords`, and [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) word detection. */
    @SerialName(value = "queryLanguages") val queryLanguages: kotlin.collections.List<String>? = arrayListOf(),

    /* [Splits compound words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words) into their component word parts in the query.  */
    @SerialName(value = "decompoundQuery") val decompoundQuery: Boolean? = true,

    /* Incidates whether [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/) are enabled. */
    @SerialName(value = "enableRules") val enableRules: Boolean? = true,

    /* Incidates whether [Personalization](https://www.algolia.com/doc/guides/personalization/what-is-personalization/) is enabled. */
    @SerialName(value = "enablePersonalization") val enablePersonalization: Boolean? = false,

    @SerialName(value = "queryType") val queryType: QueryType? = QueryType.prefixLast,

    @SerialName(value = "removeWordsIfNoResults") val removeWordsIfNoResults: RemoveWordsIfNoResults? = RemoveWordsIfNoResults.none,

    @SerialName(value = "mode") val mode: Mode? = Mode.keywordSearch,

    @SerialName(value = "semanticSearch") val semanticSearch: SemanticSearch? = null,

    /* Enables the [advanced query syntax](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#advanced-syntax). */
    @SerialName(value = "advancedSyntax") val advancedSyntax: Boolean? = false,

    /* Words which should be considered [optional](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words) when found in a query. */
    @SerialName(value = "optionalWords") val optionalWords: kotlin.collections.List<String>? = arrayListOf(),

    /* Attributes for which you want to [turn off the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes). */
    @SerialName(value = "disableExactOnAttributes") val disableExactOnAttributes: kotlin.collections.List<String>? = arrayListOf(),

    @SerialName(value = "exactOnSingleWordQuery") val exactOnSingleWordQuery: ExactOnSingleWordQuery? = ExactOnSingleWordQuery.attribute,

    /* Alternatives that should be considered an exact match by [the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes). */
    @SerialName(value = "alternativesAsExact") val alternativesAsExact: kotlin.collections.List<AlternativesAsExact>? = arrayListOf(null,null),

    /* Allows you to specify which advanced syntax features are active when `advancedSyntax` is enabled. */
    @SerialName(value = "advancedSyntaxFeatures") val advancedSyntaxFeatures: kotlin.collections.List<AdvancedSyntaxFeatures>? = arrayListOf(null,null),

    @SerialName(value = "distinct") val distinct: Distinct? = null,

    /* Whether to highlight and snippet the original word that matches the synonym or the synonym itself. */
    @SerialName(value = "replaceSynonymsInHighlight") val replaceSynonymsInHighlight: Boolean? = false,

    /* Precision of the [proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity). */
    @SerialName(value = "minProximity") val minProximity: Int? = 1,

    /* Attributes to include in the API response for search and browse queries. */
    @SerialName(value = "responseFields") val responseFields: kotlin.collections.List<String>? = arrayListOf(),

    /* Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values). */
    @SerialName(value = "maxFacetHits") val maxFacetHits: Int? = 10,

    /* Maximum number of facet values to return for each facet. */
    @SerialName(value = "maxValuesPerFacet") val maxValuesPerFacet: Int? = 100,

    /* Controls how facet values are fetched. */
    @SerialName(value = "sortFacetValuesBy") val sortFacetValuesBy: String? = "count",

    /* When the [Attribute criterion is ranked above Proximity](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute-and-proximity-combinations) in your ranking formula, Proximity is used to select which searchable attribute is matched in the Attribute ranking stage. */
    @SerialName(value = "attributeCriteriaComputedByMinProximity") val attributeCriteriaComputedByMinProximity: Boolean? = false,

    @SerialName(value = "renderingContent") val renderingContent: RenderingContent? = null,

    /* Indicates whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/). */
    @SerialName(value = "enableReRanking") val enableReRanking: Boolean? = true,

    @SerialName(value = "reRankingApplyFilter") val reRankingApplyFilter: ReRankingApplyFilter? = null

)

