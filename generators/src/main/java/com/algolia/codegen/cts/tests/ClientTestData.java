package com.algolia.codegen.cts.tests;

import java.util.List;
import java.util.Map;

public class ClientTestData {

  public String testName;
  public boolean autoCreateClient = true;
  public List<Step> steps;

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientTestData {\n");
    sb.append("    testName: ").append(testName).append("\n");
    sb.append("    autoCreateClient: ").append(autoCreateClient).append("\n");
    sb.append("    steps: ").append(steps).append("\n");
    sb.append("}");
    return sb.toString();
  }
}

class Step {

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

class Expected {

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
