// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.querysuggestions;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Query Suggestions configuration. */
public class Configuration {

  @JsonProperty("sourceIndices")
  private List<SourceIndex> sourceIndices = new ArrayList<>();

  @JsonProperty("languages")
  private Languages languages;

  @JsonProperty("exclude")
  private List<String> exclude;

  @JsonProperty("enablePersonalization")
  private Boolean enablePersonalization;

  @JsonProperty("allowSpecialCharacters")
  private Boolean allowSpecialCharacters;

  public Configuration setSourceIndices(List<SourceIndex> sourceIndices) {
    this.sourceIndices = sourceIndices;
    return this;
  }

  public Configuration addSourceIndices(SourceIndex sourceIndicesItem) {
    this.sourceIndices.add(sourceIndicesItem);
    return this;
  }

  /** Algolia indices from which to get the popular searches for query suggestions. */
  @javax.annotation.Nonnull
  public List<SourceIndex> getSourceIndices() {
    return sourceIndices;
  }

  public Configuration setLanguages(Languages languages) {
    this.languages = languages;
    return this;
  }

  /** Get languages */
  @javax.annotation.Nullable
  public Languages getLanguages() {
    return languages;
  }

  public Configuration setExclude(List<String> exclude) {
    this.exclude = exclude;
    return this;
  }

  public Configuration addExclude(String excludeItem) {
    if (this.exclude == null) {
      this.exclude = new ArrayList<>();
    }
    this.exclude.add(excludeItem);
    return this;
  }

  /** Get exclude */
  @javax.annotation.Nullable
  public List<String> getExclude() {
    return exclude;
  }

  public Configuration setEnablePersonalization(Boolean enablePersonalization) {
    this.enablePersonalization = enablePersonalization;
    return this;
  }

  /** Whether to turn on personalized query suggestions. */
  @javax.annotation.Nullable
  public Boolean getEnablePersonalization() {
    return enablePersonalization;
  }

  public Configuration setAllowSpecialCharacters(Boolean allowSpecialCharacters) {
    this.allowSpecialCharacters = allowSpecialCharacters;
    return this;
  }

  /** Whether to include suggestions with special characters. */
  @javax.annotation.Nullable
  public Boolean getAllowSpecialCharacters() {
    return allowSpecialCharacters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Configuration configuration = (Configuration) o;
    return (
      Objects.equals(this.sourceIndices, configuration.sourceIndices) &&
      Objects.equals(this.languages, configuration.languages) &&
      Objects.equals(this.exclude, configuration.exclude) &&
      Objects.equals(this.enablePersonalization, configuration.enablePersonalization) &&
      Objects.equals(this.allowSpecialCharacters, configuration.allowSpecialCharacters)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(sourceIndices, languages, exclude, enablePersonalization, allowSpecialCharacters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Configuration {\n");
    sb.append("    sourceIndices: ").append(toIndentedString(sourceIndices)).append("\n");
    sb.append("    languages: ").append(toIndentedString(languages)).append("\n");
    sb.append("    exclude: ").append(toIndentedString(exclude)).append("\n");
    sb.append("    enablePersonalization: ").append(toIndentedString(enablePersonalization)).append("\n");
    sb.append("    allowSpecialCharacters: ").append(toIndentedString(allowSpecialCharacters)).append("\n");
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
