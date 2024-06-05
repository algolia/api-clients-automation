// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** LookingSimilarQuery */
@JsonDeserialize(as = LookingSimilarQuery.class)
public class LookingSimilarQuery implements RecommendationsRequest {

  @JsonProperty("indexName")
  private String indexName;

  @JsonProperty("threshold")
  private Double threshold;

  @JsonProperty("maxRecommendations")
  private Integer maxRecommendations;

  @JsonProperty("queryParameters")
  private SearchParams queryParameters;

  @JsonProperty("model")
  private LookingSimilarModel model;

  @JsonProperty("objectID")
  private String objectID;

  @JsonProperty("fallbackParameters")
  private FallbackParams fallbackParameters;

  public LookingSimilarQuery setIndexName(String indexName) {
    this.indexName = indexName;
    return this;
  }

  /** Index name (case-sensitive). */
  @javax.annotation.Nonnull
  public String getIndexName() {
    return indexName;
  }

  public LookingSimilarQuery setThreshold(Double threshold) {
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

  public LookingSimilarQuery setMaxRecommendations(Integer maxRecommendations) {
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

  public LookingSimilarQuery setQueryParameters(SearchParams queryParameters) {
    this.queryParameters = queryParameters;
    return this;
  }

  /** Get queryParameters */
  @javax.annotation.Nullable
  public SearchParams getQueryParameters() {
    return queryParameters;
  }

  public LookingSimilarQuery setModel(LookingSimilarModel model) {
    this.model = model;
    return this;
  }

  /** Get model */
  @javax.annotation.Nonnull
  public LookingSimilarModel getModel() {
    return model;
  }

  public LookingSimilarQuery setObjectID(String objectID) {
    this.objectID = objectID;
    return this;
  }

  /** Unique record identifier. */
  @javax.annotation.Nonnull
  public String getObjectID() {
    return objectID;
  }

  public LookingSimilarQuery setFallbackParameters(FallbackParams fallbackParameters) {
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
    LookingSimilarQuery lookingSimilarQuery = (LookingSimilarQuery) o;
    return (
      Objects.equals(this.indexName, lookingSimilarQuery.indexName) &&
      Objects.equals(this.threshold, lookingSimilarQuery.threshold) &&
      Objects.equals(this.maxRecommendations, lookingSimilarQuery.maxRecommendations) &&
      Objects.equals(this.queryParameters, lookingSimilarQuery.queryParameters) &&
      Objects.equals(this.model, lookingSimilarQuery.model) &&
      Objects.equals(this.objectID, lookingSimilarQuery.objectID) &&
      Objects.equals(this.fallbackParameters, lookingSimilarQuery.fallbackParameters)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(indexName, threshold, maxRecommendations, queryParameters, model, objectID, fallbackParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LookingSimilarQuery {\n");
    sb.append("    indexName: ").append(toIndentedString(indexName)).append("\n");
    sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
    sb.append("    maxRecommendations: ").append(toIndentedString(maxRecommendations)).append("\n");
    sb.append("    queryParameters: ").append(toIndentedString(queryParameters)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
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
