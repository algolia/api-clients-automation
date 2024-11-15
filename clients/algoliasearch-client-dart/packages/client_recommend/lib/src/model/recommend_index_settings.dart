// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_recommend/src/model/query_type.dart';
import 'package:algolia_client_recommend/src/model/alternatives_as_exact.dart';
import 'package:algolia_client_recommend/src/model/advanced_syntax_features.dart';
import 'package:algolia_client_recommend/src/model/supported_language.dart';
import 'package:algolia_client_recommend/src/model/remove_words_if_no_results.dart';
import 'package:algolia_client_recommend/src/model/exact_on_single_word_query.dart';
import 'package:algolia_client_recommend/src/model/rendering_content.dart';

import 'package:json_annotation/json_annotation.dart';

part 'recommend_index_settings.g.dart';

@JsonSerializable()
final class RecommendIndexSettings {
  /// Returns a new [RecommendIndexSettings] instance.
  const RecommendIndexSettings({
    this.attributesForFaceting,
    this.replicas,
    this.paginationLimitedTo,
    this.unretrievableAttributes,
    this.disableTypoToleranceOnWords,
    this.attributesToTransliterate,
    this.camelCaseAttributes,
    this.decompoundedAttributes,
    this.indexLanguages,
    this.disablePrefixOnAttributes,
    this.allowCompressionOfIntegerArray,
    this.numericAttributesForFiltering,
    this.separatorsToIndex,
    this.searchableAttributes,
    this.userData,
    this.customNormalization,
    this.attributeForDistinct,
    this.maxFacetHits,
    this.attributesToRetrieve,
    this.ranking,
    this.relevancyStrictness,
    this.attributesToHighlight,
    this.attributesToSnippet,
    this.highlightPreTag,
    this.highlightPostTag,
    this.snippetEllipsisText,
    this.restrictHighlightAndSnippetArrays,
    this.minWordSizefor1Typo,
    this.minWordSizefor2Typos,
    this.typoTolerance,
    this.allowTyposOnNumericTokens,
    this.disableTypoToleranceOnAttributes,
    this.ignorePlurals,
    this.removeStopWords,
    this.queryLanguages,
    this.decompoundQuery,
    this.enableRules,
    this.enablePersonalization,
    this.queryType,
    this.removeWordsIfNoResults,
    this.advancedSyntax,
    this.optionalWords,
    this.disableExactOnAttributes,
    this.exactOnSingleWordQuery,
    this.alternativesAsExact,
    this.advancedSyntaxFeatures,
    this.distinct,
    this.replaceSynonymsInHighlight,
    this.minProximity,
    this.responseFields,
    this.maxValuesPerFacet,
    this.sortFacetValuesBy,
    this.attributeCriteriaComputedByMinProximity,
    this.renderingContent,
    this.enableReRanking,
    this.reRankingApplyFilter,
  });

  /// Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/).  Facets are attributes that let you categorize search results. They can be used for filtering search results. By default, no attribute is used for faceting. Attribute names are case-sensitive.  **Modifiers**  - `filterOnly(\"ATTRIBUTE\")`.   Allows the attribute to be used as a filter but doesn't evaluate the facet values.  - `searchable(\"ATTRIBUTE\")`.   Allows searching for facet values.  - `afterDistinct(\"ATTRIBUTE\")`.   Evaluates the facet count _after_ deduplication with `distinct`.   This ensures accurate facet counts.   You can apply this modifier to searchable facets: `afterDistinct(searchable(ATTRIBUTE))`.
  @JsonKey(name: r'attributesForFaceting')
  final List<String>? attributesForFaceting;

  /// Creates [replica indices](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/).  Replicas are copies of a primary index with the same records but different settings, synonyms, or rules. If you want to offer a different ranking or sorting of your search results, you'll use replica indices. All index operations on a primary index are automatically forwarded to its replicas. To add a replica index, you must provide the complete set of replicas to this parameter. If you omit a replica from this list, the replica turns into a regular, standalone index that will no longer be synced with the primary index.  **Modifier**  - `virtual(\"REPLICA\")`.   Create a virtual replica,   Virtual replicas don't increase the number of records and are optimized for [Relevant sorting](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/relevant-sort/).
  @JsonKey(name: r'replicas')
  final List<String>? replicas;

  /// Maximum number of search results that can be obtained through pagination.  Higher pagination limits might slow down your search. For pagination limits above 1,000, the sorting of results beyond the 1,000th hit can't be guaranteed.
  // maximum: 20000
  @JsonKey(name: r'paginationLimitedTo')
  final int? paginationLimitedTo;

  /// Attributes that can't be retrieved at query time.  This can be useful if you want to use an attribute for ranking or to [restrict access](https://www.algolia.com/doc/guides/security/api-keys/how-to/user-restricted-access-to-data/), but don't want to include it in the search results. Attribute names are case-sensitive.
  @JsonKey(name: r'unretrievableAttributes')
  final List<String>? unretrievableAttributes;

  /// Creates a list of [words which require exact matches](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#turn-off-typo-tolerance-for-certain-words). This also turns off [word splitting and concatenation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/splitting-and-concatenation/) for the specified words.
  @JsonKey(name: r'disableTypoToleranceOnWords')
  final List<String>? disableTypoToleranceOnWords;

  /// Attributes, for which you want to support [Japanese transliteration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#japanese-transliteration-and-type-ahead).  Transliteration supports searching in any of the Japanese writing systems. To support transliteration, you must set the indexing language to Japanese. Attribute names are case-sensitive.
  @JsonKey(name: r'attributesToTransliterate')
  final List<String>? attributesToTransliterate;

  /// Attributes for which to split [camel case](https://wikipedia.org/wiki/Camel_case) words. Attribute names are case-sensitive.
  @JsonKey(name: r'camelCaseAttributes')
  final List<String>? camelCaseAttributes;

  /// Searchable attributes to which Algolia should apply [word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/how-to/customize-segmentation/) (decompounding). Attribute names are case-sensitive.  Compound words are formed by combining two or more individual words, and are particularly prevalent in Germanic languages—for example, \"firefighter\". With decompounding, the individual components are indexed separately.  You can specify different lists for different languages. Decompounding is supported for these languages: Dutch (`nl`), German (`de`), Finnish (`fi`), Danish (`da`), Swedish (`sv`), and Norwegian (`no`). Decompounding doesn't work for words with [non-spacing mark Unicode characters](https://www.charactercodes.net/category/non-spacing_mark). For example, `Gartenstühle` won't be decompounded if the `ü` consists of `u` (U+0075) and `◌̈` (U+0308).
  @JsonKey(name: r'decompoundedAttributes')
  final Object? decompoundedAttributes;

  /// Languages for language-specific processing steps, such as word detection and dictionary settings.  **You should always specify an indexing language.** If you don't specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
  @JsonKey(name: r'indexLanguages')
  final List<SupportedLanguage>? indexLanguages;

  /// Searchable attributes for which you want to turn off [prefix matching](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#adjusting-prefix-search). Attribute names are case-sensitive.
  @JsonKey(name: r'disablePrefixOnAttributes')
  final List<String>? disablePrefixOnAttributes;

  /// Whether arrays with exclusively non-negative integers should be compressed for better performance. If true, the compressed arrays may be reordered.
  @JsonKey(name: r'allowCompressionOfIntegerArray')
  final bool? allowCompressionOfIntegerArray;

  /// Numeric attributes that can be used as [numerical filters](https://www.algolia.com/doc/guides/managing-results/rules/detecting-intent/how-to/applying-a-custom-filter-for-a-specific-query/#numerical-filters). Attribute names are case-sensitive.  By default, all numeric attributes are available as numerical filters. For faster indexing, reduce the number of numeric attributes.  To turn off filtering for all numeric attributes, specify an attribute that doesn't exist in your index, such as `NO_NUMERIC_FILTERING`.  **Modifier**  - `equalOnly(\"ATTRIBUTE\")`.   Support only filtering based on equality comparisons `=` and `!=`.
  @JsonKey(name: r'numericAttributesForFiltering')
  final List<String>? numericAttributesForFiltering;

  /// Control which non-alphanumeric characters are indexed.  By default, Algolia ignores [non-alphanumeric characters](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/how-to/how-to-search-in-hyphenated-attributes/#handling-non-alphanumeric-characters) like hyphen (`-`), plus (`+`), and parentheses (`(`,`)`). To include such characters, define them with `separatorsToIndex`.  Separators are all non-letter characters except spaces and currency characters, such as $€£¥.  With `separatorsToIndex`, Algolia treats separator characters as separate words. For example, in a search for \"Disney+\", Algolia considers \"Disney\" and \"+\" as two separate words.
  @JsonKey(name: r'separatorsToIndex')
  final String? separatorsToIndex;

  /// Attributes used for searching. Attribute names are case-sensitive.  By default, all attributes are searchable and the [Attribute](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute) ranking criterion is turned off. With a non-empty list, Algolia only returns results with matches in the selected attributes. In addition, the Attribute ranking criterion is turned on: matches in attributes that are higher in the list of `searchableAttributes` rank first. To make matches in two attributes rank equally, include them in a comma-separated string, such as `\"title,alternate_title\"`. Attributes with the same priority are always unordered.  For more information, see [Searchable attributes](https://www.algolia.com/doc/guides/sending-and-managing-data/prepare-your-data/how-to/setting-searchable-attributes/).  **Modifier**  - `unordered(\"ATTRIBUTE\")`.   Ignore the position of a match within the attribute.  Without a modifier, matches at the beginning of an attribute rank higher than matches at the end.
  @JsonKey(name: r'searchableAttributes')
  final List<String>? searchableAttributes;

  /// An object with custom data.  You can store up to 32kB as custom data.
  @JsonKey(name: r'userData')
  final Object? userData;

  /// Characters and their normalized replacements. This overrides Algolia's default [normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
  @JsonKey(name: r'customNormalization')
  final Map<String, Map<String, String>>? customNormalization;

  /// Attribute that should be used to establish groups of results. Attribute names are case-sensitive.  All records with the same value for this attribute are considered a group. You can combine `attributeForDistinct` with the `distinct` search parameter to control how many items per group are included in the search results.  If you want to use the same attribute also for faceting, use the `afterDistinct` modifier of the `attributesForFaceting` setting. This applies faceting _after_ deduplication, which will result in accurate facet counts.
  @JsonKey(name: r'attributeForDistinct')
  final String? attributeForDistinct;

  /// Maximum number of facet values to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
  // maximum: 100
  @JsonKey(name: r'maxFacetHits')
  final int? maxFacetHits;

  /// Attributes to include in the API response.  To reduce the size of your response, you can retrieve only some of the attributes. Attribute names are case-sensitive.  - `*` retrieves all attributes, except attributes included in the `customRanking` and `unretrievableAttributes` settings. - To retrieve all attributes except a specific one, prefix the attribute with a dash and combine it with the `*`: `[\"*\", \"-ATTRIBUTE\"]`. - The `objectID` attribute is always included.
  @JsonKey(name: r'attributesToRetrieve')
  final List<String>? attributesToRetrieve;

  /// Determines the order in which Algolia returns your results.  By default, each entry corresponds to a [ranking criteria](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/). The tie-breaking algorithm sequentially applies each criterion in the order they're specified. If you configure a replica index for [sorting by an attribute](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/how-to/sort-by-attribute/), you put the sorting attribute at the top of the list.  **Modifiers**  - `asc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in ascending order. - `desc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in descending order.  Before you modify the default setting, you should test your changes in the dashboard, and by [A/B testing](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/).
  @JsonKey(name: r'ranking')
  final List<String>? ranking;

  /// Relevancy threshold below which less relevant results aren't included in the results.  You can only set `relevancyStrictness` on [virtual replica indices](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/#what-are-virtual-replicas). Use this setting to strike a balance between the relevance and number of returned results.
  @JsonKey(name: r'relevancyStrictness')
  final int? relevancyStrictness;

  /// Attributes to highlight.  By default, all searchable attributes are highlighted. Use `*` to highlight all attributes or use an empty array `[]` to turn off highlighting. Attribute names are case-sensitive.  With highlighting, strings that match the search query are surrounded by HTML tags defined by `highlightPreTag` and `highlightPostTag`. You can use this to visually highlight matching parts of a search query in your UI.  For more information, see [Highlighting and snippeting](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/highlighting-snippeting/js/).
  @JsonKey(name: r'attributesToHighlight')
  final List<String>? attributesToHighlight;

  /// Attributes for which to enable snippets. Attribute names are case-sensitive.  Snippets provide additional context to matched words. If you enable snippets, they include 10 words, including the matched word. The matched word will also be wrapped by HTML tags for highlighting. You can adjust the number of words with the following notation: `ATTRIBUTE:NUMBER`, where `NUMBER` is the number of words to be extracted.
  @JsonKey(name: r'attributesToSnippet')
  final List<String>? attributesToSnippet;

  /// HTML tag to insert before the highlighted parts in all highlighted results and snippets.
  @JsonKey(name: r'highlightPreTag')
  final String? highlightPreTag;

  /// HTML tag to insert after the highlighted parts in all highlighted results and snippets.
  @JsonKey(name: r'highlightPostTag')
  final String? highlightPostTag;

  /// String used as an ellipsis indicator when a snippet is truncated.
  @JsonKey(name: r'snippetEllipsisText')
  final String? snippetEllipsisText;

  /// Whether to restrict highlighting and snippeting to items that at least partially matched the search query. By default, all items are highlighted and snippeted.
  @JsonKey(name: r'restrictHighlightAndSnippetArrays')
  final bool? restrictHighlightAndSnippetArrays;

  /// Minimum number of characters a word in the search query must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
  @JsonKey(name: r'minWordSizefor1Typo')
  final int? minWordSizefor1Typo;

  /// Minimum number of characters a word in the search query must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
  @JsonKey(name: r'minWordSizefor2Typos')
  final int? minWordSizefor2Typos;

  /// One of types:
  /// - [TypoToleranceEnum]
  /// - [bool]
  @JsonKey(name: r'typoTolerance')
  final dynamic typoTolerance;

  /// Whether to allow typos on numbers in the search query.  Turn off this setting to reduce the number of irrelevant matches when searching in large sets of similar numbers.
  @JsonKey(name: r'allowTyposOnNumericTokens')
  final bool? allowTyposOnNumericTokens;

  /// Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). Attribute names are case-sensitive.  Returning only exact matches can help when:  - [Searching in hyphenated attributes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/how-to/how-to-search-in-hyphenated-attributes/). - Reducing the number of matches when you have too many.   This can happen with attributes that are long blocks of text, such as product descriptions.  Consider alternatives such as `disableTypoToleranceOnWords` or adding synonyms if your attributes have intentional unusual spellings that might look like typos.
  @JsonKey(name: r'disableTypoToleranceOnAttributes')
  final List<String>? disableTypoToleranceOnAttributes;

  /// One of types:
  /// - [BooleanString]
  /// - [bool]
  /// - [List<SupportedLanguage>]
  @JsonKey(name: r'ignorePlurals')
  final dynamic ignorePlurals;

  /// One of types:
  /// - [bool]
  /// - [List<SupportedLanguage>]
  @JsonKey(name: r'removeStopWords')
  final dynamic removeStopWords;

  /// Languages for language-specific query processing steps such as plurals, stop-word removal, and word-detection dictionaries.  This setting sets a default list of languages used by the `removeStopWords` and `ignorePlurals` settings. This setting also sets a dictionary for word detection in the logogram-based [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) languages. To support this, you must place the CJK language **first**.  **You should always specify a query language.** If you don't specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
  @JsonKey(name: r'queryLanguages')
  final List<SupportedLanguage>? queryLanguages;

  /// Whether to split compound words in the query into their building blocks.  For more information, see [Word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words). Word segmentation is supported for these languages: German, Dutch, Finnish, Swedish, and Norwegian. Decompounding doesn't work for words with [non-spacing mark Unicode characters](https://www.charactercodes.net/category/non-spacing_mark). For example, `Gartenstühle` won't be decompounded if the `ü` consists of `u` (U+0075) and `◌̈` (U+0308).
  @JsonKey(name: r'decompoundQuery')
  final bool? decompoundQuery;

  /// Whether to enable rules.
  @JsonKey(name: r'enableRules')
  final bool? enableRules;

  /// Whether to enable Personalization.
  @JsonKey(name: r'enablePersonalization')
  final bool? enablePersonalization;

  @JsonKey(name: r'queryType')
  final QueryType? queryType;

  @JsonKey(name: r'removeWordsIfNoResults')
  final RemoveWordsIfNoResults? removeWordsIfNoResults;

  /// Whether to support phrase matching and excluding words from search queries.  Use the `advancedSyntaxFeatures` parameter to control which feature is supported.
  @JsonKey(name: r'advancedSyntax')
  final bool? advancedSyntax;

  /// One of types:
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'optionalWords')
  final dynamic optionalWords;

  /// Searchable attributes for which you want to [turn off the Exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes). Attribute names are case-sensitive.  This can be useful for attributes with long values, where the likelihood of an exact match is high, such as product descriptions. Turning off the Exact ranking criterion for these attributes favors exact matching on other attributes. This reduces the impact of individual attributes with a lot of content on ranking.
  @JsonKey(name: r'disableExactOnAttributes')
  final List<String>? disableExactOnAttributes;

  @JsonKey(name: r'exactOnSingleWordQuery')
  final ExactOnSingleWordQuery? exactOnSingleWordQuery;

  /// Determine which plurals and synonyms should be considered an exact matches.  By default, Algolia treats singular and plural forms of a word, and single-word synonyms, as [exact](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#exact) matches when searching. For example:  - \"swimsuit\" and \"swimsuits\" are treated the same - \"swimsuit\" and \"swimwear\" are treated the same (if they are [synonyms](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/#regular-synonyms)).  - `ignorePlurals`.   Plurals and similar declensions added by the `ignorePlurals` setting are considered exact matches.  - `singleWordSynonym`.   Single-word synonyms, such as \"NY\" = \"NYC\", are considered exact matches.  - `multiWordsSynonym`.   Multi-word synonyms, such as \"NY\" = \"New York\", are considered exact matches.
  @JsonKey(name: r'alternativesAsExact')
  final List<AlternativesAsExact>? alternativesAsExact;

  /// Advanced search syntax features you want to support.  - `exactPhrase`.   Phrases in quotes must match exactly.   For example, `sparkly blue \"iPhone case\"` only returns records with the exact string \"iPhone case\".  - `excludeWords`.   Query words prefixed with a `-` must not occur in a record.   For example, `search -engine` matches records that contain \"search\" but not \"engine\".  This setting only has an effect if `advancedSyntax` is true.
  @JsonKey(name: r'advancedSyntaxFeatures')
  final List<AdvancedSyntaxFeatures>? advancedSyntaxFeatures;

  /// One of types:
  /// - [bool]
  /// - [int]
  @JsonKey(name: r'distinct')
  final dynamic distinct;

  /// Whether to replace a highlighted word with the matched synonym.  By default, the original words are highlighted even if a synonym matches. For example, with `home` as a synonym for `house` and a search for `home`, records matching either \"home\" or \"house\" are included in the search results, and either \"home\" or \"house\" are highlighted.  With `replaceSynonymsInHighlight` set to `true`, a search for `home` still matches the same records, but all occurrences of \"house\" are replaced by \"home\" in the highlighted response.
  @JsonKey(name: r'replaceSynonymsInHighlight')
  final bool? replaceSynonymsInHighlight;

  /// Minimum proximity score for two matching words.  This adjusts the [Proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity) by equally scoring matches that are farther apart.  For example, if `minProximity` is 2, neighboring matches and matches with one word between them would have the same score.
  // minimum: 1
  // maximum: 7
  @JsonKey(name: r'minProximity')
  final int? minProximity;

  /// Properties to include in the API response of `search` and `browse` requests.  By default, all response properties are included. To reduce the response size, you can select, which attributes should be included.  You can't exclude these properties: `message`, `warning`, `cursor`, `serverUsed`, `indexUsed`, `abTestVariantID`, `parsedQuery`, or any property triggered by the `getRankingInfo` parameter.  Don't exclude properties that you might need in your search UI.
  @JsonKey(name: r'responseFields')
  final List<String>? responseFields;

  /// Maximum number of facet values to return for each facet.
  // maximum: 1000
  @JsonKey(name: r'maxValuesPerFacet')
  final int? maxValuesPerFacet;

  /// Order in which to retrieve facet values.  - `count`.   Facet values are retrieved by decreasing count.   The count is the number of matching records containing this facet value.  - `alpha`.   Retrieve facet values alphabetically.  This setting doesn't influence how facet values are displayed in your UI (see `renderingContent`). For more information, see [facet value display](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/facet-display/js/).
  @JsonKey(name: r'sortFacetValuesBy')
  final String? sortFacetValuesBy;

  /// Whether the best matching attribute should be determined by minimum proximity.  This setting only affects ranking if the Attribute ranking criterion comes before Proximity in the `ranking` setting. If true, the best matching attribute is selected based on the minimum proximity of multiple matches. Otherwise, the best matching attribute is determined by the order in the `searchableAttributes` setting.
  @JsonKey(name: r'attributeCriteriaComputedByMinProximity')
  final bool? attributeCriteriaComputedByMinProximity;

  @JsonKey(name: r'renderingContent')
  final RenderingContent? renderingContent;

  /// Whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).  This setting only has an effect if you activated Dynamic Re-Ranking for this index in the Algolia dashboard.
  @JsonKey(name: r'enableReRanking')
  final bool? enableReRanking;

  /// One of types:
  /// - [List<List<ReRankingApplyFilter>>]
  /// - [String]
  /// - [List<String>]
  @JsonKey(name: r'reRankingApplyFilter')
  final dynamic reRankingApplyFilter;

  @override
  bool operator ==(Object other) =>
      identical(this, other) ||
      other is RecommendIndexSettings &&
          other.attributesForFaceting == attributesForFaceting &&
          other.replicas == replicas &&
          other.paginationLimitedTo == paginationLimitedTo &&
          other.unretrievableAttributes == unretrievableAttributes &&
          other.disableTypoToleranceOnWords == disableTypoToleranceOnWords &&
          other.attributesToTransliterate == attributesToTransliterate &&
          other.camelCaseAttributes == camelCaseAttributes &&
          other.decompoundedAttributes == decompoundedAttributes &&
          other.indexLanguages == indexLanguages &&
          other.disablePrefixOnAttributes == disablePrefixOnAttributes &&
          other.allowCompressionOfIntegerArray ==
              allowCompressionOfIntegerArray &&
          other.numericAttributesForFiltering ==
              numericAttributesForFiltering &&
          other.separatorsToIndex == separatorsToIndex &&
          other.searchableAttributes == searchableAttributes &&
          other.userData == userData &&
          other.customNormalization == customNormalization &&
          other.attributeForDistinct == attributeForDistinct &&
          other.maxFacetHits == maxFacetHits &&
          other.attributesToRetrieve == attributesToRetrieve &&
          other.ranking == ranking &&
          other.relevancyStrictness == relevancyStrictness &&
          other.attributesToHighlight == attributesToHighlight &&
          other.attributesToSnippet == attributesToSnippet &&
          other.highlightPreTag == highlightPreTag &&
          other.highlightPostTag == highlightPostTag &&
          other.snippetEllipsisText == snippetEllipsisText &&
          other.restrictHighlightAndSnippetArrays ==
              restrictHighlightAndSnippetArrays &&
          other.minWordSizefor1Typo == minWordSizefor1Typo &&
          other.minWordSizefor2Typos == minWordSizefor2Typos &&
          other.typoTolerance == typoTolerance &&
          other.allowTyposOnNumericTokens == allowTyposOnNumericTokens &&
          other.disableTypoToleranceOnAttributes ==
              disableTypoToleranceOnAttributes &&
          other.ignorePlurals == ignorePlurals &&
          other.removeStopWords == removeStopWords &&
          other.queryLanguages == queryLanguages &&
          other.decompoundQuery == decompoundQuery &&
          other.enableRules == enableRules &&
          other.enablePersonalization == enablePersonalization &&
          other.queryType == queryType &&
          other.removeWordsIfNoResults == removeWordsIfNoResults &&
          other.advancedSyntax == advancedSyntax &&
          other.optionalWords == optionalWords &&
          other.disableExactOnAttributes == disableExactOnAttributes &&
          other.exactOnSingleWordQuery == exactOnSingleWordQuery &&
          other.alternativesAsExact == alternativesAsExact &&
          other.advancedSyntaxFeatures == advancedSyntaxFeatures &&
          other.distinct == distinct &&
          other.replaceSynonymsInHighlight == replaceSynonymsInHighlight &&
          other.minProximity == minProximity &&
          other.responseFields == responseFields &&
          other.maxValuesPerFacet == maxValuesPerFacet &&
          other.sortFacetValuesBy == sortFacetValuesBy &&
          other.attributeCriteriaComputedByMinProximity ==
              attributeCriteriaComputedByMinProximity &&
          other.renderingContent == renderingContent &&
          other.enableReRanking == enableReRanking &&
          other.reRankingApplyFilter == reRankingApplyFilter;

  @override
  int get hashCode =>
      attributesForFaceting.hashCode +
      replicas.hashCode +
      paginationLimitedTo.hashCode +
      unretrievableAttributes.hashCode +
      disableTypoToleranceOnWords.hashCode +
      attributesToTransliterate.hashCode +
      camelCaseAttributes.hashCode +
      decompoundedAttributes.hashCode +
      indexLanguages.hashCode +
      disablePrefixOnAttributes.hashCode +
      allowCompressionOfIntegerArray.hashCode +
      numericAttributesForFiltering.hashCode +
      separatorsToIndex.hashCode +
      searchableAttributes.hashCode +
      userData.hashCode +
      customNormalization.hashCode +
      attributeForDistinct.hashCode +
      maxFacetHits.hashCode +
      attributesToRetrieve.hashCode +
      ranking.hashCode +
      relevancyStrictness.hashCode +
      attributesToHighlight.hashCode +
      attributesToSnippet.hashCode +
      highlightPreTag.hashCode +
      highlightPostTag.hashCode +
      snippetEllipsisText.hashCode +
      restrictHighlightAndSnippetArrays.hashCode +
      minWordSizefor1Typo.hashCode +
      minWordSizefor2Typos.hashCode +
      typoTolerance.hashCode +
      allowTyposOnNumericTokens.hashCode +
      disableTypoToleranceOnAttributes.hashCode +
      ignorePlurals.hashCode +
      removeStopWords.hashCode +
      queryLanguages.hashCode +
      decompoundQuery.hashCode +
      enableRules.hashCode +
      enablePersonalization.hashCode +
      queryType.hashCode +
      removeWordsIfNoResults.hashCode +
      advancedSyntax.hashCode +
      (optionalWords == null ? 0 : optionalWords.hashCode) +
      disableExactOnAttributes.hashCode +
      exactOnSingleWordQuery.hashCode +
      alternativesAsExact.hashCode +
      advancedSyntaxFeatures.hashCode +
      distinct.hashCode +
      replaceSynonymsInHighlight.hashCode +
      minProximity.hashCode +
      responseFields.hashCode +
      maxValuesPerFacet.hashCode +
      sortFacetValuesBy.hashCode +
      attributeCriteriaComputedByMinProximity.hashCode +
      renderingContent.hashCode +
      enableReRanking.hashCode +
      reRankingApplyFilter.hashCode;

  factory RecommendIndexSettings.fromJson(Map<String, dynamic> json) =>
      _$RecommendIndexSettingsFromJson(json);

  Map<String, dynamic> toJson() => _$RecommendIndexSettingsToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
