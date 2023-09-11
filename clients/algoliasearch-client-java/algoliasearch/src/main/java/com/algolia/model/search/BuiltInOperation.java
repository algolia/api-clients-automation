// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/**
 * To update an attribute without pushing the entire record, you can use these built-in operations.
 */
@JsonDeserialize(as = BuiltInOperation.class)
public class BuiltInOperation implements AttributeToUpdate {

  @JsonProperty("_operation")
  private BuiltInOperationType operation;

  @JsonProperty("value")
  private String value;

  public BuiltInOperation setOperation(BuiltInOperationType operation) {
    this.operation = operation;
    return this;
  }

  /** Get operation */
  @javax.annotation.Nonnull
  public BuiltInOperationType getOperation() {
    return operation;
  }

  public BuiltInOperation setValue(String value) {
    this.value = value;
    return this;
  }

  /**
   * Value that corresponds to the operation, for example an `Increment` or `Decrement` step, `Add`
   * or `Remove` value.
   */
  @javax.annotation.Nonnull
  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuiltInOperation builtInOperation = (BuiltInOperation) o;
    return Objects.equals(this.operation, builtInOperation.operation) && Objects.equals(this.value, builtInOperation.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operation, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuiltInOperation {\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
