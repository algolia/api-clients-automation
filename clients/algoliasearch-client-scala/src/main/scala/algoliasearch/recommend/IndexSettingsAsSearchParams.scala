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

import algoliasearch.recommend.AdvancedSyntaxFeatures._
import algoliasearch.recommend.AlternativesAsExact._
import algoliasearch.recommend.ExactOnSingleWordQuery._
import algoliasearch.recommend.Mode._
import algoliasearch.recommend.QueryType._
import algoliasearch.recommend.RemoveWordsIfNoResults._

/** IndexSettingsAsSearchParams
  *
  * @param attributesForFaceting
  *   Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/) and
  *   the [modifiers](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) that
  *   can be applied: `filterOnly`, `searchable`, and `afterDistinct`.
  * @param attributesToRetrieve
  *   Attributes to include in the API response. To reduce the size of your response, you can retrieve only some of the
  *   attributes. By default, the response includes all attributes.
  * @param ranking
  *   Determines the order in which Algolia [returns your
  *   results](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/).
  * @param customRanking
  *   Specifies the [Custom ranking
  *   criterion](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Use the `asc` and `desc`
  *   modifiers to specify the ranking order: ascending or descending.
  * @param relevancyStrictness
  *   Relevancy threshold below which less relevant results aren't included in the results.
  * @param attributesToHighlight
  *   Attributes to highlight. Strings that match the search query in the attributes are highlighted by surrounding them
  *   with HTML tags (`highlightPreTag` and `highlightPostTag`).
  * @param attributesToSnippet
  *   Attributes to _snippet_. 'Snippeting' is shortening the attribute to a certain number of words. If not specified,
  *   the attribute is shortened to the 10 words around the matching string but you can specify the number. For example:
  *   `body:20`.
  * @param highlightPreTag
  *   HTML string to insert before the highlighted parts in all highlight and snippet results.
  * @param highlightPostTag
  *   HTML string to insert after the highlighted parts in all highlight and snippet results.
  * @param snippetEllipsisText
  *   String used as an ellipsis indicator when a snippet is truncated.
  * @param restrictHighlightAndSnippetArrays
  *   Restrict highlighting and snippeting to items that matched the query.
  * @param hitsPerPage
  *   Number of hits per page.
  * @param minWordSizefor1Typo
  *   Minimum number of characters a word in the query string must contain to accept matches with [one
  *   typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
  * @param minWordSizefor2Typos
  *   Minimum number of characters a word in the query string must contain to accept matches with [two
  *   typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
  * @param allowTyposOnNumericTokens
  *   Whether to allow typos on numbers (\"numeric tokens\") in the query string.
  * @param disableTypoToleranceOnAttributes
  *   Attributes for which you want to turn off [typo
  *   tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).
  * @param keepDiacriticsOnCharacters
  *   Characters that the engine shouldn't automatically
  *   [normalize](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
  * @param queryLanguages
  *   Sets your user's search language. This adjusts language-specific settings and features such as `ignorePlurals`,
  *   `removeStopWords`, and
  *   [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk)
  *   word detection.
  * @param decompoundQuery
  *   [Splits compound
  *   words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words)
  *   into their component word parts in the query.
  * @param enableRules
  *   Incidates whether [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/) are enabled.
  * @param enablePersonalization
  *   Incidates whether [Personalization](https://www.algolia.com/doc/guides/personalization/what-is-personalization/)
  *   is enabled.
  * @param advancedSyntax
  *   Enables the [advanced query
  *   syntax](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#advanced-syntax).
  * @param optionalWords
  *   Words which should be considered
  *   [optional](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words)
  *   when found in a query.
  * @param disableExactOnAttributes
  *   Attributes for which you want to [turn off the exact ranking
  *   criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).
  * @param alternativesAsExact
  *   Alternatives that should be considered an exact match by [the exact ranking
  *   criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).
  * @param advancedSyntaxFeatures
  *   Allows you to specify which advanced syntax features are active when `advancedSyntax` is enabled.
  * @param replaceSynonymsInHighlight
  *   Whether to highlight and snippet the original word that matches the synonym or the synonym itself.
  * @param minProximity
  *   Precision of the [proximity ranking
  *   criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity).
  * @param responseFields
  *   Attributes to include in the API response for search and browse queries.
  * @param maxFacetHits
  *   Maximum number of facet hits to return when [searching for facet
  *   values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
  * @param maxValuesPerFacet
  *   Maximum number of facet values to return for each facet.
  * @param sortFacetValuesBy
  *   Controls how facet values are fetched.
  * @param attributeCriteriaComputedByMinProximity
  *   When the [Attribute criterion is ranked above
  *   Proximity](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute-and-proximity-combinations)
  *   in your ranking formula, Proximity is used to select which searchable attribute is matched in the Attribute
  *   ranking stage.
  * @param enableReRanking
  *   Indicates whether this search will use [Dynamic
  *   Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).
  */
case class IndexSettingsAsSearchParams(
    attributesForFaceting: Option[Seq[String]] = scala.None,
    attributesToRetrieve: Option[Seq[String]] = scala.None,
    ranking: Option[Seq[String]] = scala.None,
    customRanking: Option[Seq[String]] = scala.None,
    relevancyStrictness: Option[Int] = scala.None,
    attributesToHighlight: Option[Seq[String]] = scala.None,
    attributesToSnippet: Option[Seq[String]] = scala.None,
    highlightPreTag: Option[String] = scala.None,
    highlightPostTag: Option[String] = scala.None,
    snippetEllipsisText: Option[String] = scala.None,
    restrictHighlightAndSnippetArrays: Option[Boolean] = scala.None,
    hitsPerPage: Option[Int] = scala.None,
    minWordSizefor1Typo: Option[Int] = scala.None,
    minWordSizefor2Typos: Option[Int] = scala.None,
    typoTolerance: Option[TypoTolerance] = scala.None,
    allowTyposOnNumericTokens: Option[Boolean] = scala.None,
    disableTypoToleranceOnAttributes: Option[Seq[String]] = scala.None,
    ignorePlurals: Option[IgnorePlurals] = scala.None,
    removeStopWords: Option[RemoveStopWords] = scala.None,
    keepDiacriticsOnCharacters: Option[String] = scala.None,
    queryLanguages: Option[Seq[String]] = scala.None,
    decompoundQuery: Option[Boolean] = scala.None,
    enableRules: Option[Boolean] = scala.None,
    enablePersonalization: Option[Boolean] = scala.None,
    queryType: Option[QueryType] = scala.None,
    removeWordsIfNoResults: Option[RemoveWordsIfNoResults] = scala.None,
    mode: Option[Mode] = scala.None,
    semanticSearch: Option[SemanticSearch] = scala.None,
    advancedSyntax: Option[Boolean] = scala.None,
    optionalWords: Option[Seq[String]] = scala.None,
    disableExactOnAttributes: Option[Seq[String]] = scala.None,
    exactOnSingleWordQuery: Option[ExactOnSingleWordQuery] = scala.None,
    alternativesAsExact: Option[Seq[AlternativesAsExact]] = scala.None,
    advancedSyntaxFeatures: Option[Seq[AdvancedSyntaxFeatures]] = scala.None,
    distinct: Option[Distinct] = scala.None,
    replaceSynonymsInHighlight: Option[Boolean] = scala.None,
    minProximity: Option[Int] = scala.None,
    responseFields: Option[Seq[String]] = scala.None,
    maxFacetHits: Option[Int] = scala.None,
    maxValuesPerFacet: Option[Int] = scala.None,
    sortFacetValuesBy: Option[String] = scala.None,
    attributeCriteriaComputedByMinProximity: Option[Boolean] = scala.None,
    renderingContent: Option[RenderingContent] = scala.None,
    enableReRanking: Option[Boolean] = scala.None,
    reRankingApplyFilter: Option[ReRankingApplyFilter] = scala.None
)
