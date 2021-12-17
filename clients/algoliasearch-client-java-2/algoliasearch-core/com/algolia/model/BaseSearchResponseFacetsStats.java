package com.algolia.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/**
 * BaseSearchResponseFacetsStats
 */

public class BaseSearchResponseFacetsStats {

  public static final String SERIALIZED_NAME_MIN = "min";

  @SerializedName(SERIALIZED_NAME_MIN)
  private Integer min;

  public static final String SERIALIZED_NAME_MAX = "max";

  @SerializedName(SERIALIZED_NAME_MAX)
  private Integer max;

  public static final String SERIALIZED_NAME_AVG = "avg";

  @SerializedName(SERIALIZED_NAME_AVG)
  private Integer avg;

  public static final String SERIALIZED_NAME_SUM = "sum";

  @SerializedName(SERIALIZED_NAME_SUM)
  private Integer sum;

  public BaseSearchResponseFacetsStats min(Integer min) {
    this.min = min;
    return this;
  }

  /**
   * The minimum value in the result set.
   * @return min
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The minimum value in the result set.")
  public Integer getMin() {
    return min;
  }

  public void setMin(Integer min) {
    this.min = min;
  }

  public BaseSearchResponseFacetsStats max(Integer max) {
    this.max = max;
    return this;
  }

  /**
   * The maximum value in the result set.
   * @return max
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The maximum value in the result set.")
  public Integer getMax() {
    return max;
  }

  public void setMax(Integer max) {
    this.max = max;
  }

  public BaseSearchResponseFacetsStats avg(Integer avg) {
    this.avg = avg;
    return this;
  }

  /**
   * The average facet value in the result set.
   * @return avg
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The average facet value in the result set.")
  public Integer getAvg() {
    return avg;
  }

  public void setAvg(Integer avg) {
    this.avg = avg;
  }

  public BaseSearchResponseFacetsStats sum(Integer sum) {
    this.sum = sum;
    return this;
  }

  /**
   * The sum of all values in the result set.
   * @return sum
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The sum of all values in the result set.")
  public Integer getSum() {
    return sum;
  }

  public void setSum(Integer sum) {
    this.sum = sum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseSearchResponseFacetsStats baseSearchResponseFacetsStats = (BaseSearchResponseFacetsStats) o;
    return (
      Objects.equals(this.min, baseSearchResponseFacetsStats.min) &&
      Objects.equals(this.max, baseSearchResponseFacetsStats.max) &&
      Objects.equals(this.avg, baseSearchResponseFacetsStats.avg) &&
      Objects.equals(this.sum, baseSearchResponseFacetsStats.sum)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(min, max, avg, sum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseSearchResponseFacetsStats {\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    avg: ").append(toIndentedString(avg)).append("\n");
    sb.append("    sum: ").append(toIndentedString(sum)).append("\n");
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
