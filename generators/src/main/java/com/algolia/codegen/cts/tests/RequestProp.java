package com.algolia.codegen.cts.tests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

public class RequestProp {

  public String path;
  public String method;

  @JsonDeserialize(using = RawDeserializer.class)
  public String body;

  @JsonDeserialize(using = RawDeserializer.class)
  public String queryParameters;

  @JsonDeserialize(using = RawDeserializer.class)
  public String headers;

  // header keys that must NOT reach the wire, e.g. a minted request-id when
  // the caller supplied one through another channel
  public List<String> absentHeaders;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestProp {\n");
    sb.append("    path: ").append(path).append("\n");
    sb.append("    method: ").append(method).append("\n");
    sb.append("    body: ").append(body).append("\n");
    sb.append("    queryParameters: ").append(queryParameters).append("\n");
    sb.append("    headers: ").append(headers).append("\n");
    sb.append("    absentHeaders: ").append(absentHeaders).append("\n");
    sb.append("}");
    return sb.toString();
  }
}
