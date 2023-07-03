// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.insights;

import com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** ConvertedFilters */
public class ConvertedFilters {

  @JsonProperty("eventName")
  private String eventName;

  @JsonProperty("eventType")
  private ConversionEvent eventType;

  @JsonProperty("index")
  private String index;

  @JsonProperty("filters")
  private List<String> filters = new ArrayList<>();

  @JsonProperty("userToken")
  private String userToken;

  @JsonProperty("timestamp")
  private Long timestamp;

  public ConvertedFilters setEventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  /**
   * Can contain up to 64 ASCII characters. Consider naming events consistently—for example, by
   * adopting Segment's
   * [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework)
   * framework.
   *
   * @return eventName
   */
  @javax.annotation.Nonnull
  public String getEventName() {
    return eventName;
  }

  public ConvertedFilters setEventType(ConversionEvent eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * Get eventType
   *
   * @return eventType
   */
  @javax.annotation.Nonnull
  public ConversionEvent getEventType() {
    return eventType;
  }

  public ConvertedFilters setIndex(String index) {
    this.index = index;
    return this;
  }

  /**
   * Name of the Algolia index.
   *
   * @return index
   */
  @javax.annotation.Nonnull
  public String getIndex() {
    return index;
  }

  public ConvertedFilters setFilters(List<String> filters) {
    this.filters = filters;
    return this;
  }

  public ConvertedFilters addFilters(String filtersItem) {
    this.filters.add(filtersItem);
    return this;
  }

  /**
   * Facet filters. Each facet filter string must be URL-encoded, such as, `discount:10%25`.
   *
   * @return filters
   */
  @javax.annotation.Nonnull
  public List<String> getFilters() {
    return filters;
  }

  public ConvertedFilters setUserToken(String userToken) {
    this.userToken = userToken;
    return this;
  }

  /**
   * Anonymous or pseudonymous user identifier. > **Note**: Never include personally identifiable
   * information in user tokens.
   *
   * @return userToken
   */
  @javax.annotation.Nonnull
  public String getUserToken() {
    return userToken;
  }

  public ConvertedFilters setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Time of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time).
   * By default, the Insights API uses the time it receives an event as its timestamp.
   *
   * @return timestamp
   */
  @javax.annotation.Nullable
  public Long getTimestamp() {
    return timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConvertedFilters convertedFilters = (ConvertedFilters) o;
    return (
      Objects.equals(this.eventName, convertedFilters.eventName) &&
      Objects.equals(this.eventType, convertedFilters.eventType) &&
      Objects.equals(this.index, convertedFilters.index) &&
      Objects.equals(this.filters, convertedFilters.filters) &&
      Objects.equals(this.userToken, convertedFilters.userToken) &&
      Objects.equals(this.timestamp, convertedFilters.timestamp)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventName, eventType, index, filters, userToken, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConvertedFilters {\n");
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    userToken: ").append(toIndentedString(userToken)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
