// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.analytics;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** TopSearchWithRevenueAnalytics */
public class TopSearchWithRevenueAnalytics {

  @JsonProperty("search")
  private String search;

  @JsonProperty("count")
  private Integer count;

  @JsonProperty("clickThroughRate")
  private Double clickThroughRate;

  @JsonProperty("averageClickPosition")
  private Double averageClickPosition;

  @JsonProperty("clickPositions")
  private List<ClickPosition> clickPositions = new ArrayList<>();

  @JsonProperty("conversionRate")
  private Double conversionRate;

  @JsonProperty("trackedSearchCount")
  private Integer trackedSearchCount;

  @JsonProperty("clickCount")
  private Integer clickCount;

  @JsonProperty("conversionCount")
  private Integer conversionCount;

  @JsonProperty("nbHits")
  private Integer nbHits;

  @JsonProperty("currencies")
  private Map<String, CurrencyCode> currencies = new HashMap<>();

  @JsonProperty("addToCartRate")
  private Double addToCartRate;

  @JsonProperty("addToCartCount")
  private Integer addToCartCount;

  @JsonProperty("purchaseRate")
  private Double purchaseRate;

  @JsonProperty("purchaseCount")
  private Integer purchaseCount;

  public TopSearchWithRevenueAnalytics setSearch(String search) {
    this.search = search;
    return this;
  }

  /** Search query. */
  @javax.annotation.Nonnull
  public String getSearch() {
    return search;
  }

  public TopSearchWithRevenueAnalytics setCount(Integer count) {
    this.count = count;
    return this;
  }

  /** Number of searches. */
  @javax.annotation.Nonnull
  public Integer getCount() {
    return count;
  }

  public TopSearchWithRevenueAnalytics setClickThroughRate(Double clickThroughRate) {
    this.clickThroughRate = clickThroughRate;
    return this;
  }

  /**
   * Click-through rate: calculated as the number of tracked searches with at least one click event
   * divided by the number of tracked searches. If null, Algolia didn't receive any search requests
   * with `clickAnalytics` set to true. minimum: 0 maximum: 1
   */
  @javax.annotation.Nullable
  public Double getClickThroughRate() {
    return clickThroughRate;
  }

  public TopSearchWithRevenueAnalytics setAverageClickPosition(Double averageClickPosition) {
    this.averageClickPosition = averageClickPosition;
    return this;
  }

  /**
   * Average position of a clicked search result in the list of search results. If null, Algolia
   * didn't receive any search requests with `clickAnalytics` set to true. minimum: 1
   */
  @javax.annotation.Nullable
  public Double getAverageClickPosition() {
    return averageClickPosition;
  }

  public TopSearchWithRevenueAnalytics setClickPositions(List<ClickPosition> clickPositions) {
    this.clickPositions = clickPositions;
    return this;
  }

  public TopSearchWithRevenueAnalytics addClickPositions(ClickPosition clickPositionsItem) {
    this.clickPositions.add(clickPositionsItem);
    return this;
  }

  /** List of positions in the search results and clicks associated with this search. */
  @javax.annotation.Nonnull
  public List<ClickPosition> getClickPositions() {
    return clickPositions;
  }

  public TopSearchWithRevenueAnalytics setConversionRate(Double conversionRate) {
    this.conversionRate = conversionRate;
    return this;
  }

  /**
   * Conversion rate: calculated as the number of tracked searches with at least one conversion
   * event divided by the number of tracked searches. If null, Algolia didn't receive any search
   * requests with `clickAnalytics` set to true. minimum: 0 maximum: 1
   */
  @javax.annotation.Nullable
  public Double getConversionRate() {
    return conversionRate;
  }

  public TopSearchWithRevenueAnalytics setTrackedSearchCount(Integer trackedSearchCount) {
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

  public TopSearchWithRevenueAnalytics setClickCount(Integer clickCount) {
    this.clickCount = clickCount;
    return this;
  }

  /** Number of clicks associated with this search. minimum: 0 */
  @javax.annotation.Nonnull
  public Integer getClickCount() {
    return clickCount;
  }

  public TopSearchWithRevenueAnalytics setConversionCount(Integer conversionCount) {
    this.conversionCount = conversionCount;
    return this;
  }

  /** Number of conversions from this search. minimum: 0 */
  @javax.annotation.Nonnull
  public Integer getConversionCount() {
    return conversionCount;
  }

  public TopSearchWithRevenueAnalytics setNbHits(Integer nbHits) {
    this.nbHits = nbHits;
    return this;
  }

  /** Number of results (hits). */
  @javax.annotation.Nonnull
  public Integer getNbHits() {
    return nbHits;
  }

  public TopSearchWithRevenueAnalytics setCurrencies(Map<String, CurrencyCode> currencies) {
    this.currencies = currencies;
    return this;
  }

  public TopSearchWithRevenueAnalytics putCurrencies(String key, CurrencyCode currenciesItem) {
    this.currencies.put(key, currenciesItem);
    return this;
  }

  /** Revenue associated with this search: broken down by currency. */
  @javax.annotation.Nonnull
  public Map<String, CurrencyCode> getCurrencies() {
    return currencies;
  }

  public TopSearchWithRevenueAnalytics setAddToCartRate(Double addToCartRate) {
    this.addToCartRate = addToCartRate;
    return this;
  }

  /**
   * Add-to-cart rate: calculated as the number of tracked searches with at least one add-to-cart
   * event divided by the number of tracked searches. If null, Algolia didn't receive any search
   * requests with `clickAnalytics` set to true. minimum: 0 maximum: 1
   */
  @javax.annotation.Nullable
  public Double getAddToCartRate() {
    return addToCartRate;
  }

  public TopSearchWithRevenueAnalytics setAddToCartCount(Integer addToCartCount) {
    this.addToCartCount = addToCartCount;
    return this;
  }

  /** Number of add-to-cart events from this search. minimum: 0 */
  @javax.annotation.Nonnull
  public Integer getAddToCartCount() {
    return addToCartCount;
  }

  public TopSearchWithRevenueAnalytics setPurchaseRate(Double purchaseRate) {
    this.purchaseRate = purchaseRate;
    return this;
  }

  /**
   * Purchase rate: calculated as the number of tracked searches with at least one purchase event
   * divided by the number of tracked searches. If null, Algolia didn't receive any search requests
   * with `clickAnalytics` set to true. minimum: 0 maximum: 1
   */
  @javax.annotation.Nullable
  public Double getPurchaseRate() {
    return purchaseRate;
  }

  public TopSearchWithRevenueAnalytics setPurchaseCount(Integer purchaseCount) {
    this.purchaseCount = purchaseCount;
    return this;
  }

  /** Number of purchase events from this search. */
  @javax.annotation.Nonnull
  public Integer getPurchaseCount() {
    return purchaseCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopSearchWithRevenueAnalytics topSearchWithRevenueAnalytics = (TopSearchWithRevenueAnalytics) o;
    return (
      Objects.equals(this.search, topSearchWithRevenueAnalytics.search) &&
      Objects.equals(this.count, topSearchWithRevenueAnalytics.count) &&
      Objects.equals(this.clickThroughRate, topSearchWithRevenueAnalytics.clickThroughRate) &&
      Objects.equals(this.averageClickPosition, topSearchWithRevenueAnalytics.averageClickPosition) &&
      Objects.equals(this.clickPositions, topSearchWithRevenueAnalytics.clickPositions) &&
      Objects.equals(this.conversionRate, topSearchWithRevenueAnalytics.conversionRate) &&
      Objects.equals(this.trackedSearchCount, topSearchWithRevenueAnalytics.trackedSearchCount) &&
      Objects.equals(this.clickCount, topSearchWithRevenueAnalytics.clickCount) &&
      Objects.equals(this.conversionCount, topSearchWithRevenueAnalytics.conversionCount) &&
      Objects.equals(this.nbHits, topSearchWithRevenueAnalytics.nbHits) &&
      Objects.equals(this.currencies, topSearchWithRevenueAnalytics.currencies) &&
      Objects.equals(this.addToCartRate, topSearchWithRevenueAnalytics.addToCartRate) &&
      Objects.equals(this.addToCartCount, topSearchWithRevenueAnalytics.addToCartCount) &&
      Objects.equals(this.purchaseRate, topSearchWithRevenueAnalytics.purchaseRate) &&
      Objects.equals(this.purchaseCount, topSearchWithRevenueAnalytics.purchaseCount)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      search,
      count,
      clickThroughRate,
      averageClickPosition,
      clickPositions,
      conversionRate,
      trackedSearchCount,
      clickCount,
      conversionCount,
      nbHits,
      currencies,
      addToCartRate,
      addToCartCount,
      purchaseRate,
      purchaseCount
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopSearchWithRevenueAnalytics {\n");
    sb.append("    search: ").append(toIndentedString(search)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    clickThroughRate: ").append(toIndentedString(clickThroughRate)).append("\n");
    sb.append("    averageClickPosition: ").append(toIndentedString(averageClickPosition)).append("\n");
    sb.append("    clickPositions: ").append(toIndentedString(clickPositions)).append("\n");
    sb.append("    conversionRate: ").append(toIndentedString(conversionRate)).append("\n");
    sb.append("    trackedSearchCount: ").append(toIndentedString(trackedSearchCount)).append("\n");
    sb.append("    clickCount: ").append(toIndentedString(clickCount)).append("\n");
    sb.append("    conversionCount: ").append(toIndentedString(conversionCount)).append("\n");
    sb.append("    nbHits: ").append(toIndentedString(nbHits)).append("\n");
    sb.append("    currencies: ").append(toIndentedString(currencies)).append("\n");
    sb.append("    addToCartRate: ").append(toIndentedString(addToCartRate)).append("\n");
    sb.append("    addToCartCount: ").append(toIndentedString(addToCartCount)).append("\n");
    sb.append("    purchaseRate: ").append(toIndentedString(purchaseRate)).append("\n");
    sb.append("    purchaseCount: ").append(toIndentedString(purchaseCount)).append("\n");
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
