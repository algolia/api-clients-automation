// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** TransformationTry */
public class TransformationTry {

  @JsonProperty("code")
  private String code;

  @JsonProperty("type")
  private TransformationType type;

  @JsonProperty("input")
  private TransformationInput input;

  @JsonProperty("sampleRecord")
  private Object sampleRecord;

  @JsonProperty("authentications")
  private List<AuthenticationCreate> authentications;

  public TransformationTry setCode(String code) {
    this.code = code;
    return this;
  }

  /**
   * It is deprecated. Use the `input` field with proper `type` instead to specify the
   * transformation code.
   *
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nullable
  public String getCode() {
    return code;
  }

  public TransformationTry setType(TransformationType type) {
    this.type = type;
    return this;
  }

  /** Get type */
  @javax.annotation.Nullable
  public TransformationType getType() {
    return type;
  }

  public TransformationTry setInput(TransformationInput input) {
    this.input = input;
    return this;
  }

  /** Get input */
  @javax.annotation.Nullable
  public TransformationInput getInput() {
    return input;
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

  public TransformationTry setAuthentications(List<AuthenticationCreate> authentications) {
    this.authentications = authentications;
    return this;
  }

  public TransformationTry addAuthentications(AuthenticationCreate authenticationsItem) {
    if (this.authentications == null) {
      this.authentications = new ArrayList<>();
    }
    this.authentications.add(authenticationsItem);
    return this;
  }

  /** Get authentications */
  @javax.annotation.Nullable
  public List<AuthenticationCreate> getAuthentications() {
    return authentications;
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
    return (
      Objects.equals(this.code, transformationTry.code) &&
      Objects.equals(this.type, transformationTry.type) &&
      Objects.equals(this.input, transformationTry.input) &&
      Objects.equals(this.sampleRecord, transformationTry.sampleRecord) &&
      Objects.equals(this.authentications, transformationTry.authentications)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, type, input, sampleRecord, authentications);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransformationTry {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    sampleRecord: ").append(toIndentedString(sampleRecord)).append("\n");
    sb.append("    authentications: ").append(toIndentedString(authentications)).append("\n");
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
