package com.algolia.codegen.cts.tests;

import java.util.List;
import java.util.Map;

public class Request {

  public String testName;

  public Map<String, Object> parameters;
  public RequestOptions requestOptions;
  public RequestProp request;
  public ResponseProp response;
  public List<String> skipLanguages;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    sb.append("    testName: ").append(testName).append("\n");
    sb.append("    parameters: ").append(parameters).append("\n");
    sb.append("    requestOptions: ").append(requestOptions).append("\n");
    sb.append("    request: ").append(request).append("\n");
    sb.append("    response: ").append(response).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
