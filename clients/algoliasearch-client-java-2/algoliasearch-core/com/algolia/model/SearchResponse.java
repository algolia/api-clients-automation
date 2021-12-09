/*
 * Search API
 * API powering the Search feature of Algolia.
 *
 * The version of the OpenAPI document: 0.1.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.algolia.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** SearchResponse */
@JsonPropertyOrder(
  {
    SearchResponse.JSON_PROPERTY_AB_TEST_I_D,
    SearchResponse.JSON_PROPERTY_AB_TEST_VARIANT_I_D,
    SearchResponse.JSON_PROPERTY_AROUND_LAT_LNG,
    SearchResponse.JSON_PROPERTY_AUTOMATIC_RADIUS,
    SearchResponse.JSON_PROPERTY_EXHAUSTIVE_FACETS_COUNT,
    SearchResponse.JSON_PROPERTY_EXHAUSTIVE_NB_HITS,
    SearchResponse.JSON_PROPERTY_EXHAUSTIVE_TYPO,
    SearchResponse.JSON_PROPERTY_FACETS,
    SearchResponse.JSON_PROPERTY_FACETS_STATS,
    SearchResponse.JSON_PROPERTY_HITS_PER_PAGE,
    SearchResponse.JSON_PROPERTY_INDEX,
    SearchResponse.JSON_PROPERTY_INDEX_USED,
    SearchResponse.JSON_PROPERTY_MESSAGE,
    SearchResponse.JSON_PROPERTY_NB_HITS,
    SearchResponse.JSON_PROPERTY_NB_PAGES,
    SearchResponse.JSON_PROPERTY_NB_SORTED_HITS,
    SearchResponse.JSON_PROPERTY_PAGE,
    SearchResponse.JSON_PROPERTY_PARAMS,
    SearchResponse.JSON_PROPERTY_PARSED_QUERY,
    SearchResponse.JSON_PROPERTY_PROCESSING_TIME_M_S,
    SearchResponse.JSON_PROPERTY_QUERY,
    SearchResponse.JSON_PROPERTY_QUERY_AFTER_REMOVAL,
    SearchResponse.JSON_PROPERTY_SERVER_USED,
    SearchResponse.JSON_PROPERTY_USER_DATA,
    SearchResponse.JSON_PROPERTY_HITS,
  }
)
@JsonTypeName("searchResponse")
public class SearchResponse {

  public static final String JSON_PROPERTY_AB_TEST_I_D = "abTestID";
  private Integer abTestID;

  public static final String JSON_PROPERTY_AB_TEST_VARIANT_I_D =
    "abTestVariantID";
  private Integer abTestVariantID;

  public static final String JSON_PROPERTY_AROUND_LAT_LNG = "aroundLatLng";
  private String aroundLatLng;

  public static final String JSON_PROPERTY_AUTOMATIC_RADIUS = "automaticRadius";
  private String automaticRadius;

  public static final String JSON_PROPERTY_EXHAUSTIVE_FACETS_COUNT =
    "exhaustiveFacetsCount";
  private Boolean exhaustiveFacetsCount;

  public static final String JSON_PROPERTY_EXHAUSTIVE_NB_HITS =
    "exhaustiveNbHits";
  private Boolean exhaustiveNbHits;

  public static final String JSON_PROPERTY_EXHAUSTIVE_TYPO = "exhaustiveTypo";
  private Boolean exhaustiveTypo;

  public static final String JSON_PROPERTY_FACETS = "facets";
  private Map<String, Map<String, String>> facets = null;

  public static final String JSON_PROPERTY_FACETS_STATS = "facets_stats";
  private Map<String, BaseSearchResponseFacetsStats> facetsStats = null;

  public static final String JSON_PROPERTY_HITS_PER_PAGE = "hitsPerPage";
  private Integer hitsPerPage = 20;

  public static final String JSON_PROPERTY_INDEX = "index";
  private String index;

  public static final String JSON_PROPERTY_INDEX_USED = "indexUsed";
  private String indexUsed;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private String message;

  public static final String JSON_PROPERTY_NB_HITS = "nbHits";
  private Integer nbHits;

  public static final String JSON_PROPERTY_NB_PAGES = "nbPages";
  private Integer nbPages;

  public static final String JSON_PROPERTY_NB_SORTED_HITS = "nbSortedHits";
  private Integer nbSortedHits;

  public static final String JSON_PROPERTY_PAGE = "page";
  private Integer page = 0;

  public static final String JSON_PROPERTY_PARAMS = "params";
  private String params;

  public static final String JSON_PROPERTY_PARSED_QUERY = "parsedQuery";
  private String parsedQuery;

  public static final String JSON_PROPERTY_PROCESSING_TIME_M_S =
    "processingTimeMS";
  private Integer processingTimeMS;

  public static final String JSON_PROPERTY_QUERY = "query";
  private String query = "";

  public static final String JSON_PROPERTY_QUERY_AFTER_REMOVAL =
    "queryAfterRemoval";
  private String queryAfterRemoval;

  public static final String JSON_PROPERTY_SERVER_USED = "serverUsed";
  private String serverUsed;

  public static final String JSON_PROPERTY_USER_DATA = "userData";
  private Map<String, Object> userData = null;

  public static final String JSON_PROPERTY_HITS = "hits";
  private List<Record> hits = new ArrayList<>();

  public SearchResponse abTestID(Integer abTestID) {
    this.abTestID = abTestID;
    return this;
  }

  /**
   * If a search encounters an index that is being A/B tested, abTestID reports the ongoing A/B test
   * ID.
   *
   * @return abTestID
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "If a search encounters an index that is being A/B tested, abTestID reports the ongoing" +
    " A/B test ID."
  )
  @JsonProperty(JSON_PROPERTY_AB_TEST_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getAbTestID() {
    return abTestID;
  }

  @JsonProperty(JSON_PROPERTY_AB_TEST_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAbTestID(Integer abTestID) {
    this.abTestID = abTestID;
  }

  public SearchResponse abTestVariantID(Integer abTestVariantID) {
    this.abTestVariantID = abTestVariantID;
    return this;
  }

  /**
   * If a search encounters an index that is being A/B tested, abTestVariantID reports the variant
   * ID of the index used.
   *
   * @return abTestVariantID
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "If a search encounters an index that is being A/B tested, abTestVariantID reports the" +
    " variant ID of the index used."
  )
  @JsonProperty(JSON_PROPERTY_AB_TEST_VARIANT_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getAbTestVariantID() {
    return abTestVariantID;
  }

  @JsonProperty(JSON_PROPERTY_AB_TEST_VARIANT_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAbTestVariantID(Integer abTestVariantID) {
    this.abTestVariantID = abTestVariantID;
  }

  public SearchResponse aroundLatLng(String aroundLatLng) {
    this.aroundLatLng = aroundLatLng;
    return this;
  }

  /**
   * The computed geo location.
   *
   * @return aroundLatLng
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The computed geo location.")
  @JsonProperty(JSON_PROPERTY_AROUND_LAT_LNG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAroundLatLng() {
    return aroundLatLng;
  }

  @JsonProperty(JSON_PROPERTY_AROUND_LAT_LNG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAroundLatLng(String aroundLatLng) {
    this.aroundLatLng = aroundLatLng;
  }

  public SearchResponse automaticRadius(String automaticRadius) {
    this.automaticRadius = automaticRadius;
    return this;
  }

  /**
   * The automatically computed radius. For legacy reasons, this parameter is a string and not an
   * integer.
   *
   * @return automaticRadius
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "The automatically computed radius. For legacy reasons, this parameter is a string and" +
    " not an integer."
  )
  @JsonProperty(JSON_PROPERTY_AUTOMATIC_RADIUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAutomaticRadius() {
    return automaticRadius;
  }

  @JsonProperty(JSON_PROPERTY_AUTOMATIC_RADIUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAutomaticRadius(String automaticRadius) {
    this.automaticRadius = automaticRadius;
  }

  public SearchResponse exhaustiveFacetsCount(Boolean exhaustiveFacetsCount) {
    this.exhaustiveFacetsCount = exhaustiveFacetsCount;
    return this;
  }

  /**
   * Whether the facet count is exhaustive or approximate.
   *
   * @return exhaustiveFacetsCount
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Whether the facet count is exhaustive or approximate."
  )
  @JsonProperty(JSON_PROPERTY_EXHAUSTIVE_FACETS_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getExhaustiveFacetsCount() {
    return exhaustiveFacetsCount;
  }

  @JsonProperty(JSON_PROPERTY_EXHAUSTIVE_FACETS_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExhaustiveFacetsCount(Boolean exhaustiveFacetsCount) {
    this.exhaustiveFacetsCount = exhaustiveFacetsCount;
  }

  public SearchResponse exhaustiveNbHits(Boolean exhaustiveNbHits) {
    this.exhaustiveNbHits = exhaustiveNbHits;
    return this;
  }

  /**
   * Indicate if the nbHits count was exhaustive or approximate
   *
   * @return exhaustiveNbHits
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Indicate if the nbHits count was exhaustive or approximate"
  )
  @JsonProperty(JSON_PROPERTY_EXHAUSTIVE_NB_HITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Boolean getExhaustiveNbHits() {
    return exhaustiveNbHits;
  }

  @JsonProperty(JSON_PROPERTY_EXHAUSTIVE_NB_HITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExhaustiveNbHits(Boolean exhaustiveNbHits) {
    this.exhaustiveNbHits = exhaustiveNbHits;
  }

  public SearchResponse exhaustiveTypo(Boolean exhaustiveTypo) {
    this.exhaustiveTypo = exhaustiveTypo;
    return this;
  }

  /**
   * Indicate if the typo-tolerence search was exhaustive or approximate (only included when
   * typo-tolerance is enabled)
   *
   * @return exhaustiveTypo
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Indicate if the typo-tolerence search was exhaustive or approximate (only included when" +
    " typo-tolerance is enabled)"
  )
  @JsonProperty(JSON_PROPERTY_EXHAUSTIVE_TYPO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Boolean getExhaustiveTypo() {
    return exhaustiveTypo;
  }

  @JsonProperty(JSON_PROPERTY_EXHAUSTIVE_TYPO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExhaustiveTypo(Boolean exhaustiveTypo) {
    this.exhaustiveTypo = exhaustiveTypo;
  }

  public SearchResponse facets(Map<String, Map<String, String>> facets) {
    this.facets = facets;
    return this;
  }

  public SearchResponse putFacetsItem(
    String key,
    Map<String, String> facetsItem
  ) {
    if (this.facets == null) {
      this.facets = new HashMap<>();
    }
    this.facets.put(key, facetsItem);
    return this;
  }

  /**
   * A mapping of each facet name to the corresponding facet counts.
   *
   * @return facets
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    example = "{\"category\":{\"food\":1,\"tech\":42}}",
    value = "A mapping of each facet name to the corresponding facet counts."
  )
  @JsonProperty(JSON_PROPERTY_FACETS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Map<String, Map<String, String>> getFacets() {
    return facets;
  }

  @JsonProperty(JSON_PROPERTY_FACETS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFacets(Map<String, Map<String, String>> facets) {
    this.facets = facets;
  }

  public SearchResponse facetsStats(
    Map<String, BaseSearchResponseFacetsStats> facetsStats
  ) {
    this.facetsStats = facetsStats;
    return this;
  }

  public SearchResponse putFacetsStatsItem(
    String key,
    BaseSearchResponseFacetsStats facetsStatsItem
  ) {
    if (this.facetsStats == null) {
      this.facetsStats = new HashMap<>();
    }
    this.facetsStats.put(key, facetsStatsItem);
    return this;
  }

  /**
   * Statistics for numerical facets.
   *
   * @return facetsStats
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Statistics for numerical facets.")
  @JsonProperty(JSON_PROPERTY_FACETS_STATS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Map<String, BaseSearchResponseFacetsStats> getFacetsStats() {
    return facetsStats;
  }

  @JsonProperty(JSON_PROPERTY_FACETS_STATS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFacetsStats(
    Map<String, BaseSearchResponseFacetsStats> facetsStats
  ) {
    this.facetsStats = facetsStats;
  }

  public SearchResponse hitsPerPage(Integer hitsPerPage) {
    this.hitsPerPage = hitsPerPage;
    return this;
  }

  /**
   * Set the number of hits per page.
   *
   * @return hitsPerPage
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Set the number of hits per page.")
  @JsonProperty(JSON_PROPERTY_HITS_PER_PAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Integer getHitsPerPage() {
    return hitsPerPage;
  }

  @JsonProperty(JSON_PROPERTY_HITS_PER_PAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHitsPerPage(Integer hitsPerPage) {
    this.hitsPerPage = hitsPerPage;
  }

  public SearchResponse index(String index) {
    this.index = index;
    return this;
  }

  /**
   * Index name used for the query.
   *
   * @return index
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    example = "indexName",
    value = "Index name used for the query."
  )
  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIndex() {
    return index;
  }

  @JsonProperty(JSON_PROPERTY_INDEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIndex(String index) {
    this.index = index;
  }

  public SearchResponse indexUsed(String indexUsed) {
    this.indexUsed = indexUsed;
    return this;
  }

  /**
   * Index name used for the query. In the case of an A/B test, the targeted index isn’t always the
   * index used by the query.
   *
   * @return indexUsed
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    example = "indexNameAlt",
    value = "Index name used for the query. In the case of an A/B test, the targeted index isn’t" +
    " always the index used by the query."
  )
  @JsonProperty(JSON_PROPERTY_INDEX_USED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIndexUsed() {
    return indexUsed;
  }

  @JsonProperty(JSON_PROPERTY_INDEX_USED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIndexUsed(String indexUsed) {
    this.indexUsed = indexUsed;
  }

  public SearchResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Used to return warnings about the query.
   *
   * @return message
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Used to return warnings about the query.")
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMessage() {
    return message;
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessage(String message) {
    this.message = message;
  }

  public SearchResponse nbHits(Integer nbHits) {
    this.nbHits = nbHits;
    return this;
  }

  /**
   * Number of hits that the search query matched
   *
   * @return nbHits
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(
    example = "20",
    required = true,
    value = "Number of hits that the search query matched"
  )
  @JsonProperty(JSON_PROPERTY_NB_HITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Integer getNbHits() {
    return nbHits;
  }

  @JsonProperty(JSON_PROPERTY_NB_HITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNbHits(Integer nbHits) {
    this.nbHits = nbHits;
  }

  public SearchResponse nbPages(Integer nbPages) {
    this.nbPages = nbPages;
    return this;
  }

  /**
   * Number of pages available for the current query
   *
   * @return nbPages
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(
    example = "1",
    required = true,
    value = "Number of pages available for the current query"
  )
  @JsonProperty(JSON_PROPERTY_NB_PAGES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Integer getNbPages() {
    return nbPages;
  }

  @JsonProperty(JSON_PROPERTY_NB_PAGES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNbPages(Integer nbPages) {
    this.nbPages = nbPages;
  }

  public SearchResponse nbSortedHits(Integer nbSortedHits) {
    this.nbSortedHits = nbSortedHits;
    return this;
  }

  /**
   * The number of hits selected and sorted by the relevant sort algorithm
   *
   * @return nbSortedHits
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    example = "20",
    value = "The number of hits selected and sorted by the relevant sort algorithm"
  )
  @JsonProperty(JSON_PROPERTY_NB_SORTED_HITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getNbSortedHits() {
    return nbSortedHits;
  }

  @JsonProperty(JSON_PROPERTY_NB_SORTED_HITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNbSortedHits(Integer nbSortedHits) {
    this.nbSortedHits = nbSortedHits;
  }

  public SearchResponse page(Integer page) {
    this.page = page;
    return this;
  }

  /**
   * Specify the page to retrieve.
   *
   * @return page
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Specify the page to retrieve.")
  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Integer getPage() {
    return page;
  }

  @JsonProperty(JSON_PROPERTY_PAGE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPage(Integer page) {
    this.page = page;
  }

  public SearchResponse params(String params) {
    this.params = params;
    return this;
  }

  /**
   * A url-encoded string of all search parameters.
   *
   * @return params
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(
    example = "query=a&hitsPerPage=20",
    required = true,
    value = "A url-encoded string of all search parameters."
  )
  @JsonProperty(JSON_PROPERTY_PARAMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getParams() {
    return params;
  }

  @JsonProperty(JSON_PROPERTY_PARAMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setParams(String params) {
    this.params = params;
  }

  public SearchResponse parsedQuery(String parsedQuery) {
    this.parsedQuery = parsedQuery;
    return this;
  }

  /**
   * The query string that will be searched, after normalization.
   *
   * @return parsedQuery
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "The query string that will be searched, after normalization."
  )
  @JsonProperty(JSON_PROPERTY_PARSED_QUERY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getParsedQuery() {
    return parsedQuery;
  }

  @JsonProperty(JSON_PROPERTY_PARSED_QUERY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setParsedQuery(String parsedQuery) {
    this.parsedQuery = parsedQuery;
  }

  public SearchResponse processingTimeMS(Integer processingTimeMS) {
    this.processingTimeMS = processingTimeMS;
    return this;
  }

  /**
   * Time the server took to process the request, in milliseconds.
   *
   * @return processingTimeMS
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(
    example = "20",
    required = true,
    value = "Time the server took to process the request, in milliseconds."
  )
  @JsonProperty(JSON_PROPERTY_PROCESSING_TIME_M_S)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Integer getProcessingTimeMS() {
    return processingTimeMS;
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_TIME_M_S)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProcessingTimeMS(Integer processingTimeMS) {
    this.processingTimeMS = processingTimeMS;
  }

  public SearchResponse query(String query) {
    this.query = query;
    return this;
  }

  /**
   * The text to search in the index.
   *
   * @return query
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The text to search in the index.")
  @JsonProperty(JSON_PROPERTY_QUERY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getQuery() {
    return query;
  }

  @JsonProperty(JSON_PROPERTY_QUERY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setQuery(String query) {
    this.query = query;
  }

  public SearchResponse queryAfterRemoval(String queryAfterRemoval) {
    this.queryAfterRemoval = queryAfterRemoval;
    return this;
  }

  /**
   * A markup text indicating which parts of the original query have been removed in order to
   * retrieve a non-empty result set.
   *
   * @return queryAfterRemoval
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "A markup text indicating which parts of the original query have been removed in order to" +
    " retrieve a non-empty result set."
  )
  @JsonProperty(JSON_PROPERTY_QUERY_AFTER_REMOVAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getQueryAfterRemoval() {
    return queryAfterRemoval;
  }

  @JsonProperty(JSON_PROPERTY_QUERY_AFTER_REMOVAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQueryAfterRemoval(String queryAfterRemoval) {
    this.queryAfterRemoval = queryAfterRemoval;
  }

  public SearchResponse serverUsed(String serverUsed) {
    this.serverUsed = serverUsed;
    return this;
  }

  /**
   * Actual host name of the server that processed the request.
   *
   * @return serverUsed
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Actual host name of the server that processed the request."
  )
  @JsonProperty(JSON_PROPERTY_SERVER_USED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getServerUsed() {
    return serverUsed;
  }

  @JsonProperty(JSON_PROPERTY_SERVER_USED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setServerUsed(String serverUsed) {
    this.serverUsed = serverUsed;
  }

  public SearchResponse userData(Map<String, Object> userData) {
    this.userData = userData;
    return this;
  }

  public SearchResponse putUserDataItem(String key, Object userDataItem) {
    if (this.userData == null) {
      this.userData = new HashMap<>();
    }
    this.userData.put(key, userDataItem);
    return this;
  }

  /**
   * Lets you store custom data in your indices.
   *
   * @return userData
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Lets you store custom data in your indices.")
  @JsonProperty(JSON_PROPERTY_USER_DATA)
  @JsonInclude(
    content = JsonInclude.Include.ALWAYS,
    value = JsonInclude.Include.USE_DEFAULTS
  )
  public Map<String, Object> getUserData() {
    return userData;
  }

  @JsonProperty(JSON_PROPERTY_USER_DATA)
  @JsonInclude(
    content = JsonInclude.Include.ALWAYS,
    value = JsonInclude.Include.USE_DEFAULTS
  )
  public void setUserData(Map<String, Object> userData) {
    this.userData = userData;
  }

  public SearchResponse hits(List<Record> hits) {
    this.hits = hits;
    return this;
  }

  public SearchResponse addHitsItem(Record hitsItem) {
    this.hits.add(hitsItem);
    return this;
  }

  /**
   * Get hits
   *
   * @return hits
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_HITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public List<Record> getHits() {
    return hits;
  }

  @JsonProperty(JSON_PROPERTY_HITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHits(List<Record> hits) {
    this.hits = hits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchResponse searchResponse = (SearchResponse) o;
    return (
      Objects.equals(this.abTestID, searchResponse.abTestID) &&
      Objects.equals(this.abTestVariantID, searchResponse.abTestVariantID) &&
      Objects.equals(this.aroundLatLng, searchResponse.aroundLatLng) &&
      Objects.equals(this.automaticRadius, searchResponse.automaticRadius) &&
      Objects.equals(
        this.exhaustiveFacetsCount,
        searchResponse.exhaustiveFacetsCount
      ) &&
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
      Objects.equals(this.params, searchResponse.params) &&
      Objects.equals(this.parsedQuery, searchResponse.parsedQuery) &&
      Objects.equals(this.processingTimeMS, searchResponse.processingTimeMS) &&
      Objects.equals(this.query, searchResponse.query) &&
      Objects.equals(
        this.queryAfterRemoval,
        searchResponse.queryAfterRemoval
      ) &&
      Objects.equals(this.serverUsed, searchResponse.serverUsed) &&
      Objects.equals(this.userData, searchResponse.userData) &&
      Objects.equals(this.hits, searchResponse.hits)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      abTestID,
      abTestVariantID,
      aroundLatLng,
      automaticRadius,
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
      params,
      parsedQuery,
      processingTimeMS,
      query,
      queryAfterRemoval,
      serverUsed,
      userData,
      hits
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchResponse {\n");
    sb.append("    abTestID: ").append(toIndentedString(abTestID)).append("\n");
    sb
      .append("    abTestVariantID: ")
      .append(toIndentedString(abTestVariantID))
      .append("\n");
    sb
      .append("    aroundLatLng: ")
      .append(toIndentedString(aroundLatLng))
      .append("\n");
    sb
      .append("    automaticRadius: ")
      .append(toIndentedString(automaticRadius))
      .append("\n");
    sb
      .append("    exhaustiveFacetsCount: ")
      .append(toIndentedString(exhaustiveFacetsCount))
      .append("\n");
    sb
      .append("    exhaustiveNbHits: ")
      .append(toIndentedString(exhaustiveNbHits))
      .append("\n");
    sb
      .append("    exhaustiveTypo: ")
      .append(toIndentedString(exhaustiveTypo))
      .append("\n");
    sb.append("    facets: ").append(toIndentedString(facets)).append("\n");
    sb
      .append("    facetsStats: ")
      .append(toIndentedString(facetsStats))
      .append("\n");
    sb
      .append("    hitsPerPage: ")
      .append(toIndentedString(hitsPerPage))
      .append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb
      .append("    indexUsed: ")
      .append(toIndentedString(indexUsed))
      .append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    nbHits: ").append(toIndentedString(nbHits)).append("\n");
    sb.append("    nbPages: ").append(toIndentedString(nbPages)).append("\n");
    sb
      .append("    nbSortedHits: ")
      .append(toIndentedString(nbSortedHits))
      .append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    params: ").append(toIndentedString(params)).append("\n");
    sb
      .append("    parsedQuery: ")
      .append(toIndentedString(parsedQuery))
      .append("\n");
    sb
      .append("    processingTimeMS: ")
      .append(toIndentedString(processingTimeMS))
      .append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb
      .append("    queryAfterRemoval: ")
      .append(toIndentedString(queryAfterRemoval))
      .append("\n");
    sb
      .append("    serverUsed: ")
      .append(toIndentedString(serverUsed))
      .append("\n");
    sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
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
