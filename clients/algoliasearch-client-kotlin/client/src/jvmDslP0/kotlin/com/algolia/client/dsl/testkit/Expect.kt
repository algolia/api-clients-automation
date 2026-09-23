package com.algolia.client.dsl.testkit

import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject

/** Every objectID of the fixture index. */
internal val ALL: Set<String> = setOf("1", "2", "3", "4", "5")

/**
 * Provenance of a server-contract row.
 * - [Evidence]: observed on the live engine.
 * - [Derived]: computed for the fixture from rules the evidence proves.
 * - [Unproven]: engine behaviour not yet observed.
 */
internal enum class Kind {
  Evidence,
  Derived,
  Unproven,
}

/** One assertion on a live search response. */
internal sealed interface Expect {
  /** Exact objectID set of the hits. */
  data class Hits(val ids: Set<String>) : Expect

  /** The first `ids.size` hits, in order, equal [ids]. */
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

  data class Rejected(val status: Int, val phrase: String) : Expect
}

/** A raw request body with its provenance and live expectations. */
internal class ContractRow(
  val id: String,
  val kind: Kind,
  val params: JsonObject,
  val expect: List<Expect>,
)

/** A delete-by request body with the objectIDs expected to survive it. */
internal class DeleteRow(val id: String, val params: JsonObject, val remaining: Set<String>)
