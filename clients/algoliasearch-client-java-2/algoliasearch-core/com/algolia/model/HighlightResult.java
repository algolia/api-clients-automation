/*
 * Search API
 * API powering the Search feature of Algolia.
 *
 * The version of the OpenAPI document: 0.1.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.algolia.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** HighlightResult */
@JsonPropertyOrder(
  {
    HighlightResult.JSON_PROPERTY_VALUE,
    HighlightResult.JSON_PROPERTY_MATCH_LEVEL,
    HighlightResult.JSON_PROPERTY_MATCHED_WORDS,
    HighlightResult.JSON_PROPERTY_FULLY_HIGHLIGHTED,
  }
)
@JsonTypeName("highlightResult")
public class HighlightResult {

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  /** Indicates how well the attribute matched the search query. */
  public enum MatchLevelEnum {
    NONE("none"),

    PARTIAL("partial"),

    FULL("full");

    private String value;

    MatchLevelEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MatchLevelEnum fromValue(String value) {
      for (MatchLevelEnum b : MatchLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_MATCH_LEVEL = "matchLevel";
  private MatchLevelEnum matchLevel;

  public static final String JSON_PROPERTY_MATCHED_WORDS = "matchedWords";
  private List<String> matchedWords = null;

  public static final String JSON_PROPERTY_FULLY_HIGHLIGHTED =
    "fullyHighlighted";
  private Boolean fullyHighlighted;

  public HighlightResult value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Markup text with occurrences highlighted.
   *
   * @return value
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    example = "<em>George</em> <em>Clo</em>oney",
    value = "Markup text with occurrences highlighted."
  )
  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getValue() {
    return value;
  }

  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValue(String value) {
    this.value = value;
  }

  public HighlightResult matchLevel(MatchLevelEnum matchLevel) {
    this.matchLevel = matchLevel;
    return this;
  }

  /**
   * Indicates how well the attribute matched the search query.
   *
   * @return matchLevel
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Indicates how well the attribute matched the search query."
  )
  @JsonProperty(JSON_PROPERTY_MATCH_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public MatchLevelEnum getMatchLevel() {
    return matchLevel;
  }

  @JsonProperty(JSON_PROPERTY_MATCH_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMatchLevel(MatchLevelEnum matchLevel) {
    this.matchLevel = matchLevel;
  }

  public HighlightResult matchedWords(List<String> matchedWords) {
    this.matchedWords = matchedWords;
    return this;
  }

  public HighlightResult addMatchedWordsItem(String matchedWordsItem) {
    if (this.matchedWords == null) {
      this.matchedWords = new ArrayList<>();
    }
    this.matchedWords.add(matchedWordsItem);
    return this;
  }

  /**
   * List of words from the query that matched the object.
   *
   * @return matchedWords
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "List of words from the query that matched the object."
  )
  @JsonProperty(JSON_PROPERTY_MATCHED_WORDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getMatchedWords() {
    return matchedWords;
  }

  @JsonProperty(JSON_PROPERTY_MATCHED_WORDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMatchedWords(List<String> matchedWords) {
    this.matchedWords = matchedWords;
  }

  public HighlightResult fullyHighlighted(Boolean fullyHighlighted) {
    this.fullyHighlighted = fullyHighlighted;
    return this;
  }

  /**
   * Whether the entire attribute value is highlighted.
   *
   * @return fullyHighlighted
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Whether the entire attribute value is highlighted."
  )
  @JsonProperty(JSON_PROPERTY_FULLY_HIGHLIGHTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getFullyHighlighted() {
    return fullyHighlighted;
  }

  @JsonProperty(JSON_PROPERTY_FULLY_HIGHLIGHTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFullyHighlighted(Boolean fullyHighlighted) {
    this.fullyHighlighted = fullyHighlighted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HighlightResult highlightResult = (HighlightResult) o;
    return (
      Objects.equals(this.value, highlightResult.value) &&
      Objects.equals(this.matchLevel, highlightResult.matchLevel) &&
      Objects.equals(this.matchedWords, highlightResult.matchedWords) &&
      Objects.equals(this.fullyHighlighted, highlightResult.fullyHighlighted)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, matchLevel, matchedWords, fullyHighlighted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HighlightResult {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb
      .append("    matchLevel: ")
      .append(toIndentedString(matchLevel))
      .append("\n");
    sb
      .append("    matchedWords: ")
      .append(toIndentedString(matchedWords))
      .append("\n");
    sb
      .append("    fullyHighlighted: ")
      .append(toIndentedString(fullyHighlighted))
      .append("\n");
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
