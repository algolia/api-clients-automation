// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** BaseRecommendedForYouQuery */
public class BaseRecommendedForYouQuery {

  @JsonProperty("model")
  private RecommendedForYouModel model;

  @JsonProperty("queryParameters")
  private RecommendedForYouQueryParameters queryParameters;

  @JsonProperty("fallbackParameters")
  private RecommendedForYouQueryParameters fallbackParameters;

  public BaseRecommendedForYouQuery setModel(RecommendedForYouModel model) {
    this.model = model;
    return this;
  }

  /** Get model */
  @javax.annotation.Nonnull
  public RecommendedForYouModel getModel() {
    return model;
  }

  public BaseRecommendedForYouQuery setQueryParameters(RecommendedForYouQueryParameters queryParameters) {
    this.queryParameters = queryParameters;
    return this;
  }

  /** Get queryParameters */
  @javax.annotation.Nullable
  public RecommendedForYouQueryParameters getQueryParameters() {
    return queryParameters;
  }

  public BaseRecommendedForYouQuery setFallbackParameters(RecommendedForYouQueryParameters fallbackParameters) {
    this.fallbackParameters = fallbackParameters;
    return this;
  }

  /** Get fallbackParameters */
  @javax.annotation.Nullable
  public RecommendedForYouQueryParameters getFallbackParameters() {
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
    BaseRecommendedForYouQuery baseRecommendedForYouQuery = (BaseRecommendedForYouQuery) o;
    return (
      Objects.equals(this.model, baseRecommendedForYouQuery.model) &&
      Objects.equals(this.queryParameters, baseRecommendedForYouQuery.queryParameters) &&
      Objects.equals(this.fallbackParameters, baseRecommendedForYouQuery.fallbackParameters)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(model, queryParameters, fallbackParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseRecommendedForYouQuery {\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    queryParameters: ").append(toIndentedString(queryParameters)).append("\n");
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
