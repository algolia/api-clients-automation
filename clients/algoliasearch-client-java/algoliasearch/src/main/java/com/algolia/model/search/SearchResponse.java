// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** SearchResponse */
@JsonDeserialize(as = SearchResponse.class)
public class SearchResponse<T> implements SearchResult<T> {

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
  private Map<String, FacetsStats> facetsStats;

  @JsonProperty("hitsPerPage")
  private Integer hitsPerPage;

  @JsonProperty("index")
  private String index;

  @JsonProperty("indexUsed")
  private String indexUsed;

  @JsonProperty("message")
  private String message;

  @JsonProperty("nbHits")
  private Integer nbHits;

  @JsonProperty("nbPages")
  private Integer nbPages;

  @JsonProperty("nbSortedHits")
  private Integer nbSortedHits;

  @JsonProperty("page")
  private Integer page;

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

  @JsonProperty("hits")
  private List<T> hits = new ArrayList<>();

  @JsonProperty("query")
  private String query;

  @JsonProperty("params")
  private String params;

  private Map<String, Object> additionalProperties = new HashMap<>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public SearchResponse<T> setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }

  public SearchResponse<T> setAbTestID(Integer abTestID) {
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

  public SearchResponse<T> setAbTestVariantID(Integer abTestVariantID) {
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

  public SearchResponse<T> setAroundLatLng(String aroundLatLng) {
    this.aroundLatLng = aroundLatLng;
    return this;
  }

  /** Computed geographical location. */
  @javax.annotation.Nullable
  public String getAroundLatLng() {
    return aroundLatLng;
  }

  public SearchResponse<T> setAutomaticRadius(String automaticRadius) {
    this.automaticRadius = automaticRadius;
    return this;
  }

  /** Distance from a central coordinate provided by `aroundLatLng`. */
  @javax.annotation.Nullable
  public String getAutomaticRadius() {
    return automaticRadius;
  }

  public SearchResponse<T> setExhaustive(Exhaustive exhaustive) {
    this.exhaustive = exhaustive;
    return this;
  }

  /** Get exhaustive */
  @javax.annotation.Nullable
  public Exhaustive getExhaustive() {
    return exhaustive;
  }

  public SearchResponse<T> setExhaustiveFacetsCount(Boolean exhaustiveFacetsCount) {
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

  public SearchResponse<T> setExhaustiveNbHits(Boolean exhaustiveNbHits) {
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

  public SearchResponse<T> setExhaustiveTypo(Boolean exhaustiveTypo) {
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

  public SearchResponse<T> setFacets(Map<String, Map<String, Integer>> facets) {
    this.facets = facets;
    return this;
  }

  public SearchResponse<T> putFacets(String key, Map<String, Integer> facetsItem) {
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

  public SearchResponse<T> setFacetsStats(Map<String, FacetsStats> facetsStats) {
    this.facetsStats = facetsStats;
    return this;
  }

  public SearchResponse<T> putFacetsStats(String key, FacetsStats facetsStatsItem) {
    if (this.facetsStats == null) {
      this.facetsStats = new HashMap<>();
    }
    this.facetsStats.put(key, facetsStatsItem);
    return this;
  }

  /** Statistics for numerical facets. */
  @javax.annotation.Nullable
  public Map<String, FacetsStats> getFacetsStats() {
    return facetsStats;
  }

  public SearchResponse<T> setHitsPerPage(Integer hitsPerPage) {
    this.hitsPerPage = hitsPerPage;
    return this;
  }

  /** Number of hits per page. minimum: 1 maximum: 1000 */
  @javax.annotation.Nonnull
  public Integer getHitsPerPage() {
    return hitsPerPage;
  }

  public SearchResponse<T> setIndex(String index) {
    this.index = index;
    return this;
  }

  /** Index name used for the query. */
  @javax.annotation.Nullable
  public String getIndex() {
    return index;
  }

  public SearchResponse<T> setIndexUsed(String indexUsed) {
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

  public SearchResponse<T> setMessage(String message) {
    this.message = message;
    return this;
  }

  /** Warnings about the query. */
  @javax.annotation.Nullable
  public String getMessage() {
    return message;
  }

  public SearchResponse<T> setNbHits(Integer nbHits) {
    this.nbHits = nbHits;
    return this;
  }

  /** Number of results (hits). */
  @javax.annotation.Nonnull
  public Integer getNbHits() {
    return nbHits;
  }

  public SearchResponse<T> setNbPages(Integer nbPages) {
    this.nbPages = nbPages;
    return this;
  }

  /** Number of pages of results. */
  @javax.annotation.Nonnull
  public Integer getNbPages() {
    return nbPages;
  }

  public SearchResponse<T> setNbSortedHits(Integer nbSortedHits) {
    this.nbSortedHits = nbSortedHits;
    return this;
  }

  /** Number of hits selected and sorted by the relevant sort algorithm. */
  @javax.annotation.Nullable
  public Integer getNbSortedHits() {
    return nbSortedHits;
  }

  public SearchResponse<T> setPage(Integer page) {
    this.page = page;
    return this;
  }

  /** Page of search results to retrieve. minimum: 0 */
  @javax.annotation.Nonnull
  public Integer getPage() {
    return page;
  }

  public SearchResponse<T> setParsedQuery(String parsedQuery) {
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

  public SearchResponse<T> setProcessingTimeMS(Integer processingTimeMS) {
    this.processingTimeMS = processingTimeMS;
    return this;
  }

  /** Time the server took to process the request, in milliseconds. */
  @javax.annotation.Nonnull
  public Integer getProcessingTimeMS() {
    return processingTimeMS;
  }

  public SearchResponse<T> setProcessingTimingsMS(Object processingTimingsMS) {
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

  public SearchResponse<T> setQueryAfterRemoval(String queryAfterRemoval) {
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

  public SearchResponse<T> setRedirect(Redirect redirect) {
    this.redirect = redirect;
    return this;
  }

  /** Get redirect */
  @javax.annotation.Nullable
  public Redirect getRedirect() {
    return redirect;
  }

  public SearchResponse<T> setRenderingContent(RenderingContent renderingContent) {
    this.renderingContent = renderingContent;
    return this;
  }

  /** Get renderingContent */
  @javax.annotation.Nullable
  public RenderingContent getRenderingContent() {
    return renderingContent;
  }

  public SearchResponse<T> setServerTimeMS(Integer serverTimeMS) {
    this.serverTimeMS = serverTimeMS;
    return this;
  }

  /** Time the server took to process the request, in milliseconds. */
  @javax.annotation.Nullable
  public Integer getServerTimeMS() {
    return serverTimeMS;
  }

  public SearchResponse<T> setServerUsed(String serverUsed) {
    this.serverUsed = serverUsed;
    return this;
  }

  /** Host name of the server that processed the request. */
  @javax.annotation.Nullable
  public String getServerUsed() {
    return serverUsed;
  }

  public SearchResponse<T> setUserData(Object userData) {
    this.userData = userData;
    return this;
  }

  /** An object with custom data. You can store up to 32kB as custom data. */
  @javax.annotation.Nullable
  public Object getUserData() {
    return userData;
  }

  public SearchResponse<T> setQueryID(String queryID) {
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

  public SearchResponse<T> setHits(List<T> hits) {
    this.hits = hits;
    return this;
  }

  public SearchResponse<T> addHits(T hitsItem) {
    this.hits.add(hitsItem);
    return this;
  }

  /**
   * Search results (hits). Hits are records from your index that match the search criteria,
   * augmented with additional attributes, such as, for highlighting.
   */
  @javax.annotation.Nonnull
  public List<T> getHits() {
    return hits;
  }

  public SearchResponse<T> setQuery(String query) {
    this.query = query;
    return this;
  }

  /** Search query. */
  @javax.annotation.Nonnull
  public String getQuery() {
    return query;
  }

  public SearchResponse<T> setParams(String params) {
    this.params = params;
    return this;
  }

  /** URL-encoded string of all search parameters. */
  @javax.annotation.Nonnull
  public String getParams() {
    return params;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchResponse<?> searchResponse = (SearchResponse<?>) o;
    return (
      Objects.equals(this.abTestID, searchResponse.abTestID) &&
      Objects.equals(this.abTestVariantID, searchResponse.abTestVariantID) &&
      Objects.equals(this.aroundLatLng, searchResponse.aroundLatLng) &&
      Objects.equals(this.automaticRadius, searchResponse.automaticRadius) &&
      Objects.equals(this.exhaustive, searchResponse.exhaustive) &&
      Objects.equals(this.exhaustiveFacetsCount, searchResponse.exhaustiveFacetsCount) &&
      Objects.equals(this.exhaustiveNbHits, searchResponse.exhaustiveNbHits) &&
      Objects.equals(this.exhaustiveTypo, searchResponse.exhaustiveTypo) &&
      Objects.equals(this.facets, searchResponse.facets) &&
      Objects.equals(this.facetsStats, searchResponse.facetsStats) &&
      Objects.equals(this.hitsPerPage, searchResponse.hitsPerPage) &&
      Objects.equals(this.index, searchResponse.index) &&
      Objects.equals(this.indexUsed, searchResponse.indexUsed) &&
      Objects.equals(this.message, searchResponse.message) &&
      Objects.equals(this.nbHits, searchResponse.nbHits) &&
      Objects.equals(this.nbPages, searchResponse.nbPages) &&
      Objects.equals(this.nbSortedHits, searchResponse.nbSortedHits) &&
      Objects.equals(this.page, searchResponse.page) &&
      Objects.equals(this.parsedQuery, searchResponse.parsedQuery) &&
      Objects.equals(this.processingTimeMS, searchResponse.processingTimeMS) &&
      Objects.equals(this.processingTimingsMS, searchResponse.processingTimingsMS) &&
      Objects.equals(this.queryAfterRemoval, searchResponse.queryAfterRemoval) &&
      Objects.equals(this.redirect, searchResponse.redirect) &&
      Objects.equals(this.renderingContent, searchResponse.renderingContent) &&
      Objects.equals(this.serverTimeMS, searchResponse.serverTimeMS) &&
      Objects.equals(this.serverUsed, searchResponse.serverUsed) &&
      Objects.equals(this.userData, searchResponse.userData) &&
      Objects.equals(this.queryID, searchResponse.queryID) &&
      Objects.equals(this.hits, searchResponse.hits) &&
      Objects.equals(this.query, searchResponse.query) &&
      Objects.equals(this.params, searchResponse.params) &&
      super.equals(o)
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
      hitsPerPage,
      index,
      indexUsed,
      message,
      nbHits,
      nbPages,
      nbSortedHits,
      page,
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
      hits,
      query,
      params,
      super.hashCode()
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
    sb.append("    hitsPerPage: ").append(toIndentedString(hitsPerPage)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    indexUsed: ").append(toIndentedString(indexUsed)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    nbHits: ").append(toIndentedString(nbHits)).append("\n");
    sb.append("    nbPages: ").append(toIndentedString(nbPages)).append("\n");
    sb.append("    nbSortedHits: ").append(toIndentedString(nbSortedHits)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
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
    sb.append("    hits: ").append(toIndentedString(hits)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
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
