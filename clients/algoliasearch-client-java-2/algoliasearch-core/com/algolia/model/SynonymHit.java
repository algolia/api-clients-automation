package com.algolia.model;

import com.algolia.model.SynonymHitHighlightResult;
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
 * Synonym object.
 */
@ApiModel(description = "Synonym object.")
public class SynonymHit {

  public static final String SERIALIZED_NAME_OBJECT_I_D = "objectID";

  @SerializedName(SERIALIZED_NAME_OBJECT_I_D)
  private String objectID;

  /**
   * Type of the synonym object.
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    SYNONYM("synonym"),

    ONEWAYSYNONYM("onewaysynonym"),

    ALTCORRECTION1("altcorrection1"),

    ALTCORRECTION2("altcorrection2"),

    PLACEHOLDER("placeholder");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {

      @Override
      public void write(
        final JsonWriter jsonWriter,
        final TypeEnum enumeration
      ) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_TYPE = "type";

  @SerializedName(SERIALIZED_NAME_TYPE)
  private TypeEnum type;

  public static final String SERIALIZED_NAME_SYNONYMS = "synonyms";

  @SerializedName(SERIALIZED_NAME_SYNONYMS)
  private List<String> synonyms = null;

  public static final String SERIALIZED_NAME_INPUT = "input";

  @SerializedName(SERIALIZED_NAME_INPUT)
  private String input;

  public static final String SERIALIZED_NAME_WORD = "word";

  @SerializedName(SERIALIZED_NAME_WORD)
  private String word;

  public static final String SERIALIZED_NAME_CORRECTIONS = "corrections";

  @SerializedName(SERIALIZED_NAME_CORRECTIONS)
  private List<String> corrections = null;

  public static final String SERIALIZED_NAME_PLACEHOLDER = "placeholder";

  @SerializedName(SERIALIZED_NAME_PLACEHOLDER)
  private String placeholder;

  public static final String SERIALIZED_NAME_REPLACEMENTS = "replacements";

  @SerializedName(SERIALIZED_NAME_REPLACEMENTS)
  private List<String> replacements = null;

  public static final String SERIALIZED_NAME_HIGHLIGHT_RESULT =
    "_highlightResult";

  @SerializedName(SERIALIZED_NAME_HIGHLIGHT_RESULT)
  private SynonymHitHighlightResult highlightResult;

  public SynonymHit objectID(String objectID) {
    this.objectID = objectID;
    return this;
  }

  /**
   * Unique identifier of the synonym object to be created or updated.
   * @return objectID
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Unique identifier of the synonym object to be created or updated."
  )
  public String getObjectID() {
    return objectID;
  }

  public void setObjectID(String objectID) {
    this.objectID = objectID;
  }

  public SynonymHit type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the synonym object.
   * @return type
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Type of the synonym object.")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public SynonymHit synonyms(List<String> synonyms) {
    this.synonyms = synonyms;
    return this;
  }

  public SynonymHit addSynonymsItem(String synonymsItem) {
    if (this.synonyms == null) {
      this.synonyms = new ArrayList<>();
    }
    this.synonyms.add(synonymsItem);
    return this;
  }

  /**
   * Words or phrases to be considered equivalent.
   * @return synonyms
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Words or phrases to be considered equivalent.")
  public List<String> getSynonyms() {
    return synonyms;
  }

  public void setSynonyms(List<String> synonyms) {
    this.synonyms = synonyms;
  }

  public SynonymHit input(String input) {
    this.input = input;
    return this;
  }

  /**
   * Word or phrase to appear in query strings (for onewaysynonym).
   * @return input
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Word or phrase to appear in query strings (for onewaysynonym)."
  )
  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public SynonymHit word(String word) {
    this.word = word;
    return this;
  }

  /**
   * Word or phrase to appear in query strings (for altcorrection1 and altcorrection2).
   * @return word
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Word or phrase to appear in query strings (for altcorrection1 and altcorrection2)."
  )
  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public SynonymHit corrections(List<String> corrections) {
    this.corrections = corrections;
    return this;
  }

  public SynonymHit addCorrectionsItem(String correctionsItem) {
    if (this.corrections == null) {
      this.corrections = new ArrayList<>();
    }
    this.corrections.add(correctionsItem);
    return this;
  }

  /**
   * Words to be matched in records.
   * @return corrections
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Words to be matched in records.")
  public List<String> getCorrections() {
    return corrections;
  }

  public void setCorrections(List<String> corrections) {
    this.corrections = corrections;
  }

  public SynonymHit placeholder(String placeholder) {
    this.placeholder = placeholder;
    return this;
  }

  /**
   * Token to be put inside records.
   * @return placeholder
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Token to be put inside records.")
  public String getPlaceholder() {
    return placeholder;
  }

  public void setPlaceholder(String placeholder) {
    this.placeholder = placeholder;
  }

  public SynonymHit replacements(List<String> replacements) {
    this.replacements = replacements;
    return this;
  }

  public SynonymHit addReplacementsItem(String replacementsItem) {
    if (this.replacements == null) {
      this.replacements = new ArrayList<>();
    }
    this.replacements.add(replacementsItem);
    return this;
  }

  /**
   * List of query words that will match the token.
   * @return replacements
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "List of query words that will match the token.")
  public List<String> getReplacements() {
    return replacements;
  }

  public void setReplacements(List<String> replacements) {
    this.replacements = replacements;
  }

  public SynonymHit highlightResult(SynonymHitHighlightResult highlightResult) {
    this.highlightResult = highlightResult;
    return this;
  }

  /**
   * Get highlightResult
   * @return highlightResult
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  public SynonymHitHighlightResult getHighlightResult() {
    return highlightResult;
  }

  public void setHighlightResult(SynonymHitHighlightResult highlightResult) {
    this.highlightResult = highlightResult;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SynonymHit synonymHit = (SynonymHit) o;
    return (
      Objects.equals(this.objectID, synonymHit.objectID) &&
      Objects.equals(this.type, synonymHit.type) &&
      Objects.equals(this.synonyms, synonymHit.synonyms) &&
      Objects.equals(this.input, synonymHit.input) &&
      Objects.equals(this.word, synonymHit.word) &&
      Objects.equals(this.corrections, synonymHit.corrections) &&
      Objects.equals(this.placeholder, synonymHit.placeholder) &&
      Objects.equals(this.replacements, synonymHit.replacements) &&
      Objects.equals(this.highlightResult, synonymHit.highlightResult)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      objectID,
      type,
      synonyms,
      input,
      word,
      corrections,
      placeholder,
      replacements,
      highlightResult
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SynonymHit {\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    synonyms: ").append(toIndentedString(synonyms)).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    word: ").append(toIndentedString(word)).append("\n");
    sb
      .append("    corrections: ")
      .append(toIndentedString(corrections))
      .append("\n");
    sb
      .append("    placeholder: ")
      .append(toIndentedString(placeholder))
      .append("\n");
    sb
      .append("    replacements: ")
      .append(toIndentedString(replacements))
      .append("\n");
    sb
      .append("    highlightResult: ")
      .append(toIndentedString(highlightResult))
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
