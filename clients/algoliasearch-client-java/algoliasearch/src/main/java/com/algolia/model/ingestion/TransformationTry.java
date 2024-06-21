// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** TransformationTry */
public class TransformationTry {

  @JsonProperty("code")
  private String code;

  @JsonProperty("sampleRecord")
  private Object sampleRecord;

  public TransformationTry setCode(String code) {
    this.code = code;
    return this;
  }

  /** The source code of the transformation. */
  @javax.annotation.Nonnull
  public String getCode() {
    return code;
  }

  public TransformationTry setSampleRecord(Object sampleRecord) {
    this.sampleRecord = sampleRecord;
    return this;
  }

  /** The record to apply the given code to. */
  @javax.annotation.Nonnull
  public Object getSampleRecord() {
    return sampleRecord;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransformationTry transformationTry = (TransformationTry) o;
    return Objects.equals(this.code, transformationTry.code) && Objects.equals(this.sampleRecord, transformationTry.sampleRecord);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, sampleRecord);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransformationTry {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    sampleRecord: ").append(toIndentedString(sampleRecord)).append("\n");
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
