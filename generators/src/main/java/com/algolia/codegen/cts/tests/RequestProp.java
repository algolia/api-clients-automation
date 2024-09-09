package com.algolia.codegen.cts.tests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class RequestProp {

  public String path;
  public String method;

  @JsonDeserialize(using = RawDeserializer.class)
  public String body;

  @JsonDeserialize(using = RawDeserializer.class)
  public String queryParameters;

  @JsonDeserialize(using = RawDeserializer.class)
  public String headers;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestProp {\n");
    sb.append("    path: ").append(path).append("\n");
    sb.append("    method: ").append(method).append("\n");
    sb.append("    body: ").append(body).append("\n");
    sb.append("    queryParameters: ").append(queryParameters).append("\n");
    sb.append("    headers: ").append(headers).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
