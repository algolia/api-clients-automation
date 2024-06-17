// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** TrendingFacetsQuery */
@JsonDeserialize(as = TrendingFacetsQuery.class)
public class TrendingFacetsQuery implements RecommendationsRequest {

  @JsonProperty("indexName")
  private String indexName;

  @JsonProperty("threshold")
  private Double threshold;

  @JsonProperty("maxRecommendations")
  private Integer maxRecommendations;

  @JsonProperty("queryParameters")
  private SearchParams queryParameters;

  @JsonProperty("facetName")
  private Object facetName;

  @JsonProperty("model")
  private TrendingFacetsModel model;

  @JsonProperty("fallbackParameters")
  private FallbackParams fallbackParameters;

  public TrendingFacetsQuery setIndexName(String indexName) {
    this.indexName = indexName;
    return this;
  }

  /** Index name (case-sensitive). */
  @javax.annotation.Nonnull
  public String getIndexName() {
    return indexName;
  }

  public TrendingFacetsQuery setThreshold(Double threshold) {
    this.threshold = threshold;
    return this;
  }

  /**
   * Minimum score a recommendation must have to be included in the response. minimum: 0 maximum:
   * 100
   */
  @javax.annotation.Nonnull
  public Double getThreshold() {
    return threshold;
  }

  public TrendingFacetsQuery setMaxRecommendations(Integer maxRecommendations) {
    this.maxRecommendations = maxRecommendations;
    return this;
  }

  /**
   * Maximum number of recommendations to retrieve. By default, all recommendations are returned and
   * no fallback request is made. Depending on the available recommendations and the other request
   * parameters, the actual number of recommendations may be lower than this value. minimum: 1
   * maximum: 1000
   */
  @javax.annotation.Nullable
  public Integer getMaxRecommendations() {
    return maxRecommendations;
  }

  public TrendingFacetsQuery setQueryParameters(SearchParams queryParameters) {
    this.queryParameters = queryParameters;
    return this;
  }

  /** Get queryParameters */
  @javax.annotation.Nullable
  public SearchParams getQueryParameters() {
    return queryParameters;
  }

  public TrendingFacetsQuery setFacetName(Object facetName) {
    this.facetName = facetName;
    return this;
  }

  /** Facet attribute for which to retrieve trending facet values. */
  @javax.annotation.Nullable
  public Object getFacetName() {
    return facetName;
  }

  public TrendingFacetsQuery setModel(TrendingFacetsModel model) {
    this.model = model;
    return this;
  }

  /** Get model */
  @javax.annotation.Nonnull
  public TrendingFacetsModel getModel() {
    return model;
  }

  public TrendingFacetsQuery setFallbackParameters(FallbackParams fallbackParameters) {
    this.fallbackParameters = fallbackParameters;
    return this;
  }

  /** Get fallbackParameters */
  @javax.annotation.Nullable
  public FallbackParams getFallbackParameters() {
    return fallbackParameters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrendingFacetsQuery trendingFacetsQuery = (TrendingFacetsQuery) o;
    return (
      Objects.equals(this.indexName, trendingFacetsQuery.indexName) &&
      Objects.equals(this.threshold, trendingFacetsQuery.threshold) &&
      Objects.equals(this.maxRecommendations, trendingFacetsQuery.maxRecommendations) &&
      Objects.equals(this.queryParameters, trendingFacetsQuery.queryParameters) &&
      Objects.equals(this.facetName, trendingFacetsQuery.facetName) &&
      Objects.equals(this.model, trendingFacetsQuery.model) &&
      Objects.equals(this.fallbackParameters, trendingFacetsQuery.fallbackParameters)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(indexName, threshold, maxRecommendations, queryParameters, facetName, model, fallbackParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrendingFacetsQuery {\n");
    sb.append("    indexName: ").append(toIndentedString(indexName)).append("\n");
    sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
    sb.append("    maxRecommendations: ").append(toIndentedString(maxRecommendations)).append("\n");
    sb.append("    queryParameters: ").append(toIndentedString(queryParameters)).append("\n");
    sb.append("    facetName: ").append(toIndentedString(facetName)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    fallbackParameters: ").append(toIndentedString(fallbackParameters)).append("\n");
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
