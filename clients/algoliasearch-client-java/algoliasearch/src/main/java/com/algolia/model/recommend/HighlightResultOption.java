// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Surround words that match the query with HTML tags for highlighting. */
@JsonDeserialize(as = HighlightResultOption.class)
public class HighlightResultOption implements HighlightResult {

  @JsonProperty("value")
  private String value;

  @JsonProperty("matchLevel")
  private MatchLevel matchLevel;

  @JsonProperty("matchedWords")
  private List<String> matchedWords = new ArrayList<>();

  @JsonProperty("fullyHighlighted")
  private Boolean fullyHighlighted;

  public HighlightResultOption setValue(String value) {
    this.value = value;
    return this;
  }

  /** Highlighted attribute value, including HTML tags. */
  @javax.annotation.Nonnull
  public String getValue() {
    return value;
  }

  public HighlightResultOption setMatchLevel(MatchLevel matchLevel) {
    this.matchLevel = matchLevel;
    return this;
  }

  /** Get matchLevel */
  @javax.annotation.Nonnull
  public MatchLevel getMatchLevel() {
    return matchLevel;
  }

  public HighlightResultOption setMatchedWords(List<String> matchedWords) {
    this.matchedWords = matchedWords;
    return this;
  }

  public HighlightResultOption addMatchedWords(String matchedWordsItem) {
    this.matchedWords.add(matchedWordsItem);
    return this;
  }

  /** List of matched words from the search query. */
  @javax.annotation.Nonnull
  public List<String> getMatchedWords() {
    return matchedWords;
  }

  public HighlightResultOption setFullyHighlighted(Boolean fullyHighlighted) {
    this.fullyHighlighted = fullyHighlighted;
    return this;
  }

  /** Whether the entire attribute value is highlighted. */
  @javax.annotation.Nullable
  public Boolean getFullyHighlighted() {
    return fullyHighlighted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HighlightResultOption highlightResultOption = (HighlightResultOption) o;
    return (
      Objects.equals(this.value, highlightResultOption.value) &&
      Objects.equals(this.matchLevel, highlightResultOption.matchLevel) &&
      Objects.equals(this.matchedWords, highlightResultOption.matchedWords) &&
      Objects.equals(this.fullyHighlighted, highlightResultOption.fullyHighlighted)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, matchLevel, matchedWords, fullyHighlighted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HighlightResultOption {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    matchLevel: ").append(toIndentedString(matchLevel)).append("\n");
    sb.append("    matchedWords: ").append(toIndentedString(matchedWords)).append("\n");
    sb.append("    fullyHighlighted: ").append(toIndentedString(fullyHighlighted)).append("\n");
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
