package com.algolia.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.Objects;

/** The response with a taskID and a deletedAt timestamp. */
@ApiModel(description = "The response with a taskID and a deletedAt timestamp.")
public class DeletedAtResponse {

  public static final String SERIALIZED_NAME_TASK_ID = "taskId";

  @SerializedName(SERIALIZED_NAME_TASK_ID)
  private Integer taskId;

  public static final String SERIALIZED_NAME_DELETED_AT = "deletedAt";

  @SerializedName(SERIALIZED_NAME_DELETED_AT)
  private OffsetDateTime deletedAt;

  public DeletedAtResponse taskId(Integer taskId) {
    this.taskId = taskId;
    return this;
  }

  /**
   * taskID of the indexing task to wait for.
   *
   * @return taskId
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "taskID of the indexing task to wait for."
  )
  public Integer getTaskId() {
    return taskId;
  }

  public void setTaskId(Integer taskId) {
    this.taskId = taskId;
  }

  public DeletedAtResponse deletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  /**
   * Date of deletion (ISO-8601 format).
   *
   * @return deletedAt
   */
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Date of deletion (ISO-8601 format)."
  )
  public OffsetDateTime getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeletedAtResponse deletedAtResponse = (DeletedAtResponse) o;
    return (
      Objects.equals(this.taskId, deletedAtResponse.taskId) &&
      Objects.equals(this.deletedAt, deletedAtResponse.deletedAt)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskId, deletedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeletedAtResponse {\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb
      .append("    deletedAt: ")
      .append(toIndentedString(deletedAt))
      .append("\n");
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
