package com.algolia.codegen.cts.tests;

import java.util.List;

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
