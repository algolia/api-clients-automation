// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** API request body for creating a transformation. */
public class TransformationCreate {

  @JsonProperty("code")
  private String code;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  public TransformationCreate setCode(String code) {
    this.code = code;
    return this;
  }

  /** The source code of the transformation. */
  @javax.annotation.Nonnull
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

  public TransformationCreate setDescription(String description) {
    this.description = description;
    return this;
  }

  /** A descriptive name for your transformation of what it does. */
  @javax.annotation.Nullable
  public String getDescription() {
    return description;
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
      Objects.equals(this.description, transformationCreate.description)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransformationCreate {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
