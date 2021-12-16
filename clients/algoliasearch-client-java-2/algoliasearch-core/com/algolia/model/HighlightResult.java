package com.algolia.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * HighlightResult
 */

public class HighlightResult {

  public static final String SERIALIZED_NAME_VALUE = "value";

  @SerializedName(SERIALIZED_NAME_VALUE)
  private String value;

  /**
   * Indicates how well the attribute matched the search query.
   */
  @JsonAdapter(MatchLevelEnum.Adapter.class)
  public enum MatchLevelEnum {
    NONE("none"),

    PARTIAL("partial"),

    FULL("full");

    private String value;

    MatchLevelEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MatchLevelEnum fromValue(String value) {
      for (MatchLevelEnum b : MatchLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<MatchLevelEnum> {

      @Override
      public void write(
        final JsonWriter jsonWriter,
        final MatchLevelEnum enumeration
      ) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MatchLevelEnum read(final JsonReader jsonReader)
        throws IOException {
        String value = jsonReader.nextString();
        return MatchLevelEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_MATCH_LEVEL = "matchLevel";

  @SerializedName(SERIALIZED_NAME_MATCH_LEVEL)
  private MatchLevelEnum matchLevel;

  public static final String SERIALIZED_NAME_MATCHED_WORDS = "matchedWords";

  @SerializedName(SERIALIZED_NAME_MATCHED_WORDS)
  private List<String> matchedWords = null;

  public static final String SERIALIZED_NAME_FULLY_HIGHLIGHTED =
    "fullyHighlighted";

  @SerializedName(SERIALIZED_NAME_FULLY_HIGHLIGHTED)
  private Boolean fullyHighlighted;

  public HighlightResult value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Markup text with occurrences highlighted.
   * @return value
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(
    example = "<em>George</em> <em>Clo</em>oney",
    value = "Markup text with occurrences highlighted."
  )
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public HighlightResult matchLevel(MatchLevelEnum matchLevel) {
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
  public MatchLevelEnum getMatchLevel() {
    return matchLevel;
  }

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
   * @return matchedWords
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "List of words from the query that matched the object."
  )
  public List<String> getMatchedWords() {
    return matchedWords;
  }

  public void setMatchedWords(List<String> matchedWords) {
    this.matchedWords = matchedWords;
  }

  public HighlightResult fullyHighlighted(Boolean fullyHighlighted) {
    this.fullyHighlighted = fullyHighlighted;
    return this;
  }

  /**
   * Whether the entire attribute value is highlighted.
   * @return fullyHighlighted
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Whether the entire attribute value is highlighted."
  )
  public Boolean getFullyHighlighted() {
    return fullyHighlighted;
  }

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
