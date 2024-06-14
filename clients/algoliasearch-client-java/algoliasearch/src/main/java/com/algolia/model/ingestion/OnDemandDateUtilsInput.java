// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/**
 * Input for a manually-triggered task whose source is of type `bigquery` and for which extracted
 * data spans a given time range.
 */
@JsonDeserialize(as = OnDemandDateUtilsInput.class)
public class OnDemandDateUtilsInput implements TaskInput {

  @JsonProperty("startDate")
  private String startDate;

  @JsonProperty("endDate")
  private String endDate;

  @JsonProperty("mapping")
  private MappingInput mapping;

  public OnDemandDateUtilsInput setStartDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /** Earliest date in RFC 3339 format of the extracted data from Big Query. */
  @javax.annotation.Nonnull
  public String getStartDate() {
    return startDate;
  }

  public OnDemandDateUtilsInput setEndDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /** Latest date in RFC 3339 format of the extracted data from Big Query. */
  @javax.annotation.Nonnull
  public String getEndDate() {
    return endDate;
  }

  public OnDemandDateUtilsInput setMapping(MappingInput mapping) {
    this.mapping = mapping;
    return this;
  }

  /** Get mapping */
  @javax.annotation.Nullable
  public MappingInput getMapping() {
    return mapping;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OnDemandDateUtilsInput onDemandDateUtilsInput = (OnDemandDateUtilsInput) o;
    return (
      Objects.equals(this.startDate, onDemandDateUtilsInput.startDate) &&
      Objects.equals(this.endDate, onDemandDateUtilsInput.endDate) &&
      Objects.equals(this.mapping, onDemandDateUtilsInput.mapping)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, endDate, mapping);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OnDemandDateUtilsInput {\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    mapping: ").append(toIndentedString(mapping)).append("\n");
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
