//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using Algolia.Search.Models;
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Recommend;

/// <summary>
/// IndexSettingsAsSearchParams
/// </summary>
[DataContract(Name = "indexSettingsAsSearchParams")]
[JsonObject(MemberSerialization.OptOut)]
public partial class IndexSettingsAsSearchParams
{

  /// <summary>
  /// Gets or Sets QueryType
  /// </summary>
  [DataMember(Name = "queryType", EmitDefaultValue = false)]
  public QueryType QueryType { get; set; }

  /// <summary>
  /// Gets or Sets RemoveWordsIfNoResults
  /// </summary>
  [DataMember(Name = "removeWordsIfNoResults", EmitDefaultValue = false)]
  public RemoveWordsIfNoResults RemoveWordsIfNoResults { get; set; }

  /// <summary>
  /// Gets or Sets Mode
  /// </summary>
  [DataMember(Name = "mode", EmitDefaultValue = false)]
  public Mode Mode { get; set; }

  /// <summary>
  /// Gets or Sets ExactOnSingleWordQuery
  /// </summary>
  [DataMember(Name = "exactOnSingleWordQuery", EmitDefaultValue = false)]
  public ExactOnSingleWordQuery ExactOnSingleWordQuery { get; set; }
  /// <summary>
  /// Initializes a new instance of the IndexSettingsAsSearchParams class.
  /// </summary>
  public IndexSettingsAsSearchParams()
  {
  }

  /// <summary>
  /// Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/) and the [modifiers](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) that can be applied: `filterOnly`, `searchable`, and `afterDistinct`. 
  /// </summary>
  /// <value>Attributes used for [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/) and the [modifiers](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) that can be applied: `filterOnly`, `searchable`, and `afterDistinct`. </value>
  [DataMember(Name = "attributesForFaceting", EmitDefaultValue = false)]
  public List<string> AttributesForFaceting { get; set; }

  /// <summary>
  /// Attributes to include in the API response. To reduce the size of your response, you can retrieve only some of the attributes. By default, the response includes all attributes.
  /// </summary>
  /// <value>Attributes to include in the API response. To reduce the size of your response, you can retrieve only some of the attributes. By default, the response includes all attributes.</value>
  [DataMember(Name = "attributesToRetrieve", EmitDefaultValue = false)]
  public List<string> AttributesToRetrieve { get; set; }

  /// <summary>
  /// Determines the order in which Algolia [returns your results](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/).
  /// </summary>
  /// <value>Determines the order in which Algolia [returns your results](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/).</value>
  [DataMember(Name = "ranking", EmitDefaultValue = false)]
  public List<string> Ranking { get; set; }

  /// <summary>
  /// Specifies the [Custom ranking criterion](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Use the `asc` and `desc` modifiers to specify the ranking order: ascending or descending. 
  /// </summary>
  /// <value>Specifies the [Custom ranking criterion](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Use the `asc` and `desc` modifiers to specify the ranking order: ascending or descending. </value>
  [DataMember(Name = "customRanking", EmitDefaultValue = false)]
  public List<string> CustomRanking { get; set; }

  /// <summary>
  /// Relevancy threshold below which less relevant results aren't included in the results.
  /// </summary>
  /// <value>Relevancy threshold below which less relevant results aren't included in the results.</value>
  [DataMember(Name = "relevancyStrictness", EmitDefaultValue = false)]
  public int? RelevancyStrictness { get; set; }

  /// <summary>
  /// Attributes to highlight. Strings that match the search query in the attributes are highlighted by surrounding them with HTML tags (`highlightPreTag` and `highlightPostTag`).
  /// </summary>
  /// <value>Attributes to highlight. Strings that match the search query in the attributes are highlighted by surrounding them with HTML tags (`highlightPreTag` and `highlightPostTag`).</value>
  [DataMember(Name = "attributesToHighlight", EmitDefaultValue = false)]
  public List<string> AttributesToHighlight { get; set; }

  /// <summary>
  /// Attributes to _snippet_. 'Snippeting' is shortening the attribute to a certain number of words. If not specified, the attribute is shortened to the 10 words around the matching string but you can specify the number. For example: `body:20`. 
  /// </summary>
  /// <value>Attributes to _snippet_. 'Snippeting' is shortening the attribute to a certain number of words. If not specified, the attribute is shortened to the 10 words around the matching string but you can specify the number. For example: `body:20`. </value>
  [DataMember(Name = "attributesToSnippet", EmitDefaultValue = false)]
  public List<string> AttributesToSnippet { get; set; }

  /// <summary>
  /// HTML string to insert before the highlighted parts in all highlight and snippet results.
  /// </summary>
  /// <value>HTML string to insert before the highlighted parts in all highlight and snippet results.</value>
  [DataMember(Name = "highlightPreTag", EmitDefaultValue = false)]
  public string HighlightPreTag { get; set; }

  /// <summary>
  /// HTML string to insert after the highlighted parts in all highlight and snippet results.
  /// </summary>
  /// <value>HTML string to insert after the highlighted parts in all highlight and snippet results.</value>
  [DataMember(Name = "highlightPostTag", EmitDefaultValue = false)]
  public string HighlightPostTag { get; set; }

  /// <summary>
  /// String used as an ellipsis indicator when a snippet is truncated.
  /// </summary>
  /// <value>String used as an ellipsis indicator when a snippet is truncated.</value>
  [DataMember(Name = "snippetEllipsisText", EmitDefaultValue = false)]
  public string SnippetEllipsisText { get; set; }

  /// <summary>
  /// Restrict highlighting and snippeting to items that matched the query.
  /// </summary>
  /// <value>Restrict highlighting and snippeting to items that matched the query.</value>
  [DataMember(Name = "restrictHighlightAndSnippetArrays", EmitDefaultValue = false)]
  public bool? RestrictHighlightAndSnippetArrays { get; set; }

  /// <summary>
  /// Number of hits per page.
  /// </summary>
  /// <value>Number of hits per page.</value>
  [DataMember(Name = "hitsPerPage", EmitDefaultValue = false)]
  public int? HitsPerPage { get; set; }

  /// <summary>
  /// Minimum number of characters a word in the query string must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
  /// </summary>
  /// <value>Minimum number of characters a word in the query string must contain to accept matches with [one typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).</value>
  [DataMember(Name = "minWordSizefor1Typo", EmitDefaultValue = false)]
  public int? MinWordSizefor1Typo { get; set; }

  /// <summary>
  /// Minimum number of characters a word in the query string must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
  /// </summary>
  /// <value>Minimum number of characters a word in the query string must contain to accept matches with [two typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).</value>
  [DataMember(Name = "minWordSizefor2Typos", EmitDefaultValue = false)]
  public int? MinWordSizefor2Typos { get; set; }

  /// <summary>
  /// Gets or Sets TypoTolerance
  /// </summary>
  [DataMember(Name = "typoTolerance", EmitDefaultValue = false)]
  public TypoTolerance TypoTolerance { get; set; }

  /// <summary>
  /// Whether to allow typos on numbers (\"numeric tokens\") in the query string.
  /// </summary>
  /// <value>Whether to allow typos on numbers (\"numeric tokens\") in the query string.</value>
  [DataMember(Name = "allowTyposOnNumericTokens", EmitDefaultValue = false)]
  public bool? AllowTyposOnNumericTokens { get; set; }

  /// <summary>
  /// Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).
  /// </summary>
  /// <value>Attributes for which you want to turn off [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).</value>
  [DataMember(Name = "disableTypoToleranceOnAttributes", EmitDefaultValue = false)]
  public List<string> DisableTypoToleranceOnAttributes { get; set; }

  /// <summary>
  /// Gets or Sets IgnorePlurals
  /// </summary>
  [DataMember(Name = "ignorePlurals", EmitDefaultValue = false)]
  public IgnorePlurals IgnorePlurals { get; set; }

  /// <summary>
  /// Gets or Sets RemoveStopWords
  /// </summary>
  [DataMember(Name = "removeStopWords", EmitDefaultValue = false)]
  public RemoveStopWords RemoveStopWords { get; set; }

  /// <summary>
  /// Characters that the engine shouldn't automatically [normalize](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
  /// </summary>
  /// <value>Characters that the engine shouldn't automatically [normalize](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).</value>
  [DataMember(Name = "keepDiacriticsOnCharacters", EmitDefaultValue = false)]
  public string KeepDiacriticsOnCharacters { get; set; }

  /// <summary>
  /// Sets your user's search language. This adjusts language-specific settings and features such as `ignorePlurals`, `removeStopWords`, and [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) word detection.
  /// </summary>
  /// <value>Sets your user's search language. This adjusts language-specific settings and features such as `ignorePlurals`, `removeStopWords`, and [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) word detection.</value>
  [DataMember(Name = "queryLanguages", EmitDefaultValue = false)]
  public List<string> QueryLanguages { get; set; }

  /// <summary>
  /// [Splits compound words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words) into their component word parts in the query. 
  /// </summary>
  /// <value>[Splits compound words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words) into their component word parts in the query. </value>
  [DataMember(Name = "decompoundQuery", EmitDefaultValue = false)]
  public bool? DecompoundQuery { get; set; }

  /// <summary>
  /// Incidates whether [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/) are enabled.
  /// </summary>
  /// <value>Incidates whether [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/) are enabled.</value>
  [DataMember(Name = "enableRules", EmitDefaultValue = false)]
  public bool? EnableRules { get; set; }

  /// <summary>
  /// Incidates whether [Personalization](https://www.algolia.com/doc/guides/personalization/what-is-personalization/) is enabled.
  /// </summary>
  /// <value>Incidates whether [Personalization](https://www.algolia.com/doc/guides/personalization/what-is-personalization/) is enabled.</value>
  [DataMember(Name = "enablePersonalization", EmitDefaultValue = false)]
  public bool? EnablePersonalization { get; set; }

  /// <summary>
  /// Gets or Sets SemanticSearch
  /// </summary>
  [DataMember(Name = "semanticSearch", EmitDefaultValue = false)]
  public SemanticSearch SemanticSearch { get; set; }

  /// <summary>
  /// Enables the [advanced query syntax](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#advanced-syntax).
  /// </summary>
  /// <value>Enables the [advanced query syntax](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#advanced-syntax).</value>
  [DataMember(Name = "advancedSyntax", EmitDefaultValue = false)]
  public bool? AdvancedSyntax { get; set; }

  /// <summary>
  /// Words which should be considered [optional](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words) when found in a query.
  /// </summary>
  /// <value>Words which should be considered [optional](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words) when found in a query.</value>
  [DataMember(Name = "optionalWords", EmitDefaultValue = false)]
  public List<string> OptionalWords { get; set; }

  /// <summary>
  /// Attributes for which you want to [turn off the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).
  /// </summary>
  /// <value>Attributes for which you want to [turn off the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).</value>
  [DataMember(Name = "disableExactOnAttributes", EmitDefaultValue = false)]
  public List<string> DisableExactOnAttributes { get; set; }

  /// <summary>
  /// Alternatives that should be considered an exact match by [the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).
  /// </summary>
  /// <value>Alternatives that should be considered an exact match by [the exact ranking criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).</value>
  [DataMember(Name = "alternativesAsExact", EmitDefaultValue = false)]
  public List<AlternativesAsExact> AlternativesAsExact { get; set; }

  /// <summary>
  /// Allows you to specify which advanced syntax features are active when `advancedSyntax` is enabled.
  /// </summary>
  /// <value>Allows you to specify which advanced syntax features are active when `advancedSyntax` is enabled.</value>
  [DataMember(Name = "advancedSyntaxFeatures", EmitDefaultValue = false)]
  public List<AdvancedSyntaxFeatures> AdvancedSyntaxFeatures { get; set; }

  /// <summary>
  /// Gets or Sets Distinct
  /// </summary>
  [DataMember(Name = "distinct", EmitDefaultValue = false)]
  public Distinct Distinct { get; set; }

  /// <summary>
  /// Whether to highlight and snippet the original word that matches the synonym or the synonym itself.
  /// </summary>
  /// <value>Whether to highlight and snippet the original word that matches the synonym or the synonym itself.</value>
  [DataMember(Name = "replaceSynonymsInHighlight", EmitDefaultValue = false)]
  public bool? ReplaceSynonymsInHighlight { get; set; }

  /// <summary>
  /// Precision of the [proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity).
  /// </summary>
  /// <value>Precision of the [proximity ranking criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity).</value>
  [DataMember(Name = "minProximity", EmitDefaultValue = false)]
  public int? MinProximity { get; set; }

  /// <summary>
  /// Attributes to include in the API response for search and browse queries.
  /// </summary>
  /// <value>Attributes to include in the API response for search and browse queries.</value>
  [DataMember(Name = "responseFields", EmitDefaultValue = false)]
  public List<string> ResponseFields { get; set; }

  /// <summary>
  /// Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
  /// </summary>
  /// <value>Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).</value>
  [DataMember(Name = "maxFacetHits", EmitDefaultValue = false)]
  public int? MaxFacetHits { get; set; }

  /// <summary>
  /// Maximum number of facet values to return for each facet.
  /// </summary>
  /// <value>Maximum number of facet values to return for each facet.</value>
  [DataMember(Name = "maxValuesPerFacet", EmitDefaultValue = false)]
  public int? MaxValuesPerFacet { get; set; }

  /// <summary>
  /// Controls how facet values are fetched.
  /// </summary>
  /// <value>Controls how facet values are fetched.</value>
  [DataMember(Name = "sortFacetValuesBy", EmitDefaultValue = false)]
  public string SortFacetValuesBy { get; set; }

  /// <summary>
  /// When the [Attribute criterion is ranked above Proximity](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute-and-proximity-combinations) in your ranking formula, Proximity is used to select which searchable attribute is matched in the Attribute ranking stage.
  /// </summary>
  /// <value>When the [Attribute criterion is ranked above Proximity](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute-and-proximity-combinations) in your ranking formula, Proximity is used to select which searchable attribute is matched in the Attribute ranking stage.</value>
  [DataMember(Name = "attributeCriteriaComputedByMinProximity", EmitDefaultValue = false)]
  public bool? AttributeCriteriaComputedByMinProximity { get; set; }

  /// <summary>
  /// Gets or Sets RenderingContent
  /// </summary>
  [DataMember(Name = "renderingContent", EmitDefaultValue = false)]
  public RenderingContent RenderingContent { get; set; }

  /// <summary>
  /// Indicates whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).
  /// </summary>
  /// <value>Indicates whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).</value>
  [DataMember(Name = "enableReRanking", EmitDefaultValue = false)]
  public bool? EnableReRanking { get; set; }

  /// <summary>
  /// Gets or Sets ReRankingApplyFilter
  /// </summary>
  [DataMember(Name = "reRankingApplyFilter", EmitDefaultValue = false)]
  public ReRankingApplyFilter ReRankingApplyFilter { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class IndexSettingsAsSearchParams {\n");
    sb.Append("  AttributesForFaceting: ").Append(AttributesForFaceting).Append("\n");
    sb.Append("  AttributesToRetrieve: ").Append(AttributesToRetrieve).Append("\n");
    sb.Append("  Ranking: ").Append(Ranking).Append("\n");
    sb.Append("  CustomRanking: ").Append(CustomRanking).Append("\n");
    sb.Append("  RelevancyStrictness: ").Append(RelevancyStrictness).Append("\n");
    sb.Append("  AttributesToHighlight: ").Append(AttributesToHighlight).Append("\n");
    sb.Append("  AttributesToSnippet: ").Append(AttributesToSnippet).Append("\n");
    sb.Append("  HighlightPreTag: ").Append(HighlightPreTag).Append("\n");
    sb.Append("  HighlightPostTag: ").Append(HighlightPostTag).Append("\n");
    sb.Append("  SnippetEllipsisText: ").Append(SnippetEllipsisText).Append("\n");
    sb.Append("  RestrictHighlightAndSnippetArrays: ").Append(RestrictHighlightAndSnippetArrays).Append("\n");
    sb.Append("  HitsPerPage: ").Append(HitsPerPage).Append("\n");
    sb.Append("  MinWordSizefor1Typo: ").Append(MinWordSizefor1Typo).Append("\n");
    sb.Append("  MinWordSizefor2Typos: ").Append(MinWordSizefor2Typos).Append("\n");
    sb.Append("  TypoTolerance: ").Append(TypoTolerance).Append("\n");
    sb.Append("  AllowTyposOnNumericTokens: ").Append(AllowTyposOnNumericTokens).Append("\n");
    sb.Append("  DisableTypoToleranceOnAttributes: ").Append(DisableTypoToleranceOnAttributes).Append("\n");
    sb.Append("  IgnorePlurals: ").Append(IgnorePlurals).Append("\n");
    sb.Append("  RemoveStopWords: ").Append(RemoveStopWords).Append("\n");
    sb.Append("  KeepDiacriticsOnCharacters: ").Append(KeepDiacriticsOnCharacters).Append("\n");
    sb.Append("  QueryLanguages: ").Append(QueryLanguages).Append("\n");
    sb.Append("  DecompoundQuery: ").Append(DecompoundQuery).Append("\n");
    sb.Append("  EnableRules: ").Append(EnableRules).Append("\n");
    sb.Append("  EnablePersonalization: ").Append(EnablePersonalization).Append("\n");
    sb.Append("  QueryType: ").Append(QueryType).Append("\n");
    sb.Append("  RemoveWordsIfNoResults: ").Append(RemoveWordsIfNoResults).Append("\n");
    sb.Append("  Mode: ").Append(Mode).Append("\n");
    sb.Append("  SemanticSearch: ").Append(SemanticSearch).Append("\n");
    sb.Append("  AdvancedSyntax: ").Append(AdvancedSyntax).Append("\n");
    sb.Append("  OptionalWords: ").Append(OptionalWords).Append("\n");
    sb.Append("  DisableExactOnAttributes: ").Append(DisableExactOnAttributes).Append("\n");
    sb.Append("  ExactOnSingleWordQuery: ").Append(ExactOnSingleWordQuery).Append("\n");
    sb.Append("  AlternativesAsExact: ").Append(AlternativesAsExact).Append("\n");
    sb.Append("  AdvancedSyntaxFeatures: ").Append(AdvancedSyntaxFeatures).Append("\n");
    sb.Append("  Distinct: ").Append(Distinct).Append("\n");
    sb.Append("  ReplaceSynonymsInHighlight: ").Append(ReplaceSynonymsInHighlight).Append("\n");
    sb.Append("  MinProximity: ").Append(MinProximity).Append("\n");
    sb.Append("  ResponseFields: ").Append(ResponseFields).Append("\n");
    sb.Append("  MaxFacetHits: ").Append(MaxFacetHits).Append("\n");
    sb.Append("  MaxValuesPerFacet: ").Append(MaxValuesPerFacet).Append("\n");
    sb.Append("  SortFacetValuesBy: ").Append(SortFacetValuesBy).Append("\n");
    sb.Append("  AttributeCriteriaComputedByMinProximity: ").Append(AttributeCriteriaComputedByMinProximity).Append("\n");
    sb.Append("  RenderingContent: ").Append(RenderingContent).Append("\n");
    sb.Append("  EnableReRanking: ").Append(EnableReRanking).Append("\n");
    sb.Append("  ReRankingApplyFilter: ").Append(ReRankingApplyFilter).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonConvert.SerializeObject(this, Formatting.Indented);
  }

}

