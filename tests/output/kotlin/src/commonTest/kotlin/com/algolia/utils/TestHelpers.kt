package com.algolia.utils

import kotlinx.serialization.json.*
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode

/**
 * Asserts that the serialized response contains at least the expected JSON structure. Extra keys in
 * objects and extra elements in arrays (beyond expected indices) are ignored. Mirrors the
 * union-based e2e assertion used by JS, Python, Ruby, PHP, Go, Swift, and C# clients.
 */
public fun lenientJsonAssert(expected: String, actual: String) {
  val expectedNode = Json.parseToJsonElement(expected)
  val actualNode = Json.parseToJsonElement(actual)
  val unionNode = union(expectedNode, actualNode)
  val unionJson = Json.encodeToString(JsonElement.serializer(), unionNode)
  JSONAssert.assertEquals(expected, unionJson, JSONCompareMode.LENIENT)
}

/**
 * Recursively intersects the structure of [expected] with the values of [received]. Only
 * keys/indices present in expected are kept.
 */
private fun union(expected: JsonElement, received: JsonElement): JsonElement {
  if (expected is JsonObject && received is JsonObject) {
    return buildJsonObject {
      for ((key, value) in expected) {
        if (key in received) {
          put(key, union(value, received[key]!!))
        }
      }
    }
  }

  if (expected is JsonArray && received is JsonArray) {
    return buildJsonArray {
      for (i in expected.indices) {
        if (i < received.size) {
          add(union(expected[i], received[i]))
        }
      }
    }
  }

  return received
}
