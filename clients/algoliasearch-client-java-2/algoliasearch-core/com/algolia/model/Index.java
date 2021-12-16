package com.algolia.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Index
 */

public class Index {

  public static final String SERIALIZED_NAME_NAME = "name";

  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_CREATED_AT = "createdAt";

  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private OffsetDateTime createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updatedAt";

  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private OffsetDateTime updatedAt;

  public static final String SERIALIZED_NAME_ENTRIES = "entries";

  @SerializedName(SERIALIZED_NAME_ENTRIES)
  private Integer entries;

  public static final String SERIALIZED_NAME_DATA_SIZE = "dataSize";

  @SerializedName(SERIALIZED_NAME_DATA_SIZE)
  private Integer dataSize;

  public static final String SERIALIZED_NAME_FILE_SIZE = "fileSize";

  @SerializedName(SERIALIZED_NAME_FILE_SIZE)
  private Integer fileSize;

  public static final String SERIALIZED_NAME_LAST_BUILD_TIME_S =
    "lastBuildTimeS";

  @SerializedName(SERIALIZED_NAME_LAST_BUILD_TIME_S)
  private Integer lastBuildTimeS;

  public static final String SERIALIZED_NAME_NUMBER_OF_PENDING_TASK =
    "numberOfPendingTask";

  @SerializedName(SERIALIZED_NAME_NUMBER_OF_PENDING_TASK)
  private Integer numberOfPendingTask;

  public static final String SERIALIZED_NAME_PENDING_TASK = "pendingTask";

  @SerializedName(SERIALIZED_NAME_PENDING_TASK)
  private Boolean pendingTask;

  public static final String SERIALIZED_NAME_PRIMARY = "primary";

  @SerializedName(SERIALIZED_NAME_PRIMARY)
  private String primary;

  public static final String SERIALIZED_NAME_REPLICAS = "replicas";

  @SerializedName(SERIALIZED_NAME_REPLICAS)
  private List<String> replicas = null;

  public Index name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Index name.
   * @return name
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Index name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Index createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Index creation date. An empty string means that the index has no records.
   * @return createdAt
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Index creation date. An empty string means that the index has no records."
  )
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Index updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Date of last update (ISO-8601 format).
   * @return updatedAt
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Date of last update (ISO-8601 format)."
  )
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Index entries(Integer entries) {
    this.entries = entries;
    return this;
  }

  /**
   * Number of records contained in the index.
   * @return entries
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Number of records contained in the index."
  )
  public Integer getEntries() {
    return entries;
  }

  public void setEntries(Integer entries) {
    this.entries = entries;
  }

  public Index dataSize(Integer dataSize) {
    this.dataSize = dataSize;
    return this;
  }

  /**
   * Number of bytes of the index in minified format.
   * @return dataSize
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Number of bytes of the index in minified format."
  )
  public Integer getDataSize() {
    return dataSize;
  }

  public void setDataSize(Integer dataSize) {
    this.dataSize = dataSize;
  }

  public Index fileSize(Integer fileSize) {
    this.fileSize = fileSize;
    return this;
  }

  /**
   * Number of bytes of the index binary file.
   * @return fileSize
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Number of bytes of the index binary file."
  )
  public Integer getFileSize() {
    return fileSize;
  }

  public void setFileSize(Integer fileSize) {
    this.fileSize = fileSize;
  }

  public Index lastBuildTimeS(Integer lastBuildTimeS) {
    this.lastBuildTimeS = lastBuildTimeS;
    return this;
  }

  /**
   * Last build time
   * @return lastBuildTimeS
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Last build time")
  public Integer getLastBuildTimeS() {
    return lastBuildTimeS;
  }

  public void setLastBuildTimeS(Integer lastBuildTimeS) {
    this.lastBuildTimeS = lastBuildTimeS;
  }

  public Index numberOfPendingTask(Integer numberOfPendingTask) {
    this.numberOfPendingTask = numberOfPendingTask;
    return this;
  }

  /**
   * Number of pending indexing operations. This value is deprecated and should not be used.
   * @return numberOfPendingTask
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Number of pending indexing operations. This value is deprecated and should not be used."
  )
  public Integer getNumberOfPendingTask() {
    return numberOfPendingTask;
  }

  public void setNumberOfPendingTask(Integer numberOfPendingTask) {
    this.numberOfPendingTask = numberOfPendingTask;
  }

  public Index pendingTask(Boolean pendingTask) {
    this.pendingTask = pendingTask;
    return this;
  }

  /**
   * A boolean which says whether the index has pending tasks. This value is deprecated and should not be used.
   * @return pendingTask
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "A boolean which says whether the index has pending tasks. This value is deprecated and should not be used."
  )
  public Boolean getPendingTask() {
    return pendingTask;
  }

  public void setPendingTask(Boolean pendingTask) {
    this.pendingTask = pendingTask;
  }

  public Index primary(String primary) {
    this.primary = primary;
    return this;
  }

  /**
   * Only present if the index is a replica. Contains the name of the related primary index.
   * @return primary
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Only present if the index is a replica. Contains the name of the related primary index."
  )
  public String getPrimary() {
    return primary;
  }

  public void setPrimary(String primary) {
    this.primary = primary;
  }

  public Index replicas(List<String> replicas) {
    this.replicas = replicas;
    return this;
  }

  public Index addReplicasItem(String replicasItem) {
    if (this.replicas == null) {
      this.replicas = new ArrayList<>();
    }
    this.replicas.add(replicasItem);
    return this;
  }

  /**
   * Only present if the index is a primary index with replicas. Contains the names of all linked replicas.
   * @return replicas
   **/
  @javax.annotation.Nullable
  @ApiModelProperty(
    value = "Only present if the index is a primary index with replicas. Contains the names of all linked replicas."
  )
  public List<String> getReplicas() {
    return replicas;
  }

  public void setReplicas(List<String> replicas) {
    this.replicas = replicas;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Index index = (Index) o;
    return (
      Objects.equals(this.name, index.name) &&
      Objects.equals(this.createdAt, index.createdAt) &&
      Objects.equals(this.updatedAt, index.updatedAt) &&
      Objects.equals(this.entries, index.entries) &&
      Objects.equals(this.dataSize, index.dataSize) &&
      Objects.equals(this.fileSize, index.fileSize) &&
      Objects.equals(this.lastBuildTimeS, index.lastBuildTimeS) &&
      Objects.equals(this.numberOfPendingTask, index.numberOfPendingTask) &&
      Objects.equals(this.pendingTask, index.pendingTask) &&
      Objects.equals(this.primary, index.primary) &&
      Objects.equals(this.replicas, index.replicas)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      name,
      createdAt,
      updatedAt,
      entries,
      dataSize,
      fileSize,
      lastBuildTimeS,
      numberOfPendingTask,
      pendingTask,
      primary,
      replicas
    );
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Index {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb
      .append("    createdAt: ")
      .append(toIndentedString(createdAt))
      .append("\n");
    sb
      .append("    updatedAt: ")
      .append(toIndentedString(updatedAt))
      .append("\n");
    sb.append("    entries: ").append(toIndentedString(entries)).append("\n");
    sb.append("    dataSize: ").append(toIndentedString(dataSize)).append("\n");
    sb.append("    fileSize: ").append(toIndentedString(fileSize)).append("\n");
    sb
      .append("    lastBuildTimeS: ")
      .append(toIndentedString(lastBuildTimeS))
      .append("\n");
    sb
      .append("    numberOfPendingTask: ")
      .append(toIndentedString(numberOfPendingTask))
      .append("\n");
    sb
      .append("    pendingTask: ")
      .append(toIndentedString(pendingTask))
      .append("\n");
    sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
    sb.append("    replicas: ").append(toIndentedString(replicas)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
