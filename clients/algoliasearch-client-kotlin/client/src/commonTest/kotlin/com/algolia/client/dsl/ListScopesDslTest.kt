@file:OptIn(AlgoliaExperimentalDsl::class)

package com.algolia.client.dsl

import com.algolia.client.configuration.ClientOptions
import com.algolia.client.dsl.generated.ConsequenceParamsBuilder
import com.algolia.client.dsl.rule.consequence
import com.algolia.client.dsl.rule.params
import com.algolia.client.dsl.rule.rule
import com.algolia.client.model.search.BrowseParamsObject
import com.algolia.client.model.search.ConsequenceParams
import com.algolia.client.model.search.SearchParamsObject
import com.algolia.client.model.search.SupportedLanguage
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlinx.serialization.json.encodeToJsonElement

/**
 * The list scopes: eleven `List<String>` / `List<SupportedLanguage>` search parameters exposed as
 * `field { +value }` blocks on [QueryBuilder], [BrowseBuilder], and [ConsequenceParamsBuilder].
 *
 * Contract under test: last write wins, `+Iterable` appends every element, and an empty block sets
 * `null` (field omitted). The settings helpers (`searchableAttributes { }` etc.) keep sending `[]`
 * for an empty block; that contrast is pinned here so a change on either side shows up.
 */
internal class ListScopesDslTest {

  private val json = ClientOptions().json

  @Test
  fun everyFieldOnEveryReceiver() {
    // QueryBuilder
    assertEquals(
      SearchParamsObject(restrictSearchableAttributes = listOf("title")),
      query { restrictSearchableAttributes { +"title" } },
    )
    assertEquals(
      SearchParamsObject(attributesToHighlight = listOf("name")),
      query { attributesToHighlight { +"name" } },
    )
    assertEquals(
      SearchParamsObject(attributesToRetrieve = listOf("objectID")),
      query { attributesToRetrieve { +"objectID" } },
    )
    assertEquals(
      SearchParamsObject(attributesToSnippet = listOf("description:20")),
      query { attributesToSnippet { +"description:20" } },
    )
    assertEquals(
      SearchParamsObject(ruleContexts = listOf("desktop")),
      query { ruleContexts { +"desktop" } },
    )
    assertEquals(
      SearchParamsObject(analyticsTags = listOf("web")),
      query { analyticsTags { +"web" } },
    )
    assertEquals(SearchParamsObject(facets = listOf("brand")), query { facets { +"brand" } })
    assertEquals(
      SearchParamsObject(disableTypoToleranceOnAttributes = listOf("sku")),
      query { disableTypoToleranceOnAttributes { +"sku" } },
    )
    assertEquals(
      SearchParamsObject(queryLanguages = listOf(SupportedLanguage.En)),
      query { queryLanguages { +SupportedLanguage.En } },
    )
    assertEquals(
      SearchParamsObject(naturalLanguages = listOf(SupportedLanguage.En)),
      query { naturalLanguages { +SupportedLanguage.En } },
    )
    assertEquals(
      SearchParamsObject(responseFields = listOf("hits")),
      query { responseFields { +ResponseField.Hits } },
    )

    // BrowseBuilder
    assertEquals(
      BrowseParamsObject(restrictSearchableAttributes = listOf("title")),
      browse { restrictSearchableAttributes { +"title" } },
    )
    assertEquals(
      BrowseParamsObject(attributesToHighlight = listOf("name")),
      browse { attributesToHighlight { +"name" } },
    )
    assertEquals(
      BrowseParamsObject(attributesToRetrieve = listOf("objectID")),
      browse { attributesToRetrieve { +"objectID" } },
    )
    assertEquals(
      BrowseParamsObject(attributesToSnippet = listOf("description:20")),
      browse { attributesToSnippet { +"description:20" } },
    )
    assertEquals(
      BrowseParamsObject(ruleContexts = listOf("desktop")),
      browse { ruleContexts { +"desktop" } },
    )
    assertEquals(
      BrowseParamsObject(analyticsTags = listOf("web")),
      browse { analyticsTags { +"web" } },
    )
    assertEquals(BrowseParamsObject(facets = listOf("brand")), browse { facets { +"brand" } })
    assertEquals(
      BrowseParamsObject(disableTypoToleranceOnAttributes = listOf("sku")),
      browse { disableTypoToleranceOnAttributes { +"sku" } },
    )
    assertEquals(
      BrowseParamsObject(queryLanguages = listOf(SupportedLanguage.En)),
      browse { queryLanguages { +SupportedLanguage.En } },
    )
    assertEquals(
      BrowseParamsObject(naturalLanguages = listOf(SupportedLanguage.En)),
      browse { naturalLanguages { +SupportedLanguage.En } },
    )
    assertEquals(
      BrowseParamsObject(responseFields = listOf("hits")),
      browse { responseFields { +ResponseField.Hits } },
    )

    // ConsequenceParamsBuilder, reached through rule { consequence { params { } } }
    assertEquals(
      ConsequenceParams(restrictSearchableAttributes = listOf("title")),
      consequenceParams { restrictSearchableAttributes { +"title" } },
    )
    assertEquals(
      ConsequenceParams(attributesToHighlight = listOf("name")),
      consequenceParams { attributesToHighlight { +"name" } },
    )
    assertEquals(
      ConsequenceParams(attributesToRetrieve = listOf("objectID")),
      consequenceParams { attributesToRetrieve { +"objectID" } },
    )
    assertEquals(
      ConsequenceParams(attributesToSnippet = listOf("description:20")),
      consequenceParams { attributesToSnippet { +"description:20" } },
    )
    assertEquals(
      ConsequenceParams(ruleContexts = listOf("desktop")),
      consequenceParams { ruleContexts { +"desktop" } },
    )
    assertEquals(
      ConsequenceParams(analyticsTags = listOf("web")),
      consequenceParams { analyticsTags { +"web" } },
    )
    assertEquals(
      ConsequenceParams(facets = listOf("brand")),
      consequenceParams { facets { +"brand" } },
    )
    assertEquals(
      ConsequenceParams(disableTypoToleranceOnAttributes = listOf("sku")),
      consequenceParams { disableTypoToleranceOnAttributes { +"sku" } },
    )
    assertEquals(
      ConsequenceParams(queryLanguages = listOf(SupportedLanguage.En)),
      consequenceParams { queryLanguages { +SupportedLanguage.En } },
    )
    assertEquals(
      ConsequenceParams(naturalLanguages = listOf(SupportedLanguage.En)),
      consequenceParams { naturalLanguages { +SupportedLanguage.En } },
    )
    assertEquals(
      ConsequenceParams(responseFields = listOf("hits")),
      consequenceParams { responseFields { +ResponseField.Hits } },
    )
  }

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
      query { responseFields { +listOf(ResponseField.Hits, ResponseField.NbHits) } }.responseFields,
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

  @Test
  fun responseFieldRawValues() {
    assertEquals("*", ResponseField.All.raw)
    assertEquals("aroundLatLng", ResponseField.AroundLatLng.raw)
    assertEquals("automaticRadius", ResponseField.AutomaticRadius.raw)
    assertEquals("exhaustive", ResponseField.Exhaustive.raw)
    assertEquals("facets", ResponseField.Facets.raw)
    assertEquals("facets_stats", ResponseField.FacetsStats.raw)
    assertEquals("hits", ResponseField.Hits.raw)
    assertEquals("hitsPerPage", ResponseField.HitsPerPage.raw)
    assertEquals("index", ResponseField.Index.raw)
    assertEquals("length", ResponseField.Length.raw)
    assertEquals("nbHits", ResponseField.NbHits.raw)
    assertEquals("nbPages", ResponseField.NbPages.raw)
    assertEquals("offset", ResponseField.Offset.raw)
    assertEquals("page", ResponseField.Page.raw)
    assertEquals("params", ResponseField.Params.raw)
    assertEquals("processingTimeMS", ResponseField.ProcessingTimeMS.raw)
    assertEquals("processingTimingsMS", ResponseField.ProcessingTimingsMS.raw)
    assertEquals("query", ResponseField.Query.raw)
    assertEquals("queryAfterRemoval", ResponseField.QueryAfterRemoval.raw)
    assertEquals("serverTimeMS", ResponseField.ServerTimeMS.raw)
    assertEquals("userData", ResponseField.UserData.raw)
    assertEquals("x", ResponseField.Other("x").raw)
  }

  /** Builds [ConsequenceParams] the way callers reach it: `rule { consequence { params { } } }`. */
  private fun consequenceParams(block: ConsequenceParamsBuilder.() -> Unit): ConsequenceParams =
    assertNotNull(rule("r") { consequence { params(block) } }.consequence.params)
}
