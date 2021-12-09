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
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;
import java.util.Objects;

/**
 * SnippetResult
 */
@JsonPropertyOrder(
  { SnippetResult.JSON_PROPERTY_VALUE, SnippetResult.JSON_PROPERTY_MATCH_LEVEL }
)
@JsonTypeName("snippetResult")
public class SnippetResult {

  public static final String JSON_PROPERTY_VALUE = "value";
  private String value;

  /**
   * Indicates how well the attribute matched the search query.
   */
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

  public SnippetResult value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Markup text with occurrences highlighted.
   * @return value
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(
    example = "<em>George</em> <em>Clo</em>oney...",
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

  public SnippetResult matchLevel(MatchLevelEnum matchLevel) {
    this.matchLevel = matchLevel;
    return this;
  }

  /**
   * Indicates how well the attribute matched the search query.
   * @return matchLevel
   **/
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SnippetResult snippetResult = (SnippetResult) o;
    return (
      Objects.equals(this.value, snippetResult.value) &&
      Objects.equals(this.matchLevel, snippetResult.matchLevel)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, matchLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SnippetResult {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb
      .append("    matchLevel: ")
      .append(toIndentedString(matchLevel))
      .append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
