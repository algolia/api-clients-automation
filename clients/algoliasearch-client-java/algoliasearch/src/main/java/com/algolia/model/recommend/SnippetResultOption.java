// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** Snippets that show the context around a matching search query. */
@JsonDeserialize(as = SnippetResultOption.class)
public class SnippetResultOption implements SnippetResult {

  @JsonProperty("value")
  private String value;

  @JsonProperty("matchLevel")
  private MatchLevel matchLevel;

  public SnippetResultOption setValue(String value) {
    this.value = value;
    return this;
  }

  /** Highlighted attribute value, including HTML tags. */
  @javax.annotation.Nonnull
  public String getValue() {
    return value;
  }

  public SnippetResultOption setMatchLevel(MatchLevel matchLevel) {
    this.matchLevel = matchLevel;
    return this;
  }

  /** Get matchLevel */
  @javax.annotation.Nonnull
  public MatchLevel getMatchLevel() {
    return matchLevel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SnippetResultOption snippetResultOption = (SnippetResultOption) o;
    return Objects.equals(this.value, snippetResultOption.value) && Objects.equals(this.matchLevel, snippetResultOption.matchLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, matchLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SnippetResultOption {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    matchLevel: ").append(toIndentedString(matchLevel)).append("\n");
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
