package com.algolia.model;

import com.algolia.model.UserId;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Array of userIDs and clusters.
 */
@ApiModel(description = "Array of userIDs and clusters.")
public class GetTopUserIdsResponse {

  public static final String SERIALIZED_NAME_TOP_USERS = "topUsers";

  @SerializedName(SERIALIZED_NAME_TOP_USERS)
  private List<Map<String, List<UserId>>> topUsers = new ArrayList<>();

  public GetTopUserIdsResponse topUsers(
    List<Map<String, List<UserId>>> topUsers
  ) {
    this.topUsers = topUsers;
    return this;
  }

  public GetTopUserIdsResponse addTopUsersItem(
    Map<String, List<UserId>> topUsersItem
  ) {
    this.topUsers.add(topUsersItem);
    return this;
  }

  /**
   * Mapping of cluster names to top users.
   * @return topUsers
   **/
  @javax.annotation.Nonnull
  @ApiModelProperty(
    required = true,
    value = "Mapping of cluster names to top users."
  )
  public List<Map<String, List<UserId>>> getTopUsers() {
    return topUsers;
  }

  public void setTopUsers(List<Map<String, List<UserId>>> topUsers) {
    this.topUsers = topUsers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTopUserIdsResponse getTopUserIdsResponse = (GetTopUserIdsResponse) o;
    return Objects.equals(this.topUsers, getTopUserIdsResponse.topUsers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topUsers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTopUserIdsResponse {\n");
    sb.append("    topUsers: ").append(toIndentedString(topUsers)).append("\n");
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
