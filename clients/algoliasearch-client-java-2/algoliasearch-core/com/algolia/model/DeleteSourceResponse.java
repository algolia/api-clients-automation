package com.algolia.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Objects;

/**
 * DeleteSourceResponse
 */

public class DeleteSourceResponse {

  public static final String SERIALIZED_NAME_DELETED_AT = "deletedAt";

  @SerializedName(SERIALIZED_NAME_DELETED_AT)
  private OffsetDateTime deletedAt;

  public DeleteSourceResponse deletedAt(OffsetDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  /**
   * Date of deletion (ISO-8601 format).
   * @return deletedAt
   **/
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
    DeleteSourceResponse deleteSourceResponse = (DeleteSourceResponse) o;
    return Objects.equals(this.deletedAt, deleteSourceResponse.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deletedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteSourceResponse {\n");
    sb
      .append("    deletedAt: ")
      .append(toIndentedString(deletedAt))
      .append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
