// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.insights;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Use this method to capture active filters. For example, when browsing a category page, users see
 * content filtered on that specific category.
 */
@JsonDeserialize(as = ViewedFilters.class)
public class ViewedFilters implements EventsItems {

  @JsonProperty("eventName")
  private String eventName;

  @JsonProperty("eventType")
  private ViewEvent eventType;

  @JsonProperty("index")
  private String index;

  @JsonProperty("filters")
  private List<String> filters = new ArrayList<>();

  @JsonProperty("userToken")
  private String userToken;

  @JsonProperty("authenticatedUserToken")
  private String authenticatedUserToken;

  @JsonProperty("timestamp")
  private Long timestamp;

  public ViewedFilters setEventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  /**
   * The name of the event, up to 64 ASCII characters. Consider naming events consistently—for
   * example, by adopting Segment's
   * [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework)
   * framework.
   */
  @javax.annotation.Nonnull
  public String getEventName() {
    return eventName;
  }

  public ViewedFilters setEventType(ViewEvent eventType) {
    this.eventType = eventType;
    return this;
  }

  /** Get eventType */
  @javax.annotation.Nonnull
  public ViewEvent getEventType() {
    return eventType;
  }

  public ViewedFilters setIndex(String index) {
    this.index = index;
    return this;
  }

  /** The name of an Algolia index. */
  @javax.annotation.Nonnull
  public String getIndex() {
    return index;
  }

  public ViewedFilters setFilters(List<String> filters) {
    this.filters = filters;
    return this;
  }

  public ViewedFilters addFilters(String filtersItem) {
    this.filters.add(filtersItem);
    return this;
  }

  /** Facet filters. Each facet filter string must be URL-encoded, such as, `discount:10%25`. */
  @javax.annotation.Nonnull
  public List<String> getFilters() {
    return filters;
  }

  public ViewedFilters setUserToken(String userToken) {
    this.userToken = userToken;
    return this;
  }

  /**
   * An anonymous or pseudonymous user identifier. > **Note**: Never include personally identifiable
   * information in user tokens.
   */
  @javax.annotation.Nonnull
  public String getUserToken() {
    return userToken;
  }

  public ViewedFilters setAuthenticatedUserToken(String authenticatedUserToken) {
    this.authenticatedUserToken = authenticatedUserToken;
    return this;
  }

  /**
   * An identifier for authenticated users. > **Note**: Never include personally identifiable
   * information in user tokens.
   */
  @javax.annotation.Nullable
  public String getAuthenticatedUserToken() {
    return authenticatedUserToken;
  }

  public ViewedFilters setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The timestamp of the event in milliseconds in [Unix epoch
   * time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it
   * receives an event as its timestamp.
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
    ViewedFilters viewedFilters = (ViewedFilters) o;
    return (
      Objects.equals(this.eventName, viewedFilters.eventName) &&
      Objects.equals(this.eventType, viewedFilters.eventType) &&
      Objects.equals(this.index, viewedFilters.index) &&
      Objects.equals(this.filters, viewedFilters.filters) &&
      Objects.equals(this.userToken, viewedFilters.userToken) &&
      Objects.equals(this.authenticatedUserToken, viewedFilters.authenticatedUserToken) &&
      Objects.equals(this.timestamp, viewedFilters.timestamp)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventName, eventType, index, filters, userToken, authenticatedUserToken, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ViewedFilters {\n");
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
    sb.append("    userToken: ").append(toIndentedString(userToken)).append("\n");
    sb.append("    authenticatedUserToken: ").append(toIndentedString(authenticatedUserToken)).append("\n");
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
