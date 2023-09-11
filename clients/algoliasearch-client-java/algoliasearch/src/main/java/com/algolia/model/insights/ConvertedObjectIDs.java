// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.insights;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Use this event to track when users convert on items unrelated to a previous Algolia request. For
 * example, if you don't use Algolia to build your category pages, use this event. To track
 * conversion events related to Algolia requests, use the \"Converted object IDs after search\"
 * event.
 */
@JsonDeserialize(as = ConvertedObjectIDs.class)
public class ConvertedObjectIDs implements EventsItems {

  @JsonProperty("eventName")
  private String eventName;

  @JsonProperty("eventType")
  private ConversionEvent eventType;

  @JsonProperty("index")
  private String index;

  @JsonProperty("objectIDs")
  private List<String> objectIDs = new ArrayList<>();

  @JsonProperty("userToken")
  private String userToken;

  @JsonProperty("timestamp")
  private Long timestamp;

  public ConvertedObjectIDs setEventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  /**
   * Can contain up to 64 ASCII characters. Consider naming events consistently—for example, by
   * adopting Segment's
   * [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework)
   * framework.
   */
  @javax.annotation.Nonnull
  public String getEventName() {
    return eventName;
  }

  public ConvertedObjectIDs setEventType(ConversionEvent eventType) {
    this.eventType = eventType;
    return this;
  }

  /** Get eventType */
  @javax.annotation.Nonnull
  public ConversionEvent getEventType() {
    return eventType;
  }

  public ConvertedObjectIDs setIndex(String index) {
    this.index = index;
    return this;
  }

  /** Name of the Algolia index. */
  @javax.annotation.Nonnull
  public String getIndex() {
    return index;
  }

  public ConvertedObjectIDs setObjectIDs(List<String> objectIDs) {
    this.objectIDs = objectIDs;
    return this;
  }

  public ConvertedObjectIDs addObjectIDs(String objectIDsItem) {
    this.objectIDs.add(objectIDsItem);
    return this;
  }

  /** List of object identifiers for items of an Algolia index. */
  @javax.annotation.Nonnull
  public List<String> getObjectIDs() {
    return objectIDs;
  }

  public ConvertedObjectIDs setUserToken(String userToken) {
    this.userToken = userToken;
    return this;
  }

  /**
   * Anonymous or pseudonymous user identifier. > **Note**: Never include personally identifiable
   * information in user tokens.
   */
  @javax.annotation.Nonnull
  public String getUserToken() {
    return userToken;
  }

  public ConvertedObjectIDs setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Time of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time).
   * By default, the Insights API uses the time it receives an event as its timestamp.
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
    ConvertedObjectIDs convertedObjectIDs = (ConvertedObjectIDs) o;
    return (
      Objects.equals(this.eventName, convertedObjectIDs.eventName) &&
      Objects.equals(this.eventType, convertedObjectIDs.eventType) &&
      Objects.equals(this.index, convertedObjectIDs.index) &&
      Objects.equals(this.objectIDs, convertedObjectIDs.objectIDs) &&
      Objects.equals(this.userToken, convertedObjectIDs.userToken) &&
      Objects.equals(this.timestamp, convertedObjectIDs.timestamp)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventName, eventType, index, objectIDs, userToken, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConvertedObjectIDs {\n");
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    objectIDs: ").append(toIndentedString(objectIDs)).append("\n");
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
