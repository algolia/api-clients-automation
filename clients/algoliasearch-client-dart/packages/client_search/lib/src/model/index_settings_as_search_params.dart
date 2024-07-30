// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
// ignore_for_file: unused_element
import 'package:algolia_client_search/src/model/mode.dart';
import 'package:algolia_client_search/src/model/supported_language.dart';
import 'package:algolia_client_search/src/model/rendering_content.dart';
import 'package:algolia_client_search/src/model/alternatives_as_exact.dart';
import 'package:algolia_client_search/src/model/exact_on_single_word_query.dart';
import 'package:algolia_client_search/src/model/semantic_search.dart';
import 'package:algolia_client_search/src/model/remove_words_if_no_results.dart';
import 'package:algolia_client_search/src/model/advanced_syntax_features.dart';
import 'package:algolia_client_search/src/model/query_type.dart';

import 'package:json_annotation/json_annotation.dart';

part 'index_settings_as_search_params.g.dart';

@JsonSerializable()
final class IndexSettingsAsSearchParams {
  /// Returns a new [IndexSettingsAsSearchParams] instance.
  const IndexSettingsAsSearchParams({
    this.attributesToRetrieve,
    this.ranking,
    this.customRanking,
    this.relevancyStrictness,
    this.attributesToHighlight,
    this.attributesToSnippet,
    this.highlightPreTag,
    this.highlightPostTag,
    this.snippetEllipsisText,
    this.restrictHighlightAndSnippetArrays,
    this.hitsPerPage,
    this.minWordSizefor1Typo,
    this.minWordSizefor2Typos,
    this.typoTolerance,
    this.allowTyposOnNumericTokens,
    this.disableTypoToleranceOnAttributes,
    this.ignorePlurals,
    this.removeStopWords,
    this.keepDiacriticsOnCharacters,
    this.queryLanguages,
    this.decompoundQuery,
    this.enableRules,
    this.enablePersonalization,
    this.queryType,
    this.removeWordsIfNoResults,
    this.mode,
    this.semanticSearch,
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
    this.maxFacetHits,
    this.maxValuesPerFacet,
    this.sortFacetValuesBy,
    this.attributeCriteriaComputedByMinProximity,
    this.renderingContent,
    this.enableReRanking,
    this.reRankingApplyFilter,
  });

  /// Attributes to include in the API response.  To reduce the size of your response, you can retrieve only some of the attributes. Attribute names are case-sensitive.  - `*` retrieves all attributes, except attributes included in the `customRanking` and `unretrievableAttributes` settings. - To retrieve all attributes except a specific one, prefix the attribute with a dash and combine it with the `*`: `[\"*\", \"-ATTRIBUTE\"]`. - The `objectID` attribute is always included.
  @JsonKey(name: r'attributesToRetrieve')
  final List<String>? attributesToRetrieve;

  /// Determines the order in which Algolia returns your results.  By default, each entry corresponds to a [ranking criteria](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/). The tie-breaking algorithm sequentially applies each criterion in the order they're specified. If you configure a replica index for [sorting by an attribute](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/how-to/sort-by-attribute/), you put the sorting attribute at the top of the list.  **Modifiers**  - `asc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in ascending order. - `desc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in descending order.  Before you modify the default setting, you should test your changes in the dashboard, and by [A/B testing](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/).
  @JsonKey(name: r'ranking')
  final List<String>? ranking;

  /// Attributes to use as [custom ranking](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Attribute names are case-sensitive.  The custom ranking attributes decide which items are shown first if the other ranking criteria are equal.  Records with missing values for your selected custom ranking attributes are always sorted last. Boolean attributes are sorted based on their alphabetical order.  **Modifiers**  - `asc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in ascending order.  - `desc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in descending order.  If you use two or more custom ranking attributes, [reduce the precision](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/how-to/controlling-custom-ranking-metrics-precision/) of your first attributes, or the other attributes will never be applied.
  @JsonKey(name: r'customRanking')
  final List<String>? customRanking;

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

  /// Number of hits per page.
  // minimum: 1
  // maximum: 1000
  @JsonKey(name: r'hitsPerPage')
  final int? hitsPerPage;

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
  /// - [bool]
  /// - [List<SupportedLanguage>]
  @JsonKey(name: r'ignorePlurals')
  final dynamic ignorePlurals;

  /// One of types:
  /// - [bool]
  /// - [List<SupportedLanguage>]
  @JsonKey(name: r'removeStopWords')
  final dynamic removeStopWords;

  /// Characters for which diacritics should be preserved.  By default, Algolia removes diacritics from letters. For example, `é` becomes `e`. If this causes issues in your search, you can specify characters that should keep their diacritics.
  @JsonKey(name: r'keepDiacriticsOnCharacters')
  final String? keepDiacriticsOnCharacters;

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

  @JsonKey(name: r'mode')
  final Mode? mode;

  @JsonKey(name: r'semanticSearch')
  final SemanticSearch? semanticSearch;

  /// Whether to support phrase matching and excluding words from search queries.  Use the `advancedSyntaxFeatures` parameter to control which feature is supported.
  @JsonKey(name: r'advancedSyntax')
  final bool? advancedSyntax;

  /// Words that should be considered optional when found in the query.  By default, records must match all words in the search query to be included in the search results. Adding optional words can help to increase the number of search results by running an additional search query that doesn't include the optional words. For example, if the search query is \"action video\" and \"video\" is an optional word, the search engine runs two queries. One for \"action video\" and one for \"action\". Records that match all words are ranked higher.  For a search query with 4 or more words **and** all its words are optional, the number of matched words required for a record to be included in the search results increases for every 1,000 records:  - If `optionalWords` has less than 10 words, the required number of matched words increases by 1:   results 1 to 1,000 require 1 matched word, results 1,001 to 2000 need 2 matched words. - If `optionalWords` has 10 or more words, the number of required matched words increases by the number of optional words dividied by 5 (rounded down).   For example, with 18 optional words: results 1 to 1,000 require 1 matched word, results 1,001 to 2000 need 4 matched words.  For more information, see [Optional words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words).
  @JsonKey(name: r'optionalWords')
  final List<String>? optionalWords;

  /// Searchable attributes for which you want to [turn off the Exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes). Attribute names are case-sensitive.  This can be useful for attributes with long values, where the likelyhood of an exact match is high, such as product descriptions. Turning off the Exact ranking criterion for these attributes favors exact matching on other attributes. This reduces the impact of individual attributes with a lot of content on ranking.
  @JsonKey(name: r'disableExactOnAttributes')
  final List<String>? disableExactOnAttributes;

  @JsonKey(name: r'exactOnSingleWordQuery')
  final ExactOnSingleWordQuery? exactOnSingleWordQuery;

  /// Alternatives of query words that should be considered as exact matches by the Exact ranking criterion.  - `ignorePlurals`.   Plurals and similar declensions added by the `ignorePlurals` setting are considered exact matches.  - `singleWordSynonym`.   Single-word synonyms, such as \"NY/NYC\" are considered exact matches.  - `multiWordsSynonym`.   Multi-word synonyms, such as \"NY/New York\" are considered exact matches.
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

  /// Whether to replace a highlighted word with the matched synonym.  By default, the original words are highlighted even if a synonym matches. For example, with `home` as a synonym for `house` and a search for `home`, records matching either \"home\" or \"house\" are included in the search results, and either \"home\" or \"house\" are highlighted.  With `replaceSynonymsInHighlight` set to `true`, a search for `home` still matches the same records, but all occurences of \"house\" are replaced by \"home\" in the highlighted response.
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

  /// Maximum number of facet values to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
  // maximum: 100
  @JsonKey(name: r'maxFacetHits')
  final int? maxFacetHits;

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
      other is IndexSettingsAsSearchParams &&
          other.attributesToRetrieve == attributesToRetrieve &&
          other.ranking == ranking &&
          other.customRanking == customRanking &&
          other.relevancyStrictness == relevancyStrictness &&
          other.attributesToHighlight == attributesToHighlight &&
          other.attributesToSnippet == attributesToSnippet &&
          other.highlightPreTag == highlightPreTag &&
          other.highlightPostTag == highlightPostTag &&
          other.snippetEllipsisText == snippetEllipsisText &&
          other.restrictHighlightAndSnippetArrays ==
              restrictHighlightAndSnippetArrays &&
          other.hitsPerPage == hitsPerPage &&
          other.minWordSizefor1Typo == minWordSizefor1Typo &&
          other.minWordSizefor2Typos == minWordSizefor2Typos &&
          other.typoTolerance == typoTolerance &&
          other.allowTyposOnNumericTokens == allowTyposOnNumericTokens &&
          other.disableTypoToleranceOnAttributes ==
              disableTypoToleranceOnAttributes &&
          other.ignorePlurals == ignorePlurals &&
          other.removeStopWords == removeStopWords &&
          other.keepDiacriticsOnCharacters == keepDiacriticsOnCharacters &&
          other.queryLanguages == queryLanguages &&
          other.decompoundQuery == decompoundQuery &&
          other.enableRules == enableRules &&
          other.enablePersonalization == enablePersonalization &&
          other.queryType == queryType &&
          other.removeWordsIfNoResults == removeWordsIfNoResults &&
          other.mode == mode &&
          other.semanticSearch == semanticSearch &&
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
          other.maxFacetHits == maxFacetHits &&
          other.maxValuesPerFacet == maxValuesPerFacet &&
          other.sortFacetValuesBy == sortFacetValuesBy &&
          other.attributeCriteriaComputedByMinProximity ==
              attributeCriteriaComputedByMinProximity &&
          other.renderingContent == renderingContent &&
          other.enableReRanking == enableReRanking &&
          other.reRankingApplyFilter == reRankingApplyFilter;

  @override
  int get hashCode =>
      attributesToRetrieve.hashCode +
      ranking.hashCode +
      customRanking.hashCode +
      relevancyStrictness.hashCode +
      attributesToHighlight.hashCode +
      attributesToSnippet.hashCode +
      highlightPreTag.hashCode +
      highlightPostTag.hashCode +
      snippetEllipsisText.hashCode +
      restrictHighlightAndSnippetArrays.hashCode +
      hitsPerPage.hashCode +
      minWordSizefor1Typo.hashCode +
      minWordSizefor2Typos.hashCode +
      typoTolerance.hashCode +
      allowTyposOnNumericTokens.hashCode +
      disableTypoToleranceOnAttributes.hashCode +
      ignorePlurals.hashCode +
      removeStopWords.hashCode +
      keepDiacriticsOnCharacters.hashCode +
      queryLanguages.hashCode +
      decompoundQuery.hashCode +
      enableRules.hashCode +
      enablePersonalization.hashCode +
      queryType.hashCode +
      removeWordsIfNoResults.hashCode +
      mode.hashCode +
      semanticSearch.hashCode +
      advancedSyntax.hashCode +
      optionalWords.hashCode +
      disableExactOnAttributes.hashCode +
      exactOnSingleWordQuery.hashCode +
      alternativesAsExact.hashCode +
      advancedSyntaxFeatures.hashCode +
      distinct.hashCode +
      replaceSynonymsInHighlight.hashCode +
      minProximity.hashCode +
      responseFields.hashCode +
      maxFacetHits.hashCode +
      maxValuesPerFacet.hashCode +
      sortFacetValuesBy.hashCode +
      attributeCriteriaComputedByMinProximity.hashCode +
      renderingContent.hashCode +
      enableReRanking.hashCode +
      (reRankingApplyFilter == null ? 0 : reRankingApplyFilter.hashCode);

  factory IndexSettingsAsSearchParams.fromJson(Map<String, dynamic> json) =>
      _$IndexSettingsAsSearchParamsFromJson(json);

  Map<String, dynamic> toJson() => _$IndexSettingsAsSearchParamsToJson(this);

  @override
  String toString() {
    return toJson().toString();
  }
}
