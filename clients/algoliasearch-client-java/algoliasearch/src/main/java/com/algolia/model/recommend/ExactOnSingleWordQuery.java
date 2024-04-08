// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * Determines how the [Exact ranking
 * criterion](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/override-search-engine-defaults/in-depth/adjust-exact-settings/#turn-off-exact-for-some-attributes)
 * is computed when the search query has only one word. - `attribute`. The Exact ranking criterion
 * is 1 if the query word and attribute value are the same. For example, a search for \"road\" will
 * match the value \"road\", but not \"road trip\". - `none`. The Exact ranking criterion is ignored
 * on single-word searches. - `word`. The Exact ranking criterion is 1 if the query word is found in
 * the attribute value. The query word must have at least 3 characters and must not be a stop word.
 * Only exact matches will be highlighted, partial and prefix matches won't.
 */
public enum ExactOnSingleWordQuery {
  ATTRIBUTE("attribute"),

  NONE("none"),

  WORD("word");

  private final String value;

  ExactOnSingleWordQuery(String value) {
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
  public static ExactOnSingleWordQuery fromValue(String value) {
    for (ExactOnSingleWordQuery b : ExactOnSingleWordQuery.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
