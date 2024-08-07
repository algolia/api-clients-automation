// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Configured transformations and pagination information. */
public class ListTransformationsResponse {

  @JsonProperty("transformations")
  private List<Transformation> transformations = new ArrayList<>();

  @JsonProperty("pagination")
  private Pagination pagination;

  public ListTransformationsResponse setTransformations(List<Transformation> transformations) {
    this.transformations = transformations;
    return this;
  }

  public ListTransformationsResponse addTransformations(Transformation transformationsItem) {
    this.transformations.add(transformationsItem);
    return this;
  }

  /** Get transformations */
  @javax.annotation.Nonnull
  public List<Transformation> getTransformations() {
    return transformations;
  }

  public ListTransformationsResponse setPagination(Pagination pagination) {
    this.pagination = pagination;
    return this;
  }

  /** Get pagination */
  @javax.annotation.Nonnull
  public Pagination getPagination() {
    return pagination;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListTransformationsResponse listTransformationsResponse = (ListTransformationsResponse) o;
    return (
      Objects.equals(this.transformations, listTransformationsResponse.transformations) &&
      Objects.equals(this.pagination, listTransformationsResponse.pagination)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(transformations, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListTransformationsResponse {\n");
    sb.append("    transformations: ").append(toIndentedString(transformations)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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
