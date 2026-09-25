@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.configuration.ClientOptions
import com.algolia.client.dsl.generated.DSLConsequenceParams
import com.algolia.client.dsl.rule.consequence
import com.algolia.client.dsl.rule.params
import com.algolia.client.dsl.rule.rule
import com.algolia.client.model.search.ConsequenceParams
import com.algolia.client.model.search.SupportedLanguage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlinx.serialization.json.encodeToJsonElement

/**
 * The list scopes: eleven `List<String>` / `List<SupportedLanguage>` search parameters exposed as
 * `field { +value }` blocks on [DSLQuery], [DSLBrowse], and [DSLConsequenceParams].
 *
 * Contract under test: last write wins, `+Iterable` appends every element, and an empty block sends
 * `[]`, like version 2 and the settings helpers (`searchableAttributes { }` etc.). Leaving the
 * field unset omits it.
 */
internal class ListScopesDslTest {

  private val json = ClientOptions().json

  @Test
  fun emptyBlockSendsEmptyList() {
    assertEquals(emptyList(), query { attributesToRetrieve {} }.attributesToRetrieve)
    assertEquals(
      json.parseToJsonElement("""{"attributesToRetrieve":[]}"""),
      json.encodeToJsonElement(query { attributesToRetrieve {} }),
    )

    // A later empty block replaces an earlier non-empty one.
    val cleared = query {
      attributesToRetrieve { +"a" }
      attributesToRetrieve {}
    }
    assertEquals(emptyList(), cleared.attributesToRetrieve)

    // Same rule on the other receivers and element types.
    assertEquals(emptyList(), browse { queryLanguages {} }.queryLanguages)
    assertEquals(emptyList(), consequenceParams { responseFields {} }.responseFields)

    // An unset field is omitted.
    assertNull(query { query = "x" }.attributesToRetrieve)

    assertEquals(emptyList(), settings { searchableAttributes {} }.searchableAttributes)
  }

  @Test
  fun lastWriteWins() {
    val twoBlocks = query {
      ruleContexts { +"a" }
      ruleContexts { +"b" }
    }
    assertEquals(listOf("b"), twoBlocks.ruleContexts)

    val blockAfterAssignment = query {
      ruleContexts = listOf("a")
      ruleContexts { +"b" }
    }
    assertEquals(listOf("b"), blockAfterAssignment.ruleContexts)

    val assignmentAfterBlock = query {
      ruleContexts { +"a" }
      ruleContexts = listOf("b")
    }
    assertEquals(listOf("b"), assignmentAfterBlock.ruleContexts)
  }

  @Test
  fun plusIterable() {
    assertEquals(listOf("a", "b"), query { facets { +listOf("a", "b") } }.facets)
    assertEquals(
      listOf(SupportedLanguage.En, SupportedLanguage.Fr),
      query { queryLanguages { +listOf(SupportedLanguage.En, SupportedLanguage.Fr) } }
        .queryLanguages,
    )
    assertEquals(
      listOf("hits", "nbHits"),
      query { responseFields { +listOf("hits", "nbHits") } }.responseFields,
    )

    // Single and iterable adds interleave in source order.
    val mixed = query {
      analyticsTags {
        +"a"
        +listOf("b", "c")
        +"d"
      }
    }
    assertEquals(listOf("a", "b", "c", "d"), mixed.analyticsTags)
  }

  /** Builds [ConsequenceParams] the way callers reach it: `rule { consequence { params { } } }`. */
  private fun consequenceParams(block: DSLConsequenceParams.() -> Unit): ConsequenceParams =
    assertNotNull(rule("r") { consequence { params(block) } }.consequence.params)
}
