// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.composition;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** RedirectRuleIndexMetadata */
public class RedirectRuleIndexMetadata {

  @JsonProperty("source")
  private String source;

  @JsonProperty("dest")
  private String dest;

  @JsonProperty("reason")
  private String reason;

  @JsonProperty("succeed")
  private Boolean succeed;

  @JsonProperty("data")
  private RedirectRuleIndexData data;

  public RedirectRuleIndexMetadata setSource(String source) {
    this.source = source;
    return this;
  }

  /** Source index for the redirect rule. */
  @javax.annotation.Nonnull
  public String getSource() {
    return source;
  }

  public RedirectRuleIndexMetadata setDest(String dest) {
    this.dest = dest;
    return this;
  }

  /** Destination index for the redirect rule. */
  @javax.annotation.Nonnull
  public String getDest() {
    return dest;
  }

  public RedirectRuleIndexMetadata setReason(String reason) {
    this.reason = reason;
    return this;
  }

  /** Reason for the redirect rule. */
  @javax.annotation.Nonnull
  public String getReason() {
    return reason;
  }

  public RedirectRuleIndexMetadata setSucceed(Boolean succeed) {
    this.succeed = succeed;
    return this;
  }

  /** Redirect rule status. */
  @javax.annotation.Nonnull
  public Boolean getSucceed() {
    return succeed;
  }

  public RedirectRuleIndexMetadata setData(RedirectRuleIndexData data) {
    this.data = data;
    return this;
  }

  /** Get data */
  @javax.annotation.Nonnull
  public RedirectRuleIndexData getData() {
    return data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RedirectRuleIndexMetadata redirectRuleIndexMetadata = (RedirectRuleIndexMetadata) o;
    return (
      Objects.equals(this.source, redirectRuleIndexMetadata.source) &&
      Objects.equals(this.dest, redirectRuleIndexMetadata.dest) &&
      Objects.equals(this.reason, redirectRuleIndexMetadata.reason) &&
      Objects.equals(this.succeed, redirectRuleIndexMetadata.succeed) &&
      Objects.equals(this.data, redirectRuleIndexMetadata.data)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(source, dest, reason, succeed, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RedirectRuleIndexMetadata {\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    dest: ").append(toIndentedString(dest)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    succeed: ").append(toIndentedString(succeed)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
