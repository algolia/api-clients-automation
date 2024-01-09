// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** SourceSearch */
public class SourceSearch {

  @JsonProperty("sourceIDs")
  private List<String> sourceIDs = new ArrayList<>();

  public SourceSearch setSourceIDs(List<String> sourceIDs) {
    this.sourceIDs = sourceIDs;
    return this;
  }

  public SourceSearch addSourceIDs(String sourceIDsItem) {
    this.sourceIDs.add(sourceIDsItem);
    return this;
  }

  /** Get sourceIDs */
  @javax.annotation.Nonnull
  public List<String> getSourceIDs() {
    return sourceIDs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SourceSearch sourceSearch = (SourceSearch) o;
    return Objects.equals(this.sourceIDs, sourceSearch.sourceIDs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceIDs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SourceSearch {\n");
    sb.append("    sourceIDs: ").append(toIndentedString(sourceIDs)).append("\n");
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
