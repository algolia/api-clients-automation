// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import java.util.Objects;

/** AroundPrecisionFromValueInner */
public class AroundPrecisionFromValueInner {

  @JsonProperty("from")
  private Integer from;

  @JsonProperty("value")
  private Integer value;

  public AroundPrecisionFromValueInner setFrom(Integer from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   *
   * @return from
   */
  @javax.annotation.Nullable
  public Integer getFrom() {
    return from;
  }

  public AroundPrecisionFromValueInner setValue(Integer value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   *
   * @return value
   */
  @javax.annotation.Nullable
  public Integer getValue() {
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
    AroundPrecisionFromValueInner aroundPrecisionFromValueInner = (AroundPrecisionFromValueInner) o;
    return Objects.equals(this.from, aroundPrecisionFromValueInner.from) && Objects.equals(this.value, aroundPrecisionFromValueInner.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(from, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AroundPrecisionFromValueInner {\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
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
