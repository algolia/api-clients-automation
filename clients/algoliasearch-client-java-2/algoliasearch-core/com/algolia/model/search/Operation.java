package com.algolia.model.search;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

/** Operation */
public class Operation {

  @SerializedName("action")
  private Action action;

  @SerializedName("body")
  private Object body;

  public Operation action(Action action) {
    this.action = action;
    return this;
  }

  /**
   * Get action
   *
   * @return action
   */
  @javax.annotation.Nullable
  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public Operation body(Object body) {
    this.body = body;
    return this;
  }

  /**
   * arguments to the operation (depends on the type of the operation).
   *
   * @return body
   */
  @javax.annotation.Nullable
  public Object getBody() {
    return body;
  }

  public void setBody(Object body) {
    this.body = body;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Operation operation = (Operation) o;
    return (
      Objects.equals(this.action, operation.action) &&
      Objects.equals(this.body, operation.body)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, body);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Operation {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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
