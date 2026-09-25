@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl.cases

import com.algolia.client.dsl.*
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

/**
 * `filters` values and attributes the encoder must quote or escape, run by the live suite on the
 * escaping fixture (one record per value). The unquoted forms the engine rejects are pinned in
 * [EngineProbes].
 */
internal object EscapingCases {

  val parenthesesQuoted = facetCase("Books(Kids)", """v:"Books(Kids)"""", "1")

  val colonQuoted = facetCase("a:b", """v:"a:b"""", "2")

  val lessThanQuoted = facetCase("a<b", """v:"a<b"""", "3")

  val equalsQuoted = facetCase("a=b", """v:"a=b"""", "6")

  val exclamationQuoted = facetCase("a!b", """v:"a!b"""", "7")

  val greaterThanQuoted = facetCase("a>b", """v:"a>b"""", "8")

  val embeddedQuoteEscaped = facetCase("q\"uote", """v:"q\"uote"""", "11")

  val innerBackslashEscaped = facetCase("back\\slash", """v:"back\\slash"""", "5")

  val trailingBackslashEscaped = facetCase("trail\\", """v:"trail\\"""", "9")

  val backslashBeforeSpaceEscaped = facetCase("C:\\ dir\\", """v:"C:\\ dir\\"""", "4")

  val dottedValueBare = facetCase("a.b", "v:a.b", "10")

  val attributeWithColonQuoted =
    LiveCase(
      dsl = { query { filters { facet("my:attr", "z") } } },
      body = filtersBody(""""my:attr":z"""),
      expect = listOf(Expect.Hits(setOf("10"))),
    )

  val tagsQuoted =
    LiveCase(
      dsl = {
        query {
          filters {
            orTag {
              tag("a(b)")
              tag("x:y")
            }
          }
        }
      },
      body = filtersBody("""(_tags:"a(b)" OR _tags:"x:y")"""),
      expect = listOf(Expect.Hits(setOf("1", "2"))),
    )

  val deleteByQuotedValues =
    DeleteCase(
      dsl = {
        deleteBy {
          filters {
            orFacet {
              facet("v", "Books(Kids)")
              facet("v", "trail\\")
            }
          }
        }
      },
      body = filtersBody("""(v:"Books(Kids)" OR v:"trail\\")"""),
      remaining = setOf("2", "3", "4", "5", "6", "7", "8", "10", "11"),
    )

  /** `filters { facet("v", value) }`, its body with [sql], matching only [objectID]. */
  private fun facetCase(value: String, sql: String, objectID: String): LiveCase =
    LiveCase(
      dsl = { query { filters { facet("v", value) } } },
      body = filtersBody(sql),
      expect = listOf(Expect.Hits(setOf(objectID))),
    )

  /** `{"filters": sql}` as JSON text, so [sql] is written once, unescaped for JSON. */
  private fun filtersBody(sql: String): String = buildJsonObject { put("filters", sql) }.toString()
}
