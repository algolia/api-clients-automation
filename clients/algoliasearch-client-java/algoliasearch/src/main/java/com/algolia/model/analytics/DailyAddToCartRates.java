// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.analytics;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** DailyAddToCartRates */
public class DailyAddToCartRates {

  @JsonProperty("rate")
  private Double rate;

  @JsonProperty("trackedSearchCount")
  private Integer trackedSearchCount;

  @JsonProperty("addToCartCount")
  private Integer addToCartCount;

  @JsonProperty("date")
  private String date;

  public DailyAddToCartRates setRate(Double rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Add-to-cart rate, calculated as number of tracked searches with at least one add-to-cart event
   * divided by the number of tracked searches. If null, Algolia didn't receive any search requests
   * with `clickAnalytics` set to true. minimum: 0 maximum: 1
   */
  @javax.annotation.Nullable
  public Double getRate() {
    return rate;
  }

  public DailyAddToCartRates setTrackedSearchCount(Integer trackedSearchCount) {
    this.trackedSearchCount = trackedSearchCount;
    return this;
  }

  /**
   * Number of tracked searches. Tracked searches are search requests where the `clickAnalytics`
   * parameter is true.
   */
  @javax.annotation.Nonnull
  public Integer getTrackedSearchCount() {
    return trackedSearchCount;
  }

  public DailyAddToCartRates setAddToCartCount(Integer addToCartCount) {
    this.addToCartCount = addToCartCount;
    return this;
  }

  /** Number of add-to-cart events from this search. minimum: 0 */
  @javax.annotation.Nonnull
  public Integer getAddToCartCount() {
    return addToCartCount;
  }

  public DailyAddToCartRates setDate(String date) {
    this.date = date;
    return this;
  }

  /** Date in the format YYYY-MM-DD. */
  @javax.annotation.Nonnull
  public String getDate() {
    return date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DailyAddToCartRates dailyAddToCartRates = (DailyAddToCartRates) o;
    return (
      Objects.equals(this.rate, dailyAddToCartRates.rate) &&
      Objects.equals(this.trackedSearchCount, dailyAddToCartRates.trackedSearchCount) &&
      Objects.equals(this.addToCartCount, dailyAddToCartRates.addToCartCount) &&
      Objects.equals(this.date, dailyAddToCartRates.date)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(rate, trackedSearchCount, addToCartCount, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DailyAddToCartRates {\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    trackedSearchCount: ").append(toIndentedString(trackedSearchCount)).append("\n");
    sb.append("    addToCartCount: ").append(toIndentedString(addToCartCount)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
