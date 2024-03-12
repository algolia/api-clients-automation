// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** BaseSearchParams */
public class BaseSearchParams {

  @JsonProperty("query")
  private String query;

  @JsonProperty("similarQuery")
  private String similarQuery;

  @JsonProperty("filters")
  private String filters;

  @JsonProperty("facetFilters")
  private FacetFilters facetFilters;

  @JsonProperty("optionalFilters")
  private OptionalFilters optionalFilters;

  @JsonProperty("numericFilters")
  private NumericFilters numericFilters;

  @JsonProperty("tagFilters")
  private TagFilters tagFilters;

  @JsonProperty("sumOrFiltersScores")
  private Boolean sumOrFiltersScores;

  @JsonProperty("restrictSearchableAttributes")
  private List<String> restrictSearchableAttributes;

  @JsonProperty("facets")
  private List<String> facets;

  @JsonProperty("facetingAfterDistinct")
  private Boolean facetingAfterDistinct;

  @JsonProperty("page")
  private Integer page;

  @JsonProperty("offset")
  private Integer offset;

  @JsonProperty("length")
  private Integer length;

  @JsonProperty("aroundLatLng")
  private String aroundLatLng;

  @JsonProperty("aroundLatLngViaIP")
  private Boolean aroundLatLngViaIP;

  @JsonProperty("aroundRadius")
  private AroundRadius aroundRadius;

  @JsonProperty("aroundPrecision")
  private AroundPrecision aroundPrecision;

  @JsonProperty("minimumAroundRadius")
  private Integer minimumAroundRadius;

  @JsonProperty("insideBoundingBox")
  private List<List<Double>> insideBoundingBox;

  @JsonProperty("insidePolygon")
  private List<List<Double>> insidePolygon;

  @JsonProperty("naturalLanguages")
  private List<String> naturalLanguages;

  @JsonProperty("ruleContexts")
  private List<String> ruleContexts;

  @JsonProperty("personalizationImpact")
  private Integer personalizationImpact;

  @JsonProperty("userToken")
  private String userToken;

  @JsonProperty("getRankingInfo")
  private Boolean getRankingInfo;

  @JsonProperty("synonyms")
  private Boolean synonyms;

  @JsonProperty("clickAnalytics")
  private Boolean clickAnalytics;

  @JsonProperty("analytics")
  private Boolean analytics;

  @JsonProperty("analyticsTags")
  private List<String> analyticsTags;

  @JsonProperty("percentileComputation")
  private Boolean percentileComputation;

  @JsonProperty("enableABTest")
  private Boolean enableABTest;

  public BaseSearchParams setQuery(String query) {
    this.query = query;
    return this;
  }

  /** Search query. */
  @javax.annotation.Nullable
  public String getQuery() {
    return query;
  }

  public BaseSearchParams setSimilarQuery(String similarQuery) {
    this.similarQuery = similarQuery;
    return this;
  }

  /**
   * Keywords to be used instead of the search query to conduct a more broader search. Using the
   * `similarQuery` parameter changes other settings: - `queryType` is set to `prefixNone`. -
   * `removeStopWords` is set to true. - `words` is set as the first ranking criterion. - All
   * remaining words are treated as `optionalWords`. Since the `similarQuery` is supposed to do a
   * broad search, they usually return many results. Combine it with `filters` to narrow down the
   * list of results.
   */
  @javax.annotation.Nullable
  public String getSimilarQuery() {
    return similarQuery;
  }

  public BaseSearchParams setFilters(String filters) {
    this.filters = filters;
    return this;
  }

  /**
   * Filter the search so that only records with matching values are included in the results. These
   * filters are supported: - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of
   * `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and
   * `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.**
   * `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet
   * value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean
   * filters.** `<facet>: true | false`. You can combine filters with `AND`, `OR`, and `NOT`
   * operators with the following restrictions: - You can only combine filters of the same type with
   * `OR`. **Not supported:** `facet:value OR num > 3`. - You can't use `NOT` with combinations of
   * filters. **Not supported:** `NOT(facet:value OR facet:value)` - You can't combine conjunctions
   * (`AND`) with `OR`. **Not supported:** `facet:value OR (facet:value AND facet:value)` Use quotes
   * around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`,
   * `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at
   * least one element of the array. For more information, see
   * [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
   */
  @javax.annotation.Nullable
  public String getFilters() {
    return filters;
  }

  public BaseSearchParams setFacetFilters(FacetFilters facetFilters) {
    this.facetFilters = facetFilters;
    return this;
  }

  /** Get facetFilters */
  @javax.annotation.Nullable
  public FacetFilters getFacetFilters() {
    return facetFilters;
  }

  public BaseSearchParams setOptionalFilters(OptionalFilters optionalFilters) {
    this.optionalFilters = optionalFilters;
    return this;
  }

  /** Get optionalFilters */
  @javax.annotation.Nullable
  public OptionalFilters getOptionalFilters() {
    return optionalFilters;
  }

  public BaseSearchParams setNumericFilters(NumericFilters numericFilters) {
    this.numericFilters = numericFilters;
    return this;
  }

  /** Get numericFilters */
  @javax.annotation.Nullable
  public NumericFilters getNumericFilters() {
    return numericFilters;
  }

  public BaseSearchParams setTagFilters(TagFilters tagFilters) {
    this.tagFilters = tagFilters;
    return this;
  }

  /** Get tagFilters */
  @javax.annotation.Nullable
  public TagFilters getTagFilters() {
    return tagFilters;
  }

  public BaseSearchParams setSumOrFiltersScores(Boolean sumOrFiltersScores) {
    this.sumOrFiltersScores = sumOrFiltersScores;
    return this;
  }

  /**
   * Whether to sum all filter scores. If true, all filter scores are summed. Otherwise, the maximum
   * filter score is kept. For more information, see [filter
   * scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores).
   */
  @javax.annotation.Nullable
  public Boolean getSumOrFiltersScores() {
    return sumOrFiltersScores;
  }

  public BaseSearchParams setRestrictSearchableAttributes(List<String> restrictSearchableAttributes) {
    this.restrictSearchableAttributes = restrictSearchableAttributes;
    return this;
  }

  public BaseSearchParams addRestrictSearchableAttributes(String restrictSearchableAttributesItem) {
    if (this.restrictSearchableAttributes == null) {
      this.restrictSearchableAttributes = new ArrayList<>();
    }
    this.restrictSearchableAttributes.add(restrictSearchableAttributesItem);
    return this;
  }

  /** Restricts a search to a subset of your searchable attributes. */
  @javax.annotation.Nullable
  public List<String> getRestrictSearchableAttributes() {
    return restrictSearchableAttributes;
  }

  public BaseSearchParams setFacets(List<String> facets) {
    this.facets = facets;
    return this;
  }

  public BaseSearchParams addFacets(String facetsItem) {
    if (this.facets == null) {
      this.facets = new ArrayList<>();
    }
    this.facets.add(facetsItem);
    return this;
  }

  /**
   * Facets for which to retrieve facet values that match the search criteria and the number of
   * matching facet values. To retrieve all facets, use the wildcard character `*`. For more
   * information, see
   * [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts).
   */
  @javax.annotation.Nullable
  public List<String> getFacets() {
    return facets;
  }

  public BaseSearchParams setFacetingAfterDistinct(Boolean facetingAfterDistinct) {
    this.facetingAfterDistinct = facetingAfterDistinct;
    return this;
  }

  /**
   * Whether faceting should be applied after deduplication with `distinct`. This leads to accurate
   * facet counts when using faceting in combination with `distinct`. It's usually better to use
   * `afterDistinct` modifiers in the `attributesForFaceting` setting, as `facetingAfterDistinct`
   * only computes correct facet counts if all records have the same facet values for the
   * `attributeForDistinct`.
   */
  @javax.annotation.Nullable
  public Boolean getFacetingAfterDistinct() {
    return facetingAfterDistinct;
  }

  public BaseSearchParams setPage(Integer page) {
    this.page = page;
    return this;
  }

  /** Page of search results to retrieve. minimum: 0 */
  @javax.annotation.Nullable
  public Integer getPage() {
    return page;
  }

  public BaseSearchParams setOffset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /** Position of the first hit to retrieve. */
  @javax.annotation.Nullable
  public Integer getOffset() {
    return offset;
  }

  public BaseSearchParams setLength(Integer length) {
    this.length = length;
    return this;
  }

  /** Number of hits to retrieve (used in combination with `offset`). minimum: 1 maximum: 1000 */
  @javax.annotation.Nullable
  public Integer getLength() {
    return length;
  }

  public BaseSearchParams setAroundLatLng(String aroundLatLng) {
    this.aroundLatLng = aroundLatLng;
    return this;
  }

  /**
   * Coordinates for the center of a circle, expressed as a comma-separated string of latitude and
   * longitude. Only records included within circle around this central location are included in the
   * results. The radius of the circle is determined by the `aroundRadius` and `minimumAroundRadius`
   * settings. This parameter is ignored if you also specify `insidePolygon` or `insideBoundingBox`.
   */
  @javax.annotation.Nullable
  public String getAroundLatLng() {
    return aroundLatLng;
  }

  public BaseSearchParams setAroundLatLngViaIP(Boolean aroundLatLngViaIP) {
    this.aroundLatLngViaIP = aroundLatLngViaIP;
    return this;
  }

  /** Whether to obtain the coordinates from the request's IP address. */
  @javax.annotation.Nullable
  public Boolean getAroundLatLngViaIP() {
    return aroundLatLngViaIP;
  }

  public BaseSearchParams setAroundRadius(AroundRadius aroundRadius) {
    this.aroundRadius = aroundRadius;
    return this;
  }

  /** Get aroundRadius */
  @javax.annotation.Nullable
  public AroundRadius getAroundRadius() {
    return aroundRadius;
  }

  public BaseSearchParams setAroundPrecision(AroundPrecision aroundPrecision) {
    this.aroundPrecision = aroundPrecision;
    return this;
  }

  /** Get aroundPrecision */
  @javax.annotation.Nullable
  public AroundPrecision getAroundPrecision() {
    return aroundPrecision;
  }

  public BaseSearchParams setMinimumAroundRadius(Integer minimumAroundRadius) {
    this.minimumAroundRadius = minimumAroundRadius;
    return this;
  }

  /**
   * Minimum radius (in meters) for a search around a location when `aroundRadius` isn't set.
   * minimum: 1
   */
  @javax.annotation.Nullable
  public Integer getMinimumAroundRadius() {
    return minimumAroundRadius;
  }

  public BaseSearchParams setInsideBoundingBox(List<List<Double>> insideBoundingBox) {
    this.insideBoundingBox = insideBoundingBox;
    return this;
  }

  public BaseSearchParams addInsideBoundingBox(List<Double> insideBoundingBoxItem) {
    if (this.insideBoundingBox == null) {
      this.insideBoundingBox = new ArrayList<>();
    }
    this.insideBoundingBox.add(insideBoundingBoxItem);
    return this;
  }

  /**
   * Coordinates for a rectangular area in which to search. Each bounding box is defined by the two
   * opposite points of its diagonal, and expressed as latitude and longitude pair: `[p1 lat, p1
   * long, p2 lat, p2 long]`. Provide multiple bounding boxes as nested arrays. For more
   * information, see [rectangular
   * area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
   */
  @javax.annotation.Nullable
  public List<List<Double>> getInsideBoundingBox() {
    return insideBoundingBox;
  }

  public BaseSearchParams setInsidePolygon(List<List<Double>> insidePolygon) {
    this.insidePolygon = insidePolygon;
    return this;
  }

  public BaseSearchParams addInsidePolygon(List<Double> insidePolygonItem) {
    if (this.insidePolygon == null) {
      this.insidePolygon = new ArrayList<>();
    }
    this.insidePolygon.add(insidePolygonItem);
    return this;
  }

  /**
   * Coordinates of a polygon in which to search. Polygons are defined by 3 to 10,000 points. Each
   * point is represented by its latitude and longitude. Provide multiple polygons as nested arrays.
   * For more information, see [filtering inside
   * polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
   * This parameter is ignored, if you also specify `insideBoundingBox`.
   */
  @javax.annotation.Nullable
  public List<List<Double>> getInsidePolygon() {
    return insidePolygon;
  }

  public BaseSearchParams setNaturalLanguages(List<String> naturalLanguages) {
    this.naturalLanguages = naturalLanguages;
    return this;
  }

  public BaseSearchParams addNaturalLanguages(String naturalLanguagesItem) {
    if (this.naturalLanguages == null) {
      this.naturalLanguages = new ArrayList<>();
    }
    this.naturalLanguages.add(naturalLanguagesItem);
    return this;
  }

  /**
   * ISO language codes that adjust settings that are useful for processing natural language queries
   * (as opposed to keyword searches): - Sets `removeStopWords` and `ignorePlurals` to the list of
   * provided languages. - Sets `removeWordsIfNoResults` to `allOptional`. - Adds a
   * `natural_language` attribute to `ruleContexts` and `analyticsTags`.
   */
  @javax.annotation.Nullable
  public List<String> getNaturalLanguages() {
    return naturalLanguages;
  }

  public BaseSearchParams setRuleContexts(List<String> ruleContexts) {
    this.ruleContexts = ruleContexts;
    return this;
  }

  public BaseSearchParams addRuleContexts(String ruleContextsItem) {
    if (this.ruleContexts == null) {
      this.ruleContexts = new ArrayList<>();
    }
    this.ruleContexts.add(ruleContextsItem);
    return this;
  }

  /**
   * Assigns a rule context to the search query. [Rule
   * contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context)
   * are strings that you can use to trigger matching rules.
   */
  @javax.annotation.Nullable
  public List<String> getRuleContexts() {
    return ruleContexts;
  }

  public BaseSearchParams setPersonalizationImpact(Integer personalizationImpact) {
    this.personalizationImpact = personalizationImpact;
    return this;
  }

  /**
   * Impact that Personalization should have on this search. The higher this value is, the more
   * Personalization determines the ranking compared to other factors. For more information, see
   * [Understanding Personalization
   * impact](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).
   * minimum: 0 maximum: 100
   */
  @javax.annotation.Nullable
  public Integer getPersonalizationImpact() {
    return personalizationImpact;
  }

  public BaseSearchParams setUserToken(String userToken) {
    this.userToken = userToken;
    return this;
  }

  /**
   * Unique pseudonymous or anonymous user identifier. This helps with analytics and click and
   * conversion events. For more information, see [user
   * token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
   */
  @javax.annotation.Nullable
  public String getUserToken() {
    return userToken;
  }

  public BaseSearchParams setGetRankingInfo(Boolean getRankingInfo) {
    this.getRankingInfo = getRankingInfo;
    return this;
  }

  /** Whether the search response should include detailed ranking information. */
  @javax.annotation.Nullable
  public Boolean getGetRankingInfo() {
    return getRankingInfo;
  }

  public BaseSearchParams setSynonyms(Boolean synonyms) {
    this.synonyms = synonyms;
    return this;
  }

  /** Whether to take into account an index's synonyms for this search. */
  @javax.annotation.Nullable
  public Boolean getSynonyms() {
    return synonyms;
  }

  public BaseSearchParams setClickAnalytics(Boolean clickAnalytics) {
    this.clickAnalytics = clickAnalytics;
    return this;
  }

  /**
   * Whether to include a `queryID` attribute in the response. The query ID is a unique identifier
   * for a search query and is required for tracking [click and conversion
   * events](https://www.algolia.com/guides/sending-events/getting-started/).
   */
  @javax.annotation.Nullable
  public Boolean getClickAnalytics() {
    return clickAnalytics;
  }

  public BaseSearchParams setAnalytics(Boolean analytics) {
    this.analytics = analytics;
    return this;
  }

  /** Whether this search will be included in Analytics. */
  @javax.annotation.Nullable
  public Boolean getAnalytics() {
    return analytics;
  }

  public BaseSearchParams setAnalyticsTags(List<String> analyticsTags) {
    this.analyticsTags = analyticsTags;
    return this;
  }

  public BaseSearchParams addAnalyticsTags(String analyticsTagsItem) {
    if (this.analyticsTags == null) {
      this.analyticsTags = new ArrayList<>();
    }
    this.analyticsTags.add(analyticsTagsItem);
    return this;
  }

  /**
   * Tags to apply to the query for [segmenting analytics
   * data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
   */
  @javax.annotation.Nullable
  public List<String> getAnalyticsTags() {
    return analyticsTags;
  }

  public BaseSearchParams setPercentileComputation(Boolean percentileComputation) {
    this.percentileComputation = percentileComputation;
    return this;
  }

  /** Whether to include this search when calculating processing-time percentiles. */
  @javax.annotation.Nullable
  public Boolean getPercentileComputation() {
    return percentileComputation;
  }

  public BaseSearchParams setEnableABTest(Boolean enableABTest) {
    this.enableABTest = enableABTest;
    return this;
  }

  /** Whether to enable A/B testing for this search. */
  @javax.annotation.Nullable
  public Boolean getEnableABTest() {
    return enableABTest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseSearchParams baseSearchParams = (BaseSearchParams) o;
    return (
      Objects.equals(this.query, baseSearchParams.query) &&
      Objects.equals(this.similarQuery, baseSearchParams.similarQuery) &&
      Objects.equals(this.filters, baseSearchParams.filters) &&
      Objects.equals(this.facetFilters, baseSearchParams.facetFilters) &&
      Objects.equals(this.optionalFilters, baseSearchParams.optionalFilters) &&
      Objects.equals(this.numericFilters, baseSearchParams.numericFilters) &&
      Objects.equals(this.tagFilters, baseSearchParams.tagFilters) &&
      Objects.equals(this.sumOrFiltersScores, baseSearchParams.sumOrFiltersScores) &&
      Objects.equals(this.restrictSearchableAttributes, baseSearchParams.restrictSearchableAttributes) &&
      Objects.equals(this.facets, baseSearchParams.facets) &&
      Objects.equals(this.facetingAfterDistinct, baseSearchParams.facetingAfterDistinct) &&
      Objects.equals(this.page, baseSearchParams.page) &&
      Objects.equals(this.offset, baseSearchParams.offset) &&
      Objects.equals(this.length, baseSearchParams.length) &&
      Objects.equals(this.aroundLatLng, baseSearchParams.aroundLatLng) &&
      Objects.equals(this.aroundLatLngViaIP, baseSearchParams.aroundLatLngViaIP) &&
      Objects.equals(this.aroundRadius, baseSearchParams.aroundRadius) &&
      Objects.equals(this.aroundPrecision, baseSearchParams.aroundPrecision) &&
      Objects.equals(this.minimumAroundRadius, baseSearchParams.minimumAroundRadius) &&
      Objects.equals(this.insideBoundingBox, baseSearchParams.insideBoundingBox) &&
      Objects.equals(this.insidePolygon, baseSearchParams.insidePolygon) &&
      Objects.equals(this.naturalLanguages, baseSearchParams.naturalLanguages) &&
      Objects.equals(this.ruleContexts, baseSearchParams.ruleContexts) &&
      Objects.equals(this.personalizationImpact, baseSearchParams.personalizationImpact) &&
      Objects.equals(this.userToken, baseSearchParams.userToken) &&
      Objects.equals(this.getRankingInfo, baseSearchParams.getRankingInfo) &&
      Objects.equals(this.synonyms, baseSearchParams.synonyms) &&
      Objects.equals(this.clickAnalytics, baseSearchParams.clickAnalytics) &&
      Objects.equals(this.analytics, baseSearchParams.analytics) &&
      Objects.equals(this.analyticsTags, baseSearchParams.analyticsTags) &&
      Objects.equals(this.percentileComputation, baseSearchParams.percentileComputation) &&
      Objects.equals(this.enableABTest, baseSearchParams.enableABTest)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      query,
      similarQuery,
      filters,
      facetFilters,
      optionalFilters,
      numericFilters,
      tagFilters,
      sumOrFiltersScores,
      restrictSearchableAttributes,
      facets,
      facetingAfterDistinct,
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
      synonyms,
      clickAnalytics,
      analytics,
      analyticsTags,
      percentileComputation,
      enableABTest
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseSearchParams {\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    similarQuery: ").append(toIndentedString(similarQuery)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    facetFilters: ").append(toIndentedString(facetFilters)).append("\n");
    sb.append("    optionalFilters: ").append(toIndentedString(optionalFilters)).append("\n");
    sb.append("    numericFilters: ").append(toIndentedString(numericFilters)).append("\n");
    sb.append("    tagFilters: ").append(toIndentedString(tagFilters)).append("\n");
    sb.append("    sumOrFiltersScores: ").append(toIndentedString(sumOrFiltersScores)).append("\n");
    sb.append("    restrictSearchableAttributes: ").append(toIndentedString(restrictSearchableAttributes)).append("\n");
    sb.append("    facets: ").append(toIndentedString(facets)).append("\n");
    sb.append("    facetingAfterDistinct: ").append(toIndentedString(facetingAfterDistinct)).append("\n");
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
    sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
    sb.append("    clickAnalytics: ").append(toIndentedString(clickAnalytics)).append("\n");
    sb.append("    analytics: ").append(toIndentedString(analytics)).append("\n");
    sb.append("    analyticsTags: ").append(toIndentedString(analyticsTags)).append("\n");
    sb.append("    percentileComputation: ").append(toIndentedString(percentileComputation)).append("\n");
    sb.append("    enableABTest: ").append(toIndentedString(enableABTest)).append("\n");
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
