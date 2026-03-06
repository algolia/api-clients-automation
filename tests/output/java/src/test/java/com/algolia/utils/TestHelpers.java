package com.algolia.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class TestHelpers {

  private static final ObjectMapper mapper = new ObjectMapper();

  /**
   * Asserts that the serialized response contains at least the expected JSON structure. Extra keys
   * in objects and extra elements in arrays (beyond expected indices) are ignored. Mirrors the
   * union-based e2e assertion used by JS, Python, Ruby, PHP, Go, Swift, and C# clients.
   */
  public static void lenientJsonAssert(String expected, String actual) throws Exception {
    JsonNode expectedNode = mapper.readTree(expected);
    JsonNode actualNode = mapper.readTree(actual);
    JsonNode unionNode = union(expectedNode, actualNode);
    String unionJson = mapper.writeValueAsString(unionNode);
    JSONAssert.assertEquals(expected, unionJson, JSONCompareMode.LENIENT);
  }

  /**
   * Recursively intersects the structure of {@code expected} with the values of {@code received}.
   * Only keys/indices present in expected are kept.
   */
  private static JsonNode union(JsonNode expected, JsonNode received) {
    if (expected.isObject() && received.isObject()) {
      ObjectNode result = mapper.createObjectNode();
      expected
        .fieldNames()
        .forEachRemaining(key -> {
          if (received.has(key)) {
            result.set(key, union(expected.get(key), received.get(key)));
          }
        });
      return result;
    }

    if (expected.isArray() && received.isArray()) {
      ArrayNode result = mapper.createArrayNode();
      for (int i = 0; i < expected.size() && i < received.size(); i++) {
        result.add(union(expected.get(i), received.get(i)));
      }
      return result;
    }

    return received.deepCopy();
  }
}
