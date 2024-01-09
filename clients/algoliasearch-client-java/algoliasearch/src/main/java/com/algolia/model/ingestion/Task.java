// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** Task */
public class Task {

  @JsonProperty("taskID")
  private String taskID;

  @JsonProperty("sourceID")
  private String sourceID;

  @JsonProperty("destinationID")
  private String destinationID;

  @JsonProperty("trigger")
  private Trigger trigger;

  @JsonProperty("input")
  private TaskInput input;

  @JsonProperty("enabled")
  private Boolean enabled;

  @JsonProperty("failureThreshold")
  private Integer failureThreshold;

  @JsonProperty("action")
  private ActionType action;

  @JsonProperty("createdAt")
  private String createdAt;

  @JsonProperty("updatedAt")
  private String updatedAt;

  public Task setTaskID(String taskID) {
    this.taskID = taskID;
    return this;
  }

  /** The task UUID. */
  @javax.annotation.Nonnull
  public String getTaskID() {
    return taskID;
  }

  public Task setSourceID(String sourceID) {
    this.sourceID = sourceID;
    return this;
  }

  /** The source UUID. */
  @javax.annotation.Nonnull
  public String getSourceID() {
    return sourceID;
  }

  public Task setDestinationID(String destinationID) {
    this.destinationID = destinationID;
    return this;
  }

  /** The destination UUID. */
  @javax.annotation.Nonnull
  public String getDestinationID() {
    return destinationID;
  }

  public Task setTrigger(Trigger trigger) {
    this.trigger = trigger;
    return this;
  }

  /** Get trigger */
  @javax.annotation.Nonnull
  public Trigger getTrigger() {
    return trigger;
  }

  public Task setInput(TaskInput input) {
    this.input = input;
    return this;
  }

  /** Get input */
  @javax.annotation.Nullable
  public TaskInput getInput() {
    return input;
  }

  public Task setEnabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /** Whether the task is enabled or not. */
  @javax.annotation.Nonnull
  public Boolean getEnabled() {
    return enabled;
  }

  public Task setFailureThreshold(Integer failureThreshold) {
    this.failureThreshold = failureThreshold;
    return this;
  }

  /**
   * A percentage representing the accepted failure threshold to determine if a `run` succeeded or
   * not. minimum: 0 maximum: 100
   */
  @javax.annotation.Nullable
  public Integer getFailureThreshold() {
    return failureThreshold;
  }

  public Task setAction(ActionType action) {
    this.action = action;
    return this;
  }

  /** Get action */
  @javax.annotation.Nonnull
  public ActionType getAction() {
    return action;
  }

  public Task setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /** Date of creation (RFC3339 format). */
  @javax.annotation.Nonnull
  public String getCreatedAt() {
    return createdAt;
  }

  public Task setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /** Date of last update (RFC3339 format). */
  @javax.annotation.Nullable
  public String getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return (
      Objects.equals(this.taskID, task.taskID) &&
      Objects.equals(this.sourceID, task.sourceID) &&
      Objects.equals(this.destinationID, task.destinationID) &&
      Objects.equals(this.trigger, task.trigger) &&
      Objects.equals(this.input, task.input) &&
      Objects.equals(this.enabled, task.enabled) &&
      Objects.equals(this.failureThreshold, task.failureThreshold) &&
      Objects.equals(this.action, task.action) &&
      Objects.equals(this.createdAt, task.createdAt) &&
      Objects.equals(this.updatedAt, task.updatedAt)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskID, sourceID, destinationID, trigger, input, enabled, failureThreshold, action, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    sb.append("    taskID: ").append(toIndentedString(taskID)).append("\n");
    sb.append("    sourceID: ").append(toIndentedString(sourceID)).append("\n");
    sb.append("    destinationID: ").append(toIndentedString(destinationID)).append("\n");
    sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    failureThreshold: ").append(toIndentedString(failureThreshold)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
