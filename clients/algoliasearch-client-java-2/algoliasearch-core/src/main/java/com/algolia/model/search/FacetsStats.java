// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import java.util.Objects;

/** FacetsStats */
public class FacetsStats {

  @JsonProperty("min")
  private Double min;

  @JsonProperty("max")
  private Double max;

  @JsonProperty("avg")
  private Double avg;

  @JsonProperty("sum")
  private Double sum;

  public FacetsStats setMin(Double min) {
    this.min = min;
    return this;
  }

  /**
   * The minimum value in the result set.
   *
   * @return min
   */
  @javax.annotation.Nullable
  public Double getMin() {
    return min;
  }

  public FacetsStats setMax(Double max) {
    this.max = max;
    return this;
  }

  /**
   * The maximum value in the result set.
   *
   * @return max
   */
  @javax.annotation.Nullable
  public Double getMax() {
    return max;
  }

  public FacetsStats setAvg(Double avg) {
    this.avg = avg;
    return this;
  }

  /**
   * The average facet value in the result set.
   *
   * @return avg
   */
  @javax.annotation.Nullable
  public Double getAvg() {
    return avg;
  }

  public FacetsStats setSum(Double sum) {
    this.sum = sum;
    return this;
  }

  /**
   * The sum of all values in the result set.
   *
   * @return sum
   */
  @javax.annotation.Nullable
  public Double getSum() {
    return sum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FacetsStats facetsStats = (FacetsStats) o;
    return (
      Objects.equals(this.min, facetsStats.min) &&
      Objects.equals(this.max, facetsStats.max) &&
      Objects.equals(this.avg, facetsStats.avg) &&
      Objects.equals(this.sum, facetsStats.sum)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(min, max, avg, sum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FacetsStats {\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    avg: ").append(toIndentedString(avg)).append("\n");
    sb.append("    sum: ").append(toIndentedString(sum)).append("\n");
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
