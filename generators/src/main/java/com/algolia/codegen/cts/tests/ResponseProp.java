package com.algolia.codegen.cts.tests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ResponseProp {

  public int statusCode;

  @JsonDeserialize(using = RawDeserializer.class)
  public String body;

  public String correlationIdSuffix;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseProp {\n");
    sb.append("    statusCode: ").append(statusCode).append("\n");
    sb.append("    body: ").append(body).append("\n");
    sb.append("    correlationIdSuffix: ").append(correlationIdSuffix).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
