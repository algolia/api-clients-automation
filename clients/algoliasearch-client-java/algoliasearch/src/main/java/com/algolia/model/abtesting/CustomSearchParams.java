// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.abtesting;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/**
 * Applies search parameters from [a restricted set of
 * options](https://www.algolia.com/doc/api-reference/api-methods/add-ab-test/#method-param-customsearchparameters).
 * Only use this parameter if the two variants use the same index.
 */
public class CustomSearchParams {

  @JsonProperty("customSearchParameters")
  private Object customSearchParameters;

  public CustomSearchParams setCustomSearchParameters(Object customSearchParameters) {
    this.customSearchParameters = customSearchParameters;
    return this;
  }

  /** Get customSearchParameters */
  @javax.annotation.Nonnull
  public Object getCustomSearchParameters() {
    return customSearchParameters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomSearchParams customSearchParams = (CustomSearchParams) o;
    return Objects.equals(this.customSearchParameters, customSearchParams.customSearchParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customSearchParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomSearchParams {\n");
    sb.append("    customSearchParameters: ").append(toIndentedString(customSearchParameters)).append("\n");
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
