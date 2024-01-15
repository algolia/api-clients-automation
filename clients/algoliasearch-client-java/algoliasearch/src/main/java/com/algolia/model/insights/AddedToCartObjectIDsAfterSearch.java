// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.insights;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Use this event to track when users add items to their shopping cart after a previous Algolia
 * request. If you're building your category pages with Algolia, you'll also use this event.
 */
@JsonDeserialize(as = AddedToCartObjectIDsAfterSearch.class)
public class AddedToCartObjectIDsAfterSearch implements EventsItems {

  @JsonProperty("eventName")
  private String eventName;

  @JsonProperty("eventType")
  private ConversionEvent eventType;

  @JsonProperty("eventSubtype")
  private AddToCartEvent eventSubtype;

  @JsonProperty("index")
  private String index;

  @JsonProperty("queryID")
  private String queryID;

  @JsonProperty("objectIDs")
  private List<String> objectIDs = new ArrayList<>();

  @JsonProperty("userToken")
  private String userToken;

  @JsonProperty("authenticatedUserToken")
  private String authenticatedUserToken;

  @JsonProperty("currency")
  private String currency;

  @JsonProperty("objectData")
  private List<ObjectDataAfterSearch> objectData;

  @JsonProperty("timestamp")
  private Long timestamp;

  @JsonProperty("value")
  private Value value;

  public AddedToCartObjectIDsAfterSearch setEventName(String eventName) {
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

  public AddedToCartObjectIDsAfterSearch setEventType(ConversionEvent eventType) {
    this.eventType = eventType;
    return this;
  }

  /** Get eventType */
  @javax.annotation.Nonnull
  public ConversionEvent getEventType() {
    return eventType;
  }

  public AddedToCartObjectIDsAfterSearch setEventSubtype(AddToCartEvent eventSubtype) {
    this.eventSubtype = eventSubtype;
    return this;
  }

  /** Get eventSubtype */
  @javax.annotation.Nonnull
  public AddToCartEvent getEventSubtype() {
    return eventSubtype;
  }

  public AddedToCartObjectIDsAfterSearch setIndex(String index) {
    this.index = index;
    return this;
  }

  /** The name of an Algolia index. */
  @javax.annotation.Nonnull
  public String getIndex() {
    return index;
  }

  public AddedToCartObjectIDsAfterSearch setQueryID(String queryID) {
    this.queryID = queryID;
    return this;
  }

  /**
   * Unique identifier for a search query. The query ID is required for events related to search or
   * browse requests. If you add `clickAnalytics: true` as a search request parameter, the query ID
   * is included in the API response.
   */
  @javax.annotation.Nonnull
  public String getQueryID() {
    return queryID;
  }

  public AddedToCartObjectIDsAfterSearch setObjectIDs(List<String> objectIDs) {
    this.objectIDs = objectIDs;
    return this;
  }

  public AddedToCartObjectIDsAfterSearch addObjectIDs(String objectIDsItem) {
    this.objectIDs.add(objectIDsItem);
    return this;
  }

  /** The object IDs of the records that are part of the event. */
  @javax.annotation.Nonnull
  public List<String> getObjectIDs() {
    return objectIDs;
  }

  public AddedToCartObjectIDsAfterSearch setUserToken(String userToken) {
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

  public AddedToCartObjectIDsAfterSearch setAuthenticatedUserToken(String authenticatedUserToken) {
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

  public AddedToCartObjectIDsAfterSearch setCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  /** Three-letter [currency code](https://www.iso.org/iso-4217-currency-codes.html). */
  @javax.annotation.Nullable
  public String getCurrency() {
    return currency;
  }

  public AddedToCartObjectIDsAfterSearch setObjectData(List<ObjectDataAfterSearch> objectData) {
    this.objectData = objectData;
    return this;
  }

  public AddedToCartObjectIDsAfterSearch addObjectData(ObjectDataAfterSearch objectDataItem) {
    if (this.objectData == null) {
      this.objectData = new ArrayList<>();
    }
    this.objectData.add(objectDataItem);
    return this;
  }

  /**
   * Extra information about the records involved in a purchase or add-to-cart events. If provided,
   * it must be the same length as `objectIDs`.
   */
  @javax.annotation.Nullable
  public List<ObjectDataAfterSearch> getObjectData() {
    return objectData;
  }

  public AddedToCartObjectIDsAfterSearch setTimestamp(Long timestamp) {
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

  public AddedToCartObjectIDsAfterSearch setValue(Value value) {
    this.value = value;
    return this;
  }

  /** Get value */
  @javax.annotation.Nullable
  public Value getValue() {
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
    AddedToCartObjectIDsAfterSearch addedToCartObjectIDsAfterSearch = (AddedToCartObjectIDsAfterSearch) o;
    return (
      Objects.equals(this.eventName, addedToCartObjectIDsAfterSearch.eventName) &&
      Objects.equals(this.eventType, addedToCartObjectIDsAfterSearch.eventType) &&
      Objects.equals(this.eventSubtype, addedToCartObjectIDsAfterSearch.eventSubtype) &&
      Objects.equals(this.index, addedToCartObjectIDsAfterSearch.index) &&
      Objects.equals(this.queryID, addedToCartObjectIDsAfterSearch.queryID) &&
      Objects.equals(this.objectIDs, addedToCartObjectIDsAfterSearch.objectIDs) &&
      Objects.equals(this.userToken, addedToCartObjectIDsAfterSearch.userToken) &&
      Objects.equals(this.authenticatedUserToken, addedToCartObjectIDsAfterSearch.authenticatedUserToken) &&
      Objects.equals(this.currency, addedToCartObjectIDsAfterSearch.currency) &&
      Objects.equals(this.objectData, addedToCartObjectIDsAfterSearch.objectData) &&
      Objects.equals(this.timestamp, addedToCartObjectIDsAfterSearch.timestamp) &&
      Objects.equals(this.value, addedToCartObjectIDsAfterSearch.value)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      eventName,
      eventType,
      eventSubtype,
      index,
      queryID,
      objectIDs,
      userToken,
      authenticatedUserToken,
      currency,
      objectData,
      timestamp,
      value
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddedToCartObjectIDsAfterSearch {\n");
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    eventSubtype: ").append(toIndentedString(eventSubtype)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    queryID: ").append(toIndentedString(queryID)).append("\n");
    sb.append("    objectIDs: ").append(toIndentedString(objectIDs)).append("\n");
    sb.append("    userToken: ").append(toIndentedString(userToken)).append("\n");
    sb.append("    authenticatedUserToken: ").append(toIndentedString(authenticatedUserToken)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    objectData: ").append(toIndentedString(objectData)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
