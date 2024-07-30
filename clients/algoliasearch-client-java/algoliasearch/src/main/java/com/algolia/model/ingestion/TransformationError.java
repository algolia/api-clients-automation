// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** The error if the transformation failed. */
public class TransformationError {

  @JsonProperty("code")
  private Integer code;

  @JsonProperty("message")
  private String message;

  public TransformationError setCode(Integer code) {
    this.code = code;
    return this;
  }

  /** The error status code. */
  @javax.annotation.Nullable
  public Integer getCode() {
    return code;
  }

  public TransformationError setMessage(String message) {
    this.message = message;
    return this;
  }

  /** A descriptive message explaining the failure. */
  @javax.annotation.Nullable
  public String getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransformationError transformationError = (TransformationError) o;
    return Objects.equals(this.code, transformationError.code) && Objects.equals(this.message, transformationError.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransformationError {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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