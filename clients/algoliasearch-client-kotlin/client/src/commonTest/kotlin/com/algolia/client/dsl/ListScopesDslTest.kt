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
 * Contract under test: last write wins, `+Iterable` appends every element, and an empty block sets
 * `null` (field omitted). The settings helpers (`searchableAttributes { }` etc.) keep sending `[]`
 * for an empty block; that contrast is pinned here so a change on either side shows up.
 */
internal class ListScopesDslTest {

  private val json = ClientOptions().json

  @Test
  fun emptyBlockOmitsField() {
    assertNull(query { attributesToRetrieve {} }.attributesToRetrieve)
    assertEquals(
      json.parseToJsonElement("{}"),
      json.encodeToJsonElement(query { attributesToRetrieve {} }),
    )

    // A later empty block clears an earlier non-empty one.
    val cleared = query {
      attributesToRetrieve { +"a" }
      attributesToRetrieve {}
    }
    assertNull(cleared.attributesToRetrieve)

    // Same rule on the other receivers and element types.
    assertNull(browse { queryLanguages {} }.queryLanguages)
    assertNull(consequenceParams { responseFields {} }.responseFields)

    // Escape hatch: assign emptyList() to send [] explicitly.
    assertEquals(
      json.parseToJsonElement("""{"attributesToRetrieve":[]}"""),
      json.encodeToJsonElement(query { attributesToRetrieve = emptyList() }),
    )

    // Contrast pinned: settings helpers keep sending [] for an empty block.
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
