// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.monitoring;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.util.Objects;

/** Server */
public class Server {

  @JsonProperty("name")
  private String name;

  @JsonProperty("region")
  private Region region;

  @JsonProperty("is_slave")
  private Boolean isSlave;

  @JsonProperty("is_replica")
  private Boolean isReplica;

  @JsonProperty("cluster")
  private String cluster;

  @JsonProperty("status")
  private ServerStatus status;

  @JsonProperty("type")
  private Type type;

  public Server setName(String name) {
    this.name = name;
    return this;
  }

  /** Server name. */
  @javax.annotation.Nullable
  public String getName() {
    return name;
  }

  public Server setRegion(Region region) {
    this.region = region;
    return this;
  }

  /** Get region */
  @javax.annotation.Nullable
  public Region getRegion() {
    return region;
  }

  public Server setIsSlave(Boolean isSlave) {
    this.isSlave = isSlave;
    return this;
  }

  /**
   * Included to support legacy applications. Use `is_replica` instead.
   *
   * @deprecated
   */
  @Deprecated
  @javax.annotation.Nullable
  public Boolean getIsSlave() {
    return isSlave;
  }

  public Server setIsReplica(Boolean isReplica) {
    this.isReplica = isReplica;
    return this;
  }

  /** Whether this server is a replica of another server. */
  @javax.annotation.Nullable
  public Boolean getIsReplica() {
    return isReplica;
  }

  public Server setCluster(String cluster) {
    this.cluster = cluster;
    return this;
  }

  /** Name of the cluster to which this server belongs. */
  @javax.annotation.Nullable
  public String getCluster() {
    return cluster;
  }

  public Server setStatus(ServerStatus status) {
    this.status = status;
    return this;
  }

  /** Get status */
  @javax.annotation.Nullable
  public ServerStatus getStatus() {
    return status;
  }

  public Server setType(Type type) {
    this.type = type;
    return this;
  }

  /** Get type */
  @javax.annotation.Nullable
  public Type getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Server server = (Server) o;
    return (
      Objects.equals(this.name, server.name) &&
      Objects.equals(this.region, server.region) &&
      Objects.equals(this.isSlave, server.isSlave) &&
      Objects.equals(this.isReplica, server.isReplica) &&
      Objects.equals(this.cluster, server.cluster) &&
      Objects.equals(this.status, server.status) &&
      Objects.equals(this.type, server.type)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, region, isSlave, isReplica, cluster, status, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Server {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    isSlave: ").append(toIndentedString(isSlave)).append("\n");
    sb.append("    isReplica: ").append(toIndentedString(isReplica)).append("\n");
    sb.append("    cluster: ").append(toIndentedString(cluster)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
