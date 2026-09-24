package com.algolia.client.dsl.testkit

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.jsonArray

/** Parses a raw JSON array literal. */
private fun jsonArray(text: String): JsonArray = Json.parseToJsonElement(text).jsonArray

/**
 * Every server-contract row of the Kotlin DSL test matrix (plan §Server-contract suite). Params
 * bodies are raw strings byte-identical to the plan's JSON column; expectations mirror its Expect
 * column. `†` rows in the plan are recomputed for the 5-record fixture and stay [Kind.Evidence].
 */
internal object ServerContract {
  // ── Evidence rows L01–L22 ─────────────────────────────────────────────────────────────────────

  val L01 =
    ContractRow(
      "L01",
      Kind.Evidence,
      json("""{"filters":"color:red AND category:shirt"}"""),
      listOf(Expect.Hits(setOf("1"))),
    )
  val L02 =
    ContractRow(
      "L02",
      Kind.Evidence,
      json("""{"filters":"(color:red AND category:shirt)"}"""),
      listOf(Expect.Hits(setOf("1"))),
    )
  val L03a =
    ContractRow(
      "L03a",
      Kind.Evidence,
      json("""{"filters":"(NOT color:red OR NOT category:shirt)"}"""),
      listOf(Expect.Hits(setOf("2", "3", "4", "5"))),
    )
  val L03b =
    ContractRow(
      "L03b",
      Kind.Evidence,
      json("""{"filters":"NOT color:red OR NOT category:shirt"}"""),
      listOf(Expect.Hits(setOf("2", "3", "4", "5"))),
    )
  val L04 =
    ContractRow(
      "L04",
      Kind.Evidence,
      json("""{"filters":"(color:red OR NOT category:shirt)"}"""),
      listOf(Expect.Hits(setOf("1", "3", "4"))),
    )
  val L05 =
    ContractRow(
      "L05",
      Kind.Evidence,
      json("""{"filters":"NOT color:red AND NOT color:blue"}"""),
      listOf(Expect.Hits(setOf("4", "5"))),
    )
  val L06a =
    ContractRow(
      "L06a",
      Kind.Evidence,
      json("""{"filters":"NOT (color:red OR color:blue)"}"""),
      listOf(Expect.Rejected(400, "Unexpected token '('")),
    )
  val L06b =
    ContractRow(
      "L06b",
      Kind.Evidence,
      json("""{"filters":"NOT (color:red AND category:shirt)"}"""),
      listOf(Expect.Rejected(400, "Unexpected token '('")),
    )
  val L07a =
    ContractRow(
      "L07a",
      Kind.Evidence,
      json("""{"filters":"((color:red AND category:shirt) AND (count:0 TO 9 OR count = 10))"}"""),
      listOf(Expect.Rejected(400, "only (X OR Y) AND Z is allowed")),
    )
  val L07b =
    ContractRow(
      "L07b",
      Kind.Evidence,
      json("""{"filters":"color:red AND category:shirt AND (count:0 TO 9 OR count = 10)"}"""),
      listOf(Expect.Hits(setOf("1"))),
    )
  val L08 =
    ContractRow(
      "L08",
      Kind.Evidence,
      json("""{"filters":"color:red OR _tags:x"}"""),
      listOf(Expect.Rejected(400, "Different types are not allowed in the same OR")),
    )
  val L09a =
    ContractRow(
      "L09a",
      Kind.Evidence,
      json(
        """{"filters":"(color:red<score=3> OR color:blue<score=1>)","sumOrFiltersScores":true,"getRankingInfo":true}"""
      ),
      listOf(
        Expect.Hits(setOf("1", "2", "3")),
        Expect.Scores(mapOf("1" to 3, "3" to 3, "2" to 1)),
      ),
    )
  val L09b =
    ContractRow(
      "L09b",
      Kind.Evidence,
      json("""{"filters":"(color:red<score=0> OR color:blue<score=2>)","getRankingInfo":true}"""),
      listOf(
        Expect.Hits(setOf("1", "2", "3")),
        Expect.Scores(mapOf("1" to 0, "3" to 0, "2" to 2)),
      ),
    )
  val L10 =
    ContractRow(
      "L10",
      Kind.Evidence,
      json("""{"filters":"color:red<score=3> AND category:shirt","getRankingInfo":true}"""),
      listOf(Expect.Hits(setOf("1")), Expect.Scores(mapOf("1" to 4))),
    )
  val L11a =
    ContractRow(
      "L11a",
      Kind.Evidence,
      json("""{"filters":"color:red AND (category:shirt OR category:pants)"}"""),
      listOf(Expect.Hits(setOf("1", "3"))),
    )
  val L11b =
    ContractRow(
      "L11b",
      Kind.Evidence,
      json("""{"filters":"NOT count:0 TO 9"}"""),
      listOf(Expect.Hits(setOf("1", "2"))),
    )
  val L12a =
    ContractRow(
      "L12a",
      Kind.Evidence,
      json("""{"filters":"label:-Movie"}"""),
      listOf(Expect.Hits(setOf("1"))),
    )
  val L12b =
    ContractRow(
      "L12b",
      Kind.Evidence,
      json("""{"filters":"count:-12"}"""),
      listOf(Expect.Hits(setOf("2"))),
    )
  val L12c =
    ContractRow(
      "L12c",
      Kind.Evidence,
      json("""{"filters":"label:\"-Movie\""}"""),
      listOf(Expect.Hits(setOf("1"))),
    )
  val L12d =
    ContractRow(
      "L12d",
      Kind.Evidence,
      json("""{"filters":"NOT label:\"-Movie\""}"""),
      listOf(Expect.Hits(setOf("2", "3", "4", "5"))),
    )
  val L12e =
    ContractRow(
      "L12e",
      Kind.Evidence,
      json("""{"filters":"_tags:\"-x\""}"""),
      listOf(Expect.Hits(setOf("2"))),
    )
  val L12f =
    ContractRow(
      "L12f",
      Kind.Evidence,
      json("""{"filters":"NOT _tags:\"-x\""}"""),
      listOf(Expect.Hits(setOf("1", "3", "4", "5"))),
    )
  val L18a =
    ContractRow(
      "L18a",
      Kind.Evidence,
      json("""{"optionalFilters":[["\"color\":\"red\""]],"getRankingInfo":true}"""),
      listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )
  val L18b =
    ContractRow(
      "L18b",
      Kind.Evidence,
      json("""{"optionalFilters":[["color:\"red\""]],"getRankingInfo":true}"""),
      listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )
  val L18c =
    ContractRow(
      "L18c",
      Kind.Evidence,
      json("""{"optionalFilters":[["\"color\":red"]],"getRankingInfo":true}"""),
      listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )
  val L18d =
    ContractRow(
      "L18d",
      Kind.Evidence,
      json("""{"optionalFilters":[["\"color\":\"red\"<score=3>"]],"getRankingInfo":true}"""),
      listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )
  val L18e =
    ContractRow(
      "L18e",
      Kind.Evidence,
      json("""{"optionalFilters":[["\"color\":-\"red\""]],"getRankingInfo":true}"""),
      listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 1)),
    )
  val L18f =
    ContractRow(
      "L18f",
      Kind.Evidence,
      json("""{"optionalFilters":[["\"color\":\"-red\""]],"getRankingInfo":true}"""),
      listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )
  val L19a =
    ContractRow(
      "L19a",
      Kind.Evidence,
      json("""{"optionalFilters":[["color:red"]],"getRankingInfo":true}"""),
      listOf(
        Expect.Scores(mapOf("1" to 1, "3" to 1), others = 0),
        Expect.FirstHits(setOf("1", "3")),
      ),
    )
  val L19b =
    ContractRow(
      "L19b",
      Kind.Evidence,
      json("""{"optionalFilters":[["color:red<score=3>"]],"getRankingInfo":true}"""),
      listOf(Expect.Scores(mapOf("1" to 3, "3" to 3), others = 0)),
    )
  val L19c =
    ContractRow(
      "L19c",
      Kind.Evidence,
      json("""{"optionalFilters":[["color:red<score=0>"]],"getRankingInfo":true}"""),
      listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )
  val L19d =
    ContractRow(
      "L19d",
      Kind.Evidence,
      json("""{"optionalFilters":[["color:-red<score=2>"]],"getRankingInfo":true}"""),
      listOf(Expect.Scores(mapOf("2" to 2, "4" to 2, "5" to 2, "1" to 0, "3" to 0))),
    )
  val L19e =
    ContractRow(
      "L19e",
      Kind.Evidence,
      json("""{"optionalFilters":[["label:\\-Movie"]],"getRankingInfo":true}"""),
      listOf(Expect.Scores(mapOf("1" to 1), others = 0)),
    )
  val L20a =
    ContractRow(
      "L20a",
      Kind.Evidence,
      json("""{"optionalFilters":[["color:red"],["category:shirt"]],"getRankingInfo":true}"""),
      listOf(Expect.Scores(mapOf("1" to 2, "2" to 1, "3" to 1, "5" to 1, "4" to 0))),
    )
  val L20b =
    ContractRow(
      "L20b",
      Kind.Evidence,
      json(
        """{"optionalFilters":[["color:red<score=2>","category:shirt<score=1>"]],"getRankingInfo":true}"""
      ),
      listOf(Expect.Scores(mapOf("1" to 2, "3" to 2, "2" to 1, "5" to 1, "4" to 0))),
    )
  val L21a =
    ContractRow(
      "L21a",
      Kind.Evidence,
      json("""{"optionalFilters":[["color:navy blue"]],"getRankingInfo":true}"""),
      listOf(Expect.Scores(mapOf("5" to 1), others = 0)),
    )
  val L21b =
    ContractRow(
      "L21b",
      Kind.Evidence,
      json("""{"optionalFilters":[["provider:NBC: Universal \"East\""]],"getRankingInfo":true}"""),
      listOf(Expect.Scores(mapOf("5" to 1), others = 0)),
    )
  val L21c =
    ContractRow(
      "L21c",
      Kind.Evidence,
      json("""{"optionalFilters":[["color:-navy blue<score=2>"]],"getRankingInfo":true}"""),
      listOf(Expect.Scores(mapOf("1" to 2, "2" to 2, "3" to 2, "4" to 2, "5" to 0))),
    )
  val L21d =
    ContractRow(
      "L21d",
      Kind.Evidence,
      json(
        """{"optionalFilters":[["provider:NBC: Universal \\\"East\\\""]],"getRankingInfo":true}"""
      ),
      listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )
  val L22a =
    ContractRow(
      "L22a",
      Kind.Evidence,
      json("""{"responseFields":["hits","exhaustive","processingTimeMS","processingTimingsMS"]}"""),
      listOf(Expect.Keys(setOf("hits", "exhaustive", "processingTimeMS", "processingTimingsMS"))),
    )
  val L22b =
    ContractRow(
      "L22b",
      Kind.Evidence,
      json("""{"responseFields":["hits","exhaustive","processingTimeMS","serverTimeMS"]}"""),
      listOf(Expect.Keys(setOf("hits", "exhaustive", "processingTimeMS", "serverTimeMS"))),
    )

  // ── Doc-driven rows L23–L53 ───────────────────────────────────────────────────────────────────

  val L23a =
    ContractRow(
      "L23a",
      Kind.Unproven,
      json("""{"filters":"isFeatured:true"}"""),
      listOf(Expect.Hits(setOf("1", "4"))),
    )
  val L23c =
    ContractRow(
      "L23c",
      Kind.Unproven,
      json("""{"filters":"priority:2"}"""),
      listOf(Expect.Hits(setOf("2", "3"))),
    )
  val L24 =
    ContractRow(
      "L24",
      Kind.Unproven,
      json("""{"filters":"NOT batchId:b2<score=0>"}"""),
      listOf(Expect.Hits(setOf("1", "2", "5"))),
    )
  val L25 =
    ContractRow(
      "L25",
      Kind.Unproven,
      json(
        """{"optionalFilters":[["genre:comedy<score=500>","provider:NBC<score=500>"]],"sumOrFiltersScores":true,"getRankingInfo":true}"""
      ),
      listOf(
        Expect.Scores(mapOf("1" to 1000, "3" to 500, "5" to 500, "2" to 0, "4" to 0)),
        Expect.FirstHits(setOf("1")),
      ),
    )
  val L26a =
    ContractRow(
      "L26a",
      Kind.Derived,
      json("""{"filters":"locale:en-US"}"""),
      listOf(Expect.Hits(setOf("1", "4"))),
    )
  val L26b =
    ContractRow(
      "L26b",
      Kind.Derived,
      json("""{"filters":"(locale:en-US OR locale:fr-FR)"}"""),
      listOf(Expect.Hits(setOf("1", "2", "4", "5"))),
    )
  val L26c =
    ContractRow(
      "L26c",
      Kind.Derived,
      json("""{"filters":"(locale:en-US OR locale:fr-FR) AND count:0 TO 10 AND _tags:featured"}"""),
      listOf(Expect.Hits(setOf("1"))),
    )
  val L27 =
    ContractRow(
      "L27",
      Kind.Derived,
      json(
        """{"filters":"(locale:en-US OR locale:fr-FR) AND isPinned:false","optionalFilters":[["isFeatured:true<score=500>"]],"getRankingInfo":true}"""
      ),
      // Mandatory `filters` clauses count in `_rankingInfo.filters` too (L10): matched locale 1 +
      // isPinned 1 + optional 500. Observed live 2026-09-23 (plan table said 500).
      listOf(Expect.Hits(setOf("1", "4")), Expect.Scores(mapOf("1" to 502, "4" to 502))),
    )
  val L28a =
    ContractRow(
      "L28a",
      Kind.Derived,
      json("""{"filters":"entityId:e1","attributesToHighlight":[],"getRankingInfo":false}"""),
      listOf(Expect.Hits(setOf("1"))),
    )
  val L28b =
    ContractRow(
      "L28b",
      Kind.Derived,
      json(
        """{"filters":"entityId:e1 AND locale:en-US","attributesToHighlight":[],"getRankingInfo":false,"hitsPerPage":1}"""
      ),
      listOf(Expect.Hits(setOf("1"))),
    )
  val L28c =
    ContractRow(
      "L28c",
      Kind.Derived,
      json(
        """{"filters":"entityId:e1 AND locale:fr-FR","attributesToHighlight":[],"getRankingInfo":false}"""
      ),
      listOf(Expect.Hits(emptySet())),
    )
  val L29 =
    ContractRow(
      "L29",
      Kind.Unproven,
      json(
        """{"query":"office","filters":"(locale:en-US OR locale:fr-FR) AND isPinned:false","restrictSearchableAttributes":["title","alternateTitles"],"attributesToHighlight":["title"],"optionalFilters":[["isFeatured:true<score=500>"]],"ruleContexts":["desktop"],"hitsPerPage":10}"""
      ),
      listOf(Expect.Hits(setOf("1")), Expect.UserData(jsonArray("""[{"ctx":"desktop"}]"""))),
    )
  val L30 =
    ContractRow(
      "L30",
      Kind.Unproven,
      json(
        """{"query":"office","hitsPerPage":10,"filters":"(locale:en-US OR locale:fr-FR) AND isPinned:false","restrictSearchableAttributes":["title","alternateTitles"],"attributesToHighlight":["title"],"optionalFilters":[["isFeatured:true<score=500>"],["genre:comedy<score=0>"]],"ruleContexts":["desktop","ab-variant-b"]}"""
      ),
      listOf(Expect.Hits(setOf("1")), Expect.UserData(jsonArray("""[{"ctx":"desktop"}]"""))),
    )
  val L31a =
    ContractRow(
      "L31a",
      Kind.Derived,
      json("""{"filters":"locale:en-US","queryLanguages":["en"]}"""),
      listOf(Expect.Hits(setOf("1", "4"))),
    )
  val L31b =
    ContractRow(
      "L31b",
      Kind.Derived,
      json("""{"filters":"(locale:en-US OR locale:fr-FR)","queryLanguages":["en","fr"]}"""),
      listOf(Expect.Hits(setOf("1", "2", "4", "5"))),
    )
  val L32 =
    ContractRow(
      "L32",
      Kind.Derived,
      json(
        """{"query":"office","restrictSearchableAttributes":["title"],"attributesToHighlight":["title"]}"""
      ),
      listOf(Expect.Hits(setOf("1", "3")), Expect.HighlightKeys(setOf("title"))),
    )
  val L33 =
    ContractRow(
      "L33",
      Kind.Derived,
      json(
        """{"optionalFilters":[["isFeatured:true<score=500>"]],"sumOrFiltersScores":true,"getRankingInfo":true}"""
      ),
      listOf(
        Expect.Scores(mapOf("1" to 500, "4" to 500), others = 0),
        Expect.FirstHits(setOf("1", "4")),
      ),
    )
  val L34 =
    ContractRow(
      "L34",
      Kind.Derived,
      json(
        """{"filters":"(locale:en-US OR locale:fr-FR)","queryLanguages":["en","fr"],"restrictSearchableAttributes":["title"],"attributesToHighlight":["title"],"optionalFilters":[["isFeatured:true<score=500>"]],"sumOrFiltersScores":true,"getRankingInfo":true}"""
      ),
      // Mandatory `filters` clauses count in `_rankingInfo.filters` too (L10): matched locale 1 +
      // optional 500 for the featured records, 1 alone for the others. Observed live 2026-09-23
      // (plan table said 500/0).
      listOf(
        Expect.Hits(setOf("1", "2", "4", "5")),
        Expect.Scores(mapOf("1" to 501, "4" to 501, "2" to 1, "5" to 1)),
        Expect.FirstHits(setOf("1", "4")),
        Expect.HighlightKeys(setOf("title")),
      ),
    )
  val L35 =
    ContractRow(
      "L35",
      Kind.Derived,
      json("""{"filters":"genre:comedy AND priority:1 AND isFeatured:true"}"""),
      listOf(Expect.Hits(setOf("1"))),
    )
  val L36a =
    ContractRow(
      "L36a",
      Kind.Derived,
      json("""{"filters":"NOT genre:comedy AND NOT isFeatured:true AND NOT priority:1"}"""),
      listOf(Expect.Hits(setOf("2"))),
    )
  val L36b =
    ContractRow(
      "L36b",
      Kind.Derived,
      json("""{"filters":"NOT genre:comedy"}"""),
      listOf(Expect.Hits(setOf("2", "4"))),
    )
  val L37a =
    ContractRow(
      "L37a",
      Kind.Derived,
      json("""{"filters":"suggestionType:show<score=0>"}"""),
      listOf(Expect.Hits(setOf("1", "3", "5"))),
    )
  val L37b =
    ContractRow(
      "L37b",
      Kind.Derived,
      json("""{"filters":"priority:2<score=0>"}"""),
      listOf(Expect.Hits(setOf("2", "3"))),
    )
  val L37c =
    ContractRow(
      "L37c",
      Kind.Derived,
      json("""{"filters":"isPinned:false<score=0>"}"""),
      listOf(Expect.Hits(setOf("1", "3", "4"))),
    )
  val L37d =
    ContractRow(
      "L37d",
      Kind.Derived,
      json(
        """{"filters":"suggestionType:show<score=0> AND priority:2<score=0> AND isPinned:false<score=0>"}"""
      ),
      listOf(Expect.Hits(setOf("3"))),
    )
  val L38 =
    ContractRow(
      "L38",
      Kind.Derived,
      json("""{"filters":"(entityId:e1 OR entityId:e2 OR entityId:e3) AND NOT batchId:b2"}"""),
      listOf(Expect.Hits(setOf("1", "2"))),
    )
  val L39 =
    ContractRow(
      "L39",
      Kind.Derived,
      json("""{"filters":"(entityId:e1 OR entityId:e2)"}"""),
      listOf(Expect.Hits(setOf("1", "2"))),
    )
  val L40 =
    ContractRow(
      "L40",
      Kind.Unproven,
      json(
        """{"query":"office","hitsPerPage":2,"distinct":1,"getRankingInfo":true,"restrictHighlightAndSnippetArrays":true,"clickAnalytics":true}"""
      ),
      listOf(
        Expect.NbHits(4),
        Expect.HitCount(2),
        Expect.HasKey("queryID"),
        Expect.EveryHitHasKey("_rankingInfo"),
      ),
    )
  val L41a =
    ContractRow(
      "L41a",
      Kind.Derived,
      json(
        """{"query":"office","hitsPerPage":10,"distinct":1,"getRankingInfo":true,"restrictHighlightAndSnippetArrays":true,"clickAnalytics":true,"filters":"locale:en-US","restrictSearchableAttributes":["title","alternateTitles"]}"""
      ),
      listOf(Expect.Hits(setOf("1"))),
    )
  // L41b: control, the searchable-attribute restriction matters.
  val L41b =
    ContractRow(
      "L41b",
      Kind.Derived,
      json("""{"query":"office","filters":"locale:en-US"}"""),
      listOf(Expect.Hits(setOf("1", "4"))),
    )
  val L42 =
    ContractRow(
      "L42",
      Kind.Derived,
      json("""{"filters":"(count:0 TO 9 OR count = 10) AND (_tags:featured OR _tags:x)"}"""),
      listOf(Expect.Hits(setOf("1"))),
    )
  val L44 =
    ContractRow(
      "L44",
      Kind.Derived,
      json(
        """{"optionalFilters":[["genre:comedy<score=2>"],["isFeatured:true<score=3>"],["provider:-NBC<score=1>"]],"getRankingInfo":true}"""
      ),
      listOf(
        Expect.Scores(mapOf("1" to 5, "4" to 4, "3" to 3, "5" to 3, "2" to 1)),
        Expect.FirstHits(setOf("1")),
      ),
    )
  val L45a =
    ContractRow(
      "L45a",
      Kind.Derived,
      json(
        """{"query":"office","restrictSearchableAttributes":["title","tags","alternateTitles"]}"""
      ),
      listOf(Expect.Hits(setOf("1", "2", "3"))),
    )
  val L45b =
    ContractRow(
      "L45b",
      Kind.Derived,
      json("""{"query":"office","restrictSearchableAttributes":["title","tags"]}"""),
      listOf(Expect.Hits(setOf("1", "3"))),
    )
  val L46 =
    ContractRow(
      "L46",
      Kind.Derived,
      json("""{"query":"office","attributesToHighlight":["title"]}"""),
      listOf(Expect.Hits(setOf("1", "2", "3", "4")), Expect.HighlightKeys(setOf("title"))),
    )
  val L47 =
    ContractRow(
      "L47",
      Kind.Derived,
      json("""{"attributesToRetrieve":["objectID","title","locale"]}"""),
      listOf(Expect.HitCount(5), Expect.HitKeys(setOf("objectID", "title", "locale"))),
    )
  val L48a =
    ContractRow(
      "L48a",
      Kind.Unproven,
      json("""{"query":"the office","removeStopWords":true,"queryLanguages":["en"]}"""),
      listOf(Expect.Hits(setOf("1", "2", "3", "4"))),
    )
  val L48b =
    ContractRow(
      "L48b",
      Kind.Unproven,
      json("""{"query":"the office","removeStopWords":true,"queryLanguages":["fr"]}"""),
      listOf(Expect.Hits(setOf("2", "3"))),
    )
  val L49a =
    ContractRow(
      "L49a",
      Kind.Unproven,
      json("""{"ruleContexts":["desktop","ab-variant-b"]}"""),
      listOf(Expect.UserData(jsonArray("""[{"ctx":"desktop"}]"""))),
    )
  // L49b: control, no context so the rule must not fire.
  val L49b = ContractRow("L49b", Kind.Unproven, json("""{}"""), listOf(Expect.Absent("userData")))
  val L50a =
    ContractRow(
      "L50a",
      Kind.Derived,
      json(
        """{"filters":"(genre:comedy<score=0> OR genre:drama<score=3>)","getRankingInfo":true}"""
      ),
      listOf(
        Expect.Hits(setOf("1", "2", "3", "5")),
        Expect.Scores(mapOf("2" to 3, "1" to 0, "3" to 0, "5" to 0)),
      ),
    )
  val L50b =
    ContractRow(
      "L50b",
      Kind.Derived,
      json("""{"optionalFilters":[["genre:comedy<score=0>"]],"getRankingInfo":true}"""),
      listOf(Expect.HitCount(5), Expect.Scores(emptyMap(), others = 0)),
    )
  val L51 =
    ContractRow(
      "L51",
      Kind.Derived,
      json("""{"filters":"(genre:comedy<score=0> OR provider:NBC)","getRankingInfo":true}"""),
      listOf(
        Expect.Hits(setOf("1", "3", "5")),
        Expect.Scores(mapOf("1" to 1, "3" to 0, "5" to 0)),
      ),
    )
  val L52 =
    ContractRow(
      "L52",
      Kind.Derived,
      json(
        """{"optionalFilters":[["genre:comedy<score=0>"],["provider:NBC"]],"getRankingInfo":true}"""
      ),
      listOf(Expect.Scores(mapOf("1" to 1), others = 0)),
    )
  val L53 =
    ContractRow(
      "L53",
      Kind.Unproven,
      json(
        """{"distinct":1,"typoTolerance":"min","ignorePlurals":["en"],"removeStopWords":true,"userToken":"user-1","enablePersonalization":false,"synonyms":true,"enableReRanking":false,"analytics":false}"""
      ),
      listOf(Expect.NbHits(5)),
    )

  // ── Delete rows D1–D2 (deleteByQuery bodies, run on a copy of the fixture) ────────────────────

  val D1 =
    DeleteRow("D1", json("""{"filters":"(entityId:e1 OR entityId:e2)"}"""), setOf("3", "4", "5"))
  // D2: record 3 survives only because of the negated batch.
  val D2 =
    DeleteRow(
      "D2",
      json("""{"filters":"(entityId:e1 OR entityId:e2 OR entityId:e3) AND NOT batchId:b2"}"""),
      setOf("3", "4", "5"),
    )
}
