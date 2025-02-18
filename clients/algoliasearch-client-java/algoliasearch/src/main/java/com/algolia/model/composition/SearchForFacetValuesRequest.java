// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.composition;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** SearchForFacetValuesRequest */
public class SearchForFacetValuesRequest {

  @JsonProperty("params")
  private SearchForFacetValuesParams params;

  public SearchForFacetValuesRequest setParams(SearchForFacetValuesParams params) {
    this.params = params;
    return this;
  }

  /** Get params */
  @javax.annotation.Nullable
  public SearchForFacetValuesParams getParams() {
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
    SearchForFacetValuesRequest searchForFacetValuesRequest = (SearchForFacetValuesRequest) o;
    return Objects.equals(this.params, searchForFacetValuesRequest.params);
  }

  @Override
  public int hashCode() {
    return Objects.hash(params);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchForFacetValuesRequest {\n");
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
