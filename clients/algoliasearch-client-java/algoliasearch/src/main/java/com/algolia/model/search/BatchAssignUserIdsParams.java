// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Assign userID parameters. */
public class BatchAssignUserIdsParams {

  @JsonProperty("cluster")
  private String cluster;

  @JsonProperty("users")
  private List<String> users = new ArrayList<>();

  public BatchAssignUserIdsParams setCluster(String cluster) {
    this.cluster = cluster;
    return this;
  }

  /** Cluster name. */
  @javax.annotation.Nonnull
  public String getCluster() {
    return cluster;
  }

  public BatchAssignUserIdsParams setUsers(List<String> users) {
    this.users = users;
    return this;
  }

  public BatchAssignUserIdsParams addUsers(String usersItem) {
    this.users.add(usersItem);
    return this;
  }

  /** User IDs to assign. */
  @javax.annotation.Nonnull
  public List<String> getUsers() {
    return users;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BatchAssignUserIdsParams batchAssignUserIdsParams = (BatchAssignUserIdsParams) o;
    return Objects.equals(this.cluster, batchAssignUserIdsParams.cluster) && Objects.equals(this.users, batchAssignUserIdsParams.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cluster, users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BatchAssignUserIdsParams {\n");
    sb.append("    cluster: ").append(toIndentedString(cluster)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
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
