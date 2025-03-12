// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** RelatedQuery */
@JsonDeserialize(as = RelatedQuery.class)
public class RelatedQuery implements RecommendationsRequest {

  @JsonProperty("indexName")
  private String indexName;

  @JsonProperty("threshold")
  private Double threshold;

  @JsonProperty("maxRecommendations")
  private Integer maxRecommendations;

  @JsonProperty("queryParameters")
  private RecommendSearchParams queryParameters;

  @JsonProperty("model")
  private RelatedModel model;

  @JsonProperty("objectID")
  private String objectID;

  @JsonProperty("fallbackParameters")
  private FallbackParams fallbackParameters;

  public RelatedQuery setIndexName(String indexName) {
    this.indexName = indexName;
    return this;
  }

  /** Index name (case-sensitive). */
  @javax.annotation.Nonnull
  public String getIndexName() {
    return indexName;
  }

  public RelatedQuery setThreshold(Double threshold) {
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

  public RelatedQuery setMaxRecommendations(Integer maxRecommendations) {
    this.maxRecommendations = maxRecommendations;
    return this;
  }

  /**
   * Maximum number of recommendations to retrieve. By default, all recommendations are returned and
   * no fallback request is made. Depending on the available recommendations and the other request
   * parameters, the actual number of recommendations may be lower than this value. minimum: 1
   * maximum: 30
   */
  @javax.annotation.Nullable
  public Integer getMaxRecommendations() {
    return maxRecommendations;
  }

  public RelatedQuery setQueryParameters(RecommendSearchParams queryParameters) {
    this.queryParameters = queryParameters;
    return this;
  }

  /** Get queryParameters */
  @javax.annotation.Nullable
  public RecommendSearchParams getQueryParameters() {
    return queryParameters;
  }

  public RelatedQuery setModel(RelatedModel model) {
    this.model = model;
    return this;
  }

  /** Get model */
  @javax.annotation.Nonnull
  public RelatedModel getModel() {
    return model;
  }

  public RelatedQuery setObjectID(String objectID) {
    this.objectID = objectID;
    return this;
  }

  /** Unique record identifier. */
  @javax.annotation.Nonnull
  public String getObjectID() {
    return objectID;
  }

  public RelatedQuery setFallbackParameters(FallbackParams fallbackParameters) {
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
    RelatedQuery relatedQuery = (RelatedQuery) o;
    return (
      Objects.equals(this.indexName, relatedQuery.indexName) &&
      Objects.equals(this.threshold, relatedQuery.threshold) &&
      Objects.equals(this.maxRecommendations, relatedQuery.maxRecommendations) &&
      Objects.equals(this.queryParameters, relatedQuery.queryParameters) &&
      Objects.equals(this.model, relatedQuery.model) &&
      Objects.equals(this.objectID, relatedQuery.objectID) &&
      Objects.equals(this.fallbackParameters, relatedQuery.fallbackParameters)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(indexName, threshold, maxRecommendations, queryParameters, model, objectID, fallbackParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedQuery {\n");
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
