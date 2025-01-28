// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.composition;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** CompositionsSearchResponse */
public class CompositionsSearchResponse {

  @JsonProperty("run")
  private List<CompositionRunSearchResponse> run = new ArrayList<>();

  private Map<String, Object> additionalProperties = new HashMap<>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public CompositionsSearchResponse setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }

  public CompositionsSearchResponse setRun(List<CompositionRunSearchResponse> run) {
    this.run = run;
    return this;
  }

  public CompositionsSearchResponse addRun(CompositionRunSearchResponse runItem) {
    this.run.add(runItem);
    return this;
  }

  /** Get run */
  @javax.annotation.Nonnull
  public List<CompositionRunSearchResponse> getRun() {
    return run;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompositionsSearchResponse compositionsSearchResponse = (CompositionsSearchResponse) o;
    return Objects.equals(this.run, compositionsSearchResponse.run) && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(run, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompositionsSearchResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    run: ").append(toIndentedString(run)).append("\n");
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
