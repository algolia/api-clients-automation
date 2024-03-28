// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** Trigger for a task update. */
public class TriggerUpdateInput {

  @JsonProperty("cron")
  private String cron;

  public TriggerUpdateInput setCron(String cron) {
    this.cron = cron;
    return this;
  }

  /** Cron expression for the task's schedule. */
  @javax.annotation.Nonnull
  public String getCron() {
    return cron;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TriggerUpdateInput triggerUpdateInput = (TriggerUpdateInput) o;
    return Objects.equals(this.cron, triggerUpdateInput.cron);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cron);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TriggerUpdateInput {\n");
    sb.append("    cron: ").append(toIndentedString(cron)).append("\n");
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
