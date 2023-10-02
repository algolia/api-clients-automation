// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** IndexSettingsAsSearchParams */
public class IndexSettingsAsSearchParams {

  @JsonProperty("attributesForFaceting")
  private List<String> attributesForFaceting;

  @JsonProperty("attributesToRetrieve")
  private List<String> attributesToRetrieve;

  @JsonProperty("ranking")
  private List<String> ranking;

  @JsonProperty("customRanking")
  private List<String> customRanking;

  @JsonProperty("relevancyStrictness")
  private Integer relevancyStrictness;

  @JsonProperty("attributesToHighlight")
  private List<String> attributesToHighlight;

  @JsonProperty("attributesToSnippet")
  private List<String> attributesToSnippet;

  @JsonProperty("highlightPreTag")
  private String highlightPreTag;

  @JsonProperty("highlightPostTag")
  private String highlightPostTag;

  @JsonProperty("snippetEllipsisText")
  private String snippetEllipsisText;

  @JsonProperty("restrictHighlightAndSnippetArrays")
  private Boolean restrictHighlightAndSnippetArrays;

  @JsonProperty("hitsPerPage")
  private Integer hitsPerPage;

  @JsonProperty("minWordSizefor1Typo")
  private Integer minWordSizefor1Typo;

  @JsonProperty("minWordSizefor2Typos")
  private Integer minWordSizefor2Typos;

  @JsonProperty("typoTolerance")
  private TypoTolerance typoTolerance;

  @JsonProperty("allowTyposOnNumericTokens")
  private Boolean allowTyposOnNumericTokens;

  @JsonProperty("disableTypoToleranceOnAttributes")
  private List<String> disableTypoToleranceOnAttributes;

  @JsonProperty("ignorePlurals")
  private IgnorePlurals ignorePlurals;

  @JsonProperty("removeStopWords")
  private RemoveStopWords removeStopWords;

  @JsonProperty("keepDiacriticsOnCharacters")
  private String keepDiacriticsOnCharacters;

  @JsonProperty("queryLanguages")
  private List<String> queryLanguages;

  @JsonProperty("decompoundQuery")
  private Boolean decompoundQuery;

  @JsonProperty("enableRules")
  private Boolean enableRules;

  @JsonProperty("enablePersonalization")
  private Boolean enablePersonalization;

  @JsonProperty("queryType")
  private QueryType queryType;

  @JsonProperty("removeWordsIfNoResults")
  private RemoveWordsIfNoResults removeWordsIfNoResults;

  @JsonProperty("mode")
  private Mode mode;

  @JsonProperty("semanticSearch")
  private SemanticSearch semanticSearch;

  @JsonProperty("advancedSyntax")
  private Boolean advancedSyntax;

  @JsonProperty("optionalWords")
  private List<String> optionalWords;

  @JsonProperty("disableExactOnAttributes")
  private List<String> disableExactOnAttributes;

  @JsonProperty("exactOnSingleWordQuery")
  private ExactOnSingleWordQuery exactOnSingleWordQuery;

  @JsonProperty("alternativesAsExact")
  private List<AlternativesAsExact> alternativesAsExact;

  @JsonProperty("advancedSyntaxFeatures")
  private List<AdvancedSyntaxFeatures> advancedSyntaxFeatures;

  @JsonProperty("distinct")
  private Distinct distinct;

  @JsonProperty("replaceSynonymsInHighlight")
  private Boolean replaceSynonymsInHighlight;

  @JsonProperty("minProximity")
  private Integer minProximity;

  @JsonProperty("responseFields")
  private List<String> responseFields;

  @JsonProperty("maxFacetHits")
  private Integer maxFacetHits;

  @JsonProperty("maxValuesPerFacet")
  private Integer maxValuesPerFacet;

  @JsonProperty("sortFacetValuesBy")
  private String sortFacetValuesBy;

  @JsonProperty("attributeCriteriaComputedByMinProximity")
  private Boolean attributeCriteriaComputedByMinProximity;

  @JsonProperty("renderingContent")
  private RenderingContent renderingContent;

  @JsonProperty("enableReRanking")
  private Boolean enableReRanking;

  @JsonProperty("reRankingApplyFilter")
  private ReRankingApplyFilter reRankingApplyFilter;

  public IndexSettingsAsSearchParams setAttributesForFaceting(List<String> attributesForFaceting) {
    this.attributesForFaceting = attributesForFaceting;
    return this;
  }

  public IndexSettingsAsSearchParams addAttributesForFaceting(String attributesForFacetingItem) {
    if (this.attributesForFaceting == null) {
      this.attributesForFaceting = new ArrayList<>();
    }
    this.attributesForFaceting.add(attributesForFacetingItem);
    return this;
  }

  /**
   * Attributes used for
   * [faceting](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/) and
   * the
   * [modifiers](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers)
   * that can be applied: `filterOnly`, `searchable`, and `afterDistinct`.
   */
  @javax.annotation.Nullable
  public List<String> getAttributesForFaceting() {
    return attributesForFaceting;
  }

  public IndexSettingsAsSearchParams setAttributesToRetrieve(List<String> attributesToRetrieve) {
    this.attributesToRetrieve = attributesToRetrieve;
    return this;
  }

  public IndexSettingsAsSearchParams addAttributesToRetrieve(String attributesToRetrieveItem) {
    if (this.attributesToRetrieve == null) {
      this.attributesToRetrieve = new ArrayList<>();
    }
    this.attributesToRetrieve.add(attributesToRetrieveItem);
    return this;
  }

  /**
   * Attributes to include in the API response. To reduce the size of your response, you can
   * retrieve only some of the attributes. By default, the response includes all attributes.
   */
  @javax.annotation.Nullable
  public List<String> getAttributesToRetrieve() {
    return attributesToRetrieve;
  }

  public IndexSettingsAsSearchParams setRanking(List<String> ranking) {
    this.ranking = ranking;
    return this;
  }

  public IndexSettingsAsSearchParams addRanking(String rankingItem) {
    if (this.ranking == null) {
      this.ranking = new ArrayList<>();
    }
    this.ranking.add(rankingItem);
    return this;
  }

  /**
   * Determines the order in which Algolia [returns your
   * results](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/).
   */
  @javax.annotation.Nullable
  public List<String> getRanking() {
    return ranking;
  }

  public IndexSettingsAsSearchParams setCustomRanking(List<String> customRanking) {
    this.customRanking = customRanking;
    return this;
  }

  public IndexSettingsAsSearchParams addCustomRanking(String customRankingItem) {
    if (this.customRanking == null) {
      this.customRanking = new ArrayList<>();
    }
    this.customRanking.add(customRankingItem);
    return this;
  }

  /**
   * Specifies the [Custom ranking
   * criterion](https://www.algolia.com/doc/guides/managing-results/must-do/custom-ranking/). Use
   * the `asc` and `desc` modifiers to specify the ranking order: ascending or descending.
   */
  @javax.annotation.Nullable
  public List<String> getCustomRanking() {
    return customRanking;
  }

  public IndexSettingsAsSearchParams setRelevancyStrictness(Integer relevancyStrictness) {
    this.relevancyStrictness = relevancyStrictness;
    return this;
  }

  /** Relevancy threshold below which less relevant results aren't included in the results. */
  @javax.annotation.Nullable
  public Integer getRelevancyStrictness() {
    return relevancyStrictness;
  }

  public IndexSettingsAsSearchParams setAttributesToHighlight(List<String> attributesToHighlight) {
    this.attributesToHighlight = attributesToHighlight;
    return this;
  }

  public IndexSettingsAsSearchParams addAttributesToHighlight(String attributesToHighlightItem) {
    if (this.attributesToHighlight == null) {
      this.attributesToHighlight = new ArrayList<>();
    }
    this.attributesToHighlight.add(attributesToHighlightItem);
    return this;
  }

  /**
   * Attributes to highlight. Strings that match the search query in the attributes are highlighted
   * by surrounding them with HTML tags (`highlightPreTag` and `highlightPostTag`).
   */
  @javax.annotation.Nullable
  public List<String> getAttributesToHighlight() {
    return attributesToHighlight;
  }

  public IndexSettingsAsSearchParams setAttributesToSnippet(List<String> attributesToSnippet) {
    this.attributesToSnippet = attributesToSnippet;
    return this;
  }

  public IndexSettingsAsSearchParams addAttributesToSnippet(String attributesToSnippetItem) {
    if (this.attributesToSnippet == null) {
      this.attributesToSnippet = new ArrayList<>();
    }
    this.attributesToSnippet.add(attributesToSnippetItem);
    return this;
  }

  /**
   * Attributes to _snippet_. 'Snippeting' is shortening the attribute to a certain number of words.
   * If not specified, the attribute is shortened to the 10 words around the matching string but you
   * can specify the number. For example: `body:20`.
   */
  @javax.annotation.Nullable
  public List<String> getAttributesToSnippet() {
    return attributesToSnippet;
  }

  public IndexSettingsAsSearchParams setHighlightPreTag(String highlightPreTag) {
    this.highlightPreTag = highlightPreTag;
    return this;
  }

  /** HTML string to insert before the highlighted parts in all highlight and snippet results. */
  @javax.annotation.Nullable
  public String getHighlightPreTag() {
    return highlightPreTag;
  }

  public IndexSettingsAsSearchParams setHighlightPostTag(String highlightPostTag) {
    this.highlightPostTag = highlightPostTag;
    return this;
  }

  /** HTML string to insert after the highlighted parts in all highlight and snippet results. */
  @javax.annotation.Nullable
  public String getHighlightPostTag() {
    return highlightPostTag;
  }

  public IndexSettingsAsSearchParams setSnippetEllipsisText(String snippetEllipsisText) {
    this.snippetEllipsisText = snippetEllipsisText;
    return this;
  }

  /** String used as an ellipsis indicator when a snippet is truncated. */
  @javax.annotation.Nullable
  public String getSnippetEllipsisText() {
    return snippetEllipsisText;
  }

  public IndexSettingsAsSearchParams setRestrictHighlightAndSnippetArrays(Boolean restrictHighlightAndSnippetArrays) {
    this.restrictHighlightAndSnippetArrays = restrictHighlightAndSnippetArrays;
    return this;
  }

  /** Restrict highlighting and snippeting to items that matched the query. */
  @javax.annotation.Nullable
  public Boolean getRestrictHighlightAndSnippetArrays() {
    return restrictHighlightAndSnippetArrays;
  }

  public IndexSettingsAsSearchParams setHitsPerPage(Integer hitsPerPage) {
    this.hitsPerPage = hitsPerPage;
    return this;
  }

  /** Number of hits per page. minimum: 1 maximum: 1000 */
  @javax.annotation.Nullable
  public Integer getHitsPerPage() {
    return hitsPerPage;
  }

  public IndexSettingsAsSearchParams setMinWordSizefor1Typo(Integer minWordSizefor1Typo) {
    this.minWordSizefor1Typo = minWordSizefor1Typo;
    return this;
  }

  /**
   * Minimum number of characters a word in the query string must contain to accept matches with
   * [one
   * typo](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
   */
  @javax.annotation.Nullable
  public Integer getMinWordSizefor1Typo() {
    return minWordSizefor1Typo;
  }

  public IndexSettingsAsSearchParams setMinWordSizefor2Typos(Integer minWordSizefor2Typos) {
    this.minWordSizefor2Typos = minWordSizefor2Typos;
    return this;
  }

  /**
   * Minimum number of characters a word in the query string must contain to accept matches with
   * [two
   * typos](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/in-depth/configuring-typo-tolerance/#configuring-word-length-for-typos).
   */
  @javax.annotation.Nullable
  public Integer getMinWordSizefor2Typos() {
    return minWordSizefor2Typos;
  }

  public IndexSettingsAsSearchParams setTypoTolerance(TypoTolerance typoTolerance) {
    this.typoTolerance = typoTolerance;
    return this;
  }

  /** Get typoTolerance */
  @javax.annotation.Nullable
  public TypoTolerance getTypoTolerance() {
    return typoTolerance;
  }

  public IndexSettingsAsSearchParams setAllowTyposOnNumericTokens(Boolean allowTyposOnNumericTokens) {
    this.allowTyposOnNumericTokens = allowTyposOnNumericTokens;
    return this;
  }

  /** Whether to allow typos on numbers (\"numeric tokens\") in the query string. */
  @javax.annotation.Nullable
  public Boolean getAllowTyposOnNumericTokens() {
    return allowTyposOnNumericTokens;
  }

  public IndexSettingsAsSearchParams setDisableTypoToleranceOnAttributes(List<String> disableTypoToleranceOnAttributes) {
    this.disableTypoToleranceOnAttributes = disableTypoToleranceOnAttributes;
    return this;
  }

  public IndexSettingsAsSearchParams addDisableTypoToleranceOnAttributes(String disableTypoToleranceOnAttributesItem) {
    if (this.disableTypoToleranceOnAttributes == null) {
      this.disableTypoToleranceOnAttributes = new ArrayList<>();
    }
    this.disableTypoToleranceOnAttributes.add(disableTypoToleranceOnAttributesItem);
    return this;
  }

  /**
   * Attributes for which you want to turn off [typo
   * tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/).
   */
  @javax.annotation.Nullable
  public List<String> getDisableTypoToleranceOnAttributes() {
    return disableTypoToleranceOnAttributes;
  }

  public IndexSettingsAsSearchParams setIgnorePlurals(IgnorePlurals ignorePlurals) {
    this.ignorePlurals = ignorePlurals;
    return this;
  }

  /** Get ignorePlurals */
  @javax.annotation.Nullable
  public IgnorePlurals getIgnorePlurals() {
    return ignorePlurals;
  }

  public IndexSettingsAsSearchParams setRemoveStopWords(RemoveStopWords removeStopWords) {
    this.removeStopWords = removeStopWords;
    return this;
  }

  /** Get removeStopWords */
  @javax.annotation.Nullable
  public RemoveStopWords getRemoveStopWords() {
    return removeStopWords;
  }

  public IndexSettingsAsSearchParams setKeepDiacriticsOnCharacters(String keepDiacriticsOnCharacters) {
    this.keepDiacriticsOnCharacters = keepDiacriticsOnCharacters;
    return this;
  }

  /**
   * Characters that the engine shouldn't automatically
   * [normalize](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/).
   */
  @javax.annotation.Nullable
  public String getKeepDiacriticsOnCharacters() {
    return keepDiacriticsOnCharacters;
  }

  public IndexSettingsAsSearchParams setQueryLanguages(List<String> queryLanguages) {
    this.queryLanguages = queryLanguages;
    return this;
  }

  public IndexSettingsAsSearchParams addQueryLanguages(String queryLanguagesItem) {
    if (this.queryLanguages == null) {
      this.queryLanguages = new ArrayList<>();
    }
    this.queryLanguages.add(queryLanguagesItem);
    return this;
  }

  /**
   * Sets your user's search language. This adjusts language-specific settings and features such as
   * `ignorePlurals`, `removeStopWords`, and
   * [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk)
   * word detection.
   */
  @javax.annotation.Nullable
  public List<String> getQueryLanguages() {
    return queryLanguages;
  }

  public IndexSettingsAsSearchParams setDecompoundQuery(Boolean decompoundQuery) {
    this.decompoundQuery = decompoundQuery;
    return this;
  }

  /**
   * [Splits compound
   * words](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/#splitting-compound-words)
   * into their component word parts in the query.
   */
  @javax.annotation.Nullable
  public Boolean getDecompoundQuery() {
    return decompoundQuery;
  }

  public IndexSettingsAsSearchParams setEnableRules(Boolean enableRules) {
    this.enableRules = enableRules;
    return this;
  }

  /**
   * Incidates whether
   * [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/) are enabled.
   */
  @javax.annotation.Nullable
  public Boolean getEnableRules() {
    return enableRules;
  }

  public IndexSettingsAsSearchParams setEnablePersonalization(Boolean enablePersonalization) {
    this.enablePersonalization = enablePersonalization;
    return this;
  }

  /**
   * Incidates whether
   * [Personalization](https://www.algolia.com/doc/guides/personalization/what-is-personalization/)
   * is enabled.
   */
  @javax.annotation.Nullable
  public Boolean getEnablePersonalization() {
    return enablePersonalization;
  }

  public IndexSettingsAsSearchParams setQueryType(QueryType queryType) {
    this.queryType = queryType;
    return this;
  }

  /** Get queryType */
  @javax.annotation.Nullable
  public QueryType getQueryType() {
    return queryType;
  }

  public IndexSettingsAsSearchParams setRemoveWordsIfNoResults(RemoveWordsIfNoResults removeWordsIfNoResults) {
    this.removeWordsIfNoResults = removeWordsIfNoResults;
    return this;
  }

  /** Get removeWordsIfNoResults */
  @javax.annotation.Nullable
  public RemoveWordsIfNoResults getRemoveWordsIfNoResults() {
    return removeWordsIfNoResults;
  }

  public IndexSettingsAsSearchParams setMode(Mode mode) {
    this.mode = mode;
    return this;
  }

  /** Get mode */
  @javax.annotation.Nullable
  public Mode getMode() {
    return mode;
  }

  public IndexSettingsAsSearchParams setSemanticSearch(SemanticSearch semanticSearch) {
    this.semanticSearch = semanticSearch;
    return this;
  }

  /** Get semanticSearch */
  @javax.annotation.Nullable
  public SemanticSearch getSemanticSearch() {
    return semanticSearch;
  }

  public IndexSettingsAsSearchParams setAdvancedSyntax(Boolean advancedSyntax) {
    this.advancedSyntax = advancedSyntax;
    return this;
  }

  /**
   * Enables the [advanced query
   * syntax](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/#advanced-syntax).
   */
  @javax.annotation.Nullable
  public Boolean getAdvancedSyntax() {
    return advancedSyntax;
  }

  public IndexSettingsAsSearchParams setOptionalWords(List<String> optionalWords) {
    this.optionalWords = optionalWords;
    return this;
  }

  public IndexSettingsAsSearchParams addOptionalWords(String optionalWordsItem) {
    if (this.optionalWords == null) {
      this.optionalWords = new ArrayList<>();
    }
    this.optionalWords.add(optionalWordsItem);
    return this;
  }

  /**
   * Words which should be considered
   * [optional](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/#creating-a-list-of-optional-words)
   * when found in a query.
   */
  @javax.annotation.Nullable
  public List<String> getOptionalWords() {
    return optionalWords;
  }

  public IndexSettingsAsSearchParams setDisableExactOnAttributes(List<String> disableExactOnAttributes) {
    this.disableExactOnAttributes = disableExactOnAttributes;
    return this;
  }

  public IndexSettingsAsSearchParams addDisableExactOnAttributes(String disableExactOnAttributesItem) {
    if (this.disableExactOnAttributes == null) {
      this.disableExactOnAttributes = new ArrayList<>();
    }
    this.disableExactOnAttributes.add(disableExactOnAttributesItem);
    return this;
  }

  /**
   * Attributes for which you want to [turn off the exact ranking
   * criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).
   */
  @javax.annotation.Nullable
  public List<String> getDisableExactOnAttributes() {
    return disableExactOnAttributes;
  }

  public IndexSettingsAsSearchParams setExactOnSingleWordQuery(ExactOnSingleWordQuery exactOnSingleWordQuery) {
    this.exactOnSingleWordQuery = exactOnSingleWordQuery;
    return this;
  }

  /** Get exactOnSingleWordQuery */
  @javax.annotation.Nullable
  public ExactOnSingleWordQuery getExactOnSingleWordQuery() {
    return exactOnSingleWordQuery;
  }

  public IndexSettingsAsSearchParams setAlternativesAsExact(List<AlternativesAsExact> alternativesAsExact) {
    this.alternativesAsExact = alternativesAsExact;
    return this;
  }

  public IndexSettingsAsSearchParams addAlternativesAsExact(AlternativesAsExact alternativesAsExactItem) {
    if (this.alternativesAsExact == null) {
      this.alternativesAsExact = new ArrayList<>();
    }
    this.alternativesAsExact.add(alternativesAsExactItem);
    return this;
  }

  /**
   * Alternatives that should be considered an exact match by [the exact ranking
   * criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes).
   */
  @javax.annotation.Nullable
  public List<AlternativesAsExact> getAlternativesAsExact() {
    return alternativesAsExact;
  }

  public IndexSettingsAsSearchParams setAdvancedSyntaxFeatures(List<AdvancedSyntaxFeatures> advancedSyntaxFeatures) {
    this.advancedSyntaxFeatures = advancedSyntaxFeatures;
    return this;
  }

  public IndexSettingsAsSearchParams addAdvancedSyntaxFeatures(AdvancedSyntaxFeatures advancedSyntaxFeaturesItem) {
    if (this.advancedSyntaxFeatures == null) {
      this.advancedSyntaxFeatures = new ArrayList<>();
    }
    this.advancedSyntaxFeatures.add(advancedSyntaxFeaturesItem);
    return this;
  }

  /**
   * Allows you to specify which advanced syntax features are active when `advancedSyntax` is
   * enabled.
   */
  @javax.annotation.Nullable
  public List<AdvancedSyntaxFeatures> getAdvancedSyntaxFeatures() {
    return advancedSyntaxFeatures;
  }

  public IndexSettingsAsSearchParams setDistinct(Distinct distinct) {
    this.distinct = distinct;
    return this;
  }

  /** Get distinct */
  @javax.annotation.Nullable
  public Distinct getDistinct() {
    return distinct;
  }

  public IndexSettingsAsSearchParams setReplaceSynonymsInHighlight(Boolean replaceSynonymsInHighlight) {
    this.replaceSynonymsInHighlight = replaceSynonymsInHighlight;
    return this;
  }

  /**
   * Whether to highlight and snippet the original word that matches the synonym or the synonym
   * itself.
   */
  @javax.annotation.Nullable
  public Boolean getReplaceSynonymsInHighlight() {
    return replaceSynonymsInHighlight;
  }

  public IndexSettingsAsSearchParams setMinProximity(Integer minProximity) {
    this.minProximity = minProximity;
    return this;
  }

  /**
   * Precision of the [proximity ranking
   * criterion](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#proximity).
   * minimum: 1 maximum: 7
   */
  @javax.annotation.Nullable
  public Integer getMinProximity() {
    return minProximity;
  }

  public IndexSettingsAsSearchParams setResponseFields(List<String> responseFields) {
    this.responseFields = responseFields;
    return this;
  }

  public IndexSettingsAsSearchParams addResponseFields(String responseFieldsItem) {
    if (this.responseFields == null) {
      this.responseFields = new ArrayList<>();
    }
    this.responseFields.add(responseFieldsItem);
    return this;
  }

  /** Attributes to include in the API response for search and browse queries. */
  @javax.annotation.Nullable
  public List<String> getResponseFields() {
    return responseFields;
  }

  public IndexSettingsAsSearchParams setMaxFacetHits(Integer maxFacetHits) {
    this.maxFacetHits = maxFacetHits;
    return this;
  }

  /**
   * Maximum number of facet hits to return when [searching for facet
   * values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
   * maximum: 100
   */
  @javax.annotation.Nullable
  public Integer getMaxFacetHits() {
    return maxFacetHits;
  }

  public IndexSettingsAsSearchParams setMaxValuesPerFacet(Integer maxValuesPerFacet) {
    this.maxValuesPerFacet = maxValuesPerFacet;
    return this;
  }

  /** Maximum number of facet values to return for each facet. */
  @javax.annotation.Nullable
  public Integer getMaxValuesPerFacet() {
    return maxValuesPerFacet;
  }

  public IndexSettingsAsSearchParams setSortFacetValuesBy(String sortFacetValuesBy) {
    this.sortFacetValuesBy = sortFacetValuesBy;
    return this;
  }

  /** Controls how facet values are fetched. */
  @javax.annotation.Nullable
  public String getSortFacetValuesBy() {
    return sortFacetValuesBy;
  }

  public IndexSettingsAsSearchParams setAttributeCriteriaComputedByMinProximity(Boolean attributeCriteriaComputedByMinProximity) {
    this.attributeCriteriaComputedByMinProximity = attributeCriteriaComputedByMinProximity;
    return this;
  }

  /**
   * When the [Attribute criterion is ranked above
   * Proximity](https://www.algolia.com/doc/guides/managing-results/relevance-overview/in-depth/ranking-criteria/#attribute-and-proximity-combinations)
   * in your ranking formula, Proximity is used to select which searchable attribute is matched in
   * the Attribute ranking stage.
   */
  @javax.annotation.Nullable
  public Boolean getAttributeCriteriaComputedByMinProximity() {
    return attributeCriteriaComputedByMinProximity;
  }

  public IndexSettingsAsSearchParams setRenderingContent(RenderingContent renderingContent) {
    this.renderingContent = renderingContent;
    return this;
  }

  /** Get renderingContent */
  @javax.annotation.Nullable
  public RenderingContent getRenderingContent() {
    return renderingContent;
  }

  public IndexSettingsAsSearchParams setEnableReRanking(Boolean enableReRanking) {
    this.enableReRanking = enableReRanking;
    return this;
  }

  /**
   * Indicates whether this search will use [Dynamic
   * Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).
   */
  @javax.annotation.Nullable
  public Boolean getEnableReRanking() {
    return enableReRanking;
  }

  public IndexSettingsAsSearchParams setReRankingApplyFilter(ReRankingApplyFilter reRankingApplyFilter) {
    this.reRankingApplyFilter = reRankingApplyFilter;
    return this;
  }

  /** Get reRankingApplyFilter */
  @javax.annotation.Nullable
  public ReRankingApplyFilter getReRankingApplyFilter() {
    return reRankingApplyFilter;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexSettingsAsSearchParams indexSettingsAsSearchParams = (IndexSettingsAsSearchParams) o;
    return (
      Objects.equals(this.attributesForFaceting, indexSettingsAsSearchParams.attributesForFaceting) &&
      Objects.equals(this.attributesToRetrieve, indexSettingsAsSearchParams.attributesToRetrieve) &&
      Objects.equals(this.ranking, indexSettingsAsSearchParams.ranking) &&
      Objects.equals(this.customRanking, indexSettingsAsSearchParams.customRanking) &&
      Objects.equals(this.relevancyStrictness, indexSettingsAsSearchParams.relevancyStrictness) &&
      Objects.equals(this.attributesToHighlight, indexSettingsAsSearchParams.attributesToHighlight) &&
      Objects.equals(this.attributesToSnippet, indexSettingsAsSearchParams.attributesToSnippet) &&
      Objects.equals(this.highlightPreTag, indexSettingsAsSearchParams.highlightPreTag) &&
      Objects.equals(this.highlightPostTag, indexSettingsAsSearchParams.highlightPostTag) &&
      Objects.equals(this.snippetEllipsisText, indexSettingsAsSearchParams.snippetEllipsisText) &&
      Objects.equals(this.restrictHighlightAndSnippetArrays, indexSettingsAsSearchParams.restrictHighlightAndSnippetArrays) &&
      Objects.equals(this.hitsPerPage, indexSettingsAsSearchParams.hitsPerPage) &&
      Objects.equals(this.minWordSizefor1Typo, indexSettingsAsSearchParams.minWordSizefor1Typo) &&
      Objects.equals(this.minWordSizefor2Typos, indexSettingsAsSearchParams.minWordSizefor2Typos) &&
      Objects.equals(this.typoTolerance, indexSettingsAsSearchParams.typoTolerance) &&
      Objects.equals(this.allowTyposOnNumericTokens, indexSettingsAsSearchParams.allowTyposOnNumericTokens) &&
      Objects.equals(this.disableTypoToleranceOnAttributes, indexSettingsAsSearchParams.disableTypoToleranceOnAttributes) &&
      Objects.equals(this.ignorePlurals, indexSettingsAsSearchParams.ignorePlurals) &&
      Objects.equals(this.removeStopWords, indexSettingsAsSearchParams.removeStopWords) &&
      Objects.equals(this.keepDiacriticsOnCharacters, indexSettingsAsSearchParams.keepDiacriticsOnCharacters) &&
      Objects.equals(this.queryLanguages, indexSettingsAsSearchParams.queryLanguages) &&
      Objects.equals(this.decompoundQuery, indexSettingsAsSearchParams.decompoundQuery) &&
      Objects.equals(this.enableRules, indexSettingsAsSearchParams.enableRules) &&
      Objects.equals(this.enablePersonalization, indexSettingsAsSearchParams.enablePersonalization) &&
      Objects.equals(this.queryType, indexSettingsAsSearchParams.queryType) &&
      Objects.equals(this.removeWordsIfNoResults, indexSettingsAsSearchParams.removeWordsIfNoResults) &&
      Objects.equals(this.mode, indexSettingsAsSearchParams.mode) &&
      Objects.equals(this.semanticSearch, indexSettingsAsSearchParams.semanticSearch) &&
      Objects.equals(this.advancedSyntax, indexSettingsAsSearchParams.advancedSyntax) &&
      Objects.equals(this.optionalWords, indexSettingsAsSearchParams.optionalWords) &&
      Objects.equals(this.disableExactOnAttributes, indexSettingsAsSearchParams.disableExactOnAttributes) &&
      Objects.equals(this.exactOnSingleWordQuery, indexSettingsAsSearchParams.exactOnSingleWordQuery) &&
      Objects.equals(this.alternativesAsExact, indexSettingsAsSearchParams.alternativesAsExact) &&
      Objects.equals(this.advancedSyntaxFeatures, indexSettingsAsSearchParams.advancedSyntaxFeatures) &&
      Objects.equals(this.distinct, indexSettingsAsSearchParams.distinct) &&
      Objects.equals(this.replaceSynonymsInHighlight, indexSettingsAsSearchParams.replaceSynonymsInHighlight) &&
      Objects.equals(this.minProximity, indexSettingsAsSearchParams.minProximity) &&
      Objects.equals(this.responseFields, indexSettingsAsSearchParams.responseFields) &&
      Objects.equals(this.maxFacetHits, indexSettingsAsSearchParams.maxFacetHits) &&
      Objects.equals(this.maxValuesPerFacet, indexSettingsAsSearchParams.maxValuesPerFacet) &&
      Objects.equals(this.sortFacetValuesBy, indexSettingsAsSearchParams.sortFacetValuesBy) &&
      Objects.equals(this.attributeCriteriaComputedByMinProximity, indexSettingsAsSearchParams.attributeCriteriaComputedByMinProximity) &&
      Objects.equals(this.renderingContent, indexSettingsAsSearchParams.renderingContent) &&
      Objects.equals(this.enableReRanking, indexSettingsAsSearchParams.enableReRanking) &&
      Objects.equals(this.reRankingApplyFilter, indexSettingsAsSearchParams.reRankingApplyFilter)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      attributesForFaceting,
      attributesToRetrieve,
      ranking,
      customRanking,
      relevancyStrictness,
      attributesToHighlight,
      attributesToSnippet,
      highlightPreTag,
      highlightPostTag,
      snippetEllipsisText,
      restrictHighlightAndSnippetArrays,
      hitsPerPage,
      minWordSizefor1Typo,
      minWordSizefor2Typos,
      typoTolerance,
      allowTyposOnNumericTokens,
      disableTypoToleranceOnAttributes,
      ignorePlurals,
      removeStopWords,
      keepDiacriticsOnCharacters,
      queryLanguages,
      decompoundQuery,
      enableRules,
      enablePersonalization,
      queryType,
      removeWordsIfNoResults,
      mode,
      semanticSearch,
      advancedSyntax,
      optionalWords,
      disableExactOnAttributes,
      exactOnSingleWordQuery,
      alternativesAsExact,
      advancedSyntaxFeatures,
      distinct,
      replaceSynonymsInHighlight,
      minProximity,
      responseFields,
      maxFacetHits,
      maxValuesPerFacet,
      sortFacetValuesBy,
      attributeCriteriaComputedByMinProximity,
      renderingContent,
      enableReRanking,
      reRankingApplyFilter
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexSettingsAsSearchParams {\n");
    sb.append("    attributesForFaceting: ").append(toIndentedString(attributesForFaceting)).append("\n");
    sb.append("    attributesToRetrieve: ").append(toIndentedString(attributesToRetrieve)).append("\n");
    sb.append("    ranking: ").append(toIndentedString(ranking)).append("\n");
    sb.append("    customRanking: ").append(toIndentedString(customRanking)).append("\n");
    sb.append("    relevancyStrictness: ").append(toIndentedString(relevancyStrictness)).append("\n");
    sb.append("    attributesToHighlight: ").append(toIndentedString(attributesToHighlight)).append("\n");
    sb.append("    attributesToSnippet: ").append(toIndentedString(attributesToSnippet)).append("\n");
    sb.append("    highlightPreTag: ").append(toIndentedString(highlightPreTag)).append("\n");
    sb.append("    highlightPostTag: ").append(toIndentedString(highlightPostTag)).append("\n");
    sb.append("    snippetEllipsisText: ").append(toIndentedString(snippetEllipsisText)).append("\n");
    sb.append("    restrictHighlightAndSnippetArrays: ").append(toIndentedString(restrictHighlightAndSnippetArrays)).append("\n");
    sb.append("    hitsPerPage: ").append(toIndentedString(hitsPerPage)).append("\n");
    sb.append("    minWordSizefor1Typo: ").append(toIndentedString(minWordSizefor1Typo)).append("\n");
    sb.append("    minWordSizefor2Typos: ").append(toIndentedString(minWordSizefor2Typos)).append("\n");
    sb.append("    typoTolerance: ").append(toIndentedString(typoTolerance)).append("\n");
    sb.append("    allowTyposOnNumericTokens: ").append(toIndentedString(allowTyposOnNumericTokens)).append("\n");
    sb.append("    disableTypoToleranceOnAttributes: ").append(toIndentedString(disableTypoToleranceOnAttributes)).append("\n");
    sb.append("    ignorePlurals: ").append(toIndentedString(ignorePlurals)).append("\n");
    sb.append("    removeStopWords: ").append(toIndentedString(removeStopWords)).append("\n");
    sb.append("    keepDiacriticsOnCharacters: ").append(toIndentedString(keepDiacriticsOnCharacters)).append("\n");
    sb.append("    queryLanguages: ").append(toIndentedString(queryLanguages)).append("\n");
    sb.append("    decompoundQuery: ").append(toIndentedString(decompoundQuery)).append("\n");
    sb.append("    enableRules: ").append(toIndentedString(enableRules)).append("\n");
    sb.append("    enablePersonalization: ").append(toIndentedString(enablePersonalization)).append("\n");
    sb.append("    queryType: ").append(toIndentedString(queryType)).append("\n");
    sb.append("    removeWordsIfNoResults: ").append(toIndentedString(removeWordsIfNoResults)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    semanticSearch: ").append(toIndentedString(semanticSearch)).append("\n");
    sb.append("    advancedSyntax: ").append(toIndentedString(advancedSyntax)).append("\n");
    sb.append("    optionalWords: ").append(toIndentedString(optionalWords)).append("\n");
    sb.append("    disableExactOnAttributes: ").append(toIndentedString(disableExactOnAttributes)).append("\n");
    sb.append("    exactOnSingleWordQuery: ").append(toIndentedString(exactOnSingleWordQuery)).append("\n");
    sb.append("    alternativesAsExact: ").append(toIndentedString(alternativesAsExact)).append("\n");
    sb.append("    advancedSyntaxFeatures: ").append(toIndentedString(advancedSyntaxFeatures)).append("\n");
    sb.append("    distinct: ").append(toIndentedString(distinct)).append("\n");
    sb.append("    replaceSynonymsInHighlight: ").append(toIndentedString(replaceSynonymsInHighlight)).append("\n");
    sb.append("    minProximity: ").append(toIndentedString(minProximity)).append("\n");
    sb.append("    responseFields: ").append(toIndentedString(responseFields)).append("\n");
    sb.append("    maxFacetHits: ").append(toIndentedString(maxFacetHits)).append("\n");
    sb.append("    maxValuesPerFacet: ").append(toIndentedString(maxValuesPerFacet)).append("\n");
    sb.append("    sortFacetValuesBy: ").append(toIndentedString(sortFacetValuesBy)).append("\n");
    sb
      .append("    attributeCriteriaComputedByMinProximity: ")
      .append(toIndentedString(attributeCriteriaComputedByMinProximity))
      .append("\n");
    sb.append("    renderingContent: ").append(toIndentedString(renderingContent)).append("\n");
    sb.append("    enableReRanking: ").append(toIndentedString(enableReRanking)).append("\n");
    sb.append("    reRankingApplyFilter: ").append(toIndentedString(reRankingApplyFilter)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
