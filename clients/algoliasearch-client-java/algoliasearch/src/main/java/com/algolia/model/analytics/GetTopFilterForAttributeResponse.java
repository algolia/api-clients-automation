// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.analytics;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** GetTopFilterForAttributeResponse */
public class GetTopFilterForAttributeResponse {

  @JsonProperty("values")
  private List<GetTopFilterForAttribute> values = new ArrayList<>();

  public GetTopFilterForAttributeResponse setValues(List<GetTopFilterForAttribute> values) {
    this.values = values;
    return this;
  }

  public GetTopFilterForAttributeResponse addValues(GetTopFilterForAttribute valuesItem) {
    this.values.add(valuesItem);
    return this;
  }

  /** Filter values for an attribute. */
  @javax.annotation.Nonnull
  public List<GetTopFilterForAttribute> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTopFilterForAttributeResponse getTopFilterForAttributeResponse = (GetTopFilterForAttributeResponse) o;
    return Objects.equals(this.values, getTopFilterForAttributeResponse.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTopFilterForAttributeResponse {\n");
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
