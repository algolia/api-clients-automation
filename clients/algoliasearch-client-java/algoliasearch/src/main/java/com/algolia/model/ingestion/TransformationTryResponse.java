// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** TransformationTryResponse */
public class TransformationTryResponse {

  @JsonProperty("payloads")
  private List<String> payloads = new ArrayList<>();

  @JsonProperty("error")
  private TransformationError error;

  public TransformationTryResponse setPayloads(List<String> payloads) {
    this.payloads = payloads;
    return this;
  }

  public TransformationTryResponse addPayloads(String payloadsItem) {
    this.payloads.add(payloadsItem);
    return this;
  }

  /** The array of stringified records returned by the transformation service. */
  @javax.annotation.Nonnull
  public List<String> getPayloads() {
    return payloads;
  }

  public TransformationTryResponse setError(TransformationError error) {
    this.error = error;
    return this;
  }

  /** Get error */
  @javax.annotation.Nullable
  public TransformationError getError() {
    return error;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransformationTryResponse transformationTryResponse = (TransformationTryResponse) o;
    return Objects.equals(this.payloads, transformationTryResponse.payloads) && Objects.equals(this.error, transformationTryResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payloads, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransformationTryResponse {\n");
    sb.append("    payloads: ").append(toIndentedString(payloads)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
