/*
 * Search API
 * API powering the Search feature of Algolia.
 *
 * The version of the OpenAPI document: 0.1.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.algolia.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Operation
 */
@JsonPropertyOrder(
  { Operation.JSON_PROPERTY_ACTION, Operation.JSON_PROPERTY_BODY }
)
@JsonTypeName("operation")
public class Operation {

  /**
   * type of operation.
   */
  public enum ActionEnum {
    ADDOBJECT("addObject"),

    UPDATEOBJECT("updateObject"),

    PARTIALUPDATEOBJECT("partialUpdateObject"),

    PARTIALUPDATEOBJECTNOCREATE("partialUpdateObjectNoCreate"),

    DELETEOBJECT("deleteObject"),

    DELETE("delete"),

    CLEAR("clear");

    private String value;

    ActionEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ActionEnum fromValue(String value) {
      for (ActionEnum b : ActionEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_ACTION = "action";
  private ActionEnum action;

  public static final String JSON_PROPERTY_BODY = "body";
  private Map<String, Object> body = null;

  public Operation action(ActionEnum action) {
    this.action = action;
    return this;
  }

  /**
   * type of operation.
   * @return action
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "type of operation.")
  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ActionEnum getAction() {
    return action;
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAction(ActionEnum action) {
    this.action = action;
  }

  public Operation body(Map<String, Object> body) {
    this.body = body;
    return this;
  }

  public Operation putBodyItem(String key, Object bodyItem) {
    if (this.body == null) {
      this.body = new HashMap<>();
    }
    this.body.put(key, bodyItem);
    return this;
  }

  /**
   * arguments to the operation (depends on the type of the operation).
   * @return body
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "arguments to the operation (depends on the type of the operation)."
  )
  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(
    content = JsonInclude.Include.ALWAYS,
    value = JsonInclude.Include.USE_DEFAULTS
  )
  public Map<String, Object> getBody() {
    return body;
  }

  @JsonProperty(JSON_PROPERTY_BODY)
  @JsonInclude(
    content = JsonInclude.Include.ALWAYS,
    value = JsonInclude.Include.USE_DEFAULTS
  )
  public void setBody(Map<String, Object> body) {
    this.body = body;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Operation operation = (Operation) o;
    return (
      Objects.equals(this.action, operation.action) &&
      Objects.equals(this.body, operation.body)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, body);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Operation {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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
