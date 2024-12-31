package com.algolia.utils

import io.ktor.client.utils.*
import io.ktor.http.content.*
import io.ktor.util.*
import kotlinx.serialization.json.*
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
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
fun assertContainsAll(json: String, builder: StringValuesBuilder) {
  val jsonObject = Json.parseToJsonElement(json) as JsonObject
  jsonObject.entries.onEach { (key, value) ->
    assertTrue("Missing key: $key in $jsonObject") { builder.contains(key) }
    val expected = value.jsonPrimitive.content
    val actual = builder.getAll(key)?.joinToString(",")
    assertEquals(expected, actual)
  }
}

/**
 * Asserts that the JSON content of the query params [queryParams] matches the expected JSON string [json].
 * If the actual and expected JSON objects are not equal, an [AssertionError] is thrown.
 *
 * @param queryParams The actual query params content to be checked for equality with the expected JSON string.
 * @param json The expected JSON string to compare against the actual JSON content in [queryParams].
 */
fun assertQueryParams(json: String, queryParams: StringValuesBuilder) {
  JSONAssert.assertEquals(json, "{${queryParams.build().entries().joinToString { "\"${it.key}\":\"${it.value.joinToString(",")}\"" } }}", JSONCompareMode.STRICT)
}

/**
 * Asserts that the JSON content of the given [body] matches the expected JSON string [json].
 * If the actual and expected JSON objects are not equal, an [AssertionError] is thrown.
 *
 * @param body The actual body content to be checked for equality with the expected JSON string.
 * @param json The expected JSON string to compare against the actual JSON content in [body].
 */
fun assertJsonBody(json: String, body: Any) {
  val bodyJson = body as? TextContent ?: error("json body expected, but not found!")
  JSONAssert.assertEquals(json, bodyJson.text, JSONCompareMode.STRICT)
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

fun assertError(throwable: Throwable, message: String) {
  when (throwable) {
    is SkipException -> println("Test skipped because of non-nullable")
    else -> assertTrue(throwable.message!!.matches(message.toRegex()), "Expected error: $message, but got: ${throwable.message}")
  }
}
