// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.insights;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Click event after an Algolia request. Use this event to track when users click items in the
 * search results. If you're building your category pages with Algolia, you'll also use this event.
 */
@JsonDeserialize(as = ClickedObjectIDsAfterSearch.class)
public class ClickedObjectIDsAfterSearch implements EventsItems {

  @JsonProperty("eventName")
  private String eventName;

  @JsonProperty("eventType")
  private ClickEvent eventType;

  @JsonProperty("index")
  private String index;

  @JsonProperty("objectIDs")
  private List<String> objectIDs = new ArrayList<>();

  @JsonProperty("positions")
  private List<Integer> positions = new ArrayList<>();

  @JsonProperty("queryID")
  private String queryID;

  @JsonProperty("userToken")
  private String userToken;

  @JsonProperty("authenticatedUserToken")
  private String authenticatedUserToken;

  @JsonProperty("timestamp")
  private Long timestamp;

  public ClickedObjectIDsAfterSearch setEventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  /**
   * Event name, up to 64 ASCII characters. Consider naming events consistently—for example, by
   * adopting Segment's
   * [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework)
   * framework.
   */
  @javax.annotation.Nonnull
  public String getEventName() {
    return eventName;
  }

  public ClickedObjectIDsAfterSearch setEventType(ClickEvent eventType) {
    this.eventType = eventType;
    return this;
  }

  /** Get eventType */
  @javax.annotation.Nonnull
  public ClickEvent getEventType() {
    return eventType;
  }

  public ClickedObjectIDsAfterSearch setIndex(String index) {
    this.index = index;
    return this;
  }

  /** Index name (case-sensitive) to which the event's items belong. */
  @javax.annotation.Nonnull
  public String getIndex() {
    return index;
  }

  public ClickedObjectIDsAfterSearch setObjectIDs(List<String> objectIDs) {
    this.objectIDs = objectIDs;
    return this;
  }

  public ClickedObjectIDsAfterSearch addObjectIDs(String objectIDsItem) {
    this.objectIDs.add(objectIDsItem);
    return this;
  }

  /** Object IDs of the records that are part of the event. */
  @javax.annotation.Nonnull
  public List<String> getObjectIDs() {
    return objectIDs;
  }

  public ClickedObjectIDsAfterSearch setPositions(List<Integer> positions) {
    this.positions = positions;
    return this;
  }

  public ClickedObjectIDsAfterSearch addPositions(Integer positionsItem) {
    this.positions.add(positionsItem);
    return this;
  }

  /**
   * Position of the clicked item the search results. You must provide 1 `position` for each
   * `objectID`.
   */
  @javax.annotation.Nonnull
  public List<Integer> getPositions() {
    return positions;
  }

  public ClickedObjectIDsAfterSearch setQueryID(String queryID) {
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

  public ClickedObjectIDsAfterSearch setUserToken(String userToken) {
    this.userToken = userToken;
    return this;
  }

  /**
   * Anonymous or pseudonymous user identifier. Don't use personally identifiable information in
   * user tokens. For more information, see [User
   * token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
   */
  @javax.annotation.Nonnull
  public String getUserToken() {
    return userToken;
  }

  public ClickedObjectIDsAfterSearch setAuthenticatedUserToken(String authenticatedUserToken) {
    this.authenticatedUserToken = authenticatedUserToken;
    return this;
  }

  /**
   * Identifier for authenticated users. When the user signs in, you can get an identifier from your
   * system and send it as `authenticatedUserToken`. This lets you keep using the `userToken` from
   * before the user signed in, while providing a reliable way to identify users across sessions.
   * Don't use personally identifiable information in user tokens. For more information, see [User
   * token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
   */
  @javax.annotation.Nullable
  public String getAuthenticatedUserToken() {
    return authenticatedUserToken;
  }

  public ClickedObjectIDsAfterSearch setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Timestamp of the event, measured in milliseconds since the Unix epoch. By default, the Insights
   * API uses the time it receives an event as its timestamp.
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
    ClickedObjectIDsAfterSearch clickedObjectIDsAfterSearch = (ClickedObjectIDsAfterSearch) o;
    return (
      Objects.equals(this.eventName, clickedObjectIDsAfterSearch.eventName) &&
      Objects.equals(this.eventType, clickedObjectIDsAfterSearch.eventType) &&
      Objects.equals(this.index, clickedObjectIDsAfterSearch.index) &&
      Objects.equals(this.objectIDs, clickedObjectIDsAfterSearch.objectIDs) &&
      Objects.equals(this.positions, clickedObjectIDsAfterSearch.positions) &&
      Objects.equals(this.queryID, clickedObjectIDsAfterSearch.queryID) &&
      Objects.equals(this.userToken, clickedObjectIDsAfterSearch.userToken) &&
      Objects.equals(this.authenticatedUserToken, clickedObjectIDsAfterSearch.authenticatedUserToken) &&
      Objects.equals(this.timestamp, clickedObjectIDsAfterSearch.timestamp)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventName, eventType, index, objectIDs, positions, queryID, userToken, authenticatedUserToken, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClickedObjectIDsAfterSearch {\n");
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    index: ").append(toIndentedString(index)).append("\n");
    sb.append("    objectIDs: ").append(toIndentedString(objectIDs)).append("\n");
    sb.append("    positions: ").append(toIndentedString(positions)).append("\n");
    sb.append("    queryID: ").append(toIndentedString(queryID)).append("\n");
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
