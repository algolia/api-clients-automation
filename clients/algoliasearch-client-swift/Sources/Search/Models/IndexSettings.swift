// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import Core
import Foundation

#if canImport(AnyCodable)
  import AnyCodable
#endif

/// Algolia index settings.
public struct IndexSettings: Codable, JSONEncodable, Hashable {

  static let hitsPerPageRule = NumericRule<Int>(
    minimum: 1, exclusiveMinimum: false, maximum: 1000, exclusiveMaximum: false, multipleOf: nil)
  static let minProximityRule = NumericRule<Int>(
    minimum: 1, exclusiveMinimum: false, maximum: 7, exclusiveMaximum: false, multipleOf: nil)
  static let maxFacetHitsRule = NumericRule<Int>(
    minimum: nil, exclusiveMinimum: false, maximum: 100, exclusiveMaximum: false, multipleOf: nil)
  /** Creates [replicas](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/), which are copies of a primary index with the same records but different settings. */
  public var replicas: [String]?
  /** Maximum number of hits accessible through pagination. */
  public var paginationLimitedTo: Int?
  /** Attributes that can't be retrieved at query time. */
  public var unretrievableAttributes: [String]?
  /** Words for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). */
  public var disableTypoToleranceOnWords: [String]?
  /** Attributes in your index to which [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead) applies. This will ensure that words indexed in Katakana or Kanji can also be searched in Hiragana. */
  public var attributesToTransliterate: [String]?
  /** Attributes on which to split [camel case](https://wikipedia.org/wiki/Camel_case) words. */
  public var camelCaseAttributes: [String]?
  /** Attributes in your index to which [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding) applies. */
  public var decompoundedAttributes: AnyCodable?
  /** Set the languages of your index, for language-specific processing steps such as [tokenization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/tokenization/) and [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/). */
  public var indexLanguages: [String]?
  /** Attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search). */
  public var disablePrefixOnAttributes: [String]?
  /** Incidates whether the engine compresses arrays with exclusively non-negative integers. When enabled, the compressed arrays may be reordered.  */
  public var allowCompressionOfIntegerArray: Bool?
  /** Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters). */
  public var numericAttributesForFiltering: [String]?
  /** Controls which separators are added to an Algolia index as part of [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean). Separators are all non-letter characters except spaces and currency characters, such as $€£¥. */
  public var separatorsToIndex: String?
  /** [Attributes used for searching](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/), including determining [if matches at the beginning of a word are important (ordered) or not (unordered)](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/how-to/configuring-searchable-attributes-the-right-way/#understanding-word-position).  */
  public var searchableAttributes: [String]?
  /** Lets you store custom data in your indices. */
  public var userData: AnyCodable?
  /** A list of characters and their normalized replacements to override Algolia's default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/). */
  public var customNormalization: [String: [String: String]]?
  /** Name of the deduplication attribute to be used with Algolia's [_distinct_ feature](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/#introducing-algolias-distinct-feature). */
  public var attributeForDistinct: String?
  /** Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/) and the [modifiers](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) that can be applied: `filterOnly`, `searchable`, and `afterDistinct`.  */
  public var attributesForFaceting: [String]?
  /** Attributes to include in the API response. To reduce the size of your response, you can retrieve only some of the attributes. By default, the response includes all attributes. */
  public var attributesToRetrieve: [String]?
  /** Determines the order in which Algolia [returns your results](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/). */
  public var ranking: [String]?
  /** Specifies the [Custom ranking criterion](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Use the `asc` and `desc` modifiers to specify the ranking order: ascending or descending.  */
  public var customRanking: [String]?
  /** Relevancy threshold below which less relevant results aren't included in the results. */
  public var relevancyStrictness: Int?
  /** Attributes to highlight. Strings that match the search query in the attributes are highlighted by surrounding them with HTML tags (`highlightPreTag` and `highlightPostTag`). */
  public var attributesToHighlight: [String]?
  /** Attributes to _snippet_. 'Snippeting' is shortening the attribute to a certain number of words. If not specified, the attribute is shortened to the 10 words around the matching string but you can specify the number. For example: `body:20`.  */
  public var attributesToSnippet: [String]?
  /** HTML string to insert before the highlighted parts in all highlight and snippet results. */
  public var highlightPreTag: String?
  /** HTML string to insert after the highlighted parts in all highlight and snippet results. */
  public var highlightPostTag: String?
  /** String used as an ellipsis indicator when a snippet is truncated. */
  public var snippetEllipsisText: String?
  /** Restrict highlighting and snippeting to items that matched the query. */
  public var restrictHighlightAndSnippetArrays: Bool?
  /** Number of hits per page. */
  public var hitsPerPage: Int?
  /** Minimum number of characters a word in the query string must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos). */
  public var minWordSizefor1Typo: Int?
  /** Minimum number of characters a word in the query string must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos). */
  public var minWordSizefor2Typos: Int?
  public var typoTolerance: TypoTolerance?
  /** Whether to allow typos on numbers (\"numeric tokens\") in the query string. */
  public var allowTyposOnNumericTokens: Bool?
  /** Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). */
  public var disableTypoToleranceOnAttributes: [String]?
  public var ignorePlurals: IgnorePlurals?
  public var removeStopWords: RemoveStopWords?
  /** Characters that the engine shouldn't automatically [normalize](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/). */
  public var keepDiacriticsOnCharacters: String?
  /** Sets your user's search language. This adjusts language-specific settings and features such as `ignorePlurals`, `removeStopWords`, and [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) word detection. */
  public var queryLanguages: [String]?
  /** [Splits compound words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words) into their component word parts in the query.  */
  public var decompoundQuery: Bool?
  /** Incidates whether [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/) are enabled. */
  public var enableRules: Bool?
  /** Incidates whether [Personalization](https://www.algolia.com/doc/guides/personalization/what-is-personalization/) is enabled. */
  public var enablePersonalization: Bool?
  public var queryType: QueryType?
  public var removeWordsIfNoResults: RemoveWordsIfNoResults?
  public var mode: Mode?
  public var semanticSearch: SemanticSearch?
  /** Enables the [advanced query syntax](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#advanced-syntax). */
  public var advancedSyntax: Bool?
  /** Words which should be considered [optional](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words) when found in a query. */
  public var optionalWords: [String]?
  /** Attributes for which you want to [turn off the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes). */
  public var disableExactOnAttributes: [String]?
  public var exactOnSingleWordQuery: ExactOnSingleWordQuery?
  /** Alternatives that should be considered an exact match by [the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes). */
  public var alternativesAsExact: [AlternativesAsExact]?
  /** Allows you to specify which advanced syntax features are active when `advancedSyntax` is enabled. */
  public var advancedSyntaxFeatures: [AdvancedSyntaxFeatures]?
  public var distinct: Distinct?
  /** Whether to highlight and snippet the original word that matches the synonym or the synonym itself. */
  public var replaceSynonymsInHighlight: Bool?
  /** Precision of the [proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity). */
  public var minProximity: Int?
  /** Attributes to include in the API response for search and browse queries. */
  public var responseFields: [String]?
  /** Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values). */
  public var maxFacetHits: Int?
  /** Maximum number of facet values to return for each facet. */
  public var maxValuesPerFacet: Int?
  /** Controls how facet values are fetched. */
  public var sortFacetValuesBy: String?
  /** When the [Attribute criterion is ranked above Proximity](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute-and-proximity-combinations) in your ranking formula, Proximity is used to select which searchable attribute is matched in the Attribute ranking stage. */
  public var attributeCriteriaComputedByMinProximity: Bool?
  public var renderingContent: RenderingContent?
  /** Indicates whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/). */
  public var enableReRanking: Bool?
  public var reRankingApplyFilter: ReRankingApplyFilter?

  public init(
    replicas: [String]? = nil, paginationLimitedTo: Int? = nil,
    unretrievableAttributes: [String]? = nil, disableTypoToleranceOnWords: [String]? = nil,
    attributesToTransliterate: [String]? = nil, camelCaseAttributes: [String]? = nil,
    decompoundedAttributes: AnyCodable? = nil, indexLanguages: [String]? = nil,
    disablePrefixOnAttributes: [String]? = nil, allowCompressionOfIntegerArray: Bool? = nil,
    numericAttributesForFiltering: [String]? = nil, separatorsToIndex: String? = nil,
    searchableAttributes: [String]? = nil, userData: AnyCodable? = nil,
    customNormalization: [String: [String: String]]? = nil, attributeForDistinct: String? = nil,
    attributesForFaceting: [String]? = nil, attributesToRetrieve: [String]? = nil,
    ranking: [String]? = nil, customRanking: [String]? = nil, relevancyStrictness: Int? = nil,
    attributesToHighlight: [String]? = nil, attributesToSnippet: [String]? = nil,
    highlightPreTag: String? = nil, highlightPostTag: String? = nil,
    snippetEllipsisText: String? = nil, restrictHighlightAndSnippetArrays: Bool? = nil,
    hitsPerPage: Int? = nil, minWordSizefor1Typo: Int? = nil, minWordSizefor2Typos: Int? = nil,
    typoTolerance: TypoTolerance? = nil, allowTyposOnNumericTokens: Bool? = nil,
    disableTypoToleranceOnAttributes: [String]? = nil, ignorePlurals: IgnorePlurals? = nil,
    removeStopWords: RemoveStopWords? = nil, keepDiacriticsOnCharacters: String? = nil,
    queryLanguages: [String]? = nil, decompoundQuery: Bool? = nil, enableRules: Bool? = nil,
    enablePersonalization: Bool? = nil, queryType: QueryType? = nil,
    removeWordsIfNoResults: RemoveWordsIfNoResults? = nil, mode: Mode? = nil,
    semanticSearch: SemanticSearch? = nil, advancedSyntax: Bool? = nil,
    optionalWords: [String]? = nil, disableExactOnAttributes: [String]? = nil,
    exactOnSingleWordQuery: ExactOnSingleWordQuery? = nil,
    alternativesAsExact: [AlternativesAsExact]? = nil,
    advancedSyntaxFeatures: [AdvancedSyntaxFeatures]? = nil, distinct: Distinct? = nil,
    replaceSynonymsInHighlight: Bool? = nil, minProximity: Int? = nil,
    responseFields: [String]? = nil, maxFacetHits: Int? = nil, maxValuesPerFacet: Int? = nil,
    sortFacetValuesBy: String? = nil, attributeCriteriaComputedByMinProximity: Bool? = nil,
    renderingContent: RenderingContent? = nil, enableReRanking: Bool? = nil,
    reRankingApplyFilter: ReRankingApplyFilter? = nil
  ) {
    self.replicas = replicas
    self.paginationLimitedTo = paginationLimitedTo
    self.unretrievableAttributes = unretrievableAttributes
    self.disableTypoToleranceOnWords = disableTypoToleranceOnWords
    self.attributesToTransliterate = attributesToTransliterate
    self.camelCaseAttributes = camelCaseAttributes
    self.decompoundedAttributes = decompoundedAttributes
    self.indexLanguages = indexLanguages
    self.disablePrefixOnAttributes = disablePrefixOnAttributes
    self.allowCompressionOfIntegerArray = allowCompressionOfIntegerArray
    self.numericAttributesForFiltering = numericAttributesForFiltering
    self.separatorsToIndex = separatorsToIndex
    self.searchableAttributes = searchableAttributes
    self.userData = userData
    self.customNormalization = customNormalization
    self.attributeForDistinct = attributeForDistinct
    self.attributesForFaceting = attributesForFaceting
    self.attributesToRetrieve = attributesToRetrieve
    self.ranking = ranking
    self.customRanking = customRanking
    self.relevancyStrictness = relevancyStrictness
    self.attributesToHighlight = attributesToHighlight
    self.attributesToSnippet = attributesToSnippet
    self.highlightPreTag = highlightPreTag
    self.highlightPostTag = highlightPostTag
    self.snippetEllipsisText = snippetEllipsisText
    self.restrictHighlightAndSnippetArrays = restrictHighlightAndSnippetArrays
    self.hitsPerPage = hitsPerPage
    self.minWordSizefor1Typo = minWordSizefor1Typo
    self.minWordSizefor2Typos = minWordSizefor2Typos
    self.typoTolerance = typoTolerance
    self.allowTyposOnNumericTokens = allowTyposOnNumericTokens
    self.disableTypoToleranceOnAttributes = disableTypoToleranceOnAttributes
    self.ignorePlurals = ignorePlurals
    self.removeStopWords = removeStopWords
    self.keepDiacriticsOnCharacters = keepDiacriticsOnCharacters
    self.queryLanguages = queryLanguages
    self.decompoundQuery = decompoundQuery
    self.enableRules = enableRules
    self.enablePersonalization = enablePersonalization
    self.queryType = queryType
    self.removeWordsIfNoResults = removeWordsIfNoResults
    self.mode = mode
    self.semanticSearch = semanticSearch
    self.advancedSyntax = advancedSyntax
    self.optionalWords = optionalWords
    self.disableExactOnAttributes = disableExactOnAttributes
    self.exactOnSingleWordQuery = exactOnSingleWordQuery
    self.alternativesAsExact = alternativesAsExact
    self.advancedSyntaxFeatures = advancedSyntaxFeatures
    self.distinct = distinct
    self.replaceSynonymsInHighlight = replaceSynonymsInHighlight
    self.minProximity = minProximity
    self.responseFields = responseFields
    self.maxFacetHits = maxFacetHits
    self.maxValuesPerFacet = maxValuesPerFacet
    self.sortFacetValuesBy = sortFacetValuesBy
    self.attributeCriteriaComputedByMinProximity = attributeCriteriaComputedByMinProximity
    self.renderingContent = renderingContent
    self.enableReRanking = enableReRanking
    self.reRankingApplyFilter = reRankingApplyFilter
  }

  public enum CodingKeys: String, CodingKey, CaseIterable {
    case replicas
    case paginationLimitedTo
    case unretrievableAttributes
    case disableTypoToleranceOnWords
    case attributesToTransliterate
    case camelCaseAttributes
    case decompoundedAttributes
    case indexLanguages
    case disablePrefixOnAttributes
    case allowCompressionOfIntegerArray
    case numericAttributesForFiltering
    case separatorsToIndex
    case searchableAttributes
    case userData
    case customNormalization
    case attributeForDistinct
    case attributesForFaceting
    case attributesToRetrieve
    case ranking
    case customRanking
    case relevancyStrictness
    case attributesToHighlight
    case attributesToSnippet
    case highlightPreTag
    case highlightPostTag
    case snippetEllipsisText
    case restrictHighlightAndSnippetArrays
    case hitsPerPage
    case minWordSizefor1Typo
    case minWordSizefor2Typos
    case typoTolerance
    case allowTyposOnNumericTokens
    case disableTypoToleranceOnAttributes
    case ignorePlurals
    case removeStopWords
    case keepDiacriticsOnCharacters
    case queryLanguages
    case decompoundQuery
    case enableRules
    case enablePersonalization
    case queryType
    case removeWordsIfNoResults
    case mode
    case semanticSearch
    case advancedSyntax
    case optionalWords
    case disableExactOnAttributes
    case exactOnSingleWordQuery
    case alternativesAsExact
    case advancedSyntaxFeatures
    case distinct
    case replaceSynonymsInHighlight
    case minProximity
    case responseFields
    case maxFacetHits
    case maxValuesPerFacet
    case sortFacetValuesBy
    case attributeCriteriaComputedByMinProximity
    case renderingContent
    case enableReRanking
    case reRankingApplyFilter
  }

  // Encodable protocol methods

  public func encode(to encoder: Encoder) throws {
    var container = encoder.container(keyedBy: CodingKeys.self)
    try container.encodeIfPresent(replicas, forKey: .replicas)
    try container.encodeIfPresent(paginationLimitedTo, forKey: .paginationLimitedTo)
    try container.encodeIfPresent(unretrievableAttributes, forKey: .unretrievableAttributes)
    try container.encodeIfPresent(disableTypoToleranceOnWords, forKey: .disableTypoToleranceOnWords)
    try container.encodeIfPresent(attributesToTransliterate, forKey: .attributesToTransliterate)
    try container.encodeIfPresent(camelCaseAttributes, forKey: .camelCaseAttributes)
    try container.encodeIfPresent(decompoundedAttributes, forKey: .decompoundedAttributes)
    try container.encodeIfPresent(indexLanguages, forKey: .indexLanguages)
    try container.encodeIfPresent(disablePrefixOnAttributes, forKey: .disablePrefixOnAttributes)
    try container.encodeIfPresent(
      allowCompressionOfIntegerArray, forKey: .allowCompressionOfIntegerArray)
    try container.encodeIfPresent(
      numericAttributesForFiltering, forKey: .numericAttributesForFiltering)
    try container.encodeIfPresent(separatorsToIndex, forKey: .separatorsToIndex)
    try container.encodeIfPresent(searchableAttributes, forKey: .searchableAttributes)
    try container.encodeIfPresent(userData, forKey: .userData)
    try container.encodeIfPresent(customNormalization, forKey: .customNormalization)
    try container.encodeIfPresent(attributeForDistinct, forKey: .attributeForDistinct)
    try container.encodeIfPresent(attributesForFaceting, forKey: .attributesForFaceting)
    try container.encodeIfPresent(attributesToRetrieve, forKey: .attributesToRetrieve)
    try container.encodeIfPresent(ranking, forKey: .ranking)
    try container.encodeIfPresent(customRanking, forKey: .customRanking)
    try container.encodeIfPresent(relevancyStrictness, forKey: .relevancyStrictness)
    try container.encodeIfPresent(attributesToHighlight, forKey: .attributesToHighlight)
    try container.encodeIfPresent(attributesToSnippet, forKey: .attributesToSnippet)
    try container.encodeIfPresent(highlightPreTag, forKey: .highlightPreTag)
    try container.encodeIfPresent(highlightPostTag, forKey: .highlightPostTag)
    try container.encodeIfPresent(snippetEllipsisText, forKey: .snippetEllipsisText)
    try container.encodeIfPresent(
      restrictHighlightAndSnippetArrays, forKey: .restrictHighlightAndSnippetArrays)
    try container.encodeIfPresent(hitsPerPage, forKey: .hitsPerPage)
    try container.encodeIfPresent(minWordSizefor1Typo, forKey: .minWordSizefor1Typo)
    try container.encodeIfPresent(minWordSizefor2Typos, forKey: .minWordSizefor2Typos)
    try container.encodeIfPresent(typoTolerance, forKey: .typoTolerance)
    try container.encodeIfPresent(allowTyposOnNumericTokens, forKey: .allowTyposOnNumericTokens)
    try container.encodeIfPresent(
      disableTypoToleranceOnAttributes, forKey: .disableTypoToleranceOnAttributes)
    try container.encodeIfPresent(ignorePlurals, forKey: .ignorePlurals)
    try container.encodeIfPresent(removeStopWords, forKey: .removeStopWords)
    try container.encodeIfPresent(keepDiacriticsOnCharacters, forKey: .keepDiacriticsOnCharacters)
    try container.encodeIfPresent(queryLanguages, forKey: .queryLanguages)
    try container.encodeIfPresent(decompoundQuery, forKey: .decompoundQuery)
    try container.encodeIfPresent(enableRules, forKey: .enableRules)
    try container.encodeIfPresent(enablePersonalization, forKey: .enablePersonalization)
    try container.encodeIfPresent(queryType, forKey: .queryType)
    try container.encodeIfPresent(removeWordsIfNoResults, forKey: .removeWordsIfNoResults)
    try container.encodeIfPresent(mode, forKey: .mode)
    try container.encodeIfPresent(semanticSearch, forKey: .semanticSearch)
    try container.encodeIfPresent(advancedSyntax, forKey: .advancedSyntax)
    try container.encodeIfPresent(optionalWords, forKey: .optionalWords)
    try container.encodeIfPresent(disableExactOnAttributes, forKey: .disableExactOnAttributes)
    try container.encodeIfPresent(exactOnSingleWordQuery, forKey: .exactOnSingleWordQuery)
    try container.encodeIfPresent(alternativesAsExact, forKey: .alternativesAsExact)
    try container.encodeIfPresent(advancedSyntaxFeatures, forKey: .advancedSyntaxFeatures)
    try container.encodeIfPresent(distinct, forKey: .distinct)
    try container.encodeIfPresent(replaceSynonymsInHighlight, forKey: .replaceSynonymsInHighlight)
    try container.encodeIfPresent(minProximity, forKey: .minProximity)
    try container.encodeIfPresent(responseFields, forKey: .responseFields)
    try container.encodeIfPresent(maxFacetHits, forKey: .maxFacetHits)
    try container.encodeIfPresent(maxValuesPerFacet, forKey: .maxValuesPerFacet)
    try container.encodeIfPresent(sortFacetValuesBy, forKey: .sortFacetValuesBy)
    try container.encodeIfPresent(
      attributeCriteriaComputedByMinProximity, forKey: .attributeCriteriaComputedByMinProximity)
    try container.encodeIfPresent(renderingContent, forKey: .renderingContent)
    try container.encodeIfPresent(enableReRanking, forKey: .enableReRanking)
    try container.encodeIfPresent(reRankingApplyFilter, forKey: .reRankingApplyFilter)
  }
}
