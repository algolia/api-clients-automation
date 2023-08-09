package com.algolia.codegen.cts.tests;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.Map;

public class Request {

  public String testName;

  public Map<String, Object> parameters;
  public RequestOptions requestOptions;
  public RequestProp request;
  public Map<String, Object> extras;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    sb.append("    testName: ").append(testName).append("\n");
    sb.append("    parameters: ").append(parameters).append("\n");
    sb.append("    requestOptions: ").append(requestOptions).append("\n");
    sb.append("    request: ").append(request).append("\n");
    sb.append("    extras: ").append(extras).append("\n");
    sb.append("}");
    return sb.toString();
  }
}

// Output json to raw string with quotes
class RawDeserializer extends JsonDeserializer<String> {

  @Override
  public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    TreeNode tree = jp.getCodec().readTree(jp);
    return tree.toString();
  }
}
