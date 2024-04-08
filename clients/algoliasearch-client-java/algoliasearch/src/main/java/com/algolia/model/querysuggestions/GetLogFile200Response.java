// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.querysuggestions;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** GetLogFile200Response */
public class GetLogFile200Response {

  @JsonProperty("timestamp")
  private String timestamp;

  @JsonProperty("level")
  private LogLevel level;

  @JsonProperty("message")
  private String message;

  @JsonProperty("contextLevel")
  private Integer contextLevel;

  public GetLogFile200Response setTimestamp(String timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /** Date and time of the log entry, in RFC 3339 format. */
  @javax.annotation.Nullable
  public String getTimestamp() {
    return timestamp;
  }

  public GetLogFile200Response setLevel(LogLevel level) {
    this.level = level;
    return this;
  }

  /** Get level */
  @javax.annotation.Nullable
  public LogLevel getLevel() {
    return level;
  }

  public GetLogFile200Response setMessage(String message) {
    this.message = message;
    return this;
  }

  /** Details about this log entry. */
  @javax.annotation.Nullable
  public String getMessage() {
    return message;
  }

  public GetLogFile200Response setContextLevel(Integer contextLevel) {
    this.contextLevel = contextLevel;
    return this;
  }

  /**
   * Level indicating the position of a suggestion in a hierarchy of records. For example, a
   * `contextLevel` of 1 indicates that this suggestion belongs to a previous suggestion with
   * `contextLevel` 0.
   */
  @javax.annotation.Nullable
  public Integer getContextLevel() {
    return contextLevel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetLogFile200Response getLogFile200Response = (GetLogFile200Response) o;
    return (
      Objects.equals(this.timestamp, getLogFile200Response.timestamp) &&
      Objects.equals(this.level, getLogFile200Response.level) &&
      Objects.equals(this.message, getLogFile200Response.message) &&
      Objects.equals(this.contextLevel, getLogFile200Response.contextLevel)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, level, message, contextLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetLogFile200Response {\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    contextLevel: ").append(toIndentedString(contextLevel)).append("\n");
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
