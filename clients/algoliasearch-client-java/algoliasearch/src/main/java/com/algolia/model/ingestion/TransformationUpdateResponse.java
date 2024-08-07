// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** API response for updating a transformation. */
public class TransformationUpdateResponse {

  @JsonProperty("transformationID")
  private String transformationID;

  @JsonProperty("updatedAt")
  private String updatedAt;

  public TransformationUpdateResponse setTransformationID(String transformationID) {
    this.transformationID = transformationID;
    return this;
  }

  /** Universally unique identifier (UUID) of a transformation. */
  @javax.annotation.Nonnull
  public String getTransformationID() {
    return transformationID;
  }

  public TransformationUpdateResponse setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /** Date of last update in RFC 3339 format. */
  @javax.annotation.Nonnull
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
    TransformationUpdateResponse transformationUpdateResponse = (TransformationUpdateResponse) o;
    return (
      Objects.equals(this.transformationID, transformationUpdateResponse.transformationID) &&
      Objects.equals(this.updatedAt, transformationUpdateResponse.updatedAt)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(transformationID, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransformationUpdateResponse {\n");
    sb.append("    transformationID: ").append(toIndentedString(transformationID)).append("\n");
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
