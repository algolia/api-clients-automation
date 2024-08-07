// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** TaskSearch */
public class TaskSearch {

  @JsonProperty("taskIDs")
  private List<String> taskIDs = new ArrayList<>();

  public TaskSearch setTaskIDs(List<String> taskIDs) {
    this.taskIDs = taskIDs;
    return this;
  }

  public TaskSearch addTaskIDs(String taskIDsItem) {
    this.taskIDs.add(taskIDsItem);
    return this;
  }

  /** Get taskIDs */
  @javax.annotation.Nonnull
  public List<String> getTaskIDs() {
    return taskIDs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskSearch taskSearch = (TaskSearch) o;
    return Objects.equals(this.taskIDs, taskSearch.taskIDs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskIDs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskSearch {\n");
    sb.append("    taskIDs: ").append(toIndentedString(taskIDs)).append("\n");
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
