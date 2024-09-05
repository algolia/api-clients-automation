package com.algolia.codegen.cts.tests;

import java.util.Map;

public class Snippet {

  public String testName;
  public boolean isSnippet;

  public Map<String, Object> parameters;
  public RequestOptions requestOptions;

  public Snippet(String testName, Map<String, Object> parameters) {
    this.testName = testName;
    this.isSnippet = true;
    this.parameters = parameters;
  }

  public Snippet() {}

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    sb.append("    testName: ").append(testName).append("\n");
    sb.append("    isSnippet").append(isSnippet).append("\n");
    sb.append("    parameters: ").append(parameters).append("\n");
    sb.append("    requestOptions: ").append(requestOptions).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
