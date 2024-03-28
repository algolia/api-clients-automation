// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;

/**
 * A code for the task run's outcome. A readable description of the code is included in the `reason`
 * response property.
 */
public enum RunReasonCode {
  INTERNAL("internal"),

  CRITICAL("critical"),

  NO_EVENTS("no_events"),

  TOO_MANY_ERRORS("too_many_errors"),

  OK("ok"),

  DISCARDED("discarded"),

  BLOCKING("blocking");

  private final String value;

  RunReasonCode(String value) {
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
  public static RunReasonCode fromValue(String value) {
    for (RunReasonCode b : RunReasonCode.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
