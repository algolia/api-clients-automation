// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** RecommendationsResults */
public class RecommendationsResults {

  @JsonProperty("abTestID")
  private Integer abTestID;

  @JsonProperty("abTestVariantID")
  private Integer abTestVariantID;

  @JsonProperty("aroundLatLng")
  private String aroundLatLng;

  @JsonProperty("automaticRadius")
  private String automaticRadius;

  @JsonProperty("exhaustive")
  private Exhaustive exhaustive;

  @JsonProperty("exhaustiveFacetsCount")
  private Boolean exhaustiveFacetsCount;

  @JsonProperty("exhaustiveNbHits")
  private Boolean exhaustiveNbHits;

  @JsonProperty("exhaustiveTypo")
  private Boolean exhaustiveTypo;

  @JsonProperty("facets")
  private Map<String, Map<String, Integer>> facets;

  @JsonProperty("facets_stats")
  private Map<String, FacetStats> facetsStats;

  @JsonProperty("index")
  private String index;

  @JsonProperty("indexUsed")
  private String indexUsed;

  @JsonProperty("message")
  private String message;

  @JsonProperty("nbSortedHits")
  private Integer nbSortedHits;

  @JsonProperty("parsedQuery")
  private String parsedQuery;

  @JsonProperty("processingTimeMS")
  private Integer processingTimeMS;

  @JsonProperty("processingTimingsMS")
  private Object processingTimingsMS;

  @JsonProperty("queryAfterRemoval")
  private String queryAfterRemoval;

  @JsonProperty("redirect")
  private Redirect redirect;

  @JsonProperty("renderingContent")
  private RenderingContent renderingContent;

  @JsonProperty("serverTimeMS")
  private Integer serverTimeMS;

  @JsonProperty("serverUsed")
  private String serverUsed;

  @JsonProperty("userData")
  private Object userData;

  @JsonProperty("queryID")
  private String queryID;

  @JsonProperty("page")
  private Integer page;

  @JsonProperty("nbHits")
  private Integer nbHits;

  @JsonProperty("nbPages")
  private Integer nbPages;

  @JsonProperty("hitsPerPage")
  private Integer hitsPerPage;

  @JsonProperty("hits")
  private List<RecommendationsHit> hits = new ArrayList<>();

  public RecommendationsResults setAbTestID(Integer abTestID) {
    this.abTestID = abTestID;
    return this;
  }

  /**
   * A/B test ID. This is only included in the response for indices that are part of an A/B test.
   */
  @javax.annotation.Nullable
  public Integer getAbTestID() {
    return abTestID;
  }

  public RecommendationsResults setAbTestVariantID(Integer abTestVariantID) {
    this.abTestVariantID = abTestVariantID;
    return this;
  }

  /**
   * Variant ID. This is only included in the response for indices that are part of an A/B test.
   * minimum: 1
   */
  @javax.annotation.Nullable
  public Integer getAbTestVariantID() {
    return abTestVariantID;
  }

  public RecommendationsResults setAroundLatLng(String aroundLatLng) {
    this.aroundLatLng = aroundLatLng;
    return this;
  }

  /** Computed geographical location. */
  @javax.annotation.Nullable
  public String getAroundLatLng() {
    return aroundLatLng;
  }

  public RecommendationsResults setAutomaticRadius(String automaticRadius) {
    this.automaticRadius = automaticRadius;
    return this;
  }

  /** Distance from a central coordinate provided by `aroundLatLng`. */
  @javax.annotation.Nullable
  public String getAutomaticRadius() {
    return automaticRadius;
  }

  public RecommendationsResults setExhaustive(Exhaustive exhaustive) {
    this.exhaustive = exhaustive;
    return this;
  }

  /** Get exhaustive */
  @javax.annotation.Nullable
  public Exhaustive getExhaustive() {
    return exhaustive;
  }

  public RecommendationsResults setExhaustiveFacetsCount(Boolean exhaustiveFacetsCount) {
    this.exhaustiveFacetsCount = exhaustiveFacetsCount;
    return this;
  }

  /**
   * See the `facetsCount` field of the `exhaustive` object in the response.
   *
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nullable
  public Boolean getExhaustiveFacetsCount() {
    return exhaustiveFacetsCount;
  }

  public RecommendationsResults setExhaustiveNbHits(Boolean exhaustiveNbHits) {
    this.exhaustiveNbHits = exhaustiveNbHits;
    return this;
  }

  /**
   * See the `nbHits` field of the `exhaustive` object in the response.
   *
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nullable
  public Boolean getExhaustiveNbHits() {
    return exhaustiveNbHits;
  }

  public RecommendationsResults setExhaustiveTypo(Boolean exhaustiveTypo) {
    this.exhaustiveTypo = exhaustiveTypo;
    return this;
  }

  /**
   * See the `typo` field of the `exhaustive` object in the response.
   *
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nullable
  public Boolean getExhaustiveTypo() {
    return exhaustiveTypo;
  }

  public RecommendationsResults setFacets(Map<String, Map<String, Integer>> facets) {
    this.facets = facets;
    return this;
  }

  public RecommendationsResults putFacets(String key, Map<String, Integer> facetsItem) {
    if (this.facets == null) {
      this.facets = new HashMap<>();
    }
    this.facets.put(key, facetsItem);
    return this;
  }

  /** Facet counts. */
  @javax.annotation.Nullable
  public Map<String, Map<String, Integer>> getFacets() {
    return facets;
  }

  public RecommendationsResults setFacetsStats(Map<String, FacetStats> facetsStats) {
    this.facetsStats = facetsStats;
    return this;
  }

  public RecommendationsResults putFacetsStats(String key, FacetStats facetsStatsItem) {
    if (this.facetsStats == null) {
      this.facetsStats = new HashMap<>();
    }
    this.facetsStats.put(key, facetsStatsItem);
    return this;
  }

  /** Statistics for numerical facets. */
  @javax.annotation.Nullable
  public Map<String, FacetStats> getFacetsStats() {
    return facetsStats;
  }

  public RecommendationsResults setIndex(String index) {
    this.index = index;
    return this;
  }

  /** Index name used for the query. */
  @javax.annotation.Nullable
  public String getIndex() {
    return index;
  }

  public RecommendationsResults setIndexUsed(String indexUsed) {
    this.indexUsed = indexUsed;
    return this;
  }

  /**
   * Index name used for the query. During A/B testing, the targeted index isn't always the index
   * used by the query.
   */
  @javax.annotation.Nullable
  public String getIndexUsed() {
    return indexUsed;
  }

  public RecommendationsResults setMessage(String message) {
    this.message = message;
    return this;
  }

  /** Warnings about the query. */
  @javax.annotation.Nullable
  public String getMessage() {
    return message;
  }

  public RecommendationsResults setNbSortedHits(Integer nbSortedHits) {
    this.nbSortedHits = nbSortedHits;
    return this;
  }

  /** Number of hits selected and sorted by the relevant sort algorithm. */
  @javax.annotation.Nullable
  public Integer getNbSortedHits() {
    return nbSortedHits;
  }

  public RecommendationsResults setParsedQuery(String parsedQuery) {
    this.parsedQuery = parsedQuery;
    return this;
  }

  /**
   * Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean)
   * query string that will be searched.
   */
  @javax.annotation.Nullable
  public String getParsedQuery() {
    return parsedQuery;
  }

  public RecommendationsResults setProcessingTimeMS(Integer processingTimeMS) {
    this.processingTimeMS = processingTimeMS;
    return this;
  }

  /** Time the server took to process the request, in milliseconds. */
  @javax.annotation.Nonnull
  public Integer getProcessingTimeMS() {
    return processingTimeMS;
  }

  public RecommendationsResults setProcessingTimingsMS(Object processingTimingsMS) {
    this.processingTimingsMS = processingTimingsMS;
    return this;
  }

  /**
   * Experimental. List of processing steps and their times, in milliseconds. You can use this list
   * to investigate performance issues.
   */
  @javax.annotation.Nullable
  public Object getProcessingTimingsMS() {
    return processingTimingsMS;
  }

  public RecommendationsResults setQueryAfterRemoval(String queryAfterRemoval) {
    this.queryAfterRemoval = queryAfterRemoval;
    return this;
  }

  /**
   * Markup text indicating which parts of the original query have been removed to retrieve a
   * non-empty result set.
   */
  @javax.annotation.Nullable
  public String getQueryAfterRemoval() {
    return queryAfterRemoval;
  }

  public RecommendationsResults setRedirect(Redirect redirect) {
    this.redirect = redirect;
    return this;
  }

  /** Get redirect */
  @javax.annotation.Nullable
  public Redirect getRedirect() {
    return redirect;
  }

  public RecommendationsResults setRenderingContent(RenderingContent renderingContent) {
    this.renderingContent = renderingContent;
    return this;
  }

  /** Get renderingContent */
  @javax.annotation.Nullable
  public RenderingContent getRenderingContent() {
    return renderingContent;
  }

  public RecommendationsResults setServerTimeMS(Integer serverTimeMS) {
    this.serverTimeMS = serverTimeMS;
    return this;
  }

  /** Time the server took to process the request, in milliseconds. */
  @javax.annotation.Nullable
  public Integer getServerTimeMS() {
    return serverTimeMS;
  }

  public RecommendationsResults setServerUsed(String serverUsed) {
    this.serverUsed = serverUsed;
    return this;
  }

  /** Host name of the server that processed the request. */
  @javax.annotation.Nullable
  public String getServerUsed() {
    return serverUsed;
  }

  public RecommendationsResults setUserData(Object userData) {
    this.userData = userData;
    return this;
  }

  /** An object with custom data. You can store up to 32kB as custom data. */
  @javax.annotation.Nullable
  public Object getUserData() {
    return userData;
  }

  public RecommendationsResults setQueryID(String queryID) {
    this.queryID = queryID;
    return this;
  }

  /**
   * Unique identifier for the query. This is used for [click
   * analytics](https://www.algolia.com/doc/guides/analytics/click-analytics/).
   */
  @javax.annotation.Nullable
  public String getQueryID() {
    return queryID;
  }

  public RecommendationsResults setPage(Integer page) {
    this.page = page;
    return this;
  }

  /** Page of search results to retrieve. minimum: 0 */
  @javax.annotation.Nonnull
  public Integer getPage() {
    return page;
  }

  public RecommendationsResults setNbHits(Integer nbHits) {
    this.nbHits = nbHits;
    return this;
  }

  /** Number of results (hits). */
  @javax.annotation.Nonnull
  public Integer getNbHits() {
    return nbHits;
  }

  public RecommendationsResults setNbPages(Integer nbPages) {
    this.nbPages = nbPages;
    return this;
  }

  /** Number of pages of results. */
  @javax.annotation.Nonnull
  public Integer getNbPages() {
    return nbPages;
  }

  public RecommendationsResults setHitsPerPage(Integer hitsPerPage) {
    this.hitsPerPage = hitsPerPage;
    return this;
  }

  /** Number of hits per page. minimum: 1 maximum: 1000 */
  @javax.annotation.Nonnull
  public Integer getHitsPerPage() {
    return hitsPerPage;
  }

  public RecommendationsResults setHits(List<RecommendationsHit> hits) {
    this.hits = hits;
    return this;
  }

  public RecommendationsResults addHits(RecommendationsHit hitsItem) {
    this.hits.add(hitsItem);
    return this;
  }

  /** Get hits */
  @javax.annotation.Nonnull
  public List<RecommendationsHit> getHits() {
    return hits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecommendationsResults recommendationsResults = (RecommendationsResults) o;
    return (
      Objects.equals(this.abTestID, recommendationsResults.abTestID) &&
      Objects.equals(this.abTestVariantID, recommendationsResults.abTestVariantID) &&
      Objects.equals(this.aroundLatLng, recommendationsResults.aroundLatLng) &&
      Objects.equals(this.automaticRadius, recommendationsResults.automaticRadius) &&
      Objects.equals(this.exhaustive, recommendationsResults.exhaustive) &&
      Objects.equals(this.exhaustiveFacetsCount, recommendationsResults.exhaustiveFacetsCount) &&
      Objects.equals(this.exhaustiveNbHits, recommendationsResults.exhaustiveNbHits) &&
      Objects.equals(this.exhaustiveTypo, recommendationsResults.exhaustiveTypo) &&
      Objects.equals(this.facets, recommendationsResults.facets) &&
      Objects.equals(this.facetsStats, recommendationsResults.facetsStats) &&
      Objects.equals(this.index, recommendationsResults.index) &&
      Objects.equals(this.indexUsed, recommendationsResults.indexUsed) &&
      Objects.equals(this.message, recommendationsResults.message) &&
      Objects.equals(this.nbSortedHits, recommendationsResults.nbSortedHits) &&
      Objects.equals(this.parsedQuery, recommendationsResults.parsedQuery) &&
      Objects.equals(this.processingTimeMS, recommendationsResults.processingTimeMS) &&
      Objects.equals(this.processingTimingsMS, recommendationsResults.processingTimingsMS) &&
      Objects.equals(this.queryAfterRemoval, recommendationsResults.queryAfterRemoval) &&
      Objects.equals(this.redirect, recommendationsResults.redirect) &&
      Objects.equals(this.renderingContent, recommendationsResults.renderingContent) &&
      Objects.equals(this.serverTimeMS, recommendationsResults.serverTimeMS) &&
      Objects.equals(this.serverUsed, recommendationsResults.serverUsed) &&
      Objects.equals(this.userData, recommendationsResults.userData) &&
      Objects.equals(this.queryID, recommendationsResults.queryID) &&
      Objects.equals(this.page, recommendationsResults.page) &&
      Objects.equals(this.nbHits, recommendationsResults.nbHits) &&
      Objects.equals(this.nbPages, recommendationsResults.nbPages) &&
      Objects.equals(this.hitsPerPage, recommendationsResults.hitsPerPage) &&
      Objects.equals(this.hits, recommendationsResults.hits)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      abTestID,
      abTestVariantID,
      aroundLatLng,
      automaticRadius,
      exhaustive,
      exhaustiveFacetsCount,
      exhaustiveNbHits,
      exhaustiveTypo,
      facets,
      facetsStats,
      index,
      indexUsed,
      message,
      nbSortedHits,
      parsedQuery,
      processingTimeMS,
      processingTimingsMS,
      queryAfterRemoval,
      redirect,
      renderingContent,
      serverTimeMS,
      serverUsed,
      userData,
      queryID,
      page,
      nbHits,
      nbPages,
      hitsPerPage,
      hits
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecommendationsResults {\n");
    sb.append("    abTestID: ").append(toIndentedString(abTestID)).append("\n");
    sb.append("    abTestVariantID: ").append(toIndentedString(abTestVariantID)).append("\n");
    sb.append("    aroundLatLng: ").append(toIndentedString(aroundLatLng)).append("\n");
    sb.append("    automaticRadius: ").append(toIndentedString(automaticRadius)).append("\n");
    sb.append("    exhaustive: ").append(toIndentedString(exhaustive)).append("\n");
    sb.append("    exhaustiveFacetsCount: ").append(toIndentedString(exhaustiveFacetsCount)).append("\n");
    sb.append("    exhaustiveNbHits: ").append(toIndentedString(exhaustiveNbHits)).append("\n");
    sb.append("    exhaustiveTypo: ").append(toIndentedString(exhaustiveTypo)).append("\n");
    sb.append("    facets: ").append(toIndentedString(facets)).append("\n");
    sb.append("    facetsStats: ").append(toIndentedString(facetsStats)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    indexUsed: ").append(toIndentedString(indexUsed)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    nbSortedHits: ").append(toIndentedString(nbSortedHits)).append("\n");
    sb.append("    parsedQuery: ").append(toIndentedString(parsedQuery)).append("\n");
    sb.append("    processingTimeMS: ").append(toIndentedString(processingTimeMS)).append("\n");
    sb.append("    processingTimingsMS: ").append(toIndentedString(processingTimingsMS)).append("\n");
    sb.append("    queryAfterRemoval: ").append(toIndentedString(queryAfterRemoval)).append("\n");
    sb.append("    redirect: ").append(toIndentedString(redirect)).append("\n");
    sb.append("    renderingContent: ").append(toIndentedString(renderingContent)).append("\n");
    sb.append("    serverTimeMS: ").append(toIndentedString(serverTimeMS)).append("\n");
    sb.append("    serverUsed: ").append(toIndentedString(serverUsed)).append("\n");
    sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
    sb.append("    queryID: ").append(toIndentedString(queryID)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    nbHits: ").append(toIndentedString(nbHits)).append("\n");
    sb.append("    nbPages: ").append(toIndentedString(nbPages)).append("\n");
    sb.append("    hitsPerPage: ").append(toIndentedString(hitsPerPage)).append("\n");
    sb.append("    hits: ").append(toIndentedString(hits)).append("\n");
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
