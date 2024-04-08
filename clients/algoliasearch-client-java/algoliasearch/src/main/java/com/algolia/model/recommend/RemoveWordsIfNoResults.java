// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Strategy for removing words from the query when it doesn't return any results. This helps to
 * avoid returning empty search results. - `none`. No words are removed when a query doesn't return
 * results. - `lastWords`. Treat the last (then second to last, then third to last) word as
 * optional, until there are results or at most 5 words have been removed. - `firstWords`. Treat the
 * first (then second, then third) word as optional, until there are results or at most 5 words have
 * been removed. - `allOptional`. Treat all words as optional. For more information, see [Remove
 * words to improve
 * results](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/empty-or-insufficient-results/in-depth/why-use-remove-words-if-no-results/).
 */
public enum RemoveWordsIfNoResults {
  NONE("none"),

  LAST_WORDS("lastWords"),

  FIRST_WORDS("firstWords"),

  ALL_OPTIONAL("allOptional");

  private final String value;

  RemoveWordsIfNoResults(String value) {
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
  public static RemoveWordsIfNoResults fromValue(String value) {
    for (RemoveWordsIfNoResults b : RemoveWordsIfNoResults.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
