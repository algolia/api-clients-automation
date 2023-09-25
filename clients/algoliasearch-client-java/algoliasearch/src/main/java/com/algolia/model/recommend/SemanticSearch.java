// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Settings for the semantic search part of NeuralSearch. Only used when `mode` is _neuralSearch_.
 */
public class SemanticSearch {

  @JsonProperty("eventSources")
  private List<String> eventSources;

  public SemanticSearch setEventSources(List<String> eventSources) {
    this.eventSources = eventSources;
    return this;
  }

  public SemanticSearch addEventSources(String eventSourcesItem) {
    if (this.eventSources == null) {
      this.eventSources = new ArrayList<>();
    }
    this.eventSources.add(eventSourcesItem);
    return this;
  }

  /**
   * Indices from which to collect click and conversion events. If null, the current index and
   * replica group will be used as the event source.
   */
  @javax.annotation.Nullable
  public List<String> getEventSources() {
    return eventSources;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SemanticSearch semanticSearch = (SemanticSearch) o;
    return Objects.equals(this.eventSources, semanticSearch.eventSources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventSources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SemanticSearch {\n");
    sb.append("    eventSources: ").append(toIndentedString(eventSources)).append("\n");
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
