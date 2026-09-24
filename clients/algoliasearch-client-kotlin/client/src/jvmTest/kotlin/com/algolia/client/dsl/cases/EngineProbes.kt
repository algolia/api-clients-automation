package com.algolia.client.dsl.cases

/**
 * Raw bodies the DSL never builds, sent as-is by the live suite to pin the engine behaviour an
 * encoder rule rests on. No DSL half, so [LiveCase.dsl] is `null` and `DslWireTest` skips them.
 */
internal object EngineProbes {

  // ── `filters`: what the SQL grammar rejects (FiltersEncoder) ─────────────────────────────────

  /** `NOT` never precedes a group: the encoder negates leaves only. */
  val notBeforeOrGroupRejected =
    LiveCase(
      dsl = null,
      body = """{"filters":"NOT (color:red OR color:blue)"}""",
      expect = listOf(Expect.Rejected(400, "Unexpected token '('")),
    )

  val notBeforeAndGroupRejected =
    LiveCase(
      dsl = null,
      body = """{"filters":"NOT (color:red AND category:shirt)"}""",
      expect = listOf(Expect.Rejected(400, "Unexpected token '('")),
    )

  /** Groups never nest: the encoder keeps the `AND` flat with one level of `(… OR …)`. */
  val nestedGroupsRejected =
    LiveCase(
      dsl = null,
      body = """{"filters":"((color:red AND category:shirt) AND (count:0 TO 9 OR count = 10))"}""",
      expect = listOf(Expect.Rejected(400, "only (X OR Y) AND Z is allowed")),
    )

  /** One filter family per `OR`: `orFacet` / `orTag` / `orNumeric` are typed for this. */
  val mixedFamiliesInOrRejected =
    LiveCase(
      dsl = null,
      body = """{"filters":"color:red OR _tags:x"}""",
      expect = listOf(Expect.Rejected(400, "Different types are not allowed in the same OR")),
    )

  // ── `optionalFilters`: quotes are not parsed (OptionalFiltersEncoder never emits them) ───────

  /** Every quoted form matches nothing: 5 hits, all scored 0. */
  val quotedAttributeAndValueIgnored =
    LiveCase(
      dsl = null,
      body = """{"optionalFilters":[["\"color\":\"red\""]],"getRankingInfo":true}""",
      expect = listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )

  val quotedValueIgnored =
    LiveCase(
      dsl = null,
      body = """{"optionalFilters":[["color:\"red\""]],"getRankingInfo":true}""",
      expect = listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )

  val quotedAttributeIgnored =
    LiveCase(
      dsl = null,
      body = """{"optionalFilters":[["\"color\":red"]],"getRankingInfo":true}""",
      expect = listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )

  val quotedWithScoreIgnored =
    LiveCase(
      dsl = null,
      body = """{"optionalFilters":[["\"color\":\"red\"<score=3>"]],"getRankingInfo":true}""",
      expect = listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )

  /** The quoted negation is a no-op filter that every record satisfies: all scored 1. */
  val quotedNegationMatchesEveryRecord =
    LiveCase(
      dsl = null,
      body = """{"optionalFilters":[["\"color\":-\"red\""]],"getRankingInfo":true}""",
      expect = listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 1)),
    )

  val quotedLeadingDashIgnored =
    LiveCase(
      dsl = null,
      body = """{"optionalFilters":[["\"color\":\"-red\""]],"getRankingInfo":true}""",
      expect = listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )

  /** `\"` inside quotes never matches, even against a value that contains quotes. */
  val escapedQuotesNeverMatch =
    LiveCase(
      dsl = null,
      body =
        """{"optionalFilters":[["provider:NBC: Universal \\\"East\\\""]],"getRankingInfo":true}""",
      expect = listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )
}
