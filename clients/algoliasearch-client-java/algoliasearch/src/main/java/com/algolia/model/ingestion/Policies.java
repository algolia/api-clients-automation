// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** Set of rules for a task. */
public class Policies {

  @JsonProperty("criticalThreshold")
  private Integer criticalThreshold;

  public Policies setCriticalThreshold(Integer criticalThreshold) {
    this.criticalThreshold = criticalThreshold;
    return this;
  }

  /**
   * The number of critical failures in a row before blocking the task and sending a notification.
   * minimum: 1 maximum: 10
   */
  @javax.annotation.Nullable
  public Integer getCriticalThreshold() {
    return criticalThreshold;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Policies policies = (Policies) o;
    return Objects.equals(this.criticalThreshold, policies.criticalThreshold);
  }

  @Override
  public int hashCode() {
    return Objects.hash(criticalThreshold);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Policies {\n");
    sb.append("    criticalThreshold: ").append(toIndentedString(criticalThreshold)).append("\n");
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
