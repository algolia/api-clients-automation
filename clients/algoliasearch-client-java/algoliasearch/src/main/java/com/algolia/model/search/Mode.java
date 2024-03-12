// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Search mode the index will use to query for results. This setting only applies to indices, for
 * which Algolia enabled NeuralSearch for you.
 */
public enum Mode {
  NEURAL_SEARCH("neuralSearch"),

  KEYWORD_SEARCH("keywordSearch");

  private final String value;

  Mode(String value) {
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
  public static Mode fromValue(String value) {
    for (Mode b : Mode.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
