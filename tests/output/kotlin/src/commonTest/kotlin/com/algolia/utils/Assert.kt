package com.algolia.utils

import io.ktor.client.utils.*
import io.ktor.http.content.*
import io.ktor.util.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertTrue

/**
 * Asserts that the given [StringValuesBuilder] contains all the key-value pairs specified in the provided JSON string.
 *
 * This function checks each key-value pair in the JSON string and asserts that the [StringValuesBuilder] contains
 * the same key-value pairs. If any key-value pair is missing, it will throw an [AssertionError] with a
 * descriptive message.
 *
 * @param builder The [StringValuesBuilder] instance to be checked for key-value pairs.
 * @param json A JSON string representing a map of key-value pairs.
 */
fun assertContainsAll(builder: StringValuesBuilder, json: String) {
  val jsonObject = Json.parseToJsonElement(json) as JsonObject
  jsonObject.entries.onEach { (key, value) ->
    assertTrue("Missing key: $key in $jsonObject") { builder.contains(key) }
    val expected = value.jsonPrimitive.content
    val actual = builder.getAll(key)?.joinToString(",")
    assertEquals(expected, actual)
  }
}

/**
 * Asserts that the JSON content of the given [body] matches the expected JSON string [json].
 * If the actual and expected JSON objects are not equal, an [AssertionError] is thrown.
 *
 * @param body The actual body content to be checked for equality with the expected JSON string.
 * @param json The expected JSON string to compare against the actual JSON content in [body].
 */
fun assertJsonBody(body: Any, json: String) {
  val bodyJson = body as? TextContent ?: error("json body expected, but not found!")
  val actual = Json.decodeFromString<JsonElement>(bodyJson.text)
  val expected = Json.decodeFromString<JsonElement>(json)
  assertEquals(actual, expected)
}

fun assertNoBody(body: Any) {
  assertIs<EmptyContent>(body)
}

fun assertEmptyBody(body: Any) {
  val bodyJson = body as? TextContent ?: error("json body expected, but not found!")
  val actual = Json.decodeFromString<JsonElement>(bodyJson.text)
  val expected = JsonObject(emptyMap())
  assertEquals(actual, expected)
}
