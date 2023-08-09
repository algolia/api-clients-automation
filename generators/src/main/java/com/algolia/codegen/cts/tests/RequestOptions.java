package com.algolia.codegen.cts.tests;

import java.util.Map;

public class RequestOptions {

  public Map<String, Object> queryParameters;
  public Map<String, String> headers;

  @Override
  public String toString() {
    return "RequestOptions{" + "queryParameters=" + queryParameters + ", headers=" + headers + '}';
  }
}
