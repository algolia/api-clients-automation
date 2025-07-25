// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** API request body for creating a transformation. */
public class TransformationCreate {

  @JsonProperty("code")
  private String code;

  @JsonProperty("name")
  private String name;

  @JsonProperty("type")
  private TransformationType type;

  @JsonProperty("input")
  private TransformationInput input;

  @JsonProperty("description")
  private String description;

  @JsonProperty("authenticationIDs")
  private List<String> authenticationIDs;

  public TransformationCreate setCode(String code) {
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

  public TransformationCreate setName(String name) {
    this.name = name;
    return this;
  }

  /** The uniquely identified name of your transformation. */
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public TransformationCreate setType(TransformationType type) {
    this.type = type;
    return this;
  }

  /** Get type */
  @javax.annotation.Nullable
  public TransformationType getType() {
    return type;
  }

  public TransformationCreate setInput(TransformationInput input) {
    this.input = input;
    return this;
  }

  /** Get input */
  @javax.annotation.Nullable
  public TransformationInput getInput() {
    return input;
  }

  public TransformationCreate setDescription(String description) {
    this.description = description;
    return this;
  }

  /** A descriptive name for your transformation of what it does. */
  @javax.annotation.Nullable
  public String getDescription() {
    return description;
  }

  public TransformationCreate setAuthenticationIDs(List<String> authenticationIDs) {
    this.authenticationIDs = authenticationIDs;
    return this;
  }

  public TransformationCreate addAuthenticationIDs(String authenticationIDsItem) {
    if (this.authenticationIDs == null) {
      this.authenticationIDs = new ArrayList<>();
    }
    this.authenticationIDs.add(authenticationIDsItem);
    return this;
  }

  /** The authentications associated with the current transformation. */
  @javax.annotation.Nullable
  public List<String> getAuthenticationIDs() {
    return authenticationIDs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransformationCreate transformationCreate = (TransformationCreate) o;
    return (
      Objects.equals(this.code, transformationCreate.code) &&
      Objects.equals(this.name, transformationCreate.name) &&
      Objects.equals(this.type, transformationCreate.type) &&
      Objects.equals(this.input, transformationCreate.input) &&
      Objects.equals(this.description, transformationCreate.description) &&
      Objects.equals(this.authenticationIDs, transformationCreate.authenticationIDs)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, type, input, description, authenticationIDs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransformationCreate {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    authenticationIDs: ").append(toIndentedString(authenticationIDs)).append("\n");
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
