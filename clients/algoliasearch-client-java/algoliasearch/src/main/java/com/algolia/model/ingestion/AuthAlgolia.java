// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** AuthAlgolia */
@JsonDeserialize(as = AuthAlgolia.class)
public class AuthAlgolia implements AuthInput {

  @JsonProperty("appID")
  private String appID;

  @JsonProperty("apiKey")
  private String apiKey;

  public AuthAlgolia setAppID(String appID) {
    this.appID = appID;
    return this;
  }

  /** Algolia Application ID. */
  @javax.annotation.Nonnull
  public String getAppID() {
    return appID;
  }

  public AuthAlgolia setApiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }

  /** Algolia API Key, with the correct rights to push to an index and change settings. */
  @javax.annotation.Nonnull
  public String getApiKey() {
    return apiKey;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthAlgolia authAlgolia = (AuthAlgolia) o;
    return Objects.equals(this.appID, authAlgolia.appID) && Objects.equals(this.apiKey, authAlgolia.apiKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appID, apiKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthAlgolia {\n");
    sb.append("    appID: ").append(toIndentedString(appID)).append("\n");
    sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
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
