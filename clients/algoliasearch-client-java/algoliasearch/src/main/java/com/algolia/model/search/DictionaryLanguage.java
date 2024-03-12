// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** Dictionary type. If `null`, this dictionary type isn't supported for the language. */
public class DictionaryLanguage {

  @JsonProperty("nbCustomEntries")
  private Integer nbCustomEntries;

  public DictionaryLanguage setNbCustomEntries(Integer nbCustomEntries) {
    this.nbCustomEntries = nbCustomEntries;
    return this;
  }

  /** Number of custom dictionary entries. */
  @javax.annotation.Nullable
  public Integer getNbCustomEntries() {
    return nbCustomEntries;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DictionaryLanguage dictionaryLanguage = (DictionaryLanguage) o;
    return Objects.equals(this.nbCustomEntries, dictionaryLanguage.nbCustomEntries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nbCustomEntries);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DictionaryLanguage {\n");
    sb.append("    nbCustomEntries: ").append(toIndentedString(nbCustomEntries)).append("\n");
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
