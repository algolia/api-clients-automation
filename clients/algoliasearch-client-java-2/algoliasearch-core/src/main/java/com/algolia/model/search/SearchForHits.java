package com.algolia.model.search;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** SearchForHits */
public class SearchForHits {

  @SerializedName("params")
  private String params;

  @SerializedName("query")
  private String query;

  @SerializedName("similarQuery")
  private String similarQuery;

  @SerializedName("filters")
  private String filters;

  @SerializedName("facetFilters")
  private FacetFilters facetFilters;

  @SerializedName("optionalFilters")
  private OptionalFilters optionalFilters;

  @SerializedName("numericFilters")
  private NumericFilters numericFilters;

  @SerializedName("tagFilters")
  private TagFilters tagFilters;

  @SerializedName("sumOrFiltersScores")
  private Boolean sumOrFiltersScores;

  @SerializedName("facets")
  private List<String> facets;

  @SerializedName("maxValuesPerFacet")
  private Integer maxValuesPerFacet;

  @SerializedName("facetingAfterDistinct")
  private Boolean facetingAfterDistinct;

  @SerializedName("sortFacetValuesBy")
  private String sortFacetValuesBy;

  @SerializedName("page")
  private Integer page;

  @SerializedName("offset")
  private Integer offset;

  @SerializedName("length")
  private Integer length;

  @SerializedName("aroundLatLng")
  private String aroundLatLng;

  @SerializedName("aroundLatLngViaIP")
  private Boolean aroundLatLngViaIP;

  @SerializedName("aroundRadius")
  private AroundRadius aroundRadius;

  @SerializedName("aroundPrecision")
  private Integer aroundPrecision;

  @SerializedName("minimumAroundRadius")
  private Integer minimumAroundRadius;

  @SerializedName("insideBoundingBox")
  private List<Double> insideBoundingBox;

  @SerializedName("insidePolygon")
  private List<Double> insidePolygon;

  @SerializedName("naturalLanguages")
  private List<String> naturalLanguages;

  @SerializedName("ruleContexts")
  private List<String> ruleContexts;

  @SerializedName("personalizationImpact")
  private Integer personalizationImpact;

  @SerializedName("userToken")
  private String userToken;

  @SerializedName("getRankingInfo")
  private Boolean getRankingInfo;

  @SerializedName("clickAnalytics")
  private Boolean clickAnalytics;

  @SerializedName("analytics")
  private Boolean analytics;

  @SerializedName("analyticsTags")
  private List<String> analyticsTags;

  @SerializedName("percentileComputation")
  private Boolean percentileComputation;

  @SerializedName("enableABTest")
  private Boolean enableABTest;

  @SerializedName("enableReRanking")
  private Boolean enableReRanking;

  @SerializedName("reRankingApplyFilter")
  private ReRankingApplyFilter reRankingApplyFilter;

  @SerializedName("attributesForFaceting")
  private List<String> attributesForFaceting;

  @SerializedName("unretrievableAttributes")
  private List<String> unretrievableAttributes;

  @SerializedName("attributesToRetrieve")
  private List<String> attributesToRetrieve;

  @SerializedName("restrictSearchableAttributes")
  private List<String> restrictSearchableAttributes;

  @SerializedName("ranking")
  private List<String> ranking;

  @SerializedName("customRanking")
  private List<String> customRanking;

  @SerializedName("relevancyStrictness")
  private Integer relevancyStrictness;

  @SerializedName("attributesToHighlight")
  private List<String> attributesToHighlight;

  @SerializedName("attributesToSnippet")
  private List<String> attributesToSnippet;

  @SerializedName("highlightPreTag")
  private String highlightPreTag;

  @SerializedName("highlightPostTag")
  private String highlightPostTag;

  @SerializedName("snippetEllipsisText")
  private String snippetEllipsisText;

  @SerializedName("restrictHighlightAndSnippetArrays")
  private Boolean restrictHighlightAndSnippetArrays;

  @SerializedName("hitsPerPage")
  private Integer hitsPerPage;

  @SerializedName("minWordSizefor1Typo")
  private Integer minWordSizefor1Typo;

  @SerializedName("minWordSizefor2Typos")
  private Integer minWordSizefor2Typos;

  @SerializedName("typoTolerance")
  private TypoTolerance typoTolerance;

  @SerializedName("allowTyposOnNumericTokens")
  private Boolean allowTyposOnNumericTokens;

  @SerializedName("disableTypoToleranceOnAttributes")
  private List<String> disableTypoToleranceOnAttributes;

  @SerializedName("ignorePlurals")
  private IgnorePlurals ignorePlurals;

  @SerializedName("removeStopWords")
  private RemoveStopWords removeStopWords;

  @SerializedName("keepDiacriticsOnCharacters")
  private String keepDiacriticsOnCharacters;

  @SerializedName("queryLanguages")
  private List<String> queryLanguages;

  @SerializedName("decompoundQuery")
  private Boolean decompoundQuery;

  @SerializedName("enableRules")
  private Boolean enableRules;

  @SerializedName("enablePersonalization")
  private Boolean enablePersonalization;

  @SerializedName("queryType")
  private QueryType queryType;

  @SerializedName("removeWordsIfNoResults")
  private RemoveWordsIfNoResults removeWordsIfNoResults;

  @SerializedName("advancedSyntax")
  private Boolean advancedSyntax;

  @SerializedName("optionalWords")
  private List<String> optionalWords;

  @SerializedName("disableExactOnAttributes")
  private List<String> disableExactOnAttributes;

  @SerializedName("exactOnSingleWordQuery")
  private ExactOnSingleWordQuery exactOnSingleWordQuery;

  @SerializedName("alternativesAsExact")
  private List<AlternativesAsExact> alternativesAsExact;

  @SerializedName("advancedSyntaxFeatures")
  private List<AdvancedSyntaxFeatures> advancedSyntaxFeatures;

  @SerializedName("distinct")
  private Integer distinct;

  @SerializedName("synonyms")
  private Boolean synonyms;

  @SerializedName("replaceSynonymsInHighlight")
  private Boolean replaceSynonymsInHighlight;

  @SerializedName("minProximity")
  private Integer minProximity;

  @SerializedName("responseFields")
  private List<String> responseFields;

  @SerializedName("maxFacetHits")
  private Integer maxFacetHits;

  @SerializedName("attributeCriteriaComputedByMinProximity")
  private Boolean attributeCriteriaComputedByMinProximity;

  @SerializedName("renderingContent")
  private Object renderingContent;

  @SerializedName("indexName")
  private String indexName;

  @SerializedName("type")
  private SearchTypeDefault type;

  public SearchForHits setParams(String params) {
    this.params = params;
    return this;
  }

  /**
   * Search parameters as URL-encoded query string.
   *
   * @return params
   */
  @javax.annotation.Nullable
  public String getParams() {
    return params;
  }

  public SearchForHits setQuery(String query) {
    this.query = query;
    return this;
  }

  /**
   * The text to search in the index.
   *
   * @return query
   */
  @javax.annotation.Nullable
  public String getQuery() {
    return query;
  }

  public SearchForHits setSimilarQuery(String similarQuery) {
    this.similarQuery = similarQuery;
    return this;
  }

  /**
   * Overrides the query parameter and performs a more generic search that can be used to find
   * \"similar\" results.
   *
   * @return similarQuery
   */
  @javax.annotation.Nullable
  public String getSimilarQuery() {
    return similarQuery;
  }

  public SearchForHits setFilters(String filters) {
    this.filters = filters;
    return this;
  }

  /**
   * Filter the query with numeric, facet and/or tag filters.
   *
   * @return filters
   */
  @javax.annotation.Nullable
  public String getFilters() {
    return filters;
  }

  public SearchForHits setFacetFilters(FacetFilters facetFilters) {
    this.facetFilters = facetFilters;
    return this;
  }

  /**
   * Get facetFilters
   *
   * @return facetFilters
   */
  @javax.annotation.Nullable
  public FacetFilters getFacetFilters() {
    return facetFilters;
  }

  public SearchForHits setOptionalFilters(OptionalFilters optionalFilters) {
    this.optionalFilters = optionalFilters;
    return this;
  }

  /**
   * Get optionalFilters
   *
   * @return optionalFilters
   */
  @javax.annotation.Nullable
  public OptionalFilters getOptionalFilters() {
    return optionalFilters;
  }

  public SearchForHits setNumericFilters(NumericFilters numericFilters) {
    this.numericFilters = numericFilters;
    return this;
  }

  /**
   * Get numericFilters
   *
   * @return numericFilters
   */
  @javax.annotation.Nullable
  public NumericFilters getNumericFilters() {
    return numericFilters;
  }

  public SearchForHits setTagFilters(TagFilters tagFilters) {
    this.tagFilters = tagFilters;
    return this;
  }

  /**
   * Get tagFilters
   *
   * @return tagFilters
   */
  @javax.annotation.Nullable
  public TagFilters getTagFilters() {
    return tagFilters;
  }

  public SearchForHits setSumOrFiltersScores(Boolean sumOrFiltersScores) {
    this.sumOrFiltersScores = sumOrFiltersScores;
    return this;
  }

  /**
   * Determines how to calculate the total score for filtering.
   *
   * @return sumOrFiltersScores
   */
  @javax.annotation.Nullable
  public Boolean getSumOrFiltersScores() {
    return sumOrFiltersScores;
  }

  public SearchForHits setFacets(List<String> facets) {
    this.facets = facets;
    return this;
  }

  public SearchForHits addFacets(String facetsItem) {
    if (this.facets == null) {
      this.facets = new ArrayList<>();
    }
    this.facets.add(facetsItem);
    return this;
  }

  /**
   * Retrieve facets and their facet values.
   *
   * @return facets
   */
  @javax.annotation.Nullable
  public List<String> getFacets() {
    return facets;
  }

  public SearchForHits setMaxValuesPerFacet(Integer maxValuesPerFacet) {
    this.maxValuesPerFacet = maxValuesPerFacet;
    return this;
  }

  /**
   * Maximum number of facet values to return for each facet during a regular search.
   *
   * @return maxValuesPerFacet
   */
  @javax.annotation.Nullable
  public Integer getMaxValuesPerFacet() {
    return maxValuesPerFacet;
  }

  public SearchForHits setFacetingAfterDistinct(Boolean facetingAfterDistinct) {
    this.facetingAfterDistinct = facetingAfterDistinct;
    return this;
  }

  /**
   * Force faceting to be applied after de-duplication (via the Distinct setting).
   *
   * @return facetingAfterDistinct
   */
  @javax.annotation.Nullable
  public Boolean getFacetingAfterDistinct() {
    return facetingAfterDistinct;
  }

  public SearchForHits setSortFacetValuesBy(String sortFacetValuesBy) {
    this.sortFacetValuesBy = sortFacetValuesBy;
    return this;
  }

  /**
   * Controls how facet values are fetched.
   *
   * @return sortFacetValuesBy
   */
  @javax.annotation.Nullable
  public String getSortFacetValuesBy() {
    return sortFacetValuesBy;
  }

  public SearchForHits setPage(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Specify the page to retrieve.
   *
   * @return page
   */
  @javax.annotation.Nullable
  public Integer getPage() {
    return page;
  }

  public SearchForHits setOffset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * Specify the offset of the first hit to return.
   *
   * @return offset
   */
  @javax.annotation.Nullable
  public Integer getOffset() {
    return offset;
  }

  public SearchForHits setLength(Integer length) {
    this.length = length;
    return this;
  }

  /**
   * Set the number of hits to retrieve (used only with offset). minimum: 1 maximum: 1000
   *
   * @return length
   */
  @javax.annotation.Nullable
  public Integer getLength() {
    return length;
  }

  public SearchForHits setAroundLatLng(String aroundLatLng) {
    this.aroundLatLng = aroundLatLng;
    return this;
  }

  /**
   * Search for entries around a central geolocation, enabling a geo search within a circular area.
   *
   * @return aroundLatLng
   */
  @javax.annotation.Nullable
  public String getAroundLatLng() {
    return aroundLatLng;
  }

  public SearchForHits setAroundLatLngViaIP(Boolean aroundLatLngViaIP) {
    this.aroundLatLngViaIP = aroundLatLngViaIP;
    return this;
  }

  /**
   * Search for entries around a given location automatically computed from the requester's IP
   * address.
   *
   * @return aroundLatLngViaIP
   */
  @javax.annotation.Nullable
  public Boolean getAroundLatLngViaIP() {
    return aroundLatLngViaIP;
  }

  public SearchForHits setAroundRadius(AroundRadius aroundRadius) {
    this.aroundRadius = aroundRadius;
    return this;
  }

  /**
   * Get aroundRadius
   *
   * @return aroundRadius
   */
  @javax.annotation.Nullable
  public AroundRadius getAroundRadius() {
    return aroundRadius;
  }

  public SearchForHits setAroundPrecision(Integer aroundPrecision) {
    this.aroundPrecision = aroundPrecision;
    return this;
  }

  /**
   * Precision of geo search (in meters), to add grouping by geo location to the ranking formula.
   *
   * @return aroundPrecision
   */
  @javax.annotation.Nullable
  public Integer getAroundPrecision() {
    return aroundPrecision;
  }

  public SearchForHits setMinimumAroundRadius(Integer minimumAroundRadius) {
    this.minimumAroundRadius = minimumAroundRadius;
    return this;
  }

  /**
   * Minimum radius (in meters) used for a geo search when aroundRadius is not set. minimum: 1
   *
   * @return minimumAroundRadius
   */
  @javax.annotation.Nullable
  public Integer getMinimumAroundRadius() {
    return minimumAroundRadius;
  }

  public SearchForHits setInsideBoundingBox(List<Double> insideBoundingBox) {
    this.insideBoundingBox = insideBoundingBox;
    return this;
  }

  public SearchForHits addInsideBoundingBox(Double insideBoundingBoxItem) {
    if (this.insideBoundingBox == null) {
      this.insideBoundingBox = new ArrayList<>();
    }
    this.insideBoundingBox.add(insideBoundingBoxItem);
    return this;
  }

  /**
   * Search inside a rectangular area (in geo coordinates).
   *
   * @return insideBoundingBox
   */
  @javax.annotation.Nullable
  public List<Double> getInsideBoundingBox() {
    return insideBoundingBox;
  }

  public SearchForHits setInsidePolygon(List<Double> insidePolygon) {
    this.insidePolygon = insidePolygon;
    return this;
  }

  public SearchForHits addInsidePolygon(Double insidePolygonItem) {
    if (this.insidePolygon == null) {
      this.insidePolygon = new ArrayList<>();
    }
    this.insidePolygon.add(insidePolygonItem);
    return this;
  }

  /**
   * Search inside a polygon (in geo coordinates).
   *
   * @return insidePolygon
   */
  @javax.annotation.Nullable
  public List<Double> getInsidePolygon() {
    return insidePolygon;
  }

  public SearchForHits setNaturalLanguages(List<String> naturalLanguages) {
    this.naturalLanguages = naturalLanguages;
    return this;
  }

  public SearchForHits addNaturalLanguages(String naturalLanguagesItem) {
    if (this.naturalLanguages == null) {
      this.naturalLanguages = new ArrayList<>();
    }
    this.naturalLanguages.add(naturalLanguagesItem);
    return this;
  }

  /**
   * This parameter changes the default values of certain parameters and settings that work best for
   * a natural language query, such as ignorePlurals, removeStopWords, removeWordsIfNoResults,
   * analyticsTags and ruleContexts. These parameters and settings work well together when the query
   * is formatted in natural language instead of keywords, for example when your user performs a
   * voice search.
   *
   * @return naturalLanguages
   */
  @javax.annotation.Nullable
  public List<String> getNaturalLanguages() {
    return naturalLanguages;
  }

  public SearchForHits setRuleContexts(List<String> ruleContexts) {
    this.ruleContexts = ruleContexts;
    return this;
  }

  public SearchForHits addRuleContexts(String ruleContextsItem) {
    if (this.ruleContexts == null) {
      this.ruleContexts = new ArrayList<>();
    }
    this.ruleContexts.add(ruleContextsItem);
    return this;
  }

  /**
   * Enables contextual rules.
   *
   * @return ruleContexts
   */
  @javax.annotation.Nullable
  public List<String> getRuleContexts() {
    return ruleContexts;
  }

  public SearchForHits setPersonalizationImpact(Integer personalizationImpact) {
    this.personalizationImpact = personalizationImpact;
    return this;
  }

  /**
   * Define the impact of the Personalization feature.
   *
   * @return personalizationImpact
   */
  @javax.annotation.Nullable
  public Integer getPersonalizationImpact() {
    return personalizationImpact;
  }

  public SearchForHits setUserToken(String userToken) {
    this.userToken = userToken;
    return this;
  }

  /**
   * Associates a certain user token with the current search.
   *
   * @return userToken
   */
  @javax.annotation.Nullable
  public String getUserToken() {
    return userToken;
  }

  public SearchForHits setGetRankingInfo(Boolean getRankingInfo) {
    this.getRankingInfo = getRankingInfo;
    return this;
  }

  /**
   * Retrieve detailed ranking information.
   *
   * @return getRankingInfo
   */
  @javax.annotation.Nullable
  public Boolean getGetRankingInfo() {
    return getRankingInfo;
  }

  public SearchForHits setClickAnalytics(Boolean clickAnalytics) {
    this.clickAnalytics = clickAnalytics;
    return this;
  }

  /**
   * Enable the Click Analytics feature.
   *
   * @return clickAnalytics
   */
  @javax.annotation.Nullable
  public Boolean getClickAnalytics() {
    return clickAnalytics;
  }

  public SearchForHits setAnalytics(Boolean analytics) {
    this.analytics = analytics;
    return this;
  }

  /**
   * Whether the current query will be taken into account in the Analytics.
   *
   * @return analytics
   */
  @javax.annotation.Nullable
  public Boolean getAnalytics() {
    return analytics;
  }

  public SearchForHits setAnalyticsTags(List<String> analyticsTags) {
    this.analyticsTags = analyticsTags;
    return this;
  }

  public SearchForHits addAnalyticsTags(String analyticsTagsItem) {
    if (this.analyticsTags == null) {
      this.analyticsTags = new ArrayList<>();
    }
    this.analyticsTags.add(analyticsTagsItem);
    return this;
  }

  /**
   * List of tags to apply to the query for analytics purposes.
   *
   * @return analyticsTags
   */
  @javax.annotation.Nullable
  public List<String> getAnalyticsTags() {
    return analyticsTags;
  }

  public SearchForHits setPercentileComputation(Boolean percentileComputation) {
    this.percentileComputation = percentileComputation;
    return this;
  }

  /**
   * Whether to include or exclude a query from the processing-time percentile computation.
   *
   * @return percentileComputation
   */
  @javax.annotation.Nullable
  public Boolean getPercentileComputation() {
    return percentileComputation;
  }

  public SearchForHits setEnableABTest(Boolean enableABTest) {
    this.enableABTest = enableABTest;
    return this;
  }

  /**
   * Whether this search should participate in running AB tests.
   *
   * @return enableABTest
   */
  @javax.annotation.Nullable
  public Boolean getEnableABTest() {
    return enableABTest;
  }

  public SearchForHits setEnableReRanking(Boolean enableReRanking) {
    this.enableReRanking = enableReRanking;
    return this;
  }

  /**
   * Whether this search should use AI Re-Ranking.
   *
   * @return enableReRanking
   */
  @javax.annotation.Nullable
  public Boolean getEnableReRanking() {
    return enableReRanking;
  }

  public SearchForHits setReRankingApplyFilter(ReRankingApplyFilter reRankingApplyFilter) {
    this.reRankingApplyFilter = reRankingApplyFilter;
    return this;
  }

  /**
   * Get reRankingApplyFilter
   *
   * @return reRankingApplyFilter
   */
  @javax.annotation.Nullable
  public ReRankingApplyFilter getReRankingApplyFilter() {
    return reRankingApplyFilter;
  }

  public SearchForHits setAttributesForFaceting(List<String> attributesForFaceting) {
    this.attributesForFaceting = attributesForFaceting;
    return this;
  }

  public SearchForHits addAttributesForFaceting(String attributesForFacetingItem) {
    if (this.attributesForFaceting == null) {
      this.attributesForFaceting = new ArrayList<>();
    }
    this.attributesForFaceting.add(attributesForFacetingItem);
    return this;
  }

  /**
   * The complete list of attributes that will be used for faceting.
   *
   * @return attributesForFaceting
   */
  @javax.annotation.Nullable
  public List<String> getAttributesForFaceting() {
    return attributesForFaceting;
  }

  public SearchForHits setUnretrievableAttributes(List<String> unretrievableAttributes) {
    this.unretrievableAttributes = unretrievableAttributes;
    return this;
  }

  public SearchForHits addUnretrievableAttributes(String unretrievableAttributesItem) {
    if (this.unretrievableAttributes == null) {
      this.unretrievableAttributes = new ArrayList<>();
    }
    this.unretrievableAttributes.add(unretrievableAttributesItem);
    return this;
  }

  /**
   * List of attributes that can't be retrieved at query time.
   *
   * @return unretrievableAttributes
   */
  @javax.annotation.Nullable
  public List<String> getUnretrievableAttributes() {
    return unretrievableAttributes;
  }

  public SearchForHits setAttributesToRetrieve(List<String> attributesToRetrieve) {
    this.attributesToRetrieve = attributesToRetrieve;
    return this;
  }

  public SearchForHits addAttributesToRetrieve(String attributesToRetrieveItem) {
    if (this.attributesToRetrieve == null) {
      this.attributesToRetrieve = new ArrayList<>();
    }
    this.attributesToRetrieve.add(attributesToRetrieveItem);
    return this;
  }

  /**
   * This parameter controls which attributes to retrieve and which not to retrieve.
   *
   * @return attributesToRetrieve
   */
  @javax.annotation.Nullable
  public List<String> getAttributesToRetrieve() {
    return attributesToRetrieve;
  }

  public SearchForHits setRestrictSearchableAttributes(List<String> restrictSearchableAttributes) {
    this.restrictSearchableAttributes = restrictSearchableAttributes;
    return this;
  }

  public SearchForHits addRestrictSearchableAttributes(String restrictSearchableAttributesItem) {
    if (this.restrictSearchableAttributes == null) {
      this.restrictSearchableAttributes = new ArrayList<>();
    }
    this.restrictSearchableAttributes.add(restrictSearchableAttributesItem);
    return this;
  }

  /**
   * Restricts a given query to look in only a subset of your searchable attributes.
   *
   * @return restrictSearchableAttributes
   */
  @javax.annotation.Nullable
  public List<String> getRestrictSearchableAttributes() {
    return restrictSearchableAttributes;
  }

  public SearchForHits setRanking(List<String> ranking) {
    this.ranking = ranking;
    return this;
  }

  public SearchForHits addRanking(String rankingItem) {
    if (this.ranking == null) {
      this.ranking = new ArrayList<>();
    }
    this.ranking.add(rankingItem);
    return this;
  }

  /**
   * Controls how Algolia should sort your results.
   *
   * @return ranking
   */
  @javax.annotation.Nullable
  public List<String> getRanking() {
    return ranking;
  }

  public SearchForHits setCustomRanking(List<String> customRanking) {
    this.customRanking = customRanking;
    return this;
  }

  public SearchForHits addCustomRanking(String customRankingItem) {
    if (this.customRanking == null) {
      this.customRanking = new ArrayList<>();
    }
    this.customRanking.add(customRankingItem);
    return this;
  }

  /**
   * Specifies the custom ranking criterion.
   *
   * @return customRanking
   */
  @javax.annotation.Nullable
  public List<String> getCustomRanking() {
    return customRanking;
  }

  public SearchForHits setRelevancyStrictness(Integer relevancyStrictness) {
    this.relevancyStrictness = relevancyStrictness;
    return this;
  }

  /**
   * Controls the relevancy threshold below which less relevant results aren't included in the
   * results.
   *
   * @return relevancyStrictness
   */
  @javax.annotation.Nullable
  public Integer getRelevancyStrictness() {
    return relevancyStrictness;
  }

  public SearchForHits setAttributesToHighlight(List<String> attributesToHighlight) {
    this.attributesToHighlight = attributesToHighlight;
    return this;
  }

  public SearchForHits addAttributesToHighlight(String attributesToHighlightItem) {
    if (this.attributesToHighlight == null) {
      this.attributesToHighlight = new ArrayList<>();
    }
    this.attributesToHighlight.add(attributesToHighlightItem);
    return this;
  }

  /**
   * List of attributes to highlight.
   *
   * @return attributesToHighlight
   */
  @javax.annotation.Nullable
  public List<String> getAttributesToHighlight() {
    return attributesToHighlight;
  }

  public SearchForHits setAttributesToSnippet(List<String> attributesToSnippet) {
    this.attributesToSnippet = attributesToSnippet;
    return this;
  }

  public SearchForHits addAttributesToSnippet(String attributesToSnippetItem) {
    if (this.attributesToSnippet == null) {
      this.attributesToSnippet = new ArrayList<>();
    }
    this.attributesToSnippet.add(attributesToSnippetItem);
    return this;
  }

  /**
   * List of attributes to snippet, with an optional maximum number of words to snippet.
   *
   * @return attributesToSnippet
   */
  @javax.annotation.Nullable
  public List<String> getAttributesToSnippet() {
    return attributesToSnippet;
  }

  public SearchForHits setHighlightPreTag(String highlightPreTag) {
    this.highlightPreTag = highlightPreTag;
    return this;
  }

  /**
   * The HTML string to insert before the highlighted parts in all highlight and snippet results.
   *
   * @return highlightPreTag
   */
  @javax.annotation.Nullable
  public String getHighlightPreTag() {
    return highlightPreTag;
  }

  public SearchForHits setHighlightPostTag(String highlightPostTag) {
    this.highlightPostTag = highlightPostTag;
    return this;
  }

  /**
   * The HTML string to insert after the highlighted parts in all highlight and snippet results.
   *
   * @return highlightPostTag
   */
  @javax.annotation.Nullable
  public String getHighlightPostTag() {
    return highlightPostTag;
  }

  public SearchForHits setSnippetEllipsisText(String snippetEllipsisText) {
    this.snippetEllipsisText = snippetEllipsisText;
    return this;
  }

  /**
   * String used as an ellipsis indicator when a snippet is truncated.
   *
   * @return snippetEllipsisText
   */
  @javax.annotation.Nullable
  public String getSnippetEllipsisText() {
    return snippetEllipsisText;
  }

  public SearchForHits setRestrictHighlightAndSnippetArrays(Boolean restrictHighlightAndSnippetArrays) {
    this.restrictHighlightAndSnippetArrays = restrictHighlightAndSnippetArrays;
    return this;
  }

  /**
   * Restrict highlighting and snippeting to items that matched the query.
   *
   * @return restrictHighlightAndSnippetArrays
   */
  @javax.annotation.Nullable
  public Boolean getRestrictHighlightAndSnippetArrays() {
    return restrictHighlightAndSnippetArrays;
  }

  public SearchForHits setHitsPerPage(Integer hitsPerPage) {
    this.hitsPerPage = hitsPerPage;
    return this;
  }

  /**
   * Set the number of hits per page.
   *
   * @return hitsPerPage
   */
  @javax.annotation.Nullable
  public Integer getHitsPerPage() {
    return hitsPerPage;
  }

  public SearchForHits setMinWordSizefor1Typo(Integer minWordSizefor1Typo) {
    this.minWordSizefor1Typo = minWordSizefor1Typo;
    return this;
  }

  /**
   * Minimum number of characters a word in the query string must contain to accept matches with 1
   * typo.
   *
   * @return minWordSizefor1Typo
   */
  @javax.annotation.Nullable
  public Integer getMinWordSizefor1Typo() {
    return minWordSizefor1Typo;
  }

  public SearchForHits setMinWordSizefor2Typos(Integer minWordSizefor2Typos) {
    this.minWordSizefor2Typos = minWordSizefor2Typos;
    return this;
  }

  /**
   * Minimum number of characters a word in the query string must contain to accept matches with 2
   * typos.
   *
   * @return minWordSizefor2Typos
   */
  @javax.annotation.Nullable
  public Integer getMinWordSizefor2Typos() {
    return minWordSizefor2Typos;
  }

  public SearchForHits setTypoTolerance(TypoTolerance typoTolerance) {
    this.typoTolerance = typoTolerance;
    return this;
  }

  /**
   * Get typoTolerance
   *
   * @return typoTolerance
   */
  @javax.annotation.Nullable
  public TypoTolerance getTypoTolerance() {
    return typoTolerance;
  }

  public SearchForHits setAllowTyposOnNumericTokens(Boolean allowTyposOnNumericTokens) {
    this.allowTyposOnNumericTokens = allowTyposOnNumericTokens;
    return this;
  }

  /**
   * Whether to allow typos on numbers (\"numeric tokens\") in the query string.
   *
   * @return allowTyposOnNumericTokens
   */
  @javax.annotation.Nullable
  public Boolean getAllowTyposOnNumericTokens() {
    return allowTyposOnNumericTokens;
  }

  public SearchForHits setDisableTypoToleranceOnAttributes(List<String> disableTypoToleranceOnAttributes) {
    this.disableTypoToleranceOnAttributes = disableTypoToleranceOnAttributes;
    return this;
  }

  public SearchForHits addDisableTypoToleranceOnAttributes(String disableTypoToleranceOnAttributesItem) {
    if (this.disableTypoToleranceOnAttributes == null) {
      this.disableTypoToleranceOnAttributes = new ArrayList<>();
    }
    this.disableTypoToleranceOnAttributes.add(disableTypoToleranceOnAttributesItem);
    return this;
  }

  /**
   * List of attributes on which you want to disable typo tolerance.
   *
   * @return disableTypoToleranceOnAttributes
   */
  @javax.annotation.Nullable
  public List<String> getDisableTypoToleranceOnAttributes() {
    return disableTypoToleranceOnAttributes;
  }

  public SearchForHits setIgnorePlurals(IgnorePlurals ignorePlurals) {
    this.ignorePlurals = ignorePlurals;
    return this;
  }

  /**
   * Get ignorePlurals
   *
   * @return ignorePlurals
   */
  @javax.annotation.Nullable
  public IgnorePlurals getIgnorePlurals() {
    return ignorePlurals;
  }

  public SearchForHits setRemoveStopWords(RemoveStopWords removeStopWords) {
    this.removeStopWords = removeStopWords;
    return this;
  }

  /**
   * Get removeStopWords
   *
   * @return removeStopWords
   */
  @javax.annotation.Nullable
  public RemoveStopWords getRemoveStopWords() {
    return removeStopWords;
  }

  public SearchForHits setKeepDiacriticsOnCharacters(String keepDiacriticsOnCharacters) {
    this.keepDiacriticsOnCharacters = keepDiacriticsOnCharacters;
    return this;
  }

  /**
   * List of characters that the engine shouldn't automatically normalize.
   *
   * @return keepDiacriticsOnCharacters
   */
  @javax.annotation.Nullable
  public String getKeepDiacriticsOnCharacters() {
    return keepDiacriticsOnCharacters;
  }

  public SearchForHits setQueryLanguages(List<String> queryLanguages) {
    this.queryLanguages = queryLanguages;
    return this;
  }

  public SearchForHits addQueryLanguages(String queryLanguagesItem) {
    if (this.queryLanguages == null) {
      this.queryLanguages = new ArrayList<>();
    }
    this.queryLanguages.add(queryLanguagesItem);
    return this;
  }

  /**
   * Sets the languages to be used by language-specific settings and functionalities such as
   * ignorePlurals, removeStopWords, and CJK word-detection.
   *
   * @return queryLanguages
   */
  @javax.annotation.Nullable
  public List<String> getQueryLanguages() {
    return queryLanguages;
  }

  public SearchForHits setDecompoundQuery(Boolean decompoundQuery) {
    this.decompoundQuery = decompoundQuery;
    return this;
  }

  /**
   * Splits compound words into their composing atoms in the query.
   *
   * @return decompoundQuery
   */
  @javax.annotation.Nullable
  public Boolean getDecompoundQuery() {
    return decompoundQuery;
  }

  public SearchForHits setEnableRules(Boolean enableRules) {
    this.enableRules = enableRules;
    return this;
  }

  /**
   * Whether Rules should be globally enabled.
   *
   * @return enableRules
   */
  @javax.annotation.Nullable
  public Boolean getEnableRules() {
    return enableRules;
  }

  public SearchForHits setEnablePersonalization(Boolean enablePersonalization) {
    this.enablePersonalization = enablePersonalization;
    return this;
  }

  /**
   * Enable the Personalization feature.
   *
   * @return enablePersonalization
   */
  @javax.annotation.Nullable
  public Boolean getEnablePersonalization() {
    return enablePersonalization;
  }

  public SearchForHits setQueryType(QueryType queryType) {
    this.queryType = queryType;
    return this;
  }

  /**
   * Get queryType
   *
   * @return queryType
   */
  @javax.annotation.Nullable
  public QueryType getQueryType() {
    return queryType;
  }

  public SearchForHits setRemoveWordsIfNoResults(RemoveWordsIfNoResults removeWordsIfNoResults) {
    this.removeWordsIfNoResults = removeWordsIfNoResults;
    return this;
  }

  /**
   * Get removeWordsIfNoResults
   *
   * @return removeWordsIfNoResults
   */
  @javax.annotation.Nullable
  public RemoveWordsIfNoResults getRemoveWordsIfNoResults() {
    return removeWordsIfNoResults;
  }

  public SearchForHits setAdvancedSyntax(Boolean advancedSyntax) {
    this.advancedSyntax = advancedSyntax;
    return this;
  }

  /**
   * Enables the advanced query syntax.
   *
   * @return advancedSyntax
   */
  @javax.annotation.Nullable
  public Boolean getAdvancedSyntax() {
    return advancedSyntax;
  }

  public SearchForHits setOptionalWords(List<String> optionalWords) {
    this.optionalWords = optionalWords;
    return this;
  }

  public SearchForHits addOptionalWords(String optionalWordsItem) {
    if (this.optionalWords == null) {
      this.optionalWords = new ArrayList<>();
    }
    this.optionalWords.add(optionalWordsItem);
    return this;
  }

  /**
   * A list of words that should be considered as optional when found in the query.
   *
   * @return optionalWords
   */
  @javax.annotation.Nullable
  public List<String> getOptionalWords() {
    return optionalWords;
  }

  public SearchForHits setDisableExactOnAttributes(List<String> disableExactOnAttributes) {
    this.disableExactOnAttributes = disableExactOnAttributes;
    return this;
  }

  public SearchForHits addDisableExactOnAttributes(String disableExactOnAttributesItem) {
    if (this.disableExactOnAttributes == null) {
      this.disableExactOnAttributes = new ArrayList<>();
    }
    this.disableExactOnAttributes.add(disableExactOnAttributesItem);
    return this;
  }

  /**
   * List of attributes on which you want to disable the exact ranking criterion.
   *
   * @return disableExactOnAttributes
   */
  @javax.annotation.Nullable
  public List<String> getDisableExactOnAttributes() {
    return disableExactOnAttributes;
  }

  public SearchForHits setExactOnSingleWordQuery(ExactOnSingleWordQuery exactOnSingleWordQuery) {
    this.exactOnSingleWordQuery = exactOnSingleWordQuery;
    return this;
  }

  /**
   * Get exactOnSingleWordQuery
   *
   * @return exactOnSingleWordQuery
   */
  @javax.annotation.Nullable
  public ExactOnSingleWordQuery getExactOnSingleWordQuery() {
    return exactOnSingleWordQuery;
  }

  public SearchForHits setAlternativesAsExact(List<AlternativesAsExact> alternativesAsExact) {
    this.alternativesAsExact = alternativesAsExact;
    return this;
  }

  public SearchForHits addAlternativesAsExact(AlternativesAsExact alternativesAsExactItem) {
    if (this.alternativesAsExact == null) {
      this.alternativesAsExact = new ArrayList<>();
    }
    this.alternativesAsExact.add(alternativesAsExactItem);
    return this;
  }

  /**
   * List of alternatives that should be considered an exact match by the exact ranking criterion.
   *
   * @return alternativesAsExact
   */
  @javax.annotation.Nullable
  public List<AlternativesAsExact> getAlternativesAsExact() {
    return alternativesAsExact;
  }

  public SearchForHits setAdvancedSyntaxFeatures(List<AdvancedSyntaxFeatures> advancedSyntaxFeatures) {
    this.advancedSyntaxFeatures = advancedSyntaxFeatures;
    return this;
  }

  public SearchForHits addAdvancedSyntaxFeatures(AdvancedSyntaxFeatures advancedSyntaxFeaturesItem) {
    if (this.advancedSyntaxFeatures == null) {
      this.advancedSyntaxFeatures = new ArrayList<>();
    }
    this.advancedSyntaxFeatures.add(advancedSyntaxFeaturesItem);
    return this;
  }

  /**
   * Allows you to specify which advanced syntax features are active when ‘advancedSyntax' is
   * enabled.
   *
   * @return advancedSyntaxFeatures
   */
  @javax.annotation.Nullable
  public List<AdvancedSyntaxFeatures> getAdvancedSyntaxFeatures() {
    return advancedSyntaxFeatures;
  }

  public SearchForHits setDistinct(Integer distinct) {
    this.distinct = distinct;
    return this;
  }

  /**
   * Enables de-duplication or grouping of results. minimum: 0 maximum: 4
   *
   * @return distinct
   */
  @javax.annotation.Nullable
  public Integer getDistinct() {
    return distinct;
  }

  public SearchForHits setSynonyms(Boolean synonyms) {
    this.synonyms = synonyms;
    return this;
  }

  /**
   * Whether to take into account an index's synonyms for a particular search.
   *
   * @return synonyms
   */
  @javax.annotation.Nullable
  public Boolean getSynonyms() {
    return synonyms;
  }

  public SearchForHits setReplaceSynonymsInHighlight(Boolean replaceSynonymsInHighlight) {
    this.replaceSynonymsInHighlight = replaceSynonymsInHighlight;
    return this;
  }

  /**
   * Whether to highlight and snippet the original word that matches the synonym or the synonym
   * itself.
   *
   * @return replaceSynonymsInHighlight
   */
  @javax.annotation.Nullable
  public Boolean getReplaceSynonymsInHighlight() {
    return replaceSynonymsInHighlight;
  }

  public SearchForHits setMinProximity(Integer minProximity) {
    this.minProximity = minProximity;
    return this;
  }

  /**
   * Precision of the proximity ranking criterion. minimum: 1 maximum: 7
   *
   * @return minProximity
   */
  @javax.annotation.Nullable
  public Integer getMinProximity() {
    return minProximity;
  }

  public SearchForHits setResponseFields(List<String> responseFields) {
    this.responseFields = responseFields;
    return this;
  }

  public SearchForHits addResponseFields(String responseFieldsItem) {
    if (this.responseFields == null) {
      this.responseFields = new ArrayList<>();
    }
    this.responseFields.add(responseFieldsItem);
    return this;
  }

  /**
   * Choose which fields to return in the API response. This parameters applies to search and browse
   * queries.
   *
   * @return responseFields
   */
  @javax.annotation.Nullable
  public List<String> getResponseFields() {
    return responseFields;
  }

  public SearchForHits setMaxFacetHits(Integer maxFacetHits) {
    this.maxFacetHits = maxFacetHits;
    return this;
  }

  /**
   * Maximum number of facet hits to return during a search for facet values. For performance
   * reasons, the maximum allowed number of returned values is 100. maximum: 100
   *
   * @return maxFacetHits
   */
  @javax.annotation.Nullable
  public Integer getMaxFacetHits() {
    return maxFacetHits;
  }

  public SearchForHits setAttributeCriteriaComputedByMinProximity(Boolean attributeCriteriaComputedByMinProximity) {
    this.attributeCriteriaComputedByMinProximity = attributeCriteriaComputedByMinProximity;
    return this;
  }

  /**
   * When attribute is ranked above proximity in your ranking formula, proximity is used to select
   * which searchable attribute is matched in the attribute ranking stage.
   *
   * @return attributeCriteriaComputedByMinProximity
   */
  @javax.annotation.Nullable
  public Boolean getAttributeCriteriaComputedByMinProximity() {
    return attributeCriteriaComputedByMinProximity;
  }

  public SearchForHits setRenderingContent(Object renderingContent) {
    this.renderingContent = renderingContent;
    return this;
  }

  /**
   * Content defining how the search interface should be rendered. Can be set via the settings for a
   * default value and can be overridden via rules.
   *
   * @return renderingContent
   */
  @javax.annotation.Nullable
  public Object getRenderingContent() {
    return renderingContent;
  }

  public SearchForHits setIndexName(String indexName) {
    this.indexName = indexName;
    return this;
  }

  /**
   * The Algolia index name.
   *
   * @return indexName
   */
  @javax.annotation.Nonnull
  public String getIndexName() {
    return indexName;
  }

  public SearchForHits setType(SearchTypeDefault type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  @javax.annotation.Nullable
  public SearchTypeDefault getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchForHits searchForHits = (SearchForHits) o;
    return (
      Objects.equals(this.params, searchForHits.params) &&
      Objects.equals(this.query, searchForHits.query) &&
      Objects.equals(this.similarQuery, searchForHits.similarQuery) &&
      Objects.equals(this.filters, searchForHits.filters) &&
      Objects.equals(this.facetFilters, searchForHits.facetFilters) &&
      Objects.equals(this.optionalFilters, searchForHits.optionalFilters) &&
      Objects.equals(this.numericFilters, searchForHits.numericFilters) &&
      Objects.equals(this.tagFilters, searchForHits.tagFilters) &&
      Objects.equals(this.sumOrFiltersScores, searchForHits.sumOrFiltersScores) &&
      Objects.equals(this.facets, searchForHits.facets) &&
      Objects.equals(this.maxValuesPerFacet, searchForHits.maxValuesPerFacet) &&
      Objects.equals(this.facetingAfterDistinct, searchForHits.facetingAfterDistinct) &&
      Objects.equals(this.sortFacetValuesBy, searchForHits.sortFacetValuesBy) &&
      Objects.equals(this.page, searchForHits.page) &&
      Objects.equals(this.offset, searchForHits.offset) &&
      Objects.equals(this.length, searchForHits.length) &&
      Objects.equals(this.aroundLatLng, searchForHits.aroundLatLng) &&
      Objects.equals(this.aroundLatLngViaIP, searchForHits.aroundLatLngViaIP) &&
      Objects.equals(this.aroundRadius, searchForHits.aroundRadius) &&
      Objects.equals(this.aroundPrecision, searchForHits.aroundPrecision) &&
      Objects.equals(this.minimumAroundRadius, searchForHits.minimumAroundRadius) &&
      Objects.equals(this.insideBoundingBox, searchForHits.insideBoundingBox) &&
      Objects.equals(this.insidePolygon, searchForHits.insidePolygon) &&
      Objects.equals(this.naturalLanguages, searchForHits.naturalLanguages) &&
      Objects.equals(this.ruleContexts, searchForHits.ruleContexts) &&
      Objects.equals(this.personalizationImpact, searchForHits.personalizationImpact) &&
      Objects.equals(this.userToken, searchForHits.userToken) &&
      Objects.equals(this.getRankingInfo, searchForHits.getRankingInfo) &&
      Objects.equals(this.clickAnalytics, searchForHits.clickAnalytics) &&
      Objects.equals(this.analytics, searchForHits.analytics) &&
      Objects.equals(this.analyticsTags, searchForHits.analyticsTags) &&
      Objects.equals(this.percentileComputation, searchForHits.percentileComputation) &&
      Objects.equals(this.enableABTest, searchForHits.enableABTest) &&
      Objects.equals(this.enableReRanking, searchForHits.enableReRanking) &&
      Objects.equals(this.reRankingApplyFilter, searchForHits.reRankingApplyFilter) &&
      Objects.equals(this.attributesForFaceting, searchForHits.attributesForFaceting) &&
      Objects.equals(this.unretrievableAttributes, searchForHits.unretrievableAttributes) &&
      Objects.equals(this.attributesToRetrieve, searchForHits.attributesToRetrieve) &&
      Objects.equals(this.restrictSearchableAttributes, searchForHits.restrictSearchableAttributes) &&
      Objects.equals(this.ranking, searchForHits.ranking) &&
      Objects.equals(this.customRanking, searchForHits.customRanking) &&
      Objects.equals(this.relevancyStrictness, searchForHits.relevancyStrictness) &&
      Objects.equals(this.attributesToHighlight, searchForHits.attributesToHighlight) &&
      Objects.equals(this.attributesToSnippet, searchForHits.attributesToSnippet) &&
      Objects.equals(this.highlightPreTag, searchForHits.highlightPreTag) &&
      Objects.equals(this.highlightPostTag, searchForHits.highlightPostTag) &&
      Objects.equals(this.snippetEllipsisText, searchForHits.snippetEllipsisText) &&
      Objects.equals(this.restrictHighlightAndSnippetArrays, searchForHits.restrictHighlightAndSnippetArrays) &&
      Objects.equals(this.hitsPerPage, searchForHits.hitsPerPage) &&
      Objects.equals(this.minWordSizefor1Typo, searchForHits.minWordSizefor1Typo) &&
      Objects.equals(this.minWordSizefor2Typos, searchForHits.minWordSizefor2Typos) &&
      Objects.equals(this.typoTolerance, searchForHits.typoTolerance) &&
      Objects.equals(this.allowTyposOnNumericTokens, searchForHits.allowTyposOnNumericTokens) &&
      Objects.equals(this.disableTypoToleranceOnAttributes, searchForHits.disableTypoToleranceOnAttributes) &&
      Objects.equals(this.ignorePlurals, searchForHits.ignorePlurals) &&
      Objects.equals(this.removeStopWords, searchForHits.removeStopWords) &&
      Objects.equals(this.keepDiacriticsOnCharacters, searchForHits.keepDiacriticsOnCharacters) &&
      Objects.equals(this.queryLanguages, searchForHits.queryLanguages) &&
      Objects.equals(this.decompoundQuery, searchForHits.decompoundQuery) &&
      Objects.equals(this.enableRules, searchForHits.enableRules) &&
      Objects.equals(this.enablePersonalization, searchForHits.enablePersonalization) &&
      Objects.equals(this.queryType, searchForHits.queryType) &&
      Objects.equals(this.removeWordsIfNoResults, searchForHits.removeWordsIfNoResults) &&
      Objects.equals(this.advancedSyntax, searchForHits.advancedSyntax) &&
      Objects.equals(this.optionalWords, searchForHits.optionalWords) &&
      Objects.equals(this.disableExactOnAttributes, searchForHits.disableExactOnAttributes) &&
      Objects.equals(this.exactOnSingleWordQuery, searchForHits.exactOnSingleWordQuery) &&
      Objects.equals(this.alternativesAsExact, searchForHits.alternativesAsExact) &&
      Objects.equals(this.advancedSyntaxFeatures, searchForHits.advancedSyntaxFeatures) &&
      Objects.equals(this.distinct, searchForHits.distinct) &&
      Objects.equals(this.synonyms, searchForHits.synonyms) &&
      Objects.equals(this.replaceSynonymsInHighlight, searchForHits.replaceSynonymsInHighlight) &&
      Objects.equals(this.minProximity, searchForHits.minProximity) &&
      Objects.equals(this.responseFields, searchForHits.responseFields) &&
      Objects.equals(this.maxFacetHits, searchForHits.maxFacetHits) &&
      Objects.equals(this.attributeCriteriaComputedByMinProximity, searchForHits.attributeCriteriaComputedByMinProximity) &&
      Objects.equals(this.renderingContent, searchForHits.renderingContent) &&
      Objects.equals(this.indexName, searchForHits.indexName) &&
      Objects.equals(this.type, searchForHits.type)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      params,
      query,
      similarQuery,
      filters,
      facetFilters,
      optionalFilters,
      numericFilters,
      tagFilters,
      sumOrFiltersScores,
      facets,
      maxValuesPerFacet,
      facetingAfterDistinct,
      sortFacetValuesBy,
      page,
      offset,
      length,
      aroundLatLng,
      aroundLatLngViaIP,
      aroundRadius,
      aroundPrecision,
      minimumAroundRadius,
      insideBoundingBox,
      insidePolygon,
      naturalLanguages,
      ruleContexts,
      personalizationImpact,
      userToken,
      getRankingInfo,
      clickAnalytics,
      analytics,
      analyticsTags,
      percentileComputation,
      enableABTest,
      enableReRanking,
      reRankingApplyFilter,
      attributesForFaceting,
      unretrievableAttributes,
      attributesToRetrieve,
      restrictSearchableAttributes,
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
      advancedSyntax,
      optionalWords,
      disableExactOnAttributes,
      exactOnSingleWordQuery,
      alternativesAsExact,
      advancedSyntaxFeatures,
      distinct,
      synonyms,
      replaceSynonymsInHighlight,
      minProximity,
      responseFields,
      maxFacetHits,
      attributeCriteriaComputedByMinProximity,
      renderingContent,
      indexName,
      type
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchForHits {\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    similarQuery: ").append(toIndentedString(similarQuery)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    facetFilters: ").append(toIndentedString(facetFilters)).append("\n");
    sb.append("    optionalFilters: ").append(toIndentedString(optionalFilters)).append("\n");
    sb.append("    numericFilters: ").append(toIndentedString(numericFilters)).append("\n");
    sb.append("    tagFilters: ").append(toIndentedString(tagFilters)).append("\n");
    sb.append("    sumOrFiltersScores: ").append(toIndentedString(sumOrFiltersScores)).append("\n");
    sb.append("    facets: ").append(toIndentedString(facets)).append("\n");
    sb.append("    maxValuesPerFacet: ").append(toIndentedString(maxValuesPerFacet)).append("\n");
    sb.append("    facetingAfterDistinct: ").append(toIndentedString(facetingAfterDistinct)).append("\n");
    sb.append("    sortFacetValuesBy: ").append(toIndentedString(sortFacetValuesBy)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    aroundLatLng: ").append(toIndentedString(aroundLatLng)).append("\n");
    sb.append("    aroundLatLngViaIP: ").append(toIndentedString(aroundLatLngViaIP)).append("\n");
    sb.append("    aroundRadius: ").append(toIndentedString(aroundRadius)).append("\n");
    sb.append("    aroundPrecision: ").append(toIndentedString(aroundPrecision)).append("\n");
    sb.append("    minimumAroundRadius: ").append(toIndentedString(minimumAroundRadius)).append("\n");
    sb.append("    insideBoundingBox: ").append(toIndentedString(insideBoundingBox)).append("\n");
    sb.append("    insidePolygon: ").append(toIndentedString(insidePolygon)).append("\n");
    sb.append("    naturalLanguages: ").append(toIndentedString(naturalLanguages)).append("\n");
    sb.append("    ruleContexts: ").append(toIndentedString(ruleContexts)).append("\n");
    sb.append("    personalizationImpact: ").append(toIndentedString(personalizationImpact)).append("\n");
    sb.append("    userToken: ").append(toIndentedString(userToken)).append("\n");
    sb.append("    getRankingInfo: ").append(toIndentedString(getRankingInfo)).append("\n");
    sb.append("    clickAnalytics: ").append(toIndentedString(clickAnalytics)).append("\n");
    sb.append("    analytics: ").append(toIndentedString(analytics)).append("\n");
    sb.append("    analyticsTags: ").append(toIndentedString(analyticsTags)).append("\n");
    sb.append("    percentileComputation: ").append(toIndentedString(percentileComputation)).append("\n");
    sb.append("    enableABTest: ").append(toIndentedString(enableABTest)).append("\n");
    sb.append("    enableReRanking: ").append(toIndentedString(enableReRanking)).append("\n");
    sb.append("    reRankingApplyFilter: ").append(toIndentedString(reRankingApplyFilter)).append("\n");
    sb.append("    attributesForFaceting: ").append(toIndentedString(attributesForFaceting)).append("\n");
    sb.append("    unretrievableAttributes: ").append(toIndentedString(unretrievableAttributes)).append("\n");
    sb.append("    attributesToRetrieve: ").append(toIndentedString(attributesToRetrieve)).append("\n");
    sb.append("    restrictSearchableAttributes: ").append(toIndentedString(restrictSearchableAttributes)).append("\n");
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
    sb.append("    advancedSyntax: ").append(toIndentedString(advancedSyntax)).append("\n");
    sb.append("    optionalWords: ").append(toIndentedString(optionalWords)).append("\n");
    sb.append("    disableExactOnAttributes: ").append(toIndentedString(disableExactOnAttributes)).append("\n");
    sb.append("    exactOnSingleWordQuery: ").append(toIndentedString(exactOnSingleWordQuery)).append("\n");
    sb.append("    alternativesAsExact: ").append(toIndentedString(alternativesAsExact)).append("\n");
    sb.append("    advancedSyntaxFeatures: ").append(toIndentedString(advancedSyntaxFeatures)).append("\n");
    sb.append("    distinct: ").append(toIndentedString(distinct)).append("\n");
    sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
    sb.append("    replaceSynonymsInHighlight: ").append(toIndentedString(replaceSynonymsInHighlight)).append("\n");
    sb.append("    minProximity: ").append(toIndentedString(minProximity)).append("\n");
    sb.append("    responseFields: ").append(toIndentedString(responseFields)).append("\n");
    sb.append("    maxFacetHits: ").append(toIndentedString(maxFacetHits)).append("\n");
    sb
      .append("    attributeCriteriaComputedByMinProximity: ")
      .append(toIndentedString(attributeCriteriaComputedByMinProximity))
      .append("\n");
    sb.append("    renderingContent: ").append(toIndentedString(renderingContent)).append("\n");
    sb.append("    indexName: ").append(toIndentedString(indexName)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
