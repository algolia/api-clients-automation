/*
 * Search API
 * API powering the Search feature of Algolia.
 *
 * The version of the OpenAPI document: 0.1.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.algolia.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/** SaveObjectResponse */
@JsonPropertyOrder(
  {
    SaveObjectResponse.JSON_PROPERTY_CREATED_AT,
    SaveObjectResponse.JSON_PROPERTY_TASK_I_D,
    SaveObjectResponse.JSON_PROPERTY_OBJECT_I_D,
  }
)
@JsonTypeName("saveObjectResponse")
public class SaveObjectResponse {

  public static final String JSON_PROPERTY_CREATED_AT = "createdAt";
  private String createdAt;

  public static final String JSON_PROPERTY_TASK_I_D = "taskID";
  private Integer taskID;

  public static final String JSON_PROPERTY_OBJECT_I_D = "objectID";
  private String objectID;

  public SaveObjectResponse createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   *
   * @return createdAt
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public SaveObjectResponse taskID(Integer taskID) {
    this.taskID = taskID;
    return this;
  }

  /**
   * taskID of the indexing task to wait for.
   *
   * @return taskID
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "taskID of the indexing task to wait for.")
  @JsonProperty(JSON_PROPERTY_TASK_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getTaskID() {
    return taskID;
  }

  @JsonProperty(JSON_PROPERTY_TASK_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTaskID(Integer taskID) {
    this.taskID = taskID;
  }

  public SaveObjectResponse objectID(String objectID) {
    this.objectID = objectID;
    return this;
  }

  /**
   * Unique identifier of the object.
   *
   * @return objectID
   */
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Unique identifier of the object.")
  @JsonProperty(JSON_PROPERTY_OBJECT_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getObjectID() {
    return objectID;
  }

  @JsonProperty(JSON_PROPERTY_OBJECT_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setObjectID(String objectID) {
    this.objectID = objectID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaveObjectResponse saveObjectResponse = (SaveObjectResponse) o;
    return (
      Objects.equals(this.createdAt, saveObjectResponse.createdAt) &&
      Objects.equals(this.taskID, saveObjectResponse.taskID) &&
      Objects.equals(this.objectID, saveObjectResponse.objectID)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, taskID, objectID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaveObjectResponse {\n");
    sb
      .append("    createdAt: ")
      .append(toIndentedString(createdAt))
      .append("\n");
    sb.append("    taskID: ").append(toIndentedString(taskID)).append("\n");
    sb.append("    objectID: ").append(toIndentedString(objectID)).append("\n");
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
