// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** Response from the API when the Authentication is successfully created. */
public class AuthenticationCreateResponse {

  @JsonProperty("authenticationID")
  private String authenticationID;

  @JsonProperty("name")
  private String name;

  @JsonProperty("createdAt")
  private String createdAt;

  public AuthenticationCreateResponse setAuthenticationID(String authenticationID) {
    this.authenticationID = authenticationID;
    return this;
  }

  /** The authentication UUID. */
  @javax.annotation.Nonnull
  public String getAuthenticationID() {
    return authenticationID;
  }

  public AuthenticationCreateResponse setName(String name) {
    this.name = name;
    return this;
  }

  /** An human readable name describing the object. */
  @javax.annotation.Nonnull
  public String getName() {
    return name;
  }

  public AuthenticationCreateResponse setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /** Date of creation (RFC3339 format). */
  @javax.annotation.Nonnull
  public String getCreatedAt() {
    return createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationCreateResponse authenticationCreateResponse = (AuthenticationCreateResponse) o;
    return (
      Objects.equals(this.authenticationID, authenticationCreateResponse.authenticationID) &&
      Objects.equals(this.name, authenticationCreateResponse.name) &&
      Objects.equals(this.createdAt, authenticationCreateResponse.createdAt)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(authenticationID, name, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationCreateResponse {\n");
    sb.append("    authenticationID: ").append(toIndentedString(authenticationID)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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
