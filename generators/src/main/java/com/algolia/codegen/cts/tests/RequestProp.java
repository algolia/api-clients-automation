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
    return (
      "RequestProp{" +
      "path='" +
      path +
      '\'' +
      ", method='" +
      method +
      '\'' +
      ", body='" +
      body +
      '\'' +
      ", queryParameters='" +
      queryParameters +
      '\'' +
      ", headers='" +
      headers +
      '\'' +
      '}'
    );
  }
}
