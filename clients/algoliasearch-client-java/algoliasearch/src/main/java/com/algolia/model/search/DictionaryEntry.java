// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** Dictionary entry. */
public class DictionaryEntry {

  @JsonProperty("objectID")
  private String objectID;

  @JsonProperty("language")
  private SupportedLanguage language;

  @JsonProperty("word")
  private String word;

  @JsonProperty("words")
  private List<String> words;

  @JsonProperty("decomposition")
  private List<String> decomposition;

  @JsonProperty("state")
  private DictionaryEntryState state;

  private Map<String, Object> additionalProperties = new HashMap<>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public DictionaryEntry setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }

  public DictionaryEntry setObjectID(String objectID) {
    this.objectID = objectID;
    return this;
  }

  /** Unique identifier for the dictionary entry. */
  @javax.annotation.Nonnull
  public String getObjectID() {
    return objectID;
  }

  public DictionaryEntry setLanguage(SupportedLanguage language) {
    this.language = language;
    return this;
  }

  /** Get language */
  @javax.annotation.Nonnull
  public SupportedLanguage getLanguage() {
    return language;
  }

  public DictionaryEntry setWord(String word) {
    this.word = word;
    return this;
  }

  /** Matching dictionary word for `stopwords` and `compounds` dictionaries. */
  @javax.annotation.Nullable
  public String getWord() {
    return word;
  }

  public DictionaryEntry setWords(List<String> words) {
    this.words = words;
    return this;
  }

  public DictionaryEntry addWords(String wordsItem) {
    if (this.words == null) {
      this.words = new ArrayList<>();
    }
    this.words.add(wordsItem);
    return this;
  }

  /** Matching words in the `plurals` dictionary including declensions. */
  @javax.annotation.Nullable
  public List<String> getWords() {
    return words;
  }

  public DictionaryEntry setDecomposition(List<String> decomposition) {
    this.decomposition = decomposition;
    return this;
  }

  public DictionaryEntry addDecomposition(String decompositionItem) {
    if (this.decomposition == null) {
      this.decomposition = new ArrayList<>();
    }
    this.decomposition.add(decompositionItem);
    return this;
  }

  /** Invividual components of a compound word in the `compounds` dictionary. */
  @javax.annotation.Nullable
  public List<String> getDecomposition() {
    return decomposition;
  }

  public DictionaryEntry setState(DictionaryEntryState state) {
    this.state = state;
    return this;
  }

  /** Get state */
  @javax.annotation.Nullable
  public DictionaryEntryState getState() {
    return state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DictionaryEntry dictionaryEntry = (DictionaryEntry) o;
    return (
      Objects.equals(this.objectID, dictionaryEntry.objectID) &&
      Objects.equals(this.language, dictionaryEntry.language) &&
      Objects.equals(this.word, dictionaryEntry.word) &&
      Objects.equals(this.words, dictionaryEntry.words) &&
      Objects.equals(this.decomposition, dictionaryEntry.decomposition) &&
      Objects.equals(this.state, dictionaryEntry.state) &&
      super.equals(o)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(objectID, language, word, words, decomposition, state, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DictionaryEntry {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    word: ").append(toIndentedString(word)).append("\n");
    sb.append("    words: ").append(toIndentedString(words)).append("\n");
    sb.append("    decomposition: ").append(toIndentedString(decomposition)).append("\n");
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
