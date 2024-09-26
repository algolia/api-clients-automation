package com.algolia.codegen.cts.tests;

public class Expected {

  public String type;
  public Object error;
  public Object match;

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Expected {\n");
    sb.append("    type: ").append(type).append("\n");
    sb.append("    error: ").append(error).append("\n");
    sb.append("    match: ").append(match).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
