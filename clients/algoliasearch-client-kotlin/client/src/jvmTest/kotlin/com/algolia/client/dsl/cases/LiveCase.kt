package com.algolia.client.dsl.cases

import com.algolia.client.configuration.ClientOptions
import com.algolia.client.model.search.DeleteByParams
import com.algolia.client.model.search.SearchParamsObject
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

/**
 * One search case: the DSL sample, the raw request body it must serialize to, and what the engine
 * returns for that body on the fixture index. The `val` holding a case is its name.
 */
internal class LiveCase(
  val dsl: () -> SearchParamsObject,
  val body: String,
  val expect: List<Expect>,
)

/** One delete-by case: the DSL sample, its request body, and the objectIDs that survive it. */
internal class DeleteCase(
  val dsl: () -> DeleteByParams,
  val body: String,
  val remaining: Set<String>,
)

/** One assertion on a live search response. */
internal sealed interface Expect {
  /** Exact objectID set of the hits. */
  data class Hits(val ids: Set<String>) : Expect

  /** The first `ids.size` hits, in any order, are exactly [ids]. */
  data class FirstHits(val ids: Set<String>) : Expect

  /** `_rankingInfo.filters` per objectID; [others] applies to every hit not in [byId]. */
  data class Scores(val byId: Map<String, Int>, val others: Int? = null) : Expect

  data class NbHits(val n: Int) : Expect

  data class HitCount(val n: Int) : Expect

  /** Top-level response keys, exact. */
  data class Keys(val keys: Set<String>) : Expect

  data class HasKey(val key: String) : Expect

  data class Absent(val key: String) : Expect

  data class EveryHitHasKey(val key: String) : Expect

  /** Every hit's `_highlightResult` keys. */
  data class HighlightKeys(val keys: Set<String>) : Expect

  /** Every hit's keys not starting with `_`. */
  data class HitKeys(val keys: Set<String>) : Expect

  data class UserData(val value: JsonArray) : Expect
}

/**
 * The [Json] instance the client sends requests with. `encodeDefaults` is off, so unset null
 * properties are omitted from the wire body.
 */
internal val wireJson: Json = ClientOptions().json

/** Parses a raw JSON object literal. */
internal fun json(text: String): JsonObject = Json.parseToJsonElement(text).jsonObject

/** Parses a raw JSON array literal. */
internal fun jsonArray(text: String): JsonArray = Json.parseToJsonElement(text).jsonArray

/** The request body the client would send for [params]. */
internal fun wire(params: SearchParamsObject): JsonObject =
  wireJson.encodeToJsonElement(params).jsonObject

/** The request body the client would send for [params]. */
internal fun wire(params: DeleteByParams): JsonObject =
  wireJson.encodeToJsonElement(params).jsonObject
