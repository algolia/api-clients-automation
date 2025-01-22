// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.composition;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** MatchedGeoLocation */
public class MatchedGeoLocation {

  @JsonProperty("lat")
  private Double lat;

  @JsonProperty("lng")
  private Double lng;

  @JsonProperty("distance")
  private Integer distance;

  public MatchedGeoLocation setLat(Double lat) {
    this.lat = lat;
    return this;
  }

  /** Latitude of the matched location. */
  @javax.annotation.Nullable
  public Double getLat() {
    return lat;
  }

  public MatchedGeoLocation setLng(Double lng) {
    this.lng = lng;
    return this;
  }

  /** Longitude of the matched location. */
  @javax.annotation.Nullable
  public Double getLng() {
    return lng;
  }

  public MatchedGeoLocation setDistance(Integer distance) {
    this.distance = distance;
    return this;
  }

  /** Distance between the matched location and the search location (in meters). */
  @javax.annotation.Nullable
  public Integer getDistance() {
    return distance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MatchedGeoLocation matchedGeoLocation = (MatchedGeoLocation) o;
    return (
      Objects.equals(this.lat, matchedGeoLocation.lat) &&
      Objects.equals(this.lng, matchedGeoLocation.lng) &&
      Objects.equals(this.distance, matchedGeoLocation.distance)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(lat, lng, distance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MatchedGeoLocation {\n");
    sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
    sb.append("    lng: ").append(toIndentedString(lng)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
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
