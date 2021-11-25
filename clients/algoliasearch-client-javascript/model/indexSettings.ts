import { BaseIndexSettings } from './baseIndexSettings';
import { IndexSettingsAsSearchParams } from './indexSettingsAsSearchParams';

export type IndexSettings = {
  /**
   * Creates replicas, exact copies of an index.
   */
  replicas?: Array<string>;
  /**
   * Set the maximum number of hits accessible via pagination.
   */
  paginationLimitedTo?: number;
  /**
   * A list of words for which you want to turn off typo tolerance.
   */
  disableTypoToleranceOnWords?: Array<string>;
  /**
   * Specify on which attributes to apply transliteration.
   */
  attributesToTransliterate?: Array<string>;
  /**
   * List of attributes on which to do a decomposition of camel case words.
   */
  camelCaseAttributes?: Array<string>;
  /**
   * Specify on which attributes in your index Algolia should apply word segmentation, also known as decompounding.
   */
  decompoundedAttributes?: { [key: string]: object };
  /**
   * Sets the languages at the index level for language-specific processing such as tokenization and normalization.
   */
  indexLanguages?: Array<string>;
  /**
   * Whether promoted results should match the filters of the current search, except for geographic filters.
   */
  filterPromotes?: boolean;
  /**
   * List of attributes on which you want to disable prefix matching.
   */
  disablePrefixOnAttributes?: Array<string>;
  /**
   * Enables compression of large integer arrays.
   */
  allowCompressionOfIntegerArray?: boolean;
  /**
   * List of numeric attributes that can be used as numerical filters.
   */
  numericAttributesForFiltering?: Array<string>;
  /**
   * Lets you store custom data in your indices.
   */
  userData?: { [key: string]: object };
  /**
   * The complete list of attributes used for searching.
   */
  searchableAttributes?: Array<string>;
  /**
   * The complete list of attributes that will be used for faceting.
   */
  attributesForFaceting?: Array<string>;
  /**
   * List of attributes that can’t be retrieved at query time.
   */
  unretrievableAttributes?: Array<string>;
  /**
   * This parameter controls which attributes to retrieve and which not to retrieve.
   */
  attributesToRetrieve?: Array<string>;
  /**
   * Restricts a given query to look in only a subset of your searchable attributes.
   */
  restrictSearchableAttributes?: Array<string>;
  /**
   * Controls how Algolia should sort your results.
   */
  ranking?: Array<string>;
  /**
   * Specifies the custom ranking criterion.
   */
  customRanking?: Array<string>;
  /**
   * Controls the relevancy threshold below which less relevant results aren’t included in the results.
   */
  relevancyStrictness?: number;
  /**
   * List of attributes to highlight.
   */
  attributesToHighlight?: Array<string>;
  /**
   * List of attributes to snippet, with an optional maximum number of words to snippet.
   */
  attributesToSnippet?: Array<string>;
  /**
   * The HTML string to insert before the highlighted parts in all highlight and snippet results.
   */
  highlightPreTag?: string;
  /**
   * The HTML string to insert after the highlighted parts in all highlight and snippet results.
   */
  highlightPostTag?: string;
  /**
   * String used as an ellipsis indicator when a snippet is truncated.
   */
  snippetEllipsisText?: string;
  /**
   * Restrict highlighting and snippeting to items that matched the query.
   */
  restrictHighlightAndSnippetArrays?: boolean;
  /**
   * Set the number of hits per page.
   */
  hitsPerPage?: number;
  /**
   * Minimum number of characters a word in the query string must contain to accept matches with 1 typo.
   */
  minWordSizefor1Typo?: number;
  /**
   * Minimum number of characters a word in the query string must contain to accept matches with 2 typos.
   */
  minWordSizefor2Typos?: number;
  /**
   * Controls whether typo tolerance is enabled and how it is applied.
   */
  typoTolerance?: IndexSettings.TypoToleranceEnum;
  /**
   * Whether to allow typos on numbers (“numeric tokens”) in the query string.
   */
  allowTyposOnNumericTokens?: boolean;
  /**
   * List of attributes on which you want to disable typo tolerance.
   */
  disableTypoToleranceOnAttributes?: Array<string>;
  /**
   * Control which separators are indexed.
   */
  separatorsToIndex?: string;
  /**
   * Treats singular, plurals, and other forms of declensions as matching terms.
   */
  ignorePlurals?: string;
  /**
   * Removes stop (common) words from the query before executing it.
   */
  removeStopWords?: string;
  /**
   * List of characters that the engine shouldn’t automatically normalize.
   */
  keepDiacriticsOnCharacters?: string;
  /**
   * Sets the languages to be used by language-specific settings and functionalities such as ignorePlurals, removeStopWords, and CJK word-detection.
   */
  queryLanguages?: Array<string>;
  /**
   * Splits compound words into their composing atoms in the query.
   */
  decompoundQuery?: boolean;
  /**
   * Whether Rules should be globally enabled.
   */
  enableRules?: boolean;
  /**
   * Enable the Personalization feature.
   */
  enablePersonalization?: boolean;
  /**
   * Controls if and how query words are interpreted as prefixes.
   */
  queryType?: IndexSettings.QueryTypeEnum;
  /**
   * Selects a strategy to remove words from the query when it doesn’t match any hits.
   */
  removeWordsIfNoResults?: IndexSettings.RemoveWordsIfNoResultsEnum;
  /**
   * Enables the advanced query syntax.
   */
  advancedSyntax?: boolean;
  /**
   * A list of words that should be considered as optional when found in the query.
   */
  optionalWords?: Array<string>;
  /**
   * List of attributes on which you want to disable the exact ranking criterion.
   */
  disableExactOnAttributes?: Array<string>;
  /**
   * Controls how the exact ranking criterion is computed when the query contains only one word.
   */
  exactOnSingleWordQuery?: IndexSettings.ExactOnSingleWordQueryEnum;
  /**
   * List of alternatives that should be considered an exact match by the exact ranking criterion.
   */
  alternativesAsExact?: Array<IndexSettings.AlternativesAsExactEnum>;
  /**
   * Allows you to specify which advanced syntax features are active when ‘advancedSyntax’ is enabled.
   */
  advancedSyntaxFeatures?: Array<IndexSettings.AdvancedSyntaxFeaturesEnum>;
  /**
   * Enables de-duplication or grouping of results.
   */
  distinct?: number;
  /**
   * Whether to take into account an index’s synonyms for a particular search.
   */
  synonyms?: boolean;
  /**
   * Whether to highlight and snippet the original word that matches the synonym or the synonym itself.
   */
  replaceSynonymsInHighlight?: boolean;
  /**
   * Precision of the proximity ranking criterion.
   */
  minProximity?: number;
  /**
   * Choose which fields to return in the API response. This parameters applies to search and browse queries.
   */
  responseFields?: Array<string>;
  /**
   * Maximum number of facet hits to return during a search for facet values.
   */
  maxFacetHits?: number;
  /**
   * When attribute is ranked above proximity in your ranking formula, proximity is used to select which searchable attribute is matched in the attribute ranking stage.
   */
  attributeCriteriaComputedByMinProximity?: boolean;
  /**
   * Content defining how the search interface should be rendered. Can be set via the settings for a default value and can be overridden via rules.
   */
  renderingContent?: object;
};

export namespace IndexSettings {
  export enum TypoToleranceEnum {
    True = 'true',
    False = 'false',
    Min = 'min',
    Strict = 'strict',
  }
  export enum QueryTypeEnum {
    PrefixLast = 'prefixLast',
    PrefixAll = 'prefixAll',
    PrefixNone = 'prefixNone',
  }
  export enum RemoveWordsIfNoResultsEnum {
    None = 'none',
    LastWords = 'lastWords',
    FirstWords = 'firstWords',
    AllOptional = 'allOptional',
  }
  export enum ExactOnSingleWordQueryEnum {
    Attribute = 'attribute',
    None = 'none',
    Word = 'word',
  }
  export enum AlternativesAsExactEnum {
    IgnorePlurals = 'ignorePlurals',
    SingleWordSynonym = 'singleWordSynonym',
    MultiWordsSynonym = 'multiWordsSynonym',
  }
  export enum AdvancedSyntaxFeaturesEnum {
    ExactPhrase = 'exactPhrase',
    ExcludeWords = 'excludeWords',
  }
}
