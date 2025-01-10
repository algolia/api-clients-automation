package com.algolia.codegen.cts.tests;

import java.util.Map;

public class RequestOptions {

  public Map<String, Object> queryParameters;
  public Map<String, String> headers;
  public Long readTimeout;
  public Long writeTimeout;
  public Long connectTimeout;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestOptions {\n");
    sb.append("    queryParameters: ").append(queryParameters).append("\n");
    sb.append("    headers: ").append(headers).append("\n");
    sb.append("    readTimeout: ").append(readTimeout).append("\n");
    sb.append("    writeTimeout: ").append(writeTimeout).append("\n");
    sb.append("    connectTimeout: ").append(connectTimeout).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
