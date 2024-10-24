package com.algolia.codegen.cts.tests;

import java.util.Map;

public class Step {

  public String type;
  public String method;
  public int times;
  public Map<String, Object> parameters;
  public Expected expected;

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Step {\n");
    sb.append("    type: ").append(type).append("\n");
    sb.append("    method: ").append(method).append("\n");
    sb.append("    times: ").append(times).append("\n");
    sb.append("    parameters: ").append(parameters).append("\n");
    sb.append("    expected: ").append(expected).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
