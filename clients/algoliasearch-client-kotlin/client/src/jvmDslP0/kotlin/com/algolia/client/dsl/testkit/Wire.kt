package com.algolia.client.dsl.testkit

import com.algolia.client.configuration.ClientOptions
import com.algolia.client.model.search.DeleteByParams
import com.algolia.client.model.search.SearchParamsObject
import kotlin.test.assertEquals
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

/**
 * The [Json] instance the client sends requests with. `encodeDefaults` is off, so unset null
 * properties are omitted from the wire body.
 */
internal val wireJson: Json = ClientOptions().json

/** Parses a raw JSON object literal. */
internal fun json(text: String): JsonObject = Json.parseToJsonElement(text).jsonObject

/** The request body the client would send for [params]. */
internal fun wire(params: SearchParamsObject): JsonObject =
  wireJson.encodeToJsonElement(params).jsonObject

/** The request body the client would send for [params]. */
internal fun wire(params: DeleteByParams): JsonObject =
  wireJson.encodeToJsonElement(params).jsonObject

/** Asserts that [actual] serializes to exactly the body of [row]. Key order is not compared. */
internal fun assertWire(row: DeleteRow, actual: DeleteByParams) {
  assertEquals(row.params, wire(actual), row.id)
}

/** Inline-only rows: asserts that [actual] serializes to exactly [expected]. */
internal fun assertWire(expected: String, actual: SearchParamsObject) {
  assertEquals(json(expected), wire(actual))
}
