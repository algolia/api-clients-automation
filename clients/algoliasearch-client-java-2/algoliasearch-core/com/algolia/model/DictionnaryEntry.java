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
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/** A dictionary entry. */
@ApiModel(description = "A dictionary entry.")
public class DictionnaryEntry extends HashMap<String, Object> {

  public static final String SERIALIZED_NAME_OBJECT_I_D = "objectID";

  @SerializedName(SERIALIZED_NAME_OBJECT_I_D)
  private String objectID;

  public static final String SERIALIZED_NAME_LANGUAGE = "language";

  @SerializedName(SERIALIZED_NAME_LANGUAGE)
  private String language;

  public static final String SERIALIZED_NAME_WORD = "word";

  @SerializedName(SERIALIZED_NAME_WORD)
  private String word;

  public static final String SERIALIZED_NAME_WORDS = "words";

  @SerializedName(SERIALIZED_NAME_WORDS)
  private List<String> words = null;

  public static final String SERIALIZED_NAME_DECOMPOSITION = "decomposition";

  @SerializedName(SERIALIZED_NAME_DECOMPOSITION)
  private List<String> decomposition = null;

  /** The state of the dictionary entry. */
  @JsonAdapter(StateEnum.Adapter.class)
  public enum StateEnum {
    ENABLED("enabled"),

    DISABLED("disabled");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StateEnum fromValue(String value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StateEnum> {

      @Override
      public void write(
        final JsonWriter jsonWriter,
        final StateEnum enumeration
      ) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StateEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StateEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATE = "state";

  @SerializedName(SERIALIZED_NAME_STATE)
  private StateEnum state;

  public DictionnaryEntry objectID(String objectID) {
    this.objectID = objectID;
    return this;
  }

  /**
   * Unique identifier of the object.
   *
   * @return objectID
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Unique identifier of the object.")
  public String getObjectID() {
    return objectID;
  }

  public void setObjectID(String objectID) {
    this.objectID = objectID;
  }

  public DictionnaryEntry language(String language) {
    this.language = language;
    return this;
  }

  /**
   * Language ISO code supported by the dictionary (e.g., \"en\" for English).
   *
   * @return language
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Language ISO code supported by the dictionary (e.g., \"en\" for English)."
  )
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public DictionnaryEntry word(String word) {
    this.word = word;
    return this;
  }

  /**
   * The word of the dictionary entry.
   *
   * @return word
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The word of the dictionary entry.")
  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public DictionnaryEntry words(List<String> words) {
    this.words = words;
    return this;
  }

  public DictionnaryEntry addWordsItem(String wordsItem) {
    if (this.words == null) {
      this.words = new ArrayList<>();
    }
    this.words.add(wordsItem);
    return this;
  }

  /**
   * The words of the dictionary entry.
   *
   * @return words
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The words of the dictionary entry.")
  public List<String> getWords() {
    return words;
  }

  public void setWords(List<String> words) {
    this.words = words;
  }

  public DictionnaryEntry decomposition(List<String> decomposition) {
    this.decomposition = decomposition;
    return this;
  }

  public DictionnaryEntry addDecompositionItem(String decompositionItem) {
    if (this.decomposition == null) {
      this.decomposition = new ArrayList<>();
    }
    this.decomposition.add(decompositionItem);
    return this;
  }

  /**
   * A decomposition of the word of the dictionary entry.
   *
   * @return decomposition
   */
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "A decomposition of the word of the dictionary entry."
  )
  public List<String> getDecomposition() {
    return decomposition;
  }

  public void setDecomposition(List<String> decomposition) {
    this.decomposition = decomposition;
  }

  public DictionnaryEntry state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * The state of the dictionary entry.
   *
   * @return state
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The state of the dictionary entry.")
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DictionnaryEntry dictionnaryEntry = (DictionnaryEntry) o;
    return (
      Objects.equals(this.objectID, dictionnaryEntry.objectID) &&
      Objects.equals(this.language, dictionnaryEntry.language) &&
      Objects.equals(this.word, dictionnaryEntry.word) &&
      Objects.equals(this.words, dictionnaryEntry.words) &&
      Objects.equals(this.decomposition, dictionnaryEntry.decomposition) &&
      Objects.equals(this.state, dictionnaryEntry.state) &&
      super.equals(o)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      objectID,
      language,
      word,
      words,
      decomposition,
      state,
      super.hashCode()
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DictionnaryEntry {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    word: ").append(toIndentedString(word)).append("\n");
    sb.append("    words: ").append(toIndentedString(words)).append("\n");
    sb
      .append("    decomposition: ")
      .append(toIndentedString(decomposition))
      .append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
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
