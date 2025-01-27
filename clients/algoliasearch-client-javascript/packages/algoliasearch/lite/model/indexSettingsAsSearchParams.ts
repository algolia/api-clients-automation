// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { AdvancedSyntaxFeatures } from './advancedSyntaxFeatures';
import type { AlternativesAsExact } from './alternativesAsExact';
import type { Distinct } from './distinct';
import type { ExactOnSingleWordQuery } from './exactOnSingleWordQuery';
import type { IgnorePlurals } from './ignorePlurals';
import type { Mode } from './mode';
import type { OptionalWords } from './optionalWords';
import type { QueryType } from './queryType';
import type { ReRankingApplyFilter } from './reRankingApplyFilter';
import type { RemoveStopWords } from './removeStopWords';
import type { RemoveWordsIfNoResults } from './removeWordsIfNoResults';
import type { RenderingContent } from './renderingContent';
import type { SemanticSearch } from './semanticSearch';
import type { SupportedLanguage } from './supportedLanguage';
import type { TypoTolerance } from './typoTolerance';

export type IndexSettingsAsSearchParams = {
  /**
   * Attributes to include in the API response.  To reduce the size of your response, you can retrieve only some of the attributes. Attribute names are case-sensitive.  - `*` retrieves all attributes, except attributes included in the `customRanking` and `unretrievableAttributes` settings. - To retrieve all attributes except a specific one, prefix the attribute with a dash and combine it with the `*`: `[\"*\", \"-ATTRIBUTE\"]`. - The `objectID` attribute is always included.
   */
  attributesToRetrieve?: Array<string>;

  /**
   * Determines the order in which Algolia returns your results.  By default, each entry corresponds to a [ranking criteria](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/). The tie-breaking algorithm sequentially applies each criterion in the order they\'re specified. If you configure a replica index for [sorting by an attribute](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/how-to/sort-by-attribute/), you put the sorting attribute at the top of the list.  **Modifiers**  - `asc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in ascending order. - `desc(\"ATTRIBUTE\")`.   Sort the index by the values of an attribute, in descending order.  Before you modify the default setting, you should test your changes in the dashboard, and by [A/B testing](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/).
   */
  ranking?: Array<string>;

  /**
   * Relevancy threshold below which less relevant results aren\'t included in the results.  You can only set `relevancyStrictness` on [virtual replica indices](https://www.algolia.com/doc/guides/managing-results/refine-results/sorting/in-depth/replicas/#what-are-virtual-replicas). Use this setting to strike a balance between the relevance and number of returned results.
   */
  relevancyStrictness?: number;

  /**
   * Attributes to highlight.  By default, all searchable attributes are highlighted. Use `*` to highlight all attributes or use an empty array `[]` to turn off highlighting. Attribute names are case-sensitive.  With highlighting, strings that match the search query are surrounded by HTML tags defined by `highlightPreTag` and `highlightPostTag`. You can use this to visually highlight matching parts of a search query in your UI.  For more information, see [Highlighting and snippeting](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/highlighting-snippeting/js/).
   */
  attributesToHighlight?: Array<string>;

  /**
   * Attributes for which to enable snippets. Attribute names are case-sensitive.  Snippets provide additional context to matched words. If you enable snippets, they include 10 words, including the matched word. The matched word will also be wrapped by HTML tags for highlighting. You can adjust the number of words with the following notation: `ATTRIBUTE:NUMBER`, where `NUMBER` is the number of words to be extracted.
   */
  attributesToSnippet?: Array<string>;

  /**
   * HTML tag to insert before the highlighted parts in all highlighted results and snippets.
   */
  highlightPreTag?: string;

  /**
   * HTML tag to insert after the highlighted parts in all highlighted results and snippets.
   */
  highlightPostTag?: string;

  /**
   * String used as an ellipsis indicator when a snippet is truncated.
   */
  snippetEllipsisText?: string;

  /**
   * Whether to restrict highlighting and snippeting to items that at least partially matched the search query. By default, all items are highlighted and snippeted.
   */
  restrictHighlightAndSnippetArrays?: boolean;

  /**
   * Number of hits per page.
   */
  hitsPerPage?: number;

  /**
   * Minimum number of characters a word in the search query must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
   */
  minWordSizefor1Typo?: number;

  /**
   * Minimum number of characters a word in the search query must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
   */
  minWordSizefor2Typos?: number;

  typoTolerance?: TypoTolerance;

  /**
   * Whether to allow typos on numbers in the search query.  Turn off this setting to reduce the number of irrelevant matches when searching in large sets of similar numbers.
   */
  allowTyposOnNumericTokens?: boolean;

  /**
   * Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/). Attribute names are case-sensitive.  Returning only exact matches can help when:  - [Searching in hyphenated attributes](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/how-to/how-to-search-in-hyphenated-attributes/). - Reducing the number of matches when you have too many.   This can happen with attributes that are long blocks of text, such as product descriptions.  Consider alternatives such as `disableTypoToleranceOnWords` or adding synonyms if your attributes have intentional unusual spellings that might look like typos.
   */
  disableTypoToleranceOnAttributes?: Array<string>;

  ignorePlurals?: IgnorePlurals;

  removeStopWords?: RemoveStopWords;

  /**
   * Languages for language-specific query processing steps such as plurals, stop-word removal, and word-detection dictionaries.  This setting sets a default list of languages used by the `removeStopWords` and `ignorePlurals` settings. This setting also sets a dictionary for word detection in the logogram-based [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) languages. To support this, you must place the CJK language **first**.  **You should always specify a query language.** If you don\'t specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
   */
  queryLanguages?: Array<SupportedLanguage>;

  /**
   * Whether to split compound words in the query into their building blocks.  For more information, see [Word segmentation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words). Word segmentation is supported for these languages: German, Dutch, Finnish, Swedish, and Norwegian. Decompounding doesn\'t work for words with [non-spacing mark Unicode characters](https://www.charactercodes.net/category/non-spacing_mark). For example, `Gartenstühle` won\'t be decompounded if the `ü` consists of `u` (U+0075) and `◌̈` (U+0308).
   */
  decompoundQuery?: boolean;

  /**
   * Whether to enable rules.
   */
  enableRules?: boolean;

  /**
   * Whether to enable Personalization.
   */
  enablePersonalization?: boolean;

  queryType?: QueryType;

  removeWordsIfNoResults?: RemoveWordsIfNoResults;

  mode?: Mode;

  semanticSearch?: SemanticSearch;

  /**
   * Whether to support phrase matching and excluding words from search queries.  Use the `advancedSyntaxFeatures` parameter to control which feature is supported.
   */
  advancedSyntax?: boolean;

  optionalWords?: OptionalWords | null;

  /**
   * Searchable attributes for which you want to [turn off the Exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes). Attribute names are case-sensitive.  This can be useful for attributes with long values, where the likelihood of an exact match is high, such as product descriptions. Turning off the Exact ranking criterion for these attributes favors exact matching on other attributes. This reduces the impact of individual attributes with a lot of content on ranking.
   */
  disableExactOnAttributes?: Array<string>;

  exactOnSingleWordQuery?: ExactOnSingleWordQuery;

  /**
   * Determine which plurals and synonyms should be considered an exact matches.  By default, Algolia treats singular and plural forms of a word, and single-word synonyms, as [exact](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#exact) matches when searching. For example:  - \"swimsuit\" and \"swimsuits\" are treated the same - \"swimsuit\" and \"swimwear\" are treated the same (if they are [synonyms](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/adding-synonyms/#regular-synonyms)).  - `ignorePlurals`.   Plurals and similar declensions added by the `ignorePlurals` setting are considered exact matches.  - `singleWordSynonym`.   Single-word synonyms, such as \"NY\" = \"NYC\", are considered exact matches.  - `multiWordsSynonym`.   Multi-word synonyms, such as \"NY\" = \"New York\", are considered exact matches.
   */
  alternativesAsExact?: Array<AlternativesAsExact>;

  /**
   * Advanced search syntax features you want to support.  - `exactPhrase`.   Phrases in quotes must match exactly.   For example, `sparkly blue \"iPhone case\"` only returns records with the exact string \"iPhone case\".  - `excludeWords`.   Query words prefixed with a `-` must not occur in a record.   For example, `search -engine` matches records that contain \"search\" but not \"engine\".  This setting only has an effect if `advancedSyntax` is true.
   */
  advancedSyntaxFeatures?: Array<AdvancedSyntaxFeatures>;

  distinct?: Distinct;

  /**
   * Whether to replace a highlighted word with the matched synonym.  By default, the original words are highlighted even if a synonym matches. For example, with `home` as a synonym for `house` and a search for `home`, records matching either \"home\" or \"house\" are included in the search results, and either \"home\" or \"house\" are highlighted.  With `replaceSynonymsInHighlight` set to `true`, a search for `home` still matches the same records, but all occurrences of \"house\" are replaced by \"home\" in the highlighted response.
   */
  replaceSynonymsInHighlight?: boolean;

  /**
   * Minimum proximity score for two matching words.  This adjusts the [Proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity) by equally scoring matches that are farther apart.  For example, if `minProximity` is 2, neighboring matches and matches with one word between them would have the same score.
   */
  minProximity?: number;

  /**
   * Properties to include in the API response of search and browse requests.  By default, all response properties are included. To reduce the response size, you can select which properties should be included.  An empty list may lead to an empty API response (except properties you can\'t exclude).  You can\'t exclude these properties: `message`, `warning`, `cursor`, `abTestVariantID`, or any property added by setting `getRankingInfo` to true.  Your search depends on the `hits` field. If you omit this field, searches won\'t return any results. Your UI might also depend on other properties, for example, for pagination. Before restricting the response size, check the impact on your search experience.
   */
  responseFields?: Array<string>;

  /**
   * Maximum number of facet values to return for each facet.
   */
  maxValuesPerFacet?: number;

  /**
   * Order in which to retrieve facet values.  - `count`.   Facet values are retrieved by decreasing count.   The count is the number of matching records containing this facet value.  - `alpha`.   Retrieve facet values alphabetically.  This setting doesn\'t influence how facet values are displayed in your UI (see `renderingContent`). For more information, see [facet value display](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/facet-display/js/).
   */
  sortFacetValuesBy?: string;

  /**
   * Whether the best matching attribute should be determined by minimum proximity.  This setting only affects ranking if the Attribute ranking criterion comes before Proximity in the `ranking` setting. If true, the best matching attribute is selected based on the minimum proximity of multiple matches. Otherwise, the best matching attribute is determined by the order in the `searchableAttributes` setting.
   */
  attributeCriteriaComputedByMinProximity?: boolean;

  renderingContent?: RenderingContent;

  /**
   * Whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).  This setting only has an effect if you activated Dynamic Re-Ranking for this index in the Algolia dashboard.
   */
  enableReRanking?: boolean;

  reRankingApplyFilter?: ReRankingApplyFilter | null;
};
